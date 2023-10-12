package com.nimbusds.jwt.proc;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.crypto.factories.DefaultJWEDecrypterFactory;
import com.nimbusds.jose.crypto.factories.DefaultJWSVerifierFactory;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.BadJWEException;
import com.nimbusds.jose.proc.BadJWSException;
import com.nimbusds.jose.proc.DefaultJOSEObjectTypeVerifier;
import com.nimbusds.jose.proc.JOSEObjectTypeVerifier;
import com.nimbusds.jose.proc.JWEDecrypterFactory;
import com.nimbusds.jose.proc.JWEKeySelector;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerifierFactory;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.SignedJWT;
import java.security.Key;
import java.text.ParseException;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class DefaultJWTProcessor<C extends SecurityContext> implements ConfigurableJWTProcessor<C> {
    private JWTClaimsSetAwareJWSKeySelector<C> claimsSetAwareJWSKeySelector;
    private JWTClaimsSetVerifier<C> claimsVerifier = new DefaultJWTClaimsVerifier((JWTClaimsSet) null, (Set<String>) null);
    private JWEDecrypterFactory jweDecrypterFactory = new DefaultJWEDecrypterFactory();
    private JWEKeySelector<C> jweKeySelector;
    private JOSEObjectTypeVerifier<C> jweTypeVerifier = DefaultJOSEObjectTypeVerifier.JWT;
    private JWSKeySelector<C> jwsKeySelector;
    private JOSEObjectTypeVerifier<C> jwsTypeVerifier = DefaultJOSEObjectTypeVerifier.JWT;
    private JWSVerifierFactory jwsVerifierFactory = new DefaultJWSVerifierFactory();

    public JOSEObjectTypeVerifier<C> getJWSTypeVerifier() {
        return this.jwsTypeVerifier;
    }

    public void setJWSTypeVerifier(JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier) {
        this.jwsTypeVerifier = jOSEObjectTypeVerifier;
    }

    public JWSKeySelector<C> getJWSKeySelector() {
        return this.jwsKeySelector;
    }

    public void setJWSKeySelector(JWSKeySelector<C> jWSKeySelector) {
        this.jwsKeySelector = jWSKeySelector;
    }

    public JWTClaimsSetAwareJWSKeySelector<C> getJWTClaimsSetAwareJWSKeySelector() {
        return this.claimsSetAwareJWSKeySelector;
    }

    public void setJWTClaimsSetAwareJWSKeySelector(JWTClaimsSetAwareJWSKeySelector<C> jWTClaimsSetAwareJWSKeySelector) {
        this.claimsSetAwareJWSKeySelector = jWTClaimsSetAwareJWSKeySelector;
    }

    public JOSEObjectTypeVerifier<C> getJWETypeVerifier() {
        return this.jweTypeVerifier;
    }

    public void setJWETypeVerifier(JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier) {
        this.jweTypeVerifier = jOSEObjectTypeVerifier;
    }

    public JWEKeySelector<C> getJWEKeySelector() {
        return this.jweKeySelector;
    }

    public void setJWEKeySelector(JWEKeySelector<C> jWEKeySelector) {
        this.jweKeySelector = jWEKeySelector;
    }

    public JWSVerifierFactory getJWSVerifierFactory() {
        return this.jwsVerifierFactory;
    }

    public void setJWSVerifierFactory(JWSVerifierFactory jWSVerifierFactory) {
        this.jwsVerifierFactory = jWSVerifierFactory;
    }

    public JWEDecrypterFactory getJWEDecrypterFactory() {
        return this.jweDecrypterFactory;
    }

    public void setJWEDecrypterFactory(JWEDecrypterFactory jWEDecrypterFactory) {
        this.jweDecrypterFactory = jWEDecrypterFactory;
    }

    public JWTClaimsSetVerifier<C> getJWTClaimsSetVerifier() {
        return this.claimsVerifier;
    }

    public void setJWTClaimsSetVerifier(JWTClaimsSetVerifier<C> jWTClaimsSetVerifier) {
        this.claimsVerifier = jWTClaimsSetVerifier;
    }

    private JWTClaimsSet extractJWTClaimsSet(JWT jwt) throws BadJWTException {
        try {
            return jwt.getJWTClaimsSet();
        } catch (ParseException e) {
            throw new BadJWTException(e.getMessage(), e);
        }
    }

    private JWTClaimsSet verifyClaims(JWTClaimsSet jWTClaimsSet, C c) throws BadJWTException {
        if (getJWTClaimsSetVerifier() != null) {
            getJWTClaimsSetVerifier().verify(jWTClaimsSet, c);
        }
        return jWTClaimsSet;
    }

    private List<? extends Key> selectKeys(JWSHeader jWSHeader, JWTClaimsSet jWTClaimsSet, C c) throws KeySourceException, BadJOSEException {
        if (getJWTClaimsSetAwareJWSKeySelector() != null) {
            return getJWTClaimsSetAwareJWSKeySelector().selectKeys(jWSHeader, jWTClaimsSet, c);
        }
        if (getJWSKeySelector() != null) {
            return getJWSKeySelector().selectJWSKeys(jWSHeader, c);
        }
        throw new BadJOSEException("Signed JWT rejected: No JWS key selector is configured");
    }

    public JWTClaimsSet process(String str, C c) throws ParseException, BadJOSEException, JOSEException {
        return process(JWTParser.parse(str), c);
    }

    public JWTClaimsSet process(JWT jwt, C c) throws BadJOSEException, JOSEException {
        if (jwt instanceof SignedJWT) {
            return process((SignedJWT) jwt, c);
        }
        if (jwt instanceof EncryptedJWT) {
            return process((EncryptedJWT) jwt, c);
        }
        if (jwt instanceof PlainJWT) {
            return process((PlainJWT) jwt, c);
        }
        throw new JOSEException("Unexpected JWT object type: " + jwt.getClass());
    }

    public JWTClaimsSet process(PlainJWT plainJWT, C c) throws BadJOSEException, JOSEException {
        JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier = this.jwsTypeVerifier;
        if (jOSEObjectTypeVerifier == null) {
            throw new BadJOSEException("Plain JWT rejected: No JWS header typ (type) verifier is configured");
        }
        jOSEObjectTypeVerifier.verify(plainJWT.getHeader().getType(), c);
        throw new BadJOSEException("Unsecured (plain) JWTs are rejected, extend class to handle");
    }

    public JWTClaimsSet process(SignedJWT signedJWT, C c) throws BadJOSEException, JOSEException {
        JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier = this.jwsTypeVerifier;
        if (jOSEObjectTypeVerifier != null) {
            jOSEObjectTypeVerifier.verify(signedJWT.getHeader().getType(), c);
            if (getJWSKeySelector() == null && getJWTClaimsSetAwareJWSKeySelector() == null) {
                throw new BadJOSEException("Signed JWT rejected: No JWS key selector is configured");
            } else if (getJWSVerifierFactory() != null) {
                JWTClaimsSet extractJWTClaimsSet = extractJWTClaimsSet(signedJWT);
                List<? extends Key> selectKeys = selectKeys(signedJWT.getHeader(), extractJWTClaimsSet, c);
                if (selectKeys == null || selectKeys.isEmpty()) {
                    throw new BadJOSEException("Signed JWT rejected: Another algorithm expected, or no matching key(s) found");
                }
                ListIterator<? extends Key> listIterator = selectKeys.listIterator();
                while (listIterator.hasNext()) {
                    JWSVerifier createJWSVerifier = getJWSVerifierFactory().createJWSVerifier(signedJWT.getHeader(), (Key) listIterator.next());
                    if (createJWSVerifier != null) {
                        if (signedJWT.verify(createJWSVerifier)) {
                            return verifyClaims(extractJWTClaimsSet, c);
                        }
                        if (!listIterator.hasNext()) {
                            throw new BadJWSException("Signed JWT rejected: Invalid signature");
                        }
                    }
                }
                throw new BadJOSEException("JWS object rejected: No matching verifier(s) found");
            } else {
                throw new JOSEException("No JWS verifier is configured");
            }
        } else {
            throw new BadJOSEException("Signed JWT rejected: No JWS header typ (type) verifier is configured");
        }
    }

    public JWTClaimsSet process(EncryptedJWT encryptedJWT, C c) throws BadJOSEException, JOSEException {
        JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier = this.jweTypeVerifier;
        if (jOSEObjectTypeVerifier != null) {
            jOSEObjectTypeVerifier.verify(encryptedJWT.getHeader().getType(), c);
            if (getJWEKeySelector() == null) {
                throw new BadJOSEException("Encrypted JWT rejected: No JWE key selector is configured");
            } else if (getJWEDecrypterFactory() != null) {
                List<? extends Key> selectJWEKeys = getJWEKeySelector().selectJWEKeys(encryptedJWT.getHeader(), c);
                if (selectJWEKeys == null || selectJWEKeys.isEmpty()) {
                    throw new BadJOSEException("Encrypted JWT rejected: Another algorithm expected, or no matching key(s) found");
                }
                ListIterator<? extends Key> listIterator = selectJWEKeys.listIterator();
                while (listIterator.hasNext()) {
                    JWEDecrypter createJWEDecrypter = getJWEDecrypterFactory().createJWEDecrypter(encryptedJWT.getHeader(), (Key) listIterator.next());
                    if (createJWEDecrypter != null) {
                        try {
                            encryptedJWT.decrypt(createJWEDecrypter);
                            if (!"JWT".equalsIgnoreCase(encryptedJWT.getHeader().getContentType())) {
                                return verifyClaims(extractJWTClaimsSet(encryptedJWT), c);
                            }
                            SignedJWT signedJWT = encryptedJWT.getPayload().toSignedJWT();
                            if (signedJWT != null) {
                                return process(signedJWT, c);
                            }
                            throw new BadJWTException("The payload is not a nested signed JWT");
                        } catch (JOSEException e) {
                            if (!listIterator.hasNext()) {
                                throw new BadJWEException("Encrypted JWT rejected: " + e.getMessage(), e);
                            }
                        }
                    }
                }
                throw new BadJOSEException("Encrypted JWT rejected: No matching decrypter(s) found");
            } else {
                throw new JOSEException("No JWE decrypter is configured");
            }
        } else {
            throw new BadJOSEException("Encrypted JWT rejected: No JWE header typ (type) verifier is configured");
        }
    }
}

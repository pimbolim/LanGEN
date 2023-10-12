package com.nimbusds.jose.crypto;

import com.nimbusds.jose.ActionRequiredForJWSCompletionException;
import com.nimbusds.jose.CompletableJWSObjectSigning;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSSignerOption;
import com.nimbusds.jose.crypto.impl.RSAKeyUtils;
import com.nimbusds.jose.crypto.impl.RSASSA;
import com.nimbusds.jose.crypto.impl.RSASSAProvider;
import com.nimbusds.jose.crypto.opts.AllowWeakRSAKey;
import com.nimbusds.jose.crypto.opts.OptionUtils;
import com.nimbusds.jose.crypto.opts.UserAuthenticationRequired;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.util.Base64URL;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Collections;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class RSASSASigner extends RSASSAProvider implements JWSSigner {
    private final Set<JWSSignerOption> opts;
    private final PrivateKey privateKey;

    public RSASSASigner(PrivateKey privateKey2) {
        this(privateKey2, false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public RSASSASigner(PrivateKey privateKey2, boolean z) {
        this(privateKey2, (Set<JWSSignerOption>) z ? Collections.singleton(AllowWeakRSAKey.getInstance()) : Collections.emptySet());
    }

    public RSASSASigner(PrivateKey privateKey2, Set<JWSSignerOption> set) {
        int keyBitLength;
        if ("RSA".equalsIgnoreCase(privateKey2.getAlgorithm())) {
            this.privateKey = privateKey2;
            set = set == null ? Collections.emptySet() : set;
            this.opts = set;
            if (!OptionUtils.optionIsPresent(set, AllowWeakRSAKey.class) && (keyBitLength = RSAKeyUtils.keyBitLength(privateKey2)) > 0 && keyBitLength < 2048) {
                throw new IllegalArgumentException("The RSA key size must be at least 2048 bits");
            }
            return;
        }
        throw new IllegalArgumentException("The private key algorithm must be RSA");
    }

    public RSASSASigner(RSAKey rSAKey) throws JOSEException {
        this(RSAKeyUtils.toRSAPrivateKey(rSAKey));
    }

    @Deprecated
    public RSASSASigner(RSAKey rSAKey, boolean z) throws JOSEException {
        this(RSAKeyUtils.toRSAPrivateKey(rSAKey), z);
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public Base64URL sign(JWSHeader jWSHeader, final byte[] bArr) throws JOSEException {
        final Signature initiatedSignature = getInitiatedSignature(jWSHeader);
        if (!OptionUtils.optionIsPresent(this.opts, UserAuthenticationRequired.class)) {
            return sign(bArr, initiatedSignature);
        }
        throw new ActionRequiredForJWSCompletionException("Authenticate user to complete signing", UserAuthenticationRequired.getInstance(), new CompletableJWSObjectSigning() {
            public Base64URL complete() throws JOSEException {
                return RSASSASigner.this.sign(bArr, initiatedSignature);
            }
        });
    }

    private Signature getInitiatedSignature(JWSHeader jWSHeader) throws JOSEException {
        Signature signerAndVerifier = RSASSA.getSignerAndVerifier(jWSHeader.getAlgorithm(), getJCAContext().getProvider());
        try {
            signerAndVerifier.initSign(this.privateKey);
            return signerAndVerifier;
        } catch (InvalidKeyException e) {
            throw new JOSEException("Invalid private RSA key: " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: private */
    public Base64URL sign(byte[] bArr, Signature signature) throws JOSEException {
        try {
            signature.update(bArr);
            return Base64URL.encode(signature.sign());
        } catch (SignatureException e) {
            throw new JOSEException("RSA signature exception: " + e.getMessage(), e);
        }
    }
}

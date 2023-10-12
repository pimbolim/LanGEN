package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.ECDH;
import com.nimbusds.jose.jca.JWEJCAContext;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.util.Base64URL;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.SecretKey;

public abstract class ECDH1PUCryptoProvider extends BaseJWEProvider {
    public static final Set<JWEAlgorithm> SUPPORTED_ALGORITHMS;
    public static final Set<EncryptionMethod> SUPPORTED_ENCRYPTION_METHODS = ContentCryptoProvider.SUPPORTED_ENCRYPTION_METHODS;
    private final ConcatKDF concatKDF;
    private final Curve curve;

    public abstract Set<Curve> supportedEllipticCurves();

    public /* bridge */ /* synthetic */ JWEJCAContext getJCAContext() {
        return super.getJCAContext();
    }

    public /* bridge */ /* synthetic */ Set supportedEncryptionMethods() {
        return super.supportedEncryptionMethods();
    }

    public /* bridge */ /* synthetic */ Set supportedJWEAlgorithms() {
        return super.supportedJWEAlgorithms();
    }

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(JWEAlgorithm.ECDH_1PU);
        linkedHashSet.add(JWEAlgorithm.ECDH_1PU_A128KW);
        linkedHashSet.add(JWEAlgorithm.ECDH_1PU_A192KW);
        linkedHashSet.add(JWEAlgorithm.ECDH_1PU_A256KW);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
    }

    protected ECDH1PUCryptoProvider(Curve curve2) throws JOSEException {
        super(SUPPORTED_ALGORITHMS, ContentCryptoProvider.SUPPORTED_ENCRYPTION_METHODS);
        Curve curve3;
        if (curve2 != null) {
            curve3 = curve2;
        } else {
            curve3 = new Curve("unknown");
        }
        if (supportedEllipticCurves().contains(curve2)) {
            this.curve = curve2;
            this.concatKDF = new ConcatKDF("SHA-256");
            return;
        }
        throw new JOSEException(AlgorithmSupportMessage.unsupportedEllipticCurve(curve3, supportedEllipticCurves()));
    }

    /* access modifiers changed from: protected */
    public ConcatKDF getConcatKDF() {
        return this.concatKDF;
    }

    public Curve getCurve() {
        return this.curve;
    }

    /* access modifiers changed from: protected */
    public JWECryptoParts encryptWithZ(JWEHeader jWEHeader, SecretKey secretKey, byte[] bArr, SecretKey secretKey2) throws JOSEException {
        ECDH.AlgorithmMode resolveAlgorithmMode = ECDH1PU.resolveAlgorithmMode(jWEHeader.getAlgorithm());
        EncryptionMethod encryptionMethod = jWEHeader.getEncryptionMethod();
        if (resolveAlgorithmMode.equals(ECDH.AlgorithmMode.DIRECT)) {
            getConcatKDF().getJCAContext().setProvider(getJCAContext().getMACProvider());
            return ContentCryptoProvider.encrypt(jWEHeader, bArr, ECDH1PU.deriveSharedKey(jWEHeader, secretKey, getConcatKDF()), (Base64URL) null, getJCAContext());
        } else if (!resolveAlgorithmMode.equals(ECDH.AlgorithmMode.KW)) {
            throw new JOSEException("Unexpected JWE ECDH algorithm mode: " + resolveAlgorithmMode);
        } else if (EncryptionMethod.Family.AES_CBC_HMAC_SHA.contains(encryptionMethod)) {
            if (secretKey2 == null) {
                secretKey2 = ContentCryptoProvider.generateCEK(encryptionMethod, getJCAContext().getSecureRandom());
            }
            JWECryptoParts encrypt = ContentCryptoProvider.encrypt(jWEHeader, bArr, secretKey2, (Base64URL) null, getJCAContext());
            return new JWECryptoParts(jWEHeader, Base64URL.encode(AESKW.wrapCEK(secretKey2, ECDH1PU.deriveSharedKey(jWEHeader, secretKey, encrypt.getAuthenticationTag(), getConcatKDF()), getJCAContext().getKeyEncryptionProvider())), encrypt.getInitializationVector(), encrypt.getCipherText(), encrypt.getAuthenticationTag());
        } else {
            throw new JOSEException(AlgorithmSupportMessage.unsupportedEncryptionMethod(jWEHeader.getEncryptionMethod(), EncryptionMethod.Family.AES_CBC_HMAC_SHA));
        }
    }

    /* access modifiers changed from: protected */
    public byte[] decryptWithZ(JWEHeader jWEHeader, SecretKey secretKey, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) throws JOSEException {
        SecretKey unwrapCEK;
        ECDH.AlgorithmMode resolveAlgorithmMode = ECDH1PU.resolveAlgorithmMode(jWEHeader.getAlgorithm());
        getConcatKDF().getJCAContext().setProvider(getJCAContext().getMACProvider());
        if (resolveAlgorithmMode.equals(ECDH.AlgorithmMode.DIRECT)) {
            unwrapCEK = ECDH1PU.deriveSharedKey(jWEHeader, secretKey, getConcatKDF());
        } else if (!resolveAlgorithmMode.equals(ECDH.AlgorithmMode.KW)) {
            throw new JOSEException("Unexpected JWE ECDH algorithm mode: " + resolveAlgorithmMode);
        } else if (base64URL != null) {
            unwrapCEK = AESKW.unwrapCEK(ECDH1PU.deriveSharedKey(jWEHeader, secretKey, base64URL4, getConcatKDF()), base64URL.decode(), getJCAContext().getKeyEncryptionProvider());
        } else {
            throw new JOSEException("Missing JWE encrypted key");
        }
        return ContentCryptoProvider.decrypt(jWEHeader, (Base64URL) null, base64URL2, base64URL3, base64URL4, unwrapCEK, getJCAContext());
    }
}

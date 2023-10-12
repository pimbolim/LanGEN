package com.nimbusds.jose.crypto;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.ContentCryptoProvider;
import com.nimbusds.jose.crypto.impl.RSA1_5;
import com.nimbusds.jose.crypto.impl.RSACryptoProvider;
import com.nimbusds.jose.crypto.impl.RSA_OAEP;
import com.nimbusds.jose.crypto.impl.RSA_OAEP_SHA2;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.util.Base64URL;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class RSAEncrypter extends RSACryptoProvider implements JWEEncrypter {
    private final SecretKey contentEncryptionKey;
    private final RSAPublicKey publicKey;

    public RSAEncrypter(RSAPublicKey rSAPublicKey) {
        this(rSAPublicKey, (SecretKey) null);
    }

    public RSAEncrypter(RSAKey rSAKey) throws JOSEException {
        this(rSAKey.toRSAPublicKey());
    }

    public RSAEncrypter(RSAPublicKey rSAPublicKey, SecretKey secretKey) {
        if (rSAPublicKey != null) {
            this.publicKey = rSAPublicKey;
            Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"AES", "ChaCha20"})));
            if (secretKey == null) {
                this.contentEncryptionKey = null;
            } else if (secretKey.getAlgorithm() == null || !unmodifiableSet.contains(secretKey.getAlgorithm())) {
                throw new IllegalArgumentException("The algorithm of the content encryption key (CEK) must be AES or ChaCha20");
            } else {
                this.contentEncryptionKey = secretKey;
            }
        } else {
            throw new IllegalArgumentException("The public RSA key must not be null");
        }
    }

    public RSAPublicKey getPublicKey() {
        return this.publicKey;
    }

    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        Base64URL base64URL;
        JWEAlgorithm algorithm = jWEHeader.getAlgorithm();
        EncryptionMethod encryptionMethod = jWEHeader.getEncryptionMethod();
        SecretKey secretKey = this.contentEncryptionKey;
        if (secretKey == null) {
            secretKey = ContentCryptoProvider.generateCEK(encryptionMethod, getJCAContext().getSecureRandom());
        }
        if (algorithm.equals(JWEAlgorithm.RSA1_5)) {
            base64URL = Base64URL.encode(RSA1_5.encryptCEK(this.publicKey, secretKey, getJCAContext().getKeyEncryptionProvider()));
        } else if (algorithm.equals(JWEAlgorithm.RSA_OAEP)) {
            base64URL = Base64URL.encode(RSA_OAEP.encryptCEK(this.publicKey, secretKey, getJCAContext().getKeyEncryptionProvider()));
        } else if (algorithm.equals(JWEAlgorithm.RSA_OAEP_256)) {
            base64URL = Base64URL.encode(RSA_OAEP_SHA2.encryptCEK(this.publicKey, secretKey, 256, getJCAContext().getKeyEncryptionProvider()));
        } else if (algorithm.equals(JWEAlgorithm.RSA_OAEP_384)) {
            base64URL = Base64URL.encode(RSA_OAEP_SHA2.encryptCEK(this.publicKey, secretKey, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, getJCAContext().getKeyEncryptionProvider()));
        } else if (algorithm.equals(JWEAlgorithm.RSA_OAEP_512)) {
            base64URL = Base64URL.encode(RSA_OAEP_SHA2.encryptCEK(this.publicKey, secretKey, 512, getJCAContext().getKeyEncryptionProvider()));
        } else {
            throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(algorithm, SUPPORTED_ALGORITHMS));
        }
        return ContentCryptoProvider.encrypt(jWEHeader, bArr, secretKey, base64URL, getJCAContext());
    }
}

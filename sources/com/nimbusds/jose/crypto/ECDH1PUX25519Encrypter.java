package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.ECDH1PU;
import com.nimbusds.jose.crypto.impl.ECDH1PUCryptoProvider;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.jwk.gen.OctetKeyPairGenerator;
import java.util.Collections;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ECDH1PUX25519Encrypter extends ECDH1PUCryptoProvider implements JWEEncrypter {
    private final SecretKey contentEncryptionKey;
    private final OctetKeyPair privateKey;
    private final OctetKeyPair publicKey;

    public ECDH1PUX25519Encrypter(OctetKeyPair octetKeyPair, OctetKeyPair octetKeyPair2) throws JOSEException {
        this(octetKeyPair, octetKeyPair2, (SecretKey) null);
    }

    public ECDH1PUX25519Encrypter(OctetKeyPair octetKeyPair, OctetKeyPair octetKeyPair2, SecretKey secretKey) throws JOSEException {
        super(octetKeyPair2.getCurve());
        this.publicKey = octetKeyPair2;
        this.privateKey = octetKeyPair;
        if (secretKey == null || (secretKey.getAlgorithm() != null && secretKey.getAlgorithm().equals("AES"))) {
            this.contentEncryptionKey = secretKey;
            return;
        }
        throw new IllegalArgumentException("The algorithm of the content encryption key (CEK) must be AES");
    }

    public Set<Curve> supportedEllipticCurves() {
        return Collections.singleton(Curve.X25519);
    }

    public OctetKeyPair getPublicKey() {
        return this.publicKey;
    }

    public OctetKeyPair getPrivateKey() {
        return this.privateKey;
    }

    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        OctetKeyPair generate = new OctetKeyPairGenerator(getCurve()).generate();
        return encryptWithZ(new JWEHeader.Builder(jWEHeader).ephemeralPublicKey(generate.toPublicJWK()).build(), ECDH1PU.deriveSenderZ(this.privateKey, this.publicKey, generate), bArr, this.contentEncryptionKey);
    }
}

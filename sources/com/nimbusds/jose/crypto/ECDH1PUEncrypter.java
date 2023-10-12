package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.ECDH1PU;
import com.nimbusds.jose.crypto.impl.ECDH1PUCryptoProvider;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ECDH1PUEncrypter extends ECDH1PUCryptoProvider implements JWEEncrypter {
    public static final Set<Curve> SUPPORTED_ELLIPTIC_CURVES;
    private final SecretKey contentEncryptionKey;
    private final ECPrivateKey privateKey;
    private final ECPublicKey publicKey;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(Curve.P_256);
        linkedHashSet.add(Curve.P_384);
        linkedHashSet.add(Curve.P_521);
        SUPPORTED_ELLIPTIC_CURVES = Collections.unmodifiableSet(linkedHashSet);
    }

    public ECDH1PUEncrypter(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws JOSEException {
        this(eCPrivateKey, eCPublicKey, (SecretKey) null);
    }

    public ECDH1PUEncrypter(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey, SecretKey secretKey) throws JOSEException {
        super(Curve.forECParameterSpec(eCPublicKey.getParams()));
        this.privateKey = eCPrivateKey;
        this.publicKey = eCPublicKey;
        if (secretKey == null || (secretKey.getAlgorithm() != null && secretKey.getAlgorithm().equals("AES"))) {
            this.contentEncryptionKey = secretKey;
            return;
        }
        throw new IllegalArgumentException("The algorithm of the content encryption key (CEK) must be AES");
    }

    public ECPublicKey getPublicKey() {
        return this.publicKey;
    }

    public ECPrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public Set<Curve> supportedEllipticCurves() {
        return SUPPORTED_ELLIPTIC_CURVES;
    }

    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        KeyPair generateEphemeralKeyPair = generateEphemeralKeyPair(this.publicKey.getParams());
        return encryptWithZ(new JWEHeader.Builder(jWEHeader).ephemeralPublicKey(new ECKey.Builder(getCurve(), (ECPublicKey) generateEphemeralKeyPair.getPublic()).build()).build(), ECDH1PU.deriveSenderZ(this.privateKey, this.publicKey, (ECPrivateKey) generateEphemeralKeyPair.getPrivate(), getJCAContext().getKeyEncryptionProvider()), bArr, this.contentEncryptionKey);
    }

    private KeyPair generateEphemeralKeyPair(ECParameterSpec eCParameterSpec) throws JOSEException {
        KeyPairGenerator keyPairGenerator;
        Provider keyEncryptionProvider = getJCAContext().getKeyEncryptionProvider();
        if (keyEncryptionProvider != null) {
            try {
                keyPairGenerator = KeyPairGenerator.getInstance("EC", keyEncryptionProvider);
            } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException e) {
                throw new JOSEException("Couldn't generate ephemeral EC key pair: " + e.getMessage(), e);
            }
        } else {
            keyPairGenerator = KeyPairGenerator.getInstance("EC");
        }
        keyPairGenerator.initialize(eCParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }
}

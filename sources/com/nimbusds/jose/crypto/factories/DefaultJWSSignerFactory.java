package com.nimbusds.jose.crypto.factories;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.Ed25519Signer;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jca.JCAContext;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKException;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.produce.JWSSignerFactory;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class DefaultJWSSignerFactory implements JWSSignerFactory {
    public static final Set<JWSAlgorithm> SUPPORTED_ALGORITHMS;
    private final JCAContext jcaContext = new JCAContext();

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(MACSigner.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(RSASSASigner.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(ECDSASigner.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(Ed25519Signer.SUPPORTED_ALGORITHMS);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
    }

    public Set<JWSAlgorithm> supportedJWSAlgorithms() {
        return SUPPORTED_ALGORITHMS;
    }

    public JCAContext getJCAContext() {
        return this.jcaContext;
    }

    public JWSSigner createJWSSigner(JWK jwk) throws JOSEException {
        JWSSigner jWSSigner;
        if (!jwk.isPrivate()) {
            throw JWKException.expectedPrivate();
        } else if (jwk.getKeyUse() == null || KeyUse.SIGNATURE.equals(jwk.getKeyUse())) {
            if (jwk instanceof OctetSequenceKey) {
                jWSSigner = new MACSigner((OctetSequenceKey) jwk);
            } else if (jwk instanceof RSAKey) {
                jWSSigner = new RSASSASigner((RSAKey) jwk);
            } else if (jwk instanceof ECKey) {
                jWSSigner = new ECDSASigner((ECKey) jwk);
            } else if (jwk instanceof OctetKeyPair) {
                jWSSigner = new Ed25519Signer((OctetKeyPair) jwk);
            } else {
                throw new JOSEException("Unsupported JWK type: " + jwk);
            }
            jWSSigner.getJCAContext().setSecureRandom(this.jcaContext.getSecureRandom());
            jWSSigner.getJCAContext().setProvider(this.jcaContext.getProvider());
            return jWSSigner;
        } else {
            throw new JWKException("The JWK use must be sig (signature) or unspecified");
        }
    }

    public JWSSigner createJWSSigner(JWK jwk, JWSAlgorithm jWSAlgorithm) throws JOSEException {
        JWSSigner jWSSigner;
        if (!jwk.isPrivate()) {
            throw JWKException.expectedPrivate();
        } else if (jwk.getKeyUse() == null || KeyUse.SIGNATURE.equals(jwk.getKeyUse())) {
            if (MACSigner.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
                if (jwk instanceof OctetSequenceKey) {
                    jWSSigner = new MACSigner((OctetSequenceKey) jwk);
                } else {
                    throw JWKException.expectedClass(OctetSequenceKey.class);
                }
            } else if (RSASSASigner.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
                if (jwk instanceof RSAKey) {
                    jWSSigner = new RSASSASigner((RSAKey) jwk);
                } else {
                    throw JWKException.expectedClass(RSAKey.class);
                }
            } else if (ECDSASigner.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
                if (jwk instanceof ECKey) {
                    jWSSigner = new ECDSASigner((ECKey) jwk);
                } else {
                    throw JWKException.expectedClass(ECKey.class);
                }
            } else if (!Ed25519Signer.SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
                throw new JOSEException("Unsupported JWS algorithm: " + jWSAlgorithm);
            } else if (jwk instanceof OctetKeyPair) {
                jWSSigner = new Ed25519Signer((OctetKeyPair) jwk);
            } else {
                throw JWKException.expectedClass(OctetKeyPair.class);
            }
            jWSSigner.getJCAContext().setSecureRandom(this.jcaContext.getSecureRandom());
            jWSSigner.getJCAContext().setProvider(this.jcaContext.getProvider());
            return jWSSigner;
        } else {
            throw new JWKException("The JWK use must be sig (signature) or unspecified");
        }
    }
}

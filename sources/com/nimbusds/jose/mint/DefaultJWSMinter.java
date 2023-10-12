package com.nimbusds.jose.mint;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.factories.DefaultJWSSignerFactory;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKMatcher;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.JWKSecurityContext;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.produce.JWSSignerFactory;
import java.util.List;

public class DefaultJWSMinter<C extends SecurityContext> implements ConfigurableJWSMinter<C> {
    private JWKSource<C> jwkSource;
    private JWSSignerFactory jwsSignerFactory = new DefaultJWSSignerFactory();

    public JWSObject mint(JWSHeader jWSHeader, Payload payload, C c) throws JOSEException {
        List<JWK> jwks = jwks(jWSHeader, c);
        if (!jwks.isEmpty()) {
            JWK jwk = jwks.get(0);
            JWSObject jWSObject = new JWSObject(new JWSHeader.Builder(jWSHeader).keyID(jwk.getKeyID()).x509CertURL(jwk.getX509CertURL()).x509CertChain(jwk.getX509CertChain()).x509CertSHA256Thumbprint(jwk.getX509CertSHA256Thumbprint()).x509CertThumbprint(jwk.getX509CertThumbprint()).build(), payload);
            JWSSignerFactory jWSSignerFactory = this.jwsSignerFactory;
            if (jWSSignerFactory != null) {
                jWSObject.sign(jWSSignerFactory.createJWSSigner(jwk));
                return jWSObject;
            }
            throw new JOSEException("No JWS signer factory configured");
        }
        throw new JOSEException("No JWKs found for signing");
    }

    private List<JWK> jwks(JWSHeader jWSHeader, C c) throws JOSEException {
        JWKSelector jWKSelector = new JWKSelector(JWKMatcher.forJWSHeader(jWSHeader));
        if (c instanceof JWKSecurityContext) {
            return jWKSelector.select(new JWKSet(((JWKSecurityContext) c).getKeys()));
        }
        JWKSource<C> jWKSource = this.jwkSource;
        if (jWKSource != null) {
            return jWKSource.get(jWKSelector, c);
        }
        throw new JOSEException("No JWK source configured");
    }

    public JWKSource<C> getJWKSource() {
        return this.jwkSource;
    }

    public void setJWKSource(JWKSource<C> jWKSource) {
        this.jwkSource = jWKSource;
    }

    public JWSSignerFactory getJWSSignerFactory() {
        return this.jwsSignerFactory;
    }

    public void setJWSSignerFactory(JWSSignerFactory jWSSignerFactory) {
        this.jwsSignerFactory = jWSSignerFactory;
    }
}

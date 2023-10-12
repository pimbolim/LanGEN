package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import java.util.Date;
import net.jcip.annotations.Immutable;

@Immutable
public final class JWKSetWithTimestamp {
    private final JWKSet jwkSet;
    private final Date timestamp;

    public JWKSetWithTimestamp(JWKSet jWKSet) {
        this(jWKSet, new Date());
    }

    public JWKSetWithTimestamp(JWKSet jWKSet, Date date) {
        if (jWKSet != null) {
            this.jwkSet = jWKSet;
            if (date != null) {
                this.timestamp = date;
                return;
            }
            throw new IllegalArgumentException("The timestamp must not null");
        }
        throw new IllegalArgumentException("The JWK set must not be null");
    }

    public JWKSet getJWKSet() {
        return this.jwkSet;
    }

    public Date getDate() {
        return this.timestamp;
    }
}

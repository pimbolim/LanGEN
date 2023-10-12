package com.nimbusds.jose.jwk;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.Base64URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Objects;
import net.jcip.annotations.Immutable;

@Immutable
public class ThumbprintURI {
    public static final String PREFIX = "urn:ietf:params:oauth:jwk-thumbprint:";
    private final String hashAlg;
    private final Base64URL thumbprint;

    public ThumbprintURI(String str, Base64URL base64URL) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("The hash algorithm must not be null or empty");
        }
        this.hashAlg = str;
        if (base64URL == null || base64URL.toString().isEmpty()) {
            throw new IllegalArgumentException("The thumbprint must not be null or empty");
        }
        this.thumbprint = base64URL;
    }

    public String getAlgorithmString() {
        return this.hashAlg;
    }

    public Base64URL getThumbprint() {
        return this.thumbprint;
    }

    public URI toURI() {
        return URI.create(toString());
    }

    public String toString() {
        return PREFIX + this.hashAlg + ":" + this.thumbprint;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThumbprintURI)) {
            return false;
        }
        ThumbprintURI thumbprintURI = (ThumbprintURI) obj;
        if (!this.hashAlg.equals(thumbprintURI.hashAlg) || !getThumbprint().equals(thumbprintURI.getThumbprint())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.hashAlg, getThumbprint()});
    }

    public static ThumbprintURI compute(JWK jwk) throws JOSEException {
        return new ThumbprintURI("sha-256", jwk.computeThumbprint());
    }

    public static ThumbprintURI parse(URI uri) throws ParseException {
        String uri2 = uri.toString();
        if (uri2.startsWith(PREFIX)) {
            String substring = uri2.substring(37);
            if (!substring.isEmpty()) {
                String[] split = substring.split(":");
                if (split.length != 2) {
                    throw new ParseException("Illegal JWK thumbprint: Unexpected number of components", 0);
                } else if (!split[0].isEmpty()) {
                    return new ThumbprintURI(split[0], new Base64URL(split[1]));
                } else {
                    throw new ParseException("Illegal JWK thumbprint: The hash algorithm must not be empty", 0);
                }
            } else {
                throw new ParseException("Illegal JWK thumbprint: Missing value", 0);
            }
        } else {
            throw new ParseException("Illegal JWK thumbprint prefix", 0);
        }
    }

    public static ThumbprintURI parse(String str) throws ParseException {
        try {
            return parse(new URI(str));
        } catch (URISyntaxException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }
}

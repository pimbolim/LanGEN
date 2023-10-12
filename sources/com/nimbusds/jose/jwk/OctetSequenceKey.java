package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.IntegerOverflowException;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.net.URI;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.Immutable;

@Immutable
public final class OctetSequenceKey extends JWK implements SecretJWK {
    private static final long serialVersionUID = 1;
    private final Base64URL k;

    public boolean isPrivate() {
        return true;
    }

    public OctetSequenceKey toPublicJWK() {
        return null;
    }

    public static class Builder {
        private Algorithm alg;
        private final Base64URL k;
        private String kid;
        private KeyStore ks;
        private Set<KeyOperation> ops;
        private KeyUse use;
        private List<Base64> x5c;
        @Deprecated
        private Base64URL x5t;
        private Base64URL x5t256;
        private URI x5u;

        public Builder(Base64URL base64URL) {
            if (base64URL != null) {
                this.k = base64URL;
                return;
            }
            throw new IllegalArgumentException("The key value must not be null");
        }

        public Builder(byte[] bArr) {
            this(Base64URL.encode(bArr));
            if (bArr.length == 0) {
                throw new IllegalArgumentException("The key must have a positive length");
            }
        }

        public Builder(SecretKey secretKey) {
            this(secretKey.getEncoded());
        }

        public Builder keyUse(KeyUse keyUse) {
            this.use = keyUse;
            return this;
        }

        public Builder keyOperations(Set<KeyOperation> set) {
            this.ops = set;
            return this;
        }

        public Builder algorithm(Algorithm algorithm) {
            this.alg = algorithm;
            return this;
        }

        public Builder keyID(String str) {
            this.kid = str;
            return this;
        }

        public Builder keyIDFromThumbprint() throws JOSEException {
            return keyIDFromThumbprint("SHA-256");
        }

        public Builder keyIDFromThumbprint(String str) throws JOSEException {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(JWKParameterNames.OCT_KEY_VALUE, this.k.toString());
            linkedHashMap.put(JWKParameterNames.KEY_TYPE, KeyType.OCT.getValue());
            this.kid = ThumbprintUtils.compute(str, (LinkedHashMap<String, ?>) linkedHashMap).toString();
            return this;
        }

        public Builder x509CertURL(URI uri) {
            this.x5u = uri;
            return this;
        }

        @Deprecated
        public Builder x509CertThumbprint(Base64URL base64URL) {
            this.x5t = base64URL;
            return this;
        }

        public Builder x509CertSHA256Thumbprint(Base64URL base64URL) {
            this.x5t256 = base64URL;
            return this;
        }

        public Builder x509CertChain(List<Base64> list) {
            this.x5c = list;
            return this;
        }

        public Builder keyStore(KeyStore keyStore) {
            this.ks = keyStore;
            return this;
        }

        public OctetSequenceKey build() {
            try {
                return new OctetSequenceKey(this.k, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.ks);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OctetSequenceKey(Base64URL base64URL, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL2, Base64URL base64URL3, List<Base64> list, KeyStore keyStore) {
        super(KeyType.OCT, keyUse, set, algorithm, str, uri, base64URL2, base64URL3, list, keyStore);
        Base64URL base64URL4 = base64URL;
        if (base64URL4 != null) {
            this.k = base64URL4;
        } else {
            throw new IllegalArgumentException("The key value must not be null");
        }
    }

    public Base64URL getKeyValue() {
        return this.k;
    }

    public byte[] toByteArray() {
        return getKeyValue().decode();
    }

    public SecretKey toSecretKey() {
        return toSecretKey("NONE");
    }

    public SecretKey toSecretKey(String str) {
        return new SecretKeySpec(toByteArray(), str);
    }

    public LinkedHashMap<String, ?> getRequiredParams() {
        LinkedHashMap<String, ?> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(JWKParameterNames.OCT_KEY_VALUE, this.k.toString());
        linkedHashMap.put(JWKParameterNames.KEY_TYPE, getKeyType().toString());
        return linkedHashMap;
    }

    public int size() {
        try {
            return ByteUtils.safeBitLength(this.k.decode());
        } catch (IntegerOverflowException e) {
            throw new ArithmeticException(e.getMessage());
        }
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> jSONObject = super.toJSONObject();
        jSONObject.put(JWKParameterNames.OCT_KEY_VALUE, this.k.toString());
        return jSONObject;
    }

    public static OctetSequenceKey parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str));
    }

    public static OctetSequenceKey parse(Map<String, Object> map) throws ParseException {
        if (KeyType.OCT.equals(JWKMetadata.parseKeyType(map))) {
            try {
                return new OctetSequenceKey(JSONObjectUtils.getBase64URL(map, JWKParameterNames.OCT_KEY_VALUE), JWKMetadata.parseKeyUse(map), JWKMetadata.parseKeyOperations(map), JWKMetadata.parseAlgorithm(map), JWKMetadata.parseKeyID(map), JWKMetadata.parseX509CertURL(map), JWKMetadata.parseX509CertThumbprint(map), JWKMetadata.parseX509CertSHA256Thumbprint(map), JWKMetadata.parseX509CertChain(map), (KeyStore) null);
            } catch (IllegalArgumentException e) {
                throw new ParseException(e.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type kty must be " + KeyType.OCT.getValue(), 0);
        }
    }

    public static OctetSequenceKey load(KeyStore keyStore, String str, char[] cArr) throws KeyStoreException, JOSEException {
        try {
            Key key = keyStore.getKey(str, cArr);
            if (!(key instanceof SecretKey)) {
                return null;
            }
            return new Builder((SecretKey) key).keyID(str).keyStore(keyStore).build();
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new JOSEException("Couldn't retrieve secret key (bad pin?): " + e.getMessage(), e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof OctetSequenceKey) && super.equals(obj)) {
            return Objects.equals(this.k, ((OctetSequenceKey) obj).k);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.k});
    }
}

package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.net.URI;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.jcip.annotations.Immutable;

@Immutable
public class OctetKeyPair extends JWK implements AsymmetricJWK, CurveBasedJWK {
    public static final Set<Curve> SUPPORTED_CURVES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Curve[]{Curve.Ed25519, Curve.Ed448, Curve.X25519, Curve.X448})));
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final Curve crv;
    /* access modifiers changed from: private */
    public final Base64URL d;
    private final byte[] decodedD;
    private final byte[] decodedX;
    /* access modifiers changed from: private */
    public final Base64URL x;

    public boolean matches(X509Certificate x509Certificate) {
        return false;
    }

    public static class Builder {
        private Algorithm alg;
        private final Curve crv;
        private Base64URL d;
        private String kid;
        private KeyStore ks;
        private Set<KeyOperation> ops;
        private KeyUse use;
        private final Base64URL x;
        private List<Base64> x5c;
        @Deprecated
        private Base64URL x5t;
        private Base64URL x5t256;
        private URI x5u;

        public Builder(Curve curve, Base64URL base64URL) {
            if (curve != null) {
                this.crv = curve;
                if (base64URL != null) {
                    this.x = base64URL;
                    return;
                }
                throw new IllegalArgumentException("The 'x' coordinate must not be null");
            }
            throw new IllegalArgumentException("The curve must not be null");
        }

        public Builder(OctetKeyPair octetKeyPair) {
            this.crv = octetKeyPair.crv;
            this.x = octetKeyPair.x;
            this.d = octetKeyPair.d;
            this.use = octetKeyPair.getKeyUse();
            this.ops = octetKeyPair.getKeyOperations();
            this.alg = octetKeyPair.getAlgorithm();
            this.kid = octetKeyPair.getKeyID();
            this.x5u = octetKeyPair.getX509CertURL();
            this.x5t = octetKeyPair.getX509CertThumbprint();
            this.x5t256 = octetKeyPair.getX509CertSHA256Thumbprint();
            this.x5c = octetKeyPair.getX509CertChain();
            this.ks = octetKeyPair.getKeyStore();
        }

        public Builder d(Base64URL base64URL) {
            this.d = base64URL;
            return this;
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
            linkedHashMap.put("crv", this.crv.toString());
            linkedHashMap.put(JWKParameterNames.KEY_TYPE, KeyType.OKP.getValue());
            linkedHashMap.put("x", this.x.toString());
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

        public OctetKeyPair build() {
            try {
                if (this.d == null) {
                    return new OctetKeyPair(this.crv, this.x, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.ks);
                }
                return new OctetKeyPair(this.crv, this.x, this.d, this.use, this.ops, this.alg, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.ks);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OctetKeyPair(Curve curve, Base64URL base64URL, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL2, Base64URL base64URL3, List<Base64> list, KeyStore keyStore) {
        super(KeyType.OKP, keyUse, set, algorithm, str, uri, base64URL2, base64URL3, list, keyStore);
        Curve curve2 = curve;
        Base64URL base64URL4 = base64URL;
        if (curve2 == null) {
            throw new IllegalArgumentException("The curve must not be null");
        } else if (SUPPORTED_CURVES.contains(curve)) {
            this.crv = curve2;
            if (base64URL4 != null) {
                this.x = base64URL4;
                this.decodedX = base64URL.decode();
                this.d = null;
                this.decodedD = null;
                return;
            }
            throw new IllegalArgumentException("The 'x' parameter must not be null");
        } else {
            throw new IllegalArgumentException("Unknown / unsupported curve: " + curve);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OctetKeyPair(Curve curve, Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        super(KeyType.OKP, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, keyStore);
        Curve curve2 = curve;
        Base64URL base64URL5 = base64URL;
        Base64URL base64URL6 = base64URL2;
        if (curve2 == null) {
            throw new IllegalArgumentException("The curve must not be null");
        } else if (SUPPORTED_CURVES.contains(curve2)) {
            this.crv = curve2;
            if (base64URL5 != null) {
                this.x = base64URL5;
                this.decodedX = base64URL.decode();
                if (base64URL6 != null) {
                    this.d = base64URL6;
                    this.decodedD = base64URL2.decode();
                    return;
                }
                throw new IllegalArgumentException("The 'd' parameter must not be null");
            }
            throw new IllegalArgumentException("The 'x' parameter must not be null");
        } else {
            throw new IllegalArgumentException("Unknown / unsupported curve: " + curve2);
        }
    }

    public Curve getCurve() {
        return this.crv;
    }

    public Base64URL getX() {
        return this.x;
    }

    public byte[] getDecodedX() {
        return (byte[]) this.decodedX.clone();
    }

    public Base64URL getD() {
        return this.d;
    }

    public byte[] getDecodedD() {
        byte[] bArr = this.decodedD;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public PublicKey toPublicKey() throws JOSEException {
        throw new JOSEException("Export to java.security.PublicKey not supported");
    }

    public PrivateKey toPrivateKey() throws JOSEException {
        throw new JOSEException("Export to java.security.PrivateKey not supported");
    }

    public KeyPair toKeyPair() throws JOSEException {
        throw new JOSEException("Export to java.security.KeyPair not supported");
    }

    public LinkedHashMap<String, ?> getRequiredParams() {
        LinkedHashMap<String, ?> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("crv", this.crv.toString());
        linkedHashMap.put(JWKParameterNames.KEY_TYPE, getKeyType().getValue());
        linkedHashMap.put("x", this.x.toString());
        return linkedHashMap;
    }

    public boolean isPrivate() {
        return this.d != null;
    }

    public OctetKeyPair toPublicJWK() {
        return new OctetKeyPair(getCurve(), getX(), getKeyUse(), getKeyOperations(), getAlgorithm(), getKeyID(), getX509CertURL(), getX509CertThumbprint(), getX509CertSHA256Thumbprint(), getX509CertChain(), getKeyStore());
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> jSONObject = super.toJSONObject();
        jSONObject.put("crv", this.crv.toString());
        jSONObject.put("x", this.x.toString());
        Base64URL base64URL = this.d;
        if (base64URL != null) {
            jSONObject.put("d", base64URL.toString());
        }
        return jSONObject;
    }

    public int size() {
        return ByteUtils.bitLength(this.x.decode());
    }

    public static OctetKeyPair parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str));
    }

    public static OctetKeyPair parse(Map<String, Object> map) throws ParseException {
        if (KeyType.OKP.equals(JWKMetadata.parseKeyType(map))) {
            try {
                Curve parse = Curve.parse(JSONObjectUtils.getString(map, "crv"));
                Base64URL base64URL = JSONObjectUtils.getBase64URL(map, "x");
                Base64URL base64URL2 = JSONObjectUtils.getBase64URL(map, "d");
                if (base64URL2 != null) {
                    return new OctetKeyPair(parse, base64URL, base64URL2, JWKMetadata.parseKeyUse(map), JWKMetadata.parseKeyOperations(map), JWKMetadata.parseAlgorithm(map), JWKMetadata.parseKeyID(map), JWKMetadata.parseX509CertURL(map), JWKMetadata.parseX509CertThumbprint(map), JWKMetadata.parseX509CertSHA256Thumbprint(map), JWKMetadata.parseX509CertChain(map), (KeyStore) null);
                }
                try {
                    return new OctetKeyPair(parse, base64URL, JWKMetadata.parseKeyUse(map), JWKMetadata.parseKeyOperations(map), JWKMetadata.parseAlgorithm(map), JWKMetadata.parseKeyID(map), JWKMetadata.parseX509CertURL(map), JWKMetadata.parseX509CertThumbprint(map), JWKMetadata.parseX509CertSHA256Thumbprint(map), JWKMetadata.parseX509CertChain(map), (KeyStore) null);
                } catch (IllegalArgumentException e) {
                    throw new ParseException(e.getMessage(), 0);
                }
            } catch (IllegalArgumentException e2) {
                throw new ParseException(e2.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type kty must be " + KeyType.OKP.getValue(), 0);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OctetKeyPair) || !super.equals(obj)) {
            return false;
        }
        OctetKeyPair octetKeyPair = (OctetKeyPair) obj;
        if (!Objects.equals(this.crv, octetKeyPair.crv) || !Objects.equals(this.x, octetKeyPair.x) || !Arrays.equals(this.decodedX, octetKeyPair.decodedX) || !Objects.equals(this.d, octetKeyPair.d) || !Arrays.equals(this.decodedD, octetKeyPair.decodedD)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.crv, this.x, this.d}) * 31) + Arrays.hashCode(this.decodedX)) * 31) + Arrays.hashCode(this.decodedD);
    }
}

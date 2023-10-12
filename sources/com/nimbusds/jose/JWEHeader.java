package com.nimbusds.jose;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jose.util.X509CertChainUtils;
import java.net.URI;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.jcip.annotations.Immutable;

@Immutable
public final class JWEHeader extends CommonSEHeader {
    private static final Set<String> REGISTERED_PARAMETER_NAMES;
    private static final long serialVersionUID = 1;
    private final Base64URL apu;
    private final Base64URL apv;
    private final EncryptionMethod enc;
    private final JWK epk;
    private final Base64URL iv;
    private final int p2c;
    private final Base64URL p2s;
    private final String skid;
    private final Base64URL tag;
    private final CompressionAlgorithm zip;

    public /* bridge */ /* synthetic */ JWK getJWK() {
        return super.getJWK();
    }

    public /* bridge */ /* synthetic */ URI getJWKURL() {
        return super.getJWKURL();
    }

    public /* bridge */ /* synthetic */ String getKeyID() {
        return super.getKeyID();
    }

    public /* bridge */ /* synthetic */ List getX509CertChain() {
        return super.getX509CertChain();
    }

    public /* bridge */ /* synthetic */ Base64URL getX509CertSHA256Thumbprint() {
        return super.getX509CertSHA256Thumbprint();
    }

    @Deprecated
    public /* bridge */ /* synthetic */ Base64URL getX509CertThumbprint() {
        return super.getX509CertThumbprint();
    }

    public /* bridge */ /* synthetic */ URI getX509CertURL() {
        return super.getX509CertURL();
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("alg");
        hashSet.add(HeaderParameterNames.ENCRYPTION_ALGORITHM);
        hashSet.add(HeaderParameterNames.EPHEMERAL_PUBLIC_KEY);
        hashSet.add(HeaderParameterNames.COMPRESSION_ALGORITHM);
        hashSet.add(HeaderParameterNames.JWK_SET_URL);
        hashSet.add(HeaderParameterNames.JWK);
        hashSet.add("x5u");
        hashSet.add("x5t");
        hashSet.add("x5t#S256");
        hashSet.add("x5c");
        hashSet.add("kid");
        hashSet.add(HeaderParameterNames.TYPE);
        hashSet.add(HeaderParameterNames.CONTENT_TYPE);
        hashSet.add(HeaderParameterNames.CRITICAL);
        hashSet.add(HeaderParameterNames.AGREEMENT_PARTY_U_INFO);
        hashSet.add(HeaderParameterNames.AGREEMENT_PARTY_V_INFO);
        hashSet.add(HeaderParameterNames.PBES2_SALT_INPUT);
        hashSet.add(HeaderParameterNames.PBES2_COUNT);
        hashSet.add(HeaderParameterNames.INITIALIZATION_VECTOR);
        hashSet.add(HeaderParameterNames.AUTHENTICATION_TAG);
        hashSet.add(HeaderParameterNames.SENDER_KEY_ID);
        hashSet.add("authTag");
        REGISTERED_PARAMETER_NAMES = Collections.unmodifiableSet(hashSet);
    }

    public static class Builder {
        private final JWEAlgorithm alg;
        private Base64URL apu;
        private Base64URL apv;
        private Set<String> crit;
        private String cty;
        private Map<String, Object> customParams;
        private final EncryptionMethod enc;
        private JWK epk;
        private Base64URL iv;
        private URI jku;
        private JWK jwk;
        private String kid;
        private int p2c;
        private Base64URL p2s;
        private Base64URL parsedBase64URL;
        private String skid;
        private Base64URL tag;
        private JOSEObjectType typ;
        private List<Base64> x5c;
        @Deprecated
        private Base64URL x5t;
        private Base64URL x5t256;
        private URI x5u;
        private CompressionAlgorithm zip;

        public Builder(JWEAlgorithm jWEAlgorithm, EncryptionMethod encryptionMethod) {
            if (!jWEAlgorithm.getName().equals(Algorithm.NONE.getName())) {
                this.alg = jWEAlgorithm;
                if (encryptionMethod != null) {
                    this.enc = encryptionMethod;
                    return;
                }
                throw new IllegalArgumentException("The encryption method \"enc\" parameter must not be null");
            }
            throw new IllegalArgumentException("The JWE algorithm \"alg\" cannot be \"none\"");
        }

        public Builder(JWEHeader jWEHeader) {
            this(jWEHeader.getAlgorithm(), jWEHeader.getEncryptionMethod());
            this.typ = jWEHeader.getType();
            this.cty = jWEHeader.getContentType();
            this.crit = jWEHeader.getCriticalParams();
            this.customParams = jWEHeader.getCustomParams();
            this.jku = jWEHeader.getJWKURL();
            this.jwk = jWEHeader.getJWK();
            this.x5u = jWEHeader.getX509CertURL();
            this.x5t = jWEHeader.getX509CertThumbprint();
            this.x5t256 = jWEHeader.getX509CertSHA256Thumbprint();
            this.x5c = jWEHeader.getX509CertChain();
            this.kid = jWEHeader.getKeyID();
            this.epk = jWEHeader.getEphemeralPublicKey();
            this.zip = jWEHeader.getCompressionAlgorithm();
            this.apu = jWEHeader.getAgreementPartyUInfo();
            this.apv = jWEHeader.getAgreementPartyVInfo();
            this.p2s = jWEHeader.getPBES2Salt();
            this.p2c = jWEHeader.getPBES2Count();
            this.iv = jWEHeader.getIV();
            this.tag = jWEHeader.getAuthTag();
            this.skid = jWEHeader.getSenderKeyID();
            this.customParams = jWEHeader.getCustomParams();
        }

        public Builder type(JOSEObjectType jOSEObjectType) {
            this.typ = jOSEObjectType;
            return this;
        }

        public Builder contentType(String str) {
            this.cty = str;
            return this;
        }

        public Builder criticalParams(Set<String> set) {
            this.crit = set;
            return this;
        }

        public Builder jwkURL(URI uri) {
            this.jku = uri;
            return this;
        }

        public Builder jwk(JWK jwk2) {
            if (jwk2 == null || !jwk2.isPrivate()) {
                this.jwk = jwk2;
                return this;
            }
            throw new IllegalArgumentException("The JWK must be public");
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

        public Builder keyID(String str) {
            this.kid = str;
            return this;
        }

        public Builder ephemeralPublicKey(JWK jwk2) {
            this.epk = jwk2;
            return this;
        }

        public Builder compressionAlgorithm(CompressionAlgorithm compressionAlgorithm) {
            this.zip = compressionAlgorithm;
            return this;
        }

        public Builder agreementPartyUInfo(Base64URL base64URL) {
            this.apu = base64URL;
            return this;
        }

        public Builder agreementPartyVInfo(Base64URL base64URL) {
            this.apv = base64URL;
            return this;
        }

        public Builder pbes2Salt(Base64URL base64URL) {
            this.p2s = base64URL;
            return this;
        }

        public Builder pbes2Count(int i) {
            if (i >= 0) {
                this.p2c = i;
                return this;
            }
            throw new IllegalArgumentException("The PBES2 count parameter must not be negative");
        }

        public Builder iv(Base64URL base64URL) {
            this.iv = base64URL;
            return this;
        }

        public Builder authTag(Base64URL base64URL) {
            this.tag = base64URL;
            return this;
        }

        public Builder senderKeyID(String str) {
            this.skid = str;
            return this;
        }

        public Builder customParam(String str, Object obj) {
            if (!JWEHeader.getRegisteredParameterNames().contains(str)) {
                if (this.customParams == null) {
                    this.customParams = new HashMap();
                }
                this.customParams.put(str, obj);
                return this;
            }
            throw new IllegalArgumentException("The parameter name \"" + str + "\" matches a registered name");
        }

        public Builder customParams(Map<String, Object> map) {
            this.customParams = map;
            return this;
        }

        public Builder parsedBase64URL(Base64URL base64URL) {
            this.parsedBase64URL = base64URL;
            return this;
        }

        public JWEHeader build() {
            return new JWEHeader(this.alg, this.enc, this.typ, this.cty, this.crit, this.jku, this.jwk, this.x5u, this.x5t, this.x5t256, this.x5c, this.kid, this.epk, this.zip, this.apu, this.apv, this.p2s, this.p2c, this.iv, this.tag, this.skid, this.customParams, this.parsedBase64URL);
        }
    }

    public JWEHeader(JWEAlgorithm jWEAlgorithm, EncryptionMethod encryptionMethod) {
        this(jWEAlgorithm, encryptionMethod, (JOSEObjectType) null, (String) null, (Set<String>) null, (URI) null, (JWK) null, (URI) null, (Base64URL) null, (Base64URL) null, (List<Base64>) null, (String) null, (JWK) null, (CompressionAlgorithm) null, (Base64URL) null, (Base64URL) null, (Base64URL) null, 0, (Base64URL) null, (Base64URL) null, (String) null, (Map<String, Object>) null, (Base64URL) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JWEHeader(Algorithm algorithm, EncryptionMethod encryptionMethod, JOSEObjectType jOSEObjectType, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, JWK jwk2, CompressionAlgorithm compressionAlgorithm, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, int i, Base64URL base64URL6, Base64URL base64URL7, String str3, Map<String, Object> map, Base64URL base64URL8) {
        super(algorithm, jOSEObjectType, str, set, uri, jwk, uri2, base64URL, base64URL2, list, str2, map, base64URL8);
        EncryptionMethod encryptionMethod2 = encryptionMethod;
        JWK jwk3 = jwk2;
        if (algorithm.getName().equals(Algorithm.NONE.getName())) {
            throw new IllegalArgumentException("The JWE algorithm cannot be \"none\"");
        } else if (encryptionMethod2 == null) {
            throw new IllegalArgumentException("The encryption method \"enc\" parameter must not be null");
        } else if (jwk3 == null || !jwk2.isPrivate()) {
            this.enc = encryptionMethod2;
            this.epk = jwk3;
            this.zip = compressionAlgorithm;
            this.apu = base64URL3;
            this.apv = base64URL4;
            this.p2s = base64URL5;
            this.p2c = i;
            this.iv = base64URL6;
            this.tag = base64URL7;
            this.skid = str3;
        } else {
            throw new IllegalArgumentException("Ephemeral public key should not be a private key");
        }
    }

    public JWEHeader(JWEHeader jWEHeader) {
        this(jWEHeader.getAlgorithm(), jWEHeader.getEncryptionMethod(), jWEHeader.getType(), jWEHeader.getContentType(), jWEHeader.getCriticalParams(), jWEHeader.getJWKURL(), jWEHeader.getJWK(), jWEHeader.getX509CertURL(), jWEHeader.getX509CertThumbprint(), jWEHeader.getX509CertSHA256Thumbprint(), jWEHeader.getX509CertChain(), jWEHeader.getKeyID(), jWEHeader.getEphemeralPublicKey(), jWEHeader.getCompressionAlgorithm(), jWEHeader.getAgreementPartyUInfo(), jWEHeader.getAgreementPartyVInfo(), jWEHeader.getPBES2Salt(), jWEHeader.getPBES2Count(), jWEHeader.getIV(), jWEHeader.getAuthTag(), jWEHeader.getSenderKeyID(), jWEHeader.getCustomParams(), jWEHeader.getParsedBase64URL());
    }

    public static Set<String> getRegisteredParameterNames() {
        return REGISTERED_PARAMETER_NAMES;
    }

    public JWEAlgorithm getAlgorithm() {
        return (JWEAlgorithm) super.getAlgorithm();
    }

    public EncryptionMethod getEncryptionMethod() {
        return this.enc;
    }

    public JWK getEphemeralPublicKey() {
        return this.epk;
    }

    public CompressionAlgorithm getCompressionAlgorithm() {
        return this.zip;
    }

    public Base64URL getAgreementPartyUInfo() {
        return this.apu;
    }

    public Base64URL getAgreementPartyVInfo() {
        return this.apv;
    }

    public Base64URL getPBES2Salt() {
        return this.p2s;
    }

    public int getPBES2Count() {
        return this.p2c;
    }

    public Base64URL getIV() {
        return this.iv;
    }

    public Base64URL getAuthTag() {
        return this.tag;
    }

    public String getSenderKeyID() {
        return this.skid;
    }

    public Set<String> getIncludedParams() {
        Set<String> includedParams = super.getIncludedParams();
        if (this.enc != null) {
            includedParams.add(HeaderParameterNames.ENCRYPTION_ALGORITHM);
        }
        if (this.epk != null) {
            includedParams.add(HeaderParameterNames.EPHEMERAL_PUBLIC_KEY);
        }
        if (this.zip != null) {
            includedParams.add(HeaderParameterNames.COMPRESSION_ALGORITHM);
        }
        if (this.apu != null) {
            includedParams.add(HeaderParameterNames.AGREEMENT_PARTY_U_INFO);
        }
        if (this.apv != null) {
            includedParams.add(HeaderParameterNames.AGREEMENT_PARTY_V_INFO);
        }
        if (this.p2s != null) {
            includedParams.add(HeaderParameterNames.PBES2_SALT_INPUT);
        }
        if (this.p2c > 0) {
            includedParams.add(HeaderParameterNames.PBES2_COUNT);
        }
        if (this.iv != null) {
            includedParams.add(HeaderParameterNames.INITIALIZATION_VECTOR);
        }
        if (this.tag != null) {
            includedParams.add(HeaderParameterNames.AUTHENTICATION_TAG);
        }
        if (this.skid != null) {
            includedParams.add(HeaderParameterNames.SENDER_KEY_ID);
        }
        return includedParams;
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> jSONObject = super.toJSONObject();
        EncryptionMethod encryptionMethod = this.enc;
        if (encryptionMethod != null) {
            jSONObject.put(HeaderParameterNames.ENCRYPTION_ALGORITHM, encryptionMethod.toString());
        }
        JWK jwk = this.epk;
        if (jwk != null) {
            jSONObject.put(HeaderParameterNames.EPHEMERAL_PUBLIC_KEY, jwk.toJSONObject());
        }
        CompressionAlgorithm compressionAlgorithm = this.zip;
        if (compressionAlgorithm != null) {
            jSONObject.put(HeaderParameterNames.COMPRESSION_ALGORITHM, compressionAlgorithm.toString());
        }
        Base64URL base64URL = this.apu;
        if (base64URL != null) {
            jSONObject.put(HeaderParameterNames.AGREEMENT_PARTY_U_INFO, base64URL.toString());
        }
        Base64URL base64URL2 = this.apv;
        if (base64URL2 != null) {
            jSONObject.put(HeaderParameterNames.AGREEMENT_PARTY_V_INFO, base64URL2.toString());
        }
        Base64URL base64URL3 = this.p2s;
        if (base64URL3 != null) {
            jSONObject.put(HeaderParameterNames.PBES2_SALT_INPUT, base64URL3.toString());
        }
        int i = this.p2c;
        if (i > 0) {
            jSONObject.put(HeaderParameterNames.PBES2_COUNT, Integer.valueOf(i));
        }
        Base64URL base64URL4 = this.iv;
        if (base64URL4 != null) {
            jSONObject.put(HeaderParameterNames.INITIALIZATION_VECTOR, base64URL4.toString());
        }
        Base64URL base64URL5 = this.tag;
        if (base64URL5 != null) {
            jSONObject.put(HeaderParameterNames.AUTHENTICATION_TAG, base64URL5.toString());
        }
        String str = this.skid;
        if (str != null) {
            jSONObject.put(HeaderParameterNames.SENDER_KEY_ID, str);
        }
        return jSONObject;
    }

    private static EncryptionMethod parseEncryptionMethod(Map<String, Object> map) throws ParseException {
        return EncryptionMethod.parse(JSONObjectUtils.getString(map, HeaderParameterNames.ENCRYPTION_ALGORITHM));
    }

    public static JWEHeader parse(Map<String, Object> map) throws ParseException {
        return parse(map, (Base64URL) null);
    }

    public static JWEHeader parse(Map<String, Object> map, Base64URL base64URL) throws ParseException {
        Algorithm parseAlgorithm = Header.parseAlgorithm(map);
        if (parseAlgorithm instanceof JWEAlgorithm) {
            Builder parsedBase64URL = new Builder((JWEAlgorithm) parseAlgorithm, parseEncryptionMethod(map)).parsedBase64URL(base64URL);
            for (String next : map.keySet()) {
                if (!"alg".equals(next) && !HeaderParameterNames.ENCRYPTION_ALGORITHM.equals(next)) {
                    if (HeaderParameterNames.TYPE.equals(next)) {
                        String string = JSONObjectUtils.getString(map, next);
                        if (string != null) {
                            parsedBase64URL = parsedBase64URL.type(new JOSEObjectType(string));
                        }
                    } else if (HeaderParameterNames.CONTENT_TYPE.equals(next)) {
                        parsedBase64URL = parsedBase64URL.contentType(JSONObjectUtils.getString(map, next));
                    } else if (HeaderParameterNames.CRITICAL.equals(next)) {
                        List<String> stringList = JSONObjectUtils.getStringList(map, next);
                        if (stringList != null) {
                            parsedBase64URL = parsedBase64URL.criticalParams(new HashSet(stringList));
                        }
                    } else if (HeaderParameterNames.JWK_SET_URL.equals(next)) {
                        parsedBase64URL = parsedBase64URL.jwkURL(JSONObjectUtils.getURI(map, next));
                    } else if (HeaderParameterNames.JWK.equals(next)) {
                        parsedBase64URL = parsedBase64URL.jwk(CommonSEHeader.parsePublicJWK(JSONObjectUtils.getJSONObject(map, next)));
                    } else if ("x5u".equals(next)) {
                        parsedBase64URL = parsedBase64URL.x509CertURL(JSONObjectUtils.getURI(map, next));
                    } else if ("x5t".equals(next)) {
                        parsedBase64URL = parsedBase64URL.x509CertThumbprint(Base64URL.from(JSONObjectUtils.getString(map, next)));
                    } else if ("x5t#S256".equals(next)) {
                        parsedBase64URL = parsedBase64URL.x509CertSHA256Thumbprint(Base64URL.from(JSONObjectUtils.getString(map, next)));
                    } else if ("x5c".equals(next)) {
                        parsedBase64URL = parsedBase64URL.x509CertChain(X509CertChainUtils.toBase64List(JSONObjectUtils.getJSONArray(map, next)));
                    } else if ("kid".equals(next)) {
                        parsedBase64URL = parsedBase64URL.keyID(JSONObjectUtils.getString(map, next));
                    } else if (HeaderParameterNames.EPHEMERAL_PUBLIC_KEY.equals(next)) {
                        parsedBase64URL = parsedBase64URL.ephemeralPublicKey(JWK.parse(JSONObjectUtils.getJSONObject(map, next)));
                    } else if (HeaderParameterNames.COMPRESSION_ALGORITHM.equals(next)) {
                        String string2 = JSONObjectUtils.getString(map, next);
                        if (string2 != null) {
                            parsedBase64URL = parsedBase64URL.compressionAlgorithm(new CompressionAlgorithm(string2));
                        }
                    } else if (HeaderParameterNames.AGREEMENT_PARTY_U_INFO.equals(next)) {
                        parsedBase64URL = parsedBase64URL.agreementPartyUInfo(Base64URL.from(JSONObjectUtils.getString(map, next)));
                    } else if (HeaderParameterNames.AGREEMENT_PARTY_V_INFO.equals(next)) {
                        parsedBase64URL = parsedBase64URL.agreementPartyVInfo(Base64URL.from(JSONObjectUtils.getString(map, next)));
                    } else if (HeaderParameterNames.PBES2_SALT_INPUT.equals(next)) {
                        parsedBase64URL = parsedBase64URL.pbes2Salt(Base64URL.from(JSONObjectUtils.getString(map, next)));
                    } else if (HeaderParameterNames.PBES2_COUNT.equals(next)) {
                        parsedBase64URL = parsedBase64URL.pbes2Count(JSONObjectUtils.getInt(map, next));
                    } else if (HeaderParameterNames.INITIALIZATION_VECTOR.equals(next)) {
                        parsedBase64URL = parsedBase64URL.iv(Base64URL.from(JSONObjectUtils.getString(map, next)));
                    } else if (HeaderParameterNames.AUTHENTICATION_TAG.equals(next)) {
                        parsedBase64URL = parsedBase64URL.authTag(Base64URL.from(JSONObjectUtils.getString(map, next)));
                    } else if (HeaderParameterNames.SENDER_KEY_ID.equals(next)) {
                        parsedBase64URL = parsedBase64URL.senderKeyID(JSONObjectUtils.getString(map, next));
                    } else {
                        parsedBase64URL = parsedBase64URL.customParam(next, map.get(next));
                    }
                }
            }
            return parsedBase64URL.build();
        }
        throw new ParseException("The algorithm \"alg\" header parameter must be for encryption", 0);
    }

    public static JWEHeader parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str), (Base64URL) null);
    }

    public static JWEHeader parse(String str, Base64URL base64URL) throws ParseException {
        return parse(JSONObjectUtils.parse(str, Header.MAX_HEADER_STRING_LENGTH), base64URL);
    }

    public static JWEHeader parse(Base64URL base64URL) throws ParseException {
        return parse(base64URL.decodeToString(), base64URL);
    }
}

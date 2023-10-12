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
public final class JWSHeader extends CommonSEHeader {
    private static final Set<String> REGISTERED_PARAMETER_NAMES;
    private static final long serialVersionUID = 1;
    private final boolean b64;

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
        hashSet.add(HeaderParameterNames.BASE64_URL_ENCODE_PAYLOAD);
        REGISTERED_PARAMETER_NAMES = Collections.unmodifiableSet(hashSet);
    }

    public static class Builder {
        private final JWSAlgorithm alg;
        private boolean b64;
        private Set<String> crit;
        private String cty;
        private Map<String, Object> customParams;
        private URI jku;
        private JWK jwk;
        private String kid;
        private Base64URL parsedBase64URL;
        private JOSEObjectType typ;
        private List<Base64> x5c;
        @Deprecated
        private Base64URL x5t;
        private Base64URL x5t256;
        private URI x5u;

        public Builder(JWSAlgorithm jWSAlgorithm) {
            this.b64 = true;
            if (!jWSAlgorithm.getName().equals(Algorithm.NONE.getName())) {
                this.alg = jWSAlgorithm;
                return;
            }
            throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
        }

        public Builder(JWSHeader jWSHeader) {
            this(jWSHeader.getAlgorithm());
            this.typ = jWSHeader.getType();
            this.cty = jWSHeader.getContentType();
            this.crit = jWSHeader.getCriticalParams();
            this.jku = jWSHeader.getJWKURL();
            this.jwk = jWSHeader.getJWK();
            this.x5u = jWSHeader.getX509CertURL();
            this.x5t = jWSHeader.getX509CertThumbprint();
            this.x5t256 = jWSHeader.getX509CertSHA256Thumbprint();
            this.x5c = jWSHeader.getX509CertChain();
            this.kid = jWSHeader.getKeyID();
            this.b64 = jWSHeader.isBase64URLEncodePayload();
            this.customParams = jWSHeader.getCustomParams();
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

        public Builder base64URLEncodePayload(boolean z) {
            this.b64 = z;
            return this;
        }

        public Builder customParam(String str, Object obj) {
            if (!JWSHeader.getRegisteredParameterNames().contains(str)) {
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

        public JWSHeader build() {
            return new JWSHeader(this.alg, this.typ, this.cty, this.crit, this.jku, this.jwk, this.x5u, this.x5t, this.x5t256, this.x5c, this.kid, this.b64, this.customParams, this.parsedBase64URL);
        }
    }

    public JWSHeader(JWSAlgorithm jWSAlgorithm) {
        this(jWSAlgorithm, (JOSEObjectType) null, (String) null, (Set<String>) null, (URI) null, (JWK) null, (URI) null, (Base64URL) null, (Base64URL) null, (List<Base64>) null, (String) null, true, (Map<String, Object>) null, (Base64URL) null);
    }

    @Deprecated
    public JWSHeader(JWSAlgorithm jWSAlgorithm, JOSEObjectType jOSEObjectType, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, Map<String, Object> map, Base64URL base64URL3) {
        this(jWSAlgorithm, jOSEObjectType, str, set, uri, jwk, uri2, base64URL, base64URL2, list, str2, true, map, base64URL3);
    }

    public JWSHeader(JWSAlgorithm jWSAlgorithm, JOSEObjectType jOSEObjectType, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, boolean z, Map<String, Object> map, Base64URL base64URL3) {
        super(jWSAlgorithm, jOSEObjectType, str, set, uri, jwk, uri2, base64URL, base64URL2, list, str2, map, base64URL3);
        if (!jWSAlgorithm.getName().equals(Algorithm.NONE.getName())) {
            this.b64 = z;
            return;
        }
        throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
    }

    public JWSHeader(JWSHeader jWSHeader) {
        this(jWSHeader.getAlgorithm(), jWSHeader.getType(), jWSHeader.getContentType(), jWSHeader.getCriticalParams(), jWSHeader.getJWKURL(), jWSHeader.getJWK(), jWSHeader.getX509CertURL(), jWSHeader.getX509CertThumbprint(), jWSHeader.getX509CertSHA256Thumbprint(), jWSHeader.getX509CertChain(), jWSHeader.getKeyID(), jWSHeader.isBase64URLEncodePayload(), jWSHeader.getCustomParams(), jWSHeader.getParsedBase64URL());
    }

    public static Set<String> getRegisteredParameterNames() {
        return REGISTERED_PARAMETER_NAMES;
    }

    public JWSAlgorithm getAlgorithm() {
        return (JWSAlgorithm) super.getAlgorithm();
    }

    public boolean isBase64URLEncodePayload() {
        return this.b64;
    }

    public Set<String> getIncludedParams() {
        Set<String> includedParams = super.getIncludedParams();
        if (!isBase64URLEncodePayload()) {
            includedParams.add(HeaderParameterNames.BASE64_URL_ENCODE_PAYLOAD);
        }
        return includedParams;
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> jSONObject = super.toJSONObject();
        if (!isBase64URLEncodePayload()) {
            jSONObject.put(HeaderParameterNames.BASE64_URL_ENCODE_PAYLOAD, false);
        }
        return jSONObject;
    }

    public static JWSHeader parse(Map<String, Object> map) throws ParseException {
        return parse(map, (Base64URL) null);
    }

    public static JWSHeader parse(Map<String, Object> map, Base64URL base64URL) throws ParseException {
        Algorithm parseAlgorithm = Header.parseAlgorithm(map);
        if (parseAlgorithm instanceof JWSAlgorithm) {
            Builder parsedBase64URL = new Builder((JWSAlgorithm) parseAlgorithm).parsedBase64URL(base64URL);
            for (String next : map.keySet()) {
                if (!"alg".equals(next)) {
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
                    } else if (HeaderParameterNames.BASE64_URL_ENCODE_PAYLOAD.equals(next)) {
                        parsedBase64URL = parsedBase64URL.base64URLEncodePayload(JSONObjectUtils.getBoolean(map, next));
                    } else {
                        parsedBase64URL = parsedBase64URL.customParam(next, map.get(next));
                    }
                }
            }
            return parsedBase64URL.build();
        }
        throw new ParseException("Not a JWS header", 0);
    }

    public static JWSHeader parse(String str) throws ParseException {
        return parse(str, (Base64URL) null);
    }

    public static JWSHeader parse(String str, Base64URL base64URL) throws ParseException {
        return parse(JSONObjectUtils.parse(str, Header.MAX_HEADER_STRING_LENGTH), base64URL);
    }

    public static JWSHeader parse(Base64URL base64URL) throws ParseException {
        return parse(base64URL.decodeToString(), base64URL);
    }
}

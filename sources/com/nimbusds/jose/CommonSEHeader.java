package com.nimbusds.jose;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

abstract class CommonSEHeader extends Header {
    private static final long serialVersionUID = 1;
    private final URI jku;
    private final JWK jwk;
    private final String kid;
    private final List<Base64> x5c;
    private final Base64URL x5t;
    private final Base64URL x5t256;
    private final URI x5u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected CommonSEHeader(Algorithm algorithm, JOSEObjectType jOSEObjectType, String str, Set<String> set, URI uri, JWK jwk2, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, Map<String, Object> map, Base64URL base64URL3) {
        super(algorithm, jOSEObjectType, str, set, map, base64URL3);
        List<Base64> list2 = list;
        this.jku = uri;
        this.jwk = jwk2;
        this.x5u = uri2;
        this.x5t = base64URL;
        this.x5t256 = base64URL2;
        if (list2 != null) {
            this.x5c = Collections.unmodifiableList(new ArrayList(list2));
        } else {
            this.x5c = null;
        }
        this.kid = str2;
    }

    public URI getJWKURL() {
        return this.jku;
    }

    public JWK getJWK() {
        return this.jwk;
    }

    public URI getX509CertURL() {
        return this.x5u;
    }

    @Deprecated
    public Base64URL getX509CertThumbprint() {
        return this.x5t;
    }

    public Base64URL getX509CertSHA256Thumbprint() {
        return this.x5t256;
    }

    public List<Base64> getX509CertChain() {
        return this.x5c;
    }

    public String getKeyID() {
        return this.kid;
    }

    public Set<String> getIncludedParams() {
        Set<String> includedParams = super.getIncludedParams();
        if (this.jku != null) {
            includedParams.add(HeaderParameterNames.JWK_SET_URL);
        }
        if (this.jwk != null) {
            includedParams.add(HeaderParameterNames.JWK);
        }
        if (this.x5u != null) {
            includedParams.add("x5u");
        }
        if (this.x5t != null) {
            includedParams.add("x5t");
        }
        if (this.x5t256 != null) {
            includedParams.add("x5t#S256");
        }
        List<Base64> list = this.x5c;
        if (list != null && !list.isEmpty()) {
            includedParams.add("x5c");
        }
        if (this.kid != null) {
            includedParams.add("kid");
        }
        return includedParams;
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> jSONObject = super.toJSONObject();
        URI uri = this.jku;
        if (uri != null) {
            jSONObject.put(HeaderParameterNames.JWK_SET_URL, uri.toString());
        }
        JWK jwk2 = this.jwk;
        if (jwk2 != null) {
            jSONObject.put(HeaderParameterNames.JWK, jwk2.toJSONObject());
        }
        URI uri2 = this.x5u;
        if (uri2 != null) {
            jSONObject.put("x5u", uri2.toString());
        }
        Base64URL base64URL = this.x5t;
        if (base64URL != null) {
            jSONObject.put("x5t", base64URL.toString());
        }
        Base64URL base64URL2 = this.x5t256;
        if (base64URL2 != null) {
            jSONObject.put("x5t#S256", base64URL2.toString());
        }
        List<Base64> list = this.x5c;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.x5c.size());
            for (Base64 base64 : this.x5c) {
                arrayList.add(base64.toString());
            }
            jSONObject.put("x5c", arrayList);
        }
        String str = this.kid;
        if (str != null) {
            jSONObject.put("kid", str);
        }
        return jSONObject;
    }

    static JWK parsePublicJWK(Map<String, Object> map) throws ParseException {
        if (map == null) {
            return null;
        }
        JWK parse = JWK.parse(map);
        if (!parse.isPrivate()) {
            return parse;
        }
        throw new ParseException("Non-public key in jwk header parameter", 0);
    }
}

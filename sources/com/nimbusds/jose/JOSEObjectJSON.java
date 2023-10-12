package com.nimbusds.jose;

import com.nimbusds.jose.util.JSONObjectUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Map;
import java.util.Objects;

public abstract class JOSEObjectJSON implements Serializable {
    public static final String MIME_TYPE_JOSE_JSON = "application/jose+json; charset=UTF-8";
    private static final long serialVersionUID = 1;
    private Payload payload;

    public abstract String serializeFlattened();

    public abstract String serializeGeneral();

    /* access modifiers changed from: package-private */
    public abstract Map<String, Object> toFlattenedJSONObject();

    /* access modifiers changed from: package-private */
    public abstract Map<String, Object> toGeneralJSONObject();

    protected JOSEObjectJSON(Payload payload2) {
        this.payload = payload2;
    }

    /* access modifiers changed from: protected */
    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public static JOSEObjectJSON parse(Map<String, Object> map) throws ParseException {
        if (map.containsKey("signature") || map.containsKey("signatures")) {
            return JWSObjectJSON.parse(map);
        }
        if (map.containsKey("ciphertext")) {
            throw new ParseException("JWE JSON not supported", 0);
        }
        throw new ParseException("Invalid JOSE object", 0);
    }

    public static JOSEObjectJSON parse(String str) throws ParseException {
        Objects.requireNonNull(str);
        return parse(JSONObjectUtils.parse(str));
    }
}

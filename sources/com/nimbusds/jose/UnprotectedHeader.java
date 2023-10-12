package com.nimbusds.jose;

import com.nimbusds.jose.util.JSONObjectUtils;
import java.text.ParseException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.jcip.annotations.Immutable;

@Immutable
public final class UnprotectedHeader {
    private final Map<String, Object> params;

    private UnprotectedHeader(Map<String, Object> map) {
        Objects.requireNonNull(map);
        this.params = map;
    }

    public String getKeyID() {
        return (String) this.params.get("kid");
    }

    public Object getParam(String str) {
        return this.params.get(str);
    }

    public Set<String> getIncludedParams() {
        return this.params.keySet();
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> newJSONObject = JSONObjectUtils.newJSONObject();
        newJSONObject.putAll(this.params);
        return newJSONObject;
    }

    public static UnprotectedHeader parse(Map<String, Object> map) throws ParseException {
        if (map == null) {
            return null;
        }
        Builder builder = new Builder();
        for (String next : map.keySet()) {
            builder = builder.param(next, map.get(next));
        }
        return builder.build();
    }

    public static class Builder {
        private final Map<String, Object> params = JSONObjectUtils.newJSONObject();

        public Builder keyID(String str) {
            this.params.put("kid", str);
            return this;
        }

        public Builder param(String str, Object obj) {
            this.params.put(str, obj);
            return this;
        }

        public UnprotectedHeader build() {
            return new UnprotectedHeader(this.params);
        }
    }
}

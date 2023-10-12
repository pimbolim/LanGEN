package com.nimbusds.jwt;

import com.nimbusds.jose.Payload;
import com.nimbusds.jose.util.JSONArrayUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jwt.util.DateUtils;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.jcip.annotations.Immutable;

@Immutable
public final class JWTClaimsSet implements Serializable {
    private static final Set<String> REGISTERED_CLAIM_NAMES;
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final Map<String, Object> claims;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(JWTClaimNames.ISSUER);
        hashSet.add(JWTClaimNames.SUBJECT);
        hashSet.add(JWTClaimNames.AUDIENCE);
        hashSet.add(JWTClaimNames.EXPIRATION_TIME);
        hashSet.add(JWTClaimNames.NOT_BEFORE);
        hashSet.add(JWTClaimNames.ISSUED_AT);
        hashSet.add(JWTClaimNames.JWT_ID);
        REGISTERED_CLAIM_NAMES = Collections.unmodifiableSet(hashSet);
    }

    public static class Builder {
        private final Map<String, Object> claims;

        public Builder() {
            this.claims = new LinkedHashMap();
        }

        public Builder(JWTClaimsSet jWTClaimsSet) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.claims = linkedHashMap;
            linkedHashMap.putAll(jWTClaimsSet.claims);
        }

        public Builder issuer(String str) {
            this.claims.put(JWTClaimNames.ISSUER, str);
            return this;
        }

        public Builder subject(String str) {
            this.claims.put(JWTClaimNames.SUBJECT, str);
            return this;
        }

        public Builder audience(List<String> list) {
            this.claims.put(JWTClaimNames.AUDIENCE, list);
            return this;
        }

        public Builder audience(String str) {
            if (str == null) {
                this.claims.put(JWTClaimNames.AUDIENCE, (Object) null);
            } else {
                this.claims.put(JWTClaimNames.AUDIENCE, Collections.singletonList(str));
            }
            return this;
        }

        public Builder expirationTime(Date date) {
            this.claims.put(JWTClaimNames.EXPIRATION_TIME, date);
            return this;
        }

        public Builder notBeforeTime(Date date) {
            this.claims.put(JWTClaimNames.NOT_BEFORE, date);
            return this;
        }

        public Builder issueTime(Date date) {
            this.claims.put(JWTClaimNames.ISSUED_AT, date);
            return this;
        }

        public Builder jwtID(String str) {
            this.claims.put(JWTClaimNames.JWT_ID, str);
            return this;
        }

        public Builder claim(String str, Object obj) {
            this.claims.put(str, obj);
            return this;
        }

        public Map<String, Object> getClaims() {
            return Collections.unmodifiableMap(this.claims);
        }

        public JWTClaimsSet build() {
            return new JWTClaimsSet(this.claims);
        }
    }

    private JWTClaimsSet(Map<String, Object> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.claims = linkedHashMap;
        linkedHashMap.putAll(map);
    }

    public static Set<String> getRegisteredNames() {
        return REGISTERED_CLAIM_NAMES;
    }

    public String getIssuer() {
        try {
            return getStringClaim(JWTClaimNames.ISSUER);
        } catch (ParseException unused) {
            return null;
        }
    }

    public String getSubject() {
        try {
            return getStringClaim(JWTClaimNames.SUBJECT);
        } catch (ParseException unused) {
            return null;
        }
    }

    public List<String> getAudience() {
        Object claim = getClaim(JWTClaimNames.AUDIENCE);
        if (claim instanceof String) {
            return Collections.singletonList((String) claim);
        }
        try {
            List<String> stringListClaim = getStringListClaim(JWTClaimNames.AUDIENCE);
            return stringListClaim != null ? stringListClaim : Collections.emptyList();
        } catch (ParseException unused) {
            return Collections.emptyList();
        }
    }

    public Date getExpirationTime() {
        try {
            return getDateClaim(JWTClaimNames.EXPIRATION_TIME);
        } catch (ParseException unused) {
            return null;
        }
    }

    public Date getNotBeforeTime() {
        try {
            return getDateClaim(JWTClaimNames.NOT_BEFORE);
        } catch (ParseException unused) {
            return null;
        }
    }

    public Date getIssueTime() {
        try {
            return getDateClaim(JWTClaimNames.ISSUED_AT);
        } catch (ParseException unused) {
            return null;
        }
    }

    public String getJWTID() {
        try {
            return getStringClaim(JWTClaimNames.JWT_ID);
        } catch (ParseException unused) {
            return null;
        }
    }

    public Object getClaim(String str) {
        return this.claims.get(str);
    }

    public String getStringClaim(String str) throws ParseException {
        Object claim = getClaim(str);
        if (claim == null || (claim instanceof String)) {
            return (String) claim;
        }
        throw new ParseException("The " + str + " claim is not a String", 0);
    }

    public String[] getStringArrayClaim(String str) throws ParseException {
        if (getClaim(str) == null) {
            return null;
        }
        try {
            List list = (List) getClaim(str);
            int size = list.size();
            String[] strArr = new String[size];
            int i = 0;
            while (i < size) {
                try {
                    strArr[i] = (String) list.get(i);
                    i++;
                } catch (ClassCastException unused) {
                    throw new ParseException("The " + str + " claim is not a list / JSON array of strings", 0);
                }
            }
            return strArr;
        } catch (ClassCastException unused2) {
            throw new ParseException("The " + str + " claim is not a list / JSON array", 0);
        }
    }

    public List<String> getStringListClaim(String str) throws ParseException {
        String[] stringArrayClaim = getStringArrayClaim(str);
        if (stringArrayClaim == null) {
            return null;
        }
        return Collections.unmodifiableList(Arrays.asList(stringArrayClaim));
    }

    public URI getURIClaim(String str) throws ParseException {
        String stringClaim = getStringClaim(str);
        if (stringClaim == null) {
            return null;
        }
        try {
            return new URI(stringClaim);
        } catch (URISyntaxException e) {
            throw new ParseException("The \"" + str + "\" claim is not a URI: " + e.getMessage(), 0);
        }
    }

    public Boolean getBooleanClaim(String str) throws ParseException {
        Object claim = getClaim(str);
        if (claim == null || (claim instanceof Boolean)) {
            return (Boolean) claim;
        }
        throw new ParseException("The \"" + str + "\" claim is not a Boolean", 0);
    }

    public Integer getIntegerClaim(String str) throws ParseException {
        Object claim = getClaim(str);
        if (claim == null) {
            return null;
        }
        if (claim instanceof Number) {
            return Integer.valueOf(((Number) claim).intValue());
        }
        throw new ParseException("The \"" + str + "\" claim is not an Integer", 0);
    }

    public Long getLongClaim(String str) throws ParseException {
        Object claim = getClaim(str);
        if (claim == null) {
            return null;
        }
        if (claim instanceof Number) {
            return Long.valueOf(((Number) claim).longValue());
        }
        throw new ParseException("The \"" + str + "\" claim is not a Number", 0);
    }

    public Date getDateClaim(String str) throws ParseException {
        Object claim = getClaim(str);
        if (claim == null) {
            return null;
        }
        if (claim instanceof Date) {
            return (Date) claim;
        }
        if (claim instanceof Number) {
            return DateUtils.fromSecondsSinceEpoch(((Number) claim).longValue());
        }
        throw new ParseException("The \"" + str + "\" claim is not a Date", 0);
    }

    public Float getFloatClaim(String str) throws ParseException {
        Object claim = getClaim(str);
        if (claim == null) {
            return null;
        }
        if (claim instanceof Number) {
            return Float.valueOf(((Number) claim).floatValue());
        }
        throw new ParseException("The \"" + str + "\" claim is not a Float", 0);
    }

    public Double getDoubleClaim(String str) throws ParseException {
        Object claim = getClaim(str);
        if (claim == null) {
            return null;
        }
        if (claim instanceof Number) {
            return Double.valueOf(((Number) claim).doubleValue());
        }
        throw new ParseException("The \"" + str + "\" claim is not a Double", 0);
    }

    public Map<String, Object> getJSONObjectClaim(String str) throws ParseException {
        Object claim = getClaim(str);
        if (claim == null) {
            return null;
        }
        if (claim instanceof Map) {
            Map<String, Object> newJSONObject = JSONObjectUtils.newJSONObject();
            for (Map.Entry entry : ((Map) claim).entrySet()) {
                if (entry.getKey() instanceof String) {
                    newJSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
            return newJSONObject;
        }
        throw new ParseException("The \"" + str + "\" claim is not a JSON object or Map", 0);
    }

    public Map<String, Object> getClaims() {
        return Collections.unmodifiableMap(this.claims);
    }

    public Payload toPayload() {
        return new Payload(toJSONObject());
    }

    public Map<String, Object> toJSONObject() {
        return toJSONObject(false);
    }

    public Map<String, Object> toJSONObject(boolean z) {
        Map<String, Object> newJSONObject = JSONObjectUtils.newJSONObject();
        for (Map.Entry next : this.claims.entrySet()) {
            if (next.getValue() instanceof Date) {
                newJSONObject.put(next.getKey(), Long.valueOf(DateUtils.toSecondsSinceEpoch((Date) next.getValue())));
            } else if (JWTClaimNames.AUDIENCE.equals(next.getKey())) {
                List<String> audience = getAudience();
                if (audience == null || audience.isEmpty()) {
                    if (z) {
                        newJSONObject.put(JWTClaimNames.AUDIENCE, (Object) null);
                    }
                } else if (audience.size() == 1) {
                    newJSONObject.put(JWTClaimNames.AUDIENCE, audience.get(0));
                } else {
                    List<Object> newJSONArray = JSONArrayUtils.newJSONArray();
                    newJSONArray.addAll(audience);
                    newJSONObject.put(JWTClaimNames.AUDIENCE, newJSONArray);
                }
            } else if (next.getValue() != null) {
                newJSONObject.put(next.getKey(), next.getValue());
            } else if (z) {
                newJSONObject.put(next.getKey(), (Object) null);
            }
        }
        return newJSONObject;
    }

    public String toString() {
        return JSONObjectUtils.toJSONString(toJSONObject());
    }

    public String toString(boolean z) {
        return JSONObjectUtils.toJSONString(toJSONObject(z));
    }

    public <T> T toType(JWTClaimsSetTransformer<T> jWTClaimsSetTransformer) {
        return jWTClaimsSetTransformer.transform(this);
    }

    public static JWTClaimsSet parse(Map<String, Object> map) throws ParseException {
        Builder builder = new Builder();
        for (String next : map.keySet()) {
            next.hashCode();
            char c = 65535;
            switch (next.hashCode()) {
                case 96944:
                    if (next.equals(JWTClaimNames.AUDIENCE)) {
                        c = 0;
                        break;
                    }
                    break;
                case 100893:
                    if (next.equals(JWTClaimNames.EXPIRATION_TIME)) {
                        c = 1;
                        break;
                    }
                    break;
                case 104028:
                    if (next.equals(JWTClaimNames.ISSUED_AT)) {
                        c = 2;
                        break;
                    }
                    break;
                case 104585:
                    if (next.equals(JWTClaimNames.ISSUER)) {
                        c = 3;
                        break;
                    }
                    break;
                case 105567:
                    if (next.equals(JWTClaimNames.JWT_ID)) {
                        c = 4;
                        break;
                    }
                    break;
                case 108850:
                    if (next.equals(JWTClaimNames.NOT_BEFORE)) {
                        c = 5;
                        break;
                    }
                    break;
                case 114240:
                    if (next.equals(JWTClaimNames.SUBJECT)) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    Object obj = map.get(JWTClaimNames.AUDIENCE);
                    if (!(obj instanceof String)) {
                        if (!(obj instanceof List)) {
                            if (obj != null) {
                                break;
                            } else {
                                builder.audience((String) null);
                                break;
                            }
                        } else {
                            builder.audience(JSONObjectUtils.getStringList(map, JWTClaimNames.AUDIENCE));
                            break;
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(JSONObjectUtils.getString(map, JWTClaimNames.AUDIENCE));
                        builder.audience((List<String>) arrayList);
                        break;
                    }
                case 1:
                    builder.expirationTime(new Date(JSONObjectUtils.getLong(map, JWTClaimNames.EXPIRATION_TIME) * 1000));
                    break;
                case 2:
                    builder.issueTime(new Date(JSONObjectUtils.getLong(map, JWTClaimNames.ISSUED_AT) * 1000));
                    break;
                case 3:
                    builder.issuer(JSONObjectUtils.getString(map, JWTClaimNames.ISSUER));
                    break;
                case 4:
                    builder.jwtID(JSONObjectUtils.getString(map, JWTClaimNames.JWT_ID));
                    break;
                case 5:
                    builder.notBeforeTime(new Date(JSONObjectUtils.getLong(map, JWTClaimNames.NOT_BEFORE) * 1000));
                    break;
                case 6:
                    builder.subject(JSONObjectUtils.getString(map, JWTClaimNames.SUBJECT));
                    break;
                default:
                    builder.claim(next, map.get(next));
                    break;
            }
        }
        return builder.build();
    }

    public static JWTClaimsSet parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JWTClaimsSet)) {
            return false;
        }
        return Objects.equals(this.claims, ((JWTClaimsSet) obj).claims);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.claims});
    }
}

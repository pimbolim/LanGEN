package com.stripe.android.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0002J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u0003\u0018\u00010\nJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0004J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0004H\u0007J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0004H\u0007J&\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0004J\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0004¢\u0006\u0002\u0010\u001fJ(\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0004J\u001e\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/stripe/android/core/model/StripeJsonUtils;", "", "()V", "NULL", "", "jsonArrayToList", "", "jsonArray", "Lorg/json/JSONArray;", "jsonObjectToMap", "", "jsonObject", "Lorg/json/JSONObject;", "jsonObjectToStringMap", "listToJsonArray", "values", "mapToJsonObject", "mapObject", "nullIfNullOrEmpty", "possibleNull", "optBoolean", "", "fieldName", "optCountryCode", "optCurrency", "optHash", "optInteger", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "optLong", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "optMap", "optString", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeJsonUtils.kt */
public final class StripeJsonUtils {
    public static final int $stable = 0;
    public static final StripeJsonUtils INSTANCE = new StripeJsonUtils();
    private static final String NULL = "null";

    private StripeJsonUtils() {
    }

    public final /* synthetic */ boolean optBoolean(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "fieldName");
        return jSONObject.has(str) && jSONObject.optBoolean(str, false);
    }

    public final /* synthetic */ Integer optInteger(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "fieldName");
        if (!jSONObject.has(str)) {
            return null;
        }
        return Integer.valueOf(jSONObject.optInt(str));
    }

    public final /* synthetic */ Long optLong(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "fieldName");
        if (!jSONObject.has(str)) {
            return null;
        }
        return Long.valueOf(jSONObject.optLong(str));
    }

    @JvmStatic
    public static final String optString(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(str, "fieldName");
        return INSTANCE.nullIfNullOrEmpty(jSONObject == null ? null : jSONObject.optString(str));
    }

    public final /* synthetic */ String optCountryCode(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "fieldName");
        String nullIfNullOrEmpty = nullIfNullOrEmpty(jSONObject.optString(str));
        if (nullIfNullOrEmpty != null) {
            if (nullIfNullOrEmpty.length() == 2) {
                return nullIfNullOrEmpty;
            }
        }
        return null;
    }

    @JvmStatic
    public static final String optCurrency(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "fieldName");
        String nullIfNullOrEmpty = INSTANCE.nullIfNullOrEmpty(jSONObject.optString(str));
        if (nullIfNullOrEmpty != null) {
            if (nullIfNullOrEmpty.length() == 3) {
                return nullIfNullOrEmpty;
            }
        }
        return null;
    }

    public final /* synthetic */ Map optMap(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "fieldName");
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        return INSTANCE.jsonObjectToMap(optJSONObject);
    }

    public final /* synthetic */ Map optHash(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(str, "fieldName");
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        return INSTANCE.jsonObjectToStringMap(optJSONObject);
    }

    public final /* synthetic */ Map jsonObjectToMap(JSONObject jSONObject) {
        Map map;
        if (jSONObject == null) {
            return null;
        }
        JSONArray names = jSONObject.names();
        if (names == null) {
            names = new JSONArray();
        }
        Iterable until = RangesKt.until(0, names.length());
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(names.getString(((IntIterator) it).nextInt()));
        }
        Collection arrayList2 = new ArrayList();
        for (String str : (List) arrayList) {
            Object opt = jSONObject.opt(str);
            if (opt == null) {
                map = null;
            } else if (!Intrinsics.areEqual(opt, (Object) "null")) {
                if (opt instanceof JSONObject) {
                    opt = INSTANCE.jsonObjectToMap((JSONObject) opt);
                } else if (opt instanceof JSONArray) {
                    opt = INSTANCE.jsonArrayToList((JSONArray) opt);
                }
                map = MapsKt.mapOf(TuplesKt.to(str, opt));
            } else {
                map = null;
            }
            if (map != null) {
                arrayList2.add(map);
            }
        }
        Map emptyMap = MapsKt.emptyMap();
        for (Map plus : (List) arrayList2) {
            emptyMap = MapsKt.plus(emptyMap, plus);
        }
        return emptyMap;
    }

    public final /* synthetic */ Map jsonObjectToStringMap(JSONObject jSONObject) {
        Map map;
        if (jSONObject == null) {
            return null;
        }
        JSONArray names = jSONObject.names();
        if (names == null) {
            names = new JSONArray();
        }
        Iterable until = RangesKt.until(0, names.length());
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(names.getString(((IntIterator) it).nextInt()));
        }
        Collection arrayList2 = new ArrayList();
        for (String str : (List) arrayList) {
            Object opt = jSONObject.opt(str);
            if (opt == null || Intrinsics.areEqual(opt, (Object) "null")) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to(str, opt.toString()));
            }
            if (map != null) {
                arrayList2.add(map);
            }
        }
        Map emptyMap = MapsKt.emptyMap();
        for (Map plus : (List) arrayList2) {
            emptyMap = MapsKt.plus(emptyMap, plus);
        }
        return emptyMap;
    }

    public final /* synthetic */ List jsonArrayToList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        Iterable until = RangesKt.until(0, jSONArray.length());
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(jSONArray.get(((IntIterator) it).nextInt()));
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : (List) arrayList) {
            if (next instanceof JSONArray) {
                next = INSTANCE.jsonArrayToList((JSONArray) next);
            } else if (next instanceof JSONObject) {
                next = INSTANCE.jsonObjectToMap((JSONObject) next);
            } else if (Intrinsics.areEqual(next, (Object) "null")) {
                next = null;
            }
            if (next != null) {
                arrayList2.add(next);
            }
        }
        return (List) arrayList2;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject mapToJsonObject(java.util.Map<java.lang.String, ?> r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0004
            r6 = 0
            return r6
        L_0x0004:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.util.Set r1 = r6.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0011:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0057
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r6.get(r2)
            if (r3 != 0) goto L_0x0024
            goto L_0x0011
        L_0x0024:
            boolean r4 = r3 instanceof java.util.Map     // Catch:{  }
            if (r4 == 0) goto L_0x0034
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ JSONException -> 0x0032 }
            org.json.JSONObject r3 = r5.mapToJsonObject(r3)     // Catch:{ JSONException -> 0x0032 }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x0032 }
            goto L_0x0011
        L_0x0032:
            goto L_0x0011
        L_0x0034:
            boolean r4 = r3 instanceof java.util.List     // Catch:{  }
            if (r4 == 0) goto L_0x0042
            java.util.List r3 = (java.util.List) r3     // Catch:{  }
            org.json.JSONArray r3 = r5.listToJsonArray(r3)     // Catch:{  }
            r0.put(r2, r3)     // Catch:{  }
            goto L_0x0011
        L_0x0042:
            boolean r4 = r3 instanceof java.lang.Number     // Catch:{  }
            if (r4 != 0) goto L_0x0053
            boolean r4 = r3 instanceof java.lang.Boolean     // Catch:{  }
            if (r4 == 0) goto L_0x004b
            goto L_0x0053
        L_0x004b:
            java.lang.String r3 = r3.toString()     // Catch:{  }
            r0.put(r2, r3)     // Catch:{  }
            goto L_0x0011
        L_0x0053:
            r0.put(r2, r3)     // Catch:{  }
            goto L_0x0011
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.model.StripeJsonUtils.mapToJsonObject(java.util.Map):org.json.JSONObject");
    }

    private final JSONArray listToJsonArray(List<?> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Object next : list) {
            if (next instanceof Map) {
                next = INSTANCE.mapToJsonObject((Map) next);
            } else if (next instanceof List) {
                next = INSTANCE.listToJsonArray((List) next);
            } else if (!(next instanceof Number) && !(next instanceof Boolean)) {
                next = String.valueOf(next);
            }
            jSONArray.put(next);
        }
        return jSONArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if ((r5.length() == 0) != false) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.String nullIfNullOrEmpty(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            goto L_0x0022
        L_0x0004:
            java.lang.String r1 = "null"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x001c
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0019
            r1 = 1
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            if (r1 == 0) goto L_0x001d
        L_0x001c:
            r2 = 1
        L_0x001d:
            if (r2 != 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r5 = r0
        L_0x0021:
            r0 = r5
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.model.StripeJsonUtils.nullIfNullOrEmpty(java.lang.String):java.lang.String");
    }
}

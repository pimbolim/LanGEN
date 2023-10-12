package com.stripe.android.core.networking;

import com.adobe.xmp.XMPConst;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import com.stripe.android.core.exception.InvalidRequestException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004J\u001a\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u0004J\u001a\u0010\b\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u0004J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0002J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\r\u001a\u00020\u0005H\u0002J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u0005H\u0002¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/core/networking/QueryStringFactory;", "", "()V", "compactParams", "", "", "params", "create", "createFromParamsWithEmptyValues", "flattenParams", "", "Lcom/stripe/android/core/networking/QueryStringFactory$Parameter;", "flattenParamsList", "keyPrefix", "flattenParamsMap", "flattenParamsValue", "value", "Parameter", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QueryStringFactory.kt */
public final class QueryStringFactory {
    public static final int $stable = 0;
    public static final QueryStringFactory INSTANCE = new QueryStringFactory();

    private QueryStringFactory() {
    }

    public final String create(Map<String, ?> map) {
        return CollectionsKt.joinToString$default(flattenParams(map), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, QueryStringFactory$create$1.INSTANCE, 30, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r3 = (r1 = INSTANCE).create((r3 = r1.compactParams(r3)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String createFromParamsWithEmptyValues(java.util.Map<java.lang.String, ?> r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            if (r3 != 0) goto L_0x0005
            goto L_0x0016
        L_0x0005:
            com.stripe.android.core.networking.QueryStringFactory r1 = INSTANCE
            java.util.Map r3 = r1.compactParams(r3)
            if (r3 != 0) goto L_0x000e
            goto L_0x0016
        L_0x000e:
            java.lang.String r3 = r1.create(r3)
            if (r3 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = r3
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.QueryStringFactory.createFromParamsWithEmptyValues(java.util.Map):java.lang.String");
    }

    public final Map<String, Object> compactParams(Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        HashMap hashMap = new HashMap(map);
        Iterator it = new HashSet(hashMap.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj = hashMap.get(str);
            if (obj instanceof Map) {
                Intrinsics.checkNotNullExpressionValue(str, "key");
                hashMap.put(str, compactParams((Map) obj));
            } else if (obj == null) {
                hashMap.remove(str);
            }
        }
        return hashMap;
    }

    private final List<Parameter> flattenParams(Map<String, ?> map) throws InvalidRequestException {
        return flattenParamsMap$default(this, map, (String) null, 2, (Object) null);
    }

    private final List<Parameter> flattenParamsList(List<?> list, String str) throws InvalidRequestException {
        if (list.isEmpty()) {
            return CollectionsKt.listOf(new Parameter(str, ""));
        }
        String stringPlus = Intrinsics.stringPlus(str, XMPConst.ARRAY_ITEM_NAME);
        Collection arrayList = new ArrayList();
        for (Object flattenParamsValue : list) {
            CollectionsKt.addAll(arrayList, INSTANCE.flattenParamsValue(flattenParamsValue, stringPlus));
        }
        return (List) arrayList;
    }

    static /* synthetic */ List flattenParamsMap$default(QueryStringFactory queryStringFactory, Map map, String str, int i, Object obj) throws InvalidRequestException {
        if ((i & 2) != 0) {
            str = null;
        }
        return queryStringFactory.flattenParamsMap(map, str);
    }

    private final List<Parameter> flattenParamsValue(Object obj, String str) throws InvalidRequestException {
        if (obj instanceof Map) {
            return flattenParamsMap((Map) obj, str);
        }
        if (obj instanceof List) {
            return flattenParamsList((List) obj, str);
        }
        if (obj == null) {
            return CollectionsKt.listOf(new Parameter(str, ""));
        }
        return CollectionsKt.listOf(new Parameter(str, obj.toString()));
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/core/networking/QueryStringFactory$Parameter;", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "urlEncode", "str", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QueryStringFactory.kt */
    private static final class Parameter {
        private final String key;
        private final String value;

        private final String component1() {
            return this.key;
        }

        private final String component2() {
            return this.value;
        }

        public static /* synthetic */ Parameter copy$default(Parameter parameter, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parameter.key;
            }
            if ((i & 2) != 0) {
                str2 = parameter.value;
            }
            return parameter.copy(str, str2);
        }

        public final Parameter copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            return new Parameter(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Parameter)) {
                return false;
            }
            Parameter parameter = (Parameter) obj;
            return Intrinsics.areEqual((Object) this.key, (Object) parameter.key) && Intrinsics.areEqual((Object) this.value, (Object) parameter.value);
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.value.hashCode();
        }

        public Parameter(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.key = str;
            this.value = str2;
        }

        public String toString() {
            String urlEncode = urlEncode(this.key);
            String urlEncode2 = urlEncode(this.value);
            return urlEncode + SignatureVisitor.INSTANCEOF + urlEncode2;
        }

        private final String urlEncode(String str) throws UnsupportedEncodingException {
            String encode = URLEncoder.encode(str, Charsets.UTF_8.name());
            Intrinsics.checkNotNullExpressionValue(encode, "encode(str, Charsets.UTF_8.name())");
            return encode;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.util.List<com.stripe.android.core.networking.QueryStringFactory$Parameter>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.stripe.android.core.networking.QueryStringFactory.Parameter> flattenParamsMap(java.util.Map<java.lang.String, ?> r6, java.lang.String r7) throws com.stripe.android.core.exception.InvalidRequestException {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0004
            r6 = 0
            goto L_0x0058
        L_0x0004:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0013:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0055
            java.lang.Object r1 = r6.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            if (r7 != 0) goto L_0x002c
            goto L_0x0049
        L_0x002c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            r4 = 91
            r3.append(r4)
            r3.append(r2)
            r4 = 93
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r2 = r3
        L_0x0049:
            com.stripe.android.core.networking.QueryStringFactory r3 = INSTANCE
            java.util.List r1 = r3.flattenParamsValue(r1, r2)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            kotlin.collections.CollectionsKt.addAll(r0, r1)
            goto L_0x0013
        L_0x0055:
            r6 = r0
            java.util.List r6 = (java.util.List) r6
        L_0x0058:
            if (r6 != 0) goto L_0x005e
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L_0x005e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.QueryStringFactory.flattenParamsMap(java.util.Map, java.lang.String):java.util.List");
    }
}

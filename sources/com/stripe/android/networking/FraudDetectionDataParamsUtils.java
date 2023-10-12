package com.stripe.android.networking;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\tJ6\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\f"}, d2 = {"Lcom/stripe/android/networking/FraudDetectionDataParamsUtils;", "", "()V", "addFraudDetectionData", "", "", "params", "fraudDetectionData", "Lcom/stripe/android/networking/FraudDetectionData;", "addFraudDetectionData$payments_core_release", "stripeIntentParams", "key", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FraudDetectionDataParamsUtils.kt */
public final class FraudDetectionDataParamsUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        r5 = addFraudDetectionData(r4, r1, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, ?> addFraudDetectionData$payments_core_release(java.util.Map<java.lang.String, ?> r4, com.stripe.android.networking.FraudDetectionData r5) {
        /*
            r3 = this;
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "source_data"
            java.lang.String r1 = "payment_method_data"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            java.util.Set r0 = kotlin.collections.SetsKt.setOf(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0017:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r0.next()
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = r4.containsKey(r2)
            if (r2 == 0) goto L_0x0017
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0031
            goto L_0x0039
        L_0x0031:
            java.util.Map r5 = r3.addFraudDetectionData(r4, r1, r5)
            if (r5 != 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r4 = r5
        L_0x0039:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.FraudDetectionDataParamsUtils.addFraudDetectionData$payments_core_release(java.util.Map, com.stripe.android.networking.FraudDetectionData):java.util.Map");
    }

    private final Map<String, ?> addFraudDetectionData(Map<String, ?> map, String str, FraudDetectionData fraudDetectionData) {
        Object obj = map.get(str);
        Map<String, String> map2 = null;
        Map map3 = obj instanceof Map ? (Map) obj : null;
        if (map3 == null) {
            return map;
        }
        if (fraudDetectionData != null) {
            map2 = fraudDetectionData.getParams();
        }
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        Map<String, ?> plus = MapsKt.plus(map, (Map<String, ?>) MapsKt.mapOf(TuplesKt.to(str, MapsKt.plus(map3, (Map) map2))));
        return plus == null ? map : plus;
    }
}

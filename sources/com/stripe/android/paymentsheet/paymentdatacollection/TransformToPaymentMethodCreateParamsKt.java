package com.stripe.android.paymentsheet.paymentdatacollection;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001H\u0002¨\u0006\u0004"}, d2 = {"filterOutNullValues", "", "K", "V", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransformToPaymentMethodCreateParams.kt */
public final class TransformToPaymentMethodCreateParamsKt {
    /* access modifiers changed from: private */
    public static final <K, V> Map<K, V> filterOutNullValues(Map<K, ? extends V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() != null) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }
}

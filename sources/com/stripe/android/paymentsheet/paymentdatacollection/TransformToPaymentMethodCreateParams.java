package com.stripe.android.paymentsheet.paymentdatacollection;

import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.paymentsheet.forms.FormFieldValues;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bJ4\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/paymentsheet/paymentdatacollection/TransformToPaymentMethodCreateParams;", "", "()V", "transform", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "formFieldValues", "Lcom/stripe/android/paymentsheet/forms/FormFieldValues;", "paramKey", "", "", "transformToPaymentMethodCreateParamsMap", "", "mapStructure", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransformToPaymentMethodCreateParams.kt */
public final class TransformToPaymentMethodCreateParams {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public final PaymentMethodCreateParams transform(FormFieldValues formFieldValues, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(formFieldValues, "formFieldValues");
        Intrinsics.checkNotNullParameter(map, "paramKey");
        Map map2 = MapsKt.toMap(TransformToPaymentMethodCreateParamsKt.filterOutNullValues(transformToPaymentMethodCreateParamsMap(formFieldValues, map)));
        PaymentMethod.Type.Companion companion = PaymentMethod.Type.Companion;
        Object obj = map2.get("type");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
        PaymentMethod.Type fromCode = companion.fromCode((String) obj);
        if (fromCode == null) {
            return null;
        }
        return PaymentMethodCreateParams.Companion.createWithOverride(fromCode, map2, SetsKt.setOf("PaymentSheet"));
    }

    private final Map<String, Object> transformToPaymentMethodCreateParamsMap(FormFieldValues formFieldValues, Map<String, ? extends Object> map) {
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        Map<IdentifierSpec, FormFieldEntry> fieldValuePairs = formFieldValues.getFieldValuePairs();
        Map linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(fieldValuePairs.size()));
        for (Map.Entry entry : fieldValuePairs.entrySet()) {
            linkedHashMap2.put(entry.getKey(), ((FormFieldEntry) entry.getValue()).getValue());
        }
        Map linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            linkedHashMap3.put(((IdentifierSpec) entry2.getKey()).getValue(), entry2.getValue());
        }
        Companion.createMap(map, linkedHashMap, linkedHashMap3);
        return linkedHashMap;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/paymentdatacollection/TransformToPaymentMethodCreateParams$Companion;", "", "()V", "createMap", "", "mapStructure", "", "", "dest", "", "formFieldKeyValues", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TransformToPaymentMethodCreateParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void createMap(Map<String, ? extends Object> map, Map<String, Object> map2, Map<String, String> map3) {
            for (String str : map.keySet()) {
                if (map.get(str) == null) {
                    map2.put(str, map3.get(str));
                } else if (TypeIntrinsics.isMutableMap(map.get(str))) {
                    Map linkedHashMap = new LinkedHashMap();
                    map2.put(str, linkedHashMap);
                    Companion companion = TransformToPaymentMethodCreateParams.Companion;
                    Object obj = map.get(str);
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
                    companion.createMap(TypeIntrinsics.asMutableMap(obj), linkedHashMap, map3);
                } else {
                    map2.put(str, map.get(str));
                }
            }
        }
    }
}

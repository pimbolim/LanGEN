package com.stripe.android.ui.core.forms;

import com.stripe.android.ui.core.elements.LayoutSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"PaypalForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getPaypalForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "PaypalParamKey", "", "", "", "getPaypalParamKey", "()Ljava/util/Map;", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaypalSpec.kt */
public final class PaypalSpecKt {
    private static final LayoutSpec PaypalForm = LayoutSpec.Companion.create();
    private static final Map<String, Object> PaypalParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "paypal"));

    public static final Map<String, Object> getPaypalParamKey() {
        return PaypalParamKey;
    }

    public static final LayoutSpec getPaypalForm() {
        return PaypalForm;
    }
}

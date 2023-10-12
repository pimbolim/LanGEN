package com.stripe.android.model;

import com.stripe.android.model.KlarnaSourceParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/stripe/android/model/KlarnaSourceParams$CustomPaymentMethods;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: KlarnaSourceParams.kt */
final class KlarnaSourceParams$toParamMap$2$2 extends Lambda implements Function1<KlarnaSourceParams.CustomPaymentMethods, CharSequence> {
    public static final KlarnaSourceParams$toParamMap$2$2 INSTANCE = new KlarnaSourceParams$toParamMap$2$2();

    KlarnaSourceParams$toParamMap$2$2() {
        super(1);
    }

    public final CharSequence invoke(KlarnaSourceParams.CustomPaymentMethods customPaymentMethods) {
        Intrinsics.checkNotNullParameter(customPaymentMethods, "it");
        return customPaymentMethods.getCode$payments_core_release();
    }
}

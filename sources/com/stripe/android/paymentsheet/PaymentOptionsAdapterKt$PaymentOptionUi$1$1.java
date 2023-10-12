package com.stripe.android.paymentsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
final class PaymentOptionsAdapterKt$PaymentOptionUi$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onItemSelectedListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsAdapterKt$PaymentOptionUi$1$1(Function0<Unit> function0) {
        super(0);
        this.$onItemSelectedListener = function0;
    }

    public final void invoke() {
        this.$onItemSelectedListener.invoke();
    }
}

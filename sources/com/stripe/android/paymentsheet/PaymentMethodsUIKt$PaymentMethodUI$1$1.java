package com.stripe.android.paymentsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsUI.kt */
final class PaymentMethodsUIKt$PaymentMethodUI$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $itemIndex;
    final /* synthetic */ Function1<Integer, Unit> $onItemSelectedListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsUIKt$PaymentMethodUI$1$1(Function1<? super Integer, Unit> function1, int i) {
        super(0);
        this.$onItemSelectedListener = function1;
        this.$itemIndex = i;
    }

    public final void invoke() {
        this.$onItemSelectedListener.invoke(Integer.valueOf(this.$itemIndex));
    }
}

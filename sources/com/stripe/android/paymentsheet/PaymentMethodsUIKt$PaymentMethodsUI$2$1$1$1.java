package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsUI.kt */
final class PaymentMethodsUIKt$PaymentMethodsUI$2$1$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Function1<SupportedPaymentMethod, Unit> $onItemSelectedListener;
    final /* synthetic */ List<SupportedPaymentMethod> $paymentMethods;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsUIKt$PaymentMethodsUI$2$1$1$1(Function1<? super SupportedPaymentMethod, Unit> function1, List<? extends SupportedPaymentMethod> list) {
        super(1);
        this.$onItemSelectedListener = function1;
        this.$paymentMethods = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$onItemSelectedListener.invoke(this.$paymentMethods.get(i));
    }
}

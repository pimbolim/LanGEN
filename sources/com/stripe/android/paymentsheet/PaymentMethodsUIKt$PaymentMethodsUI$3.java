package com.stripe.android.paymentsheet;

import androidx.compose.runtime.Composer;
import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsUI.kt */
final class PaymentMethodsUIKt$PaymentMethodsUI$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ Function1<SupportedPaymentMethod, Unit> $onItemSelectedListener;
    final /* synthetic */ List<SupportedPaymentMethod> $paymentMethods;
    final /* synthetic */ int $selectedIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsUIKt$PaymentMethodsUI$3(List<? extends SupportedPaymentMethod> list, int i, boolean z, Function1<? super SupportedPaymentMethod, Unit> function1, int i2) {
        super(2);
        this.$paymentMethods = list;
        this.$selectedIndex = i;
        this.$isEnabled = z;
        this.$onItemSelectedListener = function1;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        PaymentMethodsUIKt.PaymentMethodsUI(this.$paymentMethods, this.$selectedIndex, this.$isEnabled, this.$onItemSelectedListener, composer, this.$$changed | 1);
    }
}

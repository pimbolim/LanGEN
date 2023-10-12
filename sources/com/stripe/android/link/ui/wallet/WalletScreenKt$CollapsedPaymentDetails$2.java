package com.stripe.android.link.ui.wallet;

import androidx.compose.runtime.Composer;
import com.stripe.android.model.ConsumerPaymentDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$CollapsedPaymentDetails$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ ConsumerPaymentDetails.PaymentDetails $selectedPaymentMethod;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$CollapsedPaymentDetails$2(ConsumerPaymentDetails.PaymentDetails paymentDetails, boolean z, Function0<Unit> function0, int i) {
        super(2);
        this.$selectedPaymentMethod = paymentDetails;
        this.$enabled = z;
        this.$onClick = function0;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        WalletScreenKt.CollapsedPaymentDetails(this.$selectedPaymentMethod, this.$enabled, this.$onClick, composer, this.$$changed | 1);
    }
}

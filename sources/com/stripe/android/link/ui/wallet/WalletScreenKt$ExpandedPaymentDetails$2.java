package com.stripe.android.link.ui.wallet;

import androidx.compose.runtime.Composer;
import com.stripe.android.model.ConsumerPaymentDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$ExpandedPaymentDetails$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onAddNewPaymentMethodClick;
    final /* synthetic */ Function0<Unit> $onCollapse;
    final /* synthetic */ Function1<Integer, Unit> $onIndexSelected;
    final /* synthetic */ List<ConsumerPaymentDetails.PaymentDetails> $paymentDetails;
    final /* synthetic */ int $selectedIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$ExpandedPaymentDetails$2(List<? extends ConsumerPaymentDetails.PaymentDetails> list, int i, boolean z, Function1<? super Integer, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, int i2) {
        super(2);
        this.$paymentDetails = list;
        this.$selectedIndex = i;
        this.$enabled = z;
        this.$onIndexSelected = function1;
        this.$onAddNewPaymentMethodClick = function0;
        this.$onCollapse = function02;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        WalletScreenKt.ExpandedPaymentDetails(this.$paymentDetails, this.$selectedIndex, this.$enabled, this.$onIndexSelected, this.$onAddNewPaymentMethodClick, this.$onCollapse, composer, this.$$changed | 1);
    }
}

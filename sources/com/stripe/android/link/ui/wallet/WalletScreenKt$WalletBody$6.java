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
final class WalletScreenKt$WalletBody$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $isProcessing;
    final /* synthetic */ Function0<Unit> $onAddNewPaymentMethodClick;
    final /* synthetic */ Function0<Unit> $onPayAnotherWayClick;
    final /* synthetic */ Function1<ConsumerPaymentDetails.PaymentDetails, Unit> $onPayButtonClick;
    final /* synthetic */ String $payButtonLabel;
    final /* synthetic */ List<ConsumerPaymentDetails.PaymentDetails> $paymentDetails;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$WalletBody$6(boolean z, List<? extends ConsumerPaymentDetails.PaymentDetails> list, String str, Function0<Unit> function0, Function1<? super ConsumerPaymentDetails.PaymentDetails, Unit> function1, Function0<Unit> function02, int i) {
        super(2);
        this.$isProcessing = z;
        this.$paymentDetails = list;
        this.$payButtonLabel = str;
        this.$onAddNewPaymentMethodClick = function0;
        this.$onPayButtonClick = function1;
        this.$onPayAnotherWayClick = function02;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        WalletScreenKt.WalletBody(this.$isProcessing, this.$paymentDetails, this.$payButtonLabel, this.$onAddNewPaymentMethodClick, this.$onPayButtonClick, this.$onPayAnotherWayClick, composer, this.$$changed | 1);
    }
}

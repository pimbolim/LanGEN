package com.stripe.android.link.ui.wallet;

import androidx.compose.runtime.MutableState;
import com.stripe.android.model.ConsumerPaymentDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$WalletBody$5$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<ConsumerPaymentDetails.PaymentDetails, Unit> $onPayButtonClick;
    final /* synthetic */ List<ConsumerPaymentDetails.PaymentDetails> $paymentDetails;
    final /* synthetic */ MutableState<Integer> $selectedIndex$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$WalletBody$5$4(Function1<? super ConsumerPaymentDetails.PaymentDetails, Unit> function1, List<? extends ConsumerPaymentDetails.PaymentDetails> list, MutableState<Integer> mutableState) {
        super(0);
        this.$onPayButtonClick = function1;
        this.$paymentDetails = list;
        this.$selectedIndex$delegate = mutableState;
    }

    public final void invoke() {
        this.$onPayButtonClick.invoke(this.$paymentDetails.get(WalletScreenKt.m4359WalletBody$lambda9$lambda4(this.$selectedIndex$delegate)));
    }
}

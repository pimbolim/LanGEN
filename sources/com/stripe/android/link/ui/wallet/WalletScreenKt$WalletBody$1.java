package com.stripe.android.link.ui.wallet;

import com.stripe.android.model.ConsumerPaymentDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
/* synthetic */ class WalletScreenKt$WalletBody$1 extends FunctionReferenceImpl implements Function1<ConsumerPaymentDetails.PaymentDetails, Unit> {
    WalletScreenKt$WalletBody$1(Object obj) {
        super(1, obj, WalletViewModel.class, "completePayment", "completePayment(Lcom/stripe/android/model/ConsumerPaymentDetails$PaymentDetails;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConsumerPaymentDetails.PaymentDetails) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ConsumerPaymentDetails.PaymentDetails paymentDetails) {
        Intrinsics.checkNotNullParameter(paymentDetails, "p0");
        ((WalletViewModel) this.receiver).completePayment(paymentDetails);
    }
}

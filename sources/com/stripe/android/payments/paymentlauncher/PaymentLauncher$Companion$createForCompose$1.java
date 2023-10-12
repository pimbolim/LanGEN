package com.stripe.android.payments.paymentlauncher;

import com.stripe.android.payments.paymentlauncher.PaymentLauncher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentLauncher.kt */
/* synthetic */ class PaymentLauncher$Companion$createForCompose$1 extends FunctionReferenceImpl implements Function1<PaymentResult, Unit> {
    PaymentLauncher$Companion$createForCompose$1(Object obj) {
        super(1, obj, PaymentLauncher.PaymentResultCallback.class, "onPaymentResult", "onPaymentResult(Lcom/stripe/android/payments/paymentlauncher/PaymentResult;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PaymentResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PaymentResult paymentResult) {
        Intrinsics.checkNotNullParameter(paymentResult, "p0");
        ((PaymentLauncher.PaymentResultCallback) this.receiver).onPaymentResult(paymentResult);
    }
}

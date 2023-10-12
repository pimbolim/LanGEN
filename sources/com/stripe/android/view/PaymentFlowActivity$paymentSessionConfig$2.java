package com.stripe.android.view;

import com.stripe.android.PaymentSessionConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/PaymentSessionConfig;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowActivity.kt */
final class PaymentFlowActivity$paymentSessionConfig$2 extends Lambda implements Function0<PaymentSessionConfig> {
    final /* synthetic */ PaymentFlowActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentFlowActivity$paymentSessionConfig$2(PaymentFlowActivity paymentFlowActivity) {
        super(0);
        this.this$0 = paymentFlowActivity;
    }

    public final PaymentSessionConfig invoke() {
        return this.this$0.getArgs().getPaymentSessionConfig$payments_core_release();
    }
}

package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.PaymentConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultFlowController.kt */
final class DefaultFlowController$1$onCreate$2 extends Lambda implements Function0<String> {
    final /* synthetic */ DefaultFlowController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlowController$1$onCreate$2(DefaultFlowController defaultFlowController) {
        super(0);
        this.this$0 = defaultFlowController;
    }

    public final String invoke() {
        return ((PaymentConfiguration) this.this$0.lazyPaymentConfiguration.get()).getStripeAccountId();
    }
}

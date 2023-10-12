package com.stripe.android.payments;

import com.stripe.android.core.networking.ApiRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.PaymentIntentFlowResultProcessor", f = "PaymentFlowResultProcessor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {196, 206, 208}, m = "refreshStripeIntentUntilTerminalState", n = {"this", "clientSecret", "requestOptions", "remainingRetries", "this", "clientSecret", "requestOptions", "remainingRetries", "this", "clientSecret", "requestOptions", "remainingRetries"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"})
/* compiled from: PaymentFlowResultProcessor.kt */
final class PaymentIntentFlowResultProcessor$refreshStripeIntentUntilTerminalState$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PaymentIntentFlowResultProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentIntentFlowResultProcessor$refreshStripeIntentUntilTerminalState$1(PaymentIntentFlowResultProcessor paymentIntentFlowResultProcessor, Continuation<? super PaymentIntentFlowResultProcessor$refreshStripeIntentUntilTerminalState$1> continuation) {
        super(continuation);
        this.this$0 = paymentIntentFlowResultProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshStripeIntentUntilTerminalState((String) null, (ApiRequest.Options) null, this);
    }
}

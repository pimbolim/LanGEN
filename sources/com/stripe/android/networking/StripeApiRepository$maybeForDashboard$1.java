package com.stripe.android.networking;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.networking.StripeApiRepository", f = "StripeApiRepository.kt", i = {0}, l = {1781}, m = "maybeForDashboard", n = {"$this$maybeForDashboard"}, s = {"L$0"})
/* compiled from: StripeApiRepository.kt */
final class StripeApiRepository$maybeForDashboard$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StripeApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeApiRepository$maybeForDashboard$1(StripeApiRepository stripeApiRepository, Continuation<? super StripeApiRepository$maybeForDashboard$1> continuation) {
        super(continuation);
        this.this$0 = stripeApiRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.maybeForDashboard((ConfirmPaymentIntentParams) null, (ApiRequest.Options) null, this);
    }
}

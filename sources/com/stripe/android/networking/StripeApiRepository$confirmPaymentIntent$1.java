package com.stripe.android.networking;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.networking.StripeApiRepository", f = "StripeApiRepository.kt", i = {0, 0}, l = {204, 203}, m = "confirmPaymentIntent$payments_core_release", n = {"options", "expandFields"}, s = {"L$0", "L$1"})
/* compiled from: StripeApiRepository.kt */
final class StripeApiRepository$confirmPaymentIntent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StripeApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeApiRepository$confirmPaymentIntent$1(StripeApiRepository stripeApiRepository, Continuation<? super StripeApiRepository$confirmPaymentIntent$1> continuation) {
        super(continuation);
        this.this$0 = stripeApiRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.confirmPaymentIntent$payments_core_release((ConfirmPaymentIntentParams) null, (ApiRequest.Options) null, (List<String>) null, this);
    }
}

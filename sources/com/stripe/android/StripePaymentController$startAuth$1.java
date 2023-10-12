package com.stripe.android;

import com.stripe.android.PaymentController;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.view.AuthActivityStarterHost;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.StripePaymentController", f = "StripePaymentController.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {276, 282, 291, 298}, m = "startAuth", n = {"this", "host", "requestOptions", "type", "this", "host", "requestOptions", "type"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: StripePaymentController.kt */
final class StripePaymentController$startAuth$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StripePaymentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripePaymentController$startAuth$1(StripePaymentController stripePaymentController, Continuation<? super StripePaymentController$startAuth$1> continuation) {
        super(continuation);
        this.this$0 = stripePaymentController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startAuth((AuthActivityStarterHost) null, (String) null, (ApiRequest.Options) null, (PaymentController.StripeIntentType) null, this);
    }
}

package com.stripe.android;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.StripePaymentController", f = "StripePaymentController.kt", i = {0, 0}, l = {206, 205}, m = "confirmAndAuthenticateAlipay", n = {"authenticator", "requestOptions"}, s = {"L$0", "L$1"})
/* compiled from: StripePaymentController.kt */
final class StripePaymentController$confirmAndAuthenticateAlipay$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StripePaymentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripePaymentController$confirmAndAuthenticateAlipay$1(StripePaymentController stripePaymentController, Continuation<? super StripePaymentController$confirmAndAuthenticateAlipay$1> continuation) {
        super(continuation);
        this.this$0 = stripePaymentController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.confirmAndAuthenticateAlipay((ConfirmPaymentIntentParams) null, (AlipayAuthenticator) null, (ApiRequest.Options) null, this);
    }
}

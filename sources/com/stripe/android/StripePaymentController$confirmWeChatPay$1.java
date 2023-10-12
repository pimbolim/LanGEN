package com.stripe.android;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.StripePaymentController", f = "StripePaymentController.kt", i = {}, l = {219}, m = "confirmWeChatPay", n = {}, s = {})
/* compiled from: StripePaymentController.kt */
final class StripePaymentController$confirmWeChatPay$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StripePaymentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripePaymentController$confirmWeChatPay$1(StripePaymentController stripePaymentController, Continuation<? super StripePaymentController$confirmWeChatPay$1> continuation) {
        super(continuation);
        this.this$0 = stripePaymentController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.confirmWeChatPay((ConfirmPaymentIntentParams) null, (ApiRequest.Options) null, this);
    }
}

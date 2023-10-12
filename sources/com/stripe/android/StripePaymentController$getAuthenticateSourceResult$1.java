package com.stripe.android;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.StripePaymentController", f = "StripePaymentController.kt", i = {}, l = {461}, m = "getAuthenticateSourceResult", n = {}, s = {})
/* compiled from: StripePaymentController.kt */
final class StripePaymentController$getAuthenticateSourceResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StripePaymentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripePaymentController$getAuthenticateSourceResult$1(StripePaymentController stripePaymentController, Continuation<? super StripePaymentController$getAuthenticateSourceResult$1> continuation) {
        super(continuation);
        this.this$0 = stripePaymentController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAuthenticateSourceResult((Intent) null, this);
    }
}

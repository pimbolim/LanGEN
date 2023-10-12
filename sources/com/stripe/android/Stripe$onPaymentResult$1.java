package com.stripe.android;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/PaymentIntentResult;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.Stripe$onPaymentResult$1", f = "Stripe.kt", i = {}, l = {387}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Stripe.kt */
final class Stripe$onPaymentResult$1 extends SuspendLambda implements Function1<Continuation<? super PaymentIntentResult>, Object> {
    final /* synthetic */ Intent $data;
    int label;
    final /* synthetic */ Stripe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe$onPaymentResult$1(Stripe stripe, Intent intent, Continuation<? super Stripe$onPaymentResult$1> continuation) {
        super(1, continuation);
        this.this$0 = stripe;
        this.$data = intent;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Stripe$onPaymentResult$1(this.this$0, this.$data, continuation);
    }

    public final Object invoke(Continuation<? super PaymentIntentResult> continuation) {
        return ((Stripe$onPaymentResult$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getPaymentController$payments_core_release().getPaymentIntentResult(this.$data, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}

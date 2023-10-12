package com.stripe.android;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/model/PaymentMethod;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.Stripe$createPaymentMethod$1", f = "Stripe.kt", i = {}, l = {809}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Stripe.kt */
final class Stripe$createPaymentMethod$1 extends SuspendLambda implements Function1<Continuation<? super PaymentMethod>, Object> {
    final /* synthetic */ String $idempotencyKey;
    final /* synthetic */ PaymentMethodCreateParams $paymentMethodCreateParams;
    final /* synthetic */ String $stripeAccountId;
    int label;
    final /* synthetic */ Stripe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe$createPaymentMethod$1(Stripe stripe, PaymentMethodCreateParams paymentMethodCreateParams, String str, String str2, Continuation<? super Stripe$createPaymentMethod$1> continuation) {
        super(1, continuation);
        this.this$0 = stripe;
        this.$paymentMethodCreateParams = paymentMethodCreateParams;
        this.$stripeAccountId = str;
        this.$idempotencyKey = str2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Stripe$createPaymentMethod$1(this.this$0, this.$paymentMethodCreateParams, this.$stripeAccountId, this.$idempotencyKey, continuation);
    }

    public final Object invoke(Continuation<? super PaymentMethod> continuation) {
        return ((Stripe$createPaymentMethod$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getStripeRepository$payments_core_release().createPaymentMethod(this.$paymentMethodCreateParams, new ApiRequest.Options(this.this$0.getPublishableKey$payments_core_release(), this.$stripeAccountId, this.$idempotencyKey), this);
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

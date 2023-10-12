package com.stripe.android;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.PaymentIntent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/model/PaymentIntent;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.Stripe$verifyPaymentIntentWithMicrodeposits$2", f = "Stripe.kt", i = {}, l = {1704}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Stripe.kt */
final class Stripe$verifyPaymentIntentWithMicrodeposits$2 extends SuspendLambda implements Function1<Continuation<? super PaymentIntent>, Object> {
    final /* synthetic */ String $clientSecret;
    final /* synthetic */ String $descriptorCode;
    int label;
    final /* synthetic */ Stripe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe$verifyPaymentIntentWithMicrodeposits$2(Stripe stripe, String str, String str2, Continuation<? super Stripe$verifyPaymentIntentWithMicrodeposits$2> continuation) {
        super(1, continuation);
        this.this$0 = stripe;
        this.$clientSecret = str;
        this.$descriptorCode = str2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Stripe$verifyPaymentIntentWithMicrodeposits$2(this.this$0, this.$clientSecret, this.$descriptorCode, continuation);
    }

    public final Object invoke(Continuation<? super PaymentIntent> continuation) {
        return ((Stripe$verifyPaymentIntentWithMicrodeposits$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getStripeRepository$payments_core_release().verifyPaymentIntentWithMicrodeposits(this.$clientSecret, this.$descriptorCode, new ApiRequest.Options(this.this$0.getPublishableKey$payments_core_release(), this.this$0.getStripeAccountId$payments_core_release(), (String) null, 4, (DefaultConstructorMarker) null), this);
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

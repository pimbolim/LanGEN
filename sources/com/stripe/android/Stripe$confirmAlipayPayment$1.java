package com.stripe.android;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/PaymentIntentResult;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.Stripe$confirmAlipayPayment$1", f = "Stripe.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Stripe.kt */
final class Stripe$confirmAlipayPayment$1 extends SuspendLambda implements Function1<Continuation<? super PaymentIntentResult>, Object> {
    final /* synthetic */ AlipayAuthenticator $authenticator;
    final /* synthetic */ ConfirmPaymentIntentParams $confirmPaymentIntentParams;
    final /* synthetic */ String $stripeAccountId;
    int label;
    final /* synthetic */ Stripe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe$confirmAlipayPayment$1(Stripe stripe, ConfirmPaymentIntentParams confirmPaymentIntentParams, AlipayAuthenticator alipayAuthenticator, String str, Continuation<? super Stripe$confirmAlipayPayment$1> continuation) {
        super(1, continuation);
        this.this$0 = stripe;
        this.$confirmPaymentIntentParams = confirmPaymentIntentParams;
        this.$authenticator = alipayAuthenticator;
        this.$stripeAccountId = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Stripe$confirmAlipayPayment$1(this.this$0, this.$confirmPaymentIntentParams, this.$authenticator, this.$stripeAccountId, continuation);
    }

    public final Object invoke(Continuation<? super PaymentIntentResult> continuation) {
        return ((Stripe$confirmAlipayPayment$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getPaymentController$payments_core_release().confirmAndAuthenticateAlipay(this.$confirmPaymentIntentParams, this.$authenticator, new ApiRequest.Options(this.this$0.getPublishableKey$payments_core_release(), this.$stripeAccountId, (String) null, 4, (DefaultConstructorMarker) null), this);
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

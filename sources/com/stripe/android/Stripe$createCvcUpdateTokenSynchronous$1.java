package com.stripe.android;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.CvcTokenParams;
import com.stripe.android.model.Token;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/model/Token;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.Stripe$createCvcUpdateTokenSynchronous$1", f = "Stripe.kt", i = {}, l = {1466}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Stripe.kt */
final class Stripe$createCvcUpdateTokenSynchronous$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Token>, Object> {
    final /* synthetic */ String $cvc;
    final /* synthetic */ String $idempotencyKey;
    final /* synthetic */ String $stripeAccountId;
    int label;
    final /* synthetic */ Stripe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe$createCvcUpdateTokenSynchronous$1(Stripe stripe, String str, String str2, String str3, Continuation<? super Stripe$createCvcUpdateTokenSynchronous$1> continuation) {
        super(2, continuation);
        this.this$0 = stripe;
        this.$cvc = str;
        this.$stripeAccountId = str2;
        this.$idempotencyKey = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Stripe$createCvcUpdateTokenSynchronous$1(this.this$0, this.$cvc, this.$stripeAccountId, this.$idempotencyKey, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Token> continuation) {
        return ((Stripe$createCvcUpdateTokenSynchronous$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getStripeRepository$payments_core_release().createToken$payments_core_release(new CvcTokenParams(this.$cvc), new ApiRequest.Options(this.this$0.getPublishableKey$payments_core_release(), this.$stripeAccountId, this.$idempotencyKey), this);
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

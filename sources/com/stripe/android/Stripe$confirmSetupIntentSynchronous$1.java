package com.stripe.android;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.networking.StripeRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/model/SetupIntent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.Stripe$confirmSetupIntentSynchronous$1", f = "Stripe.kt", i = {}, l = {773}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Stripe.kt */
final class Stripe$confirmSetupIntentSynchronous$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SetupIntent>, Object> {
    final /* synthetic */ ConfirmSetupIntentParams $confirmSetupIntentParams;
    final /* synthetic */ String $idempotencyKey;
    int label;
    final /* synthetic */ Stripe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe$confirmSetupIntentSynchronous$1(Stripe stripe, ConfirmSetupIntentParams confirmSetupIntentParams, String str, Continuation<? super Stripe$confirmSetupIntentSynchronous$1> continuation) {
        super(2, continuation);
        this.this$0 = stripe;
        this.$confirmSetupIntentParams = confirmSetupIntentParams;
        this.$idempotencyKey = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Stripe$confirmSetupIntentSynchronous$1(this.this$0, this.$confirmSetupIntentParams, this.$idempotencyKey, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SetupIntent> continuation) {
        return ((Stripe$confirmSetupIntentSynchronous$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = StripeRepository.confirmSetupIntent$payments_core_release$default(this.this$0.getStripeRepository$payments_core_release(), this.$confirmSetupIntentParams, new ApiRequest.Options(this.this$0.getPublishableKey$payments_core_release(), this.this$0.getStripeAccountId$payments_core_release(), this.$idempotencyKey), (List) null, this, 4, (Object) null);
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

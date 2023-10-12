package com.reactnativestripesdk;

import com.facebook.react.bridge.Promise;
import com.stripe.android.Stripe;
import com.stripe.android.StripeKtxKt;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.Token;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.reactnativestripesdk.StripeSdkModule$createTokenFromCard$1", f = "StripeSdkModule.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StripeSdkModule.kt */
final class StripeSdkModule$createTokenFromCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardParams $cardParams;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ StripeSdkModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeSdkModule$createTokenFromCard$1(StripeSdkModule stripeSdkModule, CardParams cardParams, Promise promise, Continuation<? super StripeSdkModule$createTokenFromCard$1> continuation) {
        super(2, continuation);
        this.this$0 = stripeSdkModule;
        this.$cardParams = cardParams;
        this.$promise = promise;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StripeSdkModule$createTokenFromCard$1(this.this$0, this.$cardParams, this.$promise, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StripeSdkModule$createTokenFromCard$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Stripe access$getStripe$p = this.this$0.stripe;
            if (access$getStripe$p != null) {
                this.label = 1;
                obj = StripeKtxKt.createCardToken$default(access$getStripe$p, this.$cardParams, (String) null, this.this$0.stripeAccountId, this, 2, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("stripe");
                throw null;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                this.$promise.resolve(ErrorsKt.createError(CreateTokenErrorType.Failed.toString(), e.getMessage()));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$promise.resolve(MappersKt.createResult("token", MappersKt.mapFromToken((Token) obj)));
        return Unit.INSTANCE;
    }
}

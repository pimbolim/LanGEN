package com.reactnativestripesdk;

import com.facebook.react.bridge.Promise;
import com.stripe.android.Stripe;
import com.stripe.android.model.PaymentIntent;
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
@DebugMetadata(c = "com.reactnativestripesdk.StripeSdkModule$retrievePaymentIntent$1", f = "StripeSdkModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StripeSdkModule.kt */
final class StripeSdkModule$retrievePaymentIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clientSecret;
    final /* synthetic */ Promise $promise;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StripeSdkModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeSdkModule$retrievePaymentIntent$1(StripeSdkModule stripeSdkModule, String str, Promise promise, Continuation<? super StripeSdkModule$retrievePaymentIntent$1> continuation) {
        super(2, continuation);
        this.this$0 = stripeSdkModule;
        this.$clientSecret = str;
        this.$promise = promise;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StripeSdkModule$retrievePaymentIntent$1 stripeSdkModule$retrievePaymentIntent$1 = new StripeSdkModule$retrievePaymentIntent$1(this.this$0, this.$clientSecret, this.$promise, continuation);
        stripeSdkModule$retrievePaymentIntent$1.L$0 = obj;
        return stripeSdkModule$retrievePaymentIntent$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StripeSdkModule$retrievePaymentIntent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Stripe access$getStripe$p = this.this$0.stripe;
            Unit unit = null;
            if (access$getStripe$p != null) {
                PaymentIntent retrievePaymentIntentSynchronous$default = Stripe.retrievePaymentIntentSynchronous$default(access$getStripe$p, this.$clientSecret, (String) null, 2, (Object) null);
                if (retrievePaymentIntentSynchronous$default != null) {
                    this.$promise.resolve(MappersKt.createResult("paymentIntent", MappersKt.mapFromPaymentIntentResult(retrievePaymentIntentSynchronous$default)));
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    this.$promise.resolve(ErrorsKt.createError(RetrievePaymentIntentErrorType.Unknown.toString(), "Failed to retrieve the PaymentIntent"));
                }
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("stripe");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

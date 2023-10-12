package com.reactnativestripesdk;

import com.facebook.react.bridge.Promise;
import com.stripe.android.Stripe;
import com.stripe.android.StripeKtxKt;
import com.stripe.android.model.BankAccountTokenParams;
import com.stripe.android.model.Token;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.reactnativestripesdk.StripeSdkModule$createTokenFromBankAccount$1", f = "StripeSdkModule.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StripeSdkModule.kt */
final class StripeSdkModule$createTokenFromBankAccount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BankAccountTokenParams $bankAccountParams;
    final /* synthetic */ Promise $promise;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StripeSdkModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeSdkModule$createTokenFromBankAccount$1(StripeSdkModule stripeSdkModule, BankAccountTokenParams bankAccountTokenParams, Promise promise, Continuation<? super StripeSdkModule$createTokenFromBankAccount$1> continuation) {
        super(2, continuation);
        this.this$0 = stripeSdkModule;
        this.$bankAccountParams = bankAccountTokenParams;
        this.$promise = promise;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StripeSdkModule$createTokenFromBankAccount$1 stripeSdkModule$createTokenFromBankAccount$1 = new StripeSdkModule$createTokenFromBankAccount$1(this.this$0, this.$bankAccountParams, this.$promise, continuation);
        stripeSdkModule$createTokenFromBankAccount$1.L$0 = obj;
        return stripeSdkModule$createTokenFromBankAccount$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StripeSdkModule$createTokenFromBankAccount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Promise promise;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            StripeSdkModule stripeSdkModule = this.this$0;
            BankAccountTokenParams bankAccountTokenParams = this.$bankAccountParams;
            Promise promise2 = this.$promise;
            Result.Companion companion = Result.Companion;
            Stripe access$getStripe$p = stripeSdkModule.stripe;
            if (access$getStripe$p != null) {
                String access$getStripeAccountId$p = stripeSdkModule.stripeAccountId;
                this.L$0 = promise2;
                this.label = 1;
                obj = StripeKtxKt.createBankAccountToken(access$getStripe$p, bankAccountTokenParams, (String) null, access$getStripeAccountId$p, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                promise = promise2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("stripe");
                throw null;
            }
        } else if (i == 1) {
            promise = (Promise) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        promise.resolve(MappersKt.createResult("token", MappersKt.mapFromToken((Token) obj)));
        obj2 = Result.m4709constructorimpl(Unit.INSTANCE);
        Promise promise3 = this.$promise;
        Throwable r7 = Result.m4712exceptionOrNullimpl(obj2);
        if (r7 != null) {
            promise3.resolve(ErrorsKt.createError(CreateTokenErrorType.Failed.toString(), r7.getMessage()));
        }
        return Unit.INSTANCE;
    }
}

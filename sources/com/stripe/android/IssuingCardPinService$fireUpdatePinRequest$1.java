package com.stripe.android;

import com.stripe.android.EphemeralOperation;
import com.stripe.android.IssuingCardPinService;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.networking.StripeRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.IssuingCardPinService$fireUpdatePinRequest$1", f = "IssuingCardPinService.kt", i = {}, l = {233, 245, 250}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IssuingCardPinService.kt */
final class IssuingCardPinService$fireUpdatePinRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EphemeralKey $ephemeralKey;
    final /* synthetic */ IssuingCardPinService.IssuingCardPinUpdateListener $listener;
    final /* synthetic */ EphemeralOperation.Issuing.UpdatePin $operation;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IssuingCardPinService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IssuingCardPinService$fireUpdatePinRequest$1(IssuingCardPinService issuingCardPinService, EphemeralOperation.Issuing.UpdatePin updatePin, EphemeralKey ephemeralKey, IssuingCardPinService.IssuingCardPinUpdateListener issuingCardPinUpdateListener, Continuation<? super IssuingCardPinService$fireUpdatePinRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = issuingCardPinService;
        this.$operation = updatePin;
        this.$ephemeralKey = ephemeralKey;
        this.$listener = issuingCardPinUpdateListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IssuingCardPinService$fireUpdatePinRequest$1 issuingCardPinService$fireUpdatePinRequest$1 = new IssuingCardPinService$fireUpdatePinRequest$1(this.this$0, this.$operation, this.$ephemeralKey, this.$listener, continuation);
        issuingCardPinService$fireUpdatePinRequest$1.L$0 = obj;
        return issuingCardPinService$fireUpdatePinRequest$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IssuingCardPinService$fireUpdatePinRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IssuingCardPinService issuingCardPinService = this.this$0;
            EphemeralOperation.Issuing.UpdatePin updatePin = this.$operation;
            EphemeralKey ephemeralKey = this.$ephemeralKey;
            Result.Companion companion = Result.Companion;
            StripeRepository access$getStripeRepository$p = issuingCardPinService.stripeRepository;
            String cardId = updatePin.getCardId();
            String newPin = updatePin.getNewPin();
            String verificationId = updatePin.getVerificationId();
            String userOneTimeCode = updatePin.getUserOneTimeCode();
            ApiRequest.Options options = new ApiRequest.Options(ephemeralKey.getSecret(), issuingCardPinService.stripeAccountId, (String) null, 4, (DefaultConstructorMarker) null);
            this.label = 1;
            if (access$getStripeRepository$p.updateIssuingCardPin$payments_core_release(cardId, newPin, verificationId, userOneTimeCode, options, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
        } else if (i == 2 || i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m4709constructorimpl(Unit.INSTANCE);
        IssuingCardPinService.IssuingCardPinUpdateListener issuingCardPinUpdateListener = this.$listener;
        IssuingCardPinService issuingCardPinService2 = this.this$0;
        Throwable r3 = Result.m4712exceptionOrNullimpl(obj2);
        if (r3 == null) {
            Unit unit = (Unit) obj2;
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new IssuingCardPinService$fireUpdatePinRequest$1$2$1(issuingCardPinUpdateListener, (Continuation<? super IssuingCardPinService$fireUpdatePinRequest$1$2$1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            this.label = 3;
            if (issuingCardPinService2.onUpdatePinError(r3, issuingCardPinUpdateListener, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}

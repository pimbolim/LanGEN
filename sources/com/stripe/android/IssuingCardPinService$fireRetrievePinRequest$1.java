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
@DebugMetadata(c = "com.stripe.android.IssuingCardPinService$fireRetrievePinRequest$1", f = "IssuingCardPinService.kt", i = {}, l = {147, 161, 166}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IssuingCardPinService.kt */
final class IssuingCardPinService$fireRetrievePinRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EphemeralKey $ephemeralKey;
    final /* synthetic */ IssuingCardPinService.IssuingCardPinRetrievalListener $listener;
    final /* synthetic */ EphemeralOperation.Issuing.RetrievePin $operation;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IssuingCardPinService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IssuingCardPinService$fireRetrievePinRequest$1(IssuingCardPinService issuingCardPinService, EphemeralOperation.Issuing.RetrievePin retrievePin, EphemeralKey ephemeralKey, IssuingCardPinService.IssuingCardPinRetrievalListener issuingCardPinRetrievalListener, Continuation<? super IssuingCardPinService$fireRetrievePinRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = issuingCardPinService;
        this.$operation = retrievePin;
        this.$ephemeralKey = ephemeralKey;
        this.$listener = issuingCardPinRetrievalListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IssuingCardPinService$fireRetrievePinRequest$1 issuingCardPinService$fireRetrievePinRequest$1 = new IssuingCardPinService$fireRetrievePinRequest$1(this.this$0, this.$operation, this.$ephemeralKey, this.$listener, continuation);
        issuingCardPinService$fireRetrievePinRequest$1.L$0 = obj;
        return issuingCardPinService$fireRetrievePinRequest$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IssuingCardPinService$fireRetrievePinRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IssuingCardPinService issuingCardPinService = this.this$0;
            EphemeralOperation.Issuing.RetrievePin retrievePin = this.$operation;
            EphemeralKey ephemeralKey = this.$ephemeralKey;
            Result.Companion companion = Result.Companion;
            StripeRepository access$getStripeRepository$p = issuingCardPinService.stripeRepository;
            String cardId = retrievePin.getCardId();
            String verificationId = retrievePin.getVerificationId();
            String userOneTimeCode = retrievePin.getUserOneTimeCode();
            ApiRequest.Options options = new ApiRequest.Options(ephemeralKey.getSecret(), issuingCardPinService.stripeAccountId, (String) null, 4, (DefaultConstructorMarker) null);
            this.label = 1;
            obj3 = access$getStripeRepository$p.retrieveIssuingCardPin$payments_core_release(cardId, verificationId, userOneTimeCode, options, this);
            if (obj3 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
                obj3 = obj;
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
        if (obj3 != null) {
            obj2 = Result.m4709constructorimpl((String) obj3);
            IssuingCardPinService.IssuingCardPinRetrievalListener issuingCardPinRetrievalListener = this.$listener;
            IssuingCardPinService issuingCardPinService2 = this.this$0;
            Throwable r3 = Result.m4712exceptionOrNullimpl(obj2);
            if (r3 == null) {
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new IssuingCardPinService$fireRetrievePinRequest$1$2$1(issuingCardPinRetrievalListener, (String) obj2, (Continuation<? super IssuingCardPinService$fireRetrievePinRequest$1$2$1>) null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 3;
                if (issuingCardPinService2.onRetrievePinError(r3, issuingCardPinRetrievalListener, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("Could not retrieve issuing card PIN.".toString());
    }
}

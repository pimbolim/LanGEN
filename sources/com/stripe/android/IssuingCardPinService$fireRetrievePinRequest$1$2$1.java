package com.stripe.android;

import com.stripe.android.IssuingCardPinService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.IssuingCardPinService$fireRetrievePinRequest$1$2$1", f = "IssuingCardPinService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IssuingCardPinService.kt */
final class IssuingCardPinService$fireRetrievePinRequest$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IssuingCardPinService.IssuingCardPinRetrievalListener $listener;
    final /* synthetic */ String $pin;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IssuingCardPinService$fireRetrievePinRequest$1$2$1(IssuingCardPinService.IssuingCardPinRetrievalListener issuingCardPinRetrievalListener, String str, Continuation<? super IssuingCardPinService$fireRetrievePinRequest$1$2$1> continuation) {
        super(2, continuation);
        this.$listener = issuingCardPinRetrievalListener;
        this.$pin = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IssuingCardPinService$fireRetrievePinRequest$1$2$1(this.$listener, this.$pin, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IssuingCardPinService$fireRetrievePinRequest$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$listener.onIssuingCardPinRetrieved(this.$pin);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

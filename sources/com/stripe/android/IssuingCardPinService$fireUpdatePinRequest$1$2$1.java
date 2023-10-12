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
@DebugMetadata(c = "com.stripe.android.IssuingCardPinService$fireUpdatePinRequest$1$2$1", f = "IssuingCardPinService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IssuingCardPinService.kt */
final class IssuingCardPinService$fireUpdatePinRequest$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IssuingCardPinService.IssuingCardPinUpdateListener $listener;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IssuingCardPinService$fireUpdatePinRequest$1$2$1(IssuingCardPinService.IssuingCardPinUpdateListener issuingCardPinUpdateListener, Continuation<? super IssuingCardPinService$fireUpdatePinRequest$1$2$1> continuation) {
        super(2, continuation);
        this.$listener = issuingCardPinUpdateListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IssuingCardPinService$fireUpdatePinRequest$1$2$1(this.$listener, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IssuingCardPinService$fireUpdatePinRequest$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$listener.onIssuingCardPinUpdated();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

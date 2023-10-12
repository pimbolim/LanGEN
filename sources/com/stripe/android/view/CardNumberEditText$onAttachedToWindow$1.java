package com.stripe.android.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.view.CardNumberEditText$onAttachedToWindow$1", f = "CardNumberEditText.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CardNumberEditText.kt */
final class CardNumberEditText$onAttachedToWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CardNumberEditText this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardNumberEditText$onAttachedToWindow$1(CardNumberEditText cardNumberEditText, Continuation<? super CardNumberEditText$onAttachedToWindow$1> continuation) {
        super(2, continuation);
        this.this$0 = cardNumberEditText;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardNumberEditText$onAttachedToWindow$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CardNumberEditText$onAttachedToWindow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Boolean> loading = this.this$0.cardAccountRangeRepository.getLoading();
            final CardNumberEditText cardNumberEditText = this.this$0;
            this.label = 1;
            if (loading.collect(new FlowCollector<Boolean>() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CardNumberEditText$onAttachedToWindow$1$1$emit$2(cardNumberEditText, z, (Continuation<? super CardNumberEditText$onAttachedToWindow$1$1$emit$2>) null), continuation);
                    return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

package com.stripe.android.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.view.CardNumberEditText$onAttachedToWindow$1$1$emit$2", f = "CardNumberEditText.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CardNumberEditText.kt */
final class CardNumberEditText$onAttachedToWindow$1$1$emit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $it;
    int label;
    final /* synthetic */ CardNumberEditText this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardNumberEditText$onAttachedToWindow$1$1$emit$2(CardNumberEditText cardNumberEditText, boolean z, Continuation<? super CardNumberEditText$onAttachedToWindow$1$1$emit$2> continuation) {
        super(2, continuation);
        this.this$0 = cardNumberEditText;
        this.$it = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardNumberEditText$onAttachedToWindow$1$1$emit$2(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CardNumberEditText$onAttachedToWindow$1$1$emit$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.isLoadingCallback$payments_core_release().invoke(Boxing.boxBoolean(this.$it));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", "", "fieldState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "hasFocus"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.ui.core.elements.CardNumberController$visibleError$1", f = "CardNumberController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CardNumberController.kt */
final class CardNumberController$visibleError$1 extends SuspendLambda implements Function3<TextFieldState, Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    CardNumberController$visibleError$1(Continuation<? super CardNumberController$visibleError$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TextFieldState textFieldState, boolean z, Continuation<? super Boolean> continuation) {
        CardNumberController$visibleError$1 cardNumberController$visibleError$1 = new CardNumberController$visibleError$1(continuation);
        cardNumberController$visibleError$1.L$0 = textFieldState;
        cardNumberController$visibleError$1.Z$0 = z;
        return cardNumberController$visibleError$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((TextFieldState) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super Boolean>) (Continuation) obj3);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((TextFieldState) this.L$0).shouldShowError(this.Z$0));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

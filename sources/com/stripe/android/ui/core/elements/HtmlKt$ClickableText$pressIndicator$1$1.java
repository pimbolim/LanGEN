package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.ui.core.elements.HtmlKt$ClickableText$pressIndicator$1$1", f = "Html.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Html.kt */
final class HtmlKt$ClickableText$pressIndicator$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ Function1<Integer, Unit> $onClick;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HtmlKt$ClickableText$pressIndicator$1$1(MutableState<TextLayoutResult> mutableState, Function1<? super Integer, Unit> function1, Continuation<? super HtmlKt$ClickableText$pressIndicator$1$1> continuation) {
        super(2, continuation);
        this.$layoutResult = mutableState;
        this.$onClick = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HtmlKt$ClickableText$pressIndicator$1$1 htmlKt$ClickableText$pressIndicator$1$1 = new HtmlKt$ClickableText$pressIndicator$1$1(this.$layoutResult, this.$onClick, continuation);
        htmlKt$ClickableText$pressIndicator$1$1.L$0 = obj;
        return htmlKt$ClickableText$pressIndicator$1$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((HtmlKt$ClickableText$pressIndicator$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final MutableState<TextLayoutResult> mutableState = this.$layoutResult;
            final Function1<Integer, Unit> function1 = this.$onClick;
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default((PointerInputScope) this.L$0, (Function1) null, (Function1) null, (Function3) null, new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m4584invokek4lQ0M(((Offset) obj).m1363unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m4584invokek4lQ0M(long j) {
                    TextLayoutResult value = mutableState.getValue();
                    if (value != null) {
                        function1.invoke(Integer.valueOf(value.m3554getOffsetForPositionk4lQ0M(j)));
                    }
                }
            }, this, 7, (Object) null) == coroutine_suspended) {
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

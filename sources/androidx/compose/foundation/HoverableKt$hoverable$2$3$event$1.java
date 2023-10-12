package androidx.compose.foundation;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.HoverableKt$hoverable$2$3$event$1", f = "Hoverable.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Hoverable.kt */
final class HoverableKt$hoverable$2$3$event$1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerEvent>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    HoverableKt$hoverable$2$3$event$1(Continuation<? super HoverableKt$hoverable$2$3$event$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HoverableKt$hoverable$2$3$event$1 hoverableKt$hoverable$2$3$event$1 = new HoverableKt$hoverable$2$3$event$1(continuation);
        hoverableKt$hoverable$2$3$event$1.L$0 = obj;
        return hoverableKt$hoverable$2$3$event$1;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerEvent> continuation) {
        return ((HoverableKt$hoverable$2$3$event$1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default((AwaitPointerEventScope) this.L$0, (PointerEventPass) null, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}

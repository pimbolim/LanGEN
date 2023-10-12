package androidx.compose.foundation.text;

import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.TextController$update$2", f = "CoreText.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoreText.kt */
final class TextController$update$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextController$update$2(TextController textController, Continuation<? super TextController$update$2> continuation) {
        super(2, continuation);
        this.this$0 = textController;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TextController$update$2 textController$update$2 = new TextController$update$2(this.this$0, continuation);
        textController$update$2.L$0 = obj;
        return textController$update$2;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TextController$update$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver((PointerInputScope) this.L$0, this.this$0.getLongPressDragObserver(), this) == coroutine_suspended) {
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

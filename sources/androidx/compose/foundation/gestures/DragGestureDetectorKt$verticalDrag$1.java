package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0}, l = {831}, m = "verticalDrag-jO51t88", n = {"$this$verticalDrag", "onDrag", "pointer$iv$iv"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$verticalDrag$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$verticalDrag$1(Continuation<? super DragGestureDetectorKt$verticalDrag$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m262verticalDragjO51t88((AwaitPointerEventScope) null, 0, (Function1<? super PointerInputChange, Unit>) null, this);
    }
}

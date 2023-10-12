package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0}, l = {756}, m = "awaitLongPressOrCancellation", n = {"initialDown", "longPress"}, s = {"L$0", "L$1"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$awaitLongPressOrCancellation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$awaitLongPressOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.awaitLongPressOrCancellation((PointerInputScope) null, (PointerInputChange) null, this);
    }
}

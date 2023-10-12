package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {831, 869}, m = "awaitHorizontalTouchSlopOrCancellation-jO51t88", n = {"$this$awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "pointer$iv", "touchSlop$iv", "totalPositionChange$iv", "$this$awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "pointer$iv", "dragEvent$iv", "touchSlop$iv", "totalPositionChange$iv"}, s = {"L$0", "L$1", "L$2", "F$0", "F$1", "L$0", "L$1", "L$2", "L$3", "F$0", "F$1"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m250awaitHorizontalTouchSlopOrCancellationjO51t88((AwaitPointerEventScope) null, 0, (Function2<? super PointerInputChange, ? super Float, Unit>) null, this);
    }
}

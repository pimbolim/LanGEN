package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt", f = "ForEachGesture.kt", i = {0}, l = {75}, m = "awaitAllPointersUp", n = {"$this$awaitAllPointersUp"}, s = {"L$0"})
/* compiled from: ForEachGesture.kt */
final class ForEachGestureKt$awaitAllPointersUp$3 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ForEachGestureKt$awaitAllPointersUp$3(Continuation<? super ForEachGestureKt$awaitAllPointersUp$3> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ForEachGestureKt.awaitAllPointersUp((AwaitPointerEventScope) null, (Continuation<? super Unit>) this);
    }
}

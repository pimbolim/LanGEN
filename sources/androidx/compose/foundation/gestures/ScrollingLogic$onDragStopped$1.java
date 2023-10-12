package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic", f = "Scrollable.kt", i = {0, 0, 1, 1, 2, 2}, l = {292, 294, 296}, m = "onDragStopped", n = {"this", "velocity", "this", "available", "this", "velocityLeft"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
/* compiled from: Scrollable.kt */
final class ScrollingLogic$onDragStopped$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLogic$onDragStopped$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$1> continuation) {
        super(continuation);
        this.this$0 = scrollingLogic;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onDragStopped(0.0f, this);
    }
}

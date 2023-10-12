package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016JB\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152'\u0010\u0016\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/foundation/gestures/ScrollDraggableState;", "Landroidx/compose/foundation/gestures/PointerAwareDraggableState;", "Landroidx/compose/foundation/gestures/PointerAwareDragScope;", "scrollLogic", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "(Landroidx/compose/runtime/State;)V", "latestScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "getLatestScrollScope", "()Landroidx/compose/foundation/gestures/ScrollScope;", "setLatestScrollScope", "(Landroidx/compose/foundation/gestures/ScrollScope;)V", "getScrollLogic", "()Landroidx/compose/runtime/State;", "dispatchRawDelta", "", "delta", "", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dragBy", "pixels", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "dragBy-Uv8p0NA", "(FJ)V", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollDraggableState implements PointerAwareDraggableState, PointerAwareDragScope {
    private ScrollScope latestScrollScope = ScrollableKt.NoOpScrollScope;
    private final State<ScrollingLogic> scrollLogic;

    public ScrollDraggableState(State<ScrollingLogic> state) {
        Intrinsics.checkNotNullParameter(state, "scrollLogic");
        this.scrollLogic = state;
    }

    public final State<ScrollingLogic> getScrollLogic() {
        return this.scrollLogic;
    }

    public final ScrollScope getLatestScrollScope() {
        return this.latestScrollScope;
    }

    public final void setLatestScrollScope(ScrollScope scrollScope) {
        Intrinsics.checkNotNullParameter(scrollScope, "<set-?>");
        this.latestScrollScope = scrollScope;
    }

    /* renamed from: dragBy-Uv8p0NA  reason: not valid java name */
    public void m308dragByUv8p0NA(float f, long j) {
        this.scrollLogic.getValue().m313dispatchScrolliGfEq8s(getLatestScrollScope(), f, Offset.m1342boximpl(j), NestedScrollSource.Companion.m2888getDragWNlRxjI());
    }

    public Object drag(MutatePriority mutatePriority, Function2<? super PointerAwareDragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = getScrollLogic().getValue().getScrollableState().scroll(mutatePriority, new ScrollDraggableState$drag$2(this, function2, (Continuation<? super ScrollDraggableState$drag$2>) null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public void dispatchRawDelta(float f) {
        ScrollingLogic value = this.scrollLogic.getValue();
        value.m315performRawScrollMKHz9U(value.m318toOffsettuRUvjQ(f));
    }
}

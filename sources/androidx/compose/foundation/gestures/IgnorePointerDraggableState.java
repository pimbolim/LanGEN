package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016JB\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142'\u0010\u0015\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016¢\u0006\u0002\b\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/foundation/gestures/IgnorePointerDraggableState;", "Landroidx/compose/foundation/gestures/PointerAwareDraggableState;", "Landroidx/compose/foundation/gestures/PointerAwareDragScope;", "origin", "Landroidx/compose/foundation/gestures/DraggableState;", "(Landroidx/compose/foundation/gestures/DraggableState;)V", "latestConsumptionScope", "Landroidx/compose/foundation/gestures/DragScope;", "getLatestConsumptionScope", "()Landroidx/compose/foundation/gestures/DragScope;", "setLatestConsumptionScope", "(Landroidx/compose/foundation/gestures/DragScope;)V", "getOrigin", "()Landroidx/compose/foundation/gestures/DraggableState;", "dispatchRawDelta", "", "delta", "", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dragBy", "pixels", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "dragBy-Uv8p0NA", "(FJ)V", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class IgnorePointerDraggableState implements PointerAwareDraggableState, PointerAwareDragScope {
    private DragScope latestConsumptionScope;
    private final DraggableState origin;

    public IgnorePointerDraggableState(DraggableState draggableState) {
        Intrinsics.checkNotNullParameter(draggableState, "origin");
        this.origin = draggableState;
    }

    public final DraggableState getOrigin() {
        return this.origin;
    }

    public final DragScope getLatestConsumptionScope() {
        return this.latestConsumptionScope;
    }

    public final void setLatestConsumptionScope(DragScope dragScope) {
        this.latestConsumptionScope = dragScope;
    }

    /* renamed from: dragBy-Uv8p0NA  reason: not valid java name */
    public void m276dragByUv8p0NA(float f, long j) {
        DragScope dragScope = this.latestConsumptionScope;
        if (dragScope != null) {
            dragScope.dragBy(f);
        }
    }

    public Object drag(MutatePriority mutatePriority, Function2<? super PointerAwareDragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object drag = getOrigin().drag(mutatePriority, new IgnorePointerDraggableState$drag$2(this, function2, (Continuation<? super IgnorePointerDraggableState$drag$2>) null), continuation);
        return drag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag : Unit.INSTANCE;
    }

    public void dispatchRawDelta(float f) {
        this.origin.dispatchRawDelta(f);
    }
}

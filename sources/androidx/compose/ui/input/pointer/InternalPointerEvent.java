package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B$\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u001b\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aR \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerId;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "(Ljava/util/Map;Landroidx/compose/ui/input/pointer/PointerInputEvent;)V", "getChanges", "()Ljava/util/Map;", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent", "()Landroid/view/MotionEvent;", "getPointerInputEvent", "()Landroidx/compose/ui/input/pointer/PointerInputEvent;", "suppressMovementConsumption", "", "getSuppressMovementConsumption", "()Z", "setSuppressMovementConsumption", "(Z)V", "issuesEnterExitEvent", "pointerId", "issuesEnterExitEvent-0FcD4WY", "(J)Z", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InternalPointerEvent.android.kt */
public final class InternalPointerEvent {
    private final Map<PointerId, PointerInputChange> changes;
    private final PointerInputEvent pointerInputEvent;
    private boolean suppressMovementConsumption;

    public InternalPointerEvent(Map<PointerId, PointerInputChange> map, PointerInputEvent pointerInputEvent2) {
        Intrinsics.checkNotNullParameter(map, "changes");
        Intrinsics.checkNotNullParameter(pointerInputEvent2, "pointerInputEvent");
        this.changes = map;
        this.pointerInputEvent = pointerInputEvent2;
    }

    public final Map<PointerId, PointerInputChange> getChanges() {
        return this.changes;
    }

    public final PointerInputEvent getPointerInputEvent() {
        return this.pointerInputEvent;
    }

    public final MotionEvent getMotionEvent() {
        return this.pointerInputEvent.getMotionEvent();
    }

    /* renamed from: issuesEnterExitEvent-0FcD4WY  reason: not valid java name */
    public final boolean m2912issuesEnterExitEvent0FcD4WY(long j) {
        PointerInputEventData pointerInputEventData;
        List<PointerInputEventData> pointers = this.pointerInputEvent.getPointers();
        int size = pointers.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputEventData = null;
                break;
            }
            int i2 = i + 1;
            pointerInputEventData = pointers.get(i);
            if (PointerId.m2966equalsimpl0(pointerInputEventData.m2991getIdJ3iCeTQ(), j)) {
                break;
            }
            i = i2;
        }
        PointerInputEventData pointerInputEventData2 = pointerInputEventData;
        if (pointerInputEventData2 == null) {
            return false;
        }
        return pointerInputEventData2.getIssuesEnterExit();
    }

    public final boolean getSuppressMovementConsumption() {
        return this.suppressMovementConsumption;
    }

    public final void setSuppressMovementConsumption(boolean z) {
        this.suppressMovementConsumption = z;
    }
}

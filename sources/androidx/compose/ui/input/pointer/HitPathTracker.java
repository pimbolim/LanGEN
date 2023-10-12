package androidx.compose.ui.input.pointer;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui_release", "()Landroidx/compose/ui/input/pointer/NodeParent;", "addHitPath", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputFilters", "", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "addHitPath-KNwqfcY", "(JLjava/util/List;)V", "dispatchChanges", "", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "processCancel", "removeDetachedPointerInputFilters", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HitPathTracker.kt */
public final class HitPathTracker {
    private final NodeParent root = new NodeParent();
    private final LayoutCoordinates rootCoordinates;

    public HitPathTracker(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "rootCoordinates");
        this.rootCoordinates = layoutCoordinates;
    }

    public final NodeParent getRoot$ui_release() {
        return this.root;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: addHitPath-KNwqfcY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2911addHitPathKNwqfcY(long r12, java.util.List<? extends androidx.compose.ui.input.pointer.PointerInputFilter> r14) {
        /*
            r11 = this;
            java.lang.String r0 = "pointerInputFilters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            androidx.compose.ui.input.pointer.NodeParent r0 = r11.root
            int r1 = r14.size()
            r2 = 0
            r3 = 1
            r4 = 0
        L_0x000e:
            if (r4 >= r1) goto L_0x007f
            int r5 = r4 + 1
            java.lang.Object r4 = r14.get(r4)
            androidx.compose.ui.input.pointer.PointerInputFilter r4 = (androidx.compose.ui.input.pointer.PointerInputFilter) r4
            if (r3 == 0) goto L_0x0063
            androidx.compose.runtime.collection.MutableVector r6 = r0.getChildren()
            int r7 = r6.getSize()
            if (r7 <= 0) goto L_0x003d
            java.lang.Object[] r6 = r6.getContent()
            r8 = 0
        L_0x0029:
            r9 = r6[r8]
            r10 = r9
            androidx.compose.ui.input.pointer.Node r10 = (androidx.compose.ui.input.pointer.Node) r10
            androidx.compose.ui.input.pointer.PointerInputFilter r10 = r10.getPointerInputFilter()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r4)
            if (r10 == 0) goto L_0x0039
            goto L_0x003e
        L_0x0039:
            int r8 = r8 + 1
            if (r8 < r7) goto L_0x0029
        L_0x003d:
            r9 = 0
        L_0x003e:
            androidx.compose.ui.input.pointer.Node r9 = (androidx.compose.ui.input.pointer.Node) r9
            if (r9 == 0) goto L_0x0062
            r9.markIsIn()
            androidx.compose.runtime.collection.MutableVector r0 = r9.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r4 = androidx.compose.ui.input.pointer.PointerId.m2963boximpl(r12)
            boolean r0 = r0.contains(r4)
            if (r0 != 0) goto L_0x005e
            androidx.compose.runtime.collection.MutableVector r0 = r9.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r4 = androidx.compose.ui.input.pointer.PointerId.m2963boximpl(r12)
            r0.add(r4)
        L_0x005e:
            r0 = r9
            androidx.compose.ui.input.pointer.NodeParent r0 = (androidx.compose.ui.input.pointer.NodeParent) r0
            goto L_0x007d
        L_0x0062:
            r3 = 0
        L_0x0063:
            androidx.compose.ui.input.pointer.Node r6 = new androidx.compose.ui.input.pointer.Node
            r6.<init>(r4)
            androidx.compose.runtime.collection.MutableVector r4 = r6.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r7 = androidx.compose.ui.input.pointer.PointerId.m2963boximpl(r12)
            r4.add(r7)
            androidx.compose.runtime.collection.MutableVector r0 = r0.getChildren()
            r0.add(r6)
            r0 = r6
            androidx.compose.ui.input.pointer.NodeParent r0 = (androidx.compose.ui.input.pointer.NodeParent) r0
        L_0x007d:
            r4 = r5
            goto L_0x000e
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.HitPathTracker.m2911addHitPathKNwqfcY(long, java.util.List):void");
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z);
    }

    public final boolean dispatchChanges(InternalPointerEvent internalPointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        if (!this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z)) {
            return false;
        }
        boolean dispatchMainEventPass = this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z);
        if (this.root.dispatchFinalEventPass(internalPointerEvent) || dispatchMainEventPass) {
            return true;
        }
        return false;
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        this.root.clear();
    }

    public final void removeDetachedPointerInputFilters() {
        this.root.removeDetachedPointerInputFilters();
    }
}

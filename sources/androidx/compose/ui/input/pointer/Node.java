package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\bJ7\u0010&\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u001a\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "pointerInputFilter", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "(Landroidx/compose/ui/input/pointer/PointerInputFilter;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HitPathTracker.kt */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited = true;
    private boolean isIn = true;
    private PointerEvent pointerEvent;
    private final MutableVector<PointerId> pointerIds = new MutableVector<>(new PointerId[16], 0);
    private final PointerInputFilter pointerInputFilter;
    private final Map<PointerId, PointerInputChange> relevantChanges = new LinkedHashMap();
    private boolean wasIn;

    public Node(PointerInputFilter pointerInputFilter2) {
        Intrinsics.checkNotNullParameter(pointerInputFilter2, "pointerInputFilter");
        this.pointerInputFilter = pointerInputFilter2;
    }

    public final PointerInputFilter getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean buildCache(java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r30, androidx.compose.ui.layout.LayoutCoordinates r31, androidx.compose.ui.input.pointer.InternalPointerEvent r32, boolean r33) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r32
            java.lang.String r4 = "changes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "parentCoordinates"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "internalPointerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            boolean r4 = super.buildCache(r30, r31, r32, r33)
            androidx.compose.ui.input.pointer.PointerInputFilter r5 = r0.pointerInputFilter
            boolean r5 = r5.isAttached$ui_release()
            r6 = 1
            if (r5 != 0) goto L_0x0025
            return r6
        L_0x0025:
            androidx.compose.ui.input.pointer.PointerInputFilter r5 = r0.pointerInputFilter
            androidx.compose.ui.layout.LayoutCoordinates r5 = r5.getLayoutCoordinates$ui_release()
            r0.coordinates = r5
            java.util.Set r5 = r30.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0035:
            boolean r7 = r5.hasNext()
            r8 = 0
            if (r7 == 0) goto L_0x00dd
            java.lang.Object r7 = r5.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            androidx.compose.ui.input.pointer.PointerId r9 = (androidx.compose.ui.input.pointer.PointerId) r9
            long r9 = r9.m2969unboximpl()
            java.lang.Object r7 = r7.getValue()
            r11 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.input.pointer.PointerId> r7 = r0.pointerIds
            androidx.compose.ui.input.pointer.PointerId r12 = androidx.compose.ui.input.pointer.PointerId.m2963boximpl(r9)
            boolean r7 = r7.contains(r12)
            if (r7 == 0) goto L_0x0035
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            java.util.List r12 = r11.getHistorical()
            int r13 = r12.size()
        L_0x006e:
            if (r8 >= r13) goto L_0x009f
            int r14 = r8 + 1
            java.lang.Object r8 = r12.get(r8)
            androidx.compose.ui.input.pointer.HistoricalChange r8 = (androidx.compose.ui.input.pointer.HistoricalChange) r8
            androidx.compose.ui.input.pointer.HistoricalChange r15 = new androidx.compose.ui.input.pointer.HistoricalChange
            long r16 = r8.getUptimeMillis()
            androidx.compose.ui.layout.LayoutCoordinates r6 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r21 = r12
            r22 = r13
            long r12 = r8.m2910getPositionF1C5BW0()
            long r18 = r6.m3141localPositionOfR5De75A(r2, r12)
            r20 = 0
            r6 = r15
            r15.<init>(r16, r18, r20)
            r7.add(r6)
            r8 = r14
            r12 = r21
            r13 = r22
            r6 = 1
            goto L_0x006e
        L_0x009f:
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r6 = r0.relevantChanges
            androidx.compose.ui.input.pointer.PointerId r8 = androidx.compose.ui.input.pointer.PointerId.m2963boximpl(r9)
            androidx.compose.ui.layout.LayoutCoordinates r9 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            long r12 = r11.m2979getPreviousPositionF1C5BW0()
            long r21 = r9.m3141localPositionOfR5De75A(r2, r12)
            androidx.compose.ui.layout.LayoutCoordinates r9 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            long r12 = r11.m2978getPositionF1C5BW0()
            long r16 = r9.m3141localPositionOfR5De75A(r2, r12)
            r12 = 0
            r14 = 0
            r18 = 0
            r19 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 475(0x1db, float:6.66E-43)
            r28 = 0
            r26 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r7 = androidx.compose.ui.input.pointer.PointerInputChange.m2970copy96DQgws$default(r11, r12, r14, r16, r18, r19, r21, r23, r24, r25, r26, r27, r28)
            r6.put(r8, r7)
            r6 = 1
            goto L_0x0035
        L_0x00dd:
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r2 = r0.relevantChanges
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x00f3
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.input.pointer.PointerId> r1 = r0.pointerIds
            r1.clear()
            androidx.compose.runtime.collection.MutableVector r1 = r29.getChildren()
            r1.clear()
            r2 = 1
            return r2
        L_0x00f3:
            r2 = 1
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.input.pointer.PointerId> r5 = r0.pointerIds
            int r5 = r5.getSize()
            int r5 = r5 - r2
            if (r5 < 0) goto L_0x0121
        L_0x00fd:
            int r2 = r5 + -1
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.input.pointer.PointerId> r6 = r0.pointerIds
            java.lang.Object[] r6 = r6.getContent()
            r6 = r6[r5]
            androidx.compose.ui.input.pointer.PointerId r6 = (androidx.compose.ui.input.pointer.PointerId) r6
            long r6 = r6.m2969unboximpl()
            androidx.compose.ui.input.pointer.PointerId r6 = androidx.compose.ui.input.pointer.PointerId.m2963boximpl(r6)
            boolean r6 = r1.containsKey(r6)
            if (r6 != 0) goto L_0x011c
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.input.pointer.PointerId> r6 = r0.pointerIds
            r6.removeAt(r5)
        L_0x011c:
            if (r2 >= 0) goto L_0x011f
            goto L_0x0121
        L_0x011f:
            r5 = r2
            goto L_0x00fd
        L_0x0121:
            androidx.compose.ui.input.pointer.PointerEvent r1 = new androidx.compose.ui.input.pointer.PointerEvent
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r2 = r0.relevantChanges
            java.util.Collection r2 = r2.values()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
            r1.<init>(r2, r3)
            java.util.List r2 = r1.getChanges()
            int r5 = r2.size()
            r6 = 0
        L_0x013b:
            if (r6 >= r5) goto L_0x0153
            int r7 = r6 + 1
            java.lang.Object r6 = r2.get(r6)
            r9 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            long r9 = r9.m2977getIdJ3iCeTQ()
            boolean r9 = r3.m2912issuesEnterExitEvent0FcD4WY(r9)
            if (r9 == 0) goto L_0x0151
            goto L_0x0154
        L_0x0151:
            r6 = r7
            goto L_0x013b
        L_0x0153:
            r6 = 0
        L_0x0154:
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 == 0) goto L_0x0211
            if (r33 != 0) goto L_0x015d
            r0.isIn = r8
            goto L_0x017f
        L_0x015d:
            boolean r2 = r0.isIn
            if (r2 != 0) goto L_0x017f
            boolean r2 = r6.getPressed()
            if (r2 != 0) goto L_0x016d
            boolean r2 = r6.getPreviousPressed()
            if (r2 == 0) goto L_0x017f
        L_0x016d:
            androidx.compose.ui.layout.LayoutCoordinates r2 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            long r2 = r2.m3140getSizeYbymL2g()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.m2927isOutOfBoundsO0kMr_c(r6, r2)
            r3 = 1
            r2 = r2 ^ r3
            r0.isIn = r2
            goto L_0x0180
        L_0x017f:
            r3 = 1
        L_0x0180:
            boolean r2 = r0.isIn
            boolean r5 = r0.wasIn
            if (r2 == r5) goto L_0x01cb
            int r2 = r1.m2925getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m2939getMove7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m2932equalsimpl0(r2, r5)
            if (r2 != 0) goto L_0x01b6
            int r2 = r1.m2925getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m2937getEnter7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m2932equalsimpl0(r2, r5)
            if (r2 != 0) goto L_0x01b6
            int r2 = r1.m2925getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m2938getExit7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m2932equalsimpl0(r2, r5)
            if (r2 == 0) goto L_0x01cb
        L_0x01b6:
            boolean r2 = r0.isIn
            if (r2 == 0) goto L_0x01c1
            androidx.compose.ui.input.pointer.PointerEventType$Companion r2 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r2 = r2.m2937getEnter7fucELk()
            goto L_0x01c7
        L_0x01c1:
            androidx.compose.ui.input.pointer.PointerEventType$Companion r2 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r2 = r2.m2938getExit7fucELk()
        L_0x01c7:
            r1.m2926setTypeEhbLWgg$ui_release(r2)
            goto L_0x0212
        L_0x01cb:
            int r2 = r1.m2925getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m2937getEnter7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m2932equalsimpl0(r2, r5)
            if (r2 == 0) goto L_0x01ed
            boolean r2 = r0.wasIn
            if (r2 == 0) goto L_0x01ed
            boolean r2 = r0.hasExited
            if (r2 != 0) goto L_0x01ed
            androidx.compose.ui.input.pointer.PointerEventType$Companion r2 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r2 = r2.m2939getMove7fucELk()
            r1.m2926setTypeEhbLWgg$ui_release(r2)
            goto L_0x0212
        L_0x01ed:
            int r2 = r1.m2925getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m2938getExit7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m2932equalsimpl0(r2, r5)
            if (r2 == 0) goto L_0x0212
            boolean r2 = r0.isIn
            if (r2 == 0) goto L_0x0212
            boolean r2 = r6.getPressed()
            if (r2 == 0) goto L_0x0212
            androidx.compose.ui.input.pointer.PointerEventType$Companion r2 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r2 = r2.m2939getMove7fucELk()
            r1.m2926setTypeEhbLWgg$ui_release(r2)
            goto L_0x0212
        L_0x0211:
            r3 = 1
        L_0x0212:
            if (r4 != 0) goto L_0x022f
            int r2 = r1.m2925getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r4 = r4.m2939getMove7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m2932equalsimpl0(r2, r4)
            if (r2 == 0) goto L_0x022f
            androidx.compose.ui.input.pointer.PointerEvent r2 = r0.pointerEvent
            boolean r2 = r0.hasPositionChanged(r2, r1)
            if (r2 == 0) goto L_0x022d
            goto L_0x022f
        L_0x022d:
            r6 = 0
            goto L_0x0230
        L_0x022f:
            r6 = 1
        L_0x0230:
            r0.pointerEvent = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.buildCache(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent2, PointerEvent pointerEvent3) {
        if (pointerEvent2 == null || pointerEvent2.getChanges().size() != pointerEvent3.getChanges().size()) {
            return true;
        }
        int size = pointerEvent3.getChanges().size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            if (!Offset.m1350equalsimpl0(pointerEvent2.getChanges().get(i).m2978getPositionF1C5BW0(), pointerEvent3.getChanges().get(i).m2978getPositionF1C5BW0())) {
                return true;
            }
            i = i2;
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> function0) {
        if (this.relevantChanges.isEmpty() || !getPointerInputFilter().isAttached$ui_release()) {
            return false;
        }
        function0.invoke();
        return true;
    }

    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = children.getContent();
            do {
                ((Node) content[i]).dispatchCancel();
                i++;
            } while (i < size);
        }
        this.pointerInputFilter.onCancel();
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent2 = this.pointerEvent;
        if (pointerEvent2 != null) {
            this.wasIn = this.isIn;
            List<PointerInputChange> changes = pointerEvent2.getChanges();
            int size = changes.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                PointerInputChange pointerInputChange = changes.get(i);
                if (!pointerInputChange.getPressed() && (!internalPointerEvent.m2912issuesEnterExitEvent0FcD4WY(pointerInputChange.m2977getIdJ3iCeTQ()) || !this.isIn)) {
                    getPointerIds().remove(PointerId.m2963boximpl(pointerInputChange.m2977getIdJ3iCeTQ()));
                }
                i = i2;
            }
            this.isIn = false;
            this.hasExited = PointerEventType.m2932equalsimpl0(pointerEvent2.m2925getType7fucELk(), PointerEventType.Companion.m2938getExit7fucELk());
        }
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputFilter + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0047, code lost:
        r3 = getChildren();
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchMainEventPass(java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r9, androidx.compose.ui.layout.LayoutCoordinates r10, androidx.compose.ui.input.pointer.InternalPointerEvent r11, boolean r12) {
        /*
            r8 = this;
            java.lang.String r0 = "changes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r9 = "parentCoordinates"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r9)
            java.lang.String r9 = "internalPointerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r9)
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r9 = r8.relevantChanges
            boolean r9 = r9.isEmpty()
            r10 = 1
            r0 = 0
            if (r9 == 0) goto L_0x001b
        L_0x0019:
            r10 = 0
            goto L_0x0079
        L_0x001b:
            androidx.compose.ui.input.pointer.PointerInputFilter r9 = r8.getPointerInputFilter()
            boolean r9 = r9.isAttached$ui_release()
            if (r9 != 0) goto L_0x0026
            goto L_0x0019
        L_0x0026:
            androidx.compose.ui.input.pointer.PointerEvent r9 = r8.pointerEvent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            androidx.compose.ui.layout.LayoutCoordinates r1 = r8.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            long r1 = r1.m3140getSizeYbymL2g()
            androidx.compose.ui.input.pointer.PointerInputFilter r3 = r8.getPointerInputFilter()
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            r3.m2999onPointerEventH0pRuoY(r9, r4, r1)
            androidx.compose.ui.input.pointer.PointerInputFilter r3 = r8.getPointerInputFilter()
            boolean r3 = r3.isAttached$ui_release()
            if (r3 == 0) goto L_0x0066
            androidx.compose.runtime.collection.MutableVector r3 = r8.getChildren()
            int r4 = r3.getSize()
            if (r4 <= 0) goto L_0x0066
            java.lang.Object[] r3 = r3.getContent()
        L_0x0055:
            r5 = r3[r0]
            androidx.compose.ui.input.pointer.Node r5 = (androidx.compose.ui.input.pointer.Node) r5
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r6 = r8.relevantChanges
            androidx.compose.ui.layout.LayoutCoordinates r7 = r8.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r5.dispatchMainEventPass(r6, r7, r11, r12)
            int r0 = r0 + r10
            if (r0 < r4) goto L_0x0055
        L_0x0066:
            androidx.compose.ui.input.pointer.PointerInputFilter r11 = r8.getPointerInputFilter()
            boolean r11 = r11.isAttached$ui_release()
            if (r11 == 0) goto L_0x0079
            androidx.compose.ui.input.pointer.PointerInputFilter r11 = r8.getPointerInputFilter()
            androidx.compose.ui.input.pointer.PointerEventPass r12 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r11.m2999onPointerEventH0pRuoY(r9, r12, r1)
        L_0x0079:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
        r0 = getChildren();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchFinalEventPass(androidx.compose.ui.input.pointer.InternalPointerEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "internalPointerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r0 = r7.relevantChanges
            boolean r0 = r0.isEmpty()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0011
        L_0x000f:
            r1 = 0
            goto L_0x0055
        L_0x0011:
            androidx.compose.ui.input.pointer.PointerInputFilter r0 = r7.getPointerInputFilter()
            boolean r0 = r0.isAttached$ui_release()
            if (r0 != 0) goto L_0x001c
            goto L_0x000f
        L_0x001c:
            androidx.compose.ui.input.pointer.PointerEvent r0 = r7.pointerEvent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.layout.LayoutCoordinates r3 = r7.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            long r3 = r3.m3140getSizeYbymL2g()
            androidx.compose.ui.input.pointer.PointerInputFilter r5 = r7.getPointerInputFilter()
            androidx.compose.ui.input.pointer.PointerEventPass r6 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5.m2999onPointerEventH0pRuoY(r0, r6, r3)
            androidx.compose.ui.input.pointer.PointerInputFilter r0 = r7.getPointerInputFilter()
            boolean r0 = r0.isAttached$ui_release()
            if (r0 == 0) goto L_0x0055
            androidx.compose.runtime.collection.MutableVector r0 = r7.getChildren()
            int r3 = r0.getSize()
            if (r3 <= 0) goto L_0x0055
            java.lang.Object[] r0 = r0.getContent()
        L_0x004b:
            r4 = r0[r2]
            androidx.compose.ui.input.pointer.Node r4 = (androidx.compose.ui.input.pointer.Node) r4
            r4.dispatchFinalEventPass(r8)
            int r2 = r2 + r1
            if (r2 < r3) goto L_0x004b
        L_0x0055:
            r7.cleanUpHits(r8)
            r7.clearCache()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchFinalEventPass(androidx.compose.ui.input.pointer.InternalPointerEvent):boolean");
    }
}

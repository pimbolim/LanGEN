package androidx.compose.ui.input.pointer;

import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ(\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0010J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010(\u001a\u00020\u001f*\u00020\u00152\u0006\u0010!\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "()V", "canHover", "Landroid/util/SparseBooleanArray;", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui_release$annotations", "getMotionEventToComposePointerIdMap$ui_release", "()Landroid/util/SparseLongArray;", "nextId", "", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousSource", "", "previousToolType", "addFreshIds", "", "motionEvent", "Landroid/view/MotionEvent;", "clearOnDeviceChange", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui_release", "createPointerInputEventData", "index", "pressed", "", "endStream", "pointerId", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "removeStaleIds", "hasPointerId", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MotionEventAdapter.android.kt */
public final class MotionEventAdapter {
    private final SparseBooleanArray canHover = new SparseBooleanArray();
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private long nextId;
    private final List<PointerInputEventData> pointers = new ArrayList();
    private int previousSource = -1;
    private int previousToolType = -1;

    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui_release$annotations() {
    }

    public final SparseLongArray getMotionEventToComposePointerIdMap$ui_release() {
        return this.motionEventToComposePointerIdMap;
    }

    public final PointerInputEvent convertToPointerInputEvent$ui_release(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int i;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        Intrinsics.checkNotNullParameter(positionCalculator, "positionCalculator");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3) {
            this.motionEventToComposePointerIdMap.clear();
            this.canHover.clear();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean z = actionMasked == 10 || actionMasked == 7 || actionMasked == 9;
        boolean z2 = actionMasked == 8;
        if (z) {
            this.canHover.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        if (actionMasked != 1) {
            i = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            i = 0;
        }
        this.pointers.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i2 = 0;
        while (i2 < pointerCount) {
            int i3 = i2 + 1;
            this.pointers.add(createPointerInputEventData(positionCalculator, motionEvent, i2, !z && i2 != i && (!z2 || motionEvent.getButtonState() != 0)));
            i2 = i3;
        }
        removeStaleIds(motionEvent);
        return new PointerInputEvent(motionEvent.getEventTime(), this.pointers, motionEvent);
    }

    public final void endStream(int i) {
        this.canHover.delete(i);
        this.motionEventToComposePointerIdMap.delete(i);
    }

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            int pointerId = motionEvent.getPointerId(actionIndex);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                long j = this.nextId;
                this.nextId = 1 + j;
                sparseLongArray.put(pointerId, j);
                if (motionEvent.getToolType(actionIndex) == 3) {
                    this.canHover.put(pointerId, true);
                }
            }
        } else if (actionMasked == 9) {
            int pointerId2 = motionEvent.getPointerId(0);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
                SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
                long j2 = this.nextId;
                this.nextId = 1 + j2;
                sparseLongArray2.put(pointerId2, j2);
            }
        }
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int size;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.canHover.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.canHover.delete(pointerId);
            }
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount() && (size = this.motionEventToComposePointerIdMap.size() - 1) >= 0) {
            while (true) {
                int i = size - 1;
                int keyAt = this.motionEventToComposePointerIdMap.keyAt(size);
                if (!hasPointerId(motionEvent, keyAt)) {
                    this.motionEventToComposePointerIdMap.removeAt(size);
                    this.canHover.delete(keyAt);
                }
                if (i >= 0) {
                    size = i;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean hasPointerId(MotionEvent motionEvent, int i) {
        int pointerCount = motionEvent.getPointerCount();
        int i2 = 0;
        while (i2 < pointerCount) {
            int i3 = i2 + 1;
            if (motionEvent.getPointerId(i2) == i) {
                return true;
            }
            i2 = i3;
        }
        return false;
    }

    /* renamed from: getComposePointerId-_I2yYro  reason: not valid java name */
    private final long m2913getComposePointerId_I2yYro(int i) {
        long j;
        int indexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            j = this.motionEventToComposePointerIdMap.valueAt(indexOfKey);
        } else {
            j = this.nextId;
            this.nextId = 1 + j;
            this.motionEventToComposePointerIdMap.put(i, j);
        }
        return PointerId.m2964constructorimpl(j);
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            int toolType = motionEvent.getToolType(0);
            int source = motionEvent.getSource();
            if (toolType != this.previousToolType || source != this.previousSource) {
                this.previousToolType = toolType;
                this.previousSource = source;
                this.canHover.clear();
                this.motionEventToComposePointerIdMap.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.ui.input.pointer.PointerInputEventData createPointerInputEventData(androidx.compose.ui.input.pointer.PositionCalculator r25, android.view.MotionEvent r26, int r27, boolean r28) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            int r4 = r26.getPointerId(r27)
            long r6 = r0.m2913getComposePointerId_I2yYro(r4)
            float r4 = r26.getX(r27)
            float r5 = r26.getY(r27)
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r4, r5)
            if (r3 != 0) goto L_0x0031
            float r4 = r26.getRawX()
            float r5 = r26.getRawY()
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r4, r5)
            long r8 = r1.m3047screenToLocalMKHz9U(r4)
        L_0x002e:
            r10 = r4
            r12 = r8
            goto L_0x0048
        L_0x0031:
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 29
            if (r8 < r9) goto L_0x0042
            androidx.compose.ui.input.pointer.MotionEventHelper r4 = androidx.compose.ui.input.pointer.MotionEventHelper.INSTANCE
            long r4 = r4.m2914toRawOffsetdBAh8RU(r2, r3)
            long r8 = r1.m3047screenToLocalMKHz9U(r4)
            goto L_0x002e
        L_0x0042:
            long r8 = r1.m3046localToScreenMKHz9U(r4)
            r12 = r4
            r10 = r8
        L_0x0048:
            int r1 = r26.getToolType(r27)
            r4 = 1
            if (r1 == 0) goto L_0x007d
            if (r1 == r4) goto L_0x0076
            r5 = 2
            if (r1 == r5) goto L_0x006f
            r5 = 3
            if (r1 == r5) goto L_0x0068
            r5 = 4
            if (r1 == r5) goto L_0x0061
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m3045getUnknownT8wyACA()
            goto L_0x0083
        L_0x0061:
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m3041getEraserT8wyACA()
            goto L_0x0083
        L_0x0068:
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m3042getMouseT8wyACA()
            goto L_0x0083
        L_0x006f:
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m3043getStylusT8wyACA()
            goto L_0x0083
        L_0x0076:
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m3044getTouchT8wyACA()
            goto L_0x0083
        L_0x007d:
            androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r1 = r1.m3045getUnknownT8wyACA()
        L_0x0083:
            r15 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            int r5 = r26.getHistorySize()
            r9 = 0
        L_0x0090:
            if (r9 >= r5) goto L_0x00db
            int r14 = r9 + 1
            float r4 = r2.getHistoricalX(r3, r9)
            float r8 = r2.getHistoricalY(r3, r9)
            boolean r17 = java.lang.Float.isInfinite(r4)
            if (r17 != 0) goto L_0x00ab
            boolean r17 = java.lang.Float.isNaN(r4)
            if (r17 != 0) goto L_0x00ab
            r17 = 1
            goto L_0x00ad
        L_0x00ab:
            r17 = 0
        L_0x00ad:
            if (r17 == 0) goto L_0x00d6
            boolean r17 = java.lang.Float.isInfinite(r8)
            if (r17 != 0) goto L_0x00be
            boolean r17 = java.lang.Float.isNaN(r8)
            if (r17 != 0) goto L_0x00be
            r17 = 1
            goto L_0x00c0
        L_0x00be:
            r17 = 0
        L_0x00c0:
            if (r17 == 0) goto L_0x00d6
            androidx.compose.ui.input.pointer.HistoricalChange r3 = new androidx.compose.ui.input.pointer.HistoricalChange
            long r19 = r2.getHistoricalEventTime(r9)
            long r21 = androidx.compose.ui.geometry.OffsetKt.Offset(r4, r8)
            r23 = 0
            r18 = r3
            r18.<init>(r19, r21, r23)
            r1.add(r3)
        L_0x00d6:
            r3 = r27
            r9 = r14
            r4 = 1
            goto L_0x0090
        L_0x00db:
            int r3 = r26.getActionMasked()
            r4 = 8
            if (r3 != r4) goto L_0x00fa
            r3 = 10
            float r3 = r2.getAxisValue(r3)
            r4 = 9
            float r4 = r2.getAxisValue(r4)
            long r3 = androidx.compose.ui.geometry.OffsetKt.Offset(r3, r4)
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            long r3 = androidx.compose.ui.geometry.Offset.m1360timestuRUvjQ(r3, r5)
            goto L_0x0100
        L_0x00fa:
            androidx.compose.ui.geometry.Offset$Companion r3 = androidx.compose.ui.geometry.Offset.Companion
            long r3 = r3.m1369getZeroF1C5BW0()
        L_0x0100:
            r18 = r3
            android.util.SparseBooleanArray r3 = r0.canHover
            int r4 = r26.getPointerId(r27)
            r5 = 0
            boolean r16 = r3.get(r4, r5)
            androidx.compose.ui.input.pointer.PointerInputEventData r3 = new androidx.compose.ui.input.pointer.PointerInputEventData
            long r8 = r26.getEventTime()
            r20 = 0
            r5 = r3
            r14 = r28
            r17 = r1
            r5.<init>(r6, r8, r10, r12, r14, r15, r16, r17, r18, r20)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.MotionEventAdapter.createPointerInputEventData(androidx.compose.ui.input.pointer.PositionCalculator, android.view.MotionEvent, int, boolean):androidx.compose.ui.input.pointer.PointerInputEventData");
    }
}

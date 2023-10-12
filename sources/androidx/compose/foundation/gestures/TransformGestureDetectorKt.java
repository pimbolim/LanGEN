package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\u0002*\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0006\u001a\u0001\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2`\u0010\u0013\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00100\u0014H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"angle", "", "Landroidx/compose/ui/geometry/Offset;", "angle-k-4lQ0M", "(J)F", "calculateCentroid", "Landroidx/compose/ui/input/pointer/PointerEvent;", "useCurrent", "", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "calculateCentroidSize", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateRotation", "calculateZoom", "detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "onGesture", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "zoom", "rotation", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransformGestureDetector.kt */
public final class TransformGestureDetectorKt {
    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }

    public static final Object detectTransformGestures(PointerInputScope pointerInputScope, boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new TransformGestureDetectorKt$detectTransformGestures$2(z, function4, (Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    public static final float calculateRotation(PointerEvent pointerEvent) {
        PointerEvent pointerEvent2 = pointerEvent;
        Intrinsics.checkNotNullParameter(pointerEvent2, "<this>");
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= size) {
                break;
            }
            int i4 = i + 1;
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i3 = 0;
            }
            i2 += i3;
            i = i4;
        }
        float f = 0.0f;
        if (i2 < 2) {
            return 0.0f;
        }
        long calculateCentroid = calculateCentroid(pointerEvent2, true);
        long calculateCentroid2 = calculateCentroid(pointerEvent2, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        int i5 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i5 < size2) {
            int i6 = i5 + 1;
            PointerInputChange pointerInputChange2 = changes2.get(i5);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long r13 = pointerInputChange2.m2978getPositionF1C5BW0();
                long r2 = Offset.m1357minusMKHz9U(pointerInputChange2.m2979getPreviousPositionF1C5BW0(), calculateCentroid2);
                long r132 = Offset.m1357minusMKHz9U(r13, calculateCentroid);
                float r15 = m322anglek4lQ0M(r132) - m322anglek4lQ0M(r2);
                float r22 = Offset.m1351getDistanceimpl(Offset.m1358plusMKHz9U(r132, r2)) / 2.0f;
                if (r15 > 180.0f) {
                    r15 -= 360.0f;
                } else if (r15 < -180.0f) {
                    r15 += 360.0f;
                }
                f3 += r15 * r22;
                f2 += r22;
            }
            i5 = i6;
            f = 0.0f;
        }
        return (f2 > f ? 1 : (f2 == f ? 0 : -1)) == 0 ? f : f3 / f2;
    }

    /* renamed from: angle-k-4lQ0M  reason: not valid java name */
    private static final float m322anglek4lQ0M(long j) {
        boolean z = true;
        if (Offset.m1353getXimpl(j) == 0.0f) {
            if (Offset.m1354getYimpl(j) != 0.0f) {
                z = false;
            }
            if (z) {
                return 0.0f;
            }
        }
        return ((-((float) Math.atan2((double) Offset.m1353getXimpl(j), (double) Offset.m1354getYimpl(j)))) * 180.0f) / 3.1415927f;
    }

    public static final float calculateZoom(PointerEvent pointerEvent) {
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        boolean z = true;
        float calculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float calculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (calculateCentroidSize == 0.0f) {
            return 1.0f;
        }
        if (calculateCentroidSize2 != 0.0f) {
            z = false;
        }
        if (z) {
            return 1.0f;
        }
        return calculateCentroidSize / calculateCentroidSize2;
    }

    public static final long calculatePan(PointerEvent pointerEvent) {
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        long calculateCentroid = calculateCentroid(pointerEvent, true);
        if (Offset.m1350equalsimpl0(calculateCentroid, Offset.Companion.m1368getUnspecifiedF1C5BW0())) {
            return Offset.Companion.m1369getZeroF1C5BW0();
        }
        return Offset.m1357minusMKHz9U(calculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final float calculateCentroidSize(PointerEvent pointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        long calculateCentroid = calculateCentroid(pointerEvent, z);
        float f = 0.0f;
        if (Offset.m1350equalsimpl0(calculateCentroid, Offset.Companion.m1368getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = i + 1;
            PointerInputChange pointerInputChange = changes.get(i);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                f += Offset.m1351getDistanceimpl(Offset.m1357minusMKHz9U(z ? pointerInputChange.m2978getPositionF1C5BW0() : pointerInputChange.m2979getPreviousPositionF1C5BW0(), calculateCentroid));
                i2++;
            }
            i = i3;
        }
        return f / ((float) i2);
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        long r0 = Offset.Companion.m1369getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = i + 1;
            PointerInputChange pointerInputChange = changes.get(i);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                r0 = Offset.m1358plusMKHz9U(r0, z ? pointerInputChange.m2978getPositionF1C5BW0() : pointerInputChange.m2979getPreviousPositionF1C5BW0());
                i2++;
            }
            i = i3;
        }
        if (i2 == 0) {
            return Offset.Companion.m1368getUnspecifiedF1C5BW0();
        }
        return Offset.m1348divtuRUvjQ(r0, (float) i2);
    }
}

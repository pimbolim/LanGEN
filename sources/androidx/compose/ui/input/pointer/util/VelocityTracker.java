package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.VelocityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "()V", "index", "", "samples", "", "Landroidx/compose/ui/input/pointer/util/PointAtTime;", "[Landroidx/compose/ui/input/pointer/util/PointAtTime;", "addPosition", "", "timeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "()J", "getVelocityEstimate", "Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "resetTracking", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VelocityTracker.kt */
public final class VelocityTracker {
    public static final int $stable = 8;
    private int index;
    private final PointAtTime[] samples;

    public VelocityTracker() {
        PointAtTime[] pointAtTimeArr = new PointAtTime[20];
        for (int i = 0; i < 20; i++) {
            pointAtTimeArr[i] = null;
        }
        this.samples = pointAtTimeArr;
    }

    /* renamed from: addPosition-Uv8p0NA  reason: not valid java name */
    public final void m3095addPositionUv8p0NA(long j, long j2) {
        int i = (this.index + 1) % 20;
        this.index = i;
        this.samples[i] = new PointAtTime(j2, j, (DefaultConstructorMarker) null);
    }

    /* renamed from: calculateVelocity-9UxMQ8M  reason: not valid java name */
    public final long m3096calculateVelocity9UxMQ8M() {
        long r0 = getVelocityEstimate().m3094getPixelsPerSecondF1C5BW0();
        return VelocityKt.Velocity(Offset.m1353getXimpl(r0), Offset.m1354getYimpl(r0));
    }

    public final void resetTracking() {
        ArraysKt.fill$default((Object[]) this.samples, (Object) null, 0, 0, 6, (Object) null);
    }

    private final VelocityEstimate getVelocityEstimate() {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        int i = this.index;
        PointAtTime pointAtTime = this.samples[i];
        if (pointAtTime == null) {
            return VelocityEstimate.Companion.getNone();
        }
        int i2 = 0;
        PointAtTime pointAtTime2 = pointAtTime;
        while (true) {
            PointAtTime pointAtTime3 = this.samples[i];
            if (pointAtTime3 != null) {
                float time = (float) (pointAtTime.getTime() - pointAtTime3.getTime());
                float abs = (float) Math.abs(pointAtTime3.getTime() - pointAtTime2.getTime());
                if (time > 100.0f || abs > 40.0f) {
                    break;
                }
                long r11 = pointAtTime3.m3088getPointF1C5BW0();
                arrayList.add(Float.valueOf(Offset.m1353getXimpl(r11)));
                arrayList2.add(Float.valueOf(Offset.m1354getYimpl(r11)));
                arrayList3.add(Float.valueOf(-time));
                if (i == 0) {
                    i = 20;
                }
                i--;
                i2++;
                if (i2 >= 20) {
                    pointAtTime2 = pointAtTime3;
                    break;
                }
                pointAtTime2 = pointAtTime3;
            } else {
                break;
            }
        }
        if (i2 >= 3) {
            try {
                PolynomialFit polyFitLeastSquares = VelocityTrackerKt.polyFitLeastSquares(arrayList3, arrayList, 2);
                PolynomialFit polyFitLeastSquares2 = VelocityTrackerKt.polyFitLeastSquares(arrayList3, arrayList2, 2);
                float f = (float) 1000;
                return new VelocityEstimate(OffsetKt.Offset(polyFitLeastSquares.getCoefficients().get(1).floatValue() * f, polyFitLeastSquares2.getCoefficients().get(1).floatValue() * f), polyFitLeastSquares.getConfidence() * polyFitLeastSquares2.getConfidence(), pointAtTime.getTime() - pointAtTime2.getTime(), Offset.m1357minusMKHz9U(pointAtTime.m3088getPointF1C5BW0(), pointAtTime2.m3088getPointF1C5BW0()), (DefaultConstructorMarker) null);
            } catch (IllegalArgumentException unused) {
                return VelocityEstimate.Companion.getNone();
            }
        } else {
            return new VelocityEstimate(Offset.Companion.m1369getZeroF1C5BW0(), 1.0f, pointAtTime.getTime() - pointAtTime2.getTime(), Offset.m1357minusMKHz9U(pointAtTime.m3088getPointF1C5BW0(), pointAtTime2.m3088getPointF1C5BW0()), (DefaultConstructorMarker) null);
        }
    }
}

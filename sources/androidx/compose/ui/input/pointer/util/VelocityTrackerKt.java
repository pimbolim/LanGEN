package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerInputChange;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"AssumePointerMoveStoppedMilliseconds", "", "DefaultWeight", "", "HistorySize", "HorizonMilliseconds", "MinSampleSize", "polyFitLeastSquares", "Landroidx/compose/ui/input/pointer/util/PolynomialFit;", "x", "", "y", "degree", "addPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VelocityTracker.kt */
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static final int MinSampleSize = 3;

    public static final void addPointerInputChange(VelocityTracker velocityTracker, PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(velocityTracker, "<this>");
        Intrinsics.checkNotNullParameter(pointerInputChange, "event");
        List<HistoricalChange> historical = pointerInputChange.getHistorical();
        int size = historical.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            HistoricalChange historicalChange = historical.get(i);
            velocityTracker.m3095addPositionUv8p0NA(historicalChange.getUptimeMillis(), historicalChange.m2910getPositionF1C5BW0());
            i = i2;
        }
        velocityTracker.m3095addPositionUv8p0NA(pointerInputChange.getUptimeMillis(), pointerInputChange.m2978getPositionF1C5BW0());
    }

    public static final PolynomialFit polyFitLeastSquares(List<Float> list, List<Float> list2, int i) {
        float f;
        float f2;
        List<Float> list3 = list;
        List<Float> list4 = list2;
        int i2 = i;
        Intrinsics.checkNotNullParameter(list3, "x");
        Intrinsics.checkNotNullParameter(list4, JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE);
        if (i2 < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("x and y must be the same length");
        } else if (!list.isEmpty()) {
            int size = i2 >= list.size() ? list.size() - 1 : i2;
            int i3 = i2 + 1;
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            while (i4 < i3) {
                i4++;
                arrayList.add(Float.valueOf(0.0f));
            }
            List list5 = arrayList;
            int size2 = list.size();
            int i5 = size + 1;
            Matrix matrix = new Matrix(i5, size2);
            int i6 = 0;
            while (true) {
                f = 1.0f;
                if (i6 >= size2) {
                    break;
                }
                int i7 = i6 + 1;
                matrix.set(0, i6, 1.0f);
                for (int i8 = 1; i8 < i5; i8++) {
                    matrix.set(i8, i6, matrix.get(i8 - 1, i6) * list3.get(i6).floatValue());
                }
                i6 = i7;
            }
            Matrix matrix2 = new Matrix(i5, size2);
            Matrix matrix3 = new Matrix(i5, i5);
            int i9 = 0;
            while (i9 < i5) {
                int i10 = i9 + 1;
                for (int i11 = 0; i11 < size2; i11++) {
                    matrix2.set(i9, i11, matrix.get(i9, i11));
                }
                int i12 = 0;
                while (i12 < i9) {
                    int i13 = i12 + 1;
                    float times = matrix2.getRow(i9).times(matrix2.getRow(i12));
                    for (int i14 = 0; i14 < size2; i14++) {
                        matrix2.set(i9, i14, matrix2.get(i9, i14) - (matrix2.get(i12, i14) * times));
                    }
                    i12 = i13;
                }
                float norm = matrix2.getRow(i9).norm();
                if (((double) norm) >= 1.0E-6d) {
                    float f3 = 1.0f / norm;
                    for (int i15 = 0; i15 < size2; i15++) {
                        matrix2.set(i9, i15, matrix2.get(i9, i15) * f3);
                    }
                    int i16 = 0;
                    while (i16 < i5) {
                        int i17 = i16 + 1;
                        if (i16 < i9) {
                            f2 = 0.0f;
                        } else {
                            f2 = matrix2.getRow(i9).times(matrix.getRow(i16));
                        }
                        matrix3.set(i9, i16, f2);
                        i16 = i17;
                    }
                    i9 = i10;
                } else {
                    throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
                }
            }
            Vector vector = new Vector(size2);
            for (int i18 = 0; i18 < size2; i18++) {
                vector.set(i18, list4.get(i18).floatValue() * 1.0f);
            }
            int i19 = i5 - 1;
            if (i19 >= 0) {
                int i20 = i19;
                while (true) {
                    int i21 = i20 - 1;
                    list5.set(i20, Float.valueOf(matrix2.getRow(i20).times(vector)));
                    int i22 = i20 + 1;
                    if (i22 <= i19) {
                        int i23 = i19;
                        while (true) {
                            int i24 = i23 - 1;
                            list5.set(i20, Float.valueOf(((Number) list5.get(i20)).floatValue() - (matrix3.get(i20, i23) * ((Number) list5.get(i23)).floatValue())));
                            if (i23 == i22) {
                                break;
                            }
                            i23 = i24;
                        }
                    }
                    list5.set(i20, Float.valueOf(((Number) list5.get(i20)).floatValue() / matrix3.get(i20, i20)));
                    if (i21 < 0) {
                        break;
                    }
                    i20 = i21;
                }
            }
            float f4 = 0.0f;
            for (int i25 = 0; i25 < size2; i25++) {
                f4 += list4.get(i25).floatValue();
            }
            float f5 = f4 / ((float) size2);
            float f6 = 0.0f;
            int i26 = 0;
            float f7 = 0.0f;
            while (i26 < size2) {
                int i27 = i26 + 1;
                float floatValue = list4.get(i26).floatValue() - ((Number) list5.get(0)).floatValue();
                float f8 = 1.0f;
                for (int i28 = 1; i28 < i5; i28++) {
                    f8 *= list3.get(i26).floatValue();
                    floatValue -= ((Number) list5.get(i28)).floatValue() * f8;
                }
                f6 += floatValue * 1.0f * floatValue;
                float floatValue2 = list4.get(i26).floatValue() - f5;
                f7 += floatValue2 * 1.0f * floatValue2;
                i26 = i27;
            }
            if (f7 > 1.0E-6f) {
                f = 1.0f - (f6 / f7);
            }
            return new PolynomialFit(list5, f);
        } else {
            throw new IllegalArgumentException("At least one point must be provided");
        }
    }
}

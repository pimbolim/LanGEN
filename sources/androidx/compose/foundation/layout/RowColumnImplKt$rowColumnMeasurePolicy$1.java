package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\t\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J/\u0010\u000b\u001a\u00020\f*\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"androidx/compose/foundation/layout/RowColumnImplKt$rowColumnMeasurePolicy$1", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class RowColumnImplKt$rowColumnMeasurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $arrangement;
    final /* synthetic */ float $arrangementSpacing;
    final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ SizeMode $crossAxisSize;
    final /* synthetic */ LayoutOrientation $orientation;

    RowColumnImplKt$rowColumnMeasurePolicy$1(LayoutOrientation layoutOrientation, float f, SizeMode sizeMode, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function5, CrossAxisAlignment crossAxisAlignment) {
        this.$orientation = layoutOrientation;
        this.$arrangementSpacing = f;
        this.$crossAxisSize = sizeMode;
        this.$arrangement = function5;
        this.$crossAxisAlignment = crossAxisAlignment;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m475measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        int i2;
        int i3;
        int i4;
        Integer num;
        int i5;
        int i6;
        int i7;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope2, "$receiver");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        OrientationIndependentConstraints orientationIndependentConstraints = new OrientationIndependentConstraints(j, this.$orientation, (DefaultConstructorMarker) null);
        int r11 = measureScope2.m3822roundToPx0680j_4(this.$arrangementSpacing);
        int size = list.size();
        Placeable[] placeableArr = new Placeable[size];
        int size2 = list.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size2];
        for (int i8 = 0; i8 < size2; i8++) {
            rowColumnParentDataArr[i8] = RowColumnImplKt.getData((IntrinsicMeasurable) list2.get(i8));
        }
        int size3 = list.size();
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        float f = 0.0f;
        int i13 = 0;
        boolean z = false;
        while (i11 < size3) {
            int i14 = i11 + 1;
            Measurable measurable = (Measurable) list2.get(i11);
            RowColumnParentData rowColumnParentData = rowColumnParentDataArr[i11];
            float access$getWeight = RowColumnImplKt.getWeight(rowColumnParentData);
            if (access$getWeight > 0.0f) {
                f += access$getWeight;
                i12++;
                i11 = i14;
            } else {
                int mainAxisMax = orientationIndependentConstraints.getMainAxisMax();
                int i15 = mainAxisMax;
                int i16 = i11;
                int i17 = size3;
                RowColumnParentData[] rowColumnParentDataArr2 = rowColumnParentDataArr;
                Placeable r3 = measurable.m3151measureBRTryo0(OrientationIndependentConstraints.copy$default(orientationIndependentConstraints, 0, mainAxisMax == Integer.MAX_VALUE ? Integer.MAX_VALUE : mainAxisMax - i13, 0, 0, 8, (Object) null).m423toBoxConstraintsOenEA2s(this.$orientation));
                int min = Math.min(r11, (i15 - i13) - RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(r3, this.$orientation));
                i13 += RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(r3, this.$orientation) + min;
                i10 = Math.max(i10, RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(r3, this.$orientation));
                z = z || RowColumnImplKt.isRelative(rowColumnParentData);
                placeableArr[i16] = r3;
                i9 = min;
                i11 = i14;
                size3 = i17;
                rowColumnParentDataArr = rowColumnParentDataArr2;
            }
        }
        int i18 = i10;
        RowColumnParentData[] rowColumnParentDataArr3 = rowColumnParentDataArr;
        if (i12 == 0) {
            i13 -= i9;
            i2 = i18;
            i = 0;
        } else {
            int i19 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i19 <= 0 || orientationIndependentConstraints.getMainAxisMax() == Integer.MAX_VALUE) {
                i5 = orientationIndependentConstraints.getMainAxisMin();
            } else {
                i5 = orientationIndependentConstraints.getMainAxisMax();
            }
            int i20 = r11 * (i12 - 1);
            int i21 = (i5 - i13) - i20;
            float f2 = i19 > 0 ? ((float) i21) / f : 0.0f;
            int i22 = 0;
            int i23 = 0;
            while (i22 < size2) {
                RowColumnParentData rowColumnParentData2 = rowColumnParentDataArr3[i22];
                i22++;
                i23 += MathKt.roundToInt(RowColumnImplKt.getWeight(rowColumnParentData2) * f2);
            }
            int size4 = list.size();
            int i24 = i21 - i23;
            i2 = i18;
            int i25 = 0;
            int i26 = 0;
            while (i25 < size4) {
                int i27 = i25 + 1;
                if (placeableArr[i25] == null) {
                    Measurable measurable2 = (Measurable) list2.get(i25);
                    RowColumnParentData rowColumnParentData3 = rowColumnParentDataArr3[i25];
                    float access$getWeight2 = RowColumnImplKt.getWeight(rowColumnParentData3);
                    if (access$getWeight2 > 0.0f) {
                        int sign = MathKt.getSign(i24);
                        int i28 = i24 - sign;
                        int max = Math.max(0, MathKt.roundToInt(access$getWeight2 * f2) + sign);
                        float f3 = f2;
                        if (!RowColumnImplKt.getFill(rowColumnParentData3) || max == Integer.MAX_VALUE) {
                            i6 = size4;
                            i7 = 0;
                        } else {
                            i7 = max;
                            i6 = size4;
                        }
                        int i29 = i28;
                        Placeable r2 = measurable2.m3151measureBRTryo0(new OrientationIndependentConstraints(i7, max, 0, orientationIndependentConstraints.getCrossAxisMax()).m423toBoxConstraintsOenEA2s(this.$orientation));
                        i26 += RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(r2, this.$orientation);
                        i2 = Math.max(i2, RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(r2, this.$orientation));
                        z = z || RowColumnImplKt.isRelative(rowColumnParentData3);
                        placeableArr[i25] = r2;
                        list2 = list;
                        f2 = f3;
                        i25 = i27;
                        size4 = i6;
                        i24 = i29;
                    } else {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                } else {
                    list2 = list;
                    i25 = i27;
                }
            }
            i = RangesKt.coerceAtMost(i26 + i20, orientationIndependentConstraints.getMainAxisMax() - i13);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        if (z) {
            int i30 = 0;
            i3 = 0;
            while (i30 < size) {
                int i31 = i30 + 1;
                Placeable placeable = placeableArr[i30];
                Intrinsics.checkNotNull(placeable);
                CrossAxisAlignment access$getCrossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(rowColumnParentDataArr3[i30]);
                if (access$getCrossAxisAlignment == null) {
                    num = null;
                } else {
                    num = access$getCrossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable);
                }
                if (num != null) {
                    int i32 = intRef.element;
                    Number number = num;
                    int intValue = number.intValue();
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = 0;
                    }
                    intRef.element = Math.max(i32, intValue);
                    int access$rowColumnMeasurePolicy_TDGSqEk$crossAxisSize = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, this.$orientation);
                    LayoutOrientation layoutOrientation = this.$orientation;
                    int intValue2 = number.intValue();
                    if (intValue2 == Integer.MIN_VALUE) {
                        intValue2 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, layoutOrientation);
                    }
                    i3 = Math.max(i3, access$rowColumnMeasurePolicy_TDGSqEk$crossAxisSize - intValue2);
                }
                i30 = i31;
            }
        } else {
            i3 = 0;
        }
        int max2 = Math.max(i13 + i, orientationIndependentConstraints.getMainAxisMin());
        if (orientationIndependentConstraints.getCrossAxisMax() == Integer.MAX_VALUE || this.$crossAxisSize != SizeMode.Expand) {
            i4 = Math.max(i2, Math.max(orientationIndependentConstraints.getCrossAxisMin(), intRef.element + i3));
        } else {
            i4 = orientationIndependentConstraints.getCrossAxisMax();
        }
        int i33 = i4;
        int i34 = this.$orientation == LayoutOrientation.Horizontal ? max2 : i33;
        int i35 = this.$orientation == LayoutOrientation.Horizontal ? i33 : max2;
        int size5 = list.size();
        int[] iArr = new int[size5];
        for (int i36 = 0; i36 < size5; i36++) {
            iArr[i36] = 0;
        }
        return MeasureScope.DefaultImpls.layout$default(measureScope, i34, i35, (Map) null, new RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4(list, placeableArr, this.$arrangement, max2, measureScope, iArr, this.$orientation, rowColumnParentDataArr3, this.$crossAxisAlignment, i33, intRef), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MinIntrinsicWidthMeasureBlock(this.$orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m3822roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MinIntrinsicHeightMeasureBlock(this.$orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m3822roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MaxIntrinsicWidthMeasureBlock(this.$orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m3822roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return ((Number) RowColumnImplKt.MaxIntrinsicHeightMeasureBlock(this.$orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m3822roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }
}

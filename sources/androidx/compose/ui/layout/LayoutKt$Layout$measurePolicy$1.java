package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Layout.kt */
public final class LayoutKt$Layout$measurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $maxIntrinsicHeightMeasureBlock;
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $maxIntrinsicWidthMeasureBlock;
    final /* synthetic */ Function3<MeasureScope, List<? extends Measurable>, Constraints, MeasureResult> $measureBlock;
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $minIntrinsicHeightMeasureBlock;
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $minIntrinsicWidthMeasureBlock;

    LayoutKt$Layout$measurePolicy$1(Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function32, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function33, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function34, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function35) {
        this.$measureBlock = function3;
        this.$minIntrinsicWidthMeasureBlock = function32;
        this.$minIntrinsicHeightMeasureBlock = function33;
        this.$maxIntrinsicWidthMeasureBlock = function34;
        this.$maxIntrinsicHeightMeasureBlock = function35;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m3145measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$receiver");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$measureBlock.invoke(measureScope, list, Constraints.m3791boximpl(j));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$minIntrinsicWidthMeasureBlock.invoke(intrinsicMeasureScope, list, Integer.valueOf(i)).intValue();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$minIntrinsicHeightMeasureBlock.invoke(intrinsicMeasureScope, list, Integer.valueOf(i)).intValue();
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$maxIntrinsicWidthMeasureBlock.invoke(intrinsicMeasureScope, list, Integer.valueOf(i)).intValue();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$maxIntrinsicHeightMeasureBlock.invoke(intrinsicMeasureScope, list, Integer.valueOf(i)).intValue();
    }
}

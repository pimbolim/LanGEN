package androidx.compose.ui.layout;

import androidx.compose.ui.node.MeasureBlocks;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J&\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J3\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J&\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"androidx/compose/ui/layout/LayoutKt$measureBlocksOf$1", "Landroidx/compose/ui/node/MeasureBlocks;", "maxIntrinsicHeight", "", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "w", "maxIntrinsicWidth", "h", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Layout.kt */
public final class LayoutKt$measureBlocksOf$1 implements MeasureBlocks {
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $maxIntrinsicHeightMeasureBlock;
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $maxIntrinsicWidthMeasureBlock;
    final /* synthetic */ Function3<MeasureScope, List<? extends Measurable>, Constraints, MeasureResult> $measureBlock;
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $minIntrinsicHeightMeasureBlock;
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $minIntrinsicWidthMeasureBlock;

    LayoutKt$measureBlocksOf$1(Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function32, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function33, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function34, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function35) {
        this.$measureBlock = function3;
        this.$minIntrinsicWidthMeasureBlock = function32;
        this.$minIntrinsicHeightMeasureBlock = function33;
        this.$maxIntrinsicWidthMeasureBlock = function34;
        this.$maxIntrinsicHeightMeasureBlock = function35;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m3148measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$measureBlock.invoke(measureScope, list, Constraints.m3791boximpl(j));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$minIntrinsicWidthMeasureBlock.invoke(intrinsicMeasureScope, list, Integer.valueOf(i)).intValue();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$minIntrinsicHeightMeasureBlock.invoke(intrinsicMeasureScope, list, Integer.valueOf(i)).intValue();
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$maxIntrinsicWidthMeasureBlock.invoke(intrinsicMeasureScope, list, Integer.valueOf(i)).intValue();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$maxIntrinsicHeightMeasureBlock.invoke(intrinsicMeasureScope, list, Integer.valueOf(i)).intValue();
    }
}

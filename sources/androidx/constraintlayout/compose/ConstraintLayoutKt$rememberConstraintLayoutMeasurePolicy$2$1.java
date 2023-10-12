package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$2$1 implements MeasurePolicy {
    final /* synthetic */ ConstraintSet $constraintSet;
    final /* synthetic */ Measurer $measurer;
    final /* synthetic */ int $optimizationLevel;

    ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$2$1(Measurer measurer, ConstraintSet constraintSet, int i) {
        this.$measurer = measurer;
        this.$constraintSet = constraintSet;
        this.$optimizationLevel = i;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m4166measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
        Intrinsics.checkNotNullParameter(list, "measurables");
        long r12 = this.$measurer.m4179performMeasureDjhGOtQ(j, measureScope.getLayoutDirection(), this.$constraintSet, list, this.$optimizationLevel, measureScope);
        return MeasureScope.DefaultImpls.layout$default(measureScope, IntSize.m4019getWidthimpl(r12), IntSize.m4018getHeightimpl(r12), (Map) null, new ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$2$1$measure$1(this.$measurer, list), 4, (Object) null);
    }
}

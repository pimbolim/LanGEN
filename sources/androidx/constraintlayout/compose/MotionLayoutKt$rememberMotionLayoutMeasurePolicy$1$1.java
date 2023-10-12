package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
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
/* compiled from: MotionLayout.kt */
final class MotionLayoutKt$rememberMotionLayoutMeasurePolicy$1$1 implements MeasurePolicy {
    final /* synthetic */ ConstraintSet $constraintSetEnd;
    final /* synthetic */ ConstraintSet $constraintSetStart;
    final /* synthetic */ MotionMeasurer $measurer;
    final /* synthetic */ int $optimizationLevel;
    final /* synthetic */ MutableState<Float> $progress;
    final /* synthetic */ Transition $transition;

    MotionLayoutKt$rememberMotionLayoutMeasurePolicy$1$1(MotionMeasurer motionMeasurer, ConstraintSet constraintSet, ConstraintSet constraintSet2, Transition transition, int i, MutableState<Float> mutableState) {
        this.$measurer = motionMeasurer;
        this.$constraintSetStart = constraintSet;
        this.$constraintSetEnd = constraintSet2;
        this.$transition = transition;
        this.$optimizationLevel = i;
        this.$progress = mutableState;
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
    public final MeasureResult m4196measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        List<? extends Measurable> list2 = list;
        MeasureScope measureScope2 = measureScope;
        Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        long r1 = this.$measurer.m4210performInterpolationMeasureOQbXsTc(j, measureScope.getLayoutDirection(), this.$constraintSetStart, this.$constraintSetEnd, this.$transition, list, this.$optimizationLevel, this.$progress.getValue().floatValue(), measureScope);
        return MeasureScope.DefaultImpls.layout$default(measureScope, IntSize.m4019getWidthimpl(r1), IntSize.m4018getHeightimpl(r1), (Map) null, new MotionLayoutKt$rememberMotionLayoutMeasurePolicy$1$1$measure$1(this.$measurer, list2), 4, (Object) null);
    }
}

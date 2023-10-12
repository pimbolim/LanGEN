package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
final class MotionLayoutKt$rememberMotionLayoutMeasurePolicy$1$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Measurable> $measurables;
    final /* synthetic */ MotionMeasurer $measurer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MotionLayoutKt$rememberMotionLayoutMeasurePolicy$1$1$measure$1(MotionMeasurer motionMeasurer, List<? extends Measurable> list) {
        super(1);
        this.$measurer = motionMeasurer;
        this.$measurables = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        this.$measurer.performLayout(placementScope, this.$measurables);
    }
}

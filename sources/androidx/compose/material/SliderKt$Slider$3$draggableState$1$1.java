package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Slider$3$draggableState$1$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ float $maxPx;
    final /* synthetic */ float $minPx;
    final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffset;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$3$draggableState$1$1(MutableState<Float> mutableState, float f, float f2, State<? extends Function1<? super Float, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        super(1);
        this.$rawOffset = mutableState;
        this.$minPx = f;
        this.$maxPx = f2;
        this.$onValueChangeState = state;
        this.$valueRange = closedFloatingPointRange;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        MutableState<Float> mutableState = this.$rawOffset;
        mutableState.setValue(Float.valueOf(RangesKt.coerceIn(mutableState.getValue().floatValue() + f, this.$minPx, this.$maxPx)));
        this.$onValueChangeState.getValue().invoke(Float.valueOf(SliderKt$Slider$3.invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, this.$rawOffset.getValue().floatValue())));
    }
}

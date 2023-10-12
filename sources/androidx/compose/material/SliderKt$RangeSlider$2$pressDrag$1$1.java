package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$2$pressDrag$1$1 extends Lambda implements Function2<Boolean, Float, Unit> {
    final /* synthetic */ float $maxPx;
    final /* synthetic */ float $minPx;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2$pressDrag$1$1(MutableState<Float> mutableState, float f, MutableState<Float> mutableState2, float f2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        super(2);
        this.$rawOffsetStart = mutableState;
        this.$minPx = f;
        this.$rawOffsetEnd = mutableState2;
        this.$maxPx = f2;
        this.$onValueChangeState = state;
        this.$valueRange = closedFloatingPointRange;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, float f) {
        if (z) {
            MutableState<Float> mutableState = this.$rawOffsetStart;
            mutableState.setValue(Float.valueOf(RangesKt.coerceIn(mutableState.getValue().floatValue() + f, this.$minPx, this.$rawOffsetEnd.getValue().floatValue())));
        } else {
            MutableState<Float> mutableState2 = this.$rawOffsetEnd;
            mutableState2.setValue(Float.valueOf(RangesKt.coerceIn(mutableState2.getValue().floatValue() + f, this.$rawOffsetStart.getValue().floatValue(), this.$maxPx)));
        }
        this.$onValueChangeState.getValue().invoke(SliderKt$RangeSlider$2.invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, RangesKt.rangeTo(this.$rawOffsetStart.getValue().floatValue(), this.$rawOffsetEnd.getValue().floatValue())));
    }
}

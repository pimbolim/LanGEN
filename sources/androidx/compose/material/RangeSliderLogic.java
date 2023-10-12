package androidx.compose.material;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\rJ\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000bJ&\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006 "}, d2 = {"Landroidx/compose/material/RangeSliderLogic;", "", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "rawOffsetStart", "Landroidx/compose/runtime/State;", "", "rawOffsetEnd", "onDrag", "Lkotlin/Function2;", "", "", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;)V", "getEndInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getOnDrag", "()Lkotlin/jvm/functions/Function2;", "getRawOffsetEnd", "()Landroidx/compose/runtime/State;", "getRawOffsetStart", "getStartInteractionSource", "activeInteraction", "draggingStart", "captureThumb", "posX", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "shouldCaptureStartThumb", "eventX", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
final class RangeSliderLogic {
    private final MutableInteractionSource endInteractionSource;
    private final Function2<Boolean, Float, Unit> onDrag;
    private final State<Float> rawOffsetEnd;
    private final State<Float> rawOffsetStart;
    private final MutableInteractionSource startInteractionSource;

    public RangeSliderLogic(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, Function2<? super Boolean, ? super Float, Unit> function2) {
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "startInteractionSource");
        Intrinsics.checkNotNullParameter(mutableInteractionSource2, "endInteractionSource");
        Intrinsics.checkNotNullParameter(state, "rawOffsetStart");
        Intrinsics.checkNotNullParameter(state2, "rawOffsetEnd");
        Intrinsics.checkNotNullParameter(function2, "onDrag");
        this.startInteractionSource = mutableInteractionSource;
        this.endInteractionSource = mutableInteractionSource2;
        this.rawOffsetStart = state;
        this.rawOffsetEnd = state2;
        this.onDrag = function2;
    }

    public final MutableInteractionSource getStartInteractionSource() {
        return this.startInteractionSource;
    }

    public final MutableInteractionSource getEndInteractionSource() {
        return this.endInteractionSource;
    }

    public final State<Float> getRawOffsetStart() {
        return this.rawOffsetStart;
    }

    public final State<Float> getRawOffsetEnd() {
        return this.rawOffsetEnd;
    }

    public final Function2<Boolean, Float, Unit> getOnDrag() {
        return this.onDrag;
    }

    public final MutableInteractionSource activeInteraction(boolean z) {
        return z ? this.startInteractionSource : this.endInteractionSource;
    }

    public final boolean shouldCaptureStartThumb(float f) {
        float abs = Math.abs(this.rawOffsetStart.getValue().floatValue() - f);
        float abs2 = Math.abs(this.rawOffsetEnd.getValue().floatValue() - f);
        if (abs2 == abs) {
            if (this.rawOffsetStart.getValue().floatValue() > f) {
                return true;
            }
        } else if (abs < abs2) {
            return true;
        }
        return false;
    }

    public final void captureThumb(boolean z, float f, Interaction interaction, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.onDrag.invoke(Boolean.valueOf(z), Float.valueOf(f - (z ? this.rawOffsetStart : this.rawOffsetEnd).getValue().floatValue()));
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RangeSliderLogic$captureThumb$1(this, z, interaction, (Continuation<? super RangeSliderLogic$captureThumb$1>) null), 3, (Object) null);
    }
}

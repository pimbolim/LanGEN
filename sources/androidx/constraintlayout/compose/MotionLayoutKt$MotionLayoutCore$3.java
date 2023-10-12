package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
public final class MotionLayoutKt$MotionLayoutCore$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<Float> $progressState;
    final /* synthetic */ Ref.FloatRef $usedProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MotionLayoutKt$MotionLayoutCore$3(MutableState<Float> mutableState, Ref.FloatRef floatRef) {
        super(0);
        this.$progressState = mutableState;
        this.$usedProgress = floatRef;
    }

    public final void invoke() {
        this.$progressState.setValue(Float.valueOf(this.$usedProgress.element));
    }
}

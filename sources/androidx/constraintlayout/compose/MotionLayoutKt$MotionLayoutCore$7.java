package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
public final class MotionLayoutKt$MotionLayoutCore$7 extends Lambda implements Function0<Unit> {
    final /* synthetic */ float $progress;
    final /* synthetic */ MutableState<Float> $progressState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MotionLayoutKt$MotionLayoutCore$7(MutableState<Float> mutableState, float f) {
        super(0);
        this.$progressState = mutableState;
        this.$progress = f;
    }

    public final void invoke() {
        this.$progressState.setValue(Float.valueOf(this.$progress));
    }
}

package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
public final class MotionLayoutKt$MotionLayoutCore$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ ConstraintSet $targetConstraintSet;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MotionLayoutKt$MotionLayoutCore$1(Channel<ConstraintSet> channel, ConstraintSet constraintSet) {
        super(0);
        this.$channel = channel;
        this.$targetConstraintSet = constraintSet;
    }

    public final void invoke() {
        this.$channel.m6176trySendJP2dKIU(this.$targetConstraintSet);
    }
}

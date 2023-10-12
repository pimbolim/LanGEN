package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
final class MotionMeasurer$drawDebug$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ BoxScope $this_drawDebug;
    final /* synthetic */ MotionMeasurer $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MotionMeasurer$drawDebug$2(MotionMeasurer motionMeasurer, BoxScope boxScope, int i) {
        super(2);
        this.$tmp0_rcvr = motionMeasurer;
        this.$this_drawDebug = boxScope;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.drawDebug(this.$this_drawDebug, composer, this.$$changed | 1);
    }
}

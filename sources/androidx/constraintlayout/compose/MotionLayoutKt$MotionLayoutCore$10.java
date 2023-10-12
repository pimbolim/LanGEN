package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
public final class MotionLayoutKt$MotionLayoutCore$10 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function3<MotionLayoutScope, Composer, Integer, Unit> $content;
    final /* synthetic */ MotionLayoutScope $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MotionLayoutKt$MotionLayoutCore$10(Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, MotionLayoutScope motionLayoutScope, int i) {
        super(2);
        this.$content = function3;
        this.$scope = motionLayoutScope;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            this.$content.invoke(this.$scope, composer, Integer.valueOf(((this.$$changed >> 21) & 112) | 8));
        } else {
            composer.skipToGroupEnd();
        }
    }
}

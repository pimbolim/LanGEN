package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
public final class ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed$inlined;
    final /* synthetic */ Function2 $content$inlined;
    final /* synthetic */ MotionLayoutScope $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayout$2(MotionLayoutScope motionLayoutScope, int i, Function2 function2, int i2) {
        super(2);
        this.$scope = motionLayoutScope;
        this.$content$inlined = function2;
        this.$$changed$inlined = i2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            this.$content$inlined.invoke(composer, Integer.valueOf((this.$$changed$inlined >> 18) & 14));
        } else {
            composer.skipToGroupEnd();
        }
    }
}

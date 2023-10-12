package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
public final class ConstraintLayoutKt$ConstraintLayout$8 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Measurer $measurer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintLayoutKt$ConstraintLayout$8(Measurer measurer, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$measurer = measurer;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            this.$measurer.createDesignElements(composer, 8);
            this.$content.invoke(composer, Integer.valueOf((this.$$changed >> 18) & 14));
            return;
        }
        composer.skipToGroupEnd();
    }
}

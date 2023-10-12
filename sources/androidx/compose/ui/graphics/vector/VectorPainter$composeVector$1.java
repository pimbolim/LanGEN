package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
final class VectorPainter$composeVector$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function4<Float, Float, Composer, Integer, Unit> $composable;
    final /* synthetic */ VectorPainter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorPainter$composeVector$1(Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, VectorPainter vectorPainter) {
        super(2);
        this.$composable = function4;
        this.this$0 = vectorPainter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C157@5980L55:VectorPainter.kt#huu6hf");
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            this.$composable.invoke(Float.valueOf(this.this$0.vector.getViewportWidth()), Float.valueOf(this.this$0.vector.getViewportHeight()), composer, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}

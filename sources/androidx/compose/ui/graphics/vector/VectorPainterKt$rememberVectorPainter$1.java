package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
final class VectorPainterKt$rememberVectorPainter$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VectorPainter $painter;
    final /* synthetic */ int $tintBlendMode;
    final /* synthetic */ long $tintColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorPainterKt$rememberVectorPainter$1(VectorPainter vectorPainter, long j, int i) {
        super(0);
        this.$painter = vectorPainter;
        this.$tintColor = j;
        this.$tintBlendMode = i;
    }

    public final void invoke() {
        ColorFilter colorFilter;
        VectorPainter vectorPainter = this.$painter;
        if (!Color.m1597equalsimpl0(this.$tintColor, Color.Companion.m1632getUnspecified0d7_KjU())) {
            colorFilter = ColorFilter.Companion.m1640tintxETnrds(this.$tintColor, this.$tintBlendMode);
        } else {
            colorFilter = null;
        }
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter);
    }
}

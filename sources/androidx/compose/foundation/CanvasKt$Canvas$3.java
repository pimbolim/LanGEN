package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Canvas.kt */
final class CanvasKt$Canvas$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ String $contentDescription;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<DrawScope, Unit> $onDraw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CanvasKt$Canvas$3(Modifier modifier, String str, Function1<? super DrawScope, Unit> function1, int i) {
        super(2);
        this.$modifier = modifier;
        this.$contentDescription = str;
        this.$onDraw = function1;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        CanvasKt.Canvas(this.$modifier, this.$contentDescription, this.$onDraw, composer, this.$$changed | 1);
    }
}

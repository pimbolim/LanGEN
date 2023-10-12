package androidx.compose.foundation;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Border.kt */
final class BorderKt$drawRoundRectBorder$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ long $borderSize;
    final /* synthetic */ Stroke $borderStroke;
    final /* synthetic */ Brush $brush;
    final /* synthetic */ long $cornerRadius;
    final /* synthetic */ boolean $fillArea;
    final /* synthetic */ float $halfStroke;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ long $topLeft;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BorderKt$drawRoundRectBorder$1(boolean z, Brush brush, long j, float f, float f2, long j2, long j3, Stroke stroke) {
        super(1);
        this.$fillArea = z;
        this.$brush = brush;
        this.$cornerRadius = j;
        this.$halfStroke = f;
        this.$strokeWidth = f2;
        this.$topLeft = j2;
        this.$borderSize = j3;
        this.$borderStroke = stroke;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        Intrinsics.checkNotNullParameter(contentDrawScope2, "$this$onDrawWithContent");
        contentDrawScope.drawContent();
        if (this.$fillArea) {
            DrawScope.DefaultImpls.m2113drawRoundRectZuiqVtQ$default(contentDrawScope2, this.$brush, 0, 0, this.$cornerRadius, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
            return;
        }
        float r2 = CornerRadius.m1328getXimpl(this.$cornerRadius);
        float f = this.$halfStroke;
        if (r2 < f) {
            float f2 = this.$strokeWidth;
            float r7 = Size.m1422getWidthimpl(contentDrawScope.m2092getSizeNHjbRc()) - this.$strokeWidth;
            float r8 = Size.m1419getHeightimpl(contentDrawScope.m2092getSizeNHjbRc()) - this.$strokeWidth;
            int r9 = ClipOp.Companion.m1584getDifferencertfAjoo();
            Brush brush = this.$brush;
            long j = this.$cornerRadius;
            DrawScope drawScope = contentDrawScope2;
            DrawContext drawContext = drawScope.getDrawContext();
            long r14 = drawContext.m2070getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().m2143clipRectN_I0leg(f2, f2, r7, r8, r9);
            DrawScope.DefaultImpls.m2113drawRoundRectZuiqVtQ$default(drawScope, brush, 0, 0, j, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
            drawContext.getCanvas().restore();
            drawContext.m2071setSizeuvyYCjk(r14);
            return;
        }
        DrawScope.DefaultImpls.m2113drawRoundRectZuiqVtQ$default(contentDrawScope2, this.$brush, this.$topLeft, this.$borderSize, BorderKt.m172shrinkKibmq7A(this.$cornerRadius, f), 0.0f, this.$borderStroke, (ColorFilter) null, 0, 208, (Object) null);
    }
}

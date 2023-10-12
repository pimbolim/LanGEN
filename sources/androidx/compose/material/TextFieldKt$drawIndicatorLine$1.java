package androidx.compose.material;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldKt$drawIndicatorLine$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ float $lineWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKt$drawIndicatorLine$1(float f, long j) {
        super(1);
        this.$lineWidth = f;
        this.$color = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope2, "$this$drawBehind");
        float density = this.$lineWidth * drawScope.getDensity();
        float r1 = Size.m1419getHeightimpl(drawScope.m2092getSizeNHjbRc()) - (density / ((float) 2));
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope2, this.$color, OffsetKt.Offset(0.0f, r1), OffsetKt.Offset(Size.m1422getWidthimpl(drawScope.m2092getSizeNHjbRc()), r1), density, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }
}

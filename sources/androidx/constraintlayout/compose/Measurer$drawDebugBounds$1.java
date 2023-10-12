package androidx.constraintlayout.compose;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class Measurer$drawDebugBounds$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ float $forcedScaleFactor;
    final /* synthetic */ Measurer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Measurer$drawDebugBounds$1(Measurer measurer, float f) {
        super(1);
        this.this$0 = measurer;
        this.$forcedScaleFactor = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float layoutCurrentWidth = ((float) this.this$0.getLayoutCurrentWidth()) * this.$forcedScaleFactor;
        float layoutCurrentHeight = ((float) this.this$0.getLayoutCurrentHeight()) * this.$forcedScaleFactor;
        float r14 = (Size.m1422getWidthimpl(drawScope.m2092getSizeNHjbRc()) - layoutCurrentWidth) / 2.0f;
        float r13 = (Size.m1419getHeightimpl(drawScope.m2092getSizeNHjbRc()) - layoutCurrentHeight) / 2.0f;
        float f = r14 + layoutCurrentWidth;
        DrawScope drawScope2 = drawScope;
        long r3 = Color.Companion.m1633getWhite0d7_KjU();
        float f2 = r14;
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope2, r3, OffsetKt.Offset(r14, r13), OffsetKt.Offset(f, r13), 0.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, (Object) null);
        float f3 = f;
        float f4 = r13;
        float f5 = f4 + layoutCurrentHeight;
        float f6 = f4;
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope2, r3, OffsetKt.Offset(f3, f4), OffsetKt.Offset(f3, f5), 0.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, (Object) null);
        float f7 = f5;
        long Offset = OffsetKt.Offset(f3, f7);
        float f8 = f2;
        float f9 = f7;
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope2, r3, Offset, OffsetKt.Offset(f8, f7), 0.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, (Object) null);
        float f10 = f8;
        float f11 = f6;
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope2, r3, OffsetKt.Offset(f10, f9), OffsetKt.Offset(f10, f11), 0.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, (Object) null);
        float f12 = (float) 1;
        float f13 = f10 + f12;
        float f14 = f11 + f12;
        float f15 = layoutCurrentWidth + f13;
        DrawScope drawScope3 = drawScope;
        long r32 = Color.Companion.m1622getBlack0d7_KjU();
        float f16 = f13;
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope3, r32, OffsetKt.Offset(f13, f14), OffsetKt.Offset(f15, f14), 0.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, (Object) null);
        float f17 = f14;
        float f18 = f17 + layoutCurrentHeight;
        float f19 = f17;
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope3, r32, OffsetKt.Offset(f15, f17), OffsetKt.Offset(f15, f18), 0.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, (Object) null);
        float f20 = f18;
        long Offset2 = OffsetKt.Offset(f15, f20);
        float f21 = f16;
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope3, r32, Offset2, OffsetKt.Offset(f21, f20), 0.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, (Object) null);
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope3, r32, OffsetKt.Offset(f21, f20), OffsetKt.Offset(f21, f19), 0.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, (Object) null);
    }
}

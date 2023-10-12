package androidx.compose.material;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$outlineCutout$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ long $labelSize;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OutlinedTextField.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$outlineCutout$1(long j) {
        super(1);
        this.$labelSize = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        float f;
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
        float r0 = Size.m1422getWidthimpl(this.$labelSize);
        if (r0 > 0.0f) {
            float r1 = contentDrawScope.m3828toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
            float r2 = contentDrawScope.m3828toPx0680j_4(TextFieldImplKt.getTextFieldPadding()) - r1;
            float f2 = (float) 2;
            float f3 = r0 + r2 + (r1 * f2);
            int i = WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()];
            if (i == 1) {
                f = r2;
            } else if (i == 2) {
                f = Size.m1422getWidthimpl(contentDrawScope.m2092getSizeNHjbRc()) - f3;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    f3 = Size.m1422getWidthimpl(contentDrawScope.m2092getSizeNHjbRc()) - r2;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            float f4 = f3;
            float r02 = Size.m1419getHeightimpl(this.$labelSize);
            int r5 = ClipOp.Companion.m1584getDifferencertfAjoo();
            DrawContext drawContext = contentDrawScope.getDrawContext();
            long r7 = drawContext.m2070getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().m2143clipRectN_I0leg(f, (-r02) / f2, f4, r02 / f2, r5);
            contentDrawScope.drawContent();
            drawContext.getCanvas().restore();
            drawContext.m2071setSizeuvyYCjk(r7);
            return;
        }
        contentDrawScope.drawContent();
    }
}

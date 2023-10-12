package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001au\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"canReuse", "", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "canReuse-7_7YC6M", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;J)Z", "canReuseLayout", "other", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextLayoutHelper.kt */
public final class TextLayoutHelperKt {
    /* renamed from: canReuse-7_7YC6M  reason: not valid java name */
    public static final boolean m726canReuse7_7YC6M(TextLayoutResult textLayoutResult, AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, int i2, Density density, LayoutDirection layoutDirection, Font.ResourceLoader resourceLoader, long j) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "$this$canReuse");
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        TextLayoutInput layoutInput = textLayoutResult.getLayoutInput();
        if (!Intrinsics.areEqual((Object) layoutInput.getText(), (Object) annotatedString) || !canReuseLayout(layoutInput.getStyle(), textStyle) || !Intrinsics.areEqual((Object) layoutInput.getPlaceholders(), (Object) list) || layoutInput.getMaxLines() != i || layoutInput.getSoftWrap() != z || !TextOverflow.m3781equalsimpl0(layoutInput.m3551getOverflowgIe3tQ8(), i2) || !Intrinsics.areEqual((Object) layoutInput.getDensity(), (Object) density) || layoutInput.getLayoutDirection() != layoutDirection || !Intrinsics.areEqual((Object) layoutInput.getResourceLoader(), (Object) resourceLoader) || Constraints.m3805getMinWidthimpl(j) != Constraints.m3805getMinWidthimpl(layoutInput.m3550getConstraintsmsEJaDk())) {
            return false;
        }
        if ((z || TextOverflow.m3781equalsimpl0(i2, TextOverflow.Companion.m3789getEllipsisgIe3tQ8())) && Constraints.m3803getMaxWidthimpl(j) != Constraints.m3803getMaxWidthimpl(layoutInput.m3550getConstraintsmsEJaDk())) {
            return false;
        }
        return true;
    }

    public static final boolean canReuseLayout(TextStyle textStyle, TextStyle textStyle2) {
        Intrinsics.checkNotNullParameter(textStyle, "<this>");
        Intrinsics.checkNotNullParameter(textStyle2, "other");
        return textStyle == textStyle2 || (TextUnit.m4037equalsimpl0(textStyle.m3584getFontSizeXSAIIZE(), textStyle2.m3584getFontSizeXSAIIZE()) && Intrinsics.areEqual((Object) textStyle.getFontWeight(), (Object) textStyle2.getFontWeight()) && Intrinsics.areEqual((Object) textStyle.m3585getFontStyle4Lr2A7w(), (Object) textStyle2.m3585getFontStyle4Lr2A7w()) && Intrinsics.areEqual((Object) textStyle.m3586getFontSynthesisZQGJjVo(), (Object) textStyle2.m3586getFontSynthesisZQGJjVo()) && Intrinsics.areEqual((Object) textStyle.getFontFamily(), (Object) textStyle2.getFontFamily()) && Intrinsics.areEqual((Object) textStyle.getFontFeatureSettings(), (Object) textStyle2.getFontFeatureSettings()) && TextUnit.m4037equalsimpl0(textStyle.m3587getLetterSpacingXSAIIZE(), textStyle2.m3587getLetterSpacingXSAIIZE()) && Intrinsics.areEqual((Object) textStyle.m3582getBaselineShift5SSeXJ0(), (Object) textStyle2.m3582getBaselineShift5SSeXJ0()) && Intrinsics.areEqual((Object) textStyle.getTextGeometricTransform(), (Object) textStyle2.getTextGeometricTransform()) && Intrinsics.areEqual((Object) textStyle.getLocaleList(), (Object) textStyle2.getLocaleList()) && Color.m1597equalsimpl0(textStyle.m3581getBackground0d7_KjU(), textStyle2.m3581getBackground0d7_KjU()) && Intrinsics.areEqual((Object) textStyle.m3589getTextAlignbuA522U(), (Object) textStyle2.m3589getTextAlignbuA522U()) && Intrinsics.areEqual((Object) textStyle.m3590getTextDirectionmmuk1to(), (Object) textStyle2.m3590getTextDirectionmmuk1to()) && TextUnit.m4037equalsimpl0(textStyle.m3588getLineHeightXSAIIZE(), textStyle2.m3588getLineHeightXSAIIZE()) && Intrinsics.areEqual((Object) textStyle.getTextIndent(), (Object) textStyle2.getTextIndent()));
    }
}

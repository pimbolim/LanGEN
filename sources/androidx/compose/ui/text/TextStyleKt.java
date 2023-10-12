package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011\u001a'\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "DefaultLineHeight", "lerp", "Landroidx/compose/ui/text/TextStyle;", "start", "stop", "fraction", "", "resolveDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "resolveTextDirection", "Landroidx/compose/ui/text/style/TextDirection;", "layoutDirection", "textDirection", "resolveTextDirection-Yj3eThk", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/style/TextDirection;)I", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextStyle.kt */
public final class TextStyleKt {
    private static final long DefaultBackgroundColor = Color.Companion.m1631getTransparent0d7_KjU();
    private static final long DefaultColor = Color.Companion.m1622getBlack0d7_KjU();
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);
    private static final long DefaultLineHeight = TextUnit.Companion.m4051getUnspecifiedXSAIIZE();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextStyle.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final TextStyle lerp(TextStyle textStyle, TextStyle textStyle2, float f) {
        Intrinsics.checkNotNullParameter(textStyle, ViewProps.START);
        Intrinsics.checkNotNullParameter(textStyle2, "stop");
        return new TextStyle(SpanStyleKt.lerp(textStyle.toSpanStyle(), textStyle2.toSpanStyle(), f), ParagraphStyleKt.lerp(textStyle.toParagraphStyle(), textStyle2.toParagraphStyle(), f));
    }

    public static final TextStyle resolveDefaults(TextStyle textStyle, LayoutDirection layoutDirection) {
        long j;
        LayoutDirection layoutDirection2 = layoutDirection;
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(layoutDirection2, "direction");
        long r3 = textStyle.m3583getColor0d7_KjU();
        boolean z = true;
        if (!(r3 != Color.Companion.m1632getUnspecified0d7_KjU())) {
            r3 = DefaultColor;
        }
        long j2 = r3;
        long r11 = TextUnitKt.m4058isUnspecifiedR2X_6o(textStyle.m3584getFontSizeXSAIIZE()) ? DefaultFontSize : textStyle.m3584getFontSizeXSAIIZE();
        FontWeight fontWeight = textStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle r32 = textStyle.m3585getFontStyle4Lr2A7w();
        FontStyle r14 = FontStyle.m3609boximpl(r32 == null ? FontStyle.Companion.m3617getNormal_LCdwA() : r32.m3615unboximpl());
        FontSynthesis r33 = textStyle.m3586getFontSynthesisZQGJjVo();
        FontSynthesis r15 = FontSynthesis.m3618boximpl(r33 == null ? FontSynthesis.Companion.m3627getAllGVVA2EU() : r33.m3626unboximpl());
        FontFamily fontFamily = textStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = textStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnitKt.m4058isUnspecifiedR2X_6o(textStyle.m3587getLetterSpacingXSAIIZE())) {
            j = DefaultLetterSpacing;
        } else {
            j = textStyle.m3587getLetterSpacingXSAIIZE();
        }
        long j3 = j;
        BaselineShift r34 = textStyle.m3582getBaselineShift5SSeXJ0();
        BaselineShift r20 = BaselineShift.m3735boximpl(r34 == null ? BaselineShift.Companion.m3745getNoney9eOQZs() : r34.m3741unboximpl());
        TextGeometricTransform textGeometricTransform = textStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = textStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long r35 = textStyle.m3581getBackground0d7_KjU();
        if (r35 == Color.Companion.m1632getUnspecified0d7_KjU()) {
            z = false;
        }
        if (!z) {
            r35 = DefaultBackgroundColor;
        }
        long j4 = r35;
        TextDecoration textDecoration = textStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = textStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        TextAlign r1 = textStyle.m3589getTextAlignbuA522U();
        TextAlign r27 = TextAlign.m3749boximpl(r1 == null ? TextAlign.Companion.m3761getStarte0LSkKk() : r1.m3755unboximpl());
        TextDirection r28 = TextDirection.m3762boximpl(m3591resolveTextDirectionYj3eThk(layoutDirection2, textStyle.m3590getTextDirectionmmuk1to()));
        long r29 = TextUnitKt.m4058isUnspecifiedR2X_6o(textStyle.m3588getLineHeightXSAIIZE()) ? DefaultLineHeight : textStyle.m3588getLineHeightXSAIIZE();
        TextIndent textIndent = textStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        return new TextStyle(j2, r11, fontWeight2, r14, r15, fontFamily2, str, j3, r20, textGeometricTransform2, localeList2, j4, textDecoration2, shadow2, r27, r28, r29, textIndent, (DefaultConstructorMarker) null);
    }

    /* renamed from: resolveTextDirection-Yj3eThk  reason: not valid java name */
    public static final int m3591resolveTextDirectionYj3eThk(LayoutDirection layoutDirection, TextDirection textDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (textDirection == null ? false : TextDirection.m3765equalsimpl0(textDirection.m3768unboximpl(), TextDirection.Companion.m3769getContents_7Xco())) {
            int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i == 1) {
                return TextDirection.Companion.m3770getContentOrLtrs_7Xco();
            }
            if (i == 2) {
                return TextDirection.Companion.m3771getContentOrRtls_7Xco();
            }
            throw new NoWhenBranchMatchedException();
        } else if (textDirection != null) {
            return textDirection.m3768unboximpl();
        } else {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                return TextDirection.Companion.m3772getLtrs_7Xco();
            }
            if (i2 == 2) {
                return TextDirection.Companion.m3773getRtls_7Xco();
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}

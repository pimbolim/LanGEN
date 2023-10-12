package androidx.compose.ui.text;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a+\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0006\u0010\t\u001a\u0002H\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\n\u001a-\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "fraction", "", "lerpDiscrete", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerpTextUnitInheritable", "Landroidx/compose/ui/unit/TextUnit;", "t", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpanStyle.kt */
public final class SpanStyleKt {
    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY  reason: not valid java name */
    public static final long m3547lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (TextUnitKt.m4058isUnspecifiedR2X_6o(j) || TextUnitKt.m4058isUnspecifiedR2X_6o(j2)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m4030boximpl(j), TextUnit.m4030boximpl(j2), f)).m4049unboximpl();
        }
        return TextUnitKt.m4060lerpC3pnCVY(j, j2, f);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f) {
        float f2 = f;
        Intrinsics.checkNotNullParameter(spanStyle, ViewProps.START);
        Intrinsics.checkNotNullParameter(spanStyle2, "stop");
        long r9 = ColorKt.m1648lerpjxsXWHM(spanStyle.m3542getColor0d7_KjU(), spanStyle2.m3542getColor0d7_KjU(), f2);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f2);
        long r11 = m3547lerpTextUnitInheritableC3pnCVY(spanStyle.m3543getFontSizeXSAIIZE(), spanStyle2.m3543getFontSizeXSAIIZE(), f2);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight lerp = FontWeightKt.lerp(fontWeight, fontWeight2, f2);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.m3544getFontStyle4Lr2A7w(), spanStyle2.m3544getFontStyle4Lr2A7w(), f2);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.m3545getFontSynthesisZQGJjVo(), spanStyle2.m3545getFontSynthesisZQGJjVo(), f2);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f2);
        long r18 = m3547lerpTextUnitInheritableC3pnCVY(spanStyle.m3546getLetterSpacingXSAIIZE(), spanStyle2.m3546getLetterSpacingXSAIIZE(), f2);
        BaselineShift r1 = spanStyle.m3541getBaselineShift5SSeXJ0();
        float r12 = r1 == null ? BaselineShift.m3736constructorimpl(0.0f) : r1.m3741unboximpl();
        BaselineShift r5 = spanStyle2.m3541getBaselineShift5SSeXJ0();
        float r13 = BaselineShiftKt.m3748lerpjWV1Mfo(r12, r5 == null ? BaselineShift.m3736constructorimpl(0.0f) : r5.m3741unboximpl(), f2);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform lerp2 = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f2);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f2);
        long r23 = ColorKt.m1648lerpjxsXWHM(spanStyle.m3540getBackground0d7_KjU(), spanStyle2.m3540getBackground0d7_KjU(), f2);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f2);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        return new SpanStyle(r9, r11, lerp, fontStyle, fontSynthesis, fontFamily, str, r18, BaselineShift.m3735boximpl(r13), lerp2, localeList, r23, textDecoration, ShadowKt.lerp(shadow, shadow2, f2), (DefaultConstructorMarker) null);
    }
}

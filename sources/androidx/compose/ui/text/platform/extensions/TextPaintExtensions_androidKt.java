package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.platform.TypefaceAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a$\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0003H\u0000¨\u0006\f"}, d2 = {"createTypeface", "Landroid/graphics/Typeface;", "style", "Landroidx/compose/ui/text/SpanStyle;", "typefaceAdapter", "Landroidx/compose/ui/text/platform/TypefaceAdapter;", "applySpanStyle", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextPaintExtensions.android.kt */
public final class TextPaintExtensions_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:46:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.text.SpanStyle applySpanStyle(androidx.compose.ui.text.platform.AndroidTextPaint r24, androidx.compose.ui.text.SpanStyle r25, androidx.compose.ui.text.platform.TypefaceAdapter r26, androidx.compose.ui.unit.Density r27) {
        /*
            r0 = r24
            r1 = r27
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "style"
            r3 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "typefaceAdapter"
            r4 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            java.lang.String r2 = "density"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            long r5 = r25.m3543getFontSizeXSAIIZE()
            long r5 = androidx.compose.ui.unit.TextUnit.m4039getTypeUIouoOA(r5)
            androidx.compose.ui.unit.TextUnitType$Companion r2 = androidx.compose.ui.unit.TextUnitType.Companion
            long r7 = r2.m4073getSpUIouoOA()
            boolean r2 = androidx.compose.ui.unit.TextUnitType.m4068equalsimpl0(r5, r7)
            if (r2 == 0) goto L_0x003e
            long r5 = r25.m3543getFontSizeXSAIIZE()
            float r1 = r1.m3827toPxR2X_6o(r5)
            r0.setTextSize(r1)
            goto L_0x005b
        L_0x003e:
            androidx.compose.ui.unit.TextUnitType$Companion r1 = androidx.compose.ui.unit.TextUnitType.Companion
            long r1 = r1.m4072getEmUIouoOA()
            boolean r1 = androidx.compose.ui.unit.TextUnitType.m4068equalsimpl0(r5, r1)
            if (r1 == 0) goto L_0x005b
            float r1 = r24.getTextSize()
            long r5 = r25.m3543getFontSizeXSAIIZE()
            float r2 = androidx.compose.ui.unit.TextUnit.m4040getValueimpl(r5)
            float r1 = r1 * r2
            r0.setTextSize(r1)
        L_0x005b:
            boolean r1 = hasFontAttributes(r25)
            if (r1 == 0) goto L_0x0068
            android.graphics.Typeface r1 = createTypeface(r25, r26)
            r0.setTypeface(r1)
        L_0x0068:
            androidx.compose.ui.text.intl.LocaleList r1 = r25.getLocaleList()
            r2 = 0
            if (r1 == 0) goto L_0x00af
            androidx.compose.ui.text.intl.LocaleList r1 = r25.getLocaleList()
            androidx.compose.ui.text.intl.LocaleList$Companion r4 = androidx.compose.ui.text.intl.LocaleList.Companion
            androidx.compose.ui.text.intl.LocaleList r4 = r4.getCurrent()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 != 0) goto L_0x00af
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r1 < r4) goto L_0x008f
            androidx.compose.ui.text.platform.extensions.LocaleListHelperMethods r1 = androidx.compose.ui.text.platform.extensions.LocaleListHelperMethods.INSTANCE
            androidx.compose.ui.text.intl.LocaleList r4 = r25.getLocaleList()
            r1.setTextLocales(r0, r4)
            goto L_0x00af
        L_0x008f:
            androidx.compose.ui.text.intl.LocaleList r1 = r25.getLocaleList()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00a0
            androidx.compose.ui.text.intl.Locale$Companion r1 = androidx.compose.ui.text.intl.Locale.Companion
            androidx.compose.ui.text.intl.Locale r1 = r1.getCurrent()
            goto L_0x00a8
        L_0x00a0:
            androidx.compose.ui.text.intl.LocaleList r1 = r25.getLocaleList()
            androidx.compose.ui.text.intl.Locale r1 = r1.get(r2)
        L_0x00a8:
            java.util.Locale r1 = androidx.compose.ui.text.platform.extensions.LocaleExtensions_androidKt.toJavaLocale(r1)
            r0.setTextLocale(r1)
        L_0x00af:
            long r4 = r25.m3546getLetterSpacingXSAIIZE()
            long r4 = androidx.compose.ui.unit.TextUnit.m4039getTypeUIouoOA(r4)
            androidx.compose.ui.unit.TextUnitType$Companion r1 = androidx.compose.ui.unit.TextUnitType.Companion
            long r6 = r1.m4072getEmUIouoOA()
            boolean r1 = androidx.compose.ui.unit.TextUnitType.m4068equalsimpl0(r4, r6)
            if (r1 == 0) goto L_0x00cf
            long r4 = r25.m3546getLetterSpacingXSAIIZE()
            float r1 = androidx.compose.ui.unit.TextUnit.m4040getValueimpl(r4)
            r0.setLetterSpacing(r1)
            goto L_0x00d8
        L_0x00cf:
            androidx.compose.ui.unit.TextUnitType$Companion r1 = androidx.compose.ui.unit.TextUnitType.Companion
            long r6 = r1.m4073getSpUIouoOA()
            androidx.compose.ui.unit.TextUnitType.m4068equalsimpl0(r4, r6)
        L_0x00d8:
            java.lang.String r1 = r25.getFontFeatureSettings()
            if (r1 == 0) goto L_0x00f1
            java.lang.String r1 = r25.getFontFeatureSettings()
            java.lang.String r4 = ""
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 != 0) goto L_0x00f1
            java.lang.String r1 = r25.getFontFeatureSettings()
            r0.setFontFeatureSettings(r1)
        L_0x00f1:
            androidx.compose.ui.text.style.TextGeometricTransform r1 = r25.getTextGeometricTransform()
            if (r1 == 0) goto L_0x0128
            androidx.compose.ui.text.style.TextGeometricTransform r1 = r25.getTextGeometricTransform()
            androidx.compose.ui.text.style.TextGeometricTransform$Companion r4 = androidx.compose.ui.text.style.TextGeometricTransform.Companion
            androidx.compose.ui.text.style.TextGeometricTransform r4 = r4.getNone$ui_text_release()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 != 0) goto L_0x0128
            float r1 = r24.getTextScaleX()
            androidx.compose.ui.text.style.TextGeometricTransform r4 = r25.getTextGeometricTransform()
            float r4 = r4.getScaleX()
            float r1 = r1 * r4
            r0.setTextScaleX(r1)
            float r1 = r24.getTextSkewX()
            androidx.compose.ui.text.style.TextGeometricTransform r4 = r25.getTextGeometricTransform()
            float r4 = r4.getSkewX()
            float r1 = r1 + r4
            r0.setTextSkewX(r1)
        L_0x0128:
            long r4 = r25.m3542getColor0d7_KjU()
            r0.m3708setColor8_81llA(r4)
            androidx.compose.ui.graphics.Shadow r1 = r25.getShadow()
            r0.setShadow(r1)
            androidx.compose.ui.text.style.TextDecoration r1 = r25.getTextDecoration()
            r0.setTextDecoration(r1)
            long r0 = r25.m3546getLetterSpacingXSAIIZE()
            long r0 = androidx.compose.ui.unit.TextUnit.m4039getTypeUIouoOA(r0)
            androidx.compose.ui.unit.TextUnitType$Companion r4 = androidx.compose.ui.unit.TextUnitType.Companion
            long r4 = r4.m4073getSpUIouoOA()
            boolean r0 = androidx.compose.ui.unit.TextUnitType.m4068equalsimpl0(r0, r4)
            if (r0 == 0) goto L_0x0168
            long r0 = r25.m3546getLetterSpacingXSAIIZE()
            float r0 = androidx.compose.ui.unit.TextUnit.m4040getValueimpl(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0160
            r0 = 1
            goto L_0x0161
        L_0x0160:
            r0 = 0
        L_0x0161:
            if (r0 != 0) goto L_0x0168
            long r0 = r25.m3546getLetterSpacingXSAIIZE()
            goto L_0x016e
        L_0x0168:
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r0 = r0.m4051getUnspecifiedXSAIIZE()
        L_0x016e:
            r13 = r0
            long r0 = r25.m3540getBackground0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r4.m1631getTransparent0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m1597equalsimpl0(r0, r4)
            if (r0 == 0) goto L_0x0186
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.Companion
            long r0 = r0.m1632getUnspecified0d7_KjU()
            goto L_0x018a
        L_0x0186:
            long r0 = r25.m3540getBackground0d7_KjU()
        L_0x018a:
            r18 = r0
            androidx.compose.ui.text.style.BaselineShift r0 = r25.m3541getBaselineShift5SSeXJ0()
            androidx.compose.ui.text.style.BaselineShift$Companion r1 = androidx.compose.ui.text.style.BaselineShift.Companion
            float r1 = r1.m3745getNoney9eOQZs()
            if (r0 != 0) goto L_0x0199
            goto L_0x01a1
        L_0x0199:
            float r0 = r0.m3741unboximpl()
            boolean r2 = androidx.compose.ui.text.style.BaselineShift.m3738equalsimpl0(r0, r1)
        L_0x01a1:
            if (r2 == 0) goto L_0x01a7
            r0 = 0
            androidx.compose.ui.text.style.BaselineShift r0 = (androidx.compose.ui.text.style.BaselineShift) r0
            goto L_0x01ab
        L_0x01a7:
            androidx.compose.ui.text.style.BaselineShift r0 = r25.m3541getBaselineShift5SSeXJ0()
        L_0x01ab:
            r15 = r0
            androidx.compose.ui.text.SpanStyle r0 = new androidx.compose.ui.text.SpanStyle
            r3 = r0
            r4 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r17 = 0
            r20 = 0
            r21 = 0
            r22 = 13951(0x367f, float:1.955E-41)
            r23 = 0
            r3.<init>(r4, r6, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r20, r21, r22, r23)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt.applySpanStyle(androidx.compose.ui.text.platform.AndroidTextPaint, androidx.compose.ui.text.SpanStyle, androidx.compose.ui.text.platform.TypefaceAdapter, androidx.compose.ui.unit.Density):androidx.compose.ui.text.SpanStyle");
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "<this>");
        return (spanStyle.getFontFamily() == null && spanStyle.m3544getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) ? false : true;
    }

    private static final Typeface createTypeface(SpanStyle spanStyle, TypefaceAdapter typefaceAdapter) {
        FontFamily fontFamily = spanStyle.getFontFamily();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontStyle r2 = spanStyle.m3544getFontStyle4Lr2A7w();
        int r22 = r2 == null ? FontStyle.Companion.m3617getNormal_LCdwA() : r2.m3615unboximpl();
        FontSynthesis r3 = spanStyle.m3545getFontSynthesisZQGJjVo();
        return typefaceAdapter.m3716createDPcqOEQ(fontFamily, fontWeight, r22, r3 == null ? FontSynthesis.Companion.m3627getAllGVVA2EU() : r3.m3626unboximpl());
    }
}

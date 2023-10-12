package com.stripe.android.ui.core;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001aC\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a!\u0010\u0014\u001a\u00020\u0015*\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0011*\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u000bH\u0007\u001a\u0019\u0010\u001d\u001a\u00020\u001c*\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0011\u0010 \u001a\u00020!*\u00020\"H\u0007¢\u0006\u0002\u0010#\u001a\u0019\u0010$\u001a\u00020%*\u00020\u001a2\u0006\u0010&\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010'\u001a\u0011\u0010(\u001a\u00020)*\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0011\u0010,\u001a\u00020-*\u00020.H\u0007¢\u0006\u0002\u0010/\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"PaymentsTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createTextSpanFromTextStyle", "Landroid/text/SpannableString;", "text", "", "context", "Landroid/content/Context;", "fontSizeDp", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "fontFamily", "", "createTextSpanFromTextStyle-qhTmNto", "(Ljava/lang/String;Landroid/content/Context;FJLjava/lang/Integer;)Landroid/text/SpannableString;", "convertDpToPx", "", "dp", "convertDpToPx-3ABfNKs", "(Landroid/content/Context;F)F", "getPrimaryColor", "Lcom/stripe/android/ui/core/PrimaryButtonModifier;", "isSystemDarkTheme", "", "shouldUseDarkDynamicColor", "shouldUseDarkDynamicColor-8_81llA", "(J)Z", "toComposeColors", "Lcom/stripe/android/ui/core/PaymentsComposeColors;", "Lcom/stripe/android/ui/core/PaymentsColors;", "(Lcom/stripe/android/ui/core/PaymentsColors;Landroidx/compose/runtime/Composer;I)Lcom/stripe/android/ui/core/PaymentsComposeColors;", "toComposeModifier", "Lcom/stripe/android/ui/core/PrimaryButtonModifierCompose;", "isDark", "(Lcom/stripe/android/ui/core/PrimaryButtonModifier;ZLandroidx/compose/runtime/Composer;I)Lcom/stripe/android/ui/core/PrimaryButtonModifierCompose;", "toComposeShapes", "Lcom/stripe/android/ui/core/PaymentsComposeShapes;", "Lcom/stripe/android/ui/core/PaymentsShapes;", "(Lcom/stripe/android/ui/core/PaymentsShapes;Landroidx/compose/runtime/Composer;I)Lcom/stripe/android/ui/core/PaymentsComposeShapes;", "toComposeTypography", "Landroidx/compose/material/Typography;", "Lcom/stripe/android/ui/core/PaymentsTypography;", "(Lcom/stripe/android/ui/core/PaymentsTypography;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/Typography;", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentsTheme.kt */
public final class PaymentsThemeKt {
    public static final PaymentsComposeColors toComposeColors(PaymentsColors paymentsColors, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paymentsColors, "<this>");
        long r3 = paymentsColors.m4481getComponent0d7_KjU();
        long r5 = paymentsColors.m4482getComponentBorder0d7_KjU();
        long r7 = paymentsColors.m4483getComponentDivider0d7_KjU();
        long r15 = paymentsColors.m4485getOnComponent0d7_KjU();
        return new PaymentsComposeColors(r3, r5, r7, paymentsColors.m4489getSubtitle0d7_KjU(), paymentsColors.m4491getTextCursor0d7_KjU(), paymentsColors.m4487getPlaceholderText0d7_KjU(), r15, ColorsKt.m936lightColors2qZNXz8$default(paymentsColors.m4488getPrimary0d7_KjU(), 0, 0, 0, 0, paymentsColors.m4490getSurface0d7_KjU(), paymentsColors.m4484getError0d7_KjU(), 0, 0, 0, paymentsColors.m4486getOnSurface0d7_KjU(), 0, 2974, (Object) null), (DefaultConstructorMarker) null);
    }

    public static final PaymentsComposeShapes toComposeShapes(PaymentsShapes paymentsShapes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paymentsShapes, "<this>");
        return new PaymentsComposeShapes(Dp.m3859constructorimpl(paymentsShapes.getBorderStrokeWidth()), Dp.m3859constructorimpl(paymentsShapes.getBorderStrokeWidthSelected()), Shapes.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 8), RoundedCornerShapeKt.m620RoundedCornerShape0680j_4(Dp.m3859constructorimpl(paymentsShapes.getCornerRadius())), RoundedCornerShapeKt.m620RoundedCornerShape0680j_4(Dp.m3859constructorimpl(paymentsShapes.getCornerRadius())), (CornerBasedShape) null, 4, (Object) null), (DefaultConstructorMarker) null);
    }

    public static final Typography toComposeTypography(PaymentsTypography paymentsTypography, Composer composer, int i) {
        FontFamily fontFamily;
        Intrinsics.checkNotNullParameter(paymentsTypography, "<this>");
        if (paymentsTypography.getFontFamily() != null) {
            fontFamily = FontFamilyKt.FontFamily(FontKt.m3605FontRetOiIg$default(paymentsTypography.getFontFamily().intValue(), (FontWeight) null, 0, 6, (Object) null));
        } else {
            fontFamily = FontFamily.Companion.getDefault();
        }
        TextStyle textStyle = TextStyle.Companion.getDefault();
        long r3 = paymentsTypography.m4528getXLargeFontSizeXSAIIZE();
        float fontSizeMultiplier = paymentsTypography.getFontSizeMultiplier();
        TextUnitKt.m4053checkArithmeticR2X_6o(r3);
        long pack = TextUnitKt.pack(TextUnit.m4038getRawTypeimpl(r3), TextUnit.m4040getValueimpl(r3) * fontSizeMultiplier);
        FontWeight fontWeight = r3;
        FontWeight fontWeight2 = new FontWeight(paymentsTypography.getFontWeightBold());
        FontFamily fontFamily2 = fontFamily;
        TextStyle r32 = TextStyle.m3579copyHL5avdY$default(textStyle, 0, pack, fontWeight, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262105, (Object) null);
        TextStyle textStyle2 = TextStyle.Companion.getDefault();
        long r33 = paymentsTypography.m4525getLargeFontSizeXSAIIZE();
        float fontSizeMultiplier2 = paymentsTypography.getFontSizeMultiplier();
        TextUnitKt.m4053checkArithmeticR2X_6o(r33);
        long pack2 = TextUnitKt.pack(TextUnit.m4038getRawTypeimpl(r33), TextUnit.m4040getValueimpl(r33) * fontSizeMultiplier2);
        FontWeight fontWeight3 = r3;
        FontWeight fontWeight4 = new FontWeight(paymentsTypography.getFontWeightMedium());
        TextStyle r332 = TextStyle.m3579copyHL5avdY$default(textStyle2, 0, pack2, fontWeight3, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, TextUnitKt.getSp(-0.32d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 261977, (Object) null);
        TextStyle textStyle3 = TextStyle.Companion.getDefault();
        long r34 = paymentsTypography.m4527getSmallFontSizeXSAIIZE();
        float fontSizeMultiplier3 = paymentsTypography.getFontSizeMultiplier();
        TextUnitKt.m4053checkArithmeticR2X_6o(r34);
        long pack3 = TextUnitKt.pack(TextUnit.m4038getRawTypeimpl(r34), TextUnit.m4040getValueimpl(r34) * fontSizeMultiplier3);
        FontWeight fontWeight5 = r3;
        FontWeight fontWeight6 = new FontWeight(paymentsTypography.getFontWeightMedium());
        TextStyle r342 = TextStyle.m3579copyHL5avdY$default(textStyle3, 0, pack3, fontWeight5, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, TextUnitKt.getSp(-0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 261977, (Object) null);
        TextStyle textStyle4 = TextStyle.Companion.getDefault();
        long r35 = paymentsTypography.m4526getMediumFontSizeXSAIIZE();
        float fontSizeMultiplier4 = paymentsTypography.getFontSizeMultiplier();
        TextUnitKt.m4053checkArithmeticR2X_6o(r35);
        long pack4 = TextUnitKt.pack(TextUnit.m4038getRawTypeimpl(r35), TextUnit.m4040getValueimpl(r35) * fontSizeMultiplier4);
        FontWeight fontWeight7 = r3;
        FontWeight fontWeight8 = new FontWeight(paymentsTypography.getFontWeightNormal());
        TextStyle r37 = TextStyle.m3579copyHL5avdY$default(textStyle4, 0, pack4, fontWeight7, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262105, (Object) null);
        TextStyle textStyle5 = TextStyle.Companion.getDefault();
        long r36 = paymentsTypography.m4526getMediumFontSizeXSAIIZE();
        float fontSizeMultiplier5 = paymentsTypography.getFontSizeMultiplier();
        TextUnitKt.m4053checkArithmeticR2X_6o(r36);
        long pack5 = TextUnitKt.pack(TextUnit.m4038getRawTypeimpl(r36), TextUnit.m4040getValueimpl(r36) * fontSizeMultiplier5);
        FontWeight fontWeight9 = r3;
        FontWeight fontWeight10 = new FontWeight(paymentsTypography.getFontWeightNormal());
        TextStyle r352 = TextStyle.m3579copyHL5avdY$default(textStyle5, 0, pack5, fontWeight9, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, TextUnitKt.getSp(-0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 261977, (Object) null);
        TextStyle textStyle6 = TextStyle.Companion.getDefault();
        long r38 = paymentsTypography.m4529getXSmallFontSizeXSAIIZE();
        float fontSizeMultiplier6 = paymentsTypography.getFontSizeMultiplier();
        TextUnitKt.m4053checkArithmeticR2X_6o(r38);
        long pack6 = TextUnitKt.pack(TextUnit.m4038getRawTypeimpl(r38), TextUnit.m4040getValueimpl(r38) * fontSizeMultiplier6);
        FontWeight fontWeight11 = r3;
        FontWeight fontWeight12 = new FontWeight(paymentsTypography.getFontWeightMedium());
        TextStyle r40 = TextStyle.m3579copyHL5avdY$default(textStyle6, 0, pack6, fontWeight11, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262105, (Object) null);
        TextStyle textStyle7 = TextStyle.Companion.getDefault();
        long r39 = paymentsTypography.m4530getXxSmallFontSizeXSAIIZE();
        float fontSizeMultiplier7 = paymentsTypography.getFontSizeMultiplier();
        TextUnitKt.m4053checkArithmeticR2X_6o(r39);
        long pack7 = TextUnitKt.pack(TextUnit.m4038getRawTypeimpl(r39), TextUnit.m4040getValueimpl(r39) * fontSizeMultiplier7);
        FontWeight fontWeight13 = r3;
        FontWeight fontWeight14 = new FontWeight(paymentsTypography.getFontWeightNormal());
        return Typography.copy$default(MaterialTheme.INSTANCE.getTypography(composer, 8), (TextStyle) null, (TextStyle) null, (TextStyle) null, r32, r332, r342, r352, (TextStyle) null, r37, TextStyle.m3579copyHL5avdY$default(textStyle7, 0, pack7, fontWeight13, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, TextUnitKt.getSp(-0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 261977, (Object) null), (TextStyle) null, r40, (TextStyle) null, 5255, (Object) null);
    }

    public static final PrimaryButtonModifierCompose toComposeModifier(PrimaryButtonModifier primaryButtonModifier, boolean z, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(primaryButtonModifier, "<this>");
        TextStyle h5 = PaymentsTheme.INSTANCE.getTypography(composer, 8).getH5();
        if (primaryButtonModifier.getFontFamily() != null) {
            h5 = TextStyle.m3579copyHL5avdY$default(h5, 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamilyKt.FontFamily(FontKt.m3605FontRetOiIg$default(primaryButtonModifier.getFontFamily().intValue(), (FontWeight) null, 0, 6, (Object) null)), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null);
        }
        return new PrimaryButtonModifierCompose(z ? primaryButtonModifier.m4539getOnPrimaryDark0d7_KjU() : primaryButtonModifier.m4540getOnPrimaryLight0d7_KjU(), h5, Dp.m3859constructorimpl(primaryButtonModifier.getHeight()), (DefaultConstructorMarker) null);
    }

    public static final void PaymentsTheme(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(539626200);
        ComposerKt.sourceInformation(startRestartGroup, "C(PaymentsTheme)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (((i2 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            PaymentsComposeColors colors = PaymentsTheme.INSTANCE.getColors(startRestartGroup, 8);
            startRestartGroup.startReplaceableGroup(-3686930);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) colors);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new PaymentsThemeKt$PaymentsTheme$localColors$1$1(colors);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            ProvidableCompositionLocal staticCompositionLocalOf = CompositionLocalKt.staticCompositionLocalOf((Function0) rememberedValue);
            PaymentsComposeShapes shapes = PaymentsTheme.INSTANCE.getShapes(startRestartGroup, 8);
            startRestartGroup.startReplaceableGroup(-3686930);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed((Object) shapes);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new PaymentsThemeKt$PaymentsTheme$localShapes$1$1(shapes);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{staticCompositionLocalOf.provides(colors), CompositionLocalKt.staticCompositionLocalOf((Function0) rememberedValue2).provides(shapes)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819900552, true, new PaymentsThemeKt$PaymentsTheme$1(colors, shapes, function2, i2)), startRestartGroup, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PaymentsThemeKt$PaymentsTheme$2(function2, i));
        }
    }

    public static final boolean isSystemDarkTheme(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* renamed from: convertDpToPx-3ABfNKs  reason: not valid java name */
    public static final float m4514convertDpToPx3ABfNKs(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "$this$convertDpToPx");
        return f * context.getResources().getDisplayMetrics().density;
    }

    /* renamed from: createTextSpanFromTextStyle-qhTmNto  reason: not valid java name */
    public static final SpannableString m4515createTextSpanFromTextStyleqhTmNto(String str, Context context, float f, long j, Integer num) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null) {
            str = "";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan((int) m4514convertDpToPx3ABfNKs(context, f)), 0, spannableString.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(ColorKt.m1651toArgb8_81llA(j)), 0, spannableString.length(), 0);
        if (num != null) {
            typeface = ResourcesCompat.getFont(context, num.intValue());
        } else {
            typeface = Typeface.DEFAULT;
        }
        if (typeface != null) {
            spannableString.setSpan(new CustomTypefaceSpan(typeface), 0, spannableString.length(), 0);
        }
        return spannableString;
    }

    /* renamed from: shouldUseDarkDynamicColor-8_81llA  reason: not valid java name */
    public static final boolean m4516shouldUseDarkDynamicColor8_81llA(long j) {
        double calculateContrast = ColorUtils.calculateContrast(ColorKt.m1651toArgb8_81llA(j), ColorKt.m1651toArgb8_81llA(Color.Companion.m1622getBlack0d7_KjU()));
        double calculateContrast2 = ColorUtils.calculateContrast(ColorKt.m1651toArgb8_81llA(j), ColorKt.m1651toArgb8_81llA(Color.Companion.m1633getWhite0d7_KjU()));
        return calculateContrast2 <= 2.2d && calculateContrast > calculateContrast2;
    }

    public static final int getPrimaryColor(PrimaryButtonModifier primaryButtonModifier, Context context) {
        Intrinsics.checkNotNullParameter(primaryButtonModifier, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return ColorKt.m1651toArgb8_81llA(isSystemDarkTheme(context) ? primaryButtonModifier.m4541getPrimaryDark0d7_KjU() : primaryButtonModifier.m4542getPrimaryLight0d7_KjU());
    }
}

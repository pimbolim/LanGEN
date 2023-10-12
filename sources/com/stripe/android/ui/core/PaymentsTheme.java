package com.stripe.android.ui.core;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00104R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0011XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'8G¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/stripe/android/ui/core/PaymentsTheme;", "", "()V", "colors", "Lcom/stripe/android/ui/core/PaymentsComposeColors;", "getColors", "(Landroidx/compose/runtime/Composer;I)Lcom/stripe/android/ui/core/PaymentsComposeColors;", "colorsDarkMutable", "Lcom/stripe/android/ui/core/PaymentsColors;", "getColorsDarkMutable", "()Lcom/stripe/android/ui/core/PaymentsColors;", "setColorsDarkMutable", "(Lcom/stripe/android/ui/core/PaymentsColors;)V", "colorsLightMutable", "getColorsLightMutable", "setColorsLightMutable", "minContrastForWhite", "", "primaryButtonModifier", "Lcom/stripe/android/ui/core/PrimaryButtonModifierCompose;", "getPrimaryButtonModifier", "(Landroidx/compose/runtime/Composer;I)Lcom/stripe/android/ui/core/PrimaryButtonModifierCompose;", "primaryButtonModifierMutable", "Lcom/stripe/android/ui/core/PrimaryButtonModifier;", "getPrimaryButtonModifierMutable", "()Lcom/stripe/android/ui/core/PrimaryButtonModifier;", "setPrimaryButtonModifierMutable", "(Lcom/stripe/android/ui/core/PrimaryButtonModifier;)V", "shapes", "Lcom/stripe/android/ui/core/PaymentsComposeShapes;", "getShapes", "(Landroidx/compose/runtime/Composer;I)Lcom/stripe/android/ui/core/PaymentsComposeShapes;", "shapesMutable", "Lcom/stripe/android/ui/core/PaymentsShapes;", "getShapesMutable", "()Lcom/stripe/android/ui/core/PaymentsShapes;", "setShapesMutable", "(Lcom/stripe/android/ui/core/PaymentsShapes;)V", "typography", "Landroidx/compose/material/Typography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/Typography;", "typographyMutable", "Lcom/stripe/android/ui/core/PaymentsTypography;", "getTypographyMutable", "()Lcom/stripe/android/ui/core/PaymentsTypography;", "setTypographyMutable", "(Lcom/stripe/android/ui/core/PaymentsTypography;)V", "getBorderStroke", "Landroidx/compose/foundation/BorderStroke;", "isSelected", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentsTheme.kt */
public final class PaymentsTheme {
    public static final int $stable = 8;
    public static final PaymentsTheme INSTANCE = new PaymentsTheme();
    private static PaymentsColors colorsDarkMutable = PaymentsThemeDefaults.INSTANCE.getColorsDark();
    private static PaymentsColors colorsLightMutable = PaymentsThemeDefaults.INSTANCE.getColorsLight();
    public static final double minContrastForWhite = 2.2d;
    private static PrimaryButtonModifier primaryButtonModifierMutable = PaymentsThemeDefaults.INSTANCE.getPrimaryButtonModifier();
    private static PaymentsShapes shapesMutable = PaymentsThemeDefaults.INSTANCE.getShapes();
    private static PaymentsTypography typographyMutable = PaymentsThemeDefaults.INSTANCE.getTypography();

    private PaymentsTheme() {
    }

    public final PaymentsColors getColorsDarkMutable() {
        return colorsDarkMutable;
    }

    public final void setColorsDarkMutable(PaymentsColors paymentsColors) {
        Intrinsics.checkNotNullParameter(paymentsColors, "<set-?>");
        colorsDarkMutable = paymentsColors;
    }

    public final PaymentsColors getColorsLightMutable() {
        return colorsLightMutable;
    }

    public final void setColorsLightMutable(PaymentsColors paymentsColors) {
        Intrinsics.checkNotNullParameter(paymentsColors, "<set-?>");
        colorsLightMutable = paymentsColors;
    }

    public final PaymentsComposeColors getColors(Composer composer, int i) {
        return PaymentsThemeKt.toComposeColors(DarkThemeKt.isSystemInDarkTheme(composer, 0) ? colorsDarkMutable : colorsLightMutable, composer, 0);
    }

    public final PaymentsShapes getShapesMutable() {
        return shapesMutable;
    }

    public final void setShapesMutable(PaymentsShapes paymentsShapes) {
        Intrinsics.checkNotNullParameter(paymentsShapes, "<set-?>");
        shapesMutable = paymentsShapes;
    }

    public final PaymentsComposeShapes getShapes(Composer composer, int i) {
        return PaymentsThemeKt.toComposeShapes(shapesMutable, composer, 0);
    }

    public final PaymentsTypography getTypographyMutable() {
        return typographyMutable;
    }

    public final void setTypographyMutable(PaymentsTypography paymentsTypography) {
        Intrinsics.checkNotNullParameter(paymentsTypography, "<set-?>");
        typographyMutable = paymentsTypography;
    }

    public final Typography getTypography(Composer composer, int i) {
        return PaymentsThemeKt.toComposeTypography(typographyMutable, composer, 0);
    }

    public final PrimaryButtonModifier getPrimaryButtonModifierMutable() {
        return primaryButtonModifierMutable;
    }

    public final void setPrimaryButtonModifierMutable(PrimaryButtonModifier primaryButtonModifier) {
        Intrinsics.checkNotNullParameter(primaryButtonModifier, "<set-?>");
        primaryButtonModifierMutable = primaryButtonModifier;
    }

    public final PrimaryButtonModifierCompose getPrimaryButtonModifier(Composer composer, int i) {
        return PaymentsThemeKt.toComposeModifier(primaryButtonModifierMutable, DarkThemeKt.isSystemInDarkTheme(composer, 0), composer, 0);
    }

    public final BorderStroke getBorderStroke(boolean z, Composer composer, int i) {
        float f;
        long j;
        if (z) {
            composer.startReplaceableGroup(-444054041);
            f = getShapes(composer, 8).m4513getBorderStrokeWidthSelectedD9Ej5fM();
        } else {
            composer.startReplaceableGroup(-444054003);
            f = getShapes(composer, 8).m4512getBorderStrokeWidthD9Ej5fM();
        }
        composer.endReplaceableGroup();
        if (z) {
            composer.startReplaceableGroup(-444053933);
            j = getColors(composer, 8).getMaterial().m914getPrimary0d7_KjU();
        } else {
            composer.startReplaceableGroup(-444053913);
            j = getColors(composer, 8).m4501getColorComponentBorder0d7_KjU();
        }
        composer.endReplaceableGroup();
        return BorderStrokeKt.m176BorderStrokecXLIe8U(f, j);
    }
}

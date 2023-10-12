package com.stripe.android.ui.core;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/ui/core/PaymentsThemeDefaults;", "", "()V", "colorsDark", "Lcom/stripe/android/ui/core/PaymentsColors;", "getColorsDark", "()Lcom/stripe/android/ui/core/PaymentsColors;", "colorsLight", "getColorsLight", "primaryButtonModifier", "Lcom/stripe/android/ui/core/PrimaryButtonModifier;", "getPrimaryButtonModifier", "()Lcom/stripe/android/ui/core/PrimaryButtonModifier;", "shapes", "Lcom/stripe/android/ui/core/PaymentsShapes;", "getShapes", "()Lcom/stripe/android/ui/core/PaymentsShapes;", "typography", "Lcom/stripe/android/ui/core/PaymentsTypography;", "getTypography", "()Lcom/stripe/android/ui/core/PaymentsTypography;", "colors", "isDark", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentsTheme.kt */
public final class PaymentsThemeDefaults {
    public static final int $stable = 0;
    public static final PaymentsThemeDefaults INSTANCE;
    private static final PaymentsColors colorsDark = new PaymentsColors(ColorKt.Color(4278219988L), ColorKt.Color(4281216558L), Color.Companion.m1625getDarkGray0d7_KjU(), ColorKt.Color(4286085248L), ColorKt.Color(4286085248L), Color.Companion.m1633getWhite0d7_KjU(), ColorKt.Color(2583691263L), Color.Companion.m1633getWhite0d7_KjU(), ColorKt.Color(1644167167), Color.Companion.m1633getWhite0d7_KjU(), Color.Companion.m1633getWhite0d7_KjU(), Color.Companion.m1630getRed0d7_KjU(), (DefaultConstructorMarker) null);
    private static final PaymentsColors colorsLight = new PaymentsColors(ColorKt.Color(4278221567L), Color.Companion.m1633getWhite0d7_KjU(), Color.Companion.m1633getWhite0d7_KjU(), ColorKt.Color(863533184), ColorKt.Color(863533184), Color.Companion.m1622getBlack0d7_KjU(), ColorKt.Color(2566914048L), Color.Companion.m1622getBlack0d7_KjU(), ColorKt.Color(2570861635L), Color.Companion.m1622getBlack0d7_KjU(), ColorKt.Color(2566914048L), Color.Companion.m1630getRed0d7_KjU(), (DefaultConstructorMarker) null);
    private static final PrimaryButtonModifier primaryButtonModifier;
    private static final PaymentsShapes shapes;
    private static final PaymentsTypography typography;

    private PaymentsThemeDefaults() {
    }

    public final PaymentsColors colors(boolean z) {
        return z ? colorsDark : colorsLight;
    }

    static {
        PaymentsThemeDefaults paymentsThemeDefaults = new PaymentsThemeDefaults();
        INSTANCE = paymentsThemeDefaults;
        PaymentsShapes paymentsShapes = new PaymentsShapes(6.0f, 1.0f, 2.0f);
        shapes = paymentsShapes;
        PaymentsTypography paymentsTypography = new PaymentsTypography(FontWeight.Companion.getNormal().getWeight(), FontWeight.Companion.getMedium().getWeight(), FontWeight.Companion.getBold().getWeight(), 1.0f, TextUnitKt.getSp(9), TextUnitKt.getSp(12), TextUnitKt.getSp(13), TextUnitKt.getSp(14), TextUnitKt.getSp(16), TextUnitKt.getSp(20), (Integer) null, (DefaultConstructorMarker) null);
        typography = paymentsTypography;
        primaryButtonModifier = new PrimaryButtonModifier(paymentsThemeDefaults.colors(false).m4488getPrimary0d7_KjU(), Color.Companion.m1633getWhite0d7_KjU(), paymentsThemeDefaults.colors(true).m4488getPrimary0d7_KjU(), Color.Companion.m1633getWhite0d7_KjU(), paymentsShapes.getCornerRadius(), Color.Companion.m1631getTransparent0d7_KjU(), 0.0f, paymentsTypography.getFontFamily(), 40.0f, (DefaultConstructorMarker) null);
    }

    public final PaymentsColors getColorsLight() {
        return colorsLight;
    }

    public final PaymentsColors getColorsDark() {
        return colorsDark;
    }

    public final PaymentsShapes getShapes() {
        return shapes;
    }

    public final PaymentsTypography getTypography() {
        return typography;
    }

    public final PrimaryButtonModifier getPrimaryButtonModifier() {
        return primaryButtonModifier;
    }
}

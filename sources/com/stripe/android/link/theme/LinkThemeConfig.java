package com.stripe.android.link.theme;

import androidx.compose.material.ColorsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/link/theme/LinkThemeConfig;", "", "()V", "colorsDark", "Lcom/stripe/android/link/theme/LinkColors;", "colorsLight", "colors", "isDark", "", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Color.kt */
public final class LinkThemeConfig {
    public static final LinkThemeConfig INSTANCE = new LinkThemeConfig();
    private static final LinkColors colorsDark = new LinkColors(ColorKt.DarkComponentBackground, ColorKt.DarkComponentBorder, ColorKt.DarkComponentDivider, ColorKt.ButtonLabel, ColorKt.DarkTextDisabled, ColorsKt.m934darkColors2qZNXz8$default(ColorKt.LinkGreen, 0, ColorKt.DarkFill, 0, ColorKt.DarkBackground, ColorKt.DarkBackground, 0, ColorKt.DarkTextPrimary, ColorKt.DarkTextSecondary, 0, 0, 0, 3658, (Object) null), (DefaultConstructorMarker) null);
    private static final LinkColors colorsLight = new LinkColors(ColorKt.LightComponentBackground, ColorKt.LightComponentBorder, ColorKt.LightComponentDivider, ColorKt.ButtonLabel, ColorKt.LightTextDisabled, ColorsKt.m936lightColors2qZNXz8$default(ColorKt.LinkGreen, 0, ColorKt.LightFill, 0, ColorKt.LightBackground, ColorKt.LightBackground, 0, ColorKt.LightTextPrimary, ColorKt.LightTextSecondary, 0, 0, 0, 3658, (Object) null), (DefaultConstructorMarker) null);

    private LinkThemeConfig() {
    }

    public final LinkColors colors(boolean z) {
        return z ? colorsDark : colorsLight;
    }
}

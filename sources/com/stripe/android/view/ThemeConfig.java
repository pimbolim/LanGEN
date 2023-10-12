package com.stripe.android.view;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.stripe.android.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\bH\u0003J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u0019J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00020\b8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\b8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\b8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/view/ThemeConfig;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorUtils", "Lcom/stripe/android/view/StripeColorUtils;", "selectedColorInt", "", "selectedTextAlphaColorInt", "textColorValues", "", "getTextColorValues$payments_core_release", "()[I", "unselectedColorInt", "unselectedTextAlphaColorInt", "unselectedTextColorInt", "determineColor", "defaultColor", "colorIfTransparent", "getTextAlphaColor", "isSelected", "", "getTextAlphaColor$payments_core_release", "getTextColor", "getTextColor$payments_core_release", "getTintColor", "getTintColor$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThemeConfig.kt */
public final class ThemeConfig {
    private final StripeColorUtils colorUtils;
    private final int selectedColorInt;
    private final int selectedTextAlphaColorInt;
    private final int[] textColorValues;
    private final int unselectedColorInt;
    private final int unselectedTextAlphaColorInt;
    private final int unselectedTextColorInt;

    public ThemeConfig(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StripeColorUtils stripeColorUtils = new StripeColorUtils(context);
        this.colorUtils = stripeColorUtils;
        int determineColor = determineColor(context, stripeColorUtils.getColorAccent(), R.color.stripe_accent_color_default);
        this.selectedColorInt = determineColor;
        this.unselectedColorInt = determineColor(context, stripeColorUtils.getColorControlNormal(), R.color.stripe_control_normal_color_default);
        int determineColor2 = determineColor(context, stripeColorUtils.getTextColorSecondary(), R.color.stripe_color_text_secondary_default);
        this.unselectedTextColorInt = determineColor2;
        int alphaComponent = ColorUtils.setAlphaComponent(determineColor, context.getResources().getInteger(R.integer.stripe_light_text_alpha_hex));
        this.selectedTextAlphaColorInt = alphaComponent;
        int alphaComponent2 = ColorUtils.setAlphaComponent(determineColor2, context.getResources().getInteger(R.integer.stripe_light_text_alpha_hex));
        this.unselectedTextAlphaColorInt = alphaComponent2;
        this.textColorValues = new int[]{determineColor, alphaComponent, determineColor2, alphaComponent2};
    }

    public final int[] getTextColorValues$payments_core_release() {
        return this.textColorValues;
    }

    public final int getTintColor$payments_core_release(boolean z) {
        return z ? this.selectedColorInt : this.unselectedColorInt;
    }

    public final int getTextColor$payments_core_release(boolean z) {
        return z ? this.selectedColorInt : this.unselectedTextColorInt;
    }

    public final int getTextAlphaColor$payments_core_release(boolean z) {
        return z ? this.selectedTextAlphaColorInt : this.unselectedTextAlphaColorInt;
    }

    private final int determineColor(Context context, int i, int i2) {
        return StripeColorUtils.Companion.isColorTransparent(i) ? ContextCompat.getColor(context, i2) : i;
    }
}

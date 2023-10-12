package com.stripe.android.stripe3ds2.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.google.android.material.button.MaterialButton;
import com.stripe.android.stripe3ds2.init.ui.ButtonCustomization;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ThreeDS2Button;", "Lcom/google/android/material/button/MaterialButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "parseColor", "hexColor", "", "parseColor$3ds2sdk_release", "setButtonCustomization", "", "buttonCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/ButtonCustomization;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThreeDS2Button.kt */
public class ThreeDS2Button extends MaterialButton {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ThreeDS2Button(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ThreeDS2Button(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThreeDS2Button(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThreeDS2Button(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setButtonCustomization(ButtonCustomization buttonCustomization) {
        if (buttonCustomization != null) {
            String textColor = buttonCustomization.getTextColor();
            if (textColor != null) {
                setTextColor(parseColor$3ds2sdk_release(textColor));
            }
            String backgroundColor = buttonCustomization.getBackgroundColor();
            if (backgroundColor != null) {
                setBackgroundTintList(ColorStateList.valueOf(parseColor$3ds2sdk_release(backgroundColor)));
            }
            Integer valueOf = Integer.valueOf(buttonCustomization.getCornerRadius());
            boolean z = true;
            Integer num = null;
            if (!(valueOf.intValue() >= 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                setCornerRadius(valueOf.intValue());
            }
            Integer valueOf2 = Integer.valueOf(buttonCustomization.getTextFontSize());
            if (valueOf2.intValue() <= 0) {
                z = false;
            }
            if (z) {
                num = valueOf2;
            }
            if (num != null) {
                setTextSize(2, (float) num.intValue());
            }
            String textFontName = buttonCustomization.getTextFontName();
            if (textFontName != null) {
                setTypeface(Typeface.create(textFontName, 0));
            }
        }
    }

    public final int parseColor$3ds2sdk_release(String str) {
        Intrinsics.checkNotNullParameter(str, "hexColor");
        return Color.parseColor(str);
    }
}

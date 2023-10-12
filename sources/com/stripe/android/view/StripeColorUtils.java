package com.stripe.android.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012R\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u0006J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u0006H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/view/StripeColorUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorAccent", "", "getColorAccent", "()I", "colorControlNormal", "getColorControlNormal", "textColorPrimary", "getTextColorPrimary", "textColorSecondary", "getTextColorSecondary", "getTintedIconWithAttribute", "Landroid/graphics/drawable/Drawable;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "attributeResource", "iconResourceId", "getTypedValue", "Landroid/util/TypedValue;", "idRes", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeColorUtils.kt */
public final class StripeColorUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int colorAccent = getTypedValue(16843829).data;
    private final int colorControlNormal = getTypedValue(16843817).data;
    private final Context context;
    private final int textColorPrimary = getTypedValue(16842806).data;
    private final int textColorSecondary = getTypedValue(16842808).data;

    public StripeColorUtils(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final int getColorAccent() {
        return this.colorAccent;
    }

    public final int getColorControlNormal() {
        return this.colorControlNormal;
    }

    public final int getTextColorPrimary() {
        return this.textColorPrimary;
    }

    public final int getTextColorSecondary() {
        return this.textColorSecondary;
    }

    private final TypedValue getTypedValue(int i) {
        TypedValue typedValue = new TypedValue();
        this.context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue;
    }

    public final Drawable getTintedIconWithAttribute(Resources.Theme theme, int i, int i2) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(i, typedValue, true);
        int i3 = typedValue.data;
        Drawable drawable = ContextCompat.getDrawable(this.context, i2);
        Intrinsics.checkNotNull(drawable);
        Drawable wrap = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrap.mutate(), i3);
        Intrinsics.checkNotNullExpressionValue(wrap, "compatIcon");
        return wrap;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/StripeColorUtils$Companion;", "", "()V", "isColorDark", "", "color", "", "isColorTransparent", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeColorUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isColorTransparent(int i) {
            return Color.alpha(i) < 16;
        }

        public final boolean isColorDark(int i) {
            return (((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d)) / ((double) 255) <= 0.5d;
        }
    }
}

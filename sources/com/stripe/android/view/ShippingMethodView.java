package com.stripe.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.stripe.android.R;
import com.stripe.android.databinding.ShippingMethodViewBinding;
import com.stripe.android.model.ShippingMethod;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/view/ShippingMethodView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "colorUtils", "Lcom/stripe/android/view/StripeColorUtils;", "selectedColorInt", "unselectedTextColorPrimaryInt", "unselectedTextColorSecondaryInt", "viewBinding", "Lcom/stripe/android/databinding/ShippingMethodViewBinding;", "setSelected", "", "selected", "", "setShippingMethod", "shippingMethod", "Lcom/stripe/android/model/ShippingMethod;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShippingMethodView.kt */
public final class ShippingMethodView extends RelativeLayout {
    private final StripeColorUtils colorUtils;
    private final int selectedColorInt;
    private final int unselectedTextColorPrimaryInt;
    private final int unselectedTextColorSecondaryInt;
    private final ShippingMethodViewBinding viewBinding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShippingMethodView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShippingMethodView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShippingMethodView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShippingMethodView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        StripeColorUtils stripeColorUtils = new StripeColorUtils(context);
        this.colorUtils = stripeColorUtils;
        ShippingMethodViewBinding inflate = ShippingMethodViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI…text),\n        this\n    )");
        this.viewBinding = inflate;
        int colorAccent = stripeColorUtils.getColorAccent();
        int textColorPrimary = stripeColorUtils.getTextColorPrimary();
        int textColorSecondary = stripeColorUtils.getTextColorSecondary();
        this.selectedColorInt = StripeColorUtils.Companion.isColorTransparent(colorAccent) ? ContextCompat.getColor(context, R.color.stripe_accent_color_default) : colorAccent;
        this.unselectedTextColorPrimaryInt = StripeColorUtils.Companion.isColorTransparent(textColorPrimary) ? ContextCompat.getColor(context, R.color.stripe_color_text_unselected_primary_default) : textColorPrimary;
        this.unselectedTextColorSecondaryInt = StripeColorUtils.Companion.isColorTransparent(textColorSecondary) ? ContextCompat.getColor(context, R.color.stripe_color_text_unselected_secondary_default) : textColorSecondary;
    }

    public void setSelected(boolean z) {
        if (z) {
            this.viewBinding.name.setTextColor(this.selectedColorInt);
            this.viewBinding.description.setTextColor(this.selectedColorInt);
            this.viewBinding.price.setTextColor(this.selectedColorInt);
            this.viewBinding.selectedIcon.setVisibility(0);
            return;
        }
        this.viewBinding.name.setTextColor(this.unselectedTextColorPrimaryInt);
        this.viewBinding.description.setTextColor(this.unselectedTextColorSecondaryInt);
        this.viewBinding.price.setTextColor(this.unselectedTextColorPrimaryInt);
        this.viewBinding.selectedIcon.setVisibility(4);
    }

    public final void setShippingMethod(ShippingMethod shippingMethod) {
        Intrinsics.checkNotNullParameter(shippingMethod, "shippingMethod");
        this.viewBinding.name.setText(shippingMethod.getLabel());
        this.viewBinding.description.setText(shippingMethod.getDetail());
        TextView textView = this.viewBinding.price;
        long amount = shippingMethod.getAmount();
        Currency currency = shippingMethod.getCurrency();
        String string = getContext().getString(R.string.price_free);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.price_free)");
        textView.setText(PaymentUtils.formatPriceStringUsingFree(amount, currency, string));
    }
}

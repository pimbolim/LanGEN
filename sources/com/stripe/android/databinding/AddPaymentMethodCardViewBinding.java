package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.R;
import com.stripe.android.view.CardMultilineWidget;
import com.stripe.android.view.ShippingInfoWidget;

public final class AddPaymentMethodCardViewBinding implements ViewBinding {
    public final LinearLayout addPaymentMethodCard;
    public final ShippingInfoWidget billingAddressWidget;
    public final CardMultilineWidget cardMultilineWidget;
    private final LinearLayout rootView;

    private AddPaymentMethodCardViewBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ShippingInfoWidget shippingInfoWidget, CardMultilineWidget cardMultilineWidget2) {
        this.rootView = linearLayout;
        this.addPaymentMethodCard = linearLayout2;
        this.billingAddressWidget = shippingInfoWidget;
        this.cardMultilineWidget = cardMultilineWidget2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AddPaymentMethodCardViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AddPaymentMethodCardViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.add_payment_method_card_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AddPaymentMethodCardViewBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.billing_address_widget;
        ShippingInfoWidget shippingInfoWidget = (ShippingInfoWidget) ViewBindings.findChildViewById(view, i);
        if (shippingInfoWidget != null) {
            i = R.id.card_multiline_widget;
            CardMultilineWidget cardMultilineWidget2 = (CardMultilineWidget) ViewBindings.findChildViewById(view, i);
            if (cardMultilineWidget2 != null) {
                return new AddPaymentMethodCardViewBinding(linearLayout, linearLayout, shippingInfoWidget, cardMultilineWidget2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

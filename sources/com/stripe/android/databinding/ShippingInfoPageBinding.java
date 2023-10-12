package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.R;
import com.stripe.android.view.ShippingInfoWidget;

public final class ShippingInfoPageBinding implements ViewBinding {
    private final ScrollView rootView;
    public final ShippingInfoWidget shippingInfoWidget;

    private ShippingInfoPageBinding(ScrollView scrollView, ShippingInfoWidget shippingInfoWidget2) {
        this.rootView = scrollView;
        this.shippingInfoWidget = shippingInfoWidget2;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ShippingInfoPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShippingInfoPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.shipping_info_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShippingInfoPageBinding bind(View view) {
        int i = R.id.shipping_info_widget;
        ShippingInfoWidget shippingInfoWidget2 = (ShippingInfoWidget) ViewBindings.findChildViewById(view, i);
        if (shippingInfoWidget2 != null) {
            return new ShippingInfoPageBinding((ScrollView) view, shippingInfoWidget2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

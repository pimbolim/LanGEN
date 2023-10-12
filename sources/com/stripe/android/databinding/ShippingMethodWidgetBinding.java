package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.R;
import java.util.Objects;

public final class ShippingMethodWidgetBinding implements ViewBinding {
    private final View rootView;
    public final RecyclerView shippingMethods;

    private ShippingMethodWidgetBinding(View view, RecyclerView recyclerView) {
        this.rootView = view;
        this.shippingMethods = recyclerView;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static ShippingMethodWidgetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(R.layout.shipping_method_widget, viewGroup);
        return bind(viewGroup);
    }

    public static ShippingMethodWidgetBinding bind(View view) {
        int i = R.id.shipping_methods;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            return new ShippingMethodWidgetBinding(view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

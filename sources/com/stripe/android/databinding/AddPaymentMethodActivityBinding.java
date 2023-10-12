package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.R;

public final class AddPaymentMethodActivityBinding implements ViewBinding {
    public final LinearLayout root;
    private final ScrollView rootView;

    private AddPaymentMethodActivityBinding(ScrollView scrollView, LinearLayout linearLayout) {
        this.rootView = scrollView;
        this.root = linearLayout;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static AddPaymentMethodActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AddPaymentMethodActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.add_payment_method_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AddPaymentMethodActivityBinding bind(View view) {
        int i = R.id.root;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            return new AddPaymentMethodActivityBinding((ScrollView) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

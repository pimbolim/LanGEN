package com.stripe.android.paymentsheet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.paymentsheet.R;

public final class FragmentPaymentsheetAddPaymentMethodBinding implements ViewBinding {
    public final FragmentContainerView paymentMethodFragmentContainer;
    public final ComposeView paymentMethodsRecycler;
    private final LinearLayout rootView;

    private FragmentPaymentsheetAddPaymentMethodBinding(LinearLayout linearLayout, FragmentContainerView fragmentContainerView, ComposeView composeView) {
        this.rootView = linearLayout;
        this.paymentMethodFragmentContainer = fragmentContainerView;
        this.paymentMethodsRecycler = composeView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPaymentsheetAddPaymentMethodBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentPaymentsheetAddPaymentMethodBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_paymentsheet_add_payment_method, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentPaymentsheetAddPaymentMethodBinding bind(View view) {
        int i = R.id.payment_method_fragment_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
        if (fragmentContainerView != null) {
            i = R.id.payment_methods_recycler;
            ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
            if (composeView != null) {
                return new FragmentPaymentsheetAddPaymentMethodBinding((LinearLayout) view, fragmentContainerView, composeView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

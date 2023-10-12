package com.stripe.android.paymentsheet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.stripe.android.paymentsheet.R;
import java.util.Objects;

public final class FragmentPaymentsheetLoadingBinding implements ViewBinding {
    private final FrameLayout rootView;

    private FragmentPaymentsheetLoadingBinding(FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPaymentsheetLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentPaymentsheetLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_paymentsheet_loading, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentPaymentsheetLoadingBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new FragmentPaymentsheetLoadingBinding((FrameLayout) view);
    }
}

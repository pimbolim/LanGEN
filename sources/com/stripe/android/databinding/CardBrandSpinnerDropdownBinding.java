package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.stripe.android.R;
import java.util.Objects;

public final class CardBrandSpinnerDropdownBinding implements ViewBinding {
    private final AppCompatTextView rootView;
    public final AppCompatTextView textView;

    private CardBrandSpinnerDropdownBinding(AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.rootView = appCompatTextView;
        this.textView = appCompatTextView2;
    }

    public AppCompatTextView getRoot() {
        return this.rootView;
    }

    public static CardBrandSpinnerDropdownBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CardBrandSpinnerDropdownBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.card_brand_spinner_dropdown, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CardBrandSpinnerDropdownBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        AppCompatTextView appCompatTextView = (AppCompatTextView) view;
        return new CardBrandSpinnerDropdownBinding(appCompatTextView, appCompatTextView);
    }
}

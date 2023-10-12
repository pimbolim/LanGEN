package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.stripe.android.R;
import java.util.Objects;

public final class CardBrandSpinnerMainBinding implements ViewBinding {
    public final AppCompatImageView image;
    private final AppCompatImageView rootView;

    private CardBrandSpinnerMainBinding(AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2) {
        this.rootView = appCompatImageView;
        this.image = appCompatImageView2;
    }

    public AppCompatImageView getRoot() {
        return this.rootView;
    }

    public static CardBrandSpinnerMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CardBrandSpinnerMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.card_brand_spinner_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CardBrandSpinnerMainBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        AppCompatImageView appCompatImageView = (AppCompatImageView) view;
        return new CardBrandSpinnerMainBinding(appCompatImageView, appCompatImageView);
    }
}

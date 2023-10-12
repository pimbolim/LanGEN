package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.R;
import java.util.Objects;

public final class MaskedCardViewBinding implements ViewBinding {
    public final AppCompatImageView brandIcon;
    public final AppCompatImageView checkIcon;
    public final AppCompatTextView details;
    private final View rootView;

    private MaskedCardViewBinding(View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView) {
        this.rootView = view;
        this.brandIcon = appCompatImageView;
        this.checkIcon = appCompatImageView2;
        this.details = appCompatTextView;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static MaskedCardViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(R.layout.masked_card_view, viewGroup);
        return bind(viewGroup);
    }

    public static MaskedCardViewBinding bind(View view) {
        int i = R.id.brand_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.check_icon;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView2 != null) {
                i = R.id.details;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView != null) {
                    return new MaskedCardViewBinding(view, appCompatImageView, appCompatImageView2, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

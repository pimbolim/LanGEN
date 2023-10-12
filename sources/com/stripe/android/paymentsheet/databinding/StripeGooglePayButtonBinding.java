package com.stripe.android.paymentsheet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.paymentsheet.ui.PrimaryButton;
import java.util.Objects;

public final class StripeGooglePayButtonBinding implements ViewBinding {
    public final ImageView googlePayButtonContent;
    public final RelativeLayout googlePayButtonIcon;
    public final PrimaryButton primaryButton;
    private final View rootView;

    private StripeGooglePayButtonBinding(View view, ImageView imageView, RelativeLayout relativeLayout, PrimaryButton primaryButton2) {
        this.rootView = view;
        this.googlePayButtonContent = imageView;
        this.googlePayButtonIcon = relativeLayout;
        this.primaryButton = primaryButton2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static StripeGooglePayButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(R.layout.stripe_google_pay_button, viewGroup);
        return bind(viewGroup);
    }

    public static StripeGooglePayButtonBinding bind(View view) {
        int i = R.id.google_pay_button_content;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.google_pay_button_icon;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.primary_button;
                PrimaryButton primaryButton2 = (PrimaryButton) ViewBindings.findChildViewById(view, i);
                if (primaryButton2 != null) {
                    return new StripeGooglePayButtonBinding(view, imageView, relativeLayout, primaryButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

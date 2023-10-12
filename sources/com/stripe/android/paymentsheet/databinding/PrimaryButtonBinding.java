package com.stripe.android.paymentsheet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.stripe.android.paymentsheet.R;
import java.util.Objects;

public final class PrimaryButtonBinding implements ViewBinding {
    public final ImageView confirmedIcon;
    public final CircularProgressIndicator confirmingIcon;
    public final ComposeView label;
    public final ImageView lockIcon;
    private final View rootView;

    private PrimaryButtonBinding(View view, ImageView imageView, CircularProgressIndicator circularProgressIndicator, ComposeView composeView, ImageView imageView2) {
        this.rootView = view;
        this.confirmedIcon = imageView;
        this.confirmingIcon = circularProgressIndicator;
        this.label = composeView;
        this.lockIcon = imageView2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static PrimaryButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(R.layout.primary_button, viewGroup);
        return bind(viewGroup);
    }

    public static PrimaryButtonBinding bind(View view) {
        int i = R.id.confirmed_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.confirming_icon;
            CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(view, i);
            if (circularProgressIndicator != null) {
                i = R.id.label;
                ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
                if (composeView != null) {
                    i = R.id.lock_icon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        return new PrimaryButtonBinding(view, imageView, circularProgressIndicator, composeView, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

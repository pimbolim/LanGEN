package com.stripe.android.stripe3ds2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.stripe3ds2.R;
import java.util.Objects;

public final class StripeBrandZoneViewBinding implements ViewBinding {
    public final ImageView issuerImage;
    public final ImageView paymentSystemImage;
    private final View rootView;

    private StripeBrandZoneViewBinding(View view, ImageView imageView, ImageView imageView2) {
        this.rootView = view;
        this.issuerImage = imageView;
        this.paymentSystemImage = imageView2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static StripeBrandZoneViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(R.layout.stripe_brand_zone_view, viewGroup);
        return bind(viewGroup);
    }

    public static StripeBrandZoneViewBinding bind(View view) {
        int i = R.id.issuer_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.payment_system_image;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                return new StripeBrandZoneViewBinding(view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

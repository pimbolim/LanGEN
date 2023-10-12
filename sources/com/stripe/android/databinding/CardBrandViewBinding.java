package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.R;
import com.stripe.android.view.CardWidgetProgressView;
import java.util.Objects;

public final class CardBrandViewBinding implements ViewBinding {
    public final ImageView icon;
    public final CardWidgetProgressView progress;
    private final View rootView;

    private CardBrandViewBinding(View view, ImageView imageView, CardWidgetProgressView cardWidgetProgressView) {
        this.rootView = view;
        this.icon = imageView;
        this.progress = cardWidgetProgressView;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static CardBrandViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(R.layout.card_brand_view, viewGroup);
        return bind(viewGroup);
    }

    public static CardBrandViewBinding bind(View view) {
        int i = R.id.icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.progress;
            CardWidgetProgressView cardWidgetProgressView = (CardWidgetProgressView) ViewBindings.findChildViewById(view, i);
            if (cardWidgetProgressView != null) {
                return new CardBrandViewBinding(view, imageView, cardWidgetProgressView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

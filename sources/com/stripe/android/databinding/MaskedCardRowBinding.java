package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.R;
import com.stripe.android.view.MaskedCardView;

public final class MaskedCardRowBinding implements ViewBinding {
    public final MaskedCardView maskedCardItem;
    private final FrameLayout rootView;

    private MaskedCardRowBinding(FrameLayout frameLayout, MaskedCardView maskedCardView) {
        this.rootView = frameLayout;
        this.maskedCardItem = maskedCardView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MaskedCardRowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MaskedCardRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.masked_card_row, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MaskedCardRowBinding bind(View view) {
        int i = R.id.masked_card_item;
        MaskedCardView maskedCardView = (MaskedCardView) ViewBindings.findChildViewById(view, i);
        if (maskedCardView != null) {
            return new MaskedCardRowBinding((FrameLayout) view, maskedCardView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

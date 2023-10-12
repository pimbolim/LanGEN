package com.stripe.android.stripe3ds2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.stripe3ds2.R;
import com.stripe.android.stripe3ds2.views.ThreeDS2TextView;

public final class StripeChallengeZoneMultiSelectViewBinding implements ViewBinding {
    public final ThreeDS2TextView label;
    private final LinearLayout rootView;
    public final LinearLayout selectGroup;

    private StripeChallengeZoneMultiSelectViewBinding(LinearLayout linearLayout, ThreeDS2TextView threeDS2TextView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.label = threeDS2TextView;
        this.selectGroup = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StripeChallengeZoneMultiSelectViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StripeChallengeZoneMultiSelectViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.stripe_challenge_zone_multi_select_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StripeChallengeZoneMultiSelectViewBinding bind(View view) {
        int i = R.id.label;
        ThreeDS2TextView threeDS2TextView = (ThreeDS2TextView) ViewBindings.findChildViewById(view, i);
        if (threeDS2TextView != null) {
            i = R.id.select_group;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                return new StripeChallengeZoneMultiSelectViewBinding((LinearLayout) view, threeDS2TextView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

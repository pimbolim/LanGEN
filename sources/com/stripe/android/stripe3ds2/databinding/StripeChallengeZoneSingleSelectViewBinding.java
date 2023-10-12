package com.stripe.android.stripe3ds2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.stripe.android.stripe3ds2.R;
import com.stripe.android.stripe3ds2.views.ThreeDS2TextView;

public final class StripeChallengeZoneSingleSelectViewBinding implements ViewBinding {
    public final ThreeDS2TextView label;
    private final LinearLayout rootView;
    public final RadioGroup selectGroup;

    private StripeChallengeZoneSingleSelectViewBinding(LinearLayout linearLayout, ThreeDS2TextView threeDS2TextView, RadioGroup radioGroup) {
        this.rootView = linearLayout;
        this.label = threeDS2TextView;
        this.selectGroup = radioGroup;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StripeChallengeZoneSingleSelectViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StripeChallengeZoneSingleSelectViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.stripe_challenge_zone_single_select_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StripeChallengeZoneSingleSelectViewBinding bind(View view) {
        int i = R.id.label;
        ThreeDS2TextView threeDS2TextView = (ThreeDS2TextView) ViewBindings.findChildViewById(view, i);
        if (threeDS2TextView != null) {
            i = R.id.select_group;
            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
            if (radioGroup != null) {
                return new StripeChallengeZoneSingleSelectViewBinding((LinearLayout) view, threeDS2TextView, radioGroup);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

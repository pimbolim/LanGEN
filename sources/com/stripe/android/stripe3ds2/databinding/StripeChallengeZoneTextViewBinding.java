package com.stripe.android.stripe3ds2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.stripe3ds2.R;

public final class StripeChallengeZoneTextViewBinding implements ViewBinding {
    public final TextInputLayout label;
    private final TextInputLayout rootView;
    public final TextInputEditText textEntry;

    private StripeChallengeZoneTextViewBinding(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputEditText textInputEditText) {
        this.rootView = textInputLayout;
        this.label = textInputLayout2;
        this.textEntry = textInputEditText;
    }

    public TextInputLayout getRoot() {
        return this.rootView;
    }

    public static StripeChallengeZoneTextViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StripeChallengeZoneTextViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.stripe_challenge_zone_text_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StripeChallengeZoneTextViewBinding bind(View view) {
        TextInputLayout textInputLayout = (TextInputLayout) view;
        int i = R.id.text_entry;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
        if (textInputEditText != null) {
            return new StripeChallengeZoneTextViewBinding(textInputLayout, textInputLayout, textInputEditText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

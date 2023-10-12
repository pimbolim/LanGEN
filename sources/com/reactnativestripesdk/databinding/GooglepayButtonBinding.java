package com.reactnativestripesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.reactnativestripesdk.R;
import java.util.Objects;

public final class GooglepayButtonBinding implements ViewBinding {
    private final RelativeLayout rootView;

    private GooglepayButtonBinding(RelativeLayout relativeLayout) {
        this.rootView = relativeLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static GooglepayButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static GooglepayButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.googlepay_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GooglepayButtonBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new GooglepayButtonBinding((RelativeLayout) view);
    }
}

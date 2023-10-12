package com.reactnativestripesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.reactnativestripesdk.R;
import java.util.Objects;

public final class GooglepayButtonNoShadowBinding implements ViewBinding {
    private final RelativeLayout rootView;

    private GooglepayButtonNoShadowBinding(RelativeLayout relativeLayout) {
        this.rootView = relativeLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static GooglepayButtonNoShadowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static GooglepayButtonNoShadowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.googlepay_button_no_shadow, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GooglepayButtonNoShadowBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new GooglepayButtonNoShadowBinding((RelativeLayout) view);
    }
}

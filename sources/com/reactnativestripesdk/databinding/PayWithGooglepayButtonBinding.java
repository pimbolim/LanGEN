package com.reactnativestripesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.reactnativestripesdk.R;
import java.util.Objects;

public final class PayWithGooglepayButtonBinding implements ViewBinding {
    private final RelativeLayout rootView;

    private PayWithGooglepayButtonBinding(RelativeLayout relativeLayout) {
        this.rootView = relativeLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PayWithGooglepayButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PayWithGooglepayButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pay_with_googlepay_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PayWithGooglepayButtonBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new PayWithGooglepayButtonBinding((RelativeLayout) view);
    }
}

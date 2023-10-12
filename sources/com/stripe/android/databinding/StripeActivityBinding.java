package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.stripe.android.R;

public final class StripeActivityBinding implements ViewBinding {
    public final LinearProgressIndicator progressBar;
    private final RelativeLayout rootView;
    public final Toolbar toolbar;
    public final ViewStub viewStub;

    private StripeActivityBinding(RelativeLayout relativeLayout, LinearProgressIndicator linearProgressIndicator, Toolbar toolbar2, ViewStub viewStub2) {
        this.rootView = relativeLayout;
        this.progressBar = linearProgressIndicator;
        this.toolbar = toolbar2;
        this.viewStub = viewStub2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StripeActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StripeActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.stripe_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StripeActivityBinding bind(View view) {
        int i = R.id.progress_bar;
        LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i);
        if (linearProgressIndicator != null) {
            i = R.id.toolbar;
            Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i);
            if (toolbar2 != null) {
                i = R.id.view_stub;
                ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i);
                if (viewStub2 != null) {
                    return new StripeActivityBinding((RelativeLayout) view, linearProgressIndicator, toolbar2, viewStub2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

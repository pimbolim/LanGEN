package com.stripe.android.connections.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.stripe.android.connections.R;

public final class ActivityConnectionsSheetBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final CircularProgressIndicator spinner;

    private ActivityConnectionsSheetBinding(ConstraintLayout constraintLayout, CircularProgressIndicator circularProgressIndicator) {
        this.rootView = constraintLayout;
        this.spinner = circularProgressIndicator;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityConnectionsSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityConnectionsSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_connections_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityConnectionsSheetBinding bind(View view) {
        int i = R.id.spinner;
        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(view, i);
        if (circularProgressIndicator != null) {
            return new ActivityConnectionsSheetBinding((ConstraintLayout) view, circularProgressIndicator);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

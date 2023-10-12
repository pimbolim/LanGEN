package com.stripe.android.paymentsheet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.paymentsheet.ui.PrimaryButton;

public final class ActivityPaymentOptionsBinding implements ViewBinding {
    public final AppBarLayout appbar;
    public final LinearLayout bottomSheet;
    public final PrimaryButton continueButton;
    public final CoordinatorLayout coordinator;
    public final FragmentContainerView fragmentContainer;
    public final LinearLayout fragmentContainerParent;
    public final ComposeView header;
    public final TextView message;
    private final CoordinatorLayout rootView;
    public final ScrollView scrollView;
    public final TextView testmode;
    public final MaterialToolbar toolbar;

    private ActivityPaymentOptionsBinding(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, LinearLayout linearLayout, PrimaryButton primaryButton, CoordinatorLayout coordinatorLayout2, FragmentContainerView fragmentContainerView, LinearLayout linearLayout2, ComposeView composeView, TextView textView, ScrollView scrollView2, TextView textView2, MaterialToolbar materialToolbar) {
        this.rootView = coordinatorLayout;
        this.appbar = appBarLayout;
        this.bottomSheet = linearLayout;
        this.continueButton = primaryButton;
        this.coordinator = coordinatorLayout2;
        this.fragmentContainer = fragmentContainerView;
        this.fragmentContainerParent = linearLayout2;
        this.header = composeView;
        this.message = textView;
        this.scrollView = scrollView2;
        this.testmode = textView2;
        this.toolbar = materialToolbar;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPaymentOptionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPaymentOptionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_payment_options, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPaymentOptionsBinding bind(View view) {
        int i = R.id.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i);
        if (appBarLayout != null) {
            i = R.id.bottom_sheet;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.continue_button;
                PrimaryButton primaryButton = (PrimaryButton) ViewBindings.findChildViewById(view, i);
                if (primaryButton != null) {
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                    i = R.id.fragment_container;
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                    if (fragmentContainerView != null) {
                        i = R.id.fragment_container_parent;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.header;
                            ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
                            if (composeView != null) {
                                i = R.id.message;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.scroll_view;
                                    ScrollView scrollView2 = (ScrollView) ViewBindings.findChildViewById(view, i);
                                    if (scrollView2 != null) {
                                        i = R.id.testmode;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.toolbar;
                                            MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                                            if (materialToolbar != null) {
                                                return new ActivityPaymentOptionsBinding(coordinatorLayout, appBarLayout, linearLayout, primaryButton, coordinatorLayout, fragmentContainerView, linearLayout2, composeView, textView, scrollView2, textView2, materialToolbar);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

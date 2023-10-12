package com.stripe.android.paymentsheet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.stripe.android.link.ui.LinkViewButton;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.paymentsheet.ui.GooglePayButton;
import com.stripe.android.paymentsheet.ui.PrimaryButton;

public final class ActivityPaymentSheetBinding implements ViewBinding {
    public final AppBarLayout appbar;
    public final LinearLayout bottomSheet;
    public final FrameLayout buttonContainer;
    public final PrimaryButton buyButton;
    public final CoordinatorLayout coordinator;
    public final FragmentContainerView fragmentContainer;
    public final LinearLayout fragmentContainerParent;
    public final GooglePayButton googlePayButton;
    public final ComposeView googlePayDivider;
    public final ComposeView header;
    public final LinkViewButton linkButton;
    public final TextView message;
    private final CoordinatorLayout rootView;
    public final ScrollView scrollView;
    public final TextView testmode;
    public final MaterialToolbar toolbar;
    public final LinearLayout topContainer;
    public final TextView topMessage;

    private ActivityPaymentSheetBinding(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, LinearLayout linearLayout, FrameLayout frameLayout, PrimaryButton primaryButton, CoordinatorLayout coordinatorLayout2, FragmentContainerView fragmentContainerView, LinearLayout linearLayout2, GooglePayButton googlePayButton2, ComposeView composeView, ComposeView composeView2, LinkViewButton linkViewButton, TextView textView, ScrollView scrollView2, TextView textView2, MaterialToolbar materialToolbar, LinearLayout linearLayout3, TextView textView3) {
        this.rootView = coordinatorLayout;
        this.appbar = appBarLayout;
        this.bottomSheet = linearLayout;
        this.buttonContainer = frameLayout;
        this.buyButton = primaryButton;
        this.coordinator = coordinatorLayout2;
        this.fragmentContainer = fragmentContainerView;
        this.fragmentContainerParent = linearLayout2;
        this.googlePayButton = googlePayButton2;
        this.googlePayDivider = composeView;
        this.header = composeView2;
        this.linkButton = linkViewButton;
        this.message = textView;
        this.scrollView = scrollView2;
        this.testmode = textView2;
        this.toolbar = materialToolbar;
        this.topContainer = linearLayout3;
        this.topMessage = textView3;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPaymentSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPaymentSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_payment_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPaymentSheetBinding bind(View view) {
        View view2 = view;
        int i = R.id.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view2, i);
        if (appBarLayout != null) {
            i = R.id.bottom_sheet;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
            if (linearLayout != null) {
                i = R.id.button_container;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                if (frameLayout != null) {
                    i = R.id.buy_button;
                    PrimaryButton primaryButton = (PrimaryButton) ViewBindings.findChildViewById(view2, i);
                    if (primaryButton != null) {
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view2;
                        i = R.id.fragment_container;
                        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view2, i);
                        if (fragmentContainerView != null) {
                            i = R.id.fragment_container_parent;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                            if (linearLayout2 != null) {
                                i = R.id.google_pay_button;
                                GooglePayButton googlePayButton2 = (GooglePayButton) ViewBindings.findChildViewById(view2, i);
                                if (googlePayButton2 != null) {
                                    i = R.id.google_pay_divider;
                                    ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view2, i);
                                    if (composeView != null) {
                                        i = R.id.header;
                                        ComposeView composeView2 = (ComposeView) ViewBindings.findChildViewById(view2, i);
                                        if (composeView2 != null) {
                                            i = R.id.link_button;
                                            LinkViewButton linkViewButton = (LinkViewButton) ViewBindings.findChildViewById(view2, i);
                                            if (linkViewButton != null) {
                                                i = R.id.message;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView != null) {
                                                    i = R.id.scroll_view;
                                                    ScrollView scrollView2 = (ScrollView) ViewBindings.findChildViewById(view2, i);
                                                    if (scrollView2 != null) {
                                                        i = R.id.testmode;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                        if (textView2 != null) {
                                                            i = R.id.toolbar;
                                                            MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view2, i);
                                                            if (materialToolbar != null) {
                                                                i = R.id.top_container;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.top_message;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                    if (textView3 != null) {
                                                                        return new ActivityPaymentSheetBinding(coordinatorLayout, appBarLayout, linearLayout, frameLayout, primaryButton, coordinatorLayout, fragmentContainerView, linearLayout2, googlePayButton2, composeView, composeView2, linkViewButton, textView, scrollView2, textView2, materialToolbar, linearLayout3, textView3);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

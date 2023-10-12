package com.stripe.android.paymentsheet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.paymentsheet.ui.BillingAddressView;
import com.stripe.android.view.CardMultilineWidget;

public final class FragmentPaymentsheetAddCardBinding implements ViewBinding {
    public final BillingAddressView billingAddress;
    public final TextView billingAddressLabel;
    public final TextView billingErrors;
    public final Space bottomSpace;
    public final TextView cardErrors;
    public final TextView cardInfoLabel;
    public final CardMultilineWidget cardMultilineWidget;
    public final MaterialCardView cardMultilineWidgetContainer;
    private final ConstraintLayout rootView;
    public final MaterialCheckBox saveCardCheckbox;

    private FragmentPaymentsheetAddCardBinding(ConstraintLayout constraintLayout, BillingAddressView billingAddressView, TextView textView, TextView textView2, Space space, TextView textView3, TextView textView4, CardMultilineWidget cardMultilineWidget2, MaterialCardView materialCardView, MaterialCheckBox materialCheckBox) {
        this.rootView = constraintLayout;
        this.billingAddress = billingAddressView;
        this.billingAddressLabel = textView;
        this.billingErrors = textView2;
        this.bottomSpace = space;
        this.cardErrors = textView3;
        this.cardInfoLabel = textView4;
        this.cardMultilineWidget = cardMultilineWidget2;
        this.cardMultilineWidgetContainer = materialCardView;
        this.saveCardCheckbox = materialCheckBox;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPaymentsheetAddCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentPaymentsheetAddCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_paymentsheet_add_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentPaymentsheetAddCardBinding bind(View view) {
        int i = R.id.billing_address;
        BillingAddressView billingAddressView = (BillingAddressView) ViewBindings.findChildViewById(view, i);
        if (billingAddressView != null) {
            i = R.id.billing_address_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.billing_errors;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.bottom_space;
                    Space space = (Space) ViewBindings.findChildViewById(view, i);
                    if (space != null) {
                        i = R.id.card_errors;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.card_info_label;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.card_multiline_widget;
                                CardMultilineWidget cardMultilineWidget2 = (CardMultilineWidget) ViewBindings.findChildViewById(view, i);
                                if (cardMultilineWidget2 != null) {
                                    i = R.id.card_multiline_widget_container;
                                    MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                                    if (materialCardView != null) {
                                        i = R.id.save_card_checkbox;
                                        MaterialCheckBox materialCheckBox = (MaterialCheckBox) ViewBindings.findChildViewById(view, i);
                                        if (materialCheckBox != null) {
                                            return new FragmentPaymentsheetAddCardBinding((ConstraintLayout) view, billingAddressView, textView, textView2, space, textView3, textView4, cardMultilineWidget2, materialCardView, materialCheckBox);
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

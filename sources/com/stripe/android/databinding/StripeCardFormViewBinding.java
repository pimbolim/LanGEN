package com.stripe.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.R;
import com.stripe.android.view.CardMultilineWidget;
import com.stripe.android.view.CountryTextInputLayout;
import com.stripe.android.view.PostalCodeEditText;
import java.util.Objects;

public final class StripeCardFormViewBinding implements ViewBinding {
    public final CardMultilineWidget cardMultilineWidget;
    public final MaterialCardView cardMultilineWidgetContainer;
    public final CountryTextInputLayout countryLayout;
    public final View countryPostalDivider;
    public final TextView errors;
    public final PostalCodeEditText postalCode;
    public final TextInputLayout postalCodeContainer;
    private final View rootView;

    private StripeCardFormViewBinding(View view, CardMultilineWidget cardMultilineWidget2, MaterialCardView materialCardView, CountryTextInputLayout countryTextInputLayout, View view2, TextView textView, PostalCodeEditText postalCodeEditText, TextInputLayout textInputLayout) {
        this.rootView = view;
        this.cardMultilineWidget = cardMultilineWidget2;
        this.cardMultilineWidgetContainer = materialCardView;
        this.countryLayout = countryTextInputLayout;
        this.countryPostalDivider = view2;
        this.errors = textView;
        this.postalCode = postalCodeEditText;
        this.postalCodeContainer = textInputLayout;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static StripeCardFormViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(R.layout.stripe_card_form_view, viewGroup);
        return bind(viewGroup);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.stripe.android.R.id.country_postal_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.stripe.android.databinding.StripeCardFormViewBinding bind(android.view.View r11) {
        /*
            int r0 = com.stripe.android.R.id.card_multiline_widget
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            com.stripe.android.view.CardMultilineWidget r4 = (com.stripe.android.view.CardMultilineWidget) r4
            if (r4 == 0) goto L_0x0052
            int r0 = com.stripe.android.R.id.card_multiline_widget_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            com.google.android.material.card.MaterialCardView r5 = (com.google.android.material.card.MaterialCardView) r5
            if (r5 == 0) goto L_0x0052
            int r0 = com.stripe.android.R.id.country_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            com.stripe.android.view.CountryTextInputLayout r6 = (com.stripe.android.view.CountryTextInputLayout) r6
            if (r6 == 0) goto L_0x0052
            int r0 = com.stripe.android.R.id.country_postal_divider
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r7 == 0) goto L_0x0052
            int r0 = com.stripe.android.R.id.errors
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0052
            int r0 = com.stripe.android.R.id.postal_code
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            com.stripe.android.view.PostalCodeEditText r9 = (com.stripe.android.view.PostalCodeEditText) r9
            if (r9 == 0) goto L_0x0052
            int r0 = com.stripe.android.R.id.postal_code_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            if (r10 == 0) goto L_0x0052
            com.stripe.android.databinding.StripeCardFormViewBinding r0 = new com.stripe.android.databinding.StripeCardFormViewBinding
            r2 = r0
            r3 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0052:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.databinding.StripeCardFormViewBinding.bind(android.view.View):com.stripe.android.databinding.StripeCardFormViewBinding");
    }
}

package com.stripe.android.paymentsheet.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.view.CountryTextInputLayout;
import com.stripe.android.view.StripeEditText;
import java.util.Objects;

public final class StripeBillingAddressLayoutBinding implements ViewBinding {
    public final TextInputEditText address1;
    public final View address1Divider;
    public final TextInputLayout address1Layout;
    public final TextInputEditText address2;
    public final View address2Divider;
    public final TextInputLayout address2Layout;
    public final TextInputEditText city;
    public final TextInputLayout cityLayout;
    public final LinearLayout cityPostalContainer;
    public final View cityPostalDivider;
    public final CountryTextInputLayout countryLayout;
    public final StripeEditText postalCode;
    public final TextInputLayout postalCodeLayout;
    private final View rootView;
    public final TextInputEditText state;
    public final View stateDivider;
    public final TextInputLayout stateLayout;

    private StripeBillingAddressLayoutBinding(View view, TextInputEditText textInputEditText, View view2, TextInputLayout textInputLayout, TextInputEditText textInputEditText2, View view3, TextInputLayout textInputLayout2, TextInputEditText textInputEditText3, TextInputLayout textInputLayout3, LinearLayout linearLayout, View view4, CountryTextInputLayout countryTextInputLayout, StripeEditText stripeEditText, TextInputLayout textInputLayout4, TextInputEditText textInputEditText4, View view5, TextInputLayout textInputLayout5) {
        this.rootView = view;
        this.address1 = textInputEditText;
        this.address1Divider = view2;
        this.address1Layout = textInputLayout;
        this.address2 = textInputEditText2;
        this.address2Divider = view3;
        this.address2Layout = textInputLayout2;
        this.city = textInputEditText3;
        this.cityLayout = textInputLayout3;
        this.cityPostalContainer = linearLayout;
        this.cityPostalDivider = view4;
        this.countryLayout = countryTextInputLayout;
        this.postalCode = stripeEditText;
        this.postalCodeLayout = textInputLayout4;
        this.state = textInputEditText4;
        this.stateDivider = view5;
        this.stateLayout = textInputLayout5;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static StripeBillingAddressLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(R.layout.stripe_billing_address_layout, viewGroup);
        return bind(viewGroup);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        r0 = com.stripe.android.paymentsheet.R.id.city_postal_divider;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0088, code lost:
        r0 = com.stripe.android.paymentsheet.R.id.state_divider;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = com.stripe.android.paymentsheet.R.id.address1_divider;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        r0 = com.stripe.android.paymentsheet.R.id.address2_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.stripe.android.paymentsheet.databinding.StripeBillingAddressLayoutBinding bind(android.view.View r19) {
        /*
            r1 = r19
            int r0 = com.stripe.android.paymentsheet.R.id.address1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.google.android.material.textfield.TextInputEditText r2 = (com.google.android.material.textfield.TextInputEditText) r2
            if (r2 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.address1_divider
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            if (r3 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.address1_layout
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            if (r4 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.address2
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.google.android.material.textfield.TextInputEditText r5 = (com.google.android.material.textfield.TextInputEditText) r5
            if (r5 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.address2_divider
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            if (r6 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.address2_layout
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.google.android.material.textfield.TextInputLayout r7 = (com.google.android.material.textfield.TextInputLayout) r7
            if (r7 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.city
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.google.android.material.textfield.TextInputEditText r8 = (com.google.android.material.textfield.TextInputEditText) r8
            if (r8 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.city_layout
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.google.android.material.textfield.TextInputLayout r9 = (com.google.android.material.textfield.TextInputLayout) r9
            if (r9 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.city_postal_container
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.city_postal_divider
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            if (r11 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.country_layout
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.stripe.android.view.CountryTextInputLayout r12 = (com.stripe.android.view.CountryTextInputLayout) r12
            if (r12 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.postal_code
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.stripe.android.view.StripeEditText r13 = (com.stripe.android.view.StripeEditText) r13
            if (r13 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.postal_code_layout
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.google.android.material.textfield.TextInputLayout r14 = (com.google.android.material.textfield.TextInputLayout) r14
            if (r14 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.state
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.google.android.material.textfield.TextInputEditText r15 = (com.google.android.material.textfield.TextInputEditText) r15
            if (r15 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.state_divider
            android.view.View r16 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            if (r16 == 0) goto L_0x00a4
            int r0 = com.stripe.android.paymentsheet.R.id.state_layout
            android.view.View r17 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.google.android.material.textfield.TextInputLayout r17 = (com.google.android.material.textfield.TextInputLayout) r17
            if (r17 == 0) goto L_0x00a4
            com.stripe.android.paymentsheet.databinding.StripeBillingAddressLayoutBinding r18 = new com.stripe.android.paymentsheet.databinding.StripeBillingAddressLayoutBinding
            r0 = r18
            r1 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r18
        L_0x00a4:
            android.content.res.Resources r1 = r19.getResources()
            java.lang.String r0 = r1.getResourceName(r0)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.databinding.StripeBillingAddressLayoutBinding.bind(android.view.View):com.stripe.android.paymentsheet.databinding.StripeBillingAddressLayoutBinding");
    }
}

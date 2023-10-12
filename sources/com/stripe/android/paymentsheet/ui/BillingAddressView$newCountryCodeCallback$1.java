package com.stripe.android.paymentsheet.ui;

import com.stripe.android.core.model.CountryCode;
import com.stripe.android.core.model.CountryUtils;
import com.stripe.android.paymentsheet.ui.BillingAddressView;
import com.stripe.android.view.PostalCodeValidator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "newCountryCode", "Lcom/stripe/android/core/model/CountryCode;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BillingAddressView.kt */
final class BillingAddressView$newCountryCodeCallback$1 extends Lambda implements Function1<CountryCode, Unit> {
    final /* synthetic */ BillingAddressView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingAddressView$newCountryCodeCallback$1(BillingAddressView billingAddressView) {
        super(1);
        this.this$0 = billingAddressView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CountryCode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CountryCode countryCode) {
        Intrinsics.checkNotNullParameter(countryCode, "newCountryCode");
        this.this$0.updateStateView(countryCode);
        this.this$0.updatePostalCodeView(countryCode);
        this.this$0._address.setValue(this.this$0.createAddress());
        PostalCodeValidator access$getPostalCodeValidator$p = this.this$0.postalCodeValidator;
        BillingAddressView billingAddressView = this.this$0;
        String access$getValue = billingAddressView.getValue(billingAddressView.getPostalCodeView$paymentsheet_release());
        if (access$getValue == null) {
            access$getValue = "";
        }
        boolean isValid = access$getPostalCodeValidator$p.isValid(access$getValue, countryCode.getValue());
        BillingAddressView billingAddressView2 = this.this$0;
        BillingAddressView.PostalCodeViewListener postalCodeViewListener$paymentsheet_release = billingAddressView2.getPostalCodeViewListener$paymentsheet_release();
        if (postalCodeViewListener$paymentsheet_release != null) {
            postalCodeViewListener$paymentsheet_release.onCountryChanged(CountryUtils.INSTANCE.getCountryByCode(countryCode, billingAddressView2.getLocale()), isValid);
        }
        billingAddressView2.getPostalCodeView$paymentsheet_release().setShouldShowError(!isValid);
    }
}

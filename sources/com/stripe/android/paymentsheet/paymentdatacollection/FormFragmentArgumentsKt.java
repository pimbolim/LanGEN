package com.stripe.android.paymentsheet.paymentdatacollection;

import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"getInitialValuesMap", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "", "Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormFragmentArguments.kt */
public final class FormFragmentArgumentsKt {
    public static final Map<IdentifierSpec, String> getInitialValuesMap(FormFragmentArguments formFragmentArguments) {
        PaymentSheet.Address address;
        PaymentSheet.Address address2;
        PaymentSheet.Address address3;
        PaymentSheet.Address address4;
        PaymentSheet.Address address5;
        PaymentSheet.Address address6;
        Intrinsics.checkNotNullParameter(formFragmentArguments, "<this>");
        Pair[] pairArr = new Pair[9];
        IdentifierSpec.Name name = IdentifierSpec.Name.INSTANCE;
        PaymentSheet.BillingDetails billingDetails = formFragmentArguments.getBillingDetails();
        String str = null;
        pairArr[0] = TuplesKt.to(name, billingDetails == null ? null : billingDetails.getName());
        IdentifierSpec.Email email = IdentifierSpec.Email.INSTANCE;
        PaymentSheet.BillingDetails billingDetails2 = formFragmentArguments.getBillingDetails();
        pairArr[1] = TuplesKt.to(email, billingDetails2 == null ? null : billingDetails2.getEmail());
        IdentifierSpec.Phone phone = IdentifierSpec.Phone.INSTANCE;
        PaymentSheet.BillingDetails billingDetails3 = formFragmentArguments.getBillingDetails();
        pairArr[2] = TuplesKt.to(phone, billingDetails3 == null ? null : billingDetails3.getPhone());
        IdentifierSpec.Line1 line1 = IdentifierSpec.Line1.INSTANCE;
        PaymentSheet.BillingDetails billingDetails4 = formFragmentArguments.getBillingDetails();
        pairArr[3] = TuplesKt.to(line1, (billingDetails4 == null || (address6 = billingDetails4.getAddress()) == null) ? null : address6.getLine1());
        IdentifierSpec.Line2 line2 = IdentifierSpec.Line2.INSTANCE;
        PaymentSheet.BillingDetails billingDetails5 = formFragmentArguments.getBillingDetails();
        pairArr[4] = TuplesKt.to(line2, (billingDetails5 == null || (address5 = billingDetails5.getAddress()) == null) ? null : address5.getLine2());
        IdentifierSpec.City city = IdentifierSpec.City.INSTANCE;
        PaymentSheet.BillingDetails billingDetails6 = formFragmentArguments.getBillingDetails();
        pairArr[5] = TuplesKt.to(city, (billingDetails6 == null || (address4 = billingDetails6.getAddress()) == null) ? null : address4.getCity());
        IdentifierSpec.State state = IdentifierSpec.State.INSTANCE;
        PaymentSheet.BillingDetails billingDetails7 = formFragmentArguments.getBillingDetails();
        pairArr[6] = TuplesKt.to(state, (billingDetails7 == null || (address3 = billingDetails7.getAddress()) == null) ? null : address3.getState());
        IdentifierSpec.Country country = IdentifierSpec.Country.INSTANCE;
        PaymentSheet.BillingDetails billingDetails8 = formFragmentArguments.getBillingDetails();
        pairArr[7] = TuplesKt.to(country, (billingDetails8 == null || (address2 = billingDetails8.getAddress()) == null) ? null : address2.getCountry());
        IdentifierSpec.PostalCode postalCode = IdentifierSpec.PostalCode.INSTANCE;
        PaymentSheet.BillingDetails billingDetails9 = formFragmentArguments.getBillingDetails();
        if (!(billingDetails9 == null || (address = billingDetails9.getAddress()) == null)) {
            str = address.getPostalCode();
        }
        pairArr[8] = TuplesKt.to(postalCode, str);
        return MapsKt.mapOf(pairArr);
    }
}

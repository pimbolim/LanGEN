package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Card;
import com.stripe.android.model.CustomerBankAccount;
import com.stripe.android.model.CustomerCard;
import com.stripe.android.model.CustomerPaymentSource;
import com.stripe.android.model.CustomerSource;
import com.stripe.android.model.Source;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/CustomerPaymentSourceJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/CustomerPaymentSource;", "()V", "parse", "json", "Lorg/json/JSONObject;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerPaymentSourceJsonParser.kt */
public final class CustomerPaymentSourceJsonParser implements ModelJsonParser<CustomerPaymentSource> {
    public static final int $stable = 0;

    public CustomerPaymentSource parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        String optString = StripeJsonUtils.optString(jSONObject, "object");
        CustomerPaymentSource customerPaymentSource = null;
        if (optString == null) {
            return null;
        }
        int hashCode = optString.hashCode();
        if (hashCode != -1825227990) {
            if (hashCode != -896505829) {
                if (hashCode != 3046160 || !optString.equals("card")) {
                    return null;
                }
                Card parse = new CardJsonParser().parse(jSONObject);
                if (parse != null) {
                    customerPaymentSource = new CustomerCard(parse);
                }
                return customerPaymentSource;
            } else if (!optString.equals("source")) {
                return null;
            } else {
                Source parse2 = new SourceJsonParser().parse(jSONObject);
                if (parse2 != null) {
                    customerPaymentSource = new CustomerSource(parse2);
                }
                return customerPaymentSource;
            }
        } else if (!optString.equals("bank_account")) {
            return null;
        } else {
            return new CustomerBankAccount(new BankAccountJsonParser().parse(jSONObject));
        }
    }
}

package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.BankAccount;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/BankAccountJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/BankAccount;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BankAccountJsonParser.kt */
public final class BankAccountJsonParser implements ModelJsonParser<BankAccount> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_ACCOUNT_HOLDER_NAME = "account_holder_name";
    @Deprecated
    private static final String FIELD_ACCOUNT_HOLDER_TYPE = "account_holder_type";
    @Deprecated
    private static final String FIELD_BANK_NAME = "bank_name";
    @Deprecated
    private static final String FIELD_COUNTRY = "country";
    @Deprecated
    private static final String FIELD_CURRENCY = "currency";
    @Deprecated
    private static final String FIELD_FINGERPRINT = "fingerprint";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_LAST4 = "last4";
    @Deprecated
    private static final String FIELD_ROUTING_NUMBER = "routing_number";
    @Deprecated
    private static final String FIELD_STATUS = "status";

    public BankAccount parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        return new BankAccount(StripeJsonUtils.optString(jSONObject, "id"), StripeJsonUtils.optString(jSONObject, FIELD_ACCOUNT_HOLDER_NAME), BankAccount.Type.Companion.fromCode$payments_model_release(StripeJsonUtils.optString(jSONObject, FIELD_ACCOUNT_HOLDER_TYPE)), StripeJsonUtils.optString(jSONObject, FIELD_BANK_NAME), StripeJsonUtils.INSTANCE.optCountryCode(jSONObject, "country"), StripeJsonUtils.optCurrency(jSONObject, "currency"), StripeJsonUtils.optString(jSONObject, FIELD_FINGERPRINT), StripeJsonUtils.optString(jSONObject, FIELD_LAST4), StripeJsonUtils.optString(jSONObject, FIELD_ROUTING_NUMBER), BankAccount.Status.Companion.fromCode$payments_model_release(StripeJsonUtils.optString(jSONObject, "status")));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/model/parsers/BankAccountJsonParser$Companion;", "", "()V", "FIELD_ACCOUNT_HOLDER_NAME", "", "FIELD_ACCOUNT_HOLDER_TYPE", "FIELD_BANK_NAME", "FIELD_COUNTRY", "FIELD_CURRENCY", "FIELD_FINGERPRINT", "FIELD_ID", "FIELD_LAST4", "FIELD_ROUTING_NUMBER", "FIELD_STATUS", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankAccountJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

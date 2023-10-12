package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Card;
import com.stripe.android.model.CardFunding;
import com.stripe.android.model.TokenizationMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/CardJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Card;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardJsonParser.kt */
public final class CardJsonParser implements ModelJsonParser<Card> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIELD_ADDRESS_CITY = "address_city";
    private static final String FIELD_ADDRESS_COUNTRY = "address_country";
    private static final String FIELD_ADDRESS_LINE1 = "address_line1";
    private static final String FIELD_ADDRESS_LINE1_CHECK = "address_line1_check";
    private static final String FIELD_ADDRESS_LINE2 = "address_line2";
    private static final String FIELD_ADDRESS_STATE = "address_state";
    private static final String FIELD_ADDRESS_ZIP = "address_zip";
    private static final String FIELD_ADDRESS_ZIP_CHECK = "address_zip_check";
    private static final String FIELD_BRAND = "brand";
    private static final String FIELD_COUNTRY = "country";
    private static final String FIELD_CURRENCY = "currency";
    private static final String FIELD_CUSTOMER = "customer";
    private static final String FIELD_CVC_CHECK = "cvc_check";
    private static final String FIELD_EXP_MONTH = "exp_month";
    private static final String FIELD_EXP_YEAR = "exp_year";
    private static final String FIELD_FINGERPRINT = "fingerprint";
    private static final String FIELD_FUNDING = "funding";
    private static final String FIELD_ID = "id";
    private static final String FIELD_LAST4 = "last4";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_OBJECT = "object";
    private static final String FIELD_TOKENIZATION_METHOD = "tokenization_method";
    public static final String VALUE_CARD = "card";

    public Card parse(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.checkNotNullParameter(jSONObject2, "json");
        if (!Intrinsics.areEqual((Object) "card", (Object) jSONObject2.optString(FIELD_OBJECT))) {
            return null;
        }
        Integer optInteger = StripeJsonUtils.INSTANCE.optInteger(jSONObject2, FIELD_EXP_MONTH);
        int i = -1;
        Integer valueOf = Integer.valueOf(optInteger == null ? -1 : optInteger.intValue());
        int intValue = valueOf.intValue();
        boolean z = false;
        Integer num = !(intValue < 1 || intValue > 12) ? valueOf : null;
        Integer optInteger2 = StripeJsonUtils.INSTANCE.optInteger(jSONObject2, FIELD_EXP_YEAR);
        if (optInteger2 != null) {
            i = optInteger2.intValue();
        }
        Integer valueOf2 = Integer.valueOf(i);
        if (valueOf2.intValue() < 0) {
            z = true;
        }
        Integer num2 = !z ? valueOf2 : null;
        String optString = StripeJsonUtils.optString(jSONObject2, FIELD_ADDRESS_CITY);
        return new Card(num, num2, StripeJsonUtils.optString(jSONObject2, "name"), StripeJsonUtils.optString(jSONObject2, FIELD_ADDRESS_LINE1), StripeJsonUtils.optString(jSONObject2, FIELD_ADDRESS_LINE1_CHECK), StripeJsonUtils.optString(jSONObject2, FIELD_ADDRESS_LINE2), optString, StripeJsonUtils.optString(jSONObject2, FIELD_ADDRESS_STATE), StripeJsonUtils.optString(jSONObject2, FIELD_ADDRESS_ZIP), StripeJsonUtils.optString(jSONObject2, FIELD_ADDRESS_ZIP_CHECK), StripeJsonUtils.optString(jSONObject2, FIELD_ADDRESS_COUNTRY), StripeJsonUtils.optString(jSONObject2, FIELD_LAST4), Card.Companion.getCardBrand(StripeJsonUtils.optString(jSONObject2, "brand")), CardFunding.Companion.fromCode(StripeJsonUtils.optString(jSONObject2, FIELD_FUNDING)), StripeJsonUtils.optString(jSONObject2, FIELD_FINGERPRINT), StripeJsonUtils.INSTANCE.optCountryCode(jSONObject2, "country"), StripeJsonUtils.optCurrency(jSONObject2, "currency"), StripeJsonUtils.optString(jSONObject2, FIELD_CUSTOMER), StripeJsonUtils.optString(jSONObject2, FIELD_CVC_CHECK), StripeJsonUtils.optString(jSONObject2, "id"), TokenizationMethod.Companion.fromCode(StripeJsonUtils.optString(jSONObject2, FIELD_TOKENIZATION_METHOD)));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/model/parsers/CardJsonParser$Companion;", "", "()V", "FIELD_ADDRESS_CITY", "", "FIELD_ADDRESS_COUNTRY", "FIELD_ADDRESS_LINE1", "FIELD_ADDRESS_LINE1_CHECK", "FIELD_ADDRESS_LINE2", "FIELD_ADDRESS_STATE", "FIELD_ADDRESS_ZIP", "FIELD_ADDRESS_ZIP_CHECK", "FIELD_BRAND", "FIELD_COUNTRY", "FIELD_CURRENCY", "FIELD_CUSTOMER", "FIELD_CVC_CHECK", "FIELD_EXP_MONTH", "FIELD_EXP_YEAR", "FIELD_FINGERPRINT", "FIELD_FUNDING", "FIELD_ID", "FIELD_LAST4", "FIELD_NAME", "FIELD_OBJECT", "FIELD_TOKENIZATION_METHOD", "VALUE_CARD", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardJsonParser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Card;
import com.stripe.android.model.CardFunding;
import com.stripe.android.model.SourceTypeModel;
import com.stripe.android.model.TokenizationMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/SourceCardDataJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/SourceTypeModel$Card;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SourceCardDataJsonParser.kt */
public final class SourceCardDataJsonParser implements ModelJsonParser<SourceTypeModel.Card> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIELD_ADDRESS_LINE1_CHECK = "address_line1_check";
    private static final String FIELD_ADDRESS_ZIP_CHECK = "address_zip_check";
    private static final String FIELD_BRAND = "brand";
    private static final String FIELD_COUNTRY = "country";
    private static final String FIELD_CVC_CHECK = "cvc_check";
    private static final String FIELD_DYNAMIC_LAST4 = "dynamic_last4";
    private static final String FIELD_EXP_MONTH = "exp_month";
    private static final String FIELD_EXP_YEAR = "exp_year";
    private static final String FIELD_FUNDING = "funding";
    private static final String FIELD_LAST4 = "last4";
    private static final String FIELD_THREE_D_SECURE = "three_d_secure";
    private static final String FIELD_TOKENIZATION_METHOD = "tokenization_method";

    public SourceTypeModel.Card parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        return new SourceTypeModel.Card(StripeJsonUtils.optString(jSONObject, FIELD_ADDRESS_LINE1_CHECK), StripeJsonUtils.optString(jSONObject, FIELD_ADDRESS_ZIP_CHECK), Card.Companion.getCardBrand(StripeJsonUtils.optString(jSONObject, "brand")), StripeJsonUtils.optString(jSONObject, "country"), StripeJsonUtils.optString(jSONObject, FIELD_CVC_CHECK), StripeJsonUtils.optString(jSONObject, FIELD_DYNAMIC_LAST4), StripeJsonUtils.INSTANCE.optInteger(jSONObject, FIELD_EXP_MONTH), StripeJsonUtils.INSTANCE.optInteger(jSONObject, FIELD_EXP_YEAR), CardFunding.Companion.fromCode(StripeJsonUtils.optString(jSONObject, FIELD_FUNDING)), StripeJsonUtils.optString(jSONObject, FIELD_LAST4), SourceTypeModel.Card.ThreeDSecureStatus.Companion.fromCode(StripeJsonUtils.optString(jSONObject, "three_d_secure")), TokenizationMethod.Companion.fromCode(StripeJsonUtils.optString(jSONObject, FIELD_TOKENIZATION_METHOD)));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/model/parsers/SourceCardDataJsonParser$Companion;", "", "()V", "FIELD_ADDRESS_LINE1_CHECK", "", "FIELD_ADDRESS_ZIP_CHECK", "FIELD_BRAND", "FIELD_COUNTRY", "FIELD_CVC_CHECK", "FIELD_DYNAMIC_LAST4", "FIELD_EXP_MONTH", "FIELD_EXP_YEAR", "FIELD_FUNDING", "FIELD_LAST4", "FIELD_THREE_D_SECURE", "FIELD_TOKENIZATION_METHOD", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceCardDataJsonParser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

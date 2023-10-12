package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.StripeIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u000f*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000fB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0017\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fR\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodPreferenceJsonParser;", "StripeIntentType", "Lcom/stripe/android/model/StripeIntent;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "()V", "stripeIntentFieldName", "", "getStripeIntentFieldName", "()Ljava/lang/String;", "parse", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Lcom/stripe/android/model/StripeIntent;", "parseStripeIntent", "stripeIntentJson", "Companion", "Lcom/stripe/android/model/parsers/PaymentMethodPreferenceForPaymentIntentJsonParser;", "Lcom/stripe/android/model/parsers/PaymentMethodPreferenceForSetupIntentJsonParser;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodPreferenceJsonParser.kt */
public abstract class PaymentMethodPreferenceJsonParser<StripeIntentType extends StripeIntent> implements ModelJsonParser<StripeIntentType> {
    protected static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIELD_OBJECT = "object";
    private static final String FIELD_ORDERED_PAYMENT_METHOD_TYPES = "ordered_payment_method_types";
    private static final String FIELD_PAYMENT_METHOD_TYPES = "payment_method_types";
    private static final String FIELD_UNACTIVATED_PAYMENT_METHOD_TYPES = "unactivated_payment_method_types";
    private static final String OBJECT_TYPE = "payment_method_preference";

    public /* synthetic */ PaymentMethodPreferenceJsonParser(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getStripeIntentFieldName();

    public abstract StripeIntentType parseStripeIntent(JSONObject jSONObject);

    private PaymentMethodPreferenceJsonParser() {
    }

    public StripeIntentType parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        JSONObject mapToJsonObject = StripeJsonUtils.INSTANCE.mapToJsonObject(StripeJsonUtils.INSTANCE.optMap(jSONObject, OBJECT_TYPE));
        String optString = StripeJsonUtils.optString(mapToJsonObject, FIELD_OBJECT);
        if (mapToJsonObject == null || !Intrinsics.areEqual((Object) OBJECT_TYPE, (Object) optString)) {
            return null;
        }
        JSONArray optJSONArray = mapToJsonObject.optJSONArray(FIELD_ORDERED_PAYMENT_METHOD_TYPES);
        JSONArray optJSONArray2 = jSONObject.optJSONArray(FIELD_UNACTIVATED_PAYMENT_METHOD_TYPES);
        JSONObject optJSONObject = mapToJsonObject.optJSONObject(getStripeIntentFieldName());
        if (optJSONObject == null) {
            return null;
        }
        optJSONObject.put(FIELD_PAYMENT_METHOD_TYPES, optJSONArray);
        optJSONObject.put(FIELD_UNACTIVATED_PAYMENT_METHOD_TYPES, optJSONArray2);
        return parseStripeIntent(optJSONObject);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodPreferenceJsonParser$Companion;", "", "()V", "FIELD_OBJECT", "", "FIELD_ORDERED_PAYMENT_METHOD_TYPES", "FIELD_PAYMENT_METHOD_TYPES", "FIELD_UNACTIVATED_PAYMENT_METHOD_TYPES", "OBJECT_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodPreferenceJsonParser.kt */
    protected static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

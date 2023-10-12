package com.stripe.android.model.parsers;

import com.stripe.android.model.PaymentIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodPreferenceForPaymentIntentJsonParser;", "Lcom/stripe/android/model/parsers/PaymentMethodPreferenceJsonParser;", "Lcom/stripe/android/model/PaymentIntent;", "()V", "stripeIntentFieldName", "", "getStripeIntentFieldName", "()Ljava/lang/String;", "parseStripeIntent", "stripeIntentJson", "Lorg/json/JSONObject;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodPreferenceJsonParser.kt */
public final class PaymentMethodPreferenceForPaymentIntentJsonParser extends PaymentMethodPreferenceJsonParser<PaymentIntent> {
    private final String stripeIntentFieldName = "payment_intent";

    public PaymentMethodPreferenceForPaymentIntentJsonParser() {
        super((DefaultConstructorMarker) null);
    }

    public String getStripeIntentFieldName() {
        return this.stripeIntentFieldName;
    }

    public PaymentIntent parseStripeIntent(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "stripeIntentJson");
        return new PaymentIntentJsonParser().parse(jSONObject);
    }
}

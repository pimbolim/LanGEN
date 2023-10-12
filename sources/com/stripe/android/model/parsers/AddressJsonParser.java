package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Address;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/AddressJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Address;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddressJsonParser.kt */
public final class AddressJsonParser implements ModelJsonParser<Address> {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_CITY = "city";
    @Deprecated
    private static final String FIELD_COUNTRY = "country";
    @Deprecated
    private static final String FIELD_LINE_1 = "line1";
    @Deprecated
    private static final String FIELD_LINE_2 = "line2";
    @Deprecated
    private static final String FIELD_POSTAL_CODE = "postal_code";
    @Deprecated
    private static final String FIELD_STATE = "state";

    public Address parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        return new Address(StripeJsonUtils.optString(jSONObject, "city"), StripeJsonUtils.optString(jSONObject, "country"), StripeJsonUtils.optString(jSONObject, "line1"), StripeJsonUtils.optString(jSONObject, "line2"), StripeJsonUtils.optString(jSONObject, "postal_code"), StripeJsonUtils.optString(jSONObject, "state"));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/parsers/AddressJsonParser$Companion;", "", "()V", "FIELD_CITY", "", "FIELD_COUNTRY", "FIELD_LINE_1", "FIELD_LINE_2", "FIELD_POSTAL_CODE", "FIELD_STATE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddressJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

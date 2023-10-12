package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.ConsumerPaymentDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/parsers/ConsumerPaymentDetailsJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/ConsumerPaymentDetails;", "()V", "parse", "json", "Lorg/json/JSONObject;", "parsePaymentDetails", "Lcom/stripe/android/model/ConsumerPaymentDetails$PaymentDetails;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConsumerPaymentDetailsJsonParser.kt */
public final class ConsumerPaymentDetailsJsonParser implements ModelJsonParser<ConsumerPaymentDetails> {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_CARD_BRAND = "brand";
    @Deprecated
    private static final String FIELD_CARD_DETAILS = "card_details";
    @Deprecated
    private static final String FIELD_CARD_EXPIRY_MONTH = "exp_month";
    @Deprecated
    private static final String FIELD_CARD_EXPIRY_YEAR = "exp_year";
    @Deprecated
    private static final String FIELD_CARD_LAST_4 = "last4";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_IS_DEFAULT = "is_default";
    @Deprecated
    private static final String FIELD_PAYMENT_DETAILS = "redacted_payment_details";
    @Deprecated
    private static final String FIELD_TYPE = "type";

    public ConsumerPaymentDetails parse(JSONObject jSONObject) {
        List list;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        JSONArray optJSONArray = jSONObject.optJSONArray(FIELD_PAYMENT_DETAILS);
        if (optJSONArray == null) {
            list = null;
        } else {
            Iterable until = RangesKt.until(0, optJSONArray.length());
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(optJSONArray.getJSONObject(((IntIterator) it).nextInt()));
            }
            Collection arrayList2 = new ArrayList();
            for (JSONObject jSONObject2 : (List) arrayList) {
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "it");
                ConsumerPaymentDetails.PaymentDetails parsePaymentDetails = parsePaymentDetails(jSONObject2);
                if (parsePaymentDetails != null) {
                    arrayList2.add(parsePaymentDetails);
                }
            }
            list = (List) arrayList2;
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return new ConsumerPaymentDetails(list);
    }

    private final ConsumerPaymentDetails.PaymentDetails parsePaymentDetails(JSONObject jSONObject) {
        String optString = StripeJsonUtils.optString(jSONObject, "type");
        ConsumerPaymentDetails.Card card = null;
        if (optString != null) {
            String lowerCase = optString.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (Intrinsics.areEqual((Object) lowerCase, (Object) "card")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(FIELD_CARD_DETAILS);
                String string = jSONObject.getString("id");
                Intrinsics.checkNotNullExpressionValue(string, "json.getString(FIELD_ID)");
                boolean z = jSONObject.getBoolean(FIELD_IS_DEFAULT);
                int i = jSONObject2.getInt(FIELD_CARD_EXPIRY_YEAR);
                int i2 = jSONObject2.getInt(FIELD_CARD_EXPIRY_MONTH);
                CardBrand fromCode = CardBrand.Companion.fromCode(jSONObject2.getString("brand"));
                String string2 = jSONObject2.getString(FIELD_CARD_LAST_4);
                Intrinsics.checkNotNullExpressionValue(string2, "cardDetails.getString(FIELD_CARD_LAST_4)");
                card = new ConsumerPaymentDetails.Card(string, z, i, i2, fromCode, string2);
            }
        }
        return card;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/model/parsers/ConsumerPaymentDetailsJsonParser$Companion;", "", "()V", "FIELD_CARD_BRAND", "", "FIELD_CARD_DETAILS", "FIELD_CARD_EXPIRY_MONTH", "FIELD_CARD_EXPIRY_YEAR", "FIELD_CARD_LAST_4", "FIELD_ID", "FIELD_IS_DEFAULT", "FIELD_PAYMENT_DETAILS", "FIELD_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConsumerPaymentDetailsJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

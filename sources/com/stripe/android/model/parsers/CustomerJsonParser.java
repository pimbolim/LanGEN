package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Customer;
import com.stripe.android.model.CustomerPaymentSource;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.TokenizationMethod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/parsers/CustomerJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Customer;", "()V", "customerSourceJsonParser", "Lcom/stripe/android/model/parsers/CustomerPaymentSourceJsonParser;", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerJsonParser.kt */
public final class CustomerJsonParser implements ModelJsonParser<Customer> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_DATA = "data";
    @Deprecated
    private static final String FIELD_DEFAULT_SOURCE = "default_source";
    @Deprecated
    private static final String FIELD_DESCRIPTION = "description";
    @Deprecated
    private static final String FIELD_EMAIL = "email";
    @Deprecated
    private static final String FIELD_HAS_MORE = "has_more";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_LIVEMODE = "livemode";
    @Deprecated
    private static final String FIELD_OBJECT = "object";
    @Deprecated
    private static final String FIELD_SHIPPING = "shipping";
    @Deprecated
    private static final String FIELD_SOURCES = "sources";
    @Deprecated
    private static final String FIELD_TOTAL_COUNT = "total_count";
    @Deprecated
    private static final String FIELD_URL = "url";
    @Deprecated
    private static final String VALUE_CUSTOMER = "customer";
    @Deprecated
    private static final String VALUE_LIST = "list";
    private final CustomerPaymentSourceJsonParser customerSourceJsonParser = new CustomerPaymentSourceJsonParser();

    public Customer parse(JSONObject jSONObject) {
        ShippingInformation shippingInformation;
        String str;
        Integer num;
        boolean z;
        List list;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        if (!Intrinsics.areEqual((Object) VALUE_CUSTOMER, (Object) StripeJsonUtils.optString(jSONObject, FIELD_OBJECT))) {
            return null;
        }
        String optString = StripeJsonUtils.optString(jSONObject, "id");
        String optString2 = StripeJsonUtils.optString(jSONObject, FIELD_DEFAULT_SOURCE);
        JSONObject optJSONObject = jSONObject.optJSONObject("shipping");
        if (optJSONObject == null) {
            shippingInformation = null;
        } else {
            shippingInformation = new ShippingInformationJsonParser().parse(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(FIELD_SOURCES);
        if (optJSONObject2 == null || !Intrinsics.areEqual((Object) VALUE_LIST, (Object) StripeJsonUtils.optString(optJSONObject2, FIELD_OBJECT))) {
            list = CollectionsKt.emptyList();
            num = null;
            str = null;
            z = false;
        } else {
            boolean optBoolean = StripeJsonUtils.INSTANCE.optBoolean(optJSONObject2, FIELD_HAS_MORE);
            Integer optInteger = StripeJsonUtils.INSTANCE.optInteger(optJSONObject2, FIELD_TOTAL_COUNT);
            String optString3 = StripeJsonUtils.optString(optJSONObject2, "url");
            JSONArray optJSONArray = optJSONObject2.optJSONArray("data");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            Iterable until = RangesKt.until(0, optJSONArray.length());
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(optJSONArray.getJSONObject(((IntIterator) it).nextInt()));
            }
            Collection arrayList2 = new ArrayList();
            for (JSONObject jSONObject2 : (List) arrayList) {
                CustomerPaymentSourceJsonParser customerPaymentSourceJsonParser = this.customerSourceJsonParser;
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "it");
                CustomerPaymentSource parse = customerPaymentSourceJsonParser.parse(jSONObject2);
                if (parse != null) {
                    arrayList2.add(parse);
                }
            }
            Collection arrayList3 = new ArrayList();
            for (Object next : (List) arrayList2) {
                if (!(((CustomerPaymentSource) next).getTokenizationMethod() == TokenizationMethod.ApplePay)) {
                    arrayList3.add(next);
                }
            }
            num = optInteger;
            str = optString3;
            list = (List) arrayList3;
            z = optBoolean;
        }
        return new Customer(optString, optString2, shippingInformation, list, z, num, str, StripeJsonUtils.optString(jSONObject, FIELD_DESCRIPTION), StripeJsonUtils.optString(jSONObject, "email"), jSONObject.optBoolean(FIELD_LIVEMODE, false));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/model/parsers/CustomerJsonParser$Companion;", "", "()V", "FIELD_DATA", "", "FIELD_DEFAULT_SOURCE", "FIELD_DESCRIPTION", "FIELD_EMAIL", "FIELD_HAS_MORE", "FIELD_ID", "FIELD_LIVEMODE", "FIELD_OBJECT", "FIELD_SHIPPING", "FIELD_SOURCES", "FIELD_TOTAL_COUNT", "FIELD_URL", "VALUE_CUSTOMER", "VALUE_LIST", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

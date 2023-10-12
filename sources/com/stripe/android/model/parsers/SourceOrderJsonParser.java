package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Address;
import com.stripe.android.model.SourceOrder;
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

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/parsers/SourceOrderJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/SourceOrder;", "()V", "itemJsonParser", "Lcom/stripe/android/model/parsers/SourceOrderJsonParser$ItemJsonParser;", "parse", "json", "Lorg/json/JSONObject;", "Companion", "ItemJsonParser", "ShippingJsonParser", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SourceOrderJsonParser.kt */
public final class SourceOrderJsonParser implements ModelJsonParser<SourceOrder> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_AMOUNT = "amount";
    @Deprecated
    private static final String FIELD_CURRENCY = "currency";
    @Deprecated
    private static final String FIELD_EMAIL = "email";
    @Deprecated
    private static final String FIELD_ITEMS = "items";
    @Deprecated
    private static final String FIELD_SHIPPING = "shipping";
    private final ItemJsonParser itemJsonParser = new ItemJsonParser();

    public SourceOrder parse(JSONObject jSONObject) {
        SourceOrder.Shipping shipping;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        JSONArray optJSONArray = jSONObject.optJSONArray(FIELD_ITEMS);
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        Iterable until = RangesKt.until(0, optJSONArray.length());
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(optJSONArray.optJSONObject(((IntIterator) it).nextInt()));
        }
        Collection arrayList2 = new ArrayList();
        for (JSONObject jSONObject2 : (List) arrayList) {
            ItemJsonParser itemJsonParser2 = this.itemJsonParser;
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "it");
            SourceOrder.Item parse = itemJsonParser2.parse(jSONObject2);
            if (parse != null) {
                arrayList2.add(parse);
            }
        }
        List list = (List) arrayList2;
        Integer optInteger = StripeJsonUtils.INSTANCE.optInteger(jSONObject, "amount");
        String optString = StripeJsonUtils.optString(jSONObject, "currency");
        String optString2 = StripeJsonUtils.optString(jSONObject, "email");
        JSONObject optJSONObject = jSONObject.optJSONObject("shipping");
        if (optJSONObject == null) {
            shipping = null;
        } else {
            shipping = new ShippingJsonParser().parse(optJSONObject);
        }
        return new SourceOrder(optInteger, optString, optString2, list, shipping);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/SourceOrderJsonParser$ItemJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/SourceOrder$Item;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceOrderJsonParser.kt */
    public static final class ItemJsonParser implements ModelJsonParser<SourceOrder.Item> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_AMOUNT = "amount";
        @Deprecated
        private static final String FIELD_CURRENCY = "currency";
        @Deprecated
        private static final String FIELD_DESCRIPTION = "description";
        @Deprecated
        private static final String FIELD_QUANTITY = "quantity";
        @Deprecated
        private static final String FIELD_TYPE = "type";

        public SourceOrder.Item parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            SourceOrder.Item.Type fromCode$payments_core_release = SourceOrder.Item.Type.Companion.fromCode$payments_core_release(StripeJsonUtils.optString(jSONObject, "type"));
            if (fromCode$payments_core_release != null) {
                return new SourceOrder.Item(fromCode$payments_core_release, StripeJsonUtils.INSTANCE.optInteger(jSONObject, "amount"), StripeJsonUtils.optString(jSONObject, "currency"), StripeJsonUtils.optString(jSONObject, FIELD_DESCRIPTION), StripeJsonUtils.INSTANCE.optInteger(jSONObject, "quantity"));
            }
            return null;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/parsers/SourceOrderJsonParser$ItemJsonParser$Companion;", "", "()V", "FIELD_AMOUNT", "", "FIELD_CURRENCY", "FIELD_DESCRIPTION", "FIELD_QUANTITY", "FIELD_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceOrderJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/SourceOrderJsonParser$ShippingJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/SourceOrder$Shipping;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceOrderJsonParser.kt */
    public static final class ShippingJsonParser implements ModelJsonParser<SourceOrder.Shipping> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_ADDRESS = "address";
        @Deprecated
        private static final String FIELD_CARRIER = "carrier";
        @Deprecated
        private static final String FIELD_NAME = "name";
        @Deprecated
        private static final String FIELD_PHONE = "phone";
        @Deprecated
        private static final String FIELD_TRACKING_NUMBER = "tracking_number";

        public SourceOrder.Shipping parse(JSONObject jSONObject) {
            Address address;
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            JSONObject optJSONObject = jSONObject.optJSONObject("address");
            if (optJSONObject == null) {
                address = null;
            } else {
                address = new AddressJsonParser().parse(optJSONObject);
            }
            return new SourceOrder.Shipping(address, StripeJsonUtils.optString(jSONObject, FIELD_CARRIER), StripeJsonUtils.optString(jSONObject, "name"), StripeJsonUtils.optString(jSONObject, "phone"), StripeJsonUtils.optString(jSONObject, FIELD_TRACKING_NUMBER));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/parsers/SourceOrderJsonParser$ShippingJsonParser$Companion;", "", "()V", "FIELD_ADDRESS", "", "FIELD_CARRIER", "FIELD_NAME", "FIELD_PHONE", "FIELD_TRACKING_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceOrderJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/parsers/SourceOrderJsonParser$Companion;", "", "()V", "FIELD_AMOUNT", "", "FIELD_CURRENCY", "FIELD_EMAIL", "FIELD_ITEMS", "FIELD_SHIPPING", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceOrderJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

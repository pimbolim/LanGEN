package com.stripe.android.model.parsers;

import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodsList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodsListJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethodsList;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsListJsonParser.kt */
public final class PaymentMethodsListJsonParser implements ModelJsonParser<PaymentMethodsList> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_DATA = "data";
    @Deprecated
    private static final PaymentMethodJsonParser PAYMENT_METHOD_JSON_PARSER = new PaymentMethodJsonParser();

    public PaymentMethodsList parse(JSONObject jSONObject) {
        List list;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        try {
            Result.Companion companion = Result.Companion;
            PaymentMethodsListJsonParser paymentMethodsListJsonParser = this;
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            Collection arrayList = new ArrayList();
            Iterator it = RangesKt.until(0, optJSONArray.length()).iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                PaymentMethodJsonParser paymentMethodJsonParser = PAYMENT_METHOD_JSON_PARSER;
                JSONObject optJSONObject = optJSONArray.optJSONObject(nextInt);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "data.optJSONObject(it)");
                PaymentMethod parse = paymentMethodJsonParser.parse(optJSONObject);
                if (parse != null) {
                    arrayList.add(parse);
                }
            }
            list = Result.m4709constructorimpl((List) arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            list = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        List emptyList = CollectionsKt.emptyList();
        if (Result.m4715isFailureimpl(list)) {
            list = emptyList;
        }
        return new PaymentMethodsList((List) list);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodsListJsonParser$Companion;", "", "()V", "FIELD_DATA", "", "PAYMENT_METHOD_JSON_PARSER", "Lcom/stripe/android/model/parsers/PaymentMethodJsonParser;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsListJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

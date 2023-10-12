package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.networking.FraudDetectionData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/parsers/FraudDetectionDataJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/networking/FraudDetectionData;", "timestampSupplier", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FraudDetectionDataJsonParser.kt */
public final class FraudDetectionDataJsonParser implements ModelJsonParser<FraudDetectionData> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_GUID = "guid";
    @Deprecated
    private static final String FIELD_MUID = "muid";
    @Deprecated
    private static final String FIELD_SID = "sid";
    private final Function0<Long> timestampSupplier;

    public FraudDetectionDataJsonParser(Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(function0, "timestampSupplier");
        this.timestampSupplier = function0;
    }

    public FraudDetectionData parse(JSONObject jSONObject) {
        String optString;
        String optString2;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        String optString3 = StripeJsonUtils.optString(jSONObject, FIELD_GUID);
        if (optString3 == null || (optString = StripeJsonUtils.optString(jSONObject, FIELD_MUID)) == null || (optString2 = StripeJsonUtils.optString(jSONObject, FIELD_SID)) == null) {
            return null;
        }
        return new FraudDetectionData(optString3, optString, optString2, this.timestampSupplier.invoke().longValue());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/FraudDetectionDataJsonParser$Companion;", "", "()V", "FIELD_GUID", "", "FIELD_MUID", "FIELD_SID", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FraudDetectionDataJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

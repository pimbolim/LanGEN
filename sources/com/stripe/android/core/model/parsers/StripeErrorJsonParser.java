package com.stripe.android.core.model.parsers;

import com.stripe.android.core.StripeError;
import com.stripe.android.core.model.StripeJsonUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/core/model/parsers/StripeErrorJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/core/StripeError;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeErrorJsonParser.kt */
public final class StripeErrorJsonParser implements ModelJsonParser<StripeError> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIELD_CHARGE = "charge";
    private static final String FIELD_CODE = "code";
    private static final String FIELD_DECLINE_CODE = "decline_code";
    private static final String FIELD_DOC_URL = "doc_url";
    private static final String FIELD_ERROR = "error";
    private static final String FIELD_MESSAGE = "message";
    private static final String FIELD_PARAM = "param";
    private static final String FIELD_TYPE = "type";
    public static final String MALFORMED_RESPONSE_MESSAGE = "An improperly formatted error response was found.";

    public StripeError parse(JSONObject jSONObject) {
        StripeError stripeError;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        try {
            Result.Companion companion = Result.Companion;
            StripeErrorJsonParser stripeErrorJsonParser = this;
            JSONObject jSONObject2 = jSONObject.getJSONObject("error");
            String optString = StripeJsonUtils.optString(jSONObject2, FIELD_CHARGE);
            String optString2 = StripeJsonUtils.optString(jSONObject2, "code");
            String optString3 = StripeJsonUtils.optString(jSONObject2, FIELD_DECLINE_CODE);
            stripeError = Result.m4709constructorimpl(new StripeError(StripeJsonUtils.optString(jSONObject2, "type"), StripeJsonUtils.optString(jSONObject2, "message"), optString2, StripeJsonUtils.optString(jSONObject2, FIELD_PARAM), optString3, optString, StripeJsonUtils.optString(jSONObject2, FIELD_DOC_URL)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            stripeError = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        StripeError stripeError2 = new StripeError((String) null, MALFORMED_RESPONSE_MESSAGE, (String) null, (String) null, (String) null, (String) null, (String) null, 125, (DefaultConstructorMarker) null);
        if (Result.m4715isFailureimpl(stripeError)) {
            stripeError = stripeError2;
        }
        return (StripeError) stripeError;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/core/model/parsers/StripeErrorJsonParser$Companion;", "", "()V", "FIELD_CHARGE", "", "FIELD_CODE", "FIELD_DECLINE_CODE", "FIELD_DOC_URL", "FIELD_ERROR", "FIELD_MESSAGE", "FIELD_PARAM", "FIELD_TYPE", "MALFORMED_RESPONSE_MESSAGE", "getMALFORMED_RESPONSE_MESSAGE$stripe_core_release$annotations", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeErrorJsonParser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getMALFORMED_RESPONSE_MESSAGE$stripe_core_release$annotations() {
        }

        private Companion() {
        }
    }
}

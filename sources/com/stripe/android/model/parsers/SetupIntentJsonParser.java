package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.SetupIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0007\bB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/parsers/SetupIntentJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/SetupIntent;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "ErrorJsonParser", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SetupIntentJsonParser.kt */
public final class SetupIntentJsonParser implements ModelJsonParser<SetupIntent> {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_CANCELLATION_REASON = "cancellation_reason";
    @Deprecated
    private static final String FIELD_CLIENT_SECRET = "client_secret";
    @Deprecated
    private static final String FIELD_CREATED = "created";
    @Deprecated
    private static final String FIELD_DESCRIPTION = "description";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_LAST_SETUP_ERROR = "last_setup_error";
    @Deprecated
    private static final String FIELD_LIVEMODE = "livemode";
    @Deprecated
    private static final String FIELD_NEXT_ACTION = "next_action";
    @Deprecated
    private static final String FIELD_OBJECT = "object";
    @Deprecated
    private static final String FIELD_PAYMENT_METHOD = "payment_method";
    @Deprecated
    private static final String FIELD_PAYMENT_METHOD_TYPES = "payment_method_types";
    @Deprecated
    private static final String FIELD_STATUS = "status";
    @Deprecated
    private static final String FIELD_UNACTIVATED_PAYMENT_METHOD_TYPES = "unactivated_payment_method_types";
    @Deprecated
    private static final String FIELD_USAGE = "usage";
    @Deprecated
    private static final String VALUE_SETUP_INTENT = "setup_intent";

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.model.SetupIntent parse(org.json.JSONObject r21) {
        /*
            r20 = this;
            r0 = r21
            java.lang.String r1 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "object"
            java.lang.String r1 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            java.lang.String r2 = "setup_intent"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            r2 = 0
            if (r1 != 0) goto L_0x0017
            return r2
        L_0x0017:
            java.lang.String r1 = "payment_method"
            org.json.JSONObject r3 = r0.optJSONObject(r1)
            if (r3 != 0) goto L_0x0021
            r12 = r2
            goto L_0x002b
        L_0x0021:
            com.stripe.android.model.parsers.PaymentMethodJsonParser r4 = new com.stripe.android.model.parsers.PaymentMethodJsonParser
            r4.<init>()
            com.stripe.android.model.PaymentMethod r3 = r4.parse((org.json.JSONObject) r3)
            r12 = r3
        L_0x002b:
            java.lang.String r1 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            if (r12 != 0) goto L_0x0033
            r3 = 1
            goto L_0x0034
        L_0x0033:
            r3 = 0
        L_0x0034:
            if (r3 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            if (r1 != 0) goto L_0x0040
            if (r12 != 0) goto L_0x003e
            r13 = r2
            goto L_0x0041
        L_0x003e:
            java.lang.String r1 = r12.id
        L_0x0040:
            r13 = r1
        L_0x0041:
            com.stripe.android.core.model.parsers.ModelJsonParser$Companion r1 = com.stripe.android.core.model.parsers.ModelJsonParser.Companion
            java.lang.String r3 = "unactivated_payment_method_types"
            org.json.JSONArray r3 = r0.optJSONArray(r3)
            java.util.List r18 = r1.jsonArrayToList(r3)
            java.lang.String r1 = "id"
            java.lang.String r5 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            java.lang.String r1 = "created"
            long r7 = r0.optLong(r1)
            java.lang.String r1 = "client_secret"
            java.lang.String r9 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            com.stripe.android.model.SetupIntent$CancellationReason$Companion r1 = com.stripe.android.model.SetupIntent.CancellationReason.Companion
            java.lang.String r3 = "cancellation_reason"
            java.lang.String r3 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r3)
            com.stripe.android.model.SetupIntent$CancellationReason r6 = r1.fromCode$payments_core_release(r3)
            java.lang.String r1 = "description"
            java.lang.String r10 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            java.lang.String r1 = "livemode"
            boolean r11 = r0.optBoolean(r1)
            com.stripe.android.core.model.parsers.ModelJsonParser$Companion r1 = com.stripe.android.core.model.parsers.ModelJsonParser.Companion
            java.lang.String r3 = "payment_method_types"
            org.json.JSONArray r3 = r0.optJSONArray(r3)
            java.util.List r14 = r1.jsonArrayToList(r3)
            com.stripe.android.model.StripeIntent$Status$Companion r1 = com.stripe.android.model.StripeIntent.Status.Companion
            java.lang.String r3 = "status"
            java.lang.String r3 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r3)
            com.stripe.android.model.StripeIntent$Status r15 = r1.fromCode$payments_core_release(r3)
            com.stripe.android.model.StripeIntent$Usage$Companion r1 = com.stripe.android.model.StripeIntent.Usage.Companion
            java.lang.String r3 = "usage"
            java.lang.String r3 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r3)
            com.stripe.android.model.StripeIntent$Usage r16 = r1.fromCode$payments_core_release(r3)
            java.lang.String r1 = "last_setup_error"
            org.json.JSONObject r1 = r0.optJSONObject(r1)
            if (r1 != 0) goto L_0x00a6
            r17 = r2
            goto L_0x00b1
        L_0x00a6:
            com.stripe.android.model.parsers.SetupIntentJsonParser$ErrorJsonParser r3 = new com.stripe.android.model.parsers.SetupIntentJsonParser$ErrorJsonParser
            r3.<init>()
            com.stripe.android.model.SetupIntent$Error r1 = r3.parse((org.json.JSONObject) r1)
            r17 = r1
        L_0x00b1:
            java.lang.String r1 = "next_action"
            org.json.JSONObject r0 = r0.optJSONObject(r1)
            if (r0 != 0) goto L_0x00ba
            goto L_0x00c3
        L_0x00ba:
            com.stripe.android.model.parsers.NextActionDataParser r1 = new com.stripe.android.model.parsers.NextActionDataParser
            r1.<init>()
            com.stripe.android.model.StripeIntent$NextActionData r2 = r1.parse((org.json.JSONObject) r0)
        L_0x00c3:
            r19 = r2
            com.stripe.android.model.SetupIntent r0 = new com.stripe.android.model.SetupIntent
            r4 = r0
            r4.<init>(r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.parsers.SetupIntentJsonParser.parse(org.json.JSONObject):com.stripe.android.model.SetupIntent");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/SetupIntentJsonParser$ErrorJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/SetupIntent$Error;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SetupIntentJsonParser.kt */
    public static final class ErrorJsonParser implements ModelJsonParser<SetupIntent.Error> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_CODE = "code";
        @Deprecated
        private static final String FIELD_DECLINE_CODE = "decline_code";
        @Deprecated
        private static final String FIELD_DOC_URL = "doc_url";
        @Deprecated
        private static final String FIELD_MESSAGE = "message";
        @Deprecated
        private static final String FIELD_PARAM = "param";
        @Deprecated
        private static final String FIELD_PAYMENT_METHOD = "payment_method";
        @Deprecated
        private static final String FIELD_TYPE = "type";

        public SetupIntent.Error parse(JSONObject jSONObject) {
            PaymentMethod paymentMethod;
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = StripeJsonUtils.optString(jSONObject, "code");
            String optString2 = StripeJsonUtils.optString(jSONObject, FIELD_DECLINE_CODE);
            String optString3 = StripeJsonUtils.optString(jSONObject, FIELD_DOC_URL);
            String optString4 = StripeJsonUtils.optString(jSONObject, "message");
            String optString5 = StripeJsonUtils.optString(jSONObject, FIELD_PARAM);
            JSONObject optJSONObject = jSONObject.optJSONObject("payment_method");
            if (optJSONObject == null) {
                paymentMethod = null;
            } else {
                paymentMethod = new PaymentMethodJsonParser().parse(optJSONObject);
            }
            return new SetupIntent.Error(optString, optString2, optString3, optString4, optString5, paymentMethod, SetupIntent.Error.Type.Companion.fromCode$payments_core_release(StripeJsonUtils.optString(jSONObject, "type")));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/parsers/SetupIntentJsonParser$ErrorJsonParser$Companion;", "", "()V", "FIELD_CODE", "", "FIELD_DECLINE_CODE", "FIELD_DOC_URL", "FIELD_MESSAGE", "FIELD_PARAM", "FIELD_PAYMENT_METHOD", "FIELD_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SetupIntentJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/model/parsers/SetupIntentJsonParser$Companion;", "", "()V", "FIELD_CANCELLATION_REASON", "", "FIELD_CLIENT_SECRET", "FIELD_CREATED", "FIELD_DESCRIPTION", "FIELD_ID", "FIELD_LAST_SETUP_ERROR", "FIELD_LIVEMODE", "FIELD_NEXT_ACTION", "FIELD_OBJECT", "FIELD_PAYMENT_METHOD", "FIELD_PAYMENT_METHOD_TYPES", "FIELD_STATUS", "FIELD_UNACTIVATED_PAYMENT_METHOD_TYPES", "FIELD_USAGE", "VALUE_SETUP_INTENT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SetupIntentJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

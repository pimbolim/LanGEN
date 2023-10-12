package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Address;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0007\b\tB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentIntentJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentIntent;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "ErrorJsonParser", "ShippingJsonParser", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentIntentJsonParser.kt */
public final class PaymentIntentJsonParser implements ModelJsonParser<PaymentIntent> {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_AMOUNT = "amount";
    @Deprecated
    private static final String FIELD_CANCELED_AT = "canceled_at";
    @Deprecated
    private static final String FIELD_CANCELLATION_REASON = "cancellation_reason";
    @Deprecated
    private static final String FIELD_CAPTURE_METHOD = "capture_method";
    @Deprecated
    private static final String FIELD_CLIENT_SECRET = "client_secret";
    @Deprecated
    private static final String FIELD_CONFIRMATION_METHOD = "confirmation_method";
    @Deprecated
    private static final String FIELD_CREATED = "created";
    @Deprecated
    private static final String FIELD_CURRENCY = "currency";
    @Deprecated
    private static final String FIELD_DESCRIPTION = "description";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_LAST_PAYMENT_ERROR = "last_payment_error";
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
    private static final String FIELD_RECEIPT_EMAIL = "receipt_email";
    @Deprecated
    private static final String FIELD_SETUP_FUTURE_USAGE = "setup_future_usage";
    @Deprecated
    private static final String FIELD_SHIPPING = "shipping";
    @Deprecated
    private static final String FIELD_STATUS = "status";
    @Deprecated
    private static final String FIELD_UNACTIVATED_PAYMENT_METHOD_TYPES = "unactivated_payment_method_types";
    @Deprecated
    private static final String OBJECT_TYPE = "payment_intent";

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.model.PaymentIntent parse(org.json.JSONObject r28) {
        /*
            r27 = this;
            r0 = r28
            java.lang.String r1 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "object"
            java.lang.String r1 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            java.lang.String r2 = "payment_intent"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            r2 = 0
            if (r1 != 0) goto L_0x0017
            return r2
        L_0x0017:
            java.lang.String r1 = "id"
            java.lang.String r4 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            com.stripe.android.core.model.parsers.ModelJsonParser$Companion r1 = com.stripe.android.core.model.parsers.ModelJsonParser.Companion
            java.lang.String r3 = "payment_method_types"
            org.json.JSONArray r3 = r0.optJSONArray(r3)
            java.util.List r5 = r1.jsonArrayToList(r3)
            com.stripe.android.core.model.StripeJsonUtils r1 = com.stripe.android.core.model.StripeJsonUtils.INSTANCE
            java.lang.String r3 = "amount"
            java.lang.Long r6 = r1.optLong(r0, r3)
            java.lang.String r1 = "canceled_at"
            long r7 = r0.optLong(r1)
            com.stripe.android.model.PaymentIntent$CancellationReason$Companion r1 = com.stripe.android.model.PaymentIntent.CancellationReason.Companion
            java.lang.String r3 = "cancellation_reason"
            java.lang.String r3 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r3)
            com.stripe.android.model.PaymentIntent$CancellationReason r9 = r1.fromCode(r3)
            com.stripe.android.model.PaymentIntent$CaptureMethod$Companion r1 = com.stripe.android.model.PaymentIntent.CaptureMethod.Companion
            java.lang.String r3 = "capture_method"
            java.lang.String r3 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r3)
            com.stripe.android.model.PaymentIntent$CaptureMethod r10 = r1.fromCode(r3)
            java.lang.String r1 = "client_secret"
            java.lang.String r11 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            com.stripe.android.model.PaymentIntent$ConfirmationMethod$Companion r1 = com.stripe.android.model.PaymentIntent.ConfirmationMethod.Companion
            java.lang.String r3 = "confirmation_method"
            java.lang.String r3 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r3)
            com.stripe.android.model.PaymentIntent$ConfirmationMethod r12 = r1.fromCode(r3)
            java.lang.String r1 = "created"
            long r13 = r0.optLong(r1)
            java.lang.String r1 = "currency"
            java.lang.String r15 = com.stripe.android.core.model.StripeJsonUtils.optCurrency(r0, r1)
            java.lang.String r1 = "description"
            java.lang.String r16 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            com.stripe.android.core.model.StripeJsonUtils r1 = com.stripe.android.core.model.StripeJsonUtils.INSTANCE
            java.lang.String r3 = "livemode"
            boolean r17 = r1.optBoolean(r0, r3)
            java.lang.String r1 = "payment_method"
            org.json.JSONObject r3 = r0.optJSONObject(r1)
            if (r3 != 0) goto L_0x0084
            goto L_0x008d
        L_0x0084:
            com.stripe.android.model.parsers.PaymentMethodJsonParser r2 = new com.stripe.android.model.parsers.PaymentMethodJsonParser
            r2.<init>()
            com.stripe.android.model.PaymentMethod r2 = r2.parse((org.json.JSONObject) r3)
        L_0x008d:
            java.lang.String r1 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            if (r2 != 0) goto L_0x0095
            r3 = 1
            goto L_0x0096
        L_0x0095:
            r3 = 0
        L_0x0096:
            if (r3 == 0) goto L_0x0099
            goto L_0x009a
        L_0x0099:
            r1 = 0
        L_0x009a:
            if (r1 != 0) goto L_0x00a3
            if (r2 != 0) goto L_0x00a1
            r19 = 0
            goto L_0x00a5
        L_0x00a1:
            java.lang.String r1 = r2.id
        L_0x00a3:
            r19 = r1
        L_0x00a5:
            java.lang.String r1 = "receipt_email"
            java.lang.String r20 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
            com.stripe.android.model.StripeIntent$Status$Companion r1 = com.stripe.android.model.StripeIntent.Status.Companion
            java.lang.String r3 = "status"
            java.lang.String r3 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r3)
            com.stripe.android.model.StripeIntent$Status r21 = r1.fromCode$payments_core_release(r3)
            com.stripe.android.model.StripeIntent$Usage$Companion r1 = com.stripe.android.model.StripeIntent.Usage.Companion
            java.lang.String r3 = "setup_future_usage"
            java.lang.String r3 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r3)
            com.stripe.android.model.StripeIntent$Usage r22 = r1.fromCode$payments_core_release(r3)
            java.lang.String r1 = "last_payment_error"
            org.json.JSONObject r1 = r0.optJSONObject(r1)
            if (r1 != 0) goto L_0x00ce
            r23 = 0
            goto L_0x00d9
        L_0x00ce:
            com.stripe.android.model.parsers.PaymentIntentJsonParser$ErrorJsonParser r3 = new com.stripe.android.model.parsers.PaymentIntentJsonParser$ErrorJsonParser
            r3.<init>()
            com.stripe.android.model.PaymentIntent$Error r1 = r3.parse((org.json.JSONObject) r1)
            r23 = r1
        L_0x00d9:
            java.lang.String r1 = "shipping"
            org.json.JSONObject r1 = r0.optJSONObject(r1)
            if (r1 != 0) goto L_0x00e4
            r24 = 0
            goto L_0x00ef
        L_0x00e4:
            com.stripe.android.model.parsers.PaymentIntentJsonParser$ShippingJsonParser r3 = new com.stripe.android.model.parsers.PaymentIntentJsonParser$ShippingJsonParser
            r3.<init>()
            com.stripe.android.model.PaymentIntent$Shipping r1 = r3.parse((org.json.JSONObject) r1)
            r24 = r1
        L_0x00ef:
            java.lang.String r1 = "next_action"
            org.json.JSONObject r1 = r0.optJSONObject(r1)
            if (r1 != 0) goto L_0x00fa
            r26 = 0
            goto L_0x0105
        L_0x00fa:
            com.stripe.android.model.parsers.NextActionDataParser r3 = new com.stripe.android.model.parsers.NextActionDataParser
            r3.<init>()
            com.stripe.android.model.StripeIntent$NextActionData r1 = r3.parse((org.json.JSONObject) r1)
            r26 = r1
        L_0x0105:
            com.stripe.android.core.model.parsers.ModelJsonParser$Companion r1 = com.stripe.android.core.model.parsers.ModelJsonParser.Companion
            java.lang.String r3 = "unactivated_payment_method_types"
            org.json.JSONArray r0 = r0.optJSONArray(r3)
            java.util.List r25 = r1.jsonArrayToList(r0)
            com.stripe.android.model.PaymentIntent r0 = new com.stripe.android.model.PaymentIntent
            r3 = r0
            r18 = r2
            r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.parsers.PaymentIntentJsonParser.parse(org.json.JSONObject):com.stripe.android.model.PaymentIntent");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentIntentJsonParser$ErrorJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentIntent$Error;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntentJsonParser.kt */
    public static final class ErrorJsonParser implements ModelJsonParser<PaymentIntent.Error> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_CHARGE = "charge";
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

        public PaymentIntent.Error parse(JSONObject jSONObject) {
            PaymentMethod paymentMethod;
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = StripeJsonUtils.optString(jSONObject, FIELD_CHARGE);
            String optString2 = StripeJsonUtils.optString(jSONObject, "code");
            String optString3 = StripeJsonUtils.optString(jSONObject, FIELD_DECLINE_CODE);
            String optString4 = StripeJsonUtils.optString(jSONObject, FIELD_DOC_URL);
            String optString5 = StripeJsonUtils.optString(jSONObject, "message");
            String optString6 = StripeJsonUtils.optString(jSONObject, FIELD_PARAM);
            JSONObject optJSONObject = jSONObject.optJSONObject("payment_method");
            if (optJSONObject == null) {
                paymentMethod = null;
            } else {
                paymentMethod = new PaymentMethodJsonParser().parse(optJSONObject);
            }
            return new PaymentIntent.Error(optString, optString2, optString3, optString4, optString5, optString6, paymentMethod, PaymentIntent.Error.Type.Companion.fromCode(StripeJsonUtils.optString(jSONObject, "type")));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentIntentJsonParser$ErrorJsonParser$Companion;", "", "()V", "FIELD_CHARGE", "", "FIELD_CODE", "FIELD_DECLINE_CODE", "FIELD_DOC_URL", "FIELD_MESSAGE", "FIELD_PARAM", "FIELD_PAYMENT_METHOD", "FIELD_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentIntentJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentIntentJsonParser$ShippingJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentIntent$Shipping;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntentJsonParser.kt */
    public static final class ShippingJsonParser implements ModelJsonParser<PaymentIntent.Shipping> {
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

        public PaymentIntent.Shipping parse(JSONObject jSONObject) {
            Address address;
            JSONObject jSONObject2 = jSONObject;
            Intrinsics.checkNotNullParameter(jSONObject2, "json");
            JSONObject optJSONObject = jSONObject2.optJSONObject("address");
            if (optJSONObject == null) {
                address = null;
            } else {
                address = new AddressJsonParser().parse(optJSONObject);
            }
            if (address == null) {
                address = new Address((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
            }
            return new PaymentIntent.Shipping(address, StripeJsonUtils.optString(jSONObject2, FIELD_CARRIER), StripeJsonUtils.optString(jSONObject2, "name"), StripeJsonUtils.optString(jSONObject2, "phone"), StripeJsonUtils.optString(jSONObject2, FIELD_TRACKING_NUMBER));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentIntentJsonParser$ShippingJsonParser$Companion;", "", "()V", "FIELD_ADDRESS", "", "FIELD_CARRIER", "FIELD_NAME", "FIELD_PHONE", "FIELD_TRACKING_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentIntentJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentIntentJsonParser$Companion;", "", "()V", "FIELD_AMOUNT", "", "FIELD_CANCELED_AT", "FIELD_CANCELLATION_REASON", "FIELD_CAPTURE_METHOD", "FIELD_CLIENT_SECRET", "FIELD_CONFIRMATION_METHOD", "FIELD_CREATED", "FIELD_CURRENCY", "FIELD_DESCRIPTION", "FIELD_ID", "FIELD_LAST_PAYMENT_ERROR", "FIELD_LIVEMODE", "FIELD_NEXT_ACTION", "FIELD_OBJECT", "FIELD_PAYMENT_METHOD", "FIELD_PAYMENT_METHOD_TYPES", "FIELD_RECEIPT_EMAIL", "FIELD_SETUP_FUTURE_USAGE", "FIELD_SHIPPING", "FIELD_STATUS", "FIELD_UNACTIVATED_PAYMENT_METHOD_TYPES", "OBJECT_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntentJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

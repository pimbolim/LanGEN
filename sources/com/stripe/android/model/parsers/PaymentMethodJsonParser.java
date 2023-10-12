package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Address;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.wallets.Wallet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\f\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod;", "()V", "parse", "json", "Lorg/json/JSONObject;", "AuBecsDebitJsonParser", "BacsDebitJsonParser", "BillingDetails", "CardJsonParser", "Companion", "FpxJsonParser", "IdealJsonParser", "NetbankingJsonParser", "SepaDebitJsonParser", "SofortJsonParser", "USBankAccountJsonParser", "UpiJsonParser", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodJsonParser.kt */
public final class PaymentMethodJsonParser implements ModelJsonParser<PaymentMethod> {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_BILLING_DETAILS = "billing_details";
    @Deprecated
    private static final String FIELD_CREATED = "created";
    @Deprecated
    private static final String FIELD_CUSTOMER = "customer";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_LIVEMODE = "livemode";
    @Deprecated
    private static final String FIELD_TYPE = "type";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentMethod.Type.values().length];
            iArr[PaymentMethod.Type.Card.ordinal()] = 1;
            iArr[PaymentMethod.Type.CardPresent.ordinal()] = 2;
            iArr[PaymentMethod.Type.Ideal.ordinal()] = 3;
            iArr[PaymentMethod.Type.Fpx.ordinal()] = 4;
            iArr[PaymentMethod.Type.SepaDebit.ordinal()] = 5;
            iArr[PaymentMethod.Type.AuBecsDebit.ordinal()] = 6;
            iArr[PaymentMethod.Type.BacsDebit.ordinal()] = 7;
            iArr[PaymentMethod.Type.Sofort.ordinal()] = 8;
            iArr[PaymentMethod.Type.Upi.ordinal()] = 9;
            iArr[PaymentMethod.Type.Netbanking.ordinal()] = 10;
            iArr[PaymentMethod.Type.USBankAccount.ordinal()] = 11;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.stripe.android.model.PaymentMethod$Card} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.stripe.android.model.PaymentMethod$Ideal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.stripe.android.model.PaymentMethod$Fpx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: com.stripe.android.model.PaymentMethod$SepaDebit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: com.stripe.android.model.PaymentMethod$AuBecsDebit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: com.stripe.android.model.PaymentMethod$BacsDebit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: com.stripe.android.model.PaymentMethod$Sofort} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: com.stripe.android.model.PaymentMethod$Upi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: com.stripe.android.model.PaymentMethod$Netbanking} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: com.stripe.android.model.PaymentMethod$USBankAccount} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r3v25 */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r3v28 */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r3v30 */
    /* JADX WARNING: type inference failed for: r3v31 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.model.PaymentMethod parse(org.json.JSONObject r6) {
        /*
            r5 = this;
            java.lang.String r0 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.stripe.android.model.PaymentMethod$Type$Companion r0 = com.stripe.android.model.PaymentMethod.Type.Companion
            java.lang.String r1 = "type"
            java.lang.String r1 = com.stripe.android.core.model.StripeJsonUtils.optString(r6, r1)
            com.stripe.android.model.PaymentMethod$Type r0 = r0.fromCode(r1)
            com.stripe.android.model.PaymentMethod$Builder r1 = new com.stripe.android.model.PaymentMethod$Builder
            r1.<init>()
            java.lang.String r2 = "id"
            java.lang.String r2 = com.stripe.android.core.model.StripeJsonUtils.optString(r6, r2)
            com.stripe.android.model.PaymentMethod$Builder r1 = r1.setId(r2)
            com.stripe.android.model.PaymentMethod$Builder r1 = r1.setType(r0)
            com.stripe.android.core.model.StripeJsonUtils r2 = com.stripe.android.core.model.StripeJsonUtils.INSTANCE
            java.lang.String r3 = "created"
            java.lang.Long r2 = r2.optLong(r6, r3)
            com.stripe.android.model.PaymentMethod$Builder r1 = r1.setCreated(r2)
            java.lang.String r2 = "billing_details"
            org.json.JSONObject r2 = r6.optJSONObject(r2)
            r3 = 0
            if (r2 != 0) goto L_0x003b
            r2 = r3
            goto L_0x0044
        L_0x003b:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$BillingDetails r4 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$BillingDetails
            r4.<init>()
            com.stripe.android.model.PaymentMethod$BillingDetails r2 = r4.parse((org.json.JSONObject) r2)
        L_0x0044:
            com.stripe.android.model.PaymentMethod$Builder r1 = r1.setBillingDetails(r2)
            java.lang.String r2 = "customer"
            java.lang.String r2 = com.stripe.android.core.model.StripeJsonUtils.optString(r6, r2)
            com.stripe.android.model.PaymentMethod$Builder r1 = r1.setCustomerId(r2)
            java.lang.String r2 = "livemode"
            boolean r2 = r6.optBoolean(r2)
            com.stripe.android.model.PaymentMethod$Builder r1 = r1.setLiveMode(r2)
            if (r0 != 0) goto L_0x0060
            r2 = -1
            goto L_0x0068
        L_0x0060:
            int[] r2 = com.stripe.android.model.parsers.PaymentMethodJsonParser.WhenMappings.$EnumSwitchMapping$0
            int r4 = r0.ordinal()
            r2 = r2[r4]
        L_0x0068:
            switch(r2) {
                case 1: goto L_0x0142;
                case 2: goto L_0x0138;
                case 3: goto L_0x0122;
                case 4: goto L_0x010c;
                case 5: goto L_0x00f6;
                case 6: goto L_0x00e0;
                case 7: goto L_0x00c9;
                case 8: goto L_0x00b2;
                case 9: goto L_0x009b;
                case 10: goto L_0x0084;
                case 11: goto L_0x006d;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x0157
        L_0x006d:
            java.lang.String r0 = r0.code
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 != 0) goto L_0x0076
            goto L_0x007f
        L_0x0076:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$USBankAccountJsonParser r0 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$USBankAccountJsonParser
            r0.<init>()
            com.stripe.android.model.PaymentMethod$USBankAccount r3 = r0.parse((org.json.JSONObject) r6)
        L_0x007f:
            r1.setUSBankAccount(r3)
            goto L_0x0157
        L_0x0084:
            java.lang.String r0 = r0.code
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 != 0) goto L_0x008d
            goto L_0x0096
        L_0x008d:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$NetbankingJsonParser r0 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$NetbankingJsonParser
            r0.<init>()
            com.stripe.android.model.PaymentMethod$Netbanking r3 = r0.parse((org.json.JSONObject) r6)
        L_0x0096:
            r1.setNetbanking(r3)
            goto L_0x0157
        L_0x009b:
            java.lang.String r0 = r0.code
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 != 0) goto L_0x00a4
            goto L_0x00ad
        L_0x00a4:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$UpiJsonParser r0 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$UpiJsonParser
            r0.<init>()
            com.stripe.android.model.PaymentMethod$Upi r3 = r0.parse((org.json.JSONObject) r6)
        L_0x00ad:
            r1.setUpi(r3)
            goto L_0x0157
        L_0x00b2:
            java.lang.String r0 = r0.code
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 != 0) goto L_0x00bb
            goto L_0x00c4
        L_0x00bb:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$SofortJsonParser r0 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$SofortJsonParser
            r0.<init>()
            com.stripe.android.model.PaymentMethod$Sofort r3 = r0.parse((org.json.JSONObject) r6)
        L_0x00c4:
            r1.setSofort(r3)
            goto L_0x0157
        L_0x00c9:
            java.lang.String r0 = r0.code
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 != 0) goto L_0x00d2
            goto L_0x00db
        L_0x00d2:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$BacsDebitJsonParser r0 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$BacsDebitJsonParser
            r0.<init>()
            com.stripe.android.model.PaymentMethod$BacsDebit r3 = r0.parse((org.json.JSONObject) r6)
        L_0x00db:
            r1.setBacsDebit(r3)
            goto L_0x0157
        L_0x00e0:
            java.lang.String r0 = r0.code
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 != 0) goto L_0x00e9
            goto L_0x00f2
        L_0x00e9:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$AuBecsDebitJsonParser r0 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$AuBecsDebitJsonParser
            r0.<init>()
            com.stripe.android.model.PaymentMethod$AuBecsDebit r3 = r0.parse((org.json.JSONObject) r6)
        L_0x00f2:
            r1.setAuBecsDebit(r3)
            goto L_0x0157
        L_0x00f6:
            java.lang.String r0 = r0.code
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 != 0) goto L_0x00ff
            goto L_0x0108
        L_0x00ff:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$SepaDebitJsonParser r0 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$SepaDebitJsonParser
            r0.<init>()
            com.stripe.android.model.PaymentMethod$SepaDebit r3 = r0.parse((org.json.JSONObject) r6)
        L_0x0108:
            r1.setSepaDebit(r3)
            goto L_0x0157
        L_0x010c:
            java.lang.String r0 = r0.code
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 != 0) goto L_0x0115
            goto L_0x011e
        L_0x0115:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$FpxJsonParser r0 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$FpxJsonParser
            r0.<init>()
            com.stripe.android.model.PaymentMethod$Fpx r3 = r0.parse((org.json.JSONObject) r6)
        L_0x011e:
            r1.setFpx(r3)
            goto L_0x0157
        L_0x0122:
            java.lang.String r0 = r0.code
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 != 0) goto L_0x012b
            goto L_0x0134
        L_0x012b:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$IdealJsonParser r0 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$IdealJsonParser
            r0.<init>()
            com.stripe.android.model.PaymentMethod$Ideal r3 = r0.parse((org.json.JSONObject) r6)
        L_0x0134:
            r1.setIdeal(r3)
            goto L_0x0157
        L_0x0138:
            com.stripe.android.model.PaymentMethod$CardPresent$Companion r6 = com.stripe.android.model.PaymentMethod.CardPresent.Companion
            com.stripe.android.model.PaymentMethod$CardPresent r6 = r6.getEMPTY$payments_core_release()
            r1.setCardPresent(r6)
            goto L_0x0157
        L_0x0142:
            java.lang.String r0 = r0.code
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 != 0) goto L_0x014b
            goto L_0x0154
        L_0x014b:
            com.stripe.android.model.parsers.PaymentMethodJsonParser$CardJsonParser r0 = new com.stripe.android.model.parsers.PaymentMethodJsonParser$CardJsonParser
            r0.<init>()
            com.stripe.android.model.PaymentMethod$Card r3 = r0.parse((org.json.JSONObject) r6)
        L_0x0154:
            r1.setCard(r3)
        L_0x0157:
            com.stripe.android.model.PaymentMethod r6 = r1.build()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.parsers.PaymentMethodJsonParser.parse(org.json.JSONObject):com.stripe.android.model.PaymentMethod");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$BillingDetails;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class BillingDetails implements ModelJsonParser<PaymentMethod.BillingDetails> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_ADDRESS = "address";
        @Deprecated
        private static final String FIELD_EMAIL = "email";
        @Deprecated
        private static final String FIELD_NAME = "name";
        @Deprecated
        private static final String FIELD_PHONE = "phone";

        public PaymentMethod.BillingDetails parse(JSONObject jSONObject) {
            Address address;
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            JSONObject optJSONObject = jSONObject.optJSONObject("address");
            if (optJSONObject == null) {
                address = null;
            } else {
                address = new AddressJsonParser().parse(optJSONObject);
            }
            return new PaymentMethod.BillingDetails(address, StripeJsonUtils.optString(jSONObject, "email"), StripeJsonUtils.optString(jSONObject, "name"), StripeJsonUtils.optString(jSONObject, "phone"));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$BillingDetails$Companion;", "", "()V", "FIELD_ADDRESS", "", "FIELD_EMAIL", "FIELD_NAME", "FIELD_PHONE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0007\b\t\nB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$CardJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$Card;", "()V", "parse", "json", "Lorg/json/JSONObject;", "ChecksJsonParser", "Companion", "NetworksJsonParser", "ThreeDSecureUsageJsonParser", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class CardJsonParser implements ModelJsonParser<PaymentMethod.Card> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_BRAND = "brand";
        @Deprecated
        private static final String FIELD_CHECKS = "checks";
        @Deprecated
        private static final String FIELD_COUNTRY = "country";
        @Deprecated
        private static final String FIELD_EXP_MONTH = "exp_month";
        @Deprecated
        private static final String FIELD_EXP_YEAR = "exp_year";
        @Deprecated
        private static final String FIELD_FINGERPRINT = "fingerprint";
        @Deprecated
        private static final String FIELD_FUNDING = "funding";
        @Deprecated
        private static final String FIELD_LAST4 = "last4";
        @Deprecated
        private static final String FIELD_NETWORKS = "networks";
        @Deprecated
        private static final String FIELD_THREE_D_SECURE_USAGE = "three_d_secure_usage";
        @Deprecated
        private static final String FIELD_WALLET = "wallet";

        public PaymentMethod.Card parse(JSONObject jSONObject) {
            PaymentMethod.Card.Checks checks;
            PaymentMethod.Card.ThreeDSecureUsage threeDSecureUsage;
            Wallet wallet;
            PaymentMethod.Card.Networks networks;
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            CardBrand fromCode = CardBrand.Companion.fromCode(StripeJsonUtils.optString(jSONObject, "brand"));
            JSONObject optJSONObject = jSONObject.optJSONObject(FIELD_CHECKS);
            if (optJSONObject == null) {
                checks = null;
            } else {
                checks = new ChecksJsonParser().parse(optJSONObject);
            }
            String optString = StripeJsonUtils.optString(jSONObject, "country");
            Integer optInteger = StripeJsonUtils.INSTANCE.optInteger(jSONObject, FIELD_EXP_MONTH);
            Integer optInteger2 = StripeJsonUtils.INSTANCE.optInteger(jSONObject, FIELD_EXP_YEAR);
            String optString2 = StripeJsonUtils.optString(jSONObject, FIELD_FINGERPRINT);
            String optString3 = StripeJsonUtils.optString(jSONObject, FIELD_FUNDING);
            String optString4 = StripeJsonUtils.optString(jSONObject, FIELD_LAST4);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(FIELD_THREE_D_SECURE_USAGE);
            if (optJSONObject2 == null) {
                threeDSecureUsage = null;
            } else {
                threeDSecureUsage = new ThreeDSecureUsageJsonParser().parse(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(FIELD_WALLET);
            if (optJSONObject3 == null) {
                wallet = null;
            } else {
                wallet = new WalletJsonParser().parse(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(FIELD_NETWORKS);
            if (optJSONObject4 == null) {
                networks = null;
            } else {
                networks = new NetworksJsonParser().parse(optJSONObject4);
            }
            return new PaymentMethod.Card(fromCode, checks, optString, optInteger, optInteger2, optString2, optString3, optString4, threeDSecureUsage, wallet, networks);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$CardJsonParser$ChecksJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$Card$Checks;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        public static final class ChecksJsonParser implements ModelJsonParser<PaymentMethod.Card.Checks> {
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String FIELD_ADDRESS_LINE1_CHECK = "address_line1_check";
            @Deprecated
            private static final String FIELD_ADDRESS_POSTAL_CODE_CHECK = "address_postal_code_check";
            @Deprecated
            private static final String FIELD_CVC_CHECK = "cvc_check";

            public PaymentMethod.Card.Checks parse(JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                return new PaymentMethod.Card.Checks(StripeJsonUtils.optString(jSONObject, FIELD_ADDRESS_LINE1_CHECK), StripeJsonUtils.optString(jSONObject, FIELD_ADDRESS_POSTAL_CODE_CHECK), StripeJsonUtils.optString(jSONObject, FIELD_CVC_CHECK));
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$CardJsonParser$ChecksJsonParser$Companion;", "", "()V", "FIELD_ADDRESS_LINE1_CHECK", "", "FIELD_ADDRESS_POSTAL_CODE_CHECK", "FIELD_CVC_CHECK", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentMethodJsonParser.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$CardJsonParser$ThreeDSecureUsageJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$Card$ThreeDSecureUsage;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        public static final class ThreeDSecureUsageJsonParser implements ModelJsonParser<PaymentMethod.Card.ThreeDSecureUsage> {
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String FIELD_IS_SUPPORTED = "supported";

            public PaymentMethod.Card.ThreeDSecureUsage parse(JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                return new PaymentMethod.Card.ThreeDSecureUsage(StripeJsonUtils.INSTANCE.optBoolean(jSONObject, FIELD_IS_SUPPORTED));
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$CardJsonParser$ThreeDSecureUsageJsonParser$Companion;", "", "()V", "FIELD_IS_SUPPORTED", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentMethodJsonParser.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$CardJsonParser$NetworksJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$Card$Networks;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        public static final class NetworksJsonParser implements ModelJsonParser<PaymentMethod.Card.Networks> {
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String FIELD_AVAIABLE = "available";
            @Deprecated
            private static final String FIELD_PREFERRED = "preferred";
            @Deprecated
            private static final String FIELD_SELECTION_MANDATORY = "selection_mandatory";

            public PaymentMethod.Card.Networks parse(JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                List jsonArrayToList = StripeJsonUtils.INSTANCE.jsonArrayToList(jSONObject.optJSONArray(FIELD_AVAIABLE));
                if (jsonArrayToList == null) {
                    jsonArrayToList = CollectionsKt.emptyList();
                }
                Iterable<Object> iterable = jsonArrayToList;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Object obj : iterable) {
                    arrayList.add(obj.toString());
                }
                return new PaymentMethod.Card.Networks(CollectionsKt.toSet((List) arrayList), StripeJsonUtils.INSTANCE.optBoolean(jSONObject, FIELD_SELECTION_MANDATORY), StripeJsonUtils.optString(jSONObject, FIELD_PREFERRED));
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$CardJsonParser$NetworksJsonParser$Companion;", "", "()V", "FIELD_AVAIABLE", "", "FIELD_PREFERRED", "FIELD_SELECTION_MANDATORY", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentMethodJsonParser.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$CardJsonParser$Companion;", "", "()V", "FIELD_BRAND", "", "FIELD_CHECKS", "FIELD_COUNTRY", "FIELD_EXP_MONTH", "FIELD_EXP_YEAR", "FIELD_FINGERPRINT", "FIELD_FUNDING", "FIELD_LAST4", "FIELD_NETWORKS", "FIELD_THREE_D_SECURE_USAGE", "FIELD_WALLET", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$IdealJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$Ideal;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class IdealJsonParser implements ModelJsonParser<PaymentMethod.Ideal> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_BANK = "bank";
        @Deprecated
        private static final String FIELD_BIC = "bic";

        public PaymentMethod.Ideal parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new PaymentMethod.Ideal(StripeJsonUtils.optString(jSONObject, FIELD_BANK), StripeJsonUtils.optString(jSONObject, FIELD_BIC));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$IdealJsonParser$Companion;", "", "()V", "FIELD_BANK", "", "FIELD_BIC", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$FpxJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$Fpx;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class FpxJsonParser implements ModelJsonParser<PaymentMethod.Fpx> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_ACCOUNT_HOLDER_TYPE = "account_holder_type";
        @Deprecated
        private static final String FIELD_BANK = "bank";

        public PaymentMethod.Fpx parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new PaymentMethod.Fpx(StripeJsonUtils.optString(jSONObject, FIELD_BANK), StripeJsonUtils.optString(jSONObject, FIELD_ACCOUNT_HOLDER_TYPE));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$FpxJsonParser$Companion;", "", "()V", "FIELD_ACCOUNT_HOLDER_TYPE", "", "FIELD_BANK", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$NetbankingJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$Netbanking;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class NetbankingJsonParser implements ModelJsonParser<PaymentMethod.Netbanking> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_BANK = "bank";

        public PaymentMethod.Netbanking parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new PaymentMethod.Netbanking(StripeJsonUtils.optString(jSONObject, FIELD_BANK));
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$NetbankingJsonParser$Companion;", "", "()V", "FIELD_BANK", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$USBankAccountJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$USBankAccount;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class USBankAccountJsonParser implements ModelJsonParser<PaymentMethod.USBankAccount> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_ACCOUNT_HOLDER_TYPE = "account_holder_type";
        @Deprecated
        private static final String FIELD_ACCOUNT_TYPE = "account_type";
        @Deprecated
        private static final String FIELD_BANK_NAME = "bank_name";
        @Deprecated
        private static final String FIELD_FINGERPRINT = "fingerprint";
        @Deprecated
        private static final String FIELD_LAST4 = "last4";
        @Deprecated
        private static final String FIELD_LINKED_ACCOUNT = "linked_account";
        @Deprecated
        private static final String FIELD_NETWORKS = "networks";
        @Deprecated
        private static final String FIELD_NETWORKS_PREFERRED = "preferred";
        @Deprecated
        private static final String FIELD_NETWORKS_SUPPORTED = "supported";
        @Deprecated
        private static final String FIELD_ROUTING_NUMBER = "routing_number";

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: org.json.JSONArray} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: org.json.JSONArray} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: com.stripe.android.model.PaymentMethod$USBankAccount$USBankNetworks} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: org.json.JSONArray} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: org.json.JSONArray} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: org.json.JSONArray} */
        /* JADX WARNING: type inference failed for: r5v3, types: [com.stripe.android.model.PaymentMethod$USBankAccount$USBankNetworks] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.stripe.android.model.PaymentMethod.USBankAccount parse(org.json.JSONObject r17) {
            /*
                r16 = this;
                r0 = r17
                java.lang.String r1 = "json"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                com.stripe.android.model.PaymentMethod$USBankAccount$USBankAccountHolderType[] r1 = com.stripe.android.model.PaymentMethod.USBankAccount.USBankAccountHolderType.values()
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x000e:
                r5 = 0
                if (r4 >= r2) goto L_0x0026
                r6 = r1[r4]
                int r4 = r4 + 1
                java.lang.String r7 = "account_holder_type"
                java.lang.String r7 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r7)
                java.lang.String r8 = r6.getValue()
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
                if (r7 == 0) goto L_0x000e
                goto L_0x0027
            L_0x0026:
                r6 = r5
            L_0x0027:
                if (r6 != 0) goto L_0x002b
                com.stripe.android.model.PaymentMethod$USBankAccount$USBankAccountHolderType r6 = com.stripe.android.model.PaymentMethod.USBankAccount.USBankAccountHolderType.UNKNOWN
            L_0x002b:
                r8 = r6
                com.stripe.android.model.PaymentMethod$USBankAccount$USBankAccountType[] r1 = com.stripe.android.model.PaymentMethod.USBankAccount.USBankAccountType.values()
                int r2 = r1.length
            L_0x0031:
                if (r3 >= r2) goto L_0x0048
                r4 = r1[r3]
                int r3 = r3 + 1
                java.lang.String r6 = "account_type"
                java.lang.String r6 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r6)
                java.lang.String r7 = r4.getValue()
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
                if (r6 == 0) goto L_0x0031
                goto L_0x0049
            L_0x0048:
                r4 = r5
            L_0x0049:
                if (r4 != 0) goto L_0x004f
                com.stripe.android.model.PaymentMethod$USBankAccount$USBankAccountType r1 = com.stripe.android.model.PaymentMethod.USBankAccount.USBankAccountType.UNKNOWN
                r9 = r1
                goto L_0x0050
            L_0x004f:
                r9 = r4
            L_0x0050:
                java.lang.String r1 = "bank_name"
                java.lang.String r10 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
                java.lang.String r1 = "fingerprint"
                java.lang.String r11 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
                java.lang.String r1 = "last4"
                java.lang.String r12 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
                java.lang.String r1 = "linked_account"
                java.lang.String r13 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
                java.lang.String r1 = "networks"
                boolean r2 = r0.has(r1)
                if (r2 == 0) goto L_0x00bf
                org.json.JSONObject r2 = r0.optJSONObject(r1)
                java.lang.String r3 = "preferred"
                java.lang.String r2 = com.stripe.android.core.model.StripeJsonUtils.optString(r2, r3)
                com.stripe.android.core.model.StripeJsonUtils r3 = com.stripe.android.core.model.StripeJsonUtils.INSTANCE
                org.json.JSONObject r1 = r0.optJSONObject(r1)
                if (r1 != 0) goto L_0x0083
                goto L_0x0089
            L_0x0083:
                java.lang.String r4 = "supported"
                org.json.JSONArray r5 = r1.getJSONArray(r4)
            L_0x0089:
                java.util.List r1 = r3.jsonArrayToList(r5)
                if (r1 != 0) goto L_0x0093
                java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            L_0x0093:
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r3 = new java.util.ArrayList
                r4 = 10
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r4)
                r3.<init>(r4)
                java.util.Collection r3 = (java.util.Collection) r3
                java.util.Iterator r1 = r1.iterator()
            L_0x00a6:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L_0x00b8
                java.lang.Object r4 = r1.next()
                java.lang.String r4 = r4.toString()
                r3.add(r4)
                goto L_0x00a6
            L_0x00b8:
                java.util.List r3 = (java.util.List) r3
                com.stripe.android.model.PaymentMethod$USBankAccount$USBankNetworks r5 = new com.stripe.android.model.PaymentMethod$USBankAccount$USBankNetworks
                r5.<init>(r2, r3)
            L_0x00bf:
                r14 = r5
                java.lang.String r1 = "routing_number"
                java.lang.String r15 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
                com.stripe.android.model.PaymentMethod$USBankAccount r0 = new com.stripe.android.model.PaymentMethod$USBankAccount
                r7 = r0
                r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.parsers.PaymentMethodJsonParser.USBankAccountJsonParser.parse(org.json.JSONObject):com.stripe.android.model.PaymentMethod$USBankAccount");
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$USBankAccountJsonParser$Companion;", "", "()V", "FIELD_ACCOUNT_HOLDER_TYPE", "", "FIELD_ACCOUNT_TYPE", "FIELD_BANK_NAME", "FIELD_FINGERPRINT", "FIELD_LAST4", "FIELD_LINKED_ACCOUNT", "FIELD_NETWORKS", "FIELD_NETWORKS_PREFERRED", "FIELD_NETWORKS_SUPPORTED", "FIELD_ROUTING_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$SepaDebitJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$SepaDebit;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class SepaDebitJsonParser implements ModelJsonParser<PaymentMethod.SepaDebit> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_BANK_CODE = "bank_code";
        @Deprecated
        private static final String FIELD_BRANCH_CODE = "branch_code";
        @Deprecated
        private static final String FIELD_COUNTRY = "country";
        @Deprecated
        private static final String FIELD_FINGERPRINT = "fingerprint";
        @Deprecated
        private static final String FIELD_LAST4 = "last4";

        public PaymentMethod.SepaDebit parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new PaymentMethod.SepaDebit(StripeJsonUtils.optString(jSONObject, FIELD_BANK_CODE), StripeJsonUtils.optString(jSONObject, FIELD_BRANCH_CODE), StripeJsonUtils.optString(jSONObject, "country"), StripeJsonUtils.optString(jSONObject, FIELD_FINGERPRINT), StripeJsonUtils.optString(jSONObject, FIELD_LAST4));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$SepaDebitJsonParser$Companion;", "", "()V", "FIELD_BANK_CODE", "", "FIELD_BRANCH_CODE", "FIELD_COUNTRY", "FIELD_FINGERPRINT", "FIELD_LAST4", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$AuBecsDebitJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$AuBecsDebit;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class AuBecsDebitJsonParser implements ModelJsonParser<PaymentMethod.AuBecsDebit> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_BSB_NUMBER = "bsb_number";
        @Deprecated
        private static final String FIELD_FINGERPRINT = "fingerprint";
        @Deprecated
        private static final String FIELD_LAST4 = "last4";

        public PaymentMethod.AuBecsDebit parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new PaymentMethod.AuBecsDebit(StripeJsonUtils.optString(jSONObject, FIELD_BSB_NUMBER), StripeJsonUtils.optString(jSONObject, FIELD_FINGERPRINT), StripeJsonUtils.optString(jSONObject, FIELD_LAST4));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$AuBecsDebitJsonParser$Companion;", "", "()V", "FIELD_BSB_NUMBER", "", "FIELD_FINGERPRINT", "FIELD_LAST4", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$BacsDebitJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$BacsDebit;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class BacsDebitJsonParser implements ModelJsonParser<PaymentMethod.BacsDebit> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_FINGERPRINT = "fingerprint";
        @Deprecated
        private static final String FIELD_LAST4 = "last4";
        @Deprecated
        private static final String FIELD_SORT_CODE = "sort_code";

        public PaymentMethod.BacsDebit parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new PaymentMethod.BacsDebit(StripeJsonUtils.optString(jSONObject, FIELD_FINGERPRINT), StripeJsonUtils.optString(jSONObject, FIELD_LAST4), StripeJsonUtils.optString(jSONObject, FIELD_SORT_CODE));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$BacsDebitJsonParser$Companion;", "", "()V", "FIELD_FINGERPRINT", "", "FIELD_LAST4", "FIELD_SORT_CODE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$SofortJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$Sofort;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class SofortJsonParser implements ModelJsonParser<PaymentMethod.Sofort> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_COUNTRY = "country";

        public PaymentMethod.Sofort parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new PaymentMethod.Sofort(StripeJsonUtils.optString(jSONObject, "country"));
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$SofortJsonParser$Companion;", "", "()V", "FIELD_COUNTRY", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$UpiJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/PaymentMethod$Upi;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    public static final class UpiJsonParser implements ModelJsonParser<PaymentMethod.Upi> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_VPA = "vpa";

        public PaymentMethod.Upi parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new PaymentMethod.Upi(StripeJsonUtils.optString(jSONObject, FIELD_VPA));
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$UpiJsonParser$Companion;", "", "()V", "FIELD_VPA", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/parsers/PaymentMethodJsonParser$Companion;", "", "()V", "FIELD_BILLING_DETAILS", "", "FIELD_CREATED", "FIELD_CUSTOMER", "FIELD_ID", "FIELD_LIVEMODE", "FIELD_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Address;
import com.stripe.android.model.wallets.Wallet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/model/parsers/WalletJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/wallets/Wallet;", "()V", "parse", "json", "Lorg/json/JSONObject;", "parseMasterpassWallet", "Lcom/stripe/android/model/wallets/Wallet$MasterpassWallet;", "parseVisaCheckoutWallet", "Lcom/stripe/android/model/wallets/Wallet$VisaCheckoutWallet;", "dynamicLast4", "", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletJsonParser.kt */
public final class WalletJsonParser implements ModelJsonParser<Wallet> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_BILLING_ADDRESS = "billing_address";
    @Deprecated
    private static final String FIELD_DYNAMIC_LAST4 = "dynamic_last4";
    @Deprecated
    private static final String FIELD_EMAIL = "email";
    @Deprecated
    private static final String FIELD_NAME = "name";
    @Deprecated
    private static final String FIELD_SHIPPING_ADDRESS = "shipping_address";
    @Deprecated
    private static final String FIELD_TYPE = "type";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WalletJsonParser.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Wallet.Type.values().length];
            iArr[Wallet.Type.AmexExpressCheckout.ordinal()] = 1;
            iArr[Wallet.Type.ApplePay.ordinal()] = 2;
            iArr[Wallet.Type.SamsungPay.ordinal()] = 3;
            iArr[Wallet.Type.GooglePay.ordinal()] = 4;
            iArr[Wallet.Type.Masterpass.ordinal()] = 5;
            iArr[Wallet.Type.VisaCheckout.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Wallet parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Wallet.Type fromCode$payments_core_release = Wallet.Type.Companion.fromCode$payments_core_release(StripeJsonUtils.optString(jSONObject, "type"));
        if (fromCode$payments_core_release == null || (optJSONObject = jSONObject.optJSONObject(fromCode$payments_core_release.getCode())) == null) {
            return null;
        }
        String optString = StripeJsonUtils.optString(jSONObject, FIELD_DYNAMIC_LAST4);
        switch (WhenMappings.$EnumSwitchMapping$0[fromCode$payments_core_release.ordinal()]) {
            case 1:
                return new Wallet.AmexExpressCheckoutWallet(optString);
            case 2:
                return new Wallet.ApplePayWallet(optString);
            case 3:
                return new Wallet.SamsungPayWallet(optString);
            case 4:
                return new Wallet.GooglePayWallet(optString);
            case 5:
                return parseMasterpassWallet(optJSONObject);
            case 6:
                return parseVisaCheckoutWallet(optJSONObject, optString);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final Wallet.MasterpassWallet parseMasterpassWallet(JSONObject jSONObject) {
        Address address;
        JSONObject optJSONObject = jSONObject.optJSONObject(FIELD_BILLING_ADDRESS);
        Address address2 = null;
        if (optJSONObject == null) {
            address = null;
        } else {
            address = new AddressJsonParser().parse(optJSONObject);
        }
        String optString = StripeJsonUtils.optString(jSONObject, "email");
        String optString2 = StripeJsonUtils.optString(jSONObject, "name");
        JSONObject optJSONObject2 = jSONObject.optJSONObject(FIELD_SHIPPING_ADDRESS);
        if (optJSONObject2 != null) {
            address2 = new AddressJsonParser().parse(optJSONObject2);
        }
        return new Wallet.MasterpassWallet(address, optString, optString2, address2);
    }

    private final Wallet.VisaCheckoutWallet parseVisaCheckoutWallet(JSONObject jSONObject, String str) {
        Address address;
        JSONObject optJSONObject = jSONObject.optJSONObject(FIELD_BILLING_ADDRESS);
        Address address2 = null;
        if (optJSONObject == null) {
            address = null;
        } else {
            address = new AddressJsonParser().parse(optJSONObject);
        }
        String optString = StripeJsonUtils.optString(jSONObject, "email");
        String optString2 = StripeJsonUtils.optString(jSONObject, "name");
        JSONObject optJSONObject2 = jSONObject.optJSONObject(FIELD_SHIPPING_ADDRESS);
        if (optJSONObject2 != null) {
            address2 = new AddressJsonParser().parse(optJSONObject2);
        }
        return new Wallet.VisaCheckoutWallet(address, optString, optString2, address2, str);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/parsers/WalletJsonParser$Companion;", "", "()V", "FIELD_BILLING_ADDRESS", "", "FIELD_DYNAMIC_LAST4", "FIELD_EMAIL", "FIELD_NAME", "FIELD_SHIPPING_ADDRESS", "FIELD_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WalletJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

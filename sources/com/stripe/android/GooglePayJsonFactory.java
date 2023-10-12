package com.stripe.android;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 #2\u00020\u0001:\u0005\"#$%&B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B1\b\u0011\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\b\u0001\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J%\u0010\u0015\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0017J>\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u000b\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/stripe/android/GooglePayJsonFactory;", "", "context", "Landroid/content/Context;", "isJcbEnabled", "", "(Landroid/content/Context;Z)V", "publishableKeyProvider", "Lkotlin/Function0;", "", "stripeAccountIdProvider", "googlePayConfig", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;)V", "Lcom/stripe/android/GooglePayConfig;", "(Lcom/stripe/android/GooglePayConfig;Z)V", "createBaseCardPaymentMethodParams", "Lorg/json/JSONObject;", "createCardPaymentMethod", "billingAddressParameters", "Lcom/stripe/android/GooglePayJsonFactory$BillingAddressParameters;", "createIsReadyToPayRequest", "existingPaymentMethodRequired", "(Lcom/stripe/android/GooglePayJsonFactory$BillingAddressParameters;Ljava/lang/Boolean;)Lorg/json/JSONObject;", "createPaymentDataRequest", "transactionInfo", "Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo;", "shippingAddressParameters", "Lcom/stripe/android/GooglePayJsonFactory$ShippingAddressParameters;", "isEmailRequired", "merchantInfo", "Lcom/stripe/android/GooglePayJsonFactory$MerchantInfo;", "createShippingAddressParameters", "createTransactionInfo", "BillingAddressParameters", "Companion", "MerchantInfo", "ShippingAddressParameters", "TransactionInfo", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayJsonFactory.kt */
public final class GooglePayJsonFactory {
    public static final int $stable = 0;
    @Deprecated
    private static final List<String> ALLOWED_AUTH_METHODS = CollectionsKt.listOf("PAN_ONLY", "CRYPTOGRAM_3DS");
    @Deprecated
    private static final int API_VERSION = 2;
    @Deprecated
    private static final int API_VERSION_MINOR = 0;
    @Deprecated
    private static final String CARD_PAYMENT_METHOD = "CARD";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final List<String> DEFAULT_CARD_NETWORKS = CollectionsKt.listOf("AMEX", "DISCOVER", "MASTERCARD", "VISA");
    @Deprecated
    private static final String JCB_CARD_NETWORK = "JCB";
    private final GooglePayConfig googlePayConfig;
    private final boolean isJcbEnabled;

    public final JSONObject createIsReadyToPayRequest() {
        return createIsReadyToPayRequest$default(this, (BillingAddressParameters) null, (Boolean) null, 3, (Object) null);
    }

    public final JSONObject createIsReadyToPayRequest(BillingAddressParameters billingAddressParameters) {
        return createIsReadyToPayRequest$default(this, billingAddressParameters, (Boolean) null, 2, (Object) null);
    }

    public final JSONObject createPaymentDataRequest(TransactionInfo transactionInfo) {
        Intrinsics.checkNotNullParameter(transactionInfo, "transactionInfo");
        return createPaymentDataRequest$default(this, transactionInfo, (BillingAddressParameters) null, (ShippingAddressParameters) null, false, (MerchantInfo) null, 30, (Object) null);
    }

    public final JSONObject createPaymentDataRequest(TransactionInfo transactionInfo, BillingAddressParameters billingAddressParameters) {
        Intrinsics.checkNotNullParameter(transactionInfo, "transactionInfo");
        return createPaymentDataRequest$default(this, transactionInfo, billingAddressParameters, (ShippingAddressParameters) null, false, (MerchantInfo) null, 28, (Object) null);
    }

    public final JSONObject createPaymentDataRequest(TransactionInfo transactionInfo, BillingAddressParameters billingAddressParameters, ShippingAddressParameters shippingAddressParameters) {
        Intrinsics.checkNotNullParameter(transactionInfo, "transactionInfo");
        return createPaymentDataRequest$default(this, transactionInfo, billingAddressParameters, shippingAddressParameters, false, (MerchantInfo) null, 24, (Object) null);
    }

    public final JSONObject createPaymentDataRequest(TransactionInfo transactionInfo, BillingAddressParameters billingAddressParameters, ShippingAddressParameters shippingAddressParameters, boolean z) {
        Intrinsics.checkNotNullParameter(transactionInfo, "transactionInfo");
        return createPaymentDataRequest$default(this, transactionInfo, billingAddressParameters, shippingAddressParameters, z, (MerchantInfo) null, 16, (Object) null);
    }

    public GooglePayJsonFactory(GooglePayConfig googlePayConfig2, boolean z) {
        Intrinsics.checkNotNullParameter(googlePayConfig2, "googlePayConfig");
        this.googlePayConfig = googlePayConfig2;
        this.isJcbEnabled = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GooglePayJsonFactory(GooglePayConfig googlePayConfig2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(googlePayConfig2, (i & 2) != 0 ? false : z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GooglePayJsonFactory(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GooglePayJsonFactory(Context context, boolean z) {
        this(new GooglePayConfig(context), z);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public GooglePayJsonFactory(@Named("publishableKey") Function0<String> function0, @Named("stripeAccountId") Function0<String> function02, GooglePayPaymentMethodLauncher.Config config) {
        this(new GooglePayConfig(function0.invoke(), function02.invoke()), config.isJcbEnabled$payments_core_release());
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(function02, "stripeAccountIdProvider");
        Intrinsics.checkNotNullParameter(config, "googlePayConfig");
    }

    public static /* synthetic */ JSONObject createIsReadyToPayRequest$default(GooglePayJsonFactory googlePayJsonFactory, BillingAddressParameters billingAddressParameters, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            billingAddressParameters = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        return googlePayJsonFactory.createIsReadyToPayRequest(billingAddressParameters, bool);
    }

    public final JSONObject createIsReadyToPayRequest(BillingAddressParameters billingAddressParameters, Boolean bool) {
        JSONObject put = new JSONObject().put("apiVersion", 2).put("apiVersionMinor", 0).put("allowedPaymentMethods", new JSONArray().put(createCardPaymentMethod(billingAddressParameters)));
        if (bool != null) {
            put.put("existingPaymentMethodRequired", bool.booleanValue());
        }
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …          }\n            }");
        return put;
    }

    public static /* synthetic */ JSONObject createPaymentDataRequest$default(GooglePayJsonFactory googlePayJsonFactory, TransactionInfo transactionInfo, BillingAddressParameters billingAddressParameters, ShippingAddressParameters shippingAddressParameters, boolean z, MerchantInfo merchantInfo, int i, Object obj) {
        return googlePayJsonFactory.createPaymentDataRequest(transactionInfo, (i & 2) != 0 ? null : billingAddressParameters, (i & 4) != 0 ? null : shippingAddressParameters, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : merchantInfo);
    }

    public final JSONObject createPaymentDataRequest(TransactionInfo transactionInfo, BillingAddressParameters billingAddressParameters, ShippingAddressParameters shippingAddressParameters, boolean z, MerchantInfo merchantInfo) {
        boolean z2;
        Intrinsics.checkNotNullParameter(transactionInfo, "transactionInfo");
        boolean z3 = false;
        JSONObject put = new JSONObject().put("apiVersion", 2).put("apiVersionMinor", 0).put("allowedPaymentMethods", new JSONArray().put(createCardPaymentMethod(billingAddressParameters))).put("transactionInfo", createTransactionInfo(transactionInfo)).put("emailRequired", z);
        if (shippingAddressParameters != null && shippingAddressParameters.isRequired$payments_core_release()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            put.put("shippingAddressRequired", true);
            put.put("shippingAddressParameters", createShippingAddressParameters(shippingAddressParameters));
        }
        if (merchantInfo != null) {
            CharSequence merchantName$payments_core_release = merchantInfo.getMerchantName$payments_core_release();
            if (merchantName$payments_core_release == null || merchantName$payments_core_release.length() == 0) {
                z3 = true;
            }
            if (!z3) {
                put.put("merchantInfo", new JSONObject().put("merchantName", merchantInfo.getMerchantName$payments_core_release()));
            }
        }
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …          }\n            }");
        return put;
    }

    private final JSONObject createTransactionInfo(TransactionInfo transactionInfo) {
        JSONObject jSONObject = new JSONObject();
        String upperCase = transactionInfo.getCurrencyCode$payments_core_release().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        JSONObject put = jSONObject.put("currencyCode", upperCase).put("totalPriceStatus", transactionInfo.getTotalPriceStatus$payments_core_release().getCode$payments_core_release());
        String countryCode$payments_core_release = transactionInfo.getCountryCode$payments_core_release();
        if (countryCode$payments_core_release != null) {
            String upperCase2 = countryCode$payments_core_release.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            put.put("countryCode", upperCase2);
        }
        String transactionId$payments_core_release = transactionInfo.getTransactionId$payments_core_release();
        if (transactionId$payments_core_release != null) {
            put.put("transactionId", transactionId$payments_core_release);
        }
        Integer totalPrice$payments_core_release = transactionInfo.getTotalPrice$payments_core_release();
        if (totalPrice$payments_core_release != null) {
            int intValue = totalPrice$payments_core_release.intValue();
            String upperCase3 = transactionInfo.getCurrencyCode$payments_core_release().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase3, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Currency instance = Currency.getInstance(upperCase3);
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(\n           …                        )");
            put.put("totalPrice", PayWithGoogleUtils.getPriceString(intValue, instance));
        }
        String totalPriceLabel$payments_core_release = transactionInfo.getTotalPriceLabel$payments_core_release();
        if (totalPriceLabel$payments_core_release != null) {
            put.put("totalPriceLabel", totalPriceLabel$payments_core_release);
        }
        TransactionInfo.CheckoutOption checkoutOption$payments_core_release = transactionInfo.getCheckoutOption$payments_core_release();
        if (checkoutOption$payments_core_release != null) {
            put.put("checkoutOption", checkoutOption$payments_core_release.getCode$payments_core_release());
        }
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …          }\n            }");
        return put;
    }

    private final JSONObject createShippingAddressParameters(ShippingAddressParameters shippingAddressParameters) {
        JSONObject put = new JSONObject().put("allowedCountryCodes", new JSONArray(shippingAddressParameters.getNormalizedAllowedCountryCodes$payments_core_release())).put("phoneNumberRequired", shippingAddressParameters.getPhoneNumberRequired$payments_core_release());
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …berRequired\n            )");
        return put;
    }

    private final JSONObject createCardPaymentMethod(BillingAddressParameters billingAddressParameters) {
        JSONObject createBaseCardPaymentMethodParams = createBaseCardPaymentMethodParams();
        boolean z = false;
        if (billingAddressParameters != null && billingAddressParameters.isRequired$payments_core_release()) {
            z = true;
        }
        if (z) {
            createBaseCardPaymentMethodParams.put("billingAddressRequired", true);
            createBaseCardPaymentMethodParams.put("billingAddressParameters", new JSONObject().put("phoneNumberRequired", billingAddressParameters.isPhoneNumberRequired$payments_core_release()).put("format", billingAddressParameters.getFormat$payments_core_release().getCode$payments_core_release()));
        }
        JSONObject put = new JSONObject().put("type", CARD_PAYMENT_METHOD).put("parameters", createBaseCardPaymentMethodParams).put("tokenizationSpecification", this.googlePayConfig.getTokenizationSpecification());
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …okenizationSpecification)");
        return put;
    }

    private final JSONObject createBaseCardPaymentMethodParams() {
        JSONObject put = new JSONObject().put("allowedAuthMethods", new JSONArray(ALLOWED_AUTH_METHODS));
        Collection collection = DEFAULT_CARD_NETWORKS;
        List listOf = CollectionsKt.listOf(JCB_CARD_NETWORK);
        if (!this.isJcbEnabled) {
            listOf = null;
        }
        if (listOf == null) {
            listOf = CollectionsKt.emptyList();
        }
        JSONObject put2 = put.put("allowedCardNetworks", new JSONArray(CollectionsKt.plus(collection, listOf)));
        Intrinsics.checkNotNullExpressionValue(put2, "JSONObject()\n           …          )\n            )");
        return put2;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001!B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u000eJ\u000e\u0010\u000f\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/stripe/android/GooglePayJsonFactory$BillingAddressParameters;", "Landroid/os/Parcelable;", "isRequired", "", "format", "Lcom/stripe/android/GooglePayJsonFactory$BillingAddressParameters$Format;", "isPhoneNumberRequired", "(ZLcom/stripe/android/GooglePayJsonFactory$BillingAddressParameters$Format;Z)V", "getFormat$payments_core_release", "()Lcom/stripe/android/GooglePayJsonFactory$BillingAddressParameters$Format;", "isPhoneNumberRequired$payments_core_release", "()Z", "isRequired$payments_core_release", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Format", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayJsonFactory.kt */
    public static final class BillingAddressParameters implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<BillingAddressParameters> CREATOR = new Creator();
        private final Format format;
        private final boolean isPhoneNumberRequired;
        private final boolean isRequired;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayJsonFactory.kt */
        public static final class Creator implements Parcelable.Creator<BillingAddressParameters> {
            public final BillingAddressParameters createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                boolean z = true;
                boolean z2 = parcel.readInt() != 0;
                Format valueOf = Format.valueOf(parcel.readString());
                if (parcel.readInt() == 0) {
                    z = false;
                }
                return new BillingAddressParameters(z2, valueOf, z);
            }

            public final BillingAddressParameters[] newArray(int i) {
                return new BillingAddressParameters[i];
            }
        }

        public BillingAddressParameters() {
            this(false, (Format) null, false, 7, (DefaultConstructorMarker) null);
        }

        public BillingAddressParameters(boolean z) {
            this(z, (Format) null, false, 6, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public BillingAddressParameters(boolean z, Format format2) {
            this(z, format2, false, 4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(format2, "format");
        }

        public static /* synthetic */ BillingAddressParameters copy$default(BillingAddressParameters billingAddressParameters, boolean z, Format format2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = billingAddressParameters.isRequired;
            }
            if ((i & 2) != 0) {
                format2 = billingAddressParameters.format;
            }
            if ((i & 4) != 0) {
                z2 = billingAddressParameters.isPhoneNumberRequired;
            }
            return billingAddressParameters.copy(z, format2, z2);
        }

        public final boolean component1$payments_core_release() {
            return this.isRequired;
        }

        public final Format component2$payments_core_release() {
            return this.format;
        }

        public final boolean component3$payments_core_release() {
            return this.isPhoneNumberRequired;
        }

        public final BillingAddressParameters copy(boolean z, Format format2, boolean z2) {
            Intrinsics.checkNotNullParameter(format2, "format");
            return new BillingAddressParameters(z, format2, z2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BillingAddressParameters)) {
                return false;
            }
            BillingAddressParameters billingAddressParameters = (BillingAddressParameters) obj;
            return this.isRequired == billingAddressParameters.isRequired && this.format == billingAddressParameters.format && this.isPhoneNumberRequired == billingAddressParameters.isPhoneNumberRequired;
        }

        public int hashCode() {
            boolean z = this.isRequired;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int hashCode = (((z ? 1 : 0) * true) + this.format.hashCode()) * 31;
            boolean z3 = this.isPhoneNumberRequired;
            if (!z3) {
                z2 = z3;
            }
            return hashCode + (z2 ? 1 : 0);
        }

        public String toString() {
            return "BillingAddressParameters(isRequired=" + this.isRequired + ", format=" + this.format + ", isPhoneNumberRequired=" + this.isPhoneNumberRequired + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.isRequired ? 1 : 0);
            parcel.writeString(this.format.name());
            parcel.writeInt(this.isPhoneNumberRequired ? 1 : 0);
        }

        public BillingAddressParameters(boolean z, Format format2, boolean z2) {
            Intrinsics.checkNotNullParameter(format2, "format");
            this.isRequired = z;
            this.format = format2;
            this.isPhoneNumberRequired = z2;
        }

        public final boolean isRequired$payments_core_release() {
            return this.isRequired;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BillingAddressParameters(boolean z, Format format2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? Format.Min : format2, (i & 4) != 0 ? false : z2);
        }

        public final Format getFormat$payments_core_release() {
            return this.format;
        }

        public final boolean isPhoneNumberRequired$payments_core_release() {
            return this.isPhoneNumberRequired;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/GooglePayJsonFactory$BillingAddressParameters$Format;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "Min", "Full", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayJsonFactory.kt */
        public enum Format {
            Min("MIN"),
            Full("FULL");
            
            private final String code;

            private Format(String str) {
                this.code = str;
            }

            public final String getCode$payments_core_release() {
                return this.code;
            }
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u000267BS\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u001a\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001bJ\u000e\u0010\u001c\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b!J\u0012\u0010\"\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0004\b#\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b%J\u0010\u0010&\u001a\u0004\u0018\u00010\fHÀ\u0003¢\u0006\u0002\b'J^\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010)J\t\u0010*\u001a\u00020\tHÖ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\tHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\tHÖ\u0001R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u00068"}, d2 = {"Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo;", "Landroid/os/Parcelable;", "currencyCode", "", "totalPriceStatus", "Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo$TotalPriceStatus;", "countryCode", "transactionId", "totalPrice", "", "totalPriceLabel", "checkoutOption", "Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo$CheckoutOption;", "(Ljava/lang/String;Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo$TotalPriceStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo$CheckoutOption;)V", "getCheckoutOption$payments_core_release", "()Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo$CheckoutOption;", "getCountryCode$payments_core_release", "()Ljava/lang/String;", "getCurrencyCode$payments_core_release", "getTotalPrice$payments_core_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalPriceLabel$payments_core_release", "getTotalPriceStatus$payments_core_release", "()Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo$TotalPriceStatus;", "getTransactionId$payments_core_release", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "component6", "component6$payments_core_release", "component7", "component7$payments_core_release", "copy", "(Ljava/lang/String;Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo$TotalPriceStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo$CheckoutOption;)Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CheckoutOption", "TotalPriceStatus", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayJsonFactory.kt */
    public static final class TransactionInfo implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<TransactionInfo> CREATOR = new Creator();
        private final CheckoutOption checkoutOption;
        private final String countryCode;
        private final String currencyCode;
        private final Integer totalPrice;
        private final String totalPriceLabel;
        private final TotalPriceStatus totalPriceStatus;
        private final String transactionId;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayJsonFactory.kt */
        public static final class Creator implements Parcelable.Creator<TransactionInfo> {
            public final TransactionInfo createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TransactionInfo(parcel.readString(), TotalPriceStatus.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : CheckoutOption.valueOf(parcel.readString()));
            }

            public final TransactionInfo[] newArray(int i) {
                return new TransactionInfo[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public TransactionInfo(String str, TotalPriceStatus totalPriceStatus2) {
            this(str, totalPriceStatus2, (String) null, (String) null, (Integer) null, (String) null, (CheckoutOption) null, 124, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "currencyCode");
            Intrinsics.checkNotNullParameter(totalPriceStatus2, "totalPriceStatus");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public TransactionInfo(String str, TotalPriceStatus totalPriceStatus2, String str2) {
            this(str, totalPriceStatus2, str2, (String) null, (Integer) null, (String) null, (CheckoutOption) null, 120, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "currencyCode");
            Intrinsics.checkNotNullParameter(totalPriceStatus2, "totalPriceStatus");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public TransactionInfo(String str, TotalPriceStatus totalPriceStatus2, String str2, String str3) {
            this(str, totalPriceStatus2, str2, str3, (Integer) null, (String) null, (CheckoutOption) null, 112, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "currencyCode");
            Intrinsics.checkNotNullParameter(totalPriceStatus2, "totalPriceStatus");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public TransactionInfo(String str, TotalPriceStatus totalPriceStatus2, String str2, String str3, Integer num) {
            this(str, totalPriceStatus2, str2, str3, num, (String) null, (CheckoutOption) null, 96, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "currencyCode");
            Intrinsics.checkNotNullParameter(totalPriceStatus2, "totalPriceStatus");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public TransactionInfo(String str, TotalPriceStatus totalPriceStatus2, String str2, String str3, Integer num, String str4) {
            this(str, totalPriceStatus2, str2, str3, num, str4, (CheckoutOption) null, 64, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "currencyCode");
            Intrinsics.checkNotNullParameter(totalPriceStatus2, "totalPriceStatus");
        }

        public static /* synthetic */ TransactionInfo copy$default(TransactionInfo transactionInfo, String str, TotalPriceStatus totalPriceStatus2, String str2, String str3, Integer num, String str4, CheckoutOption checkoutOption2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = transactionInfo.currencyCode;
            }
            if ((i & 2) != 0) {
                totalPriceStatus2 = transactionInfo.totalPriceStatus;
            }
            TotalPriceStatus totalPriceStatus3 = totalPriceStatus2;
            if ((i & 4) != 0) {
                str2 = transactionInfo.countryCode;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = transactionInfo.transactionId;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                num = transactionInfo.totalPrice;
            }
            Integer num2 = num;
            if ((i & 32) != 0) {
                str4 = transactionInfo.totalPriceLabel;
            }
            String str7 = str4;
            if ((i & 64) != 0) {
                checkoutOption2 = transactionInfo.checkoutOption;
            }
            return transactionInfo.copy(str, totalPriceStatus3, str5, str6, num2, str7, checkoutOption2);
        }

        public final String component1$payments_core_release() {
            return this.currencyCode;
        }

        public final TotalPriceStatus component2$payments_core_release() {
            return this.totalPriceStatus;
        }

        public final String component3$payments_core_release() {
            return this.countryCode;
        }

        public final String component4$payments_core_release() {
            return this.transactionId;
        }

        public final Integer component5$payments_core_release() {
            return this.totalPrice;
        }

        public final String component6$payments_core_release() {
            return this.totalPriceLabel;
        }

        public final CheckoutOption component7$payments_core_release() {
            return this.checkoutOption;
        }

        public final TransactionInfo copy(String str, TotalPriceStatus totalPriceStatus2, String str2, String str3, Integer num, String str4, CheckoutOption checkoutOption2) {
            Intrinsics.checkNotNullParameter(str, "currencyCode");
            Intrinsics.checkNotNullParameter(totalPriceStatus2, "totalPriceStatus");
            return new TransactionInfo(str, totalPriceStatus2, str2, str3, num, str4, checkoutOption2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransactionInfo)) {
                return false;
            }
            TransactionInfo transactionInfo = (TransactionInfo) obj;
            return Intrinsics.areEqual((Object) this.currencyCode, (Object) transactionInfo.currencyCode) && this.totalPriceStatus == transactionInfo.totalPriceStatus && Intrinsics.areEqual((Object) this.countryCode, (Object) transactionInfo.countryCode) && Intrinsics.areEqual((Object) this.transactionId, (Object) transactionInfo.transactionId) && Intrinsics.areEqual((Object) this.totalPrice, (Object) transactionInfo.totalPrice) && Intrinsics.areEqual((Object) this.totalPriceLabel, (Object) transactionInfo.totalPriceLabel) && this.checkoutOption == transactionInfo.checkoutOption;
        }

        public int hashCode() {
            int hashCode = ((this.currencyCode.hashCode() * 31) + this.totalPriceStatus.hashCode()) * 31;
            String str = this.countryCode;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.transactionId;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.totalPrice;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            String str3 = this.totalPriceLabel;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            CheckoutOption checkoutOption2 = this.checkoutOption;
            if (checkoutOption2 != null) {
                i = checkoutOption2.hashCode();
            }
            return hashCode5 + i;
        }

        public String toString() {
            return "TransactionInfo(currencyCode=" + this.currencyCode + ", totalPriceStatus=" + this.totalPriceStatus + ", countryCode=" + this.countryCode + ", transactionId=" + this.transactionId + ", totalPrice=" + this.totalPrice + ", totalPriceLabel=" + this.totalPriceLabel + ", checkoutOption=" + this.checkoutOption + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.currencyCode);
            parcel.writeString(this.totalPriceStatus.name());
            parcel.writeString(this.countryCode);
            parcel.writeString(this.transactionId);
            Integer num = this.totalPrice;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            parcel.writeString(this.totalPriceLabel);
            CheckoutOption checkoutOption2 = this.checkoutOption;
            if (checkoutOption2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(checkoutOption2.name());
        }

        public TransactionInfo(String str, TotalPriceStatus totalPriceStatus2, String str2, String str3, Integer num, String str4, CheckoutOption checkoutOption2) {
            Intrinsics.checkNotNullParameter(str, "currencyCode");
            Intrinsics.checkNotNullParameter(totalPriceStatus2, "totalPriceStatus");
            this.currencyCode = str;
            this.totalPriceStatus = totalPriceStatus2;
            this.countryCode = str2;
            this.transactionId = str3;
            this.totalPrice = num;
            this.totalPriceLabel = str4;
            this.checkoutOption = checkoutOption2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TransactionInfo(String str, TotalPriceStatus totalPriceStatus2, String str2, String str3, Integer num, String str4, CheckoutOption checkoutOption2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, totalPriceStatus2, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : checkoutOption2);
        }

        public final String getCurrencyCode$payments_core_release() {
            return this.currencyCode;
        }

        public final TotalPriceStatus getTotalPriceStatus$payments_core_release() {
            return this.totalPriceStatus;
        }

        public final String getCountryCode$payments_core_release() {
            return this.countryCode;
        }

        public final String getTransactionId$payments_core_release() {
            return this.transactionId;
        }

        public final Integer getTotalPrice$payments_core_release() {
            return this.totalPrice;
        }

        public final String getTotalPriceLabel$payments_core_release() {
            return this.totalPriceLabel;
        }

        public final CheckoutOption getCheckoutOption$payments_core_release() {
            return this.checkoutOption;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo$TotalPriceStatus;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "NotCurrentlyKnown", "Estimated", "Final", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayJsonFactory.kt */
        public enum TotalPriceStatus {
            NotCurrentlyKnown("NOT_CURRENTLY_KNOWN"),
            Estimated("ESTIMATED"),
            Final("FINAL");
            
            private final String code;

            private TotalPriceStatus(String str) {
                this.code = str;
            }

            public final String getCode$payments_core_release() {
                return this.code;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo$CheckoutOption;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "Default", "CompleteImmediatePurchase", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayJsonFactory.kt */
        public enum CheckoutOption {
            Default("DEFAULT"),
            CompleteImmediatePurchase("COMPLETE_IMMEDIATE_PURCHASE");
            
            private final String code;

            private CheckoutOption(String str) {
                this.code = str;
            }

            public final String getCode$payments_core_release() {
                return this.code;
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÂ\u0003J\u000e\u0010\u0012\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0013J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006!"}, d2 = {"Lcom/stripe/android/GooglePayJsonFactory$ShippingAddressParameters;", "Landroid/os/Parcelable;", "isRequired", "", "allowedCountryCodes", "", "", "phoneNumberRequired", "(ZLjava/util/Set;Z)V", "isRequired$payments_core_release", "()Z", "normalizedAllowedCountryCodes", "getNormalizedAllowedCountryCodes$payments_core_release", "()Ljava/util/Set;", "getPhoneNumberRequired$payments_core_release", "component1", "component1$payments_core_release", "component2", "component3", "component3$payments_core_release", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayJsonFactory.kt */
    public static final class ShippingAddressParameters implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<ShippingAddressParameters> CREATOR = new Creator();
        private final Set<String> allowedCountryCodes;
        private final boolean isRequired;
        private final boolean phoneNumberRequired;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayJsonFactory.kt */
        public static final class Creator implements Parcelable.Creator<ShippingAddressParameters> {
            public final ShippingAddressParameters createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                boolean z = true;
                boolean z2 = parcel.readInt() != 0;
                int readInt = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashSet.add(parcel.readString());
                }
                Set set = linkedHashSet;
                if (parcel.readInt() == 0) {
                    z = false;
                }
                return new ShippingAddressParameters(z2, set, z);
            }

            public final ShippingAddressParameters[] newArray(int i) {
                return new ShippingAddressParameters[i];
            }
        }

        public ShippingAddressParameters() {
            this(false, (Set) null, false, 7, (DefaultConstructorMarker) null);
        }

        public ShippingAddressParameters(boolean z) {
            this(z, (Set) null, false, 6, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public ShippingAddressParameters(boolean z, Set<String> set) {
            this(z, set, false, 4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(set, "allowedCountryCodes");
        }

        private final Set<String> component2() {
            return this.allowedCountryCodes;
        }

        public static /* synthetic */ ShippingAddressParameters copy$default(ShippingAddressParameters shippingAddressParameters, boolean z, Set<String> set, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = shippingAddressParameters.isRequired;
            }
            if ((i & 2) != 0) {
                set = shippingAddressParameters.allowedCountryCodes;
            }
            if ((i & 4) != 0) {
                z2 = shippingAddressParameters.phoneNumberRequired;
            }
            return shippingAddressParameters.copy(z, set, z2);
        }

        public final boolean component1$payments_core_release() {
            return this.isRequired;
        }

        public final boolean component3$payments_core_release() {
            return this.phoneNumberRequired;
        }

        public final ShippingAddressParameters copy(boolean z, Set<String> set, boolean z2) {
            Intrinsics.checkNotNullParameter(set, "allowedCountryCodes");
            return new ShippingAddressParameters(z, set, z2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShippingAddressParameters)) {
                return false;
            }
            ShippingAddressParameters shippingAddressParameters = (ShippingAddressParameters) obj;
            return this.isRequired == shippingAddressParameters.isRequired && Intrinsics.areEqual((Object) this.allowedCountryCodes, (Object) shippingAddressParameters.allowedCountryCodes) && this.phoneNumberRequired == shippingAddressParameters.phoneNumberRequired;
        }

        public int hashCode() {
            boolean z = this.isRequired;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int hashCode = (((z ? 1 : 0) * true) + this.allowedCountryCodes.hashCode()) * 31;
            boolean z3 = this.phoneNumberRequired;
            if (!z3) {
                z2 = z3;
            }
            return hashCode + (z2 ? 1 : 0);
        }

        public String toString() {
            return "ShippingAddressParameters(isRequired=" + this.isRequired + ", allowedCountryCodes=" + this.allowedCountryCodes + ", phoneNumberRequired=" + this.phoneNumberRequired + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.isRequired ? 1 : 0);
            Set<String> set = this.allowedCountryCodes;
            parcel.writeInt(set.size());
            for (String writeString : set) {
                parcel.writeString(writeString);
            }
            parcel.writeInt(this.phoneNumberRequired ? 1 : 0);
        }

        public ShippingAddressParameters(boolean z, Set<String> set, boolean z2) {
            Intrinsics.checkNotNullParameter(set, "allowedCountryCodes");
            this.isRequired = z;
            this.allowedCountryCodes = set;
            this.phoneNumberRequired = z2;
            String[] iSOCountries = Locale.getISOCountries();
            for (String str : getNormalizedAllowedCountryCodes$payments_core_release()) {
                Intrinsics.checkNotNullExpressionValue(iSOCountries, "countryCodes");
                int length = iSOCountries.length;
                boolean z3 = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str2 = iSOCountries[i];
                    i++;
                    if (Intrinsics.areEqual((Object) str, (Object) str2)) {
                        z3 = true;
                        continue;
                        break;
                    }
                }
                if (!z3) {
                    throw new IllegalArgumentException(('\'' + str + "' is not a valid country code").toString());
                }
            }
        }

        public final boolean isRequired$payments_core_release() {
            return this.isRequired;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ShippingAddressParameters(boolean z, Set set, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? SetsKt.emptySet() : set, (i & 4) != 0 ? false : z2);
        }

        public final boolean getPhoneNumberRequired$payments_core_release() {
            return this.phoneNumberRequired;
        }

        public final Set<String> getNormalizedAllowedCountryCodes$payments_core_release() {
            Iterable<String> iterable = this.allowedCountryCodes;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String upperCase : iterable) {
                String upperCase2 = upperCase.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                arrayList.add(upperCase2);
            }
            return CollectionsKt.toSet((List) arrayList);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/GooglePayJsonFactory$MerchantInfo;", "Landroid/os/Parcelable;", "merchantName", "", "(Ljava/lang/String;)V", "getMerchantName$payments_core_release", "()Ljava/lang/String;", "component1", "component1$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayJsonFactory.kt */
    public static final class MerchantInfo implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<MerchantInfo> CREATOR = new Creator();
        private final String merchantName;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayJsonFactory.kt */
        public static final class Creator implements Parcelable.Creator<MerchantInfo> {
            public final MerchantInfo createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MerchantInfo(parcel.readString());
            }

            public final MerchantInfo[] newArray(int i) {
                return new MerchantInfo[i];
            }
        }

        public MerchantInfo() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MerchantInfo copy$default(MerchantInfo merchantInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = merchantInfo.merchantName;
            }
            return merchantInfo.copy(str);
        }

        public final String component1$payments_core_release() {
            return this.merchantName;
        }

        public final MerchantInfo copy(String str) {
            return new MerchantInfo(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MerchantInfo) && Intrinsics.areEqual((Object) this.merchantName, (Object) ((MerchantInfo) obj).merchantName);
        }

        public int hashCode() {
            String str = this.merchantName;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "MerchantInfo(merchantName=" + this.merchantName + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.merchantName);
        }

        public MerchantInfo(String str) {
            this.merchantName = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MerchantInfo(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getMerchantName$payments_core_release() {
            return this.merchantName;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/GooglePayJsonFactory$Companion;", "", "()V", "ALLOWED_AUTH_METHODS", "", "", "API_VERSION", "", "API_VERSION_MINOR", "CARD_PAYMENT_METHOD", "DEFAULT_CARD_NETWORKS", "JCB_CARD_NETWORK", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayJsonFactory.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

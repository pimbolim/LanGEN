package com.reactnativestripesdk;

import com.facebook.react.bridge.ReadableMap;
import com.stripe.android.model.Address;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.MandateDataParams;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.PaymentMethodOptionsParams;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\u000e\u0010%\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u0012H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u000eH\u0002J\b\u0010+\u001a\u00020\u0012H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/reactnativestripesdk/PaymentMethodCreateParamsFactory;", "", "clientSecret", "", "params", "Lcom/facebook/react/bridge/ReadableMap;", "cardFieldView", "Lcom/reactnativestripesdk/CardFieldView;", "cardFormView", "Lcom/reactnativestripesdk/CardFormView;", "(Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;Lcom/reactnativestripesdk/CardFieldView;Lcom/reactnativestripesdk/CardFormView;)V", "billingDetailsParams", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "createAfterpayClearpayPaymentConfirmParams", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "createAlipayPaymentConfirmParams", "createAuBecsDebitPaymentConfirmParams", "createAuBecsDebitPaymentSetupParams", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "createBancontactPaymentConfirmParams", "createBancontactPaymentSetupParams", "createCardPaymentConfirmParams", "createCardPaymentSetupParams", "createConfirmParams", "paymentMethodType", "Lcom/stripe/android/model/PaymentMethod$Type;", "createEPSPaymentConfirmParams", "createFpxPaymentConfirmParams", "createGiropayPaymentConfirmParams", "createGrabPayPaymentConfirmParams", "createIDEALPaymentConfirmParams", "createIDEALPaymentSetupParams", "createKlarnaPaymentConfirmParams", "createOXXOPaymentConfirmParams", "createP24PaymentConfirmParams", "createSepaPaymentConfirmParams", "createSepaPaymentSetupParams", "createSetupParams", "createSofortPaymentConfirmParams", "createSofortPaymentSetupParams", "createUSBankAccountParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "createUSBankAccountPaymentConfirmParams", "createUSBankAccountPaymentSetupParams", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PaymentMethodCreateParamsFactory.kt */
public final class PaymentMethodCreateParamsFactory {
    private final PaymentMethod.BillingDetails billingDetailsParams;
    private final CardFieldView cardFieldView;
    private final CardFormView cardFormView;
    private final String clientSecret;
    private final ReadableMap params;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: PaymentMethodCreateParamsFactory.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentMethod.Type.values().length];
            iArr[PaymentMethod.Type.Card.ordinal()] = 1;
            iArr[PaymentMethod.Type.Ideal.ordinal()] = 2;
            iArr[PaymentMethod.Type.Alipay.ordinal()] = 3;
            iArr[PaymentMethod.Type.Sofort.ordinal()] = 4;
            iArr[PaymentMethod.Type.Bancontact.ordinal()] = 5;
            iArr[PaymentMethod.Type.SepaDebit.ordinal()] = 6;
            iArr[PaymentMethod.Type.Oxxo.ordinal()] = 7;
            iArr[PaymentMethod.Type.Giropay.ordinal()] = 8;
            iArr[PaymentMethod.Type.Eps.ordinal()] = 9;
            iArr[PaymentMethod.Type.GrabPay.ordinal()] = 10;
            iArr[PaymentMethod.Type.P24.ordinal()] = 11;
            iArr[PaymentMethod.Type.Fpx.ordinal()] = 12;
            iArr[PaymentMethod.Type.AfterpayClearpay.ordinal()] = 13;
            iArr[PaymentMethod.Type.AuBecsDebit.ordinal()] = 14;
            iArr[PaymentMethod.Type.Klarna.ordinal()] = 15;
            iArr[PaymentMethod.Type.USBankAccount.ordinal()] = 16;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PaymentMethodCreateParamsFactory(String str, ReadableMap readableMap, CardFieldView cardFieldView2, CardFormView cardFormView2) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(readableMap, "params");
        this.clientSecret = str;
        this.params = readableMap;
        this.cardFieldView = cardFieldView2;
        this.cardFormView = cardFormView2;
        ReadableMap mapOrNull = MappersKt.getMapOrNull(readableMap, "billingDetails");
        Address address = null;
        Address cardAddress = cardFieldView2 == null ? null : cardFieldView2.getCardAddress();
        if (cardAddress != null) {
            address = cardAddress;
        } else if (cardFormView2 != null) {
            address = cardFormView2.getCardAddress();
        }
        this.billingDetailsParams = MappersKt.mapToBillingDetails(mapOrNull, address);
    }

    public final ConfirmPaymentIntentParams createConfirmParams(PaymentMethod.Type type) throws PaymentMethodCreateParamsException {
        Intrinsics.checkNotNullParameter(type, "paymentMethodType");
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    return createCardPaymentConfirmParams();
                case 2:
                    return createIDEALPaymentConfirmParams();
                case 3:
                    return createAlipayPaymentConfirmParams();
                case 4:
                    return createSofortPaymentConfirmParams();
                case 5:
                    return createBancontactPaymentConfirmParams();
                case 6:
                    return createSepaPaymentConfirmParams();
                case 7:
                    return createOXXOPaymentConfirmParams();
                case 8:
                    return createGiropayPaymentConfirmParams();
                case 9:
                    return createEPSPaymentConfirmParams();
                case 10:
                    return createGrabPayPaymentConfirmParams();
                case 11:
                    return createP24PaymentConfirmParams();
                case 12:
                    return createFpxPaymentConfirmParams();
                case 13:
                    return createAfterpayClearpayPaymentConfirmParams();
                case 14:
                    return createAuBecsDebitPaymentConfirmParams();
                case 15:
                    return createKlarnaPaymentConfirmParams();
                case 16:
                    return createUSBankAccountPaymentConfirmParams();
                default:
                    throw new Exception("This paymentMethodType is not supported yet");
            }
        } catch (PaymentMethodCreateParamsException e) {
            throw e;
        }
    }

    public final ConfirmSetupIntentParams createSetupParams(PaymentMethod.Type type) throws PaymentMethodCreateParamsException {
        Intrinsics.checkNotNullParameter(type, "paymentMethodType");
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                return createCardPaymentSetupParams();
            }
            if (i == 2) {
                return createIDEALPaymentSetupParams();
            }
            if (i == 4) {
                return createSofortPaymentSetupParams();
            }
            if (i == 5) {
                return createBancontactPaymentSetupParams();
            }
            if (i == 6) {
                return createSepaPaymentSetupParams();
            }
            if (i == 14) {
                return createAuBecsDebitPaymentSetupParams();
            }
            if (i == 16) {
                return createUSBankAccountPaymentSetupParams();
            }
            throw new Exception("This paymentMethodType is not supported yet");
        } catch (PaymentMethodCreateParamsException e) {
            throw e;
        }
    }

    private final ConfirmPaymentIntentParams createIDEALPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.Ideal(MappersKt.getValOr(this.params, "bankName", (String) null)), this.billingDetailsParams, (Map) null, 4, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, MappersKt.mapToPaymentIntentFutureUsage(MappersKt.getValOr$default(this.params, "setupFutureUsage", (String) null, 4, (Object) null)), (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 220, (Object) null);
    }

    private final ConfirmPaymentIntentParams createP24PaymentConfirmParams() throws PaymentMethodCreateParamsException {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails != null) {
            return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.createP24$default(PaymentMethodCreateParams.Companion, billingDetails, (Map) null, 2, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
        }
        throw new PaymentMethodCreateParamsException("You must provide billing details");
    }

    private final ConfirmPaymentIntentParams createCardPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        PaymentMethodOptionsParams.Card card = null;
        String valOr = MappersKt.getValOr(this.params, "paymentMethodId", (String) null);
        String valOr2 = MappersKt.getValOr(this.params, "token", (String) null);
        CardFieldView cardFieldView2 = this.cardFieldView;
        PaymentMethodCreateParams.Card cardParams = cardFieldView2 == null ? null : cardFieldView2.getCardParams();
        if (cardParams == null) {
            CardFormView cardFormView2 = this.cardFormView;
            cardParams = cardFormView2 == null ? null : cardFormView2.getCardParams();
        }
        if (cardParams == null && valOr == null && valOr2 == null) {
            throw new PaymentMethodCreateParamsException("Card details not complete");
        }
        ConfirmPaymentIntentParams.SetupFutureUsage mapToPaymentIntentFutureUsage = MappersKt.mapToPaymentIntentFutureUsage(MappersKt.getValOr$default(this.params, "setupFutureUsage", (String) null, 4, (Object) null));
        if (valOr != null) {
            String valOr3 = MappersKt.getValOr(this.params, "cvc", (String) null);
            if (valOr3 != null) {
                card = new PaymentMethodOptionsParams.Card(valOr3, (String) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, 6, (DefaultConstructorMarker) null);
            }
            return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodId$default(ConfirmPaymentIntentParams.Companion, valOr, this.clientSecret, (Boolean) null, card, (String) null, (MandateDataParams) null, mapToPaymentIntentFutureUsage, (ConfirmPaymentIntentParams.Shipping) null, 180, (Object) null);
        }
        if (valOr2 != null) {
            cardParams = PaymentMethodCreateParams.Card.Companion.create(valOr2);
        }
        PaymentMethodCreateParams.Card card2 = cardParams;
        PaymentMethodCreateParams.Companion companion = PaymentMethodCreateParams.Companion;
        Intrinsics.checkNotNull(card2);
        return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(companion, card2, this.billingDetailsParams, (Map) null, 4, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, mapToPaymentIntentFutureUsage, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 220, (Object) null);
    }

    private final ConfirmSetupIntentParams createIDEALPaymentSetupParams() throws PaymentMethodCreateParamsException {
        return ConfirmSetupIntentParams.Companion.create$default(ConfirmSetupIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.Ideal(MappersKt.getValOr(this.params, "bankName", (String) null)), this.billingDetailsParams, (Map) null, 4, (Object) null), this.clientSecret, (MandateDataParams) null, (String) null, 12, (Object) null);
    }

    private final ConfirmSetupIntentParams createSepaPaymentSetupParams() throws PaymentMethodCreateParamsException {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails != null) {
            String valOr = MappersKt.getValOr(this.params, "iban", (String) null);
            if (valOr != null) {
                return ConfirmSetupIntentParams.Companion.create$default(ConfirmSetupIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.SepaDebit(valOr), billingDetails, (Map) null, 4, (Object) null), this.clientSecret, (MandateDataParams) null, (String) null, 12, (Object) null);
            }
            PaymentMethodCreateParamsFactory paymentMethodCreateParamsFactory = this;
            throw new PaymentMethodCreateParamsException("You must provide IBAN");
        }
        throw new PaymentMethodCreateParamsException("You must provide billing details");
    }

    private final ConfirmSetupIntentParams createCardPaymentSetupParams() throws PaymentMethodCreateParamsException {
        PaymentMethodCreateParams.Card card;
        CardFieldView cardFieldView2 = this.cardFieldView;
        PaymentMethodCreateParams.Card card2 = null;
        PaymentMethodCreateParams.Card cardParams = cardFieldView2 == null ? null : cardFieldView2.getCardParams();
        if (cardParams == null) {
            CardFormView cardFormView2 = this.cardFormView;
            if (cardFormView2 != null) {
                card2 = cardFormView2.getCardParams();
            }
            if (card2 != null) {
                card = card2;
            } else {
                throw new PaymentMethodCreateParamsException("Card details not complete");
            }
        } else {
            card = cardParams;
        }
        return ConfirmSetupIntentParams.Companion.create$default(ConfirmSetupIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, card, this.billingDetailsParams, (Map) null, 4, (Object) null), this.clientSecret, (MandateDataParams) null, (String) null, 12, (Object) null);
    }

    private final ConfirmPaymentIntentParams createAlipayPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        return ConfirmPaymentIntentParams.Companion.createAlipay(this.clientSecret);
    }

    private final ConfirmPaymentIntentParams createSofortPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        String valOr = MappersKt.getValOr(this.params, "country", (String) null);
        if (valOr != null) {
            ConfirmPaymentIntentParams.SetupFutureUsage mapToPaymentIntentFutureUsage = MappersKt.mapToPaymentIntentFutureUsage(MappersKt.getValOr$default(this.params, "setupFutureUsage", (String) null, 4, (Object) null));
            return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.Sofort(valOr), this.billingDetailsParams, (Map) null, 4, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, mapToPaymentIntentFutureUsage, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 220, (Object) null);
        }
        PaymentMethodCreateParamsFactory paymentMethodCreateParamsFactory = this;
        throw new PaymentMethodCreateParamsException("You must provide bank account country");
    }

    private final ConfirmSetupIntentParams createSofortPaymentSetupParams() throws PaymentMethodCreateParamsException {
        String valOr = MappersKt.getValOr(this.params, "country", (String) null);
        if (valOr != null) {
            return ConfirmSetupIntentParams.Companion.create$default(ConfirmSetupIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.Sofort(valOr), this.billingDetailsParams, (Map) null, 4, (Object) null), this.clientSecret, (MandateDataParams) null, (String) null, 12, (Object) null);
        }
        throw new PaymentMethodCreateParamsException("You must provide country");
    }

    private final ConfirmPaymentIntentParams createGrabPayPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails == null) {
            billingDetails = new PaymentMethod.BillingDetails((Address) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        }
        return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.createGrabPay$default(PaymentMethodCreateParams.Companion, billingDetails, (Map) null, 2, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
    }

    private final ConfirmPaymentIntentParams createBancontactPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails != null) {
            ConfirmPaymentIntentParams.SetupFutureUsage mapToPaymentIntentFutureUsage = MappersKt.mapToPaymentIntentFutureUsage(MappersKt.getValOr(this.params, "setupFutureUsage", (String) null));
            return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.createBancontact$default(PaymentMethodCreateParams.Companion, billingDetails, (Map) null, 2, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, mapToPaymentIntentFutureUsage, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 220, (Object) null);
        }
        throw new PaymentMethodCreateParamsException("You must provide billing details");
    }

    private final ConfirmSetupIntentParams createBancontactPaymentSetupParams() {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails != null) {
            return ConfirmSetupIntentParams.Companion.create$default(ConfirmSetupIntentParams.Companion, PaymentMethodCreateParams.Companion.createBancontact$default(PaymentMethodCreateParams.Companion, billingDetails, (Map) null, 2, (Object) null), this.clientSecret, (MandateDataParams) null, (String) null, 12, (Object) null);
        }
        throw new PaymentMethodCreateParamsException("You must provide billing details");
    }

    private final ConfirmPaymentIntentParams createOXXOPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails != null) {
            return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.createOxxo$default(PaymentMethodCreateParams.Companion, billingDetails, (Map) null, 2, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
        }
        throw new PaymentMethodCreateParamsException("You must provide billing details");
    }

    private final ConfirmPaymentIntentParams createEPSPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails != null) {
            return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.createEps$default(PaymentMethodCreateParams.Companion, billingDetails, (Map) null, 2, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
        }
        throw new PaymentMethodCreateParamsException("You must provide billing details");
    }

    private final ConfirmPaymentIntentParams createGiropayPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails != null) {
            return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.createGiropay$default(PaymentMethodCreateParams.Companion, billingDetails, (Map) null, 2, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
        }
        throw new PaymentMethodCreateParamsException("You must provide billing details");
    }

    private final ConfirmPaymentIntentParams createSepaPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails != null) {
            String valOr = MappersKt.getValOr(this.params, "iban", (String) null);
            if (valOr != null) {
                ConfirmPaymentIntentParams.SetupFutureUsage mapToPaymentIntentFutureUsage = MappersKt.mapToPaymentIntentFutureUsage(MappersKt.getValOr$default(this.params, "setupFutureUsage", (String) null, 4, (Object) null));
                return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.SepaDebit(valOr), billingDetails, (Map) null, 4, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, mapToPaymentIntentFutureUsage, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 220, (Object) null);
            }
            PaymentMethodCreateParamsFactory paymentMethodCreateParamsFactory = this;
            throw new PaymentMethodCreateParamsException("You must provide IBAN");
        }
        throw new PaymentMethodCreateParamsException("You must provide billing details");
    }

    private final ConfirmPaymentIntentParams createFpxPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        MappersKt.getBooleanOrFalse(this.params, "testOfflineBank");
        return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.Fpx("test_offline_bank"), (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
    }

    private final ConfirmPaymentIntentParams createAfterpayClearpayPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails != null) {
            return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.createAfterpayClearpay$default(PaymentMethodCreateParams.Companion, billingDetails, (Map) null, 2, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
        }
        throw new PaymentMethodCreateParamsException("You must provide billing details");
    }

    private final ConfirmPaymentIntentParams createAuBecsDebitPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        ReadableMap mapOrNull = MappersKt.getMapOrNull(this.params, "formDetails");
        if (mapOrNull != null) {
            String valOr$default = MappersKt.getValOr$default(mapOrNull, "bsbNumber", (String) null, 4, (Object) null);
            Objects.requireNonNull(valOr$default, "null cannot be cast to non-null type kotlin.String");
            String valOr$default2 = MappersKt.getValOr$default(mapOrNull, "accountNumber", (String) null, 4, (Object) null);
            Objects.requireNonNull(valOr$default2, "null cannot be cast to non-null type kotlin.String");
            String valOr$default3 = MappersKt.getValOr$default(mapOrNull, "name", (String) null, 4, (Object) null);
            Objects.requireNonNull(valOr$default3, "null cannot be cast to non-null type kotlin.String");
            String valOr$default4 = MappersKt.getValOr$default(mapOrNull, "email", (String) null, 4, (Object) null);
            Objects.requireNonNull(valOr$default4, "null cannot be cast to non-null type kotlin.String");
            return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.AuBecsDebit(valOr$default, valOr$default2), new PaymentMethod.BillingDetails.Builder().setName(valOr$default3).setEmail(valOr$default4).build(), (Map) null, 4, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
        }
        PaymentMethodCreateParamsFactory paymentMethodCreateParamsFactory = this;
        throw new PaymentMethodCreateParamsException("You must provide form details");
    }

    private final ConfirmSetupIntentParams createAuBecsDebitPaymentSetupParams() throws PaymentMethodCreateParamsException {
        ReadableMap mapOrNull = MappersKt.getMapOrNull(this.params, "formDetails");
        if (mapOrNull != null) {
            String valOr$default = MappersKt.getValOr$default(mapOrNull, "bsbNumber", (String) null, 4, (Object) null);
            Objects.requireNonNull(valOr$default, "null cannot be cast to non-null type kotlin.String");
            String valOr$default2 = MappersKt.getValOr$default(mapOrNull, "accountNumber", (String) null, 4, (Object) null);
            Objects.requireNonNull(valOr$default2, "null cannot be cast to non-null type kotlin.String");
            String valOr$default3 = MappersKt.getValOr$default(mapOrNull, "name", (String) null, 4, (Object) null);
            Objects.requireNonNull(valOr$default3, "null cannot be cast to non-null type kotlin.String");
            String valOr$default4 = MappersKt.getValOr$default(mapOrNull, "email", (String) null, 4, (Object) null);
            Objects.requireNonNull(valOr$default4, "null cannot be cast to non-null type kotlin.String");
            return ConfirmSetupIntentParams.Companion.create$default(ConfirmSetupIntentParams.Companion, PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.AuBecsDebit(valOr$default, valOr$default2), new PaymentMethod.BillingDetails.Builder().setName(valOr$default3).setEmail(valOr$default4).build(), (Map) null, 4, (Object) null), this.clientSecret, (MandateDataParams) null, (String) null, 12, (Object) null);
        }
        PaymentMethodCreateParamsFactory paymentMethodCreateParamsFactory = this;
        throw new PaymentMethodCreateParamsException("You must provide form details");
    }

    private final ConfirmSetupIntentParams createUSBankAccountPaymentSetupParams() throws PaymentMethodCreateParamsException {
        if (this.params.getString("accountNumber") == null) {
            return ConfirmSetupIntentParams.Companion.create(this.clientSecret, PaymentMethod.Type.USBankAccount);
        }
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        CharSequence charSequence = billingDetails == null ? null : billingDetails.name;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            return ConfirmSetupIntentParams.Companion.create$default(ConfirmSetupIntentParams.Companion, createUSBankAccountParams(this.params), this.clientSecret, (MandateDataParams) null, (String) null, 12, (Object) null);
        }
        throw new PaymentMethodCreateParamsException("When creating a US bank account payment method, you must provide the following billing details: name");
    }

    private final ConfirmPaymentIntentParams createKlarnaPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        if (billingDetails != null) {
            Address address = billingDetails.address;
            CharSequence country = address == null ? null : address.getCountry();
            boolean z = false;
            if (!(country == null || StringsKt.isBlank(country))) {
                CharSequence charSequence = this.billingDetailsParams.email;
                if (charSequence == null || StringsKt.isBlank(charSequence)) {
                    z = true;
                }
                if (!z) {
                    return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, PaymentMethodCreateParams.Companion.createKlarna$default(PaymentMethodCreateParams.Companion, this.billingDetailsParams, (Map) null, 2, (Object) null), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
                }
            }
        }
        throw new PaymentMethodCreateParamsException("Klarna requires that you provide the following billing details: email, country");
    }

    private final ConfirmPaymentIntentParams createUSBankAccountPaymentConfirmParams() throws PaymentMethodCreateParamsException {
        if (this.params.getString("accountNumber") == null) {
            return ConfirmPaymentIntentParams.Companion.create(this.clientSecret, PaymentMethod.Type.USBankAccount);
        }
        PaymentMethod.BillingDetails billingDetails = this.billingDetailsParams;
        CharSequence charSequence = billingDetails == null ? null : billingDetails.name;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, createUSBankAccountParams(this.params), this.clientSecret, (Boolean) null, (String) null, (MandateDataParams) null, MappersKt.mapToPaymentIntentFutureUsage(MappersKt.getValOr$default(this.params, "setupFutureUsage", (String) null, 4, (Object) null)), (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 220, (Object) null);
        }
        throw new PaymentMethodCreateParamsException("When creating a US bank account payment method, you must provide the following billing details: name");
    }

    private final PaymentMethodCreateParams createUSBankAccountParams(ReadableMap readableMap) throws PaymentMethodCreateParamsException {
        String valOr = MappersKt.getValOr(readableMap, "accountNumber", (String) null);
        String valOr2 = MappersKt.getValOr(readableMap, "routingNumber", (String) null);
        CharSequence charSequence = valOr;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = valOr2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                return PaymentMethodCreateParams.Companion.create(new PaymentMethodCreateParams.USBankAccount(valOr, valOr2, MappersKt.mapToUSBankAccountType(MappersKt.getValOr(readableMap, "accountType", (String) null)), MappersKt.mapToUSBankAccountHolderType(MappersKt.getValOr(readableMap, "accountHolderType", (String) null))), this.billingDetailsParams, (Map<String, String>) null);
            }
            throw new PaymentMethodCreateParamsException("When creating a US bank account payment method, you must provide the bank routing number");
        }
        throw new PaymentMethodCreateParamsException("When creating a US bank account payment method, you must provide the bank account number");
    }
}

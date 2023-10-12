package com.reactnativestripesdk;

import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.braintreepayments.api.models.BinData;
import com.braintreepayments.api.models.PostalAddressParser;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.henninghall.date_picker.props.TextColorProp;
import com.stripe.android.PaymentAuthConfig;
import com.stripe.android.model.Address;
import com.stripe.android.model.BankAccount;
import com.stripe.android.model.BankAccountTokenParams;
import com.stripe.android.model.Card;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.CardFunding;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.MicrodepositType;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodOptionsParams;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.Token;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

@Metadata(d1 = {"\u0000\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u001f\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0002\u0010\u000e\u001a\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a$\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000\u001a\u0012\u0010\u0016\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000\u001a\u0012\u0010\u0019\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u001aH\u0000\u001a\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000\u001a\u0012\u0010\u001e\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0000\u001a\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010#H\u0000\u001a\u0012\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0000\u001a\u0014\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0000\u001a\u0010\u0010*\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020+H\u0000\u001a\u0014\u0010,\u001a\u0004\u0018\u00010\u00012\b\u0010-\u001a\u0004\u0018\u00010.H\u0000\u001a\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0000\u001a\u0010\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u000204H\u0000\u001a\u0014\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010-\u001a\u0004\u0018\u000106H\u0000\u001a\u0010\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u000209H\u0000\u001a\u0010\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<H\u0000\u001a\u0012\u0010=\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010>H\u0000\u001a\u0012\u0010?\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010@H\u0000\u001a\u0010\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020CH\u0000\u001a\u0012\u0010D\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010EH\u0000\u001a\u001e\u0010F\u001a\u0004\u0018\u00010G2\b\u0010\"\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0000\u001a\u0012\u0010K\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010LH\u0000\u001a\u0012\u0010M\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010NH\u0000\u001a\u001e\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010\u000b2\b\u0010R\u001a\u0004\u0018\u00010PH\u0000\u001a\u0012\u0010S\u001a\u00020T2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001e\u0010U\u001a\u0004\u0018\u00010&2\b\u0010V\u001a\u0004\u0018\u00010\u000b2\b\u0010R\u001a\u0004\u0018\u00010PH\u0000\u001a\u0012\u0010W\u001a\u0004\u0018\u00010X2\b\u0010\"\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010Y\u001a\u0004\u0018\u00010L2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0014\u0010Z\u001a\u0004\u0018\u00010\u00012\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0014\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010\u000bH\u0000\u001a\u000e\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u000b\u001a\u0012\u0010b\u001a\u00020>2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0012\u0010c\u001a\u00020@2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0010\u0010d\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020eH\u0000\u001a\u0010\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010\u000b¨\u0006i"}, d2 = {"convertToUnixTimestamp", "", "timestamp", "", "createResult", "Lcom/facebook/react/bridge/WritableMap;", "key", "value", "getBooleanOrFalse", "", "map", "Lcom/facebook/react/bridge/ReadableMap;", "getIntOrNull", "", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)Ljava/lang/Integer;", "getMapOrNull", "getStringOrNull", "getValOr", "default", "mapCaptureMethod", "captureMethod", "Lcom/stripe/android/model/PaymentIntent$CaptureMethod;", "mapCardBrand", "brand", "Lcom/stripe/android/model/CardBrand;", "mapConfirmationMethod", "Lcom/stripe/android/model/PaymentIntent$ConfirmationMethod;", "mapFromBankAccount", "bankAccount", "Lcom/stripe/android/model/BankAccount;", "mapFromBankAccountStatus", "status", "Lcom/stripe/android/model/BankAccount$Status;", "mapFromBankAccountType", "type", "Lcom/stripe/android/model/BankAccount$Type;", "mapFromBillingDetails", "billingDatails", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "mapFromCard", "card", "Lcom/stripe/android/model/Card;", "mapFromMicrodepositType", "Lcom/stripe/android/model/MicrodepositType;", "mapFromPaymentIntentLastErrorType", "errorType", "Lcom/stripe/android/model/PaymentIntent$Error$Type;", "mapFromPaymentIntentResult", "paymentIntent", "Lcom/stripe/android/model/PaymentIntent;", "mapFromPaymentMethod", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "mapFromSetupIntentLastErrorType", "Lcom/stripe/android/model/SetupIntent$Error$Type;", "mapFromSetupIntentResult", "setupIntent", "Lcom/stripe/android/model/SetupIntent;", "mapFromToken", "token", "Lcom/stripe/android/model/Token;", "mapFromUSBankAccountHolderType", "Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountHolderType;", "mapFromUSBankAccountType", "Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountType;", "mapIntentShipping", "shipping", "Lcom/stripe/android/model/PaymentIntent$Shipping;", "mapIntentStatus", "Lcom/stripe/android/model/StripeIntent$Status;", "mapNextAction", "Lcom/facebook/react/bridge/WritableNativeMap;", "Lcom/stripe/android/model/StripeIntent$NextActionType;", "data", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "mapPaymentMethodType", "Lcom/stripe/android/model/PaymentMethod$Type;", "mapSetupIntentUsage", "Lcom/stripe/android/model/StripeIntent$Usage;", "mapToAddress", "Lcom/stripe/android/model/Address;", "addressMap", "cardAddress", "mapToBankAccountType", "Lcom/stripe/android/model/BankAccountTokenParams$Type;", "mapToBillingDetails", "billingDetails", "mapToPaymentIntentFutureUsage", "Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;", "mapToPaymentMethodType", "mapToReturnURL", "urlScheme", "mapToShippingDetails", "Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;", "shippingDetails", "mapToUICustomization", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization;", "params", "mapToUSBankAccountHolderType", "mapToUSBankAccountType", "mapTokenType", "Lcom/stripe/android/model/Token$Type;", "toBundleObject", "Landroid/os/Bundle;", "readableMap", "stripe_stripe-react-native_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Mappers.kt */
public final class MappersKt {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Mappers.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$10;
        public static final /* synthetic */ int[] $EnumSwitchMapping$11;
        public static final /* synthetic */ int[] $EnumSwitchMapping$12;
        public static final /* synthetic */ int[] $EnumSwitchMapping$13;
        public static final /* synthetic */ int[] $EnumSwitchMapping$14;
        public static final /* synthetic */ int[] $EnumSwitchMapping$15;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8;
        public static final /* synthetic */ int[] $EnumSwitchMapping$9;

        static {
            int[] iArr = new int[StripeIntent.Status.values().length];
            iArr[StripeIntent.Status.Succeeded.ordinal()] = 1;
            iArr[StripeIntent.Status.RequiresPaymentMethod.ordinal()] = 2;
            iArr[StripeIntent.Status.RequiresConfirmation.ordinal()] = 3;
            iArr[StripeIntent.Status.Canceled.ordinal()] = 4;
            iArr[StripeIntent.Status.Processing.ordinal()] = 5;
            iArr[StripeIntent.Status.RequiresAction.ordinal()] = 6;
            iArr[StripeIntent.Status.RequiresCapture.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PaymentIntent.CaptureMethod.values().length];
            iArr2[PaymentIntent.CaptureMethod.Automatic.ordinal()] = 1;
            iArr2[PaymentIntent.CaptureMethod.Manual.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[PaymentIntent.ConfirmationMethod.values().length];
            iArr3[PaymentIntent.ConfirmationMethod.Automatic.ordinal()] = 1;
            iArr3[PaymentIntent.ConfirmationMethod.Manual.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[CardBrand.values().length];
            iArr4[CardBrand.AmericanExpress.ordinal()] = 1;
            iArr4[CardBrand.DinersClub.ordinal()] = 2;
            iArr4[CardBrand.Discover.ordinal()] = 3;
            iArr4[CardBrand.JCB.ordinal()] = 4;
            iArr4[CardBrand.MasterCard.ordinal()] = 5;
            iArr4[CardBrand.UnionPay.ordinal()] = 6;
            iArr4[CardBrand.Visa.ordinal()] = 7;
            iArr4[CardBrand.Unknown.ordinal()] = 8;
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[PaymentMethod.Type.values().length];
            iArr5[PaymentMethod.Type.AfterpayClearpay.ordinal()] = 1;
            iArr5[PaymentMethod.Type.Alipay.ordinal()] = 2;
            iArr5[PaymentMethod.Type.AuBecsDebit.ordinal()] = 3;
            iArr5[PaymentMethod.Type.BacsDebit.ordinal()] = 4;
            iArr5[PaymentMethod.Type.Bancontact.ordinal()] = 5;
            iArr5[PaymentMethod.Type.Card.ordinal()] = 6;
            iArr5[PaymentMethod.Type.CardPresent.ordinal()] = 7;
            iArr5[PaymentMethod.Type.Eps.ordinal()] = 8;
            iArr5[PaymentMethod.Type.Fpx.ordinal()] = 9;
            iArr5[PaymentMethod.Type.Giropay.ordinal()] = 10;
            iArr5[PaymentMethod.Type.GrabPay.ordinal()] = 11;
            iArr5[PaymentMethod.Type.Ideal.ordinal()] = 12;
            iArr5[PaymentMethod.Type.Netbanking.ordinal()] = 13;
            iArr5[PaymentMethod.Type.Oxxo.ordinal()] = 14;
            iArr5[PaymentMethod.Type.P24.ordinal()] = 15;
            iArr5[PaymentMethod.Type.SepaDebit.ordinal()] = 16;
            iArr5[PaymentMethod.Type.Sofort.ordinal()] = 17;
            iArr5[PaymentMethod.Type.Upi.ordinal()] = 18;
            iArr5[PaymentMethod.Type.WeChatPay.ordinal()] = 19;
            iArr5[PaymentMethod.Type.Klarna.ordinal()] = 20;
            iArr5[PaymentMethod.Type.USBankAccount.ordinal()] = 21;
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[Token.Type.values().length];
            iArr6[Token.Type.Account.ordinal()] = 1;
            iArr6[Token.Type.BankAccount.ordinal()] = 2;
            iArr6[Token.Type.Card.ordinal()] = 3;
            iArr6[Token.Type.CvcUpdate.ordinal()] = 4;
            iArr6[Token.Type.Person.ordinal()] = 5;
            iArr6[Token.Type.Pii.ordinal()] = 6;
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[BankAccount.Type.values().length];
            iArr7[BankAccount.Type.Company.ordinal()] = 1;
            iArr7[BankAccount.Type.Individual.ordinal()] = 2;
            $EnumSwitchMapping$6 = iArr7;
            int[] iArr8 = new int[BankAccount.Status.values().length];
            iArr8[BankAccount.Status.Errored.ordinal()] = 1;
            iArr8[BankAccount.Status.New.ordinal()] = 2;
            iArr8[BankAccount.Status.Validated.ordinal()] = 3;
            iArr8[BankAccount.Status.VerificationFailed.ordinal()] = 4;
            iArr8[BankAccount.Status.Verified.ordinal()] = 5;
            $EnumSwitchMapping$7 = iArr8;
            int[] iArr9 = new int[PaymentMethod.USBankAccount.USBankAccountHolderType.values().length];
            iArr9[PaymentMethod.USBankAccount.USBankAccountHolderType.COMPANY.ordinal()] = 1;
            iArr9[PaymentMethod.USBankAccount.USBankAccountHolderType.INDIVIDUAL.ordinal()] = 2;
            $EnumSwitchMapping$8 = iArr9;
            int[] iArr10 = new int[PaymentMethod.USBankAccount.USBankAccountType.values().length];
            iArr10[PaymentMethod.USBankAccount.USBankAccountType.CHECKING.ordinal()] = 1;
            iArr10[PaymentMethod.USBankAccount.USBankAccountType.SAVINGS.ordinal()] = 2;
            $EnumSwitchMapping$9 = iArr10;
            int[] iArr11 = new int[MicrodepositType.values().length];
            iArr11[MicrodepositType.AMOUNTS.ordinal()] = 1;
            iArr11[MicrodepositType.DESCRIPTOR_CODE.ordinal()] = 2;
            $EnumSwitchMapping$10 = iArr11;
            int[] iArr12 = new int[StripeIntent.NextActionType.values().length];
            iArr12[StripeIntent.NextActionType.RedirectToUrl.ordinal()] = 1;
            iArr12[StripeIntent.NextActionType.VerifyWithMicrodeposits.ordinal()] = 2;
            iArr12[StripeIntent.NextActionType.DisplayOxxoDetails.ordinal()] = 3;
            iArr12[StripeIntent.NextActionType.WeChatPayRedirect.ordinal()] = 4;
            iArr12[StripeIntent.NextActionType.AlipayRedirect.ordinal()] = 5;
            iArr12[StripeIntent.NextActionType.BlikAuthorize.ordinal()] = 6;
            iArr12[StripeIntent.NextActionType.UseStripeSdk.ordinal()] = 7;
            $EnumSwitchMapping$11 = iArr12;
            int[] iArr13 = new int[PaymentIntent.Error.Type.values().length];
            iArr13[PaymentIntent.Error.Type.ApiConnectionError.ordinal()] = 1;
            iArr13[PaymentIntent.Error.Type.AuthenticationError.ordinal()] = 2;
            iArr13[PaymentIntent.Error.Type.ApiError.ordinal()] = 3;
            iArr13[PaymentIntent.Error.Type.CardError.ordinal()] = 4;
            iArr13[PaymentIntent.Error.Type.IdempotencyError.ordinal()] = 5;
            iArr13[PaymentIntent.Error.Type.InvalidRequestError.ordinal()] = 6;
            iArr13[PaymentIntent.Error.Type.RateLimitError.ordinal()] = 7;
            $EnumSwitchMapping$12 = iArr13;
            int[] iArr14 = new int[SetupIntent.Error.Type.values().length];
            iArr14[SetupIntent.Error.Type.ApiConnectionError.ordinal()] = 1;
            iArr14[SetupIntent.Error.Type.AuthenticationError.ordinal()] = 2;
            iArr14[SetupIntent.Error.Type.ApiError.ordinal()] = 3;
            iArr14[SetupIntent.Error.Type.CardError.ordinal()] = 4;
            iArr14[SetupIntent.Error.Type.IdempotencyError.ordinal()] = 5;
            iArr14[SetupIntent.Error.Type.InvalidRequestError.ordinal()] = 6;
            iArr14[SetupIntent.Error.Type.RateLimitError.ordinal()] = 7;
            $EnumSwitchMapping$13 = iArr14;
            int[] iArr15 = new int[StripeIntent.Usage.values().length];
            iArr15[StripeIntent.Usage.OffSession.ordinal()] = 1;
            iArr15[StripeIntent.Usage.OnSession.ordinal()] = 2;
            iArr15[StripeIntent.Usage.OneTime.ordinal()] = 3;
            $EnumSwitchMapping$14 = iArr15;
            int[] iArr16 = new int[ReadableType.values().length];
            iArr16[ReadableType.Null.ordinal()] = 1;
            iArr16[ReadableType.Boolean.ordinal()] = 2;
            iArr16[ReadableType.Number.ordinal()] = 3;
            iArr16[ReadableType.String.ordinal()] = 4;
            iArr16[ReadableType.Map.ordinal()] = 5;
            iArr16[ReadableType.Array.ordinal()] = 6;
            $EnumSwitchMapping$15 = iArr16;
        }
    }

    public static final WritableMap createResult(String str, WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(writableMap, "value");
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap(str, writableMap);
        return writableNativeMap;
    }

    public static final String mapIntentStatus(StripeIntent.Status status) {
        switch (status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
                return "Succeeded";
            case 2:
                return "RequiresPaymentMethod";
            case 3:
                return "RequiresConfirmation";
            case 4:
                return "Canceled";
            case 5:
                return "Processing";
            case 6:
                return "RequiresAction";
            case 7:
                return "RequiresCapture";
            default:
                return BinData.UNKNOWN;
        }
    }

    public static final String mapCaptureMethod(PaymentIntent.CaptureMethod captureMethod) {
        int i = captureMethod == null ? -1 : WhenMappings.$EnumSwitchMapping$1[captureMethod.ordinal()];
        if (i != 1) {
            return i != 2 ? BinData.UNKNOWN : "Manual";
        }
        return "Automatic";
    }

    public static final String mapConfirmationMethod(PaymentIntent.ConfirmationMethod confirmationMethod) {
        int i = confirmationMethod == null ? -1 : WhenMappings.$EnumSwitchMapping$2[confirmationMethod.ordinal()];
        if (i != 1) {
            return i != 2 ? BinData.UNKNOWN : "Manual";
        }
        return "Automatic";
    }

    public static final String mapToReturnURL(String str) {
        if (str != null) {
            return Intrinsics.stringPlus(str, "://safepay");
        }
        return null;
    }

    public static final WritableMap mapIntentShipping(PaymentIntent.Shipping shipping) {
        Intrinsics.checkNotNullParameter(shipping, FirebaseAnalytics.Param.SHIPPING);
        WritableMap writableNativeMap = new WritableNativeMap();
        WritableMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putString(PostalAddressParser.LOCALITY_KEY, shipping.getAddress().getCity());
        writableNativeMap2.putString("country", shipping.getAddress().getCountry());
        writableNativeMap2.putString(PostalAddressParser.LINE_1_KEY, shipping.getAddress().getLine1());
        writableNativeMap2.putString(PostalAddressParser.LINE_2_KEY, shipping.getAddress().getLine2());
        writableNativeMap2.putString("postalCode", shipping.getAddress().getPostalCode());
        writableNativeMap2.putString(PostalAddressParser.REGION_KEY, shipping.getAddress().getState());
        writableNativeMap.putMap(PaymentMethod.BillingDetails.PARAM_ADDRESS, writableNativeMap2);
        writableNativeMap.putString("name", shipping.getName());
        writableNativeMap.putString("carrier", shipping.getCarrier());
        writableNativeMap.putString("phone", shipping.getPhone());
        writableNativeMap.putString("trackingNumber", shipping.getTrackingNumber());
        return writableNativeMap;
    }

    public static final String mapCardBrand(CardBrand cardBrand) {
        switch (cardBrand == null ? -1 : WhenMappings.$EnumSwitchMapping$3[cardBrand.ordinal()]) {
            case 1:
                return "AmericanExpress";
            case 2:
                return "DinersClub";
            case 3:
                return "Discover";
            case 4:
                return "JCB";
            case 5:
                return "MasterCard";
            case 6:
                return "UnionPay";
            case 7:
                return "Visa";
            default:
                return BinData.UNKNOWN;
        }
    }

    public static final String mapPaymentMethodType(PaymentMethod.Type type) {
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$4[type.ordinal()]) {
            case 1:
                return "AfterpayClearpay";
            case 2:
                return "Alipay";
            case 3:
                return "AuBecsDebit";
            case 4:
                return "BacsDebit";
            case 5:
                return "Bancontact";
            case 6:
                return "Card";
            case 7:
                return "CardPresent";
            case 8:
                return "Eps";
            case 9:
                return "Fpx";
            case 10:
                return "Giropay";
            case 11:
                return "GrabPay";
            case 12:
                return "Ideal";
            case 13:
                return "Netbanking";
            case 14:
                return "Oxxo";
            case 15:
                return "P24";
            case 16:
                return "SepaDebit";
            case 17:
                return "Sofort";
            case 18:
                return "Upi";
            case 19:
                return "WeChatPay";
            case 20:
                return "Klarna";
            case 21:
                return "USBankAccount";
            default:
                return BinData.UNKNOWN;
        }
    }

    public static final PaymentMethod.Type mapToPaymentMethodType(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -2045037915:
                    if (str.equals("Klarna")) {
                        return PaymentMethod.Type.Klarna;
                    }
                    break;
                case -1813087929:
                    if (str.equals("Sofort")) {
                        return PaymentMethod.Type.Sofort;
                    }
                    break;
                case -752190179:
                    if (str.equals("BacsDebit")) {
                        return PaymentMethod.Type.BacsDebit;
                    }
                    break;
                case -600549687:
                    if (str.equals("SepaDebit")) {
                        return PaymentMethod.Type.SepaDebit;
                    }
                    break;
                case -529183021:
                    if (str.equals("USBankAccount")) {
                        return PaymentMethod.Type.USBankAccount;
                    }
                    break;
                case -430881083:
                    if (str.equals("AuBecsDebit")) {
                        return PaymentMethod.Type.AuBecsDebit;
                    }
                    break;
                case -346968055:
                    if (str.equals("Netbanking")) {
                        return PaymentMethod.Type.Netbanking;
                    }
                    break;
                case -302881593:
                    if (str.equals("AfterpayClearpay")) {
                        return PaymentMethod.Type.AfterpayClearpay;
                    }
                    break;
                case -295777438:
                    if (str.equals("WeChatPay")) {
                        return PaymentMethod.Type.WeChatPay;
                    }
                    break;
                case 69896:
                    if (str.equals("Eps")) {
                        return PaymentMethod.Type.Eps;
                    }
                    break;
                case 70862:
                    if (str.equals("Fpx")) {
                        return PaymentMethod.Type.Fpx;
                    }
                    break;
                case 78482:
                    if (str.equals("P24")) {
                        return PaymentMethod.Type.P24;
                    }
                    break;
                case 85262:
                    if (str.equals("Upi")) {
                        return PaymentMethod.Type.Upi;
                    }
                    break;
                case 2092848:
                    if (str.equals("Card")) {
                        return PaymentMethod.Type.Card;
                    }
                    break;
                case 2472640:
                    if (str.equals("Oxxo")) {
                        return PaymentMethod.Type.Oxxo;
                    }
                    break;
                case 70496309:
                    if (str.equals("Ideal")) {
                        return PaymentMethod.Type.Ideal;
                    }
                    break;
                case 72721745:
                    if (str.equals("Bancontact")) {
                        return PaymentMethod.Type.Bancontact;
                    }
                    break;
                case 1703011721:
                    if (str.equals("Giropay")) {
                        return PaymentMethod.Type.Giropay;
                    }
                    break;
                case 1918741355:
                    if (str.equals("CardPresent")) {
                        return PaymentMethod.Type.CardPresent;
                    }
                    break;
                case 1944556188:
                    if (str.equals("GrabPay")) {
                        return PaymentMethod.Type.GrabPay;
                    }
                    break;
                case 1963873898:
                    if (str.equals("Alipay")) {
                        return PaymentMethod.Type.Alipay;
                    }
                    break;
            }
        }
        return null;
    }

    public static final WritableMap mapFromBillingDetails(PaymentMethod.BillingDetails billingDetails) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Address address;
        Address address2;
        Address address3;
        Address address4;
        Address address5;
        Address address6;
        WritableMap writableNativeMap = new WritableNativeMap();
        WritableMap writableNativeMap2 = new WritableNativeMap();
        String str9 = null;
        if (billingDetails == null || (address6 = billingDetails.address) == null) {
            str = null;
        } else {
            str = address6.getCountry();
        }
        writableNativeMap2.putString("country", str);
        if (billingDetails == null || (address5 = billingDetails.address) == null) {
            str2 = null;
        } else {
            str2 = address5.getCity();
        }
        writableNativeMap2.putString(PostalAddressParser.LOCALITY_KEY, str2);
        if (billingDetails == null || (address4 = billingDetails.address) == null) {
            str3 = null;
        } else {
            str3 = address4.getLine1();
        }
        writableNativeMap2.putString(PostalAddressParser.LINE_1_KEY, str3);
        if (billingDetails == null || (address3 = billingDetails.address) == null) {
            str4 = null;
        } else {
            str4 = address3.getLine2();
        }
        writableNativeMap2.putString(PostalAddressParser.LINE_2_KEY, str4);
        if (billingDetails == null || (address2 = billingDetails.address) == null) {
            str5 = null;
        } else {
            str5 = address2.getPostalCode();
        }
        writableNativeMap2.putString("postalCode", str5);
        if (billingDetails == null || (address = billingDetails.address) == null) {
            str6 = null;
        } else {
            str6 = address.getState();
        }
        writableNativeMap2.putString(PostalAddressParser.REGION_KEY, str6);
        if (billingDetails == null) {
            str7 = null;
        } else {
            str7 = billingDetails.email;
        }
        writableNativeMap.putString("email", str7);
        if (billingDetails == null) {
            str8 = null;
        } else {
            str8 = billingDetails.phone;
        }
        writableNativeMap.putString("phone", str8);
        if (billingDetails != null) {
            str9 = billingDetails.name;
        }
        writableNativeMap.putString("name", str9);
        writableNativeMap.putMap(PaymentMethod.BillingDetails.PARAM_ADDRESS, writableNativeMap2);
        return writableNativeMap;
    }

    public static final String mapTokenType(Token.Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$5[type.ordinal()]) {
            case 1:
                return "Account";
            case 2:
                return "BankAccount";
            case 3:
                return "Card";
            case 4:
                return "CvcUpdate";
            case 5:
                return "Person";
            case 6:
                return "Pii";
            default:
                return BinData.UNKNOWN;
        }
    }

    public static final String mapFromBankAccountType(BankAccount.Type type) {
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$6[type.ordinal()];
        if (i != 1) {
            return i != 2 ? BinData.UNKNOWN : "Individual";
        }
        return "Company";
    }

    public static final BankAccountTokenParams.Type mapToBankAccountType(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "Company")) {
            return BankAccountTokenParams.Type.Company;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "Individual")) {
            return BankAccountTokenParams.Type.Individual;
        }
        return BankAccountTokenParams.Type.Individual;
    }

    public static final String mapFromBankAccountStatus(BankAccount.Status status) {
        int i = status == null ? -1 : WhenMappings.$EnumSwitchMapping$7[status.ordinal()];
        if (i == 1) {
            return "Errored";
        }
        if (i == 2) {
            return "New";
        }
        if (i == 3) {
            return "Validated";
        }
        if (i != 4) {
            return i != 5 ? BinData.UNKNOWN : "Verified";
        }
        return "VerificationFailed";
    }

    public static final WritableMap mapFromBankAccount(BankAccount bankAccount) {
        WritableMap writableNativeMap = new WritableNativeMap();
        if (bankAccount == null) {
            return null;
        }
        writableNativeMap.putString(MessageExtension.FIELD_ID, bankAccount.getId());
        writableNativeMap.putString("bankName", bankAccount.getBankName());
        writableNativeMap.putString("accountHolderName", bankAccount.getAccountHolderName());
        writableNativeMap.putString("accountHolderType", mapFromBankAccountType(bankAccount.getAccountHolderType()));
        writableNativeMap.putString(FirebaseAnalytics.Param.CURRENCY, bankAccount.getCurrency());
        writableNativeMap.putString("country", bankAccount.getCountryCode());
        writableNativeMap.putString("routingNumber", bankAccount.getRoutingNumber());
        writableNativeMap.putString(NotificationCompat.CATEGORY_STATUS, mapFromBankAccountStatus(bankAccount.getStatus()));
        return writableNativeMap;
    }

    public static final PaymentMethod.USBankAccount.USBankAccountHolderType mapToUSBankAccountHolderType(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "Company")) {
            return PaymentMethod.USBankAccount.USBankAccountHolderType.COMPANY;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "Individual")) {
            return PaymentMethod.USBankAccount.USBankAccountHolderType.INDIVIDUAL;
        }
        return PaymentMethod.USBankAccount.USBankAccountHolderType.INDIVIDUAL;
    }

    public static final String mapFromUSBankAccountHolderType(PaymentMethod.USBankAccount.USBankAccountHolderType uSBankAccountHolderType) {
        int i = uSBankAccountHolderType == null ? -1 : WhenMappings.$EnumSwitchMapping$8[uSBankAccountHolderType.ordinal()];
        if (i != 1) {
            return i != 2 ? BinData.UNKNOWN : "Individual";
        }
        return "Company";
    }

    public static final PaymentMethod.USBankAccount.USBankAccountType mapToUSBankAccountType(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "Savings")) {
            return PaymentMethod.USBankAccount.USBankAccountType.SAVINGS;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "Checking")) {
            return PaymentMethod.USBankAccount.USBankAccountType.CHECKING;
        }
        return PaymentMethod.USBankAccount.USBankAccountType.CHECKING;
    }

    public static final String mapFromUSBankAccountType(PaymentMethod.USBankAccount.USBankAccountType uSBankAccountType) {
        int i = uSBankAccountType == null ? -1 : WhenMappings.$EnumSwitchMapping$9[uSBankAccountType.ordinal()];
        if (i != 1) {
            return i != 2 ? BinData.UNKNOWN : "Savings";
        }
        return "Checking";
    }

    public static final WritableMap mapFromCard(Card card) {
        Unit unit;
        Unit unit2;
        WritableMap writableNativeMap = new WritableNativeMap();
        String str = null;
        if (card == null) {
            return null;
        }
        WritableMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap.putString("country", card.getCountry());
        writableNativeMap.putString(AccountRangeJsonParser.FIELD_BRAND, mapCardBrand(card.getBrand()));
        writableNativeMap.putString(FirebaseAnalytics.Param.CURRENCY, card.getCurrency());
        Integer expMonth = card.getExpMonth();
        if (expMonth == null) {
            unit = null;
        } else {
            writableNativeMap.putInt("expMonth", expMonth.intValue());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            writableNativeMap.putNull("expMonth");
        }
        Integer expYear = card.getExpYear();
        if (expYear == null) {
            unit2 = null;
        } else {
            writableNativeMap.putInt("expYear", expYear.intValue());
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            writableNativeMap.putNull("expYear");
        }
        writableNativeMap.putString(MessageExtension.FIELD_ID, card.getId());
        writableNativeMap.putString("last4", card.getLast4());
        CardFunding funding = card.getFunding();
        if (funding != null) {
            str = funding.name();
        }
        writableNativeMap.putString("funding", str);
        writableNativeMap.putString("name", card.getName());
        writableNativeMap2.putString(PostalAddressParser.LOCALITY_KEY, card.getAddressCity());
        writableNativeMap2.putString("country", card.getAddressCountry());
        writableNativeMap2.putString(PostalAddressParser.LINE_1_KEY, card.getAddressLine1());
        writableNativeMap2.putString(PostalAddressParser.LINE_2_KEY, card.getAddressLine2());
        writableNativeMap2.putString(PostalAddressParser.REGION_KEY, card.getAddressState());
        writableNativeMap2.putString("postalCode", card.getAddressZip());
        writableNativeMap.putMap(PaymentMethod.BillingDetails.PARAM_ADDRESS, writableNativeMap2);
        return writableNativeMap;
    }

    public static final WritableMap mapFromToken(Token token) {
        Intrinsics.checkNotNullParameter(token, "token");
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString(MessageExtension.FIELD_ID, token.getId());
        writableNativeMap.putString("created", String.valueOf(token.getCreated().getTime()));
        writableNativeMap.putString("type", mapTokenType(token.getType()));
        writableNativeMap.putBoolean("livemode", token.getLivemode());
        writableNativeMap.putMap("bankAccount", mapFromBankAccount(token.getBankAccount()));
        writableNativeMap.putMap("card", mapFromCard(token.getCard()));
        return writableNativeMap;
    }

    /* JADX WARNING: type inference failed for: r7v35, types: [java.util.List] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.facebook.react.bridge.WritableMap mapFromPaymentMethod(com.stripe.android.model.PaymentMethod r17) {
        /*
            r0 = r17
            java.lang.String r1 = "paymentMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            com.facebook.react.bridge.WritableNativeMap r1 = new com.facebook.react.bridge.WritableNativeMap
            r1.<init>()
            com.facebook.react.bridge.WritableMap r1 = (com.facebook.react.bridge.WritableMap) r1
            com.facebook.react.bridge.WritableNativeMap r2 = new com.facebook.react.bridge.WritableNativeMap
            r2.<init>()
            com.facebook.react.bridge.WritableMap r2 = (com.facebook.react.bridge.WritableMap) r2
            com.facebook.react.bridge.WritableNativeMap r3 = new com.facebook.react.bridge.WritableNativeMap
            r3.<init>()
            com.facebook.react.bridge.WritableMap r3 = (com.facebook.react.bridge.WritableMap) r3
            com.facebook.react.bridge.WritableNativeMap r4 = new com.facebook.react.bridge.WritableNativeMap
            r4.<init>()
            com.facebook.react.bridge.WritableMap r4 = (com.facebook.react.bridge.WritableMap) r4
            com.facebook.react.bridge.WritableNativeMap r5 = new com.facebook.react.bridge.WritableNativeMap
            r5.<init>()
            com.facebook.react.bridge.WritableMap r5 = (com.facebook.react.bridge.WritableMap) r5
            com.facebook.react.bridge.WritableNativeMap r6 = new com.facebook.react.bridge.WritableNativeMap
            r6.<init>()
            com.facebook.react.bridge.WritableMap r6 = (com.facebook.react.bridge.WritableMap) r6
            com.facebook.react.bridge.WritableNativeMap r7 = new com.facebook.react.bridge.WritableNativeMap
            r7.<init>()
            com.facebook.react.bridge.WritableMap r7 = (com.facebook.react.bridge.WritableMap) r7
            com.facebook.react.bridge.WritableNativeMap r8 = new com.facebook.react.bridge.WritableNativeMap
            r8.<init>()
            com.facebook.react.bridge.WritableMap r8 = (com.facebook.react.bridge.WritableMap) r8
            com.facebook.react.bridge.WritableNativeMap r9 = new com.facebook.react.bridge.WritableNativeMap
            r9.<init>()
            com.facebook.react.bridge.WritableMap r9 = (com.facebook.react.bridge.WritableMap) r9
            com.facebook.react.bridge.WritableNativeMap r10 = new com.facebook.react.bridge.WritableNativeMap
            r10.<init>()
            com.facebook.react.bridge.WritableMap r10 = (com.facebook.react.bridge.WritableMap) r10
            com.stripe.android.model.PaymentMethod$Card r11 = r0.card
            if (r11 != 0) goto L_0x0053
            r11 = 0
            goto L_0x0055
        L_0x0053:
            com.stripe.android.model.CardBrand r11 = r11.brand
        L_0x0055:
            java.lang.String r11 = mapCardBrand(r11)
            java.lang.String r13 = "brand"
            r2.putString(r13, r11)
            com.stripe.android.model.PaymentMethod$Card r11 = r0.card
            if (r11 != 0) goto L_0x0064
            r11 = 0
            goto L_0x0066
        L_0x0064:
            java.lang.String r11 = r11.country
        L_0x0066:
            java.lang.String r13 = "country"
            r2.putString(r13, r11)
            com.stripe.android.model.PaymentMethod$Card r11 = r0.card
            if (r11 != 0) goto L_0x0070
            goto L_0x0080
        L_0x0070:
            java.lang.Integer r11 = r11.expiryYear
            if (r11 != 0) goto L_0x0075
            goto L_0x0080
        L_0x0075:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.String r14 = "expYear"
            r2.putInt(r14, r11)
        L_0x0080:
            com.stripe.android.model.PaymentMethod$Card r11 = r0.card
            if (r11 != 0) goto L_0x0085
            goto L_0x0095
        L_0x0085:
            java.lang.Integer r11 = r11.expiryMonth
            if (r11 != 0) goto L_0x008a
            goto L_0x0095
        L_0x008a:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.String r14 = "expMonth"
            r2.putInt(r14, r11)
        L_0x0095:
            com.stripe.android.model.PaymentMethod$Card r11 = r0.card
            if (r11 != 0) goto L_0x009b
            r11 = 0
            goto L_0x009d
        L_0x009b:
            java.lang.String r11 = r11.funding
        L_0x009d:
            java.lang.String r14 = "funding"
            r2.putString(r14, r11)
            com.stripe.android.model.PaymentMethod$Card r11 = r0.card
            if (r11 != 0) goto L_0x00a8
            r11 = 0
            goto L_0x00aa
        L_0x00a8:
            java.lang.String r11 = r11.last4
        L_0x00aa:
            java.lang.String r14 = "last4"
            r2.putString(r14, r11)
            com.stripe.android.model.PaymentMethod$SepaDebit r11 = r0.sepaDebit
            if (r11 != 0) goto L_0x00b5
            r11 = 0
            goto L_0x00b7
        L_0x00b5:
            java.lang.String r11 = r11.bankCode
        L_0x00b7:
            java.lang.String r15 = "bankCode"
            r3.putString(r15, r11)
            com.stripe.android.model.PaymentMethod$SepaDebit r11 = r0.sepaDebit
            if (r11 != 0) goto L_0x00c2
            r11 = 0
            goto L_0x00c4
        L_0x00c2:
            java.lang.String r11 = r11.country
        L_0x00c4:
            r3.putString(r13, r11)
            com.stripe.android.model.PaymentMethod$SepaDebit r11 = r0.sepaDebit
            if (r11 != 0) goto L_0x00cd
            r11 = 0
            goto L_0x00cf
        L_0x00cd:
            java.lang.String r11 = r11.fingerprint
        L_0x00cf:
            java.lang.String r15 = "fingerprint"
            r3.putString(r15, r11)
            com.stripe.android.model.PaymentMethod$SepaDebit r11 = r0.sepaDebit
            if (r11 != 0) goto L_0x00da
            r11 = 0
            goto L_0x00dc
        L_0x00da:
            java.lang.String r11 = r11.branchCode
        L_0x00dc:
            r3.putString(r14, r11)
            com.stripe.android.model.PaymentMethod$BacsDebit r11 = r0.bacsDebit
            if (r11 != 0) goto L_0x00e5
            r11 = 0
            goto L_0x00e7
        L_0x00e5:
            java.lang.String r11 = r11.fingerprint
        L_0x00e7:
            r4.putString(r15, r11)
            com.stripe.android.model.PaymentMethod$BacsDebit r11 = r0.bacsDebit
            if (r11 != 0) goto L_0x00f0
            r11 = 0
            goto L_0x00f2
        L_0x00f0:
            java.lang.String r11 = r11.last4
        L_0x00f2:
            r4.putString(r14, r11)
            com.stripe.android.model.PaymentMethod$BacsDebit r11 = r0.bacsDebit
            if (r11 != 0) goto L_0x00fb
            r11 = 0
            goto L_0x00fd
        L_0x00fb:
            java.lang.String r11 = r11.sortCode
        L_0x00fd:
            java.lang.String r12 = "sortCode"
            r4.putString(r12, r11)
            com.stripe.android.model.PaymentMethod$BacsDebit r11 = r0.bacsDebit
            if (r11 != 0) goto L_0x0108
            r11 = 0
            goto L_0x010a
        L_0x0108:
            java.lang.String r11 = r11.sortCode
        L_0x010a:
            java.lang.String r12 = "bsbNumber"
            r5.putString(r12, r11)
            com.stripe.android.model.PaymentMethod$BacsDebit r11 = r0.bacsDebit
            if (r11 != 0) goto L_0x0115
            r11 = 0
            goto L_0x0117
        L_0x0115:
            java.lang.String r11 = r11.fingerprint
        L_0x0117:
            r5.putString(r15, r11)
            com.stripe.android.model.PaymentMethod$BacsDebit r11 = r0.bacsDebit
            if (r11 != 0) goto L_0x0120
            r11 = 0
            goto L_0x0122
        L_0x0120:
            java.lang.String r11 = r11.last4
        L_0x0122:
            r5.putString(r14, r11)
            com.stripe.android.model.PaymentMethod$Sofort r11 = r0.sofort
            if (r11 != 0) goto L_0x012b
            r11 = 0
            goto L_0x012d
        L_0x012b:
            java.lang.String r11 = r11.country
        L_0x012d:
            r6.putString(r13, r11)
            com.stripe.android.model.PaymentMethod$Ideal r11 = r0.ideal
            if (r11 != 0) goto L_0x0136
            r11 = 0
            goto L_0x0138
        L_0x0136:
            java.lang.String r11 = r11.bank
        L_0x0138:
            java.lang.String r12 = "bankName"
            r7.putString(r12, r11)
            com.stripe.android.model.PaymentMethod$Ideal r11 = r0.ideal
            if (r11 != 0) goto L_0x0143
            r11 = 0
            goto L_0x0145
        L_0x0143:
            java.lang.String r11 = r11.bankIdentifierCode
        L_0x0145:
            java.lang.String r13 = "bankIdentifierCode"
            r7.putString(r13, r11)
            com.stripe.android.model.PaymentMethod$Fpx r11 = r0.fpx
            if (r11 != 0) goto L_0x0150
            r11 = 0
            goto L_0x0152
        L_0x0150:
            java.lang.String r11 = r11.accountHolderType
        L_0x0152:
            java.lang.String r13 = "accountHolderType"
            r8.putString(r13, r11)
            com.stripe.android.model.PaymentMethod$Fpx r11 = r0.fpx
            if (r11 != 0) goto L_0x015f
            r16 = r7
            r11 = 0
            goto L_0x0163
        L_0x015f:
            java.lang.String r11 = r11.bank
            r16 = r7
        L_0x0163:
            java.lang.String r7 = "bank"
            r8.putString(r7, r11)
            com.stripe.android.model.PaymentMethod$Upi r7 = r0.upi
            if (r7 != 0) goto L_0x016e
            r7 = 0
            goto L_0x0170
        L_0x016e:
            java.lang.String r7 = r7.vpa
        L_0x0170:
            java.lang.String r11 = "vpa"
            r9.putString(r11, r7)
            com.stripe.android.model.PaymentMethod$USBankAccount r7 = r0.usBankAccount
            if (r7 != 0) goto L_0x017b
            r7 = 0
            goto L_0x017d
        L_0x017b:
            java.lang.String r7 = r7.routingNumber
        L_0x017d:
            java.lang.String r11 = "routingNumber"
            r10.putString(r11, r7)
            com.stripe.android.model.PaymentMethod$USBankAccount r7 = r0.usBankAccount
            if (r7 != 0) goto L_0x0188
            r7 = 0
            goto L_0x018a
        L_0x0188:
            com.stripe.android.model.PaymentMethod$USBankAccount$USBankAccountType r7 = r7.accountType
        L_0x018a:
            java.lang.String r7 = mapFromUSBankAccountType(r7)
            java.lang.String r11 = "accountType"
            r10.putString(r11, r7)
            com.stripe.android.model.PaymentMethod$USBankAccount r7 = r0.usBankAccount
            if (r7 != 0) goto L_0x0199
            r7 = 0
            goto L_0x019b
        L_0x0199:
            com.stripe.android.model.PaymentMethod$USBankAccount$USBankAccountHolderType r7 = r7.accountHolderType
        L_0x019b:
            java.lang.String r7 = mapFromUSBankAccountHolderType(r7)
            r10.putString(r13, r7)
            com.stripe.android.model.PaymentMethod$USBankAccount r7 = r0.usBankAccount
            if (r7 != 0) goto L_0x01a8
            r7 = 0
            goto L_0x01aa
        L_0x01a8:
            java.lang.String r7 = r7.last4
        L_0x01aa:
            r10.putString(r14, r7)
            com.stripe.android.model.PaymentMethod$USBankAccount r7 = r0.usBankAccount
            if (r7 != 0) goto L_0x01b3
            r7 = 0
            goto L_0x01b5
        L_0x01b3:
            java.lang.String r7 = r7.bankName
        L_0x01b5:
            r10.putString(r12, r7)
            com.stripe.android.model.PaymentMethod$USBankAccount r7 = r0.usBankAccount
            if (r7 != 0) goto L_0x01be
            r7 = 0
            goto L_0x01c0
        L_0x01be:
            java.lang.String r7 = r7.linkedAccount
        L_0x01c0:
            java.lang.String r11 = "linkedAccount"
            r10.putString(r11, r7)
            com.stripe.android.model.PaymentMethod$USBankAccount r7 = r0.usBankAccount
            if (r7 != 0) goto L_0x01cb
            r7 = 0
            goto L_0x01cd
        L_0x01cb:
            java.lang.String r7 = r7.fingerprint
        L_0x01cd:
            r10.putString(r15, r7)
            com.stripe.android.model.PaymentMethod$USBankAccount r7 = r0.usBankAccount
            if (r7 != 0) goto L_0x01d6
        L_0x01d4:
            r7 = 0
            goto L_0x01df
        L_0x01d6:
            com.stripe.android.model.PaymentMethod$USBankAccount$USBankNetworks r7 = r7.networks
            if (r7 != 0) goto L_0x01db
            goto L_0x01d4
        L_0x01db:
            java.lang.String r7 = r7.getPreferred()
        L_0x01df:
            java.lang.String r11 = "preferredNetworks"
            r10.putString(r11, r7)
            com.stripe.android.model.PaymentMethod$USBankAccount r7 = r0.usBankAccount
            if (r7 != 0) goto L_0x01ea
        L_0x01e8:
            r7 = 0
            goto L_0x01f3
        L_0x01ea:
            com.stripe.android.model.PaymentMethod$USBankAccount$USBankNetworks r7 = r7.networks
            if (r7 != 0) goto L_0x01ef
            goto L_0x01e8
        L_0x01ef:
            java.util.List r7 = r7.getSupported()
        L_0x01f3:
            boolean r11 = r7 instanceof com.facebook.react.bridge.ReadableArray
            if (r11 == 0) goto L_0x01fb
            r12 = r7
            com.facebook.react.bridge.ReadableArray r12 = (com.facebook.react.bridge.ReadableArray) r12
            goto L_0x01fc
        L_0x01fb:
            r12 = 0
        L_0x01fc:
            java.lang.String r7 = "supportedNetworks"
            r10.putArray(r7, r12)
            java.lang.String r7 = r0.id
            java.lang.String r11 = "id"
            r1.putString(r11, r7)
            com.stripe.android.model.PaymentMethod$Type r7 = r0.type
            java.lang.String r7 = mapPaymentMethodType(r7)
            java.lang.String r11 = "type"
            r1.putString(r11, r7)
            boolean r7 = r0.liveMode
            java.lang.String r11 = "livemode"
            r1.putBoolean(r11, r7)
            java.lang.String r7 = r0.customerId
            java.lang.String r11 = "customerId"
            r1.putString(r11, r7)
            com.stripe.android.model.PaymentMethod$BillingDetails r0 = r0.billingDetails
            com.facebook.react.bridge.WritableMap r0 = mapFromBillingDetails(r0)
            com.facebook.react.bridge.ReadableMap r0 = (com.facebook.react.bridge.ReadableMap) r0
            java.lang.String r7 = "billingDetails"
            r1.putMap(r7, r0)
            com.facebook.react.bridge.ReadableMap r2 = (com.facebook.react.bridge.ReadableMap) r2
            java.lang.String r0 = "Card"
            r1.putMap(r0, r2)
            com.facebook.react.bridge.ReadableMap r3 = (com.facebook.react.bridge.ReadableMap) r3
            java.lang.String r0 = "SepaDebit"
            r1.putMap(r0, r3)
            com.facebook.react.bridge.ReadableMap r4 = (com.facebook.react.bridge.ReadableMap) r4
            java.lang.String r0 = "BacsDebit"
            r1.putMap(r0, r4)
            com.facebook.react.bridge.ReadableMap r5 = (com.facebook.react.bridge.ReadableMap) r5
            java.lang.String r0 = "AuBecsDebit"
            r1.putMap(r0, r5)
            com.facebook.react.bridge.ReadableMap r6 = (com.facebook.react.bridge.ReadableMap) r6
            java.lang.String r0 = "Sofort"
            r1.putMap(r0, r6)
            r7 = r16
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            java.lang.String r0 = "Ideal"
            r1.putMap(r0, r7)
            com.facebook.react.bridge.ReadableMap r8 = (com.facebook.react.bridge.ReadableMap) r8
            java.lang.String r0 = "Fpx"
            r1.putMap(r0, r8)
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            java.lang.String r0 = "Upi"
            r1.putMap(r0, r9)
            com.facebook.react.bridge.ReadableMap r10 = (com.facebook.react.bridge.ReadableMap) r10
            java.lang.String r0 = "USBankAccount"
            r1.putMap(r0, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativestripesdk.MappersKt.mapFromPaymentMethod(com.stripe.android.model.PaymentMethod):com.facebook.react.bridge.WritableMap");
    }

    public static final WritableMap mapFromPaymentIntentResult(PaymentIntent paymentIntent) {
        PaymentMethod paymentMethod;
        Intrinsics.checkNotNullParameter(paymentIntent, "paymentIntent");
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString(MessageExtension.FIELD_ID, paymentIntent.getId());
        writableNativeMap.putString("clientSecret", paymentIntent.getClientSecret());
        writableNativeMap.putBoolean("livemode", paymentIntent.isLiveMode());
        writableNativeMap.putString("paymentMethodId", paymentIntent.getPaymentMethodId());
        writableNativeMap.putString("receiptEmail", paymentIntent.getReceiptEmail());
        writableNativeMap.putString(FirebaseAnalytics.Param.CURRENCY, paymentIntent.getCurrency());
        writableNativeMap.putString(NotificationCompat.CATEGORY_STATUS, mapIntentStatus(paymentIntent.getStatus()));
        writableNativeMap.putString("description", paymentIntent.getDescription());
        writableNativeMap.putString("receiptEmail", paymentIntent.getReceiptEmail());
        writableNativeMap.putString("created", convertToUnixTimestamp(paymentIntent.getCreated()));
        writableNativeMap.putString("captureMethod", mapCaptureMethod(paymentIntent.getCaptureMethod()));
        writableNativeMap.putString("confirmationMethod", mapConfirmationMethod(paymentIntent.getConfirmationMethod()));
        writableNativeMap.putMap("nextAction", mapNextAction(paymentIntent.getNextActionType(), paymentIntent.getNextActionData()));
        writableNativeMap.putNull("lastPaymentError");
        writableNativeMap.putNull(FirebaseAnalytics.Param.SHIPPING);
        writableNativeMap.putNull(BaseSheetViewModel.SAVE_AMOUNT);
        writableNativeMap.putNull("canceledAt");
        PaymentIntent.Error lastPaymentError = paymentIntent.getLastPaymentError();
        if (lastPaymentError != null) {
            WritableMap writableNativeMap2 = new WritableNativeMap();
            PaymentIntent.Error lastPaymentError2 = paymentIntent.getLastPaymentError();
            if (!(lastPaymentError2 == null || (paymentMethod = lastPaymentError2.getPaymentMethod()) == null)) {
                writableNativeMap2.putMap("paymentMethod", mapFromPaymentMethod(paymentMethod));
            }
            writableNativeMap2.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, lastPaymentError.getCode());
            writableNativeMap2.putString(GraphQLConstants.Keys.MESSAGE, lastPaymentError.getMessage());
            writableNativeMap2.putString("type", mapFromPaymentIntentLastErrorType(lastPaymentError.getType()));
            writableNativeMap.putMap("lastPaymentError", writableNativeMap2);
        }
        PaymentIntent.Shipping shipping = paymentIntent.getShipping();
        if (shipping != null) {
            writableNativeMap.putMap(FirebaseAnalytics.Param.SHIPPING, mapIntentShipping(shipping));
        }
        Long amount = paymentIntent.getAmount();
        if (amount != null) {
            writableNativeMap.putDouble(BaseSheetViewModel.SAVE_AMOUNT, (double) amount.longValue());
        }
        writableNativeMap.putString("canceledAt", convertToUnixTimestamp(paymentIntent.getCanceledAt()));
        return writableNativeMap;
    }

    public static final String mapFromMicrodepositType(MicrodepositType microdepositType) {
        Intrinsics.checkNotNullParameter(microdepositType, "type");
        int i = WhenMappings.$EnumSwitchMapping$10[microdepositType.ordinal()];
        if (i != 1) {
            return i != 2 ? "unknown" : "descriptorCode";
        }
        return "amounts";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.stripe.android.model.StripeIntent$NextActionData$RedirectToUrl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.stripe.android.model.StripeIntent$NextActionData$VerifyWithMicrodeposits} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.stripe.android.model.StripeIntent$NextActionData$DisplayOxxoDetails} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: com.stripe.android.model.StripeIntent$NextActionData$WeChatPayRedirect} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.facebook.react.bridge.WritableNativeMap mapNextAction(com.stripe.android.model.StripeIntent.NextActionType r4, com.stripe.android.model.StripeIntent.NextActionData r5) {
        /*
            com.facebook.react.bridge.WritableNativeMap r0 = new com.facebook.react.bridge.WritableNativeMap
            r0.<init>()
            if (r4 != 0) goto L_0x0009
            r4 = -1
            goto L_0x0011
        L_0x0009:
            int[] r1 = com.reactnativestripesdk.MappersKt.WhenMappings.$EnumSwitchMapping$11
            int r4 = r4.ordinal()
            r4 = r1[r4]
        L_0x0011:
            java.lang.String r1 = "redirectUrl"
            java.lang.String r2 = "type"
            r3 = 0
            switch(r4) {
                case -1: goto L_0x00b0;
                case 0: goto L_0x0019;
                case 1: goto L_0x0095;
                case 2: goto L_0x0064;
                case 3: goto L_0x0039;
                case 4: goto L_0x001c;
                case 5: goto L_0x001b;
                case 6: goto L_0x00b0;
                case 7: goto L_0x00b0;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x00b1
        L_0x001b:
            return r3
        L_0x001c:
            boolean r4 = r5 instanceof com.stripe.android.model.StripeIntent.NextActionData.WeChatPayRedirect
            if (r4 == 0) goto L_0x0023
            r3 = r5
            com.stripe.android.model.StripeIntent$NextActionData$WeChatPayRedirect r3 = (com.stripe.android.model.StripeIntent.NextActionData.WeChatPayRedirect) r3
        L_0x0023:
            if (r3 != 0) goto L_0x0027
            goto L_0x00b1
        L_0x0027:
            java.lang.String r4 = "weChatRedirect"
            r0.putString(r2, r4)
            com.stripe.android.model.WeChat r4 = r3.getWeChat()
            java.lang.String r4 = r4.getQrCodeUrl()
            r0.putString(r1, r4)
            goto L_0x00b1
        L_0x0039:
            boolean r4 = r5 instanceof com.stripe.android.model.StripeIntent.NextActionData.DisplayOxxoDetails
            if (r4 == 0) goto L_0x0040
            r3 = r5
            com.stripe.android.model.StripeIntent$NextActionData$DisplayOxxoDetails r3 = (com.stripe.android.model.StripeIntent.NextActionData.DisplayOxxoDetails) r3
        L_0x0040:
            if (r3 != 0) goto L_0x0043
            goto L_0x00b1
        L_0x0043:
            java.lang.String r4 = "oxxoVoucher"
            r0.putString(r2, r4)
            int r4 = r3.getExpiresAfter()
            java.lang.String r5 = "expiration"
            r0.putInt(r5, r4)
            java.lang.String r4 = r3.getHostedVoucherUrl()
            java.lang.String r5 = "voucherURL"
            r0.putString(r5, r4)
            java.lang.String r4 = r3.getNumber()
            java.lang.String r5 = "voucherNumber"
            r0.putString(r5, r4)
            goto L_0x00b1
        L_0x0064:
            boolean r4 = r5 instanceof com.stripe.android.model.StripeIntent.NextActionData.VerifyWithMicrodeposits
            if (r4 == 0) goto L_0x006b
            r3 = r5
            com.stripe.android.model.StripeIntent$NextActionData$VerifyWithMicrodeposits r3 = (com.stripe.android.model.StripeIntent.NextActionData.VerifyWithMicrodeposits) r3
        L_0x006b:
            if (r3 != 0) goto L_0x006e
            goto L_0x00b1
        L_0x006e:
            java.lang.String r4 = "verifyWithMicrodeposits"
            r0.putString(r2, r4)
            long r4 = r3.getArrivalDate()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "arrivalDate"
            r0.putString(r5, r4)
            java.lang.String r4 = r3.getHostedVerificationUrl()
            r0.putString(r1, r4)
            com.stripe.android.model.MicrodepositType r4 = r3.getMicrodepositType()
            java.lang.String r4 = mapFromMicrodepositType(r4)
            java.lang.String r5 = "microdepositType"
            r0.putString(r5, r4)
            goto L_0x00b1
        L_0x0095:
            boolean r4 = r5 instanceof com.stripe.android.model.StripeIntent.NextActionData.RedirectToUrl
            if (r4 == 0) goto L_0x009c
            r3 = r5
            com.stripe.android.model.StripeIntent$NextActionData$RedirectToUrl r3 = (com.stripe.android.model.StripeIntent.NextActionData.RedirectToUrl) r3
        L_0x009c:
            if (r3 != 0) goto L_0x009f
            goto L_0x00b1
        L_0x009f:
            java.lang.String r4 = "urlRedirect"
            r0.putString(r2, r4)
            android.net.Uri r4 = r3.getUrl()
            java.lang.String r4 = r4.toString()
            r0.putString(r1, r4)
            goto L_0x00b1
        L_0x00b0:
            return r3
        L_0x00b1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativestripesdk.MappersKt.mapNextAction(com.stripe.android.model.StripeIntent$NextActionType, com.stripe.android.model.StripeIntent$NextActionData):com.facebook.react.bridge.WritableNativeMap");
    }

    public static final String mapFromPaymentIntentLastErrorType(PaymentIntent.Error.Type type) {
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$12[type.ordinal()]) {
            case 1:
                return "api_connection_error";
            case 2:
                return "authentication_error";
            case 3:
                return "api_error";
            case 4:
                return "card_error";
            case 5:
                return "idempotency_error";
            case 6:
                return "invalid_request_error";
            case 7:
                return "rate_limit_error";
            default:
                return null;
        }
    }

    public static final String mapFromSetupIntentLastErrorType(SetupIntent.Error.Type type) {
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$13[type.ordinal()]) {
            case 1:
                return "api_connection_error";
            case 2:
                return "authentication_error";
            case 3:
                return "api_error";
            case 4:
                return "card_error";
            case 5:
                return "idempotency_error";
            case 6:
                return "invalid_request_error";
            case 7:
                return "rate_limit_error";
            default:
                return null;
        }
    }

    public static /* synthetic */ String getValOr$default(ReadableMap readableMap, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return getValOr(readableMap, str, str2);
    }

    public static final String getValOr(ReadableMap readableMap, String str, String str2) {
        Intrinsics.checkNotNullParameter(readableMap, "map");
        Intrinsics.checkNotNullParameter(str, "key");
        return readableMap.hasKey(str) ? readableMap.getString(str) : str2;
    }

    public static final Address mapToAddress(ReadableMap readableMap, Address address) {
        if (readableMap == null) {
            return null;
        }
        Address.Builder state = new Address.Builder().setPostalCode(getValOr$default(readableMap, "postalCode", (String) null, 4, (Object) null)).setCity(getValOr$default(readableMap, PostalAddressParser.LOCALITY_KEY, (String) null, 4, (Object) null)).setCountry(getValOr$default(readableMap, "country", (String) null, 4, (Object) null)).setLine1(getValOr$default(readableMap, PostalAddressParser.LINE_1_KEY, (String) null, 4, (Object) null)).setLine2(getValOr$default(readableMap, PostalAddressParser.LINE_2_KEY, (String) null, 4, (Object) null)).setState(getValOr$default(readableMap, PostalAddressParser.REGION_KEY, (String) null, 4, (Object) null));
        if (address != null) {
            String postalCode = address.getPostalCode();
            if (postalCode != null) {
                state.setPostalCode(postalCode);
            }
            String country = address.getCountry();
            if (country != null) {
                state.setCountry(country);
            }
        }
        return state.build();
    }

    public static final PaymentMethod.BillingDetails mapToBillingDetails(ReadableMap readableMap, Address address) {
        Address address2 = null;
        if (readableMap == null && address == null) {
            return null;
        }
        PaymentMethod.BillingDetails.Builder builder = new PaymentMethod.BillingDetails.Builder();
        if (readableMap != null) {
            Address mapToAddress = mapToAddress(getMapOrNull(readableMap, PaymentMethod.BillingDetails.PARAM_ADDRESS), address);
            builder.setName(getValOr$default(readableMap, "name", (String) null, 4, (Object) null)).setPhone(getValOr$default(readableMap, "phone", (String) null, 4, (Object) null)).setEmail(getValOr$default(readableMap, "email", (String) null, 4, (Object) null));
            address2 = mapToAddress;
        }
        if (address2 == null) {
            address2 = new Address.Builder().build();
        }
        builder.setAddress(address2);
        return builder.build();
    }

    public static final ConfirmPaymentIntentParams.Shipping mapToShippingDetails(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        Address mapToAddress = mapToAddress(getMapOrNull(readableMap, PaymentMethod.BillingDetails.PARAM_ADDRESS), (Address) null);
        if (mapToAddress == null) {
            mapToAddress = new Address.Builder().build();
        }
        Address address = mapToAddress;
        String valOr$default = getValOr$default(readableMap, "name", (String) null, 4, (Object) null);
        if (valOr$default == null) {
            valOr$default = "";
        }
        return new ConfirmPaymentIntentParams.Shipping(address, valOr$default, (String) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
    }

    private static final String getStringOrNull(ReadableMap readableMap, String str) {
        if (Intrinsics.areEqual((Object) readableMap == null ? null : Boolean.valueOf(readableMap.hasKey(str)), (Object) true)) {
            return readableMap.getString(str);
        }
        return null;
    }

    public static final Integer getIntOrNull(ReadableMap readableMap, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (Intrinsics.areEqual((Object) readableMap == null ? null : Boolean.valueOf(readableMap.hasKey(str)), (Object) true)) {
            return Integer.valueOf(readableMap.getInt(str));
        }
        return null;
    }

    public static final ReadableMap getMapOrNull(ReadableMap readableMap, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (Intrinsics.areEqual((Object) readableMap == null ? null : Boolean.valueOf(readableMap.hasKey(str)), (Object) true)) {
            return readableMap.getMap(str);
        }
        return null;
    }

    public static final boolean getBooleanOrFalse(ReadableMap readableMap, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (Intrinsics.areEqual((Object) readableMap == null ? null : Boolean.valueOf(readableMap.hasKey(str)), (Object) true)) {
            return readableMap.getBoolean(str);
        }
        return false;
    }

    private static final String convertToUnixTimestamp(long j) {
        return String.valueOf(j * ((long) 1000));
    }

    public static final PaymentAuthConfig.Stripe3ds2UiCustomization mapToUICustomization(ReadableMap readableMap) {
        PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder builder;
        ReadableMap readableMap2 = readableMap;
        Intrinsics.checkNotNullParameter(readableMap2, "params");
        ReadableMap mapOrNull = getMapOrNull(readableMap2, AnnotatedPrivateKey.LABEL);
        ReadableMap map = readableMap2.getMap("navigationBar");
        ReadableMap mapOrNull2 = getMapOrNull(readableMap2, "textField");
        ReadableMap mapOrNull3 = getMapOrNull(readableMap2, "submitButton");
        ReadableMap mapOrNull4 = getMapOrNull(readableMap2, "cancelButton");
        ReadableMap mapOrNull5 = getMapOrNull(readableMap2, "nextButton");
        ReadableMap mapOrNull6 = getMapOrNull(readableMap2, "continueButton");
        ReadableMap mapOrNull7 = getMapOrNull(readableMap2, "resendButton");
        PaymentAuthConfig.Stripe3ds2LabelCustomization.Builder builder2 = new PaymentAuthConfig.Stripe3ds2LabelCustomization.Builder();
        PaymentAuthConfig.Stripe3ds2ToolbarCustomization.Builder builder3 = new PaymentAuthConfig.Stripe3ds2ToolbarCustomization.Builder();
        PaymentAuthConfig.Stripe3ds2TextBoxCustomization.Builder builder4 = new PaymentAuthConfig.Stripe3ds2TextBoxCustomization.Builder();
        PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder builder5 = new PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder();
        PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder builder6 = new PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder();
        PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder builder7 = new PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder();
        PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder builder8 = new PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder();
        PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder builder9 = new PaymentAuthConfig.Stripe3ds2ButtonCustomization.Builder();
        String stringOrNull = getStringOrNull(mapOrNull, "headingTextColor");
        if (stringOrNull != null) {
            builder2.setHeadingTextColor(stringOrNull);
        }
        ReadableMap readableMap3 = mapOrNull7;
        String stringOrNull2 = getStringOrNull(mapOrNull, TextColorProp.name);
        if (stringOrNull2 != null) {
            builder2.setTextColor(stringOrNull2);
        }
        Integer intOrNull = getIntOrNull(mapOrNull, "headingFontSize");
        if (intOrNull != null) {
            builder2.setHeadingTextFontSize(intOrNull.intValue());
        }
        Integer intOrNull2 = getIntOrNull(mapOrNull, "textFontSize");
        if (intOrNull2 != null) {
            builder2.setTextFontSize(intOrNull2.intValue());
        }
        String stringOrNull3 = getStringOrNull(map, "headerText");
        if (stringOrNull3 != null) {
            builder3.setHeaderText(stringOrNull3);
        }
        String stringOrNull4 = getStringOrNull(map, "buttonText");
        if (stringOrNull4 != null) {
            builder3.setButtonText(stringOrNull4);
        }
        String stringOrNull5 = getStringOrNull(map, TextColorProp.name);
        if (stringOrNull5 != null) {
            builder3.setTextColor(stringOrNull5);
        }
        String stringOrNull6 = getStringOrNull(map, "statusBarColor");
        if (stringOrNull6 != null) {
            builder3.setStatusBarColor(stringOrNull6);
        }
        PaymentAuthConfig.Stripe3ds2LabelCustomization.Builder builder10 = builder2;
        String stringOrNull7 = getStringOrNull(map, ViewProps.BACKGROUND_COLOR);
        if (stringOrNull7 != null) {
            builder3.setBackgroundColor(stringOrNull7);
        }
        Integer intOrNull3 = getIntOrNull(map, "textFontSize");
        if (intOrNull3 != null) {
            builder3.setTextFontSize(intOrNull3.intValue());
        }
        String stringOrNull8 = getStringOrNull(mapOrNull2, ViewProps.BORDER_COLOR);
        if (stringOrNull8 != null) {
            builder4.setBorderColor(stringOrNull8);
        }
        String stringOrNull9 = getStringOrNull(mapOrNull2, TextColorProp.name);
        if (stringOrNull9 != null) {
            builder4.setTextColor(stringOrNull9);
        }
        Integer intOrNull4 = getIntOrNull(mapOrNull2, ViewProps.BORDER_WIDTH);
        if (intOrNull4 != null) {
            builder4.setBorderWidth(intOrNull4.intValue());
        }
        Integer intOrNull5 = getIntOrNull(mapOrNull2, ViewProps.BORDER_RADIUS);
        if (intOrNull5 != null) {
            builder4.setCornerRadius(intOrNull5.intValue());
        }
        Integer intOrNull6 = getIntOrNull(mapOrNull2, "textFontSize");
        if (intOrNull6 != null) {
            builder4.setTextFontSize(intOrNull6.intValue());
        }
        String stringOrNull10 = getStringOrNull(mapOrNull3, ViewProps.BACKGROUND_COLOR);
        if (stringOrNull10 != null) {
            builder5.setBackgroundColor(stringOrNull10);
        }
        Integer intOrNull7 = getIntOrNull(mapOrNull3, ViewProps.BORDER_RADIUS);
        if (intOrNull7 != null) {
            builder5.setCornerRadius(intOrNull7.intValue());
        }
        String stringOrNull11 = getStringOrNull(mapOrNull3, TextColorProp.name);
        if (stringOrNull11 != null) {
            builder5.setTextColor(stringOrNull11);
        }
        Integer intOrNull8 = getIntOrNull(mapOrNull3, "textFontSize");
        if (intOrNull8 != null) {
            builder5.setTextFontSize(intOrNull8.intValue());
        }
        String stringOrNull12 = getStringOrNull(mapOrNull4, ViewProps.BACKGROUND_COLOR);
        if (stringOrNull12 != null) {
            builder6.setBackgroundColor(stringOrNull12);
        }
        Integer intOrNull9 = getIntOrNull(mapOrNull4, ViewProps.BORDER_RADIUS);
        if (intOrNull9 != null) {
            builder6.setCornerRadius(intOrNull9.intValue());
        }
        String stringOrNull13 = getStringOrNull(mapOrNull4, TextColorProp.name);
        if (stringOrNull13 != null) {
            builder6.setTextColor(stringOrNull13);
        }
        Integer intOrNull10 = getIntOrNull(mapOrNull4, "textFontSize");
        if (intOrNull10 != null) {
            builder6.setTextFontSize(intOrNull10.intValue());
        }
        String stringOrNull14 = getStringOrNull(mapOrNull6, ViewProps.BACKGROUND_COLOR);
        if (stringOrNull14 != null) {
            builder8.setBackgroundColor(stringOrNull14);
        }
        Integer intOrNull11 = getIntOrNull(mapOrNull6, ViewProps.BORDER_RADIUS);
        if (intOrNull11 != null) {
            builder8.setCornerRadius(intOrNull11.intValue());
        }
        String stringOrNull15 = getStringOrNull(mapOrNull6, TextColorProp.name);
        if (stringOrNull15 != null) {
            builder8.setTextColor(stringOrNull15);
        }
        Integer intOrNull12 = getIntOrNull(mapOrNull6, "textFontSize");
        if (intOrNull12 != null) {
            builder8.setTextFontSize(intOrNull12.intValue());
        }
        String stringOrNull16 = getStringOrNull(mapOrNull5, ViewProps.BACKGROUND_COLOR);
        if (stringOrNull16 != null) {
            builder7.setBackgroundColor(stringOrNull16);
        }
        Integer intOrNull13 = getIntOrNull(mapOrNull5, ViewProps.BORDER_RADIUS);
        if (intOrNull13 != null) {
            builder7.setCornerRadius(intOrNull13.intValue());
        }
        String stringOrNull17 = getStringOrNull(mapOrNull5, TextColorProp.name);
        if (stringOrNull17 != null) {
            builder7.setTextColor(stringOrNull17);
        }
        Integer intOrNull14 = getIntOrNull(mapOrNull5, "textFontSize");
        if (intOrNull14 != null) {
            builder7.setTextFontSize(intOrNull14.intValue());
        }
        ReadableMap readableMap4 = readableMap3;
        String stringOrNull18 = getStringOrNull(readableMap4, ViewProps.BACKGROUND_COLOR);
        if (stringOrNull18 == null) {
            builder = builder9;
        } else {
            builder = builder9;
            builder.setBackgroundColor(stringOrNull18);
        }
        Integer intOrNull15 = getIntOrNull(readableMap4, ViewProps.BORDER_RADIUS);
        if (intOrNull15 != null) {
            builder.setCornerRadius(intOrNull15.intValue());
        }
        String stringOrNull19 = getStringOrNull(readableMap4, TextColorProp.name);
        if (stringOrNull19 != null) {
            builder.setTextColor(stringOrNull19);
        }
        Integer intOrNull16 = getIntOrNull(readableMap4, "textFontSize");
        if (intOrNull16 != null) {
            builder.setTextFontSize(intOrNull16.intValue());
        }
        PaymentAuthConfig.Stripe3ds2UiCustomization.Builder buttonCustomization = new PaymentAuthConfig.Stripe3ds2UiCustomization.Builder().setLabelCustomization(builder10.build()).setToolbarCustomization(builder3.build()).setButtonCustomization(builder5.build(), PaymentAuthConfig.Stripe3ds2UiCustomization.ButtonType.SUBMIT).setButtonCustomization(builder8.build(), PaymentAuthConfig.Stripe3ds2UiCustomization.ButtonType.CONTINUE).setButtonCustomization(builder7.build(), PaymentAuthConfig.Stripe3ds2UiCustomization.ButtonType.SELECT).setButtonCustomization(builder6.build(), PaymentAuthConfig.Stripe3ds2UiCustomization.ButtonType.CANCEL).setButtonCustomization(builder.build(), PaymentAuthConfig.Stripe3ds2UiCustomization.ButtonType.RESEND);
        String stringOrNull20 = getStringOrNull(readableMap, "accentColor");
        if (stringOrNull20 != null) {
            buttonCustomization.setAccentColor(stringOrNull20);
        }
        return buttonCustomization.build();
    }

    public static final WritableMap mapFromSetupIntentResult(SetupIntent setupIntent) {
        PaymentMethod.Type type;
        PaymentMethod paymentMethod;
        Intrinsics.checkNotNullParameter(setupIntent, "setupIntent");
        WritableMap writableNativeMap = new WritableNativeMap();
        WritableArray createArray = Arguments.createArray();
        Intrinsics.checkNotNullExpressionValue(createArray, "createArray()");
        writableNativeMap.putString(MessageExtension.FIELD_ID, setupIntent.getId());
        writableNativeMap.putString(NotificationCompat.CATEGORY_STATUS, mapIntentStatus(setupIntent.getStatus()));
        writableNativeMap.putString("description", setupIntent.getDescription());
        writableNativeMap.putBoolean("livemode", setupIntent.isLiveMode());
        writableNativeMap.putString("clientSecret", setupIntent.getClientSecret());
        writableNativeMap.putString("paymentMethodId", setupIntent.getPaymentMethodId());
        writableNativeMap.putString("usage", mapSetupIntentUsage(setupIntent.getUsage()));
        writableNativeMap.putString("created", convertToUnixTimestamp(setupIntent.getCreated()));
        writableNativeMap.putMap("nextAction", mapNextAction(setupIntent.getNextActionType(), setupIntent.getNextActionData()));
        SetupIntent.Error lastSetupError = setupIntent.getLastSetupError();
        if (lastSetupError != null) {
            WritableMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, lastSetupError.getCode());
            writableNativeMap2.putString(GraphQLConstants.Keys.MESSAGE, lastSetupError.getMessage());
            writableNativeMap2.putString("type", mapFromSetupIntentLastErrorType(lastSetupError.getType()));
            SetupIntent.Error lastSetupError2 = setupIntent.getLastSetupError();
            if (!(lastSetupError2 == null || (paymentMethod = lastSetupError2.getPaymentMethod()) == null)) {
                writableNativeMap2.putMap("paymentMethod", mapFromPaymentMethod(paymentMethod));
            }
            writableNativeMap.putMap("lastSetupError", writableNativeMap2);
        }
        for (String str : setupIntent.getPaymentMethodTypes()) {
            PaymentMethod.Type[] values = PaymentMethod.Type.values();
            int i = 0;
            int length = values.length;
            while (true) {
                if (i >= length) {
                    type = null;
                    break;
                }
                type = values[i];
                i++;
                if (Intrinsics.areEqual((Object) str, (Object) type.code)) {
                    break;
                }
            }
            if (type != null) {
                createArray.pushString(mapPaymentMethodType(type));
            }
        }
        writableNativeMap.putArray("paymentMethodTypes", createArray);
        return writableNativeMap;
    }

    public static final String mapSetupIntentUsage(StripeIntent.Usage usage) {
        int i = usage == null ? -1 : WhenMappings.$EnumSwitchMapping$14[usage.ordinal()];
        if (i == 1) {
            return "OffSession";
        }
        if (i != 2) {
            return i != 3 ? BinData.UNKNOWN : "OneTime";
        }
        return "OnSession";
    }

    public static final ConfirmPaymentIntentParams.SetupFutureUsage mapToPaymentIntentFutureUsage(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "OffSession")) {
            return ConfirmPaymentIntentParams.SetupFutureUsage.OffSession;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "OnSession")) {
            return ConfirmPaymentIntentParams.SetupFutureUsage.OnSession;
        }
        return null;
    }

    public static final Bundle toBundleObject(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap == null) {
            return bundle;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        Intrinsics.checkNotNullExpressionValue(keySetIterator, "readableMap.keySetIterator()");
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (WhenMappings.$EnumSwitchMapping$15[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    bundle.putString(nextKey, (String) null);
                    break;
                case 2:
                    bundle.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 3:
                    try {
                        bundle.putInt(nextKey, readableMap.getInt(nextKey));
                        break;
                    } catch (Exception unused) {
                        bundle.putDouble(nextKey, readableMap.getDouble(nextKey));
                        break;
                    }
                case 4:
                    bundle.putString(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    bundle.putBundle(nextKey, toBundleObject(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    Log.e("toBundleException", "Cannot put arrays of objects into bundles. Failed on: " + nextKey + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    break;
                default:
                    Log.e("toBundleException", "Could not convert object with key: " + nextKey + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    break;
            }
        }
        return bundle;
    }
}

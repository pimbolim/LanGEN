package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.stripe.android.model.MandateDataParams;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.PaymentMethodOptionsParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b3\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 c2\u00020\u0001:\u0003cdeB©\u0001\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0018J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00105J\t\u0010P\u001a\u00020\fHÂ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u000fHÆ\u0003J²\u0001\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010SJ\t\u0010T\u001a\u00020UHÖ\u0001J\u0013\u0010V\u001a\u00020\f2\b\u0010W\u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010X\u001a\u00020UHÖ\u0001J\u0006\u0010Y\u001a\u00020\fJ\b\u0010Z\u001a\u00020\fH\u0016J\u0014\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0 H\u0016J\t\u0010\\\u001a\u00020\u0005HÖ\u0001J\u0010\u0010]\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020\fH\u0016J\u0019\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020UHÖ\u0001R\u0014\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!\u0018\u00010 8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010&R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0 8BX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010#R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010&R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010&R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "paymentMethodId", "", "sourceParams", "Lcom/stripe/android/model/SourceParams;", "sourceId", "clientSecret", "returnUrl", "savePaymentMethod", "", "useStripeSdk", "paymentMethodOptions", "Lcom/stripe/android/model/PaymentMethodOptionsParams;", "mandateId", "mandateData", "Lcom/stripe/android/model/MandateDataParams;", "setupFutureUsage", "Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;", "shipping", "Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;", "receiptEmail", "(Lcom/stripe/android/model/PaymentMethodCreateParams;Ljava/lang/String;Lcom/stripe/android/model/SourceParams;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLcom/stripe/android/model/PaymentMethodOptionsParams;Ljava/lang/String;Lcom/stripe/android/model/MandateDataParams;Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;Ljava/lang/String;)V", "getClientSecret", "()Ljava/lang/String;", "getMandateData", "()Lcom/stripe/android/model/MandateDataParams;", "setMandateData", "(Lcom/stripe/android/model/MandateDataParams;)V", "mandateDataParams", "", "", "getMandateDataParams", "()Ljava/util/Map;", "getMandateId", "setMandateId", "(Ljava/lang/String;)V", "getPaymentMethodCreateParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "getPaymentMethodId", "getPaymentMethodOptions", "()Lcom/stripe/android/model/PaymentMethodOptionsParams;", "setPaymentMethodOptions", "(Lcom/stripe/android/model/PaymentMethodOptionsParams;)V", "paymentMethodParamMap", "getPaymentMethodParamMap", "getReceiptEmail", "setReceiptEmail", "getReturnUrl", "setReturnUrl", "getSavePaymentMethod", "()Ljava/lang/Boolean;", "setSavePaymentMethod", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSetupFutureUsage", "()Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;", "setSetupFutureUsage", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;)V", "getShipping", "()Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;", "setShipping", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;)V", "getSourceId", "getSourceParams", "()Lcom/stripe/android/model/SourceParams;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/stripe/android/model/PaymentMethodCreateParams;Ljava/lang/String;Lcom/stripe/android/model/SourceParams;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLcom/stripe/android/model/PaymentMethodOptionsParams;Ljava/lang/String;Lcom/stripe/android/model/MandateDataParams;Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;Ljava/lang/String;)Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "describeContents", "", "equals", "other", "hashCode", "shouldSavePaymentMethod", "shouldUseStripeSdk", "toParamMap", "toString", "withShouldUseStripeSdk", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "SetupFutureUsage", "Shipping", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfirmPaymentIntentParams.kt */
public final class ConfirmPaymentIntentParams implements ConfirmStripeIntentParams {
    public static final int $stable = 8;
    public static final Parcelable.Creator<ConfirmPaymentIntentParams> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAM_PAYMENT_METHOD_OPTIONS = "payment_method_options";
    private static final String PARAM_RECEIPT_EMAIL = "receipt_email";
    private static final String PARAM_SAVE_PAYMENT_METHOD = "save_payment_method";
    private static final String PARAM_SETUP_FUTURE_USAGE = "setup_future_usage";
    private static final String PARAM_SHIPPING = "shipping";
    public static final String PARAM_SOURCE_DATA = "source_data";
    private static final String PARAM_SOURCE_ID = "source";
    private final String clientSecret;
    private MandateDataParams mandateData;
    private String mandateId;
    private final PaymentMethodCreateParams paymentMethodCreateParams;
    private final String paymentMethodId;
    private PaymentMethodOptionsParams paymentMethodOptions;
    private String receiptEmail;
    private String returnUrl;
    private Boolean savePaymentMethod;
    private SetupFutureUsage setupFutureUsage;
    private Shipping shipping;
    private final String sourceId;
    private final SourceParams sourceParams;
    private final boolean useStripeSdk;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfirmPaymentIntentParams.kt */
    public static final class Creator implements Parcelable.Creator<ConfirmPaymentIntentParams> {
        public final ConfirmPaymentIntentParams createFromParcel(Parcel parcel) {
            Boolean bool;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            Shipping shipping = null;
            PaymentMethodCreateParams createFromParcel = parcel.readInt() == 0 ? null : PaymentMethodCreateParams.CREATOR.createFromParcel(parcel2);
            String readString = parcel.readString();
            SourceParams createFromParcel2 = parcel.readInt() == 0 ? null : SourceParams.CREATOR.createFromParcel(parcel2);
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            boolean z = true;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                z = false;
            }
            PaymentMethodOptionsParams paymentMethodOptionsParams = (PaymentMethodOptionsParams) parcel2.readParcelable(ConfirmPaymentIntentParams.class.getClassLoader());
            String readString5 = parcel.readString();
            MandateDataParams createFromParcel3 = parcel.readInt() == 0 ? null : MandateDataParams.CREATOR.createFromParcel(parcel2);
            SetupFutureUsage valueOf = parcel.readInt() == 0 ? null : SetupFutureUsage.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                shipping = Shipping.CREATOR.createFromParcel(parcel2);
            }
            return new ConfirmPaymentIntentParams(createFromParcel, readString, createFromParcel2, readString2, readString3, readString4, bool, z, paymentMethodOptionsParams, readString5, createFromParcel3, valueOf, shipping, parcel.readString());
        }

        public final ConfirmPaymentIntentParams[] newArray(int i) {
            return new ConfirmPaymentIntentParams[i];
        }
    }

    private final boolean component8() {
        return this.useStripeSdk;
    }

    public static /* synthetic */ ConfirmPaymentIntentParams copy$default(ConfirmPaymentIntentParams confirmPaymentIntentParams, PaymentMethodCreateParams paymentMethodCreateParams2, String str, SourceParams sourceParams2, String str2, String str3, String str4, Boolean bool, boolean z, PaymentMethodOptionsParams paymentMethodOptionsParams, String str5, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage2, Shipping shipping2, String str6, int i, Object obj) {
        ConfirmPaymentIntentParams confirmPaymentIntentParams2 = confirmPaymentIntentParams;
        int i2 = i;
        return confirmPaymentIntentParams.copy((i2 & 1) != 0 ? confirmPaymentIntentParams2.paymentMethodCreateParams : paymentMethodCreateParams2, (i2 & 2) != 0 ? confirmPaymentIntentParams2.paymentMethodId : str, (i2 & 4) != 0 ? confirmPaymentIntentParams2.sourceParams : sourceParams2, (i2 & 8) != 0 ? confirmPaymentIntentParams2.sourceId : str2, (i2 & 16) != 0 ? confirmPaymentIntentParams.getClientSecret() : str3, (i2 & 32) != 0 ? confirmPaymentIntentParams.getReturnUrl() : str4, (i2 & 64) != 0 ? confirmPaymentIntentParams2.savePaymentMethod : bool, (i2 & 128) != 0 ? confirmPaymentIntentParams2.useStripeSdk : z, (i2 & 256) != 0 ? confirmPaymentIntentParams2.paymentMethodOptions : paymentMethodOptionsParams, (i2 & 512) != 0 ? confirmPaymentIntentParams2.mandateId : str5, (i2 & 1024) != 0 ? confirmPaymentIntentParams2.mandateData : mandateDataParams, (i2 & 2048) != 0 ? confirmPaymentIntentParams2.setupFutureUsage : setupFutureUsage2, (i2 & 4096) != 0 ? confirmPaymentIntentParams2.shipping : shipping2, (i2 & 8192) != 0 ? confirmPaymentIntentParams2.receiptEmail : str6);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams create(String str) {
        return Companion.create(str);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams create(String str, Shipping shipping2) {
        return Companion.create(str, shipping2);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams create(String str, Shipping shipping2, SetupFutureUsage setupFutureUsage2) {
        return Companion.create(str, shipping2, setupFutureUsage2);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams create(String str, PaymentMethod.Type type) {
        return Companion.create(str, type);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createAlipay(String str) {
        return Companion.createAlipay(str);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams2, String str) {
        return Companion.createWithPaymentMethodCreateParams(paymentMethodCreateParams2, str);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams2, String str, Boolean bool) {
        return Companion.createWithPaymentMethodCreateParams(paymentMethodCreateParams2, str, bool);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams2, String str, Boolean bool, String str2) {
        return Companion.createWithPaymentMethodCreateParams(paymentMethodCreateParams2, str, bool, str2);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams2, String str, Boolean bool, String str2, MandateDataParams mandateDataParams) {
        return Companion.createWithPaymentMethodCreateParams(paymentMethodCreateParams2, str, bool, str2, mandateDataParams);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams2, String str, Boolean bool, String str2, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage2) {
        return Companion.createWithPaymentMethodCreateParams(paymentMethodCreateParams2, str, bool, str2, mandateDataParams, setupFutureUsage2);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams2, String str, Boolean bool, String str2, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage2, Shipping shipping2) {
        return Companion.createWithPaymentMethodCreateParams(paymentMethodCreateParams2, str, bool, str2, mandateDataParams, setupFutureUsage2, shipping2);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams2, String str, Boolean bool, String str2, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage2, Shipping shipping2, PaymentMethodOptionsParams paymentMethodOptionsParams) {
        return Companion.createWithPaymentMethodCreateParams(paymentMethodCreateParams2, str, bool, str2, mandateDataParams, setupFutureUsage2, shipping2, paymentMethodOptionsParams);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2) {
        return Companion.createWithPaymentMethodId(str, str2);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool) {
        return Companion.createWithPaymentMethodId(str, str2, bool);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams) {
        return Companion.createWithPaymentMethodId(str, str2, bool, paymentMethodOptionsParams);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams, String str3) {
        return Companion.createWithPaymentMethodId(str, str2, bool, paymentMethodOptionsParams, str3);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams, String str3, MandateDataParams mandateDataParams) {
        return Companion.createWithPaymentMethodId(str, str2, bool, paymentMethodOptionsParams, str3, mandateDataParams);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams, String str3, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage2) {
        return Companion.createWithPaymentMethodId(str, str2, bool, paymentMethodOptionsParams, str3, mandateDataParams, setupFutureUsage2);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams, String str3, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage2, Shipping shipping2) {
        return Companion.createWithPaymentMethodId(str, str2, bool, paymentMethodOptionsParams, str3, mandateDataParams, setupFutureUsage2, shipping2);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithSourceId(String str, String str2, String str3) {
        return Companion.createWithSourceId(str, str2, str3);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithSourceId(String str, String str2, String str3, Boolean bool) {
        return Companion.createWithSourceId(str, str2, str3, bool);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithSourceId(String str, String str2, String str3, Boolean bool, Shipping shipping2) {
        return Companion.createWithSourceId(str, str2, str3, bool, shipping2);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithSourceParams(SourceParams sourceParams2, String str, String str2) {
        return Companion.createWithSourceParams(sourceParams2, str, str2);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithSourceParams(SourceParams sourceParams2, String str, String str2, Boolean bool) {
        return Companion.createWithSourceParams(sourceParams2, str, str2, bool);
    }

    @JvmStatic
    public static final ConfirmPaymentIntentParams createWithSourceParams(SourceParams sourceParams2, String str, String str2, Boolean bool, Shipping shipping2) {
        return Companion.createWithSourceParams(sourceParams2, str, str2, bool, shipping2);
    }

    public final PaymentMethodCreateParams component1() {
        return this.paymentMethodCreateParams;
    }

    public final String component10() {
        return this.mandateId;
    }

    public final MandateDataParams component11() {
        return this.mandateData;
    }

    public final SetupFutureUsage component12() {
        return this.setupFutureUsage;
    }

    public final Shipping component13() {
        return this.shipping;
    }

    public final String component14() {
        return this.receiptEmail;
    }

    public final String component2() {
        return this.paymentMethodId;
    }

    public final SourceParams component3() {
        return this.sourceParams;
    }

    public final String component4() {
        return this.sourceId;
    }

    public final String component5() {
        return getClientSecret();
    }

    public final String component6() {
        return getReturnUrl();
    }

    public final Boolean component7() {
        return this.savePaymentMethod;
    }

    public final PaymentMethodOptionsParams component9() {
        return this.paymentMethodOptions;
    }

    public final ConfirmPaymentIntentParams copy(PaymentMethodCreateParams paymentMethodCreateParams2, String str, SourceParams sourceParams2, String str2, String str3, String str4, Boolean bool, boolean z, PaymentMethodOptionsParams paymentMethodOptionsParams, String str5, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage2, Shipping shipping2, String str6) {
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "clientSecret");
        return new ConfirmPaymentIntentParams(paymentMethodCreateParams2, str, sourceParams2, str2, str7, str4, bool, z, paymentMethodOptionsParams, str5, mandateDataParams, setupFutureUsage2, shipping2, str6);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfirmPaymentIntentParams)) {
            return false;
        }
        ConfirmPaymentIntentParams confirmPaymentIntentParams = (ConfirmPaymentIntentParams) obj;
        return Intrinsics.areEqual((Object) this.paymentMethodCreateParams, (Object) confirmPaymentIntentParams.paymentMethodCreateParams) && Intrinsics.areEqual((Object) this.paymentMethodId, (Object) confirmPaymentIntentParams.paymentMethodId) && Intrinsics.areEqual((Object) this.sourceParams, (Object) confirmPaymentIntentParams.sourceParams) && Intrinsics.areEqual((Object) this.sourceId, (Object) confirmPaymentIntentParams.sourceId) && Intrinsics.areEqual((Object) getClientSecret(), (Object) confirmPaymentIntentParams.getClientSecret()) && Intrinsics.areEqual((Object) getReturnUrl(), (Object) confirmPaymentIntentParams.getReturnUrl()) && Intrinsics.areEqual((Object) this.savePaymentMethod, (Object) confirmPaymentIntentParams.savePaymentMethod) && this.useStripeSdk == confirmPaymentIntentParams.useStripeSdk && Intrinsics.areEqual((Object) this.paymentMethodOptions, (Object) confirmPaymentIntentParams.paymentMethodOptions) && Intrinsics.areEqual((Object) this.mandateId, (Object) confirmPaymentIntentParams.mandateId) && Intrinsics.areEqual((Object) this.mandateData, (Object) confirmPaymentIntentParams.mandateData) && this.setupFutureUsage == confirmPaymentIntentParams.setupFutureUsage && Intrinsics.areEqual((Object) this.shipping, (Object) confirmPaymentIntentParams.shipping) && Intrinsics.areEqual((Object) this.receiptEmail, (Object) confirmPaymentIntentParams.receiptEmail);
    }

    public int hashCode() {
        PaymentMethodCreateParams paymentMethodCreateParams2 = this.paymentMethodCreateParams;
        int i = 0;
        int hashCode = (paymentMethodCreateParams2 == null ? 0 : paymentMethodCreateParams2.hashCode()) * 31;
        String str = this.paymentMethodId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        SourceParams sourceParams2 = this.sourceParams;
        int hashCode3 = (hashCode2 + (sourceParams2 == null ? 0 : sourceParams2.hashCode())) * 31;
        String str2 = this.sourceId;
        int hashCode4 = (((((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + getClientSecret().hashCode()) * 31) + (getReturnUrl() == null ? 0 : getReturnUrl().hashCode())) * 31;
        Boolean bool = this.savePaymentMethod;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        boolean z = this.useStripeSdk;
        if (z) {
            z = true;
        }
        int i2 = (hashCode5 + (z ? 1 : 0)) * 31;
        PaymentMethodOptionsParams paymentMethodOptionsParams = this.paymentMethodOptions;
        int hashCode6 = (i2 + (paymentMethodOptionsParams == null ? 0 : paymentMethodOptionsParams.hashCode())) * 31;
        String str3 = this.mandateId;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MandateDataParams mandateDataParams = this.mandateData;
        int hashCode8 = (hashCode7 + (mandateDataParams == null ? 0 : mandateDataParams.hashCode())) * 31;
        SetupFutureUsage setupFutureUsage2 = this.setupFutureUsage;
        int hashCode9 = (hashCode8 + (setupFutureUsage2 == null ? 0 : setupFutureUsage2.hashCode())) * 31;
        Shipping shipping2 = this.shipping;
        int hashCode10 = (hashCode9 + (shipping2 == null ? 0 : shipping2.hashCode())) * 31;
        String str4 = this.receiptEmail;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        return "ConfirmPaymentIntentParams(paymentMethodCreateParams=" + this.paymentMethodCreateParams + ", paymentMethodId=" + this.paymentMethodId + ", sourceParams=" + this.sourceParams + ", sourceId=" + this.sourceId + ", clientSecret=" + getClientSecret() + ", returnUrl=" + getReturnUrl() + ", savePaymentMethod=" + this.savePaymentMethod + ", useStripeSdk=" + this.useStripeSdk + ", paymentMethodOptions=" + this.paymentMethodOptions + ", mandateId=" + this.mandateId + ", mandateData=" + this.mandateData + ", setupFutureUsage=" + this.setupFutureUsage + ", shipping=" + this.shipping + ", receiptEmail=" + this.receiptEmail + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        PaymentMethodCreateParams paymentMethodCreateParams2 = this.paymentMethodCreateParams;
        if (paymentMethodCreateParams2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            paymentMethodCreateParams2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.paymentMethodId);
        SourceParams sourceParams2 = this.sourceParams;
        if (sourceParams2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sourceParams2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.sourceId);
        parcel.writeString(this.clientSecret);
        parcel.writeString(this.returnUrl);
        Boolean bool = this.savePaymentMethod;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeInt(this.useStripeSdk ? 1 : 0);
        parcel.writeParcelable(this.paymentMethodOptions, i);
        parcel.writeString(this.mandateId);
        MandateDataParams mandateDataParams = this.mandateData;
        if (mandateDataParams == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            mandateDataParams.writeToParcel(parcel, i);
        }
        SetupFutureUsage setupFutureUsage2 = this.setupFutureUsage;
        if (setupFutureUsage2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(setupFutureUsage2.name());
        }
        Shipping shipping2 = this.shipping;
        if (shipping2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            shipping2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.receiptEmail);
    }

    public ConfirmPaymentIntentParams(PaymentMethodCreateParams paymentMethodCreateParams2, String str, SourceParams sourceParams2, String str2, String str3, String str4, Boolean bool, boolean z, PaymentMethodOptionsParams paymentMethodOptionsParams, String str5, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage2, Shipping shipping2, String str6) {
        Intrinsics.checkNotNullParameter(str3, "clientSecret");
        this.paymentMethodCreateParams = paymentMethodCreateParams2;
        this.paymentMethodId = str;
        this.sourceParams = sourceParams2;
        this.sourceId = str2;
        this.clientSecret = str3;
        this.returnUrl = str4;
        this.savePaymentMethod = bool;
        this.useStripeSdk = z;
        this.paymentMethodOptions = paymentMethodOptionsParams;
        this.mandateId = str5;
        this.mandateData = mandateDataParams;
        this.setupFutureUsage = setupFutureUsage2;
        this.shipping = shipping2;
        this.receiptEmail = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ConfirmPaymentIntentParams(com.stripe.android.model.PaymentMethodCreateParams r19, java.lang.String r20, com.stripe.android.model.SourceParams r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.Boolean r25, boolean r26, com.stripe.android.model.PaymentMethodOptionsParams r27, java.lang.String r28, com.stripe.android.model.MandateDataParams r29, com.stripe.android.model.ConfirmPaymentIntentParams.SetupFutureUsage r30, com.stripe.android.model.ConfirmPaymentIntentParams.Shipping r31, java.lang.String r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r19
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0013
        L_0x0011:
            r5 = r20
        L_0x0013:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0019
            r6 = r2
            goto L_0x001b
        L_0x0019:
            r6 = r21
        L_0x001b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r22
        L_0x0023:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0029
            r9 = r2
            goto L_0x002b
        L_0x0029:
            r9 = r24
        L_0x002b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0031
            r10 = r2
            goto L_0x0033
        L_0x0031:
            r10 = r25
        L_0x0033:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003a
            r1 = 0
            r11 = 0
            goto L_0x003c
        L_0x003a:
            r11 = r26
        L_0x003c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0042
            r12 = r2
            goto L_0x0044
        L_0x0042:
            r12 = r27
        L_0x0044:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x004a
            r13 = r2
            goto L_0x004c
        L_0x004a:
            r13 = r28
        L_0x004c:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0052
            r14 = r2
            goto L_0x0054
        L_0x0052:
            r14 = r29
        L_0x0054:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x005a
            r15 = r2
            goto L_0x005c
        L_0x005a:
            r15 = r30
        L_0x005c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0063
            r16 = r2
            goto L_0x0065
        L_0x0063:
            r16 = r31
        L_0x0065:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x006c
            r17 = r2
            goto L_0x006e
        L_0x006c:
            r17 = r32
        L_0x006e:
            r3 = r18
            r8 = r23
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.ConfirmPaymentIntentParams.<init>(com.stripe.android.model.PaymentMethodCreateParams, java.lang.String, com.stripe.android.model.SourceParams, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, boolean, com.stripe.android.model.PaymentMethodOptionsParams, java.lang.String, com.stripe.android.model.MandateDataParams, com.stripe.android.model.ConfirmPaymentIntentParams$SetupFutureUsage, com.stripe.android.model.ConfirmPaymentIntentParams$Shipping, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final PaymentMethodCreateParams getPaymentMethodCreateParams() {
        return this.paymentMethodCreateParams;
    }

    public final String getPaymentMethodId() {
        return this.paymentMethodId;
    }

    public final SourceParams getSourceParams() {
        return this.sourceParams;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public String getReturnUrl() {
        return this.returnUrl;
    }

    public void setReturnUrl(String str) {
        this.returnUrl = str;
    }

    public final Boolean getSavePaymentMethod() {
        return this.savePaymentMethod;
    }

    public final void setSavePaymentMethod(Boolean bool) {
        this.savePaymentMethod = bool;
    }

    public final PaymentMethodOptionsParams getPaymentMethodOptions() {
        return this.paymentMethodOptions;
    }

    public final void setPaymentMethodOptions(PaymentMethodOptionsParams paymentMethodOptionsParams) {
        this.paymentMethodOptions = paymentMethodOptionsParams;
    }

    public final String getMandateId() {
        return this.mandateId;
    }

    public final void setMandateId(String str) {
        this.mandateId = str;
    }

    public final MandateDataParams getMandateData() {
        return this.mandateData;
    }

    public final void setMandateData(MandateDataParams mandateDataParams) {
        this.mandateData = mandateDataParams;
    }

    public final SetupFutureUsage getSetupFutureUsage() {
        return this.setupFutureUsage;
    }

    public final void setSetupFutureUsage(SetupFutureUsage setupFutureUsage2) {
        this.setupFutureUsage = setupFutureUsage2;
    }

    public final Shipping getShipping() {
        return this.shipping;
    }

    public final void setShipping(Shipping shipping2) {
        this.shipping = shipping2;
    }

    public final String getReceiptEmail() {
        return this.receiptEmail;
    }

    public final void setReceiptEmail(String str) {
        this.receiptEmail = str;
    }

    public final boolean shouldSavePaymentMethod() {
        return Intrinsics.areEqual((Object) this.savePaymentMethod, (Object) true);
    }

    public boolean shouldUseStripeSdk() {
        return this.useStripeSdk;
    }

    public ConfirmPaymentIntentParams withShouldUseStripeSdk(boolean z) {
        return copy$default(this, (PaymentMethodCreateParams) null, (String) null, (SourceParams) null, (String) null, (String) null, (String) null, (Boolean) null, z, (PaymentMethodOptionsParams) null, (String) null, (MandateDataParams) null, (SetupFutureUsage) null, (Shipping) null, (String) null, 16255, (Object) null);
    }

    public Map<String, Object> toParamMap() {
        Map map;
        Map<K, V> map2;
        Map<K, V> map3;
        Map map4;
        Map<K, V> map5;
        Map mapOf = MapsKt.mapOf(TuplesKt.to("client_secret", getClientSecret()), TuplesKt.to("use_stripe_sdk", Boolean.valueOf(this.useStripeSdk)));
        Boolean bool = this.savePaymentMethod;
        Map map6 = null;
        if (bool == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to(PARAM_SAVE_PAYMENT_METHOD, Boolean.valueOf(bool.booleanValue())));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        Map plus = MapsKt.plus(mapOf, map);
        String str = this.mandateId;
        Map mapOf2 = str == null ? null : MapsKt.mapOf(TuplesKt.to("mandate", str));
        if (mapOf2 == null) {
            mapOf2 = MapsKt.emptyMap();
        }
        Map plus2 = MapsKt.plus(plus, mapOf2);
        Map<String, Object> mandateDataParams = getMandateDataParams();
        if (mandateDataParams == null) {
            map2 = null;
        } else {
            map2 = MapsKt.mapOf(TuplesKt.to("mandate_data", mandateDataParams));
        }
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        Map<K, V> plus3 = MapsKt.plus(plus2, (Map) map2);
        String returnUrl2 = getReturnUrl();
        Map mapOf3 = returnUrl2 == null ? null : MapsKt.mapOf(TuplesKt.to("return_url", returnUrl2));
        if (mapOf3 == null) {
            mapOf3 = MapsKt.emptyMap();
        }
        Map<K, V> plus4 = MapsKt.plus(plus3, (Map<K, V>) mapOf3);
        PaymentMethodOptionsParams paymentMethodOptionsParams = this.paymentMethodOptions;
        if (paymentMethodOptionsParams == null) {
            map3 = null;
        } else {
            map3 = MapsKt.mapOf(TuplesKt.to(PARAM_PAYMENT_METHOD_OPTIONS, paymentMethodOptionsParams.toParamMap()));
        }
        if (map3 == null) {
            map3 = MapsKt.emptyMap();
        }
        Map<K, V> plus5 = MapsKt.plus(plus4, map3);
        SetupFutureUsage setupFutureUsage2 = this.setupFutureUsage;
        if (setupFutureUsage2 == null) {
            map4 = null;
        } else {
            map4 = MapsKt.mapOf(TuplesKt.to("setup_future_usage", setupFutureUsage2.getCode$payments_core_release()));
        }
        if (map4 == null) {
            map4 = MapsKt.emptyMap();
        }
        Map<K, V> plus6 = MapsKt.plus(plus5, (Map<K, V>) map4);
        Shipping shipping2 = this.shipping;
        if (shipping2 == null) {
            map5 = null;
        } else {
            map5 = MapsKt.mapOf(TuplesKt.to("shipping", shipping2.toParamMap()));
        }
        if (map5 == null) {
            map5 = MapsKt.emptyMap();
        }
        Map<String, Object> plus7 = MapsKt.plus(MapsKt.plus(plus6, map5), (Map<K, V>) getPaymentMethodParamMap());
        String str2 = this.receiptEmail;
        if (str2 != null) {
            map6 = MapsKt.mapOf(TuplesKt.to(PARAM_RECEIPT_EMAIL, str2));
        }
        if (map6 == null) {
            map6 = MapsKt.emptyMap();
        }
        return MapsKt.plus(plus7, (Map<String, Object>) map6);
    }

    private final Map<String, Object> getPaymentMethodParamMap() {
        PaymentMethodCreateParams paymentMethodCreateParams2 = this.paymentMethodCreateParams;
        if (paymentMethodCreateParams2 != null) {
            return MapsKt.mapOf(TuplesKt.to("payment_method_data", paymentMethodCreateParams2.toParamMap()));
        }
        String str = this.paymentMethodId;
        if (str != null) {
            return MapsKt.mapOf(TuplesKt.to("payment_method", str));
        }
        SourceParams sourceParams2 = this.sourceParams;
        if (sourceParams2 != null) {
            return MapsKt.mapOf(TuplesKt.to(PARAM_SOURCE_DATA, sourceParams2.toParamMap()));
        }
        String str2 = this.sourceId;
        if (str2 != null) {
            return MapsKt.mapOf(TuplesKt.to("source", str2));
        }
        return MapsKt.emptyMap();
    }

    private final Map<String, Object> getMandateDataParams() {
        PaymentMethod.Type type$payments_core_release;
        MandateDataParams mandateDataParams = this.mandateData;
        Map<String, Object> paramMap = mandateDataParams == null ? null : mandateDataParams.toParamMap();
        if (paramMap != null) {
            return paramMap;
        }
        PaymentMethodCreateParams paymentMethodCreateParams2 = this.paymentMethodCreateParams;
        boolean z = true;
        if (paymentMethodCreateParams2 == null || (type$payments_core_release = paymentMethodCreateParams2.getType$payments_core_release()) == null || !type$payments_core_release.requiresMandate) {
            z = false;
        }
        if (!z || this.mandateId != null) {
            return null;
        }
        return new MandateDataParams(MandateDataParams.Type.Online.Companion.getDEFAULT()).toParamMap();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "OnSession", "OffSession", "Blank", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfirmPaymentIntentParams.kt */
    public enum SetupFutureUsage {
        OnSession("on_session"),
        OffSession("off_session"),
        Blank("");
        
        private final String code;

        private SetupFutureUsage(String str) {
            this.code = str;
        }

        public final String getCode$payments_core_release() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B;\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u0013J\u000e\u0010\u0014\u001a\u00020\u0006HÀ\u0003¢\u0006\u0002\b\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u001bJA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"0%H\u0016J\t\u0010&\u001a\u00020\u0006HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001eHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006-"}, d2 = {"Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "address", "Lcom/stripe/android/model/Address;", "name", "", "carrier", "phone", "trackingNumber", "(Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress$payments_core_release", "()Lcom/stripe/android/model/Address;", "getCarrier$payments_core_release", "()Ljava/lang/String;", "getName$payments_core_release", "getPhone$payments_core_release", "getTrackingNumber$payments_core_release", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfirmPaymentIntentParams.kt */
    public static final class Shipping implements StripeParamsModel, Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Shipping> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_ADDRESS = "address";
        @Deprecated
        private static final String PARAM_CARRIER = "carrier";
        @Deprecated
        private static final String PARAM_NAME = "name";
        @Deprecated
        private static final String PARAM_PHONE = "phone";
        @Deprecated
        private static final String PARAM_TRACKING_NUMBER = "tracking_number";
        private final Address address;
        private final String carrier;
        private final String name;
        private final String phone;
        private final String trackingNumber;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConfirmPaymentIntentParams.kt */
        public static final class Creator implements Parcelable.Creator<Shipping> {
            public final Shipping createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Shipping(Address.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final Shipping[] newArray(int i) {
                return new Shipping[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Shipping(Address address2, String str) {
            this(address2, str, (String) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(address2, "address");
            Intrinsics.checkNotNullParameter(str, "name");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Shipping(Address address2, String str, String str2) {
            this(address2, str, str2, (String) null, (String) null, 24, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(address2, "address");
            Intrinsics.checkNotNullParameter(str, "name");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Shipping(Address address2, String str, String str2, String str3) {
            this(address2, str, str2, str3, (String) null, 16, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(address2, "address");
            Intrinsics.checkNotNullParameter(str, "name");
        }

        public static /* synthetic */ Shipping copy$default(Shipping shipping, Address address2, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                address2 = shipping.address;
            }
            if ((i & 2) != 0) {
                str = shipping.name;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = shipping.carrier;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = shipping.phone;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = shipping.trackingNumber;
            }
            return shipping.copy(address2, str5, str6, str7, str4);
        }

        public final Address component1$payments_core_release() {
            return this.address;
        }

        public final String component2$payments_core_release() {
            return this.name;
        }

        public final String component3$payments_core_release() {
            return this.carrier;
        }

        public final String component4$payments_core_release() {
            return this.phone;
        }

        public final String component5$payments_core_release() {
            return this.trackingNumber;
        }

        public final Shipping copy(Address address2, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(address2, "address");
            Intrinsics.checkNotNullParameter(str, "name");
            return new Shipping(address2, str, str2, str3, str4);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Shipping)) {
                return false;
            }
            Shipping shipping = (Shipping) obj;
            return Intrinsics.areEqual((Object) this.address, (Object) shipping.address) && Intrinsics.areEqual((Object) this.name, (Object) shipping.name) && Intrinsics.areEqual((Object) this.carrier, (Object) shipping.carrier) && Intrinsics.areEqual((Object) this.phone, (Object) shipping.phone) && Intrinsics.areEqual((Object) this.trackingNumber, (Object) shipping.trackingNumber);
        }

        public int hashCode() {
            int hashCode = ((this.address.hashCode() * 31) + this.name.hashCode()) * 31;
            String str = this.carrier;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.phone;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.trackingNumber;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "Shipping(address=" + this.address + ", name=" + this.name + ", carrier=" + this.carrier + ", phone=" + this.phone + ", trackingNumber=" + this.trackingNumber + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.address.writeToParcel(parcel, i);
            parcel.writeString(this.name);
            parcel.writeString(this.carrier);
            parcel.writeString(this.phone);
            parcel.writeString(this.trackingNumber);
        }

        public Shipping(Address address2, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(address2, "address");
            Intrinsics.checkNotNullParameter(str, "name");
            this.address = address2;
            this.name = str;
            this.carrier = str2;
            this.phone = str3;
            this.trackingNumber = str4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Shipping(Address address2, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(address2, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
        }

        public final Address getAddress$payments_core_release() {
            return this.address;
        }

        public final String getName$payments_core_release() {
            return this.name;
        }

        public final String getCarrier$payments_core_release() {
            return this.carrier;
        }

        public final String getPhone$payments_core_release() {
            return this.phone;
        }

        public final String getTrackingNumber$payments_core_release() {
            return this.trackingNumber;
        }

        public Map<String, Object> toParamMap() {
            Map map;
            Pair[] pairArr = {TuplesKt.to("address", this.address.toParamMap()), TuplesKt.to("name", this.name), TuplesKt.to(PARAM_CARRIER, this.carrier), TuplesKt.to("phone", this.phone), TuplesKt.to(PARAM_TRACKING_NUMBER, this.trackingNumber)};
            Map<String, Object> emptyMap = MapsKt.emptyMap();
            for (Pair pair : CollectionsKt.listOf(pairArr)) {
                String str = (String) pair.component1();
                Object component2 = pair.component2();
                if (component2 == null) {
                    map = null;
                } else {
                    map = MapsKt.mapOf(TuplesKt.to(str, component2));
                }
                if (map == null) {
                    map = MapsKt.emptyMap();
                }
                emptyMap = MapsKt.plus(emptyMap, (Map<String, Object>) map);
            }
            return emptyMap;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping$Companion;", "", "()V", "PARAM_ADDRESS", "", "PARAM_CARRIER", "PARAM_NAME", "PARAM_PHONE", "PARAM_TRACKING_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConfirmPaymentIntentParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u001d\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0017Je\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0002\u0010\"Je\u0010#\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010$J=\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010(J=\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010,R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/stripe/android/model/ConfirmPaymentIntentParams$Companion;", "", "()V", "PARAM_PAYMENT_METHOD_OPTIONS", "", "PARAM_RECEIPT_EMAIL", "PARAM_SAVE_PAYMENT_METHOD", "PARAM_SETUP_FUTURE_USAGE", "PARAM_SHIPPING", "PARAM_SOURCE_DATA", "PARAM_SOURCE_ID", "create", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "clientSecret", "shipping", "Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;", "setupFutureUsage", "Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;", "paymentMethodType", "Lcom/stripe/android/model/PaymentMethod$Type;", "createAlipay", "createForDashboard", "paymentMethodId", "createForDashboard$payments_core_release", "createWithPaymentMethodCreateParams", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "savePaymentMethod", "", "mandateId", "mandateData", "Lcom/stripe/android/model/MandateDataParams;", "paymentMethodOptions", "Lcom/stripe/android/model/PaymentMethodOptionsParams;", "(Lcom/stripe/android/model/PaymentMethodCreateParams;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/stripe/android/model/MandateDataParams;Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;Lcom/stripe/android/model/PaymentMethodOptionsParams;)Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "createWithPaymentMethodId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/stripe/android/model/PaymentMethodOptionsParams;Ljava/lang/String;Lcom/stripe/android/model/MandateDataParams;Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;)Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "createWithSourceId", "sourceId", "returnUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;)Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "createWithSourceParams", "sourceParams", "Lcom/stripe/android/model/SourceParams;", "(Lcom/stripe/android/model/SourceParams;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/stripe/android/model/ConfirmPaymentIntentParams$Shipping;)Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfirmPaymentIntentParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams create(String str) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return create$default(this, str, (Shipping) null, (SetupFutureUsage) null, 6, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams create(String str, Shipping shipping) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return create$default(this, str, shipping, (SetupFutureUsage) null, 4, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams, String str) {
            Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return createWithPaymentMethodCreateParams$default(this, paymentMethodCreateParams, str, (Boolean) null, (String) null, (MandateDataParams) null, (SetupFutureUsage) null, (Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams, String str, Boolean bool) {
            Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return createWithPaymentMethodCreateParams$default(this, paymentMethodCreateParams, str, bool, (String) null, (MandateDataParams) null, (SetupFutureUsage) null, (Shipping) null, (PaymentMethodOptionsParams) null, 248, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams, String str, Boolean bool, String str2) {
            Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return createWithPaymentMethodCreateParams$default(this, paymentMethodCreateParams, str, bool, str2, (MandateDataParams) null, (SetupFutureUsage) null, (Shipping) null, (PaymentMethodOptionsParams) null, 240, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams, String str, Boolean bool, String str2, MandateDataParams mandateDataParams) {
            Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return createWithPaymentMethodCreateParams$default(this, paymentMethodCreateParams, str, bool, str2, mandateDataParams, (SetupFutureUsage) null, (Shipping) null, (PaymentMethodOptionsParams) null, CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams, String str, Boolean bool, String str2, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage) {
            Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return createWithPaymentMethodCreateParams$default(this, paymentMethodCreateParams, str, bool, str2, mandateDataParams, setupFutureUsage, (Shipping) null, (PaymentMethodOptionsParams) null, 192, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams, String str, Boolean bool, String str2, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage, Shipping shipping) {
            Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return createWithPaymentMethodCreateParams$default(this, paymentMethodCreateParams, str, bool, str2, mandateDataParams, setupFutureUsage, shipping, (PaymentMethodOptionsParams) null, 128, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            return createWithPaymentMethodId$default(this, str, str2, (Boolean) null, (PaymentMethodOptionsParams) null, (String) null, (MandateDataParams) null, (SetupFutureUsage) null, (Shipping) null, 252, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            return createWithPaymentMethodId$default(this, str, str2, bool, (PaymentMethodOptionsParams) null, (String) null, (MandateDataParams) null, (SetupFutureUsage) null, (Shipping) null, 248, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            return createWithPaymentMethodId$default(this, str, str2, bool, paymentMethodOptionsParams, (String) null, (MandateDataParams) null, (SetupFutureUsage) null, (Shipping) null, 240, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams, String str3) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            return createWithPaymentMethodId$default(this, str, str2, bool, paymentMethodOptionsParams, str3, (MandateDataParams) null, (SetupFutureUsage) null, (Shipping) null, CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams, String str3, MandateDataParams mandateDataParams) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            return createWithPaymentMethodId$default(this, str, str2, bool, paymentMethodOptionsParams, str3, mandateDataParams, (SetupFutureUsage) null, (Shipping) null, 192, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams, String str3, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            return createWithPaymentMethodId$default(this, str, str2, bool, paymentMethodOptionsParams, str3, mandateDataParams, setupFutureUsage, (Shipping) null, 128, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithSourceId(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "sourceId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            Intrinsics.checkNotNullParameter(str3, "returnUrl");
            return createWithSourceId$default(this, str, str2, str3, (Boolean) null, (Shipping) null, 24, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithSourceId(String str, String str2, String str3, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "sourceId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            Intrinsics.checkNotNullParameter(str3, "returnUrl");
            return createWithSourceId$default(this, str, str2, str3, bool, (Shipping) null, 16, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithSourceParams(SourceParams sourceParams, String str, String str2) {
            Intrinsics.checkNotNullParameter(sourceParams, "sourceParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            Intrinsics.checkNotNullParameter(str2, "returnUrl");
            return createWithSourceParams$default(this, sourceParams, str, str2, (Boolean) null, (Shipping) null, 24, (Object) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithSourceParams(SourceParams sourceParams, String str, String str2, Boolean bool) {
            Intrinsics.checkNotNullParameter(sourceParams, "sourceParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            Intrinsics.checkNotNullParameter(str2, "returnUrl");
            return createWithSourceParams$default(this, sourceParams, str, str2, bool, (Shipping) null, 16, (Object) null);
        }

        private Companion() {
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams create(String str, PaymentMethod.Type type) {
            PaymentMethod.Type type2 = type;
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            Intrinsics.checkNotNullParameter(type2, "paymentMethodType");
            return new ConfirmPaymentIntentParams((PaymentMethodCreateParams) null, (String) null, (SourceParams) null, (String) null, str, (String) null, (Boolean) null, false, (PaymentMethodOptionsParams) null, (String) null, type2.requiresMandate ? new MandateDataParams(MandateDataParams.Type.Online.Companion.getDEFAULT()) : null, (SetupFutureUsage) null, (Shipping) null, (String) null, 15343, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ConfirmPaymentIntentParams create$default(Companion companion, String str, Shipping shipping, SetupFutureUsage setupFutureUsage, int i, Object obj) {
            if ((i & 2) != 0) {
                shipping = null;
            }
            if ((i & 4) != 0) {
                setupFutureUsage = null;
            }
            return companion.create(str, shipping, setupFutureUsage);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams create(String str, Shipping shipping, SetupFutureUsage setupFutureUsage) {
            SetupFutureUsage setupFutureUsage2 = setupFutureUsage;
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return new ConfirmPaymentIntentParams((PaymentMethodCreateParams) null, (String) null, (SourceParams) null, (String) null, str, (String) null, (Boolean) null, false, (PaymentMethodOptionsParams) null, (String) null, (MandateDataParams) null, setupFutureUsage2, shipping, (String) null, 10223, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ConfirmPaymentIntentParams createWithPaymentMethodId$default(Companion companion, String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams, String str3, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage, Shipping shipping, int i, Object obj) {
            int i2 = i;
            return companion.createWithPaymentMethodId(str, str2, (i2 & 4) != 0 ? null : bool, (i2 & 8) != 0 ? null : paymentMethodOptionsParams, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : mandateDataParams, (i2 & 64) != 0 ? null : setupFutureUsage, (i2 & 128) != 0 ? null : shipping);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodId(String str, String str2, Boolean bool, PaymentMethodOptionsParams paymentMethodOptionsParams, String str3, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage, Shipping shipping) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            return new ConfirmPaymentIntentParams((PaymentMethodCreateParams) null, str, (SourceParams) null, (String) null, str2, (String) null, bool, false, paymentMethodOptionsParams, str3, mandateDataParams, setupFutureUsage, shipping, (String) null, 8365, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ConfirmPaymentIntentParams createWithPaymentMethodCreateParams$default(Companion companion, PaymentMethodCreateParams paymentMethodCreateParams, String str, Boolean bool, String str2, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage, Shipping shipping, PaymentMethodOptionsParams paymentMethodOptionsParams, int i, Object obj) {
            int i2 = i;
            return companion.createWithPaymentMethodCreateParams(paymentMethodCreateParams, str, (i2 & 4) != 0 ? null : bool, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : mandateDataParams, (i2 & 32) != 0 ? null : setupFutureUsage, (i2 & 64) != 0 ? null : shipping, (i2 & 128) != 0 ? null : paymentMethodOptionsParams);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithPaymentMethodCreateParams(PaymentMethodCreateParams paymentMethodCreateParams, String str, Boolean bool, String str2, MandateDataParams mandateDataParams, SetupFutureUsage setupFutureUsage, Shipping shipping, PaymentMethodOptionsParams paymentMethodOptionsParams) {
            PaymentMethodOptionsParams paymentMethodOptionsParams2 = paymentMethodOptionsParams;
            Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "paymentMethodCreateParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return new ConfirmPaymentIntentParams(paymentMethodCreateParams, (String) null, (SourceParams) null, (String) null, str, (String) null, bool, false, paymentMethodOptionsParams2, str2, mandateDataParams, setupFutureUsage, shipping, (String) null, 8366, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ConfirmPaymentIntentParams createWithSourceId$default(Companion companion, String str, String str2, String str3, Boolean bool, Shipping shipping, int i, Object obj) {
            return companion.createWithSourceId(str, str2, str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : shipping);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithSourceId(String str, String str2, String str3, Boolean bool, Shipping shipping) {
            Intrinsics.checkNotNullParameter(str, "sourceId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            Intrinsics.checkNotNullParameter(str3, "returnUrl");
            return new ConfirmPaymentIntentParams((PaymentMethodCreateParams) null, (String) null, (SourceParams) null, str, str2, str3, bool, false, (PaymentMethodOptionsParams) null, (String) null, (MandateDataParams) null, (SetupFutureUsage) null, shipping, (String) null, 12167, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ConfirmPaymentIntentParams createWithSourceParams$default(Companion companion, SourceParams sourceParams, String str, String str2, Boolean bool, Shipping shipping, int i, Object obj) {
            return companion.createWithSourceParams(sourceParams, str, str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : shipping);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createWithSourceParams(SourceParams sourceParams, String str, String str2, Boolean bool, Shipping shipping) {
            Intrinsics.checkNotNullParameter(sourceParams, "sourceParams");
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            Intrinsics.checkNotNullParameter(str2, "returnUrl");
            return new ConfirmPaymentIntentParams((PaymentMethodCreateParams) null, (String) null, sourceParams, (String) null, str, str2, bool, false, (PaymentMethodOptionsParams) null, (String) null, (MandateDataParams) null, (SetupFutureUsage) null, shipping, (String) null, 12171, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final ConfirmPaymentIntentParams createAlipay(String str) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return new ConfirmPaymentIntentParams(PaymentMethodCreateParams.Companion.createAlipay$default(PaymentMethodCreateParams.Companion, (Map) null, 1, (Object) null), (String) null, (SourceParams) null, (String) null, str, "stripe://return_url", (Boolean) null, false, (PaymentMethodOptionsParams) null, (String) null, (MandateDataParams) null, (SetupFutureUsage) null, (Shipping) null, (String) null, 16334, (DefaultConstructorMarker) null);
        }

        public final ConfirmPaymentIntentParams createForDashboard$payments_core_release(String str, String str2) {
            String str3 = str2;
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            Intrinsics.checkNotNullParameter(str2, "paymentMethodId");
            return new ConfirmPaymentIntentParams((PaymentMethodCreateParams) null, str3, (SourceParams) null, (String) null, str, (String) null, false, true, new PaymentMethodOptionsParams.Card((String) null, (String) null, (SetupFutureUsage) null, true, 7, (DefaultConstructorMarker) null), (String) null, (MandateDataParams) null, (SetupFutureUsage) null, (Shipping) null, (String) null, 15917, (DefaultConstructorMarker) null);
        }
    }
}

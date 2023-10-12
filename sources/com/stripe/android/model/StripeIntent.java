package com.stripe.android.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import com.stripe.android.utils.StripeUrlUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004./01J\b\u0010,\u001a\u00020\u000fH&J\b\u0010-\u001a\u00020\u000fH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u0004\u0018\u00010'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030#X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010%\u0001\u000223¨\u00064"}, d2 = {"Lcom/stripe/android/model/StripeIntent;", "Lcom/stripe/android/core/model/StripeModel;", "clientSecret", "", "getClientSecret", "()Ljava/lang/String;", "created", "", "getCreated", "()J", "description", "getDescription", "id", "getId", "isConfirmed", "", "()Z", "isLiveMode", "lastErrorMessage", "getLastErrorMessage", "nextActionData", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "getNextActionData", "()Lcom/stripe/android/model/StripeIntent$NextActionData;", "nextActionType", "Lcom/stripe/android/model/StripeIntent$NextActionType;", "getNextActionType", "()Lcom/stripe/android/model/StripeIntent$NextActionType;", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "paymentMethodId", "getPaymentMethodId", "paymentMethodTypes", "", "getPaymentMethodTypes", "()Ljava/util/List;", "status", "Lcom/stripe/android/model/StripeIntent$Status;", "getStatus", "()Lcom/stripe/android/model/StripeIntent$Status;", "unactivatedPaymentMethods", "getUnactivatedPaymentMethods", "requiresAction", "requiresConfirmation", "NextActionData", "NextActionType", "Status", "Usage", "Lcom/stripe/android/model/PaymentIntent;", "Lcom/stripe/android/model/SetupIntent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeIntent.kt */
public interface StripeIntent extends StripeModel {
    String getClientSecret();

    long getCreated();

    String getDescription();

    String getId();

    String getLastErrorMessage();

    NextActionData getNextActionData();

    NextActionType getNextActionType();

    PaymentMethod getPaymentMethod();

    String getPaymentMethodId();

    List<String> getPaymentMethodTypes();

    Status getStatus();

    List<String> getUnactivatedPaymentMethods();

    boolean isConfirmed();

    boolean isLiveMode();

    boolean requiresAction();

    boolean requiresConfirmation();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionType;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "toString", "RedirectToUrl", "UseStripeSdk", "DisplayOxxoDetails", "AlipayRedirect", "BlikAuthorize", "WeChatPayRedirect", "VerifyWithMicrodeposits", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeIntent.kt */
    public enum NextActionType {
        RedirectToUrl("redirect_to_url"),
        UseStripeSdk("use_stripe_sdk"),
        DisplayOxxoDetails("oxxo_display_details"),
        AlipayRedirect("alipay_handle_redirect"),
        BlikAuthorize("blik_authorize"),
        WeChatPayRedirect("wechat_pay_redirect_to_android_app"),
        VerifyWithMicrodeposits("verify_with_microdeposits");
        
        public static final Companion Companion = null;
        private final String code;

        private NextActionType(String str) {
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            return this.code;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionType$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/StripeIntent$NextActionType;", "code", "", "fromCode$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final NextActionType fromCode$payments_core_release(String str) {
                NextActionType[] values = NextActionType.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    NextActionType nextActionType = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) nextActionType.getCode(), (Object) str)) {
                        return nextActionType;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/model/StripeIntent$Status;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "toString", "Canceled", "Processing", "RequiresAction", "RequiresConfirmation", "RequiresPaymentMethod", "Succeeded", "RequiresCapture", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeIntent.kt */
    public enum Status {
        Canceled("canceled"),
        Processing(BaseSheetViewModel.SAVE_PROCESSING),
        RequiresAction("requires_action"),
        RequiresConfirmation("requires_confirmation"),
        RequiresPaymentMethod("requires_payment_method"),
        Succeeded("succeeded"),
        RequiresCapture("requires_capture");
        
        public static final Companion Companion = null;
        private final String code;

        private Status(String str) {
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            return this.code;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/StripeIntent$Status$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/StripeIntent$Status;", "code", "", "fromCode$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Status fromCode$payments_core_release(String str) {
                Status[] values = Status.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Status status = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) status.getCode(), (Object) str)) {
                        return status;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/StripeIntent$Usage;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "toString", "OnSession", "OffSession", "OneTime", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeIntent.kt */
    public enum Usage {
        OnSession("on_session"),
        OffSession("off_session"),
        OneTime("one_time");
        
        public static final Companion Companion = null;
        private final String code;

        private Usage(String str) {
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            return this.code;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/StripeIntent$Usage$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/StripeIntent$Usage;", "code", "", "fromCode$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Usage fromCode$payments_core_release(String str) {
                Usage[] values = Usage.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Usage usage = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) usage.getCode(), (Object) str)) {
                        return usage;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData;", "Lcom/stripe/android/core/model/StripeModel;", "()V", "AlipayRedirect", "BlikAuthorize", "DisplayOxxoDetails", "RedirectToUrl", "SdkData", "VerifyWithMicrodeposits", "WeChatPayRedirect", "Lcom/stripe/android/model/StripeIntent$NextActionData$DisplayOxxoDetails;", "Lcom/stripe/android/model/StripeIntent$NextActionData$RedirectToUrl;", "Lcom/stripe/android/model/StripeIntent$NextActionData$AlipayRedirect;", "Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData;", "Lcom/stripe/android/model/StripeIntent$NextActionData$BlikAuthorize;", "Lcom/stripe/android/model/StripeIntent$NextActionData$WeChatPayRedirect;", "Lcom/stripe/android/model/StripeIntent$NextActionData$VerifyWithMicrodeposits;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeIntent.kt */
    public static abstract class NextActionData implements StripeModel {
        public static final int $stable = 0;

        public /* synthetic */ NextActionData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private NextActionData() {
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$DisplayOxxoDetails;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "expiresAfter", "", "number", "", "hostedVoucherUrl", "(ILjava/lang/String;Ljava/lang/String;)V", "getExpiresAfter", "()I", "getHostedVoucherUrl", "()Ljava/lang/String;", "getNumber", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntent.kt */
        public static final class DisplayOxxoDetails extends NextActionData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<DisplayOxxoDetails> CREATOR = new Creator();
            private final int expiresAfter;
            private final String hostedVoucherUrl;
            private final String number;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: StripeIntent.kt */
            public static final class Creator implements Parcelable.Creator<DisplayOxxoDetails> {
                public final DisplayOxxoDetails createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new DisplayOxxoDetails(parcel.readInt(), parcel.readString(), parcel.readString());
                }

                public final DisplayOxxoDetails[] newArray(int i) {
                    return new DisplayOxxoDetails[i];
                }
            }

            public DisplayOxxoDetails() {
                this(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ DisplayOxxoDetails copy$default(DisplayOxxoDetails displayOxxoDetails, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = displayOxxoDetails.expiresAfter;
                }
                if ((i2 & 2) != 0) {
                    str = displayOxxoDetails.number;
                }
                if ((i2 & 4) != 0) {
                    str2 = displayOxxoDetails.hostedVoucherUrl;
                }
                return displayOxxoDetails.copy(i, str, str2);
            }

            public final int component1() {
                return this.expiresAfter;
            }

            public final String component2() {
                return this.number;
            }

            public final String component3() {
                return this.hostedVoucherUrl;
            }

            public final DisplayOxxoDetails copy(int i, String str, String str2) {
                return new DisplayOxxoDetails(i, str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof DisplayOxxoDetails)) {
                    return false;
                }
                DisplayOxxoDetails displayOxxoDetails = (DisplayOxxoDetails) obj;
                return this.expiresAfter == displayOxxoDetails.expiresAfter && Intrinsics.areEqual((Object) this.number, (Object) displayOxxoDetails.number) && Intrinsics.areEqual((Object) this.hostedVoucherUrl, (Object) displayOxxoDetails.hostedVoucherUrl);
            }

            public int hashCode() {
                int i = this.expiresAfter * 31;
                String str = this.number;
                int i2 = 0;
                int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.hostedVoucherUrl;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                return hashCode + i2;
            }

            public String toString() {
                return "DisplayOxxoDetails(expiresAfter=" + this.expiresAfter + ", number=" + this.number + ", hostedVoucherUrl=" + this.hostedVoucherUrl + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.expiresAfter);
                parcel.writeString(this.number);
                parcel.writeString(this.hostedVoucherUrl);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ DisplayOxxoDetails(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
            }

            public final int getExpiresAfter() {
                return this.expiresAfter;
            }

            public final String getNumber() {
                return this.number;
            }

            public final String getHostedVoucherUrl() {
                return this.hostedVoucherUrl;
            }

            public DisplayOxxoDetails(int i, String str, String str2) {
                super((DefaultConstructorMarker) null);
                this.expiresAfter = i;
                this.number = str;
                this.hostedVoucherUrl = str2;
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$RedirectToUrl;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "url", "Landroid/net/Uri;", "returnUrl", "", "(Landroid/net/Uri;Ljava/lang/String;)V", "getReturnUrl", "()Ljava/lang/String;", "getUrl", "()Landroid/net/Uri;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntent.kt */
        public static final class RedirectToUrl extends NextActionData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<RedirectToUrl> CREATOR = new Creator();
            private final String returnUrl;
            private final Uri url;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: StripeIntent.kt */
            public static final class Creator implements Parcelable.Creator<RedirectToUrl> {
                public final RedirectToUrl createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new RedirectToUrl((Uri) parcel.readParcelable(RedirectToUrl.class.getClassLoader()), parcel.readString());
                }

                public final RedirectToUrl[] newArray(int i) {
                    return new RedirectToUrl[i];
                }
            }

            public static /* synthetic */ RedirectToUrl copy$default(RedirectToUrl redirectToUrl, Uri uri, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = redirectToUrl.url;
                }
                if ((i & 2) != 0) {
                    str = redirectToUrl.returnUrl;
                }
                return redirectToUrl.copy(uri, str);
            }

            public final Uri component1() {
                return this.url;
            }

            public final String component2() {
                return this.returnUrl;
            }

            public final RedirectToUrl copy(Uri uri, String str) {
                Intrinsics.checkNotNullParameter(uri, "url");
                return new RedirectToUrl(uri, str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RedirectToUrl)) {
                    return false;
                }
                RedirectToUrl redirectToUrl = (RedirectToUrl) obj;
                return Intrinsics.areEqual((Object) this.url, (Object) redirectToUrl.url) && Intrinsics.areEqual((Object) this.returnUrl, (Object) redirectToUrl.returnUrl);
            }

            public int hashCode() {
                int hashCode = this.url.hashCode() * 31;
                String str = this.returnUrl;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "RedirectToUrl(url=" + this.url + ", returnUrl=" + this.returnUrl + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeParcelable(this.url, i);
                parcel.writeString(this.returnUrl);
            }

            public final Uri getUrl() {
                return this.url;
            }

            public final String getReturnUrl() {
                return this.returnUrl;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public RedirectToUrl(Uri uri, String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(uri, "url");
                this.url = uri;
                this.returnUrl = str;
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B#\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$AlipayRedirect;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "data", "", "webViewUrl", "returnUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "authCompleteUrl", "Landroid/net/Uri;", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V", "getAuthCompleteUrl", "()Ljava/lang/String;", "getData", "getReturnUrl", "getWebViewUrl", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntent.kt */
        public static final class AlipayRedirect extends NextActionData {
            public static final Parcelable.Creator<AlipayRedirect> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final String authCompleteUrl;
            private final String data;
            private final String returnUrl;
            private final Uri webViewUrl;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: StripeIntent.kt */
            public static final class Creator implements Parcelable.Creator<AlipayRedirect> {
                public final AlipayRedirect createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new AlipayRedirect(parcel.readString(), parcel.readString(), (Uri) parcel.readParcelable(AlipayRedirect.class.getClassLoader()), parcel.readString());
                }

                public final AlipayRedirect[] newArray(int i) {
                    return new AlipayRedirect[i];
                }
            }

            public static /* synthetic */ AlipayRedirect copy$default(AlipayRedirect alipayRedirect, String str, String str2, Uri uri, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = alipayRedirect.data;
                }
                if ((i & 2) != 0) {
                    str2 = alipayRedirect.authCompleteUrl;
                }
                if ((i & 4) != 0) {
                    uri = alipayRedirect.webViewUrl;
                }
                if ((i & 8) != 0) {
                    str3 = alipayRedirect.returnUrl;
                }
                return alipayRedirect.copy(str, str2, uri, str3);
            }

            public final String component1() {
                return this.data;
            }

            public final String component2() {
                return this.authCompleteUrl;
            }

            public final Uri component3() {
                return this.webViewUrl;
            }

            public final String component4() {
                return this.returnUrl;
            }

            public final AlipayRedirect copy(String str, String str2, Uri uri, String str3) {
                Intrinsics.checkNotNullParameter(str, "data");
                Intrinsics.checkNotNullParameter(uri, "webViewUrl");
                return new AlipayRedirect(str, str2, uri, str3);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AlipayRedirect)) {
                    return false;
                }
                AlipayRedirect alipayRedirect = (AlipayRedirect) obj;
                return Intrinsics.areEqual((Object) this.data, (Object) alipayRedirect.data) && Intrinsics.areEqual((Object) this.authCompleteUrl, (Object) alipayRedirect.authCompleteUrl) && Intrinsics.areEqual((Object) this.webViewUrl, (Object) alipayRedirect.webViewUrl) && Intrinsics.areEqual((Object) this.returnUrl, (Object) alipayRedirect.returnUrl);
            }

            public int hashCode() {
                int hashCode = this.data.hashCode() * 31;
                String str = this.authCompleteUrl;
                int i = 0;
                int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.webViewUrl.hashCode()) * 31;
                String str2 = this.returnUrl;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "AlipayRedirect(data=" + this.data + ", authCompleteUrl=" + this.authCompleteUrl + ", webViewUrl=" + this.webViewUrl + ", returnUrl=" + this.returnUrl + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.data);
                parcel.writeString(this.authCompleteUrl);
                parcel.writeParcelable(this.webViewUrl, i);
                parcel.writeString(this.returnUrl);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ AlipayRedirect(String str, String str2, Uri uri, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, uri, (i & 8) != 0 ? null : str3);
            }

            public final String getData() {
                return this.data;
            }

            public final String getAuthCompleteUrl() {
                return this.authCompleteUrl;
            }

            public final Uri getWebViewUrl() {
                return this.webViewUrl;
            }

            public final String getReturnUrl() {
                return this.returnUrl;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AlipayRedirect(String str, String str2, Uri uri, String str3) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "data");
                Intrinsics.checkNotNullParameter(uri, "webViewUrl");
                this.data = str;
                this.authCompleteUrl = str2;
                this.webViewUrl = uri;
                this.returnUrl = str3;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ AlipayRedirect(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, (i & 4) != 0 ? null : str3);
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public AlipayRedirect(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
                /*
                    r2 = this;
                    java.lang.String r0 = "data"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    java.lang.String r0 = "webViewUrl"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                    com.stripe.android.model.StripeIntent$NextActionData$AlipayRedirect$Companion r0 = Companion
                    java.lang.String r0 = r0.extractReturnUrl(r3)
                    android.net.Uri r4 = android.net.Uri.parse(r4)
                    java.lang.String r1 = "parse(webViewUrl)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
                    r2.<init>(r3, r0, r4, r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.StripeIntent.NextActionData.AlipayRedirect.<init>(java.lang.String, java.lang.String, java.lang.String):void");
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$AlipayRedirect$Companion;", "", "()V", "extractReturnUrl", "", "data", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: StripeIntent.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                /* access modifiers changed from: private */
                public final String extractReturnUrl(String str) {
                    Object obj;
                    String str2 = null;
                    try {
                        Result.Companion companion = Result.Companion;
                        Companion companion2 = this;
                        String queryParameter = Uri.parse(Intrinsics.stringPlus("alipay://url?", str)).getQueryParameter("return_url");
                        if (queryParameter == null || !StripeUrlUtils.INSTANCE.isStripeUrl$payments_core_release(queryParameter)) {
                            queryParameter = null;
                        }
                        obj = Result.m4709constructorimpl(queryParameter);
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
                    }
                    if (!Result.m4715isFailureimpl(obj)) {
                        str2 = obj;
                    }
                    return str2;
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "()V", "Use3DS1", "Use3DS2", "Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS1;", "Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntent.kt */
        public static abstract class SdkData extends NextActionData {
            public static final int $stable = 0;

            public /* synthetic */ SdkData(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private SdkData() {
                super((DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS1;", "Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: StripeIntent.kt */
            public static final class Use3DS1 extends SdkData {
                public static final int $stable = 8;
                public static final Parcelable.Creator<Use3DS1> CREATOR = new Creator();
                private final String url;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                /* compiled from: StripeIntent.kt */
                public static final class Creator implements Parcelable.Creator<Use3DS1> {
                    public final Use3DS1 createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        return new Use3DS1(parcel.readString());
                    }

                    public final Use3DS1[] newArray(int i) {
                        return new Use3DS1[i];
                    }
                }

                public static /* synthetic */ Use3DS1 copy$default(Use3DS1 use3DS1, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = use3DS1.url;
                    }
                    return use3DS1.copy(str);
                }

                public final String component1() {
                    return this.url;
                }

                public final Use3DS1 copy(String str) {
                    Intrinsics.checkNotNullParameter(str, "url");
                    return new Use3DS1(str);
                }

                public int describeContents() {
                    return 0;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Use3DS1) && Intrinsics.areEqual((Object) this.url, (Object) ((Use3DS1) obj).url);
                }

                public int hashCode() {
                    return this.url.hashCode();
                }

                public String toString() {
                    return "Use3DS1(url=" + this.url + ')';
                }

                public void writeToParcel(Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "out");
                    parcel.writeString(this.url);
                }

                public final String getUrl() {
                    return this.url;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Use3DS1(String str) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, "url");
                    this.url = str;
                }
            }

            @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001!B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\""}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2;", "Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData;", "source", "", "serverName", "transactionId", "serverEncryption", "Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2$DirectoryServerEncryption;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2$DirectoryServerEncryption;)V", "getServerEncryption", "()Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2$DirectoryServerEncryption;", "getServerName", "()Ljava/lang/String;", "getSource", "getTransactionId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DirectoryServerEncryption", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: StripeIntent.kt */
            public static final class Use3DS2 extends SdkData {
                public static final int $stable = 8;
                public static final Parcelable.Creator<Use3DS2> CREATOR = new Creator();
                private final DirectoryServerEncryption serverEncryption;
                private final String serverName;
                private final String source;
                private final String transactionId;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                /* compiled from: StripeIntent.kt */
                public static final class Creator implements Parcelable.Creator<Use3DS2> {
                    public final Use3DS2 createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        return new Use3DS2(parcel.readString(), parcel.readString(), parcel.readString(), DirectoryServerEncryption.CREATOR.createFromParcel(parcel));
                    }

                    public final Use3DS2[] newArray(int i) {
                        return new Use3DS2[i];
                    }
                }

                public static /* synthetic */ Use3DS2 copy$default(Use3DS2 use3DS2, String str, String str2, String str3, DirectoryServerEncryption directoryServerEncryption, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = use3DS2.source;
                    }
                    if ((i & 2) != 0) {
                        str2 = use3DS2.serverName;
                    }
                    if ((i & 4) != 0) {
                        str3 = use3DS2.transactionId;
                    }
                    if ((i & 8) != 0) {
                        directoryServerEncryption = use3DS2.serverEncryption;
                    }
                    return use3DS2.copy(str, str2, str3, directoryServerEncryption);
                }

                public final String component1() {
                    return this.source;
                }

                public final String component2() {
                    return this.serverName;
                }

                public final String component3() {
                    return this.transactionId;
                }

                public final DirectoryServerEncryption component4() {
                    return this.serverEncryption;
                }

                public final Use3DS2 copy(String str, String str2, String str3, DirectoryServerEncryption directoryServerEncryption) {
                    Intrinsics.checkNotNullParameter(str, "source");
                    Intrinsics.checkNotNullParameter(str2, "serverName");
                    Intrinsics.checkNotNullParameter(str3, "transactionId");
                    Intrinsics.checkNotNullParameter(directoryServerEncryption, "serverEncryption");
                    return new Use3DS2(str, str2, str3, directoryServerEncryption);
                }

                public int describeContents() {
                    return 0;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Use3DS2)) {
                        return false;
                    }
                    Use3DS2 use3DS2 = (Use3DS2) obj;
                    return Intrinsics.areEqual((Object) this.source, (Object) use3DS2.source) && Intrinsics.areEqual((Object) this.serverName, (Object) use3DS2.serverName) && Intrinsics.areEqual((Object) this.transactionId, (Object) use3DS2.transactionId) && Intrinsics.areEqual((Object) this.serverEncryption, (Object) use3DS2.serverEncryption);
                }

                public int hashCode() {
                    return (((((this.source.hashCode() * 31) + this.serverName.hashCode()) * 31) + this.transactionId.hashCode()) * 31) + this.serverEncryption.hashCode();
                }

                public String toString() {
                    return "Use3DS2(source=" + this.source + ", serverName=" + this.serverName + ", transactionId=" + this.transactionId + ", serverEncryption=" + this.serverEncryption + ')';
                }

                public void writeToParcel(Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "out");
                    parcel.writeString(this.source);
                    parcel.writeString(this.serverName);
                    parcel.writeString(this.transactionId);
                    this.serverEncryption.writeToParcel(parcel, i);
                }

                public final String getSource() {
                    return this.source;
                }

                public final String getServerName() {
                    return this.serverName;
                }

                public final String getTransactionId() {
                    return this.transactionId;
                }

                public final DirectoryServerEncryption getServerEncryption() {
                    return this.serverEncryption;
                }

                @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2$DirectoryServerEncryption;", "Landroid/os/Parcelable;", "directoryServerId", "", "dsCertificateData", "rootCertsData", "", "keyId", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDirectoryServerId", "()Ljava/lang/String;", "getDsCertificateData", "getKeyId", "getRootCertsData", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
                /* compiled from: StripeIntent.kt */
                public static final class DirectoryServerEncryption implements Parcelable {
                    public static final int $stable = 8;
                    public static final Parcelable.Creator<DirectoryServerEncryption> CREATOR = new Creator();
                    private final String directoryServerId;
                    private final String dsCertificateData;
                    private final String keyId;
                    private final List<String> rootCertsData;

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    /* compiled from: StripeIntent.kt */
                    public static final class Creator implements Parcelable.Creator<DirectoryServerEncryption> {
                        public final DirectoryServerEncryption createFromParcel(Parcel parcel) {
                            Intrinsics.checkNotNullParameter(parcel, "parcel");
                            return new DirectoryServerEncryption(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString());
                        }

                        public final DirectoryServerEncryption[] newArray(int i) {
                            return new DirectoryServerEncryption[i];
                        }
                    }

                    public static /* synthetic */ DirectoryServerEncryption copy$default(DirectoryServerEncryption directoryServerEncryption, String str, String str2, List<String> list, String str3, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = directoryServerEncryption.directoryServerId;
                        }
                        if ((i & 2) != 0) {
                            str2 = directoryServerEncryption.dsCertificateData;
                        }
                        if ((i & 4) != 0) {
                            list = directoryServerEncryption.rootCertsData;
                        }
                        if ((i & 8) != 0) {
                            str3 = directoryServerEncryption.keyId;
                        }
                        return directoryServerEncryption.copy(str, str2, list, str3);
                    }

                    public final String component1() {
                        return this.directoryServerId;
                    }

                    public final String component2() {
                        return this.dsCertificateData;
                    }

                    public final List<String> component3() {
                        return this.rootCertsData;
                    }

                    public final String component4() {
                        return this.keyId;
                    }

                    public final DirectoryServerEncryption copy(String str, String str2, List<String> list, String str3) {
                        Intrinsics.checkNotNullParameter(str, "directoryServerId");
                        Intrinsics.checkNotNullParameter(str2, "dsCertificateData");
                        Intrinsics.checkNotNullParameter(list, "rootCertsData");
                        return new DirectoryServerEncryption(str, str2, list, str3);
                    }

                    public int describeContents() {
                        return 0;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof DirectoryServerEncryption)) {
                            return false;
                        }
                        DirectoryServerEncryption directoryServerEncryption = (DirectoryServerEncryption) obj;
                        return Intrinsics.areEqual((Object) this.directoryServerId, (Object) directoryServerEncryption.directoryServerId) && Intrinsics.areEqual((Object) this.dsCertificateData, (Object) directoryServerEncryption.dsCertificateData) && Intrinsics.areEqual((Object) this.rootCertsData, (Object) directoryServerEncryption.rootCertsData) && Intrinsics.areEqual((Object) this.keyId, (Object) directoryServerEncryption.keyId);
                    }

                    public int hashCode() {
                        int hashCode = ((((this.directoryServerId.hashCode() * 31) + this.dsCertificateData.hashCode()) * 31) + this.rootCertsData.hashCode()) * 31;
                        String str = this.keyId;
                        return hashCode + (str == null ? 0 : str.hashCode());
                    }

                    public String toString() {
                        return "DirectoryServerEncryption(directoryServerId=" + this.directoryServerId + ", dsCertificateData=" + this.dsCertificateData + ", rootCertsData=" + this.rootCertsData + ", keyId=" + this.keyId + ')';
                    }

                    public void writeToParcel(Parcel parcel, int i) {
                        Intrinsics.checkNotNullParameter(parcel, "out");
                        parcel.writeString(this.directoryServerId);
                        parcel.writeString(this.dsCertificateData);
                        parcel.writeStringList(this.rootCertsData);
                        parcel.writeString(this.keyId);
                    }

                    public DirectoryServerEncryption(String str, String str2, List<String> list, String str3) {
                        Intrinsics.checkNotNullParameter(str, "directoryServerId");
                        Intrinsics.checkNotNullParameter(str2, "dsCertificateData");
                        Intrinsics.checkNotNullParameter(list, "rootCertsData");
                        this.directoryServerId = str;
                        this.dsCertificateData = str2;
                        this.rootCertsData = list;
                        this.keyId = str3;
                    }

                    public final String getDirectoryServerId() {
                        return this.directoryServerId;
                    }

                    public final String getDsCertificateData() {
                        return this.dsCertificateData;
                    }

                    public final List<String> getRootCertsData() {
                        return this.rootCertsData;
                    }

                    public final String getKeyId() {
                        return this.keyId;
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Use3DS2(String str, String str2, String str3, DirectoryServerEncryption directoryServerEncryption) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, "source");
                    Intrinsics.checkNotNullParameter(str2, "serverName");
                    Intrinsics.checkNotNullParameter(str3, "transactionId");
                    Intrinsics.checkNotNullParameter(directoryServerEncryption, "serverEncryption");
                    this.source = str;
                    this.serverName = str2;
                    this.transactionId = str3;
                    this.serverEncryption = directoryServerEncryption;
                }
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004HÖ\u0001¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$BlikAuthorize;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntent.kt */
        public static final class BlikAuthorize extends NextActionData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<BlikAuthorize> CREATOR = new Creator();
            public static final BlikAuthorize INSTANCE = new BlikAuthorize();

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: StripeIntent.kt */
            public static final class Creator implements Parcelable.Creator<BlikAuthorize> {
                public final BlikAuthorize createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return BlikAuthorize.INSTANCE;
                }

                public final BlikAuthorize[] newArray(int i) {
                    return new BlikAuthorize[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                return this == obj;
            }

            public int hashCode() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(1);
            }

            private BlikAuthorize() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$WeChatPayRedirect;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "weChat", "Lcom/stripe/android/model/WeChat;", "(Lcom/stripe/android/model/WeChat;)V", "getWeChat", "()Lcom/stripe/android/model/WeChat;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntent.kt */
        public static final class WeChatPayRedirect extends NextActionData {
            public static final int $stable = 0;
            public static final Parcelable.Creator<WeChatPayRedirect> CREATOR = new Creator();
            private final WeChat weChat;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: StripeIntent.kt */
            public static final class Creator implements Parcelable.Creator<WeChatPayRedirect> {
                public final WeChatPayRedirect createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new WeChatPayRedirect(WeChat.CREATOR.createFromParcel(parcel));
                }

                public final WeChatPayRedirect[] newArray(int i) {
                    return new WeChatPayRedirect[i];
                }
            }

            public static /* synthetic */ WeChatPayRedirect copy$default(WeChatPayRedirect weChatPayRedirect, WeChat weChat2, int i, Object obj) {
                if ((i & 1) != 0) {
                    weChat2 = weChatPayRedirect.weChat;
                }
                return weChatPayRedirect.copy(weChat2);
            }

            public final WeChat component1() {
                return this.weChat;
            }

            public final WeChatPayRedirect copy(WeChat weChat2) {
                Intrinsics.checkNotNullParameter(weChat2, "weChat");
                return new WeChatPayRedirect(weChat2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof WeChatPayRedirect) && Intrinsics.areEqual((Object) this.weChat, (Object) ((WeChatPayRedirect) obj).weChat);
            }

            public int hashCode() {
                return this.weChat.hashCode();
            }

            public String toString() {
                return "WeChatPayRedirect(weChat=" + this.weChat + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                this.weChat.writeToParcel(parcel, i);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public WeChatPayRedirect(WeChat weChat2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(weChat2, "weChat");
                this.weChat = weChat2;
            }

            public final WeChat getWeChat() {
                return this.weChat;
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/stripe/android/model/StripeIntent$NextActionData$VerifyWithMicrodeposits;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "arrivalDate", "", "hostedVerificationUrl", "", "microdepositType", "Lcom/stripe/android/model/MicrodepositType;", "(JLjava/lang/String;Lcom/stripe/android/model/MicrodepositType;)V", "getArrivalDate", "()J", "getHostedVerificationUrl", "()Ljava/lang/String;", "getMicrodepositType", "()Lcom/stripe/android/model/MicrodepositType;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntent.kt */
        public static final class VerifyWithMicrodeposits extends NextActionData {
            public static final int $stable = 8;
            public static final Parcelable.Creator<VerifyWithMicrodeposits> CREATOR = new Creator();
            private final long arrivalDate;
            private final String hostedVerificationUrl;
            private final MicrodepositType microdepositType;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: StripeIntent.kt */
            public static final class Creator implements Parcelable.Creator<VerifyWithMicrodeposits> {
                public final VerifyWithMicrodeposits createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new VerifyWithMicrodeposits(parcel.readLong(), parcel.readString(), MicrodepositType.valueOf(parcel.readString()));
                }

                public final VerifyWithMicrodeposits[] newArray(int i) {
                    return new VerifyWithMicrodeposits[i];
                }
            }

            public static /* synthetic */ VerifyWithMicrodeposits copy$default(VerifyWithMicrodeposits verifyWithMicrodeposits, long j, String str, MicrodepositType microdepositType2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = verifyWithMicrodeposits.arrivalDate;
                }
                if ((i & 2) != 0) {
                    str = verifyWithMicrodeposits.hostedVerificationUrl;
                }
                if ((i & 4) != 0) {
                    microdepositType2 = verifyWithMicrodeposits.microdepositType;
                }
                return verifyWithMicrodeposits.copy(j, str, microdepositType2);
            }

            public final long component1() {
                return this.arrivalDate;
            }

            public final String component2() {
                return this.hostedVerificationUrl;
            }

            public final MicrodepositType component3() {
                return this.microdepositType;
            }

            public final VerifyWithMicrodeposits copy(long j, String str, MicrodepositType microdepositType2) {
                Intrinsics.checkNotNullParameter(str, "hostedVerificationUrl");
                Intrinsics.checkNotNullParameter(microdepositType2, "microdepositType");
                return new VerifyWithMicrodeposits(j, str, microdepositType2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof VerifyWithMicrodeposits)) {
                    return false;
                }
                VerifyWithMicrodeposits verifyWithMicrodeposits = (VerifyWithMicrodeposits) obj;
                return this.arrivalDate == verifyWithMicrodeposits.arrivalDate && Intrinsics.areEqual((Object) this.hostedVerificationUrl, (Object) verifyWithMicrodeposits.hostedVerificationUrl) && this.microdepositType == verifyWithMicrodeposits.microdepositType;
            }

            public int hashCode() {
                return (((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.arrivalDate) * 31) + this.hostedVerificationUrl.hashCode()) * 31) + this.microdepositType.hashCode();
            }

            public String toString() {
                return "VerifyWithMicrodeposits(arrivalDate=" + this.arrivalDate + ", hostedVerificationUrl=" + this.hostedVerificationUrl + ", microdepositType=" + this.microdepositType + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeLong(this.arrivalDate);
                parcel.writeString(this.hostedVerificationUrl);
                parcel.writeString(this.microdepositType.name());
            }

            public final long getArrivalDate() {
                return this.arrivalDate;
            }

            public final String getHostedVerificationUrl() {
                return this.hostedVerificationUrl;
            }

            public final MicrodepositType getMicrodepositType() {
                return this.microdepositType;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public VerifyWithMicrodeposits(long j, String str, MicrodepositType microdepositType2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "hostedVerificationUrl");
                Intrinsics.checkNotNullParameter(microdepositType2, "microdepositType");
                this.arrivalDate = j;
                this.hostedVerificationUrl = str;
                this.microdepositType = microdepositType2;
            }
        }
    }
}

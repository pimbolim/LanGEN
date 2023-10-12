package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.parsers.PaymentIntentJsonParser;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\b\u0018\u0000 x2\u00020\u0001:\u0007uvwxyz{Bñ\u0001\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010$J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0014HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010 HÆ\u0003J\u000f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010#HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010&J\t\u0010^\u001a\u00020\u0007HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010`\u001a\u00020\fHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u000fHÆ\u0003J\t\u0010c\u001a\u00020\u0007HÆ\u0003J\u0002\u0010d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#HÆ\u0001¢\u0006\u0002\u0010eJ\t\u0010f\u001a\u00020gHÖ\u0001J\u0013\u0010h\u001a\u00020\u00142\b\u0010i\u001a\u0004\u0018\u00010jHÖ\u0003J\t\u0010k\u001a\u00020gHÖ\u0001J\b\u0010l\u001a\u00020\u0014H\u0007J\b\u0010m\u001a\u00020\u0014H\u0016J\b\u0010n\u001a\u00020\u0014H\u0016J\t\u0010o\u001a\u00020\u0003HÖ\u0001J\u0019\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020gHÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u0010\u0010\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0014\u00106\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00107R\u0016\u00108\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010/R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0016\u0010\"\u001a\u0004\u0018\u00010#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010>\u001a\u0004\u0018\u00010?8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010/R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010/R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010F¨\u0006|"}, d2 = {"Lcom/stripe/android/model/PaymentIntent;", "Lcom/stripe/android/model/StripeIntent;", "id", "", "paymentMethodTypes", "", "amount", "", "canceledAt", "cancellationReason", "Lcom/stripe/android/model/PaymentIntent$CancellationReason;", "captureMethod", "Lcom/stripe/android/model/PaymentIntent$CaptureMethod;", "clientSecret", "confirmationMethod", "Lcom/stripe/android/model/PaymentIntent$ConfirmationMethod;", "created", "currency", "description", "isLiveMode", "", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "paymentMethodId", "receiptEmail", "status", "Lcom/stripe/android/model/StripeIntent$Status;", "setupFutureUsage", "Lcom/stripe/android/model/StripeIntent$Usage;", "lastPaymentError", "Lcom/stripe/android/model/PaymentIntent$Error;", "shipping", "Lcom/stripe/android/model/PaymentIntent$Shipping;", "unactivatedPaymentMethods", "nextActionData", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;JLcom/stripe/android/model/PaymentIntent$CancellationReason;Lcom/stripe/android/model/PaymentIntent$CaptureMethod;Ljava/lang/String;Lcom/stripe/android/model/PaymentIntent$ConfirmationMethod;JLjava/lang/String;Ljava/lang/String;ZLcom/stripe/android/model/PaymentMethod;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/StripeIntent$Status;Lcom/stripe/android/model/StripeIntent$Usage;Lcom/stripe/android/model/PaymentIntent$Error;Lcom/stripe/android/model/PaymentIntent$Shipping;Ljava/util/List;Lcom/stripe/android/model/StripeIntent$NextActionData;)V", "getAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCanceledAt", "()J", "getCancellationReason", "()Lcom/stripe/android/model/PaymentIntent$CancellationReason;", "getCaptureMethod", "()Lcom/stripe/android/model/PaymentIntent$CaptureMethod;", "getClientSecret", "()Ljava/lang/String;", "getConfirmationMethod", "()Lcom/stripe/android/model/PaymentIntent$ConfirmationMethod;", "getCreated", "getCurrency", "getDescription", "getId", "isConfirmed", "()Z", "lastErrorMessage", "getLastErrorMessage", "getLastPaymentError", "()Lcom/stripe/android/model/PaymentIntent$Error;", "getNextActionData", "()Lcom/stripe/android/model/StripeIntent$NextActionData;", "nextActionType", "Lcom/stripe/android/model/StripeIntent$NextActionType;", "getNextActionType", "()Lcom/stripe/android/model/StripeIntent$NextActionType;", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "getPaymentMethodId", "getPaymentMethodTypes", "()Ljava/util/List;", "getReceiptEmail", "getSetupFutureUsage", "()Lcom/stripe/android/model/StripeIntent$Usage;", "getShipping", "()Lcom/stripe/android/model/PaymentIntent$Shipping;", "getStatus", "()Lcom/stripe/android/model/StripeIntent$Status;", "getUnactivatedPaymentMethods", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;JLcom/stripe/android/model/PaymentIntent$CancellationReason;Lcom/stripe/android/model/PaymentIntent$CaptureMethod;Ljava/lang/String;Lcom/stripe/android/model/PaymentIntent$ConfirmationMethod;JLjava/lang/String;Ljava/lang/String;ZLcom/stripe/android/model/PaymentMethod;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/StripeIntent$Status;Lcom/stripe/android/model/StripeIntent$Usage;Lcom/stripe/android/model/PaymentIntent$Error;Lcom/stripe/android/model/PaymentIntent$Shipping;Ljava/util/List;Lcom/stripe/android/model/StripeIntent$NextActionData;)Lcom/stripe/android/model/PaymentIntent;", "describeContents", "", "equals", "other", "", "hashCode", "isSetupFutureUsageSet", "requiresAction", "requiresConfirmation", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CancellationReason", "CaptureMethod", "ClientSecret", "Companion", "ConfirmationMethod", "Error", "Shipping", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentIntent.kt */
public final class PaymentIntent implements StripeIntent {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaymentIntent> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Long amount;
    private final long canceledAt;
    private final CancellationReason cancellationReason;
    private final CaptureMethod captureMethod;
    private final String clientSecret;
    private final ConfirmationMethod confirmationMethod;
    private final long created;
    private final String currency;
    private final String description;
    private final String id;
    private final boolean isLiveMode;
    private final Error lastPaymentError;
    private final StripeIntent.NextActionData nextActionData;
    private final PaymentMethod paymentMethod;
    private final String paymentMethodId;
    private final List<String> paymentMethodTypes;
    private final String receiptEmail;
    private final StripeIntent.Usage setupFutureUsage;
    private final Shipping shipping;
    private final StripeIntent.Status status;
    private final List<String> unactivatedPaymentMethods;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntent.kt */
    public static final class Creator implements Parcelable.Creator<PaymentIntent> {
        public final PaymentIntent createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            List createStringArrayList = parcel.createStringArrayList();
            Shipping shipping = null;
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            long readLong = parcel.readLong();
            CancellationReason valueOf2 = parcel.readInt() == 0 ? null : CancellationReason.valueOf(parcel.readString());
            CaptureMethod valueOf3 = CaptureMethod.valueOf(parcel.readString());
            String readString2 = parcel.readString();
            ConfirmationMethod valueOf4 = ConfirmationMethod.valueOf(parcel.readString());
            long readLong2 = parcel.readLong();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            PaymentMethod createFromParcel = parcel.readInt() == 0 ? null : PaymentMethod.CREATOR.createFromParcel(parcel2);
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            StripeIntent.Status valueOf5 = parcel.readInt() == 0 ? null : StripeIntent.Status.valueOf(parcel.readString());
            StripeIntent.Usage valueOf6 = parcel.readInt() == 0 ? null : StripeIntent.Usage.valueOf(parcel.readString());
            Error createFromParcel2 = parcel.readInt() == 0 ? null : Error.CREATOR.createFromParcel(parcel2);
            if (parcel.readInt() != 0) {
                shipping = Shipping.CREATOR.createFromParcel(parcel2);
            }
            return new PaymentIntent(readString, createStringArrayList, valueOf, readLong, valueOf2, valueOf3, readString2, valueOf4, readLong2, readString3, readString4, z, createFromParcel, readString5, readString6, valueOf5, valueOf6, createFromParcel2, shipping, parcel.createStringArrayList(), (StripeIntent.NextActionData) parcel2.readParcelable(PaymentIntent.class.getClassLoader()));
        }

        public final PaymentIntent[] newArray(int i) {
            return new PaymentIntent[i];
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntent.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StripeIntent.Usage.values().length];
            iArr[StripeIntent.Usage.OnSession.ordinal()] = 1;
            iArr[StripeIntent.Usage.OffSession.ordinal()] = 2;
            iArr[StripeIntent.Usage.OneTime.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ PaymentIntent copy$default(PaymentIntent paymentIntent, String str, List list, Long l, long j, CancellationReason cancellationReason2, CaptureMethod captureMethod2, String str2, ConfirmationMethod confirmationMethod2, long j2, String str3, String str4, boolean z, PaymentMethod paymentMethod2, String str5, String str6, StripeIntent.Status status2, StripeIntent.Usage usage, Error error, Shipping shipping2, List list2, StripeIntent.NextActionData nextActionData2, int i, Object obj) {
        PaymentIntent paymentIntent2 = paymentIntent;
        int i2 = i;
        return paymentIntent.copy((i2 & 1) != 0 ? paymentIntent.getId() : str, (i2 & 2) != 0 ? paymentIntent.getPaymentMethodTypes() : list, (i2 & 4) != 0 ? paymentIntent2.amount : l, (i2 & 8) != 0 ? paymentIntent2.canceledAt : j, (i2 & 16) != 0 ? paymentIntent2.cancellationReason : cancellationReason2, (i2 & 32) != 0 ? paymentIntent2.captureMethod : captureMethod2, (i2 & 64) != 0 ? paymentIntent.getClientSecret() : str2, (i2 & 128) != 0 ? paymentIntent2.confirmationMethod : confirmationMethod2, (i2 & 256) != 0 ? paymentIntent.getCreated() : j2, (i2 & 512) != 0 ? paymentIntent2.currency : str3, (i2 & 1024) != 0 ? paymentIntent.getDescription() : str4, (i2 & 2048) != 0 ? paymentIntent.isLiveMode() : z, (i2 & 4096) != 0 ? paymentIntent.getPaymentMethod() : paymentMethod2, (i2 & 8192) != 0 ? paymentIntent.getPaymentMethodId() : str5, (i2 & 16384) != 0 ? paymentIntent2.receiptEmail : str6, (i2 & 32768) != 0 ? paymentIntent.getStatus() : status2, (i2 & 65536) != 0 ? paymentIntent2.setupFutureUsage : usage, (i2 & 131072) != 0 ? paymentIntent2.lastPaymentError : error, (i2 & 262144) != 0 ? paymentIntent2.shipping : shipping2, (i2 & 524288) != 0 ? paymentIntent.getUnactivatedPaymentMethods() : list2, (i2 & 1048576) != 0 ? paymentIntent.getNextActionData() : nextActionData2);
    }

    @JvmStatic
    public static final PaymentIntent fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    public final String component1() {
        return getId();
    }

    public final String component10() {
        return this.currency;
    }

    public final String component11() {
        return getDescription();
    }

    public final boolean component12() {
        return isLiveMode();
    }

    public final PaymentMethod component13() {
        return getPaymentMethod();
    }

    public final String component14() {
        return getPaymentMethodId();
    }

    public final String component15() {
        return this.receiptEmail;
    }

    public final StripeIntent.Status component16() {
        return getStatus();
    }

    public final StripeIntent.Usage component17() {
        return this.setupFutureUsage;
    }

    public final Error component18() {
        return this.lastPaymentError;
    }

    public final Shipping component19() {
        return this.shipping;
    }

    public final List<String> component2() {
        return getPaymentMethodTypes();
    }

    public final List<String> component20() {
        return getUnactivatedPaymentMethods();
    }

    public final StripeIntent.NextActionData component21() {
        return getNextActionData();
    }

    public final Long component3() {
        return this.amount;
    }

    public final long component4() {
        return this.canceledAt;
    }

    public final CancellationReason component5() {
        return this.cancellationReason;
    }

    public final CaptureMethod component6() {
        return this.captureMethod;
    }

    public final String component7() {
        return getClientSecret();
    }

    public final ConfirmationMethod component8() {
        return this.confirmationMethod;
    }

    public final long component9() {
        return getCreated();
    }

    public final PaymentIntent copy(String str, List<String> list, Long l, long j, CancellationReason cancellationReason2, CaptureMethod captureMethod2, String str2, ConfirmationMethod confirmationMethod2, long j2, String str3, String str4, boolean z, PaymentMethod paymentMethod2, String str5, String str6, StripeIntent.Status status2, StripeIntent.Usage usage, Error error, Shipping shipping2, List<String> list2, StripeIntent.NextActionData nextActionData2) {
        String str7 = str;
        Intrinsics.checkNotNullParameter(list, "paymentMethodTypes");
        Intrinsics.checkNotNullParameter(captureMethod2, "captureMethod");
        Intrinsics.checkNotNullParameter(confirmationMethod2, "confirmationMethod");
        Intrinsics.checkNotNullParameter(list2, "unactivatedPaymentMethods");
        return new PaymentIntent(str, list, l, j, cancellationReason2, captureMethod2, str2, confirmationMethod2, j2, str3, str4, z, paymentMethod2, str5, str6, status2, usage, error, shipping2, list2, nextActionData2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentIntent)) {
            return false;
        }
        PaymentIntent paymentIntent = (PaymentIntent) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) paymentIntent.getId()) && Intrinsics.areEqual((Object) getPaymentMethodTypes(), (Object) paymentIntent.getPaymentMethodTypes()) && Intrinsics.areEqual((Object) this.amount, (Object) paymentIntent.amount) && this.canceledAt == paymentIntent.canceledAt && this.cancellationReason == paymentIntent.cancellationReason && this.captureMethod == paymentIntent.captureMethod && Intrinsics.areEqual((Object) getClientSecret(), (Object) paymentIntent.getClientSecret()) && this.confirmationMethod == paymentIntent.confirmationMethod && getCreated() == paymentIntent.getCreated() && Intrinsics.areEqual((Object) this.currency, (Object) paymentIntent.currency) && Intrinsics.areEqual((Object) getDescription(), (Object) paymentIntent.getDescription()) && isLiveMode() == paymentIntent.isLiveMode() && Intrinsics.areEqual((Object) getPaymentMethod(), (Object) paymentIntent.getPaymentMethod()) && Intrinsics.areEqual((Object) getPaymentMethodId(), (Object) paymentIntent.getPaymentMethodId()) && Intrinsics.areEqual((Object) this.receiptEmail, (Object) paymentIntent.receiptEmail) && getStatus() == paymentIntent.getStatus() && this.setupFutureUsage == paymentIntent.setupFutureUsage && Intrinsics.areEqual((Object) this.lastPaymentError, (Object) paymentIntent.lastPaymentError) && Intrinsics.areEqual((Object) this.shipping, (Object) paymentIntent.shipping) && Intrinsics.areEqual((Object) getUnactivatedPaymentMethods(), (Object) paymentIntent.getUnactivatedPaymentMethods()) && Intrinsics.areEqual((Object) getNextActionData(), (Object) paymentIntent.getNextActionData());
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((getId() == null ? 0 : getId().hashCode()) * 31) + getPaymentMethodTypes().hashCode()) * 31;
        Long l = this.amount;
        int hashCode2 = (((hashCode + (l == null ? 0 : l.hashCode())) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.canceledAt)) * 31;
        CancellationReason cancellationReason2 = this.cancellationReason;
        int hashCode3 = (((((((((hashCode2 + (cancellationReason2 == null ? 0 : cancellationReason2.hashCode())) * 31) + this.captureMethod.hashCode()) * 31) + (getClientSecret() == null ? 0 : getClientSecret().hashCode())) * 31) + this.confirmationMethod.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(getCreated())) * 31;
        String str = this.currency;
        int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + (getDescription() == null ? 0 : getDescription().hashCode())) * 31;
        boolean isLiveMode2 = isLiveMode();
        if (isLiveMode2) {
            isLiveMode2 = true;
        }
        int hashCode5 = (((((hashCode4 + (isLiveMode2 ? 1 : 0)) * 31) + (getPaymentMethod() == null ? 0 : getPaymentMethod().hashCode())) * 31) + (getPaymentMethodId() == null ? 0 : getPaymentMethodId().hashCode())) * 31;
        String str2 = this.receiptEmail;
        int hashCode6 = (((hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31) + (getStatus() == null ? 0 : getStatus().hashCode())) * 31;
        StripeIntent.Usage usage = this.setupFutureUsage;
        int hashCode7 = (hashCode6 + (usage == null ? 0 : usage.hashCode())) * 31;
        Error error = this.lastPaymentError;
        int hashCode8 = (hashCode7 + (error == null ? 0 : error.hashCode())) * 31;
        Shipping shipping2 = this.shipping;
        int hashCode9 = (((hashCode8 + (shipping2 == null ? 0 : shipping2.hashCode())) * 31) + getUnactivatedPaymentMethods().hashCode()) * 31;
        if (getNextActionData() != null) {
            i = getNextActionData().hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "PaymentIntent(id=" + getId() + ", paymentMethodTypes=" + getPaymentMethodTypes() + ", amount=" + this.amount + ", canceledAt=" + this.canceledAt + ", cancellationReason=" + this.cancellationReason + ", captureMethod=" + this.captureMethod + ", clientSecret=" + getClientSecret() + ", confirmationMethod=" + this.confirmationMethod + ", created=" + getCreated() + ", currency=" + this.currency + ", description=" + getDescription() + ", isLiveMode=" + isLiveMode() + ", paymentMethod=" + getPaymentMethod() + ", paymentMethodId=" + getPaymentMethodId() + ", receiptEmail=" + this.receiptEmail + ", status=" + getStatus() + ", setupFutureUsage=" + this.setupFutureUsage + ", lastPaymentError=" + this.lastPaymentError + ", shipping=" + this.shipping + ", unactivatedPaymentMethods=" + getUnactivatedPaymentMethods() + ", nextActionData=" + getNextActionData() + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeStringList(this.paymentMethodTypes);
        Long l = this.amount;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeLong(this.canceledAt);
        CancellationReason cancellationReason2 = this.cancellationReason;
        if (cancellationReason2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(cancellationReason2.name());
        }
        parcel.writeString(this.captureMethod.name());
        parcel.writeString(this.clientSecret);
        parcel.writeString(this.confirmationMethod.name());
        parcel.writeLong(this.created);
        parcel.writeString(this.currency);
        parcel.writeString(this.description);
        parcel.writeInt(this.isLiveMode ? 1 : 0);
        PaymentMethod paymentMethod2 = this.paymentMethod;
        if (paymentMethod2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            paymentMethod2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.paymentMethodId);
        parcel.writeString(this.receiptEmail);
        StripeIntent.Status status2 = this.status;
        if (status2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(status2.name());
        }
        StripeIntent.Usage usage = this.setupFutureUsage;
        if (usage == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(usage.name());
        }
        Error error = this.lastPaymentError;
        if (error == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            error.writeToParcel(parcel, i);
        }
        Shipping shipping2 = this.shipping;
        if (shipping2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            shipping2.writeToParcel(parcel, i);
        }
        parcel.writeStringList(this.unactivatedPaymentMethods);
        parcel.writeParcelable(this.nextActionData, i);
    }

    public PaymentIntent(String str, List<String> list, Long l, long j, CancellationReason cancellationReason2, CaptureMethod captureMethod2, String str2, ConfirmationMethod confirmationMethod2, long j2, String str3, String str4, boolean z, PaymentMethod paymentMethod2, String str5, String str6, StripeIntent.Status status2, StripeIntent.Usage usage, Error error, Shipping shipping2, List<String> list2, StripeIntent.NextActionData nextActionData2) {
        ConfirmationMethod confirmationMethod3 = confirmationMethod2;
        List<String> list3 = list2;
        Intrinsics.checkNotNullParameter(list, "paymentMethodTypes");
        Intrinsics.checkNotNullParameter(captureMethod2, "captureMethod");
        Intrinsics.checkNotNullParameter(confirmationMethod3, "confirmationMethod");
        Intrinsics.checkNotNullParameter(list3, "unactivatedPaymentMethods");
        this.id = str;
        this.paymentMethodTypes = list;
        this.amount = l;
        this.canceledAt = j;
        this.cancellationReason = cancellationReason2;
        this.captureMethod = captureMethod2;
        this.clientSecret = str2;
        this.confirmationMethod = confirmationMethod3;
        this.created = j2;
        this.currency = str3;
        this.description = str4;
        this.isLiveMode = z;
        this.paymentMethod = paymentMethod2;
        this.paymentMethodId = str5;
        this.receiptEmail = str6;
        this.status = status2;
        this.setupFutureUsage = usage;
        this.lastPaymentError = error;
        this.shipping = shipping2;
        this.unactivatedPaymentMethods = list3;
        this.nextActionData = nextActionData2;
    }

    public String getId() {
        return this.id;
    }

    public List<String> getPaymentMethodTypes() {
        return this.paymentMethodTypes;
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final long getCanceledAt() {
        return this.canceledAt;
    }

    public final CancellationReason getCancellationReason() {
        return this.cancellationReason;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentIntent(java.lang.String r28, java.util.List r29, java.lang.Long r30, long r31, com.stripe.android.model.PaymentIntent.CancellationReason r33, com.stripe.android.model.PaymentIntent.CaptureMethod r34, java.lang.String r35, com.stripe.android.model.PaymentIntent.ConfirmationMethod r36, long r37, java.lang.String r39, java.lang.String r40, boolean r41, com.stripe.android.model.PaymentMethod r42, java.lang.String r43, java.lang.String r44, com.stripe.android.model.StripeIntent.Status r45, com.stripe.android.model.StripeIntent.Usage r46, com.stripe.android.model.PaymentIntent.Error r47, com.stripe.android.model.PaymentIntent.Shipping r48, java.util.List r49, com.stripe.android.model.StripeIntent.NextActionData r50, int r51, kotlin.jvm.internal.DefaultConstructorMarker r52) {
        /*
            r27 = this;
            r0 = r51
            r1 = r0 & 8
            if (r1 == 0) goto L_0x000a
            r1 = 0
            r7 = r1
            goto L_0x000c
        L_0x000a:
            r7 = r31
        L_0x000c:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r9 = r2
            goto L_0x0015
        L_0x0013:
            r9 = r33
        L_0x0015:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001d
            com.stripe.android.model.PaymentIntent$CaptureMethod r1 = com.stripe.android.model.PaymentIntent.CaptureMethod.Automatic
            r10 = r1
            goto L_0x001f
        L_0x001d:
            r10 = r34
        L_0x001f:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0027
            com.stripe.android.model.PaymentIntent$ConfirmationMethod r1 = com.stripe.android.model.PaymentIntent.ConfirmationMethod.Automatic
            r12 = r1
            goto L_0x0029
        L_0x0027:
            r12 = r36
        L_0x0029:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0030
            r16 = r2
            goto L_0x0032
        L_0x0030:
            r16 = r40
        L_0x0032:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0039
            r18 = r2
            goto L_0x003b
        L_0x0039:
            r18 = r42
        L_0x003b:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0042
            r19 = r2
            goto L_0x0044
        L_0x0042:
            r19 = r43
        L_0x0044:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x004b
            r20 = r2
            goto L_0x004d
        L_0x004b:
            r20 = r44
        L_0x004d:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0056
            r21 = r2
            goto L_0x0058
        L_0x0056:
            r21 = r45
        L_0x0058:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0060
            r22 = r2
            goto L_0x0062
        L_0x0060:
            r22 = r46
        L_0x0062:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x006a
            r23 = r2
            goto L_0x006c
        L_0x006a:
            r23 = r47
        L_0x006c:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0074
            r24 = r2
            goto L_0x0076
        L_0x0074:
            r24 = r48
        L_0x0076:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x007e
            r26 = r2
            goto L_0x0080
        L_0x007e:
            r26 = r50
        L_0x0080:
            r3 = r27
            r4 = r28
            r5 = r29
            r6 = r30
            r11 = r35
            r13 = r37
            r15 = r39
            r17 = r41
            r25 = r49
            r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.PaymentIntent.<init>(java.lang.String, java.util.List, java.lang.Long, long, com.stripe.android.model.PaymentIntent$CancellationReason, com.stripe.android.model.PaymentIntent$CaptureMethod, java.lang.String, com.stripe.android.model.PaymentIntent$ConfirmationMethod, long, java.lang.String, java.lang.String, boolean, com.stripe.android.model.PaymentMethod, java.lang.String, java.lang.String, com.stripe.android.model.StripeIntent$Status, com.stripe.android.model.StripeIntent$Usage, com.stripe.android.model.PaymentIntent$Error, com.stripe.android.model.PaymentIntent$Shipping, java.util.List, com.stripe.android.model.StripeIntent$NextActionData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final CaptureMethod getCaptureMethod() {
        return this.captureMethod;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public final ConfirmationMethod getConfirmationMethod() {
        return this.confirmationMethod;
    }

    public long getCreated() {
        return this.created;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isLiveMode() {
        return this.isLiveMode;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getPaymentMethodId() {
        return this.paymentMethodId;
    }

    public final String getReceiptEmail() {
        return this.receiptEmail;
    }

    public StripeIntent.Status getStatus() {
        return this.status;
    }

    public final StripeIntent.Usage getSetupFutureUsage() {
        return this.setupFutureUsage;
    }

    public final Error getLastPaymentError() {
        return this.lastPaymentError;
    }

    public final Shipping getShipping() {
        return this.shipping;
    }

    public List<String> getUnactivatedPaymentMethods() {
        return this.unactivatedPaymentMethods;
    }

    public StripeIntent.NextActionData getNextActionData() {
        return this.nextActionData;
    }

    public StripeIntent.NextActionType getNextActionType() {
        StripeIntent.NextActionData nextActionData2 = getNextActionData();
        if (nextActionData2 instanceof StripeIntent.NextActionData.SdkData) {
            return StripeIntent.NextActionType.UseStripeSdk;
        }
        if (nextActionData2 instanceof StripeIntent.NextActionData.RedirectToUrl) {
            return StripeIntent.NextActionType.RedirectToUrl;
        }
        if (nextActionData2 instanceof StripeIntent.NextActionData.DisplayOxxoDetails) {
            return StripeIntent.NextActionType.DisplayOxxoDetails;
        }
        if (nextActionData2 instanceof StripeIntent.NextActionData.VerifyWithMicrodeposits) {
            return StripeIntent.NextActionType.VerifyWithMicrodeposits;
        }
        return null;
    }

    public boolean isConfirmed() {
        return CollectionsKt.contains(SetsKt.setOf(StripeIntent.Status.Processing, StripeIntent.Status.RequiresCapture, StripeIntent.Status.Succeeded), getStatus());
    }

    public String getLastErrorMessage() {
        Error error = this.lastPaymentError;
        if (error == null) {
            return null;
        }
        return error.getMessage();
    }

    public boolean requiresAction() {
        return getStatus() == StripeIntent.Status.RequiresAction;
    }

    public boolean requiresConfirmation() {
        return getStatus() == StripeIntent.Status.RequiresConfirmation;
    }

    public final boolean isSetupFutureUsageSet() {
        StripeIntent.Usage usage = this.setupFutureUsage;
        int i = usage == null ? -1 : WhenMappings.$EnumSwitchMapping$0[usage.ordinal()];
        if (i == -1) {
            return false;
        }
        if (i == 1 || i == 2) {
            return true;
        }
        if (i == 3) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 /2\u00020\u0001:\u0002/0BW\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003Ji\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00061"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$Error;", "Lcom/stripe/android/core/model/StripeModel;", "charge", "", "code", "declineCode", "docUrl", "message", "param", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "type", "Lcom/stripe/android/model/PaymentIntent$Error$Type;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/PaymentMethod;Lcom/stripe/android/model/PaymentIntent$Error$Type;)V", "getCharge", "()Ljava/lang/String;", "getCode", "getDeclineCode", "getDocUrl", "getMessage", "getParam", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "getType", "()Lcom/stripe/android/model/PaymentIntent$Error$Type;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Type", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntent.kt */
    public static final class Error implements StripeModel {
        public static final int $stable = 8;
        public static final String CODE_AUTHENTICATION_ERROR = "payment_intent_authentication_failure";
        public static final Parcelable.Creator<Error> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String charge;
        private final String code;
        private final String declineCode;
        private final String docUrl;
        private final String message;
        private final String param;
        private final PaymentMethod paymentMethod;
        private final Type type;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentIntent.kt */
        public static final class Creator implements Parcelable.Creator<Error> {
            public final Error createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Error(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : PaymentMethod.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Type.valueOf(parcel.readString()));
            }

            public final Error[] newArray(int i) {
                return new Error[i];
            }
        }

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, String str3, String str4, String str5, String str6, PaymentMethod paymentMethod2, Type type2, int i, Object obj) {
            Error error2 = error;
            int i2 = i;
            return error.copy((i2 & 1) != 0 ? error2.charge : str, (i2 & 2) != 0 ? error2.code : str2, (i2 & 4) != 0 ? error2.declineCode : str3, (i2 & 8) != 0 ? error2.docUrl : str4, (i2 & 16) != 0 ? error2.message : str5, (i2 & 32) != 0 ? error2.param : str6, (i2 & 64) != 0 ? error2.paymentMethod : paymentMethod2, (i2 & 128) != 0 ? error2.type : type2);
        }

        public final String component1() {
            return this.charge;
        }

        public final String component2() {
            return this.code;
        }

        public final String component3() {
            return this.declineCode;
        }

        public final String component4() {
            return this.docUrl;
        }

        public final String component5() {
            return this.message;
        }

        public final String component6() {
            return this.param;
        }

        public final PaymentMethod component7() {
            return this.paymentMethod;
        }

        public final Type component8() {
            return this.type;
        }

        public final Error copy(String str, String str2, String str3, String str4, String str5, String str6, PaymentMethod paymentMethod2, Type type2) {
            return new Error(str, str2, str3, str4, str5, str6, paymentMethod2, type2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.charge, (Object) error.charge) && Intrinsics.areEqual((Object) this.code, (Object) error.code) && Intrinsics.areEqual((Object) this.declineCode, (Object) error.declineCode) && Intrinsics.areEqual((Object) this.docUrl, (Object) error.docUrl) && Intrinsics.areEqual((Object) this.message, (Object) error.message) && Intrinsics.areEqual((Object) this.param, (Object) error.param) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) error.paymentMethod) && this.type == error.type;
        }

        public int hashCode() {
            String str = this.charge;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.code;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.declineCode;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.docUrl;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.message;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.param;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            PaymentMethod paymentMethod2 = this.paymentMethod;
            int hashCode7 = (hashCode6 + (paymentMethod2 == null ? 0 : paymentMethod2.hashCode())) * 31;
            Type type2 = this.type;
            if (type2 != null) {
                i = type2.hashCode();
            }
            return hashCode7 + i;
        }

        public String toString() {
            return "Error(charge=" + this.charge + ", code=" + this.code + ", declineCode=" + this.declineCode + ", docUrl=" + this.docUrl + ", message=" + this.message + ", param=" + this.param + ", paymentMethod=" + this.paymentMethod + ", type=" + this.type + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.charge);
            parcel.writeString(this.code);
            parcel.writeString(this.declineCode);
            parcel.writeString(this.docUrl);
            parcel.writeString(this.message);
            parcel.writeString(this.param);
            PaymentMethod paymentMethod2 = this.paymentMethod;
            if (paymentMethod2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                paymentMethod2.writeToParcel(parcel, i);
            }
            Type type2 = this.type;
            if (type2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(type2.name());
        }

        public Error(String str, String str2, String str3, String str4, String str5, String str6, PaymentMethod paymentMethod2, Type type2) {
            this.charge = str;
            this.code = str2;
            this.declineCode = str3;
            this.docUrl = str4;
            this.message = str5;
            this.param = str6;
            this.paymentMethod = paymentMethod2;
            this.type = type2;
        }

        public final String getCharge() {
            return this.charge;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getDeclineCode() {
            return this.declineCode;
        }

        public final String getDocUrl() {
            return this.docUrl;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getParam() {
            return this.param;
        }

        public final PaymentMethod getPaymentMethod() {
            return this.paymentMethod;
        }

        public final Type getType() {
            return this.type;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$Error$Type;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "ApiConnectionError", "ApiError", "AuthenticationError", "CardError", "IdempotencyError", "InvalidRequestError", "RateLimitError", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentIntent.kt */
        public enum Type {
            ApiConnectionError("api_connection_error"),
            ApiError("api_error"),
            AuthenticationError("authentication_error"),
            CardError("card_error"),
            IdempotencyError("idempotency_error"),
            InvalidRequestError("invalid_request_error"),
            RateLimitError("rate_limit_error");
            
            public static final Companion Companion = null;
            private final String code;

            private Type(String str) {
                this.code = str;
            }

            public final String getCode() {
                return this.code;
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$Error$Type$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/PaymentIntent$Error$Type;", "typeCode", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentIntent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Type fromCode(String str) {
                    Type[] values = Type.values();
                    int length = values.length;
                    int i = 0;
                    while (i < length) {
                        Type type = values[i];
                        i++;
                        if (Intrinsics.areEqual((Object) type.getCode(), (Object) str)) {
                            return type;
                        }
                    }
                    return null;
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$Error$Companion;", "", "()V", "CODE_AUTHENTICATION_ERROR", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentIntent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006$"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$Shipping;", "Lcom/stripe/android/core/model/StripeModel;", "address", "Lcom/stripe/android/model/Address;", "carrier", "", "name", "phone", "trackingNumber", "(Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Lcom/stripe/android/model/Address;", "getCarrier", "()Ljava/lang/String;", "getName", "getPhone", "getTrackingNumber", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntent.kt */
    public static final class Shipping implements StripeModel {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Shipping> CREATOR = new Creator();
        private final Address address;
        private final String carrier;
        private final String name;
        private final String phone;
        private final String trackingNumber;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentIntent.kt */
        public static final class Creator implements Parcelable.Creator<Shipping> {
            public final Shipping createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Shipping(Address.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final Shipping[] newArray(int i) {
                return new Shipping[i];
            }
        }

        public static /* synthetic */ Shipping copy$default(Shipping shipping, Address address2, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                address2 = shipping.address;
            }
            if ((i & 2) != 0) {
                str = shipping.carrier;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = shipping.name;
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

        public final Address component1() {
            return this.address;
        }

        public final String component2() {
            return this.carrier;
        }

        public final String component3() {
            return this.name;
        }

        public final String component4() {
            return this.phone;
        }

        public final String component5() {
            return this.trackingNumber;
        }

        public final Shipping copy(Address address2, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(address2, PaymentMethod.BillingDetails.PARAM_ADDRESS);
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
            return Intrinsics.areEqual((Object) this.address, (Object) shipping.address) && Intrinsics.areEqual((Object) this.carrier, (Object) shipping.carrier) && Intrinsics.areEqual((Object) this.name, (Object) shipping.name) && Intrinsics.areEqual((Object) this.phone, (Object) shipping.phone) && Intrinsics.areEqual((Object) this.trackingNumber, (Object) shipping.trackingNumber);
        }

        public int hashCode() {
            int hashCode = this.address.hashCode() * 31;
            String str = this.carrier;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.name;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.phone;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.trackingNumber;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            return "Shipping(address=" + this.address + ", carrier=" + this.carrier + ", name=" + this.name + ", phone=" + this.phone + ", trackingNumber=" + this.trackingNumber + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.address.writeToParcel(parcel, i);
            parcel.writeString(this.carrier);
            parcel.writeString(this.name);
            parcel.writeString(this.phone);
            parcel.writeString(this.trackingNumber);
        }

        public Shipping(Address address2, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(address2, PaymentMethod.BillingDetails.PARAM_ADDRESS);
            this.address = address2;
            this.carrier = str;
            this.name = str2;
            this.phone = str3;
            this.trackingNumber = str4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Shipping(Address address2, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(address2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
        }

        public final Address getAddress() {
            return this.address;
        }

        public final String getCarrier() {
            return this.carrier;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPhone() {
            return this.phone;
        }

        public final String getTrackingNumber() {
            return this.trackingNumber;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\nJ\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$ClientSecret;", "", "value", "", "(Ljava/lang/String;)V", "paymentIntentId", "getPaymentIntentId$payments_core_release", "()Ljava/lang/String;", "getValue$payments_core_release", "component1", "component1$payments_core_release", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntent.kt */
    public static final class ClientSecret {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final Pattern PATTERN = Pattern.compile("^pi_[^_]+_secret_[^_]+$");
        private final String paymentIntentId;
        private final String value;

        public static /* synthetic */ ClientSecret copy$default(ClientSecret clientSecret, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = clientSecret.value;
            }
            return clientSecret.copy(str);
        }

        public final String component1$payments_core_release() {
            return this.value;
        }

        public final ClientSecret copy(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return new ClientSecret(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClientSecret) && Intrinsics.areEqual((Object) this.value, (Object) ((ClientSecret) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "ClientSecret(value=" + this.value + ')';
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x006d A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x006e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ClientSecret(java.lang.String r5) {
            /*
                r4 = this;
                java.lang.String r0 = "value"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                r4.<init>()
                r4.value = r5
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                kotlin.text.Regex r0 = new kotlin.text.Regex
                java.lang.String r1 = "_secret"
                r0.<init>((java.lang.String) r1)
                r1 = 0
                java.util.List r5 = r0.split(r5, r1)
                boolean r0 = r5.isEmpty()
                if (r0 != 0) goto L_0x004c
                int r0 = r5.size()
                java.util.ListIterator r0 = r5.listIterator(r0)
            L_0x0026:
                boolean r2 = r0.hasPrevious()
                if (r2 == 0) goto L_0x004c
                java.lang.Object r2 = r0.previous()
                java.lang.String r2 = (java.lang.String) r2
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                int r2 = r2.length()
                r3 = 1
                if (r2 != 0) goto L_0x003d
                r2 = 1
                goto L_0x003e
            L_0x003d:
                r2 = 0
            L_0x003e:
                if (r2 != 0) goto L_0x0026
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                int r0 = r0.nextIndex()
                int r0 = r0 + r3
                java.util.List r5 = kotlin.collections.CollectionsKt.take(r5, r0)
                goto L_0x0050
            L_0x004c:
                java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            L_0x0050:
                java.util.Collection r5 = (java.util.Collection) r5
                java.lang.String[] r0 = new java.lang.String[r1]
                java.lang.Object[] r5 = r5.toArray(r0)
                java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
                java.util.Objects.requireNonNull(r5, r0)
                java.lang.String[] r5 = (java.lang.String[]) r5
                r5 = r5[r1]
                r4.paymentIntentId = r5
                com.stripe.android.model.PaymentIntent$ClientSecret$Companion r5 = Companion
                java.lang.String r0 = r4.value
                boolean r5 = r5.isMatch(r0)
                if (r5 == 0) goto L_0x006e
                return
            L_0x006e:
                java.lang.String r5 = r4.getValue$payments_core_release()
                java.lang.String r0 = "Invalid Payment Intent client secret: "
                java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r5)
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r5 = r5.toString()
                r0.<init>(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.PaymentIntent.ClientSecret.<init>(java.lang.String):void");
        }

        public final String getValue$payments_core_release() {
            return this.value;
        }

        public final String getPaymentIntentId$payments_core_release() {
            return this.paymentIntentId;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$ClientSecret$Companion;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "isMatch", "", "value", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentIntent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final boolean isMatch(String str) {
                Intrinsics.checkNotNullParameter(str, "value");
                return ClientSecret.PATTERN.matcher(str).matches();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$CancellationReason;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "Duplicate", "Fraudulent", "RequestedByCustomer", "Abandoned", "FailedInvoice", "VoidInvoice", "Automatic", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntent.kt */
    public enum CancellationReason {
        Duplicate("duplicate"),
        Fraudulent("fraudulent"),
        RequestedByCustomer("requested_by_customer"),
        Abandoned("abandoned"),
        FailedInvoice("failed_invoice"),
        VoidInvoice("void_invoice"),
        Automatic("automatic");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String code;

        private CancellationReason(String str) {
            this.code = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$CancellationReason$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/PaymentIntent$CancellationReason;", "code", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentIntent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CancellationReason fromCode(String str) {
                CancellationReason[] values = CancellationReason.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    CancellationReason cancellationReason = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) cancellationReason.code, (Object) str)) {
                        return cancellationReason;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$CaptureMethod;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "Automatic", "Manual", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntent.kt */
    public enum CaptureMethod {
        Automatic("automatic"),
        Manual("manual");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String code;

        private CaptureMethod(String str) {
            this.code = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$CaptureMethod$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/PaymentIntent$CaptureMethod;", "code", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentIntent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CaptureMethod fromCode(String str) {
                CaptureMethod captureMethod;
                CaptureMethod[] values = CaptureMethod.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        captureMethod = null;
                        break;
                    }
                    captureMethod = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) captureMethod.code, (Object) str)) {
                        break;
                    }
                }
                return captureMethod == null ? CaptureMethod.Automatic : captureMethod;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$ConfirmationMethod;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "Automatic", "Manual", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntent.kt */
    public enum ConfirmationMethod {
        Automatic("automatic"),
        Manual("manual");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String code;

        private ConfirmationMethod(String str) {
            this.code = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$ConfirmationMethod$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/PaymentIntent$ConfirmationMethod;", "code", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentIntent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ConfirmationMethod fromCode(String str) {
                ConfirmationMethod confirmationMethod;
                ConfirmationMethod[] values = ConfirmationMethod.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        confirmationMethod = null;
                        break;
                    }
                    confirmationMethod = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) confirmationMethod.code, (Object) str)) {
                        break;
                    }
                }
                return confirmationMethod == null ? ConfirmationMethod.Automatic : confirmationMethod;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/PaymentIntent$Companion;", "", "()V", "fromJson", "Lcom/stripe/android/model/PaymentIntent;", "jsonObject", "Lorg/json/JSONObject;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PaymentIntent fromJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new PaymentIntentJsonParser().parse(jSONObject);
        }
    }
}

package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.parsers.SetupIntentJsonParser;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 X2\u00020\u0001:\u0004VWXYB\u0001\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u000bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003Jµ\u0001\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\t\u0010H\u001a\u00020IHÖ\u0001J\u0013\u0010J\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020IHÖ\u0001J\b\u0010N\u001a\u00020\u000bH\u0016J\b\u0010O\u001a\u00020\u000bH\u0016J\t\u0010P\u001a\u00020\u0003HÖ\u0001J\u0019\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020IHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010$R\u0016\u0010%\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\u0004\u0018\u00010,8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006Z"}, d2 = {"Lcom/stripe/android/model/SetupIntent;", "Lcom/stripe/android/model/StripeIntent;", "id", "", "cancellationReason", "Lcom/stripe/android/model/SetupIntent$CancellationReason;", "created", "", "clientSecret", "description", "isLiveMode", "", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "paymentMethodId", "paymentMethodTypes", "", "status", "Lcom/stripe/android/model/StripeIntent$Status;", "usage", "Lcom/stripe/android/model/StripeIntent$Usage;", "lastSetupError", "Lcom/stripe/android/model/SetupIntent$Error;", "unactivatedPaymentMethods", "nextActionData", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "(Ljava/lang/String;Lcom/stripe/android/model/SetupIntent$CancellationReason;JLjava/lang/String;Ljava/lang/String;ZLcom/stripe/android/model/PaymentMethod;Ljava/lang/String;Ljava/util/List;Lcom/stripe/android/model/StripeIntent$Status;Lcom/stripe/android/model/StripeIntent$Usage;Lcom/stripe/android/model/SetupIntent$Error;Ljava/util/List;Lcom/stripe/android/model/StripeIntent$NextActionData;)V", "getCancellationReason", "()Lcom/stripe/android/model/SetupIntent$CancellationReason;", "getClientSecret", "()Ljava/lang/String;", "getCreated", "()J", "getDescription", "getId", "isConfirmed", "()Z", "lastErrorMessage", "getLastErrorMessage", "getLastSetupError", "()Lcom/stripe/android/model/SetupIntent$Error;", "getNextActionData", "()Lcom/stripe/android/model/StripeIntent$NextActionData;", "nextActionType", "Lcom/stripe/android/model/StripeIntent$NextActionType;", "getNextActionType", "()Lcom/stripe/android/model/StripeIntent$NextActionType;", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "getPaymentMethodId", "getPaymentMethodTypes", "()Ljava/util/List;", "getStatus", "()Lcom/stripe/android/model/StripeIntent$Status;", "getUnactivatedPaymentMethods", "getUsage", "()Lcom/stripe/android/model/StripeIntent$Usage;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "requiresAction", "requiresConfirmation", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CancellationReason", "ClientSecret", "Companion", "Error", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SetupIntent.kt */
public final class SetupIntent implements StripeIntent {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SetupIntent> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CancellationReason cancellationReason;
    private final String clientSecret;
    private final long created;
    private final String description;
    private final String id;
    private final boolean isLiveMode;
    private final Error lastSetupError;
    private final StripeIntent.NextActionData nextActionData;
    private final PaymentMethod paymentMethod;
    private final String paymentMethodId;
    private final List<String> paymentMethodTypes;
    private final StripeIntent.Status status;
    private final List<String> unactivatedPaymentMethods;
    private final StripeIntent.Usage usage;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SetupIntent.kt */
    public static final class Creator implements Parcelable.Creator<SetupIntent> {
        public final SetupIntent createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            Error error = null;
            CancellationReason valueOf = parcel.readInt() == 0 ? null : CancellationReason.valueOf(parcel.readString());
            long readLong = parcel.readLong();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            PaymentMethod createFromParcel = parcel.readInt() == 0 ? null : PaymentMethod.CREATOR.createFromParcel(parcel2);
            String readString4 = parcel.readString();
            List createStringArrayList = parcel.createStringArrayList();
            StripeIntent.Status valueOf2 = parcel.readInt() == 0 ? null : StripeIntent.Status.valueOf(parcel.readString());
            StripeIntent.Usage valueOf3 = parcel.readInt() == 0 ? null : StripeIntent.Usage.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                error = Error.CREATOR.createFromParcel(parcel2);
            }
            return new SetupIntent(readString, valueOf, readLong, readString2, readString3, z, createFromParcel, readString4, createStringArrayList, valueOf2, valueOf3, error, parcel.createStringArrayList(), (StripeIntent.NextActionData) parcel2.readParcelable(SetupIntent.class.getClassLoader()));
        }

        public final SetupIntent[] newArray(int i) {
            return new SetupIntent[i];
        }
    }

    public static /* synthetic */ SetupIntent copy$default(SetupIntent setupIntent, String str, CancellationReason cancellationReason2, long j, String str2, String str3, boolean z, PaymentMethod paymentMethod2, String str4, List list, StripeIntent.Status status2, StripeIntent.Usage usage2, Error error, List list2, StripeIntent.NextActionData nextActionData2, int i, Object obj) {
        SetupIntent setupIntent2 = setupIntent;
        int i2 = i;
        return setupIntent.copy((i2 & 1) != 0 ? setupIntent.getId() : str, (i2 & 2) != 0 ? setupIntent2.cancellationReason : cancellationReason2, (i2 & 4) != 0 ? setupIntent.getCreated() : j, (i2 & 8) != 0 ? setupIntent.getClientSecret() : str2, (i2 & 16) != 0 ? setupIntent.getDescription() : str3, (i2 & 32) != 0 ? setupIntent.isLiveMode() : z, (i2 & 64) != 0 ? setupIntent.getPaymentMethod() : paymentMethod2, (i2 & 128) != 0 ? setupIntent.getPaymentMethodId() : str4, (i2 & 256) != 0 ? setupIntent.getPaymentMethodTypes() : list, (i2 & 512) != 0 ? setupIntent.getStatus() : status2, (i2 & 1024) != 0 ? setupIntent2.usage : usage2, (i2 & 2048) != 0 ? setupIntent2.lastSetupError : error, (i2 & 4096) != 0 ? setupIntent.getUnactivatedPaymentMethods() : list2, (i2 & 8192) != 0 ? setupIntent.getNextActionData() : nextActionData2);
    }

    @JvmStatic
    public static final SetupIntent fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    public final String component1() {
        return getId();
    }

    public final StripeIntent.Status component10() {
        return getStatus();
    }

    public final StripeIntent.Usage component11() {
        return this.usage;
    }

    public final Error component12() {
        return this.lastSetupError;
    }

    public final List<String> component13() {
        return getUnactivatedPaymentMethods();
    }

    public final StripeIntent.NextActionData component14() {
        return getNextActionData();
    }

    public final CancellationReason component2() {
        return this.cancellationReason;
    }

    public final long component3() {
        return getCreated();
    }

    public final String component4() {
        return getClientSecret();
    }

    public final String component5() {
        return getDescription();
    }

    public final boolean component6() {
        return isLiveMode();
    }

    public final PaymentMethod component7() {
        return getPaymentMethod();
    }

    public final String component8() {
        return getPaymentMethodId();
    }

    public final List<String> component9() {
        return getPaymentMethodTypes();
    }

    public final SetupIntent copy(String str, CancellationReason cancellationReason2, long j, String str2, String str3, boolean z, PaymentMethod paymentMethod2, String str4, List<String> list, StripeIntent.Status status2, StripeIntent.Usage usage2, Error error, List<String> list2, StripeIntent.NextActionData nextActionData2) {
        List<String> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "paymentMethodTypes");
        List<String> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "unactivatedPaymentMethods");
        return new SetupIntent(str, cancellationReason2, j, str2, str3, z, paymentMethod2, str4, list3, status2, usage2, error, list4, nextActionData2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetupIntent)) {
            return false;
        }
        SetupIntent setupIntent = (SetupIntent) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) setupIntent.getId()) && this.cancellationReason == setupIntent.cancellationReason && getCreated() == setupIntent.getCreated() && Intrinsics.areEqual((Object) getClientSecret(), (Object) setupIntent.getClientSecret()) && Intrinsics.areEqual((Object) getDescription(), (Object) setupIntent.getDescription()) && isLiveMode() == setupIntent.isLiveMode() && Intrinsics.areEqual((Object) getPaymentMethod(), (Object) setupIntent.getPaymentMethod()) && Intrinsics.areEqual((Object) getPaymentMethodId(), (Object) setupIntent.getPaymentMethodId()) && Intrinsics.areEqual((Object) getPaymentMethodTypes(), (Object) setupIntent.getPaymentMethodTypes()) && getStatus() == setupIntent.getStatus() && this.usage == setupIntent.usage && Intrinsics.areEqual((Object) this.lastSetupError, (Object) setupIntent.lastSetupError) && Intrinsics.areEqual((Object) getUnactivatedPaymentMethods(), (Object) setupIntent.getUnactivatedPaymentMethods()) && Intrinsics.areEqual((Object) getNextActionData(), (Object) setupIntent.getNextActionData());
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (getId() == null ? 0 : getId().hashCode()) * 31;
        CancellationReason cancellationReason2 = this.cancellationReason;
        int hashCode2 = (((((((hashCode + (cancellationReason2 == null ? 0 : cancellationReason2.hashCode())) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(getCreated())) * 31) + (getClientSecret() == null ? 0 : getClientSecret().hashCode())) * 31) + (getDescription() == null ? 0 : getDescription().hashCode())) * 31;
        boolean isLiveMode2 = isLiveMode();
        if (isLiveMode2) {
            isLiveMode2 = true;
        }
        int hashCode3 = (((((((((hashCode2 + (isLiveMode2 ? 1 : 0)) * 31) + (getPaymentMethod() == null ? 0 : getPaymentMethod().hashCode())) * 31) + (getPaymentMethodId() == null ? 0 : getPaymentMethodId().hashCode())) * 31) + getPaymentMethodTypes().hashCode()) * 31) + (getStatus() == null ? 0 : getStatus().hashCode())) * 31;
        StripeIntent.Usage usage2 = this.usage;
        int hashCode4 = (hashCode3 + (usage2 == null ? 0 : usage2.hashCode())) * 31;
        Error error = this.lastSetupError;
        int hashCode5 = (((hashCode4 + (error == null ? 0 : error.hashCode())) * 31) + getUnactivatedPaymentMethods().hashCode()) * 31;
        if (getNextActionData() != null) {
            i = getNextActionData().hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "SetupIntent(id=" + getId() + ", cancellationReason=" + this.cancellationReason + ", created=" + getCreated() + ", clientSecret=" + getClientSecret() + ", description=" + getDescription() + ", isLiveMode=" + isLiveMode() + ", paymentMethod=" + getPaymentMethod() + ", paymentMethodId=" + getPaymentMethodId() + ", paymentMethodTypes=" + getPaymentMethodTypes() + ", status=" + getStatus() + ", usage=" + this.usage + ", lastSetupError=" + this.lastSetupError + ", unactivatedPaymentMethods=" + getUnactivatedPaymentMethods() + ", nextActionData=" + getNextActionData() + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        CancellationReason cancellationReason2 = this.cancellationReason;
        if (cancellationReason2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(cancellationReason2.name());
        }
        parcel.writeLong(this.created);
        parcel.writeString(this.clientSecret);
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
        parcel.writeStringList(this.paymentMethodTypes);
        StripeIntent.Status status2 = this.status;
        if (status2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(status2.name());
        }
        StripeIntent.Usage usage2 = this.usage;
        if (usage2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(usage2.name());
        }
        Error error = this.lastSetupError;
        if (error == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            error.writeToParcel(parcel, i);
        }
        parcel.writeStringList(this.unactivatedPaymentMethods);
        parcel.writeParcelable(this.nextActionData, i);
    }

    public SetupIntent(String str, CancellationReason cancellationReason2, long j, String str2, String str3, boolean z, PaymentMethod paymentMethod2, String str4, List<String> list, StripeIntent.Status status2, StripeIntent.Usage usage2, Error error, List<String> list2, StripeIntent.NextActionData nextActionData2) {
        List<String> list3 = list2;
        Intrinsics.checkNotNullParameter(list, "paymentMethodTypes");
        Intrinsics.checkNotNullParameter(list3, "unactivatedPaymentMethods");
        this.id = str;
        this.cancellationReason = cancellationReason2;
        this.created = j;
        this.clientSecret = str2;
        this.description = str3;
        this.isLiveMode = z;
        this.paymentMethod = paymentMethod2;
        this.paymentMethodId = str4;
        this.paymentMethodTypes = list;
        this.status = status2;
        this.usage = usage2;
        this.lastSetupError = error;
        this.unactivatedPaymentMethods = list3;
        this.nextActionData = nextActionData2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SetupIntent(java.lang.String r20, com.stripe.android.model.SetupIntent.CancellationReason r21, long r22, java.lang.String r24, java.lang.String r25, boolean r26, com.stripe.android.model.PaymentMethod r27, java.lang.String r28, java.util.List r29, com.stripe.android.model.StripeIntent.Status r30, com.stripe.android.model.StripeIntent.Usage r31, com.stripe.android.model.SetupIntent.Error r32, java.util.List r33, com.stripe.android.model.StripeIntent.NextActionData r34, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
        /*
            r19 = this;
            r0 = r35
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r11 = r2
            goto L_0x000b
        L_0x0009:
            r11 = r27
        L_0x000b:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0012
            r16 = r2
            goto L_0x0014
        L_0x0012:
            r16 = r32
        L_0x0014:
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r8 = r24
            r9 = r25
            r10 = r26
            r12 = r28
            r13 = r29
            r14 = r30
            r15 = r31
            r17 = r33
            r18 = r34
            r3.<init>(r4, r5, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.SetupIntent.<init>(java.lang.String, com.stripe.android.model.SetupIntent$CancellationReason, long, java.lang.String, java.lang.String, boolean, com.stripe.android.model.PaymentMethod, java.lang.String, java.util.List, com.stripe.android.model.StripeIntent$Status, com.stripe.android.model.StripeIntent$Usage, com.stripe.android.model.SetupIntent$Error, java.util.List, com.stripe.android.model.StripeIntent$NextActionData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public String getId() {
        return this.id;
    }

    public final CancellationReason getCancellationReason() {
        return this.cancellationReason;
    }

    public long getCreated() {
        return this.created;
    }

    public String getClientSecret() {
        return this.clientSecret;
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

    public List<String> getPaymentMethodTypes() {
        return this.paymentMethodTypes;
    }

    public StripeIntent.Status getStatus() {
        return this.status;
    }

    public final StripeIntent.Usage getUsage() {
        return this.usage;
    }

    public final Error getLastSetupError() {
        return this.lastSetupError;
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
        return CollectionsKt.contains(SetsKt.setOf(StripeIntent.Status.Processing, StripeIntent.Status.Succeeded), getStatus());
    }

    public String getLastErrorMessage() {
        Error error = this.lastSetupError;
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

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 ,2\u00020\u0001:\u0002,-BM\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003J]\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020 HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020 HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006."}, d2 = {"Lcom/stripe/android/model/SetupIntent$Error;", "Lcom/stripe/android/core/model/StripeModel;", "code", "", "declineCode", "docUrl", "message", "param", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "type", "Lcom/stripe/android/model/SetupIntent$Error$Type;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/PaymentMethod;Lcom/stripe/android/model/SetupIntent$Error$Type;)V", "getCode", "()Ljava/lang/String;", "getDeclineCode", "getDocUrl", "getMessage", "getParam", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "getType", "()Lcom/stripe/android/model/SetupIntent$Error$Type;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Type", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SetupIntent.kt */
    public static final class Error implements StripeModel {
        public static final int $stable = 8;
        public static final String CODE_AUTHENTICATION_ERROR = "setup_intent_authentication_failure";
        public static final Parcelable.Creator<Error> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String code;
        private final String declineCode;
        private final String docUrl;
        private final String message;
        private final String param;
        private final PaymentMethod paymentMethod;
        private final Type type;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SetupIntent.kt */
        public static final class Creator implements Parcelable.Creator<Error> {
            public final Error createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Error(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : PaymentMethod.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Type.valueOf(parcel.readString()));
            }

            public final Error[] newArray(int i) {
                return new Error[i];
            }
        }

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, String str3, String str4, String str5, PaymentMethod paymentMethod2, Type type2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.code;
            }
            if ((i & 2) != 0) {
                str2 = error.declineCode;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = error.docUrl;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = error.message;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = error.param;
            }
            String str9 = str5;
            if ((i & 32) != 0) {
                paymentMethod2 = error.paymentMethod;
            }
            PaymentMethod paymentMethod3 = paymentMethod2;
            if ((i & 64) != 0) {
                type2 = error.type;
            }
            return error.copy(str, str6, str7, str8, str9, paymentMethod3, type2);
        }

        public final String component1() {
            return this.code;
        }

        public final String component2() {
            return this.declineCode;
        }

        public final String component3() {
            return this.docUrl;
        }

        public final String component4() {
            return this.message;
        }

        public final String component5() {
            return this.param;
        }

        public final PaymentMethod component6() {
            return this.paymentMethod;
        }

        public final Type component7() {
            return this.type;
        }

        public final Error copy(String str, String str2, String str3, String str4, String str5, PaymentMethod paymentMethod2, Type type2) {
            return new Error(str, str2, str3, str4, str5, paymentMethod2, type2);
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
            return Intrinsics.areEqual((Object) this.code, (Object) error.code) && Intrinsics.areEqual((Object) this.declineCode, (Object) error.declineCode) && Intrinsics.areEqual((Object) this.docUrl, (Object) error.docUrl) && Intrinsics.areEqual((Object) this.message, (Object) error.message) && Intrinsics.areEqual((Object) this.param, (Object) error.param) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) error.paymentMethod) && this.type == error.type;
        }

        public int hashCode() {
            String str = this.code;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.declineCode;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.docUrl;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.message;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.param;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            PaymentMethod paymentMethod2 = this.paymentMethod;
            int hashCode6 = (hashCode5 + (paymentMethod2 == null ? 0 : paymentMethod2.hashCode())) * 31;
            Type type2 = this.type;
            if (type2 != null) {
                i = type2.hashCode();
            }
            return hashCode6 + i;
        }

        public String toString() {
            return "Error(code=" + this.code + ", declineCode=" + this.declineCode + ", docUrl=" + this.docUrl + ", message=" + this.message + ", param=" + this.param + ", paymentMethod=" + this.paymentMethod + ", type=" + this.type + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
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

        public Error(String str, String str2, String str3, String str4, String str5, PaymentMethod paymentMethod2, Type type2) {
            this.code = str;
            this.declineCode = str2;
            this.docUrl = str3;
            this.message = str4;
            this.param = str5;
            this.paymentMethod = paymentMethod2;
            this.type = type2;
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/model/SetupIntent$Error$Type;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "ApiConnectionError", "ApiError", "AuthenticationError", "CardError", "IdempotencyError", "InvalidRequestError", "RateLimitError", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SetupIntent.kt */
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

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/SetupIntent$Error$Type$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/SetupIntent$Error$Type;", "typeCode", "", "fromCode$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SetupIntent.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Type fromCode$payments_core_release(String str) {
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/SetupIntent$Error$Companion;", "", "()V", "CODE_AUTHENTICATION_ERROR", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SetupIntent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\nJ\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/model/SetupIntent$ClientSecret;", "", "value", "", "(Ljava/lang/String;)V", "setupIntentId", "getSetupIntentId$payments_core_release", "()Ljava/lang/String;", "getValue$payments_core_release", "component1", "component1$payments_core_release", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SetupIntent.kt */
    public static final class ClientSecret {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final Pattern PATTERN = Pattern.compile("^seti_[^_]+_secret_[^_]+$");
        private final String setupIntentId;
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
                r4.setupIntentId = r5
                com.stripe.android.model.SetupIntent$ClientSecret$Companion r5 = Companion
                java.lang.String r0 = r4.value
                boolean r5 = r5.isMatch(r0)
                if (r5 == 0) goto L_0x006e
                return
            L_0x006e:
                java.lang.String r5 = r4.getValue$payments_core_release()
                java.lang.String r0 = "Invalid Setup Intent client secret: "
                java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r5)
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r5 = r5.toString()
                r0.<init>(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.SetupIntent.ClientSecret.<init>(java.lang.String):void");
        }

        public final String getValue$payments_core_release() {
            return this.value;
        }

        public final String getSetupIntentId$payments_core_release() {
            return this.setupIntentId;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/SetupIntent$ClientSecret$Companion;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "isMatch", "", "value", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SetupIntent.kt */
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/SetupIntent$CancellationReason;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "Duplicate", "RequestedByCustomer", "Abandoned", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SetupIntent.kt */
    public enum CancellationReason {
        Duplicate("duplicate"),
        RequestedByCustomer("requested_by_customer"),
        Abandoned("abandoned");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String code;

        private CancellationReason(String str) {
            this.code = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/SetupIntent$CancellationReason$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/SetupIntent$CancellationReason;", "code", "", "fromCode$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SetupIntent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CancellationReason fromCode$payments_core_release(String str) {
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/SetupIntent$Companion;", "", "()V", "fromJson", "Lcom/stripe/android/model/SetupIntent;", "jsonObject", "Lorg/json/JSONObject;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SetupIntent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SetupIntent fromJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new SetupIntentJsonParser().parse(jSONObject);
        }
    }
}

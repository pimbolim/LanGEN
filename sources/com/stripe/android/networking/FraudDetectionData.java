package com.stripe.android.networking;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0014J\u000e\u0010\u0015\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0018J\u000e\u0010\u0019\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u001aJ1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020&J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006."}, d2 = {"Lcom/stripe/android/networking/FraudDetectionData;", "Lcom/stripe/android/core/model/StripeModel;", "guid", "", "muid", "sid", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getGuid$payments_core_release", "()Ljava/lang/String;", "getMuid$payments_core_release", "params", "", "getParams", "()Ljava/util/Map;", "getSid$payments_core_release", "getTimestamp$payments_core_release", "()J", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isExpired", "currentTime", "toJson", "Lorg/json/JSONObject;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FraudDetectionData.kt */
public final class FraudDetectionData implements StripeModel {
    public static final Parcelable.Creator<FraudDetectionData> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_GUID = "guid";
    private static final String KEY_MUID = "muid";
    private static final String KEY_SID = "sid";
    public static final String KEY_TIMESTAMP = "timestamp";
    private static final long TTL = TimeUnit.MINUTES.toMillis(30);
    private final String guid;
    private final String muid;
    private final String sid;
    private final long timestamp;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FraudDetectionData.kt */
    public static final class Creator implements Parcelable.Creator<FraudDetectionData> {
        public final FraudDetectionData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FraudDetectionData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        public final FraudDetectionData[] newArray(int i) {
            return new FraudDetectionData[i];
        }
    }

    public static /* synthetic */ FraudDetectionData copy$default(FraudDetectionData fraudDetectionData, String str, String str2, String str3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fraudDetectionData.guid;
        }
        if ((i & 2) != 0) {
            str2 = fraudDetectionData.muid;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = fraudDetectionData.sid;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            j = fraudDetectionData.timestamp;
        }
        return fraudDetectionData.copy(str, str4, str5, j);
    }

    public final String component1$payments_core_release() {
        return this.guid;
    }

    public final String component2$payments_core_release() {
        return this.muid;
    }

    public final String component3$payments_core_release() {
        return this.sid;
    }

    public final long component4$payments_core_release() {
        return this.timestamp;
    }

    public final FraudDetectionData copy(String str, String str2, String str3, long j) {
        Intrinsics.checkNotNullParameter(str, KEY_GUID);
        Intrinsics.checkNotNullParameter(str2, KEY_MUID);
        Intrinsics.checkNotNullParameter(str3, KEY_SID);
        return new FraudDetectionData(str, str2, str3, j);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FraudDetectionData)) {
            return false;
        }
        FraudDetectionData fraudDetectionData = (FraudDetectionData) obj;
        return Intrinsics.areEqual((Object) this.guid, (Object) fraudDetectionData.guid) && Intrinsics.areEqual((Object) this.muid, (Object) fraudDetectionData.muid) && Intrinsics.areEqual((Object) this.sid, (Object) fraudDetectionData.sid) && this.timestamp == fraudDetectionData.timestamp;
    }

    public int hashCode() {
        return (((((this.guid.hashCode() * 31) + this.muid.hashCode()) * 31) + this.sid.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.timestamp);
    }

    public String toString() {
        return "FraudDetectionData(guid=" + this.guid + ", muid=" + this.muid + ", sid=" + this.sid + ", timestamp=" + this.timestamp + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.guid);
        parcel.writeString(this.muid);
        parcel.writeString(this.sid);
        parcel.writeLong(this.timestamp);
    }

    public FraudDetectionData(String str, String str2, String str3, long j) {
        Intrinsics.checkNotNullParameter(str, KEY_GUID);
        Intrinsics.checkNotNullParameter(str2, KEY_MUID);
        Intrinsics.checkNotNullParameter(str3, KEY_SID);
        this.guid = str;
        this.muid = str2;
        this.sid = str3;
        this.timestamp = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FraudDetectionData(String str, String str2, String str3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? 0 : j);
    }

    public final String getGuid$payments_core_release() {
        return this.guid;
    }

    public final String getMuid$payments_core_release() {
        return this.muid;
    }

    public final String getSid$payments_core_release() {
        return this.sid;
    }

    public final long getTimestamp$payments_core_release() {
        return this.timestamp;
    }

    public final Map<String, String> getParams() {
        return MapsKt.mapOf(TuplesKt.to(KEY_GUID, this.guid), TuplesKt.to(KEY_MUID, this.muid), TuplesKt.to(KEY_SID, this.sid));
    }

    public final JSONObject toJson() {
        JSONObject put = new JSONObject().put(KEY_GUID, this.guid).put(KEY_MUID, this.muid).put(KEY_SID, this.sid).put("timestamp", this.timestamp);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …KEY_TIMESTAMP, timestamp)");
        return put;
    }

    public final boolean isExpired(long j) {
        return j - this.timestamp > TTL;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/networking/FraudDetectionData$Companion;", "", "()V", "KEY_GUID", "", "KEY_MUID", "KEY_SID", "KEY_TIMESTAMP", "TTL", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FraudDetectionData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

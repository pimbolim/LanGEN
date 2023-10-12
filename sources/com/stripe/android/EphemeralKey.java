package com.stripe.android;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u000e\u0010\u0019\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001aJ\u000e\u0010\u001b\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u001cJ\u000e\u0010\u001d\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b J\u000e\u0010!\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b\"J\u000e\u0010#\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b$J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000e\u0010&\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b'JY\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001J\u0013\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020*HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020*HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u00065"}, d2 = {"Lcom/stripe/android/EphemeralKey;", "Lcom/stripe/android/core/model/StripeModel;", "objectId", "", "created", "", "expires", "id", "isLiveMode", "", "objectType", "secret", "type", "(Ljava/lang/String;JJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreated$payments_core_release", "()J", "getExpires$payments_core_release", "getId$payments_core_release", "()Ljava/lang/String;", "isLiveMode$payments_core_release", "()Z", "getObjectId$payments_core_release", "getObjectType$payments_core_release", "getSecret", "getType$payments_core_release", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "component6", "component6$payments_core_release", "component7", "component8", "component8$payments_core_release", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EphemeralKey.kt */
public final class EphemeralKey implements StripeModel {
    public static final int $stable = 8;
    public static final Parcelable.Creator<EphemeralKey> CREATOR = new Creator();
    private final long created;
    private final long expires;
    private final String id;
    private final boolean isLiveMode;
    private final String objectId;
    private final String objectType;
    private final String secret;
    private final String type;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EphemeralKey.kt */
    public static final class Creator implements Parcelable.Creator<EphemeralKey> {
        public final EphemeralKey createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EphemeralKey(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final EphemeralKey[] newArray(int i) {
            return new EphemeralKey[i];
        }
    }

    public static /* synthetic */ EphemeralKey copy$default(EphemeralKey ephemeralKey, String str, long j, long j2, String str2, boolean z, String str3, String str4, String str5, int i, Object obj) {
        EphemeralKey ephemeralKey2 = ephemeralKey;
        int i2 = i;
        return ephemeralKey.copy((i2 & 1) != 0 ? ephemeralKey2.objectId : str, (i2 & 2) != 0 ? ephemeralKey2.created : j, (i2 & 4) != 0 ? ephemeralKey2.expires : j2, (i2 & 8) != 0 ? ephemeralKey2.id : str2, (i2 & 16) != 0 ? ephemeralKey2.isLiveMode : z, (i2 & 32) != 0 ? ephemeralKey2.objectType : str3, (i2 & 64) != 0 ? ephemeralKey2.secret : str4, (i2 & 128) != 0 ? ephemeralKey2.type : str5);
    }

    public final String component1$payments_core_release() {
        return this.objectId;
    }

    public final long component2$payments_core_release() {
        return this.created;
    }

    public final long component3$payments_core_release() {
        return this.expires;
    }

    public final String component4$payments_core_release() {
        return this.id;
    }

    public final boolean component5$payments_core_release() {
        return this.isLiveMode;
    }

    public final String component6$payments_core_release() {
        return this.objectType;
    }

    public final String component7() {
        return this.secret;
    }

    public final String component8$payments_core_release() {
        return this.type;
    }

    public final EphemeralKey copy(String str, long j, long j2, String str2, boolean z, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "objectId");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str6, MessageExtension.FIELD_ID);
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "objectType");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "secret");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "type");
        return new EphemeralKey(str, j, j2, str6, z, str7, str8, str9);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EphemeralKey)) {
            return false;
        }
        EphemeralKey ephemeralKey = (EphemeralKey) obj;
        return Intrinsics.areEqual((Object) this.objectId, (Object) ephemeralKey.objectId) && this.created == ephemeralKey.created && this.expires == ephemeralKey.expires && Intrinsics.areEqual((Object) this.id, (Object) ephemeralKey.id) && this.isLiveMode == ephemeralKey.isLiveMode && Intrinsics.areEqual((Object) this.objectType, (Object) ephemeralKey.objectType) && Intrinsics.areEqual((Object) this.secret, (Object) ephemeralKey.secret) && Intrinsics.areEqual((Object) this.type, (Object) ephemeralKey.type);
    }

    public int hashCode() {
        int hashCode = ((((((this.objectId.hashCode() * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.created)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.expires)) * 31) + this.id.hashCode()) * 31;
        boolean z = this.isLiveMode;
        if (z) {
            z = true;
        }
        return ((((((hashCode + (z ? 1 : 0)) * 31) + this.objectType.hashCode()) * 31) + this.secret.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "EphemeralKey(objectId=" + this.objectId + ", created=" + this.created + ", expires=" + this.expires + ", id=" + this.id + ", isLiveMode=" + this.isLiveMode + ", objectType=" + this.objectType + ", secret=" + this.secret + ", type=" + this.type + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.objectId);
        parcel.writeLong(this.created);
        parcel.writeLong(this.expires);
        parcel.writeString(this.id);
        parcel.writeInt(this.isLiveMode ? 1 : 0);
        parcel.writeString(this.objectType);
        parcel.writeString(this.secret);
        parcel.writeString(this.type);
    }

    public EphemeralKey(String str, long j, long j2, String str2, boolean z, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "objectId");
        Intrinsics.checkNotNullParameter(str2, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str3, "objectType");
        Intrinsics.checkNotNullParameter(str4, "secret");
        Intrinsics.checkNotNullParameter(str5, "type");
        this.objectId = str;
        this.created = j;
        this.expires = j2;
        this.id = str2;
        this.isLiveMode = z;
        this.objectType = str3;
        this.secret = str4;
        this.type = str5;
    }

    public final String getObjectId$payments_core_release() {
        return this.objectId;
    }

    public final long getCreated$payments_core_release() {
        return this.created;
    }

    public final long getExpires$payments_core_release() {
        return this.expires;
    }

    public final String getId$payments_core_release() {
        return this.id;
    }

    public final boolean isLiveMode$payments_core_release() {
        return this.isLiveMode;
    }

    public final String getObjectType$payments_core_release() {
        return this.objectType;
    }

    public final String getSecret() {
        return this.secret;
    }

    public final String getType$payments_core_release() {
        return this.type;
    }
}

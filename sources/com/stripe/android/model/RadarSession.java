package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/model/RadarSession;", "Lcom/stripe/android/core/model/StripeModel;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RadarSession.kt */
public final class RadarSession implements StripeModel {
    public static final int $stable = 8;
    public static final Parcelable.Creator<RadarSession> CREATOR = new Creator();
    private final String id;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RadarSession.kt */
    public static final class Creator implements Parcelable.Creator<RadarSession> {
        public final RadarSession createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RadarSession(parcel.readString());
        }

        public final RadarSession[] newArray(int i) {
            return new RadarSession[i];
        }
    }

    public static /* synthetic */ RadarSession copy$default(RadarSession radarSession, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = radarSession.id;
        }
        return radarSession.copy(str);
    }

    public final String component1() {
        return this.id;
    }

    public final RadarSession copy(String str) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        return new RadarSession(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RadarSession) && Intrinsics.areEqual((Object) this.id, (Object) ((RadarSession) obj).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "RadarSession(id=" + this.id + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
    }

    public RadarSession(String str) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        this.id = str;
    }

    public final String getId() {
        return this.id;
    }
}

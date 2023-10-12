package com.stripe.android.stripe3ds2.init;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\rHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/HardwareId;", "Landroid/os/Parcelable;", "value", "", "(Ljava/lang/String;)V", "isPresent", "", "()Z", "getValue", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HardwareId.kt */
public final class HardwareId implements Parcelable {
    public static final Parcelable.Creator<HardwareId> CREATOR = new Creator();
    private final String value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HardwareId.kt */
    public static final class Creator implements Parcelable.Creator<HardwareId> {
        public final HardwareId createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new HardwareId(parcel.readString());
        }

        public final HardwareId[] newArray(int i) {
            return new HardwareId[i];
        }
    }

    public static /* synthetic */ HardwareId copy$default(HardwareId hardwareId, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hardwareId.value;
        }
        return hardwareId.copy(str);
    }

    public final String component1() {
        return this.value;
    }

    public final HardwareId copy(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new HardwareId(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HardwareId) && Intrinsics.areEqual((Object) this.value, (Object) ((HardwareId) obj).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "HardwareId(value=" + this.value + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.value);
    }

    public HardwareId(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean isPresent() {
        return this.value.length() > 0;
    }
}

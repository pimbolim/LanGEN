package com.stripe.android.stripe3ds2.init;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/AppInfo;", "Landroid/os/Parcelable;", "sdkAppId", "", "version", "", "(Ljava/lang/String;I)V", "getSdkAppId", "()Ljava/lang/String;", "getVersion", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppInfo.kt */
public final class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new Creator();
    private final String sdkAppId;
    private final int version;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AppInfo.kt */
    public static final class Creator implements Parcelable.Creator<AppInfo> {
        public final AppInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AppInfo(parcel.readString(), parcel.readInt());
        }

        public final AppInfo[] newArray(int i) {
            return new AppInfo[i];
        }
    }

    public static /* synthetic */ AppInfo copy$default(AppInfo appInfo, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = appInfo.sdkAppId;
        }
        if ((i2 & 2) != 0) {
            i = appInfo.version;
        }
        return appInfo.copy(str, i);
    }

    public final String component1() {
        return this.sdkAppId;
    }

    public final int component2() {
        return this.version;
    }

    public final AppInfo copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "sdkAppId");
        return new AppInfo(str, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInfo)) {
            return false;
        }
        AppInfo appInfo = (AppInfo) obj;
        return Intrinsics.areEqual((Object) this.sdkAppId, (Object) appInfo.sdkAppId) && this.version == appInfo.version;
    }

    public int hashCode() {
        return (this.sdkAppId.hashCode() * 31) + this.version;
    }

    public String toString() {
        return "AppInfo(sdkAppId=" + this.sdkAppId + ", version=" + this.version + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.sdkAppId);
        parcel.writeInt(this.version);
    }

    public AppInfo(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "sdkAppId");
        this.sdkAppId = str;
        this.version = i;
    }

    public final String getSdkAppId() {
        return this.sdkAppId;
    }

    public final int getVersion() {
        return this.version;
    }
}

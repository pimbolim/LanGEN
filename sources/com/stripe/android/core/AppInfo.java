package com.stripe.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J7\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J'\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e0\u000eH\u0000¢\u0006\u0002\b\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\r\u0010\u0018\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/stripe/android/core/AppInfo;", "Landroid/os/Parcelable;", "name", "", "version", "url", "partnerId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "createClientHeaders", "", "createClientHeaders$stripe_core_release", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "toUserAgent", "toUserAgent$stripe_core_release", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppInfo.kt */
public final class AppInfo implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<AppInfo> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String name;
    private final String partnerId;
    private final String url;
    private final String version;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AppInfo.kt */
    public static final class Creator implements Parcelable.Creator<AppInfo> {
        public final AppInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AppInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final AppInfo[] newArray(int i) {
            return new AppInfo[i];
        }
    }

    private final String component1() {
        return this.name;
    }

    private final String component2() {
        return this.version;
    }

    private final String component3() {
        return this.url;
    }

    private final String component4() {
        return this.partnerId;
    }

    public static /* synthetic */ AppInfo copy$default(AppInfo appInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appInfo.name;
        }
        if ((i & 2) != 0) {
            str2 = appInfo.version;
        }
        if ((i & 4) != 0) {
            str3 = appInfo.url;
        }
        if ((i & 8) != 0) {
            str4 = appInfo.partnerId;
        }
        return appInfo.copy(str, str2, str3, str4);
    }

    @JvmStatic
    public static final AppInfo create(String str) {
        return Companion.create(str);
    }

    @JvmStatic
    public static final AppInfo create(String str, String str2) {
        return Companion.create(str, str2);
    }

    @JvmStatic
    public static final AppInfo create(String str, String str2, String str3) {
        return Companion.create(str, str2, str3);
    }

    @JvmStatic
    public static final AppInfo create(String str, String str2, String str3, String str4) {
        return Companion.create(str, str2, str3, str4);
    }

    public final AppInfo copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new AppInfo(str, str2, str3, str4);
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
        return Intrinsics.areEqual((Object) this.name, (Object) appInfo.name) && Intrinsics.areEqual((Object) this.version, (Object) appInfo.version) && Intrinsics.areEqual((Object) this.url, (Object) appInfo.url) && Intrinsics.areEqual((Object) this.partnerId, (Object) appInfo.partnerId);
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.version;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.partnerId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "AppInfo(name=" + this.name + ", version=" + this.version + ", url=" + this.url + ", partnerId=" + this.partnerId + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.version);
        parcel.writeString(this.url);
        parcel.writeString(this.partnerId);
    }

    public AppInfo(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.version = str2;
        this.url = str3;
        this.partnerId = str4;
    }

    public final String toUserAgent$stripe_core_release() {
        String[] strArr = new String[3];
        strArr[0] = this.name;
        String str = this.version;
        String str2 = null;
        strArr[1] = str == null ? null : Intrinsics.stringPlus("/", str);
        String str3 = this.url;
        if (str3 != null) {
            str2 = " (" + str3 + ')';
        }
        strArr[2] = str2;
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((T[]) strArr), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final Map<String, Map<String, String>> createClientHeaders$stripe_core_release() {
        return MapsKt.mapOf(TuplesKt.to("application", MapsKt.mapOf(TuplesKt.to("name", this.name), TuplesKt.to("version", this.version), TuplesKt.to("url", this.url), TuplesKt.to("partner_id", this.partnerId))));
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/stripe/android/core/AppInfo$Companion;", "", "()V", "create", "Lcom/stripe/android/core/AppInfo;", "name", "", "version", "url", "partnerId", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AppInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AppInfo create(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return create$default(this, str, (String) null, (String) null, (String) null, 14, (Object) null);
        }

        @JvmStatic
        public final AppInfo create(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            return create$default(this, str, str2, (String) null, (String) null, 12, (Object) null);
        }

        @JvmStatic
        public final AppInfo create(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "name");
            return create$default(this, str, str2, str3, (String) null, 8, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ AppInfo create$default(Companion companion, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            return companion.create(str, str2, str3, str4);
        }

        @JvmStatic
        public final AppInfo create(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new AppInfo(str, str2, str3, str4);
        }
    }
}

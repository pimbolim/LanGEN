package com.stripe.android.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/core/model/CountryCode;", "Landroid/os/Parcelable;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CountryCode.kt */
public final class CountryCode implements Parcelable {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public static final CountryCode CA = new CountryCode("CA");
    public static final Parcelable.Creator<CountryCode> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final CountryCode GB = new CountryCode("GB");
    /* access modifiers changed from: private */
    public static final CountryCode US = new CountryCode("US");
    private final String value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CountryCode.kt */
    public static final class Creator implements Parcelable.Creator<CountryCode> {
        public final CountryCode createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CountryCode(parcel.readString());
        }

        public final CountryCode[] newArray(int i) {
            return new CountryCode[i];
        }
    }

    public static /* synthetic */ CountryCode copy$default(CountryCode countryCode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = countryCode.value;
        }
        return countryCode.copy(str);
    }

    public final String component1() {
        return this.value;
    }

    public final CountryCode copy(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new CountryCode(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CountryCode) && Intrinsics.areEqual((Object) this.value, (Object) ((CountryCode) obj).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "CountryCode(value=" + this.value + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.value);
    }

    public CountryCode(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/core/model/CountryCode$Companion;", "", "()V", "CA", "Lcom/stripe/android/core/model/CountryCode;", "getCA", "()Lcom/stripe/android/core/model/CountryCode;", "GB", "getGB", "US", "getUS", "create", "value", "", "isCA", "", "countryCode", "isGB", "isUS", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CountryCode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CountryCode getUS() {
            return CountryCode.US;
        }

        public final CountryCode getCA() {
            return CountryCode.CA;
        }

        public final CountryCode getGB() {
            return CountryCode.GB;
        }

        public final boolean isUS(CountryCode countryCode) {
            return Intrinsics.areEqual((Object) countryCode, (Object) getUS());
        }

        public final boolean isCA(CountryCode countryCode) {
            return Intrinsics.areEqual((Object) countryCode, (Object) getCA());
        }

        public final boolean isGB(CountryCode countryCode) {
            return Intrinsics.areEqual((Object) countryCode, (Object) getGB());
        }

        public final CountryCode create(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return new CountryCode(upperCase);
        }
    }
}

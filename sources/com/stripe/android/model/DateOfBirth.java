package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u0017H\u0016J\t\u0010\u0019\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006 "}, d2 = {"Lcom/stripe/android/model/DateOfBirth;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "day", "", "month", "year", "(III)V", "getDay", "()I", "getMonth", "getYear", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toParamMap", "", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DateOfBirth.kt */
public final class DateOfBirth implements StripeParamsModel, Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<DateOfBirth> CREATOR = new Creator();
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PARAM_DAY = "day";
    @Deprecated
    private static final String PARAM_MONTH = "month";
    @Deprecated
    private static final String PARAM_YEAR = "year";
    private final int day;
    private final int month;
    private final int year;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DateOfBirth.kt */
    public static final class Creator implements Parcelable.Creator<DateOfBirth> {
        public final DateOfBirth createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DateOfBirth(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        public final DateOfBirth[] newArray(int i) {
            return new DateOfBirth[i];
        }
    }

    public static /* synthetic */ DateOfBirth copy$default(DateOfBirth dateOfBirth, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = dateOfBirth.day;
        }
        if ((i4 & 2) != 0) {
            i2 = dateOfBirth.month;
        }
        if ((i4 & 4) != 0) {
            i3 = dateOfBirth.year;
        }
        return dateOfBirth.copy(i, i2, i3);
    }

    public final int component1() {
        return this.day;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.year;
    }

    public final DateOfBirth copy(int i, int i2, int i3) {
        return new DateOfBirth(i, i2, i3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateOfBirth)) {
            return false;
        }
        DateOfBirth dateOfBirth = (DateOfBirth) obj;
        return this.day == dateOfBirth.day && this.month == dateOfBirth.month && this.year == dateOfBirth.year;
    }

    public int hashCode() {
        return (((this.day * 31) + this.month) * 31) + this.year;
    }

    public String toString() {
        return "DateOfBirth(day=" + this.day + ", month=" + this.month + ", year=" + this.year + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.day);
        parcel.writeInt(this.month);
        parcel.writeInt(this.year);
    }

    public DateOfBirth(int i, int i2, int i3) {
        this.day = i;
        this.month = i2;
        this.year = i3;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getYear() {
        return this.year;
    }

    public Map<String, Object> toParamMap() {
        return MapsKt.mapOf(TuplesKt.to(PARAM_DAY, Integer.valueOf(this.day)), TuplesKt.to(PARAM_MONTH, Integer.valueOf(this.month)), TuplesKt.to(PARAM_YEAR, Integer.valueOf(this.year)));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/DateOfBirth$Companion;", "", "()V", "PARAM_DAY", "", "PARAM_MONTH", "PARAM_YEAR", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DateOfBirth.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

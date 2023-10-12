package com.stripe.android.ui.core;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.ui.core.CurrencyFormatter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/ui/core/Amount;", "Landroid/os/Parcelable;", "value", "", "currencyCode", "", "(JLjava/lang/String;)V", "getCurrencyCode", "()Ljava/lang/String;", "getValue", "()J", "buildPayButtonLabel", "resources", "Landroid/content/res/Resources;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Amount.kt */
public final class Amount implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<Amount> CREATOR = new Creator();
    private final String currencyCode;
    private final long value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Amount.kt */
    public static final class Creator implements Parcelable.Creator<Amount> {
        public final Amount createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Amount(parcel.readLong(), parcel.readString());
        }

        public final Amount[] newArray(int i) {
            return new Amount[i];
        }
    }

    public static /* synthetic */ Amount copy$default(Amount amount, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = amount.value;
        }
        if ((i & 2) != 0) {
            str = amount.currencyCode;
        }
        return amount.copy(j, str);
    }

    public final long component1() {
        return this.value;
    }

    public final String component2() {
        return this.currencyCode;
    }

    public final Amount copy(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "currencyCode");
        return new Amount(j, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Amount)) {
            return false;
        }
        Amount amount = (Amount) obj;
        return this.value == amount.value && Intrinsics.areEqual((Object) this.currencyCode, (Object) amount.currencyCode);
    }

    public int hashCode() {
        return (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.value) * 31) + this.currencyCode.hashCode();
    }

    public String toString() {
        return "Amount(value=" + this.value + ", currencyCode=" + this.currencyCode + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.value);
        parcel.writeString(this.currencyCode);
    }

    public Amount(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "currencyCode");
        this.value = j;
        this.currencyCode = str;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final long getValue() {
        return this.value;
    }

    public final String buildPayButtonLabel(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.stripe_pay_button_amount, new Object[]{CurrencyFormatter.Companion.format$default(CurrencyFormatter.Companion, this.value, this.currencyCode, (Locale) null, 4, (Object) null)});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …, currencyCode)\n        )");
        return string;
    }
}

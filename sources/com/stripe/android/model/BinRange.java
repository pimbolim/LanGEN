package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import com.stripe.android.cards.CardNumber;
import com.stripe.android.core.model.StripeModel;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/model/BinRange;", "Lcom/stripe/android/core/model/StripeModel;", "low", "", "high", "(Ljava/lang/String;Ljava/lang/String;)V", "getHigh", "()Ljava/lang/String;", "getLow", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "matches", "cardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BinRange.kt */
public final class BinRange implements StripeModel {
    public static final int $stable = 8;
    public static final Parcelable.Creator<BinRange> CREATOR = new Creator();
    private final String high;
    private final String low;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BinRange.kt */
    public static final class Creator implements Parcelable.Creator<BinRange> {
        public final BinRange createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BinRange(parcel.readString(), parcel.readString());
        }

        public final BinRange[] newArray(int i) {
            return new BinRange[i];
        }
    }

    public static /* synthetic */ BinRange copy$default(BinRange binRange, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = binRange.low;
        }
        if ((i & 2) != 0) {
            str2 = binRange.high;
        }
        return binRange.copy(str, str2);
    }

    public final String component1() {
        return this.low;
    }

    public final String component2() {
        return this.high;
    }

    public final BinRange copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_LOW);
        Intrinsics.checkNotNullParameter(str2, RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH);
        return new BinRange(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinRange)) {
            return false;
        }
        BinRange binRange = (BinRange) obj;
        return Intrinsics.areEqual((Object) this.low, (Object) binRange.low) && Intrinsics.areEqual((Object) this.high, (Object) binRange.high);
    }

    public int hashCode() {
        return (this.low.hashCode() * 31) + this.high.hashCode();
    }

    public String toString() {
        return "BinRange(low=" + this.low + ", high=" + this.high + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.low);
        parcel.writeString(this.high);
    }

    public BinRange(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_LOW);
        Intrinsics.checkNotNullParameter(str2, RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH);
        this.low = str;
        this.high = str2;
    }

    public final String getLow() {
        return this.low;
    }

    public final String getHigh() {
        return this.high;
    }

    public final boolean matches(CardNumber.Unvalidated unvalidated) {
        Intrinsics.checkNotNullParameter(unvalidated, "cardNumber");
        String normalized = unvalidated.getNormalized();
        BigDecimal bigDecimalOrNull = StringsKt.toBigDecimalOrNull(normalized);
        if (bigDecimalOrNull == null) {
            return false;
        }
        boolean z = normalized.length() >= this.low.length() ? new BigDecimal(StringsKt.take(normalized, this.low.length())).compareTo(new BigDecimal(this.low)) >= 0 : bigDecimalOrNull.compareTo(new BigDecimal(StringsKt.take(this.low, normalized.length()))) >= 0;
        boolean z2 = normalized.length() >= this.high.length() ? new BigDecimal(StringsKt.take(normalized, this.high.length())).compareTo(new BigDecimal(this.high)) <= 0 : bigDecimalOrNull.compareTo(new BigDecimal(StringsKt.take(this.high, normalized.length()))) <= 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}

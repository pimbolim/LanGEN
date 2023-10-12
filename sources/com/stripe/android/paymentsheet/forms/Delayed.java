package com.stripe.android.paymentsheet.forms;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/forms/Delayed;", "Lcom/stripe/android/paymentsheet/forms/PIRequirement;", "Lcom/stripe/android/paymentsheet/forms/SIRequirement;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodRequirements.kt */
public final class Delayed implements PIRequirement, SIRequirement {
    public static final Parcelable.Creator<Delayed> CREATOR = new Creator();
    public static final Delayed INSTANCE = new Delayed();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodRequirements.kt */
    public static final class Creator implements Parcelable.Creator<Delayed> {
        public final Delayed createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return Delayed.INSTANCE;
        }

        public final Delayed[] newArray(int i) {
            return new Delayed[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }

    private Delayed() {
    }
}

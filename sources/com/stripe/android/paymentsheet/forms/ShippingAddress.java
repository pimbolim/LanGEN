package com.stripe.android.paymentsheet.forms;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/forms/ShippingAddress;", "Lcom/stripe/android/paymentsheet/forms/PIRequirement;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodRequirements.kt */
public final class ShippingAddress implements PIRequirement {
    public static final Parcelable.Creator<ShippingAddress> CREATOR = new Creator();
    public static final ShippingAddress INSTANCE = new ShippingAddress();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodRequirements.kt */
    public static final class Creator implements Parcelable.Creator<ShippingAddress> {
        public final ShippingAddress createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return ShippingAddress.INSTANCE;
        }

        public final ShippingAddress[] newArray(int i) {
            return new ShippingAddress[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }

    private ShippingAddress() {
    }
}

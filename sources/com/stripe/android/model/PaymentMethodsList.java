package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/PaymentMethodsList;", "Lcom/stripe/android/core/model/StripeModel;", "paymentMethods", "", "Lcom/stripe/android/model/PaymentMethod;", "(Ljava/util/List;)V", "getPaymentMethods", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsList.kt */
public final class PaymentMethodsList implements StripeModel {
    public static final Parcelable.Creator<PaymentMethodsList> CREATOR = new Creator();
    private final List<PaymentMethod> paymentMethods;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsList.kt */
    public static final class Creator implements Parcelable.Creator<PaymentMethodsList> {
        public final PaymentMethodsList createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(PaymentMethod.CREATOR.createFromParcel(parcel));
            }
            return new PaymentMethodsList(arrayList);
        }

        public final PaymentMethodsList[] newArray(int i) {
            return new PaymentMethodsList[i];
        }
    }

    public static /* synthetic */ PaymentMethodsList copy$default(PaymentMethodsList paymentMethodsList, List<PaymentMethod> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = paymentMethodsList.paymentMethods;
        }
        return paymentMethodsList.copy(list);
    }

    public final List<PaymentMethod> component1() {
        return this.paymentMethods;
    }

    public final PaymentMethodsList copy(List<PaymentMethod> list) {
        Intrinsics.checkNotNullParameter(list, "paymentMethods");
        return new PaymentMethodsList(list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PaymentMethodsList) && Intrinsics.areEqual((Object) this.paymentMethods, (Object) ((PaymentMethodsList) obj).paymentMethods);
    }

    public int hashCode() {
        return this.paymentMethods.hashCode();
    }

    public String toString() {
        return "PaymentMethodsList(paymentMethods=" + this.paymentMethods + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<PaymentMethod> list = this.paymentMethods;
        parcel.writeInt(list.size());
        for (PaymentMethod writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i);
        }
    }

    public PaymentMethodsList(List<PaymentMethod> list) {
        Intrinsics.checkNotNullParameter(list, "paymentMethods");
        this.paymentMethods = list;
    }

    public final List<PaymentMethod> getPaymentMethods() {
        return this.paymentMethods;
    }
}

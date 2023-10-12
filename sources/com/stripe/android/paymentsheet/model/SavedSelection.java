package com.stripe.android.paymentsheet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SavedSelection;", "Landroid/os/Parcelable;", "()V", "GooglePay", "None", "PaymentMethod", "Lcom/stripe/android/paymentsheet/model/SavedSelection$GooglePay;", "Lcom/stripe/android/paymentsheet/model/SavedSelection$PaymentMethod;", "Lcom/stripe/android/paymentsheet/model/SavedSelection$None;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SavedSelection.kt */
public abstract class SavedSelection implements Parcelable {
    public /* synthetic */ SavedSelection(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SavedSelection() {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SavedSelection$GooglePay;", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SavedSelection.kt */
    public static final class GooglePay extends SavedSelection {
        public static final int $stable = 8;
        public static final Parcelable.Creator<GooglePay> CREATOR = new Creator();
        public static final GooglePay INSTANCE = new GooglePay();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SavedSelection.kt */
        public static final class Creator implements Parcelable.Creator<GooglePay> {
            public final GooglePay createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return GooglePay.INSTANCE;
            }

            public final GooglePay[] newArray(int i) {
                return new GooglePay[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private GooglePay() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SavedSelection$PaymentMethod;", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SavedSelection.kt */
    public static final class PaymentMethod extends SavedSelection {
        public static final int $stable = 8;
        public static final Parcelable.Creator<PaymentMethod> CREATOR = new Creator();
        private final String id;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SavedSelection.kt */
        public static final class Creator implements Parcelable.Creator<PaymentMethod> {
            public final PaymentMethod createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PaymentMethod(parcel.readString());
            }

            public final PaymentMethod[] newArray(int i) {
                return new PaymentMethod[i];
            }
        }

        public static /* synthetic */ PaymentMethod copy$default(PaymentMethod paymentMethod, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = paymentMethod.id;
            }
            return paymentMethod.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final PaymentMethod copy(String str) {
            Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
            return new PaymentMethod(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaymentMethod) && Intrinsics.areEqual((Object) this.id, (Object) ((PaymentMethod) obj).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "PaymentMethod(id=" + this.id + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.id);
        }

        public final String getId() {
            return this.id;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaymentMethod(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
            this.id = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SavedSelection$None;", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SavedSelection.kt */
    public static final class None extends SavedSelection {
        public static final int $stable = 8;
        public static final Parcelable.Creator<None> CREATOR = new Creator();
        public static final None INSTANCE = new None();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SavedSelection.kt */
        public static final class Creator implements Parcelable.Creator<None> {
            public final None createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return None.INSTANCE;
            }

            public final None[] newArray(int i) {
                return new None[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private None() {
            super((DefaultConstructorMarker) null);
        }
    }
}

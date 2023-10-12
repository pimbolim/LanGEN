package com.stripe.android.paymentsheet;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "Landroid/os/Parcelable;", "()V", "Canceled", "Completed", "Failed", "Lcom/stripe/android/paymentsheet/PaymentSheetResult$Completed;", "Lcom/stripe/android/paymentsheet/PaymentSheetResult$Canceled;", "Lcom/stripe/android/paymentsheet/PaymentSheetResult$Failed;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetResult.kt */
public abstract class PaymentSheetResult implements Parcelable {
    public static final int $stable = 0;

    public /* synthetic */ PaymentSheetResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaymentSheetResult() {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetResult$Completed;", "Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetResult.kt */
    public static final class Completed extends PaymentSheetResult {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Completed> CREATOR = new Creator();
        public static final Completed INSTANCE = new Completed();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetResult.kt */
        public static final class Creator implements Parcelable.Creator<Completed> {
            public final Completed createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Completed.INSTANCE;
            }

            public final Completed[] newArray(int i) {
                return new Completed[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Completed() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetResult$Canceled;", "Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetResult.kt */
    public static final class Canceled extends PaymentSheetResult {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Canceled> CREATOR = new Creator();
        public static final Canceled INSTANCE = new Canceled();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetResult.kt */
        public static final class Creator implements Parcelable.Creator<Canceled> {
            public final Canceled createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Canceled.INSTANCE;
            }

            public final Canceled[] newArray(int i) {
                return new Canceled[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Canceled() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetResult$Failed;", "Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetResult.kt */
    public static final class Failed extends PaymentSheetResult {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Failed> CREATOR = new Creator();
        private final Throwable error;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetResult.kt */
        public static final class Creator implements Parcelable.Creator<Failed> {
            public final Failed createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Failed((Throwable) parcel.readSerializable());
            }

            public final Failed[] newArray(int i) {
                return new Failed[i];
            }
        }

        public static /* synthetic */ Failed copy$default(Failed failed, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = failed.error;
            }
            return failed.copy(th);
        }

        public final Throwable component1() {
            return this.error;
        }

        public final Failed copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, ReactVideoView.EVENT_PROP_ERROR);
            return new Failed(th);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && Intrinsics.areEqual((Object) this.error, (Object) ((Failed) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Failed(error=" + this.error + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeSerializable(this.error);
        }

        public final Throwable getError() {
            return this.error;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failed(Throwable th) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, ReactVideoView.EVENT_PROP_ERROR);
            this.error = th;
        }
    }
}

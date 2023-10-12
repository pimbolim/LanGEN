package com.stripe.android.paymentsheet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \n2\u00020\u0001:\u0004\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionResult;", "Landroid/os/Parcelable;", "resultCode", "", "(I)V", "getResultCode", "()I", "toBundle", "Landroid/os/Bundle;", "Canceled", "Companion", "Failed", "Succeeded", "Lcom/stripe/android/paymentsheet/PaymentOptionResult$Succeeded;", "Lcom/stripe/android/paymentsheet/PaymentOptionResult$Failed;", "Lcom/stripe/android/paymentsheet/PaymentOptionResult$Canceled;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionResult.kt */
public abstract class PaymentOptionResult implements Parcelable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_RESULT = "extra_activity_result";
    private final int resultCode;

    public /* synthetic */ PaymentOptionResult(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private PaymentOptionResult(int i) {
        this.resultCode = i;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final Bundle toBundle() {
        return BundleKt.bundleOf(TuplesKt.to("extra_activity_result", this));
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionResult$Succeeded;", "Lcom/stripe/android/paymentsheet/PaymentOptionResult;", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "(Lcom/stripe/android/paymentsheet/model/PaymentSelection;)V", "getPaymentSelection", "()Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionResult.kt */
    public static final class Succeeded extends PaymentOptionResult {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Succeeded> CREATOR = new Creator();
        private final PaymentSelection paymentSelection;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionResult.kt */
        public static final class Creator implements Parcelable.Creator<Succeeded> {
            public final Succeeded createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Succeeded((PaymentSelection) parcel.readParcelable(Succeeded.class.getClassLoader()));
            }

            public final Succeeded[] newArray(int i) {
                return new Succeeded[i];
            }
        }

        public static /* synthetic */ Succeeded copy$default(Succeeded succeeded, PaymentSelection paymentSelection2, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentSelection2 = succeeded.paymentSelection;
            }
            return succeeded.copy(paymentSelection2);
        }

        public final PaymentSelection component1() {
            return this.paymentSelection;
        }

        public final Succeeded copy(PaymentSelection paymentSelection2) {
            Intrinsics.checkNotNullParameter(paymentSelection2, "paymentSelection");
            return new Succeeded(paymentSelection2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Succeeded) && Intrinsics.areEqual((Object) this.paymentSelection, (Object) ((Succeeded) obj).paymentSelection);
        }

        public int hashCode() {
            return this.paymentSelection.hashCode();
        }

        public String toString() {
            return "Succeeded(paymentSelection=" + this.paymentSelection + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.paymentSelection, i);
        }

        public final PaymentSelection getPaymentSelection() {
            return this.paymentSelection;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Succeeded(PaymentSelection paymentSelection2) {
            super(-1, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(paymentSelection2, "paymentSelection");
            this.paymentSelection = paymentSelection2;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionResult$Failed;", "Lcom/stripe/android/paymentsheet/PaymentOptionResult;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionResult.kt */
    public static final class Failed extends PaymentOptionResult {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Failed> CREATOR = new Creator();
        private final Throwable error;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionResult.kt */
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
            super(0, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, ReactVideoView.EVENT_PROP_ERROR);
            this.error = th;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionResult$Canceled;", "Lcom/stripe/android/paymentsheet/PaymentOptionResult;", "mostRecentError", "", "(Ljava/lang/Throwable;)V", "getMostRecentError", "()Ljava/lang/Throwable;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionResult.kt */
    public static final class Canceled extends PaymentOptionResult {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Canceled> CREATOR = new Creator();
        private final Throwable mostRecentError;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionResult.kt */
        public static final class Creator implements Parcelable.Creator<Canceled> {
            public final Canceled createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Canceled((Throwable) parcel.readSerializable());
            }

            public final Canceled[] newArray(int i) {
                return new Canceled[i];
            }
        }

        public static /* synthetic */ Canceled copy$default(Canceled canceled, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = canceled.mostRecentError;
            }
            return canceled.copy(th);
        }

        public final Throwable component1() {
            return this.mostRecentError;
        }

        public final Canceled copy(Throwable th) {
            return new Canceled(th);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Canceled) && Intrinsics.areEqual((Object) this.mostRecentError, (Object) ((Canceled) obj).mostRecentError);
        }

        public int hashCode() {
            Throwable th = this.mostRecentError;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        public String toString() {
            return "Canceled(mostRecentError=" + this.mostRecentError + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeSerializable(this.mostRecentError);
        }

        public final Throwable getMostRecentError() {
            return this.mostRecentError;
        }

        public Canceled(Throwable th) {
            super(0, (DefaultConstructorMarker) null);
            this.mostRecentError = th;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionResult$Companion;", "", "()V", "EXTRA_RESULT", "", "fromIntent", "Lcom/stripe/android/paymentsheet/PaymentOptionResult;", "intent", "Landroid/content/Intent;", "fromIntent$paymentsheet_release", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ PaymentOptionResult fromIntent$paymentsheet_release(Intent intent) {
            if (intent == null) {
                return null;
            }
            return (PaymentOptionResult) intent.getParcelableExtra("extra_activity_result");
        }
    }
}

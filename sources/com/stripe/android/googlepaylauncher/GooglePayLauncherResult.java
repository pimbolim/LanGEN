package com.stripe.android.googlepaylauncher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.google.android.gms.common.api.Status;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.view.ActivityStarter;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00062\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult;", "Lcom/stripe/android/view/ActivityStarter$Result;", "()V", "toBundle", "Landroid/os/Bundle;", "Canceled", "Companion", "Error", "PaymentData", "Unavailable", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$Error;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$PaymentData;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$Canceled;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$Unavailable;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayLauncherResult.kt */
public abstract class GooglePayLauncherResult implements ActivityStarter.Result {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ GooglePayLauncherResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final GooglePayLauncherResult fromIntent(Intent intent) {
        return Companion.fromIntent(intent);
    }

    private GooglePayLauncherResult() {
    }

    public Bundle toBundle() {
        return BundleKt.bundleOf(TuplesKt.to("extra_activity_result", this));
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$Error;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult;", "exception", "", "googlePayStatus", "Lcom/google/android/gms/common/api/Status;", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "(Ljava/lang/Throwable;Lcom/google/android/gms/common/api/Status;Lcom/stripe/android/model/PaymentMethod;Lcom/stripe/android/model/ShippingInformation;)V", "getException", "()Ljava/lang/Throwable;", "getGooglePayStatus", "()Lcom/google/android/gms/common/api/Status;", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "getShippingInformation", "()Lcom/stripe/android/model/ShippingInformation;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherResult.kt */
    public static final class Error extends GooglePayLauncherResult {
        public static final Parcelable.Creator<Error> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Throwable exception;
        private final Status googlePayStatus;
        private final PaymentMethod paymentMethod;
        private final ShippingInformation shippingInformation;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncherResult.kt */
        public static final class Creator implements Parcelable.Creator<Error> {
            public final Error createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return Error.Companion.create(parcel);
            }

            public final Error[] newArray(int i) {
                return new Error[i];
            }
        }

        public static /* synthetic */ Error copy$default(Error error, Throwable th, Status status, PaymentMethod paymentMethod2, ShippingInformation shippingInformation2, int i, Object obj) {
            if ((i & 1) != 0) {
                th = error.exception;
            }
            if ((i & 2) != 0) {
                status = error.googlePayStatus;
            }
            if ((i & 4) != 0) {
                paymentMethod2 = error.paymentMethod;
            }
            if ((i & 8) != 0) {
                shippingInformation2 = error.shippingInformation;
            }
            return error.copy(th, status, paymentMethod2, shippingInformation2);
        }

        public final Throwable component1() {
            return this.exception;
        }

        public final Status component2() {
            return this.googlePayStatus;
        }

        public final PaymentMethod component3() {
            return this.paymentMethod;
        }

        public final ShippingInformation component4() {
            return this.shippingInformation;
        }

        public final Error copy(Throwable th, Status status, PaymentMethod paymentMethod2, ShippingInformation shippingInformation2) {
            Intrinsics.checkNotNullParameter(th, "exception");
            return new Error(th, status, paymentMethod2, shippingInformation2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.exception, (Object) error.exception) && Intrinsics.areEqual((Object) this.googlePayStatus, (Object) error.googlePayStatus) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) error.paymentMethod) && Intrinsics.areEqual((Object) this.shippingInformation, (Object) error.shippingInformation);
        }

        public int hashCode() {
            int hashCode = this.exception.hashCode() * 31;
            Status status = this.googlePayStatus;
            int i = 0;
            int hashCode2 = (hashCode + (status == null ? 0 : status.hashCode())) * 31;
            PaymentMethod paymentMethod2 = this.paymentMethod;
            int hashCode3 = (hashCode2 + (paymentMethod2 == null ? 0 : paymentMethod2.hashCode())) * 31;
            ShippingInformation shippingInformation2 = this.shippingInformation;
            if (shippingInformation2 != null) {
                i = shippingInformation2.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "Error(exception=" + this.exception + ", googlePayStatus=" + this.googlePayStatus + ", paymentMethod=" + this.paymentMethod + ", shippingInformation=" + this.shippingInformation + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Companion.write(this, parcel, i);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(Throwable th, Status status, PaymentMethod paymentMethod2, ShippingInformation shippingInformation2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(th, (i & 2) != 0 ? null : status, (i & 4) != 0 ? null : paymentMethod2, (i & 8) != 0 ? null : shippingInformation2);
        }

        public final Throwable getException() {
            return this.exception;
        }

        public final Status getGooglePayStatus() {
            return this.googlePayStatus;
        }

        public final PaymentMethod getPaymentMethod() {
            return this.paymentMethod;
        }

        public final ShippingInformation getShippingInformation() {
            return this.shippingInformation;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$Error$Companion;", "Lkotlinx/parcelize/Parceler;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$Error;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncherResult.kt */
        public static final class Companion implements Parceler<Error> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public Error[] newArray(int i) {
                return (Error[]) Parceler.DefaultImpls.newArray(this, i);
            }

            public Error create(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Serializable readSerializable = parcel.readSerializable();
                Objects.requireNonNull(readSerializable, "null cannot be cast to non-null type kotlin.Throwable");
                return new Error((Throwable) readSerializable, (Status) parcel.readParcelable(Status.class.getClassLoader()), (PaymentMethod) null, (ShippingInformation) null, 12, (DefaultConstructorMarker) null);
            }

            public void write(Error error, Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(error, "<this>");
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeSerializable(error.getException());
                parcel.writeParcelable(error.getGooglePayStatus(), i);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(Throwable th, Status status, PaymentMethod paymentMethod2, ShippingInformation shippingInformation2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, "exception");
            this.exception = th;
            this.googlePayStatus = status;
            this.paymentMethod = paymentMethod2;
            this.shippingInformation = shippingInformation2;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$PaymentData;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult;", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "(Lcom/stripe/android/model/PaymentMethod;Lcom/stripe/android/model/ShippingInformation;)V", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "getShippingInformation", "()Lcom/stripe/android/model/ShippingInformation;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherResult.kt */
    public static final class PaymentData extends GooglePayLauncherResult {
        public static final Parcelable.Creator<PaymentData> CREATOR = new Creator();
        private final PaymentMethod paymentMethod;
        private final ShippingInformation shippingInformation;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncherResult.kt */
        public static final class Creator implements Parcelable.Creator<PaymentData> {
            public final PaymentData createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PaymentData(PaymentMethod.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ShippingInformation.CREATOR.createFromParcel(parcel));
            }

            public final PaymentData[] newArray(int i) {
                return new PaymentData[i];
            }
        }

        public static /* synthetic */ PaymentData copy$default(PaymentData paymentData, PaymentMethod paymentMethod2, ShippingInformation shippingInformation2, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentMethod2 = paymentData.paymentMethod;
            }
            if ((i & 2) != 0) {
                shippingInformation2 = paymentData.shippingInformation;
            }
            return paymentData.copy(paymentMethod2, shippingInformation2);
        }

        public final PaymentMethod component1() {
            return this.paymentMethod;
        }

        public final ShippingInformation component2() {
            return this.shippingInformation;
        }

        public final PaymentData copy(PaymentMethod paymentMethod2, ShippingInformation shippingInformation2) {
            Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
            return new PaymentData(paymentMethod2, shippingInformation2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaymentData)) {
                return false;
            }
            PaymentData paymentData = (PaymentData) obj;
            return Intrinsics.areEqual((Object) this.paymentMethod, (Object) paymentData.paymentMethod) && Intrinsics.areEqual((Object) this.shippingInformation, (Object) paymentData.shippingInformation);
        }

        public int hashCode() {
            int hashCode = this.paymentMethod.hashCode() * 31;
            ShippingInformation shippingInformation2 = this.shippingInformation;
            return hashCode + (shippingInformation2 == null ? 0 : shippingInformation2.hashCode());
        }

        public String toString() {
            return "PaymentData(paymentMethod=" + this.paymentMethod + ", shippingInformation=" + this.shippingInformation + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.paymentMethod.writeToParcel(parcel, i);
            ShippingInformation shippingInformation2 = this.shippingInformation;
            if (shippingInformation2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            shippingInformation2.writeToParcel(parcel, i);
        }

        public final PaymentMethod getPaymentMethod() {
            return this.paymentMethod;
        }

        public final ShippingInformation getShippingInformation() {
            return this.shippingInformation;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaymentData(PaymentMethod paymentMethod2, ShippingInformation shippingInformation2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
            this.paymentMethod = paymentMethod2;
            this.shippingInformation = shippingInformation2;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$Canceled;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherResult.kt */
    public static final class Canceled extends GooglePayLauncherResult {
        public static final Parcelable.Creator<Canceled> CREATOR = new Creator();
        public static final Canceled INSTANCE = new Canceled();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncherResult.kt */
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$Unavailable;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherResult.kt */
    public static final class Unavailable extends GooglePayLauncherResult {
        public static final Parcelable.Creator<Unavailable> CREATOR = new Creator();
        public static final Unavailable INSTANCE = new Unavailable();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncherResult.kt */
        public static final class Creator implements Parcelable.Creator<Unavailable> {
            public final Unavailable createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Unavailable.INSTANCE;
            }

            public final Unavailable[] newArray(int i) {
                return new Unavailable[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Unavailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult$Companion;", "", "()V", "fromIntent", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult;", "intent", "Landroid/content/Intent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GooglePayLauncherResult fromIntent(Intent intent) {
            GooglePayLauncherResult googlePayLauncherResult = intent == null ? null : (GooglePayLauncherResult) intent.getParcelableExtra("extra_activity_result");
            return googlePayLauncherResult == null ? new Error(new IllegalStateException("Error while processing result from Google Pay."), (Status) null, (PaymentMethod) null, (ShippingInformation) null, 14, (DefaultConstructorMarker) null) : googlePayLauncherResult;
        }
    }
}

package com.stripe.android;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.ShippingMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BY\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0002\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0006HÂ\u0003J\t\u0010 \u001a\u00020\u0006HÂ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J_\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0006HÆ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020)HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020)HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016¨\u00065"}, d2 = {"Lcom/stripe/android/PaymentSessionData;", "Landroid/os/Parcelable;", "config", "Lcom/stripe/android/PaymentSessionConfig;", "(Lcom/stripe/android/PaymentSessionConfig;)V", "isShippingInfoRequired", "", "isShippingMethodRequired", "cartTotal", "", "shippingTotal", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "shippingMethod", "Lcom/stripe/android/model/ShippingMethod;", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "useGooglePay", "(ZZJJLcom/stripe/android/model/ShippingInformation;Lcom/stripe/android/model/ShippingMethod;Lcom/stripe/android/model/PaymentMethod;Z)V", "getCartTotal", "()J", "isPaymentReadyToCharge", "()Z", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "getShippingInformation", "()Lcom/stripe/android/model/ShippingInformation;", "getShippingMethod", "()Lcom/stripe/android/model/ShippingMethod;", "getShippingTotal", "getUseGooglePay", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSessionData.kt */
public final class PaymentSessionData implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaymentSessionData> CREATOR = new Creator();
    private final long cartTotal;
    private final boolean isShippingInfoRequired;
    private final boolean isShippingMethodRequired;
    private final PaymentMethod paymentMethod;
    private final ShippingInformation shippingInformation;
    private final ShippingMethod shippingMethod;
    private final long shippingTotal;
    private final boolean useGooglePay;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionData.kt */
    public static final class Creator implements Parcelable.Creator<PaymentSessionData> {
        public final PaymentSessionData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            PaymentMethod paymentMethod = null;
            ShippingInformation createFromParcel = parcel.readInt() == 0 ? null : ShippingInformation.CREATOR.createFromParcel(parcel);
            ShippingMethod createFromParcel2 = parcel.readInt() == 0 ? null : ShippingMethod.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                paymentMethod = PaymentMethod.CREATOR.createFromParcel(parcel);
            }
            return new PaymentSessionData(z, z2, readLong, readLong2, createFromParcel, createFromParcel2, paymentMethod, parcel.readInt() != 0);
        }

        public final PaymentSessionData[] newArray(int i) {
            return new PaymentSessionData[i];
        }
    }

    private final boolean component1() {
        return this.isShippingInfoRequired;
    }

    private final boolean component2() {
        return this.isShippingMethodRequired;
    }

    public static /* synthetic */ PaymentSessionData copy$default(PaymentSessionData paymentSessionData, boolean z, boolean z2, long j, long j2, ShippingInformation shippingInformation2, ShippingMethod shippingMethod2, PaymentMethod paymentMethod2, boolean z3, int i, Object obj) {
        PaymentSessionData paymentSessionData2 = paymentSessionData;
        int i2 = i;
        return paymentSessionData.copy((i2 & 1) != 0 ? paymentSessionData2.isShippingInfoRequired : z, (i2 & 2) != 0 ? paymentSessionData2.isShippingMethodRequired : z2, (i2 & 4) != 0 ? paymentSessionData2.cartTotal : j, (i2 & 8) != 0 ? paymentSessionData2.shippingTotal : j2, (i2 & 16) != 0 ? paymentSessionData2.shippingInformation : shippingInformation2, (i2 & 32) != 0 ? paymentSessionData2.shippingMethod : shippingMethod2, (i2 & 64) != 0 ? paymentSessionData2.paymentMethod : paymentMethod2, (i2 & 128) != 0 ? paymentSessionData2.useGooglePay : z3);
    }

    public final long component3() {
        return this.cartTotal;
    }

    public final long component4() {
        return this.shippingTotal;
    }

    public final ShippingInformation component5() {
        return this.shippingInformation;
    }

    public final ShippingMethod component6() {
        return this.shippingMethod;
    }

    public final PaymentMethod component7() {
        return this.paymentMethod;
    }

    public final boolean component8() {
        return this.useGooglePay;
    }

    public final PaymentSessionData copy(boolean z, boolean z2, long j, long j2, ShippingInformation shippingInformation2, ShippingMethod shippingMethod2, PaymentMethod paymentMethod2, boolean z3) {
        return new PaymentSessionData(z, z2, j, j2, shippingInformation2, shippingMethod2, paymentMethod2, z3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentSessionData)) {
            return false;
        }
        PaymentSessionData paymentSessionData = (PaymentSessionData) obj;
        return this.isShippingInfoRequired == paymentSessionData.isShippingInfoRequired && this.isShippingMethodRequired == paymentSessionData.isShippingMethodRequired && this.cartTotal == paymentSessionData.cartTotal && this.shippingTotal == paymentSessionData.shippingTotal && Intrinsics.areEqual((Object) this.shippingInformation, (Object) paymentSessionData.shippingInformation) && Intrinsics.areEqual((Object) this.shippingMethod, (Object) paymentSessionData.shippingMethod) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) paymentSessionData.paymentMethod) && this.useGooglePay == paymentSessionData.useGooglePay;
    }

    public int hashCode() {
        boolean z = this.isShippingInfoRequired;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.isShippingMethodRequired;
        if (z3) {
            z3 = true;
        }
        int hashCode = (((((i + (z3 ? 1 : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.cartTotal)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.shippingTotal)) * 31;
        ShippingInformation shippingInformation2 = this.shippingInformation;
        int i2 = 0;
        int hashCode2 = (hashCode + (shippingInformation2 == null ? 0 : shippingInformation2.hashCode())) * 31;
        ShippingMethod shippingMethod2 = this.shippingMethod;
        int hashCode3 = (hashCode2 + (shippingMethod2 == null ? 0 : shippingMethod2.hashCode())) * 31;
        PaymentMethod paymentMethod2 = this.paymentMethod;
        if (paymentMethod2 != null) {
            i2 = paymentMethod2.hashCode();
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z4 = this.useGooglePay;
        if (!z4) {
            z2 = z4;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "PaymentSessionData(isShippingInfoRequired=" + this.isShippingInfoRequired + ", isShippingMethodRequired=" + this.isShippingMethodRequired + ", cartTotal=" + this.cartTotal + ", shippingTotal=" + this.shippingTotal + ", shippingInformation=" + this.shippingInformation + ", shippingMethod=" + this.shippingMethod + ", paymentMethod=" + this.paymentMethod + ", useGooglePay=" + this.useGooglePay + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.isShippingInfoRequired ? 1 : 0);
        parcel.writeInt(this.isShippingMethodRequired ? 1 : 0);
        parcel.writeLong(this.cartTotal);
        parcel.writeLong(this.shippingTotal);
        ShippingInformation shippingInformation2 = this.shippingInformation;
        if (shippingInformation2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            shippingInformation2.writeToParcel(parcel, i);
        }
        ShippingMethod shippingMethod2 = this.shippingMethod;
        if (shippingMethod2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            shippingMethod2.writeToParcel(parcel, i);
        }
        PaymentMethod paymentMethod2 = this.paymentMethod;
        if (paymentMethod2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            paymentMethod2.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.useGooglePay ? 1 : 0);
    }

    public PaymentSessionData(boolean z, boolean z2, long j, long j2, ShippingInformation shippingInformation2, ShippingMethod shippingMethod2, PaymentMethod paymentMethod2, boolean z3) {
        this.isShippingInfoRequired = z;
        this.isShippingMethodRequired = z2;
        this.cartTotal = j;
        this.shippingTotal = j2;
        this.shippingInformation = shippingInformation2;
        this.shippingMethod = shippingMethod2;
        this.paymentMethod = paymentMethod2;
        this.useGooglePay = z3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentSessionData(boolean r16, boolean r17, long r18, long r20, com.stripe.android.model.ShippingInformation r22, com.stripe.android.model.ShippingMethod r23, com.stripe.android.model.PaymentMethod r24, boolean r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r15 = this;
            r0 = r26
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r7 = r2
            goto L_0x000c
        L_0x000a:
            r7 = r18
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0012
            r9 = r2
            goto L_0x0014
        L_0x0012:
            r9 = r20
        L_0x0014:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x001b
            r11 = r2
            goto L_0x001d
        L_0x001b:
            r11 = r22
        L_0x001d:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0023
            r12 = r2
            goto L_0x0025
        L_0x0023:
            r12 = r23
        L_0x0025:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002b
            r13 = r2
            goto L_0x002d
        L_0x002b:
            r13 = r24
        L_0x002d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            r14 = 0
            goto L_0x0036
        L_0x0034:
            r14 = r25
        L_0x0036:
            r4 = r15
            r5 = r16
            r6 = r17
            r4.<init>(r5, r6, r7, r9, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.PaymentSessionData.<init>(boolean, boolean, long, long, com.stripe.android.model.ShippingInformation, com.stripe.android.model.ShippingMethod, com.stripe.android.model.PaymentMethod, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getCartTotal() {
        return this.cartTotal;
    }

    public final long getShippingTotal() {
        return this.shippingTotal;
    }

    public final ShippingInformation getShippingInformation() {
        return this.shippingInformation;
    }

    public final ShippingMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public final PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public final boolean getUseGooglePay() {
        return this.useGooglePay;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PaymentSessionData(PaymentSessionConfig paymentSessionConfig) {
        this(paymentSessionConfig.isShippingInfoRequired(), paymentSessionConfig.isShippingMethodRequired(), 0, 0, (ShippingInformation) null, (ShippingMethod) null, (PaymentMethod) null, false, 252, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(paymentSessionConfig, "config");
    }

    public final boolean isPaymentReadyToCharge() {
        return (this.paymentMethod != null || this.useGooglePay) && (!this.isShippingInfoRequired || this.shippingInformation != null) && (!this.isShippingMethodRequired || this.shippingMethod != null);
    }
}

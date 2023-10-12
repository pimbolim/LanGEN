package com.stripe.android.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import com.stripe.android.ObjectBuilder;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.view.ActivityStarter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\r"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsActivityStarter;", "Lcom/stripe/android/view/ActivityStarter;", "Lcom/stripe/android/view/PaymentMethodsActivity;", "Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "Args", "Companion", "Result", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsActivityStarter.kt */
public final class PaymentMethodsActivityStarter extends ActivityStarter<PaymentMethodsActivity, Args> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_CODE = 6000;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentMethodsActivityStarter(Activity activity) {
        super(activity, PaymentMethodsActivity.class, (int) REQUEST_CODE, (Integer) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentMethodsActivityStarter(Fragment fragment) {
        super(fragment, PaymentMethodsActivity.class, (int) REQUEST_CODE, (Integer) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 J2\u00020\u0001:\u0002IJBw\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b¢\u0006\u0002\u0010\u0014J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b)J\u000e\u0010*\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b+J\u000e\u0010,\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b-J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000e\u00100\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b1J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÀ\u0003¢\u0006\u0002\b3J\u0010\u00104\u001a\u0004\u0018\u00010\rHÀ\u0003¢\u0006\u0002\b5J\u0012\u00106\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b7\u0010&J\u000e\u00108\u001a\u00020\u0010HÀ\u0003¢\u0006\u0002\b9J\u000e\u0010:\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b;J\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010=J\t\u0010>\u001a\u00020\u0005HÖ\u0001J\u0013\u0010?\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0005HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\u0019\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0013\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0014\u0010\u0012\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&¨\u0006K"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args;", "Lcom/stripe/android/view/ActivityStarter$Args;", "initialPaymentMethodId", "", "paymentMethodsFooterLayoutId", "", "addPaymentMethodFooterLayoutId", "isPaymentSessionActive", "", "paymentMethodTypes", "", "Lcom/stripe/android/model/PaymentMethod$Type;", "paymentConfiguration", "Lcom/stripe/android/PaymentConfiguration;", "windowFlags", "billingAddressFields", "Lcom/stripe/android/view/BillingAddressFields;", "shouldShowGooglePay", "useGooglePay", "canDeletePaymentMethods", "(Ljava/lang/String;IIZLjava/util/List;Lcom/stripe/android/PaymentConfiguration;Ljava/lang/Integer;Lcom/stripe/android/view/BillingAddressFields;ZZZ)V", "getAddPaymentMethodFooterLayoutId", "()I", "getBillingAddressFields$payments_core_release", "()Lcom/stripe/android/view/BillingAddressFields;", "getCanDeletePaymentMethods$payments_core_release", "()Z", "getInitialPaymentMethodId$payments_core_release", "()Ljava/lang/String;", "isPaymentSessionActive$payments_core_release", "getPaymentConfiguration$payments_core_release", "()Lcom/stripe/android/PaymentConfiguration;", "getPaymentMethodTypes$payments_core_release", "()Ljava/util/List;", "getPaymentMethodsFooterLayoutId", "getShouldShowGooglePay$payments_core_release", "getUseGooglePay$payments_core_release", "getWindowFlags$payments_core_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component1$payments_core_release", "component10", "component10$payments_core_release", "component11", "component11$payments_core_release", "component2", "component3", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "component6", "component6$payments_core_release", "component7", "component7$payments_core_release", "component8", "component8$payments_core_release", "component9", "component9$payments_core_release", "copy", "(Ljava/lang/String;IIZLjava/util/List;Lcom/stripe/android/PaymentConfiguration;Ljava/lang/Integer;Lcom/stripe/android/view/BillingAddressFields;ZZZ)Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsActivityStarter.kt */
    public static final class Args implements ActivityStarter.Args {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int addPaymentMethodFooterLayoutId;
        private final BillingAddressFields billingAddressFields;
        private final boolean canDeletePaymentMethods;
        private final String initialPaymentMethodId;
        private final boolean isPaymentSessionActive;
        private final PaymentConfiguration paymentConfiguration;
        private final List<PaymentMethod.Type> paymentMethodTypes;
        private final int paymentMethodsFooterLayoutId;
        private final boolean shouldShowGooglePay;
        private final boolean useGooglePay;
        private final Integer windowFlags;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodsActivityStarter.kt */
        public static final class Creator implements Parcelable.Creator<Args> {
            public final Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                boolean z = parcel.readInt() != 0;
                int readInt3 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt3);
                for (int i = 0; i != readInt3; i++) {
                    arrayList.add(PaymentMethod.Type.CREATOR.createFromParcel(parcel));
                }
                List list = arrayList;
                Integer num = null;
                PaymentConfiguration createFromParcel = parcel.readInt() == 0 ? null : PaymentConfiguration.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    num = Integer.valueOf(parcel.readInt());
                }
                return new Args(readString, readInt, readInt2, z, list, createFromParcel, num, BillingAddressFields.valueOf(parcel.readString()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
            }

            public final Args[] newArray(int i) {
                return new Args[i];
            }
        }

        public static /* synthetic */ Args copy$default(Args args, String str, int i, int i2, boolean z, List list, PaymentConfiguration paymentConfiguration2, Integer num, BillingAddressFields billingAddressFields2, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
            Args args2 = args;
            int i4 = i3;
            return args.copy((i4 & 1) != 0 ? args2.initialPaymentMethodId : str, (i4 & 2) != 0 ? args2.paymentMethodsFooterLayoutId : i, (i4 & 4) != 0 ? args2.addPaymentMethodFooterLayoutId : i2, (i4 & 8) != 0 ? args2.isPaymentSessionActive : z, (i4 & 16) != 0 ? args2.paymentMethodTypes : list, (i4 & 32) != 0 ? args2.paymentConfiguration : paymentConfiguration2, (i4 & 64) != 0 ? args2.windowFlags : num, (i4 & 128) != 0 ? args2.billingAddressFields : billingAddressFields2, (i4 & 256) != 0 ? args2.shouldShowGooglePay : z2, (i4 & 512) != 0 ? args2.useGooglePay : z3, (i4 & 1024) != 0 ? args2.canDeletePaymentMethods : z4);
        }

        public final String component1$payments_core_release() {
            return this.initialPaymentMethodId;
        }

        public final boolean component10$payments_core_release() {
            return this.useGooglePay;
        }

        public final boolean component11$payments_core_release() {
            return this.canDeletePaymentMethods;
        }

        public final int component2() {
            return this.paymentMethodsFooterLayoutId;
        }

        public final int component3() {
            return this.addPaymentMethodFooterLayoutId;
        }

        public final boolean component4$payments_core_release() {
            return this.isPaymentSessionActive;
        }

        public final List<PaymentMethod.Type> component5$payments_core_release() {
            return this.paymentMethodTypes;
        }

        public final PaymentConfiguration component6$payments_core_release() {
            return this.paymentConfiguration;
        }

        public final Integer component7$payments_core_release() {
            return this.windowFlags;
        }

        public final BillingAddressFields component8$payments_core_release() {
            return this.billingAddressFields;
        }

        public final boolean component9$payments_core_release() {
            return this.shouldShowGooglePay;
        }

        public final Args copy(String str, int i, int i2, boolean z, List<? extends PaymentMethod.Type> list, PaymentConfiguration paymentConfiguration2, Integer num, BillingAddressFields billingAddressFields2, boolean z2, boolean z3, boolean z4) {
            List<? extends PaymentMethod.Type> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "paymentMethodTypes");
            BillingAddressFields billingAddressFields3 = billingAddressFields2;
            Intrinsics.checkNotNullParameter(billingAddressFields3, "billingAddressFields");
            return new Args(str, i, i2, z, list2, paymentConfiguration2, num, billingAddressFields3, z2, z3, z4);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Args)) {
                return false;
            }
            Args args = (Args) obj;
            return Intrinsics.areEqual((Object) this.initialPaymentMethodId, (Object) args.initialPaymentMethodId) && this.paymentMethodsFooterLayoutId == args.paymentMethodsFooterLayoutId && this.addPaymentMethodFooterLayoutId == args.addPaymentMethodFooterLayoutId && this.isPaymentSessionActive == args.isPaymentSessionActive && Intrinsics.areEqual((Object) this.paymentMethodTypes, (Object) args.paymentMethodTypes) && Intrinsics.areEqual((Object) this.paymentConfiguration, (Object) args.paymentConfiguration) && Intrinsics.areEqual((Object) this.windowFlags, (Object) args.windowFlags) && this.billingAddressFields == args.billingAddressFields && this.shouldShowGooglePay == args.shouldShowGooglePay && this.useGooglePay == args.useGooglePay && this.canDeletePaymentMethods == args.canDeletePaymentMethods;
        }

        public int hashCode() {
            String str = this.initialPaymentMethodId;
            int i = 0;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.paymentMethodsFooterLayoutId) * 31) + this.addPaymentMethodFooterLayoutId) * 31;
            boolean z = this.isPaymentSessionActive;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.paymentMethodTypes.hashCode()) * 31;
            PaymentConfiguration paymentConfiguration2 = this.paymentConfiguration;
            int hashCode3 = (hashCode2 + (paymentConfiguration2 == null ? 0 : paymentConfiguration2.hashCode())) * 31;
            Integer num = this.windowFlags;
            if (num != null) {
                i = num.hashCode();
            }
            int hashCode4 = (((hashCode3 + i) * 31) + this.billingAddressFields.hashCode()) * 31;
            boolean z3 = this.shouldShowGooglePay;
            if (z3) {
                z3 = true;
            }
            int i2 = (hashCode4 + (z3 ? 1 : 0)) * 31;
            boolean z4 = this.useGooglePay;
            if (z4) {
                z4 = true;
            }
            int i3 = (i2 + (z4 ? 1 : 0)) * 31;
            boolean z5 = this.canDeletePaymentMethods;
            if (!z5) {
                z2 = z5;
            }
            return i3 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "Args(initialPaymentMethodId=" + this.initialPaymentMethodId + ", paymentMethodsFooterLayoutId=" + this.paymentMethodsFooterLayoutId + ", addPaymentMethodFooterLayoutId=" + this.addPaymentMethodFooterLayoutId + ", isPaymentSessionActive=" + this.isPaymentSessionActive + ", paymentMethodTypes=" + this.paymentMethodTypes + ", paymentConfiguration=" + this.paymentConfiguration + ", windowFlags=" + this.windowFlags + ", billingAddressFields=" + this.billingAddressFields + ", shouldShowGooglePay=" + this.shouldShowGooglePay + ", useGooglePay=" + this.useGooglePay + ", canDeletePaymentMethods=" + this.canDeletePaymentMethods + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.initialPaymentMethodId);
            parcel.writeInt(this.paymentMethodsFooterLayoutId);
            parcel.writeInt(this.addPaymentMethodFooterLayoutId);
            parcel.writeInt(this.isPaymentSessionActive ? 1 : 0);
            List<PaymentMethod.Type> list = this.paymentMethodTypes;
            parcel.writeInt(list.size());
            for (PaymentMethod.Type writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i);
            }
            PaymentConfiguration paymentConfiguration2 = this.paymentConfiguration;
            if (paymentConfiguration2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                paymentConfiguration2.writeToParcel(parcel, i);
            }
            Integer num = this.windowFlags;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            parcel.writeString(this.billingAddressFields.name());
            parcel.writeInt(this.shouldShowGooglePay ? 1 : 0);
            parcel.writeInt(this.useGooglePay ? 1 : 0);
            parcel.writeInt(this.canDeletePaymentMethods ? 1 : 0);
        }

        public Args(String str, int i, int i2, boolean z, List<? extends PaymentMethod.Type> list, PaymentConfiguration paymentConfiguration2, Integer num, BillingAddressFields billingAddressFields2, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(list, "paymentMethodTypes");
            Intrinsics.checkNotNullParameter(billingAddressFields2, "billingAddressFields");
            this.initialPaymentMethodId = str;
            this.paymentMethodsFooterLayoutId = i;
            this.addPaymentMethodFooterLayoutId = i2;
            this.isPaymentSessionActive = z;
            this.paymentMethodTypes = list;
            this.paymentConfiguration = paymentConfiguration2;
            this.windowFlags = num;
            this.billingAddressFields = billingAddressFields2;
            this.shouldShowGooglePay = z2;
            this.useGooglePay = z3;
            this.canDeletePaymentMethods = z4;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Args(java.lang.String r15, int r16, int r17, boolean r18, java.util.List r19, com.stripe.android.PaymentConfiguration r20, java.lang.Integer r21, com.stripe.android.view.BillingAddressFields r22, boolean r23, boolean r24, boolean r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
            /*
                r14 = this;
                r0 = r26
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0009
                r1 = 0
                r9 = r1
                goto L_0x000b
            L_0x0009:
                r9 = r21
            L_0x000b:
                r1 = r0 & 256(0x100, float:3.59E-43)
                r2 = 0
                if (r1 == 0) goto L_0x0012
                r11 = 0
                goto L_0x0014
            L_0x0012:
                r11 = r23
            L_0x0014:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L_0x001a
                r12 = 0
                goto L_0x001c
            L_0x001a:
                r12 = r24
            L_0x001c:
                r0 = r0 & 1024(0x400, float:1.435E-42)
                if (r0 == 0) goto L_0x0023
                r0 = 1
                r13 = 1
                goto L_0x0025
            L_0x0023:
                r13 = r25
            L_0x0025:
                r2 = r14
                r3 = r15
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r10 = r22
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentMethodsActivityStarter.Args.<init>(java.lang.String, int, int, boolean, java.util.List, com.stripe.android.PaymentConfiguration, java.lang.Integer, com.stripe.android.view.BillingAddressFields, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getInitialPaymentMethodId$payments_core_release() {
            return this.initialPaymentMethodId;
        }

        public final int getPaymentMethodsFooterLayoutId() {
            return this.paymentMethodsFooterLayoutId;
        }

        public final int getAddPaymentMethodFooterLayoutId() {
            return this.addPaymentMethodFooterLayoutId;
        }

        public final boolean isPaymentSessionActive$payments_core_release() {
            return this.isPaymentSessionActive;
        }

        public final List<PaymentMethod.Type> getPaymentMethodTypes$payments_core_release() {
            return this.paymentMethodTypes;
        }

        public final PaymentConfiguration getPaymentConfiguration$payments_core_release() {
            return this.paymentConfiguration;
        }

        public final Integer getWindowFlags$payments_core_release() {
            return this.windowFlags;
        }

        public final BillingAddressFields getBillingAddressFields$payments_core_release() {
            return this.billingAddressFields;
        }

        public final boolean getShouldShowGooglePay$payments_core_release() {
            return this.shouldShowGooglePay;
        }

        public final boolean getUseGooglePay$payments_core_release() {
            return this.useGooglePay;
        }

        public final boolean getCanDeletePaymentMethods$payments_core_release() {
            return this.canDeletePaymentMethods;
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0014\u0010\u001e\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0010\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\tH\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010$R\u0012\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006%"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args;", "()V", "addPaymentMethodFooterLayoutId", "", "billingAddressFields", "Lcom/stripe/android/view/BillingAddressFields;", "canDeletePaymentMethods", "", "initialPaymentMethodId", "", "isPaymentSessionActive", "paymentConfiguration", "Lcom/stripe/android/PaymentConfiguration;", "paymentMethodTypes", "", "Lcom/stripe/android/model/PaymentMethod$Type;", "paymentMethodsFooterLayoutId", "shouldShowGooglePay", "useGooglePay", "windowFlags", "Ljava/lang/Integer;", "build", "setAddPaymentMethodFooter", "setBillingAddressFields", "setCanDeletePaymentMethods", "setInitialPaymentMethodId", "setIsPaymentSessionActive", "setPaymentConfiguration", "setPaymentMethodTypes", "setPaymentMethodsFooter", "setShouldShowGooglePay", "setUseGooglePay", "setUseGooglePay$payments_core_release", "setWindowFlags", "(Ljava/lang/Integer;)Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args$Builder;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodsActivityStarter.kt */
        public static final class Builder implements ObjectBuilder<Args> {
            public static final int $stable = 8;
            private int addPaymentMethodFooterLayoutId;
            private BillingAddressFields billingAddressFields = BillingAddressFields.PostalCode;
            private boolean canDeletePaymentMethods = true;
            private String initialPaymentMethodId;
            private boolean isPaymentSessionActive;
            private PaymentConfiguration paymentConfiguration;
            private List<? extends PaymentMethod.Type> paymentMethodTypes;
            private int paymentMethodsFooterLayoutId;
            private boolean shouldShowGooglePay;
            private boolean useGooglePay;
            private Integer windowFlags;

            public final Builder setBillingAddressFields(BillingAddressFields billingAddressFields2) {
                Intrinsics.checkNotNullParameter(billingAddressFields2, "billingAddressFields");
                Builder builder = this;
                builder.billingAddressFields = billingAddressFields2;
                return builder;
            }

            public final Builder setInitialPaymentMethodId(String str) {
                Builder builder = this;
                builder.initialPaymentMethodId = str;
                return builder;
            }

            public final Builder setIsPaymentSessionActive(boolean z) {
                Builder builder = this;
                builder.isPaymentSessionActive = z;
                return builder;
            }

            public final Builder setPaymentConfiguration(PaymentConfiguration paymentConfiguration2) {
                Builder builder = this;
                builder.paymentConfiguration = paymentConfiguration2;
                return builder;
            }

            public final Builder setPaymentMethodTypes(List<? extends PaymentMethod.Type> list) {
                Intrinsics.checkNotNullParameter(list, "paymentMethodTypes");
                Builder builder = this;
                builder.paymentMethodTypes = list;
                return builder;
            }

            public final Builder setShouldShowGooglePay(boolean z) {
                Builder builder = this;
                builder.shouldShowGooglePay = z;
                return builder;
            }

            public final Builder setPaymentMethodsFooter(int i) {
                Builder builder = this;
                builder.paymentMethodsFooterLayoutId = i;
                return builder;
            }

            public final Builder setAddPaymentMethodFooter(int i) {
                Builder builder = this;
                builder.addPaymentMethodFooterLayoutId = i;
                return builder;
            }

            public final Builder setWindowFlags(Integer num) {
                Builder builder = this;
                builder.windowFlags = num;
                return builder;
            }

            public final Builder setUseGooglePay$payments_core_release(boolean z) {
                Builder builder = this;
                builder.useGooglePay = z;
                return builder;
            }

            public final Builder setCanDeletePaymentMethods(boolean z) {
                Builder builder = this;
                builder.canDeletePaymentMethods = z;
                return builder;
            }

            public Args build() {
                String str = this.initialPaymentMethodId;
                boolean z = this.isPaymentSessionActive;
                List<? extends PaymentMethod.Type> list = this.paymentMethodTypes;
                if (list == null) {
                    list = CollectionsKt.listOf(PaymentMethod.Type.Card);
                }
                boolean z2 = this.shouldShowGooglePay;
                boolean z3 = this.useGooglePay;
                PaymentConfiguration paymentConfiguration2 = this.paymentConfiguration;
                return new Args(str, this.paymentMethodsFooterLayoutId, this.addPaymentMethodFooterLayoutId, z, list, paymentConfiguration2, this.windowFlags, this.billingAddressFields, z2, z3, this.canDeletePaymentMethods);
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args$Companion;", "", "()V", "create", "Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args;", "intent", "Landroid/content/Intent;", "create$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodsActivityStarter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Args create$payments_core_release(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Parcelable parcelableExtra = intent.getParcelableExtra("extra_activity_args");
                if (parcelableExtra != null) {
                    return (Args) parcelableExtra;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\rHÖ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsActivityStarter$Result;", "Lcom/stripe/android/view/ActivityStarter$Result;", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "useGooglePay", "", "(Lcom/stripe/android/model/PaymentMethod;Z)V", "getUseGooglePay", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsActivityStarter.kt */
    public static final class Result implements ActivityStarter.Result {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Result> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public final PaymentMethod paymentMethod;
        private final boolean useGooglePay;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodsActivityStarter.kt */
        public static final class Creator implements Parcelable.Creator<Result> {
            public final Result createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Result(parcel.readInt() == 0 ? null : PaymentMethod.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
            }

            public final Result[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result() {
            this((PaymentMethod) null, false, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Result copy$default(Result result, PaymentMethod paymentMethod2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentMethod2 = result.paymentMethod;
            }
            if ((i & 2) != 0) {
                z = result.useGooglePay;
            }
            return result.copy(paymentMethod2, z);
        }

        @JvmStatic
        public static final Result fromIntent(Intent intent) {
            return Companion.fromIntent(intent);
        }

        public final PaymentMethod component1() {
            return this.paymentMethod;
        }

        public final boolean component2() {
            return this.useGooglePay;
        }

        public final Result copy(PaymentMethod paymentMethod2, boolean z) {
            return new Result(paymentMethod2, z);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return Intrinsics.areEqual((Object) this.paymentMethod, (Object) result.paymentMethod) && this.useGooglePay == result.useGooglePay;
        }

        public int hashCode() {
            PaymentMethod paymentMethod2 = this.paymentMethod;
            int hashCode = (paymentMethod2 == null ? 0 : paymentMethod2.hashCode()) * 31;
            boolean z = this.useGooglePay;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "Result(paymentMethod=" + this.paymentMethod + ", useGooglePay=" + this.useGooglePay + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            PaymentMethod paymentMethod2 = this.paymentMethod;
            if (paymentMethod2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                paymentMethod2.writeToParcel(parcel, i);
            }
            parcel.writeInt(this.useGooglePay ? 1 : 0);
        }

        public Result(PaymentMethod paymentMethod2, boolean z) {
            this.paymentMethod = paymentMethod2;
            this.useGooglePay = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Result(PaymentMethod paymentMethod2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : paymentMethod2, (i & 2) != 0 ? false : z);
        }

        public final boolean getUseGooglePay() {
            return this.useGooglePay;
        }

        public Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to("extra_activity_result", this));
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsActivityStarter$Result$Companion;", "", "()V", "fromIntent", "Lcom/stripe/android/view/PaymentMethodsActivityStarter$Result;", "intent", "Landroid/content/Intent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodsActivityStarter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Result fromIntent(Intent intent) {
                if (intent == null) {
                    return null;
                }
                return (Result) intent.getParcelableExtra("extra_activity_result");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsActivityStarter$Companion;", "", "()V", "REQUEST_CODE", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsActivityStarter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

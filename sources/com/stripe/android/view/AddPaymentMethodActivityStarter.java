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
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\r"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivityStarter;", "Lcom/stripe/android/view/ActivityStarter;", "Lcom/stripe/android/view/AddPaymentMethodActivity;", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "Args", "Companion", "Result", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodActivityStarter.kt */
public final class AddPaymentMethodActivityStarter extends ActivityStarter<AddPaymentMethodActivity, Args> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_CODE = 6001;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddPaymentMethodActivityStarter(Activity activity) {
        super(activity, AddPaymentMethodActivity.class, (int) REQUEST_CODE, (Integer) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddPaymentMethodActivityStarter(Fragment fragment) {
        super(fragment, AddPaymentMethodActivity.class, (int) REQUEST_CODE, (Integer) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 :2\u00020\u0001:\u00029:BG\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001d\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b J\u000e\u0010!\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\"J\u000e\u0010#\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b$J\u0010\u0010%\u001a\u0004\u0018\u00010\nHÀ\u0003¢\u0006\u0002\b&J\u000e\u0010'\u001a\u00020\fHÀ\u0003¢\u0006\u0002\b(J\u0012\u0010)\u001a\u0004\u0018\u00010\fHÀ\u0003¢\u0006\u0004\b*\u0010\u001bJX\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\fHÖ\u0001J\u0013\u0010.\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\fHÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\fHÖ\u0001R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006;"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "Lcom/stripe/android/view/ActivityStarter$Args;", "billingAddressFields", "Lcom/stripe/android/view/BillingAddressFields;", "shouldAttachToCustomer", "", "isPaymentSessionActive", "paymentMethodType", "Lcom/stripe/android/model/PaymentMethod$Type;", "paymentConfiguration", "Lcom/stripe/android/PaymentConfiguration;", "addPaymentMethodFooterLayoutId", "", "windowFlags", "(Lcom/stripe/android/view/BillingAddressFields;ZZLcom/stripe/android/model/PaymentMethod$Type;Lcom/stripe/android/PaymentConfiguration;ILjava/lang/Integer;)V", "getAddPaymentMethodFooterLayoutId$payments_core_release", "()I", "getBillingAddressFields$payments_core_release", "()Lcom/stripe/android/view/BillingAddressFields;", "isPaymentSessionActive$payments_core_release", "()Z", "getPaymentConfiguration$payments_core_release", "()Lcom/stripe/android/PaymentConfiguration;", "getPaymentMethodType$payments_core_release", "()Lcom/stripe/android/model/PaymentMethod$Type;", "getShouldAttachToCustomer$payments_core_release", "getWindowFlags$payments_core_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "component6", "component6$payments_core_release", "component7", "component7$payments_core_release", "copy", "(Lcom/stripe/android/view/BillingAddressFields;ZZLcom/stripe/android/model/PaymentMethod$Type;Lcom/stripe/android/PaymentConfiguration;ILjava/lang/Integer;)Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddPaymentMethodActivityStarter.kt */
    public static final class Args implements ActivityStarter.Args {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int addPaymentMethodFooterLayoutId;
        private final BillingAddressFields billingAddressFields;
        private final boolean isPaymentSessionActive;
        private final PaymentConfiguration paymentConfiguration;
        private final PaymentMethod.Type paymentMethodType;
        private final boolean shouldAttachToCustomer;
        private final Integer windowFlags;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AddPaymentMethodActivityStarter.kt */
        public static final class Creator implements Parcelable.Creator<Args> {
            public final Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                BillingAddressFields valueOf = BillingAddressFields.valueOf(parcel.readString());
                boolean z = false;
                boolean z2 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                return new Args(valueOf, z2, z, PaymentMethod.Type.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : PaymentConfiguration.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            public final Args[] newArray(int i) {
                return new Args[i];
            }
        }

        public static /* synthetic */ Args copy$default(Args args, BillingAddressFields billingAddressFields2, boolean z, boolean z2, PaymentMethod.Type type, PaymentConfiguration paymentConfiguration2, int i, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                billingAddressFields2 = args.billingAddressFields;
            }
            if ((i2 & 2) != 0) {
                z = args.shouldAttachToCustomer;
            }
            boolean z3 = z;
            if ((i2 & 4) != 0) {
                z2 = args.isPaymentSessionActive;
            }
            boolean z4 = z2;
            if ((i2 & 8) != 0) {
                type = args.paymentMethodType;
            }
            PaymentMethod.Type type2 = type;
            if ((i2 & 16) != 0) {
                paymentConfiguration2 = args.paymentConfiguration;
            }
            PaymentConfiguration paymentConfiguration3 = paymentConfiguration2;
            if ((i2 & 32) != 0) {
                i = args.addPaymentMethodFooterLayoutId;
            }
            int i3 = i;
            if ((i2 & 64) != 0) {
                num = args.windowFlags;
            }
            return args.copy(billingAddressFields2, z3, z4, type2, paymentConfiguration3, i3, num);
        }

        public final BillingAddressFields component1$payments_core_release() {
            return this.billingAddressFields;
        }

        public final boolean component2$payments_core_release() {
            return this.shouldAttachToCustomer;
        }

        public final boolean component3$payments_core_release() {
            return this.isPaymentSessionActive;
        }

        public final PaymentMethod.Type component4$payments_core_release() {
            return this.paymentMethodType;
        }

        public final PaymentConfiguration component5$payments_core_release() {
            return this.paymentConfiguration;
        }

        public final int component6$payments_core_release() {
            return this.addPaymentMethodFooterLayoutId;
        }

        public final Integer component7$payments_core_release() {
            return this.windowFlags;
        }

        public final Args copy(BillingAddressFields billingAddressFields2, boolean z, boolean z2, PaymentMethod.Type type, PaymentConfiguration paymentConfiguration2, int i, Integer num) {
            Intrinsics.checkNotNullParameter(billingAddressFields2, "billingAddressFields");
            Intrinsics.checkNotNullParameter(type, "paymentMethodType");
            return new Args(billingAddressFields2, z, z2, type, paymentConfiguration2, i, num);
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
            return this.billingAddressFields == args.billingAddressFields && this.shouldAttachToCustomer == args.shouldAttachToCustomer && this.isPaymentSessionActive == args.isPaymentSessionActive && this.paymentMethodType == args.paymentMethodType && Intrinsics.areEqual((Object) this.paymentConfiguration, (Object) args.paymentConfiguration) && this.addPaymentMethodFooterLayoutId == args.addPaymentMethodFooterLayoutId && Intrinsics.areEqual((Object) this.windowFlags, (Object) args.windowFlags);
        }

        public int hashCode() {
            int hashCode = this.billingAddressFields.hashCode() * 31;
            boolean z = this.shouldAttachToCustomer;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i = (hashCode + (z ? 1 : 0)) * 31;
            boolean z3 = this.isPaymentSessionActive;
            if (!z3) {
                z2 = z3;
            }
            int hashCode2 = (((i + (z2 ? 1 : 0)) * 31) + this.paymentMethodType.hashCode()) * 31;
            PaymentConfiguration paymentConfiguration2 = this.paymentConfiguration;
            int i2 = 0;
            int hashCode3 = (((hashCode2 + (paymentConfiguration2 == null ? 0 : paymentConfiguration2.hashCode())) * 31) + this.addPaymentMethodFooterLayoutId) * 31;
            Integer num = this.windowFlags;
            if (num != null) {
                i2 = num.hashCode();
            }
            return hashCode3 + i2;
        }

        public String toString() {
            return "Args(billingAddressFields=" + this.billingAddressFields + ", shouldAttachToCustomer=" + this.shouldAttachToCustomer + ", isPaymentSessionActive=" + this.isPaymentSessionActive + ", paymentMethodType=" + this.paymentMethodType + ", paymentConfiguration=" + this.paymentConfiguration + ", addPaymentMethodFooterLayoutId=" + this.addPaymentMethodFooterLayoutId + ", windowFlags=" + this.windowFlags + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.billingAddressFields.name());
            parcel.writeInt(this.shouldAttachToCustomer ? 1 : 0);
            parcel.writeInt(this.isPaymentSessionActive ? 1 : 0);
            this.paymentMethodType.writeToParcel(parcel, i);
            PaymentConfiguration paymentConfiguration2 = this.paymentConfiguration;
            if (paymentConfiguration2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                paymentConfiguration2.writeToParcel(parcel, i);
            }
            parcel.writeInt(this.addPaymentMethodFooterLayoutId);
            Integer num = this.windowFlags;
            if (num == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }

        public Args(BillingAddressFields billingAddressFields2, boolean z, boolean z2, PaymentMethod.Type type, PaymentConfiguration paymentConfiguration2, int i, Integer num) {
            Intrinsics.checkNotNullParameter(billingAddressFields2, "billingAddressFields");
            Intrinsics.checkNotNullParameter(type, "paymentMethodType");
            this.billingAddressFields = billingAddressFields2;
            this.shouldAttachToCustomer = z;
            this.isPaymentSessionActive = z2;
            this.paymentMethodType = type;
            this.paymentConfiguration = paymentConfiguration2;
            this.addPaymentMethodFooterLayoutId = i;
            this.windowFlags = num;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Args(BillingAddressFields billingAddressFields2, boolean z, boolean z2, PaymentMethod.Type type, PaymentConfiguration paymentConfiguration2, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(billingAddressFields2, z, z2, type, paymentConfiguration2, i, (i2 & 64) != 0 ? null : num);
        }

        public final BillingAddressFields getBillingAddressFields$payments_core_release() {
            return this.billingAddressFields;
        }

        public final boolean getShouldAttachToCustomer$payments_core_release() {
            return this.shouldAttachToCustomer;
        }

        public final boolean isPaymentSessionActive$payments_core_release() {
            return this.isPaymentSessionActive;
        }

        public final PaymentMethod.Type getPaymentMethodType$payments_core_release() {
            return this.paymentMethodType;
        }

        public final PaymentConfiguration getPaymentConfiguration$payments_core_release() {
            return this.paymentConfiguration;
        }

        public final int getAddPaymentMethodFooterLayoutId$payments_core_release() {
            return this.addPaymentMethodFooterLayoutId;
        }

        public final Integer getWindowFlags$payments_core_release() {
            return this.windowFlags;
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0015J\u0012\u0010\u0016\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\tJ\u0015\u0010\u0019\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001aR\u0012\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "()V", "addPaymentMethodFooterLayoutId", "", "billingAddressFields", "Lcom/stripe/android/view/BillingAddressFields;", "isPaymentSessionActive", "", "paymentConfiguration", "Lcom/stripe/android/PaymentConfiguration;", "paymentMethodType", "Lcom/stripe/android/model/PaymentMethod$Type;", "shouldAttachToCustomer", "windowFlags", "Ljava/lang/Integer;", "build", "setAddPaymentMethodFooter", "setBillingAddressFields", "setIsPaymentSessionActive", "setIsPaymentSessionActive$payments_core_release", "setPaymentConfiguration", "setPaymentMethodType", "setShouldAttachToCustomer", "setWindowFlags", "(Ljava/lang/Integer;)Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args$Builder;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AddPaymentMethodActivityStarter.kt */
        public static final class Builder implements ObjectBuilder<Args> {
            public static final int $stable = 8;
            private int addPaymentMethodFooterLayoutId;
            private BillingAddressFields billingAddressFields = BillingAddressFields.PostalCode;
            private boolean isPaymentSessionActive;
            private PaymentConfiguration paymentConfiguration;
            private PaymentMethod.Type paymentMethodType = PaymentMethod.Type.Card;
            private boolean shouldAttachToCustomer;
            private Integer windowFlags;

            public final Builder setShouldAttachToCustomer(boolean z) {
                Builder builder = this;
                builder.shouldAttachToCustomer = z;
                return builder;
            }

            public final Builder setBillingAddressFields(BillingAddressFields billingAddressFields2) {
                Intrinsics.checkNotNullParameter(billingAddressFields2, "billingAddressFields");
                Builder builder = this;
                builder.billingAddressFields = billingAddressFields2;
                return builder;
            }

            public final Builder setPaymentMethodType(PaymentMethod.Type type) {
                Intrinsics.checkNotNullParameter(type, "paymentMethodType");
                Builder builder = this;
                builder.paymentMethodType = type;
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

            public final /* synthetic */ Builder setIsPaymentSessionActive$payments_core_release(boolean z) {
                Builder builder = this;
                builder.isPaymentSessionActive = z;
                return builder;
            }

            public final /* synthetic */ Builder setPaymentConfiguration(PaymentConfiguration paymentConfiguration2) {
                Builder builder = this;
                builder.paymentConfiguration = paymentConfiguration2;
                return builder;
            }

            public Args build() {
                BillingAddressFields billingAddressFields2 = this.billingAddressFields;
                boolean z = this.shouldAttachToCustomer;
                boolean z2 = this.isPaymentSessionActive;
                PaymentMethod.Type type = this.paymentMethodType;
                if (type == null) {
                    type = PaymentMethod.Type.Card;
                }
                return new Args(billingAddressFields2, z, z2, type, this.paymentConfiguration, this.addPaymentMethodFooterLayoutId, this.windowFlags);
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args$Companion;", "", "()V", "create", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "intent", "Landroid/content/Intent;", "create$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AddPaymentMethodActivityStarter.kt */
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

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00062\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result;", "Lcom/stripe/android/view/ActivityStarter$Result;", "()V", "toBundle", "Landroid/os/Bundle;", "Canceled", "Companion", "Failure", "Success", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result$Success;", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result$Failure;", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result$Canceled;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddPaymentMethodActivityStarter.kt */
    public static abstract class Result implements ActivityStarter.Result {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static final Result fromIntent(Intent intent) {
            return Companion.fromIntent(intent);
        }

        private Result() {
        }

        public Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to("extra_activity_result", this));
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result$Success;", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result;", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "(Lcom/stripe/android/model/PaymentMethod;)V", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AddPaymentMethodActivityStarter.kt */
        public static final class Success extends Result {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Success> CREATOR = new Creator();
            private final PaymentMethod paymentMethod;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AddPaymentMethodActivityStarter.kt */
            public static final class Creator implements Parcelable.Creator<Success> {
                public final Success createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Success(PaymentMethod.CREATOR.createFromParcel(parcel));
                }

                public final Success[] newArray(int i) {
                    return new Success[i];
                }
            }

            public static /* synthetic */ Success copy$default(Success success, PaymentMethod paymentMethod2, int i, Object obj) {
                if ((i & 1) != 0) {
                    paymentMethod2 = success.paymentMethod;
                }
                return success.copy(paymentMethod2);
            }

            public final PaymentMethod component1() {
                return this.paymentMethod;
            }

            public final Success copy(PaymentMethod paymentMethod2) {
                Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
                return new Success(paymentMethod2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) ((Success) obj).paymentMethod);
            }

            public int hashCode() {
                return this.paymentMethod.hashCode();
            }

            public String toString() {
                return "Success(paymentMethod=" + this.paymentMethod + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                this.paymentMethod.writeToParcel(parcel, i);
            }

            public final PaymentMethod getPaymentMethod() {
                return this.paymentMethod;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(PaymentMethod paymentMethod2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
                this.paymentMethod = paymentMethod2;
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result$Failure;", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result;", "exception", "", "(Ljava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AddPaymentMethodActivityStarter.kt */
        public static final class Failure extends Result {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Failure> CREATOR = new Creator();
            private final Throwable exception;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AddPaymentMethodActivityStarter.kt */
            public static final class Creator implements Parcelable.Creator<Failure> {
                public final Failure createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Failure((Throwable) parcel.readSerializable());
                }

                public final Failure[] newArray(int i) {
                    return new Failure[i];
                }
            }

            public static /* synthetic */ Failure copy$default(Failure failure, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = failure.exception;
                }
                return failure.copy(th);
            }

            public final Throwable component1() {
                return this.exception;
            }

            public final Failure copy(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "exception");
                return new Failure(th);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failure) && Intrinsics.areEqual((Object) this.exception, (Object) ((Failure) obj).exception);
            }

            public int hashCode() {
                return this.exception.hashCode();
            }

            public String toString() {
                return "Failure(exception=" + this.exception + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeSerializable(this.exception);
            }

            public final Throwable getException() {
                return this.exception;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failure(Throwable th) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(th, "exception");
                this.exception = th;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result$Canceled;", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AddPaymentMethodActivityStarter.kt */
        public static final class Canceled extends Result {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Canceled> CREATOR = new Creator();
            public static final Canceled INSTANCE = new Canceled();

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AddPaymentMethodActivityStarter.kt */
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

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result$Companion;", "", "()V", "fromIntent", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result;", "intent", "Landroid/content/Intent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AddPaymentMethodActivityStarter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Result fromIntent(Intent intent) {
                Result result = intent == null ? null : (Result) intent.getParcelableExtra("extra_activity_result");
                return result == null ? Canceled.INSTANCE : result;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Companion;", "", "()V", "REQUEST_CODE", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddPaymentMethodActivityStarter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

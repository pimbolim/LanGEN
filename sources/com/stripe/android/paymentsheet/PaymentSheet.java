package com.stripe.android.paymentsheet;

import android.content.res.ColorStateList;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.paymentsheet.flowcontroller.FlowControllerFactory;
import com.stripe.android.paymentsheet.model.PaymentOption;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0006\u0015\u0016\u0017\u0018\u0019\u001aB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u000f\b\u0000\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet;", "", "activity", "Landroidx/activity/ComponentActivity;", "callback", "Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;", "(Landroidx/activity/ComponentActivity;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)V", "paymentSheetLauncher", "Lcom/stripe/android/paymentsheet/PaymentSheetLauncher;", "(Lcom/stripe/android/paymentsheet/PaymentSheetLauncher;)V", "presentWithPaymentIntent", "", "paymentIntentClientSecret", "", "configuration", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "presentWithSetupIntent", "setupIntentClientSecret", "Address", "BillingDetails", "Configuration", "CustomerConfiguration", "FlowController", "GooglePayConfiguration", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheet.kt */
public final class PaymentSheet {
    public static final int $stable = 8;
    private final PaymentSheetLauncher paymentSheetLauncher;

    public final void presentWithPaymentIntent(String str) {
        Intrinsics.checkNotNullParameter(str, "paymentIntentClientSecret");
        presentWithPaymentIntent$default(this, str, (Configuration) null, 2, (Object) null);
    }

    public final void presentWithSetupIntent(String str) {
        Intrinsics.checkNotNullParameter(str, "setupIntentClientSecret");
        presentWithSetupIntent$default(this, str, (Configuration) null, 2, (Object) null);
    }

    public PaymentSheet(PaymentSheetLauncher paymentSheetLauncher2) {
        Intrinsics.checkNotNullParameter(paymentSheetLauncher2, "paymentSheetLauncher");
        this.paymentSheetLauncher = paymentSheetLauncher2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PaymentSheet(ComponentActivity componentActivity, PaymentSheetResultCallback paymentSheetResultCallback) {
        this(new DefaultPaymentSheetLauncher(componentActivity, paymentSheetResultCallback));
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        Intrinsics.checkNotNullParameter(paymentSheetResultCallback, "callback");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PaymentSheet(Fragment fragment, PaymentSheetResultCallback paymentSheetResultCallback) {
        this(new DefaultPaymentSheetLauncher(fragment, paymentSheetResultCallback));
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(paymentSheetResultCallback, "callback");
    }

    public static /* synthetic */ void presentWithPaymentIntent$default(PaymentSheet paymentSheet, String str, Configuration configuration, int i, Object obj) {
        if ((i & 2) != 0) {
            configuration = null;
        }
        paymentSheet.presentWithPaymentIntent(str, configuration);
    }

    public final void presentWithPaymentIntent(String str, Configuration configuration) {
        Intrinsics.checkNotNullParameter(str, "paymentIntentClientSecret");
        this.paymentSheetLauncher.presentWithPaymentIntent(str, configuration);
    }

    public static /* synthetic */ void presentWithSetupIntent$default(PaymentSheet paymentSheet, String str, Configuration configuration, int i, Object obj) {
        if ((i & 2) != 0) {
            configuration = null;
        }
        paymentSheet.presentWithSetupIntent(str, configuration);
    }

    public final void presentWithSetupIntent(String str, Configuration configuration) {
        Intrinsics.checkNotNullParameter(str, "setupIntentClientSecret");
        this.paymentSheetLauncher.presentWithSetupIntent(str, configuration);
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001.BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JM\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020#HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020#HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "Landroid/os/Parcelable;", "merchantDisplayName", "", "customer", "Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "googlePay", "Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "primaryButtonColor", "Landroid/content/res/ColorStateList;", "defaultBillingDetails", "Lcom/stripe/android/paymentsheet/PaymentSheet$BillingDetails;", "allowsDelayedPaymentMethods", "", "(Ljava/lang/String;Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;Landroid/content/res/ColorStateList;Lcom/stripe/android/paymentsheet/PaymentSheet$BillingDetails;Z)V", "getAllowsDelayedPaymentMethods", "()Z", "getCustomer", "()Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "getDefaultBillingDetails", "()Lcom/stripe/android/paymentsheet/PaymentSheet$BillingDetails;", "getGooglePay", "()Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "getMerchantDisplayName", "()Ljava/lang/String;", "getPrimaryButtonColor", "()Landroid/content/res/ColorStateList;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheet.kt */
    public static final class Configuration implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Configuration> CREATOR = new Creator();
        private final boolean allowsDelayedPaymentMethods;
        private final CustomerConfiguration customer;
        private final BillingDetails defaultBillingDetails;
        private final GooglePayConfiguration googlePay;
        private final String merchantDisplayName;
        private final ColorStateList primaryButtonColor;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static final class Creator implements Parcelable.Creator<Configuration> {
            public final Configuration createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                BillingDetails billingDetails = null;
                CustomerConfiguration createFromParcel = parcel.readInt() == 0 ? null : CustomerConfiguration.CREATOR.createFromParcel(parcel);
                GooglePayConfiguration createFromParcel2 = parcel.readInt() == 0 ? null : GooglePayConfiguration.CREATOR.createFromParcel(parcel);
                ColorStateList colorStateList = (ColorStateList) parcel.readParcelable(Configuration.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    billingDetails = BillingDetails.CREATOR.createFromParcel(parcel);
                }
                return new Configuration(readString, createFromParcel, createFromParcel2, colorStateList, billingDetails, parcel.readInt() != 0);
            }

            public final Configuration[] newArray(int i) {
                return new Configuration[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Configuration(String str) {
            this(str, (CustomerConfiguration) null, (GooglePayConfiguration) null, (ColorStateList) null, (BillingDetails) null, false, 62, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "merchantDisplayName");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Configuration(String str, CustomerConfiguration customerConfiguration) {
            this(str, customerConfiguration, (GooglePayConfiguration) null, (ColorStateList) null, (BillingDetails) null, false, 60, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "merchantDisplayName");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Configuration(String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration) {
            this(str, customerConfiguration, googlePayConfiguration, (ColorStateList) null, (BillingDetails) null, false, 56, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "merchantDisplayName");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Configuration(String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration, ColorStateList colorStateList) {
            this(str, customerConfiguration, googlePayConfiguration, colorStateList, (BillingDetails) null, false, 48, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "merchantDisplayName");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Configuration(String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration, ColorStateList colorStateList, BillingDetails billingDetails) {
            this(str, customerConfiguration, googlePayConfiguration, colorStateList, billingDetails, false, 32, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "merchantDisplayName");
        }

        public static /* synthetic */ Configuration copy$default(Configuration configuration, String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration, ColorStateList colorStateList, BillingDetails billingDetails, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = configuration.merchantDisplayName;
            }
            if ((i & 2) != 0) {
                customerConfiguration = configuration.customer;
            }
            CustomerConfiguration customerConfiguration2 = customerConfiguration;
            if ((i & 4) != 0) {
                googlePayConfiguration = configuration.googlePay;
            }
            GooglePayConfiguration googlePayConfiguration2 = googlePayConfiguration;
            if ((i & 8) != 0) {
                colorStateList = configuration.primaryButtonColor;
            }
            ColorStateList colorStateList2 = colorStateList;
            if ((i & 16) != 0) {
                billingDetails = configuration.defaultBillingDetails;
            }
            BillingDetails billingDetails2 = billingDetails;
            if ((i & 32) != 0) {
                z = configuration.allowsDelayedPaymentMethods;
            }
            return configuration.copy(str, customerConfiguration2, googlePayConfiguration2, colorStateList2, billingDetails2, z);
        }

        public final String component1() {
            return this.merchantDisplayName;
        }

        public final CustomerConfiguration component2() {
            return this.customer;
        }

        public final GooglePayConfiguration component3() {
            return this.googlePay;
        }

        public final ColorStateList component4() {
            return this.primaryButtonColor;
        }

        public final BillingDetails component5() {
            return this.defaultBillingDetails;
        }

        public final boolean component6() {
            return this.allowsDelayedPaymentMethods;
        }

        public final Configuration copy(String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration, ColorStateList colorStateList, BillingDetails billingDetails, boolean z) {
            Intrinsics.checkNotNullParameter(str, "merchantDisplayName");
            return new Configuration(str, customerConfiguration, googlePayConfiguration, colorStateList, billingDetails, z);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return Intrinsics.areEqual((Object) this.merchantDisplayName, (Object) configuration.merchantDisplayName) && Intrinsics.areEqual((Object) this.customer, (Object) configuration.customer) && Intrinsics.areEqual((Object) this.googlePay, (Object) configuration.googlePay) && Intrinsics.areEqual((Object) this.primaryButtonColor, (Object) configuration.primaryButtonColor) && Intrinsics.areEqual((Object) this.defaultBillingDetails, (Object) configuration.defaultBillingDetails) && this.allowsDelayedPaymentMethods == configuration.allowsDelayedPaymentMethods;
        }

        public int hashCode() {
            int hashCode = this.merchantDisplayName.hashCode() * 31;
            CustomerConfiguration customerConfiguration = this.customer;
            int i = 0;
            int hashCode2 = (hashCode + (customerConfiguration == null ? 0 : customerConfiguration.hashCode())) * 31;
            GooglePayConfiguration googlePayConfiguration = this.googlePay;
            int hashCode3 = (hashCode2 + (googlePayConfiguration == null ? 0 : googlePayConfiguration.hashCode())) * 31;
            ColorStateList colorStateList = this.primaryButtonColor;
            int hashCode4 = (hashCode3 + (colorStateList == null ? 0 : colorStateList.hashCode())) * 31;
            BillingDetails billingDetails = this.defaultBillingDetails;
            if (billingDetails != null) {
                i = billingDetails.hashCode();
            }
            int i2 = (hashCode4 + i) * 31;
            boolean z = this.allowsDelayedPaymentMethods;
            if (z) {
                z = true;
            }
            return i2 + (z ? 1 : 0);
        }

        public String toString() {
            return "Configuration(merchantDisplayName=" + this.merchantDisplayName + ", customer=" + this.customer + ", googlePay=" + this.googlePay + ", primaryButtonColor=" + this.primaryButtonColor + ", defaultBillingDetails=" + this.defaultBillingDetails + ", allowsDelayedPaymentMethods=" + this.allowsDelayedPaymentMethods + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.merchantDisplayName);
            CustomerConfiguration customerConfiguration = this.customer;
            if (customerConfiguration == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                customerConfiguration.writeToParcel(parcel, i);
            }
            GooglePayConfiguration googlePayConfiguration = this.googlePay;
            if (googlePayConfiguration == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                googlePayConfiguration.writeToParcel(parcel, i);
            }
            parcel.writeParcelable(this.primaryButtonColor, i);
            BillingDetails billingDetails = this.defaultBillingDetails;
            if (billingDetails == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                billingDetails.writeToParcel(parcel, i);
            }
            parcel.writeInt(this.allowsDelayedPaymentMethods ? 1 : 0);
        }

        public Configuration(String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration, ColorStateList colorStateList, BillingDetails billingDetails, boolean z) {
            Intrinsics.checkNotNullParameter(str, "merchantDisplayName");
            this.merchantDisplayName = str;
            this.customer = customerConfiguration;
            this.googlePay = googlePayConfiguration;
            this.primaryButtonColor = colorStateList;
            this.defaultBillingDetails = billingDetails;
            this.allowsDelayedPaymentMethods = z;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Configuration(java.lang.String r6, com.stripe.android.paymentsheet.PaymentSheet.CustomerConfiguration r7, com.stripe.android.paymentsheet.PaymentSheet.GooglePayConfiguration r8, android.content.res.ColorStateList r9, com.stripe.android.paymentsheet.PaymentSheet.BillingDetails r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r5 = this;
                r0 = r12 & 2
                r1 = 0
                if (r0 == 0) goto L_0x0007
                r0 = r1
                goto L_0x0008
            L_0x0007:
                r0 = r7
            L_0x0008:
                r2 = r12 & 4
                if (r2 == 0) goto L_0x000e
                r2 = r1
                goto L_0x000f
            L_0x000e:
                r2 = r8
            L_0x000f:
                r3 = r12 & 8
                if (r3 == 0) goto L_0x0015
                r3 = r1
                goto L_0x0016
            L_0x0015:
                r3 = r9
            L_0x0016:
                r4 = r12 & 16
                if (r4 == 0) goto L_0x001b
                goto L_0x001c
            L_0x001b:
                r1 = r10
            L_0x001c:
                r4 = r12 & 32
                if (r4 == 0) goto L_0x0022
                r4 = 0
                goto L_0x0023
            L_0x0022:
                r4 = r11
            L_0x0023:
                r7 = r5
                r8 = r6
                r9 = r0
                r10 = r2
                r11 = r3
                r12 = r1
                r13 = r4
                r7.<init>(r8, r9, r10, r11, r12, r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentSheet.Configuration.<init>(java.lang.String, com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration, com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration, android.content.res.ColorStateList, com.stripe.android.paymentsheet.PaymentSheet$BillingDetails, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getMerchantDisplayName() {
            return this.merchantDisplayName;
        }

        public final CustomerConfiguration getCustomer() {
            return this.customer;
        }

        public final GooglePayConfiguration getGooglePay() {
            return this.googlePay;
        }

        public final ColorStateList getPrimaryButtonColor() {
            return this.primaryButtonColor;
        }

        public final BillingDetails getDefaultBillingDetails() {
            return this.defaultBillingDetails;
        }

        public final boolean getAllowsDelayedPaymentMethods() {
            return this.allowsDelayedPaymentMethods;
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration$Builder;", "", "merchantDisplayName", "", "(Ljava/lang/String;)V", "allowsDelayedPaymentMethods", "", "customer", "Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "defaultBillingDetails", "Lcom/stripe/android/paymentsheet/PaymentSheet$BillingDetails;", "googlePay", "Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "primaryButtonColor", "Landroid/content/res/ColorStateList;", "build", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static final class Builder {
            public static final int $stable = 8;
            private boolean allowsDelayedPaymentMethods;
            private CustomerConfiguration customer;
            private BillingDetails defaultBillingDetails;
            private GooglePayConfiguration googlePay;
            private String merchantDisplayName;
            private ColorStateList primaryButtonColor;

            public Builder(String str) {
                Intrinsics.checkNotNullParameter(str, "merchantDisplayName");
                this.merchantDisplayName = str;
            }

            public final Builder merchantDisplayName(String str) {
                Intrinsics.checkNotNullParameter(str, "merchantDisplayName");
                Builder builder = this;
                builder.merchantDisplayName = str;
                return builder;
            }

            public final Builder customer(CustomerConfiguration customerConfiguration) {
                Builder builder = this;
                builder.customer = customerConfiguration;
                return builder;
            }

            public final Builder googlePay(GooglePayConfiguration googlePayConfiguration) {
                Builder builder = this;
                builder.googlePay = googlePayConfiguration;
                return builder;
            }

            public final Builder primaryButtonColor(ColorStateList colorStateList) {
                Builder builder = this;
                builder.primaryButtonColor = colorStateList;
                return builder;
            }

            public final Builder defaultBillingDetails(BillingDetails billingDetails) {
                Builder builder = this;
                builder.defaultBillingDetails = billingDetails;
                return builder;
            }

            public final Builder allowsDelayedPaymentMethods(boolean z) {
                Builder builder = this;
                builder.allowsDelayedPaymentMethods = z;
                return builder;
            }

            public final Configuration build() {
                return new Configuration(this.merchantDisplayName, this.customer, this.googlePay, this.primaryButtonColor, this.defaultBillingDetails, this.allowsDelayedPaymentMethods);
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001%BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006&"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$Address;", "Landroid/os/Parcelable;", "city", "", "country", "line1", "line2", "postalCode", "state", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCity", "()Ljava/lang/String;", "getCountry", "getLine1", "getLine2", "getPostalCode", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheet.kt */
    public static final class Address implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Address> CREATOR = new Creator();
        private final String city;
        private final String country;
        private final String line1;
        private final String line2;
        private final String postalCode;
        private final String state;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static final class Creator implements Parcelable.Creator<Address> {
            public final Address createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Address(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final Address[] newArray(int i) {
                return new Address[i];
            }
        }

        public Address() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Address copy$default(Address address, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = address.city;
            }
            if ((i & 2) != 0) {
                str2 = address.country;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = address.line1;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = address.line2;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = address.postalCode;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = address.state;
            }
            return address.copy(str, str7, str8, str9, str10, str6);
        }

        public final String component1() {
            return this.city;
        }

        public final String component2() {
            return this.country;
        }

        public final String component3() {
            return this.line1;
        }

        public final String component4() {
            return this.line2;
        }

        public final String component5() {
            return this.postalCode;
        }

        public final String component6() {
            return this.state;
        }

        public final Address copy(String str, String str2, String str3, String str4, String str5, String str6) {
            return new Address(str, str2, str3, str4, str5, str6);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Address)) {
                return false;
            }
            Address address = (Address) obj;
            return Intrinsics.areEqual((Object) this.city, (Object) address.city) && Intrinsics.areEqual((Object) this.country, (Object) address.country) && Intrinsics.areEqual((Object) this.line1, (Object) address.line1) && Intrinsics.areEqual((Object) this.line2, (Object) address.line2) && Intrinsics.areEqual((Object) this.postalCode, (Object) address.postalCode) && Intrinsics.areEqual((Object) this.state, (Object) address.state);
        }

        public int hashCode() {
            String str = this.city;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.country;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.line1;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.line2;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.postalCode;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.state;
            if (str6 != null) {
                i = str6.hashCode();
            }
            return hashCode5 + i;
        }

        public String toString() {
            return "Address(city=" + this.city + ", country=" + this.country + ", line1=" + this.line1 + ", line2=" + this.line2 + ", postalCode=" + this.postalCode + ", state=" + this.state + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.city);
            parcel.writeString(this.country);
            parcel.writeString(this.line1);
            parcel.writeString(this.line2);
            parcel.writeString(this.postalCode);
            parcel.writeString(this.state);
        }

        public Address(String str, String str2, String str3, String str4, String str5, String str6) {
            this.city = str;
            this.country = str2;
            this.line1 = str3;
            this.line2 = str4;
            this.postalCode = str5;
            this.state = str6;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Address(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r5 = this;
                r13 = r12 & 1
                r0 = 0
                if (r13 == 0) goto L_0x0007
                r13 = r0
                goto L_0x0008
            L_0x0007:
                r13 = r6
            L_0x0008:
                r6 = r12 & 2
                if (r6 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r7
            L_0x000f:
                r6 = r12 & 4
                if (r6 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r8
            L_0x0016:
                r6 = r12 & 8
                if (r6 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r9
            L_0x001d:
                r6 = r12 & 16
                if (r6 == 0) goto L_0x0023
                r4 = r0
                goto L_0x0024
            L_0x0023:
                r4 = r10
            L_0x0024:
                r6 = r12 & 32
                if (r6 == 0) goto L_0x002a
                r12 = r0
                goto L_0x002b
            L_0x002a:
                r12 = r11
            L_0x002b:
                r6 = r5
                r7 = r13
                r8 = r1
                r9 = r2
                r10 = r3
                r11 = r4
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentSheet.Address.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getCity() {
            return this.city;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getLine1() {
            return this.line1;
        }

        public final String getLine2() {
            return this.line2;
        }

        public final String getPostalCode() {
            return this.postalCode;
        }

        public final String getState() {
            return this.state;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$Address$Builder;", "", "()V", "city", "", "country", "line1", "line2", "postalCode", "state", "build", "Lcom/stripe/android/paymentsheet/PaymentSheet$Address;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static final class Builder {
            public static final int $stable = 8;
            private String city;
            private String country;
            private String line1;
            private String line2;
            private String postalCode;
            private String state;

            public final Builder city(String str) {
                Builder builder = this;
                builder.city = str;
                return builder;
            }

            public final Builder country(String str) {
                Builder builder = this;
                builder.country = str;
                return builder;
            }

            public final Builder line1(String str) {
                Builder builder = this;
                builder.line1 = str;
                return builder;
            }

            public final Builder line2(String str) {
                Builder builder = this;
                builder.line2 = str;
                return builder;
            }

            public final Builder postalCode(String str) {
                Builder builder = this;
                builder.postalCode = str;
                return builder;
            }

            public final Builder state(String str) {
                Builder builder = this;
                builder.state = str;
                return builder;
            }

            public final Address build() {
                return new Address(this.city, this.country, this.line1, this.line2, this.postalCode, this.state);
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001!B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\""}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$BillingDetails;", "Landroid/os/Parcelable;", "address", "Lcom/stripe/android/paymentsheet/PaymentSheet$Address;", "email", "", "name", "phone", "(Lcom/stripe/android/paymentsheet/PaymentSheet$Address;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Lcom/stripe/android/paymentsheet/PaymentSheet$Address;", "getEmail", "()Ljava/lang/String;", "getName", "getPhone", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheet.kt */
    public static final class BillingDetails implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<BillingDetails> CREATOR = new Creator();
        private final Address address;
        private final String email;
        private final String name;
        private final String phone;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static final class Creator implements Parcelable.Creator<BillingDetails> {
            public final BillingDetails createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new BillingDetails(parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final BillingDetails[] newArray(int i) {
                return new BillingDetails[i];
            }
        }

        public BillingDetails() {
            this((Address) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ BillingDetails copy$default(BillingDetails billingDetails, Address address2, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                address2 = billingDetails.address;
            }
            if ((i & 2) != 0) {
                str = billingDetails.email;
            }
            if ((i & 4) != 0) {
                str2 = billingDetails.name;
            }
            if ((i & 8) != 0) {
                str3 = billingDetails.phone;
            }
            return billingDetails.copy(address2, str, str2, str3);
        }

        public final Address component1() {
            return this.address;
        }

        public final String component2() {
            return this.email;
        }

        public final String component3() {
            return this.name;
        }

        public final String component4() {
            return this.phone;
        }

        public final BillingDetails copy(Address address2, String str, String str2, String str3) {
            return new BillingDetails(address2, str, str2, str3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BillingDetails)) {
                return false;
            }
            BillingDetails billingDetails = (BillingDetails) obj;
            return Intrinsics.areEqual((Object) this.address, (Object) billingDetails.address) && Intrinsics.areEqual((Object) this.email, (Object) billingDetails.email) && Intrinsics.areEqual((Object) this.name, (Object) billingDetails.name) && Intrinsics.areEqual((Object) this.phone, (Object) billingDetails.phone);
        }

        public int hashCode() {
            Address address2 = this.address;
            int i = 0;
            int hashCode = (address2 == null ? 0 : address2.hashCode()) * 31;
            String str = this.email;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.name;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.phone;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "BillingDetails(address=" + this.address + ", email=" + this.email + ", name=" + this.name + ", phone=" + this.phone + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Address address2 = this.address;
            if (address2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                address2.writeToParcel(parcel, i);
            }
            parcel.writeString(this.email);
            parcel.writeString(this.name);
            parcel.writeString(this.phone);
        }

        public BillingDetails(Address address2, String str, String str2, String str3) {
            this.address = address2;
            this.email = str;
            this.name = str2;
            this.phone = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BillingDetails(Address address2, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : address2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        public final Address getAddress() {
            return this.address;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPhone() {
            return this.phone;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$BillingDetails$Builder;", "", "()V", "address", "Lcom/stripe/android/paymentsheet/PaymentSheet$Address;", "email", "", "name", "phone", "addressBuilder", "Lcom/stripe/android/paymentsheet/PaymentSheet$Address$Builder;", "build", "Lcom/stripe/android/paymentsheet/PaymentSheet$BillingDetails;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static final class Builder {
            public static final int $stable = 8;
            private Address address;
            private String email;
            private String name;
            private String phone;

            public final Builder address(Address address2) {
                Builder builder = this;
                builder.address = address2;
                return builder;
            }

            public final Builder address(Address.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "addressBuilder");
                Builder builder2 = this;
                builder2.address = builder.build();
                return builder2;
            }

            public final Builder email(String str) {
                Builder builder = this;
                builder.email = str;
                return builder;
            }

            public final Builder name(String str) {
                Builder builder = this;
                builder.name = str;
                return builder;
            }

            public final Builder phone(String str) {
                Builder builder = this;
                builder.phone = str;
                return builder;
            }

            public final BillingDetails build() {
                return new BillingDetails(this.address, this.email, this.name, this.phone);
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "Landroid/os/Parcelable;", "id", "", "ephemeralKeySecret", "(Ljava/lang/String;Ljava/lang/String;)V", "getEphemeralKeySecret", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheet.kt */
    public static final class CustomerConfiguration implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<CustomerConfiguration> CREATOR = new Creator();
        private final String ephemeralKeySecret;
        private final String id;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static final class Creator implements Parcelable.Creator<CustomerConfiguration> {
            public final CustomerConfiguration createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CustomerConfiguration(parcel.readString(), parcel.readString());
            }

            public final CustomerConfiguration[] newArray(int i) {
                return new CustomerConfiguration[i];
            }
        }

        public static /* synthetic */ CustomerConfiguration copy$default(CustomerConfiguration customerConfiguration, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = customerConfiguration.id;
            }
            if ((i & 2) != 0) {
                str2 = customerConfiguration.ephemeralKeySecret;
            }
            return customerConfiguration.copy(str, str2);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.ephemeralKeySecret;
        }

        public final CustomerConfiguration copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
            Intrinsics.checkNotNullParameter(str2, "ephemeralKeySecret");
            return new CustomerConfiguration(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomerConfiguration)) {
                return false;
            }
            CustomerConfiguration customerConfiguration = (CustomerConfiguration) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) customerConfiguration.id) && Intrinsics.areEqual((Object) this.ephemeralKeySecret, (Object) customerConfiguration.ephemeralKeySecret);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.ephemeralKeySecret.hashCode();
        }

        public String toString() {
            return "CustomerConfiguration(id=" + this.id + ", ephemeralKeySecret=" + this.ephemeralKeySecret + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.ephemeralKeySecret);
        }

        public CustomerConfiguration(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
            Intrinsics.checkNotNullParameter(str2, "ephemeralKeySecret");
            this.id = str;
            this.ephemeralKeySecret = str2;
        }

        public final String getId() {
            return this.id;
        }

        public final String getEphemeralKeySecret() {
            return this.ephemeralKeySecret;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "Landroid/os/Parcelable;", "environment", "Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;", "countryCode", "", "(Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;Ljava/lang/String;)V", "currencyCode", "(Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getCurrencyCode", "getEnvironment", "()Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Environment", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheet.kt */
    public static final class GooglePayConfiguration implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<GooglePayConfiguration> CREATOR = new Creator();
        private final String countryCode;
        private final String currencyCode;
        private final Environment environment;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static final class Creator implements Parcelable.Creator<GooglePayConfiguration> {
            public final GooglePayConfiguration createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new GooglePayConfiguration(Environment.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
            }

            public final GooglePayConfiguration[] newArray(int i) {
                return new GooglePayConfiguration[i];
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;", "", "(Ljava/lang/String;I)V", "Production", "Test", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public enum Environment {
            Production,
            Test
        }

        public static /* synthetic */ GooglePayConfiguration copy$default(GooglePayConfiguration googlePayConfiguration, Environment environment2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                environment2 = googlePayConfiguration.environment;
            }
            if ((i & 2) != 0) {
                str = googlePayConfiguration.countryCode;
            }
            if ((i & 4) != 0) {
                str2 = googlePayConfiguration.currencyCode;
            }
            return googlePayConfiguration.copy(environment2, str, str2);
        }

        public final Environment component1() {
            return this.environment;
        }

        public final String component2() {
            return this.countryCode;
        }

        public final String component3() {
            return this.currencyCode;
        }

        public final GooglePayConfiguration copy(Environment environment2, String str, String str2) {
            Intrinsics.checkNotNullParameter(environment2, "environment");
            Intrinsics.checkNotNullParameter(str, "countryCode");
            return new GooglePayConfiguration(environment2, str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GooglePayConfiguration)) {
                return false;
            }
            GooglePayConfiguration googlePayConfiguration = (GooglePayConfiguration) obj;
            return this.environment == googlePayConfiguration.environment && Intrinsics.areEqual((Object) this.countryCode, (Object) googlePayConfiguration.countryCode) && Intrinsics.areEqual((Object) this.currencyCode, (Object) googlePayConfiguration.currencyCode);
        }

        public int hashCode() {
            int hashCode = ((this.environment.hashCode() * 31) + this.countryCode.hashCode()) * 31;
            String str = this.currencyCode;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "GooglePayConfiguration(environment=" + this.environment + ", countryCode=" + this.countryCode + ", currencyCode=" + this.currencyCode + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.environment.name());
            parcel.writeString(this.countryCode);
            parcel.writeString(this.currencyCode);
        }

        public GooglePayConfiguration(Environment environment2, String str, String str2) {
            Intrinsics.checkNotNullParameter(environment2, "environment");
            Intrinsics.checkNotNullParameter(str, "countryCode");
            this.environment = environment2;
            this.countryCode = str;
            this.currencyCode = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GooglePayConfiguration(Environment environment2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(environment2, str, (i & 4) != 0 ? null : str2);
        }

        public final Environment getEnvironment() {
            return this.environment;
        }

        public final String getCountryCode() {
            return this.countryCode;
        }

        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public GooglePayConfiguration(Environment environment2, String str) {
            this(environment2, str, (String) null);
            Intrinsics.checkNotNullParameter(environment2, "environment");
            Intrinsics.checkNotNullParameter(str, "countryCode");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J$\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0003H&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController;", "", "configureWithPaymentIntent", "", "paymentIntentClientSecret", "", "configuration", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "callback", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$ConfigCallback;", "configureWithSetupIntent", "setupIntentClientSecret", "confirm", "getPaymentOption", "Lcom/stripe/android/paymentsheet/model/PaymentOption;", "presentPaymentOptions", "Companion", "ConfigCallback", "Result", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheet.kt */
    public interface FlowController {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* renamed from: com.stripe.android.paymentsheet.PaymentSheet$FlowController$-CC  reason: invalid class name */
        /* compiled from: PaymentSheet.kt */
        public final /* synthetic */ class CC {
            @JvmStatic
            public static FlowController create(ComponentActivity componentActivity, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback) {
                return FlowController.Companion.create(componentActivity, paymentOptionCallback, paymentSheetResultCallback);
            }

            @JvmStatic
            public static FlowController create(Fragment fragment, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback) {
                return FlowController.Companion.create(fragment, paymentOptionCallback, paymentSheetResultCallback);
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$ConfigCallback;", "", "onConfigured", "", "success", "", "error", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public interface ConfigCallback {
            void onConfigured(boolean z, Throwable th);
        }

        void configureWithPaymentIntent(String str, Configuration configuration, ConfigCallback configCallback);

        void configureWithSetupIntent(String str, Configuration configuration, ConfigCallback configCallback);

        void confirm();

        PaymentOption getPaymentOption();

        void presentPaymentOptions();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static final class DefaultImpls {
            public static /* synthetic */ void configureWithPaymentIntent$default(FlowController flowController, String str, Configuration configuration, ConfigCallback configCallback, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        configuration = null;
                    }
                    flowController.configureWithPaymentIntent(str, configuration, configCallback);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configureWithPaymentIntent");
            }

            public static /* synthetic */ void configureWithSetupIntent$default(FlowController flowController, String str, Configuration configuration, ConfigCallback configCallback, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        configuration = null;
                    }
                    flowController.configureWithSetupIntent(str, configuration, configCallback);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configureWithSetupIntent");
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result;", "", "()V", "Failure", "Success", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result$Success;", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result$Failure;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static abstract class Result {
            public static final int $stable = 0;

            public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result$Success;", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result;", "()V", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentSheet.kt */
            public static final class Success extends Result {
                public static final int $stable = 0;
                public static final Success INSTANCE = new Success();

                private Success() {
                    super((DefaultConstructorMarker) null);
                }
            }

            private Result() {
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result$Failure;", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentSheet.kt */
            public static final class Failure extends Result {
                public static final int $stable = 8;
                private final Throwable error;

                public final Throwable getError() {
                    return this.error;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Failure(Throwable th) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(th, ReactVideoView.EVENT_PROP_ERROR);
                    this.error = th;
                }
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\r"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Companion;", "", "()V", "create", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController;", "activity", "Landroidx/activity/ComponentActivity;", "paymentOptionCallback", "Lcom/stripe/android/paymentsheet/PaymentOptionCallback;", "paymentResultCallback", "Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;", "fragment", "Landroidx/fragment/app/Fragment;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheet.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            @JvmStatic
            public final FlowController create(ComponentActivity componentActivity, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback) {
                Intrinsics.checkNotNullParameter(componentActivity, "activity");
                Intrinsics.checkNotNullParameter(paymentOptionCallback, "paymentOptionCallback");
                Intrinsics.checkNotNullParameter(paymentSheetResultCallback, "paymentResultCallback");
                return new FlowControllerFactory(componentActivity, paymentOptionCallback, paymentSheetResultCallback).create();
            }

            @JvmStatic
            public final FlowController create(Fragment fragment, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback) {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                Intrinsics.checkNotNullParameter(paymentOptionCallback, "paymentOptionCallback");
                Intrinsics.checkNotNullParameter(paymentSheetResultCallback, "paymentResultCallback");
                return new FlowControllerFactory(fragment, paymentOptionCallback, paymentSheetResultCallback).create();
            }
        }
    }
}

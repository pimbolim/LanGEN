package com.stripe.android.model.wallets;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.Address;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0006\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/model/wallets/Wallet;", "Lcom/stripe/android/core/model/StripeModel;", "walletType", "Lcom/stripe/android/model/wallets/Wallet$Type;", "(Lcom/stripe/android/model/wallets/Wallet$Type;)V", "getWalletType$payments_core_release", "()Lcom/stripe/android/model/wallets/Wallet$Type;", "AmexExpressCheckoutWallet", "ApplePayWallet", "GooglePayWallet", "MasterpassWallet", "SamsungPayWallet", "Type", "VisaCheckoutWallet", "Lcom/stripe/android/model/wallets/Wallet$AmexExpressCheckoutWallet;", "Lcom/stripe/android/model/wallets/Wallet$ApplePayWallet;", "Lcom/stripe/android/model/wallets/Wallet$GooglePayWallet;", "Lcom/stripe/android/model/wallets/Wallet$MasterpassWallet;", "Lcom/stripe/android/model/wallets/Wallet$SamsungPayWallet;", "Lcom/stripe/android/model/wallets/Wallet$VisaCheckoutWallet;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Wallet.kt */
public abstract class Wallet implements StripeModel {
    public static final int $stable = 0;
    private final Type walletType;

    public /* synthetic */ Wallet(Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(type);
    }

    private Wallet(Type type) {
        this.walletType = type;
    }

    public final Type getWalletType$payments_core_release() {
        return this.walletType;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/model/wallets/Wallet$AmexExpressCheckoutWallet;", "Lcom/stripe/android/model/wallets/Wallet;", "dynamicLast4", "", "(Ljava/lang/String;)V", "getDynamicLast4", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Wallet.kt */
    public static final class AmexExpressCheckoutWallet extends Wallet {
        public static final int $stable = 8;
        public static final Parcelable.Creator<AmexExpressCheckoutWallet> CREATOR = new Creator();
        private final String dynamicLast4;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Wallet.kt */
        public static final class Creator implements Parcelable.Creator<AmexExpressCheckoutWallet> {
            public final AmexExpressCheckoutWallet createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AmexExpressCheckoutWallet(parcel.readString());
            }

            public final AmexExpressCheckoutWallet[] newArray(int i) {
                return new AmexExpressCheckoutWallet[i];
            }
        }

        public static /* synthetic */ AmexExpressCheckoutWallet copy$default(AmexExpressCheckoutWallet amexExpressCheckoutWallet, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = amexExpressCheckoutWallet.dynamicLast4;
            }
            return amexExpressCheckoutWallet.copy(str);
        }

        public final String component1() {
            return this.dynamicLast4;
        }

        public final AmexExpressCheckoutWallet copy(String str) {
            return new AmexExpressCheckoutWallet(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AmexExpressCheckoutWallet) && Intrinsics.areEqual((Object) this.dynamicLast4, (Object) ((AmexExpressCheckoutWallet) obj).dynamicLast4);
        }

        public int hashCode() {
            String str = this.dynamicLast4;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "AmexExpressCheckoutWallet(dynamicLast4=" + this.dynamicLast4 + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.dynamicLast4);
        }

        public final String getDynamicLast4() {
            return this.dynamicLast4;
        }

        public AmexExpressCheckoutWallet(String str) {
            super(Type.AmexExpressCheckout, (DefaultConstructorMarker) null);
            this.dynamicLast4 = str;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/model/wallets/Wallet$ApplePayWallet;", "Lcom/stripe/android/model/wallets/Wallet;", "dynamicLast4", "", "(Ljava/lang/String;)V", "getDynamicLast4", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Wallet.kt */
    public static final class ApplePayWallet extends Wallet {
        public static final int $stable = 8;
        public static final Parcelable.Creator<ApplePayWallet> CREATOR = new Creator();
        private final String dynamicLast4;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Wallet.kt */
        public static final class Creator implements Parcelable.Creator<ApplePayWallet> {
            public final ApplePayWallet createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ApplePayWallet(parcel.readString());
            }

            public final ApplePayWallet[] newArray(int i) {
                return new ApplePayWallet[i];
            }
        }

        public static /* synthetic */ ApplePayWallet copy$default(ApplePayWallet applePayWallet, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = applePayWallet.dynamicLast4;
            }
            return applePayWallet.copy(str);
        }

        public final String component1() {
            return this.dynamicLast4;
        }

        public final ApplePayWallet copy(String str) {
            return new ApplePayWallet(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApplePayWallet) && Intrinsics.areEqual((Object) this.dynamicLast4, (Object) ((ApplePayWallet) obj).dynamicLast4);
        }

        public int hashCode() {
            String str = this.dynamicLast4;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "ApplePayWallet(dynamicLast4=" + this.dynamicLast4 + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.dynamicLast4);
        }

        public final String getDynamicLast4() {
            return this.dynamicLast4;
        }

        public ApplePayWallet(String str) {
            super(Type.ApplePay, (DefaultConstructorMarker) null);
            this.dynamicLast4 = str;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/model/wallets/Wallet$GooglePayWallet;", "Lcom/stripe/android/model/wallets/Wallet;", "Landroid/os/Parcelable;", "dynamicLast4", "", "(Ljava/lang/String;)V", "getDynamicLast4", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Wallet.kt */
    public static final class GooglePayWallet extends Wallet implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<GooglePayWallet> CREATOR = new Creator();
        private final String dynamicLast4;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Wallet.kt */
        public static final class Creator implements Parcelable.Creator<GooglePayWallet> {
            public final GooglePayWallet createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new GooglePayWallet(parcel.readString());
            }

            public final GooglePayWallet[] newArray(int i) {
                return new GooglePayWallet[i];
            }
        }

        public static /* synthetic */ GooglePayWallet copy$default(GooglePayWallet googlePayWallet, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = googlePayWallet.dynamicLast4;
            }
            return googlePayWallet.copy(str);
        }

        public final String component1() {
            return this.dynamicLast4;
        }

        public final GooglePayWallet copy(String str) {
            return new GooglePayWallet(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GooglePayWallet) && Intrinsics.areEqual((Object) this.dynamicLast4, (Object) ((GooglePayWallet) obj).dynamicLast4);
        }

        public int hashCode() {
            String str = this.dynamicLast4;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "GooglePayWallet(dynamicLast4=" + this.dynamicLast4 + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.dynamicLast4);
        }

        public final String getDynamicLast4() {
            return this.dynamicLast4;
        }

        public GooglePayWallet(String str) {
            super(Type.GooglePay, (DefaultConstructorMarker) null);
            this.dynamicLast4 = str;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006!"}, d2 = {"Lcom/stripe/android/model/wallets/Wallet$MasterpassWallet;", "Lcom/stripe/android/model/wallets/Wallet;", "billingAddress", "Lcom/stripe/android/model/Address;", "email", "", "name", "shippingAddress", "(Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/Address;)V", "getBillingAddress", "()Lcom/stripe/android/model/Address;", "getEmail", "()Ljava/lang/String;", "getName", "getShippingAddress", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Wallet.kt */
    public static final class MasterpassWallet extends Wallet {
        public static final int $stable = 0;
        public static final Parcelable.Creator<MasterpassWallet> CREATOR = new Creator();
        private final Address billingAddress;
        private final String email;
        private final String name;
        private final Address shippingAddress;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Wallet.kt */
        public static final class Creator implements Parcelable.Creator<MasterpassWallet> {
            public final MasterpassWallet createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Address address = null;
                Address createFromParcel = parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    address = Address.CREATOR.createFromParcel(parcel);
                }
                return new MasterpassWallet(createFromParcel, readString, readString2, address);
            }

            public final MasterpassWallet[] newArray(int i) {
                return new MasterpassWallet[i];
            }
        }

        public static /* synthetic */ MasterpassWallet copy$default(MasterpassWallet masterpassWallet, Address address, String str, String str2, Address address2, int i, Object obj) {
            if ((i & 1) != 0) {
                address = masterpassWallet.billingAddress;
            }
            if ((i & 2) != 0) {
                str = masterpassWallet.email;
            }
            if ((i & 4) != 0) {
                str2 = masterpassWallet.name;
            }
            if ((i & 8) != 0) {
                address2 = masterpassWallet.shippingAddress;
            }
            return masterpassWallet.copy(address, str, str2, address2);
        }

        public final Address component1() {
            return this.billingAddress;
        }

        public final String component2() {
            return this.email;
        }

        public final String component3() {
            return this.name;
        }

        public final Address component4() {
            return this.shippingAddress;
        }

        public final MasterpassWallet copy(Address address, String str, String str2, Address address2) {
            return new MasterpassWallet(address, str, str2, address2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MasterpassWallet)) {
                return false;
            }
            MasterpassWallet masterpassWallet = (MasterpassWallet) obj;
            return Intrinsics.areEqual((Object) this.billingAddress, (Object) masterpassWallet.billingAddress) && Intrinsics.areEqual((Object) this.email, (Object) masterpassWallet.email) && Intrinsics.areEqual((Object) this.name, (Object) masterpassWallet.name) && Intrinsics.areEqual((Object) this.shippingAddress, (Object) masterpassWallet.shippingAddress);
        }

        public int hashCode() {
            Address address = this.billingAddress;
            int i = 0;
            int hashCode = (address == null ? 0 : address.hashCode()) * 31;
            String str = this.email;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.name;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Address address2 = this.shippingAddress;
            if (address2 != null) {
                i = address2.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "MasterpassWallet(billingAddress=" + this.billingAddress + ", email=" + this.email + ", name=" + this.name + ", shippingAddress=" + this.shippingAddress + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Address address = this.billingAddress;
            if (address == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                address.writeToParcel(parcel, i);
            }
            parcel.writeString(this.email);
            parcel.writeString(this.name);
            Address address2 = this.shippingAddress;
            if (address2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            address2.writeToParcel(parcel, i);
        }

        public final Address getBillingAddress() {
            return this.billingAddress;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getName() {
            return this.name;
        }

        public final Address getShippingAddress() {
            return this.shippingAddress;
        }

        public MasterpassWallet(Address address, String str, String str2, Address address2) {
            super(Type.Masterpass, (DefaultConstructorMarker) null);
            this.billingAddress = address;
            this.email = str;
            this.name = str2;
            this.shippingAddress = address2;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/model/wallets/Wallet$SamsungPayWallet;", "Lcom/stripe/android/model/wallets/Wallet;", "dynamicLast4", "", "(Ljava/lang/String;)V", "getDynamicLast4", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Wallet.kt */
    public static final class SamsungPayWallet extends Wallet {
        public static final int $stable = 8;
        public static final Parcelable.Creator<SamsungPayWallet> CREATOR = new Creator();
        private final String dynamicLast4;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Wallet.kt */
        public static final class Creator implements Parcelable.Creator<SamsungPayWallet> {
            public final SamsungPayWallet createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SamsungPayWallet(parcel.readString());
            }

            public final SamsungPayWallet[] newArray(int i) {
                return new SamsungPayWallet[i];
            }
        }

        public static /* synthetic */ SamsungPayWallet copy$default(SamsungPayWallet samsungPayWallet, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = samsungPayWallet.dynamicLast4;
            }
            return samsungPayWallet.copy(str);
        }

        public final String component1() {
            return this.dynamicLast4;
        }

        public final SamsungPayWallet copy(String str) {
            return new SamsungPayWallet(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SamsungPayWallet) && Intrinsics.areEqual((Object) this.dynamicLast4, (Object) ((SamsungPayWallet) obj).dynamicLast4);
        }

        public int hashCode() {
            String str = this.dynamicLast4;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "SamsungPayWallet(dynamicLast4=" + this.dynamicLast4 + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.dynamicLast4);
        }

        public final String getDynamicLast4() {
            return this.dynamicLast4;
        }

        public SamsungPayWallet(String str) {
            super(Type.SamsungPay, (DefaultConstructorMarker) null);
            this.dynamicLast4 = str;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006$"}, d2 = {"Lcom/stripe/android/model/wallets/Wallet$VisaCheckoutWallet;", "Lcom/stripe/android/model/wallets/Wallet;", "billingAddress", "Lcom/stripe/android/model/Address;", "email", "", "name", "shippingAddress", "dynamicLast4", "(Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/Address;Ljava/lang/String;)V", "getBillingAddress", "()Lcom/stripe/android/model/Address;", "getDynamicLast4", "()Ljava/lang/String;", "getEmail", "getName", "getShippingAddress", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Wallet.kt */
    public static final class VisaCheckoutWallet extends Wallet {
        public static final int $stable = 0;
        public static final Parcelable.Creator<VisaCheckoutWallet> CREATOR = new Creator();
        private final Address billingAddress;
        private final String dynamicLast4;
        private final String email;
        private final String name;
        private final Address shippingAddress;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Wallet.kt */
        public static final class Creator implements Parcelable.Creator<VisaCheckoutWallet> {
            public final VisaCheckoutWallet createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Address address = null;
                Address createFromParcel = parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    address = Address.CREATOR.createFromParcel(parcel);
                }
                return new VisaCheckoutWallet(createFromParcel, readString, readString2, address, parcel.readString());
            }

            public final VisaCheckoutWallet[] newArray(int i) {
                return new VisaCheckoutWallet[i];
            }
        }

        public static /* synthetic */ VisaCheckoutWallet copy$default(VisaCheckoutWallet visaCheckoutWallet, Address address, String str, String str2, Address address2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                address = visaCheckoutWallet.billingAddress;
            }
            if ((i & 2) != 0) {
                str = visaCheckoutWallet.email;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = visaCheckoutWallet.name;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                address2 = visaCheckoutWallet.shippingAddress;
            }
            Address address3 = address2;
            if ((i & 16) != 0) {
                str3 = visaCheckoutWallet.dynamicLast4;
            }
            return visaCheckoutWallet.copy(address, str4, str5, address3, str3);
        }

        public final Address component1() {
            return this.billingAddress;
        }

        public final String component2() {
            return this.email;
        }

        public final String component3() {
            return this.name;
        }

        public final Address component4() {
            return this.shippingAddress;
        }

        public final String component5() {
            return this.dynamicLast4;
        }

        public final VisaCheckoutWallet copy(Address address, String str, String str2, Address address2, String str3) {
            return new VisaCheckoutWallet(address, str, str2, address2, str3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VisaCheckoutWallet)) {
                return false;
            }
            VisaCheckoutWallet visaCheckoutWallet = (VisaCheckoutWallet) obj;
            return Intrinsics.areEqual((Object) this.billingAddress, (Object) visaCheckoutWallet.billingAddress) && Intrinsics.areEqual((Object) this.email, (Object) visaCheckoutWallet.email) && Intrinsics.areEqual((Object) this.name, (Object) visaCheckoutWallet.name) && Intrinsics.areEqual((Object) this.shippingAddress, (Object) visaCheckoutWallet.shippingAddress) && Intrinsics.areEqual((Object) this.dynamicLast4, (Object) visaCheckoutWallet.dynamicLast4);
        }

        public int hashCode() {
            Address address = this.billingAddress;
            int i = 0;
            int hashCode = (address == null ? 0 : address.hashCode()) * 31;
            String str = this.email;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.name;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Address address2 = this.shippingAddress;
            int hashCode4 = (hashCode3 + (address2 == null ? 0 : address2.hashCode())) * 31;
            String str3 = this.dynamicLast4;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            return "VisaCheckoutWallet(billingAddress=" + this.billingAddress + ", email=" + this.email + ", name=" + this.name + ", shippingAddress=" + this.shippingAddress + ", dynamicLast4=" + this.dynamicLast4 + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Address address = this.billingAddress;
            if (address == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                address.writeToParcel(parcel, i);
            }
            parcel.writeString(this.email);
            parcel.writeString(this.name);
            Address address2 = this.shippingAddress;
            if (address2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                address2.writeToParcel(parcel, i);
            }
            parcel.writeString(this.dynamicLast4);
        }

        public final Address getBillingAddress() {
            return this.billingAddress;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getName() {
            return this.name;
        }

        public final Address getShippingAddress() {
            return this.shippingAddress;
        }

        public final String getDynamicLast4() {
            return this.dynamicLast4;
        }

        public VisaCheckoutWallet(Address address, String str, String str2, Address address2, String str3) {
            super(Type.VisaCheckout, (DefaultConstructorMarker) null);
            this.billingAddress = address;
            this.email = str;
            this.name = str2;
            this.shippingAddress = address2;
            this.dynamicLast4 = str3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/model/wallets/Wallet$Type;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "AmexExpressCheckout", "ApplePay", "GooglePay", "Masterpass", "SamsungPay", "VisaCheckout", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Wallet.kt */
    public enum Type {
        AmexExpressCheckout("amex_express_checkout"),
        ApplePay("apple_pay"),
        GooglePay("google_pay"),
        Masterpass("master_pass"),
        SamsungPay("samsung_pay"),
        VisaCheckout("visa_checkout");
        
        public static final Companion Companion = null;
        private final String code;

        private Type(String str) {
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/wallets/Wallet$Type$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/wallets/Wallet$Type;", "code", "", "fromCode$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Wallet.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Type fromCode$payments_core_release(String str) {
                Type[] values = Type.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Type type = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) type.getCode(), (Object) str)) {
                        return type;
                    }
                }
                return null;
            }
        }
    }
}

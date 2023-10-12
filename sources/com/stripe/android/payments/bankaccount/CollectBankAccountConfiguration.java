package com.stripe.android.payments.bankaccount;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;", "Landroid/os/Parcelable;", "()V", "USBankAccount", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration$USBankAccount;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountLauncher.kt */
public abstract class CollectBankAccountConfiguration implements Parcelable {
    public static final int $stable = 0;

    public /* synthetic */ CollectBankAccountConfiguration(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CollectBankAccountConfiguration() {
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration$USBankAccount;", "Landroid/os/Parcelable;", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;", "name", "", "email", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectBankAccountLauncher.kt */
    public static final class USBankAccount extends CollectBankAccountConfiguration implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<USBankAccount> CREATOR = new Creator();
        private final String email;
        private final String name;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CollectBankAccountLauncher.kt */
        public static final class Creator implements Parcelable.Creator<USBankAccount> {
            public final USBankAccount createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new USBankAccount(parcel.readString(), parcel.readString());
            }

            public final USBankAccount[] newArray(int i) {
                return new USBankAccount[i];
            }
        }

        public static /* synthetic */ USBankAccount copy$default(USBankAccount uSBankAccount, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = uSBankAccount.name;
            }
            if ((i & 2) != 0) {
                str2 = uSBankAccount.email;
            }
            return uSBankAccount.copy(str, str2);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.email;
        }

        public final USBankAccount copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new USBankAccount(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof USBankAccount)) {
                return false;
            }
            USBankAccount uSBankAccount = (USBankAccount) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) uSBankAccount.name) && Intrinsics.areEqual((Object) this.email, (Object) uSBankAccount.email);
        }

        public int hashCode() {
            int hashCode = this.name.hashCode() * 31;
            String str = this.email;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "USBankAccount(name=" + this.name + ", email=" + this.email + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.name);
            parcel.writeString(this.email);
        }

        public final String getName() {
            return this.name;
        }

        public final String getEmail() {
            return this.email;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public USBankAccount(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "name");
            this.name = str;
            this.email = str2;
        }
    }
}

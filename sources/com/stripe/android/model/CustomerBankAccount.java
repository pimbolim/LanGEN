package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/model/CustomerBankAccount;", "Lcom/stripe/android/model/CustomerPaymentSource;", "bankAccount", "Lcom/stripe/android/model/BankAccount;", "(Lcom/stripe/android/model/BankAccount;)V", "getBankAccount", "()Lcom/stripe/android/model/BankAccount;", "id", "", "getId", "()Ljava/lang/String;", "tokenizationMethod", "Lcom/stripe/android/model/TokenizationMethod;", "getTokenizationMethod", "()Lcom/stripe/android/model/TokenizationMethod;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerSource.kt */
public final class CustomerBankAccount extends CustomerPaymentSource {
    public static final int $stable = 8;
    public static final Parcelable.Creator<CustomerBankAccount> CREATOR = new Creator();
    private final BankAccount bankAccount;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerSource.kt */
    public static final class Creator implements Parcelable.Creator<CustomerBankAccount> {
        public final CustomerBankAccount createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CustomerBankAccount((BankAccount) parcel.readParcelable(CustomerBankAccount.class.getClassLoader()));
        }

        public final CustomerBankAccount[] newArray(int i) {
            return new CustomerBankAccount[i];
        }
    }

    public static /* synthetic */ CustomerBankAccount copy$default(CustomerBankAccount customerBankAccount, BankAccount bankAccount2, int i, Object obj) {
        if ((i & 1) != 0) {
            bankAccount2 = customerBankAccount.bankAccount;
        }
        return customerBankAccount.copy(bankAccount2);
    }

    public final BankAccount component1() {
        return this.bankAccount;
    }

    public final CustomerBankAccount copy(BankAccount bankAccount2) {
        Intrinsics.checkNotNullParameter(bankAccount2, "bankAccount");
        return new CustomerBankAccount(bankAccount2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomerBankAccount) && Intrinsics.areEqual((Object) this.bankAccount, (Object) ((CustomerBankAccount) obj).bankAccount);
    }

    public TokenizationMethod getTokenizationMethod() {
        return null;
    }

    public int hashCode() {
        return this.bankAccount.hashCode();
    }

    public String toString() {
        return "CustomerBankAccount(bankAccount=" + this.bankAccount + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.bankAccount, i);
    }

    public final BankAccount getBankAccount() {
        return this.bankAccount;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerBankAccount(BankAccount bankAccount2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(bankAccount2, "bankAccount");
        this.bankAccount = bankAccount2;
    }

    public String getId() {
        return this.bankAccount.getId();
    }
}

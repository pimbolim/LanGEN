package com.stripe.android.paymentsheet.paymentdatacollection;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import com.stripe.android.ui.core.Amount;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0001\u0010\r\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003JS\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\r\u001a\u00020\bHÆ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020$HÖ\u0001J\t\u0010)\u001a\u00020\bHÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020$HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006/"}, d2 = {"Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;", "Landroid/os/Parcelable;", "paymentMethod", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "showCheckbox", "", "showCheckboxControlledFields", "merchantName", "", "amount", "Lcom/stripe/android/ui/core/Amount;", "billingDetails", "Lcom/stripe/android/paymentsheet/PaymentSheet$BillingDetails;", "injectorKey", "(Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;ZZLjava/lang/String;Lcom/stripe/android/ui/core/Amount;Lcom/stripe/android/paymentsheet/PaymentSheet$BillingDetails;Ljava/lang/String;)V", "getAmount", "()Lcom/stripe/android/ui/core/Amount;", "getBillingDetails", "()Lcom/stripe/android/paymentsheet/PaymentSheet$BillingDetails;", "getInjectorKey", "()Ljava/lang/String;", "getMerchantName", "getPaymentMethod", "()Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "getShowCheckbox", "()Z", "getShowCheckboxControlledFields", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormFragmentArguments.kt */
public final class FormFragmentArguments implements Parcelable {
    public static final Parcelable.Creator<FormFragmentArguments> CREATOR = new Creator();
    private final Amount amount;
    private final PaymentSheet.BillingDetails billingDetails;
    private final String injectorKey;
    private final String merchantName;
    private final SupportedPaymentMethod paymentMethod;
    private final boolean showCheckbox;
    private final boolean showCheckboxControlledFields;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormFragmentArguments.kt */
    public static final class Creator implements Parcelable.Creator<FormFragmentArguments> {
        public final FormFragmentArguments createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            SupportedPaymentMethod supportedPaymentMethod = (SupportedPaymentMethod) parcel.readParcelable(FormFragmentArguments.class.getClassLoader());
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new FormFragmentArguments(supportedPaymentMethod, z2, z, parcel.readString(), (Amount) parcel.readParcelable(FormFragmentArguments.class.getClassLoader()), parcel.readInt() == 0 ? null : PaymentSheet.BillingDetails.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        public final FormFragmentArguments[] newArray(int i) {
            return new FormFragmentArguments[i];
        }
    }

    public static /* synthetic */ FormFragmentArguments copy$default(FormFragmentArguments formFragmentArguments, SupportedPaymentMethod supportedPaymentMethod, boolean z, boolean z2, String str, Amount amount2, PaymentSheet.BillingDetails billingDetails2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            supportedPaymentMethod = formFragmentArguments.paymentMethod;
        }
        if ((i & 2) != 0) {
            z = formFragmentArguments.showCheckbox;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            z2 = formFragmentArguments.showCheckboxControlledFields;
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            str = formFragmentArguments.merchantName;
        }
        String str3 = str;
        if ((i & 16) != 0) {
            amount2 = formFragmentArguments.amount;
        }
        Amount amount3 = amount2;
        if ((i & 32) != 0) {
            billingDetails2 = formFragmentArguments.billingDetails;
        }
        PaymentSheet.BillingDetails billingDetails3 = billingDetails2;
        if ((i & 64) != 0) {
            str2 = formFragmentArguments.injectorKey;
        }
        return formFragmentArguments.copy(supportedPaymentMethod, z3, z4, str3, amount3, billingDetails3, str2);
    }

    public final SupportedPaymentMethod component1() {
        return this.paymentMethod;
    }

    public final boolean component2() {
        return this.showCheckbox;
    }

    public final boolean component3() {
        return this.showCheckboxControlledFields;
    }

    public final String component4() {
        return this.merchantName;
    }

    public final Amount component5() {
        return this.amount;
    }

    public final PaymentSheet.BillingDetails component6() {
        return this.billingDetails;
    }

    public final String component7() {
        return this.injectorKey;
    }

    public final FormFragmentArguments copy(SupportedPaymentMethod supportedPaymentMethod, boolean z, boolean z2, String str, Amount amount2, PaymentSheet.BillingDetails billingDetails2, @InjectorKey String str2) {
        Intrinsics.checkNotNullParameter(supportedPaymentMethod, "paymentMethod");
        Intrinsics.checkNotNullParameter(str, "merchantName");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "injectorKey");
        return new FormFragmentArguments(supportedPaymentMethod, z, z2, str, amount2, billingDetails2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormFragmentArguments)) {
            return false;
        }
        FormFragmentArguments formFragmentArguments = (FormFragmentArguments) obj;
        return Intrinsics.areEqual((Object) this.paymentMethod, (Object) formFragmentArguments.paymentMethod) && this.showCheckbox == formFragmentArguments.showCheckbox && this.showCheckboxControlledFields == formFragmentArguments.showCheckboxControlledFields && Intrinsics.areEqual((Object) this.merchantName, (Object) formFragmentArguments.merchantName) && Intrinsics.areEqual((Object) this.amount, (Object) formFragmentArguments.amount) && Intrinsics.areEqual((Object) this.billingDetails, (Object) formFragmentArguments.billingDetails) && Intrinsics.areEqual((Object) this.injectorKey, (Object) formFragmentArguments.injectorKey);
    }

    public int hashCode() {
        int hashCode = this.paymentMethod.hashCode() * 31;
        boolean z = this.showCheckbox;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.showCheckboxControlledFields;
        if (!z3) {
            z2 = z3;
        }
        int hashCode2 = (((i + (z2 ? 1 : 0)) * 31) + this.merchantName.hashCode()) * 31;
        Amount amount2 = this.amount;
        int i2 = 0;
        int hashCode3 = (hashCode2 + (amount2 == null ? 0 : amount2.hashCode())) * 31;
        PaymentSheet.BillingDetails billingDetails2 = this.billingDetails;
        if (billingDetails2 != null) {
            i2 = billingDetails2.hashCode();
        }
        return ((hashCode3 + i2) * 31) + this.injectorKey.hashCode();
    }

    public String toString() {
        return "FormFragmentArguments(paymentMethod=" + this.paymentMethod + ", showCheckbox=" + this.showCheckbox + ", showCheckboxControlledFields=" + this.showCheckboxControlledFields + ", merchantName=" + this.merchantName + ", amount=" + this.amount + ", billingDetails=" + this.billingDetails + ", injectorKey=" + this.injectorKey + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.paymentMethod, i);
        parcel.writeInt(this.showCheckbox ? 1 : 0);
        parcel.writeInt(this.showCheckboxControlledFields ? 1 : 0);
        parcel.writeString(this.merchantName);
        parcel.writeParcelable(this.amount, i);
        PaymentSheet.BillingDetails billingDetails2 = this.billingDetails;
        if (billingDetails2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            billingDetails2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.injectorKey);
    }

    public FormFragmentArguments(SupportedPaymentMethod supportedPaymentMethod, boolean z, boolean z2, String str, Amount amount2, PaymentSheet.BillingDetails billingDetails2, @InjectorKey String str2) {
        Intrinsics.checkNotNullParameter(supportedPaymentMethod, "paymentMethod");
        Intrinsics.checkNotNullParameter(str, "merchantName");
        Intrinsics.checkNotNullParameter(str2, "injectorKey");
        this.paymentMethod = supportedPaymentMethod;
        this.showCheckbox = z;
        this.showCheckboxControlledFields = z2;
        this.merchantName = str;
        this.amount = amount2;
        this.billingDetails = billingDetails2;
        this.injectorKey = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormFragmentArguments(SupportedPaymentMethod supportedPaymentMethod, boolean z, boolean z2, String str, Amount amount2, PaymentSheet.BillingDetails billingDetails2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(supportedPaymentMethod, z, z2, str, (i & 16) != 0 ? null : amount2, (i & 32) != 0 ? null : billingDetails2, str2);
    }

    public final SupportedPaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public final boolean getShowCheckbox() {
        return this.showCheckbox;
    }

    public final boolean getShowCheckboxControlledFields() {
        return this.showCheckboxControlledFields;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final PaymentSheet.BillingDetails getBillingDetails() {
        return this.billingDetails;
    }

    public final String getInjectorKey() {
        return this.injectorKey;
    }
}

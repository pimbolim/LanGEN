package com.stripe.android.googlepaylauncher;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0012\u0010&\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b'\u0010\u000fJ\u000e\u0010(\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b)J\u000e\u0010*\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b+J\u000e\u0010,\u001a\u00020\nHÀ\u0003¢\u0006\u0002\b-J\u0010\u0010.\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b/J\u0010\u00100\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b1JZ\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u00103J\t\u00104\u001a\u00020\u0005HÖ\u0001J\u0013\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0005HÖ\u0001J\t\u00109\u001a\u00020\u0007HÖ\u0001J\u0019\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u0006?"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayConfig;", "Landroid/os/Parcelable;", "environment", "Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "amount", "", "countryCode", "", "currencyCode", "isEmailRequired", "", "merchantName", "transactionId", "(Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getAmount$payments_core_release", "()Ljava/lang/Integer;", "setAmount$payments_core_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCountryCode$payments_core_release", "()Ljava/lang/String;", "setCountryCode$payments_core_release", "(Ljava/lang/String;)V", "getCurrencyCode$payments_core_release", "setCurrencyCode$payments_core_release", "getEnvironment", "()Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "setEnvironment", "(Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;)V", "isEmailRequired$payments_core_release", "()Z", "setEmailRequired$payments_core_release", "(Z)V", "getMerchantName$payments_core_release", "setMerchantName$payments_core_release", "getTransactionId$payments_core_release", "setTransactionId$payments_core_release", "component1", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "component6", "component6$payments_core_release", "component7", "component7$payments_core_release", "copy", "(Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lcom/stripe/android/googlepaylauncher/GooglePayConfig;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayConfig.kt */
public final class GooglePayConfig implements Parcelable {
    public static final Parcelable.Creator<GooglePayConfig> CREATOR = new Creator();
    private Integer amount;
    private String countryCode;
    private String currencyCode;
    private GooglePayEnvironment environment;
    private boolean isEmailRequired;
    private String merchantName;
    private String transactionId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayConfig.kt */
    public static final class Creator implements Parcelable.Creator<GooglePayConfig> {
        public final GooglePayConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GooglePayConfig(GooglePayEnvironment.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        public final GooglePayConfig[] newArray(int i) {
            return new GooglePayConfig[i];
        }
    }

    public static /* synthetic */ GooglePayConfig copy$default(GooglePayConfig googlePayConfig, GooglePayEnvironment googlePayEnvironment, Integer num, String str, String str2, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            googlePayEnvironment = googlePayConfig.environment;
        }
        if ((i & 2) != 0) {
            num = googlePayConfig.amount;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            str = googlePayConfig.countryCode;
        }
        String str5 = str;
        if ((i & 8) != 0) {
            str2 = googlePayConfig.currencyCode;
        }
        String str6 = str2;
        if ((i & 16) != 0) {
            z = googlePayConfig.isEmailRequired;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str3 = googlePayConfig.merchantName;
        }
        String str7 = str3;
        if ((i & 64) != 0) {
            str4 = googlePayConfig.transactionId;
        }
        return googlePayConfig.copy(googlePayEnvironment, num2, str5, str6, z2, str7, str4);
    }

    public final GooglePayEnvironment component1() {
        return this.environment;
    }

    public final Integer component2$payments_core_release() {
        return this.amount;
    }

    public final String component3$payments_core_release() {
        return this.countryCode;
    }

    public final String component4$payments_core_release() {
        return this.currencyCode;
    }

    public final boolean component5$payments_core_release() {
        return this.isEmailRequired;
    }

    public final String component6$payments_core_release() {
        return this.merchantName;
    }

    public final String component7$payments_core_release() {
        return this.transactionId;
    }

    public final GooglePayConfig copy(GooglePayEnvironment googlePayEnvironment, Integer num, String str, String str2, boolean z, String str3, String str4) {
        Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(str2, "currencyCode");
        return new GooglePayConfig(googlePayEnvironment, num, str, str2, z, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GooglePayConfig)) {
            return false;
        }
        GooglePayConfig googlePayConfig = (GooglePayConfig) obj;
        return this.environment == googlePayConfig.environment && Intrinsics.areEqual((Object) this.amount, (Object) googlePayConfig.amount) && Intrinsics.areEqual((Object) this.countryCode, (Object) googlePayConfig.countryCode) && Intrinsics.areEqual((Object) this.currencyCode, (Object) googlePayConfig.currencyCode) && this.isEmailRequired == googlePayConfig.isEmailRequired && Intrinsics.areEqual((Object) this.merchantName, (Object) googlePayConfig.merchantName) && Intrinsics.areEqual((Object) this.transactionId, (Object) googlePayConfig.transactionId);
    }

    public int hashCode() {
        int hashCode = this.environment.hashCode() * 31;
        Integer num = this.amount;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.countryCode.hashCode()) * 31) + this.currencyCode.hashCode()) * 31;
        boolean z = this.isEmailRequired;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str = this.merchantName;
        int hashCode3 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.transactionId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "GooglePayConfig(environment=" + this.environment + ", amount=" + this.amount + ", countryCode=" + this.countryCode + ", currencyCode=" + this.currencyCode + ", isEmailRequired=" + this.isEmailRequired + ", merchantName=" + this.merchantName + ", transactionId=" + this.transactionId + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.environment.name());
        Integer num = this.amount;
        if (num == null) {
            i2 = 0;
        } else {
            parcel.writeInt(1);
            i2 = num.intValue();
        }
        parcel.writeInt(i2);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.currencyCode);
        parcel.writeInt(this.isEmailRequired ? 1 : 0);
        parcel.writeString(this.merchantName);
        parcel.writeString(this.transactionId);
    }

    public GooglePayConfig(GooglePayEnvironment googlePayEnvironment, Integer num, String str, String str2, boolean z, String str3, String str4) {
        Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(str2, "currencyCode");
        this.environment = googlePayEnvironment;
        this.amount = num;
        this.countryCode = str;
        this.currencyCode = str2;
        this.isEmailRequired = z;
        this.merchantName = str3;
        this.transactionId = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GooglePayConfig(GooglePayEnvironment googlePayEnvironment, Integer num, String str, String str2, boolean z, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(googlePayEnvironment, num, str, str2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4);
    }

    public final GooglePayEnvironment getEnvironment() {
        return this.environment;
    }

    public final void setEnvironment(GooglePayEnvironment googlePayEnvironment) {
        Intrinsics.checkNotNullParameter(googlePayEnvironment, "<set-?>");
        this.environment = googlePayEnvironment;
    }

    public final Integer getAmount$payments_core_release() {
        return this.amount;
    }

    public final void setAmount$payments_core_release(Integer num) {
        this.amount = num;
    }

    public final String getCountryCode$payments_core_release() {
        return this.countryCode;
    }

    public final void setCountryCode$payments_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countryCode = str;
    }

    public final String getCurrencyCode$payments_core_release() {
        return this.currencyCode;
    }

    public final void setCurrencyCode$payments_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currencyCode = str;
    }

    public final boolean isEmailRequired$payments_core_release() {
        return this.isEmailRequired;
    }

    public final void setEmailRequired$payments_core_release(boolean z) {
        this.isEmailRequired = z;
    }

    public final String getMerchantName$payments_core_release() {
        return this.merchantName;
    }

    public final void setMerchantName$payments_core_release(String str) {
        this.merchantName = str;
    }

    public final String getTransactionId$payments_core_release() {
        return this.transactionId;
    }

    public final void setTransactionId$payments_core_release(String str) {
        this.transactionId = str;
    }
}

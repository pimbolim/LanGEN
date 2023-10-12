package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001(B+\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\tHÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/stripe/android/model/AccountRange;", "Lcom/stripe/android/core/model/StripeModel;", "binRange", "Lcom/stripe/android/model/BinRange;", "panLength", "", "brandInfo", "Lcom/stripe/android/model/AccountRange$BrandInfo;", "country", "", "(Lcom/stripe/android/model/BinRange;ILcom/stripe/android/model/AccountRange$BrandInfo;Ljava/lang/String;)V", "getBinRange", "()Lcom/stripe/android/model/BinRange;", "brand", "Lcom/stripe/android/model/CardBrand;", "getBrand", "()Lcom/stripe/android/model/CardBrand;", "getBrandInfo", "()Lcom/stripe/android/model/AccountRange$BrandInfo;", "getCountry", "()Ljava/lang/String;", "getPanLength", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "BrandInfo", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountRange.kt */
public final class AccountRange implements StripeModel {
    public static final int $stable = 0;
    public static final Parcelable.Creator<AccountRange> CREATOR = new Creator();
    private final BinRange binRange;
    private final BrandInfo brandInfo;
    private final String country;
    private final int panLength;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountRange.kt */
    public static final class Creator implements Parcelable.Creator<AccountRange> {
        public final AccountRange createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AccountRange(BinRange.CREATOR.createFromParcel(parcel), parcel.readInt(), BrandInfo.valueOf(parcel.readString()), parcel.readString());
        }

        public final AccountRange[] newArray(int i) {
            return new AccountRange[i];
        }
    }

    public static /* synthetic */ AccountRange copy$default(AccountRange accountRange, BinRange binRange2, int i, BrandInfo brandInfo2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            binRange2 = accountRange.binRange;
        }
        if ((i2 & 2) != 0) {
            i = accountRange.panLength;
        }
        if ((i2 & 4) != 0) {
            brandInfo2 = accountRange.brandInfo;
        }
        if ((i2 & 8) != 0) {
            str = accountRange.country;
        }
        return accountRange.copy(binRange2, i, brandInfo2, str);
    }

    public final BinRange component1() {
        return this.binRange;
    }

    public final int component2() {
        return this.panLength;
    }

    public final BrandInfo component3() {
        return this.brandInfo;
    }

    public final String component4() {
        return this.country;
    }

    public final AccountRange copy(BinRange binRange2, int i, BrandInfo brandInfo2, String str) {
        Intrinsics.checkNotNullParameter(binRange2, "binRange");
        Intrinsics.checkNotNullParameter(brandInfo2, "brandInfo");
        return new AccountRange(binRange2, i, brandInfo2, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountRange)) {
            return false;
        }
        AccountRange accountRange = (AccountRange) obj;
        return Intrinsics.areEqual((Object) this.binRange, (Object) accountRange.binRange) && this.panLength == accountRange.panLength && this.brandInfo == accountRange.brandInfo && Intrinsics.areEqual((Object) this.country, (Object) accountRange.country);
    }

    public int hashCode() {
        int hashCode = ((((this.binRange.hashCode() * 31) + this.panLength) * 31) + this.brandInfo.hashCode()) * 31;
        String str = this.country;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AccountRange(binRange=" + this.binRange + ", panLength=" + this.panLength + ", brandInfo=" + this.brandInfo + ", country=" + this.country + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.binRange.writeToParcel(parcel, i);
        parcel.writeInt(this.panLength);
        parcel.writeString(this.brandInfo.name());
        parcel.writeString(this.country);
    }

    public AccountRange(BinRange binRange2, int i, BrandInfo brandInfo2, String str) {
        Intrinsics.checkNotNullParameter(binRange2, "binRange");
        Intrinsics.checkNotNullParameter(brandInfo2, "brandInfo");
        this.binRange = binRange2;
        this.panLength = i;
        this.brandInfo = brandInfo2;
        this.country = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountRange(BinRange binRange2, int i, BrandInfo brandInfo2, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(binRange2, i, brandInfo2, (i2 & 8) != 0 ? null : str);
    }

    public final BinRange getBinRange() {
        return this.binRange;
    }

    public final int getPanLength() {
        return this.panLength;
    }

    public final BrandInfo getBrandInfo() {
        return this.brandInfo;
    }

    public final String getCountry() {
        return this.country;
    }

    public final CardBrand getBrand() {
        return this.brandInfo.getBrand();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/model/AccountRange$BrandInfo;", "", "brandName", "", "brand", "Lcom/stripe/android/model/CardBrand;", "(Ljava/lang/String;ILjava/lang/String;Lcom/stripe/android/model/CardBrand;)V", "getBrand", "()Lcom/stripe/android/model/CardBrand;", "getBrandName", "()Ljava/lang/String;", "Visa", "Mastercard", "AmericanExpress", "JCB", "DinersClub", "Discover", "UnionPay", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountRange.kt */
    public enum BrandInfo {
        Visa("VISA", CardBrand.Visa),
        Mastercard("MASTERCARD", CardBrand.MasterCard),
        AmericanExpress("AMERICAN_EXPRESS", CardBrand.AmericanExpress),
        JCB("JCB", CardBrand.JCB),
        DinersClub("DINERS_CLUB", CardBrand.DinersClub),
        Discover("DISCOVER", CardBrand.Discover),
        UnionPay("UNIONPAY", CardBrand.UnionPay);
        
        private final CardBrand brand;
        private final String brandName;

        private BrandInfo(String str, CardBrand cardBrand) {
            this.brandName = str;
            this.brand = cardBrand;
        }

        public final String getBrandName() {
            return this.brandName;
        }

        public final CardBrand getBrand() {
            return this.brand;
        }
    }
}

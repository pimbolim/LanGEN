package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001\\Bù\u0001\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\u0010\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0012HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0002\u0010N\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÆ\u0001¢\u0006\u0002\u0010OJ\t\u0010P\u001a\u00020\u0004HÖ\u0001J\u0013\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010THÖ\u0003J\t\u0010U\u001a\u00020\u0004HÖ\u0001J\t\u0010V\u001a\u00020\u0007HÖ\u0001J\u0019\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0007¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b0\u0010.R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001fR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006]"}, d2 = {"Lcom/stripe/android/model/Card;", "Lcom/stripe/android/core/model/StripeModel;", "Lcom/stripe/android/model/StripePaymentSource;", "expMonth", "", "expYear", "name", "", "addressLine1", "addressLine1Check", "addressLine2", "addressCity", "addressState", "addressZip", "addressZipCheck", "addressCountry", "last4", "brand", "Lcom/stripe/android/model/CardBrand;", "funding", "Lcom/stripe/android/model/CardFunding;", "fingerprint", "country", "currency", "customerId", "cvcCheck", "id", "tokenizationMethod", "Lcom/stripe/android/model/TokenizationMethod;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/CardBrand;Lcom/stripe/android/model/CardFunding;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/TokenizationMethod;)V", "getAddressCity", "()Ljava/lang/String;", "getAddressCountry", "getAddressLine1", "getAddressLine1Check", "getAddressLine2", "getAddressState", "getAddressZip", "getAddressZipCheck", "getBrand", "()Lcom/stripe/android/model/CardBrand;", "getCountry", "getCurrency", "getCustomerId", "getCvcCheck", "getExpMonth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExpYear", "getFingerprint", "getFunding", "()Lcom/stripe/android/model/CardFunding;", "getId", "getLast4", "getName", "getTokenizationMethod", "()Lcom/stripe/android/model/TokenizationMethod;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/CardBrand;Lcom/stripe/android/model/CardFunding;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/TokenizationMethod;)Lcom/stripe/android/model/Card;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Card.kt */
public final class Card implements StripeModel, StripePaymentSource {
    public static final Parcelable.Creator<Card> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String addressCity;
    private final String addressCountry;
    private final String addressLine1;
    private final String addressLine1Check;
    private final String addressLine2;
    private final String addressState;
    private final String addressZip;
    private final String addressZipCheck;
    private final CardBrand brand;
    private final String country;
    private final String currency;
    private final String customerId;
    private final String cvcCheck;
    private final Integer expMonth;
    private final Integer expYear;
    private final String fingerprint;
    private final CardFunding funding;
    private final String id;
    private final String last4;
    private final String name;
    private final TokenizationMethod tokenizationMethod;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Card.kt */
    public static final class Creator implements Parcelable.Creator<Card> {
        public final Card createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Card(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), CardBrand.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : CardFunding.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TokenizationMethod.valueOf(parcel.readString()));
        }

        public final Card[] newArray(int i) {
            return new Card[i];
        }
    }

    public static /* synthetic */ Card copy$default(Card card, Integer num, Integer num2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, CardBrand cardBrand, CardFunding cardFunding, String str11, String str12, String str13, String str14, String str15, String str16, TokenizationMethod tokenizationMethod2, int i, Object obj) {
        Card card2 = card;
        int i2 = i;
        return card.copy((i2 & 1) != 0 ? card2.expMonth : num, (i2 & 2) != 0 ? card2.expYear : num2, (i2 & 4) != 0 ? card2.name : str, (i2 & 8) != 0 ? card2.addressLine1 : str2, (i2 & 16) != 0 ? card2.addressLine1Check : str3, (i2 & 32) != 0 ? card2.addressLine2 : str4, (i2 & 64) != 0 ? card2.addressCity : str5, (i2 & 128) != 0 ? card2.addressState : str6, (i2 & 256) != 0 ? card2.addressZip : str7, (i2 & 512) != 0 ? card2.addressZipCheck : str8, (i2 & 1024) != 0 ? card2.addressCountry : str9, (i2 & 2048) != 0 ? card2.last4 : str10, (i2 & 4096) != 0 ? card2.brand : cardBrand, (i2 & 8192) != 0 ? card2.funding : cardFunding, (i2 & 16384) != 0 ? card2.fingerprint : str11, (i2 & 32768) != 0 ? card2.country : str12, (i2 & 65536) != 0 ? card2.currency : str13, (i2 & 131072) != 0 ? card2.customerId : str14, (i2 & 262144) != 0 ? card2.cvcCheck : str15, (i2 & 524288) != 0 ? card.getId() : str16, (i2 & 1048576) != 0 ? card2.tokenizationMethod : tokenizationMethod2);
    }

    public final Integer component1() {
        return this.expMonth;
    }

    public final String component10() {
        return this.addressZipCheck;
    }

    public final String component11() {
        return this.addressCountry;
    }

    public final String component12() {
        return this.last4;
    }

    public final CardBrand component13() {
        return this.brand;
    }

    public final CardFunding component14() {
        return this.funding;
    }

    public final String component15() {
        return this.fingerprint;
    }

    public final String component16() {
        return this.country;
    }

    public final String component17() {
        return this.currency;
    }

    public final String component18() {
        return this.customerId;
    }

    public final String component19() {
        return this.cvcCheck;
    }

    public final Integer component2() {
        return this.expYear;
    }

    public final String component20() {
        return getId();
    }

    public final TokenizationMethod component21() {
        return this.tokenizationMethod;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.addressLine1;
    }

    public final String component5() {
        return this.addressLine1Check;
    }

    public final String component6() {
        return this.addressLine2;
    }

    public final String component7() {
        return this.addressCity;
    }

    public final String component8() {
        return this.addressState;
    }

    public final String component9() {
        return this.addressZip;
    }

    public final Card copy(Integer num, Integer num2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, CardBrand cardBrand, CardFunding cardFunding, String str11, String str12, String str13, String str14, String str15, String str16, TokenizationMethod tokenizationMethod2) {
        Integer num3 = num;
        Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
        return new Card(num, num2, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, cardBrand, cardFunding, str11, str12, str13, str14, str15, str16, tokenizationMethod2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card card = (Card) obj;
        return Intrinsics.areEqual((Object) this.expMonth, (Object) card.expMonth) && Intrinsics.areEqual((Object) this.expYear, (Object) card.expYear) && Intrinsics.areEqual((Object) this.name, (Object) card.name) && Intrinsics.areEqual((Object) this.addressLine1, (Object) card.addressLine1) && Intrinsics.areEqual((Object) this.addressLine1Check, (Object) card.addressLine1Check) && Intrinsics.areEqual((Object) this.addressLine2, (Object) card.addressLine2) && Intrinsics.areEqual((Object) this.addressCity, (Object) card.addressCity) && Intrinsics.areEqual((Object) this.addressState, (Object) card.addressState) && Intrinsics.areEqual((Object) this.addressZip, (Object) card.addressZip) && Intrinsics.areEqual((Object) this.addressZipCheck, (Object) card.addressZipCheck) && Intrinsics.areEqual((Object) this.addressCountry, (Object) card.addressCountry) && Intrinsics.areEqual((Object) this.last4, (Object) card.last4) && this.brand == card.brand && this.funding == card.funding && Intrinsics.areEqual((Object) this.fingerprint, (Object) card.fingerprint) && Intrinsics.areEqual((Object) this.country, (Object) card.country) && Intrinsics.areEqual((Object) this.currency, (Object) card.currency) && Intrinsics.areEqual((Object) this.customerId, (Object) card.customerId) && Intrinsics.areEqual((Object) this.cvcCheck, (Object) card.cvcCheck) && Intrinsics.areEqual((Object) getId(), (Object) card.getId()) && this.tokenizationMethod == card.tokenizationMethod;
    }

    public int hashCode() {
        Integer num = this.expMonth;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.expYear;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.addressLine1;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.addressLine1Check;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.addressLine2;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.addressCity;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.addressState;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.addressZip;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.addressZipCheck;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.addressCountry;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.last4;
        int hashCode12 = (((hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31) + this.brand.hashCode()) * 31;
        CardFunding cardFunding = this.funding;
        int hashCode13 = (hashCode12 + (cardFunding == null ? 0 : cardFunding.hashCode())) * 31;
        String str11 = this.fingerprint;
        int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.country;
        int hashCode15 = (hashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.currency;
        int hashCode16 = (hashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.customerId;
        int hashCode17 = (hashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.cvcCheck;
        int hashCode18 = (((hashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31) + (getId() == null ? 0 : getId().hashCode())) * 31;
        TokenizationMethod tokenizationMethod2 = this.tokenizationMethod;
        if (tokenizationMethod2 != null) {
            i = tokenizationMethod2.hashCode();
        }
        return hashCode18 + i;
    }

    public String toString() {
        return "Card(expMonth=" + this.expMonth + ", expYear=" + this.expYear + ", name=" + this.name + ", addressLine1=" + this.addressLine1 + ", addressLine1Check=" + this.addressLine1Check + ", addressLine2=" + this.addressLine2 + ", addressCity=" + this.addressCity + ", addressState=" + this.addressState + ", addressZip=" + this.addressZip + ", addressZipCheck=" + this.addressZipCheck + ", addressCountry=" + this.addressCountry + ", last4=" + this.last4 + ", brand=" + this.brand + ", funding=" + this.funding + ", fingerprint=" + this.fingerprint + ", country=" + this.country + ", currency=" + this.currency + ", customerId=" + this.customerId + ", cvcCheck=" + this.cvcCheck + ", id=" + getId() + ", tokenizationMethod=" + this.tokenizationMethod + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.expMonth;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.expYear;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.name);
        parcel.writeString(this.addressLine1);
        parcel.writeString(this.addressLine1Check);
        parcel.writeString(this.addressLine2);
        parcel.writeString(this.addressCity);
        parcel.writeString(this.addressState);
        parcel.writeString(this.addressZip);
        parcel.writeString(this.addressZipCheck);
        parcel.writeString(this.addressCountry);
        parcel.writeString(this.last4);
        parcel.writeString(this.brand.name());
        CardFunding cardFunding = this.funding;
        if (cardFunding == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(cardFunding.name());
        }
        parcel.writeString(this.fingerprint);
        parcel.writeString(this.country);
        parcel.writeString(this.currency);
        parcel.writeString(this.customerId);
        parcel.writeString(this.cvcCheck);
        parcel.writeString(this.id);
        TokenizationMethod tokenizationMethod2 = this.tokenizationMethod;
        if (tokenizationMethod2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeString(tokenizationMethod2.name());
    }

    public Card(Integer num, Integer num2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, CardBrand cardBrand, CardFunding cardFunding, String str11, String str12, String str13, String str14, String str15, String str16, TokenizationMethod tokenizationMethod2) {
        CardBrand cardBrand2 = cardBrand;
        Intrinsics.checkNotNullParameter(cardBrand2, AccountRangeJsonParser.FIELD_BRAND);
        this.expMonth = num;
        this.expYear = num2;
        this.name = str;
        this.addressLine1 = str2;
        this.addressLine1Check = str3;
        this.addressLine2 = str4;
        this.addressCity = str5;
        this.addressState = str6;
        this.addressZip = str7;
        this.addressZipCheck = str8;
        this.addressCountry = str9;
        this.last4 = str10;
        this.brand = cardBrand2;
        this.funding = cardFunding;
        this.fingerprint = str11;
        this.country = str12;
        this.currency = str13;
        this.customerId = str14;
        this.cvcCheck = str15;
        this.id = str16;
        this.tokenizationMethod = tokenizationMethod2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Card(java.lang.Integer r26, java.lang.Integer r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, com.stripe.android.model.CardBrand r38, com.stripe.android.model.CardFunding r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, com.stripe.android.model.TokenizationMethod r46, int r47, kotlin.jvm.internal.DefaultConstructorMarker r48) {
        /*
            r25 = this;
            r0 = r47
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r28
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0011
            r7 = r2
            goto L_0x0013
        L_0x0011:
            r7 = r29
        L_0x0013:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0019
            r8 = r2
            goto L_0x001b
        L_0x0019:
            r8 = r30
        L_0x001b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0021
            r9 = r2
            goto L_0x0023
        L_0x0021:
            r9 = r31
        L_0x0023:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0029
            r10 = r2
            goto L_0x002b
        L_0x0029:
            r10 = r32
        L_0x002b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0031
            r11 = r2
            goto L_0x0033
        L_0x0031:
            r11 = r33
        L_0x0033:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0039
            r12 = r2
            goto L_0x003b
        L_0x0039:
            r12 = r34
        L_0x003b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0041
            r13 = r2
            goto L_0x0043
        L_0x0041:
            r13 = r35
        L_0x0043:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0049
            r14 = r2
            goto L_0x004b
        L_0x0049:
            r14 = r36
        L_0x004b:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0051
            r15 = r2
            goto L_0x0053
        L_0x0051:
            r15 = r37
        L_0x0053:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x005a
            r17 = r2
            goto L_0x005c
        L_0x005a:
            r17 = r39
        L_0x005c:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0063
            r18 = r2
            goto L_0x0065
        L_0x0063:
            r18 = r40
        L_0x0065:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x006e
            r19 = r2
            goto L_0x0070
        L_0x006e:
            r19 = r41
        L_0x0070:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0078
            r20 = r2
            goto L_0x007a
        L_0x0078:
            r20 = r42
        L_0x007a:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0082
            r21 = r2
            goto L_0x0084
        L_0x0082:
            r21 = r43
        L_0x0084:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008c
            r22 = r2
            goto L_0x008e
        L_0x008c:
            r22 = r44
        L_0x008e:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0096
            r24 = r2
            goto L_0x0098
        L_0x0096:
            r24 = r46
        L_0x0098:
            r3 = r25
            r4 = r26
            r5 = r27
            r16 = r38
            r23 = r45
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.Card.<init>(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.model.CardBrand, com.stripe.android.model.CardFunding, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.model.TokenizationMethod, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getExpMonth() {
        return this.expMonth;
    }

    public final Integer getExpYear() {
        return this.expYear;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAddressLine1() {
        return this.addressLine1;
    }

    public final String getAddressLine1Check() {
        return this.addressLine1Check;
    }

    public final String getAddressLine2() {
        return this.addressLine2;
    }

    public final String getAddressCity() {
        return this.addressCity;
    }

    public final String getAddressState() {
        return this.addressState;
    }

    public final String getAddressZip() {
        return this.addressZip;
    }

    public final String getAddressZipCheck() {
        return this.addressZipCheck;
    }

    public final String getAddressCountry() {
        return this.addressCountry;
    }

    public final String getLast4() {
        return this.last4;
    }

    public final CardBrand getBrand() {
        return this.brand;
    }

    public final CardFunding getFunding() {
        return this.funding;
    }

    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final String getCvcCheck() {
        return this.cvcCheck;
    }

    public String getId() {
        return this.id;
    }

    public final TokenizationMethod getTokenizationMethod() {
        return this.tokenizationMethod;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/Card$Companion;", "", "()V", "getCardBrand", "Lcom/stripe/android/model/CardBrand;", "brandName", "", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Card.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ CardBrand getCardBrand(String str) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -993787207:
                        if (str.equals("Diners Club")) {
                            return CardBrand.DinersClub;
                        }
                        break;
                    case -298759312:
                        if (str.equals("American Express")) {
                            return CardBrand.AmericanExpress;
                        }
                        break;
                    case -231891079:
                        if (str.equals("UnionPay")) {
                            return CardBrand.UnionPay;
                        }
                        break;
                    case -46205774:
                        if (str.equals("MasterCard")) {
                            return CardBrand.MasterCard;
                        }
                        break;
                    case 73257:
                        if (str.equals("JCB")) {
                            return CardBrand.JCB;
                        }
                        break;
                    case 2666593:
                        if (str.equals("Visa")) {
                            return CardBrand.Visa;
                        }
                        break;
                    case 337828873:
                        if (str.equals("Discover")) {
                            return CardBrand.Discover;
                        }
                        break;
                }
            }
            return CardBrand.Unknown;
        }
    }
}

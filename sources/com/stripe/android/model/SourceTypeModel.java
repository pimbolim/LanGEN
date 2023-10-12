package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/SourceTypeModel;", "Lcom/stripe/android/core/model/StripeModel;", "()V", "Card", "SepaDebit", "Lcom/stripe/android/model/SourceTypeModel$Card;", "Lcom/stripe/android/model/SourceTypeModel$SepaDebit;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SourceTypeModel.kt */
public abstract class SourceTypeModel implements StripeModel {
    public static final int $stable = 0;

    public /* synthetic */ SourceTypeModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SourceTypeModel() {
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001BB\u0001\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00103\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u00020\u000bHÖ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u000bHÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\u0019\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006C"}, d2 = {"Lcom/stripe/android/model/SourceTypeModel$Card;", "Lcom/stripe/android/model/SourceTypeModel;", "addressLine1Check", "", "addressZipCheck", "brand", "Lcom/stripe/android/model/CardBrand;", "country", "cvcCheck", "dynamicLast4", "expiryMonth", "", "expiryYear", "funding", "Lcom/stripe/android/model/CardFunding;", "last4", "threeDSecureStatus", "Lcom/stripe/android/model/SourceTypeModel$Card$ThreeDSecureStatus;", "tokenizationMethod", "Lcom/stripe/android/model/TokenizationMethod;", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/CardBrand;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/stripe/android/model/CardFunding;Ljava/lang/String;Lcom/stripe/android/model/SourceTypeModel$Card$ThreeDSecureStatus;Lcom/stripe/android/model/TokenizationMethod;)V", "getAddressLine1Check", "()Ljava/lang/String;", "getAddressZipCheck", "getBrand", "()Lcom/stripe/android/model/CardBrand;", "getCountry", "getCvcCheck", "getDynamicLast4", "getExpiryMonth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExpiryYear", "getFunding", "()Lcom/stripe/android/model/CardFunding;", "getLast4", "getThreeDSecureStatus", "()Lcom/stripe/android/model/SourceTypeModel$Card$ThreeDSecureStatus;", "getTokenizationMethod", "()Lcom/stripe/android/model/TokenizationMethod;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/CardBrand;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/stripe/android/model/CardFunding;Ljava/lang/String;Lcom/stripe/android/model/SourceTypeModel$Card$ThreeDSecureStatus;Lcom/stripe/android/model/TokenizationMethod;)Lcom/stripe/android/model/SourceTypeModel$Card;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ThreeDSecureStatus", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceTypeModel.kt */
    public static final class Card extends SourceTypeModel {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Card> CREATOR = new Creator();
        private final String addressLine1Check;
        private final String addressZipCheck;
        private final CardBrand brand;
        private final String country;
        private final String cvcCheck;
        private final String dynamicLast4;
        private final Integer expiryMonth;
        private final Integer expiryYear;
        private final CardFunding funding;
        private final String last4;
        private final ThreeDSecureStatus threeDSecureStatus;
        private final TokenizationMethod tokenizationMethod;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceTypeModel.kt */
        public static final class Creator implements Parcelable.Creator<Card> {
            public final Card createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Card(parcel.readString(), parcel.readString(), CardBrand.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : CardFunding.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() == 0 ? null : ThreeDSecureStatus.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : TokenizationMethod.valueOf(parcel.readString()));
            }

            public final Card[] newArray(int i) {
                return new Card[i];
            }
        }

        public static /* synthetic */ Card copy$default(Card card, String str, String str2, CardBrand cardBrand, String str3, String str4, String str5, Integer num, Integer num2, CardFunding cardFunding, String str6, ThreeDSecureStatus threeDSecureStatus2, TokenizationMethod tokenizationMethod2, int i, Object obj) {
            Card card2 = card;
            int i2 = i;
            return card.copy((i2 & 1) != 0 ? card2.addressLine1Check : str, (i2 & 2) != 0 ? card2.addressZipCheck : str2, (i2 & 4) != 0 ? card2.brand : cardBrand, (i2 & 8) != 0 ? card2.country : str3, (i2 & 16) != 0 ? card2.cvcCheck : str4, (i2 & 32) != 0 ? card2.dynamicLast4 : str5, (i2 & 64) != 0 ? card2.expiryMonth : num, (i2 & 128) != 0 ? card2.expiryYear : num2, (i2 & 256) != 0 ? card2.funding : cardFunding, (i2 & 512) != 0 ? card2.last4 : str6, (i2 & 1024) != 0 ? card2.threeDSecureStatus : threeDSecureStatus2, (i2 & 2048) != 0 ? card2.tokenizationMethod : tokenizationMethod2);
        }

        public final String component1() {
            return this.addressLine1Check;
        }

        public final String component10() {
            return this.last4;
        }

        public final ThreeDSecureStatus component11() {
            return this.threeDSecureStatus;
        }

        public final TokenizationMethod component12() {
            return this.tokenizationMethod;
        }

        public final String component2() {
            return this.addressZipCheck;
        }

        public final CardBrand component3() {
            return this.brand;
        }

        public final String component4() {
            return this.country;
        }

        public final String component5() {
            return this.cvcCheck;
        }

        public final String component6() {
            return this.dynamicLast4;
        }

        public final Integer component7() {
            return this.expiryMonth;
        }

        public final Integer component8() {
            return this.expiryYear;
        }

        public final CardFunding component9() {
            return this.funding;
        }

        public final Card copy(String str, String str2, CardBrand cardBrand, String str3, String str4, String str5, Integer num, Integer num2, CardFunding cardFunding, String str6, ThreeDSecureStatus threeDSecureStatus2, TokenizationMethod tokenizationMethod2) {
            CardBrand cardBrand2 = cardBrand;
            Intrinsics.checkNotNullParameter(cardBrand2, AccountRangeJsonParser.FIELD_BRAND);
            return new Card(str, str2, cardBrand2, str3, str4, str5, num, num2, cardFunding, str6, threeDSecureStatus2, tokenizationMethod2);
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
            return Intrinsics.areEqual((Object) this.addressLine1Check, (Object) card.addressLine1Check) && Intrinsics.areEqual((Object) this.addressZipCheck, (Object) card.addressZipCheck) && this.brand == card.brand && Intrinsics.areEqual((Object) this.country, (Object) card.country) && Intrinsics.areEqual((Object) this.cvcCheck, (Object) card.cvcCheck) && Intrinsics.areEqual((Object) this.dynamicLast4, (Object) card.dynamicLast4) && Intrinsics.areEqual((Object) this.expiryMonth, (Object) card.expiryMonth) && Intrinsics.areEqual((Object) this.expiryYear, (Object) card.expiryYear) && this.funding == card.funding && Intrinsics.areEqual((Object) this.last4, (Object) card.last4) && this.threeDSecureStatus == card.threeDSecureStatus && this.tokenizationMethod == card.tokenizationMethod;
        }

        public int hashCode() {
            String str = this.addressLine1Check;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.addressZipCheck;
            int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.brand.hashCode()) * 31;
            String str3 = this.country;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.cvcCheck;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.dynamicLast4;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num = this.expiryMonth;
            int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.expiryYear;
            int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
            CardFunding cardFunding = this.funding;
            int hashCode8 = (hashCode7 + (cardFunding == null ? 0 : cardFunding.hashCode())) * 31;
            String str6 = this.last4;
            int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
            ThreeDSecureStatus threeDSecureStatus2 = this.threeDSecureStatus;
            int hashCode10 = (hashCode9 + (threeDSecureStatus2 == null ? 0 : threeDSecureStatus2.hashCode())) * 31;
            TokenizationMethod tokenizationMethod2 = this.tokenizationMethod;
            if (tokenizationMethod2 != null) {
                i = tokenizationMethod2.hashCode();
            }
            return hashCode10 + i;
        }

        public String toString() {
            return "Card(addressLine1Check=" + this.addressLine1Check + ", addressZipCheck=" + this.addressZipCheck + ", brand=" + this.brand + ", country=" + this.country + ", cvcCheck=" + this.cvcCheck + ", dynamicLast4=" + this.dynamicLast4 + ", expiryMonth=" + this.expiryMonth + ", expiryYear=" + this.expiryYear + ", funding=" + this.funding + ", last4=" + this.last4 + ", threeDSecureStatus=" + this.threeDSecureStatus + ", tokenizationMethod=" + this.tokenizationMethod + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.addressLine1Check);
            parcel.writeString(this.addressZipCheck);
            parcel.writeString(this.brand.name());
            parcel.writeString(this.country);
            parcel.writeString(this.cvcCheck);
            parcel.writeString(this.dynamicLast4);
            Integer num = this.expiryMonth;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            Integer num2 = this.expiryYear;
            if (num2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num2.intValue());
            }
            CardFunding cardFunding = this.funding;
            if (cardFunding == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(cardFunding.name());
            }
            parcel.writeString(this.last4);
            ThreeDSecureStatus threeDSecureStatus2 = this.threeDSecureStatus;
            if (threeDSecureStatus2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(threeDSecureStatus2.name());
            }
            TokenizationMethod tokenizationMethod2 = this.tokenizationMethod;
            if (tokenizationMethod2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(tokenizationMethod2.name());
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Card(java.lang.String r17, java.lang.String r18, com.stripe.android.model.CardBrand r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.Integer r23, java.lang.Integer r24, com.stripe.android.model.CardFunding r25, java.lang.String r26, com.stripe.android.model.SourceTypeModel.Card.ThreeDSecureStatus r27, com.stripe.android.model.TokenizationMethod r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
            /*
                r16 = this;
                r0 = r29
                r1 = r0 & 1
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r4 = r2
                goto L_0x000b
            L_0x0009:
                r4 = r17
            L_0x000b:
                r1 = r0 & 2
                if (r1 == 0) goto L_0x0011
                r5 = r2
                goto L_0x0013
            L_0x0011:
                r5 = r18
            L_0x0013:
                r1 = r0 & 8
                if (r1 == 0) goto L_0x0019
                r7 = r2
                goto L_0x001b
            L_0x0019:
                r7 = r20
            L_0x001b:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0021
                r8 = r2
                goto L_0x0023
            L_0x0021:
                r8 = r21
            L_0x0023:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0029
                r9 = r2
                goto L_0x002b
            L_0x0029:
                r9 = r22
            L_0x002b:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0031
                r10 = r2
                goto L_0x0033
            L_0x0031:
                r10 = r23
            L_0x0033:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L_0x0039
                r11 = r2
                goto L_0x003b
            L_0x0039:
                r11 = r24
            L_0x003b:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x0041
                r12 = r2
                goto L_0x0043
            L_0x0041:
                r12 = r25
            L_0x0043:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L_0x0049
                r13 = r2
                goto L_0x004b
            L_0x0049:
                r13 = r26
            L_0x004b:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L_0x0051
                r14 = r2
                goto L_0x0053
            L_0x0051:
                r14 = r27
            L_0x0053:
                r0 = r0 & 2048(0x800, float:2.87E-42)
                if (r0 == 0) goto L_0x0059
                r15 = r2
                goto L_0x005b
            L_0x0059:
                r15 = r28
            L_0x005b:
                r3 = r16
                r6 = r19
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.SourceTypeModel.Card.<init>(java.lang.String, java.lang.String, com.stripe.android.model.CardBrand, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, com.stripe.android.model.CardFunding, java.lang.String, com.stripe.android.model.SourceTypeModel$Card$ThreeDSecureStatus, com.stripe.android.model.TokenizationMethod, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getAddressLine1Check() {
            return this.addressLine1Check;
        }

        public final String getAddressZipCheck() {
            return this.addressZipCheck;
        }

        public final CardBrand getBrand() {
            return this.brand;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getCvcCheck() {
            return this.cvcCheck;
        }

        public final String getDynamicLast4() {
            return this.dynamicLast4;
        }

        public final Integer getExpiryMonth() {
            return this.expiryMonth;
        }

        public final Integer getExpiryYear() {
            return this.expiryYear;
        }

        public final CardFunding getFunding() {
            return this.funding;
        }

        public final String getLast4() {
            return this.last4;
        }

        public final ThreeDSecureStatus getThreeDSecureStatus() {
            return this.threeDSecureStatus;
        }

        public final TokenizationMethod getTokenizationMethod() {
            return this.tokenizationMethod;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/SourceTypeModel$Card$ThreeDSecureStatus;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "Required", "Optional", "NotSupported", "Recommended", "Unknown", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceTypeModel.kt */
        public enum ThreeDSecureStatus {
            Required("required"),
            Optional("optional"),
            NotSupported("not_supported"),
            Recommended("recommended"),
            Unknown("unknown");
            
            public static final Companion Companion = null;
            /* access modifiers changed from: private */
            public final String code;

            private ThreeDSecureStatus(String str) {
                this.code = str;
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }

            public String toString() {
                return this.code;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/SourceTypeModel$Card$ThreeDSecureStatus$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/SourceTypeModel$Card$ThreeDSecureStatus;", "code", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: SourceTypeModel.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final ThreeDSecureStatus fromCode(String str) {
                    ThreeDSecureStatus[] values = ThreeDSecureStatus.values();
                    int length = values.length;
                    int i = 0;
                    while (i < length) {
                        ThreeDSecureStatus threeDSecureStatus = values[i];
                        i++;
                        if (Intrinsics.areEqual((Object) threeDSecureStatus.code, (Object) str)) {
                            return threeDSecureStatus;
                        }
                    }
                    return null;
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Card(String str, String str2, CardBrand cardBrand, String str3, String str4, String str5, Integer num, Integer num2, CardFunding cardFunding, String str6, ThreeDSecureStatus threeDSecureStatus2, TokenizationMethod tokenizationMethod2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
            this.addressLine1Check = str;
            this.addressZipCheck = str2;
            this.brand = cardBrand;
            this.country = str3;
            this.cvcCheck = str4;
            this.dynamicLast4 = str5;
            this.expiryMonth = num;
            this.expiryYear = num2;
            this.funding = cardFunding;
            this.last4 = str6;
            this.threeDSecureStatus = threeDSecureStatus2;
            this.tokenizationMethod = tokenizationMethod2;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006("}, d2 = {"Lcom/stripe/android/model/SourceTypeModel$SepaDebit;", "Lcom/stripe/android/model/SourceTypeModel;", "bankCode", "", "branchCode", "country", "fingerPrint", "last4", "mandateReference", "mandateUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBankCode", "()Ljava/lang/String;", "getBranchCode", "getCountry", "getFingerPrint", "getLast4", "getMandateReference", "getMandateUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceTypeModel.kt */
    public static final class SepaDebit extends SourceTypeModel {
        public static final int $stable = 8;
        public static final Parcelable.Creator<SepaDebit> CREATOR = new Creator();
        private final String bankCode;
        private final String branchCode;
        private final String country;
        private final String fingerPrint;
        private final String last4;
        private final String mandateReference;
        private final String mandateUrl;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceTypeModel.kt */
        public static final class Creator implements Parcelable.Creator<SepaDebit> {
            public final SepaDebit createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SepaDebit(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final SepaDebit[] newArray(int i) {
                return new SepaDebit[i];
            }
        }

        public static /* synthetic */ SepaDebit copy$default(SepaDebit sepaDebit, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sepaDebit.bankCode;
            }
            if ((i & 2) != 0) {
                str2 = sepaDebit.branchCode;
            }
            String str8 = str2;
            if ((i & 4) != 0) {
                str3 = sepaDebit.country;
            }
            String str9 = str3;
            if ((i & 8) != 0) {
                str4 = sepaDebit.fingerPrint;
            }
            String str10 = str4;
            if ((i & 16) != 0) {
                str5 = sepaDebit.last4;
            }
            String str11 = str5;
            if ((i & 32) != 0) {
                str6 = sepaDebit.mandateReference;
            }
            String str12 = str6;
            if ((i & 64) != 0) {
                str7 = sepaDebit.mandateUrl;
            }
            return sepaDebit.copy(str, str8, str9, str10, str11, str12, str7);
        }

        public final String component1() {
            return this.bankCode;
        }

        public final String component2() {
            return this.branchCode;
        }

        public final String component3() {
            return this.country;
        }

        public final String component4() {
            return this.fingerPrint;
        }

        public final String component5() {
            return this.last4;
        }

        public final String component6() {
            return this.mandateReference;
        }

        public final String component7() {
            return this.mandateUrl;
        }

        public final SepaDebit copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            return new SepaDebit(str, str2, str3, str4, str5, str6, str7);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SepaDebit)) {
                return false;
            }
            SepaDebit sepaDebit = (SepaDebit) obj;
            return Intrinsics.areEqual((Object) this.bankCode, (Object) sepaDebit.bankCode) && Intrinsics.areEqual((Object) this.branchCode, (Object) sepaDebit.branchCode) && Intrinsics.areEqual((Object) this.country, (Object) sepaDebit.country) && Intrinsics.areEqual((Object) this.fingerPrint, (Object) sepaDebit.fingerPrint) && Intrinsics.areEqual((Object) this.last4, (Object) sepaDebit.last4) && Intrinsics.areEqual((Object) this.mandateReference, (Object) sepaDebit.mandateReference) && Intrinsics.areEqual((Object) this.mandateUrl, (Object) sepaDebit.mandateUrl);
        }

        public int hashCode() {
            String str = this.bankCode;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.branchCode;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.country;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.fingerPrint;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.last4;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.mandateReference;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.mandateUrl;
            if (str7 != null) {
                i = str7.hashCode();
            }
            return hashCode6 + i;
        }

        public String toString() {
            return "SepaDebit(bankCode=" + this.bankCode + ", branchCode=" + this.branchCode + ", country=" + this.country + ", fingerPrint=" + this.fingerPrint + ", last4=" + this.last4 + ", mandateReference=" + this.mandateReference + ", mandateUrl=" + this.mandateUrl + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bankCode);
            parcel.writeString(this.branchCode);
            parcel.writeString(this.country);
            parcel.writeString(this.fingerPrint);
            parcel.writeString(this.last4);
            parcel.writeString(this.mandateReference);
            parcel.writeString(this.mandateUrl);
        }

        public final String getBankCode() {
            return this.bankCode;
        }

        public final String getBranchCode() {
            return this.branchCode;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getFingerPrint() {
            return this.fingerPrint;
        }

        public final String getLast4() {
            return this.last4;
        }

        public final String getMandateReference() {
            return this.mandateReference;
        }

        public final String getMandateUrl() {
            return this.mandateUrl;
        }

        public SepaDebit(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            super((DefaultConstructorMarker) null);
            this.bankCode = str;
            this.branchCode = str2;
            this.country = str3;
            this.fingerPrint = str4;
            this.last4 = str5;
            this.mandateReference = str6;
            this.mandateUrl = str7;
        }
    }
}

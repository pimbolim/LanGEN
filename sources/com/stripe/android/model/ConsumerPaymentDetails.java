package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/model/ConsumerPaymentDetails;", "Lcom/stripe/android/core/model/StripeModel;", "paymentDetails", "", "Lcom/stripe/android/model/ConsumerPaymentDetails$PaymentDetails;", "(Ljava/util/List;)V", "getPaymentDetails", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Card", "PaymentDetails", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConsumerPaymentDetails.kt */
public final class ConsumerPaymentDetails implements StripeModel {
    public static final int $stable = 8;
    public static final Parcelable.Creator<ConsumerPaymentDetails> CREATOR = new Creator();
    private final List<PaymentDetails> paymentDetails;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConsumerPaymentDetails.kt */
    public static final class Creator implements Parcelable.Creator<ConsumerPaymentDetails> {
        public final ConsumerPaymentDetails createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(parcel.readParcelable(ConsumerPaymentDetails.class.getClassLoader()));
            }
            return new ConsumerPaymentDetails(arrayList);
        }

        public final ConsumerPaymentDetails[] newArray(int i) {
            return new ConsumerPaymentDetails[i];
        }
    }

    public static /* synthetic */ ConsumerPaymentDetails copy$default(ConsumerPaymentDetails consumerPaymentDetails, List<PaymentDetails> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = consumerPaymentDetails.paymentDetails;
        }
        return consumerPaymentDetails.copy(list);
    }

    public final List<PaymentDetails> component1() {
        return this.paymentDetails;
    }

    public final ConsumerPaymentDetails copy(List<? extends PaymentDetails> list) {
        Intrinsics.checkNotNullParameter(list, "paymentDetails");
        return new ConsumerPaymentDetails(list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsumerPaymentDetails) && Intrinsics.areEqual((Object) this.paymentDetails, (Object) ((ConsumerPaymentDetails) obj).paymentDetails);
    }

    public int hashCode() {
        return this.paymentDetails.hashCode();
    }

    public String toString() {
        return "ConsumerPaymentDetails(paymentDetails=" + this.paymentDetails + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<PaymentDetails> list = this.paymentDetails;
        parcel.writeInt(list.size());
        for (PaymentDetails writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i);
        }
    }

    public ConsumerPaymentDetails(List<? extends PaymentDetails> list) {
        Intrinsics.checkNotNullParameter(list, "paymentDetails");
        this.paymentDetails = list;
    }

    public final List<PaymentDetails> getPaymentDetails() {
        return this.paymentDetails;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t\u0001\u0001\n¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/ConsumerPaymentDetails$PaymentDetails;", "Landroid/os/Parcelable;", "id", "", "isDefault", "", "(Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "Lcom/stripe/android/model/ConsumerPaymentDetails$Card;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConsumerPaymentDetails.kt */
    public static abstract class PaymentDetails implements Parcelable {
        public static final int $stable = 0;
        private final String id;
        private final boolean isDefault;

        public /* synthetic */ PaymentDetails(String str, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z);
        }

        private PaymentDetails(String str, boolean z) {
            this.id = str;
            this.isDefault = z;
        }

        public String getId() {
            return this.id;
        }

        public boolean isDefault() {
            return this.isDefault;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006)"}, d2 = {"Lcom/stripe/android/model/ConsumerPaymentDetails$Card;", "Lcom/stripe/android/model/ConsumerPaymentDetails$PaymentDetails;", "id", "", "isDefault", "", "expiryYear", "", "expiryMonth", "brand", "Lcom/stripe/android/model/CardBrand;", "last4", "(Ljava/lang/String;ZIILcom/stripe/android/model/CardBrand;Ljava/lang/String;)V", "getBrand", "()Lcom/stripe/android/model/CardBrand;", "getExpiryMonth", "()I", "getExpiryYear", "getId", "()Ljava/lang/String;", "()Z", "getLast4", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConsumerPaymentDetails.kt */
    public static final class Card extends PaymentDetails {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Card> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String type = "card";
        private final CardBrand brand;
        private final int expiryMonth;
        private final int expiryYear;
        private final String id;
        private final boolean isDefault;
        private final String last4;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConsumerPaymentDetails.kt */
        public static final class Creator implements Parcelable.Creator<Card> {
            public final Card createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Card(parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), CardBrand.valueOf(parcel.readString()), parcel.readString());
            }

            public final Card[] newArray(int i) {
                return new Card[i];
            }
        }

        public static /* synthetic */ Card copy$default(Card card, String str, boolean z, int i, int i2, CardBrand cardBrand, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = card.getId();
            }
            if ((i3 & 2) != 0) {
                z = card.isDefault();
            }
            boolean z2 = z;
            if ((i3 & 4) != 0) {
                i = card.expiryYear;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = card.expiryMonth;
            }
            int i5 = i2;
            if ((i3 & 16) != 0) {
                cardBrand = card.brand;
            }
            CardBrand cardBrand2 = cardBrand;
            if ((i3 & 32) != 0) {
                str2 = card.last4;
            }
            return card.copy(str, z2, i4, i5, cardBrand2, str2);
        }

        public final String component1() {
            return getId();
        }

        public final boolean component2() {
            return isDefault();
        }

        public final int component3() {
            return this.expiryYear;
        }

        public final int component4() {
            return this.expiryMonth;
        }

        public final CardBrand component5() {
            return this.brand;
        }

        public final String component6() {
            return this.last4;
        }

        public final Card copy(String str, boolean z, int i, int i2, CardBrand cardBrand, String str2) {
            Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
            Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
            Intrinsics.checkNotNullParameter(str2, "last4");
            return new Card(str, z, i, i2, cardBrand, str2);
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
            return Intrinsics.areEqual((Object) getId(), (Object) card.getId()) && isDefault() == card.isDefault() && this.expiryYear == card.expiryYear && this.expiryMonth == card.expiryMonth && this.brand == card.brand && Intrinsics.areEqual((Object) this.last4, (Object) card.last4);
        }

        public int hashCode() {
            int hashCode = getId().hashCode() * 31;
            boolean isDefault2 = isDefault();
            if (isDefault2) {
                isDefault2 = true;
            }
            return ((((((((hashCode + (isDefault2 ? 1 : 0)) * 31) + this.expiryYear) * 31) + this.expiryMonth) * 31) + this.brand.hashCode()) * 31) + this.last4.hashCode();
        }

        public String toString() {
            return "Card(id=" + getId() + ", isDefault=" + isDefault() + ", expiryYear=" + this.expiryYear + ", expiryMonth=" + this.expiryMonth + ", brand=" + this.brand + ", last4=" + this.last4 + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeInt(this.isDefault ? 1 : 0);
            parcel.writeInt(this.expiryYear);
            parcel.writeInt(this.expiryMonth);
            parcel.writeString(this.brand.name());
            parcel.writeString(this.last4);
        }

        public String getId() {
            return this.id;
        }

        public boolean isDefault() {
            return this.isDefault;
        }

        public final int getExpiryYear() {
            return this.expiryYear;
        }

        public final int getExpiryMonth() {
            return this.expiryMonth;
        }

        public final CardBrand getBrand() {
            return this.brand;
        }

        public final String getLast4() {
            return this.last4;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/ConsumerPaymentDetails$Card$Companion;", "", "()V", "type", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConsumerPaymentDetails.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Card(String str, boolean z, int i, int i2, CardBrand cardBrand, String str2) {
            super(str, z, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
            Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
            Intrinsics.checkNotNullParameter(str2, "last4");
            this.id = str;
            this.isDefault = z;
            this.expiryYear = i;
            this.expiryMonth = i2;
            this.brand = cardBrand;
            this.last4 = str2;
        }
    }
}

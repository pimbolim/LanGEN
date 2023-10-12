package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/model/CustomerCard;", "Lcom/stripe/android/model/CustomerPaymentSource;", "card", "Lcom/stripe/android/model/Card;", "(Lcom/stripe/android/model/Card;)V", "getCard", "()Lcom/stripe/android/model/Card;", "id", "", "getId", "()Ljava/lang/String;", "tokenizationMethod", "Lcom/stripe/android/model/TokenizationMethod;", "getTokenizationMethod", "()Lcom/stripe/android/model/TokenizationMethod;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerSource.kt */
public final class CustomerCard extends CustomerPaymentSource {
    public static final int $stable = 8;
    public static final Parcelable.Creator<CustomerCard> CREATOR = new Creator();
    private final Card card;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerSource.kt */
    public static final class Creator implements Parcelable.Creator<CustomerCard> {
        public final CustomerCard createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CustomerCard((Card) parcel.readParcelable(CustomerCard.class.getClassLoader()));
        }

        public final CustomerCard[] newArray(int i) {
            return new CustomerCard[i];
        }
    }

    public static /* synthetic */ CustomerCard copy$default(CustomerCard customerCard, Card card2, int i, Object obj) {
        if ((i & 1) != 0) {
            card2 = customerCard.card;
        }
        return customerCard.copy(card2);
    }

    public final Card component1() {
        return this.card;
    }

    public final CustomerCard copy(Card card2) {
        Intrinsics.checkNotNullParameter(card2, "card");
        return new CustomerCard(card2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomerCard) && Intrinsics.areEqual((Object) this.card, (Object) ((CustomerCard) obj).card);
    }

    public int hashCode() {
        return this.card.hashCode();
    }

    public String toString() {
        return "CustomerCard(card=" + this.card + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.card, i);
    }

    public final Card getCard() {
        return this.card;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerCard(Card card2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(card2, "card");
        this.card = card2;
    }

    public String getId() {
        return this.card.getId();
    }

    public TokenizationMethod getTokenizationMethod() {
        return this.card.getTokenizationMethod();
    }
}

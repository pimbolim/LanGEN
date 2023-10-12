package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.ui.core.address.AddressFieldElementRepository;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Lcom/stripe/android/ui/core/elements/CardBillingSpec;", "Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "countryCodes", "", "", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Ljava/util/Set;)V", "getCountryCodes", "()Ljava/util/Set;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "transform", "Lcom/stripe/android/ui/core/elements/CardBillingAddressElement;", "addressRepository", "Lcom/stripe/android/ui/core/address/AddressFieldElementRepository;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardBillingSpec.kt */
public final class CardBillingSpec extends SectionFieldSpec {
    public static final Parcelable.Creator<CardBillingSpec> CREATOR = new Creator();
    private final Set<String> countryCodes;
    private final IdentifierSpec identifier;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardBillingSpec.kt */
    public static final class Creator implements Parcelable.Creator<CardBillingSpec> {
        public final CardBillingSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            IdentifierSpec identifierSpec = (IdentifierSpec) parcel.readParcelable(CardBillingSpec.class.getClassLoader());
            int readInt = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashSet.add(parcel.readString());
            }
            return new CardBillingSpec(identifierSpec, linkedHashSet);
        }

        public final CardBillingSpec[] newArray(int i) {
            return new CardBillingSpec[i];
        }
    }

    public static /* synthetic */ CardBillingSpec copy$default(CardBillingSpec cardBillingSpec, IdentifierSpec identifierSpec, Set<String> set, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = cardBillingSpec.getIdentifier();
        }
        if ((i & 2) != 0) {
            set = cardBillingSpec.countryCodes;
        }
        return cardBillingSpec.copy(identifierSpec, set);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final Set<String> component2() {
        return this.countryCodes;
    }

    public final CardBillingSpec copy(IdentifierSpec identifierSpec, Set<String> set) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(set, "countryCodes");
        return new CardBillingSpec(identifierSpec, set);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardBillingSpec)) {
            return false;
        }
        CardBillingSpec cardBillingSpec = (CardBillingSpec) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) cardBillingSpec.getIdentifier()) && Intrinsics.areEqual((Object) this.countryCodes, (Object) cardBillingSpec.countryCodes);
    }

    public int hashCode() {
        return (getIdentifier().hashCode() * 31) + this.countryCodes.hashCode();
    }

    public String toString() {
        return "CardBillingSpec(identifier=" + getIdentifier() + ", countryCodes=" + this.countryCodes + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.identifier, i);
        Set<String> set = this.countryCodes;
        parcel.writeInt(set.size());
        for (String writeString : set) {
            parcel.writeString(writeString);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardBillingSpec(IdentifierSpec identifierSpec, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new IdentifierSpec.Generic("card_billing") : identifierSpec, set);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public final Set<String> getCountryCodes() {
        return this.countryCodes;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardBillingSpec(IdentifierSpec identifierSpec, Set<String> set) {
        super(identifierSpec, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(set, "countryCodes");
        this.identifier = identifierSpec;
        this.countryCodes = set;
    }

    public final CardBillingAddressElement transform(AddressFieldElementRepository addressFieldElementRepository) {
        Intrinsics.checkNotNullParameter(addressFieldElementRepository, "addressRepository");
        return new CardBillingAddressElement(new IdentifierSpec.Generic("credit_billing"), addressFieldElementRepository, this.countryCodes, (DropdownFieldController) null, (Map) null, 24, (DefaultConstructorMarker) null);
    }
}

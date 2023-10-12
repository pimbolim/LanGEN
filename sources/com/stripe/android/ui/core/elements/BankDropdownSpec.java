package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Lcom/stripe/android/ui/core/elements/BankDropdownSpec;", "Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "label", "", "bankType", "Lcom/stripe/android/ui/core/elements/SupportedBankType;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;ILcom/stripe/android/ui/core/elements/SupportedBankType;)V", "getBankType", "()Lcom/stripe/android/ui/core/elements/SupportedBankType;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getLabel", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "transform", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "bankRepository", "Lcom/stripe/android/ui/core/elements/BankRepository;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BankDropdownSpec.kt */
public final class BankDropdownSpec extends SectionFieldSpec {
    public static final int $stable = 8;
    public static final Parcelable.Creator<BankDropdownSpec> CREATOR = new Creator();
    private final SupportedBankType bankType;
    private final IdentifierSpec identifier;
    private final int label;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankDropdownSpec.kt */
    public static final class Creator implements Parcelable.Creator<BankDropdownSpec> {
        public final BankDropdownSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BankDropdownSpec((IdentifierSpec) parcel.readParcelable(BankDropdownSpec.class.getClassLoader()), parcel.readInt(), SupportedBankType.valueOf(parcel.readString()));
        }

        public final BankDropdownSpec[] newArray(int i) {
            return new BankDropdownSpec[i];
        }
    }

    public static /* synthetic */ BankDropdownSpec copy$default(BankDropdownSpec bankDropdownSpec, IdentifierSpec identifierSpec, int i, SupportedBankType supportedBankType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            identifierSpec = bankDropdownSpec.getIdentifier();
        }
        if ((i2 & 2) != 0) {
            i = bankDropdownSpec.label;
        }
        if ((i2 & 4) != 0) {
            supportedBankType = bankDropdownSpec.bankType;
        }
        return bankDropdownSpec.copy(identifierSpec, i, supportedBankType);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final int component2() {
        return this.label;
    }

    public final SupportedBankType component3() {
        return this.bankType;
    }

    public final BankDropdownSpec copy(IdentifierSpec identifierSpec, int i, SupportedBankType supportedBankType) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(supportedBankType, "bankType");
        return new BankDropdownSpec(identifierSpec, i, supportedBankType);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankDropdownSpec)) {
            return false;
        }
        BankDropdownSpec bankDropdownSpec = (BankDropdownSpec) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) bankDropdownSpec.getIdentifier()) && this.label == bankDropdownSpec.label && this.bankType == bankDropdownSpec.bankType;
    }

    public int hashCode() {
        return (((getIdentifier().hashCode() * 31) + this.label) * 31) + this.bankType.hashCode();
    }

    public String toString() {
        return "BankDropdownSpec(identifier=" + getIdentifier() + ", label=" + this.label + ", bankType=" + this.bankType + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.identifier, i);
        parcel.writeInt(this.label);
        parcel.writeString(this.bankType.name());
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public final int getLabel() {
        return this.label;
    }

    public final SupportedBankType getBankType() {
        return this.bankType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankDropdownSpec(IdentifierSpec identifierSpec, int i, SupportedBankType supportedBankType) {
        super(identifierSpec, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(supportedBankType, "bankType");
        this.identifier = identifierSpec;
        this.label = i;
        this.bankType = supportedBankType;
    }

    public final SectionFieldElement transform(BankRepository bankRepository) {
        Intrinsics.checkNotNullParameter(bankRepository, "bankRepository");
        return new SimpleDropdownElement(getIdentifier(), new DropdownFieldController(new SimpleDropdownConfig(this.label, bankRepository.get(this.bankType)), (String) null, 2, (DefaultConstructorMarker) null));
    }
}

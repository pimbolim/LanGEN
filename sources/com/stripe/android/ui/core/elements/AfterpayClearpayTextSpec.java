package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import com.stripe.android.ui.core.Amount;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/ui/core/elements/AfterpayClearpayTextSpec;", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "Lcom/stripe/android/ui/core/elements/RequiredItemSpec;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;)V", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "transform", "Lcom/stripe/android/ui/core/elements/FormElement;", "amount", "Lcom/stripe/android/ui/core/Amount;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AfterpayClearpayTextSpec.kt */
public final class AfterpayClearpayTextSpec extends FormItemSpec implements RequiredItemSpec {
    public static final Parcelable.Creator<AfterpayClearpayTextSpec> CREATOR = new Creator();
    private final IdentifierSpec identifier;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AfterpayClearpayTextSpec.kt */
    public static final class Creator implements Parcelable.Creator<AfterpayClearpayTextSpec> {
        public final AfterpayClearpayTextSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AfterpayClearpayTextSpec((IdentifierSpec) parcel.readParcelable(AfterpayClearpayTextSpec.class.getClassLoader()));
        }

        public final AfterpayClearpayTextSpec[] newArray(int i) {
            return new AfterpayClearpayTextSpec[i];
        }
    }

    public static /* synthetic */ AfterpayClearpayTextSpec copy$default(AfterpayClearpayTextSpec afterpayClearpayTextSpec, IdentifierSpec identifierSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = afterpayClearpayTextSpec.getIdentifier();
        }
        return afterpayClearpayTextSpec.copy(identifierSpec);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final AfterpayClearpayTextSpec copy(IdentifierSpec identifierSpec) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new AfterpayClearpayTextSpec(identifierSpec);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AfterpayClearpayTextSpec) && Intrinsics.areEqual((Object) getIdentifier(), (Object) ((AfterpayClearpayTextSpec) obj).getIdentifier());
    }

    public int hashCode() {
        return getIdentifier().hashCode();
    }

    public String toString() {
        return "AfterpayClearpayTextSpec(identifier=" + getIdentifier() + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.identifier, i);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AfterpayClearpayTextSpec(IdentifierSpec identifierSpec) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        this.identifier = identifierSpec;
    }

    public final FormElement transform(Amount amount) {
        Intrinsics.checkNotNullParameter(amount, BaseSheetViewModel.SAVE_AMOUNT);
        return new AfterpayClearpayHeaderElement(getIdentifier(), amount, (Controller) null, 4, (DefaultConstructorMarker) null);
    }
}

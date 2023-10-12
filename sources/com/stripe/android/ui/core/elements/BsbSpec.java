package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/ui/core/elements/BsbSpec;", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "Lcom/stripe/android/ui/core/elements/RequiredItemSpec;", "Landroid/os/Parcelable;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;)V", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "transform", "Lcom/stripe/android/ui/core/elements/BsbElement;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BsbSpec.kt */
public final class BsbSpec extends FormItemSpec implements RequiredItemSpec, Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<BsbSpec> CREATOR = new Creator();
    private final IdentifierSpec identifier;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BsbSpec.kt */
    public static final class Creator implements Parcelable.Creator<BsbSpec> {
        public final BsbSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BsbSpec((IdentifierSpec) parcel.readParcelable(BsbSpec.class.getClassLoader()));
        }

        public final BsbSpec[] newArray(int i) {
            return new BsbSpec[i];
        }
    }

    public BsbSpec() {
        this((IdentifierSpec) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BsbSpec copy$default(BsbSpec bsbSpec, IdentifierSpec identifierSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = bsbSpec.getIdentifier();
        }
        return bsbSpec.copy(identifierSpec);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final BsbSpec copy(IdentifierSpec identifierSpec) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new BsbSpec(identifierSpec);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BsbSpec) && Intrinsics.areEqual((Object) getIdentifier(), (Object) ((BsbSpec) obj).getIdentifier());
    }

    public int hashCode() {
        return getIdentifier().hashCode();
    }

    public String toString() {
        return "BsbSpec(identifier=" + getIdentifier() + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.identifier, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BsbSpec(IdentifierSpec identifierSpec, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new IdentifierSpec.Generic("bsb_number") : identifierSpec);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BsbSpec(IdentifierSpec identifierSpec) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        this.identifier = identifierSpec;
    }

    public final BsbElement transform() {
        return new BsbElement(getIdentifier(), BsbSpecKt.banks);
    }
}

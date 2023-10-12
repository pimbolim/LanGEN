package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/ui/core/elements/AffirmTextSpec;", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;)V", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "transform", "Lcom/stripe/android/ui/core/elements/FormElement;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AffirmTextSpec.kt */
public final class AffirmTextSpec extends FormItemSpec {
    public static final Parcelable.Creator<AffirmTextSpec> CREATOR = new Creator();
    private final IdentifierSpec identifier;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AffirmTextSpec.kt */
    public static final class Creator implements Parcelable.Creator<AffirmTextSpec> {
        public final AffirmTextSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AffirmTextSpec((IdentifierSpec) parcel.readParcelable(AffirmTextSpec.class.getClassLoader()));
        }

        public final AffirmTextSpec[] newArray(int i) {
            return new AffirmTextSpec[i];
        }
    }

    public static /* synthetic */ AffirmTextSpec copy$default(AffirmTextSpec affirmTextSpec, IdentifierSpec identifierSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = affirmTextSpec.identifier;
        }
        return affirmTextSpec.copy(identifierSpec);
    }

    public final IdentifierSpec component1() {
        return this.identifier;
    }

    public final AffirmTextSpec copy(IdentifierSpec identifierSpec) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new AffirmTextSpec(identifierSpec);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AffirmTextSpec) && Intrinsics.areEqual((Object) this.identifier, (Object) ((AffirmTextSpec) obj).identifier);
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    public String toString() {
        return "AffirmTextSpec(identifier=" + this.identifier + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.identifier, i);
    }

    public final IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AffirmTextSpec(IdentifierSpec identifierSpec) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        this.identifier = identifierSpec;
    }

    public final FormElement transform() {
        return new AffirmHeaderElement(this.identifier, (Controller) null, 2, (DefaultConstructorMarker) null);
    }
}

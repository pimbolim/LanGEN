package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/ui/core/elements/MandateTextSpec;", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "Lcom/stripe/android/ui/core/elements/RequiredItemSpec;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "stringResId", "", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;I)V", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getStringResId", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "transform", "Lcom/stripe/android/ui/core/elements/FormElement;", "merchantName", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MandateTextSpec.kt */
public final class MandateTextSpec extends FormItemSpec implements RequiredItemSpec {
    public static final Parcelable.Creator<MandateTextSpec> CREATOR = new Creator();
    private final IdentifierSpec identifier;
    private final int stringResId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MandateTextSpec.kt */
    public static final class Creator implements Parcelable.Creator<MandateTextSpec> {
        public final MandateTextSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MandateTextSpec((IdentifierSpec) parcel.readParcelable(MandateTextSpec.class.getClassLoader()), parcel.readInt());
        }

        public final MandateTextSpec[] newArray(int i) {
            return new MandateTextSpec[i];
        }
    }

    public static /* synthetic */ MandateTextSpec copy$default(MandateTextSpec mandateTextSpec, IdentifierSpec identifierSpec, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            identifierSpec = mandateTextSpec.getIdentifier();
        }
        if ((i2 & 2) != 0) {
            i = mandateTextSpec.stringResId;
        }
        return mandateTextSpec.copy(identifierSpec, i);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final int component2() {
        return this.stringResId;
    }

    public final MandateTextSpec copy(IdentifierSpec identifierSpec, int i) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new MandateTextSpec(identifierSpec, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MandateTextSpec)) {
            return false;
        }
        MandateTextSpec mandateTextSpec = (MandateTextSpec) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) mandateTextSpec.getIdentifier()) && this.stringResId == mandateTextSpec.stringResId;
    }

    public int hashCode() {
        return (getIdentifier().hashCode() * 31) + this.stringResId;
    }

    public String toString() {
        return "MandateTextSpec(identifier=" + getIdentifier() + ", stringResId=" + this.stringResId + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.identifier, i);
        parcel.writeInt(this.stringResId);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public final int getStringResId() {
        return this.stringResId;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MandateTextSpec(IdentifierSpec identifierSpec, int i) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        this.identifier = identifierSpec;
        this.stringResId = i;
    }

    public final FormElement transform(String str) {
        Intrinsics.checkNotNullParameter(str, "merchantName");
        return new MandateTextElement(getIdentifier(), this.stringResId, str, (InputController) null, 8, (DefaultConstructorMarker) null);
    }
}

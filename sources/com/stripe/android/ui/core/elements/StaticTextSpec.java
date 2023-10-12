package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/ui/core/elements/StaticTextSpec;", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "Lcom/stripe/android/ui/core/elements/RequiredItemSpec;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "stringResId", "", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;I)V", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getStringResId", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "transform", "Lcom/stripe/android/ui/core/elements/FormElement;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StaticTextSpec.kt */
public final class StaticTextSpec extends FormItemSpec implements RequiredItemSpec {
    public static final Parcelable.Creator<StaticTextSpec> CREATOR = new Creator();
    private final IdentifierSpec identifier;
    private final int stringResId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StaticTextSpec.kt */
    public static final class Creator implements Parcelable.Creator<StaticTextSpec> {
        public final StaticTextSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StaticTextSpec((IdentifierSpec) parcel.readParcelable(StaticTextSpec.class.getClassLoader()), parcel.readInt());
        }

        public final StaticTextSpec[] newArray(int i) {
            return new StaticTextSpec[i];
        }
    }

    public static /* synthetic */ StaticTextSpec copy$default(StaticTextSpec staticTextSpec, IdentifierSpec identifierSpec, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            identifierSpec = staticTextSpec.getIdentifier();
        }
        if ((i2 & 2) != 0) {
            i = staticTextSpec.stringResId;
        }
        return staticTextSpec.copy(identifierSpec, i);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final int component2() {
        return this.stringResId;
    }

    public final StaticTextSpec copy(IdentifierSpec identifierSpec, int i) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new StaticTextSpec(identifierSpec, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StaticTextSpec)) {
            return false;
        }
        StaticTextSpec staticTextSpec = (StaticTextSpec) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) staticTextSpec.getIdentifier()) && this.stringResId == staticTextSpec.stringResId;
    }

    public int hashCode() {
        return (getIdentifier().hashCode() * 31) + this.stringResId;
    }

    public String toString() {
        return "StaticTextSpec(identifier=" + getIdentifier() + ", stringResId=" + this.stringResId + ')';
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
    public StaticTextSpec(IdentifierSpec identifierSpec, int i) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        this.identifier = identifierSpec;
        this.stringResId = i;
    }

    public final FormElement transform() {
        return new StaticTextElement(getIdentifier(), this.stringResId, (InputController) null, 4, (DefaultConstructorMarker) null);
    }
}

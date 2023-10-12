package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/ui/core/elements/AuBecsDebitMandateTextSpec;", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "Lcom/stripe/android/ui/core/elements/RequiredItemSpec;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;)V", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "transform", "Lcom/stripe/android/ui/core/elements/FormElement;", "merchantName", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuBecsDebitMandateTextSpec.kt */
public final class AuBecsDebitMandateTextSpec extends FormItemSpec implements RequiredItemSpec {
    public static final Parcelable.Creator<AuBecsDebitMandateTextSpec> CREATOR = new Creator();
    private final IdentifierSpec identifier;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AuBecsDebitMandateTextSpec.kt */
    public static final class Creator implements Parcelable.Creator<AuBecsDebitMandateTextSpec> {
        public final AuBecsDebitMandateTextSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuBecsDebitMandateTextSpec((IdentifierSpec) parcel.readParcelable(AuBecsDebitMandateTextSpec.class.getClassLoader()));
        }

        public final AuBecsDebitMandateTextSpec[] newArray(int i) {
            return new AuBecsDebitMandateTextSpec[i];
        }
    }

    public static /* synthetic */ AuBecsDebitMandateTextSpec copy$default(AuBecsDebitMandateTextSpec auBecsDebitMandateTextSpec, IdentifierSpec identifierSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = auBecsDebitMandateTextSpec.getIdentifier();
        }
        return auBecsDebitMandateTextSpec.copy(identifierSpec);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final AuBecsDebitMandateTextSpec copy(IdentifierSpec identifierSpec) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new AuBecsDebitMandateTextSpec(identifierSpec);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AuBecsDebitMandateTextSpec) && Intrinsics.areEqual((Object) getIdentifier(), (Object) ((AuBecsDebitMandateTextSpec) obj).getIdentifier());
    }

    public int hashCode() {
        return getIdentifier().hashCode();
    }

    public String toString() {
        return "AuBecsDebitMandateTextSpec(identifier=" + getIdentifier() + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.identifier, i);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuBecsDebitMandateTextSpec(IdentifierSpec identifierSpec) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        this.identifier = identifierSpec;
    }

    public final FormElement transform(String str) {
        Intrinsics.checkNotNullParameter(str, "merchantName");
        return new AuBecsDebitMandateTextElement(getIdentifier(), str, (InputController) null, 4, (DefaultConstructorMarker) null);
    }
}

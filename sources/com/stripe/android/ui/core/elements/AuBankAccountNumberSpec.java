package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0006\u0010\u0005\u001a\u00020\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004HÖ\u0001¨\u0006\f"}, d2 = {"Lcom/stripe/android/ui/core/elements/AuBankAccountNumberSpec;", "Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "()V", "describeContents", "", "transform", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuBankAccountNumberSpec.kt */
public final class AuBankAccountNumberSpec extends SectionFieldSpec {
    public static final int $stable = 8;
    public static final Parcelable.Creator<AuBankAccountNumberSpec> CREATOR = new Creator();
    public static final AuBankAccountNumberSpec INSTANCE = new AuBankAccountNumberSpec();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AuBankAccountNumberSpec.kt */
    public static final class Creator implements Parcelable.Creator<AuBankAccountNumberSpec> {
        public final AuBankAccountNumberSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return AuBankAccountNumberSpec.INSTANCE;
        }

        public final AuBankAccountNumberSpec[] newArray(int i) {
            return new AuBankAccountNumberSpec[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }

    private AuBankAccountNumberSpec() {
        super(new IdentifierSpec.Generic("account_number"), (DefaultConstructorMarker) null);
    }

    public final SectionFieldElement transform() {
        return new SimpleTextElement(getIdentifier(), new SimpleTextFieldController(new AuBankAccountNumberConfig(), false, (String) null, 6, (DefaultConstructorMarker) null));
    }
}

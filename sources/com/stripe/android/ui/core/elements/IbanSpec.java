package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0006\u0010\u0005\u001a\u00020\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004HÖ\u0001¨\u0006\f"}, d2 = {"Lcom/stripe/android/ui/core/elements/IbanSpec;", "Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "()V", "describeContents", "", "transform", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IbanSpec.kt */
public final class IbanSpec extends SectionFieldSpec {
    public static final int $stable = 8;
    public static final Parcelable.Creator<IbanSpec> CREATOR = new Creator();
    public static final IbanSpec INSTANCE = new IbanSpec();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IbanSpec.kt */
    public static final class Creator implements Parcelable.Creator<IbanSpec> {
        public final IbanSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return IbanSpec.INSTANCE;
        }

        public final IbanSpec[] newArray(int i) {
            return new IbanSpec[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }

    private IbanSpec() {
        super(new IdentifierSpec.Generic("iban"), (DefaultConstructorMarker) null);
    }

    public final SectionFieldElement transform() {
        return new IbanElement(getIdentifier(), new SimpleTextFieldController(new IbanConfig(), false, (String) null, 6, (DefaultConstructorMarker) null));
    }
}

package com.stripe.android.ui.core.elements;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/ui/core/elements/CardDetailsSpec;", "Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "()V", "describeContents", "", "transform", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "context", "Landroid/content/Context;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardDetailsSpec.kt */
public final class CardDetailsSpec extends SectionFieldSpec {
    public static final Parcelable.Creator<CardDetailsSpec> CREATOR = new Creator();
    public static final CardDetailsSpec INSTANCE = new CardDetailsSpec();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardDetailsSpec.kt */
    public static final class Creator implements Parcelable.Creator<CardDetailsSpec> {
        public final CardDetailsSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return CardDetailsSpec.INSTANCE;
        }

        public final CardDetailsSpec[] newArray(int i) {
            return new CardDetailsSpec[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }

    private CardDetailsSpec() {
        super(new IdentifierSpec.Generic("card_details"), (DefaultConstructorMarker) null);
    }

    public final SectionFieldElement transform(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CardDetailsElement(new IdentifierSpec.Generic("credit_detail"), context, (CardDetailsController) null, 4, (DefaultConstructorMarker) null);
    }
}

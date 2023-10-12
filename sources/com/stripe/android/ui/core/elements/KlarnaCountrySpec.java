package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004HÖ\u0001¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/ui/core/elements/KlarnaCountrySpec;", "Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "()V", "describeContents", "", "transform", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "currencyCode", "", "country", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KlarnaCountrySpec.kt */
public final class KlarnaCountrySpec extends SectionFieldSpec {
    public static final int $stable = 8;
    public static final Parcelable.Creator<KlarnaCountrySpec> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KlarnaCountrySpec.kt */
    public static final class Creator implements Parcelable.Creator<KlarnaCountrySpec> {
        public final KlarnaCountrySpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new KlarnaCountrySpec();
        }

        public final KlarnaCountrySpec[] newArray(int i) {
            return new KlarnaCountrySpec[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }

    public KlarnaCountrySpec() {
        super(IdentifierSpec.Country.INSTANCE, (DefaultConstructorMarker) null);
    }

    public final SectionFieldElement transform(String str, String str2) {
        return new CountryElement(getIdentifier(), new DropdownFieldController(new CountryConfig(KlarnaHelper.INSTANCE.getAllowedCountriesForCurrency(str), (Locale) null, 2, (DefaultConstructorMarker) null), str2));
    }
}

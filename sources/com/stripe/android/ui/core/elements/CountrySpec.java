package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/ui/core/elements/CountrySpec;", "Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "onlyShowCountryCodes", "", "", "(Ljava/util/Set;)V", "getOnlyShowCountryCodes", "()Ljava/util/Set;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "transform", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "country", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CountrySpec.kt */
public final class CountrySpec extends SectionFieldSpec {
    public static final int $stable = 8;
    public static final Parcelable.Creator<CountrySpec> CREATOR = new Creator();
    private final Set<String> onlyShowCountryCodes;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CountrySpec.kt */
    public static final class Creator implements Parcelable.Creator<CountrySpec> {
        public final CountrySpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashSet.add(parcel.readString());
            }
            return new CountrySpec(linkedHashSet);
        }

        public final CountrySpec[] newArray(int i) {
            return new CountrySpec[i];
        }
    }

    public CountrySpec() {
        this((Set) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CountrySpec copy$default(CountrySpec countrySpec, Set<String> set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = countrySpec.onlyShowCountryCodes;
        }
        return countrySpec.copy(set);
    }

    public final Set<String> component1() {
        return this.onlyShowCountryCodes;
    }

    public final CountrySpec copy(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "onlyShowCountryCodes");
        return new CountrySpec(set);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CountrySpec) && Intrinsics.areEqual((Object) this.onlyShowCountryCodes, (Object) ((CountrySpec) obj).onlyShowCountryCodes);
    }

    public int hashCode() {
        return this.onlyShowCountryCodes.hashCode();
    }

    public String toString() {
        return "CountrySpec(onlyShowCountryCodes=" + this.onlyShowCountryCodes + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Set<String> set = this.onlyShowCountryCodes;
        parcel.writeInt(set.size());
        for (String writeString : set) {
            parcel.writeString(writeString);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CountrySpec(Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt.emptySet() : set);
    }

    public final Set<String> getOnlyShowCountryCodes() {
        return this.onlyShowCountryCodes;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountrySpec(Set<String> set) {
        super(IdentifierSpec.Country.INSTANCE, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(set, "onlyShowCountryCodes");
        this.onlyShowCountryCodes = set;
    }

    public final SectionFieldElement transform(String str) {
        return new CountryElement(getIdentifier(), new DropdownFieldController(new CountryConfig(this.onlyShowCountryCodes, (Locale) null, 2, (DefaultConstructorMarker) null), str));
    }
}

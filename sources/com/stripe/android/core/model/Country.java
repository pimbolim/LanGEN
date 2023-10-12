package com.stripe.android.core.model;

import com.stripe.android.model.PaymentMethodOptionsParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/core/model/Country;", "", "code", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stripe/android/core/model/CountryCode;", "(Lcom/stripe/android/core/model/CountryCode;Ljava/lang/String;)V", "getCode", "()Lcom/stripe/android/core/model/CountryCode;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Country.kt */
public final class Country {
    public static final int $stable = 8;
    private final CountryCode code;
    private final String name;

    public static /* synthetic */ Country copy$default(Country country, CountryCode countryCode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            countryCode = country.code;
        }
        if ((i & 2) != 0) {
            str = country.name;
        }
        return country.copy(countryCode, str);
    }

    public final CountryCode component1() {
        return this.code;
    }

    public final String component2() {
        return this.name;
    }

    public final Country copy(CountryCode countryCode, String str) {
        Intrinsics.checkNotNullParameter(countryCode, PaymentMethodOptionsParams.Blik.PARAM_CODE);
        Intrinsics.checkNotNullParameter(str, "name");
        return new Country(countryCode, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Country)) {
            return false;
        }
        Country country = (Country) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) country.code) && Intrinsics.areEqual((Object) this.name, (Object) country.name);
    }

    public int hashCode() {
        return (this.code.hashCode() * 31) + this.name.hashCode();
    }

    public Country(CountryCode countryCode, String str) {
        Intrinsics.checkNotNullParameter(countryCode, PaymentMethodOptionsParams.Blik.PARAM_CODE);
        Intrinsics.checkNotNullParameter(str, "name");
        this.code = countryCode;
        this.name = str;
    }

    public final CountryCode getCode() {
        return this.code;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Country(String str, String str2) {
        this(CountryCode.Companion.create(str), str2);
        Intrinsics.checkNotNullParameter(str, PaymentMethodOptionsParams.Blik.PARAM_CODE);
        Intrinsics.checkNotNullParameter(str2, "name");
    }

    public String toString() {
        return this.name;
    }
}

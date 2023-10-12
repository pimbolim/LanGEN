package com.stripe.android.core.model;

import com.stripe.android.core.model.CountryCode;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, d2 = {"getCountryCode", "Lcom/stripe/android/core/model/CountryCode;", "Ljava/util/Locale;", "stripe-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CountryCode.kt */
public final class CountryCodeKt {
    public static final CountryCode getCountryCode(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        CountryCode.Companion companion = CountryCode.Companion;
        String country = locale.getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "this.country");
        return companion.create(country);
    }
}

package com.stripe.android.core.model;

import com.stripe.android.core.model.CountryCode;
import com.stripe.android.model.PaymentMethodOptionsParams;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0015\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u0013J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\tJ\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0007J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\tJ\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0015\u001a\u00020\tH\u0007J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0015\u001a\u00020\tH\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/core/model/CountryUtils;", "", "()V", "CARD_POSTAL_CODE_COUNTRIES", "", "", "getCARD_POSTAL_CODE_COUNTRIES$stripe_core_release", "()Ljava/util/Set;", "cachedCountriesLocale", "Ljava/util/Locale;", "cachedOrderedLocalizedCountries", "", "Lcom/stripe/android/core/model/Country;", "doesCountryUsePostalCode", "", "countryCode", "Lcom/stripe/android/core/model/CountryCode;", "formatNameForSorting", "name", "formatNameForSorting$stripe_core_release", "getCountryByCode", "currentLocale", "getCountryCodeByName", "countryName", "getDisplayCountry", "getOrderedCountries", "getSortedLocalizedCountries", "localizedCountries", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CountryUtils.kt */
public final class CountryUtils {
    public static final int $stable = 8;
    private static final Set<String> CARD_POSTAL_CODE_COUNTRIES = SetsKt.setOf("US", "GB", "CA");
    public static final CountryUtils INSTANCE = new CountryUtils();
    private static Locale cachedCountriesLocale;
    private static List<Country> cachedOrderedLocalizedCountries = CollectionsKt.emptyList();

    private CountryUtils() {
    }

    public final Set<String> getCARD_POSTAL_CODE_COUNTRIES$stripe_core_release() {
        return CARD_POSTAL_CODE_COUNTRIES;
    }

    private final List<Country> localizedCountries(Locale locale) {
        String[] iSOCountries = Locale.getISOCountries();
        Intrinsics.checkNotNullExpressionValue(iSOCountries, "getISOCountries()");
        Object[] objArr = (Object[]) iSOCountries;
        Collection arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            String str = (String) obj;
            CountryCode.Companion companion = CountryCode.Companion;
            Intrinsics.checkNotNullExpressionValue(str, PaymentMethodOptionsParams.Blik.PARAM_CODE);
            CountryCode create = companion.create(str);
            String displayCountry = new Locale("", str).getDisplayCountry(locale);
            Intrinsics.checkNotNullExpressionValue(displayCountry, "Locale(\"\", code).getDisplayCountry(currentLocale)");
            arrayList.add(new Country(create, displayCountry));
        }
        return (List) arrayList;
    }

    public final /* synthetic */ String getDisplayCountry(CountryCode countryCode, Locale locale) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(locale, "currentLocale");
        Country countryByCode = getCountryByCode(countryCode, locale);
        String name = countryByCode == null ? null : countryByCode.getName();
        if (name != null) {
            return name;
        }
        String displayCountry = new Locale("", countryCode.getValue()).getDisplayCountry(locale);
        Intrinsics.checkNotNullExpressionValue(displayCountry, "Locale(\"\", countryCode.v…layCountry(currentLocale)");
        return displayCountry;
    }

    public final /* synthetic */ CountryCode getCountryCodeByName(String str, Locale locale) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "countryName");
        Intrinsics.checkNotNullParameter(locale, "currentLocale");
        Iterator it = localizedCountries(locale).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Country) obj).getName(), (Object) str)) {
                break;
            }
        }
        Country country = (Country) obj;
        if (country == null) {
            return null;
        }
        return country.getCode();
    }

    public final /* synthetic */ Country getCountryByCode(CountryCode countryCode, Locale locale) {
        Object obj;
        Intrinsics.checkNotNullParameter(locale, "currentLocale");
        Iterator it = localizedCountries(locale).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Country) obj).getCode(), (Object) countryCode)) {
                break;
            }
        }
        return (Country) obj;
    }

    private final List<Country> getSortedLocalizedCountries(Locale locale) {
        if (Intrinsics.areEqual((Object) locale, (Object) cachedCountriesLocale)) {
            return cachedOrderedLocalizedCountries;
        }
        cachedCountriesLocale = locale;
        Collection arrayList = new ArrayList();
        for (Object next : CollectionsKt.sortedWith(localizedCountries(locale), new CountryUtils$getSortedLocalizedCountries$$inlined$sortedBy$1())) {
            if (!Intrinsics.areEqual((Object) ((Country) next).getCode(), (Object) CountryCodeKt.getCountryCode(locale))) {
                arrayList.add(next);
            }
        }
        List<Country> list = (List) arrayList;
        cachedOrderedLocalizedCountries = list;
        return list;
    }

    public final /* synthetic */ List getOrderedCountries(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "currentLocale");
        return CollectionsKt.plus(CollectionsKt.listOfNotNull(getCountryByCode(CountryCodeKt.getCountryCode(locale), locale)), getSortedLocalizedCountries(locale));
    }

    public final String formatNameForSorting$stripe_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        String normalize = Normalizer.normalize(lowerCase, Normalizer.Form.NFD);
        Intrinsics.checkNotNullExpressionValue(normalize, "normalize(name.lowercase(), Normalizer.Form.NFD)");
        return new Regex("\\p{Mn}+").replace((CharSequence) normalize, "");
    }

    @Deprecated(message = "Use with parameter CountryCode", replaceWith = @ReplaceWith(expression = "CountryUtils.doesCountryUsePostalCode(CountryCode.create(countryCode))", imports = {"com.stripe.android.model.CountryCode"}))
    public final /* synthetic */ boolean doesCountryUsePostalCode(String str) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Set<String> set = CARD_POSTAL_CODE_COUNTRIES;
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return set.contains(upperCase);
    }

    public final /* synthetic */ boolean doesCountryUsePostalCode(CountryCode countryCode) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        return CARD_POSTAL_CODE_COUNTRIES.contains(countryCode.getValue());
    }
}

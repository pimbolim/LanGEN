package com.stripe.android.ui.core.elements;

import com.henninghall.date_picker.props.LocaleProp;
import com.stripe.android.core.model.Country;
import com.stripe.android.core.model.CountryCode;
import com.stripe.android.core.model.CountryUtils;
import com.stripe.android.ui.core.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0016R\u0014\u0010\b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\f8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/ui/core/elements/CountryConfig;", "Lcom/stripe/android/ui/core/elements/DropdownConfig;", "onlyShowCountryCodes", "", "", "locale", "Ljava/util/Locale;", "(Ljava/util/Set;Ljava/util/Locale;)V", "debugLabel", "getDebugLabel", "()Ljava/lang/String;", "label", "", "getLabel", "()I", "getLocale", "()Ljava/util/Locale;", "getOnlyShowCountryCodes", "()Ljava/util/Set;", "convertFromRaw", "rawValue", "convertToRaw", "displayName", "getDisplayItems", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CountryConfig.kt */
public final class CountryConfig implements DropdownConfig {
    public static final int $stable = 8;
    private final String debugLabel;
    private final int label;
    private final Locale locale;
    private final Set<String> onlyShowCountryCodes;

    public CountryConfig() {
        this((Set) null, (Locale) null, 3, (DefaultConstructorMarker) null);
    }

    public CountryConfig(Set<String> set, Locale locale2) {
        Intrinsics.checkNotNullParameter(set, "onlyShowCountryCodes");
        Intrinsics.checkNotNullParameter(locale2, LocaleProp.name);
        this.onlyShowCountryCodes = set;
        this.locale = locale2;
        this.debugLabel = "country";
        this.label = R.string.address_label_country;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CountryConfig(java.util.Set r1, java.util.Locale r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0008
            java.util.Set r1 = kotlin.collections.SetsKt.emptySet()
        L_0x0008:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0015
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = "getDefault()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x0015:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.CountryConfig.<init>(java.util.Set, java.util.Locale, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Set<String> getOnlyShowCountryCodes() {
        return this.onlyShowCountryCodes;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public String getDebugLabel() {
        return this.debugLabel;
    }

    public int getLabel() {
        return this.label;
    }

    public List<String> getDisplayItems() {
        Collection arrayList = new ArrayList();
        for (Object next : CountryUtils.INSTANCE.getOrderedCountries(this.locale)) {
            Country country = (Country) next;
            boolean z = true;
            if (!getOnlyShowCountryCodes().isEmpty() && (!(!getOnlyShowCountryCodes().isEmpty()) || !getOnlyShowCountryCodes().contains(country.getCode().getValue()))) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        Iterable<Country> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Country name : iterable) {
            arrayList2.add(name.getName());
        }
        return (List) arrayList2;
    }

    public String convertFromRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        CountryUtils countryUtils = CountryUtils.INSTANCE;
        CountryCode create = CountryCode.Companion.create(str);
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        Country countryByCode = countryUtils.getCountryByCode(create, locale2);
        String name = countryByCode == null ? null : countryByCode.getName();
        return name == null ? getDisplayItems().get(0) : name;
    }

    public String convertToRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        CountryUtils countryUtils = CountryUtils.INSTANCE;
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        CountryCode countryCodeByName = countryUtils.getCountryCodeByName(str, locale2);
        if (countryCodeByName == null) {
            return null;
        }
        return countryCodeByName.getValue();
    }
}

package com.stripe.android.ui.core.elements;

import com.henninghall.date_picker.props.LocaleProp;
import com.stripe.android.model.Source;
import com.stripe.android.ui.core.R;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/ui/core/elements/KlarnaHelper;", "", "()V", "buyNowCountries", "", "", "currencyToAllowedCountries", "", "getAllowedCountriesForCurrency", "currencyCode", "getKlarnaHeader", "", "locale", "Ljava/util/Locale;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KlarnaHelper.kt */
public final class KlarnaHelper {
    public static final int $stable = 8;
    public static final KlarnaHelper INSTANCE = new KlarnaHelper();
    private static final Set<String> buyNowCountries = SetsKt.setOf("AT", "BE", "DE", "IT", "NL", "ES", "SE");
    private static final Map<String, Set<String>> currencyToAllowedCountries = MapsKt.mapOf(TuplesKt.to(Source.EURO, SetsKt.setOf("AT", "FI", "DE", "NL", "BE", "ES", "IT", "FR")), TuplesKt.to("dkk", SetsKt.setOf("DK")), TuplesKt.to("nok", SetsKt.setOf("NO")), TuplesKt.to("sek", SetsKt.setOf("SE")), TuplesKt.to("gbp", SetsKt.setOf("GB")), TuplesKt.to(Source.USD, SetsKt.setOf("US")));

    private KlarnaHelper() {
    }

    public final Set<String> getAllowedCountriesForCurrency(String str) {
        Set<String> set = currencyToAllowedCountries.get(str);
        return set == null ? SetsKt.emptySet() : set;
    }

    public static /* synthetic */ int getKlarnaHeader$default(KlarnaHelper klarnaHelper, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return klarnaHelper.getKlarnaHeader(locale);
    }

    public final int getKlarnaHeader(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, LocaleProp.name);
        if (buyNowCountries.contains(locale.getCountry())) {
            return R.string.klarna_buy_now_pay_later;
        }
        return R.string.klarna_pay_later;
    }
}

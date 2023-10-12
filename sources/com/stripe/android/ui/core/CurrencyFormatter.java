package com.stripe.android.ui.core;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/stripe/android/ui/core/CurrencyFormatter;", "", "()V", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CurrencyFormatter.kt */
public final class CurrencyFormatter {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final double MAJOR_UNIT_BASE = 10.0d;
    /* access modifiers changed from: private */
    public static final Map<Set<String>, Integer> SERVER_DECIMAL_DIGITS = MapsKt.mapOf(TuplesKt.to(SetsKt.setOf("UGX", "AFN", "ALL", "AMD", "COP", "IDR", "ISK", "PKR", "LBP"), 2));

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/ui/core/CurrencyFormatter$Companion;", "", "()V", "MAJOR_UNIT_BASE", "", "SERVER_DECIMAL_DIGITS", "", "", "", "", "format", "amount", "", "amountCurrency", "Ljava/util/Currency;", "targetLocale", "Ljava/util/Locale;", "amountCurrencyCode", "getDefaultDecimalDigits", "currency", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CurrencyFormatter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ String format$default(Companion companion, long j, String str, Locale locale, int i, Object obj) {
            if ((i & 4) != 0) {
                locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            }
            return companion.format(j, str, locale);
        }

        public final String format(long j, String str, Locale locale) {
            Intrinsics.checkNotNullParameter(str, "amountCurrencyCode");
            Intrinsics.checkNotNullParameter(locale, "targetLocale");
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Currency instance = Currency.getInstance(upperCase);
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(amountCurrencyCode.uppercase())");
            return format(j, instance, locale);
        }

        public static /* synthetic */ String format$default(Companion companion, long j, Currency currency, Locale locale, int i, Object obj) {
            if ((i & 4) != 0) {
                locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            }
            return companion.format(j, currency, locale);
        }

        public final String format(long j, Currency currency, Locale locale) {
            Intrinsics.checkNotNullParameter(currency, "amountCurrency");
            Intrinsics.checkNotNullParameter(locale, "targetLocale");
            int defaultDecimalDigits = getDefaultDecimalDigits(currency);
            double pow = ((double) j) / Math.pow(CurrencyFormatter.MAJOR_UNIT_BASE, (double) defaultDecimalDigits);
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                if (currencyInstance != null) {
                    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) currencyInstance).getDecimalFormatSymbols();
                    decimalFormatSymbols.setCurrency(currency);
                    decimalFormatSymbols.setCurrencySymbol(currency.getSymbol(locale));
                    ((DecimalFormat) currencyInstance).setMinimumFractionDigits(defaultDecimalDigits);
                    ((DecimalFormat) currencyInstance).setDecimalFormatSymbols(decimalFormatSymbols);
                    Result.m4709constructorimpl(Unit.INSTANCE);
                    String format = currencyInstance.format(pow);
                    Intrinsics.checkNotNullExpressionValue(format, "currencyFormat.format(majorUnitAmount)");
                    return format;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.text.DecimalFormat");
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
        }

        private final int getDefaultDecimalDigits(Currency currency) {
            Map access$getSERVER_DECIMAL_DIGITS$cp = CurrencyFormatter.SERVER_DECIMAL_DIGITS;
            Map linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : access$getSERVER_DECIMAL_DIGITS$cp.entrySet()) {
                String currencyCode = currency.getCurrencyCode();
                Intrinsics.checkNotNullExpressionValue(currencyCode, "currency.currencyCode");
                String upperCase = currencyCode.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                if (((Set) entry.getKey()).contains(upperCase)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Collection arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry value : linkedHashMap.entrySet()) {
                arrayList.add(Integer.valueOf(((Number) value.getValue()).intValue()));
            }
            Integer num = (Integer) CollectionsKt.firstOrNull((List) arrayList);
            return num == null ? currency.getDefaultFractionDigits() : num.intValue();
        }
    }
}

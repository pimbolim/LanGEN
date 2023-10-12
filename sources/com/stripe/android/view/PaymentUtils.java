package com.stripe.android.view;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0007¨\u0006\r"}, d2 = {"Lcom/stripe/android/view/PaymentUtils;", "", "()V", "formatPriceString", "", "amount", "", "currency", "Ljava/util/Currency;", "formatPriceString$payments_core_release", "formatPriceStringUsingFree", "", "free", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentUtils.kt */
public final class PaymentUtils {
    public static final int $stable = 0;
    public static final PaymentUtils INSTANCE = new PaymentUtils();

    private PaymentUtils() {
    }

    @JvmStatic
    public static final String formatPriceStringUsingFree(long j, Currency currency, String str) {
        Intrinsics.checkNotNullParameter(currency, FirebaseAnalytics.Param.CURRENCY);
        Intrinsics.checkNotNullParameter(str, "free");
        if (j == 0) {
            return str;
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        Objects.requireNonNull(currencyInstance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) currencyInstance;
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol(currency.getSymbol(Locale.getDefault()));
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return INSTANCE.formatPriceString$payments_core_release((double) j, currency);
    }

    public final /* synthetic */ String formatPriceString$payments_core_release(double d, Currency currency) {
        Intrinsics.checkNotNullParameter(currency, FirebaseAnalytics.Param.CURRENCY);
        double pow = d / Math.pow(10.0d, (double) currency.getDefaultFractionDigits());
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        if (currencyInstance != null) {
            try {
                DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) currencyInstance).getDecimalFormatSymbols();
                decimalFormatSymbols.setCurrencySymbol(currency.getSymbol(Locale.getDefault()));
                ((DecimalFormat) currencyInstance).setDecimalFormatSymbols(decimalFormatSymbols);
                String format = currencyInstance.format(pow);
                Intrinsics.checkNotNullExpressionValue(format, "{\n            val decima…ajorUnitAmount)\n        }");
                return format;
            } catch (ClassCastException unused) {
                String format2 = currencyInstance.format(pow);
                Intrinsics.checkNotNullExpressionValue(format2, "{\n            currencyFo…ajorUnitAmount)\n        }");
                return format2;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.text.DecimalFormat");
        }
    }
}

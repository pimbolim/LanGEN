package com.stripe.android;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/stripe/android/PayWithGoogleUtils;", "", "()V", "getPriceString", "", "price", "", "currency", "Ljava/util/Currency;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayWithGoogleUtils.kt */
public final class PayWithGoogleUtils {
    public static final int $stable = 0;
    public static final PayWithGoogleUtils INSTANCE = new PayWithGoogleUtils();

    private PayWithGoogleUtils() {
    }

    @JvmStatic
    public static final String getPriceString(int i, Currency currency) {
        Intrinsics.checkNotNullParameter(currency, FirebaseAnalytics.Param.CURRENCY);
        int defaultFractionDigits = currency.getDefaultFractionDigits();
        int length = String.valueOf(i).length();
        StringBuilder sb = new StringBuilder();
        if (defaultFractionDigits == 0) {
            int i2 = 0;
            while (i2 < length) {
                i2++;
                sb.append('#');
            }
            DecimalFormat decimalFormat = new DecimalFormat(sb.toString(), DecimalFormatSymbols.getInstance(Locale.ROOT));
            decimalFormat.setCurrency(currency);
            decimalFormat.setGroupingUsed(false);
            String format = decimalFormat.format(Integer.valueOf(i));
            Intrinsics.checkNotNullExpressionValue(format, "noDecimalCurrencyFormat.format(price)");
            return format;
        }
        int i3 = length - defaultFractionDigits;
        int i4 = 0;
        while (i4 < i3) {
            i4++;
            sb.append('#');
        }
        if (length <= defaultFractionDigits) {
            sb.append('0');
        }
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        int i5 = 0;
        while (i5 < defaultFractionDigits) {
            i5++;
            sb.append('0');
        }
        double pow = ((double) i) / Math.pow(10.0d, (double) defaultFractionDigits);
        DecimalFormat decimalFormat2 = new DecimalFormat(sb.toString(), DecimalFormatSymbols.getInstance(Locale.ROOT));
        decimalFormat2.setCurrency(currency);
        decimalFormat2.setGroupingUsed(false);
        String format2 = decimalFormat2.format(pow);
        Intrinsics.checkNotNullExpressionValue(format2, "decimalFormat.format(decimalPrice)");
        return format2;
    }
}

package com.stripe.android.view;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H\u0007J\u001a\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/view/DateUtils;", "", "()V", "MAX_VALID_YEAR", "", "convertTwoDigitYearToFour", "inputYear", "calendar", "Ljava/util/Calendar;", "isExpiryDataValid", "", "expiryMonth", "expiryYear", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DateUtils.kt */
public final class DateUtils {
    public static final DateUtils INSTANCE = new DateUtils();
    private static final int MAX_VALID_YEAR = 9980;

    private DateUtils() {
    }

    @JvmStatic
    public static final boolean isExpiryDataValid(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return isExpiryDataValid(i, i2, instance);
    }

    @JvmStatic
    public static final boolean isExpiryDataValid(int i, int i2, Calendar calendar) {
        int i3;
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        if (!(1 <= i && i < 13)) {
            return false;
        }
        return (i2 >= 0 && i2 <= MAX_VALID_YEAR) && i2 >= (i3 = calendar.get(1)) && (i2 > i3 || i >= calendar.get(2) + 1);
    }

    public final int convertTwoDigitYearToFour(int i) {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return convertTwoDigitYearToFour(i, instance);
    }

    public final int convertTwoDigitYearToFour(int i, Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        int i2 = calendar.get(1);
        int i3 = i2 / 100;
        int i4 = i2 % 100;
        if (i4 > 80 && i < 20) {
            i3++;
        } else if (i4 < 20 && i > 80) {
            i3--;
        }
        return (i3 * 100) + i;
    }
}

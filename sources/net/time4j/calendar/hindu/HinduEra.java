package net.time4j.calendar.hindu;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Locale;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarEra;
import net.time4j.format.CalendarText;
import net.time4j.format.TextWidth;

public enum HinduEra implements CalendarEra {
    KALI_YUGA,
    NEPALESE,
    KOLLAM,
    VIKRAMA,
    SAKA,
    BENGAL;
    
    private static final int[] SAKA_OFFSETS = null;

    static {
        SAKA_OFFSETS = new int[]{3179, 955, TypedValues.Custom.TYPE_INT, 135, 0, -515};
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getInstance("hindu", locale).getEras(textWidth).print(this);
    }

    public int yearOfEra(HinduEra hinduEra, int i) {
        try {
            int[] iArr = SAKA_OFFSETS;
            return MathUtils.safeSubtract(MathUtils.safeAdd(i, iArr[ordinal()]), iArr[hinduEra.ordinal()]);
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Out of range: " + i);
        }
    }
}

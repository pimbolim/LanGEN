package net.time4j.calendar;

import java.util.Locale;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoOperator;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextWidth;

public enum HijriMonth implements ChronoCondition<HijriCalendar> {
    MUHARRAM,
    SAFAR,
    RABI_I,
    RABI_II,
    JUMADA_I,
    JUMADA_II,
    RAJAB,
    SHABAN,
    RAMADAN,
    SHAWWAL,
    DHU_AL_QIDAH,
    DHU_AL_HIJJAH;
    
    private static final HijriMonth[] ENUMS = null;

    static {
        ENUMS = values();
    }

    public static HijriMonth valueOf(int i) {
        if (i >= 1 && i <= 12) {
            return ENUMS[i - 1];
        }
        throw new IllegalArgumentException("Out of range: " + i);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE, OutputContext.FORMAT);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return CalendarText.getInstance("islamic", locale).getStdMonths(textWidth, outputContext).print(this);
    }

    public boolean test(HijriCalendar hijriCalendar) {
        return hijriCalendar.getMonth() == this;
    }

    static class Operator implements ChronoOperator<HijriCalendar> {
        private final int steps;

        Operator(int i) {
            this.steps = i;
        }

        public HijriCalendar apply(HijriCalendar hijriCalendar) {
            int year = (((hijriCalendar.getYear() * 12) + hijriCalendar.getMonth().getValue()) - 1) + this.steps;
            int i = year / 12;
            int i2 = (year % 12) + 1;
            return HijriCalendar.of(hijriCalendar.getVariant(), i, i2, Math.min(hijriCalendar.getDayOfMonth(), hijriCalendar.getCalendarSystem().getLengthOfMonth(HijriEra.ANNO_HEGIRAE, i, i2)));
        }
    }
}

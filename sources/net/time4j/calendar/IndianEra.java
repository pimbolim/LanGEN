package net.time4j.calendar;

import java.util.Locale;
import net.time4j.engine.CalendarEra;
import net.time4j.format.CalendarText;
import net.time4j.format.TextWidth;

public enum IndianEra implements CalendarEra {
    SAKA;

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getInstance("indian", locale).getEras(textWidth).print(this);
    }
}

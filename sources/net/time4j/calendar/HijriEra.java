package net.time4j.calendar;

import java.util.Locale;
import net.time4j.engine.CalendarEra;
import net.time4j.format.CalendarText;
import net.time4j.format.TextWidth;

public enum HijriEra implements CalendarEra {
    ANNO_HEGIRAE;

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getInstance("islamic", locale).getEras(textWidth).print(this);
    }
}

package net.time4j.format.expert;

import java.util.Locale;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.CalendarText;
import net.time4j.tz.OffsetSign;
import net.time4j.tz.TZID;
import net.time4j.tz.ZonalOffset;

enum TimezoneElement implements ChronoElement<TZID> {
    TIMEZONE_ID,
    TIMEZONE_OFFSET;

    public char getSymbol() {
        return 0;
    }

    public boolean isDateElement() {
        return false;
    }

    public boolean isLenient() {
        return false;
    }

    public boolean isTimeElement() {
        return false;
    }

    public Class<TZID> getType() {
        return TZID.class;
    }

    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return chronoDisplay.getTimezone().canonical().compareTo(chronoDisplay2.getTimezone().canonical());
    }

    public TZID getDefaultMinimum() {
        return ZonalOffset.ofHours(OffsetSign.BEHIND_UTC, 14);
    }

    public TZID getDefaultMaximum() {
        return ZonalOffset.ofHours(OffsetSign.AHEAD_OF_UTC, 14);
    }

    public String getDisplayName(Locale locale) {
        String str = CalendarText.getIsoInstance(locale).getTextForms().get("L_zone");
        return str == null ? name() : str;
    }
}

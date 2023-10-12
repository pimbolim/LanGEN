package net.time4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.base.WallTime;
import net.time4j.engine.ChronoCondition;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextWidth;

public enum Meridiem implements ChronoCondition<WallTime> {
    AM,
    PM;

    public static Meridiem ofHour(int i) {
        if (i >= 0 && i <= 24) {
            return (i < 12 || i == 24) ? AM : PM;
        }
        throw new IllegalArgumentException("Hour of day out of range: " + i);
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE, OutputContext.FORMAT);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return CalendarText.getIsoInstance(locale).getMeridiems(textWidth, outputContext).print(this);
    }

    public static Meridiem parse(CharSequence charSequence, Locale locale, TextWidth textWidth, OutputContext outputContext) throws ParseException {
        char charAt;
        if (charSequence.length() == 2 && ((charAt = charSequence.charAt(1)) == 'M' || charAt == 'm')) {
            char charAt2 = charSequence.charAt(0);
            if (charAt2 == 'A' || charAt2 == 'a') {
                return AM;
            }
            if (charAt2 == 'P' || charAt2 == 'p') {
                return PM;
            }
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Meridiem meridiem = (Meridiem) CalendarText.getIsoInstance(locale).getMeridiems(textWidth, outputContext).parse(charSequence, parsePosition, Meridiem.class);
        if (meridiem != null) {
            return meridiem;
        }
        throw new ParseException("Cannot parse: " + charSequence, parsePosition.getErrorIndex());
    }

    public boolean test(WallTime wallTime) {
        int hour = wallTime.getHour();
        if (this != AM) {
            return hour >= 12 && hour < 24;
        }
        if (hour < 12 || hour == 24) {
            return true;
        }
    }
}

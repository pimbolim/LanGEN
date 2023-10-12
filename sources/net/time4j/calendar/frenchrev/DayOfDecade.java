package net.time4j.calendar.frenchrev;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import java.util.Map;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextWidth;

public enum DayOfDecade {
    PRIMIDI,
    DUODI,
    TRIDI,
    QUARTIDI,
    QUINTIDI,
    SEXTIDI,
    SEPTIDI,
    OCTIDI,
    NONIDI,
    DECADI;

    public static DayOfDecade valueOf(int i) {
        if (i >= 1 && i <= 10) {
            return values()[i - 1];
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
        CalendarText instance = CalendarText.getInstance("frenchrev", locale);
        String str = textWidth == TextWidth.NARROW ? "N" : outputContext == OutputContext.FORMAT ? "w" : ExifInterface.LONGITUDE_WEST;
        Map<String, String> textForms = instance.getTextForms();
        return textForms.get("D(" + str + ")_" + getValue());
    }
}

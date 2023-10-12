package net.time4j.calendar.frenchrev;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;

public enum Sansculottides {
    COMPLEMENTARY_DAY_1,
    COMPLEMENTARY_DAY_2,
    COMPLEMENTARY_DAY_3,
    COMPLEMENTARY_DAY_4,
    COMPLEMENTARY_DAY_5,
    LEAP_DAY;

    public static Sansculottides valueOf(int i) {
        if (i >= 1 && i <= 6) {
            return values()[i - 1];
        }
        throw new IllegalArgumentException("Out of range: " + i);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public String getDisplayName(Locale locale, OutputContext outputContext) {
        CalendarText instance = CalendarText.getInstance("frenchrev", locale);
        StringBuilder sb = new StringBuilder();
        sb.append("S(");
        sb.append(outputContext == OutputContext.STANDALONE ? ExifInterface.LONGITUDE_WEST : "w");
        sb.append(")_");
        sb.append(getValue());
        String str = instance.getTextForms().get(sb.toString());
        if (str != null || outputContext != OutputContext.STANDALONE) {
            return str;
        }
        return instance.getTextForms().get("S(w)_" + getValue());
    }
}

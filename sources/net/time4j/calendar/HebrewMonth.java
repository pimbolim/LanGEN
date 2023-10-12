package net.time4j.calendar;

import java.util.Locale;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.ChronoCondition;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextWidth;

public enum HebrewMonth implements ChronoCondition<HebrewCalendar> {
    TISHRI,
    HESHVAN,
    KISLEV,
    TEVET,
    SHEVAT,
    ADAR_I,
    ADAR_II,
    NISAN,
    IYAR,
    SIVAN,
    TAMUZ,
    AV,
    ELUL;
    
    private static final AttributeKey<Order> ATTRIBUTE = null;
    private static final HebrewMonth[] ENUMS = null;

    public enum Order {
        CIVIL,
        BIBLICAL,
        ENUM
    }

    static {
        ENUMS = values();
        ATTRIBUTE = Attributes.createKey("HEBREW_MONTH_ORDER", Order.class);
    }

    public static HebrewMonth valueOfCivil(int i, boolean z) {
        if (i < 1 || i > 13 || (!z && i == 13)) {
            throw new IllegalArgumentException("Hebrew month out of range: " + i);
        } else if (z || i < 6) {
            return ENUMS[i - 1];
        } else {
            return ENUMS[i];
        }
    }

    public static HebrewMonth valueOfBiblical(int i, boolean z) {
        if (i < 1 || i > 13 || (!z && i == 13)) {
            throw new IllegalArgumentException("Hebrew month out of range: " + i);
        }
        int i2 = i + 7;
        if (i2 > 13) {
            i2 -= 13;
        }
        if (z || i != 12) {
            return ENUMS[i2 - 1];
        }
        return ADAR_II;
    }

    public int getCivilValue(boolean z) {
        int ordinal = ordinal() + 1;
        return (z || ordinal < 7) ? ordinal : ordinal - 1;
    }

    public int getBiblicalValue(boolean z) {
        int ordinal = ordinal() + 7;
        if (ordinal > 13) {
            ordinal -= 13;
        }
        if (z || ordinal != 13) {
            return ordinal;
        }
        return 12;
    }

    public String getDisplayName(Locale locale, boolean z) {
        return getDisplayName(locale, TextWidth.WIDE, OutputContext.FORMAT, z);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth, OutputContext outputContext, boolean z) {
        CalendarText instance = CalendarText.getInstance("hebrew", locale);
        if (!z || this != ADAR_II) {
            return instance.getStdMonths(textWidth, outputContext).print(this);
        }
        return instance.getLeapMonths(textWidth, outputContext).print(this);
    }

    public boolean test(HebrewCalendar hebrewCalendar) {
        return hebrewCalendar.getMonth() == this;
    }

    public static AttributeKey<Order> order() {
        return ATTRIBUTE;
    }

    static HebrewMonth valueOf(int i) {
        if (i >= 1 && i <= 13) {
            return ENUMS[i - 1];
        }
        throw new IllegalArgumentException("Hebrew month out of range: " + i);
    }

    /* access modifiers changed from: package-private */
    public int getValue() {
        return ordinal() + 1;
    }
}

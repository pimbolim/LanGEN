package net.time4j.calendar.hindu;

import androidx.webkit.ProxyConfig;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import net.time4j.calendar.IndianMonth;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.ChronoCondition;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextWidth;
import org.apache.commons.lang3.StringUtils;

public final class HinduMonth extends HinduPrimitive implements Comparable<HinduMonth>, ChronoCondition<HinduCalendar>, Serializable {
    public static final AttributeKey<Boolean> RASI_NAMES = Attributes.createKey("RASI_NAMES", Boolean.class);
    private final boolean leap;
    private final IndianMonth value;

    private HinduMonth(IndianMonth indianMonth, boolean z) {
        Objects.requireNonNull(indianMonth, "Missing Indian month.");
        this.value = indianMonth;
        this.leap = z;
    }

    public static HinduMonth of(IndianMonth indianMonth) {
        return new HinduMonth(indianMonth, false);
    }

    public static HinduMonth ofLunisolar(int i) {
        return new HinduMonth(IndianMonth.valueOf(i), false);
    }

    public static HinduMonth ofSolar(int i) {
        int i2 = 1;
        if (i != 12) {
            i2 = 1 + i;
        }
        return new HinduMonth(IndianMonth.valueOf(i2), false);
    }

    public IndianMonth getValue() {
        return this.value;
    }

    public int getRasi() {
        if (this.value == IndianMonth.CHAITRA) {
            return 12;
        }
        return this.value.getValue() - 1;
    }

    public String getRasi(Locale locale) {
        String print = CalendarText.getInstance("hindu", locale).getTextForms("R", IndianMonth.class, new String[0]).print(IndianMonth.valueOf(getRasi()));
        if (!this.leap) {
            return print;
        }
        return getAdhika(locale) + print;
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE, OutputContext.FORMAT);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth, OutputContext outputContext) {
        String print = CalendarText.getInstance("indian", locale).getStdMonths(textWidth, outputContext).print(this.value);
        if (!this.leap) {
            return print;
        }
        return getAdhika(locale) + print;
    }

    public boolean isLeap() {
        return this.leap;
    }

    public HinduMonth withLeap() {
        return this.leap ? this : new HinduMonth(this.value, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HinduMonth)) {
            return false;
        }
        HinduMonth hinduMonth = (HinduMonth) obj;
        if (this.value == hinduMonth.value && this.leap == hinduMonth.leap) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode() + (this.leap ? 12 : 0);
    }

    public String toString() {
        String indianMonth = this.value.toString();
        if (!this.leap) {
            return indianMonth;
        }
        return ProxyConfig.MATCH_ALL_SCHEMES + indianMonth;
    }

    public int compareTo(HinduMonth hinduMonth) {
        int compareTo = this.value.compareTo(hinduMonth.value);
        if (compareTo == 0) {
            return this.leap ? hinduMonth.leap ? 0 : -1 : hinduMonth.leap ? 1 : 0;
        }
        return compareTo;
    }

    public boolean test(HinduCalendar hinduCalendar) {
        return equals(hinduCalendar.getMonth());
    }

    private static String getAdhika(Locale locale) {
        return CalendarText.getInstance("hindu", locale).getTextForms().get("adhika") + StringUtils.SPACE;
    }
}

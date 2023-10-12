package net.time4j.calendar.hindu;

import androidx.webkit.ProxyConfig;
import java.io.Serializable;
import net.time4j.engine.ChronoCondition;

public final class HinduDay extends HinduPrimitive implements Comparable<HinduDay>, ChronoCondition<HinduCalendar>, Serializable {
    private final boolean leap;
    private final int value;

    private HinduDay(int i, boolean z) {
        if (i < 1 || i > 32) {
            throw new IllegalArgumentException("Day-of-month value out of range: " + i);
        }
        this.value = i;
        this.leap = z;
    }

    public static HinduDay valueOf(int i) {
        return new HinduDay(i, false);
    }

    public int getValue() {
        return this.value;
    }

    public boolean isLeap() {
        return this.leap;
    }

    public HinduDay withLeap() {
        return this.leap ? this : new HinduDay(this.value, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HinduDay)) {
            return false;
        }
        HinduDay hinduDay = (HinduDay) obj;
        if (this.value == hinduDay.value && this.leap == hinduDay.leap) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.value + (this.leap ? 12 : 0);
    }

    public String toString() {
        String valueOf = String.valueOf(this.value);
        if (!this.leap) {
            return valueOf;
        }
        return ProxyConfig.MATCH_ALL_SCHEMES + valueOf;
    }

    public int compareTo(HinduDay hinduDay) {
        int i = this.value - hinduDay.value;
        if (i == 0) {
            return this.leap ? hinduDay.leap ^ true ? 1 : 0 : hinduDay.leap ? -1 : 0;
        }
        return i;
    }

    public boolean test(HinduCalendar hinduCalendar) {
        return equals(hinduCalendar.getDayOfMonth());
    }
}

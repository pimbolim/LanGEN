package net.time4j.tz.model;

import java.util.Objects;
import net.time4j.ClockUnit;
import net.time4j.DayCycles;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.base.GregorianDate;
import net.time4j.format.CalendarType;

public abstract class DaylightSavingRule {
    private final transient long dayOverflow;
    private final transient OffsetIndicator indicator;
    private final transient int savings;
    private final transient PlainTime timeOfDay;

    public abstract PlainDate getDate(int i);

    /* access modifiers changed from: package-private */
    public int getType() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract int toCalendarYear(long j);

    /* access modifiers changed from: protected */
    public abstract int toCalendarYear(GregorianDate gregorianDate);

    protected DaylightSavingRule(int i, OffsetIndicator offsetIndicator, int i2) {
        Objects.requireNonNull(offsetIndicator, "Missing offset indicator.");
        if (i2 == Integer.MAX_VALUE || (i2 >= -64800 && i2 <= 64800)) {
            if (i == 86400) {
                this.dayOverflow = 0;
                this.timeOfDay = PlainTime.midnightAtEndOfDay();
            } else {
                DayCycles roll = PlainTime.midnightAtStartOfDay().roll((long) i, ClockUnit.SECONDS);
                this.dayOverflow = roll.getDayOverflow();
                this.timeOfDay = roll.getWallTime();
            }
            this.indicator = offsetIndicator;
            this.savings = i2 == Integer.MAX_VALUE ? 0 : i2;
            return;
        }
        throw new IllegalArgumentException("DST out of range: " + i2);
    }

    public final PlainTime getTimeOfDay() {
        return this.timeOfDay;
    }

    public final OffsetIndicator getIndicator() {
        return this.indicator;
    }

    public final int getSavings() {
        return this.savings;
    }

    /* access modifiers changed from: protected */
    public String getCalendarType() {
        CalendarType calendarType = (CalendarType) getClass().getAnnotation(CalendarType.class);
        if (calendarType != null) {
            return calendarType.value();
        }
        throw new IllegalStateException("Cannot find calendar type annotation: " + getClass());
    }

    /* access modifiers changed from: protected */
    public final long getDayOverflow() {
        return this.dayOverflow;
    }
}

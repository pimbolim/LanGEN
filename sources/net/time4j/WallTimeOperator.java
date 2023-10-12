package net.time4j;

import java.util.Objects;
import net.time4j.engine.ChronoOperator;

final class WallTimeOperator extends ElementOperator<PlainTimestamp> {
    private final int mode;
    private final PlainTime value;

    /* access modifiers changed from: package-private */
    public ChronoOperator<PlainTimestamp> onTimestamp() {
        return this;
    }

    WallTimeOperator(int i, PlainTime plainTime) {
        super(PlainTime.COMPONENT, i);
        Objects.requireNonNull(plainTime, "Missing target wall time.");
        this.mode = i;
        this.value = plainTime;
    }

    public PlainTimestamp apply(PlainTimestamp plainTimestamp) {
        PlainTime wallTime = plainTimestamp.getWallTime();
        if (this.value.isSimultaneous(wallTime)) {
            return handleSameTimes(plainTimestamp);
        }
        if (this.value.getHour() == 24) {
            return handleMidnight24(plainTimestamp);
        }
        if (this.value.isAfter(wallTime)) {
            return handleLater(plainTimestamp);
        }
        return handleEarlier(plainTimestamp);
    }

    private PlainTimestamp handleSameTimes(PlainTimestamp plainTimestamp) {
        switch (this.mode) {
            case 9:
                return (PlainTimestamp) plainTimestamp.plus(1, CalendarUnit.DAYS);
            case 10:
                return (PlainTimestamp) plainTimestamp.minus(1, CalendarUnit.DAYS);
            case 11:
            case 12:
                return plainTimestamp;
            default:
                throw new AssertionError("Unknown: " + this.mode);
        }
    }

    private PlainTimestamp handleMidnight24(PlainTimestamp plainTimestamp) {
        PlainDate calendarDate = plainTimestamp.getCalendarDate();
        switch (this.mode) {
            case 9:
            case 11:
                return ((PlainDate) calendarDate.plus(1, CalendarUnit.DAYS)).atStartOfDay();
            case 10:
            case 12:
                return calendarDate.atStartOfDay();
            default:
                throw new AssertionError("Unknown: " + this.mode);
        }
    }

    private PlainTimestamp handleLater(PlainTimestamp plainTimestamp) {
        switch (this.mode) {
            case 9:
            case 11:
                return plainTimestamp.with(this.value);
            case 10:
            case 12:
                return ((PlainTimestamp) plainTimestamp.minus(1, CalendarUnit.DAYS)).with(this.value);
            default:
                throw new AssertionError("Unknown: " + this.mode);
        }
    }

    private PlainTimestamp handleEarlier(PlainTimestamp plainTimestamp) {
        switch (this.mode) {
            case 9:
            case 11:
                return ((PlainTimestamp) plainTimestamp.plus(1, CalendarUnit.DAYS)).with(this.value);
            case 10:
            case 12:
                return plainTimestamp.with(this.value);
            default:
                throw new AssertionError("Unknown: " + this.mode);
        }
    }
}

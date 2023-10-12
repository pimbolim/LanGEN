package net.time4j;

import net.time4j.engine.ChronoOperator;

final class FullValueOperator extends ElementOperator<PlainTime> {
    static final FullValueOperator NEXT_FULL_HOUR = new FullValueOperator(15);
    static final FullValueOperator NEXT_FULL_MINUTE = new FullValueOperator(16);
    static final FullValueOperator ROUNDING_FULL_HOUR = new FullValueOperator(13);
    static final FullValueOperator ROUNDING_FULL_MINUTE = new FullValueOperator(14);
    private final ChronoOperator<PlainTimestamp> tsop = new ChronoOperator<PlainTimestamp>() {
        public PlainTimestamp apply(PlainTimestamp plainTimestamp) {
            PlainTime access$000 = FullValueOperator.this.doApply(plainTimestamp.getWallTime());
            if (access$000.getHour() == 24) {
                return PlainTimestamp.of((PlainDate) plainTimestamp.getCalendarDate().plus(1, CalendarUnit.DAYS), PlainTime.midnightAtStartOfDay());
            }
            return plainTimestamp.with(access$000);
        }
    };

    private FullValueOperator(int i) {
        super(PlainTime.COMPONENT, i);
    }

    public PlainTime apply(PlainTime plainTime) {
        return doApply(plainTime);
    }

    /* access modifiers changed from: package-private */
    public ChronoOperator<PlainTimestamp> onTimestamp() {
        return this.tsop;
    }

    /* access modifiers changed from: private */
    public PlainTime doApply(PlainTime plainTime) {
        int hour = plainTime.getHour();
        int minute = plainTime.getMinute();
        int i = 0;
        int i2 = 1;
        switch (getType()) {
            case 13:
                if (minute >= 30 && (hour = hour + 1) == 25) {
                    hour = 1;
                }
                return PlainTime.of(hour);
            case 14:
                if (plainTime.getSecond() >= 30) {
                    if (hour == 24) {
                        hour = 0;
                        minute = 1;
                    } else {
                        minute++;
                        if (minute == 60) {
                            hour++;
                            minute = 0;
                        }
                    }
                }
                return PlainTime.of(hour, minute);
            case 15:
                int i3 = hour + 1;
                if (i3 != 25) {
                    i2 = i3;
                }
                return PlainTime.of(i2);
            case 16:
                if (hour == 24) {
                    hour = 0;
                    i = 1;
                } else {
                    int i4 = minute + 1;
                    if (i4 == 60) {
                        hour++;
                    } else {
                        i = i4;
                    }
                }
                return PlainTime.of(hour, i);
            default:
                throw new AssertionError("Unknown: " + getType());
        }
    }
}

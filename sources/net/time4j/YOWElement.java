package net.time4j;

import java.io.ObjectStreamException;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.UnitRule;

final class YOWElement extends AbstractDateElement<Integer> {
    static final YOWElement INSTANCE = new YOWElement("YEAR_OF_WEEKDATE");
    private static final UnitRule U_RULE = new URule();
    private static final long serialVersionUID = -6907291758376370420L;
    private final transient ElementOperator<PlainDate> nextAdjuster = new YOWRollingAdjuster(1);
    private final transient ElementOperator<PlainDate> previousAdjuster = new YOWRollingAdjuster(-1);

    public char getSymbol() {
        return 'Y';
    }

    public boolean isDateElement() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isSingleton() {
        return true;
    }

    public boolean isTimeElement() {
        return false;
    }

    private YOWElement(String str) {
        super(str);
    }

    public Class<Integer> getType() {
        return Integer.class;
    }

    public Integer getDefaultMinimum() {
        return PlainDate.MIN_YEAR;
    }

    public Integer getDefaultMaximum() {
        return PlainDate.MAX_YEAR;
    }

    public ElementOperator<PlainDate> decremented() {
        return this.previousAdjuster;
    }

    public ElementOperator<PlainDate> incremented() {
        return this.nextAdjuster;
    }

    static <T extends ChronoEntity<T>> ElementRule<T, Integer> elementRule(Class<T> cls) {
        return new ERule();
    }

    static <T extends ChronoEntity<T>> UnitRule<T> unitRule() {
        return U_RULE;
    }

    /* access modifiers changed from: private */
    public static int getFirstCalendarWeekAsDayOfYear(PlainDate plainDate, int i) {
        return getFirstCalendarWeekAsDayOfYear(plainDate.getYear() + i);
    }

    /* access modifiers changed from: private */
    public static int getFirstCalendarWeekAsDayOfYear(int i) {
        int value = Weekday.valueOf(GregorianMath.getDayOfWeek(i, 1, 1)).getValue(Weekmodel.ISO);
        return value <= 8 - Weekmodel.ISO.getMinimalDaysInFirstWeek() ? 2 - value : 9 - value;
    }

    /* access modifiers changed from: private */
    public static int getLengthOfYear(PlainDate plainDate, int i) {
        return GregorianMath.isLeapYear(plainDate.getYear() + i) ? 366 : 365;
    }

    /* access modifiers changed from: private */
    public static int getWeekOfYear(PlainDate plainDate) {
        int dayOfYear = plainDate.getDayOfYear();
        int firstCalendarWeekAsDayOfYear = getFirstCalendarWeekAsDayOfYear(plainDate, 0);
        if (firstCalendarWeekAsDayOfYear <= dayOfYear) {
            int i = ((dayOfYear - firstCalendarWeekAsDayOfYear) / 7) + 1;
            if (i < 53 || getFirstCalendarWeekAsDayOfYear(plainDate, 1) + getLengthOfYear(plainDate, 0) > dayOfYear) {
                return i;
            }
            return 1;
        }
        return (((dayOfYear + getLengthOfYear(plainDate, -1)) - getFirstCalendarWeekAsDayOfYear(plainDate, -1)) / 7) + 1;
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    private static class YOWRollingAdjuster extends ElementOperator<PlainDate> {
        /* access modifiers changed from: private */
        public final long amount;
        private final ChronoOperator<PlainTimestamp> yowTS;

        private YOWRollingAdjuster(long j) {
            super(YOWElement.INSTANCE, 8);
            this.amount = j;
            this.yowTS = new ChronoOperator<PlainTimestamp>() {
                public PlainTimestamp apply(PlainTimestamp plainTimestamp) {
                    return (PlainTimestamp) YOWElement.unitRule().addTo(plainTimestamp, YOWRollingAdjuster.this.amount);
                }
            };
        }

        public PlainDate apply(PlainDate plainDate) {
            return (PlainDate) YOWElement.unitRule().addTo(plainDate, this.amount);
        }

        /* access modifiers changed from: package-private */
        public ChronoOperator<PlainTimestamp> onTimestamp() {
            return this.yowTS;
        }
    }

    private static class URule<T extends ChronoEntity<T>> implements UnitRule<T> {
        private URule() {
        }

        public T addTo(T t, long j) {
            if (j == 0) {
                return t;
            }
            int safeCast = MathUtils.safeCast(MathUtils.safeAdd((long) ((Integer) t.get(YOWElement.INSTANCE)).intValue(), j));
            PlainDate plainDate = (PlainDate) t.get(PlainDate.CALENDAR_DATE);
            int weekOfYear = plainDate.getWeekOfYear();
            Weekday dayOfWeek = plainDate.getDayOfWeek();
            if (weekOfYear == 53) {
                weekOfYear = ((Integer) PlainDate.of(safeCast, 26, dayOfWeek).getMaximum(Weekmodel.ISO.weekOfYear())).intValue();
            }
            return t.with(PlainDate.CALENDAR_DATE, PlainDate.of(safeCast, weekOfYear, dayOfWeek));
        }

        public long between(T t, T t2) {
            PlainDate plainDate = (PlainDate) t.get(PlainDate.CALENDAR_DATE);
            PlainDate plainDate2 = (PlainDate) t2.get(PlainDate.CALENDAR_DATE);
            long intValue = (long) (((Integer) plainDate2.get(YOWElement.INSTANCE)).intValue() - ((Integer) plainDate.get(YOWElement.INSTANCE)).intValue());
            int i = (intValue > 0 ? 1 : (intValue == 0 ? 0 : -1));
            if (i == 0) {
                return intValue;
            }
            int access$400 = YOWElement.getWeekOfYear(plainDate);
            int access$4002 = YOWElement.getWeekOfYear(plainDate2);
            if (i > 0 && access$400 > access$4002) {
                intValue--;
            } else if (i < 0 && access$400 < access$4002) {
                intValue++;
            }
            int i2 = (intValue > 0 ? 1 : (intValue == 0 ? 0 : -1));
            if (i2 == 0 || access$400 != access$4002) {
                return intValue;
            }
            int value = plainDate.getDayOfWeek().getValue();
            int value2 = plainDate2.getDayOfWeek().getValue();
            if (i2 > 0 && value > value2) {
                intValue--;
            } else if (i2 < 0 && value < value2) {
                intValue++;
            }
            int i3 = (intValue > 0 ? 1 : (intValue == 0 ? 0 : -1));
            if (i3 == 0 || value != value2 || !t.contains(PlainTime.WALL_TIME) || !t2.contains(PlainTime.WALL_TIME)) {
                return intValue;
            }
            PlainTime plainTime = (PlainTime) t.get(PlainTime.WALL_TIME);
            PlainTime plainTime2 = (PlainTime) t2.get(PlainTime.WALL_TIME);
            if (i3 <= 0 || !plainTime.isAfter(plainTime2)) {
                return (i3 >= 0 || !plainTime.isBefore(plainTime2)) ? intValue : intValue + 1;
            }
            return intValue - 1;
        }
    }

    private static class ERule<T extends ChronoEntity<T>> implements ElementRule<T, Integer> {
        private ERule() {
        }

        public Integer getValue(T t) {
            PlainDate plainDate = (PlainDate) t.get(PlainDate.CALENDAR_DATE);
            int year = plainDate.getYear();
            int dayOfYear = plainDate.getDayOfYear();
            int access$500 = YOWElement.getFirstCalendarWeekAsDayOfYear(plainDate, 0);
            if (access$500 > dayOfYear) {
                year--;
            } else if (((dayOfYear - access$500) / 7) + 1 >= 53 && YOWElement.getFirstCalendarWeekAsDayOfYear(plainDate, 1) + YOWElement.getLengthOfYear(plainDate, 0) <= dayOfYear) {
                year++;
            }
            return Integer.valueOf(year);
        }

        public Integer getMinimum(T t) {
            return YOWElement.INSTANCE.getDefaultMinimum();
        }

        public Integer getMaximum(T t) {
            return YOWElement.INSTANCE.getDefaultMaximum();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
            r3 = r3.intValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isValid(T r2, java.lang.Integer r3) {
            /*
                r1 = this;
                r2 = 0
                if (r3 != 0) goto L_0x0004
                return r2
            L_0x0004:
                int r3 = r3.intValue()
                r0 = -999999999(0xffffffffc4653601, float:-916.8438)
                if (r3 < r0) goto L_0x0013
                r0 = 999999999(0x3b9ac9ff, float:0.004723787)
                if (r3 > r0) goto L_0x0013
                r2 = 1
            L_0x0013:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.YOWElement.ERule.isValid(net.time4j.engine.ChronoEntity, java.lang.Integer):boolean");
        }

        public T withValue(T t, Integer num, boolean z) {
            if (num != null) {
                return t.with(PlainDate.CALENDAR_DATE, setYearOfWeekdate((PlainDate) t.get(PlainDate.CALENDAR_DATE), num.intValue()));
            }
            throw new IllegalArgumentException("Missing element value.");
        }

        public ChronoElement<?> getChildAtFloor(T t) {
            return getChild();
        }

        public ChronoElement<?> getChildAtCeiling(T t) {
            return getChild();
        }

        private ChronoElement<?> getChild() {
            return Weekmodel.ISO.weekOfYear();
        }

        private static PlainDate setYearOfWeekdate(PlainDate plainDate, int i) {
            int access$700 = YOWElement.getFirstCalendarWeekAsDayOfYear(i);
            int access$400 = YOWElement.getWeekOfYear(plainDate);
            long transform = EpochDays.UNIX.transform(GregorianMath.toMJD(i, 1, 1), EpochDays.MODIFIED_JULIAN_DATE) + ((long) (access$700 - 1)) + ((long) ((access$400 - 1) * 7)) + ((long) (plainDate.getDayOfWeek().getValue(Weekmodel.ISO) - 1));
            if (access$400 == 53) {
                if (((YOWElement.getFirstCalendarWeekAsDayOfYear(i + 1) + (GregorianMath.isLeapYear(i) ? 366 : 365)) - access$700) / 7 < 53) {
                    transform -= 7;
                }
            }
            return plainDate.withDaysSinceUTC(transform - 730);
        }
    }
}

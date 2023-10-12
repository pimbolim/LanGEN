package net.time4j.calendar;

import java.util.Objects;
import net.time4j.Weekday;
import net.time4j.base.MathUtils;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.IntElementRule;

final class WeekdayInMonthElement<T extends ChronoEntity<T> & CalendarDate> extends StdIntegerDateElement<T> implements OrdinalWeekdayElement<T> {
    private static final int LAST = Integer.MAX_VALUE;
    private static final long serialVersionUID = 4275169663905222176L;
    /* access modifiers changed from: private */
    public final transient ChronoElement<Integer> domElement;
    /* access modifiers changed from: private */
    public final transient ChronoElement<Weekday> dowElement;

    WeekdayInMonthElement(Class<T> cls, ChronoElement<Integer> chronoElement, ChronoElement<Weekday> chronoElement2) {
        super("WEEKDAY_IN_MONTH", cls, 1, chronoElement.getDefaultMaximum().intValue() / 7, 'F', new WeekOperator(true), new WeekOperator(false));
        this.domElement = chronoElement;
        this.dowElement = chronoElement2;
    }

    public ChronoOperator<T> setToFirst(Weekday weekday) {
        return setTo(1, weekday);
    }

    public ChronoOperator<T> setToLast(Weekday weekday) {
        return setTo(Integer.MAX_VALUE, weekday);
    }

    public ChronoOperator<T> setTo(int i, Weekday weekday) {
        return new SetOperator(this, i, weekday);
    }

    static <T extends ChronoEntity<T> & CalendarDate> ElementRule<T, Integer> getRule(WeekdayInMonthElement<T> weekdayInMonthElement) {
        return new Rule(weekdayInMonthElement);
    }

    private static class Rule<T extends ChronoEntity<T> & CalendarDate> implements IntElementRule<T> {
        private final WeekdayInMonthElement<T> wim;

        public ChronoElement<?> getChildAtCeiling(T t) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(T t) {
            return null;
        }

        Rule(WeekdayInMonthElement<T> weekdayInMonthElement) {
            this.wim = weekdayInMonthElement;
        }

        public Integer getValue(T t) {
            return Integer.valueOf(getInt(t));
        }

        public Integer getMinimum(T t) {
            return 1;
        }

        public Integer getMaximum(T t) {
            return Integer.valueOf(getMax(t));
        }

        public boolean isValid(T t, Integer num) {
            return num != null && isValid(t, num.intValue());
        }

        public T withValue(T t, Integer num, boolean z) {
            if (num != null) {
                return withValue(t, num.intValue(), z);
            }
            throw new IllegalArgumentException("Missing value.");
        }

        public boolean isValid(T t, int i) {
            return i >= 1 && i <= getMax(t);
        }

        public T withValue(T t, int i, boolean z) {
            if (isValid(t, i)) {
                return t.with(this.wim.setTo(i, (Weekday) t.get(this.wim.dowElement)));
            }
            throw new IllegalArgumentException("Invalid value: " + i);
        }

        public int getInt(T t) {
            return MathUtils.floorDivide(t.getInt(this.wim.domElement) - 1, 7) + 1;
        }

        private int getMax(T t) {
            int i = t.getInt(this.wim.domElement);
            while (true) {
                int i2 = i + 7;
                if (i2 > ((Integer) t.getMaximum(this.wim.domElement)).intValue()) {
                    return MathUtils.floorDivide(i - 1, 7) + 1;
                }
                i = i2;
            }
        }
    }

    private static class SetOperator<T extends ChronoEntity<T> & CalendarDate> implements ChronoOperator<T> {
        private final Weekday dayOfWeek;
        private final long ordinal;
        private final WeekdayInMonthElement<T> wim;

        SetOperator(WeekdayInMonthElement<T> weekdayInMonthElement, int i, Weekday weekday) {
            Objects.requireNonNull(weekday, "Missing value.");
            this.wim = weekdayInMonthElement;
            this.ordinal = (long) i;
            this.dayOfWeek = weekday;
        }

        public T apply(T t) {
            long j;
            Weekday weekday = (Weekday) t.get(this.wim.dowElement);
            int i = t.getInt(this.wim.domElement);
            if (this.ordinal == 2147483647L) {
                int intValue = ((Integer) t.getMaximum(this.wim.domElement)).intValue() - i;
                int value = weekday.getValue() + (intValue % 7);
                if (value > 7) {
                    value -= 7;
                }
                int value2 = this.dayOfWeek.getValue() - value;
                j = (long) (intValue + value2);
                if (value2 > 0) {
                    j -= 7;
                }
            } else {
                int value3 = this.dayOfWeek.getValue() - weekday.getValue();
                j = ((this.ordinal - ((long) (MathUtils.floorDivide((i + value3) - 1, 7) + 1))) * 7) + ((long) value3);
            }
            return t.with((ChronoElement<Long>) EpochDays.UTC, ((CalendarDate) t).getDaysSinceEpochUTC() + j);
        }
    }

    private static class WeekOperator<T extends ChronoEntity<T>> implements ChronoOperator<T> {
        private final boolean backwards;

        WeekOperator(boolean z) {
            this.backwards = z;
        }

        public T apply(T t) {
            long longValue = ((Long) t.get(EpochDays.UTC)).longValue();
            return t.with((ChronoElement<Long>) EpochDays.UTC, this.backwards ? longValue - 7 : longValue + 7);
        }
    }
}

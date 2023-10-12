package net.time4j;

import java.io.ObjectStreamException;
import java.util.Objects;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoOperator;

final class WeekdayInMonthElement extends AbstractDateElement<Integer> implements OrdinalWeekdayElement {
    static final WeekdayInMonthElement INSTANCE = new WeekdayInMonthElement();
    private static final int LAST = 5;
    private static final long serialVersionUID = -2378018589067147278L;

    public char getSymbol() {
        return 'F';
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

    private WeekdayInMonthElement() {
        super("WEEKDAY_IN_MONTH");
    }

    public Class<Integer> getType() {
        return Integer.class;
    }

    public Integer getDefaultMinimum() {
        return 1;
    }

    public Integer getDefaultMaximum() {
        return 5;
    }

    public ElementOperator<PlainDate> setToFirst(Weekday weekday) {
        return setTo(1, weekday);
    }

    public ElementOperator<PlainDate> setToSecond(Weekday weekday) {
        return setTo(2, weekday);
    }

    public ElementOperator<PlainDate> setToThird(Weekday weekday) {
        return setTo(3, weekday);
    }

    public ElementOperator<PlainDate> setToFourth(Weekday weekday) {
        return setTo(4, weekday);
    }

    public ElementOperator<PlainDate> setToLast(Weekday weekday) {
        return setTo(5, weekday);
    }

    private ElementOperator<PlainDate> setTo(int i, Weekday weekday) {
        return new SpecialOperator(i, weekday);
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    private static class SpecialOperator extends ElementOperator<PlainDate> {
        private final Weekday dayOfWeek;
        private final long ordinal;
        private final ChronoOperator<PlainTimestamp> specialTS = new ChronoOperator<PlainTimestamp>() {
            public PlainTimestamp apply(PlainTimestamp plainTimestamp) {
                return (PlainTimestamp) SpecialOperator.this.doApply(plainTimestamp);
            }
        };

        SpecialOperator(int i, Weekday weekday) {
            super(WeekdayInMonthElement.INSTANCE, 7);
            Objects.requireNonNull(weekday, "Missing value.");
            this.ordinal = (long) i;
            this.dayOfWeek = weekday;
        }

        public PlainDate apply(PlainDate plainDate) {
            return (PlainDate) doApply(plainDate);
        }

        /* access modifiers changed from: package-private */
        public ChronoOperator<PlainTimestamp> onTimestamp() {
            return this.specialTS;
        }

        /* access modifiers changed from: private */
        public <T extends ChronoEntity<T>> T doApply(T t) {
            long j;
            if (t.contains(PlainDate.CALENDAR_DATE)) {
                PlainDate plainDate = (PlainDate) t.get(PlainDate.CALENDAR_DATE);
                int value = this.dayOfWeek.getValue() - ((Weekday) plainDate.get(PlainDate.DAY_OF_WEEK)).getValue();
                int dayOfMonth = plainDate.getDayOfMonth() + value;
                long j2 = this.ordinal;
                if (j2 == 5) {
                    j = ((5 - ((long) (MathUtils.floorDivide(dayOfMonth - 1, 7) + 1))) * 7) + ((long) value);
                    if (((long) plainDate.getDayOfMonth()) + j > ((long) GregorianMath.getLengthOfMonth(plainDate.getYear(), plainDate.getMonth()))) {
                        j -= 7;
                    }
                } else {
                    j = ((j2 - ((long) (MathUtils.floorDivide(dayOfMonth - 1, 7) + 1))) * 7) + ((long) value);
                }
                return t.with(PlainDate.CALENDAR_DATE, (PlainDate) plainDate.plus(j, CalendarUnit.DAYS));
            }
            throw new ChronoException("Rule not found for ordinal day of week in month: " + t);
        }
    }
}

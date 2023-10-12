package net.time4j.engine;

import net.time4j.base.MathUtils;
import net.time4j.engine.Calendrical;

public abstract class Calendrical<U, D extends Calendrical<U, D>> extends TimePoint<U, D> implements CalendarDate {
    public <T extends Calendrical<?, T>> T transform(Class<T> cls) {
        String name = cls.getName();
        Chronology<T> lookup = Chronology.lookup(cls);
        if (lookup != null) {
            return (Calendrical) transform(lookup.getCalendarSystem(), name);
        }
        throw new IllegalArgumentException("Cannot find any chronology for given target type: " + name);
    }

    public <T extends CalendarVariant<T>> T transform(Class<T> cls, String str) {
        String name = cls.getName();
        Chronology<T> lookup = Chronology.lookup(cls);
        if (lookup != null) {
            return (CalendarVariant) transform(lookup.getCalendarSystem(str), name);
        }
        throw new IllegalArgumentException("Cannot find any chronology for given target type: " + name);
    }

    public <T extends CalendarVariant<T>> T transform(Class<T> cls, VariantSource variantSource) {
        return transform(cls, variantSource.getVariant());
    }

    public boolean isBefore(CalendarDate calendarDate) {
        return compareByTime(calendarDate) < 0;
    }

    public boolean isAfter(CalendarDate calendarDate) {
        return compareByTime(calendarDate) > 0;
    }

    public boolean isSimultaneous(CalendarDate calendarDate) {
        return this == calendarDate || compareByTime(calendarDate) == 0;
    }

    public int compareTo(D d) {
        if (getChronology().getChronoType() == d.getChronology().getChronoType()) {
            return compareByTime(d);
        }
        throw new ClassCastException("Cannot compare different types of dates, use instance of EpochDays as comparator instead.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Calendrical)) {
            return false;
        }
        Calendrical calendrical = (Calendrical) obj;
        if (getChronology().getChronoType() == calendrical.getChronology().getChronoType() && getDaysSinceEpochUTC() == calendrical.getDaysSinceEpochUTC()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long daysSinceEpochUTC = getDaysSinceEpochUTC();
        return (int) (daysSinceEpochUTC ^ (daysSinceEpochUTC >>> 32));
    }

    public D plus(CalendarDays calendarDays) {
        long safeAdd = MathUtils.safeAdd(getDaysSinceEpochUTC(), calendarDays.getAmount());
        try {
            return (Calendrical) getCalendarSystem().transform(safeAdd);
        } catch (IllegalArgumentException e) {
            ArithmeticException arithmeticException = new ArithmeticException("Out of range: " + safeAdd);
            arithmeticException.initCause(e);
            throw arithmeticException;
        }
    }

    public D minus(CalendarDays calendarDays) {
        return plus(CalendarDays.of(MathUtils.safeNegate(calendarDays.getAmount())));
    }

    public long getDaysSinceEpochUTC() {
        return getCalendarSystem().transform(getContext());
    }

    /* access modifiers changed from: protected */
    public int compareByTime(CalendarDate calendarDate) {
        int i = (getDaysSinceEpochUTC() > calendarDate.getDaysSinceEpochUTC() ? 1 : (getDaysSinceEpochUTC() == calendarDate.getDaysSinceEpochUTC() ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    private CalendarSystem<D> getCalendarSystem() {
        return getChronology().getCalendarSystem();
    }

    private <T> T transform(CalendarSystem<T> calendarSystem, String str) {
        long daysSinceEpochUTC = getDaysSinceEpochUTC();
        if (calendarSystem.getMinimumSinceUTC() <= daysSinceEpochUTC && calendarSystem.getMaximumSinceUTC() >= daysSinceEpochUTC) {
            return calendarSystem.transform(daysSinceEpochUTC);
        }
        throw new ArithmeticException("Cannot transform <" + daysSinceEpochUTC + "> to: " + str);
    }
}

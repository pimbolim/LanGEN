package net.time4j.engine;

import java.io.Serializable;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarVariant;

public abstract class CalendarVariant<D extends CalendarVariant<D>> extends ChronoEntity<D> implements CalendarDate, VariantSource, Comparable<D>, Serializable {
    public abstract boolean equals(Object obj);

    /* access modifiers changed from: protected */
    public abstract CalendarFamily<D> getChronology();

    public abstract int hashCode();

    public abstract String toString();

    public D withVariant(String str) {
        if (str.equals(getVariant())) {
            return (CalendarVariant) getContext();
        }
        return transform(getChronology().getChronoType(), str);
    }

    public D withVariant(VariantSource variantSource) {
        return withVariant(variantSource.getVariant());
    }

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

    public int compareTo(D d) {
        int i = (getDaysSinceEpochUTC() > d.getDaysSinceEpochUTC() ? 1 : (getDaysSinceEpochUTC() == d.getDaysSinceEpochUTC() ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            return 1;
        }
        return getVariant().compareTo(d.getVariant());
    }

    public boolean isAfter(CalendarDate calendarDate) {
        return getDaysSinceEpochUTC() > calendarDate.getDaysSinceEpochUTC();
    }

    public boolean isBefore(CalendarDate calendarDate) {
        return getDaysSinceEpochUTC() < calendarDate.getDaysSinceEpochUTC();
    }

    public boolean isSimultaneous(CalendarDate calendarDate) {
        return getDaysSinceEpochUTC() == calendarDate.getDaysSinceEpochUTC();
    }

    public D plus(CalendarDays calendarDays) {
        long safeAdd = MathUtils.safeAdd(getDaysSinceEpochUTC(), calendarDays.getAmount());
        try {
            return (CalendarVariant) getCalendarSystem().transform(safeAdd);
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
    public CalendarSystem<D> getCalendarSystem() {
        return getChronology().getCalendarSystem(getVariant());
    }

    /* access modifiers changed from: package-private */
    public <V> ElementRule<D, V> getRule(ChronoElement<V> chronoElement) {
        if (chronoElement instanceof EpochDays) {
            return EpochDays.class.cast(chronoElement).derive(getCalendarSystem());
        }
        return super.getRule(chronoElement);
    }

    private <T> T transform(CalendarSystem<T> calendarSystem, String str) {
        long daysSinceEpochUTC = getDaysSinceEpochUTC();
        if (calendarSystem.getMinimumSinceUTC() <= daysSinceEpochUTC && calendarSystem.getMaximumSinceUTC() >= daysSinceEpochUTC) {
            return calendarSystem.transform(daysSinceEpochUTC);
        }
        throw new ArithmeticException("Cannot transform <" + daysSinceEpochUTC + "> to: " + str);
    }
}

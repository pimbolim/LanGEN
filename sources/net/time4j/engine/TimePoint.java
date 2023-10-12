package net.time4j.engine;

import java.io.Serializable;
import net.time4j.base.MathUtils;
import net.time4j.engine.TimePoint;

public abstract class TimePoint<U, T extends TimePoint<U, T>> extends ChronoEntity<T> implements Comparable<T>, Serializable {
    public abstract int compareTo(T t);

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: protected */
    public abstract TimeAxis<U, T> getChronology();

    public abstract int hashCode();

    public abstract String toString();

    public T plus(TimeSpan<? extends U> timeSpan) {
        try {
            return timeSpan.addTo((TimePoint) getContext());
        } catch (IllegalArgumentException e) {
            ArithmeticException arithmeticException = new ArithmeticException("Result beyond boundaries of time axis.");
            arithmeticException.initCause(e);
            throw arithmeticException;
        }
    }

    public T minus(TimeSpan<? extends U> timeSpan) {
        try {
            return timeSpan.subtractFrom((TimePoint) getContext());
        } catch (IllegalArgumentException e) {
            ArithmeticException arithmeticException = new ArithmeticException("Result beyond boundaries of time axis.");
            arithmeticException.initCause(e);
            throw arithmeticException;
        }
    }

    public T plus(long j, U u) {
        if (j == 0) {
            return (TimePoint) getContext();
        }
        try {
            return (TimePoint) getRule(u).addTo(getContext(), j);
        } catch (IllegalArgumentException e) {
            ArithmeticException arithmeticException = new ArithmeticException("Result beyond boundaries of time axis.");
            arithmeticException.initCause(e);
            throw arithmeticException;
        }
    }

    public T minus(long j, U u) {
        return plus(MathUtils.safeNegate(j), u);
    }

    public <P> P until(T t, TimeMetric<? extends U, P> timeMetric) {
        return timeMetric.between((TimePoint) getContext(), t);
    }

    public long until(T t, U u) {
        return getRule(u).between(getContext(), t);
    }

    public static <U, T extends TimePoint<U, T>> T min(T t, T t2) {
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    public static <U, T extends TimePoint<U, T>> T max(T t, T t2) {
        return t.compareTo(t2) > 0 ? t : t2;
    }

    private UnitRule<T> getRule(U u) {
        return getChronology().getRule(u);
    }
}

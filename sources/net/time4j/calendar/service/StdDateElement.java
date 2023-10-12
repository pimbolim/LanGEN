package net.time4j.calendar.service;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.lang.Comparable;
import net.time4j.calendar.StdCalendarElement;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.Chronology;
import net.time4j.engine.EpochDays;
import net.time4j.engine.StdOperator;
import net.time4j.format.DisplayElement;

public abstract class StdDateElement<V extends Comparable<V>, T extends ChronoEntity<T>> extends DisplayElement<V> implements StdCalendarElement<V, T> {
    private final Class<T> chrono;
    private final transient boolean daywise;
    private final transient char symbol;

    public boolean isDateElement() {
        return true;
    }

    public boolean isTimeElement() {
        return false;
    }

    public StdDateElement(String str, Class<T> cls, char c, boolean z) {
        super(str);
        this.chrono = cls;
        this.symbol = c;
        this.daywise = z;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public ChronoOperator<T> minimized() {
        return StdOperator.minimized(this);
    }

    public ChronoOperator<T> maximized() {
        return StdOperator.maximized(this);
    }

    public ChronoOperator<T> decremented() {
        if (this.daywise) {
            return new DayOperator(true);
        }
        return StdOperator.decremented(this);
    }

    public ChronoOperator<T> incremented() {
        if (this.daywise) {
            return new DayOperator(false);
        }
        return StdOperator.incremented(this);
    }

    public ChronoOperator<T> atFloor() {
        return StdOperator.atFloor(this);
    }

    public ChronoOperator<T> atCeiling() {
        return StdOperator.atCeiling(this);
    }

    /* access modifiers changed from: protected */
    public boolean doEquals(BasicElement<?> basicElement) {
        return this.chrono == ((StdDateElement) basicElement).chrono;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        String name = name();
        for (ChronoElement next : Chronology.lookup(this.chrono).getRegisteredElements()) {
            if (next.name().equals(name)) {
                return next;
            }
        }
        throw new InvalidObjectException(name);
    }

    /* access modifiers changed from: protected */
    public Class<T> getChronoType() {
        return this.chrono;
    }

    private static class DayOperator<T extends ChronoEntity<T>> implements ChronoOperator<T> {
        private final boolean backwards;

        DayOperator(boolean z) {
            this.backwards = z;
        }

        public T apply(T t) {
            long longValue = ((Long) t.get(EpochDays.UTC)).longValue();
            return t.with((ChronoElement<Long>) EpochDays.UTC, this.backwards ? longValue - 1 : longValue + 1);
        }
    }
}

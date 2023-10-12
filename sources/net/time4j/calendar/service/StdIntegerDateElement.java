package net.time4j.calendar.service;

import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;

public class StdIntegerDateElement<T extends ChronoEntity<T>> extends StdDateElement<Integer, T> {
    private static final long serialVersionUID = -4975173343610190782L;
    private final transient ChronoOperator<T> decrementor;
    private final transient ChronoOperator<T> incrementor;
    private final transient int max;
    private final transient int min;

    public StdIntegerDateElement(String str, Class<T> cls, int i, int i2, char c) {
        super(str, cls, c, str.startsWith("DAY_OF_"));
        this.min = i;
        this.max = i2;
        this.decrementor = null;
        this.incrementor = null;
    }

    public StdIntegerDateElement(String str, Class<T> cls, int i, int i2, char c, ChronoOperator<T> chronoOperator, ChronoOperator<T> chronoOperator2) {
        super(str, cls, c, false);
        this.min = i;
        this.max = i2;
        this.decrementor = chronoOperator;
        this.incrementor = chronoOperator2;
    }

    public Class<Integer> getType() {
        return Integer.class;
    }

    public Integer getDefaultMinimum() {
        return Integer.valueOf(this.min);
    }

    public Integer getDefaultMaximum() {
        return Integer.valueOf(this.max);
    }

    public ChronoOperator<T> decremented() {
        ChronoOperator<T> chronoOperator = this.decrementor;
        if (chronoOperator != null) {
            return chronoOperator;
        }
        return super.decremented();
    }

    public ChronoOperator<T> incremented() {
        ChronoOperator<T> chronoOperator = this.incrementor;
        if (chronoOperator != null) {
            return chronoOperator;
        }
        return super.incremented();
    }
}

package net.time4j;

import net.time4j.engine.ChronoOperator;

final class ValueOperator<T> implements ChronoOperator<T> {
    private final ChronoOperator<T> delegate;
    private final Object value;

    private ValueOperator(ChronoOperator<T> chronoOperator, Object obj) {
        this.delegate = chronoOperator;
        this.value = obj;
    }

    static <T> ValueOperator of(ChronoOperator<T> chronoOperator, Object obj) {
        return new ValueOperator(chronoOperator, obj);
    }

    public T apply(T t) {
        return this.delegate.apply(t);
    }

    /* access modifiers changed from: package-private */
    public Object getValue() {
        return this.value;
    }
}

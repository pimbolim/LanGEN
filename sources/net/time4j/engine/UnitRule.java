package net.time4j.engine;

public interface UnitRule<T> {
    T addTo(T t, long j);

    long between(T t, T t2);
}

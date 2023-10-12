package net.time4j.engine;

public interface ChronoOperator<T> {
    T apply(T t);
}

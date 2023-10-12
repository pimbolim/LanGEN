package net.time4j.engine;

public interface ChronoFunction<T, R> {
    R apply(T t);
}

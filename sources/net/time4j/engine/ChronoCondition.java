package net.time4j.engine;

public interface ChronoCondition<T> {
    boolean test(T t);
}

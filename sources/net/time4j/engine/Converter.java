package net.time4j.engine;

public interface Converter<S, T> {
    S from(T t);

    Class<S> getSourceType();

    T translate(S s);
}

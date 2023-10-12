package net.time4j.engine;

public interface Normalizer<U> {
    TimeSpan<U> normalize(TimeSpan<? extends U> timeSpan);
}

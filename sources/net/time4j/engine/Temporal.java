package net.time4j.engine;

public interface Temporal<C> {
    boolean isAfter(C c);

    boolean isBefore(C c);

    boolean isSimultaneous(C c);
}

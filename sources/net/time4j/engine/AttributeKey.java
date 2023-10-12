package net.time4j.engine;

public interface AttributeKey<A> {
    String name();

    Class<A> type();
}

package net.time4j.engine;

public interface AttributeQuery {
    boolean contains(AttributeKey<?> attributeKey);

    <A> A get(AttributeKey<A> attributeKey);

    <A> A get(AttributeKey<A> attributeKey, A a);
}

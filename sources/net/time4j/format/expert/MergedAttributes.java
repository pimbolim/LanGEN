package net.time4j.format.expert;

import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;

final class MergedAttributes implements AttributeQuery {
    private final AttributeQuery inner;
    private final AttributeQuery outer;

    MergedAttributes(AttributeQuery attributeQuery, AttributeQuery attributeQuery2) {
        this.outer = attributeQuery;
        this.inner = attributeQuery2;
    }

    public boolean contains(AttributeKey<?> attributeKey) {
        return this.outer.contains(attributeKey) || this.inner.contains(attributeKey);
    }

    public <A> A get(AttributeKey<A> attributeKey) {
        if (this.outer.contains(attributeKey)) {
            return this.outer.get(attributeKey);
        }
        return this.inner.get(attributeKey);
    }

    public <A> A get(AttributeKey<A> attributeKey, A a) {
        if (this.outer.contains(attributeKey)) {
            return this.outer.get(attributeKey);
        }
        return this.inner.get(attributeKey, a);
    }
}

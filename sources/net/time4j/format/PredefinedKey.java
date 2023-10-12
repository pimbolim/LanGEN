package net.time4j.format;

import java.util.Objects;
import net.time4j.engine.AttributeKey;

final class PredefinedKey<A> implements AttributeKey<A> {
    private final String name;
    private final Class<A> type;

    private PredefinedKey(String str, Class<A> cls) {
        Objects.requireNonNull(str, "Missing name of attribute key.");
        Objects.requireNonNull(cls, "Missing type of attribute.");
        this.name = str;
        this.type = cls;
    }

    static <A> PredefinedKey<A> valueOf(String str, Class<A> cls) {
        return new PredefinedKey<>(str, cls);
    }

    public String name() {
        return this.name;
    }

    public Class<A> type() {
        return this.type;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PredefinedKey)) {
            return false;
        }
        PredefinedKey predefinedKey = (PredefinedKey) obj;
        if (!this.name.equals(predefinedKey.name) || !this.type.equals(predefinedKey.type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return this.type.getName() + "@" + this.name;
    }
}

package net.time4j.format;

public enum Leniency {
    STRICT,
    SMART,
    LAX;

    public boolean isStrict() {
        return this == STRICT;
    }

    public boolean isSmart() {
        return this == SMART;
    }

    public boolean isLax() {
        return this == LAX;
    }
}

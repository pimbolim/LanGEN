package net.time4j.engine;

public abstract class BasicUnit implements ChronoUnit {
    /* access modifiers changed from: protected */
    public <T extends ChronoEntity<T>> UnitRule<T> derive(Chronology<T> chronology) {
        return null;
    }

    protected BasicUnit() {
    }

    public boolean isCalendrical() {
        return Double.compare(getLength(), 86400.0d) >= 0;
    }

    /* access modifiers changed from: protected */
    public final <T extends ChronoEntity<T>> UnitRule<T> derive(T t) {
        return derive(t.getChronology());
    }
}

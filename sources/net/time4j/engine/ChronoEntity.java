package net.time4j.engine;

import java.util.Objects;
import java.util.Set;
import net.time4j.engine.ChronoEntity;
import net.time4j.tz.TZID;

public abstract class ChronoEntity<T extends ChronoEntity<T>> implements ChronoDisplay {
    /* access modifiers changed from: protected */
    public abstract Chronology<T> getChronology();

    public boolean hasTimezone() {
        return false;
    }

    public boolean contains(ChronoElement<?> chronoElement) {
        return getChronology().isSupported(chronoElement);
    }

    public <V> V get(ChronoElement<V> chronoElement) {
        return getRule(chronoElement).getValue(getContext());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [net.time4j.engine.ChronoElement<java.lang.Integer>, net.time4j.engine.ChronoElement] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getInt(net.time4j.engine.ChronoElement<java.lang.Integer> r2) {
        /*
            r1 = this;
            net.time4j.engine.Chronology r0 = r1.getChronology()
            net.time4j.engine.IntElementRule r0 = r0.getIntegerRule(r2)
            if (r0 != 0) goto L_0x0015
            java.lang.Object r2 = r1.get(r2)     // Catch:{ ChronoException -> 0x001e }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ ChronoException -> 0x001e }
            int r2 = r2.intValue()     // Catch:{ ChronoException -> 0x001e }
            return r2
        L_0x0015:
            net.time4j.engine.ChronoEntity r2 = r1.getContext()     // Catch:{ ChronoException -> 0x001e }
            int r2 = r0.getInt(r2)     // Catch:{ ChronoException -> 0x001e }
            return r2
        L_0x001e:
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.engine.ChronoEntity.getInt(net.time4j.engine.ChronoElement):int");
    }

    public <V> V getMinimum(ChronoElement<V> chronoElement) {
        return getRule(chronoElement).getMinimum(getContext());
    }

    public <V> V getMaximum(ChronoElement<V> chronoElement) {
        return getRule(chronoElement).getMaximum(getContext());
    }

    public final <R> R get(ChronoFunction<? super T, R> chronoFunction) {
        return chronoFunction.apply(getContext());
    }

    public boolean matches(ChronoCondition<? super T> chronoCondition) {
        return chronoCondition.test(getContext());
    }

    public <V> boolean isValid(ChronoElement<V> chronoElement, V v) {
        Objects.requireNonNull(chronoElement, "Missing chronological element.");
        return contains(chronoElement) && getRule(chronoElement).isValid(getContext(), v);
    }

    public boolean isValid(ChronoElement<Integer> chronoElement, int i) {
        IntElementRule<T> integerRule = getChronology().getIntegerRule(chronoElement);
        if (integerRule != null) {
            return integerRule.isValid(getContext(), i);
        }
        return isValid(chronoElement, Integer.valueOf(i));
    }

    public boolean isValid(ChronoElement<Long> chronoElement, long j) {
        return isValid(chronoElement, Long.valueOf(j));
    }

    public <V> T with(ChronoElement<V> chronoElement, V v) {
        return (ChronoEntity) getRule(chronoElement).withValue(getContext(), v, chronoElement.isLenient());
    }

    public T with(ChronoElement<Integer> chronoElement, int i) {
        IntElementRule<T> integerRule = getChronology().getIntegerRule(chronoElement);
        if (integerRule != null) {
            return (ChronoEntity) integerRule.withValue(getContext(), i, chronoElement.isLenient());
        }
        return with(chronoElement, Integer.valueOf(i));
    }

    public T with(ChronoElement<Long> chronoElement, long j) {
        return with(chronoElement, Long.valueOf(j));
    }

    public T with(ChronoOperator<T> chronoOperator) {
        return (ChronoEntity) chronoOperator.apply(getContext());
    }

    public TZID getTimezone() {
        throw new ChronoException("Timezone not available: " + this);
    }

    public Set<ChronoElement<?>> getRegisteredElements() {
        return getChronology().getRegisteredElements();
    }

    /* access modifiers changed from: protected */
    public T getContext() {
        Chronology chronology = getChronology();
        Class chronoType = chronology.getChronoType();
        if (chronoType.isInstance(this)) {
            return (ChronoEntity) chronoType.cast(this);
        }
        for (ChronoElement next : chronology.getRegisteredElements()) {
            if (chronoType == next.getType()) {
                return (ChronoEntity) chronoType.cast(get(next));
            }
        }
        throw new IllegalStateException("Implementation error: Cannot find entity context.");
    }

    /* access modifiers changed from: package-private */
    public <V> ElementRule<T, V> getRule(ChronoElement<V> chronoElement) {
        return getChronology().getRule(chronoElement);
    }
}

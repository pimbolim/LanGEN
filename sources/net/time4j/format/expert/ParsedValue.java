package net.time4j.format.expert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoException;

class ParsedValue extends ParsedEntity<ParsedValue> {
    private Map<ChronoElement<?>, Object> map = null;
    private Object result = null;

    ParsedValue() {
    }

    public boolean contains(ChronoElement<?> chronoElement) {
        Map<ChronoElement<?>, Object> map2;
        if (chronoElement == null || (map2 = this.map) == null) {
            return false;
        }
        return map2.containsKey(chronoElement);
    }

    public <V> V get(ChronoElement<V> chronoElement) {
        Objects.requireNonNull(chronoElement);
        Map map2 = this.map;
        if (map2 != null && map2.containsKey(chronoElement)) {
            return chronoElement.getType().cast(map2.get(chronoElement));
        }
        throw new ChronoException("No value found for: " + chronoElement.name());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [net.time4j.engine.ChronoElement<java.lang.Integer>, net.time4j.engine.ChronoElement, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getInt(net.time4j.engine.ChronoElement<java.lang.Integer> r3) {
        /*
            r2 = this;
            java.util.Objects.requireNonNull(r3)
            java.util.Map<net.time4j.engine.ChronoElement<?>, java.lang.Object> r0 = r2.map
            if (r0 == 0) goto L_0x0020
            boolean r1 = r0.containsKey(r3)
            if (r1 == 0) goto L_0x0020
            java.lang.Class r1 = r3.getType()
            java.lang.Object r3 = r0.get(r3)
            java.lang.Object r3 = r1.cast(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            return r3
        L_0x0020:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.ParsedValue.getInt(net.time4j.engine.ChronoElement):int");
    }

    public Set<ChronoElement<?>> getRegisteredElements() {
        Map<ChronoElement<?>, Object> map2 = this.map;
        if (map2 == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(map2.keySet());
    }

    /* access modifiers changed from: package-private */
    public void put(ChronoElement<?> chronoElement, int i) {
        Objects.requireNonNull(chronoElement);
        Map map2 = this.map;
        if (map2 == null) {
            map2 = new HashMap();
            this.map = map2;
        }
        map2.put(chronoElement, Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public void put(ChronoElement<?> chronoElement, Object obj) {
        Objects.requireNonNull(chronoElement);
        if (obj == null) {
            Map<ChronoElement<?>, Object> map2 = this.map;
            if (map2 != null) {
                map2.remove(chronoElement);
                if (this.map.isEmpty()) {
                    this.map = null;
                    return;
                }
                return;
            }
            return;
        }
        Map map3 = this.map;
        if (map3 == null) {
            map3 = new HashMap();
            this.map = map3;
        }
        map3.put(chronoElement, obj);
    }

    /* access modifiers changed from: package-private */
    public void setResult(Object obj) {
        this.result = obj;
    }

    /* access modifiers changed from: package-private */
    public <E> E getResult() {
        return this.result;
    }
}

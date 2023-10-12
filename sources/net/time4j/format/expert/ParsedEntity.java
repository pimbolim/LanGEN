package net.time4j.format.expert;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.Chronology;
import net.time4j.format.expert.ParsedEntity;
import net.time4j.tz.TZID;

abstract class ParsedEntity<T extends ParsedEntity<T>> extends ChronoEntity<T> {
    /* access modifiers changed from: package-private */
    public abstract <E> E getResult();

    /* access modifiers changed from: package-private */
    public abstract void put(ChronoElement<?> chronoElement, int i);

    /* access modifiers changed from: package-private */
    public abstract void put(ChronoElement<?> chronoElement, Object obj);

    /* access modifiers changed from: package-private */
    public abstract void setResult(Object obj);

    ParsedEntity() {
    }

    public <V> boolean isValid(ChronoElement<V> chronoElement, V v) {
        Objects.requireNonNull(chronoElement, "Missing chronological element.");
        return true;
    }

    public <V> T with(ChronoElement<V> chronoElement, V v) {
        put((ChronoElement<?>) chronoElement, (Object) v);
        return this;
    }

    public T with(ChronoElement<Integer> chronoElement, int i) {
        put((ChronoElement<?>) chronoElement, i);
        return this;
    }

    public <V> V getMinimum(ChronoElement<V> chronoElement) {
        return chronoElement.getDefaultMinimum();
    }

    public <V> V getMaximum(ChronoElement<V> chronoElement) {
        return chronoElement.getDefaultMaximum();
    }

    public final boolean hasTimezone() {
        return contains(TimezoneElement.TIMEZONE_ID) || contains(TimezoneElement.TIMEZONE_OFFSET);
    }

    public final TZID getTimezone() {
        Object obj;
        if (contains(TimezoneElement.TIMEZONE_ID)) {
            obj = get(TimezoneElement.TIMEZONE_ID);
        } else {
            obj = contains(TimezoneElement.TIMEZONE_OFFSET) ? get(TimezoneElement.TIMEZONE_OFFSET) : null;
        }
        if (obj instanceof TZID) {
            return TZID.class.cast(obj);
        }
        return super.getTimezone();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof net.time4j.format.expert.ParsedEntity
            r2 = 0
            if (r1 == 0) goto L_0x0057
            net.time4j.format.expert.ParsedEntity r7 = (net.time4j.format.expert.ParsedEntity) r7
            java.util.Set r1 = r6.getRegisteredElements()
            java.util.Set r3 = r7.getRegisteredElements()
            int r4 = r1.size()
            int r5 = r3.size()
            if (r4 == r5) goto L_0x001e
            return r2
        L_0x001e:
            java.util.Iterator r1 = r1.iterator()
        L_0x0022:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0043
            java.lang.Object r4 = r1.next()
            net.time4j.engine.ChronoElement r4 = (net.time4j.engine.ChronoElement) r4
            boolean r5 = r3.contains(r4)
            if (r5 == 0) goto L_0x0042
            java.lang.Object r5 = r6.get(r4)
            java.lang.Object r4 = r7.get(r4)
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x0022
        L_0x0042:
            return r2
        L_0x0043:
            java.lang.Object r1 = r6.getResult()
            java.lang.Object r7 = r7.getResult()
            if (r1 != 0) goto L_0x0052
            if (r7 != 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r0 = 0
        L_0x0051:
            return r0
        L_0x0052:
            boolean r7 = r1.equals(r7)
            return r7
        L_0x0057:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.ParsedEntity.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = getRegisteredElements().hashCode();
        Object result = getResult();
        return result != null ? hashCode + (result.hashCode() * 31) : hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (ChronoElement next : getRegisteredElements()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next.name());
            sb.append(SignatureVisitor.INSTANCEOF);
            sb.append(get(next));
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        Object result = getResult();
        if (result != null) {
            sb.append(">>>result=");
            sb.append(result);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final Chronology<T> getChronology() {
        throw new UnsupportedOperationException("Parsed values do not have any chronology.");
    }
}

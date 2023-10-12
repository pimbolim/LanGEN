package net.time4j;

import java.lang.Enum;
import java.util.Objects;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoOperator;

final class NavigationOperator<V extends Enum<V>> extends ElementOperator<PlainDate> {
    private final int len;
    private final ChronoOperator<PlainTimestamp> navTS = new ChronoOperator<PlainTimestamp>() {
        public PlainTimestamp apply(PlainTimestamp plainTimestamp) {
            return (PlainTimestamp) NavigationOperator.this.doApply(plainTimestamp);
        }
    };
    private final V value;

    NavigationOperator(ChronoElement<V> chronoElement, int i, V v) {
        super(chronoElement, i);
        Objects.requireNonNull(v, "Missing value.");
        this.value = v;
        this.len = ((Enum[]) chronoElement.getType().getEnumConstants()).length;
    }

    public PlainDate apply(PlainDate plainDate) {
        return (PlainDate) doApply(plainDate);
    }

    /* access modifiers changed from: package-private */
    public ChronoOperator<PlainTimestamp> onTimestamp() {
        return this.navTS;
    }

    /* access modifiers changed from: private */
    public <T extends ChronoEntity<T>> T doApply(T t) {
        String str;
        if (t.contains(PlainDate.CALENDAR_DATE)) {
            PlainDate plainDate = (PlainDate) t.get(PlainDate.CALENDAR_DATE);
            int ordinal = Enum.class.cast(plainDate.get(getElement())).ordinal();
            int delta = delta(ordinal);
            if (delta == ordinal) {
                return t;
            }
            return t.with(PlainDate.CALENDAR_DATE, plainDate.plus((long) (delta - ordinal), plainDate.getChronology().getBaseUnit(getElement())));
        }
        switch (getType()) {
            case 9:
                str = "setToNext";
                break;
            case 10:
                str = "setToPrevious";
                break;
            case 11:
                str = "setToNextOrSame";
                break;
            case 12:
                str = "setToPreviousOrSame";
                break;
            default:
                throw new AssertionError("Unknown: " + getType());
        }
        throw new ChronoException(str + "()-operation not supported on: " + getElement().name());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return r0 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return r0 - r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int delta(int r3) {
        /*
            r2 = this;
            V r0 = r2.value
            int r0 = r0.ordinal()
            int r1 = r2.getType()
            switch(r1) {
                case 9: goto L_0x0038;
                case 10: goto L_0x0032;
                case 11: goto L_0x002d;
                case 12: goto L_0x0028;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown: "
            r0.append(r1)
            int r1 = r2.getType()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            throw r3
        L_0x0028:
            if (r0 <= r3) goto L_0x003d
            int r3 = r2.len
            goto L_0x0036
        L_0x002d:
            if (r0 >= r3) goto L_0x003d
            int r3 = r2.len
            goto L_0x003c
        L_0x0032:
            if (r0 < r3) goto L_0x003d
            int r3 = r2.len
        L_0x0036:
            int r0 = r0 - r3
            goto L_0x003d
        L_0x0038:
            if (r0 > r3) goto L_0x003d
            int r3 = r2.len
        L_0x003c:
            int r0 = r0 + r3
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.NavigationOperator.delta(int):int");
    }
}

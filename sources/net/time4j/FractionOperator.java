package net.time4j;

import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;

final class FractionOperator<T extends ChronoEntity<T>> implements ChronoOperator<T> {
    private static final int KILO = 1000;
    private static final int MIO = 1000000;
    private final char fraction;
    private final boolean up;

    FractionOperator(char c, boolean z) {
        this.fraction = c;
        this.up = z;
    }

    public T apply(T t) {
        if (this.fraction == '9') {
            return t;
        }
        int intValue = ((Integer) t.get(PlainTime.NANO_OF_SECOND)).intValue();
        int intValue2 = ((Integer) t.getMaximum(PlainTime.NANO_OF_SECOND)).intValue();
        char c = this.fraction;
        int i = 0;
        if (c == '3') {
            int i2 = (intValue / 1000000) * 1000000;
            if (this.up) {
                i = 999999;
            }
            return t.with((ChronoElement<Integer>) PlainTime.NANO_OF_SECOND, Math.min(intValue2, i2 + i));
        } else if (c == '6') {
            int i3 = (intValue / 1000) * 1000;
            if (this.up) {
                i = 999;
            }
            return t.with((ChronoElement<Integer>) PlainTime.NANO_OF_SECOND, Math.min(intValue2, i3 + i));
        } else {
            throw new UnsupportedOperationException("Unknown: " + this.fraction);
        }
    }
}

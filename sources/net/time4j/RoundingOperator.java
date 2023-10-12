package net.time4j;

import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;

final class RoundingOperator<T extends ChronoEntity<T>> implements ChronoOperator<T> {
    private final ProportionalElement<?, T> element;
    private final boolean longBased;
    private final double stepwidth;
    private final Boolean up;

    RoundingOperator(ProportionalElement<?, T> proportionalElement, Boolean bool, int i) {
        this.element = proportionalElement;
        this.up = bool;
        this.stepwidth = (double) i;
        this.longBased = proportionalElement.getType().equals(Long.class);
    }

    public T apply(T t) {
        double d;
        Number number;
        double d2;
        double d3;
        double doubleValue = ((Number) t.get(this.element)).doubleValue();
        Boolean bool = this.up;
        if (bool == null) {
            double ceil = Math.ceil(doubleValue / this.stepwidth);
            double d4 = this.stepwidth;
            d = ceil * d4;
            double floor = Math.floor(doubleValue / d4) * this.stepwidth;
            if (doubleValue - floor < d - doubleValue) {
                d = floor;
            }
        } else {
            if (bool.booleanValue()) {
                d3 = Math.ceil(doubleValue / this.stepwidth);
                d2 = this.stepwidth;
            } else {
                d3 = Math.floor(doubleValue / this.stepwidth);
                d2 = this.stepwidth;
            }
            d = d2 * d3;
        }
        if (this.longBased) {
            number = Long.valueOf((long) d);
        } else {
            number = Integer.valueOf((int) d);
        }
        return t.with(lenient(this.element, number));
    }

    private static <V extends Number, T extends ChronoEntity<T>> ChronoOperator<T> lenient(ProportionalElement<V, T> proportionalElement, Number number) {
        return proportionalElement.setLenient((Number) proportionalElement.getType().cast(number));
    }
}

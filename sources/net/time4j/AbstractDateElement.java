package net.time4j;

import java.lang.Comparable;
import net.time4j.engine.ChronoFunction;
import net.time4j.format.DisplayElement;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

abstract class AbstractDateElement<V extends Comparable<V>> extends DisplayElement<V> implements AdjustableElement<V, PlainDate> {
    private final transient ElementOperator<PlainDate> maximizer = new DateOperator(this, 1);
    private final transient ElementOperator<PlainDate> minimizer = new DateOperator(this, 0);

    AbstractDateElement(String str) {
        super(str);
    }

    public ElementOperator<PlainDate> newValue(V v) {
        return new DateOperator(this, -1, v);
    }

    public ElementOperator<PlainDate> minimized() {
        return this.minimizer;
    }

    public ElementOperator<PlainDate> maximized() {
        return this.maximizer;
    }

    public ElementOperator<PlainDate> decremented() {
        return new DateOperator(this, 2);
    }

    public ElementOperator<PlainDate> incremented() {
        return new DateOperator(this, 3);
    }

    public ElementOperator<PlainDate> atFloor() {
        return new DateOperator(this, 4);
    }

    public ElementOperator<PlainDate> atCeiling() {
        return new DateOperator(this, 5);
    }

    public ElementOperator<PlainDate> setLenient(V v) {
        return new DateOperator(this, 6, v);
    }

    public ChronoFunction<Moment, V> inStdTimezone() {
        return in(Timezone.ofSystem());
    }

    public ChronoFunction<Moment, V> inTimezone(TZID tzid) {
        return in(Timezone.of(tzid));
    }

    public ChronoFunction<Moment, V> in(Timezone timezone) {
        return new ZonalQuery(this, timezone);
    }

    public ChronoFunction<Moment, V> atUTC() {
        return at(ZonalOffset.UTC);
    }

    public ChronoFunction<Moment, V> at(ZonalOffset zonalOffset) {
        return new ZonalQuery(this, zonalOffset);
    }
}

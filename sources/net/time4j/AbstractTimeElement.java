package net.time4j;

import java.lang.Comparable;
import net.time4j.engine.ChronoFunction;
import net.time4j.format.DisplayElement;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

abstract class AbstractTimeElement<V extends Comparable<V>> extends DisplayElement<V> implements AdjustableElement<V, PlainTime> {
    private final transient ElementOperator<PlainTime> maximizer = new TimeOperator(this, 1);
    private final transient ElementOperator<PlainTime> minimizer = new TimeOperator(this, 0);

    AbstractTimeElement(String str) {
        super(str);
    }

    public ElementOperator<PlainTime> newValue(V v) {
        return new TimeOperator(this, -1, v);
    }

    public ElementOperator<PlainTime> minimized() {
        return this.minimizer;
    }

    public ElementOperator<PlainTime> maximized() {
        return this.maximizer;
    }

    public ElementOperator<PlainTime> decremented() {
        return new TimeOperator(this, 2);
    }

    public ElementOperator<PlainTime> incremented() {
        return new TimeOperator(this, 3);
    }

    public ElementOperator<PlainTime> atFloor() {
        return new TimeOperator(this, 4);
    }

    public ElementOperator<PlainTime> atCeiling() {
        return new TimeOperator(this, 5);
    }

    public ElementOperator<PlainTime> setLenient(V v) {
        return new TimeOperator(this, 6, v);
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

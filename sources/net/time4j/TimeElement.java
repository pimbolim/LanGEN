package net.time4j;

import java.io.ObjectStreamException;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoFunction;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

final class TimeElement extends BasicElement<PlainTime> implements WallTimeElement {
    static final TimeElement INSTANCE = new TimeElement();
    private static final long serialVersionUID = -3712256393866098916L;

    public boolean isDateElement() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isSingleton() {
        return true;
    }

    public boolean isTimeElement() {
        return true;
    }

    private TimeElement() {
        super("WALL_TIME");
    }

    public Class<PlainTime> getType() {
        return PlainTime.class;
    }

    public PlainTime getDefaultMinimum() {
        return PlainTime.MIN;
    }

    public PlainTime getDefaultMaximum() {
        return PlainTime.of(23, 59, 59, 999999999);
    }

    public ElementOperator<?> setToNext(PlainTime plainTime) {
        return new WallTimeOperator(9, plainTime);
    }

    public ElementOperator<?> setToPrevious(PlainTime plainTime) {
        return new WallTimeOperator(10, plainTime);
    }

    public ElementOperator<?> setToNextOrSame(PlainTime plainTime) {
        return new WallTimeOperator(11, plainTime);
    }

    public ElementOperator<?> setToPreviousOrSame(PlainTime plainTime) {
        return new WallTimeOperator(12, plainTime);
    }

    public ElementOperator<PlainTime> roundedToFullHour() {
        return FullValueOperator.ROUNDING_FULL_HOUR;
    }

    public ElementOperator<PlainTime> roundedToFullMinute() {
        return FullValueOperator.ROUNDING_FULL_MINUTE;
    }

    public ElementOperator<PlainTime> setToNextFullHour() {
        return FullValueOperator.NEXT_FULL_HOUR;
    }

    public ElementOperator<PlainTime> setToNextFullMinute() {
        return FullValueOperator.NEXT_FULL_MINUTE;
    }

    public ChronoFunction<Moment, PlainTime> inStdTimezone() {
        return in(Timezone.ofSystem());
    }

    public ChronoFunction<Moment, PlainTime> inTimezone(TZID tzid) {
        return in(Timezone.of(tzid));
    }

    public ChronoFunction<Moment, PlainTime> in(Timezone timezone) {
        return new ZonalQuery(this, timezone);
    }

    public ChronoFunction<Moment, PlainTime> atUTC() {
        return at(ZonalOffset.UTC);
    }

    public ChronoFunction<Moment, PlainTime> at(ZonalOffset zonalOffset) {
        return new ZonalQuery(this, zonalOffset);
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}

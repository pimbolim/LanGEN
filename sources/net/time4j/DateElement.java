package net.time4j;

import java.io.ObjectStreamException;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoFunction;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

final class DateElement extends BasicElement<PlainDate> implements CalendarDateElement {
    static final DateElement INSTANCE = new DateElement();
    private static final long serialVersionUID = -6519899440006935829L;

    public boolean isDateElement() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isSingleton() {
        return true;
    }

    public boolean isTimeElement() {
        return false;
    }

    private DateElement() {
        super("CALENDAR_DATE");
    }

    public Class<PlainDate> getType() {
        return PlainDate.class;
    }

    public PlainDate getDefaultMinimum() {
        return PlainDate.MIN;
    }

    public PlainDate getDefaultMaximum() {
        return PlainDate.MAX;
    }

    public ElementOperator<PlainDate> firstDayOfNextMonth() {
        return CalendarOperator.FIRST_DAY_OF_NEXT_MONTH;
    }

    public ElementOperator<PlainDate> firstDayOfNextQuarter() {
        return CalendarOperator.FIRST_DAY_OF_NEXT_QUARTER;
    }

    public ElementOperator<PlainDate> firstDayOfNextYear() {
        return CalendarOperator.FIRST_DAY_OF_NEXT_YEAR;
    }

    public ElementOperator<PlainDate> lastDayOfPreviousMonth() {
        return CalendarOperator.LAST_DAY_OF_PREVIOUS_MONTH;
    }

    public ElementOperator<PlainDate> lastDayOfPreviousQuarter() {
        return CalendarOperator.LAST_DAY_OF_PREVIOUS_QUARTER;
    }

    public ElementOperator<PlainDate> lastDayOfPreviousYear() {
        return CalendarOperator.LAST_DAY_OF_PREVIOUS_YEAR;
    }

    public ChronoFunction<Moment, PlainDate> inStdTimezone() {
        return in(Timezone.ofSystem());
    }

    public ChronoFunction<Moment, PlainDate> inTimezone(TZID tzid) {
        return in(Timezone.of(tzid));
    }

    public ChronoFunction<Moment, PlainDate> in(Timezone timezone) {
        return new ZonalQuery(this, timezone);
    }

    public ChronoFunction<Moment, PlainDate> atUTC() {
        return at(ZonalOffset.UTC);
    }

    public ChronoFunction<Moment, PlainDate> at(ZonalOffset zonalOffset) {
        return new ZonalQuery(this, zonalOffset);
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}

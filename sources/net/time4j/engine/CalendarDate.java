package net.time4j.engine;

public interface CalendarDate extends Temporal<CalendarDate> {
    long getDaysSinceEpochUTC();
}

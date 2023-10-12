package net.time4j.calendar;

import net.time4j.Weekday;
import net.time4j.engine.ChronoOperator;

public interface OrdinalWeekdayElement<T> extends StdCalendarElement<Integer, T> {
    ChronoOperator<T> setTo(int i, Weekday weekday);

    ChronoOperator<T> setToFirst(Weekday weekday);

    ChronoOperator<T> setToLast(Weekday weekday);
}

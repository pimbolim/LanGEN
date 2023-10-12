package net.time4j;

public interface CalendarDateElement extends ZonalElement<PlainDate> {
    ElementOperator<PlainDate> firstDayOfNextMonth();

    ElementOperator<PlainDate> firstDayOfNextQuarter();

    ElementOperator<PlainDate> firstDayOfNextYear();

    ElementOperator<PlainDate> lastDayOfPreviousMonth();

    ElementOperator<PlainDate> lastDayOfPreviousQuarter();

    ElementOperator<PlainDate> lastDayOfPreviousYear();
}

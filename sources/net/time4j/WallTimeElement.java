package net.time4j;

public interface WallTimeElement extends ZonalElement<PlainTime> {
    ElementOperator<PlainTime> roundedToFullHour();

    ElementOperator<PlainTime> roundedToFullMinute();

    ElementOperator<?> setToNext(PlainTime plainTime);

    ElementOperator<PlainTime> setToNextFullHour();

    ElementOperator<PlainTime> setToNextFullMinute();

    ElementOperator<?> setToNextOrSame(PlainTime plainTime);

    ElementOperator<?> setToPrevious(PlainTime plainTime);

    ElementOperator<?> setToPreviousOrSame(PlainTime plainTime);
}

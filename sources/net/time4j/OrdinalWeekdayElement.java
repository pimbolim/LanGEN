package net.time4j;

public interface OrdinalWeekdayElement extends AdjustableElement<Integer, PlainDate> {
    ElementOperator<PlainDate> setToFirst(Weekday weekday);

    ElementOperator<PlainDate> setToFourth(Weekday weekday);

    ElementOperator<PlainDate> setToLast(Weekday weekday);

    ElementOperator<PlainDate> setToSecond(Weekday weekday);

    ElementOperator<PlainDate> setToThird(Weekday weekday);
}

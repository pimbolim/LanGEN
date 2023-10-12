package net.time4j;

import java.lang.Enum;

public interface NavigableElement<V extends Enum<V>> extends AdjustableElement<V, PlainDate> {
    ElementOperator<PlainDate> setToNext(V v);

    ElementOperator<PlainDate> setToNextOrSame(V v);

    ElementOperator<PlainDate> setToPrevious(V v);

    ElementOperator<PlainDate> setToPreviousOrSame(V v);
}

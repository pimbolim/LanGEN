package net.time4j;

public interface AdjustableElement<V, T> extends ZonalElement<V> {
    ElementOperator<T> atCeiling();

    ElementOperator<T> atFloor();

    ElementOperator<T> decremented();

    ElementOperator<T> incremented();

    ElementOperator<T> maximized();

    ElementOperator<T> minimized();

    ElementOperator<T> newValue(V v);
}

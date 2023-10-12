package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

public abstract class Prop<T> {
    private T value;

    /* access modifiers changed from: package-private */
    public abstract T toValue(Dynamic dynamic);

    public Prop() {
    }

    public Prop(T t) {
        this.value = t;
    }

    public void setValue(Dynamic dynamic) {
        this.value = toValue(dynamic);
    }

    public void setValue(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }
}

package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

public class MaximumDateProp extends Prop<String> {
    public static final String name = "maximumDate";

    public String toValue(Dynamic dynamic) {
        return dynamic.asString();
    }
}

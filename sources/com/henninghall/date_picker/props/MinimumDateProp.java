package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

public class MinimumDateProp extends Prop<String> {
    public static final String name = "minimumDate";

    public String toValue(Dynamic dynamic) {
        return dynamic.asString();
    }
}

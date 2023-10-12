package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

public class DateProp extends Prop<String> {
    public static final String name = "date";

    public String toValue(Dynamic dynamic) {
        return dynamic.asString();
    }
}

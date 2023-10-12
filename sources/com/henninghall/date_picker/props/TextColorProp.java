package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

public class TextColorProp extends Prop<String> {
    public static final String name = "textColor";

    public String toValue(Dynamic dynamic) {
        return dynamic.asString();
    }
}

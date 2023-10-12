package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

public class FadeToColorProp extends Prop<String> {
    public static final String name = "fadeToColor";

    public String toValue(Dynamic dynamic) {
        return dynamic.asString();
    }
}

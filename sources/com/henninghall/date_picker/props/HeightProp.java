package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

public class HeightProp extends Prop<Integer> {
    public static final String name = "height";

    public Integer toValue(Dynamic dynamic) {
        return Integer.valueOf(dynamic.asInt());
    }
}

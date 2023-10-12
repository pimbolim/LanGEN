package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

public class DividerHeightProp extends Prop<Integer> {
    public static final String name = "dividerHeight";

    public Integer toValue(Dynamic dynamic) {
        return Integer.valueOf(dynamic.asInt());
    }
}

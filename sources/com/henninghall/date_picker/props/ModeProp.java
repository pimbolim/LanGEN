package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;
import com.henninghall.date_picker.models.Mode;

public class ModeProp extends Prop<Mode> {
    public static final String name = "mode";

    public Mode toValue(Dynamic dynamic) {
        return Mode.valueOf(dynamic.asString());
    }
}

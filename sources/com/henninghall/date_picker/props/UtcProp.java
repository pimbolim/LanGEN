package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

public class UtcProp extends Prop<Boolean> {
    public static final String name = "utc";

    /* access modifiers changed from: package-private */
    public Boolean toValue(Dynamic dynamic) {
        return Boolean.valueOf(dynamic.asBoolean());
    }
}

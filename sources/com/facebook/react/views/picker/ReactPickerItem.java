package com.facebook.react.views.picker;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

class ReactPickerItem {
    public final Integer color;
    public final String label;

    public ReactPickerItem(ReadableMap readableMap) {
        this.label = readableMap.getString(AnnotatedPrivateKey.LABEL);
        if (!readableMap.hasKey("color") || readableMap.isNull("color")) {
            this.color = null;
        } else {
            this.color = Integer.valueOf(readableMap.getInt("color"));
        }
    }

    public static List<ReactPickerItem> createFromJsArrayMap(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(new ReactPickerItem(readableArray.getMap(i)));
        }
        return arrayList;
    }
}

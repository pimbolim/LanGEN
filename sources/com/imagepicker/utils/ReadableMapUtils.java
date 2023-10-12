package com.imagepicker.utils;

import android.text.TextUtils;
import com.facebook.react.bridge.ReadableMap;

public class ReadableMapUtils {
    public static boolean hasAndNotEmpty(Class cls, ReadableMap readableMap, String str) {
        if (!readableMap.hasKey(str) || readableMap.isNull(str)) {
            return false;
        }
        if (String.class.equals(cls)) {
            return !TextUtils.isEmpty(readableMap.getString(str));
        }
        return true;
    }

    public static boolean hasAndNotNullReadableMap(ReadableMap readableMap, String str) {
        return hasAndNotEmpty(ReadableMap.class, readableMap, str);
    }

    public static boolean hasAndNotEmptyString(ReadableMap readableMap, String str) {
        return hasAndNotEmpty(String.class, readableMap, str);
    }
}

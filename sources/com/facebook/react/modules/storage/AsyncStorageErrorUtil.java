package com.facebook.react.modules.storage;

import com.braintreepayments.api.internal.GraphQLConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

public class AsyncStorageErrorUtil {
    static WritableMap getError(String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(GraphQLConstants.Keys.MESSAGE, str2);
        if (str != null) {
            createMap.putString("key", str);
        }
        return createMap;
    }

    static WritableMap getInvalidKeyError(String str) {
        return getError(str, "Invalid key");
    }

    static WritableMap getInvalidValueError(String str) {
        return getError(str, "Invalid Value");
    }

    static WritableMap getDBError(String str) {
        return getError(str, "Database Error");
    }
}

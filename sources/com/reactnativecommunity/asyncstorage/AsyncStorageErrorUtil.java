package com.reactnativecommunity.asyncstorage;

import com.braintreepayments.api.internal.GraphQLConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import javax.annotation.Nullable;

public class AsyncStorageErrorUtil {
    static WritableMap getError(@Nullable String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(GraphQLConstants.Keys.MESSAGE, str2);
        if (str != null) {
            createMap.putString("key", str);
        }
        return createMap;
    }

    static WritableMap getInvalidKeyError(@Nullable String str) {
        return getError(str, "Invalid key");
    }

    static WritableMap getInvalidValueError(@Nullable String str) {
        return getError(str, "Invalid Value");
    }

    static WritableMap getDBError(@Nullable String str) {
        return getError(str, "Database Error");
    }
}

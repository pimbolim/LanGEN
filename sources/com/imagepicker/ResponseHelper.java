package com.imagepicker;

import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;

public class ResponseHelper {
    private WritableMap response = Arguments.createMap();

    public void cleanResponse() {
        this.response = Arguments.createMap();
    }

    public WritableMap getResponse() {
        return this.response;
    }

    public void putString(String str, String str2) {
        this.response.putString(str, str2);
    }

    public void putInt(String str, int i) {
        this.response.putInt(str, i);
    }

    public void putBoolean(String str, boolean z) {
        this.response.putBoolean(str, z);
    }

    public void putDouble(String str, double d) {
        this.response.putDouble(str, d);
    }

    public void invokeCustomButton(Callback callback, String str) {
        cleanResponse();
        this.response.putString("customButton", str);
        invokeResponse(callback);
    }

    public void invokeCancel(Callback callback) {
        cleanResponse();
        this.response.putBoolean("didCancel", true);
        invokeResponse(callback);
    }

    public void invokeError(Callback callback, String str) {
        cleanResponse();
        this.response.putString(ReactVideoView.EVENT_PROP_ERROR, str);
        invokeResponse(callback);
    }

    public void invokeResponse(Callback callback) {
        if (callback != null) {
            callback.invoke(this.response);
        }
    }
}

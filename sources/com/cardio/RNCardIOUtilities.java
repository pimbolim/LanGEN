package com.cardio;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import io.card.payment.CardIOActivity;

public class RNCardIOUtilities extends ReactContextBaseJavaModule {
    public String getName() {
        return "RCTCardIOUtilities";
    }

    public RNCardIOUtilities(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void canReadCardWithCamera(Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(CardIOActivity.canReadCardWithCamera()));
        } catch (Exception e) {
            promise.reject((Throwable) e);
        }
    }
}

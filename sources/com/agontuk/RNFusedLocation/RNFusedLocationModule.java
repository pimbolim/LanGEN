package com.agontuk.RNFusedLocation;

import android.content.Intent;
import android.location.Location;
import android.util.Log;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.HashMap;

public class RNFusedLocationModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final String TAG = "RNFusedLocation";
    private LocationProvider continuousLocationProvider;
    private int singleLocationProviderKeyCounter = 1;
    /* access modifiers changed from: private */
    public final HashMap<String, LocationProvider> singleLocationProviders;

    @ReactMethod
    public void addListener(String str) {
    }

    public String getName() {
        return TAG;
    }

    public void onNewIntent(Intent intent) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNFusedLocationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        this.singleLocationProviders = new HashMap<>();
        Log.i(TAG, "RNFusedLocation initialized");
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[LOOP:0: B:6:0x0015->B:9:0x0025, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(android.app.Activity r1, int r2, int r3, android.content.Intent r4) {
        /*
            r0 = this;
            com.agontuk.RNFusedLocation.LocationProvider r1 = r0.continuousLocationProvider
            if (r1 == 0) goto L_0x000b
            boolean r1 = r1.onActivityResult(r2, r3)
            if (r1 == 0) goto L_0x000b
            return
        L_0x000b:
            java.util.HashMap<java.lang.String, com.agontuk.RNFusedLocation.LocationProvider> r1 = r0.singleLocationProviders
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x0015:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0027
            java.lang.Object r4 = r1.next()
            com.agontuk.RNFusedLocation.LocationProvider r4 = (com.agontuk.RNFusedLocation.LocationProvider) r4
            boolean r4 = r4.onActivityResult(r2, r3)
            if (r4 == 0) goto L_0x0015
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.agontuk.RNFusedLocation.RNFusedLocationModule.onActivityResult(android.app.Activity, int, int, android.content.Intent):void");
    }

    @ReactMethod
    public void getCurrentPosition(ReadableMap readableMap, final Callback callback, final Callback callback2) {
        if (!LocationUtils.hasLocationPermission(getContext())) {
            callback2.invoke(LocationUtils.buildError(LocationError.PERMISSION_DENIED, (String) null));
            return;
        }
        LocationOptions fromReadableMap = LocationOptions.fromReadableMap(readableMap);
        LocationProvider createLocationProvider = createLocationProvider(fromReadableMap.isForceLocationManager());
        final String str = "provider-" + this.singleLocationProviderKeyCounter;
        this.singleLocationProviders.put(str, createLocationProvider);
        this.singleLocationProviderKeyCounter++;
        createLocationProvider.getCurrentLocation(fromReadableMap, new LocationChangeListener() {
            public void onLocationChange(Location location) {
                callback.invoke(LocationUtils.locationToMap(location));
                RNFusedLocationModule.this.singleLocationProviders.remove(str);
            }

            public void onLocationError(LocationError locationError, String str) {
                callback2.invoke(LocationUtils.buildError(locationError, str));
                RNFusedLocationModule.this.singleLocationProviders.remove(str);
            }
        });
    }

    @ReactMethod
    public void startObserving(ReadableMap readableMap) {
        if (!LocationUtils.hasLocationPermission(getContext())) {
            emitEvent("geolocationError", LocationUtils.buildError(LocationError.PERMISSION_DENIED, (String) null));
            return;
        }
        LocationOptions fromReadableMap = LocationOptions.fromReadableMap(readableMap);
        if (this.continuousLocationProvider == null) {
            this.continuousLocationProvider = createLocationProvider(fromReadableMap.isForceLocationManager());
        }
        this.continuousLocationProvider.requestLocationUpdates(fromReadableMap, new LocationChangeListener() {
            public void onLocationChange(Location location) {
                RNFusedLocationModule.this.emitEvent("geolocationDidChange", LocationUtils.locationToMap(location));
            }

            public void onLocationError(LocationError locationError, String str) {
                RNFusedLocationModule.this.emitEvent("geolocationError", LocationUtils.buildError(locationError, str));
            }
        });
    }

    @ReactMethod
    public void stopObserving() {
        LocationProvider locationProvider = this.continuousLocationProvider;
        if (locationProvider != null) {
            locationProvider.removeLocationUpdates();
            this.continuousLocationProvider = null;
        }
    }

    private LocationProvider createLocationProvider(boolean z) {
        ReactApplicationContext context = getContext();
        boolean isGooglePlayServicesAvailable = LocationUtils.isGooglePlayServicesAvailable(context);
        if (z || !isGooglePlayServicesAvailable) {
            return new LocationManagerProvider(context);
        }
        return new FusedLocationProvider(context);
    }

    /* access modifiers changed from: private */
    public void emitEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    private ReactApplicationContext getContext() {
        return getReactApplicationContext();
    }
}

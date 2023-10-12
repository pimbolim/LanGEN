package com.agontuk.RNFusedLocation;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

public class LocationManagerProvider implements LocationProvider {
    /* access modifiers changed from: private */
    public boolean isSingleUpdate = false;
    /* access modifiers changed from: private */
    public LocationChangeListener locationChangeListener;
    private final LocationListener locationListener = new LocationListener() {
        public void onProviderEnabled(String str) {
        }

        public void onLocationChanged(Location location) {
            LocationManagerProvider.this.locationChangeListener.onLocationChange(location);
            if (LocationManagerProvider.this.isSingleUpdate) {
                LocationManagerProvider.this.timeoutHandler.removeCallbacks(LocationManagerProvider.this.timeoutRunnable);
                LocationManagerProvider.this.removeLocationUpdates();
            }
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 2) {
                onProviderEnabled(str);
            } else {
                onProviderDisabled(str);
            }
        }

        public void onProviderDisabled(String str) {
            LocationManagerProvider.this.locationChangeListener.onLocationError(LocationError.POSITION_UNAVAILABLE, (String) null);
        }
    };
    private final LocationManager locationManager;
    /* access modifiers changed from: private */
    public final Handler timeoutHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final Runnable timeoutRunnable = new Runnable() {
        public void run() {
            LocationManagerProvider.this.locationChangeListener.onLocationError(LocationError.TIMEOUT, (String) null);
            LocationManagerProvider.this.removeLocationUpdates();
        }
    };

    public boolean onActivityResult(int i, int i2) {
        return false;
    }

    public LocationManagerProvider(ReactApplicationContext reactApplicationContext) {
        this.locationManager = (LocationManager) reactApplicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION);
    }

    public void getCurrentLocation(LocationOptions locationOptions, LocationChangeListener locationChangeListener2) {
        this.isSingleUpdate = true;
        this.locationChangeListener = locationChangeListener2;
        String bestProvider = getBestProvider(locationOptions.getAccuracy());
        if (bestProvider == null) {
            locationChangeListener2.onLocationError(LocationError.POSITION_UNAVAILABLE, (String) null);
            return;
        }
        Location lastKnownLocation = this.locationManager.getLastKnownLocation(bestProvider);
        if (lastKnownLocation == null || ((double) LocationUtils.getLocationAge(lastKnownLocation)) >= locationOptions.getMaximumAge()) {
            startLocationUpdates(bestProvider, locationOptions.getInterval(), locationOptions.getDistanceFilter(), locationOptions.getTimeout());
            return;
        }
        Log.i(RNFusedLocationModule.TAG, "returning cached location.");
        locationChangeListener2.onLocationChange(lastKnownLocation);
    }

    public void requestLocationUpdates(LocationOptions locationOptions, LocationChangeListener locationChangeListener2) {
        this.isSingleUpdate = false;
        this.locationChangeListener = locationChangeListener2;
        String bestProvider = getBestProvider(locationOptions.getAccuracy());
        if (bestProvider == null) {
            locationChangeListener2.onLocationError(LocationError.POSITION_UNAVAILABLE, (String) null);
            return;
        }
        startLocationUpdates(bestProvider, locationOptions.getInterval(), locationOptions.getDistanceFilter(), locationOptions.getTimeout());
    }

    public void removeLocationUpdates() {
        this.locationManager.removeUpdates(this.locationListener);
    }

    private String getBestProvider(LocationAccuracy locationAccuracy) {
        String bestProvider = this.locationManager.getBestProvider(getProviderCriteria(locationAccuracy), true);
        if (bestProvider != null) {
            return bestProvider;
        }
        List<String> providers = this.locationManager.getProviders(true);
        if (providers.size() > 0) {
            return providers.get(0);
        }
        return null;
    }

    /* renamed from: com.agontuk.RNFusedLocation.LocationManagerProvider$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.agontuk.RNFusedLocation.LocationAccuracy[] r0 = com.agontuk.RNFusedLocation.LocationAccuracy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy = r0
                com.agontuk.RNFusedLocation.LocationAccuracy r1 = com.agontuk.RNFusedLocation.LocationAccuracy.high     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy     // Catch:{ NoSuchFieldError -> 0x001d }
                com.agontuk.RNFusedLocation.LocationAccuracy r1 = com.agontuk.RNFusedLocation.LocationAccuracy.balanced     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.agontuk.RNFusedLocation.LocationAccuracy r1 = com.agontuk.RNFusedLocation.LocationAccuracy.low     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.agontuk.RNFusedLocation.LocationAccuracy r1 = com.agontuk.RNFusedLocation.LocationAccuracy.passive     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.agontuk.RNFusedLocation.LocationManagerProvider.AnonymousClass3.<clinit>():void");
        }
    }

    private Criteria getProviderCriteria(LocationAccuracy locationAccuracy) {
        int i = AnonymousClass3.$SwitchMap$com$agontuk$RNFusedLocation$LocationAccuracy[locationAccuracy.ordinal()];
        int i2 = 0;
        int i3 = 3;
        int i4 = 1;
        if (i == 1) {
            i2 = 1;
            i4 = 3;
        } else if (i == 2) {
            i2 = 2;
            i3 = 2;
            i4 = 2;
        } else if (i == 3) {
            i2 = 2;
            i3 = 1;
        } else if (i == 4) {
            i3 = 0;
            i4 = 0;
        } else {
            throw new IllegalStateException("Unexpected value: " + locationAccuracy);
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(i2);
        criteria.setBearingAccuracy(i3);
        criteria.setHorizontalAccuracy(i3);
        criteria.setPowerRequirement(i4);
        criteria.setSpeedAccuracy(i3);
        criteria.setVerticalAccuracy(i3);
        return criteria;
    }

    private void startLocationUpdates(String str, long j, float f, long j2) {
        this.locationManager.requestLocationUpdates(str, j, f, this.locationListener, Looper.getMainLooper());
        if (this.isSingleUpdate && j2 > 0 && j2 != Long.MAX_VALUE) {
            this.timeoutHandler.postDelayed(this.timeoutRunnable, j2);
        }
    }
}

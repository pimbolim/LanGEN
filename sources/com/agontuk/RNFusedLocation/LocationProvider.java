package com.agontuk.RNFusedLocation;

public interface LocationProvider {
    void getCurrentLocation(LocationOptions locationOptions, LocationChangeListener locationChangeListener);

    boolean onActivityResult(int i, int i2);

    void removeLocationUpdates();

    void requestLocationUpdates(LocationOptions locationOptions, LocationChangeListener locationChangeListener);
}

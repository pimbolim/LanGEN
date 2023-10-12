package com.agontuk.RNFusedLocation;

import android.location.Location;

public interface LocationChangeListener {
    void onLocationChange(Location location);

    void onLocationError(LocationError locationError, String str);
}

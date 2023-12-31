package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

public interface LocationListenerCompat extends LocationListener {
    void onFlushComplete(int i);

    void onLocationChanged(List<Location> list);

    void onProviderDisabled(String str);

    void onProviderEnabled(String str);

    void onStatusChanged(String str, int i, Bundle bundle);

    /* renamed from: androidx.core.location.LocationListenerCompat$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFlushComplete(LocationListenerCompat locationListenerCompat, int i) {
        }

        public static void $default$onProviderDisabled(LocationListenerCompat locationListenerCompat, String str) {
        }

        public static void $default$onProviderEnabled(LocationListenerCompat locationListenerCompat, String str) {
        }

        public static void $default$onStatusChanged(LocationListenerCompat locationListenerCompat, String str, int i, Bundle bundle) {
        }

        public static void $default$onLocationChanged(LocationListenerCompat _this, List list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                _this.onLocationChanged((Location) list.get(i));
            }
        }
    }
}

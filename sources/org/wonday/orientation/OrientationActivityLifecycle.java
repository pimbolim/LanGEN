package org.wonday.orientation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

public class OrientationActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "OrientationModule";
    private static AtomicInteger activeCount = new AtomicInteger(0);
    private static OrientationActivityLifecycle instance;
    private OrientationListeners orientationListeners;

    public static OrientationActivityLifecycle getInstance() {
        if (instance == null) {
            instance = new OrientationActivityLifecycle();
        }
        return instance;
    }

    private OrientationActivityLifecycle() {
    }

    public void registerListeners(OrientationListeners orientationListeners2) {
        this.orientationListeners = orientationListeners2;
        if (activeCount.get() == 1) {
            this.orientationListeners.start();
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.d(TAG, "onActivityCreated");
    }

    public void onActivityStarted(Activity activity) {
        Log.d(TAG, "onActivityStarted");
    }

    public void onActivityResumed(Activity activity) {
        Log.d(TAG, "onActivityResumed");
        if (activeCount.incrementAndGet() == 1 && this.orientationListeners != null) {
            Log.d(TAG, "Start orientation");
            this.orientationListeners.start();
        }
    }

    public void onActivityPaused(Activity activity) {
        Log.d(TAG, "onActivityPaused");
    }

    public void onActivityStopped(Activity activity) {
        OrientationListeners orientationListeners2;
        Log.d(TAG, "onActivityStopped");
        if (activeCount.decrementAndGet() == 0 && (orientationListeners2 = this.orientationListeners) != null) {
            orientationListeners2.stop();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Log.d(TAG, "onActivitySaveInstanceState");
    }

    public void onActivityDestroyed(Activity activity) {
        OrientationListeners orientationListeners2;
        Log.d(TAG, "onActivityDestroyed");
        if (activeCount.get() == 0 && (orientationListeners2 = this.orientationListeners) != null) {
            orientationListeners2.release();
        }
    }
}

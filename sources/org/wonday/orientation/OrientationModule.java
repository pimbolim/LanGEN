package org.wonday.orientation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.brentvatne.react.ReactVideoView;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class OrientationModule extends ReactContextBaseJavaModule implements OrientationListeners {
    final ReactApplicationContext ctx;
    private boolean isLocked = false;
    /* access modifiers changed from: private */
    public String lastDeviceOrientationValue = "";
    /* access modifiers changed from: private */
    public String lastOrientationValue = "";
    final OrientationEventListener mOrientationListener;
    final BroadcastReceiver mReceiver;

    public String getName() {
        return ExifInterface.TAG_ORIENTATION;
    }

    public OrientationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.ctx = reactApplicationContext;
        AnonymousClass1 r0 = new OrientationEventListener(reactApplicationContext, 2) {
            public void onOrientationChanged(int i) {
                FLog.d(ReactConstants.TAG, "DeviceOrientation changed to " + i);
                String access$000 = OrientationModule.this.lastDeviceOrientationValue;
                if (i == -1) {
                    access$000 = "UNKNOWN";
                } else if (i > 355 || i < 5) {
                    access$000 = "PORTRAIT";
                } else if (i > 85 && i < 95) {
                    access$000 = "LANDSCAPE-RIGHT";
                } else if (i > 175 && i < 185) {
                    access$000 = "PORTRAIT-UPSIDEDOWN";
                } else if (i > 265 && i < 275) {
                    access$000 = "LANDSCAPE-LEFT";
                }
                if (!OrientationModule.this.lastDeviceOrientationValue.equals(access$000)) {
                    String unused = OrientationModule.this.lastDeviceOrientationValue = access$000;
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("deviceOrientation", access$000);
                    if (OrientationModule.this.ctx.hasActiveCatalystInstance()) {
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) OrientationModule.this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("deviceOrientationDidChange", createMap);
                    }
                }
            }
        };
        this.mOrientationListener = r0;
        if (r0.canDetectOrientation()) {
            FLog.d(ReactConstants.TAG, "orientation detect enabled.");
            r0.enable();
        } else {
            FLog.d(ReactConstants.TAG, "orientation detect disabled.");
            r0.disable();
        }
        this.mReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String access$100 = OrientationModule.this.getCurrentOrientation();
                String unused = OrientationModule.this.lastOrientationValue = access$100;
                FLog.d(ReactConstants.TAG, "Orientation changed to " + access$100);
                WritableMap createMap = Arguments.createMap();
                createMap.putString(ReactVideoView.EVENT_PROP_ORIENTATION, access$100);
                if (OrientationModule.this.ctx.hasActiveCatalystInstance()) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) OrientationModule.this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("orientationDidChange", createMap);
                }
            }
        };
        OrientationActivityLifecycle.getInstance().registerListeners(this);
    }

    /* access modifiers changed from: private */
    public String getCurrentOrientation() {
        int rotation = ((WindowManager) getReactApplicationContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return "PORTRAIT";
        }
        if (rotation == 1) {
            return "LANDSCAPE-LEFT";
        }
        if (rotation != 2) {
            return rotation != 3 ? "UNKNOWN" : "LANDSCAPE-RIGHT";
        }
        return "PORTRAIT-UPSIDEDOWN";
    }

    @ReactMethod
    public void getOrientation(Callback callback) {
        callback.invoke(getCurrentOrientation());
    }

    @ReactMethod
    public void getDeviceOrientation(Callback callback) {
        callback.invoke(this.lastDeviceOrientationValue);
    }

    @ReactMethod
    public void lockToPortrait() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(1);
            this.isLocked = true;
            this.lastOrientationValue = "PORTRAIT";
            WritableMap createMap = Arguments.createMap();
            createMap.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("orientationDidChange", createMap);
            }
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("lockDidChange", createMap2);
            }
        }
    }

    @ReactMethod
    public void lockToPortraitUpsideDown() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(9);
            this.isLocked = true;
            this.lastOrientationValue = "PORTRAIT-UPSIDEDOWN";
            WritableMap createMap = Arguments.createMap();
            createMap.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("orientationDidChange", createMap);
            }
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("lockDidChange", createMap2);
            }
        }
    }

    @ReactMethod
    public void lockToLandscape() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(6);
            this.isLocked = true;
            this.lastOrientationValue = "LANDSCAPE-LEFT";
            WritableMap createMap = Arguments.createMap();
            createMap.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("orientationDidChange", createMap);
            }
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("lockDidChange", createMap2);
            }
        }
    }

    @ReactMethod
    public void lockToLandscapeLeft() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(0);
            this.isLocked = true;
            this.lastOrientationValue = "LANDSCAPE-LEFT";
            WritableMap createMap = Arguments.createMap();
            createMap.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("orientationDidChange", createMap);
            }
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("lockDidChange", createMap2);
            }
        }
    }

    @ReactMethod
    public void lockToLandscapeRight() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(8);
            this.isLocked = true;
            this.lastOrientationValue = "LANDSCAPE-RIGHT";
            WritableMap createMap = Arguments.createMap();
            createMap.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("orientationDidChange", createMap);
            }
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("lockDidChange", createMap2);
            }
        }
    }

    @ReactMethod
    public void unlockAllOrientations() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(4);
            this.isLocked = false;
            this.lastOrientationValue = this.lastDeviceOrientationValue;
            WritableMap createMap = Arguments.createMap();
            createMap.putString(ReactVideoView.EVENT_PROP_ORIENTATION, this.lastOrientationValue);
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("orientationDidChange", createMap);
            }
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString(ReactVideoView.EVENT_PROP_ORIENTATION, "UNKNOWN");
            if (this.ctx.hasActiveCatalystInstance()) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.ctx.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("lockDidChange", createMap2);
            }
        }
    }

    @ReactMethod
    public void getAutoRotateState(Callback callback) {
        callback.invoke(Boolean.valueOf(Settings.System.getInt(this.ctx.getContentResolver(), "accelerometer_rotation", 0) == 1));
    }

    @Nullable
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("initialOrientation", getCurrentOrientation());
        return hashMap;
    }

    public void start() {
        FLog.i(ReactConstants.TAG, "orientation detect enabled.");
        this.mOrientationListener.enable();
        this.ctx.registerReceiver(this.mReceiver, new IntentFilter("onConfigurationChanged"));
    }

    public void stop() {
        FLog.d(ReactConstants.TAG, "orientation detect disabled.");
        this.mOrientationListener.disable();
        try {
            this.ctx.unregisterReceiver(this.mReceiver);
        } catch (IllegalArgumentException e) {
            FLog.w(ReactConstants.TAG, "Receiver already unregistered", (Throwable) e);
        }
    }

    public void release() {
        FLog.d(ReactConstants.TAG, "orientation detect disabled.");
        this.mOrientationListener.disable();
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            try {
                currentActivity.unregisterReceiver(this.mReceiver);
            } catch (IllegalArgumentException e) {
                FLog.w(ReactConstants.TAG, "Receiver already unregistered", (Throwable) e);
            }
        }
    }
}

package io.invertase.firebase.fabric.crashlytics;

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.devsupport.StackTraceHelper;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.util.ArrayList;

public class RNFirebaseCrashlytics extends ReactContextBaseJavaModule {
    private static final String TAG = "RNFirebaseCrashlytics";

    public String getName() {
        return TAG;
    }

    public RNFirebaseCrashlytics(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Log.d(TAG, "New instance");
    }

    @ReactMethod
    public void crash() {
        Crashlytics.getInstance().crash();
    }

    @ReactMethod
    public void log(String str) {
        Crashlytics.log(str);
    }

    @ReactMethod
    public void recordError(int i, String str) {
        Crashlytics.logException(new Exception(i + ": " + str));
    }

    @ReactMethod
    public void recordCustomError(String str, String str2, ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList(0);
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            ReadableMap map2 = map.hasKey("additional") ? map.getMap("additional") : null;
            int i2 = -1;
            arrayList.add(new StackTraceElement(map.hasKey("className") ? map.getString("className") : "Unknown Class", map.hasKey("functionName") ? map.getString("functionName") : "Unknown Function", map.getString("fileName"), map.hasKey(StackTraceHelper.LINE_NUMBER_KEY) ? map.getInt(StackTraceHelper.LINE_NUMBER_KEY) : -1));
            if (map2 != null) {
                String obj = map2.toString();
                String string = map.getString("fileName");
                if (map.hasKey(StackTraceHelper.LINE_NUMBER_KEY)) {
                    i2 = map.getInt(StackTraceHelper.LINE_NUMBER_KEY);
                }
                arrayList.add(new StackTraceElement("Additional Parameters", obj, string, i2));
            }
        }
        Exception exc = new Exception(str + "\n" + str2);
        exc.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
        Crashlytics.logException(exc);
    }

    @ReactMethod
    public void setBoolValue(String str, boolean z) {
        Crashlytics.setBool(str, z);
    }

    @ReactMethod
    public void setFloatValue(String str, float f) {
        Crashlytics.setFloat(str, f);
    }

    @ReactMethod
    public void setIntValue(String str, int i) {
        Crashlytics.setInt(str, i);
    }

    @ReactMethod
    public void setStringValue(String str, String str2) {
        Crashlytics.setString(str, str2);
    }

    @ReactMethod
    public void setUserIdentifier(String str) {
        Crashlytics.setUserIdentifier(str);
    }

    @ReactMethod
    public void setUserName(String str) {
        Crashlytics.setUserName(str);
    }

    @ReactMethod
    public void setUserEmail(String str) {
        Crashlytics.setUserEmail(str);
    }

    @ReactMethod
    public void enableCrashlyticsCollection() {
        Fabric.with(getReactApplicationContext(), new Kit[]{new Crashlytics()});
    }
}

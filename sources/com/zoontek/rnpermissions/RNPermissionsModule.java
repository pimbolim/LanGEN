package com.zoontek.rnpermissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import java.util.ArrayList;

@ReactModule(name = "RNPermissions")
public class RNPermissionsModule extends ReactContextBaseJavaModule implements PermissionListener {
    private static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";
    public static final String MODULE_NAME = "RNPermissions";
    private static final String SETTING_NAME = "@RNPermissions:NonRequestables";
    private final String BLOCKED = "blocked";
    private final String DENIED = "denied";
    private final String GRANTED = "granted";
    private final String UNAVAILABLE = "unavailable";
    private int mRequestCode = 0;
    private final SparseArray<Request> mRequests;
    /* access modifiers changed from: private */
    public final SharedPreferences mSharedPrefs;

    public String getName() {
        return MODULE_NAME;
    }

    public RNPermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mSharedPrefs = reactApplicationContext.getSharedPreferences(SETTING_NAME, 0);
        this.mRequests = new SparseArray<>();
    }

    private class Request {
        public Callback callback;
        public boolean[] rationaleStatuses;

        public Request(boolean[] zArr, Callback callback2) {
            this.rationaleStatuses = zArr;
            this.callback = callback2;
        }
    }

    private String getFieldName(String str) {
        if (str.equals("android.permission.ACCEPT_HANDOVER")) {
            return "ACCEPT_HANDOVER";
        }
        if (str.equals("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return "ACCESS_BACKGROUND_LOCATION";
        }
        if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
            return "ACCESS_COARSE_LOCATION";
        }
        if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
            return "ACCESS_FINE_LOCATION";
        }
        if (str.equals("android.permission.ACCESS_MEDIA_LOCATION")) {
            return "ACCESS_MEDIA_LOCATION";
        }
        if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
            return "ADD_VOICEMAIL";
        }
        if (str.equals("android.permission.ACTIVITY_RECOGNITION")) {
            return "ACTIVITY_RECOGNITION";
        }
        if (str.equals("android.permission.ANSWER_PHONE_CALLS")) {
            return "ANSWER_PHONE_CALLS";
        }
        if (str.equals("android.permission.BLUETOOTH_ADVERTISE")) {
            return "BLUETOOTH_ADVERTISE";
        }
        if (str.equals("android.permission.BLUETOOTH_CONNECT")) {
            return "BLUETOOTH_CONNECT";
        }
        if (str.equals("android.permission.BLUETOOTH_SCAN")) {
            return "BLUETOOTH_SCAN";
        }
        if (str.equals("android.permission.BODY_SENSORS")) {
            return "BODY_SENSORS";
        }
        if (str.equals("android.permission.CALL_PHONE")) {
            return "CALL_PHONE";
        }
        if (str.equals("android.permission.CAMERA")) {
            return "CAMERA";
        }
        if (str.equals("android.permission.GET_ACCOUNTS")) {
            return "GET_ACCOUNTS";
        }
        if (str.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
            return "PROCESS_OUTGOING_CALLS";
        }
        if (str.equals("android.permission.READ_CALENDAR")) {
            return "READ_CALENDAR";
        }
        if (str.equals("android.permission.READ_CALL_LOG")) {
            return "READ_CALL_LOG";
        }
        if (str.equals("android.permission.READ_CONTACTS")) {
            return "READ_CONTACTS";
        }
        if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
            return "READ_EXTERNAL_STORAGE";
        }
        if (str.equals("android.permission.READ_PHONE_NUMBERS")) {
            return "READ_PHONE_NUMBERS";
        }
        if (str.equals("android.permission.READ_PHONE_STATE")) {
            return "READ_PHONE_STATE";
        }
        if (str.equals("android.permission.READ_SMS")) {
            return "READ_SMS";
        }
        if (str.equals("android.permission.RECEIVE_MMS")) {
            return "RECEIVE_MMS";
        }
        if (str.equals("android.permission.RECEIVE_SMS")) {
            return "RECEIVE_SMS";
        }
        if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
            return "RECEIVE_WAP_PUSH";
        }
        if (str.equals("android.permission.RECORD_AUDIO")) {
            return "RECORD_AUDIO";
        }
        if (str.equals("android.permission.SEND_SMS")) {
            return "SEND_SMS";
        }
        if (str.equals("android.permission.USE_SIP")) {
            return "USE_SIP";
        }
        if (str.equals("android.permission.WRITE_CALENDAR")) {
            return "WRITE_CALENDAR";
        }
        if (str.equals("android.permission.WRITE_CALL_LOG")) {
            return "WRITE_CALL_LOG";
        }
        if (str.equals("android.permission.WRITE_CONTACTS")) {
            return "WRITE_CONTACTS";
        }
        if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
            return "WRITE_EXTERNAL_STORAGE";
        }
        return null;
    }

    private boolean permissionExists(String str) {
        String fieldName = getFieldName(str);
        if (fieldName == null) {
            return false;
        }
        try {
            Manifest.permission.class.getField(fieldName);
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    @ReactMethod
    public void checkNotifications(Promise promise) {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(getReactApplicationContext()).areNotificationsEnabled();
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        if (areNotificationsEnabled) {
            createMap.putString(NotificationCompat.CATEGORY_STATUS, "granted");
        } else {
            createMap.putString(NotificationCompat.CATEGORY_STATUS, "blocked");
        }
        createMap.putMap("settings", createMap2);
        promise.resolve(createMap);
    }

    @ReactMethod
    public void openSettings(Promise promise) {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intent intent = new Intent();
            String packageName = reactApplicationContext.getPackageName();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(268435456);
            intent.setData(Uri.fromParts("package", packageName, (String) null));
            reactApplicationContext.startActivity(intent);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(ERROR_INVALID_ACTIVITY, (Throwable) e);
        }
    }

    @ReactMethod
    public void checkPermission(String str, Promise promise) {
        if (str == null || !permissionExists(str)) {
            promise.resolve("unavailable");
            return;
        }
        Context baseContext = getReactApplicationContext().getBaseContext();
        String str2 = "blocked";
        if (Build.VERSION.SDK_INT < 23) {
            if (baseContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                str2 = "granted";
            }
            promise.resolve(str2);
        } else if (baseContext.checkSelfPermission(str) == 0) {
            promise.resolve("granted");
        } else if (this.mSharedPrefs.getBoolean(str, false)) {
            promise.resolve(str2);
        } else {
            promise.resolve("denied");
        }
    }

    @ReactMethod
    public void shouldShowRequestPermissionRationale(String str, Promise promise) {
        if (str == null || Build.VERSION.SDK_INT < 23) {
            promise.resolve(false);
            return;
        }
        try {
            promise.resolve(Boolean.valueOf(getPermissionAwareActivity().shouldShowRequestPermissionRationale(str)));
        } catch (IllegalStateException e) {
            promise.reject(ERROR_INVALID_ACTIVITY, (Throwable) e);
        }
    }

    @ReactMethod
    public void requestPermission(final String str, final Promise promise) {
        if (str == null || !permissionExists(str)) {
            promise.resolve("unavailable");
            return;
        }
        Context baseContext = getReactApplicationContext().getBaseContext();
        String str2 = "blocked";
        if (Build.VERSION.SDK_INT < 23) {
            if (baseContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                str2 = "granted";
            }
            promise.resolve(str2);
        } else if (baseContext.checkSelfPermission(str) == 0) {
            promise.resolve("granted");
        } else if (this.mSharedPrefs.getBoolean(str, false)) {
            promise.resolve(str2);
        } else {
            try {
                PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity();
                this.mRequests.put(this.mRequestCode, new Request(new boolean[]{permissionAwareActivity.shouldShowRequestPermissionRationale(str)}, new Callback() {
                    public void invoke(Object... objArr) {
                        int[] iArr = objArr[0];
                        if (iArr.length <= 0 || iArr[0] != 0) {
                            PermissionAwareActivity permissionAwareActivity = objArr[1];
                            if (!objArr[2][0] || permissionAwareActivity.shouldShowRequestPermissionRationale(str)) {
                                promise.resolve("denied");
                                return;
                            }
                            RNPermissionsModule.this.mSharedPrefs.edit().putBoolean(str, true).commit();
                            promise.resolve("blocked");
                            return;
                        }
                        promise.resolve("granted");
                    }
                }));
                permissionAwareActivity.requestPermissions(new String[]{str}, this.mRequestCode, this);
                this.mRequestCode++;
            } catch (IllegalStateException e) {
                promise.reject(ERROR_INVALID_ACTIVITY, (Throwable) e);
            }
        }
    }

    @ReactMethod
    public void checkMultiplePermissions(ReadableArray readableArray, Promise promise) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Context baseContext = getReactApplicationContext().getBaseContext();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            if (!permissionExists(string)) {
                writableNativeMap.putString(string, "unavailable");
            } else {
                String str = "blocked";
                if (Build.VERSION.SDK_INT < 23) {
                    if (baseContext.checkPermission(string, Process.myPid(), Process.myUid()) == 0) {
                        str = "granted";
                    }
                    writableNativeMap.putString(string, str);
                } else if (baseContext.checkSelfPermission(string) == 0) {
                    writableNativeMap.putString(string, "granted");
                } else if (this.mSharedPrefs.getBoolean(string, false)) {
                    writableNativeMap.putString(string, str);
                } else {
                    writableNativeMap.putString(string, "denied");
                }
            }
        }
        promise.resolve(writableNativeMap);
    }

    @ReactMethod
    public void requestMultiplePermissions(ReadableArray readableArray, final Promise promise) {
        final WritableNativeMap writableNativeMap = new WritableNativeMap();
        final ArrayList arrayList = new ArrayList();
        Context baseContext = getReactApplicationContext().getBaseContext();
        int i = 0;
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            String string = readableArray.getString(i2);
            if (!permissionExists(string)) {
                writableNativeMap.putString(string, "unavailable");
            } else {
                String str = "blocked";
                if (Build.VERSION.SDK_INT < 23) {
                    if (baseContext.checkPermission(string, Process.myPid(), Process.myUid()) == 0) {
                        str = "granted";
                    }
                    writableNativeMap.putString(string, str);
                } else if (baseContext.checkSelfPermission(string) == 0) {
                    writableNativeMap.putString(string, "granted");
                } else if (this.mSharedPrefs.getBoolean(string, false)) {
                    writableNativeMap.putString(string, str);
                } else {
                    arrayList.add(string);
                }
            }
            i++;
        }
        if (readableArray.size() == i) {
            promise.resolve(writableNativeMap);
            return;
        }
        try {
            PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity();
            boolean[] zArr = new boolean[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                zArr[i3] = permissionAwareActivity.shouldShowRequestPermissionRationale((String) arrayList.get(i3));
            }
            this.mRequests.put(this.mRequestCode, new Request(zArr, new Callback() {
                public void invoke(Object... objArr) {
                    int[] iArr = objArr[0];
                    PermissionAwareActivity permissionAwareActivity = objArr[1];
                    boolean[] zArr = objArr[2];
                    for (int i = 0; i < arrayList.size(); i++) {
                        String str = (String) arrayList.get(i);
                        if (iArr.length > 0 && iArr[i] == 0) {
                            writableNativeMap.putString(str, "granted");
                        } else if (!zArr[i] || permissionAwareActivity.shouldShowRequestPermissionRationale(str)) {
                            writableNativeMap.putString(str, "denied");
                        } else {
                            RNPermissionsModule.this.mSharedPrefs.edit().putBoolean(str, true).commit();
                            writableNativeMap.putString(str, "blocked");
                        }
                    }
                    promise.resolve(writableNativeMap);
                }
            }));
            permissionAwareActivity.requestPermissions((String[]) arrayList.toArray(new String[0]), this.mRequestCode, this);
            this.mRequestCode++;
        } catch (IllegalStateException e) {
            promise.reject(ERROR_INVALID_ACTIVITY, (Throwable) e);
        }
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Request request = this.mRequests.get(i);
        request.callback.invoke(iArr, getPermissionAwareActivity(), request.rationaleStatuses);
        this.mRequests.remove(i);
        if (this.mRequests.size() == 0) {
            return true;
        }
        return false;
    }

    private PermissionAwareActivity getPermissionAwareActivity() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        } else if (currentActivity instanceof PermissionAwareActivity) {
            return (PermissionAwareActivity) currentActivity;
        } else {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
    }
}

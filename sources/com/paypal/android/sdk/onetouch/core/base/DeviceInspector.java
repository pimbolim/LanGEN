package com.paypal.android.sdk.onetouch.core.base;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import org.apache.commons.lang3.StringUtils;

public class DeviceInspector {
    public static String getApplicationInfoName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String getSimOperatorName(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str.equalsIgnoreCase("unknown") || str2.startsWith(str)) {
            return str2;
        }
        return str + StringUtils.SPACE + str2;
    }

    public static String getOs() {
        return "Android " + Build.VERSION.RELEASE;
    }
}

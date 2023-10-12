package com.google.android.instantapps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.bouncycastle.i18n.ErrorBundle;

public final class InstantApps {
    static final String ACTION_QUICK_INSTALL = "com.google.android.finsky.action.IA_INSTALL";
    private static final String EXTRA_POST_INSTALL_INTENT = "postInstallIntent";
    private static Boolean isInstantApp;
    private static Context lastApplicationContext;
    private static PackageManagerWrapper packageManagerWrapper;

    private InstantApps() {
    }

    public static boolean isInstantApp(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                throw new IllegalStateException("Application context is null!");
            } else if (isInstantApp != null && applicationContext.equals(lastApplicationContext)) {
                return isInstantApp.booleanValue();
            } else {
                Boolean bool = null;
                isInstantApp = null;
                if (isAtLeastO()) {
                    if (packageManagerWrapper == null || !applicationContext.equals(lastApplicationContext)) {
                        packageManagerWrapper = new PackageManagerWrapper(applicationContext.getPackageManager());
                    }
                    bool = packageManagerWrapper.isInstantApp();
                }
                lastApplicationContext = applicationContext;
                if (bool != null) {
                    isInstantApp = bool;
                } else {
                    try {
                        applicationContext.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        isInstantApp = true;
                    } catch (ClassNotFoundException unused) {
                        isInstantApp = false;
                    }
                }
                return isInstantApp.booleanValue();
            }
        } else {
            throw new IllegalArgumentException("Context must be non-null");
        }
    }

    /* access modifiers changed from: private */
    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    static class PackageManagerWrapper {
        private static Method isInstantAppMethod;
        private final PackageManager packageManager;

        PackageManagerWrapper(PackageManager packageManager2) {
            this.packageManager = packageManager2;
        }

        /* access modifiers changed from: package-private */
        public Boolean isInstantApp() {
            if (!InstantApps.isAtLeastO()) {
                return null;
            }
            if (isInstantAppMethod == null) {
                try {
                    isInstantAppMethod = PackageManager.class.getDeclaredMethod(NamedConstantsKt.IS_INSTANT_APP, new Class[0]);
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            }
            try {
                return (Boolean) isInstantAppMethod.invoke(this.packageManager, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return null;
            }
        }
    }

    @Deprecated
    public static boolean showInstallPrompt(Activity activity, int i, String str) {
        return showInstallPromptImpl(activity, (Intent) null, i, str);
    }

    public static boolean showInstallPrompt(Activity activity, Intent intent, int i, String str) {
        return showInstallPromptImpl(activity, intent, i, str);
    }

    private static boolean showInstallPromptImpl(Activity activity, Intent intent, int i, String str) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        } else if (!isInstantApp(activity)) {
            return false;
        } else {
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("market").authority(ErrorBundle.DETAIL_ENTRY).appendQueryParameter(MessageExtension.FIELD_ID, activity.getPackageName());
            if (!TextUtils.isEmpty(str)) {
                appendQueryParameter.appendQueryParameter("referrer", str);
            }
            Intent intent2 = new Intent(ACTION_QUICK_INSTALL).setData(appendQueryParameter.build()).setPackage("com.android.vending");
            intent2.putExtra(EXTRA_POST_INSTALL_INTENT, intent);
            if (intent == null || !storeSupportsQuickInstall(activity, intent2)) {
                return showInstallPromptFallback(activity, i, str);
            }
            return showInstallPromptImplWithIntent(activity, intent2, i);
        }
    }

    private static boolean showInstallPromptImplWithIntent(Activity activity, Intent intent, int i) {
        activity.startActivityForResult(intent, i);
        return true;
    }

    private static boolean showInstallPromptFallback(Activity activity, int i, String str) {
        Intent putExtra = new Intent("android.intent.action.VIEW").setPackage("com.android.vending").addCategory("android.intent.category.DEFAULT").putExtra("callerId", activity.getPackageName()).putExtra("overlay", true);
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("market").authority(ErrorBundle.DETAIL_ENTRY).appendQueryParameter(MessageExtension.FIELD_ID, activity.getPackageName());
        if (!TextUtils.isEmpty(str)) {
            appendQueryParameter.appendQueryParameter("referrer", str);
        }
        putExtra.setData(appendQueryParameter.build());
        activity.startActivityForResult(putExtra, i);
        return true;
    }

    private static boolean storeSupportsQuickInstall(Context context, Intent intent) {
        if (context.getPackageManager().resolveActivity(intent, 0) != null) {
            return true;
        }
        return false;
    }
}

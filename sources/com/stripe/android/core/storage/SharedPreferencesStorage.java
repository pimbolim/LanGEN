package com.stripe.android.core.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/core/storage/SharedPreferencesStorage;", "Lcom/stripe/android/core/storage/Storage;", "context", "Landroid/content/Context;", "purpose", "", "(Landroid/content/Context;Ljava/lang/String;)V", "sharedPrefs", "Landroid/content/SharedPreferences;", "getSharedPrefs", "()Landroid/content/SharedPreferences;", "sharedPrefs$delegate", "Lkotlin/Lazy;", "clear", "", "getBoolean", "key", "defaultValue", "getFloat", "", "getInt", "", "getLong", "", "getString", "remove", "storeValue", "value", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Storage.kt */
public final class SharedPreferencesStorage implements Storage {
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final String logTag;
    /* access modifiers changed from: private */
    public final Context context;
    private final String purpose;
    private final Lazy sharedPrefs$delegate = LazyKt.lazy(new SharedPreferencesStorage$sharedPrefs$2(this));

    public SharedPreferencesStorage(Context context2, String str) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "purpose");
        this.context = context2;
        this.purpose = str;
    }

    private final SharedPreferences getSharedPrefs() {
        return (SharedPreferences) this.sharedPrefs$delegate.getValue();
    }

    public boolean storeValue(String str, String str2) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs == null) {
            bool = null;
        } else {
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.putString(this.purpose + '_' + str, str2);
            bool = Boolean.valueOf(edit.commit());
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        String str3 = logTag;
        Log.e(str3, "Shared preferences is unavailable to store " + str2 + " for " + str);
        return false;
    }

    public boolean storeValue(String str, long j) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs == null) {
            bool = null;
        } else {
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.putLong(this.purpose + '_' + str, j);
            bool = Boolean.valueOf(edit.commit());
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        String str2 = logTag;
        Log.e(str2, "Shared preferences is unavailable to store " + j + " for " + str);
        return false;
    }

    public boolean storeValue(String str, int i) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs == null) {
            bool = null;
        } else {
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.putInt(this.purpose + '_' + str, i);
            bool = Boolean.valueOf(edit.commit());
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        String str2 = logTag;
        Log.e(str2, "Shared preferences is unavailable to store " + i + " for " + str);
        return false;
    }

    public boolean storeValue(String str, float f) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs == null) {
            bool = null;
        } else {
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.putFloat(this.purpose + '_' + str, f);
            bool = Boolean.valueOf(edit.commit());
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        String str2 = logTag;
        Log.e(str2, "Shared preferences is unavailable to store " + f + " for " + str);
        return false;
    }

    public boolean storeValue(String str, boolean z) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs == null) {
            bool = null;
        } else {
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.putBoolean(this.purpose + '_' + str, z);
            bool = Boolean.valueOf(edit.commit());
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        String str2 = logTag;
        Log.e(str2, "Shared preferences is unavailable to store " + z + " for " + str);
        return false;
    }

    public String getString(String str, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        try {
            SharedPreferences sharedPrefs = getSharedPrefs();
            if (sharedPrefs == null) {
                str3 = null;
            } else {
                str3 = sharedPrefs.getString(this.purpose + '_' + str, str2);
            }
            if (str3 != null) {
                return str3;
            }
            Log.e(logTag, Intrinsics.stringPlus("Unable to retrieve a String for ", str));
            return str2;
        } catch (Throwable th) {
            if (th instanceof ClassCastException) {
                Log.e(logTag, Intrinsics.stringPlus(str, " is not a String"), th);
                return str2;
            }
            Log.d(logTag, Intrinsics.stringPlus("Error retrieving String for ", str), th);
            return str2;
        }
    }

    public long getLong(String str, long j) {
        Long l;
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            SharedPreferences sharedPrefs = getSharedPrefs();
            if (sharedPrefs == null) {
                l = null;
            } else {
                l = Long.valueOf(sharedPrefs.getLong(this.purpose + '_' + str, j));
            }
            if (l != null) {
                return l.longValue();
            }
            Log.e(logTag, Intrinsics.stringPlus("Unable to retrieve a Long for ", str));
            return j;
        } catch (Throwable th) {
            if (th instanceof ClassCastException) {
                Log.e(logTag, Intrinsics.stringPlus(str, " is not a Long"), th);
                return j;
            }
            Log.d(logTag, Intrinsics.stringPlus("Error retrieving Long for ", str), th);
            return j;
        }
    }

    public int getInt(String str, int i) {
        Integer num;
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            SharedPreferences sharedPrefs = getSharedPrefs();
            if (sharedPrefs == null) {
                num = null;
            } else {
                num = Integer.valueOf(sharedPrefs.getInt(this.purpose + '_' + str, i));
            }
            if (num != null) {
                return num.intValue();
            }
            Log.e(logTag, Intrinsics.stringPlus("Unable to retrieve an Int for ", str));
            return i;
        } catch (Throwable th) {
            if (th instanceof ClassCastException) {
                Log.e(logTag, Intrinsics.stringPlus(str, " is not a Int"), th);
                return i;
            }
            Log.d(logTag, Intrinsics.stringPlus("Error retrieving Int for ", str), th);
            return i;
        }
    }

    public float getFloat(String str, float f) {
        Float f2;
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            SharedPreferences sharedPrefs = getSharedPrefs();
            if (sharedPrefs == null) {
                f2 = null;
            } else {
                f2 = Float.valueOf(sharedPrefs.getFloat(this.purpose + '_' + str, f));
            }
            if (f2 != null) {
                return f2.floatValue();
            }
            Log.e(logTag, Intrinsics.stringPlus("Unable to retrieve a Float for ", str));
            return f;
        } catch (Throwable th) {
            if (th instanceof ClassCastException) {
                Log.e(logTag, Intrinsics.stringPlus(str, " is not a Float"), th);
                return f;
            }
            Log.d(logTag, Intrinsics.stringPlus("Error retrieving Float for ", str), th);
            return f;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            SharedPreferences sharedPrefs = getSharedPrefs();
            if (sharedPrefs == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(sharedPrefs.getBoolean(this.purpose + '_' + str, z));
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            Log.e(logTag, Intrinsics.stringPlus("Unable to retrieve a Boolean for ", str));
            return z;
        } catch (Throwable th) {
            if (th instanceof ClassCastException) {
                Log.e(logTag, Intrinsics.stringPlus(str, " is not a Boolean"), th);
                return z;
            }
            Log.d(logTag, Intrinsics.stringPlus("Error retrieving Boolean for ", str), th);
            return z;
        }
    }

    public boolean remove(String str) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs == null) {
            bool = null;
        } else {
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.remove(str);
            bool = Boolean.valueOf(edit.commit());
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        Log.e(logTag, "Shared preferences is unavailable to remove values");
        return false;
    }

    public boolean clear() {
        Boolean bool;
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs == null) {
            bool = null;
        } else {
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.clear();
            bool = Boolean.valueOf(edit.commit());
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        Log.e(logTag, "Shared preferences is unavailable to clear values");
        return false;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/core/storage/SharedPreferencesStorage$Companion;", "", "()V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Storage.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLogTag() {
            return SharedPreferencesStorage.logTag;
        }
    }

    static {
        String simpleName = SharedPreferencesStorage.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "SharedPreferencesStorage::class.java.simpleName");
        logTag = simpleName;
    }
}

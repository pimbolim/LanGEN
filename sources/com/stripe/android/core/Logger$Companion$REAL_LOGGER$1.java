package com.stripe.android.core;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.reactnativestripesdk.StripeSdkModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/stripe/android/core/Logger$Companion$REAL_LOGGER$1", "Lcom/stripe/android/core/Logger;", "debug", "", "msg", "", "error", "t", "", "info", "warning", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Logger.kt */
public final class Logger$Companion$REAL_LOGGER$1 implements Logger {
    Logger$Companion$REAL_LOGGER$1() {
    }

    public void debug(String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Log.d(StripeSdkModule.NAME, str);
    }

    public void info(String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Log.i(StripeSdkModule.NAME, str);
    }

    public void warning(String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Log.w(StripeSdkModule.NAME, str);
    }

    public void error(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        Log.e(StripeSdkModule.NAME, str, th);
    }
}

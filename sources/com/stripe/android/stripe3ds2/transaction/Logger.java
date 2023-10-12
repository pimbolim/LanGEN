package com.stripe.android.stripe3ds2.transaction;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \n2\u00020\u0001:\u0003\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/Logger;", "", "()V", "error", "", "msg", "", "t", "", "info", "Companion", "Noop", "Real", "Lcom/stripe/android/stripe3ds2/transaction/Logger$Real;", "Lcom/stripe/android/stripe3ds2/transaction/Logger$Noop;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Logger.kt */
public abstract class Logger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ Logger(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract void error(String str, Throwable th);

    public abstract void info(String str);

    private Logger() {
    }

    public static /* synthetic */ void error$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                th = null;
            }
            logger.error(str, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/Logger$Real;", "Lcom/stripe/android/stripe3ds2/transaction/Logger;", "()V", "TAG", "", "error", "", "msg", "t", "", "info", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Logger.kt */
    public static final class Real extends Logger {
        public static final Real INSTANCE = new Real();
        private static final String TAG = "StripeSdk";

        private Real() {
            super((DefaultConstructorMarker) null);
        }

        public void info(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Log.i("StripeSdk", str);
        }

        public void error(String str, Throwable th) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Log.e("StripeSdk", str, th);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/Logger$Noop;", "Lcom/stripe/android/stripe3ds2/transaction/Logger;", "()V", "error", "", "msg", "", "t", "", "info", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Logger.kt */
    public static final class Noop extends Logger {
        public static final Noop INSTANCE = new Noop();

        public void error(String str, Throwable th) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        }

        public void info(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        }

        private Noop() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/Logger$Companion;", "", "()V", "get", "Lcom/stripe/android/stripe3ds2/transaction/Logger;", "enableLogging", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Logger.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Logger get(boolean z) {
            if (z) {
                return Real.INSTANCE;
            }
            return Noop.INSTANCE;
        }
    }
}

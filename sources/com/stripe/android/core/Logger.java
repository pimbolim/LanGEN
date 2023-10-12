package com.stripe.android.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/stripe/android/core/Logger;", "", "debug", "", "msg", "", "error", "t", "", "info", "warning", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Logger.kt */
public interface Logger {
    public static final Companion Companion = Companion.$$INSTANCE;

    void debug(String str);

    void error(String str, Throwable th);

    void info(String str);

    void warning(String str);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Logger.kt */
    public static final class DefaultImpls {
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
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0002\u0004\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\fR\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/core/Logger$Companion;", "", "()V", "NOOP_LOGGER", "com/stripe/android/core/Logger$Companion$NOOP_LOGGER$1", "Lcom/stripe/android/core/Logger$Companion$NOOP_LOGGER$1;", "REAL_LOGGER", "com/stripe/android/core/Logger$Companion$REAL_LOGGER$1", "Lcom/stripe/android/core/Logger$Companion$REAL_LOGGER$1;", "TAG", "", "getInstance", "Lcom/stripe/android/core/Logger;", "enableLogging", "", "noop", "real", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Logger.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Logger$Companion$NOOP_LOGGER$1 NOOP_LOGGER = new Logger$Companion$NOOP_LOGGER$1();
        private static final Logger$Companion$REAL_LOGGER$1 REAL_LOGGER = new Logger$Companion$REAL_LOGGER$1();
        private static final String TAG = "StripeSdk";

        private Companion() {
        }

        public final Logger getInstance(boolean z) {
            if (z) {
                return real();
            }
            return noop();
        }

        public final Logger real() {
            return REAL_LOGGER;
        }

        public final Logger noop() {
            return NOOP_LOGGER;
        }
    }
}

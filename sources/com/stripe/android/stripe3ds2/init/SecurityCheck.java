package com.stripe.android.stripe3ds2.init;

import android.os.Debug;
import android.os.Environment;
import com.stripe.android.stripe3ds2.init.Warning;
import com.stripe.android.stripe3ds2.service.StripeThreeDs2ServiceImpl;
import java.io.File;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\t\n\u000b\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck;", "", "warning", "Lcom/stripe/android/stripe3ds2/init/Warning;", "(Lcom/stripe/android/stripe3ds2/init/Warning;)V", "getWarning", "()Lcom/stripe/android/stripe3ds2/init/Warning;", "check", "", "DebuggerAttached", "Emulator", "RootedCheck", "Tampered", "UnsupportedOS", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck$RootedCheck;", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck$Tampered;", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck$Emulator;", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck$DebuggerAttached;", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck$UnsupportedOS;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecurityCheck.kt */
public abstract class SecurityCheck {
    private final Warning warning;

    public /* synthetic */ SecurityCheck(Warning warning2, DefaultConstructorMarker defaultConstructorMarker) {
        this(warning2);
    }

    public abstract boolean check();

    private SecurityCheck(Warning warning2) {
        this.warning = warning2;
    }

    public final Warning getWarning() {
        return this.warning;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck$RootedCheck;", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck;", "()V", "check", "", "findSuBinary", "findSuperuserApk", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SecurityCheck.kt */
    public static final class RootedCheck extends SecurityCheck {
        @Deprecated
        private static final List<String> BINARY_PATHS = CollectionsKt.listOf("/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/");
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final Warning WARNING = new Warning("SW01", "The device is jailbroken.", Warning.Severity.HIGH);

        public RootedCheck() {
            super(WARNING, (DefaultConstructorMarker) null);
        }

        public boolean check() {
            return findSuBinary() || findSuperuserApk();
        }

        private final boolean findSuBinary() {
            Iterable<String> iterable = BINARY_PATHS;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                return false;
            }
            for (String stringPlus : iterable) {
                if (new File(Intrinsics.stringPlus(stringPlus, "su")).exists()) {
                    return true;
                }
            }
            return false;
        }

        private final boolean findSuperuserApk() {
            return new File(Intrinsics.stringPlus(Environment.getRootDirectory().toString(), "/Superuser")).isDirectory();
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck$RootedCheck$Companion;", "", "()V", "BINARY_PATHS", "", "", "WARNING", "Lcom/stripe/android/stripe3ds2/init/Warning;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SecurityCheck.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck$Tampered;", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck;", "()V", "check", "", "hasValidFields", "hasValidMethods", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SecurityCheck.kt */
    public static final class Tampered extends SecurityCheck {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final Warning WARNING = new Warning("SW02", "The integrity of the SDK has been tampered.", Warning.Severity.HIGH);

        public Tampered() {
            super(WARNING, (DefaultConstructorMarker) null);
        }

        public boolean check() {
            return !hasValidFields() || !hasValidMethods();
        }

        private final boolean hasValidFields() {
            return StripeThreeDs2ServiceImpl.class.getDeclaredFields().length == 8;
        }

        private final boolean hasValidMethods() {
            return StripeThreeDs2ServiceImpl.class.getDeclaredMethods().length == 5;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck$Tampered$Companion;", "", "()V", "WARNING", "Lcom/stripe/android/stripe3ds2/init/Warning;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SecurityCheck.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck$Emulator;", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck;", "()V", "isEmulator", "", "()Z", "check", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SecurityCheck.kt */
    public static final class Emulator extends SecurityCheck {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final Warning WARNING = new Warning("SW02", "An emulator is being used to run the App.", Warning.Severity.HIGH);

        public Emulator() {
            super(WARNING, (DefaultConstructorMarker) null);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0080, code lost:
            if (kotlin.text.StringsKt.startsWith$default(r0, "generic", false, 2, (java.lang.Object) null) == false) goto L_0x0082;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final boolean isEmulator() {
            /*
                r7 = this;
                java.lang.String r0 = android.os.Build.FINGERPRINT
                java.lang.String r1 = "FINGERPRINT"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.String r2 = "generic"
                r3 = 0
                r4 = 2
                r5 = 0
                boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r2, r3, r4, r5)
                if (r0 != 0) goto L_0x008a
                java.lang.String r0 = android.os.Build.FINGERPRINT
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.String r1 = "unknown"
                boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r1, r3, r4, r5)
                if (r0 != 0) goto L_0x008a
                java.lang.String r0 = android.os.Build.MODEL
                java.lang.String r1 = "MODEL"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r6 = "Emulator"
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r6, (boolean) r3, (int) r4, (java.lang.Object) r5)
                if (r0 != 0) goto L_0x008a
                java.lang.String r0 = android.os.Build.MODEL
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r6 = "Android SDK built for x86"
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r6, (boolean) r3, (int) r4, (java.lang.Object) r5)
                if (r0 != 0) goto L_0x008a
                java.lang.String r0 = android.os.Build.MODEL
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r1 = "google_sdk"
                r6 = r1
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r6, (boolean) r3, (int) r4, (java.lang.Object) r5)
                if (r0 != 0) goto L_0x008a
                java.lang.String r0 = android.os.Build.MANUFACTURER
                java.lang.String r6 = "MANUFACTURER"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r6 = "Genymotion"
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r6, (boolean) r3, (int) r4, (java.lang.Object) r5)
                if (r0 != 0) goto L_0x008a
                java.lang.String r0 = android.os.Build.BRAND
                java.lang.String r6 = "BRAND"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
                boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r2, r3, r4, r5)
                if (r0 == 0) goto L_0x0082
                java.lang.String r0 = android.os.Build.DEVICE
                java.lang.String r6 = "DEVICE"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
                boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r2, r3, r4, r5)
                if (r0 != 0) goto L_0x008a
            L_0x0082:
                java.lang.String r0 = android.os.Build.PRODUCT
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x008b
            L_0x008a:
                r3 = 1
            L_0x008b:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.init.SecurityCheck.Emulator.isEmulator():boolean");
        }

        public boolean check() {
            return isEmulator();
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck$Emulator$Companion;", "", "()V", "WARNING", "Lcom/stripe/android/stripe3ds2/init/Warning;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SecurityCheck.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck$DebuggerAttached;", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck;", "isDebuggerConnected", "", "(Z)V", "()Z", "check", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SecurityCheck.kt */
    public static final class DebuggerAttached extends SecurityCheck {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final Warning WARNING = new Warning("SW04", "A debugger is attached to the App.", Warning.Severity.MEDIUM);
        private final boolean isDebuggerConnected;

        public DebuggerAttached() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DebuggerAttached(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Debug.isDebuggerConnected() : z);
        }

        public final boolean isDebuggerConnected() {
            return this.isDebuggerConnected;
        }

        public DebuggerAttached(boolean z) {
            super(WARNING, (DefaultConstructorMarker) null);
            this.isDebuggerConnected = z;
        }

        public boolean check() {
            return this.isDebuggerConnected;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck$DebuggerAttached$Companion;", "", "()V", "WARNING", "Lcom/stripe/android/stripe3ds2/init/Warning;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SecurityCheck.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck$UnsupportedOS;", "Lcom/stripe/android/stripe3ds2/init/SecurityCheck;", "()V", "check", "", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SecurityCheck.kt */
    public static final class UnsupportedOS extends SecurityCheck {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final Warning WARNING = new Warning("SW05", "The OS or the OS version is not supported.", Warning.Severity.HIGH);

        public boolean check() {
            return false;
        }

        public UnsupportedOS() {
            super(WARNING, (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/SecurityCheck$UnsupportedOS$Companion;", "", "()V", "WARNING", "Lcom/stripe/android/stripe3ds2/init/Warning;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SecurityCheck.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}

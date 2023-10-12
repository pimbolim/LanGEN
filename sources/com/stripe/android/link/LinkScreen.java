package com.stripe.android.link;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/link/LinkScreen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Loading", "PaymentMethod", "SignUp", "Verification", "Wallet", "Lcom/stripe/android/link/LinkScreen$Loading;", "Lcom/stripe/android/link/LinkScreen$Verification;", "Lcom/stripe/android/link/LinkScreen$Wallet;", "Lcom/stripe/android/link/LinkScreen$PaymentMethod;", "Lcom/stripe/android/link/LinkScreen$SignUp;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkScreen.kt */
public abstract class LinkScreen {
    private final String route;

    public /* synthetic */ LinkScreen(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private LinkScreen(String str) {
        this.route = str;
    }

    public String getRoute() {
        return this.route;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/link/LinkScreen$Loading;", "Lcom/stripe/android/link/LinkScreen;", "()V", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkScreen.kt */
    public static final class Loading extends LinkScreen {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super("Loading", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/link/LinkScreen$Verification;", "Lcom/stripe/android/link/LinkScreen;", "()V", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkScreen.kt */
    public static final class Verification extends LinkScreen {
        public static final int $stable = 0;
        public static final Verification INSTANCE = new Verification();

        private Verification() {
            super("Verification", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/link/LinkScreen$Wallet;", "Lcom/stripe/android/link/LinkScreen;", "()V", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkScreen.kt */
    public static final class Wallet extends LinkScreen {
        public static final int $stable = 0;
        public static final Wallet INSTANCE = new Wallet();

        private Wallet() {
            super("Wallet", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/link/LinkScreen$PaymentMethod;", "Lcom/stripe/android/link/LinkScreen;", "()V", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkScreen.kt */
    public static final class PaymentMethod extends LinkScreen {
        public static final int $stable = 0;
        public static final PaymentMethod INSTANCE = new PaymentMethod();

        private PaymentMethod() {
            super("PaymentMethod", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\b\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/stripe/android/link/LinkScreen$SignUp;", "Lcom/stripe/android/link/LinkScreen;", "email", "", "(Ljava/lang/String;)V", "route", "getRoute", "()Ljava/lang/String;", "route$1", "Companion", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkScreen.kt */
    public static final class SignUp extends LinkScreen {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String emailArg = "email";
        public static final String route = "SignUp?email={email}";
        private final String route$1;

        public SignUp() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SignUp(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SignUp(java.lang.String r4) {
            /*
                r3 = this;
                r0 = 0
                if (r4 != 0) goto L_0x0005
                r4 = r0
                goto L_0x001d
            L_0x0005:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r4)
                r2 = 61
                r1.append(r2)
                java.lang.String r4 = com.stripe.android.link.LinkScreenKt.urlEncode(r4)
                r1.append(r4)
                java.lang.String r4 = r1.toString()
            L_0x001d:
                java.lang.String r1 = "SignUp?"
                java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r4)
                r3.<init>(r4, r0)
                java.lang.String r4 = com.stripe.android.link.LinkScreen.super.getRoute()
                r3.route$1 = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.LinkScreen.SignUp.<init>(java.lang.String):void");
        }

        public String getRoute() {
            return this.route$1;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/link/LinkScreen$SignUp$Companion;", "", "()V", "emailArg", "", "route", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkScreen.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}

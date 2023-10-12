package com.stripe.android.core.networking;

import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.networking.StripeConnection;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bJ\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¨\u0006\f"}, d2 = {"Lcom/stripe/android/core/networking/ConnectionFactory;", "", "create", "Lcom/stripe/android/core/networking/StripeConnection;", "", "request", "Lcom/stripe/android/core/networking/StripeRequest;", "createForFile", "Ljava/io/File;", "outputFile", "Companion", "Default", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionFactory.kt */
public interface ConnectionFactory {
    public static final /* synthetic */ Companion Companion = Companion.$$INSTANCE;

    StripeConnection<String> create(StripeRequest stripeRequest) throws IOException, InvalidRequestException;

    StripeConnection<File> createForFile(StripeRequest stripeRequest, File file) throws IOException, InvalidRequestException;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\r"}, d2 = {"Lcom/stripe/android/core/networking/ConnectionFactory$Default;", "Lcom/stripe/android/core/networking/ConnectionFactory;", "()V", "create", "Lcom/stripe/android/core/networking/StripeConnection;", "", "request", "Lcom/stripe/android/core/networking/StripeRequest;", "createForFile", "Ljava/io/File;", "outputFile", "openConnectionAndApplyFields", "Ljava/net/HttpURLConnection;", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionFactory.kt */
    public static final class Default implements ConnectionFactory {
        public static final int $stable = 0;
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        public /* synthetic */ StripeConnection create(StripeRequest stripeRequest) throws IOException, InvalidRequestException {
            Intrinsics.checkNotNullParameter(stripeRequest, "request");
            return new StripeConnection.Default(openConnectionAndApplyFields(stripeRequest));
        }

        public StripeConnection<File> createForFile(StripeRequest stripeRequest, File file) {
            Intrinsics.checkNotNullParameter(stripeRequest, "request");
            Intrinsics.checkNotNullParameter(file, "outputFile");
            return new StripeConnection.FileConnection(openConnectionAndApplyFields(stripeRequest), file);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00aa, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ab, code lost:
            kotlin.io.CloseableKt.closeFinally(r1, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ae, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.net.HttpURLConnection openConnectionAndApplyFields(com.stripe.android.core.networking.StripeRequest r6) {
            /*
                r5 = this;
                java.net.URL r0 = new java.net.URL
                java.lang.String r1 = r6.getUrl()
                r0.<init>(r1)
                java.net.URLConnection r0 = r0.openConnection()
                java.lang.String r1 = "null cannot be cast to non-null type java.net.HttpURLConnection"
                java.util.Objects.requireNonNull(r0, r1)
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
                int r1 = com.stripe.android.core.networking.ConnectionFactory.Companion.CONNECT_TIMEOUT
                r0.setConnectTimeout(r1)
                int r1 = com.stripe.android.core.networking.ConnectionFactory.Companion.READ_TIMEOUT
                r0.setReadTimeout(r1)
                r1 = 0
                r0.setUseCaches(r1)
                com.stripe.android.core.networking.StripeRequest$Method r1 = r6.getMethod()
                java.lang.String r1 = r1.getCode()
                r0.setRequestMethod(r1)
                java.util.Map r1 = r6.getHeaders()
                java.util.Set r1 = r1.entrySet()
                java.util.Iterator r1 = r1.iterator()
            L_0x003d:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0059
                java.lang.Object r2 = r1.next()
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2
                java.lang.Object r3 = r2.getKey()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r2 = r2.getValue()
                java.lang.String r2 = (java.lang.String) r2
                r0.setRequestProperty(r3, r2)
                goto L_0x003d
            L_0x0059:
                com.stripe.android.core.networking.StripeRequest$Method r1 = com.stripe.android.core.networking.StripeRequest.Method.POST
                com.stripe.android.core.networking.StripeRequest$Method r2 = r6.getMethod()
                if (r1 != r2) goto L_0x00af
                r1 = 1
                r0.setDoOutput(r1)
                java.util.Map r1 = r6.getPostHeaders()
                if (r1 != 0) goto L_0x006c
                goto L_0x0090
            L_0x006c:
                java.util.Set r1 = r1.entrySet()
                java.util.Iterator r1 = r1.iterator()
            L_0x0074:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0090
                java.lang.Object r2 = r1.next()
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2
                java.lang.Object r3 = r2.getKey()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r2 = r2.getValue()
                java.lang.String r2 = (java.lang.String) r2
                r0.setRequestProperty(r3, r2)
                goto L_0x0074
            L_0x0090:
                java.io.OutputStream r1 = r0.getOutputStream()
                java.io.Closeable r1 = (java.io.Closeable) r1
                r2 = 0
                r3 = r1
                java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x00a8 }
                java.lang.String r4 = "output"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x00a8 }
                r6.writePostBody(r3)     // Catch:{ all -> 0x00a8 }
                kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a8 }
                kotlin.io.CloseableKt.closeFinally(r1, r2)
                goto L_0x00af
            L_0x00a8:
                r6 = move-exception
                throw r6     // Catch:{ all -> 0x00aa }
            L_0x00aa:
                r0 = move-exception
                kotlin.io.CloseableKt.closeFinally(r1, r6)
                throw r0
            L_0x00af:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.ConnectionFactory.Default.openConnectionAndApplyFields(com.stripe.android.core.networking.StripeRequest):java.net.HttpURLConnection");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/core/networking/ConnectionFactory$Companion;", "", "()V", "CONNECT_TIMEOUT", "", "READ_TIMEOUT", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionFactory.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        /* access modifiers changed from: private */
        public static final int CONNECT_TIMEOUT = ((int) TimeUnit.SECONDS.toMillis(30));
        /* access modifiers changed from: private */
        public static final int READ_TIMEOUT = ((int) TimeUnit.SECONDS.toMillis(80));

        private Companion() {
        }
    }
}

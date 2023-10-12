package com.stripe.android.core.networking;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u000f\u0010\u0011J\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eR\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/core/networking/StripeConnection;", "ResponseBodyType", "Ljava/io/Closeable;", "response", "Lcom/stripe/android/core/networking/StripeResponse;", "getResponse", "()Lcom/stripe/android/core/networking/StripeResponse;", "responseCode", "", "getResponseCode", "()I", "createBodyFromResponseStream", "responseStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)Ljava/lang/Object;", "AbstractConnection", "Default", "FileConnection", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeConnection.kt */
public interface StripeConnection<ResponseBodyType> extends Closeable {
    ResponseBodyType createBodyFromResponseStream(InputStream inputStream);

    StripeResponse<ResponseBodyType> getResponse();

    int getResponseCode();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u0014*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/core/networking/StripeConnection$AbstractConnection;", "ResponseBodyType", "Lcom/stripe/android/core/networking/StripeConnection;", "conn", "Ljava/net/HttpURLConnection;", "(Ljava/net/HttpURLConnection;)V", "response", "Lcom/stripe/android/core/networking/StripeResponse;", "getResponse", "()Lcom/stripe/android/core/networking/StripeResponse;", "responseCode", "", "getResponseCode", "()I", "responseStream", "Ljava/io/InputStream;", "getResponseStream", "()Ljava/io/InputStream;", "close", "", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeConnection.kt */
    public static abstract class AbstractConnection<ResponseBodyType> implements StripeConnection<ResponseBodyType> {
        public static final int $stable = 8;
        /* access modifiers changed from: private */
        public static final String CHARSET = StandardCharsets.UTF_8.name();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final HttpURLConnection conn;

        public AbstractConnection(HttpURLConnection httpURLConnection) {
            Intrinsics.checkNotNullParameter(httpURLConnection, "conn");
            this.conn = httpURLConnection;
        }

        public /* synthetic */ int getResponseCode() {
            return this.conn.getResponseCode();
        }

        public /* synthetic */ StripeResponse getResponse() throws IOException {
            int responseCode = getResponseCode();
            Object createBodyFromResponseStream = createBodyFromResponseStream(getResponseStream());
            Map headerFields = this.conn.getHeaderFields();
            Intrinsics.checkNotNullExpressionValue(headerFields, "conn.headerFields");
            return new StripeResponse(responseCode, createBodyFromResponseStream, headerFields);
        }

        private final InputStream getResponseStream() throws IOException {
            int responseCode = getResponseCode();
            boolean z = false;
            if (200 <= responseCode && responseCode < 300) {
                z = true;
            }
            if (z) {
                return this.conn.getInputStream();
            }
            return this.conn.getErrorStream();
        }

        public void close() {
            InputStream responseStream = getResponseStream();
            if (responseStream != null) {
                responseStream.close();
            }
            this.conn.disconnect();
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/core/networking/StripeConnection$AbstractConnection$Companion;", "", "()V", "CHARSET", "", "kotlin.jvm.PlatformType", "getCHARSET$stripe_core_release", "()Ljava/lang/String;", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeConnection.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String getCHARSET$stripe_core_release() {
                return AbstractConnection.CHARSET;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/stripe/android/core/networking/StripeConnection$Default;", "Lcom/stripe/android/core/networking/StripeConnection$AbstractConnection;", "", "conn", "Ljava/net/HttpURLConnection;", "(Ljava/net/HttpURLConnection;)V", "createBodyFromResponseStream", "responseStream", "Ljava/io/InputStream;", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeConnection.kt */
    public static final class Default extends AbstractConnection<String> {
        public static final int $stable = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Default(HttpURLConnection httpURLConnection) {
            super(httpURLConnection);
            Intrinsics.checkNotNullParameter(httpURLConnection, "conn");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
            kotlin.io.CloseableKt.closeFinally(r1, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String createBodyFromResponseStream(java.io.InputStream r5) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                if (r5 != 0) goto L_0x0004
                return r0
            L_0x0004:
                r1 = r5
                java.io.Closeable r1 = (java.io.Closeable) r1
                r2 = r1
                java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x002d }
                java.util.Scanner r2 = new java.util.Scanner     // Catch:{ all -> 0x002d }
                com.stripe.android.core.networking.StripeConnection$AbstractConnection$Companion r3 = com.stripe.android.core.networking.StripeConnection.AbstractConnection.Companion     // Catch:{ all -> 0x002d }
                java.lang.String r3 = r3.getCHARSET$stripe_core_release()     // Catch:{ all -> 0x002d }
                r2.<init>(r5, r3)     // Catch:{ all -> 0x002d }
                java.lang.String r5 = "\\A"
                java.util.Scanner r5 = r2.useDelimiter(r5)     // Catch:{ all -> 0x002d }
                boolean r2 = r5.hasNext()     // Catch:{ all -> 0x002d }
                if (r2 == 0) goto L_0x0026
                java.lang.String r5 = r5.next()     // Catch:{ all -> 0x002d }
                goto L_0x0029
            L_0x0026:
                r5 = r0
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x002d }
            L_0x0029:
                kotlin.io.CloseableKt.closeFinally(r1, r0)
                return r5
            L_0x002d:
                r5 = move-exception
                throw r5     // Catch:{ all -> 0x002f }
            L_0x002f:
                r0 = move-exception
                kotlin.io.CloseableKt.closeFinally(r1, r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.StripeConnection.Default.createBodyFromResponseStream(java.io.InputStream):java.lang.String");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/core/networking/StripeConnection$FileConnection;", "Lcom/stripe/android/core/networking/StripeConnection$AbstractConnection;", "Ljava/io/File;", "conn", "Ljava/net/HttpURLConnection;", "outputFile", "(Ljava/net/HttpURLConnection;Ljava/io/File;)V", "createBodyFromResponseStream", "responseStream", "Ljava/io/InputStream;", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeConnection.kt */
    public static final class FileConnection extends AbstractConnection<File> {
        public static final int $stable = 8;
        private final File outputFile;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FileConnection(HttpURLConnection httpURLConnection, File file) {
            super(httpURLConnection);
            Intrinsics.checkNotNullParameter(httpURLConnection, "conn");
            Intrinsics.checkNotNullParameter(file, "outputFile");
            this.outputFile = file;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            kotlin.io.CloseableKt.closeFinally(r2, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x002f, code lost:
            kotlin.io.CloseableKt.closeFinally(r7, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.File createBodyFromResponseStream(java.io.InputStream r7) throws java.io.IOException {
            /*
                r6 = this;
                r0 = 0
                if (r7 != 0) goto L_0x0004
                return r0
            L_0x0004:
                java.io.Closeable r7 = (java.io.Closeable) r7
                r1 = r7
                java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x002c }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x002c }
                java.io.File r3 = r6.outputFile     // Catch:{ all -> 0x002c }
                r2.<init>(r3)     // Catch:{ all -> 0x002c }
                java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x002c }
                r3 = r2
                java.io.FileOutputStream r3 = (java.io.FileOutputStream) r3     // Catch:{ all -> 0x0025 }
                java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x0025 }
                r4 = 0
                r5 = 2
                kotlin.io.ByteStreamsKt.copyTo$default(r1, r3, r4, r5, r0)     // Catch:{ all -> 0x0025 }
                kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x002c }
                kotlin.io.CloseableKt.closeFinally(r7, r0)
                java.io.File r7 = r6.outputFile
                return r7
            L_0x0025:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0027 }
            L_0x0027:
                r1 = move-exception
                kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x002c }
                throw r1     // Catch:{ all -> 0x002c }
            L_0x002c:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x002e }
            L_0x002e:
                r1 = move-exception
                kotlin.io.CloseableKt.closeFinally(r7, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.StripeConnection.FileConnection.createBodyFromResponseStream(java.io.InputStream):java.io.File");
        }
    }
}

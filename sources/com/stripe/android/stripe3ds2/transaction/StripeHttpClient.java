package com.stripe.android.stripe3ds2.transaction;

import androidx.browser.trusted.sharing.ShareTarget;
import com.stripe.android.core.networking.NetworkConstantsKt;
import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002!\"B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0015\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\fH\u0001¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeHttpClient;", "Lcom/stripe/android/stripe3ds2/transaction/HttpClient;", "url", "", "connectionFactory", "Lcom/stripe/android/stripe3ds2/transaction/StripeHttpClient$ConnectionFactory;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/StripeHttpClient$ConnectionFactory;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lkotlin/coroutines/CoroutineContext;)V", "createConnection", "Ljava/net/HttpURLConnection;", "createGetConnection", "createPostConnection", "requestBody", "contentType", "doGetRequest", "Ljava/io/InputStream;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doPostRequest", "Lcom/stripe/android/stripe3ds2/transaction/HttpResponse;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doPostRequestInternal", "getResponseBody", "inputStream", "handlePostResponse", "conn", "handlePostResponse$3ds2sdk_release", "isSuccessfulResponse", "", "responseCode", "", "ConnectionFactory", "DefaultConnectionFactory", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeHttpClient.kt */
public final class StripeHttpClient implements HttpClient {
    private final ConnectionFactory connectionFactory;
    /* access modifiers changed from: private */
    public final ErrorReporter errorReporter;
    private final String url;
    private final CoroutineContext workContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeHttpClient$ConnectionFactory;", "", "create", "Ljava/net/HttpURLConnection;", "url", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeHttpClient.kt */
    public interface ConnectionFactory {
        HttpURLConnection create(String str);
    }

    private final boolean isSuccessfulResponse(int i) {
        return 200 <= i && i < 300;
    }

    public StripeHttpClient(String str, ConnectionFactory connectionFactory2, ErrorReporter errorReporter2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(connectionFactory2, "connectionFactory");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.url = str;
        this.connectionFactory = connectionFactory2;
        this.errorReporter = errorReporter2;
        this.workContext = coroutineContext;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StripeHttpClient(String str, ConnectionFactory connectionFactory2, ErrorReporter errorReporter2, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new DefaultConnectionFactory() : connectionFactory2, errorReporter2, coroutineContext);
    }

    public Object doGetRequest(Continuation<? super InputStream> continuation) {
        return BuildersKt.withContext(this.workContext, new StripeHttpClient$doGetRequest$2(this, (Continuation<? super StripeHttpClient$doGetRequest$2>) null), continuation);
    }

    public Object doPostRequest(String str, String str2, Continuation<? super HttpResponse> continuation) {
        return BuildersKt.withContext(this.workContext, new StripeHttpClient$doPostRequest$2(this, str, str2, (Continuation<? super StripeHttpClient$doPostRequest$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.stripe.android.stripe3ds2.transaction.HttpResponse doPostRequestInternal(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.net.HttpURLConnection r7 = r5.createPostConnection(r6, r7)
            java.io.OutputStream r0 = r7.getOutputStream()
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            java.io.OutputStream r1 = (java.io.OutputStream) r1     // Catch:{ all -> 0x0043 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "os"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x0043 }
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0043 }
            java.lang.String r4 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x0043 }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0043 }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x0043 }
            r1 = r2
            java.io.OutputStreamWriter r1 = (java.io.OutputStreamWriter) r1     // Catch:{ all -> 0x003c }
            r1.write(r6)     // Catch:{ all -> 0x003c }
            r1.flush()     // Catch:{ all -> 0x003c }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003c }
            r6 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r6)     // Catch:{ all -> 0x0043 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0043 }
            kotlin.io.CloseableKt.closeFinally(r0, r6)
            r7.connect()
            com.stripe.android.stripe3ds2.transaction.HttpResponse r6 = r5.handlePostResponse$3ds2sdk_release(r7)
            return r6
        L_0x003c:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x003e }
        L_0x003e:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r6)     // Catch:{ all -> 0x0043 }
            throw r7     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transaction.StripeHttpClient.doPostRequestInternal(java.lang.String, java.lang.String):com.stripe.android.stripe3ds2.transaction.HttpResponse");
    }

    public final HttpResponse handlePostResponse$3ds2sdk_release(HttpURLConnection httpURLConnection) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "conn");
        int responseCode = httpURLConnection.getResponseCode();
        if (isSuccessfulResponse(responseCode)) {
            InputStream inputStream = httpURLConnection.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "conn.inputStream");
            return new HttpResponse(getResponseBody(inputStream), httpURLConnection.getContentType());
        }
        throw new SDKRuntimeException("Unsuccessful response code from " + this.url + ": " + responseCode, (Throwable) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getResponseBody(java.io.InputStream r4) {
        /*
            r3 = this;
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0038 }
            r1 = r3
            com.stripe.android.stripe3ds2.transaction.StripeHttpClient r1 = (com.stripe.android.stripe3ds2.transaction.StripeHttpClient) r1     // Catch:{ all -> 0x0038 }
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0038 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0038 }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x0038 }
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ all -> 0x0038 }
            r4 = 8192(0x2000, float:1.14794E-41)
            boolean r1 = r2 instanceof java.io.BufferedReader     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0018
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ all -> 0x0038 }
            goto L_0x001e
        L_0x0018:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0038 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0038 }
            r2 = r1
        L_0x001e:
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x0038 }
            r4 = r2
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4     // Catch:{ all -> 0x0031 }
            java.io.Reader r4 = (java.io.Reader) r4     // Catch:{ all -> 0x0031 }
            java.lang.String r4 = kotlin.io.TextStreamsKt.readText(r4)     // Catch:{ all -> 0x0031 }
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x0038 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)     // Catch:{ all -> 0x0038 }
            goto L_0x0043
        L_0x0031:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ all -> 0x0038 }
            throw r1     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r4 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x0043:
            boolean r1 = kotlin.Result.m4715isFailureimpl(r4)
            if (r1 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r0 = r4
        L_0x004b:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0051
            java.lang.String r0 = ""
        L_0x0051:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transaction.StripeHttpClient.getResponseBody(java.io.InputStream):java.lang.String");
    }

    private final HttpURLConnection createPostConnection(String str, String str2) {
        HttpURLConnection createConnection = createConnection();
        createConnection.setRequestMethod(ShareTarget.METHOD_POST);
        createConnection.setDoOutput(true);
        createConnection.setRequestProperty(NetworkConstantsKt.HEADER_CONTENT_TYPE, str2);
        createConnection.setRequestProperty("Content-Length", String.valueOf(str.length()));
        return createConnection;
    }

    /* access modifiers changed from: private */
    public final HttpURLConnection createGetConnection() {
        HttpURLConnection createConnection = createConnection();
        createConnection.setDoInput(true);
        return createConnection;
    }

    private final HttpURLConnection createConnection() {
        return this.connectionFactory.create(this.url);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeHttpClient$DefaultConnectionFactory;", "Lcom/stripe/android/stripe3ds2/transaction/StripeHttpClient$ConnectionFactory;", "()V", "create", "Ljava/net/HttpURLConnection;", "url", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeHttpClient.kt */
    private static final class DefaultConnectionFactory implements ConnectionFactory {
        public HttpURLConnection create(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            URLConnection openConnection = new URL(str).openConnection();
            Objects.requireNonNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            return (HttpURLConnection) openConnection;
        }
    }
}

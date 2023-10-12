package com.stripe.android.core.networking;

import com.stripe.android.core.AppInfo;
import com.stripe.android.core.model.StripeFileParams;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.RequestHeadersFactory;
import com.stripe.android.core.networking.StripeRequest;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 32\u00020\u0001:\u00013B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0004J\u0010\u0010.\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010/\u001a\u00020+2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\tH\u0004R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\"\u0010\fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\f¨\u00064"}, d2 = {"Lcom/stripe/android/core/networking/FileUploadRequest;", "Lcom/stripe/android/core/networking/StripeRequest;", "fileParams", "Lcom/stripe/android/core/model/StripeFileParams;", "options", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "appInfo", "Lcom/stripe/android/core/AppInfo;", "boundary", "", "(Lcom/stripe/android/core/model/StripeFileParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lcom/stripe/android/core/AppInfo;Ljava/lang/String;)V", "getBoundary", "()Ljava/lang/String;", "fileMetadata", "getFileMetadata", "headers", "", "getHeaders", "()Ljava/util/Map;", "headersFactory", "Lcom/stripe/android/core/networking/RequestHeadersFactory;", "method", "Lcom/stripe/android/core/networking/StripeRequest$Method;", "getMethod", "()Lcom/stripe/android/core/networking/StripeRequest$Method;", "mimeType", "Lcom/stripe/android/core/networking/StripeRequest$MimeType;", "getMimeType", "()Lcom/stripe/android/core/networking/StripeRequest$MimeType;", "postHeaders", "getPostHeaders", "setPostHeaders", "(Ljava/util/Map;)V", "purposeContents", "getPurposeContents", "retryResponseCodes", "", "", "getRetryResponseCodes", "()Ljava/lang/Iterable;", "url", "getUrl", "writeFile", "", "outputStream", "Ljava/io/OutputStream;", "writePostBody", "writeString", "writer", "Ljava/io/PrintWriter;", "contents", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileUploadRequest.kt */
public class FileUploadRequest extends StripeRequest {
    public static final int $stable = 8;
    protected static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HOST = "https://files.stripe.com/v1/files";
    public static final String LINE_BREAK = "\r\n";
    private final String boundary;
    private final StripeFileParams fileParams;
    private final Map<String, String> headers;
    private final RequestHeadersFactory headersFactory;
    private final StripeRequest.Method method;
    private final StripeRequest.MimeType mimeType;
    private Map<String, String> postHeaders;
    private final Iterable<Integer> retryResponseCodes;
    private final String url;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileUploadRequest(StripeFileParams stripeFileParams, ApiRequest.Options options, AppInfo appInfo, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stripeFileParams, options, (i & 4) != 0 ? null : appInfo, (i & 8) != 0 ? Companion.createBoundary() : str);
    }

    /* access modifiers changed from: protected */
    public final String getBoundary() {
        return this.boundary;
    }

    public FileUploadRequest(StripeFileParams stripeFileParams, ApiRequest.Options options, AppInfo appInfo, String str) {
        Intrinsics.checkNotNullParameter(stripeFileParams, "fileParams");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(str, "boundary");
        this.fileParams = stripeFileParams;
        this.boundary = str;
        RequestHeadersFactory fileUpload = new RequestHeadersFactory.FileUpload(options, appInfo, (Locale) null, (String) null, (String) null, str, 28, (DefaultConstructorMarker) null);
        this.headersFactory = fileUpload;
        this.method = StripeRequest.Method.POST;
        this.mimeType = StripeRequest.MimeType.MultipartForm;
        this.url = HOST;
        this.retryResponseCodes = NetworkConstantsKt.getDEFAULT_RETRY_CODES();
        this.headers = fileUpload.create();
        this.postHeaders = fileUpload.createPostHeader();
    }

    public StripeRequest.Method getMethod() {
        return this.method;
    }

    public StripeRequest.MimeType getMimeType() {
        return this.mimeType;
    }

    public String getUrl() {
        return this.url;
    }

    public Iterable<Integer> getRetryResponseCodes() {
        return this.retryResponseCodes;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Map<String, String> getPostHeaders() {
        return this.postHeaders;
    }

    public void setPostHeaders(Map<String, String> map) {
        this.postHeaders = map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writePostBody(java.io.OutputStream r6) {
        /*
            r5 = this;
            java.lang.String r0 = "--"
            java.lang.String r1 = "outputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter
            r2.<init>(r6, r1)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r1 = r2
            java.io.OutputStreamWriter r1 = (java.io.OutputStreamWriter) r1     // Catch:{ all -> 0x0065 }
            java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch:{ all -> 0x0065 }
            java.io.Writer r1 = (java.io.Writer) r1     // Catch:{ all -> 0x0065 }
            r4 = 1
            r3.<init>(r1, r4)     // Catch:{ all -> 0x0065 }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x0065 }
            r1 = r3
            java.io.PrintWriter r1 = (java.io.PrintWriter) r1     // Catch:{ all -> 0x005e }
            java.lang.String r4 = r5.getPurposeContents()     // Catch:{ all -> 0x005e }
            r5.writeString(r1, r4)     // Catch:{ all -> 0x005e }
            java.lang.String r4 = r5.getFileMetadata()     // Catch:{ all -> 0x005e }
            r5.writeString(r1, r4)     // Catch:{ all -> 0x005e }
            r5.writeFile(r6)     // Catch:{ all -> 0x005e }
            java.lang.String r6 = "\r\n"
            r1.write(r6)     // Catch:{ all -> 0x005e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r6.<init>()     // Catch:{ all -> 0x005e }
            r6.append(r0)     // Catch:{ all -> 0x005e }
            java.lang.String r4 = r5.getBoundary()     // Catch:{ all -> 0x005e }
            r6.append(r4)     // Catch:{ all -> 0x005e }
            r6.append(r0)     // Catch:{ all -> 0x005e }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x005e }
            r1.write(r6)     // Catch:{ all -> 0x005e }
            r1.flush()     // Catch:{ all -> 0x005e }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005e }
            r6 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r6)     // Catch:{ all -> 0x0065 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0065 }
            kotlin.io.CloseableKt.closeFinally(r2, r6)
            return
        L_0x005e:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r6)     // Catch:{ all -> 0x0065 }
            throw r0     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.FileUploadRequest.writePostBody(java.io.OutputStream):void");
    }

    /* access modifiers changed from: protected */
    public final void writeString(PrintWriter printWriter, String str) {
        Intrinsics.checkNotNullParameter(printWriter, "writer");
        Intrinsics.checkNotNullParameter(str, "contents");
        printWriter.write(StringsKt.replace$default(str, "\n", LINE_BREAK, false, 4, (Object) null));
        printWriter.flush();
    }

    /* access modifiers changed from: protected */
    public final void writeFile(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        ByteStreamsKt.copyTo$default(new FileInputStream(this.fileParams.getFile$stripe_core_release()), outputStream, 0, 2, (Object) null);
    }

    public final String getFileMetadata() {
        String name = this.fileParams.getFile$stripe_core_release().getName();
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(name);
        return StringsKt.trimIndent("\n                --" + this.boundary + "\n                Content-Disposition: form-data; name=\"file\"; filename=\"" + name + "\"\n                Content-Type: " + guessContentTypeFromName + "\n                Content-Transfer-Encoding: binary\n\n\n            ");
    }

    public final String getPurposeContents() {
        return StringsKt.trimIndent("\n                --" + this.boundary + "\n                Content-Disposition: form-data; name=\"purpose\"\n\n                " + this.fileParams.getPurpose$stripe_core_release().getCode() + "\n\n            ");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/core/networking/FileUploadRequest$Companion;", "", "()V", "HOST", "", "LINE_BREAK", "createBoundary", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FileUploadRequest.kt */
    protected static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final String createBoundary() {
            return String.valueOf(Random.Default.nextLong(0, Long.MAX_VALUE));
        }
    }
}

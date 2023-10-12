package com.stripe.android.stripe3ds2.observability;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.henninghall.date_picker.props.LocaleProp;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.stripe.android.core.networking.AnalyticsFields;
import com.stripe.android.model.Stripe3ds2AuthParams;
import com.stripe.android.stripe3ds2.transaction.Logger;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0003,-.BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\b\u0018J\r\u0010\u0019\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\rH\u0001¢\u0006\u0002\b\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0010H\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/stripe/android/stripe3ds2/observability/DefaultErrorReporter;", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "context", "Landroid/content/Context;", "config", "Lcom/stripe/android/stripe3ds2/observability/DefaultErrorReporter$Config;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "logger", "Lcom/stripe/android/stripe3ds2/transaction/Logger;", "sentryConfig", "Lcom/stripe/android/stripe3ds2/observability/SentryConfig;", "environment", "", "localeCountry", "osVersion", "", "(Landroid/content/Context;Lcom/stripe/android/stripe3ds2/observability/DefaultErrorReporter$Config;Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/stripe3ds2/transaction/Logger;Lcom/stripe/android/stripe3ds2/observability/SentryConfig;Ljava/lang/String;Ljava/lang/String;I)V", "createPostConnection", "Ljavax/net/ssl/HttpsURLConnection;", "createRequestBody", "Lorg/json/JSONObject;", "t", "", "createRequestBody$3ds2sdk_release", "createRequestContexts", "createRequestContexts$3ds2sdk_release", "createRequestStacktrace", "createRequestStacktrace$3ds2sdk_release", "createSentryAuthHeader", "createSentryAuthHeader$3ds2sdk_release", "getResponseBody", "responseStream", "Ljava/io/InputStream;", "logResponse", "", "connection", "responseCode", "onFailure", "exception", "openConnection", "reportError", "send", "requestBody", "Companion", "Config", "EmptyConfig", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultErrorReporter.kt */
public final class DefaultErrorReporter implements ErrorReporter {
    @Deprecated
    private static final String CHARSET = StandardCharsets.UTF_8.name();
    @Deprecated
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    @Deprecated
    private static final String HEADER_SENTRY_AUTH = "X-Sentry-Auth";
    @Deprecated
    private static final String HEADER_USER_AGENT = "User-Agent";
    @Deprecated
    private static final String HOST = "https://errors.stripe.com";
    @Deprecated
    private static final String HTTP_METHOD = "POST";
    @Deprecated
    private static final String USER_AGENT = "Android3ds2Sdk 6.1.5";
    private final Config config;
    private final Context context;
    private final String environment;
    private final String localeCountry;
    private final Logger logger;
    private final int osVersion;
    private final SentryConfig sentryConfig;
    private final CoroutineContext workContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/observability/DefaultErrorReporter$Config;", "", "customTags", "", "", "getCustomTags", "()Ljava/util/Map;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultErrorReporter.kt */
    public interface Config {
        Map<String, String> getCustomTags();
    }

    private final void logResponse(HttpsURLConnection httpsURLConnection, int i) {
    }

    public DefaultErrorReporter(Context context2, Config config2, CoroutineContext coroutineContext, Logger logger2, SentryConfig sentryConfig2, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(sentryConfig2, "sentryConfig");
        Intrinsics.checkNotNullParameter(str, "environment");
        Intrinsics.checkNotNullParameter(str2, "localeCountry");
        this.context = context2;
        this.config = config2;
        this.workContext = coroutineContext;
        this.logger = logger2;
        this.sentryConfig = sentryConfig2;
        this.environment = str;
        this.localeCountry = str2;
        this.osVersion = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DefaultErrorReporter(android.content.Context r9, com.stripe.android.stripe3ds2.observability.DefaultErrorReporter.Config r10, kotlin.coroutines.CoroutineContext r11, com.stripe.android.stripe3ds2.transaction.Logger r12, com.stripe.android.stripe3ds2.observability.SentryConfig r13, java.lang.String r14, java.lang.String r15, int r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r8 = this;
            r0 = r17
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000b
            com.stripe.android.stripe3ds2.observability.DefaultErrorReporter$EmptyConfig r1 = com.stripe.android.stripe3ds2.observability.DefaultErrorReporter.EmptyConfig.INSTANCE
            com.stripe.android.stripe3ds2.observability.DefaultErrorReporter$Config r1 = (com.stripe.android.stripe3ds2.observability.DefaultErrorReporter.Config) r1
            goto L_0x000c
        L_0x000b:
            r1 = r10
        L_0x000c:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0017
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            goto L_0x0018
        L_0x0017:
            r2 = r11
        L_0x0018:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x0021
            com.stripe.android.stripe3ds2.transaction.Logger$Noop r3 = com.stripe.android.stripe3ds2.transaction.Logger.Noop.INSTANCE
            com.stripe.android.stripe3ds2.transaction.Logger r3 = (com.stripe.android.stripe3ds2.transaction.Logger) r3
            goto L_0x0022
        L_0x0021:
            r3 = r12
        L_0x0022:
            r4 = r0 & 16
            if (r4 == 0) goto L_0x002b
            com.stripe.android.stripe3ds2.observability.DefaultSentryConfig r4 = com.stripe.android.stripe3ds2.observability.DefaultSentryConfig.INSTANCE
            com.stripe.android.stripe3ds2.observability.SentryConfig r4 = (com.stripe.android.stripe3ds2.observability.SentryConfig) r4
            goto L_0x002c
        L_0x002b:
            r4 = r13
        L_0x002c:
            r5 = r0 & 32
            if (r5 == 0) goto L_0x0033
            java.lang.String r5 = "release"
            goto L_0x0034
        L_0x0033:
            r5 = r14
        L_0x0034:
            r6 = r0 & 64
            if (r6 == 0) goto L_0x0046
            java.util.Locale r6 = java.util.Locale.getDefault()
            java.lang.String r6 = r6.getCountry()
            java.lang.String r7 = "getDefault().country"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            goto L_0x0047
        L_0x0046:
            r6 = r15
        L_0x0047:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x004e
            int r0 = android.os.Build.VERSION.SDK_INT
            goto L_0x0050
        L_0x004e:
            r0 = r16
        L_0x0050:
            r10 = r8
            r11 = r9
            r12 = r1
            r13 = r2
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.observability.DefaultErrorReporter.<init>(android.content.Context, com.stripe.android.stripe3ds2.observability.DefaultErrorReporter$Config, kotlin.coroutines.CoroutineContext, com.stripe.android.stripe3ds2.transaction.Logger, com.stripe.android.stripe3ds2.observability.SentryConfig, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public void reportError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new DefaultErrorReporter$reportError$1(this, th, (Continuation<? super DefaultErrorReporter$reportError$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void send(org.json.JSONObject r7) {
        /*
            r6 = this;
            javax.net.ssl.HttpsURLConnection r0 = r6.createPostConnection()
            java.io.OutputStream r1 = r0.getOutputStream()
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = r1
            java.io.OutputStream r2 = (java.io.OutputStream) r2     // Catch:{ all -> 0x004d }
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "os"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ all -> 0x004d }
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x004d }
            java.lang.String r5 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x004d }
            r3.<init>(r2, r4)     // Catch:{ all -> 0x004d }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x004d }
            r2 = r3
            java.io.OutputStreamWriter r2 = (java.io.OutputStreamWriter) r2     // Catch:{ all -> 0x0046 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0046 }
            r2.write(r7)     // Catch:{ all -> 0x0046 }
            r2.flush()     // Catch:{ all -> 0x0046 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0046 }
            r7 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r7)     // Catch:{ all -> 0x004d }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004d }
            kotlin.io.CloseableKt.closeFinally(r1, r7)
            r0.connect()
            int r7 = r0.getResponseCode()
            r6.logResponse(r0, r7)
            r0.disconnect()
            return
        L_0x0046:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r7)     // Catch:{ all -> 0x004d }
            throw r0     // Catch:{ all -> 0x004d }
        L_0x004d:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x004f }
        L_0x004f:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.observability.DefaultErrorReporter.send(org.json.JSONObject):void");
    }

    private final String getResponseBody(InputStream inputStream) {
        Object obj;
        String str;
        String str2 = null;
        try {
            Result.Companion companion = Result.Companion;
            DefaultErrorReporter defaultErrorReporter = this;
            Scanner useDelimiter = new Scanner(inputStream, CHARSET).useDelimiter("\\A");
            if (useDelimiter.hasNext()) {
                str = useDelimiter.next();
            } else {
                str = null;
            }
            inputStream.close();
            obj = Result.m4709constructorimpl(str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m4715isFailureimpl(obj)) {
            str2 = obj;
        }
        return str2;
    }

    private final HttpsURLConnection createPostConnection() {
        HttpsURLConnection openConnection = openConnection();
        openConnection.setRequestMethod("POST");
        openConnection.setDoOutput(true);
        for (Map.Entry entry : MapsKt.mapOf(TuplesKt.to("Content-Type", CONTENT_TYPE), TuplesKt.to("User-Agent", USER_AGENT), TuplesKt.to(HEADER_SENTRY_AUTH, createSentryAuthHeader$3ds2sdk_release())).entrySet()) {
            openConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        return openConnection;
    }

    private final HttpsURLConnection openConnection() {
        URLConnection openConnection = new URL("https://errors.stripe.com/api/" + this.sentryConfig.getProjectId() + "/store/").openConnection();
        Objects.requireNonNull(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        return (HttpsURLConnection) openConnection;
    }

    public final /* synthetic */ JSONObject createRequestBody$3ds2sdk_release(Throwable th) {
        Intrinsics.checkNotNullParameter(th, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT);
        JSONObject put = new JSONObject().put("release", "com.stripe.android.stripe3ds2@6.1.5+22");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject put2 = new JSONObject().put("type", th.getClass().getCanonicalName());
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        JSONObject put3 = put.put("exception", jSONObject.put("values", jSONArray.put(put2.put("value", message).put("stacktrace", createRequestStacktrace$3ds2sdk_release(th)))));
        JSONObject put4 = new JSONObject().put(LocaleProp.name, this.localeCountry).put("environment", this.environment).put("android_os_version", this.osVersion);
        for (Map.Entry next : this.config.getCustomTags().entrySet()) {
            put4.put((String) next.getKey(), (String) next.getValue());
        }
        Unit unit = Unit.INSTANCE;
        JSONObject put5 = put3.put("tags", put4).put("contexts", createRequestContexts$3ds2sdk_release());
        Intrinsics.checkNotNullExpressionValue(put5, "JSONObject()\n           … createRequestContexts())");
        return put5;
    }

    public final /* synthetic */ JSONObject createRequestContexts$3ds2sdk_release() {
        Object obj;
        CharSequence charSequence;
        ApplicationInfo applicationInfo;
        int i = 0;
        try {
            Result.Companion companion = Result.Companion;
            DefaultErrorReporter defaultErrorReporter = this;
            obj = Result.m4709constructorimpl(defaultErrorReporter.context.getPackageManager().getPackageInfo(defaultErrorReporter.context.getPackageName(), 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        String str = null;
        if (Result.m4715isFailureimpl(obj)) {
            obj = null;
        }
        PackageInfo packageInfo = (PackageInfo) obj;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            charSequence = null;
        } else {
            charSequence = applicationInfo.loadLabel(this.context.getPackageManager());
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject put = new JSONObject().put("app_identifier", this.context.getPackageName()).put(AnalyticsFields.APP_NAME, charSequence);
        if (packageInfo != null) {
            str = packageInfo.versionName;
        }
        if (str == null) {
            str = "";
        }
        JSONObject put2 = jSONObject.put(Stripe3ds2AuthParams.FIELD_APP, put.put(AnalyticsFields.APP_VERSION, str)).put("os", new JSONObject().put("name", "Android").put("version", Build.VERSION.RELEASE).put("type", Build.TYPE).put("build", Build.DISPLAY));
        JSONObject put3 = new JSONObject().put("model_id", Build.ID).put("model", Build.MODEL).put("manufacturer", Build.MANUFACTURER).put("type", Build.TYPE);
        JSONArray jSONArray = new JSONArray();
        String[] strArr = Build.SUPPORTED_ABIS;
        Intrinsics.checkNotNullExpressionValue(strArr, "SUPPORTED_ABIS");
        Object[] objArr = (Object[]) strArr;
        int length = objArr.length;
        while (i < length) {
            Object obj2 = objArr[i];
            i++;
            jSONArray.put((String) obj2);
        }
        Unit unit = Unit.INSTANCE;
        JSONObject put4 = put2.put("device", put3.put("archs", jSONArray));
        Intrinsics.checkNotNullExpressionValue(put4, "JSONObject()\n           …          )\n            )");
        return put4;
    }

    public final /* synthetic */ JSONObject createRequestStacktrace$3ds2sdk_release(Throwable th) {
        Intrinsics.checkNotNullParameter(th, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "t.stackTrace");
        for (StackTraceElement stackTraceElement : ArraysKt.reversed((T[]) (Object[]) stackTrace)) {
            jSONArray.put(new JSONObject().put("lineno", stackTraceElement.getLineNumber()).put("filename", stackTraceElement.getClassName()).put("function", stackTraceElement.getMethodName()));
        }
        Unit unit = Unit.INSTANCE;
        JSONObject put = jSONObject.put("frames", jSONArray);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …          }\n            )");
        return put;
    }

    public final /* synthetic */ String createSentryAuthHeader$3ds2sdk_release() {
        return CollectionsKt.joinToString$default(CollectionsKt.listOf("Sentry", CollectionsKt.joinToString$default(CollectionsKt.listOf(TuplesKt.to("sentry_key", this.sentryConfig.getKey()), TuplesKt.to("sentry_version", this.sentryConfig.getVersion()), TuplesKt.to("sentry_timestamp", this.sentryConfig.getTimestamp()), TuplesKt.to("sentry_client", USER_AGENT), TuplesKt.to("sentry_secret", this.sentryConfig.getSecret())), ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, DefaultErrorReporter$createSentryAuthHeader$1.INSTANCE, 30, (Object) null)), StringUtils.SPACE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onFailure(Throwable th) {
        this.logger.error("Failed to send error report.", th);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/observability/DefaultErrorReporter$EmptyConfig;", "Lcom/stripe/android/stripe3ds2/observability/DefaultErrorReporter$Config;", "()V", "customTags", "", "", "getCustomTags", "()Ljava/util/Map;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultErrorReporter.kt */
    public static final class EmptyConfig implements Config {
        public static final EmptyConfig INSTANCE = new EmptyConfig();
        private static final Map<String, String> customTags = MapsKt.emptyMap();

        private EmptyConfig() {
        }

        public Map<String, String> getCustomTags() {
            return customTags;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/stripe3ds2/observability/DefaultErrorReporter$Companion;", "", "()V", "CHARSET", "", "kotlin.jvm.PlatformType", "CONTENT_TYPE", "HEADER_CONTENT_TYPE", "HEADER_SENTRY_AUTH", "HEADER_USER_AGENT", "HOST", "HTTP_METHOD", "USER_AGENT", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultErrorReporter.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

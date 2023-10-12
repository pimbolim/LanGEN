package com.ReactNativeBlobUtil;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.ReactNativeBlobUtil.Utils.Tls12SocketFactory;
import com.braintreepayments.api.models.PostalAddressParser;
import com.drew.metadata.exif.makernotes.OlympusCameraSettingsMakernoteDirectory;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.stripe.android.core.networking.NetworkConstantsKt;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.TlsVersion;

public class ReactNativeBlobUtilReq extends BroadcastReceiver implements Runnable {
    public static HashMap<String, Long> androidDownloadManagerTaskTable = new HashMap<>();
    static ConnectionPool pool = new ConnectionPool();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> progressReport = new HashMap<>();
    public static HashMap<String, Call> taskTable = new HashMap<>();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> uploadProgressReport = new HashMap<>();
    private final int QUERY = OlympusCameraSettingsMakernoteDirectory.TagPictureModeHue;
    Callback callback;
    OkHttpClient client;
    long contentLength;
    String destPath;
    long downloadManagerId;
    /* access modifiers changed from: private */
    public Future<?> future;
    ReadableMap headers;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            Cursor query;
            if (message.what == 1314 && message.getData().getLong("downloadManagerId") == ReactNativeBlobUtilReq.this.downloadManagerId && (query = ((DownloadManager) ReactNativeBlobUtil.RCTContext.getApplicationContext().getSystemService("download")).query(new DownloadManager.Query())) != null && query.moveToFirst()) {
                long j = (long) query.getInt(query.getColumnIndex("bytes_so_far"));
                long j2 = query.getLong(query.getColumnIndex("total_size"));
                query.close();
                ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilReq.this.taskId);
                float f = j2 != -1 ? (float) (j / j2) : 0.0f;
                if (reportProgress != null && reportProgress.shouldReport(f)) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("taskId", String.valueOf(ReactNativeBlobUtilReq.this.taskId));
                    createMap.putString("written", String.valueOf(j));
                    createMap.putString("total", String.valueOf(j2));
                    createMap.putString("chunk", "");
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtil.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, createMap);
                }
                if (j2 == j) {
                    ReactNativeBlobUtilReq.this.future.cancel(true);
                }
            }
            return true;
        }
    });
    String method;
    ReactNativeBlobUtilConfig options;
    String rawRequestBody;
    ReadableArray rawRequestBodyArray;
    ArrayList<String> redirects = new ArrayList<>();
    ReactNativeBlobUtilBody requestBody;
    RequestType requestType;
    WritableMap respInfo;
    ResponseFormat responseFormat = ResponseFormat.Auto;
    ResponseType responseType;
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    String taskId;
    boolean timeout = false;
    String url;

    enum RequestType {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    enum ResponseFormat {
        Auto,
        UTF8,
        BASE64
    }

    enum ResponseType {
        KeepInMemory,
        FileStorage
    }

    private boolean shouldTransformFile() {
        return this.options.transformFile.booleanValue() && (this.options.fileCache.booleanValue() || this.options.path != null);
    }

    public ReactNativeBlobUtilReq(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, OkHttpClient okHttpClient, Callback callback2) {
        this.method = str2.toUpperCase(Locale.ROOT);
        ReactNativeBlobUtilConfig reactNativeBlobUtilConfig = new ReactNativeBlobUtilConfig(readableMap);
        this.options = reactNativeBlobUtilConfig;
        this.taskId = str;
        this.url = str3;
        this.headers = readableMap2;
        this.callback = callback2;
        this.rawRequestBody = str4;
        this.rawRequestBodyArray = readableArray;
        this.client = okHttpClient;
        if ((reactNativeBlobUtilConfig.fileCache.booleanValue() || this.options.path != null) && !shouldTransformFile()) {
            this.responseType = ResponseType.FileStorage;
        } else {
            this.responseType = ResponseType.KeepInMemory;
        }
        if (str4 != null) {
            this.requestType = RequestType.SingleFile;
        } else if (readableArray != null) {
            this.requestType = RequestType.Form;
        } else {
            this.requestType = RequestType.WithoutBody;
        }
    }

    public static void cancelTask(String str) {
        if (taskTable.containsKey(str)) {
            taskTable.get(str).cancel();
            taskTable.remove(str);
        }
        if (androidDownloadManagerTaskTable.containsKey(str)) {
            ((DownloadManager) ReactNativeBlobUtil.RCTContext.getApplicationContext().getSystemService("download")).remove(new long[]{androidDownloadManagerTaskTable.get(str).longValue()});
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:147:0x03a7 A[Catch:{ Exception -> 0x04ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0457 A[Catch:{ Exception -> 0x04ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x049f A[Catch:{ Exception -> 0x04ef }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = ";base64"
            java.lang.String r3 = "post"
            java.lang.String r4 = "Content-Type"
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r5 = "path"
            r6 = 2
            r7 = 1
            if (r0 == 0) goto L_0x0164
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r8 = "useDownloadManager"
            boolean r0 = r0.hasKey(r8)
            if (r0 == 0) goto L_0x0164
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r8)
            if (r0 == 0) goto L_0x0164
            java.lang.String r0 = r1.url
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.app.DownloadManager$Request r2 = new android.app.DownloadManager$Request
            r2.<init>(r0)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "notification"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x004d
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r3)
            if (r0 == 0) goto L_0x004d
            r2.setNotificationVisibility(r7)
            goto L_0x0050
        L_0x004d:
            r2.setNotificationVisibility(r6)
        L_0x0050:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "title"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x0067
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r3)
            r2.setTitle(r0)
        L_0x0067:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "description"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x007e
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r3)
            r2.setDescription(r0)
        L_0x007e:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.hasKey(r5)
            if (r0 == 0) goto L_0x00a8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "file://"
            r0.append(r3)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r3 = r1.options
            com.facebook.react.bridge.ReadableMap r3 = r3.addAndroidDownloads
            java.lang.String r3 = r3.getString(r5)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r2.setDestinationUri(r0)
        L_0x00a8:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "mime"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x00bf
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r0 = r0.getString(r3)
            r2.setMimeType(r0)
        L_0x00bf:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            java.lang.String r3 = "mediaScannable"
            boolean r0 = r0.hasKey(r3)
            if (r0 == 0) goto L_0x00d8
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            com.facebook.react.bridge.ReadableMap r0 = r0.addAndroidDownloads
            boolean r0 = r0.getBoolean(r3)
            if (r0 == 0) goto L_0x00d8
            r2.allowScanningByMediaScanner()
        L_0x00d8:
            com.facebook.react.bridge.ReadableMap r0 = r1.headers
            com.facebook.react.bridge.ReadableMapKeySetIterator r0 = r0.keySetIterator()
        L_0x00de:
            boolean r3 = r0.hasNextKey()
            if (r3 == 0) goto L_0x00f2
            java.lang.String r3 = r0.nextKey()
            com.facebook.react.bridge.ReadableMap r4 = r1.headers
            java.lang.String r4 = r4.getString(r3)
            r2.addRequestHeader(r3, r4)
            goto L_0x00de
        L_0x00f2:
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0123 }
            java.lang.String r3 = r1.url     // Catch:{ MalformedURLException -> 0x0123 }
            r0.<init>(r3)     // Catch:{ MalformedURLException -> 0x0123 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0123 }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x0123 }
            java.lang.String r4 = r0.getProtocol()     // Catch:{ MalformedURLException -> 0x0123 }
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x0123 }
            java.lang.String r4 = "://"
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x0123 }
            java.lang.String r0 = r0.getHost()     // Catch:{ MalformedURLException -> 0x0123 }
            r3.append(r0)     // Catch:{ MalformedURLException -> 0x0123 }
            java.lang.String r0 = r3.toString()     // Catch:{ MalformedURLException -> 0x0123 }
            android.webkit.CookieManager r3 = android.webkit.CookieManager.getInstance()     // Catch:{ MalformedURLException -> 0x0123 }
            java.lang.String r0 = r3.getCookie(r0)     // Catch:{ MalformedURLException -> 0x0123 }
            java.lang.String r3 = "Cookie"
            r2.addRequestHeader(r3, r0)     // Catch:{ MalformedURLException -> 0x0123 }
            goto L_0x0127
        L_0x0123:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0127:
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r3 = "download"
            java.lang.Object r3 = r0.getSystemService(r3)
            android.app.DownloadManager r3 = (android.app.DownloadManager) r3
            long r2 = r3.enqueue(r2)
            r1.downloadManagerId = r2
            java.util.HashMap<java.lang.String, java.lang.Long> r4 = androidDownloadManagerTaskTable
            java.lang.String r5 = r1.taskId
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4.put(r5, r2)
            android.content.IntentFilter r2 = new android.content.IntentFilter
            java.lang.String r3 = "android.intent.action.DOWNLOAD_COMPLETE"
            r2.<init>(r3)
            r0.registerReceiver(r1, r2)
            java.util.concurrent.ScheduledExecutorService r4 = r1.scheduledExecutorService
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$2 r5 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$2
            r5.<init>()
            r6 = 0
            r8 = 100
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r0 = r4.scheduleAtFixedRate(r5, r6, r8, r10)
            r1.future = r0
            return
        L_0x0164:
            java.lang.String r0 = r1.taskId
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r8 = r1.options
            java.lang.String r8 = r8.appendExt
            boolean r8 = r8.isEmpty()
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x0174
            r8 = r9
            goto L_0x0189
        L_0x0174:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "."
            r8.append(r10)
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r10 = r1.options
            java.lang.String r10 = r10.appendExt
            r8.append(r10)
            java.lang.String r8 = r8.toString()
        L_0x0189:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r10 = r1.options
            java.lang.String r10 = r10.key
            r11 = 3
            r12 = 0
            r13 = 0
            if (r10 == 0) goto L_0x01ce
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            java.lang.String r0 = r0.key
            java.lang.String r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.getMD5(r0)
            if (r0 != 0) goto L_0x019e
            java.lang.String r0 = r1.taskId
        L_0x019e:
            java.io.File r10 = new java.io.File
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.getTmpPath(r0)
            r14.append(r15)
            r14.append(r8)
            java.lang.String r14 = r14.toString()
            r10.<init>(r14)
            boolean r14 = r10.exists()
            if (r14 == 0) goto L_0x01ce
            com.facebook.react.bridge.Callback r0 = r1.callback
            java.lang.Object[] r2 = new java.lang.Object[r11]
            r2[r13] = r12
            r2[r7] = r5
            java.lang.String r3 = r10.getAbsolutePath()
            r2[r6] = r3
            r0.invoke(r2)
            return
        L_0x01ce:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r5 = r1.options
            java.lang.String r5 = r5.path
            if (r5 == 0) goto L_0x01db
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options
            java.lang.String r0 = r0.path
            r1.destPath = r0
            goto L_0x01fa
        L_0x01db:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r5 = r1.options
            java.lang.Boolean r5 = r5.fileCache
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x01fa
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.getTmpPath(r0)
            r5.append(r0)
            r5.append(r8)
            java.lang.String r0 = r5.toString()
            r1.destPath = r0
        L_0x01fa:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options     // Catch:{ Exception -> 0x04ef }
            java.lang.Boolean r0 = r0.trusty     // Catch:{ Exception -> 0x04ef }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x04ef }
            if (r0 == 0) goto L_0x020b
            okhttp3.OkHttpClient r0 = r1.client     // Catch:{ Exception -> 0x04ef }
            okhttp3.OkHttpClient$Builder r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.getUnsafeOkHttpClient(r0)     // Catch:{ Exception -> 0x04ef }
            goto L_0x0211
        L_0x020b:
            okhttp3.OkHttpClient r0 = r1.client     // Catch:{ Exception -> 0x04ef }
            okhttp3.OkHttpClient$Builder r0 = r0.newBuilder()     // Catch:{ Exception -> 0x04ef }
        L_0x0211:
            r5 = r0
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r1.options     // Catch:{ Exception -> 0x04ef }
            java.lang.Boolean r0 = r0.wifiOnly     // Catch:{ Exception -> 0x04ef }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x04ef }
            if (r0 == 0) goto L_0x0280
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04ef }
            r8 = 21
            if (r0 < r8) goto L_0x027b
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext     // Catch:{ Exception -> 0x04ef }
            com.facebook.react.bridge.ReactApplicationContext r8 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext     // Catch:{ Exception -> 0x04ef }
            java.lang.String r8 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r8)     // Catch:{ Exception -> 0x04ef }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Exception -> 0x04ef }
            android.net.Network[] r8 = r0.getAllNetworks()     // Catch:{ Exception -> 0x04ef }
            int r10 = r8.length     // Catch:{ Exception -> 0x04ef }
            r14 = 0
        L_0x0234:
            if (r14 >= r10) goto L_0x0264
            r15 = r8[r14]     // Catch:{ Exception -> 0x04ef }
            android.net.NetworkInfo r16 = r0.getNetworkInfo(r15)     // Catch:{ Exception -> 0x04ef }
            android.net.NetworkCapabilities r6 = r0.getNetworkCapabilities(r15)     // Catch:{ Exception -> 0x04ef }
            if (r6 == 0) goto L_0x0260
            if (r16 != 0) goto L_0x0245
            goto L_0x0260
        L_0x0245:
            boolean r16 = r16.isConnected()     // Catch:{ Exception -> 0x04ef }
            if (r16 != 0) goto L_0x024c
            goto L_0x0260
        L_0x024c:
            boolean r6 = r6.hasTransport(r7)     // Catch:{ Exception -> 0x04ef }
            if (r6 == 0) goto L_0x0260
            java.net.Proxy r0 = java.net.Proxy.NO_PROXY     // Catch:{ Exception -> 0x04ef }
            r5.proxy(r0)     // Catch:{ Exception -> 0x04ef }
            javax.net.SocketFactory r0 = r15.getSocketFactory()     // Catch:{ Exception -> 0x04ef }
            r5.socketFactory(r0)     // Catch:{ Exception -> 0x04ef }
            r0 = 1
            goto L_0x0265
        L_0x0260:
            int r14 = r14 + 1
            r6 = 2
            goto L_0x0234
        L_0x0264:
            r0 = 0
        L_0x0265:
            if (r0 != 0) goto L_0x0280
            com.facebook.react.bridge.Callback r0 = r1.callback     // Catch:{ Exception -> 0x04ef }
            java.lang.Object[] r2 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x04ef }
            java.lang.String r3 = "No available WiFi connections."
            r2[r13] = r3     // Catch:{ Exception -> 0x04ef }
            r2[r7] = r12     // Catch:{ Exception -> 0x04ef }
            r3 = 2
            r2[r3] = r12     // Catch:{ Exception -> 0x04ef }
            r0.invoke(r2)     // Catch:{ Exception -> 0x04ef }
            r17.releaseTaskResource()     // Catch:{ Exception -> 0x04ef }
            return
        L_0x027b:
            java.lang.String r0 = "ReactNativeBlobUtil: wifiOnly was set, but SDK < 21. wifiOnly was ignored."
            com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.emitWarningEvent(r0)     // Catch:{ Exception -> 0x04ef }
        L_0x0280:
            okhttp3.Request$Builder r6 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x04ef }
            r6.<init>()     // Catch:{ Exception -> 0x04ef }
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0290 }
            java.lang.String r8 = r1.url     // Catch:{ MalformedURLException -> 0x0290 }
            r0.<init>(r8)     // Catch:{ MalformedURLException -> 0x0290 }
            r6.url((java.net.URL) r0)     // Catch:{ MalformedURLException -> 0x0290 }
            goto L_0x0294
        L_0x0290:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x04ef }
        L_0x0294:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x04ef }
            r0.<init>()     // Catch:{ Exception -> 0x04ef }
            com.facebook.react.bridge.ReadableMap r8 = r1.headers     // Catch:{ Exception -> 0x04ef }
            if (r8 == 0) goto L_0x02e6
            com.facebook.react.bridge.ReadableMapKeySetIterator r8 = r8.keySetIterator()     // Catch:{ Exception -> 0x04ef }
        L_0x02a1:
            boolean r10 = r8.hasNextKey()     // Catch:{ Exception -> 0x04ef }
            if (r10 == 0) goto L_0x02e6
            java.lang.String r10 = r8.nextKey()     // Catch:{ Exception -> 0x04ef }
            com.facebook.react.bridge.ReadableMap r14 = r1.headers     // Catch:{ Exception -> 0x04ef }
            java.lang.String r14 = r14.getString(r10)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r15 = "RNFB-Response"
            boolean r15 = r10.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x04ef }
            if (r15 == 0) goto L_0x02d3
            java.lang.String r10 = "base64"
            boolean r10 = r14.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x04ef }
            if (r10 == 0) goto L_0x02c6
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r10 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.BASE64     // Catch:{ Exception -> 0x04ef }
            r1.responseFormat = r10     // Catch:{ Exception -> 0x04ef }
            goto L_0x02a1
        L_0x02c6:
            java.lang.String r10 = "utf8"
            boolean r10 = r14.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x04ef }
            if (r10 == 0) goto L_0x02a1
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r10 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.UTF8     // Catch:{ Exception -> 0x04ef }
            r1.responseFormat = r10     // Catch:{ Exception -> 0x04ef }
            goto L_0x02a1
        L_0x02d3:
            java.util.Locale r15 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x04ef }
            java.lang.String r15 = r10.toLowerCase(r15)     // Catch:{ Exception -> 0x04ef }
            r6.header(r15, r14)     // Catch:{ Exception -> 0x04ef }
            java.util.Locale r15 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x04ef }
            java.lang.String r10 = r10.toLowerCase(r15)     // Catch:{ Exception -> 0x04ef }
            r0.put(r10, r14)     // Catch:{ Exception -> 0x04ef }
            goto L_0x02a1
        L_0x02e6:
            java.lang.String r8 = r1.method     // Catch:{ Exception -> 0x04ef }
            boolean r8 = r8.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r10 = "patch"
            java.lang.String r14 = "put"
            java.lang.String r15 = "content-type"
            if (r8 != 0) goto L_0x030b
            java.lang.String r8 = r1.method     // Catch:{ Exception -> 0x04ef }
            boolean r8 = r8.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04ef }
            if (r8 != 0) goto L_0x030b
            java.lang.String r8 = r1.method     // Catch:{ Exception -> 0x04ef }
            boolean r8 = r8.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x04ef }
            if (r8 == 0) goto L_0x0305
            goto L_0x030b
        L_0x0305:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.WithoutBody     // Catch:{ Exception -> 0x04ef }
            r1.requestType = r2     // Catch:{ Exception -> 0x04ef }
            goto L_0x038f
        L_0x030b:
            java.lang.String r8 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x04ef }
            java.util.Locale r13 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x04ef }
            java.lang.String r8 = r8.toLowerCase(r13)     // Catch:{ Exception -> 0x04ef }
            com.facebook.react.bridge.ReadableArray r13 = r1.rawRequestBodyArray     // Catch:{ Exception -> 0x04ef }
            if (r13 == 0) goto L_0x031e
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r13 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.Form     // Catch:{ Exception -> 0x04ef }
            r1.requestType = r13     // Catch:{ Exception -> 0x04ef }
            goto L_0x0333
        L_0x031e:
            boolean r13 = r8.isEmpty()     // Catch:{ Exception -> 0x04ef }
            if (r13 == 0) goto L_0x0333
            boolean r13 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x04ef }
            if (r13 != 0) goto L_0x032f
            java.lang.String r13 = "application/octet-stream"
            r6.header(r4, r13)     // Catch:{ Exception -> 0x04ef }
        L_0x032f:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r13 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ Exception -> 0x04ef }
            r1.requestType = r13     // Catch:{ Exception -> 0x04ef }
        L_0x0333:
            java.lang.String r13 = r1.rawRequestBody     // Catch:{ Exception -> 0x04ef }
            if (r13 == 0) goto L_0x038f
            java.lang.String r12 = "ReactNativeBlobUtil-file://"
            boolean r12 = r13.startsWith(r12)     // Catch:{ Exception -> 0x04ef }
            if (r12 != 0) goto L_0x038b
            java.lang.String r12 = r1.rawRequestBody     // Catch:{ Exception -> 0x04ef }
            java.lang.String r13 = "ReactNativeBlobUtil-content://"
            boolean r12 = r12.startsWith(r13)     // Catch:{ Exception -> 0x04ef }
            if (r12 == 0) goto L_0x034a
            goto L_0x038b
        L_0x034a:
            java.util.Locale r12 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x04ef }
            java.lang.String r12 = r8.toLowerCase(r12)     // Catch:{ Exception -> 0x04ef }
            boolean r12 = r12.contains(r2)     // Catch:{ Exception -> 0x04ef }
            if (r12 != 0) goto L_0x036a
            java.util.Locale r12 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x04ef }
            java.lang.String r12 = r8.toLowerCase(r12)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r13 = "application/octet"
            boolean r12 = r12.startsWith(r13)     // Catch:{ Exception -> 0x04ef }
            if (r12 == 0) goto L_0x0365
            goto L_0x036a
        L_0x0365:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.AsIs     // Catch:{ Exception -> 0x04ef }
            r1.requestType = r2     // Catch:{ Exception -> 0x04ef }
            goto L_0x038f
        L_0x036a:
            java.lang.String r2 = r8.replace(r2, r9)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r8 = ";BASE64"
            java.lang.String r2 = r2.replace(r8, r9)     // Catch:{ Exception -> 0x04ef }
            boolean r8 = r0.containsKey(r15)     // Catch:{ Exception -> 0x04ef }
            if (r8 == 0) goto L_0x037d
            r0.put(r15, r2)     // Catch:{ Exception -> 0x04ef }
        L_0x037d:
            boolean r8 = r0.containsKey(r4)     // Catch:{ Exception -> 0x04ef }
            if (r8 == 0) goto L_0x0386
            r0.put(r4, r2)     // Catch:{ Exception -> 0x04ef }
        L_0x0386:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ Exception -> 0x04ef }
            r1.requestType = r2     // Catch:{ Exception -> 0x04ef }
            goto L_0x038f
        L_0x038b:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ Exception -> 0x04ef }
            r1.requestType = r2     // Catch:{ Exception -> 0x04ef }
        L_0x038f:
            java.lang.String r2 = "Transfer-Encoding"
            java.lang.String r2 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r4 = "chunked"
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x04ef }
            int[] r4 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r8 = r1.requestType     // Catch:{ Exception -> 0x04ef }
            int r8 = r8.ordinal()     // Catch:{ Exception -> 0x04ef }
            r4 = r4[r8]     // Catch:{ Exception -> 0x04ef }
            if (r4 == r7) goto L_0x0457
            r8 = 2
            if (r4 == r8) goto L_0x042c
            if (r4 == r11) goto L_0x03e1
            r0 = 4
            if (r4 == r0) goto L_0x03b1
            goto L_0x0481
        L_0x03b1:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x04ef }
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x04ef }
            if (r0 != 0) goto L_0x03d2
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x04ef }
            boolean r0 = r0.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04ef }
            if (r0 != 0) goto L_0x03d2
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x04ef }
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x04ef }
            if (r0 == 0) goto L_0x03ca
            goto L_0x03d2
        L_0x03ca:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x04ef }
            r2 = 0
            r6.method(r0, r2)     // Catch:{ Exception -> 0x04ef }
            goto L_0x0481
        L_0x03d2:
            java.lang.String r0 = r1.method     // Catch:{ Exception -> 0x04ef }
            r2 = 0
            byte[] r3 = new byte[r2]     // Catch:{ Exception -> 0x04ef }
            r2 = 0
            okhttp3.RequestBody r2 = okhttp3.RequestBody.create((okhttp3.MediaType) r2, (byte[]) r3)     // Catch:{ Exception -> 0x04ef }
            r6.method(r0, r2)     // Catch:{ Exception -> 0x04ef }
            goto L_0x0481
        L_0x03e1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ef }
            r0.<init>()     // Catch:{ Exception -> 0x04ef }
            java.lang.String r3 = "ReactNativeBlobUtil-"
            r0.append(r3)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r3 = r1.taskId     // Catch:{ Exception -> 0x04ef }
            r0.append(r3)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r3 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilBody     // Catch:{ Exception -> 0x04ef }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x04ef }
            r3.<init>(r4)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x04ef }
            com.facebook.react.bridge.ReadableArray r3 = r1.rawRequestBodyArray     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setBody((com.facebook.react.bridge.ReadableArray) r3)     // Catch:{ Exception -> 0x04ef }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ef }
            r3.<init>()     // Catch:{ Exception -> 0x04ef }
            java.lang.String r4 = "multipart/form-data; boundary="
            r3.append(r4)     // Catch:{ Exception -> 0x04ef }
            r3.append(r0)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x04ef }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x04ef }
            r1.requestBody = r0     // Catch:{ Exception -> 0x04ef }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x04ef }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x04ef }
            goto L_0x0481
        L_0x042c:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r3 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilBody     // Catch:{ Exception -> 0x04ef }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x04ef }
            r3.<init>(r4)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r3 = r1.rawRequestBody     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setBody((java.lang.String) r3)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r0 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r15)     // Catch:{ Exception -> 0x04ef }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x04ef }
            r1.requestBody = r0     // Catch:{ Exception -> 0x04ef }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x04ef }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x04ef }
            goto L_0x0481
        L_0x0457:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r3 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilBody     // Catch:{ Exception -> 0x04ef }
            java.lang.String r4 = r1.taskId     // Catch:{ Exception -> 0x04ef }
            r3.<init>(r4)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r3.chunkedEncoding(r2)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setRequestType(r3)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r3 = r1.rawRequestBody     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r2 = r2.setBody((java.lang.String) r3)     // Catch:{ Exception -> 0x04ef }
            java.lang.String r0 = r1.getHeaderIgnoreCases((java.util.HashMap<java.lang.String, java.lang.String>) r0, (java.lang.String) r15)     // Catch:{ Exception -> 0x04ef }
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilBody r0 = r2.setMIME(r0)     // Catch:{ Exception -> 0x04ef }
            r1.requestBody = r0     // Catch:{ Exception -> 0x04ef }
            java.lang.String r2 = r1.method     // Catch:{ Exception -> 0x04ef }
            r6.method(r2, r0)     // Catch:{ Exception -> 0x04ef }
        L_0x0481:
            okhttp3.Request r0 = r6.build()     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$3 r2 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$3     // Catch:{ Exception -> 0x04ef }
            r2.<init>()     // Catch:{ Exception -> 0x04ef }
            r5.addNetworkInterceptor(r2)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$4 r2 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$4     // Catch:{ Exception -> 0x04ef }
            r2.<init>(r0)     // Catch:{ Exception -> 0x04ef }
            r5.addInterceptor(r2)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x04ef }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x04ef }
            r8 = 0
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x04b1
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x04ef }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x04ef }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x04ef }
            r5.connectTimeout(r2, r4)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x04ef }
            long r2 = r2.timeout     // Catch:{ Exception -> 0x04ef }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x04ef }
            r5.readTimeout(r2, r4)     // Catch:{ Exception -> 0x04ef }
        L_0x04b1:
            okhttp3.ConnectionPool r2 = pool     // Catch:{ Exception -> 0x04ef }
            r5.connectionPool(r2)     // Catch:{ Exception -> 0x04ef }
            r2 = 0
            r5.retryOnConnectionFailure(r2)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x04ef }
            java.lang.Boolean r2 = r2.followRedirect     // Catch:{ Exception -> 0x04ef }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x04ef }
            r5.followRedirects(r2)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r2 = r1.options     // Catch:{ Exception -> 0x04ef }
            java.lang.Boolean r2 = r2.followRedirect     // Catch:{ Exception -> 0x04ef }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x04ef }
            r5.followSslRedirects(r2)     // Catch:{ Exception -> 0x04ef }
            r5.retryOnConnectionFailure(r7)     // Catch:{ Exception -> 0x04ef }
            okhttp3.OkHttpClient$Builder r2 = enableTls12OnPreLollipop(r5)     // Catch:{ Exception -> 0x04ef }
            okhttp3.OkHttpClient r2 = r2.build()     // Catch:{ Exception -> 0x04ef }
            okhttp3.Call r0 = r2.newCall(r0)     // Catch:{ Exception -> 0x04ef }
            java.util.HashMap<java.lang.String, okhttp3.Call> r2 = taskTable     // Catch:{ Exception -> 0x04ef }
            java.lang.String r3 = r1.taskId     // Catch:{ Exception -> 0x04ef }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x04ef }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$5 r2 = new com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$5     // Catch:{ Exception -> 0x04ef }
            r2.<init>()     // Catch:{ Exception -> 0x04ef }
            r0.enqueue(r2)     // Catch:{ Exception -> 0x04ef }
            goto L_0x051c
        L_0x04ef:
            r0 = move-exception
            r0.printStackTrace()
            r17.releaseTaskResource()
            com.facebook.react.bridge.Callback r2 = r1.callback
            java.lang.Object[] r3 = new java.lang.Object[r7]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "ReactNativeBlobUtil request error: "
            r4.append(r5)
            java.lang.String r5 = r0.getMessage()
            r4.append(r5)
            java.lang.Throwable r0 = r0.getCause()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r4 = 0
            r3[r4] = r0
            r2.invoke(r3)
        L_0x051c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.run():void");
    }

    /* renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType;
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        static {
            /*
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseType[] r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType = r0
                r1 = 1
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseType.KeepInMemory     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseType r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseType.FileStorage     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType[] r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType = r2
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.SingleFile     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.AsIs     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.Form     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType     // Catch:{ NoSuchFieldError -> 0x004e }
                com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$RequestType r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.RequestType.WithoutBody     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.AnonymousClass6.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void releaseTaskResource() {
        if (taskTable.containsKey(this.taskId)) {
            taskTable.remove(this.taskId);
        }
        if (androidDownloadManagerTaskTable.containsKey(this.taskId)) {
            androidDownloadManagerTaskTable.remove(this.taskId);
        }
        if (uploadProgressReport.containsKey(this.taskId)) {
            uploadProgressReport.remove(this.taskId);
        }
        if (progressReport.containsKey(this.taskId)) {
            progressReport.remove(this.taskId);
        }
        ReactNativeBlobUtilBody reactNativeBlobUtilBody = this.requestBody;
        if (reactNativeBlobUtilBody != null) {
            reactNativeBlobUtilBody.clearRequestBody();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:80|81|82|83|(1:85)(1:86)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|(1:16)(1:15)) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008a, code lost:
        if (r0 != null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009c, code lost:
        if (r0.source().buffer().size() > 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009e, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a7, code lost:
        if (r0.contentLength() > 0) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a9, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ab, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b0, code lost:
        r13 = r0.string();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b5, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b6, code lost:
        r13.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b9, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ba, code lost:
        r12.callback.invoke("Unexpected FileStorage response file: " + r13, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d7, code lost:
        r12.callback.invoke("Unexpected FileStorage response with no file.", null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x005a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x01eb */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01f1 A[Catch:{ IOException -> 0x0216 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0204 A[Catch:{ IOException -> 0x0216 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void done(okhttp3.Response r13) {
        /*
            r12 = this;
            boolean r0 = r12.isBlobResponse(r13)
            com.facebook.react.bridge.WritableMap r1 = r12.getResponseInfo(r13, r0)
            r12.emitStateEvent(r1)
            int[] r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseType r2 = r12.responseType
            int r2 = r2.ordinal()
            r1 = r1[r2]
            java.lang.String r2 = "UTF-8"
            java.lang.String r3 = ""
            java.lang.String r4 = "?append=true"
            java.lang.String r5 = "path"
            java.lang.String r6 = "utf8"
            r7 = 3
            r8 = 0
            r9 = 0
            r10 = 2
            r11 = 1
            if (r1 == r11) goto L_0x00e5
            if (r1 == r10) goto L_0x0053
            com.facebook.react.bridge.Callback r0 = r12.callback     // Catch:{ IOException -> 0x0044 }
            java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0044 }
            r1[r9] = r8     // Catch:{ IOException -> 0x0044 }
            r1[r11] = r6     // Catch:{ IOException -> 0x0044 }
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x0044 }
            okhttp3.ResponseBody r4 = r13.body()     // Catch:{ IOException -> 0x0044 }
            byte[] r4 = r4.bytes()     // Catch:{ IOException -> 0x0044 }
            r3.<init>(r4, r2)     // Catch:{ IOException -> 0x0044 }
            r1[r10] = r3     // Catch:{ IOException -> 0x0044 }
            r0.invoke(r1)     // Catch:{ IOException -> 0x0044 }
            goto L_0x0223
        L_0x0044:
            com.facebook.react.bridge.Callback r0 = r12.callback
            java.lang.Object[] r1 = new java.lang.Object[r10]
            java.lang.String r2 = "ReactNativeBlobUtil failed to encode response data to UTF8 string."
            r1[r9] = r2
            r1[r11] = r8
            r0.invoke(r1)
            goto L_0x0223
        L_0x0053:
            okhttp3.ResponseBody r0 = r13.body()
            r0.bytes()     // Catch:{ Exception -> 0x005a }
        L_0x005a:
            com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilFileResp r0 = (com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilFileResp) r0     // Catch:{ ClassCastException -> 0x008a }
            if (r0 == 0) goto L_0x0073
            boolean r0 = r0.isDownloadComplete()
            if (r0 != 0) goto L_0x0073
            com.facebook.react.bridge.Callback r0 = r12.callback
            java.lang.Object[] r1 = new java.lang.Object[r10]
            java.lang.String r2 = "Download interrupted."
            r1[r9] = r2
            r1[r11] = r8
            r0.invoke(r1)
            goto L_0x0223
        L_0x0073:
            java.lang.String r0 = r12.destPath
            java.lang.String r0 = r0.replace(r4, r3)
            r12.destPath = r0
            com.facebook.react.bridge.Callback r1 = r12.callback
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r2[r9] = r8
            r2[r11] = r5
            r2[r10] = r0
            r1.invoke(r2)
            goto L_0x0223
        L_0x008a:
            if (r0 == 0) goto L_0x00d7
            okio.BufferedSource r13 = r0.source()     // Catch:{ IOException -> 0x00b5 }
            okio.Buffer r13 = r13.buffer()     // Catch:{ IOException -> 0x00b5 }
            long r1 = r13.size()     // Catch:{ IOException -> 0x00b5 }
            r3 = 0
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x00a0
            r13 = 1
            goto L_0x00a1
        L_0x00a0:
            r13 = 0
        L_0x00a1:
            long r1 = r0.contentLength()     // Catch:{ IOException -> 0x00b5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x00ab
            r1 = 1
            goto L_0x00ac
        L_0x00ab:
            r1 = 0
        L_0x00ac:
            if (r13 == 0) goto L_0x00b9
            if (r1 == 0) goto L_0x00b9
            java.lang.String r13 = r0.string()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00ba
        L_0x00b5:
            r13 = move-exception
            r13.printStackTrace()
        L_0x00b9:
            r13 = r8
        L_0x00ba:
            com.facebook.react.bridge.Callback r0 = r12.callback
            java.lang.Object[] r1 = new java.lang.Object[r10]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected FileStorage response file: "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r13 = r2.toString()
            r1[r9] = r13
            r1[r11] = r8
            r0.invoke(r1)
            goto L_0x00e4
        L_0x00d7:
            com.facebook.react.bridge.Callback r13 = r12.callback
            java.lang.Object[] r0 = new java.lang.Object[r10]
            java.lang.String r1 = "Unexpected FileStorage response with no file."
            r0[r9] = r1
            r0[r11] = r8
            r13.invoke(r0)
        L_0x00e4:
            return
        L_0x00e5:
            if (r0 == 0) goto L_0x0130
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r0 = r12.options     // Catch:{ IOException -> 0x0216 }
            java.lang.Boolean r0 = r0.auto     // Catch:{ IOException -> 0x0216 }
            boolean r0 = r0.booleanValue()     // Catch:{ IOException -> 0x0216 }
            if (r0 == 0) goto L_0x0130
            java.lang.String r0 = r12.taskId     // Catch:{ IOException -> 0x0216 }
            java.lang.String r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.getTmpPath(r0)     // Catch:{ IOException -> 0x0216 }
            okhttp3.ResponseBody r1 = r13.body()     // Catch:{ IOException -> 0x0216 }
            java.io.InputStream r1 = r1.byteStream()     // Catch:{ IOException -> 0x0216 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0216 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0216 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0216 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0216 }
            r3 = 10240(0x2800, float:1.4349E-41)
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x0216 }
        L_0x010d:
            int r4 = r1.read(r3)     // Catch:{ IOException -> 0x0216 }
            r6 = -1
            if (r4 == r6) goto L_0x0118
            r2.write(r3, r9, r4)     // Catch:{ IOException -> 0x0216 }
            goto L_0x010d
        L_0x0118:
            r1.close()     // Catch:{ IOException -> 0x0216 }
            r2.flush()     // Catch:{ IOException -> 0x0216 }
            r2.close()     // Catch:{ IOException -> 0x0216 }
            com.facebook.react.bridge.Callback r1 = r12.callback     // Catch:{ IOException -> 0x0216 }
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0216 }
            r2[r9] = r8     // Catch:{ IOException -> 0x0216 }
            r2[r11] = r5     // Catch:{ IOException -> 0x0216 }
            r2[r10] = r0     // Catch:{ IOException -> 0x0216 }
            r1.invoke(r2)     // Catch:{ IOException -> 0x0216 }
            goto L_0x0223
        L_0x0130:
            okhttp3.ResponseBody r0 = r13.body()     // Catch:{ IOException -> 0x0216 }
            byte[] r0 = r0.bytes()     // Catch:{ IOException -> 0x0216 }
            boolean r1 = r12.shouldTransformFile()     // Catch:{ IOException -> 0x0216 }
            if (r1 == 0) goto L_0x01af
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ IOException -> 0x0216 }
            if (r1 == 0) goto L_0x01a7
            java.lang.String r1 = r12.destPath     // Catch:{ IOException -> 0x0216 }
            java.lang.String r1 = r1.replace(r4, r3)     // Catch:{ IOException -> 0x0216 }
            r12.destPath = r1     // Catch:{ IOException -> 0x0216 }
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0216 }
            java.lang.String r2 = r12.destPath     // Catch:{ IOException -> 0x0216 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0216 }
            boolean r2 = r1.exists()     // Catch:{ IOException -> 0x0216 }
            if (r2 != 0) goto L_0x015a
            r1.createNewFile()     // Catch:{ IOException -> 0x0216 }
        L_0x015a:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0185 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0185 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ all -> 0x017b }
            byte[] r0 = r1.onWriteFile(r0)     // Catch:{ all -> 0x017b }
            r2.write(r0)     // Catch:{ all -> 0x017b }
            r2.close()     // Catch:{ Exception -> 0x0185 }
            com.facebook.react.bridge.Callback r0 = r12.callback     // Catch:{ IOException -> 0x0216 }
            java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0216 }
            r1[r9] = r8     // Catch:{ IOException -> 0x0216 }
            r1[r11] = r5     // Catch:{ IOException -> 0x0216 }
            java.lang.String r2 = r12.destPath     // Catch:{ IOException -> 0x0216 }
            r1[r10] = r2     // Catch:{ IOException -> 0x0216 }
            r0.invoke(r1)     // Catch:{ IOException -> 0x0216 }
            return
        L_0x017b:
            r0 = move-exception
            r2.close()     // Catch:{ all -> 0x0180 }
            goto L_0x0184
        L_0x0180:
            r1 = move-exception
            r0.addSuppressed(r1)     // Catch:{ Exception -> 0x0185 }
        L_0x0184:
            throw r0     // Catch:{ Exception -> 0x0185 }
        L_0x0185:
            r0 = move-exception
            com.facebook.react.bridge.Callback r1 = r12.callback     // Catch:{ IOException -> 0x0216 }
            java.lang.Object[] r2 = new java.lang.Object[r10]     // Catch:{ IOException -> 0x0216 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0216 }
            r3.<init>()     // Catch:{ IOException -> 0x0216 }
            java.lang.String r4 = "Error from file transformer:"
            r3.append(r4)     // Catch:{ IOException -> 0x0216 }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ IOException -> 0x0216 }
            r3.append(r0)     // Catch:{ IOException -> 0x0216 }
            java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x0216 }
            r2[r9] = r0     // Catch:{ IOException -> 0x0216 }
            r2[r11] = r8     // Catch:{ IOException -> 0x0216 }
            r1.invoke(r2)     // Catch:{ IOException -> 0x0216 }
            return
        L_0x01a7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0216 }
            java.lang.String r1 = "Write file with transform was specified but the shared file transformer is not set"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0216 }
            throw r0     // Catch:{ IOException -> 0x0216 }
        L_0x01af:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r1 = r12.responseFormat     // Catch:{ IOException -> 0x0216 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.BASE64     // Catch:{ IOException -> 0x0216 }
            java.lang.String r4 = "base64"
            if (r1 != r3) goto L_0x01c9
            com.facebook.react.bridge.Callback r1 = r12.callback     // Catch:{ IOException -> 0x0216 }
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0216 }
            r2[r9] = r8     // Catch:{ IOException -> 0x0216 }
            r2[r11] = r4     // Catch:{ IOException -> 0x0216 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r10)     // Catch:{ IOException -> 0x0216 }
            r2[r10] = r0     // Catch:{ IOException -> 0x0216 }
            r1.invoke(r2)     // Catch:{ IOException -> 0x0216 }
            return
        L_0x01c9:
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r2)     // Catch:{ CharacterCodingException -> 0x01eb }
            java.nio.charset.CharsetDecoder r2 = r1.newDecoder()     // Catch:{ CharacterCodingException -> 0x01eb }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ CharacterCodingException -> 0x01eb }
            r2.decode(r3)     // Catch:{ CharacterCodingException -> 0x01eb }
            java.lang.String r2 = new java.lang.String     // Catch:{ CharacterCodingException -> 0x01eb }
            r2.<init>(r0, r1)     // Catch:{ CharacterCodingException -> 0x01eb }
            com.facebook.react.bridge.Callback r1 = r12.callback     // Catch:{ CharacterCodingException -> 0x01eb }
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch:{ CharacterCodingException -> 0x01eb }
            r3[r9] = r8     // Catch:{ CharacterCodingException -> 0x01eb }
            r3[r11] = r6     // Catch:{ CharacterCodingException -> 0x01eb }
            r3[r10] = r2     // Catch:{ CharacterCodingException -> 0x01eb }
            r1.invoke(r3)     // Catch:{ CharacterCodingException -> 0x01eb }
            goto L_0x0223
        L_0x01eb:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r1 = r12.responseFormat     // Catch:{ IOException -> 0x0216 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$ResponseFormat r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.ResponseFormat.UTF8     // Catch:{ IOException -> 0x0216 }
            if (r1 != r2) goto L_0x0204
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x0216 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0216 }
            com.facebook.react.bridge.Callback r0 = r12.callback     // Catch:{ IOException -> 0x0216 }
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0216 }
            r2[r9] = r8     // Catch:{ IOException -> 0x0216 }
            r2[r11] = r6     // Catch:{ IOException -> 0x0216 }
            r2[r10] = r1     // Catch:{ IOException -> 0x0216 }
            r0.invoke(r2)     // Catch:{ IOException -> 0x0216 }
            goto L_0x0223
        L_0x0204:
            com.facebook.react.bridge.Callback r1 = r12.callback     // Catch:{ IOException -> 0x0216 }
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0216 }
            r2[r9] = r8     // Catch:{ IOException -> 0x0216 }
            r2[r11] = r4     // Catch:{ IOException -> 0x0216 }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r10)     // Catch:{ IOException -> 0x0216 }
            r2[r10] = r0     // Catch:{ IOException -> 0x0216 }
            r1.invoke(r2)     // Catch:{ IOException -> 0x0216 }
            goto L_0x0223
        L_0x0216:
            com.facebook.react.bridge.Callback r0 = r12.callback
            java.lang.Object[] r1 = new java.lang.Object[r10]
            java.lang.String r2 = "ReactNativeBlobUtil failed to encode response data to BASE64 string."
            r1[r9] = r2
            r1[r11] = r8
            r0.invoke(r1)
        L_0x0223:
            okhttp3.ResponseBody r13 = r13.body()
            r13.close()
            r12.releaseTaskResource()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.done(okhttp3.Response):void");
    }

    public static ReactNativeBlobUtilProgressConfig getReportProgress(String str) {
        if (!progressReport.containsKey(str)) {
            return null;
        }
        return progressReport.get(str);
    }

    public static ReactNativeBlobUtilProgressConfig getReportUploadProgress(String str) {
        if (!uploadProgressReport.containsKey(str)) {
            return null;
        }
        return uploadProgressReport.get(str);
    }

    private WritableMap getResponseInfo(Response response, boolean z) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(NotificationCompat.CATEGORY_STATUS, response.code());
        createMap.putString(PostalAddressParser.REGION_KEY, "2");
        createMap.putString("taskId", this.taskId);
        createMap.putBoolean("timeout", this.timeout);
        WritableMap createMap2 = Arguments.createMap();
        for (int i = 0; i < response.headers().size(); i++) {
            createMap2.putString(response.headers().name(i), response.headers().value(i));
        }
        WritableArray createArray = Arguments.createArray();
        Iterator<String> it = this.redirects.iterator();
        while (it.hasNext()) {
            createArray.pushString(it.next());
        }
        createMap.putArray("redirects", createArray);
        createMap.putMap("headers", createMap2);
        Headers headers2 = response.headers();
        if (z) {
            createMap.putString("respType", "blob");
        } else if (getHeaderIgnoreCases(headers2, "content-type").equalsIgnoreCase("text/")) {
            createMap.putString("respType", "text");
        } else if (getHeaderIgnoreCases(headers2, "content-type").contains("application/json")) {
            createMap.putString("respType", "json");
        } else {
            createMap.putString("respType", "");
        }
        return createMap;
    }

    private boolean isBlobResponse(Response response) {
        boolean z;
        String headerIgnoreCases = getHeaderIgnoreCases(response.headers(), NetworkConstantsKt.HEADER_CONTENT_TYPE);
        boolean z2 = !headerIgnoreCases.equalsIgnoreCase("text/");
        boolean z3 = !headerIgnoreCases.equalsIgnoreCase("application/json");
        if (this.options.binaryContentTypes != null) {
            int i = 0;
            while (true) {
                if (i >= this.options.binaryContentTypes.size()) {
                    break;
                } else if (headerIgnoreCases.toLowerCase(Locale.ROOT).contains(this.options.binaryContentTypes.getString(i).toLowerCase(Locale.ROOT))) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        z = false;
        if ((z3 || z2) && !z) {
            return false;
        }
        return true;
    }

    private String getHeaderIgnoreCases(Headers headers2, String str) {
        String str2 = headers2.get(str);
        if (str2 != null) {
            return str2;
        }
        return headers2.get(str.toLowerCase(Locale.ROOT)) == null ? "" : headers2.get(str.toLowerCase(Locale.ROOT));
    }

    private String getHeaderIgnoreCases(HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = hashMap.get(str.toLowerCase(Locale.ROOT));
        return str3 == null ? "" : str3;
    }

    private void emitStateEvent(WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtil.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_HTTP_STATE, writableMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ef A[SYNTHETIC, Splitter:B:28:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r13, android.content.Intent r14) {
        /*
            r12 = this;
            java.lang.String r13 = r14.getAction()
            java.lang.String r0 = "android.intent.action.DOWNLOAD_COMPLETE"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x0153
            com.facebook.react.bridge.ReactApplicationContext r13 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext
            android.content.Context r13 = r13.getApplicationContext()
            android.os.Bundle r14 = r14.getExtras()
            java.lang.String r0 = "extra_download_id"
            long r0 = r14.getLong(r0)
            long r2 = r12.downloadManagerId
            int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x0153
            r12.releaseTaskResource()
            android.app.DownloadManager$Query r14 = new android.app.DownloadManager$Query
            r14.<init>()
            r0 = 1
            long[] r1 = new long[r0]
            long r2 = r12.downloadManagerId
            r4 = 0
            r1[r4] = r2
            r14.setFilterById(r1)
            java.lang.String r1 = "download"
            java.lang.Object r1 = r13.getSystemService(r1)
            android.app.DownloadManager r1 = (android.app.DownloadManager) r1
            r1.query(r14)
            android.database.Cursor r14 = r1.query(r14)
            java.lang.String r1 = "Download manager failed to download from  "
            r2 = 3
            r3 = 2
            r5 = 0
            if (r14 != 0) goto L_0x006f
            com.facebook.react.bridge.Callback r13 = r12.callback
            java.lang.Object[] r14 = new java.lang.Object[r2]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = r12.url
            r2.append(r1)
            java.lang.String r1 = ". Query was unsuccessful "
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r14[r4] = r1
            r14[r0] = r5
            r14[r3] = r5
            r13.invoke(r14)
            return
        L_0x006f:
            boolean r6 = r14.moveToFirst()     // Catch:{ all -> 0x014c }
            if (r6 == 0) goto L_0x00dd
            java.lang.String r6 = "status"
            int r6 = r14.getColumnIndex(r6)     // Catch:{ all -> 0x014c }
            int r6 = r14.getInt(r6)     // Catch:{ all -> 0x014c }
            r7 = 16
            if (r6 != r7) goto L_0x00af
            com.facebook.react.bridge.Callback r13 = r12.callback     // Catch:{ all -> 0x014c }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x014c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x014c }
            r7.<init>()     // Catch:{ all -> 0x014c }
            r7.append(r1)     // Catch:{ all -> 0x014c }
            java.lang.String r1 = r12.url     // Catch:{ all -> 0x014c }
            r7.append(r1)     // Catch:{ all -> 0x014c }
            java.lang.String r1 = ". Status Code = "
            r7.append(r1)     // Catch:{ all -> 0x014c }
            r7.append(r6)     // Catch:{ all -> 0x014c }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x014c }
            r2[r4] = r1     // Catch:{ all -> 0x014c }
            r2[r0] = r5     // Catch:{ all -> 0x014c }
            r2[r3] = r5     // Catch:{ all -> 0x014c }
            r13.invoke(r2)     // Catch:{ all -> 0x014c }
            if (r14 == 0) goto L_0x00ae
            r14.close()
        L_0x00ae:
            return
        L_0x00af:
            java.lang.String r1 = "local_uri"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ all -> 0x014c }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00dd
            android.net.Uri r7 = android.net.Uri.parse(r1)     // Catch:{ all -> 0x014c }
            android.content.ContentResolver r6 = r13.getContentResolver()     // Catch:{ all -> 0x014c }
            java.lang.String r13 = "_data"
            java.lang.String[] r8 = new java.lang.String[]{r13}     // Catch:{ all -> 0x014c }
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r13 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x014c }
            if (r13 == 0) goto L_0x00dd
            r13.moveToFirst()     // Catch:{ all -> 0x014c }
            java.lang.String r1 = r13.getString(r4)     // Catch:{ all -> 0x014c }
            r13.close()     // Catch:{ all -> 0x014c }
            goto L_0x00de
        L_0x00dd:
            r1 = r5
        L_0x00de:
            if (r14 == 0) goto L_0x00e3
            r14.close()
        L_0x00e3:
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r13 = r12.options
            com.facebook.react.bridge.ReadableMap r13 = r13.addAndroidDownloads
            java.lang.String r14 = "path"
            boolean r13 = r13.hasKey(r14)
            if (r13 == 0) goto L_0x012c
            com.ReactNativeBlobUtil.ReactNativeBlobUtilConfig r13 = r12.options     // Catch:{ Exception -> 0x0118 }
            com.facebook.react.bridge.ReadableMap r13 = r13.addAndroidDownloads     // Catch:{ Exception -> 0x0118 }
            java.lang.String r13 = r13.getString(r14)     // Catch:{ Exception -> 0x0118 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0118 }
            r1.<init>(r13)     // Catch:{ Exception -> 0x0118 }
            boolean r1 = r1.exists()     // Catch:{ Exception -> 0x0118 }
            if (r1 == 0) goto L_0x0110
            com.facebook.react.bridge.Callback r1 = r12.callback     // Catch:{ Exception -> 0x0118 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0118 }
            r2[r4] = r5     // Catch:{ Exception -> 0x0118 }
            r2[r0] = r14     // Catch:{ Exception -> 0x0118 }
            r2[r3] = r13     // Catch:{ Exception -> 0x0118 }
            r1.invoke(r2)     // Catch:{ Exception -> 0x0118 }
            goto L_0x0153
        L_0x0110:
            java.lang.Exception r13 = new java.lang.Exception     // Catch:{ Exception -> 0x0118 }
            java.lang.String r14 = "Download manager download failed, the file does not downloaded to destination."
            r13.<init>(r14)     // Catch:{ Exception -> 0x0118 }
            throw r13     // Catch:{ Exception -> 0x0118 }
        L_0x0118:
            r13 = move-exception
            r13.printStackTrace()
            com.facebook.react.bridge.Callback r14 = r12.callback
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r13 = r13.getLocalizedMessage()
            r1[r4] = r13
            r1[r0] = r5
            r14.invoke(r1)
            goto L_0x0153
        L_0x012c:
            if (r1 != 0) goto L_0x013e
            com.facebook.react.bridge.Callback r13 = r12.callback
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r2 = "Download manager could not resolve downloaded file path."
            r1[r4] = r2
            r1[r0] = r14
            r1[r3] = r5
            r13.invoke(r1)
            goto L_0x0153
        L_0x013e:
            com.facebook.react.bridge.Callback r13 = r12.callback
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r5
            r2[r0] = r14
            r2[r3] = r1
            r13.invoke(r2)
            goto L_0x0153
        L_0x014c:
            r13 = move-exception
            if (r14 == 0) goto L_0x0152
            r14.close()
        L_0x0152:
            throw r13
        L_0x0153:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.onReceive(android.content.Context, android.content.Intent):void");
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19) {
            try {
                SSLContext instance = SSLContext.getInstance("TLSv1.2");
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                builder.sslSocketFactory(new Tls12SocketFactory(instance.getSocketFactory()));
                ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build();
                ArrayList arrayList = new ArrayList();
                arrayList.add(build);
                arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
                arrayList.add(ConnectionSpec.CLEARTEXT);
                builder.connectionSpecs(arrayList);
            } catch (Exception e) {
                FLog.e("OkHttpTLSCompat", "Error while setting TLS 1.2", (Throwable) e);
            }
        }
        return builder;
    }
}

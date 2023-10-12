package com.ReactNativeBlobUtil;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.stripe.android.model.PaymentMethodOptionsParams;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.UUID;

public class ReactNativeBlobUtilStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final HashMap<String, ReactNativeBlobUtilStream> fileStreams = new HashMap<>();
    private final DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private String encoding = ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64;
    private OutputStream writeStreamInstance = null;

    ReactNativeBlobUtilStream(ReactApplicationContext reactApplicationContext) {
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067 A[SYNTHETIC, Splitter:B:23:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a A[Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0113 A[Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void readStream(java.lang.String r17, java.lang.String r18, int r19, int r20, java.lang.String r21) {
        /*
            r16 = this;
            r1 = r16
            r2 = r18
            r0 = r20
            r3 = r21
            java.lang.String r4 = "bundle-assets://"
            java.lang.String r5 = "base64"
            java.lang.String r6 = "error"
            java.lang.String r7 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r17)
            if (r7 == 0) goto L_0x0016
            r8 = r7
            goto L_0x0018
        L_0x0016:
            r8 = r17
        L_0x0018:
            boolean r9 = r2.equalsIgnoreCase(r5)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            if (r9 == 0) goto L_0x0021
            r9 = 4095(0xfff, float:5.738E-42)
            goto L_0x0023
        L_0x0021:
            r9 = 4096(0x1000, float:5.74E-42)
        L_0x0023:
            if (r19 <= 0) goto L_0x0027
            r9 = r19
        L_0x0027:
            java.lang.String r10 = ""
            if (r7 == 0) goto L_0x0040
            boolean r11 = r8.startsWith(r4)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            if (r11 == 0) goto L_0x0040
            com.facebook.react.bridge.ReactApplicationContext r7 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            java.lang.String r4 = r8.replace(r4, r10)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            java.io.InputStream r4 = r7.open(r4)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            goto L_0x005b
        L_0x0040:
            if (r7 != 0) goto L_0x0051
            com.facebook.react.bridge.ReactApplicationContext r4 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            android.net.Uri r7 = android.net.Uri.parse(r8)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            java.io.InputStream r4 = r4.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            goto L_0x005b
        L_0x0051:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            java.io.File r7 = new java.io.File     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r4.<init>(r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
        L_0x005b:
            java.lang.String r7 = "utf8"
            boolean r7 = r2.equalsIgnoreCase(r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r11 = -1
            java.lang.String r12 = "data"
            r13 = 0
            if (r7 == 0) goto L_0x009a
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            java.lang.String r7 = "UTF-8"
            java.nio.charset.Charset r7 = java.nio.charset.Charset.forName(r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r5.<init>(r4, r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r7.<init>(r5, r9)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            char[] r14 = new char[r9]     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
        L_0x0079:
            int r15 = r7.read(r14, r13, r9)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            if (r15 == r11) goto L_0x0093
            java.lang.String r15 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r15.<init>(r14)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r1.emitStreamEvent((java.lang.String) r3, (java.lang.String) r12, (java.lang.String) r15)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            if (r0 <= 0) goto L_0x008f
            r15 = r14
            long r13 = (long) r0     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            android.os.SystemClock.sleep(r13)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            goto L_0x0090
        L_0x008f:
            r15 = r14
        L_0x0090:
            r14 = r15
            r13 = 0
            goto L_0x0079
        L_0x0093:
            r7.close()     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r5.close()     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            goto L_0x00c3
        L_0x009a:
            java.lang.String r7 = "ascii"
            boolean r7 = r2.equalsIgnoreCase(r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            if (r7 == 0) goto L_0x00c5
            byte[] r5 = new byte[r9]     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
        L_0x00a4:
            int r7 = r4.read(r5)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            if (r7 == r11) goto L_0x00c3
            com.facebook.react.bridge.WritableArray r9 = com.facebook.react.bridge.Arguments.createArray()     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r13 = 0
        L_0x00af:
            if (r13 >= r7) goto L_0x00b9
            byte r14 = r5[r13]     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r9.pushInt(r14)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            int r13 = r13 + 1
            goto L_0x00af
        L_0x00b9:
            r1.emitStreamEvent((java.lang.String) r3, (java.lang.String) r12, (com.facebook.react.bridge.WritableArray) r9)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            if (r0 <= 0) goto L_0x00a4
            long r13 = (long) r0     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            android.os.SystemClock.sleep(r13)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            goto L_0x00a4
        L_0x00c3:
            r15 = 0
            goto L_0x00f3
        L_0x00c5:
            boolean r5 = r2.equalsIgnoreCase(r5)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            if (r5 == 0) goto L_0x00f5
            byte[] r5 = new byte[r9]     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
        L_0x00cd:
            int r7 = r4.read(r5)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            if (r7 == r11) goto L_0x00c3
            r13 = 2
            if (r7 >= r9) goto L_0x00e4
            byte[] r14 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r15 = 0
            java.lang.System.arraycopy(r5, r15, r14, r15, r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            java.lang.String r7 = android.util.Base64.encodeToString(r14, r13)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r1.emitStreamEvent((java.lang.String) r3, (java.lang.String) r12, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            goto L_0x00ec
        L_0x00e4:
            r15 = 0
            java.lang.String r7 = android.util.Base64.encodeToString(r5, r13)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r1.emitStreamEvent((java.lang.String) r3, (java.lang.String) r12, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
        L_0x00ec:
            if (r0 <= 0) goto L_0x00cd
            long r13 = (long) r0     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            android.os.SystemClock.sleep(r13)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            goto L_0x00cd
        L_0x00f3:
            r13 = 0
            goto L_0x0111
        L_0x00f5:
            java.lang.String r0 = "EINVAL"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            java.lang.String r7 = "Unrecognized encoding `"
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r5.append(r2)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            java.lang.String r7 = "`, should be one of `base64`, `utf8`, `ascii`"
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r1.emitStreamEvent(r3, r6, r0, r5)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            r13 = 1
        L_0x0111:
            if (r13 != 0) goto L_0x0118
            java.lang.String r0 = "end"
            r1.emitStreamEvent((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r10)     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
        L_0x0118:
            r4.close()     // Catch:{ FileNotFoundException -> 0x013c, Exception -> 0x011c }
            goto L_0x0157
        L_0x011c:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Failed to convert data to "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " encoded string. This might be because this encoding cannot be used for this data."
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r4 = "EUNSPECIFIED"
            r1.emitStreamEvent(r3, r6, r4, r2)
            r0.printStackTrace()
            goto L_0x0157
        L_0x013c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "No such file '"
            r0.append(r2)
            r0.append(r8)
            java.lang.String r2 = "'"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ENOENT"
            r1.emitStreamEvent(r3, r6, r2, r0)
        L_0x0157:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilStream.readStream(java.lang.String, java.lang.String, int, int, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public void writeStream(String str, String str2, boolean z, Callback callback) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    callback.invoke("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    callback.invoke("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            } else if (file.isDirectory()) {
                callback.invoke("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str, z);
            this.encoding = str2;
            String uuid = UUID.randomUUID().toString();
            fileStreams.put(uuid, this);
            this.writeStreamInstance = fileOutputStream;
            callback.invoke(null, null, uuid);
        } catch (Exception e) {
            callback.invoke("EUNSPECIFIED", "Failed to create write stream at path `" + str + "`; " + e.getLocalizedMessage());
        }
    }

    static void writeChunk(String str, String str2, Callback callback) {
        ReactNativeBlobUtilStream reactNativeBlobUtilStream = fileStreams.get(str);
        try {
            reactNativeBlobUtilStream.writeStreamInstance.write(ReactNativeBlobUtilUtils.stringToBytes(str2, reactNativeBlobUtilStream.encoding));
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            outputStream.write(bArr);
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void closeStream(String str, Callback callback) {
        try {
            HashMap<String, ReactNativeBlobUtilStream> hashMap = fileStreams;
            OutputStream outputStream = hashMap.get(str).writeStreamInstance;
            hashMap.remove(str);
            outputStream.close();
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    private void emitStreamEvent(String str, String str2, String str3) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("event", str2);
        createMap.putString("detail", str3);
        this.emitter.emit(str, createMap);
    }

    private void emitStreamEvent(String str, String str2, WritableArray writableArray) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("event", str2);
        createMap.putArray("detail", writableArray);
        this.emitter.emit(str, createMap);
    }

    private void emitStreamEvent(String str, String str2, String str3, String str4) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("event", str2);
        createMap.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, str3);
        createMap.putString("detail", str4);
        this.emitter.emit(str, createMap);
    }

    public static InputStream inputStreamFromPath(String str) throws IOException {
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return ReactNativeBlobUtil.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
        }
        return new FileInputStream(new File(str));
    }
}

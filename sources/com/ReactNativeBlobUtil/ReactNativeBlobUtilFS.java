package com.ReactNativeBlobUtil;

import android.content.res.AssetFileDescriptor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

class ReactNativeBlobUtilFS {
    private static HashMap<String, ReactNativeBlobUtilFS> fileStreams = new HashMap<>();
    private DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private String encoding = ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64;
    private ReactApplicationContext mCtx;
    private OutputStream writeStreamInstance = null;

    ReactNativeBlobUtilFS(ReactApplicationContext reactApplicationContext) {
        this.mCtx = reactApplicationContext;
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0072 A[Catch:{ all -> 0x008d, FileNotFoundException | Exception -> 0x0092 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077 A[Catch:{ all -> 0x008d, FileNotFoundException | Exception -> 0x0092 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean writeFile(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            r0 = 0
            java.lang.String r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r1.<init>(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            java.io.File r3 = r1.getParentFile()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r2 != 0) goto L_0x0030
            if (r3 == 0) goto L_0x0029
            boolean r2 = r3.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r2 != 0) goto L_0x0029
            boolean r2 = r3.mkdirs()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r2 != 0) goto L_0x0029
            boolean r3 = r3.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r3 != 0) goto L_0x0029
            return r0
        L_0x0029:
            boolean r3 = r1.createNewFile()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r3 != 0) goto L_0x0030
            return r0
        L_0x0030:
            java.lang.String r3 = "uri"
            boolean r3 = r4.equalsIgnoreCase(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r3 == 0) goto L_0x007b
            java.lang.String r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r5)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            boolean r3 = r4.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            if (r3 != 0) goto L_0x0048
            return r0
        L_0x0048:
            r3 = 10240(0x2800, float:1.4349E-41)
            byte[] r3 = new byte[r3]     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r5 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x006e }
            r2.<init>(r4)     // Catch:{ all -> 0x006e }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x006a }
            r4.<init>(r1, r6)     // Catch:{ all -> 0x006a }
        L_0x0057:
            int r5 = r2.read(r3)     // Catch:{ all -> 0x0068 }
            if (r5 <= 0) goto L_0x0061
            r4.write(r3, r0, r5)     // Catch:{ all -> 0x0068 }
            goto L_0x0057
        L_0x0061:
            r2.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            goto L_0x008b
        L_0x0068:
            r3 = move-exception
            goto L_0x006c
        L_0x006a:
            r3 = move-exception
            r4 = r5
        L_0x006c:
            r5 = r2
            goto L_0x0070
        L_0x006e:
            r3 = move-exception
            r4 = r5
        L_0x0070:
            if (r5 == 0) goto L_0x0075
            r5.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
        L_0x0075:
            if (r4 == 0) goto L_0x007a
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
        L_0x007a:
            throw r3     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
        L_0x007b:
            byte[] r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.stringToBytes(r5, r4)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r4.<init>(r1, r6)     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            r4.write(r3)     // Catch:{ all -> 0x008d }
            int r3 = r3.length     // Catch:{ all -> 0x008d }
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
        L_0x008b:
            r3 = 1
            return r3
        L_0x008d:
            r3 = move-exception
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
            throw r3     // Catch:{ FileNotFoundException | Exception -> 0x0092 }
        L_0x0092:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.writeFile(java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c7 A[Catch:{ all -> 0x00fd, FileNotFoundException -> 0x010b, Exception -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cc A[Catch:{ all -> 0x00fd, FileNotFoundException -> 0x010b, Exception -> 0x0102 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void writeFile(java.lang.String r6, java.lang.String r7, java.lang.String r8, boolean r9, boolean r10, com.facebook.react.bridge.Promise r11) {
        /*
            java.lang.String r0 = "EUNSPECIFIED"
            java.lang.String r1 = "File '"
            java.lang.String r2 = "ENOENT"
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.io.File r4 = r3.getParentFile()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            boolean r5 = r3.exists()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            if (r5 != 0) goto L_0x0061
            if (r4 == 0) goto L_0x0043
            boolean r5 = r4.exists()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            if (r5 != 0) goto L_0x0043
            boolean r5 = r4.mkdirs()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            if (r5 != 0) goto L_0x0043
            boolean r4 = r4.exists()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            if (r4 != 0) goto L_0x0043
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.lang.String r8 = "Failed to create parent directory of '"
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r7.append(r6)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.lang.String r8 = "'"
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r11.reject((java.lang.String) r0, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            return
        L_0x0043:
            boolean r4 = r3.createNewFile()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            if (r4 != 0) goto L_0x0061
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r7.append(r1)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r7.append(r6)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.lang.String r8 = "' does not exist and could not be created"
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r11.reject((java.lang.String) r2, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            return
        L_0x0061:
            java.lang.String r4 = "uri"
            boolean r4 = r7.equalsIgnoreCase(r4)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            if (r4 == 0) goto L_0x00d0
            java.lang.String r7 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r8)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.io.File r8 = new java.io.File     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r8.<init>(r7)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            boolean r9 = r8.exists()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            if (r9 != 0) goto L_0x009a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.lang.String r9 = "No such file '"
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r8.append(r6)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.lang.String r9 = "' ('"
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r8.append(r7)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.lang.String r7 = "')"
            r8.append(r7)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.lang.String r7 = r8.toString()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r11.reject((java.lang.String) r2, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            return
        L_0x009a:
            r7 = 10240(0x2800, float:1.4349E-41)
            byte[] r7 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r9 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x00c3 }
            r4.<init>(r8)     // Catch:{ all -> 0x00c3 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x00bf }
            r8.<init>(r3, r10)     // Catch:{ all -> 0x00bf }
            r9 = 0
            r10 = 0
        L_0x00ab:
            int r3 = r4.read(r7)     // Catch:{ all -> 0x00bd }
            if (r3 <= 0) goto L_0x00b6
            r8.write(r7, r9, r3)     // Catch:{ all -> 0x00bd }
            int r10 = r10 + r3
            goto L_0x00ab
        L_0x00b6:
            r4.close()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r8.close()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            goto L_0x00f5
        L_0x00bd:
            r7 = move-exception
            goto L_0x00c1
        L_0x00bf:
            r7 = move-exception
            r8 = r9
        L_0x00c1:
            r9 = r4
            goto L_0x00c5
        L_0x00c3:
            r7 = move-exception
            r8 = r9
        L_0x00c5:
            if (r9 == 0) goto L_0x00ca
            r9.close()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
        L_0x00ca:
            if (r8 == 0) goto L_0x00cf
            r8.close()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
        L_0x00cf:
            throw r7     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
        L_0x00d0:
            byte[] r7 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.stringToBytes(r8, r7)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            if (r9 == 0) goto L_0x00e9
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r8 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            if (r8 == 0) goto L_0x00e1
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r8 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            byte[] r7 = r8.onWriteFile(r7)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            goto L_0x00e9
        L_0x00e1:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            java.lang.String r8 = "Write file with transform was specified but the shared file transformer is not set"
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            throw r7     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
        L_0x00e9:
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r8.<init>(r3, r10)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r8.write(r7)     // Catch:{ all -> 0x00fd }
            int r10 = r7.length     // Catch:{ all -> 0x00fd }
            r8.close()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
        L_0x00f5:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            r11.resolve(r7)     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            goto L_0x0122
        L_0x00fd:
            r7 = move-exception
            r8.close()     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
            throw r7     // Catch:{ FileNotFoundException -> 0x010b, Exception -> 0x0102 }
        L_0x0102:
            r6 = move-exception
            java.lang.String r6 = r6.getLocalizedMessage()
            r11.reject((java.lang.String) r0, (java.lang.String) r6)
            goto L_0x0122
        L_0x010b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            r7.append(r6)
            java.lang.String r6 = "' does not exist and could not be created, or it is a directory"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r11.reject((java.lang.String) r2, (java.lang.String) r6)
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.writeFile(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, com.facebook.react.bridge.Promise):void");
    }

    static void writeFile(String str, ReadableArray readableArray, boolean z, Promise promise) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                    promise.reject("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            fileOutputStream = new FileOutputStream(file, z);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            promise.resolve(Integer.valueOf(readableArray.size()));
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0076 A[Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0093 A[Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void readFile(java.lang.String r7, java.lang.String r8, boolean r9, com.facebook.react.bridge.Promise r10) {
        /*
            java.lang.String r0 = "bundle-assets://"
            java.lang.String r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r7)
            if (r1 == 0) goto L_0x0009
            r7 = r1
        L_0x0009:
            java.lang.String r2 = "EUNSPECIFIED"
            r3 = 0
            if (r1 == 0) goto L_0x003d
            boolean r4 = r1.startsWith(r0)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            if (r4 == 0) goto L_0x003d
            java.lang.String r1 = ""
            java.lang.String r0 = r7.replace(r0, r1)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            com.facebook.react.bridge.ReactApplicationContext r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            android.content.res.AssetFileDescriptor r1 = r1.openFd(r0)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            long r4 = r1.getLength()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            int r1 = (int) r4     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            byte[] r4 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            com.facebook.react.bridge.ReactApplicationContext r5 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            java.io.InputStream r0 = r5.open(r0)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            int r5 = r0.read(r4, r3, r1)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r0.close()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            goto L_0x0074
        L_0x003d:
            if (r1 != 0) goto L_0x005b
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            android.net.Uri r1 = android.net.Uri.parse(r7)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            java.io.InputStream r0 = r0.openInputStream(r1)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            int r1 = r0.available()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            byte[] r4 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            int r5 = r0.read(r4)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r0.close()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            goto L_0x0074
        L_0x005b:
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r0.<init>(r7)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            long r4 = r0.length()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            int r1 = (int) r4     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            byte[] r4 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r5.<init>(r0)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            int r0 = r5.read(r4)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r5.close()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r5 = r0
        L_0x0074:
            if (r5 >= r1) goto L_0x0093
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            java.lang.String r9 = "Read only "
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r8.append(r5)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            java.lang.String r9 = " bytes of "
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r8.append(r1)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r10.reject((java.lang.String) r2, (java.lang.String) r8)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            return
        L_0x0093:
            if (r9 == 0) goto L_0x00a8
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            if (r9 == 0) goto L_0x00a0
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            byte[] r4 = r9.onReadFile(r4)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            goto L_0x00a8
        L_0x00a0:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            java.lang.String r9 = "Read file with transform was specified but the shared file transformer is not set"
            r8.<init>(r9)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            throw r8     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
        L_0x00a8:
            java.util.Locale r9 = java.util.Locale.ROOT     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            java.lang.String r8 = r8.toLowerCase(r9)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r9 = -1
            int r0 = r8.hashCode()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r1 = -1396204209(0xffffffffacc79d4f, float:-5.673385E-12)
            r5 = 2
            r6 = 1
            if (r0 == r1) goto L_0x00d9
            r1 = 3600241(0x36ef71, float:5.045012E-39)
            if (r0 == r1) goto L_0x00cf
            r1 = 93106001(0x58caf51, float:1.3229938E-35)
            if (r0 == r1) goto L_0x00c5
            goto L_0x00e2
        L_0x00c5:
            java.lang.String r0 = "ascii"
            boolean r8 = r8.equals(r0)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            if (r8 == 0) goto L_0x00e2
            r9 = 1
            goto L_0x00e2
        L_0x00cf:
            java.lang.String r0 = "utf8"
            boolean r8 = r8.equals(r0)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            if (r8 == 0) goto L_0x00e2
            r9 = 2
            goto L_0x00e2
        L_0x00d9:
            java.lang.String r0 = "base64"
            boolean r8 = r8.equals(r0)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            if (r8 == 0) goto L_0x00e2
            r9 = 0
        L_0x00e2:
            if (r9 == 0) goto L_0x010e
            if (r9 == r6) goto L_0x00fb
            if (r9 == r5) goto L_0x00f2
            java.lang.String r8 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r8.<init>(r4)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            goto L_0x0167
        L_0x00f2:
            java.lang.String r8 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r8.<init>(r4)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            goto L_0x0167
        L_0x00fb:
            com.facebook.react.bridge.WritableArray r8 = com.facebook.react.bridge.Arguments.createArray()     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            int r9 = r4.length     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
        L_0x0100:
            if (r3 >= r9) goto L_0x010a
            byte r0 = r4[r3]     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r8.pushInt(r0)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            int r3 = r3 + 1
            goto L_0x0100
        L_0x010a:
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            goto L_0x0167
        L_0x010e:
            java.lang.String r8 = android.util.Base64.encodeToString(r4, r5)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x011f, Exception -> 0x0116 }
            goto L_0x0167
        L_0x0116:
            r7 = move-exception
            java.lang.String r7 = r7.getLocalizedMessage()
            r10.reject((java.lang.String) r2, (java.lang.String) r7)
            goto L_0x0167
        L_0x011f:
            r8 = move-exception
            java.lang.String r8 = r8.getLocalizedMessage()
            java.lang.String r9 = "EISDIR"
            boolean r0 = r8.contains(r9)
            if (r0 == 0) goto L_0x0149
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expecting a file but '"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = "' is a directory; "
            r0.append(r7)
            r0.append(r8)
            java.lang.String r7 = r0.toString()
            r10.reject((java.lang.String) r9, (java.lang.String) r7)
            goto L_0x0167
        L_0x0149:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "No such file '"
            r9.append(r0)
            r9.append(r7)
            java.lang.String r7 = "'; "
            r9.append(r7)
            r9.append(r8)
            java.lang.String r7 = r9.toString()
            java.lang.String r8 = "ENOENT"
            r10.reject((java.lang.String) r8, (java.lang.String) r7)
        L_0x0167:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.readFile(java.lang.String, java.lang.String, boolean, com.facebook.react.bridge.Promise):void");
    }

    static Map<String, Object> getSystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        hashMap.put("DocumentDir", getFilesDirPath(reactApplicationContext));
        hashMap.put("CacheDir", getCacheDirPath(reactApplicationContext));
        hashMap.put("DCIMDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DCIM));
        hashMap.put("PictureDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_PICTURES));
        hashMap.put("MusicDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MUSIC));
        hashMap.put("DownloadDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DOWNLOADS));
        hashMap.put("MovieDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MOVIES));
        hashMap.put("RingtoneDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_RINGTONES));
        if (Environment.getExternalStorageState().equals("mounted")) {
            hashMap.put("SDCardDir", getExternalFilesDirPath(reactApplicationContext, (String) null));
            File externalFilesDir = reactApplicationContext.getExternalFilesDir((String) null);
            if (externalFilesDir == null || externalFilesDir.getParentFile() == null) {
                hashMap.put("SDCardApplicationDir", "");
            } else {
                hashMap.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            }
        }
        hashMap.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        return hashMap;
    }

    static String getExternalFilesDirPath(ReactApplicationContext reactApplicationContext, String str) {
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(str);
        return externalFilesDir != null ? externalFilesDir.getAbsolutePath() : "";
    }

    static String getFilesDirPath(ReactApplicationContext reactApplicationContext) {
        File filesDir = reactApplicationContext.getFilesDir();
        return filesDir != null ? filesDir.getAbsolutePath() : "";
    }

    static String getCacheDirPath(ReactApplicationContext reactApplicationContext) {
        File cacheDir = reactApplicationContext.getCacheDir();
        return cacheDir != null ? cacheDir.getAbsolutePath() : "";
    }

    public static void getSDCardDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir((String) null).getAbsolutePath());
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardDir", e.getLocalizedMessage());
            }
        } else {
            promise.reject("ReactNativeBlobUtil.getSDCardDir", "External storage not mounted");
        }
    }

    public static void getSDCardApplicationDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir((String) null).getParentFile().getAbsolutePath());
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", e.getLocalizedMessage());
            }
        } else {
            promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", "External storage not mounted");
        }
    }

    static String getTmpPath(String str) {
        return ReactNativeBlobUtil.RCTContext.getFilesDir() + "/ReactNativeBlobUtilTmp_" + str;
    }

    static void unlink(String str, Callback callback) {
        try {
            deleteRecursive(new File(ReactNativeBlobUtilUtils.normalizePath(str)));
            callback.invoke(null, true);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), false);
        }
    }

    private static void deleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File deleteRecursive : listFiles) {
                    deleteRecursive(deleteRecursive);
                }
            } else {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete '" + file + "'");
        }
    }

    static void mkdir(String str, Promise promise) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        File file = new File(normalizePath);
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(file.isDirectory() ? "Folder" : "File");
            sb.append(" '");
            sb.append(normalizePath);
            sb.append("' already exists");
            promise.reject("EEXIST", sb.toString());
            return;
        }
        try {
            if (!file.mkdirs()) {
                promise.reject("EUNSPECIFIED", "mkdir failed to create some or all directories in '" + normalizePath + "'");
                return;
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c6 A[SYNTHETIC, Splitter:B:44:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ce A[Catch:{ Exception -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f8 A[SYNTHETIC, Splitter:B:56:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0100 A[Catch:{ Exception -> 0x00fc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void cp(java.lang.String r6, java.lang.String r7, com.facebook.react.bridge.Callback r8) {
        /*
            java.lang.String r0 = ""
            java.lang.String r6 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r6)
            java.lang.String r7 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r7)
            r1 = 0
            r2 = 1
            r3 = 0
            boolean r4 = isPathExists(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            if (r4 != 0) goto L_0x0031
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r4.<init>()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r5 = "Source file at path`"
            r4.append(r5)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r4.append(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r6 = "` does not exist"
            r4.append(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r7[r3] = r6     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r8.invoke(r7)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            return
        L_0x0031:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            boolean r4 = r4.exists()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            if (r4 != 0) goto L_0x0065
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            boolean r4 = r4.createNewFile()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            if (r4 != 0) goto L_0x0065
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r4.<init>()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r5 = "Destination file at '"
            r4.append(r5)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r4.append(r7)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r7 = "' already exists"
            r4.append(r7)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r6[r3] = r7     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r8.invoke(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            return
        L_0x0065:
            java.io.InputStream r6 = inputStreamFromPath(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a7, all -> 0x00a2 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00a7, all -> 0x00a2 }
            r7 = 10240(0x2800, float:1.4349E-41)
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x00a0, all -> 0x009e }
        L_0x0072:
            int r1 = r6.read(r7)     // Catch:{ Exception -> 0x00a0, all -> 0x009e }
            if (r1 <= 0) goto L_0x007c
            r4.write(r7, r3, r1)     // Catch:{ Exception -> 0x00a0, all -> 0x009e }
            goto L_0x0072
        L_0x007c:
            if (r6 == 0) goto L_0x0084
            r6.close()     // Catch:{ Exception -> 0x0082 }
            goto L_0x0084
        L_0x0082:
            r6 = move-exception
            goto L_0x008a
        L_0x0084:
            r4.close()     // Catch:{ Exception -> 0x0082 }
            r6 = r0
            goto L_0x00e5
        L_0x008a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            java.lang.String r6 = r6.getLocalizedMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            goto L_0x00e5
        L_0x009e:
            r7 = move-exception
            goto L_0x00a4
        L_0x00a0:
            r7 = move-exception
            goto L_0x00a9
        L_0x00a2:
            r7 = move-exception
            r4 = r1
        L_0x00a4:
            r1 = r6
            r6 = r7
            goto L_0x00f6
        L_0x00a7:
            r7 = move-exception
            r4 = r1
        L_0x00a9:
            r1 = r6
            r6 = r7
            goto L_0x00b1
        L_0x00ac:
            r6 = move-exception
            r4 = r1
            goto L_0x00f6
        L_0x00af:
            r6 = move-exception
            r4 = r1
        L_0x00b1:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
            r7.<init>()     // Catch:{ all -> 0x00f5 }
            r7.append(r0)     // Catch:{ all -> 0x00f5 }
            java.lang.String r6 = r6.getLocalizedMessage()     // Catch:{ all -> 0x00f5 }
            r7.append(r6)     // Catch:{ all -> 0x00f5 }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x00cc
            r1.close()     // Catch:{ Exception -> 0x00ca }
            goto L_0x00cc
        L_0x00ca:
            r7 = move-exception
            goto L_0x00d2
        L_0x00cc:
            if (r4 == 0) goto L_0x00e5
            r4.close()     // Catch:{ Exception -> 0x00ca }
            goto L_0x00e5
        L_0x00d2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r6 = r7.getLocalizedMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
        L_0x00e5:
            if (r6 == r0) goto L_0x00ef
            java.lang.Object[] r7 = new java.lang.Object[r2]
            r7[r3] = r6
            r8.invoke(r7)
            goto L_0x00f4
        L_0x00ef:
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r8.invoke(r6)
        L_0x00f4:
            return
        L_0x00f5:
            r6 = move-exception
        L_0x00f6:
            if (r1 == 0) goto L_0x00fe
            r1.close()     // Catch:{ Exception -> 0x00fc }
            goto L_0x00fe
        L_0x00fc:
            r7 = move-exception
            goto L_0x0104
        L_0x00fe:
            if (r4 == 0) goto L_0x0107
            r4.close()     // Catch:{ Exception -> 0x00fc }
            goto L_0x0107
        L_0x0104:
            r7.getLocalizedMessage()
        L_0x0107:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.cp(java.lang.String, java.lang.String, com.facebook.react.bridge.Callback):void");
    }

    static void mv(String str, String str2, Callback callback) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        String normalizePath2 = ReactNativeBlobUtilUtils.normalizePath(str2);
        File file = new File(normalizePath);
        if (!file.exists()) {
            callback.invoke("Source file at path `" + normalizePath + "` does not exist");
            return;
        }
        try {
            File file2 = new File(normalizePath2);
            File parentFile = file2.getParentFile();
            if (parentFile == null || parentFile.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                if (!file.renameTo(file2)) {
                    callback.invoke("mv failed for unknown reasons");
                    return;
                }
                callback.invoke(new Object[0]);
                return;
            }
            callback.invoke("mv failed because the destination directory doesn't exist");
        } catch (Exception e) {
            callback.invoke(e.toString());
        }
    }

    static void exists(String str, Callback callback) {
        if (isAsset(str)) {
            try {
                ReactNativeBlobUtil.RCTContext.getAssets().openFd(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                callback.invoke(true, false);
            } catch (IOException unused) {
                callback.invoke(false, false);
            }
        } else {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            if (normalizePath != null) {
                callback.invoke(Boolean.valueOf(new File(normalizePath).exists()), Boolean.valueOf(new File(normalizePath).isDirectory()));
                return;
            }
            callback.invoke(false, false);
        }
    }

    static void ls(String str, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + normalizePath + "'");
            } else if (!file.isDirectory()) {
                promise.reject("ENOTDIR", "Not a directory '" + normalizePath + "'");
            } else {
                String[] list = new File(normalizePath).list();
                WritableArray createArray = Arguments.createArray();
                for (String pushString : list) {
                    createArray.pushString(pushString);
                }
                promise.resolve(createArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void slice(String str, String str2, int i, int i2, String str3, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            String normalizePath2 = ReactNativeBlobUtilUtils.normalizePath(str2);
            File file = new File(normalizePath);
            if (file.isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + normalizePath + "' is a directory");
            } else if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + normalizePath + "'");
            } else {
                int length = (int) file.length();
                int min = Math.min(length, i2) - i;
                FileInputStream fileInputStream = new FileInputStream(new File(normalizePath));
                FileOutputStream fileOutputStream = new FileOutputStream(new File(normalizePath2));
                int skip = (int) fileInputStream.skip((long) i);
                if (skip != i) {
                    promise.reject("EUNSPECIFIED", "Skipped " + skip + " instead of the specified " + i + " bytes, size is " + length);
                    return;
                }
                byte[] bArr = new byte[10240];
                int i3 = 0;
                while (true) {
                    if (i3 >= min) {
                        break;
                    }
                    int read = fileInputStream.read(bArr, 0, 10240);
                    int i4 = min - i3;
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, Math.min(i4, read));
                    i3 += read;
                }
                fileInputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                promise.resolve(normalizePath2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void lstat(String str, final Callback callback) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        new AsyncTask<String, Integer, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(String... strArr) {
                WritableArray createArray = Arguments.createArray();
                if (strArr[0] == null) {
                    Callback.this.invoke("the path specified for lstat is either `null` or `undefined`.");
                    return 0;
                }
                File file = new File(strArr[0]);
                if (!file.exists()) {
                    Callback.this.invoke("failed to lstat path `" + strArr[0] + "` because it does not exist or it is not a folder");
                    return 0;
                }
                if (file.isDirectory()) {
                    for (String str : file.list()) {
                        createArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getPath() + "/" + str));
                    }
                } else {
                    createArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getAbsolutePath()));
                }
                Callback.this.invoke(null, createArray);
                return 0;
            }
        }.execute(new String[]{normalizePath});
    }

    static void stat(String str, Callback callback) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap statFile = statFile(normalizePath);
            if (statFile == null) {
                callback.invoke("failed to stat path `" + normalizePath + "` because it does not exist or it is not a folder", null);
                return;
            }
            callback.invoke(null, statFile);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static WritableMap statFile(String str) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap createMap = Arguments.createMap();
            if (isAsset(normalizePath)) {
                String replace = normalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "");
                AssetFileDescriptor openFd = ReactNativeBlobUtil.RCTContext.getAssets().openFd(replace);
                createMap.putString("filename", replace);
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, normalizePath);
                createMap.putString("type", UriUtil.LOCAL_ASSET_SCHEME);
                createMap.putString("size", String.valueOf(openFd.getLength()));
                createMap.putInt("lastModified", 0);
            } else {
                File file = new File(normalizePath);
                if (!file.exists()) {
                    return null;
                }
                createMap.putString("filename", file.getName());
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, file.getPath());
                createMap.putString("type", file.isDirectory() ? "directory" : UriUtil.LOCAL_FILE_SCHEME);
                createMap.putString("size", String.valueOf(file.length()));
                createMap.putString("lastModified", String.valueOf(file.lastModified()));
            }
            return createMap;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void scanFile(String[] strArr, String[] strArr2, final Callback callback) {
        try {
            MediaScannerConnection.scanFile(this.mCtx, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                    callback.invoke(null, true);
                }
            });
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    static void hash(String str, String str2, Promise promise) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("md5", "MD5");
            hashMap.put("sha1", McElieceCCA2KeyGenParameterSpec.SHA1);
            hashMap.put("sha224", McElieceCCA2KeyGenParameterSpec.SHA224);
            hashMap.put("sha256", "SHA-256");
            hashMap.put("sha384", McElieceCCA2KeyGenParameterSpec.SHA384);
            hashMap.put("sha512", "SHA-512");
            if (!hashMap.containsKey(str2)) {
                promise.reject("EINVAL", "Invalid algorithm '" + str2 + "', must be one of md5, sha1, sha224, sha256, sha384, sha512");
                return;
            }
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            if (file.isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + normalizePath + "' is a directory");
            } else if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + normalizePath + "'");
            } else {
                MessageDigest instance = MessageDigest.getInstance((String) hashMap.get(str2));
                FileInputStream fileInputStream = new FileInputStream(normalizePath);
                byte[] bArr = new byte[1048576];
                if (file.length() != 0) {
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    }
                }
                StringBuilder sb = new StringBuilder();
                byte[] digest = instance.digest();
                int length = digest.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i])}));
                }
                promise.resolve(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFile(String str, String str2, String str3, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            boolean createNewFile = file.createNewFile();
            if (str3.equals("uri")) {
                File file2 = new File(str2.replace(ReactNativeBlobUtilConst.FILE_PREFIX, ""));
                if (!file2.exists()) {
                    promise.reject("ENOENT", "Source file : " + str2 + " does not exist");
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(file2);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[10240];
                for (int read = fileInputStream.read(bArr); read > 0; read = fileInputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } else if (!createNewFile) {
                promise.reject("EEXIST", "File `" + normalizePath + "` already exists");
                return;
            } else {
                new FileOutputStream(file).write(ReactNativeBlobUtilUtils.stringToBytes(str2, str3));
            }
            promise.resolve(normalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            if (!file.createNewFile()) {
                promise.reject("EEXIST", "File at path `" + normalizePath + "` already exists");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            promise.resolve(normalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void df(Callback callback, ReactApplicationContext reactApplicationContext) {
        StatFs statFs = new StatFs(reactApplicationContext.getFilesDir().getPath());
        WritableMap createMap = Arguments.createMap();
        if (Build.VERSION.SDK_INT >= 18) {
            createMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
            createMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
            File externalFilesDir = reactApplicationContext.getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                StatFs statFs2 = new StatFs(externalFilesDir.getPath());
                createMap.putString("external_free", String.valueOf(statFs2.getFreeBytes()));
                createMap.putString("external_total", String.valueOf(statFs2.getTotalBytes()));
            } else {
                createMap.putString("external_free", "-1");
                createMap.putString("external_total", "-1");
            }
        }
        callback.invoke(null, createMap);
    }

    static void removeSession(ReadableArray readableArray, final Callback callback) {
        new AsyncTask<ReadableArray, Integer, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(ReadableArray... readableArrayArr) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < readableArrayArr[0].size(); i++) {
                        String string = readableArrayArr[0].getString(i);
                        File file = new File(string);
                        if (file.exists() && !file.delete()) {
                            arrayList.add(string);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        Callback.this.invoke(null, true);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to delete: ");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            sb.append((String) it.next());
                            sb.append(", ");
                        }
                        Callback.this.invoke(sb.toString());
                    }
                } catch (Exception e) {
                    Callback.this.invoke(e.getLocalizedMessage());
                }
                return Integer.valueOf(readableArrayArr[0].size());
            }
        }.execute(new ReadableArray[]{readableArray});
    }

    private static InputStream inputStreamFromPath(String str) throws IOException {
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return ReactNativeBlobUtil.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
        }
        return new FileInputStream(new File(str));
    }

    private static boolean isPathExists(String str) {
        if (!str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return new File(str).exists();
        }
        try {
            ReactNativeBlobUtil.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    static boolean isAsset(String str) {
        return str != null && str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET);
    }
}

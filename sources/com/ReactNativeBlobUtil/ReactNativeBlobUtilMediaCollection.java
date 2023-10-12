package com.ReactNativeBlobUtil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import com.ReactNativeBlobUtil.Utils.FileDescription;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ReactNativeBlobUtilMediaCollection {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public enum MediaType {
        Audio,
        Image,
        Video,
        Download
    }

    private static Uri getMediaUri(MediaType mediaType) {
        if (mediaType == MediaType.Audio) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Audio.Media.getContentUri("external_primary");
            }
            return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else if (mediaType == MediaType.Video) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Video.Media.getContentUri("external_primary");
            }
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else if (mediaType == MediaType.Image) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Images.Media.getContentUri("external_primary");
            }
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (mediaType != MediaType.Download || Build.VERSION.SDK_INT < 29) {
            return null;
        } else {
            return MediaStore.Downloads.getContentUri("external_primary");
        }
    }

    private static String getRelativePath(MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (mediaType == MediaType.Audio) {
                return Environment.DIRECTORY_MUSIC;
            }
            if (mediaType == MediaType.Video) {
                return Environment.DIRECTORY_MOVIES;
            }
            if (mediaType == MediaType.Image) {
                return Environment.DIRECTORY_PICTURES;
            }
            if (mediaType == MediaType.Download) {
                return Environment.DIRECTORY_DOWNLOADS;
            }
            return Environment.DIRECTORY_DOWNLOADS;
        } else if (mediaType == MediaType.Audio) {
            return ReactNativeBlobUtilFS.getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MUSIC);
        } else {
            if (mediaType == MediaType.Video) {
                return ReactNativeBlobUtilFS.getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MOVIES);
            }
            if (mediaType == MediaType.Image) {
                return ReactNativeBlobUtilFS.getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_PICTURES);
            }
            if (mediaType == MediaType.Download) {
                return ReactNativeBlobUtilFS.getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DOWNLOADS);
            }
            return ReactNativeBlobUtilFS.getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DOWNLOADS);
        }
    }

    public static Uri createNewMediaFile(FileDescription fileDescription, MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        ContentResolver contentResolver = ReactNativeBlobUtil.RCTContext.getApplicationContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        String relativePath = getRelativePath(mediaType, reactApplicationContext);
        String str = fileDescription.mimeType;
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("date_modified", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("mime_type", str);
            contentValues.put("_display_name", fileDescription.name);
            contentValues.put("relative_path", relativePath + '/' + fileDescription.partentFolder);
            return contentResolver.insert(getMediaUri(mediaType), contentValues);
        }
        File file = new File(relativePath + fileDescription.getFullPath());
        if (file.exists()) {
            return Uri.fromFile(file);
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            return null;
        }
        try {
            file.createNewFile();
            return Uri.fromFile(file);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cd A[SYNTHETIC, Splitter:B:47:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d5 A[Catch:{ IOException -> 0x00d9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean writeToMediaFile(android.net.Uri r10, java.lang.String r11, boolean r12, com.facebook.react.bridge.Promise r13) {
        /*
            java.lang.String r0 = "Failed to get output stream."
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 0
            r3 = 29
            if (r1 < r3) goto L_0x00e1
            com.facebook.react.bridge.ReactApplicationContext r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext     // Catch:{ IOException -> 0x00d9 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ IOException -> 0x00d9 }
            android.content.ContentResolver r3 = r1.getContentResolver()     // Catch:{ IOException -> 0x00d9 }
            r4 = 0
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r5 = "w"
            android.os.ParcelFileDescriptor r1 = r1.openFileDescriptor(r10, r5)     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r11 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r11)     // Catch:{ Exception -> 0x00b4 }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00b4 }
            r5.<init>(r11)     // Catch:{ Exception -> 0x00b4 }
            boolean r6 = r5.exists()     // Catch:{ Exception -> 0x00b4 }
            if (r6 != 0) goto L_0x0049
            java.lang.String r10 = "ENOENT"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b4 }
            r12.<init>()     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r1 = "No such file ('"
            r12.append(r1)     // Catch:{ Exception -> 0x00b4 }
            r12.append(r11)     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r11 = "')"
            r12.append(r11)     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x00b4 }
            r13.reject((java.lang.String) r10, (java.lang.String) r11)     // Catch:{ Exception -> 0x00b4 }
            return r2
        L_0x0049:
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b4 }
            r11.<init>(r5)     // Catch:{ Exception -> 0x00b4 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b4 }
            java.io.FileDescriptor r7 = r1.getFileDescriptor()     // Catch:{ Exception -> 0x00b4 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00b4 }
            if (r12 == 0) goto L_0x0079
            long r7 = r5.length()     // Catch:{ Exception -> 0x00b4 }
            int r12 = (int) r7     // Catch:{ Exception -> 0x00b4 }
            byte[] r12 = new byte[r12]     // Catch:{ Exception -> 0x00b4 }
            r11.read(r12)     // Catch:{ Exception -> 0x00b4 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r5 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ Exception -> 0x00b4 }
            if (r5 == 0) goto L_0x0071
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r5 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ Exception -> 0x00b4 }
            byte[] r12 = r5.onWriteFile(r12)     // Catch:{ Exception -> 0x00b4 }
            r6.write(r12)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x0087
        L_0x0071:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r11 = "Write to media file with transform was specified but the shared file transformer is not set"
            r10.<init>(r11)     // Catch:{ Exception -> 0x00b4 }
            throw r10     // Catch:{ Exception -> 0x00b4 }
        L_0x0079:
            r12 = 10240(0x2800, float:1.4349E-41)
            byte[] r12 = new byte[r12]     // Catch:{ Exception -> 0x00b4 }
        L_0x007d:
            int r5 = r11.read(r12)     // Catch:{ Exception -> 0x00b4 }
            if (r5 <= 0) goto L_0x0087
            r6.write(r12, r2, r5)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x007d
        L_0x0087:
            r11.close()     // Catch:{ Exception -> 0x00b4 }
            r6.close()     // Catch:{ Exception -> 0x00b4 }
            r1.close()     // Catch:{ Exception -> 0x00b4 }
            java.io.OutputStream r10 = r3.openOutputStream(r10)     // Catch:{ IOException -> 0x00c3, all -> 0x00c1 }
            if (r10 != 0) goto L_0x00ad
            java.io.IOException r11 = new java.io.IOException     // Catch:{ IOException -> 0x00a8, all -> 0x00a4 }
            r11.<init>(r0)     // Catch:{ IOException -> 0x00a8, all -> 0x00a4 }
            r13.reject((java.lang.Throwable) r11)     // Catch:{ IOException -> 0x00a8, all -> 0x00a4 }
            if (r10 == 0) goto L_0x00a3
            r10.close()     // Catch:{ IOException -> 0x00d9 }
        L_0x00a3:
            return r2
        L_0x00a4:
            r11 = move-exception
            r4 = r10
            r10 = r11
            goto L_0x00d3
        L_0x00a8:
            r11 = move-exception
            r9 = r11
            r11 = r10
            r10 = r9
            goto L_0x00c5
        L_0x00ad:
            if (r10 == 0) goto L_0x00b2
            r10.close()     // Catch:{ IOException -> 0x00d9 }
        L_0x00b2:
            r10 = 1
            return r10
        L_0x00b4:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ IOException -> 0x00c3, all -> 0x00c1 }
            java.io.IOException r10 = new java.io.IOException     // Catch:{ IOException -> 0x00c3, all -> 0x00c1 }
            r10.<init>(r0)     // Catch:{ IOException -> 0x00c3, all -> 0x00c1 }
            r13.reject((java.lang.Throwable) r10)     // Catch:{ IOException -> 0x00c3, all -> 0x00c1 }
            return r2
        L_0x00c1:
            r10 = move-exception
            goto L_0x00d3
        L_0x00c3:
            r10 = move-exception
            r11 = r4
        L_0x00c5:
            r3.delete(r4, r4, r4)     // Catch:{ all -> 0x00d1 }
            r13.reject((java.lang.Throwable) r10)     // Catch:{ all -> 0x00d1 }
            if (r11 == 0) goto L_0x00d0
            r11.close()     // Catch:{ IOException -> 0x00d9 }
        L_0x00d0:
            return r2
        L_0x00d1:
            r10 = move-exception
            r4 = r11
        L_0x00d3:
            if (r4 == 0) goto L_0x00d8
            r4.close()     // Catch:{ IOException -> 0x00d9 }
        L_0x00d8:
            throw r10     // Catch:{ IOException -> 0x00d9 }
        L_0x00d9:
            java.lang.String r10 = "ReactNativeBlobUtil.createMediaFile"
            java.lang.String r11 = "Cannot write to file, file might not exist"
            r13.reject((java.lang.String) r10, (java.lang.String) r11)
            return r2
        L_0x00e1:
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r10)
            java.lang.String r12 = "uri"
            boolean r10 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.writeFile((java.lang.String) r10, (java.lang.String) r12, (java.lang.String) r11, (boolean) r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.writeToMediaFile(android.net.Uri, java.lang.String, boolean, com.facebook.react.bridge.Promise):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cc A[SYNTHETIC, Splitter:B:52:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d6 A[SYNTHETIC, Splitter:B:57:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e2 A[SYNTHETIC, Splitter:B:63:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ec A[SYNTHETIC, Splitter:B:68:0x00ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToInternal(android.net.Uri r4, java.lang.String r5, com.facebook.react.bridge.Promise r6) {
        /*
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtil.RCTContext
            android.content.Context r0 = r0.getApplicationContext()
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0075
            java.io.File r2 = r1.getParentFile()     // Catch:{ IOException -> 0x005c }
            if (r2 == 0) goto L_0x003c
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x005c }
            if (r3 != 0) goto L_0x003c
            boolean r2 = r2.mkdirs()     // Catch:{ IOException -> 0x005c }
            if (r2 != 0) goto L_0x003c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x005c }
            r1.<init>()     // Catch:{ IOException -> 0x005c }
            java.lang.String r2 = "ReactNativeBlobUtil.copyToInternal: Cannot create parent folders<'"
            r1.append(r2)     // Catch:{ IOException -> 0x005c }
            r1.append(r5)     // Catch:{ IOException -> 0x005c }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x005c }
            r6.reject((java.lang.String) r1)     // Catch:{ IOException -> 0x005c }
            return
        L_0x003c:
            boolean r1 = r1.createNewFile()     // Catch:{ IOException -> 0x005c }
            if (r1 != 0) goto L_0x0075
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x005c }
            r1.<init>()     // Catch:{ IOException -> 0x005c }
            java.lang.String r2 = "ReactNativeBlobUtil.copyToInternal: Destination file at '"
            r1.append(r2)     // Catch:{ IOException -> 0x005c }
            r1.append(r5)     // Catch:{ IOException -> 0x005c }
            java.lang.String r2 = "' already exists"
            r1.append(r2)     // Catch:{ IOException -> 0x005c }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x005c }
            r6.reject((java.lang.String) r1)     // Catch:{ IOException -> 0x005c }
            return
        L_0x005c:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ReactNativeBlobUtil.copyToInternal: Could not create file: "
            r2.append(r3)
            java.lang.String r1 = r1.getLocalizedMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r6.reject((java.lang.String) r1)
        L_0x0075:
            r1 = 0
            java.io.InputStream r4 = r0.openInputStream(r4)     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00a9, all -> 0x00a5 }
            r0.<init>(r5)     // Catch:{ IOException -> 0x00a9, all -> 0x00a5 }
            r5 = 10240(0x2800, float:1.4349E-41)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x00a3, all -> 0x00a1 }
        L_0x0083:
            int r1 = r4.read(r5)     // Catch:{ IOException -> 0x00a3, all -> 0x00a1 }
            if (r1 <= 0) goto L_0x008e
            r2 = 0
            r0.write(r5, r2, r1)     // Catch:{ IOException -> 0x00a3, all -> 0x00a1 }
            goto L_0x0083
        L_0x008e:
            if (r4 == 0) goto L_0x0098
            r4.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0098:
            r0.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00d9
        L_0x009c:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x00d9
        L_0x00a1:
            r5 = move-exception
            goto L_0x00a7
        L_0x00a3:
            r5 = move-exception
            goto L_0x00ab
        L_0x00a5:
            r5 = move-exception
            r0 = r1
        L_0x00a7:
            r1 = r4
            goto L_0x00e0
        L_0x00a9:
            r5 = move-exception
            r0 = r1
        L_0x00ab:
            r1 = r4
            goto L_0x00b2
        L_0x00ad:
            r5 = move-exception
            r0 = r1
            goto L_0x00e0
        L_0x00b0:
            r5 = move-exception
            r0 = r1
        L_0x00b2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r4.<init>()     // Catch:{ all -> 0x00df }
            java.lang.String r2 = "ReactNativeBlobUtil.copyToInternal:  Could not write data: "
            r4.append(r2)     // Catch:{ all -> 0x00df }
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x00df }
            r4.append(r5)     // Catch:{ all -> 0x00df }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00df }
            r6.reject((java.lang.String) r4)     // Catch:{ all -> 0x00df }
            if (r1 == 0) goto L_0x00d4
            r1.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00d4
        L_0x00d0:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00d4:
            if (r0 == 0) goto L_0x00d9
            r0.close()     // Catch:{ IOException -> 0x009c }
        L_0x00d9:
            java.lang.String r4 = ""
            r6.resolve(r4)
            return
        L_0x00df:
            r5 = move-exception
        L_0x00e0:
            if (r1 == 0) goto L_0x00ea
            r1.close()     // Catch:{ IOException -> 0x00e6 }
            goto L_0x00ea
        L_0x00e6:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00ea:
            if (r0 == 0) goto L_0x00f4
            r0.close()     // Catch:{ IOException -> 0x00f0 }
            goto L_0x00f4
        L_0x00f0:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00f4:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.copyToInternal(android.net.Uri, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    public static void getBlob(Uri uri, String str, Promise promise) {
        try {
            InputStream openInputStream = ReactNativeBlobUtil.RCTContext.getApplicationContext().getContentResolver().openInputStream(uri);
            int available = openInputStream.available();
            byte[] bArr = new byte[available];
            int read = openInputStream.read(bArr);
            openInputStream.close();
            if (read < available) {
                promise.reject("EUNSPECIFIED", "Read only " + read + " bytes of " + available);
                return;
            }
            String lowerCase = str.toLowerCase();
            char c = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != -1396204209) {
                if (hashCode == 93106001) {
                    if (lowerCase.equals("ascii")) {
                        c = 1;
                    }
                }
            } else if (lowerCase.equals(ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64)) {
                c = 0;
            }
            if (c == 0) {
                promise.resolve(Base64.encodeToString(bArr, 2));
            } else if (c != 1) {
                promise.resolve(new String(bArr));
            } else {
                WritableArray createArray = Arguments.createArray();
                for (int i = 0; i < available; i++) {
                    createArray.pushInt(bArr[i]);
                }
                promise.resolve(createArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

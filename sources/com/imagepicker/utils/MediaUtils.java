package com.imagepicker.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.ReadableMap;
import com.imagepicker.ResponseHelper;
import com.imagepicker.media.ImageConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.UUID;

public class MediaUtils {
    public static File createNewFile(Context context, ReadableMap readableMap, boolean z) {
        String str = "image-" + UUID.randomUUID().toString() + ".jpg";
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (ReadableMapUtils.hasAndNotNullReadableMap(readableMap, "storageOptions")) {
            ReadableMap map = readableMap.getMap("storageOptions");
            if (map.hasKey("privateDirectory") && map.getBoolean("privateDirectory")) {
                externalStoragePublicDirectory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            }
            if (ReadableMapUtils.hasAndNotEmptyString(map, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
                externalStoragePublicDirectory = new File(externalStoragePublicDirectory, map.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH));
            }
        } else if (z) {
            externalStoragePublicDirectory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        }
        File file = new File(externalStoragePublicDirectory, str);
        try {
            externalStoragePublicDirectory.mkdirs();
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ImageConfig getResizedImage(Context context, ReadableMap readableMap, ImageConfig imageConfig, int i, int i2, int i3) {
        int i4;
        int i5;
        ImageConfig imageConfig2;
        FileOutputStream fileOutputStream;
        Throwable th;
        ImageConfig imageConfig3 = imageConfig;
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        if (imageConfig3.maxWidth != 0 || imageConfig3.maxHeight != 0) {
            i5 = i;
            i4 = i2;
            while (true) {
                if ((imageConfig3.maxWidth != 0 && i5 <= imageConfig3.maxWidth * 2) || (imageConfig3.maxHeight != 0 && i4 <= imageConfig3.maxHeight * 2)) {
                    break;
                }
                Context context2 = context;
                ReadableMap readableMap2 = readableMap;
                int i6 = i3;
                options.inSampleSize *= 2;
                i4 /= 2;
                i5 /= 2;
            }
        } else {
            i5 = i;
            i4 = i2;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(imageConfig3.original.getAbsolutePath(), options);
        if (decodeFile == null) {
            return imageConfig3;
        }
        if (imageConfig3.maxWidth == 0 || imageConfig3.maxWidth > i5) {
            imageConfig2 = imageConfig3.withMaxWidth(i5);
        } else {
            imageConfig2 = imageConfig3;
        }
        if (imageConfig3.maxHeight == 0 || imageConfig3.maxWidth > i4) {
            imageConfig2 = imageConfig2.withMaxHeight(i4);
        }
        ImageConfig imageConfig4 = imageConfig2;
        double d = ((double) imageConfig4.maxWidth) / ((double) i5);
        double d2 = ((double) imageConfig4.maxHeight) / ((double) i4);
        if (d >= d2) {
            d = d2;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) imageConfig4.rotation);
        float f = (float) d;
        matrix.postScale(f, f);
        try {
            int attributeInt = new ExifInterface(imageConfig4.original.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt == 3) {
                matrix.postRotate(180.0f);
            } else if (attributeInt == 6) {
                matrix.postRotate(90.0f);
            } else if (attributeInt == 8) {
                matrix.postRotate(270.0f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, imageConfig4.quality, byteArrayOutputStream);
        if (i3 == 13001) {
            z = true;
        }
        Context context3 = context;
        File createNewFile = createNewFile(context, readableMap, !z);
        if (createNewFile == null) {
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            if (createBitmap != null) {
                createBitmap.recycle();
            }
            return imageConfig3;
        }
        ImageConfig withResizedFile = imageConfig4.withResizedFile(createNewFile);
        try {
            fileOutputStream = new FileOutputStream(withResizedFile.resized);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        if (createBitmap != null) {
            createBitmap.recycle();
        }
        return withResizedFile;
        throw th;
    }

    public static void removeUselessFiles(int i, ImageConfig imageConfig) {
        if (i == 13001) {
            if (imageConfig.original != null && imageConfig.original.exists()) {
                imageConfig.original.delete();
            }
            if (imageConfig.resized != null && imageConfig.resized.exists()) {
                imageConfig.resized.delete();
            }
        }
    }

    public static void fileScan(Context context, String str) {
        if (context != null) {
            MediaScannerConnection.scanFile(context, new String[]{str}, (String[]) null, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                    Log.i("TAG", "Finished scanning " + str);
                }
            });
        }
    }

    public static ReadExifResult readExifInterface(ResponseHelper responseHelper, ImageConfig imageConfig) {
        int i = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(imageConfig.original.getAbsolutePath());
            float[] fArr = new float[2];
            exifInterface.getLatLong(fArr);
            float f = fArr[0];
            boolean z = true;
            float f2 = fArr[1];
            if (!(f == 0.0f && f2 == 0.0f)) {
                responseHelper.putDouble("latitude", (double) f);
                responseHelper.putDouble("longitude", (double) f2);
            }
            String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                responseHelper.putString("timestamp", simpleDateFormat2.format(simpleDateFormat.parse(attribute)) + "Z");
            } catch (Exception unused) {
            }
            int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt == 6) {
                    i = 90;
                } else if (attributeInt == 8) {
                    i = 270;
                }
                z = false;
            } else {
                i = 180;
            }
            responseHelper.putInt("originalRotation", i);
            responseHelper.putBoolean("isVertical", z);
            return new ReadExifResult(i, (Throwable) null);
        } catch (IOException e) {
            e.printStackTrace();
            return new ReadExifResult(0, e);
        }
    }

    public static RolloutPhotoResult rolloutPhotoFromCamera(ImageConfig imageConfig) {
        ImageConfig imageConfig2;
        File file = imageConfig.resized == null ? imageConfig.original : imageConfig.resized;
        File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath(), file.getName());
        try {
            moveFile(file, file2);
            if (imageConfig.resized != null) {
                imageConfig2 = imageConfig.withResizedFile(file2);
            } else {
                imageConfig2 = imageConfig.withOriginalFile(file2);
            }
            return new RolloutPhotoResult(imageConfig2, (Throwable) null);
        } catch (IOException e) {
            e.printStackTrace();
            return new RolloutPhotoResult(imageConfig, e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b A[SYNTHETIC, Splitter:B:18:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043 A[Catch:{ IOException -> 0x003f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void moveFile(java.io.File r8, java.io.File r9) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0037 }
            r1.<init>(r8)     // Catch:{ all -> 0x0037 }
            java.nio.channels.FileChannel r1 = r1.getChannel()     // Catch:{ all -> 0x0037 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0033 }
            r2.<init>(r9)     // Catch:{ all -> 0x0033 }
            java.nio.channels.FileChannel r0 = r2.getChannel()     // Catch:{ all -> 0x0033 }
            r3 = 0
            long r5 = r1.size()     // Catch:{ all -> 0x0033 }
            r2 = r1
            r7 = r0
            r2.transferTo(r3, r5, r7)     // Catch:{ all -> 0x0033 }
            r8.delete()     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0029
        L_0x0027:
            r8 = move-exception
            goto L_0x002f
        L_0x0029:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0032
        L_0x002f:
            r8.printStackTrace()
        L_0x0032:
            return
        L_0x0033:
            r8 = move-exception
            r9 = r0
            r0 = r1
            goto L_0x0039
        L_0x0037:
            r8 = move-exception
            r9 = r0
        L_0x0039:
            if (r0 == 0) goto L_0x0041
            r0.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0041
        L_0x003f:
            r9 = move-exception
            goto L_0x0047
        L_0x0041:
            if (r9 == 0) goto L_0x004a
            r9.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x004a
        L_0x0047:
            r9.printStackTrace()
        L_0x004a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.utils.MediaUtils.moveFile(java.io.File, java.io.File):void");
    }

    public static class RolloutPhotoResult {
        public final Throwable error;
        public final ImageConfig imageConfig;

        public RolloutPhotoResult(ImageConfig imageConfig2, Throwable th) {
            this.imageConfig = imageConfig2;
            this.error = th;
        }
    }

    public static class ReadExifResult {
        public final int currentRotation;
        public final Throwable error;

        public ReadExifResult(int i, Throwable th) {
            this.currentRotation = i;
            this.error = th;
        }
    }
}

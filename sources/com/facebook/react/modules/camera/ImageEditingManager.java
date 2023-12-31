package com.facebook.react.modules.camera;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.fbreact.specs.NativeImageEditorSpec;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@ReactModule(name = "ImageEditingManager")
public class ImageEditingManager extends NativeImageEditorSpec {
    private static final int COMPRESS_QUALITY = 90;
    private static final String[] EXIF_ATTRIBUTES = {ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_ISO_SPEED_RATINGS, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_ORIENTATION, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE};
    private static final List<String> LOCAL_URI_PREFIXES = Arrays.asList(new String[]{"file://", ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT});
    public static final String NAME = "ImageEditingManager";
    private static final String TEMP_FILE_PREFIX = "ReactNative_cropped_image_";

    public String getName() {
        return NAME;
    }

    public ImageEditingManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        new CleanTask(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void onCatalystInstanceDestroy() {
        new CleanTask(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private static class CleanTask extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;

        private CleanTask(ReactContext reactContext) {
            super(reactContext);
            this.mContext = reactContext;
        }

        /* access modifiers changed from: protected */
        public void doInBackgroundGuarded(Void... voidArr) {
            cleanDirectory(this.mContext.getCacheDir());
            File externalCacheDir = this.mContext.getExternalCacheDir();
            if (externalCacheDir != null) {
                cleanDirectory(externalCacheDir);
            }
        }

        private void cleanDirectory(File file) {
            File[] listFiles = file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith(ImageEditingManager.TEMP_FILE_PREFIX);
                }
            });
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }
    }

    public void cropImage(String str, ReadableMap readableMap, Callback callback, Callback callback2) {
        ReadableMap readableMap2 = readableMap;
        ReadableMap readableMap3 = null;
        ReadableMap map = readableMap2.hasKey(TypedValues.CycleType.S_WAVE_OFFSET) ? readableMap2.getMap(TypedValues.CycleType.S_WAVE_OFFSET) : null;
        if (readableMap2.hasKey("size")) {
            readableMap3 = readableMap2.getMap("size");
        }
        boolean z = readableMap2.hasKey("allowExternalStorage") ? readableMap2.getBoolean("allowExternalStorage") : true;
        if (map == null || readableMap3 == null || !map.hasKey("x") || !map.hasKey(JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE) || !readableMap3.hasKey("width") || !readableMap3.hasKey("height")) {
            throw new JSApplicationIllegalArgumentException("Please specify offset and size");
        } else if (str == null || str.isEmpty()) {
            throw new JSApplicationIllegalArgumentException("Please specify a URI");
        } else {
            CropTask cropTask = r4;
            String str2 = "height";
            CropTask cropTask2 = new CropTask(getReactApplicationContext(), str, (int) map.getDouble("x"), (int) map.getDouble(JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE), (int) readableMap3.getDouble("width"), (int) readableMap3.getDouble("height"), z, callback, callback2);
            if (readableMap2.hasKey("displaySize")) {
                ReadableMap map2 = readableMap2.getMap("displaySize");
                cropTask.setTargetSize((int) map2.getDouble("width"), (int) map2.getDouble(str2));
            }
            cropTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    private static class CropTask extends GuardedAsyncTask<Void, Void> {
        final boolean mAllowExternalStorage;
        final Context mContext;
        final Callback mError;
        final int mHeight;
        final Callback mSuccess;
        int mTargetHeight;
        int mTargetWidth;
        final String mUri;
        final int mWidth;
        final int mX;
        final int mY;

        private CropTask(ReactContext reactContext, String str, int i, int i2, int i3, int i4, boolean z, Callback callback, Callback callback2) {
            super(reactContext);
            this.mTargetWidth = 0;
            this.mTargetHeight = 0;
            if (i < 0 || i2 < 0 || i3 <= 0 || i4 <= 0) {
                throw new JSApplicationIllegalArgumentException(String.format("Invalid crop rectangle: [%d, %d, %d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
            }
            this.mContext = reactContext;
            this.mUri = str;
            this.mX = i;
            this.mY = i2;
            this.mWidth = i3;
            this.mHeight = i4;
            this.mAllowExternalStorage = z;
            this.mSuccess = callback;
            this.mError = callback2;
        }

        public void setTargetSize(int i, int i2) {
            if (i <= 0 || i2 <= 0) {
                throw new JSApplicationIllegalArgumentException(String.format("Invalid target size: [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            this.mTargetWidth = i;
            this.mTargetHeight = i2;
        }

        private InputStream openBitmapInputStream() throws IOException {
            InputStream inputStream;
            if (ImageEditingManager.isLocalUri(this.mUri)) {
                inputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mUri));
            } else {
                inputStream = new URL(this.mUri).openConnection().getInputStream();
            }
            if (inputStream != null) {
                return inputStream;
            }
            throw new IOException("Cannot open bitmap: " + this.mUri);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(1:20)(2:25|26)) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
            if (r4.mAllowExternalStorage != false) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
            r2 = com.facebook.react.modules.camera.ImageEditingManager.access$400(r4.mContext, r2, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
            throw new java.lang.SecurityException("We couldn't create file in internal cache and external cache is disabled. Did you forget to pass allowExternalStorage=true?");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0030 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doInBackgroundGuarded(java.lang.Void... r5) {
            /*
                r4 = this;
                r5 = 0
                r0 = 1
                android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x006f }
                r1.<init>()     // Catch:{ Exception -> 0x006f }
                int r2 = r4.mTargetWidth     // Catch:{ Exception -> 0x006f }
                if (r2 <= 0) goto L_0x0011
                int r3 = r4.mTargetHeight     // Catch:{ Exception -> 0x006f }
                if (r3 <= 0) goto L_0x0011
                r3 = 1
                goto L_0x0012
            L_0x0011:
                r3 = 0
            L_0x0012:
                if (r3 == 0) goto L_0x001b
                int r3 = r4.mTargetHeight     // Catch:{ Exception -> 0x006f }
                android.graphics.Bitmap r2 = r4.cropAndResize(r2, r3, r1)     // Catch:{ Exception -> 0x006f }
                goto L_0x001f
            L_0x001b:
                android.graphics.Bitmap r2 = r4.crop(r1)     // Catch:{ Exception -> 0x006f }
            L_0x001f:
                java.lang.String r1 = r1.outMimeType     // Catch:{ Exception -> 0x006f }
                if (r1 == 0) goto L_0x0067
                boolean r3 = r1.isEmpty()     // Catch:{ Exception -> 0x006f }
                if (r3 != 0) goto L_0x0067
                android.content.Context r3 = r4.mContext     // Catch:{ Exception -> 0x0030 }
                java.io.File r2 = com.facebook.react.modules.camera.ImageEditingManager.writeBitmapToInternalCache(r3, r2, r1)     // Catch:{ Exception -> 0x0030 }
                goto L_0x003a
            L_0x0030:
                boolean r3 = r4.mAllowExternalStorage     // Catch:{ Exception -> 0x006f }
                if (r3 == 0) goto L_0x005f
                android.content.Context r3 = r4.mContext     // Catch:{ Exception -> 0x006f }
                java.io.File r2 = com.facebook.react.modules.camera.ImageEditingManager.writeBitmapToExternalCache(r3, r2, r1)     // Catch:{ Exception -> 0x006f }
            L_0x003a:
                java.lang.String r3 = "image/jpeg"
                boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x006f }
                if (r1 == 0) goto L_0x004d
                android.content.Context r1 = r4.mContext     // Catch:{ Exception -> 0x006f }
                java.lang.String r3 = r4.mUri     // Catch:{ Exception -> 0x006f }
                android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x006f }
                com.facebook.react.modules.camera.ImageEditingManager.copyExif(r1, r3, r2)     // Catch:{ Exception -> 0x006f }
            L_0x004d:
                com.facebook.react.bridge.Callback r1 = r4.mSuccess     // Catch:{ Exception -> 0x006f }
                java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x006f }
                android.net.Uri r2 = android.net.Uri.fromFile(r2)     // Catch:{ Exception -> 0x006f }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x006f }
                r3[r5] = r2     // Catch:{ Exception -> 0x006f }
                r1.invoke(r3)     // Catch:{ Exception -> 0x006f }
                goto L_0x007d
            L_0x005f:
                java.lang.SecurityException r1 = new java.lang.SecurityException     // Catch:{ Exception -> 0x006f }
                java.lang.String r2 = "We couldn't create file in internal cache and external cache is disabled. Did you forget to pass allowExternalStorage=true?"
                r1.<init>(r2)     // Catch:{ Exception -> 0x006f }
                throw r1     // Catch:{ Exception -> 0x006f }
            L_0x0067:
                java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x006f }
                java.lang.String r2 = "Could not determine MIME type"
                r1.<init>(r2)     // Catch:{ Exception -> 0x006f }
                throw r1     // Catch:{ Exception -> 0x006f }
            L_0x006f:
                r1 = move-exception
                com.facebook.react.bridge.Callback r2 = r4.mError
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.String r1 = r1.getMessage()
                r0[r5] = r1
                r2.invoke(r0)
            L_0x007d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.camera.ImageEditingManager.CropTask.doInBackgroundGuarded(java.lang.Void[]):void");
        }

        private Bitmap crop(BitmapFactory.Options options) throws IOException {
            InputStream openBitmapInputStream = openBitmapInputStream();
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openBitmapInputStream, false);
            try {
                int i = this.mX;
                int i2 = this.mY;
                return newInstance.decodeRegion(new Rect(i, i2, this.mWidth + i, this.mHeight + i2), options);
            } finally {
                if (openBitmapInputStream != null) {
                    openBitmapInputStream.close();
                }
                newInstance.recycle();
            }
        }

        /* JADX INFO: finally extract failed */
        private Bitmap cropAndResize(int i, int i2, BitmapFactory.Options options) throws IOException {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            int i3 = i;
            int i4 = i2;
            BitmapFactory.Options options2 = options;
            Assertions.assertNotNull(options);
            BitmapFactory.Options options3 = new BitmapFactory.Options();
            options3.inJustDecodeBounds = true;
            InputStream openBitmapInputStream = openBitmapInputStream();
            try {
                BitmapFactory.decodeStream(openBitmapInputStream, (Rect) null, options3);
                if (openBitmapInputStream != null) {
                    openBitmapInputStream.close();
                }
                int i5 = this.mWidth;
                int i6 = this.mHeight;
                float f6 = (float) i3;
                float f7 = (float) i4;
                float f8 = f6 / f7;
                if (((float) i5) / ((float) i6) > f8) {
                    f5 = ((float) i6) * f8;
                    f4 = (float) i6;
                    f2 = ((float) this.mX) + ((((float) i5) - f5) / 2.0f);
                    f = (float) this.mY;
                    f3 = f7 / ((float) i6);
                } else {
                    f5 = (float) i5;
                    float f9 = ((float) i5) / f8;
                    f2 = (float) this.mX;
                    f = ((float) this.mY) + ((((float) i6) - f9) / 2.0f);
                    float f10 = f9;
                    f3 = f6 / ((float) i5);
                    f4 = f10;
                }
                options2.inSampleSize = ImageEditingManager.getDecodeSampleSize(i5, i6, i3, i4);
                options3.inJustDecodeBounds = false;
                InputStream openBitmapInputStream2 = openBitmapInputStream();
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(openBitmapInputStream2, (Rect) null, options2);
                    if (decodeStream != null) {
                        int floor = (int) Math.floor((double) (f2 / ((float) options2.inSampleSize)));
                        int floor2 = (int) Math.floor((double) (f / ((float) options2.inSampleSize)));
                        int floor3 = (int) Math.floor((double) (f5 / ((float) options2.inSampleSize)));
                        float f11 = f3 * ((float) options2.inSampleSize);
                        Matrix matrix = new Matrix();
                        matrix.setScale(f11, f11);
                        return Bitmap.createBitmap(decodeStream, floor, floor2, floor3, (int) Math.floor((double) (f4 / ((float) options2.inSampleSize))), matrix, true);
                    }
                    throw new IOException("Cannot decode bitmap: " + this.mUri);
                } finally {
                    if (openBitmapInputStream2 != null) {
                        openBitmapInputStream2.close();
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                if (openBitmapInputStream != null) {
                    openBitmapInputStream.close();
                }
                throw th2;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void copyExif(Context context, Uri uri, File file) throws IOException {
        File fileFromUri = getFileFromUri(context, uri);
        if (fileFromUri == null) {
            FLog.w(ReactConstants.TAG, "Couldn't get real path for uri: " + uri);
            return;
        }
        android.media.ExifInterface exifInterface = new android.media.ExifInterface(fileFromUri.getAbsolutePath());
        android.media.ExifInterface exifInterface2 = new android.media.ExifInterface(file.getAbsolutePath());
        for (String str : EXIF_ATTRIBUTES) {
            String attribute = exifInterface.getAttribute(str);
            if (attribute != null) {
                exifInterface2.setAttribute(str, attribute);
            }
        }
        exifInterface2.saveAttributes();
    }

    private static File getFileFromUri(Context context, Uri uri) {
        Cursor query;
        if (uri.getScheme().equals(UriUtil.LOCAL_FILE_SCHEME)) {
            return new File(uri.getPath());
        }
        if (!uri.getScheme().equals("content") || (query = context.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null)) == null) {
            return null;
        }
        try {
            if (query.moveToFirst()) {
                String string = query.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    return new File(string);
                }
            }
            query.close();
            return null;
        } finally {
            query.close();
        }
    }

    /* access modifiers changed from: private */
    public static boolean isLocalUri(String str) {
        for (String startsWith : LOCAL_URI_PREFIXES) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private static String getFileExtensionForType(String str) {
        if ("image/png".equals(str)) {
            return ".png";
        }
        return "image/webp".equals(str) ? ".webp" : ".jpg";
    }

    private static Bitmap.CompressFormat getCompressFormatForType(String str) {
        if ("image/png".equals(str)) {
            return Bitmap.CompressFormat.PNG;
        }
        if ("image/webp".equals(str)) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    /* access modifiers changed from: private */
    public static File writeBitmapToInternalCache(Context context, Bitmap bitmap, String str) throws IOException {
        File createTempFile = createTempFile(context.getCacheDir(), str);
        writeCompressedBitmapToFile(bitmap, str, createTempFile);
        return createTempFile;
    }

    /* access modifiers changed from: private */
    public static File writeBitmapToExternalCache(Context context, Bitmap bitmap, String str) throws IOException {
        File createTempFile = createTempFile(context.getExternalCacheDir(), str);
        writeCompressedBitmapToFile(bitmap, str, createTempFile);
        return createTempFile;
    }

    private static void writeCompressedBitmapToFile(Bitmap bitmap, String str, File file) throws IOException {
        bitmap.compress(getCompressFormatForType(str), 90, new FileOutputStream(file));
    }

    private static File createTempFile(File file, String str) throws IOException {
        if (file != null) {
            return File.createTempFile(TEMP_FILE_PREFIX, getFileExtensionForType(str), file);
        }
        throw new IOException("No cache directory available");
    }

    /* access modifiers changed from: private */
    public static int getDecodeSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i3 || i > i4) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i7 / i5 >= i3 && i6 / i5 >= i4) {
                i5 *= 2;
            }
        }
        return i5;
    }
}

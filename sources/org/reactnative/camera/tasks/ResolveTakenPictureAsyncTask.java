package org.reactnative.camera.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.io.File;
import java.io.IOException;
import org.reactnative.camera.utils.RNFileUtils;

public class ResolveTakenPictureAsyncTask extends AsyncTask<Void, Void, WritableMap> {
    private static final String ERROR_TAG = "E_TAKING_PICTURE_FAILED";
    private Bitmap mBitmap;
    private File mCacheDirectory;
    private int mDeviceOrientation;
    private byte[] mImageData;
    private ReadableMap mOptions;
    private PictureSavedDelegate mPictureSavedDelegate;
    private Promise mPromise;
    private int mSoftwareRotation;

    private int getImageRotation(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public ResolveTakenPictureAsyncTask(byte[] bArr, Promise promise, ReadableMap readableMap, File file, int i, int i2, PictureSavedDelegate pictureSavedDelegate) {
        this.mPromise = promise;
        this.mOptions = readableMap;
        this.mImageData = bArr;
        this.mCacheDirectory = file;
        this.mDeviceOrientation = i;
        this.mSoftwareRotation = i2;
        this.mPictureSavedDelegate = pictureSavedDelegate;
    }

    private int getQuality() {
        return (int) (this.mOptions.getDouble("quality") * 100.0d);
    }

    private void loadBitmap() throws IOException {
        if (this.mBitmap == null) {
            byte[] bArr = this.mImageData;
            this.mBitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        if (this.mBitmap == null) {
            throw new IOException("Failed to decode Image Bitmap");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x027d A[SYNTHETIC, Splitter:B:128:0x027d] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x028f A[SYNTHETIC, Splitter:B:135:0x028f] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x029f A[SYNTHETIC, Splitter:B:142:0x029f] */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0089 A[Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5 A[Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c7 A[Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d1 A[Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fa A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0107 A[Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0108 A[Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011e A[Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0135 A[Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:125:0x0271=Splitter:B:125:0x0271, B:132:0x0283=Splitter:B:132:0x0283} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.WritableMap doInBackground(java.lang.Void... r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "mirrorImage"
            java.lang.String r2 = "fixOrientation"
            java.lang.String r3 = "exif"
            java.lang.String r4 = "E_TAKING_PICTURE_FAILED"
            java.lang.String r5 = "writeExif"
            java.lang.String r6 = "width"
            com.facebook.react.bridge.WritableMap r7 = com.facebook.react.bridge.Arguments.createMap()
            int r8 = r1.mDeviceOrientation
            java.lang.String r9 = "deviceOrientation"
            r7.putInt(r9, r8)
            com.facebook.react.bridge.ReadableMap r8 = r1.mOptions
            java.lang.String r9 = "orientation"
            boolean r8 = r8.hasKey(r9)
            if (r8 == 0) goto L_0x002a
            com.facebook.react.bridge.ReadableMap r8 = r1.mOptions
            int r8 = r8.getInt(r9)
            goto L_0x002c
        L_0x002a:
            int r8 = r1.mDeviceOrientation
        L_0x002c:
            java.lang.String r9 = "pictureOrientation"
            r7.putInt(r9, r8)
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ NotFoundException -> 0x0281, IOException -> 0x026f, all -> 0x026b }
            byte[] r10 = r1.mImageData     // Catch:{ NotFoundException -> 0x0281, IOException -> 0x026f, all -> 0x026b }
            r9.<init>(r10)     // Catch:{ NotFoundException -> 0x0281, IOException -> 0x026f, all -> 0x026b }
            int r10 = r1.mSoftwareRotation     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r10 == 0) goto L_0x0049
            r16.loadBitmap()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r10 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r11 = r1.mSoftwareRotation     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r10 = r1.rotateBitmap(r10, r11)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r1.mBitmap = r10     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x0049:
            com.facebook.react.bridge.ReadableMap r10 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r10 = r10.hasKey(r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            java.lang.String r11 = "Orientation"
            r12 = 0
            r13 = 1
            if (r10 == 0) goto L_0x007f
            com.facebook.react.bridge.ReadableMap r10 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r2 = r10.getBoolean(r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r2 == 0) goto L_0x007f
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.<init>((java.io.InputStream) r9)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r10 = r2.getAttributeInt(r11, r12)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r10 == 0) goto L_0x0080
            int r14 = r1.getImageRotation(r10)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r14 == 0) goto L_0x0080
            r16.loadBitmap()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r10 = r1.getImageRotation(r10)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r14 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r10 = r1.rotateBitmap(r14, r10)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r1.mBitmap = r10     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r10 = 1
            goto L_0x0081
        L_0x007f:
            r2 = 0
        L_0x0080:
            r10 = 0
        L_0x0081:
            com.facebook.react.bridge.ReadableMap r14 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r14 = r14.hasKey(r6)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r14 == 0) goto L_0x009a
            r16.loadBitmap()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r14 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            com.facebook.react.bridge.ReadableMap r15 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r15 = r15.getInt(r6)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r14 = r1.resizeBitmap(r14, r15)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r1.mBitmap = r14     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x009a:
            com.facebook.react.bridge.ReadableMap r14 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r14 = r14.hasKey(r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r14 == 0) goto L_0x00b5
            com.facebook.react.bridge.ReadableMap r14 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r0 = r14.getBoolean(r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r0 == 0) goto L_0x00b5
            r16.loadBitmap()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r0 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r0 = r1.flipHorizontally(r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r1.mBitmap = r0     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x00b5:
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r0 = r0.hasKey(r3)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r0 == 0) goto L_0x00c7
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r0 = r0.getBoolean(r3)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r0 == 0) goto L_0x00c7
            r0 = 1
            goto L_0x00c8
        L_0x00c7:
            r0 = 0
        L_0x00c8:
            com.facebook.react.bridge.ReadableMap r14 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r14 = r14.hasKey(r5)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r15 = 2
            if (r14 == 0) goto L_0x00f4
            int[] r14 = org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask.AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            com.facebook.react.bridge.ReadableMap r8 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            com.facebook.react.bridge.ReadableType r8 = r8.getType(r5)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r8 = r8.ordinal()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r8 = r14[r8]     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r8 == r13) goto L_0x00eb
            if (r8 == r15) goto L_0x00e4
            goto L_0x00f4
        L_0x00e4:
            com.facebook.react.bridge.ReadableMap r8 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            com.facebook.react.bridge.ReadableMap r5 = r8.getMap(r5)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            goto L_0x00f5
        L_0x00eb:
            com.facebook.react.bridge.ReadableMap r8 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r5 = r8.getBoolean(r5)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r8 = r5
            r5 = 0
            goto L_0x00f6
        L_0x00f4:
            r5 = 0
        L_0x00f5:
            r8 = 1
        L_0x00f6:
            java.lang.String r14 = "height"
            if (r0 != 0) goto L_0x00ff
            if (r8 == 0) goto L_0x00fd
            goto L_0x00ff
        L_0x00fd:
            r2 = 0
            goto L_0x013f
        L_0x00ff:
            android.graphics.Bitmap r15 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r15 != 0) goto L_0x010a
            if (r5 != 0) goto L_0x010a
            if (r0 == 0) goto L_0x0108
            goto L_0x010a
        L_0x0108:
            r2 = 0
            goto L_0x011a
        L_0x010a:
            if (r2 != 0) goto L_0x0111
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.<init>((java.io.InputStream) r9)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x0111:
            com.facebook.react.bridge.WritableMap r2 = org.reactnative.camera.RNCameraViewHelper.getExifData(r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r5 == 0) goto L_0x011a
            r2.merge(r5)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x011a:
            android.graphics.Bitmap r15 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r15 == 0) goto L_0x0133
            int r15 = r15.getWidth()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.putInt(r6, r15)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r15 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r15 = r15.getHeight()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.putInt(r14, r15)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r10 == 0) goto L_0x0133
            r2.putInt(r11, r13)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x0133:
            if (r0 == 0) goto L_0x013f
            com.facebook.react.bridge.WritableMap r0 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r0.merge(r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r7.putMap(r3, r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x013f:
            android.graphics.Bitmap r0 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            java.lang.String r3 = "uri"
            java.lang.String r10 = "doNotSave"
            java.lang.String r11 = "base64"
            if (r0 != 0) goto L_0x01d8
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r0.<init>()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r0.inJustDecodeBounds = r13     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            byte[] r2 = r1.mImageData     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r13 = r2.length     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.BitmapFactory.decodeByteArray(r2, r12, r13, r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r2 = r0.outWidth     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r7.putInt(r6, r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r0 = r0.outHeight     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r7.putInt(r14, r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r0 = r0.hasKey(r10)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r0 == 0) goto L_0x0170
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r0 = r0.getBoolean(r10)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r0 != 0) goto L_0x01bc
        L_0x0170:
            java.io.File r0 = new java.io.File     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            java.lang.String r2 = r16.getImagePath()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r0.<init>(r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r0.createNewFile()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.<init>(r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            byte[] r6 = r1.mImageData     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.write(r6)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.flush()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.close()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r8 == 0) goto L_0x01a0
            if (r5 == 0) goto L_0x01a0
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            java.lang.String r6 = r0.getAbsolutePath()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.<init>((java.lang.String) r6)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            org.reactnative.camera.RNCameraViewHelper.setExifData(r2, r5)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.saveAttributes()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            goto L_0x01b1
        L_0x01a0:
            if (r8 != 0) goto L_0x01b1
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            java.lang.String r5 = r0.getAbsolutePath()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.<init>((java.lang.String) r5)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            org.reactnative.camera.RNCameraViewHelper.clearExifData(r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.saveAttributes()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x01b1:
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            java.lang.String r0 = r0.toString()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r7.putString(r3, r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x01bc:
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r0 = r0.hasKey(r11)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r0 == 0) goto L_0x025d
            com.facebook.react.bridge.ReadableMap r0 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r0 = r0.getBoolean(r11)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r0 == 0) goto L_0x025d
            byte[] r0 = r1.mImageData     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r7.putString(r11, r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            goto L_0x025d
        L_0x01d8:
            int r0 = r0.getWidth()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r7.putInt(r6, r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r0 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r0 = r0.getHeight()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r7.putInt(r14, r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r0.<init>()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap r5 = r1.mBitmap     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            int r12 = r16.getQuality()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r5 = r5.compress(r6, r12, r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r5 != 0) goto L_0x020e
            com.facebook.react.bridge.Promise r0 = r1.mPromise     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            java.lang.String r2 = "Could not compress image to JPEG"
            r0.reject((java.lang.String) r4, (java.lang.String) r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r9.close()     // Catch:{ IOException -> 0x0207 }
        L_0x0205:
            r2 = 0
            goto L_0x020d
        L_0x0207:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            goto L_0x0205
        L_0x020d:
            return r2
        L_0x020e:
            com.facebook.react.bridge.ReadableMap r5 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r5 = r5.hasKey(r10)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r5 == 0) goto L_0x021e
            com.facebook.react.bridge.ReadableMap r5 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r5 = r5.getBoolean(r10)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r5 != 0) goto L_0x0241
        L_0x021e:
            java.lang.String r5 = r1.writeStreamToFile(r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r8 == 0) goto L_0x0231
            if (r2 == 0) goto L_0x0231
            androidx.exifinterface.media.ExifInterface r6 = new androidx.exifinterface.media.ExifInterface     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r6.<init>((java.lang.String) r5)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            org.reactnative.camera.RNCameraViewHelper.setExifData(r6, r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r6.saveAttributes()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x0231:
            java.io.File r2 = new java.io.File     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2.<init>(r5)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            android.net.Uri r2 = android.net.Uri.fromFile(r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            java.lang.String r2 = r2.toString()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r7.putString(r3, r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x0241:
            com.facebook.react.bridge.ReadableMap r2 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r2 = r2.hasKey(r11)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r2 == 0) goto L_0x025d
            com.facebook.react.bridge.ReadableMap r2 = r1.mOptions     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            boolean r2 = r2.getBoolean(r11)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            if (r2 == 0) goto L_0x025d
            byte[] r0 = r0.toByteArray()     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r2 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r2)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
            r7.putString(r11, r0)     // Catch:{ NotFoundException -> 0x0269, IOException -> 0x0267 }
        L_0x025d:
            r9.close()     // Catch:{ IOException -> 0x0261 }
            goto L_0x0266
        L_0x0261:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x0266:
            return r7
        L_0x0267:
            r0 = move-exception
            goto L_0x0271
        L_0x0269:
            r0 = move-exception
            goto L_0x0283
        L_0x026b:
            r0 = move-exception
            r2 = r0
            r8 = 0
            goto L_0x029d
        L_0x026f:
            r0 = move-exception
            r9 = 0
        L_0x0271:
            com.facebook.react.bridge.Promise r2 = r1.mPromise     // Catch:{ all -> 0x029a }
            java.lang.String r3 = "An unknown I/O exception has occurred."
            r2.reject((java.lang.String) r4, (java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x029a }
            r0.printStackTrace()     // Catch:{ all -> 0x029a }
            if (r9 == 0) goto L_0x0298
            r9.close()     // Catch:{ IOException -> 0x0293 }
            goto L_0x0298
        L_0x0281:
            r0 = move-exception
            r9 = 0
        L_0x0283:
            com.facebook.react.bridge.Promise r2 = r1.mPromise     // Catch:{ all -> 0x029a }
            java.lang.String r3 = "Documents directory of the app could not be found."
            r2.reject((java.lang.String) r4, (java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x029a }
            r0.printStackTrace()     // Catch:{ all -> 0x029a }
            if (r9 == 0) goto L_0x0298
            r9.close()     // Catch:{ IOException -> 0x0293 }
            goto L_0x0298
        L_0x0293:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x0298:
            r2 = 0
            return r2
        L_0x029a:
            r0 = move-exception
            r2 = r0
            r8 = r9
        L_0x029d:
            if (r8 == 0) goto L_0x02a8
            r8.close()     // Catch:{ IOException -> 0x02a3 }
            goto L_0x02a8
        L_0x02a3:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x02a8:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask.doInBackground(java.lang.Void[]):com.facebook.react.bridge.WritableMap");
    }

    /* renamed from: org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask.AnonymousClass1.<clinit>():void");
        }
    }

    private Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private Bitmap resizeBitmap(Bitmap bitmap, int i) {
        return Bitmap.createScaledBitmap(bitmap, i, (int) (((float) bitmap.getHeight()) * (((float) i) / ((float) bitmap.getWidth()))), true);
    }

    private Bitmap flipHorizontally(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private String getImagePath() throws IOException {
        if (this.mOptions.hasKey(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
            return this.mOptions.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        }
        return RNFileUtils.getOutputFilePath(this.mCacheDirectory, ".jpg");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0026, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r2.close();
        r0 = r0;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0036, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0001] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0026 A[SYNTHETIC, Splitter:B:21:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0031 A[SYNTHETIC, Splitter:B:29:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String writeStreamToFile(java.io.ByteArrayOutputStream r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            java.lang.String r1 = r3.getImagePath()     // Catch:{ IOException -> 0x001d, all -> 0x001b }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0018, all -> 0x001b }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0018, all -> 0x001b }
            r4.writeTo(r2)     // Catch:{ IOException -> 0x0016 }
            r2.close()     // Catch:{ IOException -> 0x0011 }
            goto L_0x0029
        L_0x0011:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0029
        L_0x0016:
            r4 = move-exception
            goto L_0x0020
        L_0x0018:
            r4 = move-exception
            r2 = r0
            goto L_0x0020
        L_0x001b:
            r4 = move-exception
            goto L_0x002f
        L_0x001d:
            r4 = move-exception
            r1 = r0
            r2 = r1
        L_0x0020:
            r0 = r4
            r0.printStackTrace()     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0029
            r2.close()     // Catch:{ IOException -> 0x0011 }
        L_0x0029:
            if (r0 != 0) goto L_0x002c
            return r1
        L_0x002c:
            throw r0
        L_0x002d:
            r4 = move-exception
            r0 = r2
        L_0x002f:
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0039:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask.writeStreamToFile(java.io.ByteArrayOutputStream):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(WritableMap writableMap) {
        super.onPostExecute(writableMap);
        if (writableMap == null) {
            return;
        }
        if (!this.mOptions.hasKey("fastMode") || !this.mOptions.getBoolean("fastMode")) {
            this.mPromise.resolve(writableMap);
            return;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(MessageExtension.FIELD_ID, this.mOptions.getInt(MessageExtension.FIELD_ID));
        createMap.putMap("data", writableMap);
        this.mPictureSavedDelegate.onPictureSaved(createMap);
    }
}

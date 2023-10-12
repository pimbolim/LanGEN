package com.oblador.vectoricons;

import android.graphics.Typeface;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.HashMap;
import java.util.Map;

public class VectorIconsModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "RNVectorIconsModule";
    private static final Map<String, Typeface> sTypefaceCache = new HashMap();

    @interface Errors {
        public static final String E_UNKNOWN_ERROR = "E_UNKNOWN_ERROR";
    }

    public String getName() {
        return REACT_CLASS;
    }

    public VectorIconsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0122 A[SYNTHETIC, Splitter:B:17:0x0122] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String createGlyphImagePath(java.lang.String r7, java.lang.String r8, java.lang.Integer r9, java.lang.Integer r10) throws java.io.IOException, java.io.FileNotFoundException {
        /*
            r6 = this;
            com.facebook.react.bridge.ReactApplicationContext r0 = r6.getReactApplicationContext()
            java.io.File r1 = r0.getCacheDir()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = r1.getAbsolutePath()
            r2.append(r1)
            java.lang.String r1 = "/"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.content.res.Resources r2 = r0.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.density
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "@"
            r3.append(r4)
            int r4 = (int) r2
            float r5 = (float) r4
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x003c
            java.lang.String r4 = java.lang.Integer.toString(r4)
            goto L_0x0040
        L_0x003c:
            java.lang.String r4 = java.lang.Float.toString(r2)
        L_0x0040:
            r3.append(r4)
            java.lang.String r4 = "x"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            int r4 = r9.intValue()
            float r4 = (float) r4
            float r4 = r4 * r2
            int r2 = java.lang.Math.round(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            java.lang.String r5 = ":"
            r4.append(r5)
            r4.append(r8)
            r4.append(r5)
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            int r4 = r4.hashCode()
            r5 = 32
            java.lang.String r4 = java.lang.Integer.toString(r4, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            r5.append(r4)
            java.lang.String r1 = "_"
            r5.append(r1)
            int r9 = r9.intValue()
            java.lang.String r9 = java.lang.Integer.toString(r9)
            r5.append(r9)
            r5.append(r3)
            java.lang.String r9 = ".png"
            r5.append(r9)
            java.lang.String r9 = r5.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "file://"
            r1.append(r3)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r9)
            boolean r9 = r3.exists()
            if (r9 == 0) goto L_0x00bf
            return r1
        L_0x00bf:
            r9 = 0
            com.facebook.react.views.text.ReactFontManager r4 = com.facebook.react.views.text.ReactFontManager.getInstance()
            android.content.res.AssetManager r0 = r0.getAssets()
            r5 = 0
            android.graphics.Typeface r7 = r4.getTypeface(r7, r5, r0)
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r0.setTypeface(r7)
            int r7 = r10.intValue()
            r0.setColor(r7)
            float r7 = (float) r2
            r0.setTextSize(r7)
            r7 = 1
            r0.setAntiAlias(r7)
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            int r10 = r8.length()
            r0.getTextBounds(r8, r5, r10, r7)
            android.graphics.Paint$FontMetrics r7 = r0.getFontMetrics()
            float r7 = r7.bottom
            int r7 = (int) r7
            int r7 = r2 - r7
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r2, r2, r10)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r10)
            float r4 = (float) r5
            float r7 = (float) r7
            r2.drawText(r8, r4, r7, r0)
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x011f }
            r7.<init>(r3)     // Catch:{ all -> 0x011f }
            android.graphics.Bitmap$CompressFormat r8 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x011c }
            r9 = 100
            r10.compress(r8, r9, r7)     // Catch:{ all -> 0x011c }
            r7.flush()     // Catch:{ all -> 0x011c }
            r7.close()     // Catch:{ all -> 0x011c }
            return r1
        L_0x011c:
            r8 = move-exception
            r9 = r7
            goto L_0x0120
        L_0x011f:
            r8 = move-exception
        L_0x0120:
            if (r9 == 0) goto L_0x012a
            r9.close()     // Catch:{ IOException -> 0x0126 }
            goto L_0x012a
        L_0x0126:
            r7 = move-exception
            r7.printStackTrace()
        L_0x012a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oblador.vectoricons.VectorIconsModule.createGlyphImagePath(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer):java.lang.String");
    }

    @ReactMethod
    public void getImageForFont(String str, String str2, Integer num, Integer num2, Promise promise) {
        try {
            promise.resolve(createGlyphImagePath(str, str2, num, num2));
        } catch (Throwable th) {
            promise.reject(Errors.E_UNKNOWN_ERROR, th);
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getImageForFontSync(String str, String str2, Integer num, Integer num2) {
        try {
            return createGlyphImagePath(str, str2, num, num2);
        } catch (Throwable unused) {
            return null;
        }
    }
}

package io.card.payment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.drew.metadata.exif.makernotes.OlympusMakernoteDirectory;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;

class CardScanner implements Camera.AutoFocusCallback, Camera.PreviewCallback, SurfaceHolder.Callback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "CardScanner";
    private static boolean manualFallbackForError;
    private static boolean processingInProgress = false;
    private long captureStart;
    private Bitmap detectedBitmap;
    private boolean isSurfaceValid;
    private long mAutoFocusCompletedAt;
    private long mAutoFocusStartedAt;
    private Camera mCamera;
    private boolean mFirstPreviewFrame = true;
    private int mFrameOrientation = 1;
    private byte[] mPreviewBuffer;
    final int mPreviewHeight = 480;
    final int mPreviewWidth = OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE;
    protected WeakReference<CardIOActivity> mScanActivityRef;
    private boolean mScanExpiry;
    private boolean mSuppressScan = false;
    private int mUnblurDigits = -1;
    private int numAutoRefocus;
    private int numFramesSkipped;
    private int numManualRefocus;
    private int numManualTorchChange;
    protected boolean useCamera = true;

    private native void nCleanup();

    private native void nGetGuideFrame(int i, int i2, int i3, Rect rect);

    private native int nGetNumFramesScanned();

    private native void nResetAnalytics();

    private native void nScanFrame(byte[] bArr, int i, int i2, int i3, DetectionInfo detectionInfo, Bitmap bitmap, boolean z);

    private native void nSetup(boolean z, float f);

    private native void nSetup(boolean z, float f, int i);

    public static native boolean nUseNeon();

    public static native boolean nUseTegra();

    public static native boolean nUseX86();

    static {
        Log.i("card.io", "card.io 5.5.1 03/17/2017 14:23:12 -0400");
        try {
            loadLibrary("cardioDecider");
            Log.d("card.io", "Loaded card.io decider library.");
            Log.d("card.io", "    nUseNeon(): " + nUseNeon());
            Log.d("card.io", "    nUseTegra():" + nUseTegra());
            Log.d("card.io", "    nUseX86():  " + nUseX86());
            if (usesSupportedProcessorArch()) {
                loadLibrary("opencv_core");
                Log.d("card.io", "Loaded opencv core library");
                loadLibrary("opencv_imgproc");
                Log.d("card.io", "Loaded opencv imgproc library");
            }
            if (nUseNeon()) {
                loadLibrary("cardioRecognizer");
                Log.i("card.io", "Loaded card.io NEON library");
            } else if (nUseX86()) {
                loadLibrary("cardioRecognizer");
                Log.i("card.io", "Loaded card.io x86 library");
            } else if (nUseTegra()) {
                loadLibrary("cardioRecognizer_tegra2");
                Log.i("card.io", "Loaded card.io Tegra2 library");
            } else {
                Log.w("card.io", "unsupported processor - card.io scanning requires ARMv7 or x86 architecture");
                manualFallbackForError = true;
            }
        } catch (UnsatisfiedLinkError e) {
            Log.e("card.io", "Failed to load native library: " + e.getMessage());
            manualFallbackForError = true;
        }
    }

    private static void loadLibrary(String str) throws UnsatisfiedLinkError {
        try {
            System.loadLibrary(str);
        } catch (UnsatisfiedLinkError e) {
            String alternativeLibsPath = CardIONativeLibsConfig.getAlternativeLibsPath();
            if (alternativeLibsPath == null || alternativeLibsPath.length() == 0) {
                throw e;
            }
            if (!File.separator.equals(Character.valueOf(alternativeLibsPath.charAt(alternativeLibsPath.length() - 1)))) {
                alternativeLibsPath = alternativeLibsPath + File.separator;
            }
            String str2 = alternativeLibsPath + Build.CPU_ABI + File.separator + System.mapLibraryName(str);
            Log.d("card.io", "loadLibrary failed for library " + str + ". Trying " + str2);
            System.load(str2);
        }
    }

    private static boolean usesSupportedProcessorArch() {
        return nUseNeon() || nUseTegra() || nUseX86();
    }

    static boolean processorSupported() {
        return !manualFallbackForError && usesSupportedProcessorArch();
    }

    CardScanner(CardIOActivity cardIOActivity, int i) {
        boolean z = false;
        Intent intent = cardIOActivity.getIntent();
        if (intent != null) {
            this.mSuppressScan = intent.getBooleanExtra(CardIOActivity.EXTRA_SUPPRESS_SCAN, false);
            if (intent.getBooleanExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, false) && intent.getBooleanExtra(CardIOActivity.EXTRA_SCAN_EXPIRY, true)) {
                z = true;
            }
            this.mScanExpiry = z;
            this.mUnblurDigits = intent.getIntExtra(CardIOActivity.EXTRA_UNBLUR_DIGITS, -1);
        }
        this.mScanActivityRef = new WeakReference<>(cardIOActivity);
        this.mFrameOrientation = i;
        nSetup(this.mSuppressScan, 6.0f, this.mUnblurDigits);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.hardware.Camera connectToCamera(int r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "card.io"
            long r1 = java.lang.System.currentTimeMillis()
            boolean r3 = r8.useCamera
            if (r3 == 0) goto L_0x0031
        L_0x000a:
            android.hardware.Camera r9 = android.hardware.Camera.open()     // Catch:{ RuntimeException -> 0x0017, Exception -> 0x000f }
            return r9
        L_0x000f:
            r10 = move-exception
            java.lang.String r3 = "Unexpected exception. Please report it as a GitHub issue"
            android.util.Log.e(r0, r3, r10)
            r10 = 0
            goto L_0x0027
        L_0x0017:
            java.lang.String r3 = "Wasn't able to connect to camera service. Waiting and trying again..."
            android.util.Log.w(r0, r3)     // Catch:{ InterruptedException -> 0x0021 }
            long r3 = (long) r9     // Catch:{ InterruptedException -> 0x0021 }
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0021 }
            goto L_0x0027
        L_0x0021:
            r3 = move-exception
            java.lang.String r4 = "Interrupted while waiting for camera"
            android.util.Log.e(r0, r4, r3)
        L_0x0027:
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            long r5 = (long) r10
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x000a
        L_0x0031:
            java.lang.String r9 = TAG
            java.lang.String r10 = "camera connect timeout"
            android.util.Log.w(r9, r10)
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.card.payment.CardScanner.connectToCamera(int, int):android.hardware.Camera");
    }

    /* access modifiers changed from: package-private */
    public void prepareScanner() {
        this.mFirstPreviewFrame = true;
        this.mAutoFocusStartedAt = 0;
        this.mAutoFocusCompletedAt = 0;
        this.numManualRefocus = 0;
        this.numAutoRefocus = 0;
        this.numManualTorchChange = 0;
        this.numFramesSkipped = 0;
        boolean z = this.useCamera;
        if (z && this.mCamera == null) {
            Camera connectToCamera = connectToCamera(50, 5000);
            this.mCamera = connectToCamera;
            if (connectToCamera == null) {
                Log.e("card.io", "prepare scanner couldn't connect to camera!");
                return;
            }
            setCameraDisplayOrientation(connectToCamera);
            Camera.Parameters parameters = this.mCamera.getParameters();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                Camera.Size size = null;
                Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Camera.Size next = it.next();
                    if (next.width == 640 && next.height == 480) {
                        size = next;
                        break;
                    }
                }
                if (size == null) {
                    Log.w("card.io", "Didn't find a supported 640x480 resolution, so forcing");
                    Camera.Size size2 = supportedPreviewSizes.get(0);
                    size2.width = OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE;
                    size2.height = 480;
                }
            }
            parameters.setPreviewSize(OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE, 480);
            this.mCamera.setParameters(parameters);
        } else if (!z) {
            Log.w(TAG, "useCamera is false!");
        } else if (this.mCamera != null) {
            String str = TAG;
            Log.v(str, "we already have a camera instance: " + this.mCamera);
        }
        if (this.detectedBitmap == null) {
            this.detectedBitmap = Bitmap.createBitmap(428, 270, Bitmap.Config.ARGB_8888);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean resumeScanning(SurfaceHolder surfaceHolder) {
        if (this.mCamera == null) {
            prepareScanner();
        }
        boolean z = this.useCamera;
        if (!z || this.mCamera != null) {
            if (z && this.mPreviewBuffer == null) {
                byte[] bArr = new byte[((ImageFormat.getBitsPerPixel(this.mCamera.getParameters().getPreviewFormat()) / 8) * 307200 * 3)];
                this.mPreviewBuffer = bArr;
                this.mCamera.addCallbackBuffer(bArr);
            }
            surfaceHolder.addCallback(this);
            surfaceHolder.setType(3);
            if (this.useCamera) {
                this.mCamera.setPreviewCallbackWithBuffer(this);
            }
            if (this.isSurfaceValid) {
                makePreviewGo(surfaceHolder);
            }
            setFlashOn(false);
            this.captureStart = System.currentTimeMillis();
            nResetAnalytics();
            return true;
        }
        Log.i(TAG, "null camera. failure");
        return false;
    }

    public void pauseScanning() {
        setFlashOn(false);
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.stopPreview();
                this.mCamera.setPreviewDisplay((SurfaceHolder) null);
            } catch (IOException e) {
                Log.w("card.io", "can't stop preview display", e);
            }
            this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
            this.mCamera.release();
            this.mPreviewBuffer = null;
            this.mCamera = null;
        }
    }

    public void endScanning() {
        if (this.mCamera != null) {
            pauseScanning();
        }
        nCleanup();
        this.mPreviewBuffer = null;
    }

    private boolean makePreviewGo(SurfaceHolder surfaceHolder) {
        this.mFirstPreviewFrame = true;
        if (this.useCamera) {
            try {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                try {
                    this.mCamera.startPreview();
                    this.mCamera.autoFocus(this);
                } catch (RuntimeException e) {
                    Log.e("card.io", "startPreview failed on camera. Error: ", e);
                    return false;
                }
            } catch (IOException e2) {
                Log.e("card.io", "can't set preview display", e2);
                return false;
            }
        }
        return true;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.mCamera != null || !this.useCamera) {
            this.isSurfaceValid = true;
            makePreviewGo(surfaceHolder);
            return;
        }
        Log.wtf("card.io", "CardScanner.surfaceCreated() - camera is null!");
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        String str = TAG;
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(surfaceHolder != null);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        Log.d(str, String.format("Preview.surfaceChanged(holder?:%b, f:%d, w:%d, h:%d )", objArr));
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.stopPreview();
            } catch (Exception e) {
                Log.e("card.io", "error stopping camera", e);
            }
        }
        this.isSurfaceValid = false;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr == null) {
            Log.w(TAG, "frame is null! skipping");
            return;
        }
        boolean z = true;
        if (processingInProgress) {
            Log.e(TAG, "processing in progress.... dropping frame");
            this.numFramesSkipped++;
            if (camera != null) {
                camera.addCallbackBuffer(bArr);
                return;
            }
            return;
        }
        processingInProgress = true;
        if (this.mFirstPreviewFrame) {
            this.mFirstPreviewFrame = false;
            this.mFrameOrientation = 1;
            ((CardIOActivity) this.mScanActivityRef.get()).onFirstFrame(1);
        }
        DetectionInfo detectionInfo = new DetectionInfo();
        nScanFrame(bArr, OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE, 480, this.mFrameOrientation, detectionInfo, this.detectedBitmap, this.mScanExpiry);
        if (detectionInfo.focusScore < 6.0f) {
            z = false;
        }
        if (!z) {
            triggerAutoFocus(false);
        } else if (detectionInfo.predicted() || (this.mSuppressScan && detectionInfo.detected())) {
            ((CardIOActivity) this.mScanActivityRef.get()).onCardDetected(this.detectedBitmap, detectionInfo);
        }
        if (camera != null) {
            camera.addCallbackBuffer(bArr);
        }
        processingInProgress = false;
    }

    /* access modifiers changed from: package-private */
    public void onEdgeUpdate(DetectionInfo detectionInfo) {
        ((CardIOActivity) this.mScanActivityRef.get()).onEdgeUpdate(detectionInfo);
    }

    /* access modifiers changed from: package-private */
    public Rect getGuideFrame(int i, int i2, int i3) {
        if (!processorSupported()) {
            return null;
        }
        Rect rect = new Rect();
        nGetGuideFrame(i, i2, i3, rect);
        return rect;
    }

    /* access modifiers changed from: package-private */
    public Rect getGuideFrame(int i, int i2) {
        return getGuideFrame(this.mFrameOrientation, i, i2);
    }

    /* access modifiers changed from: package-private */
    public void setDeviceOrientation(int i) {
        this.mFrameOrientation = i;
    }

    public void onAutoFocus(boolean z, Camera camera) {
        this.mAutoFocusCompletedAt = System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public boolean isAutoFocusing() {
        return this.mAutoFocusCompletedAt < this.mAutoFocusStartedAt;
    }

    /* access modifiers changed from: package-private */
    public void triggerAutoFocus(boolean z) {
        if (this.useCamera && !isAutoFocusing()) {
            try {
                this.mAutoFocusStartedAt = System.currentTimeMillis();
                this.mCamera.autoFocus(this);
                if (z) {
                    this.numManualRefocus++;
                } else {
                    this.numAutoRefocus++;
                }
            } catch (RuntimeException e) {
                Log.w(TAG, "could not trigger auto focus: " + e);
            }
        }
    }

    public boolean isFlashOn() {
        if (!this.useCamera) {
            return false;
        }
        return this.mCamera.getParameters().getFlashMode().equals("torch");
    }

    public boolean setFlashOn(boolean z) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return false;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(z ? "torch" : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            this.mCamera.setParameters(parameters);
            this.numManualTorchChange++;
            return true;
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not set flash mode: " + e);
            return false;
        }
    }

    private void setCameraDisplayOrientation(Camera camera) {
        int i;
        if (Build.VERSION.SDK_INT >= 21) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(0, cameraInfo);
            i = ((cameraInfo.orientation - getRotationalOffset()) + 360) % 360;
        } else {
            i = 90;
        }
        camera.setDisplayOrientation(i);
    }

    /* access modifiers changed from: package-private */
    public int getRotationalOffset() {
        int rotation = ((WindowManager) ((CardIOActivity) this.mScanActivityRef.get()).getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 90;
        }
        if (rotation == 2) {
            return 180;
        }
        return rotation == 3 ? 270 : 0;
    }
}

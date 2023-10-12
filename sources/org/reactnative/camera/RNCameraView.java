package org.reactnative.camera;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.CamcorderProfile;
import android.os.AsyncTask;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.cameraview.CameraView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.camera.tasks.BarCodeScannerAsyncTask;
import org.reactnative.camera.tasks.BarCodeScannerAsyncTaskDelegate;
import org.reactnative.camera.tasks.BarcodeDetectorAsyncTask;
import org.reactnative.camera.tasks.BarcodeDetectorAsyncTaskDelegate;
import org.reactnative.camera.tasks.FaceDetectorAsyncTask;
import org.reactnative.camera.tasks.FaceDetectorAsyncTaskDelegate;
import org.reactnative.camera.tasks.PictureSavedDelegate;
import org.reactnative.camera.tasks.ResolveTakenPictureAsyncTask;
import org.reactnative.camera.tasks.TextRecognizerAsyncTask;
import org.reactnative.camera.tasks.TextRecognizerAsyncTaskDelegate;
import org.reactnative.camera.utils.RNFileUtils;
import org.reactnative.facedetector.RNFaceDetector;

public class RNCameraView extends CameraView implements LifecycleEventListener, BarCodeScannerAsyncTaskDelegate, FaceDetectorAsyncTaskDelegate, BarcodeDetectorAsyncTaskDelegate, TextRecognizerAsyncTaskDelegate, PictureSavedDelegate {
    public volatile boolean barCodeScannerTaskLock = false;
    public volatile boolean faceDetectorTaskLock = false;
    public volatile boolean googleBarcodeDetectorTaskLock = false;
    /* access modifiers changed from: private */
    public boolean invertImageData = false;
    private List<String> mBarCodeTypes = null;
    /* access modifiers changed from: private */
    public int mCameraViewHeight = 0;
    /* access modifiers changed from: private */
    public int mCameraViewWidth = 0;
    private boolean mDetectedImageInEvent = false;
    private int mFaceDetectionClassifications = RNFaceDetector.NO_CLASSIFICATIONS;
    private int mFaceDetectionLandmarks = RNFaceDetector.NO_LANDMARKS;
    /* access modifiers changed from: private */
    public RNFaceDetector mFaceDetector;
    private int mFaceDetectorMode = RNFaceDetector.FAST_MODE;
    private GestureDetector mGestureDetector;
    /* access modifiers changed from: private */
    public RNBarcodeDetector mGoogleBarcodeDetector;
    /* access modifiers changed from: private */
    public int mGoogleVisionBarCodeMode = RNBarcodeDetector.NORMAL_MODE;
    private int mGoogleVisionBarCodeType = RNBarcodeDetector.ALL_FORMATS;
    /* access modifiers changed from: private */
    public boolean mIsNew = true;
    /* access modifiers changed from: private */
    public boolean mIsPaused = false;
    /* access modifiers changed from: private */
    public Boolean mIsRecording = false;
    /* access modifiers changed from: private */
    public Boolean mIsRecordingInterrupted = false;
    /* access modifiers changed from: private */
    public boolean mLimitScanArea = false;
    /* access modifiers changed from: private */
    public MultiFormatReader mMultiFormatReader;
    /* access modifiers changed from: private */
    public int mPaddingX;
    /* access modifiers changed from: private */
    public int mPaddingY;
    /* access modifiers changed from: private */
    public Map<Promise, File> mPictureTakenDirectories = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public Map<Promise, ReadableMap> mPictureTakenOptions = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public Queue<Promise> mPictureTakenPromises = new ConcurrentLinkedQueue();
    private ScaleGestureDetector mScaleGestureDetector;
    /* access modifiers changed from: private */
    public float mScanAreaHeight = 0.0f;
    /* access modifiers changed from: private */
    public float mScanAreaWidth = 0.0f;
    /* access modifiers changed from: private */
    public float mScanAreaX = 0.0f;
    /* access modifiers changed from: private */
    public float mScanAreaY = 0.0f;
    /* access modifiers changed from: private */
    public boolean mShouldDetectFaces = false;
    private boolean mShouldDetectTouches = false;
    /* access modifiers changed from: private */
    public boolean mShouldGoogleDetectBarcodes = false;
    /* access modifiers changed from: private */
    public boolean mShouldRecognizeText = false;
    /* access modifiers changed from: private */
    public boolean mShouldScanBarCodes = false;
    /* access modifiers changed from: private */
    public ThemedReactContext mThemedReactContext;
    private boolean mTrackingEnabled = true;
    private boolean mUseNativeZoom = false;
    /* access modifiers changed from: private */
    public Promise mVideoRecordedPromise;
    private GestureDetector.SimpleOnGestureListener onGestureListener = new GestureDetector.SimpleOnGestureListener() {
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            RNCameraView rNCameraView = RNCameraView.this;
            RNCameraViewHelper.emitTouchEvent(rNCameraView, false, rNCameraView.scalePosition(motionEvent.getX()), RNCameraView.this.scalePosition(motionEvent.getY()));
            return true;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            RNCameraView rNCameraView = RNCameraView.this;
            RNCameraViewHelper.emitTouchEvent(rNCameraView, true, rNCameraView.scalePosition(motionEvent.getX()), RNCameraView.this.scalePosition(motionEvent.getY()));
            return true;
        }
    };
    private ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener() {
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RNCameraView.this.onZoom(scaleGestureDetector.getScaleFactor());
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            RNCameraView.this.onZoom(scaleGestureDetector.getScaleFactor());
            return true;
        }
    };
    public volatile boolean textRecognizerTaskLock = false;

    public void requestLayout() {
    }

    public RNCameraView(ThemedReactContext themedReactContext) {
        super(themedReactContext, true);
        this.mThemedReactContext = themedReactContext;
        themedReactContext.addLifecycleEventListener(this);
        addCallback(new CameraView.Callback() {
            public void onCameraOpened(CameraView cameraView) {
                RNCameraViewHelper.emitCameraReadyEvent(cameraView);
            }

            public void onMountError(CameraView cameraView) {
                RNCameraViewHelper.emitMountErrorEvent(cameraView, "Camera view threw an error - component could not be rendered.");
            }

            public void onPictureTaken(CameraView cameraView, byte[] bArr, int i, int i2) {
                Promise promise = (Promise) RNCameraView.this.mPictureTakenPromises.poll();
                ReadableMap readableMap = (ReadableMap) RNCameraView.this.mPictureTakenOptions.remove(promise);
                if (readableMap.hasKey("fastMode") && readableMap.getBoolean("fastMode")) {
                    promise.resolve((Object) null);
                }
                File file = (File) RNCameraView.this.mPictureTakenDirectories.remove(promise);
                if (Build.VERSION.SDK_INT >= 11) {
                    new ResolveTakenPictureAsyncTask(bArr, promise, readableMap, file, i, i2, RNCameraView.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    new ResolveTakenPictureAsyncTask(bArr, promise, readableMap, file, i, i2, RNCameraView.this).execute(new Void[0]);
                }
                RNCameraViewHelper.emitPictureTakenEvent(cameraView);
            }

            public void onRecordingStart(CameraView cameraView, String str, int i, int i2) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("videoOrientation", i);
                createMap.putInt("deviceOrientation", i2);
                createMap.putString("uri", RNFileUtils.uriFromFile(new File(str)).toString());
                RNCameraViewHelper.emitRecordingStartEvent(cameraView, createMap);
            }

            public void onRecordingEnd(CameraView cameraView) {
                RNCameraViewHelper.emitRecordingEndEvent(cameraView);
            }

            public void onVideoRecorded(CameraView cameraView, String str, int i, int i2) {
                if (RNCameraView.this.mVideoRecordedPromise != null) {
                    if (str != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("isRecordingInterrupted", RNCameraView.this.mIsRecordingInterrupted.booleanValue());
                        createMap.putInt("videoOrientation", i);
                        createMap.putInt("deviceOrientation", i2);
                        createMap.putString("uri", RNFileUtils.uriFromFile(new File(str)).toString());
                        RNCameraView.this.mVideoRecordedPromise.resolve(createMap);
                    } else {
                        RNCameraView.this.mVideoRecordedPromise.reject("E_RECORDING", "Couldn't stop recording - there is none in progress");
                    }
                    Boolean unused = RNCameraView.this.mIsRecording = false;
                    Boolean unused2 = RNCameraView.this.mIsRecordingInterrupted = false;
                    Promise unused3 = RNCameraView.this.mVideoRecordedPromise = null;
                }
            }

            public void onFramePreview(CameraView cameraView, byte[] bArr, int i, int i2, int i3) {
                CameraView cameraView2 = cameraView;
                byte[] bArr2 = bArr;
                int correctCameraRotation = RNCameraViewHelper.getCorrectCameraRotation(i3, RNCameraView.this.getFacing(), RNCameraView.this.getCameraOrientation());
                boolean z = RNCameraView.this.mShouldScanBarCodes && !RNCameraView.this.barCodeScannerTaskLock && (cameraView2 instanceof BarCodeScannerAsyncTaskDelegate);
                boolean z2 = RNCameraView.this.mShouldDetectFaces && !RNCameraView.this.faceDetectorTaskLock && (cameraView2 instanceof FaceDetectorAsyncTaskDelegate);
                boolean z3 = RNCameraView.this.mShouldGoogleDetectBarcodes && !RNCameraView.this.googleBarcodeDetectorTaskLock && (cameraView2 instanceof BarcodeDetectorAsyncTaskDelegate);
                boolean z4 = RNCameraView.this.mShouldRecognizeText && !RNCameraView.this.textRecognizerTaskLock && (cameraView2 instanceof TextRecognizerAsyncTaskDelegate);
                if ((z || z2 || z3 || z4) && ((double) bArr2.length) >= ((double) i) * 1.5d * ((double) i2)) {
                    if (z) {
                        RNCameraView.this.barCodeScannerTaskLock = true;
                        BarCodeScannerAsyncTask barCodeScannerAsyncTask = r2;
                        BarCodeScannerAsyncTask barCodeScannerAsyncTask2 = new BarCodeScannerAsyncTask((BarCodeScannerAsyncTaskDelegate) cameraView2, RNCameraView.this.mMultiFormatReader, bArr, i, i2, RNCameraView.this.mLimitScanArea, RNCameraView.this.mScanAreaX, RNCameraView.this.mScanAreaY, RNCameraView.this.mScanAreaWidth, RNCameraView.this.mScanAreaHeight, RNCameraView.this.mCameraViewWidth, RNCameraView.this.mCameraViewHeight, RNCameraView.this.getAspectRatio().toFloat());
                        barCodeScannerAsyncTask.execute(new Void[0]);
                    }
                    if (z2) {
                        RNCameraView.this.faceDetectorTaskLock = true;
                        new FaceDetectorAsyncTask((FaceDetectorAsyncTaskDelegate) cameraView, RNCameraView.this.mFaceDetector, bArr, i, i2, correctCameraRotation, RNCameraView.this.getResources().getDisplayMetrics().density, RNCameraView.this.getFacing(), RNCameraView.this.getWidth(), RNCameraView.this.getHeight(), RNCameraView.this.mPaddingX, RNCameraView.this.mPaddingY).execute(new Void[0]);
                    }
                    if (z3) {
                        RNCameraView.this.googleBarcodeDetectorTaskLock = true;
                        if (RNCameraView.this.mGoogleVisionBarCodeMode == RNBarcodeDetector.NORMAL_MODE) {
                            boolean unused = RNCameraView.this.invertImageData = false;
                        } else if (RNCameraView.this.mGoogleVisionBarCodeMode == RNBarcodeDetector.ALTERNATE_MODE) {
                            RNCameraView rNCameraView = RNCameraView.this;
                            boolean unused2 = rNCameraView.invertImageData = !rNCameraView.invertImageData;
                        } else if (RNCameraView.this.mGoogleVisionBarCodeMode == RNBarcodeDetector.INVERTED_MODE) {
                            boolean unused3 = RNCameraView.this.invertImageData = true;
                        }
                        byte[] bArr3 = bArr;
                        if (RNCameraView.this.invertImageData) {
                            for (int i4 = 0; i4 < bArr3.length; i4++) {
                                bArr3[i4] = (byte) (~bArr3[i4]);
                            }
                        }
                        new BarcodeDetectorAsyncTask((BarcodeDetectorAsyncTaskDelegate) cameraView, RNCameraView.this.mGoogleBarcodeDetector, bArr, i, i2, correctCameraRotation, RNCameraView.this.getResources().getDisplayMetrics().density, RNCameraView.this.getFacing(), RNCameraView.this.getWidth(), RNCameraView.this.getHeight(), RNCameraView.this.mPaddingX, RNCameraView.this.mPaddingY).execute(new Void[0]);
                    }
                    if (z4) {
                        RNCameraView.this.textRecognizerTaskLock = true;
                        new TextRecognizerAsyncTask((TextRecognizerAsyncTaskDelegate) cameraView, RNCameraView.this.mThemedReactContext, bArr, i, i2, correctCameraRotation, RNCameraView.this.getResources().getDisplayMetrics().density, RNCameraView.this.getFacing(), RNCameraView.this.getWidth(), RNCameraView.this.getHeight(), RNCameraView.this.mPaddingX, RNCameraView.this.mPaddingY).execute(new Void[0]);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        View view = getView();
        if (view != null) {
            float f = (float) (i3 - i);
            float f2 = (float) (i4 - i2);
            float f3 = getAspectRatio().toFloat();
            int i7 = getResources().getConfiguration().orientation;
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            if (i7 == 2) {
                float f4 = f3 * f2;
                if (f4 < f) {
                    i6 = (int) (f / f3);
                } else {
                    i5 = (int) f4;
                    i6 = (int) f2;
                    int i8 = (int) ((f - ((float) i5)) / 2.0f);
                    int i9 = (int) ((f2 - ((float) i6)) / 2.0f);
                    this.mPaddingX = i8;
                    this.mPaddingY = i9;
                    view.layout(i8, i9, i5 + i8, i6 + i9);
                }
            } else {
                float f5 = f3 * f;
                if (f5 > f2) {
                    i6 = (int) f5;
                } else {
                    i5 = (int) (f2 / f3);
                    i6 = (int) f2;
                    int i82 = (int) ((f - ((float) i5)) / 2.0f);
                    int i92 = (int) ((f2 - ((float) i6)) / 2.0f);
                    this.mPaddingX = i82;
                    this.mPaddingY = i92;
                    view.layout(i82, i92, i5 + i82, i6 + i92);
                }
            }
            i5 = (int) f;
            int i822 = (int) ((f - ((float) i5)) / 2.0f);
            int i922 = (int) ((f2 - ((float) i6)) / 2.0f);
            this.mPaddingX = i822;
            this.mPaddingY = i922;
            view.layout(i822, i922, i5 + i822, i6 + i922);
        }
    }

    public void setBarCodeTypes(List<String> list) {
        this.mBarCodeTypes = list;
        initBarcodeReader();
    }

    public void setDetectedImageInEvent(boolean z) {
        this.mDetectedImageInEvent = z;
    }

    public void takePicture(final ReadableMap readableMap, final Promise promise, final File file) {
        this.mBgHandler.post(new Runnable() {
            public void run() {
                RNCameraView.this.mPictureTakenPromises.add(promise);
                RNCameraView.this.mPictureTakenOptions.put(promise, readableMap);
                RNCameraView.this.mPictureTakenDirectories.put(promise, file);
                try {
                    RNCameraView.super.takePicture(readableMap);
                } catch (Exception e) {
                    RNCameraView.this.mPictureTakenPromises.remove(promise);
                    RNCameraView.this.mPictureTakenOptions.remove(promise);
                    RNCameraView.this.mPictureTakenDirectories.remove(promise);
                    promise.reject("E_TAKE_PICTURE_FAILED", e.getMessage());
                }
            }
        });
    }

    public void onPictureSaved(WritableMap writableMap) {
        RNCameraViewHelper.emitPictureSavedEvent(this, writableMap);
    }

    public void record(final ReadableMap readableMap, final Promise promise, final File file) {
        this.mBgHandler.post(new Runnable() {
            public void run() {
                try {
                    String string = readableMap.hasKey(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH) ? readableMap.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH) : RNFileUtils.getOutputFilePath(file, ".mp4");
                    int i = readableMap.hasKey("maxDuration") ? readableMap.getInt("maxDuration") : -1;
                    int i2 = readableMap.hasKey("maxFileSize") ? readableMap.getInt("maxFileSize") : -1;
                    int i3 = readableMap.hasKey("fps") ? readableMap.getInt("fps") : -1;
                    CamcorderProfile camcorderProfile = readableMap.hasKey("quality") ? RNCameraViewHelper.getCamcorderProfile(readableMap.getInt("quality")) : CamcorderProfile.get(1);
                    if (readableMap.hasKey("videoBitrate")) {
                        camcorderProfile.videoBitRate = readableMap.getInt("videoBitrate");
                    }
                    if (RNCameraView.super.record(string, i * 1000, i2, readableMap.hasKey("mute") ? !readableMap.getBoolean("mute") : true, camcorderProfile, readableMap.hasKey(ReactVideoView.EVENT_PROP_ORIENTATION) ? readableMap.getInt(ReactVideoView.EVENT_PROP_ORIENTATION) : 0, i3)) {
                        Boolean unused = RNCameraView.this.mIsRecording = true;
                        Promise unused2 = RNCameraView.this.mVideoRecordedPromise = promise;
                        return;
                    }
                    promise.reject("E_RECORDING_FAILED", "Starting video recording failed. Another recording might be in progress.");
                } catch (IOException unused3) {
                    promise.reject("E_RECORDING_FAILED", "Starting video recording failed - could not create video file.");
                }
            }
        });
    }

    private void initBarcodeReader() {
        this.mMultiFormatReader = new MultiFormatReader();
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        EnumSet<E> noneOf = EnumSet.noneOf(BarcodeFormat.class);
        List<String> list = this.mBarCodeTypes;
        if (list != null) {
            for (String str : list) {
                String str2 = (String) CameraModule.VALID_BARCODE_TYPES.get(str);
                if (str2 != null) {
                    noneOf.add(BarcodeFormat.valueOf(str2));
                }
            }
        }
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, noneOf);
        this.mMultiFormatReader.setHints(enumMap);
    }

    public void setShouldScanBarCodes(boolean z) {
        if (z && this.mMultiFormatReader == null) {
            initBarcodeReader();
        }
        this.mShouldScanBarCodes = z;
        setScanning(this.mShouldDetectFaces || this.mShouldGoogleDetectBarcodes || z || this.mShouldRecognizeText);
    }

    public void onBarCodeRead(Result result, int i, int i2, byte[] bArr) {
        byte[] bArr2;
        String barcodeFormat = result.getBarcodeFormat().toString();
        if (this.mShouldScanBarCodes && this.mBarCodeTypes.contains(barcodeFormat)) {
            if (this.mDetectedImageInEvent) {
                try {
                    YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                    bArr2 = byteArrayOutputStream.toByteArray();
                } catch (Exception e) {
                    throw new RuntimeException(String.format("Error decoding imageData from NV21 format (%d bytes)", new Object[]{Integer.valueOf(bArr.length)}), e);
                }
            } else {
                bArr2 = null;
            }
            RNCameraViewHelper.emitBarCodeReadEvent(this, result, i, i2, bArr2);
        }
    }

    public void onBarCodeScanningTaskCompleted() {
        this.barCodeScannerTaskLock = false;
        MultiFormatReader multiFormatReader = this.mMultiFormatReader;
        if (multiFormatReader != null) {
            multiFormatReader.reset();
        }
    }

    public void setRectOfInterest(float f, float f2, float f3, float f4) {
        this.mLimitScanArea = true;
        this.mScanAreaX = f;
        this.mScanAreaY = f2;
        this.mScanAreaWidth = f3;
        this.mScanAreaHeight = f4;
    }

    public void setCameraViewDimensions(int i, int i2) {
        this.mCameraViewWidth = i;
        this.mCameraViewHeight = i2;
    }

    public void setShouldDetectTouches(boolean z) {
        if (this.mShouldDetectTouches || !z) {
            this.mGestureDetector = null;
        } else {
            this.mGestureDetector = new GestureDetector(this.mThemedReactContext, this.onGestureListener);
        }
        this.mShouldDetectTouches = z;
    }

    public void setUseNativeZoom(boolean z) {
        if (this.mUseNativeZoom || !z) {
            this.mScaleGestureDetector = null;
        } else {
            this.mScaleGestureDetector = new ScaleGestureDetector(this.mThemedReactContext, this.onScaleGestureListener);
        }
        this.mUseNativeZoom = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mUseNativeZoom) {
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
        }
        if (!this.mShouldDetectTouches) {
            return true;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private void setupFaceDetector() {
        RNFaceDetector rNFaceDetector = new RNFaceDetector(this.mThemedReactContext);
        this.mFaceDetector = rNFaceDetector;
        rNFaceDetector.setMode(this.mFaceDetectorMode);
        this.mFaceDetector.setLandmarkType(this.mFaceDetectionLandmarks);
        this.mFaceDetector.setClassificationType(this.mFaceDetectionClassifications);
        this.mFaceDetector.setTracking(this.mTrackingEnabled);
    }

    public void setFaceDetectionLandmarks(int i) {
        this.mFaceDetectionLandmarks = i;
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        if (rNFaceDetector != null) {
            rNFaceDetector.setLandmarkType(i);
        }
    }

    public void setFaceDetectionClassifications(int i) {
        this.mFaceDetectionClassifications = i;
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        if (rNFaceDetector != null) {
            rNFaceDetector.setClassificationType(i);
        }
    }

    public void setFaceDetectionMode(int i) {
        this.mFaceDetectorMode = i;
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        if (rNFaceDetector != null) {
            rNFaceDetector.setMode(i);
        }
    }

    public void setTracking(boolean z) {
        this.mTrackingEnabled = z;
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        if (rNFaceDetector != null) {
            rNFaceDetector.setTracking(z);
        }
    }

    public void setShouldDetectFaces(boolean z) {
        if (z && this.mFaceDetector == null) {
            setupFaceDetector();
        }
        this.mShouldDetectFaces = z;
        setScanning(z || this.mShouldGoogleDetectBarcodes || this.mShouldScanBarCodes || this.mShouldRecognizeText);
    }

    public void onFacesDetected(WritableArray writableArray) {
        if (this.mShouldDetectFaces) {
            RNCameraViewHelper.emitFacesDetectedEvent(this, writableArray);
        }
    }

    public void onFaceDetectionError(RNFaceDetector rNFaceDetector) {
        if (this.mShouldDetectFaces) {
            RNCameraViewHelper.emitFaceDetectionErrorEvent(this, rNFaceDetector);
        }
    }

    public void onFaceDetectingTaskCompleted() {
        this.faceDetectorTaskLock = false;
    }

    private void setupBarcodeDetector() {
        RNBarcodeDetector rNBarcodeDetector = new RNBarcodeDetector(this.mThemedReactContext);
        this.mGoogleBarcodeDetector = rNBarcodeDetector;
        rNBarcodeDetector.setBarcodeType(this.mGoogleVisionBarCodeType);
    }

    public void setShouldGoogleDetectBarcodes(boolean z) {
        if (z && this.mGoogleBarcodeDetector == null) {
            setupBarcodeDetector();
        }
        this.mShouldGoogleDetectBarcodes = z;
        setScanning(this.mShouldDetectFaces || z || this.mShouldScanBarCodes || this.mShouldRecognizeText);
    }

    public void setGoogleVisionBarcodeType(int i) {
        this.mGoogleVisionBarCodeType = i;
        RNBarcodeDetector rNBarcodeDetector = this.mGoogleBarcodeDetector;
        if (rNBarcodeDetector != null) {
            rNBarcodeDetector.setBarcodeType(i);
        }
    }

    public void setGoogleVisionBarcodeMode(int i) {
        this.mGoogleVisionBarCodeMode = i;
    }

    public void onBarcodesDetected(WritableArray writableArray, int i, int i2, byte[] bArr) {
        byte[] bArr2;
        if (this.mShouldGoogleDetectBarcodes) {
            if (this.mDetectedImageInEvent) {
                try {
                    YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                    bArr2 = byteArrayOutputStream.toByteArray();
                } catch (Exception e) {
                    throw new RuntimeException(String.format("Error decoding imageData from NV21 format (%d bytes)", new Object[]{Integer.valueOf(bArr.length)}), e);
                }
            } else {
                bArr2 = null;
            }
            RNCameraViewHelper.emitBarcodesDetectedEvent(this, writableArray, bArr2);
        }
    }

    public void onBarcodeDetectionError(RNBarcodeDetector rNBarcodeDetector) {
        if (this.mShouldGoogleDetectBarcodes) {
            RNCameraViewHelper.emitBarcodeDetectionErrorEvent(this, rNBarcodeDetector);
        }
    }

    public void onBarcodeDetectingTaskCompleted() {
        this.googleBarcodeDetectorTaskLock = false;
    }

    public void setShouldRecognizeText(boolean z) {
        this.mShouldRecognizeText = z;
        setScanning(this.mShouldDetectFaces || this.mShouldGoogleDetectBarcodes || this.mShouldScanBarCodes || z);
    }

    public void onTextRecognized(WritableArray writableArray) {
        if (this.mShouldRecognizeText) {
            RNCameraViewHelper.emitTextRecognizedEvent(this, writableArray);
        }
    }

    public void onTextRecognizerTaskCompleted() {
        this.textRecognizerTaskLock = false;
    }

    public void onHostResume() {
        if (hasCameraPermissions()) {
            this.mBgHandler.post(new Runnable() {
                public void run() {
                    if ((RNCameraView.this.mIsPaused && !RNCameraView.this.isCameraOpened()) || RNCameraView.this.mIsNew) {
                        boolean unused = RNCameraView.this.mIsPaused = false;
                        boolean unused2 = RNCameraView.this.mIsNew = false;
                        RNCameraView.this.start();
                    }
                }
            });
        } else {
            RNCameraViewHelper.emitMountErrorEvent(this, "Camera permissions not granted - component could not be rendered.");
        }
    }

    public void onHostPause() {
        if (this.mIsRecording.booleanValue()) {
            this.mIsRecordingInterrupted = true;
        }
        if (!this.mIsPaused && isCameraOpened()) {
            this.mIsPaused = true;
            stop();
        }
    }

    public void onHostDestroy() {
        RNFaceDetector rNFaceDetector = this.mFaceDetector;
        if (rNFaceDetector != null) {
            rNFaceDetector.release();
        }
        RNBarcodeDetector rNBarcodeDetector = this.mGoogleBarcodeDetector;
        if (rNBarcodeDetector != null) {
            rNBarcodeDetector.release();
        }
        this.mMultiFormatReader = null;
        this.mThemedReactContext.removeLifecycleEventListener(this);
        this.mBgHandler.post(new Runnable() {
            public void run() {
                RNCameraView.this.stop();
                RNCameraView.this.cleanup();
            }
        });
    }

    /* access modifiers changed from: private */
    public void onZoom(float f) {
        float zoom = getZoom();
        float f2 = (f - 1.0f) + zoom;
        if (f2 > zoom) {
            setZoom(Math.min(f2, 1.0f));
        } else {
            setZoom(Math.max(f2, 0.0f));
        }
    }

    private boolean hasCameraPermissions() {
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public int scalePosition(float f) {
        Resources resources = getResources();
        resources.getConfiguration();
        return (int) (f / resources.getDisplayMetrics().density);
    }
}

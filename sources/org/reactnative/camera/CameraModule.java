package org.reactnative.camera;

import android.content.pm.PackageInfo;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.Size;
import com.google.zxing.BarcodeFormat;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import javax.annotation.Nullable;
import kotlinx.coroutines.DebugKt;
import org.reactnative.barcodedetector.BarcodeFormatUtils;
import org.reactnative.camera.utils.ScopedContext;
import org.reactnative.facedetector.RNFaceDetector;

public class CameraModule extends ReactContextBaseJavaModule {
    static final int GOOGLE_VISION_BARCODE_MODE_ALTERNATE = 1;
    static final int GOOGLE_VISION_BARCODE_MODE_INVERTED = 2;
    static final int GOOGLE_VISION_BARCODE_MODE_NORMAL = 0;
    private static final String TAG = "CameraModule";
    public static final Map<String, Object> VALID_BARCODE_TYPES = Collections.unmodifiableMap(new HashMap<String, Object>() {
        {
            put("aztec", BarcodeFormat.AZTEC.toString());
            put("ean13", BarcodeFormat.EAN_13.toString());
            put("ean8", BarcodeFormat.EAN_8.toString());
            put("qr", BarcodeFormat.QR_CODE.toString());
            put("pdf417", BarcodeFormat.PDF_417.toString());
            put("upc_e", BarcodeFormat.UPC_E.toString());
            put("datamatrix", BarcodeFormat.DATA_MATRIX.toString());
            put("code39", BarcodeFormat.CODE_39.toString());
            put("code93", BarcodeFormat.CODE_93.toString());
            put("interleaved2of5", BarcodeFormat.ITF.toString());
            put("codabar", BarcodeFormat.CODABAR.toString());
            put("code128", BarcodeFormat.CODE_128.toString());
            put("maxicode", BarcodeFormat.MAXICODE.toString());
            put("rss14", BarcodeFormat.RSS_14.toString());
            put("rssexpanded", BarcodeFormat.RSS_EXPANDED.toString());
            put("upc_a", BarcodeFormat.UPC_A.toString());
            put("upc_ean", BarcodeFormat.UPC_EAN_EXTENSION.toString());
        }
    });
    static final int VIDEO_1080P = 1;
    static final int VIDEO_2160P = 0;
    static final int VIDEO_480P = 3;
    static final int VIDEO_4x3 = 4;
    static final int VIDEO_720P = 2;
    private ScopedContext mScopedContext;

    public String getName() {
        return "RNCameraModule";
    }

    public CameraModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mScopedContext = new ScopedContext(reactApplicationContext);
    }

    public ScopedContext getScopedContext() {
        return this.mScopedContext;
    }

    @Nullable
    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
            {
                put("Type", getTypeConstants());
                put("FlashMode", getFlashModeConstants());
                put("AutoFocus", getAutoFocusConstants());
                put(ExifInterface.TAG_WHITE_BALANCE, getWhiteBalanceConstants());
                put("VideoQuality", getVideoQualityConstants());
                put("BarCodeType", getBarCodeConstants());
                put("FaceDetection", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("Mode", getFaceDetectionModeConstants());
                        put("Landmarks", getFaceDetectionLandmarksConstants());
                        put("Classifications", getFaceDetectionClassificationsConstants());
                    }

                    private Map<String, Object> getFaceDetectionModeConstants() {
                        return Collections.unmodifiableMap(new HashMap<String, Object>() {
                            {
                                put("fast", Integer.valueOf(RNFaceDetector.FAST_MODE));
                                put("accurate", Integer.valueOf(RNFaceDetector.ACCURATE_MODE));
                            }
                        });
                    }

                    private Map<String, Object> getFaceDetectionClassificationsConstants() {
                        return Collections.unmodifiableMap(new HashMap<String, Object>() {
                            {
                                put("all", Integer.valueOf(RNFaceDetector.ALL_CLASSIFICATIONS));
                                put(ViewProps.NONE, Integer.valueOf(RNFaceDetector.NO_CLASSIFICATIONS));
                            }
                        });
                    }

                    private Map<String, Object> getFaceDetectionLandmarksConstants() {
                        return Collections.unmodifiableMap(new HashMap<String, Object>() {
                            {
                                put("all", Integer.valueOf(RNFaceDetector.ALL_LANDMARKS));
                                put(ViewProps.NONE, Integer.valueOf(RNFaceDetector.NO_LANDMARKS));
                            }
                        });
                    }
                }));
                put("GoogleVisionBarcodeDetection", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("BarcodeType", BarcodeFormatUtils.REVERSE_FORMATS);
                        put("BarcodeMode", AnonymousClass2.this.getGoogleVisionBarcodeModeConstants());
                    }
                }));
                put(ExifInterface.TAG_ORIENTATION, Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("auto", 0);
                        put("portrait", 1);
                        put("portraitUpsideDown", 2);
                        put("landscapeLeft", 3);
                        put("landscapeRight", 4);
                    }
                }));
            }

            private Map<String, Object> getTypeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("front", 1);
                        put("back", 0);
                    }
                });
            }

            private Map<String, Object> getFlashModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put(DebugKt.DEBUG_PROPERTY_VALUE_OFF, 0);
                        put("on", 1);
                        put("auto", 3);
                        put("torch", 2);
                    }
                });
            }

            private Map<String, Object> getAutoFocusConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("on", true);
                        put(DebugKt.DEBUG_PROPERTY_VALUE_OFF, false);
                    }
                });
            }

            private Map<String, Object> getWhiteBalanceConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("auto", 0);
                        put("cloudy", 1);
                        put("sunny", 2);
                        put("shadow", 3);
                        put("fluorescent", 4);
                        put("incandescent", 5);
                    }
                });
            }

            private Map<String, Object> getVideoQualityConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("2160p", 0);
                        put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_1080P, 1);
                        put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_720P, 2);
                        put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_480P, 3);
                        put("4:3", 4);
                    }
                });
            }

            /* access modifiers changed from: private */
            public Map<String, Object> getGoogleVisionBarcodeModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("NORMAL", 0);
                        put("ALTERNATE", 1);
                        put("INVERTED", 2);
                    }
                });
            }

            private Map<String, Object> getBarCodeConstants() {
                return CameraModule.VALID_BARCODE_TYPES;
            }
        });
    }

    @ReactMethod
    public void pausePreview(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    RNCameraView rNCameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(i);
                    if (rNCameraView.isCameraOpened()) {
                        rNCameraView.pausePreview();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void resumePreview(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    RNCameraView rNCameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(i);
                    if (rNCameraView.isCameraOpened()) {
                        rNCameraView.resumePreview();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void takePicture(ReadableMap readableMap, int i, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final File cacheDirectory = this.mScopedContext.getCacheDirectory();
        final int i2 = i;
        final ReadableMap readableMap2 = readableMap;
        final Promise promise2 = promise;
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                RNCameraView rNCameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(i2);
                try {
                    if (rNCameraView.isCameraOpened()) {
                        rNCameraView.takePicture(readableMap2, promise2, cacheDirectory);
                    } else {
                        promise2.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                } catch (Exception e) {
                    promise2.reject("E_TAKE_PICTURE_FAILED", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void record(ReadableMap readableMap, int i, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final File cacheDirectory = this.mScopedContext.getCacheDirectory();
        final int i2 = i;
        final ReadableMap readableMap2 = readableMap;
        final Promise promise2 = promise;
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    RNCameraView rNCameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(i2);
                    if (rNCameraView.isCameraOpened()) {
                        rNCameraView.record(readableMap2, promise2, cacheDirectory);
                    } else {
                        promise2.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                } catch (Exception e) {
                    promise2.reject("E_CAPTURE_FAILED", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void stopRecording(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    RNCameraView rNCameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(i);
                    if (rNCameraView.isCameraOpened()) {
                        rNCameraView.stopRecording();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void pauseRecording(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    RNCameraView rNCameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(i);
                    if (rNCameraView.isCameraOpened()) {
                        rNCameraView.pauseRecording();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void resumeRecording(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    RNCameraView rNCameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(i);
                    if (rNCameraView.isCameraOpened()) {
                        rNCameraView.resumeRecording();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void getSupportedRatios(final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    RNCameraView rNCameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(i);
                    WritableArray createArray = Arguments.createArray();
                    if (rNCameraView.isCameraOpened()) {
                        for (AspectRatio aspectRatio : rNCameraView.getSupportedAspectRatios()) {
                            createArray.pushString(aspectRatio.toString());
                        }
                        promise.resolve(createArray);
                        return;
                    }
                    promise.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void getCameraIds(final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    WritableArray createArray = Arguments.createArray();
                    for (Properties next : ((RNCameraView) nativeViewHierarchyManager.resolveView(i)).getCameraIds()) {
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putString(MessageExtension.FIELD_ID, next.getProperty(MessageExtension.FIELD_ID));
                        writableNativeMap.putInt("type", Integer.valueOf(next.getProperty("type")).intValue());
                        createArray.pushMap(writableNativeMap);
                    }
                    promise.resolve(createArray);
                } catch (Exception e) {
                    e.printStackTrace();
                    promise.reject("E_CAMERA_FAILED", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void getAvailablePictureSizes(final String str, final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    RNCameraView rNCameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(i);
                    WritableArray createArray = Arguments.createArray();
                    if (rNCameraView.isCameraOpened()) {
                        for (Size size : rNCameraView.getAvailablePictureSizes(AspectRatio.parse(str))) {
                            createArray.pushString(size.toString());
                        }
                        promise.resolve(createArray);
                        return;
                    }
                    promise.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                } catch (Exception unused) {
                    promise.reject("E_CAMERA_BAD_VIEWTAG", "getAvailablePictureSizesAsync: Expected a Camera component");
                }
            }
        });
    }

    @ReactMethod
    public void checkIfRecordAudioPermissionsAreDefined(Promise promise) {
        try {
            PackageInfo packageInfo = getCurrentActivity().getPackageManager().getPackageInfo(getReactApplicationContext().getPackageName(), 4096);
            if (packageInfo.requestedPermissions != null) {
                for (String equals : packageInfo.requestedPermissions) {
                    if (equals.equals("android.permission.RECORD_AUDIO")) {
                        promise.resolve(true);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        promise.resolve(false);
    }

    @ReactMethod
    public void getSupportedPreviewFpsRange(final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    WritableArray createArray = Arguments.createArray();
                    Iterator<int[]> it = ((RNCameraView) nativeViewHierarchyManager.resolveView(i)).getSupportedPreviewFpsRange().iterator();
                    while (it.hasNext()) {
                        int[] next = it.next();
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putInt("MINIMUM_FPS", next[0]);
                        writableNativeMap.putInt("MAXIMUM_FPS", next[1]);
                        createArray.pushMap(writableNativeMap);
                    }
                    promise.resolve(createArray);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void hasTorch(Promise promise) {
        promise.resolve(Boolean.valueOf(getReactApplicationContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash")));
    }

    @ReactMethod
    public void checkIfVideoIsValid(final String str, final Promise promise) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                boolean z = true;
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    try {
                        String extractMetadata = mediaMetadataRetriever.extractMetadata(17);
                        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(12);
                        Promise promise = promise;
                        if (extractMetadata != null) {
                            if (!"yes".equals(extractMetadata) && !"true".equals(extractMetadata)) {
                                if (extractMetadata2 != null && extractMetadata2.contains("video")) {
                                }
                            }
                            promise.resolve(Boolean.valueOf(z));
                            mediaMetadataRetriever.release();
                            return;
                        }
                        z = false;
                        promise.resolve(Boolean.valueOf(z));
                        try {
                            mediaMetadataRetriever.release();
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    } catch (Throwable unused2) {
                    }
                    throw th;
                } catch (Exception e) {
                    e.printStackTrace();
                    promise.resolve(true);
                    mediaMetadataRetriever.release();
                } catch (Throwable unused3) {
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}

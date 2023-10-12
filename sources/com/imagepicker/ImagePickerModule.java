package com.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import android.webkit.MimeTypeMap;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.imagepicker.media.ImageConfig;
import com.imagepicker.permissions.OnImagePickerPermissionsCallback;
import com.imagepicker.permissions.PermissionUtils;
import com.imagepicker.utils.MediaUtils;
import com.imagepicker.utils.ReadableMapUtils;
import com.imagepicker.utils.RealPathUtil;
import com.imagepicker.utils.UI;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

@ReactModule(name = "ImagePickerManager")
public class ImagePickerModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final int DEFAULT_EXPLAINING_PERMISSION_DIALIOG_THEME = R.style.DefaultExplainingPermissionsTheme;
    public static final String NAME = "ImagePickerManager";
    public static final int REQUEST_LAUNCH_IMAGE_CAPTURE = 13001;
    public static final int REQUEST_LAUNCH_IMAGE_LIBRARY = 13002;
    public static final int REQUEST_LAUNCH_VIDEO_CAPTURE = 13004;
    public static final int REQUEST_LAUNCH_VIDEO_LIBRARY = 13003;
    public static final int REQUEST_PERMISSIONS_FOR_CAMERA = 14001;
    public static final int REQUEST_PERMISSIONS_FOR_LIBRARY = 14002;
    protected Callback callback;
    protected Uri cameraCaptureURI;
    private final int dialogThemeId;
    private ImageConfig imageConfig;
    private PermissionListener listener;
    private Boolean noData;
    /* access modifiers changed from: private */
    public ReadableMap options;
    /* access modifiers changed from: private */
    public Callback permissionRequestCallback;
    private Boolean pickBoth;
    private Boolean pickVideo;
    private final ReactApplicationContext reactContext;
    /* access modifiers changed from: private */
    public ResponseHelper responseHelper;
    @Deprecated
    private int videoDurationLimit;
    @Deprecated
    private int videoQuality;

    public String getName() {
        return NAME;
    }

    public void onNewIntent(Intent intent) {
    }

    public ImagePickerModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, DEFAULT_EXPLAINING_PERMISSION_DIALIOG_THEME);
    }

    public ImagePickerModule(ReactApplicationContext reactApplicationContext, int i) {
        super(reactApplicationContext);
        this.noData = false;
        this.pickVideo = false;
        this.pickBoth = false;
        this.imageConfig = new ImageConfig((File) null, (File) null, 0, 0, 100, 0, false);
        this.videoQuality = 1;
        this.videoDurationLimit = 0;
        this.responseHelper = new ResponseHelper();
        this.listener = new PermissionListener() {
            public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                boolean z = true;
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    z = z && (iArr[i2] == 0);
                }
                if (ImagePickerModule.this.callback == null || ImagePickerModule.this.options == null) {
                    return false;
                }
                if (!z) {
                    ImagePickerModule.this.responseHelper.invokeError(ImagePickerModule.this.permissionRequestCallback, "Permissions weren't granted");
                    return false;
                }
                if (i == 14001) {
                    ImagePickerModule imagePickerModule = ImagePickerModule.this;
                    imagePickerModule.launchCamera(imagePickerModule.options, ImagePickerModule.this.permissionRequestCallback);
                } else if (i == 14002) {
                    ImagePickerModule imagePickerModule2 = ImagePickerModule.this;
                    imagePickerModule2.launchImageLibrary(imagePickerModule2.options, ImagePickerModule.this.permissionRequestCallback);
                }
                return true;
            }
        };
        this.dialogThemeId = i;
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void showImagePicker(ReadableMap readableMap, Callback callback2) {
        if (getCurrentActivity() == null) {
            this.responseHelper.invokeError(callback2, "can't find current Activity");
            return;
        }
        this.callback = callback2;
        this.options = readableMap;
        this.imageConfig = new ImageConfig((File) null, (File) null, 0, 0, 100, 0, false);
        UI.chooseDialog(this, readableMap, new UI.OnAction() {
            public void onTakePhoto(ImagePickerModule imagePickerModule) {
                if (imagePickerModule != null) {
                    imagePickerModule.launchCamera();
                }
            }

            public void onUseLibrary(ImagePickerModule imagePickerModule) {
                if (imagePickerModule != null) {
                    imagePickerModule.launchImageLibrary();
                }
            }

            public void onCancel(ImagePickerModule imagePickerModule) {
                if (imagePickerModule != null) {
                    imagePickerModule.doOnCancel();
                }
            }

            public void onCustomButton(ImagePickerModule imagePickerModule, String str) {
                if (imagePickerModule != null) {
                    imagePickerModule.invokeCustomButton(str);
                }
            }
        }).show();
    }

    public void doOnCancel() {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            this.responseHelper.invokeCancel(callback2);
            this.callback = null;
        }
    }

    public void launchCamera() {
        launchCamera(this.options, this.callback);
    }

    @ReactMethod
    public void launchCamera(ReadableMap readableMap, Callback callback2) {
        int i;
        Intent intent;
        this.permissionRequestCallback = callback2;
        if (!isCameraAvailable()) {
            this.responseHelper.invokeError(callback2, "Camera not available");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            this.responseHelper.invokeError(callback2, "can't find current Activity");
            return;
        }
        this.callback = callback2;
        this.options = readableMap;
        if (permissionsCheck(currentActivity, callback2, REQUEST_PERMISSIONS_FOR_CAMERA)) {
            parseOptions(this.options);
            if (this.pickVideo.booleanValue()) {
                i = 13004;
                intent = new Intent("android.media.action.VIDEO_CAPTURE");
                intent.putExtra("android.intent.extra.videoQuality", this.videoQuality);
                int i2 = this.videoDurationLimit;
                if (i2 > 0) {
                    intent.putExtra("android.intent.extra.durationLimit", i2);
                }
            } else {
                i = REQUEST_LAUNCH_IMAGE_CAPTURE;
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                ImageConfig withOriginalFile = this.imageConfig.withOriginalFile(MediaUtils.createNewFile(this.reactContext, this.options, false));
                this.imageConfig = withOriginalFile;
                if (withOriginalFile.original != null) {
                    Uri compatUriFromFile = RealPathUtil.compatUriFromFile(this.reactContext, this.imageConfig.original);
                    this.cameraCaptureURI = compatUriFromFile;
                    if (compatUriFromFile == null) {
                        this.responseHelper.invokeError(callback2, "Couldn't get file path for photo");
                        return;
                    }
                    intent.putExtra("output", compatUriFromFile);
                } else {
                    this.responseHelper.invokeError(callback2, "Couldn't get file path for photo");
                    return;
                }
            }
            if (intent.resolveActivity(this.reactContext.getPackageManager()) == null) {
                this.responseHelper.invokeError(callback2, "Cannot launch camera");
                return;
            }
            if (Build.VERSION.SDK_INT <= 19) {
                for (ResolveInfo resolveInfo : this.reactContext.getPackageManager().queryIntentActivities(intent, 65536)) {
                    this.reactContext.grantUriPermission(resolveInfo.activityInfo.packageName, this.cameraCaptureURI, 3);
                }
            }
            try {
                currentActivity.startActivityForResult(intent, i);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                this.responseHelper.invokeError(callback2, "Cannot launch camera");
            }
        }
    }

    public void launchImageLibrary() {
        launchImageLibrary(this.options, this.callback);
    }

    @ReactMethod
    public void launchImageLibrary(ReadableMap readableMap, Callback callback2) {
        Intent intent;
        int i;
        this.permissionRequestCallback = callback2;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            this.responseHelper.invokeError(callback2, "can't find current Activity");
            return;
        }
        this.callback = callback2;
        this.options = readableMap;
        if (permissionsCheck(currentActivity, callback2, REQUEST_PERMISSIONS_FOR_LIBRARY)) {
            parseOptions(this.options);
            if (this.pickVideo.booleanValue()) {
                i = REQUEST_LAUNCH_VIDEO_LIBRARY;
                intent = new Intent("android.intent.action.PICK");
                intent.setType("video/*");
            } else {
                i = REQUEST_LAUNCH_IMAGE_LIBRARY;
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (this.pickBoth.booleanValue()) {
                    intent.setType("image/* video/*");
                }
            }
            if (intent.resolveActivity(this.reactContext.getPackageManager()) == null) {
                this.responseHelper.invokeError(callback2, "Cannot launch photo library");
                return;
            }
            String str = null;
            try {
                if (ReadableMapUtils.hasAndNotEmptyString(readableMap, "chooseWhichLibraryTitle")) {
                    str = readableMap.getString("chooseWhichLibraryTitle");
                }
                currentActivity.startActivityForResult(Intent.createChooser(intent, str), i);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                this.responseHelper.invokeError(callback2, "Cannot launch photo library");
            }
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Uri uri;
        if (!passResult(i)) {
            this.responseHelper.cleanResponse();
            if (i2 != -1) {
                MediaUtils.removeUselessFiles(i, this.imageConfig);
                this.responseHelper.invokeCancel(this.callback);
                this.callback = null;
                return;
            }
            switch (i) {
                case REQUEST_LAUNCH_IMAGE_CAPTURE /*13001*/:
                    uri = this.cameraCaptureURI;
                    break;
                case REQUEST_LAUNCH_IMAGE_LIBRARY /*13002*/:
                    uri = intent.getData();
                    String realPathFromURI = getRealPathFromURI(uri);
                    boolean z = !TextUtils.isEmpty(realPathFromURI) && Patterns.WEB_URL.matcher(realPathFromURI).matches();
                    if (realPathFromURI == null || z) {
                        try {
                            File createFileFromURI = createFileFromURI(uri);
                            String absolutePath = createFileFromURI.getAbsolutePath();
                            uri = Uri.fromFile(createFileFromURI);
                            realPathFromURI = absolutePath;
                        } catch (Exception unused) {
                            this.responseHelper.putString(ReactVideoView.EVENT_PROP_ERROR, "Could not read photo");
                            this.responseHelper.putString("uri", uri.toString());
                            this.responseHelper.invokeResponse(this.callback);
                            this.callback = null;
                            return;
                        }
                    }
                    this.imageConfig = this.imageConfig.withOriginalFile(new File(realPathFromURI));
                    break;
                case REQUEST_LAUNCH_VIDEO_LIBRARY /*13003*/:
                    this.responseHelper.putString("uri", intent.getData().toString());
                    this.responseHelper.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, getRealPathFromURI(intent.getData()));
                    this.responseHelper.invokeResponse(this.callback);
                    this.callback = null;
                    return;
                case 13004:
                    String realPathFromURI2 = getRealPathFromURI(intent.getData());
                    this.responseHelper.putString("uri", intent.getData().toString());
                    this.responseHelper.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, realPathFromURI2);
                    MediaUtils.fileScan(this.reactContext, realPathFromURI2);
                    this.responseHelper.invokeResponse(this.callback);
                    this.callback = null;
                    return;
                default:
                    uri = null;
                    break;
            }
            MediaUtils.ReadExifResult readExifInterface = MediaUtils.readExifInterface(this.responseHelper, this.imageConfig);
            if (readExifInterface.error != null) {
                MediaUtils.removeUselessFiles(i, this.imageConfig);
                this.responseHelper.invokeError(this.callback, readExifInterface.error.getMessage());
                this.callback = null;
                return;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.imageConfig.original.getAbsolutePath(), options2);
            int i3 = options2.outWidth;
            int i4 = options2.outHeight;
            updatedResultResponse(uri, this.imageConfig.original.getAbsolutePath());
            if (this.imageConfig.useOriginal(i3, i4, readExifInterface.currentRotation)) {
                this.responseHelper.putInt("width", i3);
                this.responseHelper.putInt("height", i4);
                MediaUtils.fileScan(this.reactContext, this.imageConfig.original.getAbsolutePath());
            } else {
                ImageConfig resizedImage = MediaUtils.getResizedImage(this.reactContext, this.options, this.imageConfig, i3, i4, i);
                this.imageConfig = resizedImage;
                if (resizedImage.resized == null) {
                    MediaUtils.removeUselessFiles(i, this.imageConfig);
                    this.responseHelper.putString(ReactVideoView.EVENT_PROP_ERROR, "Can't resize the image");
                } else {
                    Uri fromFile = Uri.fromFile(this.imageConfig.resized);
                    BitmapFactory.decodeFile(this.imageConfig.resized.getAbsolutePath(), options2);
                    this.responseHelper.putInt("width", options2.outWidth);
                    this.responseHelper.putInt("height", options2.outHeight);
                    updatedResultResponse(fromFile, this.imageConfig.resized.getAbsolutePath());
                    MediaUtils.fileScan(this.reactContext, this.imageConfig.resized.getAbsolutePath());
                }
            }
            if (this.imageConfig.saveToCameraRoll && i == 13001) {
                MediaUtils.RolloutPhotoResult rolloutPhotoFromCamera = MediaUtils.rolloutPhotoFromCamera(this.imageConfig);
                if (rolloutPhotoFromCamera.error == null) {
                    ImageConfig imageConfig2 = rolloutPhotoFromCamera.imageConfig;
                    this.imageConfig = imageConfig2;
                    updatedResultResponse(Uri.fromFile(imageConfig2.getActualFile()), this.imageConfig.getActualFile().getAbsolutePath());
                } else {
                    MediaUtils.removeUselessFiles(i, this.imageConfig);
                    this.responseHelper.putString(ReactVideoView.EVENT_PROP_ERROR, "Error moving image to camera roll: " + rolloutPhotoFromCamera.error.getMessage());
                    return;
                }
            }
            this.responseHelper.invokeResponse(this.callback);
            this.callback = null;
            this.options = null;
        }
    }

    public void invokeCustomButton(String str) {
        this.responseHelper.invokeCustomButton(this.callback, str);
    }

    public Context getContext() {
        return getReactApplicationContext();
    }

    public int getDialogThemeId() {
        return this.dialogThemeId;
    }

    public Activity getActivity() {
        return getCurrentActivity();
    }

    private boolean passResult(int i) {
        return this.callback == null || (this.cameraCaptureURI == null && i == 13001) || !(i == 13001 || i == 13002 || i == 13003 || i == 13004);
    }

    private void updatedResultResponse(Uri uri, String str) {
        this.responseHelper.putString("uri", uri.toString());
        this.responseHelper.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, str);
        if (!this.noData.booleanValue()) {
            this.responseHelper.putString("data", getBase64StringFromFile(str));
        }
        putExtraFileInfo(str, this.responseHelper);
    }

    private boolean permissionsCheck(Activity activity, Callback callback2, int i) {
        String[] strArr;
        int checkSelfPermission = ActivityCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        boolean z = true;
        if (i == 14001 ? ActivityCompat.checkSelfPermission(activity, "android.permission.CAMERA") == 0 && checkSelfPermission == 0 : i == 14002 && checkSelfPermission == 0) {
            return true;
        }
        if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.WRITE_EXTERNAL_STORAGE") || !ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.CAMERA")) {
            z = false;
        }
        if (Boolean.valueOf(z).booleanValue()) {
            AlertDialog explainingDialog = PermissionUtils.explainingDialog(this, this.options, new PermissionUtils.OnExplainingPermissionCallback() {
                public void onCancel(WeakReference<ImagePickerModule> weakReference, DialogInterface dialogInterface) {
                    ImagePickerModule imagePickerModule = (ImagePickerModule) weakReference.get();
                    if (imagePickerModule != null) {
                        imagePickerModule.doOnCancel();
                    }
                }

                public void onReTry(WeakReference<ImagePickerModule> weakReference, DialogInterface dialogInterface) {
                    ImagePickerModule imagePickerModule = (ImagePickerModule) weakReference.get();
                    if (imagePickerModule != null) {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", imagePickerModule.getContext().getPackageName(), (String) null));
                        Activity activity = imagePickerModule.getActivity();
                        if (activity != null) {
                            activity.startActivityForResult(intent, 1);
                        }
                    }
                }
            });
            if (explainingDialog != null) {
                explainingDialog.show();
            }
            return false;
        }
        if (i == 14001) {
            strArr = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        } else if (i != 14002) {
            strArr = new String[0];
        } else {
            strArr = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        if (activity instanceof ReactActivity) {
            ((ReactActivity) activity).requestPermissions(strArr, i, this.listener);
        } else if (activity instanceof PermissionAwareActivity) {
            ((PermissionAwareActivity) activity).requestPermissions(strArr, i, this.listener);
        } else if (activity instanceof OnImagePickerPermissionsCallback) {
            ((OnImagePickerPermissionsCallback) activity).setPermissionListener(this.listener);
            ActivityCompat.requestPermissions(activity, strArr, i);
        } else {
            throw new UnsupportedOperationException(activity.getClass().getSimpleName() + " must implement " + OnImagePickerPermissionsCallback.class.getSimpleName() + " or " + PermissionAwareActivity.class.getSimpleName());
        }
        return false;
    }

    private boolean isCameraAvailable() {
        return this.reactContext.getPackageManager().hasSystemFeature("android.hardware.camera") || this.reactContext.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    private String getRealPathFromURI(Uri uri) {
        return RealPathUtil.getRealPathFromURI(this.reactContext, uri);
    }

    private File createFileFromURI(Uri uri) throws Exception {
        File externalCacheDir = this.reactContext.getExternalCacheDir();
        File file = new File(externalCacheDir, "photo-" + uri.getLastPathSegment());
        InputStream openInputStream = this.reactContext.getContentResolver().openInputStream(uri);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    return file;
                }
            }
        } finally {
            fileOutputStream.close();
            openInputStream.close();
        }
    }

    private String getBase64StringFromFile(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private void putExtraFileInfo(String str, ResponseHelper responseHelper2) {
        try {
            File file = new File(str);
            responseHelper2.putDouble("fileSize", (double) file.length());
            responseHelper2.putString("fileName", file.getName());
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            String name = file.getName();
            if (fileExtensionFromUrl != "") {
                responseHelper2.putString("type", MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl));
                return;
            }
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                responseHelper2.putString("type", MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseOptions(ReadableMap readableMap) {
        this.noData = false;
        if (readableMap.hasKey("noData")) {
            this.noData = Boolean.valueOf(readableMap.getBoolean("noData"));
        }
        this.imageConfig = this.imageConfig.updateFromOptions(readableMap);
        this.pickVideo = false;
        this.pickBoth = false;
        if (readableMap.hasKey("mediaType") && readableMap.getString("mediaType").equals("mixed")) {
            this.pickBoth = true;
        }
        if (readableMap.hasKey("mediaType") && readableMap.getString("mediaType").equals("video")) {
            this.pickVideo = true;
        }
        this.videoQuality = 1;
        if (readableMap.hasKey("videoQuality") && readableMap.getString("videoQuality").equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_LOW)) {
            this.videoQuality = 0;
        }
        this.videoDurationLimit = 0;
        if (readableMap.hasKey("durationLimit")) {
            this.videoDurationLimit = readableMap.getInt("durationLimit");
        }
    }
}

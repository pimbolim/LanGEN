package io.invertase.firebase.storage;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.braintreepayments.api.models.PostalAddressParser;
import com.brentvatne.react.ReactVideoView;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.StreamDownloadTask;
import com.google.firebase.storage.UploadTask;
import io.invertase.firebase.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RNFirebaseStorage extends ReactContextBaseJavaModule {
    private static final String CachesDirectoryPath = "CACHES_DIRECTORY_PATH";
    private static final String DocumentDirectoryPath = "DOCUMENT_DIRECTORY_PATH";
    private static final String ExternalDirectoryPath = "EXTERNAL_DIRECTORY_PATH";
    private static final String ExternalStorageDirectoryPath = "EXTERNAL_STORAGE_DIRECTORY_PATH";
    private static final String FileTypeDirectory = "FILETYPE_DIRECTORY";
    private static final String FileTypeRegular = "FILETYPE_REGULAR";
    private static final String PicturesDirectoryPath = "PICTURES_DIRECTORY_PATH";
    private static final String STORAGE_DOWNLOAD_FAILURE = "download_failure";
    private static final String STORAGE_DOWNLOAD_SUCCESS = "download_success";
    private static final String STORAGE_EVENT = "storage_event";
    private static final String STORAGE_STATE_CHANGED = "state_changed";
    private static final String STORAGE_UPLOAD_FAILURE = "upload_failure";
    private static final String STORAGE_UPLOAD_SUCCESS = "upload_success";
    private static final String TAG = "RNFirebaseStorage";
    private static final String TemporaryDirectoryPath = "TEMP_DIRECTORY_PATH";

    public String getName() {
        return TAG;
    }

    public RNFirebaseStorage(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Log.d(TAG, "New instance");
    }

    public boolean isExternalStorageWritable() {
        boolean z;
        boolean z2;
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            z2 = true;
            z = true;
        } else {
            z2 = "mounted_ro".equals(externalStorageState);
            z = false;
        }
        if (!z2 || !z) {
            return false;
        }
        return true;
    }

    @ReactMethod
    public void delete(String str, String str2, final Promise promise) {
        getReference(str2, str).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            public void onSuccess(Void voidR) {
                promise.resolve((Object) null);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                RNFirebaseStorage.this.promiseRejectStorageException(promise, exc);
            }
        });
    }

    @ReactMethod
    public void getDownloadURL(String str, String str2, final Promise promise) {
        Log.d(TAG, "getDownloadURL path " + str2);
        getReference(str2, str).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            public void onSuccess(Uri uri) {
                promise.resolve(uri.toString());
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                RNFirebaseStorage.this.promiseRejectStorageException(promise, exc);
            }
        });
    }

    @ReactMethod
    public void getMetadata(String str, String str2, final Promise promise) {
        getReference(str2, str).getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
            public void onSuccess(StorageMetadata storageMetadata) {
                promise.resolve(RNFirebaseStorage.this.getMetadataAsMap(storageMetadata));
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                RNFirebaseStorage.this.promiseRejectStorageException(promise, exc);
            }
        });
    }

    @ReactMethod
    public void updateMetadata(String str, String str2, ReadableMap readableMap, final Promise promise) {
        getReference(str2, str).updateMetadata(buildMetadataFromMap(readableMap, (Uri) null)).addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
            public void onSuccess(StorageMetadata storageMetadata) {
                promise.resolve(RNFirebaseStorage.this.getMetadataAsMap(storageMetadata));
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                RNFirebaseStorage.this.promiseRejectStorageException(promise, exc);
            }
        });
    }

    @ReactMethod
    public void downloadFile(final String str, final String str2, final String str3, final Promise promise) {
        if (!isExternalStorageWritable()) {
            promise.reject("storage/invalid-device-file-path", "The specified device file path is invalid or is restricted.");
            return;
        }
        Log.d(TAG, "downloadFile path: " + str2);
        getReference(str2, str).getStream(new StreamDownloadTask.StreamProcessor() {
            public void doInBackground(StreamDownloadTask.TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException {
                String str = "/";
                int lastIndexOf = str3.lastIndexOf(str);
                if (lastIndexOf > 0) {
                    str = str3.substring(0, lastIndexOf) + str;
                }
                String substring = lastIndexOf > 0 ? str3.substring(lastIndexOf + 1) : str3;
                Boolean.valueOf(new File(str).mkdirs());
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str, substring));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        return;
                    }
                }
            }
        }).addOnProgressListener(new OnProgressListener<StreamDownloadTask.TaskSnapshot>() {
            public void onProgress(StreamDownloadTask.TaskSnapshot taskSnapshot) {
                Log.d(RNFirebaseStorage.TAG, "downloadFile progress " + taskSnapshot);
                RNFirebaseStorage.this.sendJSEvent(str, RNFirebaseStorage.STORAGE_STATE_CHANGED, str2, RNFirebaseStorage.this.getDownloadTaskAsMap(taskSnapshot));
            }
        }).addOnPausedListener(new OnPausedListener<StreamDownloadTask.TaskSnapshot>() {
            public void onPaused(StreamDownloadTask.TaskSnapshot taskSnapshot) {
                Log.d(RNFirebaseStorage.TAG, "downloadFile paused " + taskSnapshot);
                RNFirebaseStorage.this.sendJSEvent(str, RNFirebaseStorage.STORAGE_STATE_CHANGED, str2, RNFirebaseStorage.this.getDownloadTaskAsMap(taskSnapshot));
            }
        }).addOnSuccessListener(new OnSuccessListener<StreamDownloadTask.TaskSnapshot>() {
            public void onSuccess(StreamDownloadTask.TaskSnapshot taskSnapshot) {
                Log.d(RNFirebaseStorage.TAG, "downloadFile success" + taskSnapshot);
                RNFirebaseStorage.this.sendJSEvent(str, RNFirebaseStorage.STORAGE_DOWNLOAD_SUCCESS, str2, RNFirebaseStorage.this.getDownloadTaskAsMap(taskSnapshot));
                promise.resolve(RNFirebaseStorage.this.getDownloadTaskAsMap(taskSnapshot));
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(@Nonnull Exception exc) {
                Log.e(RNFirebaseStorage.TAG, "downloadFile failure " + exc.getMessage());
                RNFirebaseStorage.this.promiseRejectStorageException(promise, exc);
            }
        });
    }

    @ReactMethod
    public void setMaxDownloadRetryTime(String str, double d) {
        FirebaseStorage.getInstance(FirebaseApp.getInstance(str)).setMaxDownloadRetryTimeMillis((long) d);
    }

    @ReactMethod
    public void setMaxOperationRetryTime(String str, double d) {
        FirebaseStorage.getInstance(FirebaseApp.getInstance(str)).setMaxOperationRetryTimeMillis((long) d);
    }

    @ReactMethod
    public void setMaxUploadRetryTime(String str, double d) {
        FirebaseStorage.getInstance(FirebaseApp.getInstance(str)).setMaxUploadRetryTimeMillis((long) d);
    }

    @ReactMethod
    public void putFile(final String str, final String str2, String str3, ReadableMap readableMap, final Promise promise) {
        StorageReference reference = getReference(str2, str);
        Log.i(TAG, "putFile: " + str3 + " to " + str2);
        try {
            Uri uri = getURI(str3);
            reference.putFile(uri, buildMetadataFromMap(readableMap, uri)).addOnFailureListener(new OnFailureListener() {
                public void onFailure(@Nonnull Exception exc) {
                    Log.e(RNFirebaseStorage.TAG, "putFile failure " + exc.getMessage());
                    RNFirebaseStorage.this.promiseRejectStorageException(promise, exc);
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Log.d(RNFirebaseStorage.TAG, "putFile success " + taskSnapshot);
                    RNFirebaseStorage.this.getUploadTaskAsMap(taskSnapshot, new OnSuccessListener<WritableMap>() {
                        public void onSuccess(WritableMap writableMap) {
                            RNFirebaseStorage.this.sendJSEvent(str, RNFirebaseStorage.STORAGE_STATE_CHANGED, str2, writableMap);
                        }
                    });
                    RNFirebaseStorage.this.getUploadTaskAsMap(taskSnapshot, new OnSuccessListener<WritableMap>() {
                        public void onSuccess(WritableMap writableMap) {
                            RNFirebaseStorage.this.sendJSEvent(str, RNFirebaseStorage.STORAGE_UPLOAD_SUCCESS, str2, writableMap);
                        }
                    });
                    RNFirebaseStorage.this.getUploadTaskAsMap(taskSnapshot, new OnSuccessListener<WritableMap>() {
                        public void onSuccess(WritableMap writableMap) {
                            promise.resolve(writableMap);
                        }
                    });
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    Log.d(RNFirebaseStorage.TAG, "putFile progress " + taskSnapshot);
                    RNFirebaseStorage.this.getUploadTaskAsMap(taskSnapshot, new OnSuccessListener<WritableMap>() {
                        public void onSuccess(WritableMap writableMap) {
                            RNFirebaseStorage.this.sendJSEvent(str, RNFirebaseStorage.STORAGE_STATE_CHANGED, str2, writableMap);
                        }
                    });
                }
            }).addOnPausedListener(new OnPausedListener<UploadTask.TaskSnapshot>() {
                public void onPaused(UploadTask.TaskSnapshot taskSnapshot) {
                    Log.d(RNFirebaseStorage.TAG, "putFile paused " + taskSnapshot);
                    RNFirebaseStorage.this.getUploadTaskAsMap(taskSnapshot, new OnSuccessListener<WritableMap>() {
                        public void onSuccess(WritableMap writableMap) {
                            RNFirebaseStorage.this.sendJSEvent(str, RNFirebaseStorage.STORAGE_STATE_CHANGED, str2, writableMap);
                        }
                    });
                }
            });
        } catch (Exception e) {
            promiseRejectStorageException(promise, e);
        }
    }

    private StorageReference getReference(String str, String str2) {
        FirebaseStorage instance = FirebaseStorage.getInstance(FirebaseApp.getInstance(str2));
        if (str.startsWith("url::")) {
            return instance.getReferenceFromUrl(str.substring(5));
        }
        return instance.getReference(str);
    }

    private Uri getURI(String str) {
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null || parse.getScheme().isEmpty()) {
            return Uri.fromFile(new File(str));
        }
        return parse;
    }

    private StorageMetadata buildMetadataFromMap(ReadableMap readableMap, @Nullable Uri uri) {
        String str;
        StorageMetadata.Builder builder = new StorageMetadata.Builder();
        try {
            Map<String, Object> recursivelyDeconstructReadableMap = Utils.recursivelyDeconstructReadableMap(readableMap);
            Map map = (Map) recursivelyDeconstructReadableMap.get("customMetadata");
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    builder.setCustomMetadata((String) entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            builder.setCacheControl((String) recursivelyDeconstructReadableMap.get("cacheControl"));
            builder.setContentDisposition((String) recursivelyDeconstructReadableMap.get("contentDisposition"));
            builder.setContentEncoding((String) recursivelyDeconstructReadableMap.get("contentEncoding"));
            builder.setContentLanguage((String) recursivelyDeconstructReadableMap.get("contentLanguage"));
            if (readableMap.hasKey("contentType")) {
                builder.setContentType((String) recursivelyDeconstructReadableMap.get("contentType"));
            } else if (uri != null) {
                if (uri.getScheme().equals("content")) {
                    str = getReactApplicationContext().getContentResolver().getType(uri);
                } else {
                    str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
                }
                if (str != null) {
                    builder.setContentType(str);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "error while building meta data " + e.getMessage());
        }
        return builder.build();
    }

    /* access modifiers changed from: private */
    public WritableMap getDownloadTaskAsMap(StreamDownloadTask.TaskSnapshot taskSnapshot) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("bytesTransferred", (double) taskSnapshot.getBytesTransferred());
        createMap.putString("ref", taskSnapshot.getStorage().getPath());
        createMap.putString(PostalAddressParser.REGION_KEY, getTaskStatus(taskSnapshot.getTask()));
        createMap.putDouble("totalBytes", (double) taskSnapshot.getTotalByteCount());
        return createMap;
    }

    /* access modifiers changed from: private */
    public void getUploadTaskAsMap(final UploadTask.TaskSnapshot taskSnapshot, final OnSuccessListener<WritableMap> onSuccessListener) {
        if (taskSnapshot != null) {
            taskSnapshot.getStorage().getDownloadUrl().addOnFailureListener(new OnFailureListener() {
                public void onFailure(@Nonnull Exception exc) {
                    int errorCode = ((StorageException) exc).getErrorCode();
                    if (errorCode == -13021 || errorCode == -13010) {
                        onSuccessListener.onSuccess(RNFirebaseStorage.this.getRespAsMap(taskSnapshot, (String) null));
                    }
                }
            }).addOnSuccessListener(new OnSuccessListener<Uri>() {
                public void onSuccess(Uri uri) {
                    onSuccessListener.onSuccess(RNFirebaseStorage.this.getRespAsMap(taskSnapshot, uri.toString()));
                }
            });
        } else {
            onSuccessListener.onSuccess(Arguments.createMap());
        }
    }

    /* access modifiers changed from: private */
    public WritableMap getRespAsMap(UploadTask.TaskSnapshot taskSnapshot, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("bytesTransferred", (double) taskSnapshot.getBytesTransferred());
        createMap.putString("downloadURL", str);
        StorageMetadata metadata = taskSnapshot.getMetadata();
        if (metadata != null) {
            createMap.putMap(ReactVideoView.EVENT_PROP_METADATA, getMetadataAsMap(metadata));
        }
        createMap.putString("ref", taskSnapshot.getStorage().getPath());
        createMap.putString(PostalAddressParser.REGION_KEY, getTaskStatus(taskSnapshot.getTask()));
        createMap.putDouble("totalBytes", (double) taskSnapshot.getTotalByteCount());
        return createMap;
    }

    /* access modifiers changed from: private */
    public WritableMap getMetadataAsMap(StorageMetadata storageMetadata) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("bucket", storageMetadata.getBucket());
        createMap.putString("generation", storageMetadata.getGeneration());
        createMap.putString("metageneration", storageMetadata.getMetadataGeneration());
        createMap.putString("fullPath", storageMetadata.getPath());
        createMap.putString("name", storageMetadata.getName());
        createMap.putDouble("size", (double) storageMetadata.getSizeBytes());
        createMap.putDouble("timeCreated", (double) storageMetadata.getCreationTimeMillis());
        createMap.putDouble("updated", (double) storageMetadata.getUpdatedTimeMillis());
        createMap.putString("md5hash", storageMetadata.getMd5Hash());
        createMap.putString("cacheControl", storageMetadata.getCacheControl());
        createMap.putString("contentDisposition", storageMetadata.getContentDisposition());
        createMap.putString("contentEncoding", storageMetadata.getContentEncoding());
        createMap.putString("contentLanguage", storageMetadata.getContentLanguage());
        createMap.putString("contentType", storageMetadata.getContentType());
        WritableMap createMap2 = Arguments.createMap();
        for (String str : storageMetadata.getCustomMetadataKeys()) {
            createMap2.putString(str, storageMetadata.getCustomMetadata(str));
        }
        createMap.putMap("customMetadata", createMap2);
        return createMap;
    }

    private String getTaskStatus(StorageTask<?> storageTask) {
        if (storageTask.isInProgress()) {
            return "running";
        }
        if (storageTask.isPaused()) {
            return ReactVideoViewManager.PROP_PAUSED;
        }
        if (storageTask.isSuccessful() || storageTask.isComplete()) {
            return "success";
        }
        if (storageTask.isCanceled()) {
            return "cancelled";
        }
        return storageTask.getException() != null ? ReactVideoView.EVENT_PROP_ERROR : "unknown";
    }

    /* access modifiers changed from: private */
    public void sendJSEvent(String str, String str2, String str3, WritableMap writableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.putMap("body", writableMap);
        createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, str3);
        createMap.putString("eventName", str2);
        createMap.putString("appName", str);
        Utils.sendEvent(getReactApplicationContext(), STORAGE_EVENT, createMap);
    }

    /* access modifiers changed from: private */
    public void promiseRejectStorageException(Promise promise, Exception exc) {
        String str = "storage/unknown";
        String message = exc.getMessage();
        try {
            String str2 = "An unknown error has occurred.";
            if (exc instanceof StorageException) {
                int errorCode = ((StorageException) exc).getErrorCode();
                if (errorCode == -13040) {
                    str = "storage/cancelled";
                    message = "User cancelled the operation.";
                } else if (errorCode == -13000) {
                    message = str2;
                } else if (errorCode == -13031) {
                    str = "storage/non-matching-checksum";
                    message = "File on the client does not match the checksum of the file received by the server.";
                } else if (errorCode == -13030) {
                    str = "storage/retry-limit-exceeded";
                    message = "The maximum time limit on an operation (upload, download, delete, etc.) has been exceeded.";
                } else if (errorCode == -13021) {
                    str = "storage/unauthorized";
                    message = "User is not authorized to perform the desired action.";
                } else if (errorCode != -13020) {
                    switch (errorCode) {
                        case -13013:
                            str = "storage/quota-exceeded";
                            message = "Quota on your Firebase Storage bucket has been exceeded.";
                            break;
                        case -13012:
                            str = "storage/project-not-found";
                            message = "No project is configured for Firebase Storage.";
                            break;
                        case -13011:
                            str = "storage/bucket-not-found";
                            message = "No bucket is configured for Firebase Storage.";
                            break;
                        case -13010:
                            str = "storage/object-not-found";
                            message = "No object exists at the desired reference.";
                            break;
                    }
                } else {
                    str = "storage/unauthenticated";
                    message = "User is unauthenticated. Authenticate and try again.";
                }
                str2 = message;
            }
        } finally {
            promise.reject(str, message, (Throwable) exc);
        }
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put(DocumentDirectoryPath, getReactApplicationContext().getFilesDir().getAbsolutePath());
        hashMap.put(TemporaryDirectoryPath, getReactApplicationContext().getCacheDir().getAbsolutePath());
        hashMap.put(PicturesDirectoryPath, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        hashMap.put(CachesDirectoryPath, getReactApplicationContext().getCacheDir().getAbsolutePath());
        hashMap.put(FileTypeRegular, 0);
        hashMap.put(FileTypeDirectory, 1);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            hashMap.put(ExternalStorageDirectoryPath, externalStorageDirectory.getAbsolutePath());
        } else {
            hashMap.put(ExternalStorageDirectoryPath, (Object) null);
        }
        File externalFilesDir = getReactApplicationContext().getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            hashMap.put(ExternalDirectoryPath, externalFilesDir.getAbsolutePath());
        } else {
            hashMap.put(ExternalDirectoryPath, (Object) null);
        }
        return hashMap;
    }
}

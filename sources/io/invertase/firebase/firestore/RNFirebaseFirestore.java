package io.invertase.firebase.firestore;

import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseArray;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Transaction;
import com.google.firebase.firestore.WriteBatch;
import com.stripe.android.model.PaymentMethodOptionsParams;
import io.invertase.firebase.ErrorUtils;
import io.invertase.firebase.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;

public class RNFirebaseFirestore extends ReactContextBaseJavaModule {
    private static final String TAG = "RNFirebaseFirestore";
    private SparseArray<RNFirebaseFirestoreTransactionHandler> transactionHandlers = new SparseArray<>();

    public String getName() {
        return TAG;
    }

    RNFirebaseFirestore(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    static void promiseRejectException(Promise promise, FirebaseFirestoreException firebaseFirestoreException) {
        WritableMap jSError = getJSError(firebaseFirestoreException);
        promise.reject(jSError.getString(PaymentMethodOptionsParams.Blik.PARAM_CODE), jSError.getString(GraphQLConstants.Keys.MESSAGE), (Throwable) firebaseFirestoreException);
    }

    static FirebaseFirestore getFirestoreForApp(String str) {
        return FirebaseFirestore.getInstance(FirebaseApp.getInstance(str));
    }

    static WritableMap getJSError(FirebaseFirestoreException firebaseFirestoreException) {
        String str;
        String str2;
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("nativeErrorCode", firebaseFirestoreException.getCode().value());
        createMap.putString("nativeErrorMessage", firebaseFirestoreException.getMessage());
        switch (AnonymousClass5.$SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[firebaseFirestoreException.getCode().ordinal()]) {
            case 1:
                str = ErrorUtils.getCodeWithService("Firestore", "ok");
                str2 = ErrorUtils.getMessageWithService("Ok.", "Firestore", str);
                break;
            case 2:
                str = ErrorUtils.getCodeWithService("Firestore", "cancelled");
                str2 = ErrorUtils.getMessageWithService("The operation was cancelled.", "Firestore", str);
                break;
            case 3:
                str = ErrorUtils.getCodeWithService("Firestore", "unknown");
                str2 = ErrorUtils.getMessageWithService("Unknown error or an error from a different error domain.", "Firestore", str);
                break;
            case 4:
                str = ErrorUtils.getCodeWithService("Firestore", "invalid-argument");
                str2 = ErrorUtils.getMessageWithService("Client specified an invalid argument.", "Firestore", str);
                break;
            case 5:
                str = ErrorUtils.getCodeWithService("Firestore", "deadline-exceeded");
                str2 = ErrorUtils.getMessageWithService("Deadline expired before operation could complete.", "Firestore", str);
                break;
            case 6:
                str = ErrorUtils.getCodeWithService("Firestore", "not-found");
                str2 = ErrorUtils.getMessageWithService("Some requested document was not found.", "Firestore", str);
                break;
            case 7:
                str = ErrorUtils.getCodeWithService("Firestore", "already-exists");
                str2 = ErrorUtils.getMessageWithService("Some document that we attempted to create already exists.", "Firestore", str);
                break;
            case 8:
                str = ErrorUtils.getCodeWithService("Firestore", "permission-denied");
                str2 = ErrorUtils.getMessageWithService("The caller does not have permission to execute the specified operation.", "Firestore", str);
                break;
            case 9:
                str = ErrorUtils.getCodeWithService("Firestore", "resource-exhausted");
                str2 = ErrorUtils.getMessageWithService("Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space.", "Firestore", str);
                break;
            case 10:
                str = ErrorUtils.getCodeWithService("Firestore", "failed-precondition");
                str2 = ErrorUtils.getMessageWithService("Operation was rejected because the system is not in a state required for the operation`s execution.", "Firestore", str);
                break;
            case 11:
                str = ErrorUtils.getCodeWithService("Firestore", "aborted");
                str2 = ErrorUtils.getMessageWithService("The operation was aborted, typically due to a concurrency issue like transaction aborts, etc.", "Firestore", str);
                break;
            case 12:
                str = ErrorUtils.getCodeWithService("Firestore", "out-of-range");
                str2 = ErrorUtils.getMessageWithService("Operation was attempted past the valid range.", "Firestore", str);
                break;
            case 13:
                str = ErrorUtils.getCodeWithService("Firestore", "unimplemented");
                str2 = ErrorUtils.getMessageWithService("Operation is not implemented or not supported/enabled.", "Firestore", str);
                break;
            case 14:
                str = ErrorUtils.getCodeWithService("Firestore", "internal");
                str2 = ErrorUtils.getMessageWithService("Internal errors.", "Firestore", str);
                break;
            case 15:
                str = ErrorUtils.getCodeWithService("Firestore", "unavailable");
                str2 = ErrorUtils.getMessageWithService("The service is currently unavailable.", "Firestore", str);
                break;
            case 16:
                str = ErrorUtils.getCodeWithService("Firestore", "data-loss");
                str2 = ErrorUtils.getMessageWithService("Unrecoverable data loss or corruption.", "Firestore", str);
                break;
            case 17:
                str = ErrorUtils.getCodeWithService("Firestore", "unauthenticated");
                str2 = ErrorUtils.getMessageWithService("The request does not have valid authentication credentials for the operation.", "Firestore", str);
                break;
            default:
                str = ErrorUtils.getCodeWithService("Firestore", "unknown");
                str2 = ErrorUtils.getMessageWithService(GraphQLConstants.ErrorMessages.UNKNOWN, "Firestore", str);
                break;
        }
        createMap.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, str);
        createMap.putString(GraphQLConstants.Keys.MESSAGE, str2);
        return createMap;
    }

    /* renamed from: io.invertase.firebase.firestore.RNFirebaseFirestore$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.firebase.firestore.FirebaseFirestoreException$Code[] r0 = com.google.firebase.firestore.FirebaseFirestoreException.Code.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code = r0
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.OK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.CANCELLED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.INVALID_ARGUMENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.DEADLINE_EXCEEDED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.ALREADY_EXISTS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.PERMISSION_DENIED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.RESOURCE_EXHAUSTED     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.FAILED_PRECONDITION     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.ABORTED     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.OUT_OF_RANGE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.UNIMPLEMENTED     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.INTERNAL     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.DATA_LOSS     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.firebase.firestore.FirebaseFirestoreException$Code r1 = com.google.firebase.firestore.FirebaseFirestoreException.Code.UNAUTHENTICATED     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.firestore.RNFirebaseFirestore.AnonymousClass5.<clinit>():void");
        }
    }

    @ReactMethod
    public void disableNetwork(String str, final Promise promise) {
        getFirestoreForApp(str).disableNetwork().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseFirestore.TAG, "disableNetwork:onComplete:success");
                    promise.resolve((Object) null);
                    return;
                }
                Log.e(RNFirebaseFirestore.TAG, "disableNetwork:onComplete:failure", task.getException());
                RNFirebaseFirestore.promiseRejectException(promise, task.getException());
            }
        });
    }

    @ReactMethod
    public void setLogLevel(String str) {
        if ("debug".equals(str) || ReactVideoView.EVENT_PROP_ERROR.equals(str)) {
            FirebaseFirestore.setLoggingEnabled(true);
        } else {
            FirebaseFirestore.setLoggingEnabled(false);
        }
    }

    @ReactMethod
    public void enableNetwork(String str, final Promise promise) {
        getFirestoreForApp(str).enableNetwork().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseFirestore.TAG, "enableNetwork:onComplete:success");
                    promise.resolve((Object) null);
                    return;
                }
                Log.e(RNFirebaseFirestore.TAG, "enableNetwork:onComplete:failure", task.getException());
                RNFirebaseFirestore.promiseRejectException(promise, task.getException());
            }
        });
    }

    @ReactMethod
    public void collectionGet(String str, String str2, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        getCollectionForAppPath(str, str2, readableArray, readableArray2, readableMap).get(readableMap2, promise);
    }

    @ReactMethod
    public void collectionOffSnapshot(String str, String str2, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, String str3) {
        RNFirebaseFirestoreCollectionReference.offSnapshot(str3);
    }

    @ReactMethod
    public void collectionOnSnapshot(String str, String str2, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, String str3, ReadableMap readableMap2) {
        getCollectionForAppPath(str, str2, readableArray, readableArray2, readableMap).onSnapshot(str3, readableMap2);
    }

    @ReactMethod
    public void documentBatch(String str, ReadableArray readableArray, final Promise promise) {
        FirebaseFirestore firestoreForApp = getFirestoreForApp(str);
        WriteBatch batch = firestoreForApp.batch();
        Iterator<Object> it = FirestoreSerialize.parseDocumentBatches(firestoreForApp, readableArray).iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            String str2 = (String) map.get("type");
            Map map2 = (Map) map.get("data");
            DocumentReference document = firestoreForApp.document((String) map.get(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH));
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1785516855:
                    if (str2.equals("UPDATE")) {
                        c = 0;
                        break;
                    }
                    break;
                case 81986:
                    if (str2.equals("SET")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2012838315:
                    if (str2.equals("DELETE")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    batch = batch.update(document, map2);
                    break;
                case 1:
                    Map map3 = (Map) map.get("options");
                    if (map3 != null && map3.containsKey("merge") && ((Boolean) map3.get("merge")).booleanValue()) {
                        batch = batch.set(document, map2, SetOptions.merge());
                        break;
                    } else {
                        batch = batch.set(document, map2);
                        break;
                    }
                case 2:
                    batch = batch.delete(document);
                    break;
            }
        }
        batch.commit().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseFirestore.TAG, "documentBatch:onComplete:success");
                    promise.resolve((Object) null);
                    return;
                }
                Log.e(RNFirebaseFirestore.TAG, "documentBatch:onComplete:failure", task.getException());
                RNFirebaseFirestore.promiseRejectException(promise, task.getException());
            }
        });
    }

    @ReactMethod
    public void documentDelete(String str, String str2, Promise promise) {
        getDocumentForAppPath(str, str2).delete(promise);
    }

    @ReactMethod
    public void documentGet(String str, String str2, ReadableMap readableMap, Promise promise) {
        getDocumentForAppPath(str, str2).get(readableMap, promise);
    }

    @ReactMethod
    public void documentOffSnapshot(String str, String str2, String str3) {
        RNFirebaseFirestoreDocumentReference.offSnapshot(str3);
    }

    @ReactMethod
    public void documentOnSnapshot(String str, String str2, String str3, ReadableMap readableMap) {
        getDocumentForAppPath(str, str2).onSnapshot(str3, readableMap);
    }

    @ReactMethod
    public void documentSet(String str, String str2, ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        getDocumentForAppPath(str, str2).set(readableMap, readableMap2, promise);
    }

    @ReactMethod
    public void documentUpdate(String str, String str2, ReadableMap readableMap, Promise promise) {
        getDocumentForAppPath(str, str2).update(readableMap, promise);
    }

    @ReactMethod
    public void settings(String str, ReadableMap readableMap, Promise promise) {
        FirebaseFirestore firestoreForApp = getFirestoreForApp(str);
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder();
        if (readableMap.hasKey("host")) {
            builder.setHost(readableMap.getString("host"));
        } else {
            builder.setHost(firestoreForApp.getFirestoreSettings().getHost());
        }
        if (readableMap.hasKey("persistence")) {
            builder.setPersistenceEnabled(readableMap.getBoolean("persistence"));
        } else {
            builder.setPersistenceEnabled(firestoreForApp.getFirestoreSettings().isPersistenceEnabled());
        }
        if (readableMap.hasKey("cacheSizeBytes")) {
            int i = readableMap.getInt("cacheSizeBytes");
            if (i == -1) {
                builder.setCacheSizeBytes(-1);
            } else {
                builder.setCacheSizeBytes((long) i);
            }
        } else {
            builder.setCacheSizeBytes(firestoreForApp.getFirestoreSettings().getCacheSizeBytes());
        }
        if (readableMap.hasKey("ssl")) {
            builder.setSslEnabled(readableMap.getBoolean("ssl"));
        } else {
            builder.setSslEnabled(firestoreForApp.getFirestoreSettings().isSslEnabled());
        }
        if (readableMap.hasKey("timestampsInSnapshots")) {
            builder.setTimestampsInSnapshotsEnabled(readableMap.getBoolean("timestampsInSnapshots"));
        }
        firestoreForApp.setFirestoreSettings(builder.build());
        promise.resolve((Object) null);
    }

    public void onCatalystInstanceDestroy() {
        int size = this.transactionHandlers.size();
        for (int i = 0; i < size; i++) {
            RNFirebaseFirestoreTransactionHandler rNFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(i);
            if (rNFirebaseFirestoreTransactionHandler != null) {
                rNFirebaseFirestoreTransactionHandler.abort();
            }
        }
        this.transactionHandlers.clear();
    }

    @ReactMethod
    public void transactionGetDocument(String str, int i, String str2, Promise promise) {
        RNFirebaseFirestoreTransactionHandler rNFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(i);
        if (rNFirebaseFirestoreTransactionHandler == null) {
            promise.reject("internal-error", "An internal error occurred whilst attempting to find a native transaction by id.");
        } else {
            rNFirebaseFirestoreTransactionHandler.getDocument(getDocumentForAppPath(str, str2).getRef(), promise);
        }
    }

    @ReactMethod
    public void transactionDispose(String str, int i) {
        RNFirebaseFirestoreTransactionHandler rNFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(i);
        if (rNFirebaseFirestoreTransactionHandler != null) {
            rNFirebaseFirestoreTransactionHandler.abort();
            this.transactionHandlers.delete(i);
        }
    }

    @ReactMethod
    public void transactionApplyBuffer(String str, int i, ReadableArray readableArray) {
        RNFirebaseFirestoreTransactionHandler rNFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(i);
        if (rNFirebaseFirestoreTransactionHandler != null) {
            rNFirebaseFirestoreTransactionHandler.signalBufferReceived(readableArray);
        }
    }

    @ReactMethod
    public void transactionBegin(final String str, int i) {
        final RNFirebaseFirestoreTransactionHandler rNFirebaseFirestoreTransactionHandler = new RNFirebaseFirestoreTransactionHandler(str, i);
        this.transactionHandlers.put(i, rNFirebaseFirestoreTransactionHandler);
        AsyncTask.execute(new Runnable() {
            public void run() {
                RNFirebaseFirestore.getFirestoreForApp(str).runTransaction(new Transaction.Function<Void>() {
                    public Void apply(@Nonnull Transaction transaction) throws FirebaseFirestoreException {
                        rNFirebaseFirestoreTransactionHandler.resetState(transaction);
                        AsyncTask.execute(new Runnable() {
                            public void run() {
                                Utils.sendEvent(RNFirebaseFirestore.this.getReactApplicationContext(), "firestore_transaction_event", rNFirebaseFirestoreTransactionHandler.createEventMap((FirebaseFirestoreException) null, "update"));
                            }
                        });
                        rNFirebaseFirestoreTransactionHandler.await();
                        if (rNFirebaseFirestoreTransactionHandler.aborted) {
                            throw new FirebaseFirestoreException("abort", FirebaseFirestoreException.Code.ABORTED);
                        } else if (!rNFirebaseFirestoreTransactionHandler.timeout) {
                            ReadableArray commandBuffer = rNFirebaseFirestoreTransactionHandler.getCommandBuffer();
                            if (commandBuffer == null) {
                                return null;
                            }
                            int size = commandBuffer.size();
                            for (int i = 0; i < size; i++) {
                                ReadableMap map = commandBuffer.getMap(i);
                                String string = map.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
                                String string2 = map.getString("type");
                                RNFirebaseFirestoreDocumentReference access$300 = RNFirebaseFirestore.this.getDocumentForAppPath(str, string);
                                string2.hashCode();
                                char c = 65535;
                                switch (string2.hashCode()) {
                                    case -1335458389:
                                        if (string2.equals("delete")) {
                                            c = 0;
                                            break;
                                        }
                                        break;
                                    case -838846263:
                                        if (string2.equals("update")) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                    case 113762:
                                        if (string2.equals("set")) {
                                            c = 2;
                                            break;
                                        }
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                        transaction.delete(access$300.getRef());
                                        break;
                                    case 1:
                                        transaction.update(access$300.getRef(), FirestoreSerialize.parseReadableMap(RNFirebaseFirestore.getFirestoreForApp(str), map.getMap("data")));
                                        break;
                                    case 2:
                                        ReadableMap map2 = map.getMap("data");
                                        ReadableMap map3 = map.getMap("options");
                                        Map<String, Object> parseReadableMap = FirestoreSerialize.parseReadableMap(RNFirebaseFirestore.getFirestoreForApp(str), map2);
                                        if (map3 != null && map3.hasKey("merge") && map3.getBoolean("merge")) {
                                            transaction.set(access$300.getRef(), parseReadableMap, SetOptions.merge());
                                            break;
                                        } else {
                                            transaction.set(access$300.getRef(), parseReadableMap);
                                            break;
                                        }
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Unknown command type at index " + i + ".");
                                }
                            }
                            return null;
                        } else {
                            throw new FirebaseFirestoreException("timeout", FirebaseFirestoreException.Code.DEADLINE_EXCEEDED);
                        }
                    }
                }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    public void onSuccess(Void voidR) {
                        if (!rNFirebaseFirestoreTransactionHandler.aborted) {
                            Log.d(RNFirebaseFirestore.TAG, "Transaction onSuccess!");
                            Utils.sendEvent(RNFirebaseFirestore.this.getReactApplicationContext(), "firestore_transaction_event", rNFirebaseFirestoreTransactionHandler.createEventMap((FirebaseFirestoreException) null, "complete"));
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    public void onFailure(@Nonnull Exception exc) {
                        if (!rNFirebaseFirestoreTransactionHandler.aborted) {
                            Log.w(RNFirebaseFirestore.TAG, "Transaction onFailure.", exc);
                            Utils.sendEvent(RNFirebaseFirestore.this.getReactApplicationContext(), "firestore_transaction_event", rNFirebaseFirestoreTransactionHandler.createEventMap((FirebaseFirestoreException) exc, ReactVideoView.EVENT_PROP_ERROR));
                        }
                    }
                });
            }
        });
    }

    private RNFirebaseFirestoreCollectionReference getCollectionForAppPath(String str, String str2, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap) {
        return new RNFirebaseFirestoreCollectionReference(getReactApplicationContext(), str, str2, readableArray, readableArray2, readableMap);
    }

    /* access modifiers changed from: private */
    public RNFirebaseFirestoreDocumentReference getDocumentForAppPath(String str, String str2) {
        return new RNFirebaseFirestoreDocumentReference(getReactApplicationContext(), str, str2);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("deleteFieldValue", FieldValue.delete().toString());
        hashMap.put("serverTimestampFieldValue", FieldValue.serverTimestamp().toString());
        return hashMap;
    }
}

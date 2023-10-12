package io.invertase.firebase.firestore;

import android.util.Log;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Source;
import io.invertase.firebase.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

public class RNFirebaseFirestoreDocumentReference {
    private static final String TAG = "RNFBFSDocumentReference";
    /* access modifiers changed from: private */
    public static Map<String, ListenerRegistration> documentSnapshotListeners = new HashMap();
    /* access modifiers changed from: private */
    public final String appName;
    /* access modifiers changed from: private */
    public final String path;
    /* access modifiers changed from: private */
    public ReactContext reactContext;
    private final DocumentReference ref;

    RNFirebaseFirestoreDocumentReference(ReactContext reactContext2, String str, String str2) {
        this.path = str2;
        this.appName = str;
        this.reactContext = reactContext2;
        this.ref = RNFirebaseFirestore.getFirestoreForApp(str).document(str2);
    }

    static void offSnapshot(String str) {
        ListenerRegistration remove = documentSnapshotListeners.remove(str);
        if (remove != null) {
            remove.remove();
        }
    }

    /* access modifiers changed from: package-private */
    public void delete(final Promise promise) {
        this.ref.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseFirestoreDocumentReference.TAG, "delete:onComplete:success");
                    promise.resolve((Object) null);
                    return;
                }
                Log.e(RNFirebaseFirestoreDocumentReference.TAG, "delete:onComplete:failure", task.getException());
                RNFirebaseFirestore.promiseRejectException(promise, task.getException());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void get(ReadableMap readableMap, final Promise promise) {
        Source source;
        if (readableMap == null || !readableMap.hasKey("source")) {
            source = Source.DEFAULT;
        } else {
            String string = readableMap.getString("source");
            if ("server".equals(string)) {
                source = Source.SERVER;
            } else if ("cache".equals(string)) {
                source = Source.CACHE;
            } else {
                source = Source.DEFAULT;
            }
        }
        final AnonymousClass2 r0 = new DocumentSnapshotSerializeAsyncTask(this.reactContext, this) {
            /* access modifiers changed from: protected */
            public void onPostExecute(WritableMap writableMap) {
                promise.resolve(writableMap);
            }
        };
        this.ref.get(source).addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            public void onComplete(@Nonnull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseFirestoreDocumentReference.TAG, "get:onComplete:success");
                    r0.execute(new Object[]{task.getResult()});
                    return;
                }
                Log.e(RNFirebaseFirestoreDocumentReference.TAG, "get:onComplete:failure", task.getException());
                RNFirebaseFirestore.promiseRejectException(promise, task.getException());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onSnapshot(final String str, ReadableMap readableMap) {
        MetadataChanges metadataChanges;
        if (!documentSnapshotListeners.containsKey(str)) {
            AnonymousClass4 r0 = new EventListener<DocumentSnapshot>() {
                public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
                    if (firebaseFirestoreException == null) {
                        RNFirebaseFirestoreDocumentReference.this.handleDocumentSnapshotEvent(str, documentSnapshot);
                        return;
                    }
                    ListenerRegistration listenerRegistration = (ListenerRegistration) RNFirebaseFirestoreDocumentReference.documentSnapshotListeners.remove(str);
                    if (listenerRegistration != null) {
                        listenerRegistration.remove();
                    }
                    RNFirebaseFirestoreDocumentReference.this.handleDocumentSnapshotError(str, firebaseFirestoreException);
                }
            };
            if (readableMap == null || !readableMap.hasKey("includeMetadataChanges") || !readableMap.getBoolean("includeMetadataChanges")) {
                metadataChanges = MetadataChanges.EXCLUDE;
            } else {
                metadataChanges = MetadataChanges.INCLUDE;
            }
            documentSnapshotListeners.put(str, this.ref.addSnapshotListener(metadataChanges, r0));
        }
    }

    public void set(ReadableMap readableMap, ReadableMap readableMap2, final Promise promise) {
        Task task;
        Map<String, Object> parseReadableMap = FirestoreSerialize.parseReadableMap(RNFirebaseFirestore.getFirestoreForApp(this.appName), readableMap);
        if (readableMap2 == null || !readableMap2.hasKey("merge") || !readableMap2.getBoolean("merge")) {
            task = this.ref.set(parseReadableMap);
        } else {
            task = this.ref.set(parseReadableMap, SetOptions.merge());
        }
        task.addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseFirestoreDocumentReference.TAG, "set:onComplete:success");
                    promise.resolve((Object) null);
                    return;
                }
                Log.e(RNFirebaseFirestoreDocumentReference.TAG, "set:onComplete:failure", task.getException());
                RNFirebaseFirestore.promiseRejectException(promise, task.getException());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void update(ReadableMap readableMap, final Promise promise) {
        this.ref.update(FirestoreSerialize.parseReadableMap(RNFirebaseFirestore.getFirestoreForApp(this.appName), readableMap)).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseFirestoreDocumentReference.TAG, "update:onComplete:success");
                    promise.resolve((Object) null);
                    return;
                }
                Log.e(RNFirebaseFirestoreDocumentReference.TAG, "update:onComplete:failure", task.getException());
                RNFirebaseFirestore.promiseRejectException(promise, task.getException());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public DocumentReference getRef() {
        return this.ref;
    }

    /* access modifiers changed from: package-private */
    public boolean hasListeners() {
        return !documentSnapshotListeners.isEmpty();
    }

    /* access modifiers changed from: private */
    public void handleDocumentSnapshotEvent(final String str, DocumentSnapshot documentSnapshot) {
        new DocumentSnapshotSerializeAsyncTask(this.reactContext, this) {
            /* access modifiers changed from: protected */
            public void onPostExecute(WritableMap writableMap) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, RNFirebaseFirestoreDocumentReference.this.path);
                createMap.putString("appName", RNFirebaseFirestoreDocumentReference.this.appName);
                createMap.putString("listenerId", str);
                createMap.putMap("documentSnapshot", writableMap);
                Utils.sendEvent(RNFirebaseFirestoreDocumentReference.this.reactContext, "firestore_document_sync_event", createMap);
            }
        }.execute(new Object[]{documentSnapshot});
    }

    /* access modifiers changed from: private */
    public void handleDocumentSnapshotError(String str, FirebaseFirestoreException firebaseFirestoreException) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, this.path);
        createMap.putString("appName", this.appName);
        createMap.putString("listenerId", str);
        createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, RNFirebaseFirestore.getJSError(firebaseFirestoreException));
        Utils.sendEvent(this.reactContext, "firestore_document_sync_event", createMap);
    }
}

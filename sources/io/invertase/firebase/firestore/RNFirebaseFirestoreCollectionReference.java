package io.invertase.firebase.firestore;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import io.invertase.firebase.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

class RNFirebaseFirestoreCollectionReference {
    private static final String TAG = "RNFSCollectionReference";
    /* access modifiers changed from: private */
    public static Map<String, ListenerRegistration> collectionSnapshotListeners = new HashMap();
    /* access modifiers changed from: private */
    public final String appName;
    private final ReadableArray filters;
    private final ReadableMap options;
    private final ReadableArray orders;
    /* access modifiers changed from: private */
    public final String path;
    private final Query query = buildQuery();
    /* access modifiers changed from: private */
    public ReactContext reactContext;

    RNFirebaseFirestoreCollectionReference(ReactContext reactContext2, String str, String str2, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap) {
        this.appName = str;
        this.path = str2;
        this.filters = readableArray;
        this.orders = readableArray2;
        this.options = readableMap;
        this.reactContext = reactContext2;
    }

    static void offSnapshot(String str) {
        ListenerRegistration remove = collectionSnapshotListeners.remove(str);
        if (remove != null) {
            remove.remove();
        }
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
        final AnonymousClass1 r0 = new QuerySnapshotSerializeAsyncTask(this.reactContext, this) {
            /* access modifiers changed from: protected */
            public void onPostExecute(WritableMap writableMap) {
                promise.resolve(writableMap);
            }
        };
        this.query.get(source).addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            public void onComplete(@Nonnull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseFirestoreCollectionReference.TAG, "get:onComplete:success");
                    r0.execute(new Object[]{task.getResult()});
                    return;
                }
                Log.e(RNFirebaseFirestoreCollectionReference.TAG, "get:onComplete:failure", task.getException());
                RNFirebaseFirestore.promiseRejectException(promise, task.getException());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onSnapshot(final String str, ReadableMap readableMap) {
        MetadataChanges metadataChanges;
        if (!collectionSnapshotListeners.containsKey(str)) {
            AnonymousClass3 r0 = new EventListener<QuerySnapshot>() {
                public void onEvent(QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
                    if (firebaseFirestoreException == null) {
                        RNFirebaseFirestoreCollectionReference.this.handleQuerySnapshotEvent(str, querySnapshot);
                        return;
                    }
                    ListenerRegistration listenerRegistration = (ListenerRegistration) RNFirebaseFirestoreCollectionReference.collectionSnapshotListeners.remove(str);
                    if (listenerRegistration != null) {
                        listenerRegistration.remove();
                    }
                    RNFirebaseFirestoreCollectionReference.this.handleQuerySnapshotError(str, firebaseFirestoreException);
                }
            };
            if (readableMap == null || !readableMap.hasKey("includeMetadataChanges") || !readableMap.getBoolean("includeMetadataChanges")) {
                metadataChanges = MetadataChanges.EXCLUDE;
            } else {
                metadataChanges = MetadataChanges.INCLUDE;
            }
            collectionSnapshotListeners.put(str, this.query.addSnapshotListener(metadataChanges, r0));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasListeners() {
        return !collectionSnapshotListeners.isEmpty();
    }

    private Query buildQuery() {
        FirebaseFirestore firestoreForApp = RNFirebaseFirestore.getFirestoreForApp(this.appName);
        return applyOptions(firestoreForApp, applyOrders(applyFilters(firestoreForApp, firestoreForApp.collection(this.path))));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.firebase.firestore.Query applyFilters(com.google.firebase.firestore.FirebaseFirestore r20, com.google.firebase.firestore.Query r21) {
        /*
            r19 = this;
            r0 = r19
            r2 = r21
            r3 = 0
        L_0x0005:
            com.facebook.react.bridge.ReadableArray r4 = r0.filters
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x0141
            com.facebook.react.bridge.ReadableArray r4 = r0.filters
            com.facebook.react.bridge.ReadableMap r4 = r4.getMap(r3)
            java.lang.String r5 = "fieldPath"
            com.facebook.react.bridge.ReadableMap r5 = r4.getMap(r5)
            java.lang.String r6 = "type"
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r7 = "operator"
            java.lang.String r7 = r4.getString(r7)
            java.lang.String r8 = "value"
            com.facebook.react.bridge.ReadableMap r4 = r4.getMap(r8)
            r8 = r20
            java.lang.Object r4 = io.invertase.firebase.firestore.FirestoreSerialize.parseTypeMap(r8, r4)
            java.lang.String r9 = "string"
            boolean r6 = r6.equals(r9)
            java.lang.String r11 = "GREATER_THAN_OR_EQUAL"
            java.lang.String r13 = "GREATER_THAN"
            java.lang.String r15 = "ARRAY_CONTAINS"
            r16 = 2
            java.lang.String r1 = "EQUAL"
            java.lang.String r10 = "LESS_THAN"
            java.lang.String r12 = "LESS_THAN_OR_EQUAL"
            r17 = -1
            r18 = 1
            if (r6 == 0) goto L_0x00b9
            java.lang.String r5 = r5.getString(r9)
            r7.hashCode()
            int r6 = r7.hashCode()
            switch(r6) {
                case -2081783184: goto L_0x0088;
                case -1112834937: goto L_0x007f;
                case 66219796: goto L_0x0076;
                case 67210597: goto L_0x006d;
                case 972152550: goto L_0x0064;
                case 989027057: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            r10 = -1
            goto L_0x0090
        L_0x005b:
            boolean r1 = r7.equals(r11)
            if (r1 != 0) goto L_0x0062
            goto L_0x0059
        L_0x0062:
            r10 = 5
            goto L_0x0090
        L_0x0064:
            boolean r1 = r7.equals(r13)
            if (r1 != 0) goto L_0x006b
            goto L_0x0059
        L_0x006b:
            r10 = 4
            goto L_0x0090
        L_0x006d:
            boolean r1 = r7.equals(r15)
            if (r1 != 0) goto L_0x0074
            goto L_0x0059
        L_0x0074:
            r10 = 3
            goto L_0x0090
        L_0x0076:
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L_0x007d
            goto L_0x0059
        L_0x007d:
            r10 = 2
            goto L_0x0090
        L_0x007f:
            boolean r1 = r7.equals(r10)
            if (r1 != 0) goto L_0x0086
            goto L_0x0059
        L_0x0086:
            r10 = 1
            goto L_0x0090
        L_0x0088:
            boolean r1 = r7.equals(r12)
            if (r1 != 0) goto L_0x008f
            goto L_0x0059
        L_0x008f:
            r10 = 0
        L_0x0090:
            switch(r10) {
                case 0: goto L_0x00b3;
                case 1: goto L_0x00ad;
                case 2: goto L_0x00a7;
                case 3: goto L_0x00a1;
                case 4: goto L_0x009b;
                case 5: goto L_0x0095;
                default: goto L_0x0093;
            }
        L_0x0093:
            goto L_0x013d
        L_0x0095:
            com.google.firebase.firestore.Query r2 = r2.whereGreaterThanOrEqualTo(r5, r4)
            goto L_0x013d
        L_0x009b:
            com.google.firebase.firestore.Query r2 = r2.whereGreaterThan(r5, r4)
            goto L_0x013d
        L_0x00a1:
            com.google.firebase.firestore.Query r2 = r2.whereArrayContains(r5, r4)
            goto L_0x013d
        L_0x00a7:
            com.google.firebase.firestore.Query r2 = r2.whereEqualTo(r5, r4)
            goto L_0x013d
        L_0x00ad:
            com.google.firebase.firestore.Query r2 = r2.whereLessThan(r5, r4)
            goto L_0x013d
        L_0x00b3:
            com.google.firebase.firestore.Query r2 = r2.whereLessThanOrEqualTo(r5, r4)
            goto L_0x013d
        L_0x00b9:
            java.lang.String r6 = "elements"
            com.facebook.react.bridge.ReadableArray r5 = r5.getArray(r6)
            int r6 = r5.size()
            java.lang.String[] r6 = new java.lang.String[r6]
            r9 = 0
        L_0x00c6:
            int r14 = r5.size()
            if (r9 >= r14) goto L_0x00d5
            java.lang.String r14 = r5.getString(r9)
            r6[r9] = r14
            int r9 = r9 + 1
            goto L_0x00c6
        L_0x00d5:
            com.google.firebase.firestore.FieldPath r5 = com.google.firebase.firestore.FieldPath.of(r6)
            r7.hashCode()
            int r6 = r7.hashCode()
            switch(r6) {
                case -2081783184: goto L_0x0112;
                case -1112834937: goto L_0x0109;
                case 66219796: goto L_0x0100;
                case 67210597: goto L_0x00f7;
                case 972152550: goto L_0x00ee;
                case 989027057: goto L_0x00e5;
                default: goto L_0x00e3;
            }
        L_0x00e3:
            r10 = -1
            goto L_0x011a
        L_0x00e5:
            boolean r1 = r7.equals(r11)
            if (r1 != 0) goto L_0x00ec
            goto L_0x00e3
        L_0x00ec:
            r10 = 5
            goto L_0x011a
        L_0x00ee:
            boolean r1 = r7.equals(r13)
            if (r1 != 0) goto L_0x00f5
            goto L_0x00e3
        L_0x00f5:
            r10 = 4
            goto L_0x011a
        L_0x00f7:
            boolean r1 = r7.equals(r15)
            if (r1 != 0) goto L_0x00fe
            goto L_0x00e3
        L_0x00fe:
            r10 = 3
            goto L_0x011a
        L_0x0100:
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L_0x0107
            goto L_0x00e3
        L_0x0107:
            r10 = 2
            goto L_0x011a
        L_0x0109:
            boolean r1 = r7.equals(r10)
            if (r1 != 0) goto L_0x0110
            goto L_0x00e3
        L_0x0110:
            r10 = 1
            goto L_0x011a
        L_0x0112:
            boolean r1 = r7.equals(r12)
            if (r1 != 0) goto L_0x0119
            goto L_0x00e3
        L_0x0119:
            r10 = 0
        L_0x011a:
            switch(r10) {
                case 0: goto L_0x0138;
                case 1: goto L_0x0133;
                case 2: goto L_0x012d;
                case 3: goto L_0x0128;
                case 4: goto L_0x0123;
                case 5: goto L_0x011e;
                default: goto L_0x011d;
            }
        L_0x011d:
            goto L_0x013d
        L_0x011e:
            com.google.firebase.firestore.Query r1 = r2.whereGreaterThanOrEqualTo(r5, r4)
            goto L_0x0131
        L_0x0123:
            com.google.firebase.firestore.Query r1 = r2.whereGreaterThan(r5, r4)
            goto L_0x0131
        L_0x0128:
            com.google.firebase.firestore.Query r1 = r2.whereArrayContains(r5, r4)
            goto L_0x0131
        L_0x012d:
            com.google.firebase.firestore.Query r1 = r2.whereEqualTo(r5, r4)
        L_0x0131:
            r2 = r1
            goto L_0x013d
        L_0x0133:
            com.google.firebase.firestore.Query r1 = r2.whereLessThan(r5, r4)
            goto L_0x0131
        L_0x0138:
            com.google.firebase.firestore.Query r1 = r2.whereLessThanOrEqualTo(r5, r4)
            goto L_0x0131
        L_0x013d:
            int r3 = r3 + 1
            goto L_0x0005
        L_0x0141:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.firestore.RNFirebaseFirestoreCollectionReference.applyFilters(com.google.firebase.firestore.FirebaseFirestore, com.google.firebase.firestore.Query):com.google.firebase.firestore.Query");
    }

    private Query applyOrders(Query query2) {
        Iterator<Object> it = Utils.recursivelyDeconstructReadableArray(this.orders).iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            String str = (String) map.get("direction");
            Map map2 = (Map) map.get("fieldPath");
            if (((String) map2.get("type")).equals(TypedValues.Custom.S_STRING)) {
                query2 = query2.orderBy((String) map2.get(TypedValues.Custom.S_STRING), Query.Direction.valueOf(str));
            } else {
                List list = (List) map2.get("elements");
                query2 = query2.orderBy(FieldPath.of((String[]) list.toArray(new String[list.size()])), Query.Direction.valueOf(str));
            }
        }
        return query2;
    }

    private Query applyOptions(FirebaseFirestore firebaseFirestore, Query query2) {
        if (this.options.hasKey("endAt")) {
            query2 = query2.endAt(FirestoreSerialize.parseReadableArray(firebaseFirestore, this.options.getArray("endAt")).toArray());
        }
        if (this.options.hasKey("endBefore")) {
            query2 = query2.endBefore(FirestoreSerialize.parseReadableArray(firebaseFirestore, this.options.getArray("endBefore")).toArray());
        }
        if (this.options.hasKey("limit")) {
            query2 = query2.limit((long) this.options.getInt("limit"));
        }
        if (this.options.hasKey("startAfter")) {
            query2 = query2.startAfter(FirestoreSerialize.parseReadableArray(firebaseFirestore, this.options.getArray("startAfter")).toArray());
        }
        return this.options.hasKey("startAt") ? query2.startAt(FirestoreSerialize.parseReadableArray(firebaseFirestore, this.options.getArray("startAt")).toArray()) : query2;
    }

    /* access modifiers changed from: private */
    public void handleQuerySnapshotEvent(final String str, QuerySnapshot querySnapshot) {
        new QuerySnapshotSerializeAsyncTask(this.reactContext, this) {
            /* access modifiers changed from: protected */
            public void onPostExecute(WritableMap writableMap) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, RNFirebaseFirestoreCollectionReference.this.path);
                createMap.putString("appName", RNFirebaseFirestoreCollectionReference.this.appName);
                createMap.putString("listenerId", str);
                createMap.putMap("querySnapshot", writableMap);
                Utils.sendEvent(RNFirebaseFirestoreCollectionReference.this.reactContext, "firestore_collection_sync_event", createMap);
            }
        }.execute(new Object[]{querySnapshot});
    }

    /* access modifiers changed from: private */
    public void handleQuerySnapshotError(String str, FirebaseFirestoreException firebaseFirestoreException) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("appName", this.appName);
        createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, this.path);
        createMap.putString("listenerId", str);
        createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, RNFirebaseFirestore.getJSError(firebaseFirestoreException));
        Utils.sendEvent(this.reactContext, "firestore_collection_sync_event", createMap);
    }
}

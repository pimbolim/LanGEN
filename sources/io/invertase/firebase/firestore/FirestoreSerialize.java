package io.invertase.firebase.firestore;

import android.util.Base64;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SnapshotMetadata;
import io.invertase.firebase.Utils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

class FirestoreSerialize {
    private static final String CHANGE_ADDED = "added";
    private static final String CHANGE_MODIFIED = "modified";
    private static final String CHANGE_REMOVED = "removed";
    private static final String KEY_CHANGES = "changes";
    private static final String KEY_DATA = "data";
    private static final String KEY_DOCUMENTS = "documents";
    private static final String KEY_DOC_CHANGE_DOCUMENT = "document";
    private static final String KEY_DOC_CHANGE_NEW_INDEX = "newIndex";
    private static final String KEY_DOC_CHANGE_OLD_INDEX = "oldIndex";
    private static final String KEY_DOC_CHANGE_TYPE = "type";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_META = "metadata";
    private static final String KEY_META_FROM_CACHE = "fromCache";
    private static final String KEY_META_HAS_PENDING_WRITES = "hasPendingWrites";
    private static final String KEY_NANOSECONDS = "nanoseconds";
    private static final String KEY_OPTIONS = "options";
    private static final String KEY_PATH = "path";
    private static final String KEY_SECONDS = "seconds";
    private static final String TAG = "FirestoreSerialize";
    private static final String TYPE = "type";
    private static final String TYPE_ARRAY = "array";
    private static final String TYPE_BLOB = "blob";
    private static final String TYPE_BOOLEAN = "boolean";
    private static final String TYPE_DATE = "date";
    private static final String TYPE_DOCUMENTID = "documentid";
    private static final String TYPE_FIELDVALUE = "fieldvalue";
    private static final String TYPE_FIELDVALUE_DELETE = "delete";
    private static final String TYPE_FIELDVALUE_ELEMENTS = "elements";
    private static final String TYPE_FIELDVALUE_INCREMENT = "increment";
    private static final String TYPE_FIELDVALUE_REMOVE = "remove";
    private static final String TYPE_FIELDVALUE_TIMESTAMP = "timestamp";
    private static final String TYPE_FIELDVALUE_TYPE = "type";
    private static final String TYPE_FIELDVALUE_UNION = "union";
    private static final String TYPE_GEOPOINT = "geopoint";
    private static final String TYPE_INFINITY = "infinity";
    private static final String TYPE_NAN = "nan";
    private static final String TYPE_NULL = "null";
    private static final String TYPE_NUMBER = "number";
    private static final String TYPE_OBJECT = "object";
    private static final String TYPE_REFERENCE = "reference";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_TIMESTAMP = "timestamp";
    private static final String VALUE = "value";

    FirestoreSerialize() {
    }

    static WritableMap snapshotToWritableMap(DocumentSnapshot documentSnapshot) {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        SnapshotMetadata metadata = documentSnapshot.getMetadata();
        createMap.putBoolean(KEY_META_FROM_CACHE, metadata.isFromCache());
        createMap.putBoolean(KEY_META_HAS_PENDING_WRITES, metadata.hasPendingWrites());
        createMap2.putMap("metadata", createMap);
        createMap2.putString("path", documentSnapshot.getReference().getPath());
        if (documentSnapshot.exists()) {
            createMap2.putMap("data", objectMapToWritable(documentSnapshot.getData()));
        }
        return createMap2;
    }

    static WritableMap snapshotToWritableMap(QuerySnapshot querySnapshot) {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        WritableArray createArray = Arguments.createArray();
        SnapshotMetadata metadata = querySnapshot.getMetadata();
        List<DocumentSnapshot> documents = querySnapshot.getDocuments();
        List documentChanges = querySnapshot.getDocumentChanges();
        for (DocumentSnapshot snapshotToWritableMap : documents) {
            createArray.pushMap(snapshotToWritableMap(snapshotToWritableMap));
        }
        createMap.putBoolean(KEY_META_FROM_CACHE, metadata.isFromCache());
        createMap.putBoolean(KEY_META_HAS_PENDING_WRITES, metadata.hasPendingWrites());
        createMap2.putMap("metadata", createMap);
        createMap2.putArray(KEY_DOCUMENTS, createArray);
        createMap2.putArray(KEY_CHANGES, documentChangesToWritableArray(documentChanges));
        return createMap2;
    }

    private static WritableArray documentChangesToWritableArray(List<DocumentChange> list) {
        WritableArray createArray = Arguments.createArray();
        for (DocumentChange documentChangeToWritableMap : list) {
            createArray.pushMap(documentChangeToWritableMap(documentChangeToWritableMap));
        }
        return createArray;
    }

    private static WritableMap documentChangeToWritableMap(DocumentChange documentChange) {
        WritableMap createMap = Arguments.createMap();
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$DocumentChange$Type[documentChange.getType().ordinal()];
        if (i == 1) {
            createMap.putString("type", CHANGE_ADDED);
        } else if (i == 2) {
            createMap.putString("type", CHANGE_MODIFIED);
        } else if (i == 3) {
            createMap.putString("type", CHANGE_REMOVED);
        }
        createMap.putMap(KEY_DOC_CHANGE_DOCUMENT, snapshotToWritableMap((DocumentSnapshot) documentChange.getDocument()));
        createMap.putInt(KEY_DOC_CHANGE_NEW_INDEX, documentChange.getNewIndex());
        createMap.putInt(KEY_DOC_CHANGE_OLD_INDEX, documentChange.getOldIndex());
        return createMap;
    }

    /* renamed from: io.invertase.firebase.firestore.FirestoreSerialize$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$DocumentChange$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.firebase.firestore.DocumentChange$Type[] r0 = com.google.firebase.firestore.DocumentChange.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type = r0
                com.google.firebase.firestore.DocumentChange$Type r1 = com.google.firebase.firestore.DocumentChange.Type.ADDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$DocumentChange$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.firestore.DocumentChange$Type r1 = com.google.firebase.firestore.DocumentChange.Type.MODIFIED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$DocumentChange$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.firestore.DocumentChange$Type r1 = com.google.firebase.firestore.DocumentChange.Type.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.firestore.FirestoreSerialize.AnonymousClass1.<clinit>():void");
        }
    }

    private static WritableMap objectMapToWritable(Map<String, Object> map) {
        WritableMap createMap = Arguments.createMap();
        for (Map.Entry next : map.entrySet()) {
            createMap.putMap((String) next.getKey(), buildTypeMap(next.getValue()));
        }
        return createMap;
    }

    private static WritableArray objectArrayToWritable(Object[] objArr) {
        WritableArray createArray = Arguments.createArray();
        for (Object buildTypeMap : objArr) {
            createArray.pushMap(buildTypeMap(buildTypeMap));
        }
        return createArray;
    }

    private static WritableMap buildTypeMap(Object obj) {
        WritableMap createMap = Arguments.createMap();
        if (obj == null) {
            createMap.putString("type", "null");
            createMap.putNull("value");
            return createMap;
        } else if (obj instanceof Boolean) {
            createMap.putString("type", "boolean");
            createMap.putBoolean("value", ((Boolean) obj).booleanValue());
            return createMap;
        } else if (obj instanceof Integer) {
            createMap.putString("type", TYPE_NUMBER);
            createMap.putDouble("value", ((Integer) obj).doubleValue());
            return createMap;
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            if (Double.isInfinite(d.doubleValue())) {
                createMap.putString("type", TYPE_INFINITY);
                return createMap;
            } else if (Double.isNaN(d.doubleValue())) {
                createMap.putString("type", TYPE_NAN);
                return createMap;
            } else {
                createMap.putString("type", TYPE_NUMBER);
                createMap.putDouble("value", d.doubleValue());
                return createMap;
            }
        } else if (obj instanceof Float) {
            createMap.putString("type", TYPE_NUMBER);
            createMap.putDouble("value", ((Float) obj).doubleValue());
            return createMap;
        } else if (obj instanceof Long) {
            createMap.putString("type", TYPE_NUMBER);
            createMap.putDouble("value", ((Long) obj).doubleValue());
            return createMap;
        } else if (obj instanceof String) {
            createMap.putString("type", "string");
            createMap.putString("value", (String) obj);
            return createMap;
        } else if (obj instanceof Date) {
            createMap.putString("type", "date");
            createMap.putDouble("value", (double) ((Date) obj).getTime());
            return createMap;
        } else if (Map.class.isAssignableFrom(obj.getClass())) {
            createMap.putString("type", TYPE_OBJECT);
            createMap.putMap("value", objectMapToWritable((Map) obj));
            return createMap;
        } else if (List.class.isAssignableFrom(obj.getClass())) {
            createMap.putString("type", TYPE_ARRAY);
            List list = (List) obj;
            createMap.putArray("value", objectArrayToWritable(list.toArray(new Object[list.size()])));
            return createMap;
        } else if (obj instanceof DocumentReference) {
            createMap.putString("type", TYPE_REFERENCE);
            createMap.putString("value", ((DocumentReference) obj).getPath());
            return createMap;
        } else if (obj instanceof Timestamp) {
            WritableMap createMap2 = Arguments.createMap();
            Timestamp timestamp = (Timestamp) obj;
            createMap2.putDouble(KEY_SECONDS, (double) timestamp.getSeconds());
            createMap2.putInt(KEY_NANOSECONDS, timestamp.getNanoseconds());
            createMap.putString("type", "timestamp");
            createMap.putMap("value", createMap2);
            return createMap;
        } else if (obj instanceof GeoPoint) {
            WritableMap createMap3 = Arguments.createMap();
            GeoPoint geoPoint = (GeoPoint) obj;
            createMap3.putDouble(KEY_LATITUDE, geoPoint.getLatitude());
            createMap3.putDouble(KEY_LONGITUDE, geoPoint.getLongitude());
            createMap.putMap("value", createMap3);
            createMap.putString("type", TYPE_GEOPOINT);
            return createMap;
        } else if (obj instanceof Blob) {
            createMap.putString("type", TYPE_BLOB);
            createMap.putString("value", Base64.encodeToString(((Blob) obj).toBytes(), 2));
            return createMap;
        } else {
            Log.w(TAG, "Unknown object of type " + obj.getClass());
            createMap.putString("type", "null");
            createMap.putNull("value");
            return createMap;
        }
    }

    static Map<String, Object> parseReadableMap(FirebaseFirestore firebaseFirestore, @Nullable ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        if (readableMap == null) {
            return hashMap;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, parseTypeMap(firebaseFirestore, readableMap.getMap(nextKey)));
        }
        return hashMap;
    }

    static List<Object> parseReadableArray(FirebaseFirestore firebaseFirestore, @Nullable ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        if (readableArray == null) {
            return arrayList;
        }
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(parseTypeMap(firebaseFirestore, readableArray.getMap(i)));
        }
        return arrayList;
    }

    static Object parseTypeMap(FirebaseFirestore firebaseFirestore, ReadableMap readableMap) {
        String string = readableMap.getString("type");
        if ("null".equals(string)) {
            return null;
        }
        if ("boolean".equals(string)) {
            return Boolean.valueOf(readableMap.getBoolean("value"));
        }
        if (TYPE_NAN.equals(string)) {
            return Double.valueOf(Double.NaN);
        }
        if (TYPE_NUMBER.equals(string)) {
            return Double.valueOf(readableMap.getDouble("value"));
        }
        if (TYPE_INFINITY.equals(string)) {
            return Double.valueOf(Double.POSITIVE_INFINITY);
        }
        if ("string".equals(string)) {
            return readableMap.getString("value");
        }
        if (TYPE_ARRAY.equals(string)) {
            return parseReadableArray(firebaseFirestore, readableMap.getArray("value"));
        }
        if (TYPE_OBJECT.equals(string)) {
            return parseReadableMap(firebaseFirestore, readableMap.getMap("value"));
        }
        if ("date".equals(string)) {
            return new Date(Double.valueOf(readableMap.getDouble("value")).longValue());
        }
        if (TYPE_DOCUMENTID.equals(string)) {
            return FieldPath.documentId();
        }
        if (TYPE_GEOPOINT.equals(string)) {
            ReadableMap map = readableMap.getMap("value");
            return new GeoPoint(map.getDouble(KEY_LATITUDE), map.getDouble(KEY_LONGITUDE));
        } else if (TYPE_BLOB.equals(string)) {
            return Blob.fromBytes(Base64.decode(readableMap.getString("value"), 2));
        } else {
            if (TYPE_REFERENCE.equals(string)) {
                return firebaseFirestore.document(readableMap.getString("value"));
            }
            if ("timestamp".equals(string)) {
                ReadableMap map2 = readableMap.getMap("value");
                return new Timestamp((long) map2.getDouble(KEY_SECONDS), map2.getInt(KEY_NANOSECONDS));
            } else if (TYPE_FIELDVALUE.equals(string)) {
                ReadableMap map3 = readableMap.getMap("value");
                String string2 = map3.getString("type");
                if ("timestamp".equals(string2)) {
                    return FieldValue.serverTimestamp();
                }
                if (TYPE_FIELDVALUE_INCREMENT.equals(string2)) {
                    return FieldValue.increment(map3.getDouble(TYPE_FIELDVALUE_ELEMENTS));
                }
                if (TYPE_FIELDVALUE_DELETE.equals(string2)) {
                    return FieldValue.delete();
                }
                if (TYPE_FIELDVALUE_UNION.equals(string2)) {
                    return FieldValue.arrayUnion(parseReadableArray(firebaseFirestore, map3.getArray(TYPE_FIELDVALUE_ELEMENTS)).toArray());
                }
                if (TYPE_FIELDVALUE_REMOVE.equals(string2)) {
                    return FieldValue.arrayRemove(parseReadableArray(firebaseFirestore, map3.getArray(TYPE_FIELDVALUE_ELEMENTS)).toArray());
                }
                Log.w(TAG, "Unknown FieldValue type: " + string2);
                return null;
            } else {
                Log.w(TAG, "Unknown object of type " + string);
                return null;
            }
        }
    }

    static List<Object> parseDocumentBatches(FirebaseFirestore firebaseFirestore, ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            HashMap hashMap = new HashMap();
            ReadableMap map = readableArray.getMap(i);
            hashMap.put("type", map.getString("type"));
            hashMap.put("path", map.getString("path"));
            if (map.hasKey("data")) {
                hashMap.put("data", parseReadableMap(firebaseFirestore, map.getMap("data")));
            }
            if (map.hasKey(KEY_OPTIONS)) {
                hashMap.put(KEY_OPTIONS, Utils.recursivelyDeconstructReadableMap(map.getMap(KEY_OPTIONS)));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }
}

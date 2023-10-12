package io.invertase.firebase.database;

import android.os.AsyncTask;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import io.invertase.firebase.Utils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class RNFirebaseDatabaseReference {
    private static final String TAG = "RNFirebaseDBReference";
    private String appName;
    private HashMap<String, ChildEventListener> childEventListeners = new HashMap<>();
    private String dbURL;
    /* access modifiers changed from: private */
    public String key;
    /* access modifiers changed from: private */
    public Query query;
    private HashMap<String, ValueEventListener> valueEventListeners = new HashMap<>();

    RNFirebaseDatabaseReference(String str, String str2, String str3, String str4, ReadableArray readableArray) {
        this.key = str3;
        this.query = null;
        this.appName = str;
        this.dbURL = str2;
        buildDatabaseQueryAtPathAndModifiers(str4, readableArray);
    }

    /* access modifiers changed from: package-private */
    public void removeAllEventListeners() {
        if (hasListeners().booleanValue()) {
            Iterator<Map.Entry<String, ValueEventListener>> it = this.valueEventListeners.entrySet().iterator();
            while (it.hasNext()) {
                this.query.removeEventListener((ValueEventListener) it.next().getValue());
                it.remove();
            }
            Iterator<Map.Entry<String, ChildEventListener>> it2 = this.childEventListeners.entrySet().iterator();
            while (it2.hasNext()) {
                this.query.removeEventListener((ChildEventListener) it2.next().getValue());
                it2.remove();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Query getQuery() {
        return this.query;
    }

    private Boolean hasEventListener(String str) {
        return Boolean.valueOf(this.valueEventListeners.containsKey(str) || this.childEventListeners.containsKey(str));
    }

    /* access modifiers changed from: package-private */
    public Boolean hasListeners() {
        return Boolean.valueOf(this.valueEventListeners.size() > 0 || this.childEventListeners.size() > 0);
    }

    /* access modifiers changed from: package-private */
    public void removeEventListener(String str) {
        if (this.valueEventListeners.containsKey(str)) {
            this.query.removeEventListener(this.valueEventListeners.get(str));
            this.valueEventListeners.remove(str);
        }
        if (this.childEventListeners.containsKey(str)) {
            this.query.removeEventListener(this.childEventListeners.get(str));
            this.childEventListeners.remove(str);
        }
    }

    private void addEventListener(String str, ValueEventListener valueEventListener) {
        this.valueEventListeners.put(str, valueEventListener);
        this.query.addValueEventListener(valueEventListener);
    }

    private void addEventListener(String str, ChildEventListener childEventListener) {
        this.childEventListeners.put(str, childEventListener);
        this.query.addChildEventListener(childEventListener);
    }

    private void addOnceValueEventListener(final Promise promise) {
        final AnonymousClass1 r0 = new DataSnapshotToMapAsyncTask(this) {
            /* access modifiers changed from: protected */
            public void onPostExecute(WritableMap writableMap) {
                if (isAvailable().booleanValue()) {
                    promise.resolve(writableMap);
                }
            }
        };
        this.query.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(@Nonnull DataSnapshot dataSnapshot) {
                r0.execute(new Object[]{dataSnapshot, null});
            }

            public void onCancelled(@Nonnull DatabaseError databaseError) {
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        });
        Log.d(TAG, "Added OnceValueEventListener for key: " + this.key);
    }

    private void addChildOnceEventListener(final String str, final Promise promise) {
        this.query.addChildEventListener(new ChildEventListener() {
            public void onChildAdded(@Nonnull DataSnapshot dataSnapshot, String str) {
                if ("child_added".equals(str)) {
                    RNFirebaseDatabaseReference.this.query.removeEventListener(this);
                    promise.resolve(RNFirebaseDatabaseUtils.snapshotToMap(dataSnapshot, str));
                }
            }

            public void onChildChanged(@Nonnull DataSnapshot dataSnapshot, String str) {
                if ("child_changed".equals(str)) {
                    RNFirebaseDatabaseReference.this.query.removeEventListener(this);
                    promise.resolve(RNFirebaseDatabaseUtils.snapshotToMap(dataSnapshot, str));
                }
            }

            public void onChildRemoved(@Nonnull DataSnapshot dataSnapshot) {
                if ("child_removed".equals(str)) {
                    RNFirebaseDatabaseReference.this.query.removeEventListener(this);
                    promise.resolve(RNFirebaseDatabaseUtils.snapshotToMap(dataSnapshot, (String) null));
                }
            }

            public void onChildMoved(@Nonnull DataSnapshot dataSnapshot, String str) {
                if ("child_moved".equals(str)) {
                    RNFirebaseDatabaseReference.this.query.removeEventListener(this);
                    promise.resolve(RNFirebaseDatabaseUtils.snapshotToMap(dataSnapshot, str));
                }
            }

            public void onCancelled(@Nonnull DatabaseError databaseError) {
                RNFirebaseDatabaseReference.this.query.removeEventListener(this);
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void on(String str, ReadableMap readableMap) {
        if (str.equals("value")) {
            addValueEventListener(readableMap);
        } else {
            addChildEventListener(readableMap, str);
        }
    }

    /* access modifiers changed from: package-private */
    public void once(String str, Promise promise) {
        if (str.equals("value")) {
            addOnceValueEventListener(promise);
        } else {
            addChildOnceEventListener(str, promise);
        }
    }

    private void addChildEventListener(final ReadableMap readableMap, final String str) {
        final String string = readableMap.getString("eventRegistrationKey");
        readableMap.getString("registrationCancellationKey");
        if (!hasEventListener(string).booleanValue()) {
            addEventListener(string, (ChildEventListener) new ChildEventListener() {
                public void onChildAdded(@Nonnull DataSnapshot dataSnapshot, String str) {
                    if ("child_added".equals(str)) {
                        RNFirebaseDatabaseReference.this.handleDatabaseEvent("child_added", readableMap, dataSnapshot, str);
                    }
                }

                public void onChildChanged(@Nonnull DataSnapshot dataSnapshot, String str) {
                    if ("child_changed".equals(str)) {
                        RNFirebaseDatabaseReference.this.handleDatabaseEvent("child_changed", readableMap, dataSnapshot, str);
                    }
                }

                public void onChildRemoved(@Nonnull DataSnapshot dataSnapshot) {
                    if ("child_removed".equals(str)) {
                        RNFirebaseDatabaseReference.this.handleDatabaseEvent("child_removed", readableMap, dataSnapshot, (String) null);
                    }
                }

                public void onChildMoved(@Nonnull DataSnapshot dataSnapshot, String str) {
                    if ("child_moved".equals(str)) {
                        RNFirebaseDatabaseReference.this.handleDatabaseEvent("child_moved", readableMap, dataSnapshot, str);
                    }
                }

                public void onCancelled(@Nonnull DatabaseError databaseError) {
                    RNFirebaseDatabaseReference.this.removeEventListener(string);
                    RNFirebaseDatabaseReference.this.handleDatabaseError(readableMap, databaseError);
                }
            });
        }
    }

    private void addValueEventListener(final ReadableMap readableMap) {
        final String string = readableMap.getString("eventRegistrationKey");
        if (!hasEventListener(string).booleanValue()) {
            addEventListener(string, (ValueEventListener) new ValueEventListener() {
                public void onDataChange(@Nonnull DataSnapshot dataSnapshot) {
                    RNFirebaseDatabaseReference.this.handleDatabaseEvent("value", readableMap, dataSnapshot, (String) null);
                }

                public void onCancelled(@Nonnull DatabaseError databaseError) {
                    RNFirebaseDatabaseReference.this.removeEventListener(string);
                    RNFirebaseDatabaseReference.this.handleDatabaseError(readableMap, databaseError);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void handleDatabaseEvent(final String str, final ReadableMap readableMap, DataSnapshot dataSnapshot, @Nullable String str2) {
        new DataSnapshotToMapAsyncTask(this) {
            /* access modifiers changed from: protected */
            public void onPostExecute(WritableMap writableMap) {
                if (isAvailable().booleanValue()) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putMap("data", writableMap);
                    createMap.putString("key", RNFirebaseDatabaseReference.this.key);
                    createMap.putString("eventType", str);
                    createMap.putMap("registration", Utils.readableMapToWritableMap(readableMap));
                    Utils.sendEvent(RNFirebaseDatabase.getReactApplicationContextInstance(), "database_sync_event", createMap);
                }
            }
        }.execute(new Object[]{dataSnapshot, str2});
    }

    /* access modifiers changed from: private */
    public void handleDatabaseError(ReadableMap readableMap, DatabaseError databaseError) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("key", this.key);
        createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, RNFirebaseDatabase.getJSError(databaseError));
        createMap.putMap("registration", Utils.readableMapToWritableMap(readableMap));
        Utils.sendEvent(RNFirebaseDatabase.getReactApplicationContextInstance(), "database_sync_event", createMap);
    }

    private void buildDatabaseQueryAtPathAndModifiers(String str, ReadableArray readableArray) {
        this.query = RNFirebaseDatabase.getDatabaseForApp(this.appName, this.dbURL).getReference(str);
        Iterator<Object> it = Utils.recursivelyDeconstructReadableArray(readableArray).iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            String str2 = (String) map.get("type");
            String str3 = (String) map.get("name");
            if ("orderBy".equals(str2)) {
                applyOrderByModifier(str3, str2, map);
            } else if ("limit".equals(str2)) {
                applyLimitModifier(str3, str2, map);
            } else if ("filter".equals(str2)) {
                applyFilterModifier(str3, map);
            }
        }
    }

    private void applyOrderByModifier(String str, String str2, Map map) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -626148087:
                if (str.equals("orderByPriority")) {
                    c = 0;
                    break;
                }
                break;
            case 729747418:
                if (str.equals("orderByKey")) {
                    c = 1;
                    break;
                }
                break;
            case 1200288727:
                if (str.equals("orderByChild")) {
                    c = 2;
                    break;
                }
                break;
            case 1217630252:
                if (str.equals("orderByValue")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.query = this.query.orderByPriority();
                return;
            case 1:
                this.query = this.query.orderByKey();
                return;
            case 2:
                this.query = this.query.orderByChild((String) map.get("key"));
                return;
            case 3:
                this.query = this.query.orderByValue();
                return;
            default:
                return;
        }
    }

    private void applyLimitModifier(String str, String str2, Map map) {
        int intValue = ((Double) map.get("limit")).intValue();
        if ("limitToLast".equals(str)) {
            this.query = this.query.limitToLast(intValue);
        } else if ("limitToFirst".equals(str)) {
            this.query = this.query.limitToFirst(intValue);
        }
    }

    private void applyFilterModifier(String str, Map map) {
        String str2 = (String) map.get("valueType");
        String str3 = (String) map.get("key");
        if ("equalTo".equals(str)) {
            applyEqualToFilter(str3, str2, map);
        } else if ("endAt".equals(str)) {
            applyEndAtFilter(str3, str2, map);
        } else if ("startAt".equals(str)) {
            applyStartAtFilter(str3, str2, map);
        }
    }

    private void applyEqualToFilter(String str, String str2, Map map) {
        if ("number".equals(str2)) {
            double doubleValue = ((Double) map.get("value")).doubleValue();
            if (str == null) {
                this.query = this.query.equalTo(doubleValue);
            } else {
                this.query = this.query.equalTo(doubleValue, str);
            }
        } else if (TypedValues.Custom.S_BOOLEAN.equals(str2)) {
            boolean booleanValue = ((Boolean) map.get("value")).booleanValue();
            if (str == null) {
                this.query = this.query.equalTo(booleanValue);
            } else {
                this.query = this.query.equalTo(booleanValue, str);
            }
        } else if (TypedValues.Custom.S_STRING.equals(str2)) {
            String str3 = (String) map.get("value");
            if (str == null) {
                this.query = this.query.equalTo(str3);
            } else {
                this.query = this.query.equalTo(str3, str);
            }
        }
    }

    private void applyEndAtFilter(String str, String str2, Map map) {
        if ("number".equals(str2)) {
            double doubleValue = ((Double) map.get("value")).doubleValue();
            if (str == null) {
                this.query = this.query.endAt(doubleValue);
            } else {
                this.query = this.query.endAt(doubleValue, str);
            }
        } else if (TypedValues.Custom.S_BOOLEAN.equals(str2)) {
            boolean booleanValue = ((Boolean) map.get("value")).booleanValue();
            if (str == null) {
                this.query = this.query.endAt(booleanValue);
            } else {
                this.query = this.query.endAt(booleanValue, str);
            }
        } else if (TypedValues.Custom.S_STRING.equals(str2)) {
            String str3 = (String) map.get("value");
            if (str == null) {
                this.query = this.query.endAt(str3);
            } else {
                this.query = this.query.endAt(str3, str);
            }
        }
    }

    private void applyStartAtFilter(String str, String str2, Map map) {
        if ("number".equals(str2)) {
            double doubleValue = ((Double) map.get("value")).doubleValue();
            if (str == null) {
                this.query = this.query.startAt(doubleValue);
            } else {
                this.query = this.query.startAt(doubleValue, str);
            }
        } else if (TypedValues.Custom.S_BOOLEAN.equals(str2)) {
            boolean booleanValue = ((Boolean) map.get("value")).booleanValue();
            if (str == null) {
                this.query = this.query.startAt(booleanValue);
            } else {
                this.query = this.query.startAt(booleanValue, str);
            }
        } else if (TypedValues.Custom.S_STRING.equals(str2)) {
            String str3 = (String) map.get("value");
            if (str == null) {
                this.query = this.query.startAt(str3);
            } else {
                this.query = this.query.startAt(str3, str);
            }
        }
    }

    private static class DataSnapshotToMapAsyncTask extends AsyncTask<Object, Void, WritableMap> {
        private WeakReference<RNFirebaseDatabaseReference> referenceWeakReference;

        /* access modifiers changed from: protected */
        public void onPostExecute(WritableMap writableMap) {
        }

        DataSnapshotToMapAsyncTask(RNFirebaseDatabaseReference rNFirebaseDatabaseReference) {
            this.referenceWeakReference = new WeakReference<>(rNFirebaseDatabaseReference);
        }

        /* access modifiers changed from: protected */
        public final WritableMap doInBackground(Object... objArr) {
            try {
                return RNFirebaseDatabaseUtils.snapshotToMap(objArr[0], objArr[1]);
            } catch (RuntimeException e) {
                if (isAvailable().booleanValue()) {
                    RNFirebaseDatabase.getReactApplicationContextInstance().handleException(e);
                }
                throw e;
            }
        }

        /* access modifiers changed from: package-private */
        public Boolean isAvailable() {
            return Boolean.valueOf((RNFirebaseDatabase.getReactApplicationContextInstance() == null || this.referenceWeakReference.get() == null) ? false : true);
        }
    }
}

package io.invertase.firebase.database;

import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.OnDisconnect;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.Transaction;
import com.stripe.android.model.PaymentMethodOptionsParams;
import io.invertase.firebase.ErrorUtils;
import io.invertase.firebase.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class RNFirebaseDatabase extends ReactContextBaseJavaModule {
    private static final String TAG = "RNFirebaseDatabase";
    private static boolean enableLogging = false;
    private static HashMap<String, Boolean> loggingLevelSet = new HashMap<>();
    private static ReactApplicationContext reactApplicationContext;
    private static HashMap<String, RNFirebaseDatabaseReference> references = new HashMap<>();
    /* access modifiers changed from: private */
    public static SparseArray<RNFirebaseTransactionHandler> transactionHandlers = new SparseArray<>();

    public String getName() {
        return TAG;
    }

    RNFirebaseDatabase(ReactApplicationContext reactApplicationContext2) {
        super(reactApplicationContext2);
    }

    static ReactApplicationContext getReactApplicationContextInstance() {
        return reactApplicationContext;
    }

    static void handlePromise(Promise promise, DatabaseError databaseError) {
        if (databaseError != null) {
            WritableMap jSError = getJSError(databaseError);
            promise.reject(jSError.getString(PaymentMethodOptionsParams.Blik.PARAM_CODE), jSError.getString(GraphQLConstants.Keys.MESSAGE), (Throwable) databaseError.toException());
            return;
        }
        promise.resolve((Object) null);
    }

    static FirebaseDatabase getDatabaseForApp(String str, String str2) {
        FirebaseDatabase firebaseDatabase;
        if (str2 == null || str2.length() <= 0) {
            firebaseDatabase = FirebaseDatabase.getInstance(FirebaseApp.getInstance(str));
        } else if (str == null || str.length() <= 0) {
            firebaseDatabase = FirebaseDatabase.getInstance(str2);
        } else {
            firebaseDatabase = FirebaseDatabase.getInstance(FirebaseApp.getInstance(str), str2);
        }
        Boolean bool = loggingLevelSet.get(firebaseDatabase.getApp().getName());
        if (enableLogging && (bool == null || !bool.booleanValue())) {
            try {
                loggingLevelSet.put(firebaseDatabase.getApp().getName(), Boolean.valueOf(enableLogging));
                firebaseDatabase.setLogLevel(Logger.Level.DEBUG);
            } catch (DatabaseException unused) {
                Log.w(TAG, "WARNING: enableLogging(bool) must be called before any other use of database(). \nIf you are sure you've done this then this message can be ignored during development as \nRN reloads can cause false positives. APP: " + firebaseDatabase.getApp().getName());
            }
        } else if (!enableLogging && bool != null && bool.booleanValue()) {
            try {
                loggingLevelSet.put(firebaseDatabase.getApp().getName(), Boolean.valueOf(enableLogging));
                firebaseDatabase.setLogLevel(Logger.Level.WARN);
            } catch (DatabaseException unused2) {
                Log.w(TAG, "WARNING: enableLogging(bool) must be called before any other use of database(). \nIf you are sure you've done this then this message can be ignored during development as \nRN reloads can cause false positives. APP: " + firebaseDatabase.getApp().getName());
            }
        }
        return firebaseDatabase;
    }

    static WritableMap getJSError(DatabaseError databaseError) {
        String str;
        String str2;
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("nativeErrorCode", databaseError.getCode());
        createMap.putString("nativeErrorMessage", databaseError.getMessage());
        int code = databaseError.getCode();
        if (code == -25) {
            str = ErrorUtils.getCodeWithService("Database", "write-cancelled");
            str2 = ErrorUtils.getMessageWithService("The write was canceled by the user.", "Database", str);
        } else if (code == -24) {
            str = ErrorUtils.getCodeWithService("Database", "network-error");
            str2 = ErrorUtils.getMessageWithService("The operation could not be performed due to a network error.", "Database", str);
        } else if (code == -4) {
            str = ErrorUtils.getCodeWithService("Database", "disconnected");
            str2 = ErrorUtils.getMessageWithService("The operation had to be aborted due to a network disconnect.", "Database", str);
        } else if (code == -3) {
            str = ErrorUtils.getCodeWithService("Database", "permission-denied");
            str2 = ErrorUtils.getMessageWithService("Client doesn't have permission to access the desired data.", "Database", str);
        } else if (code == -2) {
            str = ErrorUtils.getCodeWithService("Database", "failure");
            str2 = ErrorUtils.getMessageWithService("The server indicated that this operation failed.", "Database", str);
        } else if (code != -1) {
            switch (code) {
                case -11:
                    str = ErrorUtils.getCodeWithService("Database", "user-code-exception");
                    str2 = ErrorUtils.getMessageWithService("User code called from the Firebase Database runloop threw an exception.", "Database", str);
                    break;
                case -10:
                    str = ErrorUtils.getCodeWithService("Database", "unavailable");
                    str2 = ErrorUtils.getMessageWithService("The service is unavailable.", "Database", str);
                    break;
                case -9:
                    str = ErrorUtils.getCodeWithService("Database", "overridden-by-set");
                    str2 = ErrorUtils.getMessageWithService("The transaction was overridden by a subsequent set.", "Database", str);
                    break;
                case -8:
                    str = ErrorUtils.getCodeWithService("Database", "max-retries");
                    str2 = ErrorUtils.getMessageWithService("The transaction had too many retries.", "Database", str);
                    break;
                case -7:
                    str = ErrorUtils.getCodeWithService("Database", "invalid-token");
                    str2 = ErrorUtils.getMessageWithService("The supplied auth token was invalid.", "Database", str);
                    break;
                case -6:
                    str = ErrorUtils.getCodeWithService("Database", "expired-token");
                    str2 = ErrorUtils.getMessageWithService("The supplied auth token has expired.", "Database", str);
                    break;
                default:
                    str = ErrorUtils.getCodeWithService("Database", "unknown");
                    str2 = ErrorUtils.getMessageWithService(GraphQLConstants.ErrorMessages.UNKNOWN, "Database", str);
                    break;
            }
        } else {
            str = ErrorUtils.getCodeWithService("Database", "data-stale");
            str2 = ErrorUtils.getMessageWithService("The transaction needs to be run again with current data.", "Database", str);
        }
        createMap.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, str);
        createMap.putString(GraphQLConstants.Keys.MESSAGE, str2);
        return createMap;
    }

    public void initialize() {
        super.initialize();
        Log.d(TAG, "RNFirebaseDatabase:initialized");
        reactApplicationContext = getReactApplicationContext();
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        Iterator<Map.Entry<String, RNFirebaseDatabaseReference>> it = references.entrySet().iterator();
        while (it.hasNext()) {
            ((RNFirebaseDatabaseReference) it.next().getValue()).removeAllEventListeners();
            it.remove();
        }
    }

    @ReactMethod
    public void goOnline(String str, String str2) {
        getDatabaseForApp(str, str2).goOnline();
    }

    @ReactMethod
    public void goOffline(String str, String str2) {
        getDatabaseForApp(str, str2).goOffline();
    }

    @ReactMethod
    public void setPersistence(String str, String str2, Boolean bool) {
        getDatabaseForApp(str, str2).setPersistenceEnabled(bool.booleanValue());
    }

    @ReactMethod
    public void setPersistenceCacheSizeBytes(String str, String str2, int i) {
        getDatabaseForApp(str, str2).setPersistenceCacheSizeBytes((long) i);
    }

    @ReactMethod
    public void enableLogging(Boolean bool) {
        enableLogging = bool.booleanValue();
        for (FirebaseApp next : FirebaseApp.getApps(getReactApplicationContext())) {
            loggingLevelSet.put(next.getName(), bool);
            try {
                if (enableLogging) {
                    FirebaseDatabase.getInstance(next).setLogLevel(Logger.Level.DEBUG);
                } else {
                    FirebaseDatabase.getInstance(next).setLogLevel(Logger.Level.WARN);
                }
            } catch (DatabaseException unused) {
                Log.w(TAG, "WARNING: enableLogging(bool) must be called before any other use of database(). \nIf you are sure you've done this then this message can be ignored during development as \nRN reloads can cause false positives. APP: " + next.getName());
            }
        }
    }

    @ReactMethod
    public void keepSynced(String str, String str2, String str3, String str4, ReadableArray readableArray, Boolean bool) {
        getInternalReferenceForApp(str, str2, str3, str4, readableArray).getQuery().keepSynced(bool.booleanValue());
    }

    @ReactMethod
    public void transactionTryCommit(String str, String str2, int i, ReadableMap readableMap) {
        RNFirebaseTransactionHandler rNFirebaseTransactionHandler = transactionHandlers.get(i);
        if (rNFirebaseTransactionHandler != null) {
            rNFirebaseTransactionHandler.signalUpdateReceived(readableMap);
        }
    }

    @ReactMethod
    public void transactionStart(String str, String str2, String str3, int i, Boolean bool) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final int i2 = i;
        final Boolean bool2 = bool;
        AsyncTask.execute(new Runnable() {
            public void run() {
                RNFirebaseDatabase.this.getReferenceForAppPath(str4, str5, str6).runTransaction(new Transaction.Handler() {
                    @Nonnull
                    public Transaction.Result doTransaction(@Nonnull MutableData mutableData) {
                        RNFirebaseTransactionHandler rNFirebaseTransactionHandler = new RNFirebaseTransactionHandler(i2, str4, str5);
                        RNFirebaseDatabase.transactionHandlers.put(i2, rNFirebaseTransactionHandler);
                        final WritableMap createUpdateMap = rNFirebaseTransactionHandler.createUpdateMap(mutableData);
                        AsyncTask.execute(new Runnable() {
                            public void run() {
                                Utils.sendEvent(RNFirebaseDatabase.this.getReactApplicationContext(), "database_transaction_event", createUpdateMap);
                            }
                        });
                        try {
                            rNFirebaseTransactionHandler.await();
                            if (rNFirebaseTransactionHandler.abort) {
                                return Transaction.abort();
                            }
                            if (rNFirebaseTransactionHandler.timeout) {
                                return Transaction.abort();
                            }
                            mutableData.setValue(rNFirebaseTransactionHandler.value);
                            return Transaction.success(mutableData);
                        } catch (InterruptedException unused) {
                            rNFirebaseTransactionHandler.interrupted = true;
                            return Transaction.abort();
                        }
                    }

                    public void onComplete(DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot) {
                        Utils.sendEvent(RNFirebaseDatabase.this.getReactApplicationContext(), "database_transaction_event", ((RNFirebaseTransactionHandler) RNFirebaseDatabase.transactionHandlers.get(i2)).createResultMap(databaseError, z, dataSnapshot));
                        RNFirebaseDatabase.transactionHandlers.delete(i2);
                    }
                }, bool2.booleanValue());
            }
        });
    }

    @ReactMethod
    public void onDisconnectSet(String str, String str2, String str3, ReadableMap readableMap, final Promise promise) {
        String string = readableMap.getString("type");
        OnDisconnect onDisconnect = getReferenceForAppPath(str, str2, str3).onDisconnect();
        AnonymousClass2 r3 = new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        };
        string.hashCode();
        char c = 65535;
        switch (string.hashCode()) {
            case -1034364087:
                if (string.equals("number")) {
                    c = 0;
                    break;
                }
                break;
            case -1023368385:
                if (string.equals("object")) {
                    c = 1;
                    break;
                }
                break;
            case -891985903:
                if (string.equals(TypedValues.Custom.S_STRING)) {
                    c = 2;
                    break;
                }
                break;
            case 3392903:
                if (string.equals(AbstractJsonLexerKt.NULL)) {
                    c = 3;
                    break;
                }
                break;
            case 64711720:
                if (string.equals(TypedValues.Custom.S_BOOLEAN)) {
                    c = 4;
                    break;
                }
                break;
            case 93090393:
                if (string.equals("array")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                onDisconnect.setValue(Double.valueOf(readableMap.getDouble("value")), r3);
                return;
            case 1:
                onDisconnect.setValue(Utils.recursivelyDeconstructReadableMap(readableMap.getMap("value")), r3);
                return;
            case 2:
                onDisconnect.setValue(readableMap.getString("value"), r3);
                return;
            case 3:
                onDisconnect.setValue((Object) null, r3);
                return;
            case 4:
                onDisconnect.setValue(Boolean.valueOf(readableMap.getBoolean("value")), r3);
                return;
            case 5:
                onDisconnect.setValue(Utils.recursivelyDeconstructReadableArray(readableMap.getArray("value")), r3);
                return;
            default:
                return;
        }
    }

    @ReactMethod
    public void onDisconnectUpdate(String str, String str2, String str3, ReadableMap readableMap, final Promise promise) {
        getReferenceForAppPath(str, str2, str3).onDisconnect().updateChildren(Utils.recursivelyDeconstructReadableMap(readableMap), new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        });
    }

    @ReactMethod
    public void onDisconnectRemove(String str, String str2, String str3, final Promise promise) {
        getReferenceForAppPath(str, str2, str3).onDisconnect().removeValue(new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        });
    }

    @ReactMethod
    public void onDisconnectCancel(String str, String str2, String str3, final Promise promise) {
        getReferenceForAppPath(str, str2, str3).onDisconnect().cancel(new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        });
    }

    @ReactMethod
    public void set(String str, String str2, String str3, ReadableMap readableMap, final Promise promise) {
        getReferenceForAppPath(str, str2, str3).setValue(Utils.recursivelyDeconstructReadableMap(readableMap).get("value"), new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        });
    }

    @ReactMethod
    public void setPriority(String str, String str2, String str3, ReadableMap readableMap, final Promise promise) {
        getReferenceForAppPath(str, str2, str3).setPriority(Utils.recursivelyDeconstructReadableMap(readableMap).get("value"), new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        });
    }

    @ReactMethod
    public void setWithPriority(String str, String str2, String str3, ReadableMap readableMap, ReadableMap readableMap2, final Promise promise) {
        getReferenceForAppPath(str, str2, str3).setValue(Utils.recursivelyDeconstructReadableMap(readableMap).get("value"), Utils.recursivelyDeconstructReadableMap(readableMap2).get("value"), new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        });
    }

    @ReactMethod
    public void update(String str, String str2, String str3, ReadableMap readableMap, final Promise promise) {
        getReferenceForAppPath(str, str2, str3).updateChildren(Utils.recursivelyDeconstructReadableMap(readableMap), new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        });
    }

    @ReactMethod
    public void remove(String str, String str2, String str3, final Promise promise) {
        getReferenceForAppPath(str, str2, str3).removeValue(new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                RNFirebaseDatabase.handlePromise(promise, databaseError);
            }
        });
    }

    @ReactMethod
    public void once(String str, String str2, String str3, String str4, ReadableArray readableArray, String str5, Promise promise) {
        getInternalReferenceForApp(str, str2, str3, str4, readableArray).once(str5, promise);
    }

    @ReactMethod
    public void on(String str, String str2, ReadableMap readableMap) {
        getCachedInternalReferenceForApp(str, str2, readableMap).on(readableMap.getString("eventType"), readableMap.getMap("registration"));
    }

    @ReactMethod
    public void off(String str, String str2) {
        RNFirebaseDatabaseReference rNFirebaseDatabaseReference = references.get(str);
        if (rNFirebaseDatabaseReference != null) {
            rNFirebaseDatabaseReference.removeEventListener(str2);
            if (!rNFirebaseDatabaseReference.hasListeners().booleanValue()) {
                references.remove(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public DatabaseReference getReferenceForAppPath(String str, String str2, String str3) {
        return getDatabaseForApp(str, str2).getReference(str3);
    }

    private RNFirebaseDatabaseReference getInternalReferenceForApp(String str, String str2, String str3, String str4, ReadableArray readableArray) {
        return new RNFirebaseDatabaseReference(str, str2, str3, str4, readableArray);
    }

    private RNFirebaseDatabaseReference getCachedInternalReferenceForApp(String str, String str2, ReadableMap readableMap) {
        String string = readableMap.getString("key");
        String string2 = readableMap.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        ReadableArray array = readableMap.getArray("modifiers");
        RNFirebaseDatabaseReference rNFirebaseDatabaseReference = references.get(string);
        if (rNFirebaseDatabaseReference != null) {
            return rNFirebaseDatabaseReference;
        }
        RNFirebaseDatabaseReference internalReferenceForApp = getInternalReferenceForApp(str, str2, string, string2, array);
        references.put(string, internalReferenceForApp);
        return internalReferenceForApp;
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("serverValueTimestamp", ServerValue.TIMESTAMP);
        return hashMap;
    }
}

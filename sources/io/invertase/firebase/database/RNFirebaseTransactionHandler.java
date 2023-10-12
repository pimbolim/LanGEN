package io.invertase.firebase.database;

import androidx.lifecycle.CoroutineLiveDataKt;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.MutableData;
import com.stripe.android.model.PaymentMethodOptionsParams;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import io.invertase.firebase.Utils;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;

public class RNFirebaseTransactionHandler {
    boolean abort = false;
    private String appName;
    private final Condition condition;
    private Map<String, Object> data;
    private String dbURL;
    boolean interrupted;
    private final ReentrantLock lock;
    private boolean signalled;
    boolean timeout = false;
    private int transactionId;
    public Object value;

    RNFirebaseTransactionHandler(int i, String str, String str2) {
        this.appName = str;
        this.dbURL = str2;
        this.transactionId = i;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    /* access modifiers changed from: package-private */
    public void signalUpdateReceived(ReadableMap readableMap) {
        Map<String, Object> recursivelyDeconstructReadableMap = Utils.recursivelyDeconstructReadableMap(readableMap);
        this.lock.lock();
        this.value = recursivelyDeconstructReadableMap.get("value");
        this.abort = ((Boolean) recursivelyDeconstructReadableMap.get("abort")).booleanValue();
        try {
            if (!this.signalled) {
                this.signalled = true;
                this.data = recursivelyDeconstructReadableMap;
                this.condition.signalAll();
                return;
            }
            throw new IllegalStateException("This transactionUpdateHandler has already been signalled.");
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void await() throws InterruptedException {
        boolean z;
        this.lock.lock();
        this.signalled = false;
        long currentTimeMillis = System.currentTimeMillis() + CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        while (!this.timeout && !this.condition.await(250, TimeUnit.MILLISECONDS) && !(z = this.signalled)) {
            try {
                if (!z && System.currentTimeMillis() > currentTimeMillis) {
                    this.timeout = true;
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getUpdates() {
        return this.data;
    }

    /* access modifiers changed from: package-private */
    public WritableMap createUpdateMap(MutableData mutableData) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(MessageExtension.FIELD_ID, this.transactionId);
        createMap.putString("type", "update");
        createMap.putString("appName", this.appName);
        createMap.putString("dbURL", this.dbURL);
        if (!mutableData.hasChildren()) {
            Utils.mapPutValue("value", mutableData.getValue(), createMap);
        } else {
            Object castValue = RNFirebaseDatabaseUtils.castValue(mutableData);
            if (castValue instanceof WritableNativeArray) {
                createMap.putArray("value", (WritableArray) castValue);
            } else {
                createMap.putMap("value", (WritableMap) castValue);
            }
        }
        return createMap;
    }

    /* access modifiers changed from: package-private */
    public WritableMap createResultMap(@Nullable DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(MessageExtension.FIELD_ID, this.transactionId);
        createMap.putString("appName", this.appName);
        createMap.putString("dbURL", this.dbURL);
        createMap.putBoolean("timeout", this.timeout);
        createMap.putBoolean("committed", z);
        createMap.putBoolean("interrupted", this.interrupted);
        if (databaseError != null || this.timeout || this.interrupted) {
            createMap.putString("type", ReactVideoView.EVENT_PROP_ERROR);
            if (databaseError != null) {
                createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, RNFirebaseDatabase.getJSError(databaseError));
            }
            if (databaseError == null && this.timeout) {
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, "DATABASE/INTERNAL-TIMEOUT");
                createMap2.putString(GraphQLConstants.Keys.MESSAGE, "A timeout occurred whilst waiting for RN JS thread to send transaction updates.");
                createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, createMap2);
            }
        } else {
            createMap.putString("type", "complete");
            createMap.putMap("snapshot", RNFirebaseDatabaseUtils.snapshotToMap(dataSnapshot));
        }
        return createMap;
    }
}

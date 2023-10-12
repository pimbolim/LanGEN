package io.invertase.firebase.firestore;

import com.braintreepayments.api.internal.GraphQLConstants;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;
import com.stripe.android.model.PaymentMethodOptionsParams;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;

class RNFirebaseFirestoreTransactionHandler {
    boolean aborted = false;
    private String appName;
    private ReadableArray commandBuffer;
    private final Condition condition;
    private Transaction firestoreTransaction;
    private final ReentrantLock lock;
    boolean timeout = false;
    private long timeoutAt;
    private int transactionId;

    RNFirebaseFirestoreTransactionHandler(String str, int i) {
        this.appName = str;
        this.transactionId = i;
        updateInternalTimeout();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    /* access modifiers changed from: package-private */
    public void abort() {
        this.aborted = true;
        safeUnlock();
    }

    /* access modifiers changed from: package-private */
    public void resetState(Transaction transaction) {
        this.commandBuffer = null;
        this.firestoreTransaction = transaction;
    }

    /* access modifiers changed from: package-private */
    public void signalBufferReceived(ReadableArray readableArray) {
        this.lock.lock();
        try {
            this.commandBuffer = readableArray;
            this.condition.signalAll();
        } finally {
            safeUnlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void await() {
        this.lock.lock();
        updateInternalTimeout();
        while (!this.aborted && !this.timeout && !this.condition.await(10, TimeUnit.MILLISECONDS)) {
            try {
                if (System.currentTimeMillis() > this.timeoutAt) {
                    this.timeout = true;
                }
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                safeUnlock();
                throw th;
            }
        }
        safeUnlock();
    }

    /* access modifiers changed from: package-private */
    public ReadableArray getCommandBuffer() {
        return this.commandBuffer;
    }

    /* access modifiers changed from: package-private */
    public void getDocument(DocumentReference documentReference, Promise promise) {
        updateInternalTimeout();
        try {
            promise.resolve(FirestoreSerialize.snapshotToWritableMap(this.firestoreTransaction.get(documentReference)));
        } catch (FirebaseFirestoreException e) {
            WritableMap jSError = RNFirebaseFirestore.getJSError(e);
            promise.reject(jSError.getString(PaymentMethodOptionsParams.Blik.PARAM_CODE), jSError.getString(GraphQLConstants.Keys.MESSAGE));
        }
    }

    /* access modifiers changed from: package-private */
    public WritableMap createEventMap(@Nullable FirebaseFirestoreException firebaseFirestoreException, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(MessageExtension.FIELD_ID, this.transactionId);
        createMap.putString("appName", this.appName);
        if (firebaseFirestoreException != null) {
            createMap.putString("type", ReactVideoView.EVENT_PROP_ERROR);
            createMap.putMap(ReactVideoView.EVENT_PROP_ERROR, RNFirebaseFirestore.getJSError(firebaseFirestoreException));
        } else {
            createMap.putString("type", str);
        }
        return createMap;
    }

    private void safeUnlock() {
        if (this.lock.isLocked()) {
            this.lock.unlock();
        }
    }

    private void updateInternalTimeout() {
        this.timeoutAt = System.currentTimeMillis() + 15000;
    }
}

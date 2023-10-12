package com.stripe.android;

import com.stripe.android.networking.FraudDetectionData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/stripe/android/FraudDetectionDataStore;", "", "get", "Lcom/stripe/android/networking/FraudDetectionData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", "fraudDetectionData", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FraudDetectionDataStore.kt */
public interface FraudDetectionDataStore {
    Object get(Continuation<? super FraudDetectionData> continuation);

    void save(FraudDetectionData fraudDetectionData);
}

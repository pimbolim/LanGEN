package com.stripe.android;

import com.stripe.android.networking.FraudDetectionData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H&\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/stripe/android/FraudDetectionDataRepository;", "", "getCached", "Lcom/stripe/android/networking/FraudDetectionData;", "getLatest", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "", "save", "fraudDetectionData", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FraudDetectionDataRepository.kt */
public interface FraudDetectionDataRepository {
    FraudDetectionData getCached();

    Object getLatest(Continuation<? super FraudDetectionData> continuation);

    void refresh();

    void save(FraudDetectionData fraudDetectionData);
}

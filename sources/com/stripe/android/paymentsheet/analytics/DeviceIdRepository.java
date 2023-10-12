package com.stripe.android.paymentsheet.analytics;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/DeviceIdRepository;", "", "get", "Lcom/stripe/android/paymentsheet/analytics/DeviceId;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceIdRepository.kt */
public interface DeviceIdRepository {
    Object get(Continuation<? super DeviceId> continuation);
}

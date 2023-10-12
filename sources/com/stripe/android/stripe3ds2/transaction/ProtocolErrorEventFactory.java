package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.stripe3ds2.transactions.ErrorData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ProtocolErrorEventFactory;", "", "()V", "create", "Lcom/stripe/android/stripe3ds2/transaction/ProtocolErrorEvent;", "errorData", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtocolErrorEventFactory.kt */
public final class ProtocolErrorEventFactory {
    public final ProtocolErrorEvent create(ErrorData errorData) {
        Intrinsics.checkNotNullParameter(errorData, "errorData");
        String acsTransId = errorData.getAcsTransId();
        if (acsTransId == null) {
            acsTransId = "";
        }
        return new ProtocolErrorEvent(errorData.getSdkTransId(), new ErrorMessage(acsTransId, errorData.getErrorCode(), errorData.getErrorDescription(), errorData.getErrorDetail()));
    }
}

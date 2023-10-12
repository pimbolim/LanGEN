package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.transactions.ErrorData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0001\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;", "", "executeAsync", "", "errorData", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "Factory", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ErrorRequestExecutor.kt */
public interface ErrorRequestExecutor {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor$Factory;", "", "create", "Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;", "acsUrl", "", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ErrorRequestExecutor.kt */
    public interface Factory {
        ErrorRequestExecutor create(String str, ErrorReporter errorReporter);
    }

    void executeAsync(ErrorData errorData);
}

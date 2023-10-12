package com.stripe.android.core.exception;

import com.stripe.android.core.StripeError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/core/exception/MaxRetryReachedException;", "Lcom/stripe/android/core/exception/StripeException;", "message", "", "(Ljava/lang/String;)V", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaxRetryReachedException.kt */
public final class MaxRetryReachedException extends StripeException {
    public static final int $stable = 0;

    public MaxRetryReachedException() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaxRetryReachedException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public MaxRetryReachedException(String str) {
        super((StripeError) null, (String) null, 0, (Throwable) null, str, 15, (DefaultConstructorMarker) null);
    }
}

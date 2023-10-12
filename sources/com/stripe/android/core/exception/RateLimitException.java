package com.stripe.android.core.exception;

import com.stripe.android.core.StripeError;
import com.stripe.android.core.networking.NetworkConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/core/exception/RateLimitException;", "Lcom/stripe/android/core/exception/StripeException;", "stripeError", "Lcom/stripe/android/core/StripeError;", "requestId", "", "message", "cause", "", "(Lcom/stripe/android/core/StripeError;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RateLimitException.kt */
public final class RateLimitException extends StripeException {
    public static final int $stable = 0;

    public RateLimitException() {
        this((StripeError) null, (String) null, (String) null, (Throwable) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RateLimitException(com.stripe.android.core.StripeError r2, java.lang.String r3, java.lang.String r4, java.lang.Throwable r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r1 = this;
            r7 = r6 & 1
            r0 = 0
            if (r7 == 0) goto L_0x0006
            r2 = r0
        L_0x0006:
            r7 = r6 & 2
            if (r7 == 0) goto L_0x000b
            r3 = r0
        L_0x000b:
            r7 = r6 & 4
            if (r7 == 0) goto L_0x0017
            if (r2 != 0) goto L_0x0013
            r4 = r0
            goto L_0x0017
        L_0x0013:
            java.lang.String r4 = r2.getMessage()
        L_0x0017:
            r6 = r6 & 8
            if (r6 == 0) goto L_0x001c
            r5 = r0
        L_0x001c:
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.exception.RateLimitException.<init>(com.stripe.android.core.StripeError, java.lang.String, java.lang.String, java.lang.Throwable, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public RateLimitException(StripeError stripeError, String str, String str2, Throwable th) {
        super(stripeError, str, NetworkConstantsKt.HTTP_TOO_MANY_REQUESTS, th, str2);
    }
}

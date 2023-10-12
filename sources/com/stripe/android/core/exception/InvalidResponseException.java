package com.stripe.android.core.exception;

import com.stripe.android.core.StripeError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stripe/android/core/exception/InvalidResponseException;", "Lcom/stripe/android/core/exception/StripeException;", "stripeError", "Lcom/stripe/android/core/StripeError;", "requestId", "", "statusCode", "", "message", "cause", "", "(Lcom/stripe/android/core/StripeError;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InvalidResponseException.kt */
public final class InvalidResponseException extends StripeException {
    public static final int $stable = 0;

    public InvalidResponseException() {
        this((StripeError) null, (String) null, 0, (String) null, (Throwable) null, 31, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InvalidResponseException(com.stripe.android.core.StripeError r5, java.lang.String r6, int r7, java.lang.String r8, java.lang.Throwable r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0016
            r7 = 0
            r2 = 0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x0024
            if (r11 != 0) goto L_0x001f
            r8 = r0
            goto L_0x0024
        L_0x001f:
            java.lang.String r5 = r11.getMessage()
            r8 = r5
        L_0x0024:
            r3 = r8
            r5 = r10 & 16
            if (r5 == 0) goto L_0x002b
            r10 = r0
            goto L_0x002c
        L_0x002b:
            r10 = r9
        L_0x002c:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.exception.InvalidResponseException.<init>(com.stripe.android.core.StripeError, java.lang.String, int, java.lang.String, java.lang.Throwable, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public InvalidResponseException(StripeError stripeError, String str, int i, String str2, Throwable th) {
        super(stripeError, str, i, th, str2);
    }
}

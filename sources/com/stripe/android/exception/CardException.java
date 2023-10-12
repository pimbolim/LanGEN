package com.stripe.android.exception;

import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.StripeException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/exception/CardException;", "Lcom/stripe/android/core/exception/StripeException;", "stripeError", "Lcom/stripe/android/core/StripeError;", "requestId", "", "(Lcom/stripe/android/core/StripeError;Ljava/lang/String;)V", "charge", "getCharge", "()Ljava/lang/String;", "code", "getCode", "declineCode", "getDeclineCode", "param", "getParam", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardException.kt */
public final class CardException extends StripeException {
    public static final int $stable = 0;
    private final String charge;
    private final String code;
    private final String declineCode;
    private final String param;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardException(StripeError stripeError, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stripeError, (i & 2) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardException(StripeError stripeError, String str) {
        super(stripeError, str, 402, (Throwable) null, (String) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(stripeError, "stripeError");
        this.code = stripeError.getCode();
        this.param = stripeError.getParam();
        this.declineCode = stripeError.getDeclineCode();
        this.charge = stripeError.getCharge();
    }

    public final String getCode() {
        return this.code;
    }

    public final String getParam() {
        return this.param;
    }

    public final String getDeclineCode() {
        return this.declineCode;
    }

    public final String getCharge() {
        return this.charge;
    }
}

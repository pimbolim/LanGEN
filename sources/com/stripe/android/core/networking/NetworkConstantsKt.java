package com.stripe.android.core.networking;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\"\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u00068\u0006XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u00068\u0006XT¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u00068\u0006XT¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u00068\u0006XT¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u00068\u0006XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u00068\u0006XT¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u00068\u0006XT¢\u0006\u0002\n\u0000\"\u0010\u0010\r\u001a\u00020\u00068\u0006XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u00068\u0006XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u000f\u001a\u00020\u00068\u0006XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u00028\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"DEFAULT_RETRY_CODES", "", "", "getDEFAULT_RETRY_CODES", "()Ljava/lang/Iterable;", "HEADER_ACCEPT", "", "HEADER_ACCEPT_CHARSET", "HEADER_ACCEPT_LANGUAGE", "HEADER_AUTHORIZATION", "HEADER_CONTENT_TYPE", "HEADER_IDEMPOTENCY_KEY", "HEADER_STRIPE_ACCOUNT", "HEADER_STRIPE_LIVEMODE", "HEADER_STRIPE_VERSION", "HEADER_USER_AGENT", "HTTP_TOO_MANY_REQUESTS", "stripe-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkConstants.kt */
public final class NetworkConstantsKt {
    private static final Iterable<Integer> DEFAULT_RETRY_CODES = new IntRange(HTTP_TOO_MANY_REQUESTS, HTTP_TOO_MANY_REQUESTS);
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
    public static final String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_IDEMPOTENCY_KEY = "Idempotency-Key";
    public static final String HEADER_STRIPE_ACCOUNT = "Stripe-Account";
    public static final String HEADER_STRIPE_LIVEMODE = "Stripe-Livemode";
    public static final String HEADER_STRIPE_VERSION = "Stripe-Version";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final int HTTP_TOO_MANY_REQUESTS = 429;

    public static final Iterable<Integer> getDEFAULT_RETRY_CODES() {
        return DEFAULT_RETRY_CODES;
    }
}

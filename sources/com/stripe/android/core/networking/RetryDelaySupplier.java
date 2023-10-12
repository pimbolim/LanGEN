package com.stripe.android.core.networking;

import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\b\u0017¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/core/networking/RetryDelaySupplier;", "", "()V", "incrementSeconds", "", "(J)V", "getDelayMillis", "maxRetries", "", "remainingRetries", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RetryDelaySupplier.kt */
public final class RetryDelaySupplier {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final long DEFAULT_INCREMENT_SECONDS = 2;
    private final long incrementSeconds;

    public RetryDelaySupplier(long j) {
        this.incrementSeconds = j;
    }

    @Inject
    public RetryDelaySupplier() {
        this(2);
    }

    public final long getDelayMillis(int i, int i2) {
        return TimeUnit.SECONDS.toMillis((long) Math.pow((double) this.incrementSeconds, (double) ((i - RangesKt.coerceIn(i2, 1, i)) + 1)));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/core/networking/RetryDelaySupplier$Companion;", "", "()V", "DEFAULT_INCREMENT_SECONDS", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RetryDelaySupplier.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

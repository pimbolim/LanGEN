package com.stripe.android.core.networking;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"com/stripe/android/core/networking/AnalyticsRequestFactory$createRequest$1", "Lcom/stripe/android/core/networking/AnalyticsEvent;", "eventName", "", "getEventName", "()Ljava/lang/String;", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnalyticsRequestFactory.kt */
public final class AnalyticsRequestFactory$createRequest$1 implements AnalyticsEvent {
    final /* synthetic */ String $event;
    private final String eventName;

    AnalyticsRequestFactory$createRequest$1(String str) {
        this.$event = str;
        this.eventName = str;
    }

    public String getEventName() {
        return this.eventName;
    }
}

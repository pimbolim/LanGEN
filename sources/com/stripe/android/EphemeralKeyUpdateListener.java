package com.stripe.android;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/stripe/android/EphemeralKeyUpdateListener;", "", "onKeyUpdate", "", "stripeResponseJson", "", "onKeyUpdateFailure", "responseCode", "", "message", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EphemeralKeyUpdateListener.kt */
public interface EphemeralKeyUpdateListener {
    void onKeyUpdate(String str);

    void onKeyUpdateFailure(int i, String str);
}

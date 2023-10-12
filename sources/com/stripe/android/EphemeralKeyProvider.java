package com.stripe.android;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/stripe/android/EphemeralKeyProvider;", "", "createEphemeralKey", "", "apiVersion", "", "keyUpdateListener", "Lcom/stripe/android/EphemeralKeyUpdateListener;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EphemeralKeyProvider.kt */
public interface EphemeralKeyProvider {
    void createEphemeralKey(String str, EphemeralKeyUpdateListener ephemeralKeyUpdateListener);
}

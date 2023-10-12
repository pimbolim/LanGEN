package com.stripe.android.payments.connections;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/payments/connections/UnsupportedConnectionsPaymentsProxy;", "Lcom/stripe/android/payments/connections/ConnectionsPaymentsProxy;", "()V", "present", "", "linkAccountSessionClientSecret", "", "publishableKey", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsPaymentsProxy.kt */
public final class UnsupportedConnectionsPaymentsProxy implements ConnectionsPaymentsProxy {
    public void present(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "linkAccountSessionClientSecret");
        Intrinsics.checkNotNullParameter(str2, "publishableKey");
    }
}

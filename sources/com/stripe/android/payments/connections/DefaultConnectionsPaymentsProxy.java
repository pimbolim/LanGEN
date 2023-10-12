package com.stripe.android.payments.connections;

import com.stripe.android.connections.ConnectionsSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/payments/connections/DefaultConnectionsPaymentsProxy;", "Lcom/stripe/android/payments/connections/ConnectionsPaymentsProxy;", "connectionsSheet", "Lcom/stripe/android/connections/ConnectionsSheet;", "(Lcom/stripe/android/connections/ConnectionsSheet;)V", "present", "", "linkAccountSessionClientSecret", "", "publishableKey", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsPaymentsProxy.kt */
public final class DefaultConnectionsPaymentsProxy implements ConnectionsPaymentsProxy {
    private final ConnectionsSheet connectionsSheet;

    public DefaultConnectionsPaymentsProxy(ConnectionsSheet connectionsSheet2) {
        Intrinsics.checkNotNullParameter(connectionsSheet2, "connectionsSheet");
        this.connectionsSheet = connectionsSheet2;
    }

    public void present(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "linkAccountSessionClientSecret");
        Intrinsics.checkNotNullParameter(str2, "publishableKey");
        this.connectionsSheet.present(new ConnectionsSheet.Configuration(str, str2));
    }
}

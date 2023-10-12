package com.stripe.android.payments.connections.reflection;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/payments/connections/reflection/DefaultIsConnectionsAvailable;", "Lcom/stripe/android/payments/connections/reflection/IsConnectionsAvailable;", "()V", "invoke", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IsConnectionsAvailable.kt */
public final class DefaultIsConnectionsAvailable implements IsConnectionsAvailable {
    public boolean invoke() {
        try {
            Class.forName("com.stripe.android.connections.ConnectionsSheet");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

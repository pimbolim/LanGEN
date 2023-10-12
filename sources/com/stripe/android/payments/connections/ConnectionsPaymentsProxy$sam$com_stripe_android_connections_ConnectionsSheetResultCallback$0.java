package com.stripe.android.payments.connections;

import com.stripe.android.connections.ConnectionsSheetResult;
import com.stripe.android.connections.ConnectionsSheetResultCallback;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsPaymentsProxy.kt */
final class ConnectionsPaymentsProxy$sam$com_stripe_android_connections_ConnectionsSheetResultCallback$0 implements ConnectionsSheetResultCallback, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    ConnectionsPaymentsProxy$sam$com_stripe_android_connections_ConnectionsSheetResultCallback$0(Function1 function1) {
        this.function = function1;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ConnectionsSheetResultCallback) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onConnectionsSheetResult(ConnectionsSheetResult connectionsSheetResult) {
        this.function.invoke(connectionsSheetResult);
    }
}

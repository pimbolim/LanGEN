package com.stripe.android.payments.connections;

import androidx.fragment.app.Fragment;
import com.stripe.android.connections.ConnectionsSheet;
import com.stripe.android.connections.ConnectionsSheetResult;
import com.stripe.android.connections.ConnectionsSheetResultCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/payments/connections/DefaultConnectionsPaymentsProxy;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsPaymentsProxy.kt */
final class ConnectionsPaymentsProxy$Companion$create$1 extends Lambda implements Function0<DefaultConnectionsPaymentsProxy> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ Function1<ConnectionsSheetResult, Unit> $onComplete;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionsPaymentsProxy$Companion$create$1(Fragment fragment, Function1<? super ConnectionsSheetResult, Unit> function1) {
        super(0);
        this.$fragment = fragment;
        this.$onComplete = function1;
    }

    public final DefaultConnectionsPaymentsProxy invoke() {
        return new DefaultConnectionsPaymentsProxy(ConnectionsSheet.Companion.create(this.$fragment, (ConnectionsSheetResultCallback) new ConnectionsPaymentsProxy$sam$com_stripe_android_connections_ConnectionsSheetResultCallback$0(this.$onComplete)));
    }
}

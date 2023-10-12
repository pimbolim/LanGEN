package com.stripe.android.connections;

import android.content.Intent;
import com.stripe.android.connections.ConnectionsSheetContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsSheetActivity.kt */
final class ConnectionsSheetActivity$starterArgs$2 extends Lambda implements Function0<ConnectionsSheetContract.Args> {
    final /* synthetic */ ConnectionsSheetActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionsSheetActivity$starterArgs$2(ConnectionsSheetActivity connectionsSheetActivity) {
        super(0);
        this.this$0 = connectionsSheetActivity;
    }

    public final ConnectionsSheetContract.Args invoke() {
        ConnectionsSheetContract.Args.Companion companion = ConnectionsSheetContract.Args.Companion;
        Intent intent = this.this$0.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return companion.fromIntent$connections_release(intent);
    }
}

package com.stripe.android.payments.bankaccount.ui;

import com.stripe.android.connections.ConnectionsSheetResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountActivity.kt */
/* synthetic */ class CollectBankAccountActivity$initConnectionsPaymentsProxy$1 extends FunctionReferenceImpl implements Function1<ConnectionsSheetResult, Unit> {
    CollectBankAccountActivity$initConnectionsPaymentsProxy$1(Object obj) {
        super(1, obj, CollectBankAccountViewModel.class, "onConnectionsResult", "onConnectionsResult(Lcom/stripe/android/connections/ConnectionsSheetResult;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConnectionsSheetResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ConnectionsSheetResult connectionsSheetResult) {
        Intrinsics.checkNotNullParameter(connectionsSheetResult, "p0");
        ((CollectBankAccountViewModel) this.receiver).onConnectionsResult(connectionsSheetResult);
    }
}

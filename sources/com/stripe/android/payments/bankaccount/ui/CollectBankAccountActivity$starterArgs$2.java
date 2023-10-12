package com.stripe.android.payments.bankaccount.ui;

import android.content.Intent;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountActivity.kt */
final class CollectBankAccountActivity$starterArgs$2 extends Lambda implements Function0<CollectBankAccountContract.Args> {
    final /* synthetic */ CollectBankAccountActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectBankAccountActivity$starterArgs$2(CollectBankAccountActivity collectBankAccountActivity) {
        super(0);
        this.this$0 = collectBankAccountActivity;
    }

    public final CollectBankAccountContract.Args invoke() {
        CollectBankAccountContract.Args.Companion companion = CollectBankAccountContract.Args.Companion;
        Intent intent = this.this$0.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return companion.fromIntent(intent);
    }
}

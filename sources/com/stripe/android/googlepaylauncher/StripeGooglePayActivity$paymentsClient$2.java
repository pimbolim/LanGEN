package com.stripe.android.googlepaylauncher;

import com.google.android.gms.wallet.PaymentsClient;
import com.stripe.android.googlepaylauncher.StripeGooglePayContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/android/gms/wallet/PaymentsClient;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeGooglePayActivity.kt */
final class StripeGooglePayActivity$paymentsClient$2 extends Lambda implements Function0<PaymentsClient> {
    final /* synthetic */ StripeGooglePayActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeGooglePayActivity$paymentsClient$2(StripeGooglePayActivity stripeGooglePayActivity) {
        super(0);
        this.this$0 = stripeGooglePayActivity;
    }

    public final PaymentsClient invoke() {
        PaymentsClientFactory paymentsClientFactory = new PaymentsClientFactory(this.this$0);
        StripeGooglePayContract.Args access$getArgs$p = this.this$0.args;
        if (access$getArgs$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("args");
            access$getArgs$p = null;
        }
        return paymentsClientFactory.create(access$getArgs$p.getConfig().getEnvironment());
    }
}

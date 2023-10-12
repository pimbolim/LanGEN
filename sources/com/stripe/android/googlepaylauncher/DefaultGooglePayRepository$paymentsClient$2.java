package com.stripe.android.googlepaylauncher;

import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/android/gms/wallet/PaymentsClient;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayRepository.kt */
final class DefaultGooglePayRepository$paymentsClient$2 extends Lambda implements Function0<PaymentsClient> {
    final /* synthetic */ DefaultGooglePayRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultGooglePayRepository$paymentsClient$2(DefaultGooglePayRepository defaultGooglePayRepository) {
        super(0);
        this.this$0 = defaultGooglePayRepository;
    }

    public final PaymentsClient invoke() {
        Wallet.WalletOptions build = new Wallet.WalletOptions.Builder().setEnvironment(this.this$0.environment.getValue$payments_core_release()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…lue)\n            .build()");
        PaymentsClient paymentsClient = Wallet.getPaymentsClient(this.this$0.context, build);
        Intrinsics.checkNotNullExpressionValue(paymentsClient, "getPaymentsClient(context, options)");
        return paymentsClient;
    }
}

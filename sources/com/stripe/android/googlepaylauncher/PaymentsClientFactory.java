package com.stripe.android.googlepaylauncher;

import android.content.Context;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/googlepaylauncher/PaymentsClientFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "create", "Lcom/google/android/gms/wallet/PaymentsClient;", "environment", "Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentsClientFactory.kt */
public final class PaymentsClientFactory {
    private final Context context;

    @Inject
    public PaymentsClientFactory(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final PaymentsClient create(GooglePayEnvironment googlePayEnvironment) {
        Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
        Wallet.WalletOptions build = new Wallet.WalletOptions.Builder().setEnvironment(googlePayEnvironment.getValue$payments_core_release()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…lue)\n            .build()");
        PaymentsClient paymentsClient = Wallet.getPaymentsClient(this.context, build);
        Intrinsics.checkNotNullExpressionValue(paymentsClient, "getPaymentsClient(context, options)");
        return paymentsClient;
    }
}

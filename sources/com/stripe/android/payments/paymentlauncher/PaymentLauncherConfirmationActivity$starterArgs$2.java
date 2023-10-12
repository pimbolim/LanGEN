package com.stripe.android.payments.paymentlauncher;

import android.content.Intent;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentLauncherConfirmationActivity.kt */
final class PaymentLauncherConfirmationActivity$starterArgs$2 extends Lambda implements Function0<PaymentLauncherContract.Args> {
    final /* synthetic */ PaymentLauncherConfirmationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentLauncherConfirmationActivity$starterArgs$2(PaymentLauncherConfirmationActivity paymentLauncherConfirmationActivity) {
        super(0);
        this.this$0 = paymentLauncherConfirmationActivity;
    }

    public final PaymentLauncherContract.Args invoke() {
        PaymentLauncherContract.Args.Companion companion = PaymentLauncherContract.Args.Companion;
        Intent intent = this.this$0.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return companion.fromIntent(intent);
    }
}

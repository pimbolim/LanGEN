package com.stripe.android.payments.paymentlauncher;

import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentLauncherConfirmationActivity.kt */
final class PaymentLauncherConfirmationActivity$viewModelFactory$1 extends Lambda implements Function0<PaymentLauncherContract.Args> {
    final /* synthetic */ PaymentLauncherConfirmationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentLauncherConfirmationActivity$viewModelFactory$1(PaymentLauncherConfirmationActivity paymentLauncherConfirmationActivity) {
        super(0);
        this.this$0 = paymentLauncherConfirmationActivity;
    }

    public final PaymentLauncherContract.Args invoke() {
        PaymentLauncherContract.Args access$getStarterArgs = this.this$0.getStarterArgs();
        if (access$getStarterArgs != null) {
            return access$getStarterArgs;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

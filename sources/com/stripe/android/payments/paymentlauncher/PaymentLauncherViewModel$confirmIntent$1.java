package com.stripe.android.payments.paymentlauncher;

import com.stripe.android.model.ConfirmStripeIntentParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel", f = "PaymentLauncherViewModel.kt", i = {}, l = {143, 150}, m = "confirmIntent", n = {}, s = {})
/* compiled from: PaymentLauncherViewModel.kt */
final class PaymentLauncherViewModel$confirmIntent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PaymentLauncherViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentLauncherViewModel$confirmIntent$1(PaymentLauncherViewModel paymentLauncherViewModel, Continuation<? super PaymentLauncherViewModel$confirmIntent$1> continuation) {
        super(continuation);
        this.this$0 = paymentLauncherViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.confirmIntent((ConfirmStripeIntentParams) null, (String) null, this);
    }
}

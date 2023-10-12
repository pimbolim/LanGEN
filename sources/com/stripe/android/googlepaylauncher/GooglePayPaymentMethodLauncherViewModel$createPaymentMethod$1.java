package com.stripe.android.googlepaylauncher;

import com.google.android.gms.wallet.PaymentData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel", f = "GooglePayPaymentMethodLauncherViewModel.kt", i = {}, l = {105}, m = "createPaymentMethod", n = {}, s = {})
/* compiled from: GooglePayPaymentMethodLauncherViewModel.kt */
final class GooglePayPaymentMethodLauncherViewModel$createPaymentMethod$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GooglePayPaymentMethodLauncherViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayPaymentMethodLauncherViewModel$createPaymentMethod$1(GooglePayPaymentMethodLauncherViewModel googlePayPaymentMethodLauncherViewModel, Continuation<? super GooglePayPaymentMethodLauncherViewModel$createPaymentMethod$1> continuation) {
        super(continuation);
        this.this$0 = googlePayPaymentMethodLauncherViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createPaymentMethod((PaymentData) null, this);
    }
}

package com.stripe.android.googlepaylauncher;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel", f = "GooglePayPaymentMethodLauncherViewModel.kt", i = {0}, l = {88}, m = "createLoadPaymentDataTask", n = {"this"}, s = {"L$0"})
/* compiled from: GooglePayPaymentMethodLauncherViewModel.kt */
final class GooglePayPaymentMethodLauncherViewModel$createLoadPaymentDataTask$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GooglePayPaymentMethodLauncherViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayPaymentMethodLauncherViewModel$createLoadPaymentDataTask$1(GooglePayPaymentMethodLauncherViewModel googlePayPaymentMethodLauncherViewModel, Continuation<? super GooglePayPaymentMethodLauncherViewModel$createLoadPaymentDataTask$1> continuation) {
        super(continuation);
        this.this$0 = googlePayPaymentMethodLauncherViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createLoadPaymentDataTask(this);
    }
}

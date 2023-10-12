package com.stripe.android.googlepaylauncher;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel", f = "GooglePayLauncherViewModel.kt", i = {}, l = {197, 201}, m = "getResultFromConfirmation$payments_core_release", n = {}, s = {})
/* compiled from: GooglePayLauncherViewModel.kt */
final class GooglePayLauncherViewModel$getResultFromConfirmation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GooglePayLauncherViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayLauncherViewModel$getResultFromConfirmation$1(GooglePayLauncherViewModel googlePayLauncherViewModel, Continuation<? super GooglePayLauncherViewModel$getResultFromConfirmation$1> continuation) {
        super(continuation);
        this.this$0 = googlePayLauncherViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getResultFromConfirmation$payments_core_release(0, (Intent) null, this);
    }
}

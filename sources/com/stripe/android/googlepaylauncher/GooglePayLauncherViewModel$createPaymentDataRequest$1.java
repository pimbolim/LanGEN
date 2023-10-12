package com.stripe.android.googlepaylauncher;

import com.stripe.android.googlepaylauncher.GooglePayLauncherContract;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel", f = "GooglePayLauncherViewModel.kt", i = {0, 0, 1, 1}, l = {68, 82}, m = "createPaymentDataRequest", n = {"this", "args", "this", "args"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: GooglePayLauncherViewModel.kt */
final class GooglePayLauncherViewModel$createPaymentDataRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GooglePayLauncherViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayLauncherViewModel$createPaymentDataRequest$1(GooglePayLauncherViewModel googlePayLauncherViewModel, Continuation<? super GooglePayLauncherViewModel$createPaymentDataRequest$1> continuation) {
        super(continuation);
        this.this$0 = googlePayLauncherViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createPaymentDataRequest((GooglePayLauncherContract.Args) null, this);
    }
}

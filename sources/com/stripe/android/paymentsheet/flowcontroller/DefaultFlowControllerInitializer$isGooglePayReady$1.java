package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.paymentsheet.PaymentSheet;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer", f = "DefaultFlowControllerInitializer.kt", i = {}, l = {68}, m = "isGooglePayReady", n = {}, s = {})
/* compiled from: DefaultFlowControllerInitializer.kt */
final class DefaultFlowControllerInitializer$isGooglePayReady$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultFlowControllerInitializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlowControllerInitializer$isGooglePayReady$1(DefaultFlowControllerInitializer defaultFlowControllerInitializer, Continuation<? super DefaultFlowControllerInitializer$isGooglePayReady$1> continuation) {
        super(continuation);
        this.this$0 = defaultFlowControllerInitializer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.isGooglePayReady((PaymentSheet.Configuration) null, this);
    }
}

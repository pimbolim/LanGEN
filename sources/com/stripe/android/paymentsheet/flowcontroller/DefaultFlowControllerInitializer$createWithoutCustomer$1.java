package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.model.ClientSecret;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer", f = "DefaultFlowControllerInitializer.kt", i = {0, 0, 0, 0}, l = {123}, m = "createWithoutCustomer", n = {"this", "clientSecret", "config", "isGooglePayReady"}, s = {"L$0", "L$1", "L$2", "Z$0"})
/* compiled from: DefaultFlowControllerInitializer.kt */
final class DefaultFlowControllerInitializer$createWithoutCustomer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultFlowControllerInitializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlowControllerInitializer$createWithoutCustomer$1(DefaultFlowControllerInitializer defaultFlowControllerInitializer, Continuation<? super DefaultFlowControllerInitializer$createWithoutCustomer$1> continuation) {
        super(continuation);
        this.this$0 = defaultFlowControllerInitializer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createWithoutCustomer((ClientSecret) null, (PaymentSheet.Configuration) null, false, this);
    }
}

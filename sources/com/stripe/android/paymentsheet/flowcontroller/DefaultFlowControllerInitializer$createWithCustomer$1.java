package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.model.ClientSecret;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer", f = "DefaultFlowControllerInitializer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3}, l = {80, 89, 96, 104}, m = "createWithCustomer", n = {"this", "clientSecret", "customerConfig", "config", "prefsRepository", "isGooglePayReady", "this", "clientSecret", "config", "prefsRepository", "stripeIntent", "isGooglePayReady", "clientSecret", "config", "prefsRepository", "stripeIntent", "paymentMethods", "isGooglePayReady", "isGooglePayReady"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$0"})
/* compiled from: DefaultFlowControllerInitializer.kt */
final class DefaultFlowControllerInitializer$createWithCustomer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultFlowControllerInitializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlowControllerInitializer$createWithCustomer$1(DefaultFlowControllerInitializer defaultFlowControllerInitializer, Continuation<? super DefaultFlowControllerInitializer$createWithCustomer$1> continuation) {
        super(continuation);
        this.this$0 = defaultFlowControllerInitializer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createWithCustomer((ClientSecret) null, (PaymentSheet.CustomerConfiguration) null, (PaymentSheet.Configuration) null, false, this);
    }
}

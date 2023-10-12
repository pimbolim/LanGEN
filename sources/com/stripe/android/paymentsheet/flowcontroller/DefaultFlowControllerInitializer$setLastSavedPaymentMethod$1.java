package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.model.PaymentMethod;
import com.stripe.android.paymentsheet.PrefsRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer", f = "DefaultFlowControllerInitializer.kt", i = {0, 0, 0}, l = {155}, m = "setLastSavedPaymentMethod", n = {"prefsRepository", "paymentMethods", "isGooglePayReady"}, s = {"L$0", "L$1", "Z$0"})
/* compiled from: DefaultFlowControllerInitializer.kt */
final class DefaultFlowControllerInitializer$setLastSavedPaymentMethod$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultFlowControllerInitializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlowControllerInitializer$setLastSavedPaymentMethod$1(DefaultFlowControllerInitializer defaultFlowControllerInitializer, Continuation<? super DefaultFlowControllerInitializer$setLastSavedPaymentMethod$1> continuation) {
        super(continuation);
        this.this$0 = defaultFlowControllerInitializer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setLastSavedPaymentMethod((PrefsRepository) null, false, (List<PaymentMethod>) null, this);
    }
}

package com.stripe.android;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.CustomerSessionOperationExecutor", f = "CustomerSessionOperationExecutor.kt", i = {0, 0, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10, 12, 12, 14, 14}, l = {27, 32, 39, 51, 66, 77, 92, 103, 118, 128, 142, 155, 170, 182, 189, 200}, m = "execute$payments_core_release", n = {"this", "operation", "this", "operation", "this", "operation", "this", "operation", "this", "operation", "this", "operation", "this", "operation", "this", "operation"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* compiled from: CustomerSessionOperationExecutor.kt */
final class CustomerSessionOperationExecutor$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CustomerSessionOperationExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerSessionOperationExecutor$execute$1(CustomerSessionOperationExecutor customerSessionOperationExecutor, Continuation<? super CustomerSessionOperationExecutor$execute$1> continuation) {
        super(continuation);
        this.this$0 = customerSessionOperationExecutor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute$payments_core_release((EphemeralKey) null, (EphemeralOperation) null, this);
    }
}

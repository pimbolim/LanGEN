package com.stripe.android.stripe3ds2.transaction;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ImmediateTimeoutTransactionTimer;", "Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;", "()V", "timeout", "Lkotlinx/coroutines/flow/Flow;", "", "getTimeout", "()Lkotlinx/coroutines/flow/Flow;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImmediateTimeoutTransactionTimer.kt */
public final class ImmediateTimeoutTransactionTimer implements TransactionTimer {
    private final Flow<Boolean> timeout = FlowKt.flowOf(true);

    public Object start(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public Flow<Boolean> getTimeout() {
        return this.timeout;
    }
}

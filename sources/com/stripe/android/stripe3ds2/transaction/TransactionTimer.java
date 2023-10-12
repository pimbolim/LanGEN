package com.stripe.android.stripe3ds2.transaction;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;", "", "timeout", "Lkotlinx/coroutines/flow/Flow;", "", "getTimeout", "()Lkotlinx/coroutines/flow/Flow;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransactionTimer.kt */
public interface TransactionTimer {
    Flow<Boolean> getTimeout();

    Object start(Continuation<? super Unit> continuation);
}

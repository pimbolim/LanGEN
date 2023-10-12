package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import com.stripe.android.stripe3ds2.transactions.ErrorData;
import com.stripe.android.stripe3ds2.transactions.ProtocolError;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\r\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\b\u0018J\u0011\u0010\u0019\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/DefaultTransactionTimer;", "Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;", "timeoutMinutes", "", "errorRequestExecutor", "Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;", "creqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(ILcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;Lkotlin/coroutines/CoroutineContext;)V", "mutableTimeoutFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "timeout", "Lkotlinx/coroutines/flow/StateFlow;", "getTimeout", "()Lkotlinx/coroutines/flow/StateFlow;", "timeoutMillis", "", "createTimeoutErrorData", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "onTimeout", "", "onTimeout$3ds2sdk_release", "start", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransactionTimer.kt */
public final class DefaultTransactionTimer implements TransactionTimer {
    private final ChallengeRequestData creqData;
    private final ErrorRequestExecutor errorRequestExecutor;
    private final MutableStateFlow<Boolean> mutableTimeoutFlow;
    private final StateFlow<Boolean> timeout;
    /* access modifiers changed from: private */
    public final long timeoutMillis;
    private final CoroutineContext workContext;

    public DefaultTransactionTimer(int i, ErrorRequestExecutor errorRequestExecutor2, ChallengeRequestData challengeRequestData, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(errorRequestExecutor2, "errorRequestExecutor");
        Intrinsics.checkNotNullParameter(challengeRequestData, "creqData");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.errorRequestExecutor = errorRequestExecutor2;
        this.creqData = challengeRequestData;
        this.workContext = coroutineContext;
        this.timeoutMillis = TimeUnit.MINUTES.toMillis((long) i);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this.mutableTimeoutFlow = MutableStateFlow;
        this.timeout = MutableStateFlow;
    }

    public StateFlow<Boolean> getTimeout() {
        return this.timeout;
    }

    public Object start(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.workContext, new DefaultTransactionTimer$start$2(this, (Continuation<? super DefaultTransactionTimer$start$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void onTimeout$3ds2sdk_release() {
        this.errorRequestExecutor.executeAsync(createTimeoutErrorData());
        this.mutableTimeoutFlow.setValue(true);
    }

    private final ErrorData createTimeoutErrorData() {
        return new ErrorData(this.creqData.getThreeDsServerTransId(), this.creqData.getAcsTransId(), (String) null, String.valueOf(ProtocolError.TransactionTimedout.getCode()), ErrorData.ErrorComponent.ThreeDsSdk, ProtocolError.TransactionTimedout.getDescription(), "Timeout expiry reached for the transaction", (String) null, this.creqData.getMessageVersion(), this.creqData.getSdkTransId(), 132, (DefaultConstructorMarker) null);
    }
}

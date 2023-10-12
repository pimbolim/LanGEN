package com.stripe.android.payments.core.authentication.threeds2;

import com.stripe.android.model.Stripe3ds2Fingerprint;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel", f = "Stripe3ds2TransactionViewModel.kt", i = {0, 0, 0, 0}, l = {107, 115}, m = "begin3ds2Auth", n = {"this", "stripe3ds2Fingerprint", "transaction", "timeout"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* compiled from: Stripe3ds2TransactionViewModel.kt */
final class Stripe3ds2TransactionViewModel$begin3ds2Auth$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Stripe3ds2TransactionViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe3ds2TransactionViewModel$begin3ds2Auth$1(Stripe3ds2TransactionViewModel stripe3ds2TransactionViewModel, Continuation<? super Stripe3ds2TransactionViewModel$begin3ds2Auth$1> continuation) {
        super(continuation);
        this.this$0 = stripe3ds2TransactionViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.begin3ds2Auth((Stripe3ds2Fingerprint) null, this);
    }
}

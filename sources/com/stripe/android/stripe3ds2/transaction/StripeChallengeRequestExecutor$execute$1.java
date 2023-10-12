package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor", f = "StripeChallengeRequestExecutor.kt", i = {0}, l = {60}, m = "execute", n = {"creqData"}, s = {"L$0"})
/* compiled from: StripeChallengeRequestExecutor.kt */
final class StripeChallengeRequestExecutor$execute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StripeChallengeRequestExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeChallengeRequestExecutor$execute$1(StripeChallengeRequestExecutor stripeChallengeRequestExecutor, Continuation<? super StripeChallengeRequestExecutor$execute$1> continuation) {
        super(continuation);
        this.this$0 = stripeChallengeRequestExecutor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute((ChallengeRequestData) null, this);
    }
}

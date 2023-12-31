package com.stripe.android.stripe3ds2.transaction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository", f = "InitChallengeRepository.kt", i = {0, 0, 0, 0, 0}, l = {67}, m = "startChallenge", n = {"this", "args", "$this$startChallenge_u24lambda_u2d0", "errorRequestExecutor", "creqExecutorConfig"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: InitChallengeRepository.kt */
final class DefaultInitChallengeRepository$startChallenge$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultInitChallengeRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultInitChallengeRepository$startChallenge$1(DefaultInitChallengeRepository defaultInitChallengeRepository, Continuation<? super DefaultInitChallengeRepository$startChallenge$1> continuation) {
        super(continuation);
        this.this$0 = defaultInitChallengeRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startChallenge((InitChallengeArgs) null, this);
    }
}

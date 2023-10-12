package com.stripe.android.payments.core.authentication.threeds2;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor", f = "Stripe3ds2ChallengeResultProcessor.kt", i = {0, 0, 0, 0}, l = {200, 208}, m = "onComplete3ds2AuthFailure", n = {"this", "challengeResult", "requestOptions", "remainingRetries"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* compiled from: Stripe3ds2ChallengeResultProcessor.kt */
final class DefaultStripe3ds2ChallengeResultProcessor$onComplete3ds2AuthFailure$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultStripe3ds2ChallengeResultProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultStripe3ds2ChallengeResultProcessor$onComplete3ds2AuthFailure$1(DefaultStripe3ds2ChallengeResultProcessor defaultStripe3ds2ChallengeResultProcessor, Continuation<? super DefaultStripe3ds2ChallengeResultProcessor$onComplete3ds2AuthFailure$1> continuation) {
        super(continuation);
        this.this$0 = defaultStripe3ds2ChallengeResultProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onComplete3ds2AuthFailure((ChallengeResult) null, (ApiRequest.Options) null, 0, (Throwable) null, this);
    }
}

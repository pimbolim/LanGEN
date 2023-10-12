package com.stripe.android.cards;

import com.stripe.android.cards.CardNumber;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.cards.DefaultCardAccountRangeRepository", f = "DefaultCardAccountRangeRepository.kt", i = {0, 0, 1, 1, 2, 2}, l = {17, 18, 20, 21}, m = "getAccountRange", n = {"this", "cardNumber", "this", "cardNumber", "this", "cardNumber"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* compiled from: DefaultCardAccountRangeRepository.kt */
final class DefaultCardAccountRangeRepository$getAccountRange$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultCardAccountRangeRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultCardAccountRangeRepository$getAccountRange$1(DefaultCardAccountRangeRepository defaultCardAccountRangeRepository, Continuation<? super DefaultCardAccountRangeRepository$getAccountRange$1> continuation) {
        super(continuation);
        this.this$0 = defaultCardAccountRangeRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAccountRange((CardNumber.Unvalidated) null, this);
    }
}

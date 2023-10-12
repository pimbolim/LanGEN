package com.stripe.android.networking;

import com.stripe.android.core.networking.ApiRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.networking.StripeApiRepository", f = "StripeApiRepository.kt", i = {0, 0, 0, 0}, l = {1640}, m = "makeApiRequest$payments_core_release", n = {"this", "apiRequest", "onResponse", "dnsCacheData"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: StripeApiRepository.kt */
final class StripeApiRepository$makeApiRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StripeApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeApiRepository$makeApiRequest$1(StripeApiRepository stripeApiRepository, Continuation<? super StripeApiRepository$makeApiRequest$1> continuation) {
        super(continuation);
        this.this$0 = stripeApiRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.makeApiRequest$payments_core_release((ApiRequest) null, (Function0<Unit>) null, this);
    }
}

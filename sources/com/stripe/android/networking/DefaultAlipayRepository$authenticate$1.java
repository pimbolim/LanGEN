package com.stripe.android.networking;

import com.stripe.android.AlipayAuthenticator;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.PaymentIntent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.networking.DefaultAlipayRepository", f = "DefaultAlipayRepository.kt", i = {}, l = {34}, m = "authenticate", n = {}, s = {})
/* compiled from: DefaultAlipayRepository.kt */
final class DefaultAlipayRepository$authenticate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultAlipayRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultAlipayRepository$authenticate$1(DefaultAlipayRepository defaultAlipayRepository, Continuation<? super DefaultAlipayRepository$authenticate$1> continuation) {
        super(continuation);
        this.this$0 = defaultAlipayRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.authenticate((PaymentIntent) null, (AlipayAuthenticator) null, (ApiRequest.Options) null, this);
    }
}

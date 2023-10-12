package com.stripe.android.connections.repository;

import com.stripe.android.core.networking.StripeRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.serialization.KSerializer;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.connections.repository.ConnectionsApiRepository", f = "ConnectionsApiRepository.kt", i = {0, 0, 0}, l = {89}, m = "executeRequest", n = {"this", "request", "responseSerializer"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: ConnectionsApiRepository.kt */
final class ConnectionsApiRepository$executeRequest$1<Response> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConnectionsApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionsApiRepository$executeRequest$1(ConnectionsApiRepository connectionsApiRepository, Continuation<? super ConnectionsApiRepository$executeRequest$1> continuation) {
        super(continuation);
        this.this$0 = connectionsApiRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeRequest((StripeRequest) null, (KSerializer) null, this);
    }
}

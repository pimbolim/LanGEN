package com.stripe.android.connections.analytics;

import com.stripe.android.core.networking.AnalyticsEvent;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.AnalyticsRequestFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.connections.analytics.DefaultConnectionsEventReporter$fireEvent$1", f = "DefaultConnectionsEventReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultConnectionsEventReporter.kt */
final class DefaultConnectionsEventReporter$fireEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConnectionsAnalyticsEvent $event;
    int label;
    final /* synthetic */ DefaultConnectionsEventReporter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultConnectionsEventReporter$fireEvent$1(DefaultConnectionsEventReporter defaultConnectionsEventReporter, ConnectionsAnalyticsEvent connectionsAnalyticsEvent, Continuation<? super DefaultConnectionsEventReporter$fireEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultConnectionsEventReporter;
        this.$event = connectionsAnalyticsEvent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultConnectionsEventReporter$fireEvent$1(this.this$0, this.$event, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultConnectionsEventReporter$fireEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AnalyticsRequestExecutor access$getAnalyticsRequestExecutor$p = this.this$0.analyticsRequestExecutor;
            AnalyticsRequestFactory access$getAnalyticsRequestFactory$p = this.this$0.analyticsRequestFactory;
            ConnectionsAnalyticsEvent connectionsAnalyticsEvent = this.$event;
            access$getAnalyticsRequestExecutor$p.executeAsync(access$getAnalyticsRequestFactory$p.createRequest((AnalyticsEvent) connectionsAnalyticsEvent, (Map<String, ? extends Object>) connectionsAnalyticsEvent.getAdditionalParams()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

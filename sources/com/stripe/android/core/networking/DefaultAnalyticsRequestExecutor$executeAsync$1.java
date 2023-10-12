package com.stripe.android.core.networking;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor$executeAsync$1", f = "DefaultAnalyticsRequestExecutor.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultAnalyticsRequestExecutor.kt */
final class DefaultAnalyticsRequestExecutor$executeAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnalyticsRequest $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultAnalyticsRequestExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultAnalyticsRequestExecutor$executeAsync$1(DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor, AnalyticsRequest analyticsRequest, Continuation<? super DefaultAnalyticsRequestExecutor$executeAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultAnalyticsRequestExecutor;
        this.$request = analyticsRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultAnalyticsRequestExecutor$executeAsync$1 defaultAnalyticsRequestExecutor$executeAsync$1 = new DefaultAnalyticsRequestExecutor$executeAsync$1(this.this$0, this.$request, continuation);
        defaultAnalyticsRequestExecutor$executeAsync$1.L$0 = obj;
        return defaultAnalyticsRequestExecutor$executeAsync$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultAnalyticsRequestExecutor$executeAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor = this.this$0;
            AnalyticsRequest analyticsRequest = this.$request;
            Result.Companion companion = Result.Companion;
            this.label = 1;
            obj = defaultAnalyticsRequestExecutor.stripeNetworkClient.executeRequest(analyticsRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m4709constructorimpl((StripeResponse) obj);
        DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor2 = this.this$0;
        Throwable r5 = Result.m4712exceptionOrNullimpl(obj2);
        if (r5 != null) {
            defaultAnalyticsRequestExecutor2.logger.error("Exception while making analytics request", r5);
        }
        return Unit.INSTANCE;
    }
}

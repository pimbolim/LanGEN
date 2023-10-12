package com.stripe.android.core.networking;

import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.IOContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/core/networking/DefaultAnalyticsRequestExecutor;", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "()V", "logger", "Lcom/stripe/android/core/Logger;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/core/Logger;Lkotlin/coroutines/CoroutineContext;)V", "stripeNetworkClient", "Lcom/stripe/android/core/networking/StripeNetworkClient;", "(Lcom/stripe/android/core/networking/StripeNetworkClient;Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/core/Logger;)V", "executeAsync", "", "request", "Lcom/stripe/android/core/networking/AnalyticsRequest;", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultAnalyticsRequestExecutor.kt */
public final class DefaultAnalyticsRequestExecutor implements AnalyticsRequestExecutor {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FIELD_EVENT = "event";
    /* access modifiers changed from: private */
    public final Logger logger;
    /* access modifiers changed from: private */
    public final StripeNetworkClient stripeNetworkClient;
    private final CoroutineContext workContext;

    public DefaultAnalyticsRequestExecutor(StripeNetworkClient stripeNetworkClient2, @IOContext CoroutineContext coroutineContext, Logger logger2) {
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.stripeNetworkClient = stripeNetworkClient2;
        this.workContext = coroutineContext;
        this.logger = logger2;
    }

    public DefaultAnalyticsRequestExecutor() {
        this(Logger.Companion.noop(), Dispatchers.getIO());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public DefaultAnalyticsRequestExecutor(Logger logger2, @IOContext CoroutineContext coroutineContext) {
        this(new DefaultStripeNetworkClient(coroutineContext, (ConnectionFactory) null, (RetryDelaySupplier) null, 0, logger2, 14, (DefaultConstructorMarker) null), coroutineContext, logger2);
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
    }

    public void executeAsync(AnalyticsRequest analyticsRequest) {
        Intrinsics.checkNotNullParameter(analyticsRequest, "request");
        this.logger.info(Intrinsics.stringPlus("Event: ", analyticsRequest.getParams().get("event")));
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new DefaultAnalyticsRequestExecutor$executeAsync$1(this, analyticsRequest, (Continuation<? super DefaultAnalyticsRequestExecutor$executeAsync$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/core/networking/DefaultAnalyticsRequestExecutor$Companion;", "", "()V", "FIELD_EVENT", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultAnalyticsRequestExecutor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

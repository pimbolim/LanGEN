package com.stripe.android.connections.analytics;

import com.stripe.android.connections.ConnectionsSheet;
import com.stripe.android.connections.ConnectionsSheetResult;
import com.stripe.android.connections.analytics.ConnectionsAnalyticsEvent;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.AnalyticsRequestFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/connections/analytics/DefaultConnectionsEventReporter;", "Lcom/stripe/android/connections/analytics/ConnectionsEventReporter;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "analyticsRequestFactory", "Lcom/stripe/android/core/networking/AnalyticsRequestFactory;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/core/networking/AnalyticsRequestFactory;Lkotlin/coroutines/CoroutineContext;)V", "fireEvent", "", "event", "Lcom/stripe/android/connections/analytics/ConnectionsAnalyticsEvent;", "onPresented", "configuration", "Lcom/stripe/android/connections/ConnectionsSheet$Configuration;", "onResult", "connectionsSheetResult", "Lcom/stripe/android/connections/ConnectionsSheetResult;", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultConnectionsEventReporter.kt */
public final class DefaultConnectionsEventReporter implements ConnectionsEventReporter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAM_CLIENT_SECRET = "las_client_secret";
    public static final String PARAM_SESSION_RESULT = "session_result";
    /* access modifiers changed from: private */
    public final AnalyticsRequestExecutor analyticsRequestExecutor;
    /* access modifiers changed from: private */
    public final AnalyticsRequestFactory analyticsRequestFactory;
    private final CoroutineContext workContext;

    @Inject
    public DefaultConnectionsEventReporter(AnalyticsRequestExecutor analyticsRequestExecutor2, AnalyticsRequestFactory analyticsRequestFactory2, @IOContext CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(analyticsRequestFactory2, "analyticsRequestFactory");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.analyticsRequestFactory = analyticsRequestFactory2;
        this.workContext = coroutineContext;
    }

    public void onPresented(ConnectionsSheet.Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        fireEvent(new ConnectionsAnalyticsEvent(ConnectionsAnalyticsEvent.Code.SheetPresented, MapsKt.mapOf(TuplesKt.to(PARAM_CLIENT_SECRET, configuration.getLinkAccountSessionClientSecret()))));
    }

    public void onResult(ConnectionsSheet.Configuration configuration, ConnectionsSheetResult connectionsSheetResult) {
        ConnectionsAnalyticsEvent connectionsAnalyticsEvent;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(connectionsSheetResult, "connectionsSheetResult");
        if (connectionsSheetResult instanceof ConnectionsSheetResult.Completed) {
            connectionsAnalyticsEvent = new ConnectionsAnalyticsEvent(ConnectionsAnalyticsEvent.Code.SheetClosed, MapsKt.mapOf(TuplesKt.to(PARAM_CLIENT_SECRET, configuration.getLinkAccountSessionClientSecret()), TuplesKt.to(PARAM_SESSION_RESULT, "completed")));
        } else if (connectionsSheetResult instanceof ConnectionsSheetResult.Canceled) {
            connectionsAnalyticsEvent = new ConnectionsAnalyticsEvent(ConnectionsAnalyticsEvent.Code.SheetClosed, MapsKt.mapOf(TuplesKt.to(PARAM_CLIENT_SECRET, configuration.getLinkAccountSessionClientSecret()), TuplesKt.to(PARAM_SESSION_RESULT, "cancelled")));
        } else if (connectionsSheetResult instanceof ConnectionsSheetResult.Failed) {
            connectionsAnalyticsEvent = new ConnectionsAnalyticsEvent(ConnectionsAnalyticsEvent.Code.SheetFailed, MapsKt.mapOf(TuplesKt.to(PARAM_CLIENT_SECRET, configuration.getLinkAccountSessionClientSecret()), TuplesKt.to(PARAM_SESSION_RESULT, "failure")));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        fireEvent(connectionsAnalyticsEvent);
    }

    private final void fireEvent(ConnectionsAnalyticsEvent connectionsAnalyticsEvent) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new DefaultConnectionsEventReporter$fireEvent$1(this, connectionsAnalyticsEvent, (Continuation<? super DefaultConnectionsEventReporter$fireEvent$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/analytics/DefaultConnectionsEventReporter$Companion;", "", "()V", "PARAM_CLIENT_SECRET", "", "PARAM_SESSION_RESULT", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultConnectionsEventReporter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

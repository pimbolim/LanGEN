package com.stripe.android.connections.analytics;

import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.AnalyticsRequestFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class DefaultConnectionsEventReporter_Factory implements Factory<DefaultConnectionsEventReporter> {
    private final Provider<AnalyticsRequestExecutor> analyticsRequestExecutorProvider;
    private final Provider<AnalyticsRequestFactory> analyticsRequestFactoryProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public DefaultConnectionsEventReporter_Factory(Provider<AnalyticsRequestExecutor> provider, Provider<AnalyticsRequestFactory> provider2, Provider<CoroutineContext> provider3) {
        this.analyticsRequestExecutorProvider = provider;
        this.analyticsRequestFactoryProvider = provider2;
        this.workContextProvider = provider3;
    }

    public DefaultConnectionsEventReporter get() {
        return newInstance(this.analyticsRequestExecutorProvider.get(), this.analyticsRequestFactoryProvider.get(), this.workContextProvider.get());
    }

    public static DefaultConnectionsEventReporter_Factory create(Provider<AnalyticsRequestExecutor> provider, Provider<AnalyticsRequestFactory> provider2, Provider<CoroutineContext> provider3) {
        return new DefaultConnectionsEventReporter_Factory(provider, provider2, provider3);
    }

    public static DefaultConnectionsEventReporter newInstance(AnalyticsRequestExecutor analyticsRequestExecutor, AnalyticsRequestFactory analyticsRequestFactory, CoroutineContext coroutineContext) {
        return new DefaultConnectionsEventReporter(analyticsRequestExecutor, analyticsRequestFactory, coroutineContext);
    }
}

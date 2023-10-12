package com.stripe.android.core.networking;

import com.stripe.android.core.Logger;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class DefaultAnalyticsRequestExecutor_Factory implements Factory<DefaultAnalyticsRequestExecutor> {
    private final Provider<Logger> loggerProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public DefaultAnalyticsRequestExecutor_Factory(Provider<Logger> provider, Provider<CoroutineContext> provider2) {
        this.loggerProvider = provider;
        this.workContextProvider = provider2;
    }

    public DefaultAnalyticsRequestExecutor get() {
        return newInstance(this.loggerProvider.get(), this.workContextProvider.get());
    }

    public static DefaultAnalyticsRequestExecutor_Factory create(Provider<Logger> provider, Provider<CoroutineContext> provider2) {
        return new DefaultAnalyticsRequestExecutor_Factory(provider, provider2);
    }

    public static DefaultAnalyticsRequestExecutor newInstance(Logger logger, CoroutineContext coroutineContext) {
        return new DefaultAnalyticsRequestExecutor(logger, coroutineContext);
    }
}

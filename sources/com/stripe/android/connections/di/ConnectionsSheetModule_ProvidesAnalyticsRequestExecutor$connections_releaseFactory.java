package com.stripe.android.connections.di;

import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ConnectionsSheetModule_ProvidesAnalyticsRequestExecutor$connections_releaseFactory implements Factory<AnalyticsRequestExecutor> {
    private final Provider<DefaultAnalyticsRequestExecutor> executorProvider;

    public ConnectionsSheetModule_ProvidesAnalyticsRequestExecutor$connections_releaseFactory(Provider<DefaultAnalyticsRequestExecutor> provider) {
        this.executorProvider = provider;
    }

    public AnalyticsRequestExecutor get() {
        return providesAnalyticsRequestExecutor$connections_release(this.executorProvider.get());
    }

    public static ConnectionsSheetModule_ProvidesAnalyticsRequestExecutor$connections_releaseFactory create(Provider<DefaultAnalyticsRequestExecutor> provider) {
        return new ConnectionsSheetModule_ProvidesAnalyticsRequestExecutor$connections_releaseFactory(provider);
    }

    public static AnalyticsRequestExecutor providesAnalyticsRequestExecutor$connections_release(DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor) {
        return (AnalyticsRequestExecutor) Preconditions.checkNotNullFromProvides(ConnectionsSheetModule.INSTANCE.providesAnalyticsRequestExecutor$connections_release(defaultAnalyticsRequestExecutor));
    }
}

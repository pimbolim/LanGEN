package com.stripe.android.connections.di;

import android.app.Application;
import com.stripe.android.core.networking.AnalyticsRequestFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ConnectionsSheetModule_ProvideAnalyticsRequestFactory$connections_releaseFactory implements Factory<AnalyticsRequestFactory> {
    private final Provider<Application> applicationProvider;
    private final Provider<String> publishableKeyProvider;

    public ConnectionsSheetModule_ProvideAnalyticsRequestFactory$connections_releaseFactory(Provider<Application> provider, Provider<String> provider2) {
        this.applicationProvider = provider;
        this.publishableKeyProvider = provider2;
    }

    public AnalyticsRequestFactory get() {
        return provideAnalyticsRequestFactory$connections_release(this.applicationProvider.get(), this.publishableKeyProvider.get());
    }

    public static ConnectionsSheetModule_ProvideAnalyticsRequestFactory$connections_releaseFactory create(Provider<Application> provider, Provider<String> provider2) {
        return new ConnectionsSheetModule_ProvideAnalyticsRequestFactory$connections_releaseFactory(provider, provider2);
    }

    public static AnalyticsRequestFactory provideAnalyticsRequestFactory$connections_release(Application application, String str) {
        return (AnalyticsRequestFactory) Preconditions.checkNotNullFromProvides(ConnectionsSheetModule.INSTANCE.provideAnalyticsRequestFactory$connections_release(application, str));
    }
}

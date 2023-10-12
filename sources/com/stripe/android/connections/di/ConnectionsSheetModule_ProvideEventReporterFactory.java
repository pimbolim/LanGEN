package com.stripe.android.connections.di;

import com.stripe.android.connections.analytics.ConnectionsEventReporter;
import com.stripe.android.connections.analytics.DefaultConnectionsEventReporter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ConnectionsSheetModule_ProvideEventReporterFactory implements Factory<ConnectionsEventReporter> {
    private final Provider<DefaultConnectionsEventReporter> defaultConnectionsEventReporterProvider;

    public ConnectionsSheetModule_ProvideEventReporterFactory(Provider<DefaultConnectionsEventReporter> provider) {
        this.defaultConnectionsEventReporterProvider = provider;
    }

    public ConnectionsEventReporter get() {
        return provideEventReporter(this.defaultConnectionsEventReporterProvider.get());
    }

    public static ConnectionsSheetModule_ProvideEventReporterFactory create(Provider<DefaultConnectionsEventReporter> provider) {
        return new ConnectionsSheetModule_ProvideEventReporterFactory(provider);
    }

    public static ConnectionsEventReporter provideEventReporter(DefaultConnectionsEventReporter defaultConnectionsEventReporter) {
        return (ConnectionsEventReporter) Preconditions.checkNotNullFromProvides(ConnectionsSheetModule.INSTANCE.provideEventReporter(defaultConnectionsEventReporter));
    }
}

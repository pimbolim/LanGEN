package com.stripe.android.connections.di;

import com.stripe.android.connections.ConnectionsSheet;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ConnectionsSheetConfigurationModule_ProvidesPublishableKeyFactory implements Factory<String> {
    private final Provider<ConnectionsSheet.Configuration> configurationProvider;

    public ConnectionsSheetConfigurationModule_ProvidesPublishableKeyFactory(Provider<ConnectionsSheet.Configuration> provider) {
        this.configurationProvider = provider;
    }

    public String get() {
        return providesPublishableKey(this.configurationProvider.get());
    }

    public static ConnectionsSheetConfigurationModule_ProvidesPublishableKeyFactory create(Provider<ConnectionsSheet.Configuration> provider) {
        return new ConnectionsSheetConfigurationModule_ProvidesPublishableKeyFactory(provider);
    }

    public static String providesPublishableKey(ConnectionsSheet.Configuration configuration) {
        return (String) Preconditions.checkNotNullFromProvides(ConnectionsSheetConfigurationModule.INSTANCE.providesPublishableKey(configuration));
    }
}

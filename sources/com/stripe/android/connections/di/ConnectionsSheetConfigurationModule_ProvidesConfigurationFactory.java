package com.stripe.android.connections.di;

import com.stripe.android.connections.ConnectionsSheet;
import com.stripe.android.connections.ConnectionsSheetContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ConnectionsSheetConfigurationModule_ProvidesConfigurationFactory implements Factory<ConnectionsSheet.Configuration> {
    private final Provider<ConnectionsSheetContract.Args> argsProvider;

    public ConnectionsSheetConfigurationModule_ProvidesConfigurationFactory(Provider<ConnectionsSheetContract.Args> provider) {
        this.argsProvider = provider;
    }

    public ConnectionsSheet.Configuration get() {
        return providesConfiguration(this.argsProvider.get());
    }

    public static ConnectionsSheetConfigurationModule_ProvidesConfigurationFactory create(Provider<ConnectionsSheetContract.Args> provider) {
        return new ConnectionsSheetConfigurationModule_ProvidesConfigurationFactory(provider);
    }

    public static ConnectionsSheet.Configuration providesConfiguration(ConnectionsSheetContract.Args args) {
        return (ConnectionsSheet.Configuration) Preconditions.checkNotNullFromProvides(ConnectionsSheetConfigurationModule.INSTANCE.providesConfiguration(args));
    }
}

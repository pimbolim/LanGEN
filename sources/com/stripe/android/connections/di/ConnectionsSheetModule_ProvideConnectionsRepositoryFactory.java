package com.stripe.android.connections.di;

import com.stripe.android.connections.repository.ConnectionsApiRepository;
import com.stripe.android.connections.repository.ConnectionsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ConnectionsSheetModule_ProvideConnectionsRepositoryFactory implements Factory<ConnectionsRepository> {
    private final Provider<ConnectionsApiRepository> repositoryProvider;

    public ConnectionsSheetModule_ProvideConnectionsRepositoryFactory(Provider<ConnectionsApiRepository> provider) {
        this.repositoryProvider = provider;
    }

    public ConnectionsRepository get() {
        return provideConnectionsRepository(this.repositoryProvider.get());
    }

    public static ConnectionsSheetModule_ProvideConnectionsRepositoryFactory create(Provider<ConnectionsApiRepository> provider) {
        return new ConnectionsSheetModule_ProvideConnectionsRepositoryFactory(provider);
    }

    public static ConnectionsRepository provideConnectionsRepository(ConnectionsApiRepository connectionsApiRepository) {
        return (ConnectionsRepository) Preconditions.checkNotNullFromProvides(ConnectionsSheetModule.INSTANCE.provideConnectionsRepository(connectionsApiRepository));
    }
}

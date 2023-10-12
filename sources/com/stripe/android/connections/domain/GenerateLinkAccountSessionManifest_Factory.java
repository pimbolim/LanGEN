package com.stripe.android.connections.domain;

import com.stripe.android.connections.repository.ConnectionsRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GenerateLinkAccountSessionManifest_Factory implements Factory<GenerateLinkAccountSessionManifest> {
    private final Provider<ConnectionsRepository> connectionsRepositoryProvider;

    public GenerateLinkAccountSessionManifest_Factory(Provider<ConnectionsRepository> provider) {
        this.connectionsRepositoryProvider = provider;
    }

    public GenerateLinkAccountSessionManifest get() {
        return newInstance(this.connectionsRepositoryProvider.get());
    }

    public static GenerateLinkAccountSessionManifest_Factory create(Provider<ConnectionsRepository> provider) {
        return new GenerateLinkAccountSessionManifest_Factory(provider);
    }

    public static GenerateLinkAccountSessionManifest newInstance(ConnectionsRepository connectionsRepository) {
        return new GenerateLinkAccountSessionManifest(connectionsRepository);
    }
}

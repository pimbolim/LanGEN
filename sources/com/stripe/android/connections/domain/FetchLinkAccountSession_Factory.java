package com.stripe.android.connections.domain;

import com.stripe.android.connections.repository.ConnectionsRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FetchLinkAccountSession_Factory implements Factory<FetchLinkAccountSession> {
    private final Provider<ConnectionsRepository> connectionsRepositoryProvider;

    public FetchLinkAccountSession_Factory(Provider<ConnectionsRepository> provider) {
        this.connectionsRepositoryProvider = provider;
    }

    public FetchLinkAccountSession get() {
        return newInstance(this.connectionsRepositoryProvider.get());
    }

    public static FetchLinkAccountSession_Factory create(Provider<ConnectionsRepository> provider) {
        return new FetchLinkAccountSession_Factory(provider);
    }

    public static FetchLinkAccountSession newInstance(ConnectionsRepository connectionsRepository) {
        return new FetchLinkAccountSession(connectionsRepository);
    }
}

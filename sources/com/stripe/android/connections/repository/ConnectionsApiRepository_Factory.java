package com.stripe.android.connections.repository;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.StripeNetworkClient;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ConnectionsApiRepository_Factory implements Factory<ConnectionsApiRepository> {
    private final Provider<ApiRequest.Factory> apiRequestFactoryProvider;
    private final Provider<String> publishableKeyProvider;
    private final Provider<StripeNetworkClient> stripeNetworkClientProvider;

    public ConnectionsApiRepository_Factory(Provider<String> provider, Provider<StripeNetworkClient> provider2, Provider<ApiRequest.Factory> provider3) {
        this.publishableKeyProvider = provider;
        this.stripeNetworkClientProvider = provider2;
        this.apiRequestFactoryProvider = provider3;
    }

    public ConnectionsApiRepository get() {
        return newInstance(this.publishableKeyProvider.get(), this.stripeNetworkClientProvider.get(), this.apiRequestFactoryProvider.get());
    }

    public static ConnectionsApiRepository_Factory create(Provider<String> provider, Provider<StripeNetworkClient> provider2, Provider<ApiRequest.Factory> provider3) {
        return new ConnectionsApiRepository_Factory(provider, provider2, provider3);
    }

    public static ConnectionsApiRepository newInstance(String str, StripeNetworkClient stripeNetworkClient, ApiRequest.Factory factory) {
        return new ConnectionsApiRepository(str, stripeNetworkClient, factory);
    }
}

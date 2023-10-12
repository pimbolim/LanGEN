package com.stripe.android.connections.di;

import com.stripe.android.core.Logger;
import com.stripe.android.core.networking.StripeNetworkClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class ConnectionsSheetModule_ProvideStripeNetworkClientFactory implements Factory<StripeNetworkClient> {
    private final Provider<CoroutineContext> contextProvider;
    private final Provider<Logger> loggerProvider;

    public ConnectionsSheetModule_ProvideStripeNetworkClientFactory(Provider<CoroutineContext> provider, Provider<Logger> provider2) {
        this.contextProvider = provider;
        this.loggerProvider = provider2;
    }

    public StripeNetworkClient get() {
        return provideStripeNetworkClient(this.contextProvider.get(), this.loggerProvider.get());
    }

    public static ConnectionsSheetModule_ProvideStripeNetworkClientFactory create(Provider<CoroutineContext> provider, Provider<Logger> provider2) {
        return new ConnectionsSheetModule_ProvideStripeNetworkClientFactory(provider, provider2);
    }

    public static StripeNetworkClient provideStripeNetworkClient(CoroutineContext coroutineContext, Logger logger) {
        return (StripeNetworkClient) Preconditions.checkNotNullFromProvides(ConnectionsSheetModule.INSTANCE.provideStripeNetworkClient(coroutineContext, logger));
    }
}

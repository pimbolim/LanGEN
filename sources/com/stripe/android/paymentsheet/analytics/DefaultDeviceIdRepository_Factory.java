package com.stripe.android.paymentsheet.analytics;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class DefaultDeviceIdRepository_Factory implements Factory<DefaultDeviceIdRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public DefaultDeviceIdRepository_Factory(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        this.contextProvider = provider;
        this.workContextProvider = provider2;
    }

    public DefaultDeviceIdRepository get() {
        return newInstance(this.contextProvider.get(), this.workContextProvider.get());
    }

    public static DefaultDeviceIdRepository_Factory create(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        return new DefaultDeviceIdRepository_Factory(provider, provider2);
    }

    public static DefaultDeviceIdRepository newInstance(Context context, CoroutineContext coroutineContext) {
        return new DefaultDeviceIdRepository(context, coroutineContext);
    }
}

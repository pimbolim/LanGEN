package com.stripe.android.googlepaylauncher;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PaymentsClientFactory_Factory implements Factory<PaymentsClientFactory> {
    private final Provider<Context> contextProvider;

    public PaymentsClientFactory_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public PaymentsClientFactory get() {
        return newInstance(this.contextProvider.get());
    }

    public static PaymentsClientFactory_Factory create(Provider<Context> provider) {
        return new PaymentsClientFactory_Factory(provider);
    }

    public static PaymentsClientFactory newInstance(Context context) {
        return new PaymentsClientFactory(context);
    }
}

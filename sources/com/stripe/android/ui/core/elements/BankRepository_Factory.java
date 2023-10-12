package com.stripe.android.ui.core.elements;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BankRepository_Factory implements Factory<BankRepository> {
    private final Provider<Resources> resourcesProvider;

    public BankRepository_Factory(Provider<Resources> provider) {
        this.resourcesProvider = provider;
    }

    public BankRepository get() {
        return newInstance(this.resourcesProvider.get());
    }

    public static BankRepository_Factory create(Provider<Resources> provider) {
        return new BankRepository_Factory(provider);
    }

    public static BankRepository newInstance(Resources resources) {
        return new BankRepository(resources);
    }
}

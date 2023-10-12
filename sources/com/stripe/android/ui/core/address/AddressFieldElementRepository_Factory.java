package com.stripe.android.ui.core.address;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AddressFieldElementRepository_Factory implements Factory<AddressFieldElementRepository> {
    private final Provider<Resources> resourcesProvider;

    public AddressFieldElementRepository_Factory(Provider<Resources> provider) {
        this.resourcesProvider = provider;
    }

    public AddressFieldElementRepository get() {
        return newInstance(this.resourcesProvider.get());
    }

    public static AddressFieldElementRepository_Factory create(Provider<Resources> provider) {
        return new AddressFieldElementRepository_Factory(provider);
    }

    public static AddressFieldElementRepository newInstance(Resources resources) {
        return new AddressFieldElementRepository(resources);
    }
}

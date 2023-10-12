package com.stripe.android.link.account;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class CookieStore_Factory implements Factory<CookieStore> {
    private final Provider<EncryptedStore> storeProvider;

    public CookieStore_Factory(Provider<EncryptedStore> provider) {
        this.storeProvider = provider;
    }

    public CookieStore get() {
        return newInstance(this.storeProvider.get());
    }

    public static CookieStore_Factory create(Provider<EncryptedStore> provider) {
        return new CookieStore_Factory(provider);
    }

    public static CookieStore newInstance(EncryptedStore encryptedStore) {
        return new CookieStore(encryptedStore);
    }
}

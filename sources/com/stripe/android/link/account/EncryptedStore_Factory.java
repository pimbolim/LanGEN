package com.stripe.android.link.account;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class EncryptedStore_Factory implements Factory<EncryptedStore> {
    private final Provider<Context> contextProvider;

    public EncryptedStore_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public EncryptedStore get() {
        return newInstance(this.contextProvider.get());
    }

    public static EncryptedStore_Factory create(Provider<Context> provider) {
        return new EncryptedStore_Factory(provider);
    }

    public static EncryptedStore newInstance(Context context) {
        return new EncryptedStore(context);
    }
}

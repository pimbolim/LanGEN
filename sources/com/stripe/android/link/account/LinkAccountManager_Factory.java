package com.stripe.android.link.account;

import com.stripe.android.link.repositories.LinkRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LinkAccountManager_Factory implements Factory<LinkAccountManager> {
    private final Provider<CookieStore> cookieStoreProvider;
    private final Provider<LinkRepository> linkRepositoryProvider;

    public LinkAccountManager_Factory(Provider<LinkRepository> provider, Provider<CookieStore> provider2) {
        this.linkRepositoryProvider = provider;
        this.cookieStoreProvider = provider2;
    }

    public LinkAccountManager get() {
        return newInstance(this.linkRepositoryProvider.get(), this.cookieStoreProvider.get());
    }

    public static LinkAccountManager_Factory create(Provider<LinkRepository> provider, Provider<CookieStore> provider2) {
        return new LinkAccountManager_Factory(provider, provider2);
    }

    public static LinkAccountManager newInstance(LinkRepository linkRepository, CookieStore cookieStore) {
        return new LinkAccountManager(linkRepository, cookieStore);
    }
}

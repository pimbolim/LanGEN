package com.stripe.android.link;

import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.account.CookieStore;
import com.stripe.android.link.account.LinkAccountManager;
import com.stripe.android.link.confirmation.ConfirmationManager;
import com.stripe.android.link.model.Navigator;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.stripe.android.link.LinkActivityViewModel_Factory  reason: case insensitive filesystem */
public final class C0007LinkActivityViewModel_Factory implements Factory<LinkActivityViewModel> {
    private final Provider<LinkActivityContract.Args> argsProvider;
    private final Provider<ConfirmationManager> confirmationManagerProvider;
    private final Provider<CookieStore> cookieStoreProvider;
    private final Provider<LinkAccountManager> linkAccountManagerProvider;
    private final Provider<Navigator> navigatorProvider;

    public C0007LinkActivityViewModel_Factory(Provider<LinkActivityContract.Args> provider, Provider<LinkAccountManager> provider2, Provider<CookieStore> provider3, Provider<Navigator> provider4, Provider<ConfirmationManager> provider5) {
        this.argsProvider = provider;
        this.linkAccountManagerProvider = provider2;
        this.cookieStoreProvider = provider3;
        this.navigatorProvider = provider4;
        this.confirmationManagerProvider = provider5;
    }

    public LinkActivityViewModel get() {
        return newInstance(this.argsProvider.get(), this.linkAccountManagerProvider.get(), this.cookieStoreProvider.get(), this.navigatorProvider.get(), this.confirmationManagerProvider.get());
    }

    public static C0007LinkActivityViewModel_Factory create(Provider<LinkActivityContract.Args> provider, Provider<LinkAccountManager> provider2, Provider<CookieStore> provider3, Provider<Navigator> provider4, Provider<ConfirmationManager> provider5) {
        return new C0007LinkActivityViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LinkActivityViewModel newInstance(LinkActivityContract.Args args, LinkAccountManager linkAccountManager, CookieStore cookieStore, Navigator navigator, ConfirmationManager confirmationManager) {
        return new LinkActivityViewModel(args, linkAccountManager, cookieStore, navigator, confirmationManager);
    }
}

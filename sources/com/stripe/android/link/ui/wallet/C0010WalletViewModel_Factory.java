package com.stripe.android.link.ui.wallet;

import com.stripe.android.core.Logger;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.account.LinkAccountManager;
import com.stripe.android.link.confirmation.ConfirmationManager;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.model.Navigator;
import com.stripe.android.link.repositories.LinkRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.stripe.android.link.ui.wallet.WalletViewModel_Factory  reason: case insensitive filesystem */
public final class C0010WalletViewModel_Factory implements Factory<WalletViewModel> {
    private final Provider<LinkActivityContract.Args> argsProvider;
    private final Provider<ConfirmationManager> confirmationManagerProvider;
    private final Provider<LinkAccountManager> linkAccountManagerProvider;
    private final Provider<LinkAccount> linkAccountProvider;
    private final Provider<LinkRepository> linkRepositoryProvider;
    private final Provider<Logger> loggerProvider;
    private final Provider<Navigator> navigatorProvider;

    public C0010WalletViewModel_Factory(Provider<LinkActivityContract.Args> provider, Provider<LinkAccount> provider2, Provider<LinkRepository> provider3, Provider<LinkAccountManager> provider4, Provider<Navigator> provider5, Provider<ConfirmationManager> provider6, Provider<Logger> provider7) {
        this.argsProvider = provider;
        this.linkAccountProvider = provider2;
        this.linkRepositoryProvider = provider3;
        this.linkAccountManagerProvider = provider4;
        this.navigatorProvider = provider5;
        this.confirmationManagerProvider = provider6;
        this.loggerProvider = provider7;
    }

    public WalletViewModel get() {
        return newInstance(this.argsProvider.get(), this.linkAccountProvider.get(), this.linkRepositoryProvider.get(), this.linkAccountManagerProvider.get(), this.navigatorProvider.get(), this.confirmationManagerProvider.get(), this.loggerProvider.get());
    }

    public static C0010WalletViewModel_Factory create(Provider<LinkActivityContract.Args> provider, Provider<LinkAccount> provider2, Provider<LinkRepository> provider3, Provider<LinkAccountManager> provider4, Provider<Navigator> provider5, Provider<ConfirmationManager> provider6, Provider<Logger> provider7) {
        return new C0010WalletViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static WalletViewModel newInstance(LinkActivityContract.Args args, LinkAccount linkAccount, LinkRepository linkRepository, LinkAccountManager linkAccountManager, Navigator navigator, ConfirmationManager confirmationManager, Logger logger) {
        return new WalletViewModel(args, linkAccount, linkRepository, linkAccountManager, navigator, confirmationManager, logger);
    }
}

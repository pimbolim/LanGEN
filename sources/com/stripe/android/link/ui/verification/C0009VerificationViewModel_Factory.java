package com.stripe.android.link.ui.verification;

import com.stripe.android.core.Logger;
import com.stripe.android.link.account.LinkAccountManager;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.model.Navigator;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.stripe.android.link.ui.verification.VerificationViewModel_Factory  reason: case insensitive filesystem */
public final class C0009VerificationViewModel_Factory implements Factory<VerificationViewModel> {
    private final Provider<LinkAccountManager> linkAccountManagerProvider;
    private final Provider<LinkAccount> linkAccountProvider;
    private final Provider<Logger> loggerProvider;
    private final Provider<Navigator> navigatorProvider;

    public C0009VerificationViewModel_Factory(Provider<LinkAccountManager> provider, Provider<Navigator> provider2, Provider<Logger> provider3, Provider<LinkAccount> provider4) {
        this.linkAccountManagerProvider = provider;
        this.navigatorProvider = provider2;
        this.loggerProvider = provider3;
        this.linkAccountProvider = provider4;
    }

    public VerificationViewModel get() {
        return newInstance(this.linkAccountManagerProvider.get(), this.navigatorProvider.get(), this.loggerProvider.get(), this.linkAccountProvider.get());
    }

    public static C0009VerificationViewModel_Factory create(Provider<LinkAccountManager> provider, Provider<Navigator> provider2, Provider<Logger> provider3, Provider<LinkAccount> provider4) {
        return new C0009VerificationViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static VerificationViewModel newInstance(LinkAccountManager linkAccountManager, Navigator navigator, Logger logger, LinkAccount linkAccount) {
        return new VerificationViewModel(linkAccountManager, navigator, logger, linkAccount);
    }
}

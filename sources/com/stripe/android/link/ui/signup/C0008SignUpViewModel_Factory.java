package com.stripe.android.link.ui.signup;

import com.stripe.android.core.Logger;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.account.LinkAccountManager;
import com.stripe.android.link.model.Navigator;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.stripe.android.link.ui.signup.SignUpViewModel_Factory  reason: case insensitive filesystem */
public final class C0008SignUpViewModel_Factory implements Factory<SignUpViewModel> {
    private final Provider<LinkActivityContract.Args> argsProvider;
    private final Provider<LinkAccountManager> linkAccountManagerProvider;
    private final Provider<Logger> loggerProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<String> prefilledEmailProvider;

    public C0008SignUpViewModel_Factory(Provider<LinkActivityContract.Args> provider, Provider<String> provider2, Provider<LinkAccountManager> provider3, Provider<Navigator> provider4, Provider<Logger> provider5) {
        this.argsProvider = provider;
        this.prefilledEmailProvider = provider2;
        this.linkAccountManagerProvider = provider3;
        this.navigatorProvider = provider4;
        this.loggerProvider = provider5;
    }

    public SignUpViewModel get() {
        return newInstance(this.argsProvider.get(), this.prefilledEmailProvider.get(), this.linkAccountManagerProvider.get(), this.navigatorProvider.get(), this.loggerProvider.get());
    }

    public static C0008SignUpViewModel_Factory create(Provider<LinkActivityContract.Args> provider, Provider<String> provider2, Provider<LinkAccountManager> provider3, Provider<Navigator> provider4, Provider<Logger> provider5) {
        return new C0008SignUpViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SignUpViewModel newInstance(LinkActivityContract.Args args, String str, LinkAccountManager linkAccountManager, Navigator navigator, Logger logger) {
        return new SignUpViewModel(args, str, linkAccountManager, navigator, logger);
    }
}

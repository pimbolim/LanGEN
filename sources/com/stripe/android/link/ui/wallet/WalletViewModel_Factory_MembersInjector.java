package com.stripe.android.link.ui.wallet;

import com.stripe.android.link.injection.SignedInViewModelSubcomponent;
import com.stripe.android.link.ui.wallet.WalletViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class WalletViewModel_Factory_MembersInjector implements MembersInjector<WalletViewModel.Factory> {
    private final Provider<SignedInViewModelSubcomponent.Builder> subComponentBuilderProvider;

    public WalletViewModel_Factory_MembersInjector(Provider<SignedInViewModelSubcomponent.Builder> provider) {
        this.subComponentBuilderProvider = provider;
    }

    public static MembersInjector<WalletViewModel.Factory> create(Provider<SignedInViewModelSubcomponent.Builder> provider) {
        return new WalletViewModel_Factory_MembersInjector(provider);
    }

    public void injectMembers(WalletViewModel.Factory factory) {
        injectSubComponentBuilderProvider(factory, this.subComponentBuilderProvider);
    }

    public static void injectSubComponentBuilderProvider(WalletViewModel.Factory factory, Provider<SignedInViewModelSubcomponent.Builder> provider) {
        factory.subComponentBuilderProvider = provider;
    }
}

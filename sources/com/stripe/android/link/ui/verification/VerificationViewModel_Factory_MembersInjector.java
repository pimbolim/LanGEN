package com.stripe.android.link.ui.verification;

import com.stripe.android.link.injection.SignedInViewModelSubcomponent;
import com.stripe.android.link.ui.verification.VerificationViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class VerificationViewModel_Factory_MembersInjector implements MembersInjector<VerificationViewModel.Factory> {
    private final Provider<SignedInViewModelSubcomponent.Builder> subComponentBuilderProvider;

    public VerificationViewModel_Factory_MembersInjector(Provider<SignedInViewModelSubcomponent.Builder> provider) {
        this.subComponentBuilderProvider = provider;
    }

    public static MembersInjector<VerificationViewModel.Factory> create(Provider<SignedInViewModelSubcomponent.Builder> provider) {
        return new VerificationViewModel_Factory_MembersInjector(provider);
    }

    public void injectMembers(VerificationViewModel.Factory factory) {
        injectSubComponentBuilderProvider(factory, this.subComponentBuilderProvider);
    }

    public static void injectSubComponentBuilderProvider(VerificationViewModel.Factory factory, Provider<SignedInViewModelSubcomponent.Builder> provider) {
        factory.subComponentBuilderProvider = provider;
    }
}

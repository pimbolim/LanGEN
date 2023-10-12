package com.stripe.android.link.ui.signup;

import com.stripe.android.link.injection.SignUpViewModelSubcomponent;
import com.stripe.android.link.ui.signup.SignUpViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SignUpViewModel_Factory_MembersInjector implements MembersInjector<SignUpViewModel.Factory> {
    private final Provider<SignUpViewModelSubcomponent.Builder> subComponentBuilderProvider;

    public SignUpViewModel_Factory_MembersInjector(Provider<SignUpViewModelSubcomponent.Builder> provider) {
        this.subComponentBuilderProvider = provider;
    }

    public static MembersInjector<SignUpViewModel.Factory> create(Provider<SignUpViewModelSubcomponent.Builder> provider) {
        return new SignUpViewModel_Factory_MembersInjector(provider);
    }

    public void injectMembers(SignUpViewModel.Factory factory) {
        injectSubComponentBuilderProvider(factory, this.subComponentBuilderProvider);
    }

    public static void injectSubComponentBuilderProvider(SignUpViewModel.Factory factory, Provider<SignUpViewModelSubcomponent.Builder> provider) {
        factory.subComponentBuilderProvider = provider;
    }
}

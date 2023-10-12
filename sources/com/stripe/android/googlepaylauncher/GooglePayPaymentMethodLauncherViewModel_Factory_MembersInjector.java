package com.stripe.android.googlepaylauncher;

import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherViewModelSubcomponent;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class GooglePayPaymentMethodLauncherViewModel_Factory_MembersInjector implements MembersInjector<GooglePayPaymentMethodLauncherViewModel.Factory> {
    private final Provider<GooglePayPaymentMethodLauncherViewModelSubcomponent.Builder> subComponentBuilderProvider;

    public GooglePayPaymentMethodLauncherViewModel_Factory_MembersInjector(Provider<GooglePayPaymentMethodLauncherViewModelSubcomponent.Builder> provider) {
        this.subComponentBuilderProvider = provider;
    }

    public static MembersInjector<GooglePayPaymentMethodLauncherViewModel.Factory> create(Provider<GooglePayPaymentMethodLauncherViewModelSubcomponent.Builder> provider) {
        return new GooglePayPaymentMethodLauncherViewModel_Factory_MembersInjector(provider);
    }

    public void injectMembers(GooglePayPaymentMethodLauncherViewModel.Factory factory) {
        injectSubComponentBuilder(factory, this.subComponentBuilderProvider.get());
    }

    public static void injectSubComponentBuilder(GooglePayPaymentMethodLauncherViewModel.Factory factory, GooglePayPaymentMethodLauncherViewModelSubcomponent.Builder builder) {
        factory.subComponentBuilder = builder;
    }
}

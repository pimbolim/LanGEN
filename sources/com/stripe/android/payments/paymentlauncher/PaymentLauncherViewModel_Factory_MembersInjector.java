package com.stripe.android.payments.paymentlauncher;

import com.stripe.android.payments.core.injection.PaymentLauncherViewModelSubcomponent;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PaymentLauncherViewModel_Factory_MembersInjector implements MembersInjector<PaymentLauncherViewModel.Factory> {
    private final Provider<PaymentLauncherViewModelSubcomponent.Builder> subComponentBuilderProvider;

    public PaymentLauncherViewModel_Factory_MembersInjector(Provider<PaymentLauncherViewModelSubcomponent.Builder> provider) {
        this.subComponentBuilderProvider = provider;
    }

    public static MembersInjector<PaymentLauncherViewModel.Factory> create(Provider<PaymentLauncherViewModelSubcomponent.Builder> provider) {
        return new PaymentLauncherViewModel_Factory_MembersInjector(provider);
    }

    public void injectMembers(PaymentLauncherViewModel.Factory factory) {
        injectSubComponentBuilderProvider(factory, this.subComponentBuilderProvider);
    }

    public static void injectSubComponentBuilderProvider(PaymentLauncherViewModel.Factory factory, Provider<PaymentLauncherViewModelSubcomponent.Builder> provider) {
        factory.subComponentBuilderProvider = provider;
    }
}

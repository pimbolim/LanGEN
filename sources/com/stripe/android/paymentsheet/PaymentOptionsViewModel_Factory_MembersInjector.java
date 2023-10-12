package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import com.stripe.android.paymentsheet.injection.PaymentOptionsViewModelSubcomponent;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PaymentOptionsViewModel_Factory_MembersInjector implements MembersInjector<PaymentOptionsViewModel.Factory> {
    private final Provider<PaymentOptionsViewModelSubcomponent.Builder> subComponentBuilderProvider;

    public PaymentOptionsViewModel_Factory_MembersInjector(Provider<PaymentOptionsViewModelSubcomponent.Builder> provider) {
        this.subComponentBuilderProvider = provider;
    }

    public static MembersInjector<PaymentOptionsViewModel.Factory> create(Provider<PaymentOptionsViewModelSubcomponent.Builder> provider) {
        return new PaymentOptionsViewModel_Factory_MembersInjector(provider);
    }

    public void injectMembers(PaymentOptionsViewModel.Factory factory) {
        injectSubComponentBuilderProvider(factory, this.subComponentBuilderProvider);
    }

    public static void injectSubComponentBuilderProvider(PaymentOptionsViewModel.Factory factory, Provider<PaymentOptionsViewModelSubcomponent.Builder> provider) {
        factory.subComponentBuilderProvider = provider;
    }
}

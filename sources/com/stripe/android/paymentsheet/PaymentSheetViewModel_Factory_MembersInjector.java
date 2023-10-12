package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.PaymentSheetViewModel;
import com.stripe.android.paymentsheet.injection.PaymentSheetViewModelSubcomponent;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PaymentSheetViewModel_Factory_MembersInjector implements MembersInjector<PaymentSheetViewModel.Factory> {
    private final Provider<PaymentSheetViewModelSubcomponent.Builder> subComponentBuilderProvider;

    public PaymentSheetViewModel_Factory_MembersInjector(Provider<PaymentSheetViewModelSubcomponent.Builder> provider) {
        this.subComponentBuilderProvider = provider;
    }

    public static MembersInjector<PaymentSheetViewModel.Factory> create(Provider<PaymentSheetViewModelSubcomponent.Builder> provider) {
        return new PaymentSheetViewModel_Factory_MembersInjector(provider);
    }

    public void injectMembers(PaymentSheetViewModel.Factory factory) {
        injectSubComponentBuilderProvider(factory, this.subComponentBuilderProvider);
    }

    public static void injectSubComponentBuilderProvider(PaymentSheetViewModel.Factory factory, Provider<PaymentSheetViewModelSubcomponent.Builder> provider) {
        factory.subComponentBuilderProvider = provider;
    }
}

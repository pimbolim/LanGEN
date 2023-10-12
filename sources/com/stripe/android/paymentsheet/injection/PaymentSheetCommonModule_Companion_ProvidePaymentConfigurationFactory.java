package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import com.stripe.android.PaymentConfiguration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PaymentSheetCommonModule_Companion_ProvidePaymentConfigurationFactory implements Factory<PaymentConfiguration> {
    private final Provider<Context> appContextProvider;

    public PaymentSheetCommonModule_Companion_ProvidePaymentConfigurationFactory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    public PaymentConfiguration get() {
        return providePaymentConfiguration(this.appContextProvider.get());
    }

    public static PaymentSheetCommonModule_Companion_ProvidePaymentConfigurationFactory create(Provider<Context> provider) {
        return new PaymentSheetCommonModule_Companion_ProvidePaymentConfigurationFactory(provider);
    }

    public static PaymentConfiguration providePaymentConfiguration(Context context) {
        return (PaymentConfiguration) Preconditions.checkNotNullFromProvides(PaymentSheetCommonModule.Companion.providePaymentConfiguration(context));
    }
}

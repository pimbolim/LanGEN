package com.stripe.android.paymentsheet.injection;

import com.stripe.android.PaymentConfiguration;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;

public final class PaymentSheetCommonModule_Companion_ProvideStripeAccountIdFactory implements Factory<Function0<String>> {
    private final Provider<PaymentConfiguration> paymentConfigurationProvider;

    public PaymentSheetCommonModule_Companion_ProvideStripeAccountIdFactory(Provider<PaymentConfiguration> provider) {
        this.paymentConfigurationProvider = provider;
    }

    public Function0<String> get() {
        return provideStripeAccountId(DoubleCheck.lazy(this.paymentConfigurationProvider));
    }

    public static PaymentSheetCommonModule_Companion_ProvideStripeAccountIdFactory create(Provider<PaymentConfiguration> provider) {
        return new PaymentSheetCommonModule_Companion_ProvideStripeAccountIdFactory(provider);
    }

    public static Function0<String> provideStripeAccountId(Lazy<PaymentConfiguration> lazy) {
        return (Function0) Preconditions.checkNotNullFromProvides(PaymentSheetCommonModule.Companion.provideStripeAccountId(lazy));
    }
}

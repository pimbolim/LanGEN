package com.stripe.android.paymentsheet.injection;

import com.stripe.android.PaymentConfiguration;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;

public final class PaymentSheetCommonModule_Companion_ProvidePublishableKeyFactory implements Factory<Function0<String>> {
    private final Provider<PaymentConfiguration> paymentConfigurationProvider;

    public PaymentSheetCommonModule_Companion_ProvidePublishableKeyFactory(Provider<PaymentConfiguration> provider) {
        this.paymentConfigurationProvider = provider;
    }

    public Function0<String> get() {
        return providePublishableKey(DoubleCheck.lazy(this.paymentConfigurationProvider));
    }

    public static PaymentSheetCommonModule_Companion_ProvidePublishableKeyFactory create(Provider<PaymentConfiguration> provider) {
        return new PaymentSheetCommonModule_Companion_ProvidePublishableKeyFactory(provider);
    }

    public static Function0<String> providePublishableKey(Lazy<PaymentConfiguration> lazy) {
        return (Function0) Preconditions.checkNotNullFromProvides(PaymentSheetCommonModule.Companion.providePublishableKey(lazy));
    }
}

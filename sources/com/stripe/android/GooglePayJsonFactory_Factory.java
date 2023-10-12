package com.stripe.android;

import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;

public final class GooglePayJsonFactory_Factory implements Factory<GooglePayJsonFactory> {
    private final Provider<GooglePayPaymentMethodLauncher.Config> googlePayConfigProvider;
    private final Provider<Function0<String>> publishableKeyProvider;
    private final Provider<Function0<String>> stripeAccountIdProvider;

    public GooglePayJsonFactory_Factory(Provider<Function0<String>> provider, Provider<Function0<String>> provider2, Provider<GooglePayPaymentMethodLauncher.Config> provider3) {
        this.publishableKeyProvider = provider;
        this.stripeAccountIdProvider = provider2;
        this.googlePayConfigProvider = provider3;
    }

    public GooglePayJsonFactory get() {
        return newInstance(this.publishableKeyProvider.get(), this.stripeAccountIdProvider.get(), this.googlePayConfigProvider.get());
    }

    public static GooglePayJsonFactory_Factory create(Provider<Function0<String>> provider, Provider<Function0<String>> provider2, Provider<GooglePayPaymentMethodLauncher.Config> provider3) {
        return new GooglePayJsonFactory_Factory(provider, provider2, provider3);
    }

    public static GooglePayJsonFactory newInstance(Function0<String> function0, Function0<String> function02, GooglePayPaymentMethodLauncher.Config config) {
        return new GooglePayJsonFactory(function0, function02, config);
    }
}

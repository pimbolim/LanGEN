package com.stripe.android.googlepaylauncher.injection;

import android.content.Context;
import com.google.android.gms.wallet.PaymentsClient;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.PaymentsClientFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class GooglePayPaymentMethodLauncherModule_Companion_ProvidePaymentsClientFactory implements Factory<PaymentsClient> {
    private final Provider<Context> contextProvider;
    private final Provider<GooglePayPaymentMethodLauncher.Config> googlePayConfigProvider;
    private final Provider<PaymentsClientFactory> paymentsClientFactoryProvider;

    public GooglePayPaymentMethodLauncherModule_Companion_ProvidePaymentsClientFactory(Provider<Context> provider, Provider<GooglePayPaymentMethodLauncher.Config> provider2, Provider<PaymentsClientFactory> provider3) {
        this.contextProvider = provider;
        this.googlePayConfigProvider = provider2;
        this.paymentsClientFactoryProvider = provider3;
    }

    public PaymentsClient get() {
        return providePaymentsClient(this.contextProvider.get(), this.googlePayConfigProvider.get(), this.paymentsClientFactoryProvider.get());
    }

    public static GooglePayPaymentMethodLauncherModule_Companion_ProvidePaymentsClientFactory create(Provider<Context> provider, Provider<GooglePayPaymentMethodLauncher.Config> provider2, Provider<PaymentsClientFactory> provider3) {
        return new GooglePayPaymentMethodLauncherModule_Companion_ProvidePaymentsClientFactory(provider, provider2, provider3);
    }

    public static PaymentsClient providePaymentsClient(Context context, GooglePayPaymentMethodLauncher.Config config, PaymentsClientFactory paymentsClientFactory) {
        return (PaymentsClient) Preconditions.checkNotNullFromProvides(GooglePayPaymentMethodLauncherModule.Companion.providePaymentsClient(context, config, paymentsClientFactory));
    }
}

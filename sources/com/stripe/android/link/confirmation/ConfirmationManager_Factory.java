package com.stripe.android.link.confirmation;

import com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;

public final class ConfirmationManager_Factory implements Factory<ConfirmationManager> {
    private final Provider<StripePaymentLauncherAssistedFactory> paymentLauncherFactoryProvider;
    private final Provider<Function0<String>> publishableKeyProvider;
    private final Provider<Function0<String>> stripeAccountIdProvider;

    public ConfirmationManager_Factory(Provider<StripePaymentLauncherAssistedFactory> provider, Provider<Function0<String>> provider2, Provider<Function0<String>> provider3) {
        this.paymentLauncherFactoryProvider = provider;
        this.publishableKeyProvider = provider2;
        this.stripeAccountIdProvider = provider3;
    }

    public ConfirmationManager get() {
        return newInstance(this.paymentLauncherFactoryProvider.get(), this.publishableKeyProvider.get(), this.stripeAccountIdProvider.get());
    }

    public static ConfirmationManager_Factory create(Provider<StripePaymentLauncherAssistedFactory> provider, Provider<Function0<String>> provider2, Provider<Function0<String>> provider3) {
        return new ConfirmationManager_Factory(provider, provider2, provider3);
    }

    public static ConfirmationManager newInstance(StripePaymentLauncherAssistedFactory stripePaymentLauncherAssistedFactory, Function0<String> function0, Function0<String> function02) {
        return new ConfirmationManager(stripePaymentLauncherAssistedFactory, function0, function02);
    }
}

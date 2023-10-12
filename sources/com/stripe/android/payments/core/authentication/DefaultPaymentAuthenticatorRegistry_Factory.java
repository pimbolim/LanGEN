package com.stripe.android.payments.core.authentication;

import com.stripe.android.model.StripeIntent;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

public final class DefaultPaymentAuthenticatorRegistry_Factory implements Factory<DefaultPaymentAuthenticatorRegistry> {
    private final Provider<NoOpIntentAuthenticator> noOpIntentAuthenticatorProvider;
    private final Provider<Map<Class<? extends StripeIntent.NextActionData>, PaymentAuthenticator<StripeIntent>>> paymentAuthenticatorMapProvider;
    private final Provider<SourceAuthenticator> sourceAuthenticatorProvider;

    public DefaultPaymentAuthenticatorRegistry_Factory(Provider<NoOpIntentAuthenticator> provider, Provider<SourceAuthenticator> provider2, Provider<Map<Class<? extends StripeIntent.NextActionData>, PaymentAuthenticator<StripeIntent>>> provider3) {
        this.noOpIntentAuthenticatorProvider = provider;
        this.sourceAuthenticatorProvider = provider2;
        this.paymentAuthenticatorMapProvider = provider3;
    }

    public DefaultPaymentAuthenticatorRegistry get() {
        return newInstance(this.noOpIntentAuthenticatorProvider.get(), this.sourceAuthenticatorProvider.get(), this.paymentAuthenticatorMapProvider.get());
    }

    public static DefaultPaymentAuthenticatorRegistry_Factory create(Provider<NoOpIntentAuthenticator> provider, Provider<SourceAuthenticator> provider2, Provider<Map<Class<? extends StripeIntent.NextActionData>, PaymentAuthenticator<StripeIntent>>> provider3) {
        return new DefaultPaymentAuthenticatorRegistry_Factory(provider, provider2, provider3);
    }

    public static DefaultPaymentAuthenticatorRegistry newInstance(NoOpIntentAuthenticator noOpIntentAuthenticator, SourceAuthenticator sourceAuthenticator, Map<Class<? extends StripeIntent.NextActionData>, PaymentAuthenticator<StripeIntent>> map) {
        return new DefaultPaymentAuthenticatorRegistry(noOpIntentAuthenticator, sourceAuthenticator, map);
    }
}

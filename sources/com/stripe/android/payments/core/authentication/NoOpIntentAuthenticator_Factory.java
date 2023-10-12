package com.stripe.android.payments.core.authentication;

import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.view.AuthActivityStarterHost;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.jvm.functions.Function1;

public final class NoOpIntentAuthenticator_Factory implements Factory<NoOpIntentAuthenticator> {
    private final Provider<Function1<AuthActivityStarterHost, PaymentRelayStarter>> paymentRelayStarterFactoryProvider;

    public NoOpIntentAuthenticator_Factory(Provider<Function1<AuthActivityStarterHost, PaymentRelayStarter>> provider) {
        this.paymentRelayStarterFactoryProvider = provider;
    }

    public NoOpIntentAuthenticator get() {
        return newInstance(this.paymentRelayStarterFactoryProvider.get());
    }

    public static NoOpIntentAuthenticator_Factory create(Provider<Function1<AuthActivityStarterHost, PaymentRelayStarter>> provider) {
        return new NoOpIntentAuthenticator_Factory(provider);
    }

    public static NoOpIntentAuthenticator newInstance(Function1<AuthActivityStarterHost, PaymentRelayStarter> function1) {
        return new NoOpIntentAuthenticator(function1);
    }
}

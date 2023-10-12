package com.stripe.android.payments.core.authentication;

import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.view.AuthActivityStarterHost;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.jvm.functions.Function1;

public final class UnsupportedAuthenticator_Factory implements Factory<UnsupportedAuthenticator> {
    private final Provider<Function1<AuthActivityStarterHost, PaymentRelayStarter>> paymentRelayStarterFactoryProvider;

    public UnsupportedAuthenticator_Factory(Provider<Function1<AuthActivityStarterHost, PaymentRelayStarter>> provider) {
        this.paymentRelayStarterFactoryProvider = provider;
    }

    public UnsupportedAuthenticator get() {
        return newInstance(this.paymentRelayStarterFactoryProvider.get());
    }

    public static UnsupportedAuthenticator_Factory create(Provider<Function1<AuthActivityStarterHost, PaymentRelayStarter>> provider) {
        return new UnsupportedAuthenticator_Factory(provider);
    }

    public static UnsupportedAuthenticator newInstance(Function1<AuthActivityStarterHost, PaymentRelayStarter> function1) {
        return new UnsupportedAuthenticator(function1);
    }
}

package com.stripe.android.payments.core.injection;

import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.payments.core.authentication.DefaultPaymentAuthenticatorRegistry;
import com.stripe.android.view.AuthActivityStarterHost;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.functions.Function1;

public final class AuthenticationModule_Companion_ProvidePaymentRelayStarterFactoryFactory implements Factory<Function1<AuthActivityStarterHost, PaymentRelayStarter>> {
    private final Provider<DefaultPaymentAuthenticatorRegistry> registryProvider;

    public AuthenticationModule_Companion_ProvidePaymentRelayStarterFactoryFactory(Provider<DefaultPaymentAuthenticatorRegistry> provider) {
        this.registryProvider = provider;
    }

    public Function1<AuthActivityStarterHost, PaymentRelayStarter> get() {
        return providePaymentRelayStarterFactory(DoubleCheck.lazy(this.registryProvider));
    }

    public static AuthenticationModule_Companion_ProvidePaymentRelayStarterFactoryFactory create(Provider<DefaultPaymentAuthenticatorRegistry> provider) {
        return new AuthenticationModule_Companion_ProvidePaymentRelayStarterFactoryFactory(provider);
    }

    public static Function1<AuthActivityStarterHost, PaymentRelayStarter> providePaymentRelayStarterFactory(Lazy<DefaultPaymentAuthenticatorRegistry> lazy) {
        return (Function1) Preconditions.checkNotNullFromProvides(AuthenticationModule.Companion.providePaymentRelayStarterFactory(lazy));
    }
}

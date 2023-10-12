package com.stripe.android.payments.core.injection;

import com.stripe.android.PaymentBrowserAuthStarter;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.core.authentication.DefaultPaymentAuthenticatorRegistry;
import com.stripe.android.view.AuthActivityStarterHost;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.functions.Function1;

public final class AuthenticationModule_Companion_ProvidePaymentBrowserAuthStarterFactoryFactory implements Factory<Function1<AuthActivityStarterHost, PaymentBrowserAuthStarter>> {
    private final Provider<DefaultReturnUrl> defaultReturnUrlProvider;
    private final Provider<DefaultPaymentAuthenticatorRegistry> registryProvider;

    public AuthenticationModule_Companion_ProvidePaymentBrowserAuthStarterFactoryFactory(Provider<DefaultPaymentAuthenticatorRegistry> provider, Provider<DefaultReturnUrl> provider2) {
        this.registryProvider = provider;
        this.defaultReturnUrlProvider = provider2;
    }

    public Function1<AuthActivityStarterHost, PaymentBrowserAuthStarter> get() {
        return providePaymentBrowserAuthStarterFactory(DoubleCheck.lazy(this.registryProvider), this.defaultReturnUrlProvider.get());
    }

    public static AuthenticationModule_Companion_ProvidePaymentBrowserAuthStarterFactoryFactory create(Provider<DefaultPaymentAuthenticatorRegistry> provider, Provider<DefaultReturnUrl> provider2) {
        return new AuthenticationModule_Companion_ProvidePaymentBrowserAuthStarterFactoryFactory(provider, provider2);
    }

    public static Function1<AuthActivityStarterHost, PaymentBrowserAuthStarter> providePaymentBrowserAuthStarterFactory(Lazy<DefaultPaymentAuthenticatorRegistry> lazy, DefaultReturnUrl defaultReturnUrl) {
        return (Function1) Preconditions.checkNotNullFromProvides(AuthenticationModule.Companion.providePaymentBrowserAuthStarterFactory(lazy, defaultReturnUrl));
    }
}

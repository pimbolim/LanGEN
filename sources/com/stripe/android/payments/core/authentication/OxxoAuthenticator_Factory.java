package com.stripe.android.payments.core.authentication;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class OxxoAuthenticator_Factory implements Factory<OxxoAuthenticator> {
    private final Provider<NoOpIntentAuthenticator> noOpIntentAuthenticatorProvider;
    private final Provider<WebIntentAuthenticator> webIntentAuthenticatorProvider;

    public OxxoAuthenticator_Factory(Provider<WebIntentAuthenticator> provider, Provider<NoOpIntentAuthenticator> provider2) {
        this.webIntentAuthenticatorProvider = provider;
        this.noOpIntentAuthenticatorProvider = provider2;
    }

    public OxxoAuthenticator get() {
        return newInstance(this.webIntentAuthenticatorProvider.get(), this.noOpIntentAuthenticatorProvider.get());
    }

    public static OxxoAuthenticator_Factory create(Provider<WebIntentAuthenticator> provider, Provider<NoOpIntentAuthenticator> provider2) {
        return new OxxoAuthenticator_Factory(provider, provider2);
    }

    public static OxxoAuthenticator newInstance(WebIntentAuthenticator webIntentAuthenticator, NoOpIntentAuthenticator noOpIntentAuthenticator) {
        return new OxxoAuthenticator(webIntentAuthenticator, noOpIntentAuthenticator);
    }
}

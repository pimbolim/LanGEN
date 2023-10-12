package com.stripe.android.payments.bankaccount.domain;

import com.stripe.android.networking.StripeRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AttachLinkAccountSession_Factory implements Factory<AttachLinkAccountSession> {
    private final Provider<StripeRepository> stripeRepositoryProvider;

    public AttachLinkAccountSession_Factory(Provider<StripeRepository> provider) {
        this.stripeRepositoryProvider = provider;
    }

    public AttachLinkAccountSession get() {
        return newInstance(this.stripeRepositoryProvider.get());
    }

    public static AttachLinkAccountSession_Factory create(Provider<StripeRepository> provider) {
        return new AttachLinkAccountSession_Factory(provider);
    }

    public static AttachLinkAccountSession newInstance(StripeRepository stripeRepository) {
        return new AttachLinkAccountSession(stripeRepository);
    }
}

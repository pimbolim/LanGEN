package com.stripe.android.payments.bankaccount.domain;

import com.stripe.android.networking.StripeRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CreateLinkAccountSession_Factory implements Factory<CreateLinkAccountSession> {
    private final Provider<StripeRepository> stripeRepositoryProvider;

    public CreateLinkAccountSession_Factory(Provider<StripeRepository> provider) {
        this.stripeRepositoryProvider = provider;
    }

    public CreateLinkAccountSession get() {
        return newInstance(this.stripeRepositoryProvider.get());
    }

    public static CreateLinkAccountSession_Factory create(Provider<StripeRepository> provider) {
        return new CreateLinkAccountSession_Factory(provider);
    }

    public static CreateLinkAccountSession newInstance(StripeRepository stripeRepository) {
        return new CreateLinkAccountSession(stripeRepository);
    }
}

package com.stripe.android.payments.bankaccount.domain;

import com.stripe.android.networking.StripeRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class VerifyWithMicrodeposit_Factory implements Factory<VerifyWithMicrodeposit> {
    private final Provider<StripeRepository> stripeRepositoryProvider;

    public VerifyWithMicrodeposit_Factory(Provider<StripeRepository> provider) {
        this.stripeRepositoryProvider = provider;
    }

    public VerifyWithMicrodeposit get() {
        return newInstance(this.stripeRepositoryProvider.get());
    }

    public static VerifyWithMicrodeposit_Factory create(Provider<StripeRepository> provider) {
        return new VerifyWithMicrodeposit_Factory(provider);
    }

    public static VerifyWithMicrodeposit newInstance(StripeRepository stripeRepository) {
        return new VerifyWithMicrodeposit(stripeRepository);
    }
}

package com.stripe.android.paymentsheet.repositories;

import com.stripe.android.PaymentConfiguration;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class StripeIntentRepository_Api_Factory implements Factory<StripeIntentRepository.Api> {
    private final Provider<Locale> localeProvider;
    private final Provider<PaymentConfiguration> paymentConfigProvider;
    private final Provider<StripeRepository> stripeRepositoryProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public StripeIntentRepository_Api_Factory(Provider<StripeRepository> provider, Provider<PaymentConfiguration> provider2, Provider<CoroutineContext> provider3, Provider<Locale> provider4) {
        this.stripeRepositoryProvider = provider;
        this.paymentConfigProvider = provider2;
        this.workContextProvider = provider3;
        this.localeProvider = provider4;
    }

    public StripeIntentRepository.Api get() {
        return newInstance(this.stripeRepositoryProvider.get(), DoubleCheck.lazy(this.paymentConfigProvider), this.workContextProvider.get(), this.localeProvider.get());
    }

    public static StripeIntentRepository_Api_Factory create(Provider<StripeRepository> provider, Provider<PaymentConfiguration> provider2, Provider<CoroutineContext> provider3, Provider<Locale> provider4) {
        return new StripeIntentRepository_Api_Factory(provider, provider2, provider3, provider4);
    }

    public static StripeIntentRepository.Api newInstance(StripeRepository stripeRepository, Lazy<PaymentConfiguration> lazy, CoroutineContext coroutineContext, Locale locale) {
        return new StripeIntentRepository.Api(stripeRepository, lazy, coroutineContext, locale);
    }
}

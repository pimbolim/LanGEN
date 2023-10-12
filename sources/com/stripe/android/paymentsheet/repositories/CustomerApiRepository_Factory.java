package com.stripe.android.paymentsheet.repositories;

import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.Logger;
import com.stripe.android.networking.StripeRepository;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class CustomerApiRepository_Factory implements Factory<CustomerApiRepository> {
    private final Provider<Logger> loggerProvider;
    private final Provider<PaymentConfiguration> paymentConfigProvider;
    private final Provider<Set<String>> productUsageTokensProvider;
    private final Provider<StripeRepository> stripeRepositoryProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public CustomerApiRepository_Factory(Provider<StripeRepository> provider, Provider<PaymentConfiguration> provider2, Provider<Logger> provider3, Provider<CoroutineContext> provider4, Provider<Set<String>> provider5) {
        this.stripeRepositoryProvider = provider;
        this.paymentConfigProvider = provider2;
        this.loggerProvider = provider3;
        this.workContextProvider = provider4;
        this.productUsageTokensProvider = provider5;
    }

    public CustomerApiRepository get() {
        return newInstance(this.stripeRepositoryProvider.get(), DoubleCheck.lazy(this.paymentConfigProvider), this.loggerProvider.get(), this.workContextProvider.get(), this.productUsageTokensProvider.get());
    }

    public static CustomerApiRepository_Factory create(Provider<StripeRepository> provider, Provider<PaymentConfiguration> provider2, Provider<Logger> provider3, Provider<CoroutineContext> provider4, Provider<Set<String>> provider5) {
        return new CustomerApiRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CustomerApiRepository newInstance(StripeRepository stripeRepository, Lazy<PaymentConfiguration> lazy, Logger logger, CoroutineContext coroutineContext, Set<String> set) {
        return new CustomerApiRepository(stripeRepository, lazy, logger, coroutineContext, set);
    }
}

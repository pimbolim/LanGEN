package com.stripe.android.payments.core.authentication.threeds2;

import com.stripe.android.core.Logger;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.RetryDelaySupplier;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class DefaultStripe3ds2ChallengeResultProcessor_Factory implements Factory<DefaultStripe3ds2ChallengeResultProcessor> {
    private final Provider<AnalyticsRequestExecutor> analyticsRequestExecutorProvider;
    private final Provider<Logger> loggerProvider;
    private final Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    private final Provider<RetryDelaySupplier> retryDelaySupplierProvider;
    private final Provider<StripeRepository> stripeRepositoryProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public DefaultStripe3ds2ChallengeResultProcessor_Factory(Provider<StripeRepository> provider, Provider<AnalyticsRequestExecutor> provider2, Provider<PaymentAnalyticsRequestFactory> provider3, Provider<RetryDelaySupplier> provider4, Provider<Logger> provider5, Provider<CoroutineContext> provider6) {
        this.stripeRepositoryProvider = provider;
        this.analyticsRequestExecutorProvider = provider2;
        this.paymentAnalyticsRequestFactoryProvider = provider3;
        this.retryDelaySupplierProvider = provider4;
        this.loggerProvider = provider5;
        this.workContextProvider = provider6;
    }

    public DefaultStripe3ds2ChallengeResultProcessor get() {
        return newInstance(this.stripeRepositoryProvider.get(), this.analyticsRequestExecutorProvider.get(), this.paymentAnalyticsRequestFactoryProvider.get(), this.retryDelaySupplierProvider.get(), this.loggerProvider.get(), this.workContextProvider.get());
    }

    public static DefaultStripe3ds2ChallengeResultProcessor_Factory create(Provider<StripeRepository> provider, Provider<AnalyticsRequestExecutor> provider2, Provider<PaymentAnalyticsRequestFactory> provider3, Provider<RetryDelaySupplier> provider4, Provider<Logger> provider5, Provider<CoroutineContext> provider6) {
        return new DefaultStripe3ds2ChallengeResultProcessor_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static DefaultStripe3ds2ChallengeResultProcessor newInstance(StripeRepository stripeRepository, AnalyticsRequestExecutor analyticsRequestExecutor, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, RetryDelaySupplier retryDelaySupplier, Logger logger, CoroutineContext coroutineContext) {
        return new DefaultStripe3ds2ChallengeResultProcessor(stripeRepository, analyticsRequestExecutor, paymentAnalyticsRequestFactory, retryDelaySupplier, logger, coroutineContext);
    }
}

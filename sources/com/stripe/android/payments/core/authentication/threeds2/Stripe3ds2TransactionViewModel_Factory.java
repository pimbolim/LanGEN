package com.stripe.android.payments.core.authentication.threeds2;

import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract;
import com.stripe.android.stripe3ds2.service.StripeThreeDs2Service;
import com.stripe.android.stripe3ds2.transaction.InitChallengeRepository;
import com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class Stripe3ds2TransactionViewModel_Factory implements Factory<Stripe3ds2TransactionViewModel> {
    private final Provider<AnalyticsRequestExecutor> analyticsRequestExecutorProvider;
    private final Provider<Stripe3ds2TransactionContract.Args> argsProvider;
    private final Provider<Stripe3ds2ChallengeResultProcessor> challengeResultProcessorProvider;
    private final Provider<InitChallengeRepository> initChallengeRepositoryProvider;
    private final Provider<Boolean> isInstantAppProvider;
    private final Provider<MessageVersionRegistry> messageVersionRegistryProvider;
    private final Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<StripeRepository> stripeRepositoryProvider;
    private final Provider<StripeThreeDs2Service> threeDs2ServiceProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public Stripe3ds2TransactionViewModel_Factory(Provider<Stripe3ds2TransactionContract.Args> provider, Provider<StripeRepository> provider2, Provider<AnalyticsRequestExecutor> provider3, Provider<PaymentAnalyticsRequestFactory> provider4, Provider<StripeThreeDs2Service> provider5, Provider<MessageVersionRegistry> provider6, Provider<Stripe3ds2ChallengeResultProcessor> provider7, Provider<InitChallengeRepository> provider8, Provider<CoroutineContext> provider9, Provider<SavedStateHandle> provider10, Provider<Boolean> provider11) {
        this.argsProvider = provider;
        this.stripeRepositoryProvider = provider2;
        this.analyticsRequestExecutorProvider = provider3;
        this.paymentAnalyticsRequestFactoryProvider = provider4;
        this.threeDs2ServiceProvider = provider5;
        this.messageVersionRegistryProvider = provider6;
        this.challengeResultProcessorProvider = provider7;
        this.initChallengeRepositoryProvider = provider8;
        this.workContextProvider = provider9;
        this.savedStateHandleProvider = provider10;
        this.isInstantAppProvider = provider11;
    }

    public Stripe3ds2TransactionViewModel get() {
        return newInstance(this.argsProvider.get(), this.stripeRepositoryProvider.get(), this.analyticsRequestExecutorProvider.get(), this.paymentAnalyticsRequestFactoryProvider.get(), this.threeDs2ServiceProvider.get(), this.messageVersionRegistryProvider.get(), this.challengeResultProcessorProvider.get(), this.initChallengeRepositoryProvider.get(), this.workContextProvider.get(), this.savedStateHandleProvider.get(), this.isInstantAppProvider.get().booleanValue());
    }

    public static Stripe3ds2TransactionViewModel_Factory create(Provider<Stripe3ds2TransactionContract.Args> provider, Provider<StripeRepository> provider2, Provider<AnalyticsRequestExecutor> provider3, Provider<PaymentAnalyticsRequestFactory> provider4, Provider<StripeThreeDs2Service> provider5, Provider<MessageVersionRegistry> provider6, Provider<Stripe3ds2ChallengeResultProcessor> provider7, Provider<InitChallengeRepository> provider8, Provider<CoroutineContext> provider9, Provider<SavedStateHandle> provider10, Provider<Boolean> provider11) {
        return new Stripe3ds2TransactionViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static Stripe3ds2TransactionViewModel newInstance(Stripe3ds2TransactionContract.Args args, StripeRepository stripeRepository, AnalyticsRequestExecutor analyticsRequestExecutor, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, StripeThreeDs2Service stripeThreeDs2Service, MessageVersionRegistry messageVersionRegistry, Stripe3ds2ChallengeResultProcessor stripe3ds2ChallengeResultProcessor, InitChallengeRepository initChallengeRepository, CoroutineContext coroutineContext, SavedStateHandle savedStateHandle, boolean z) {
        return new Stripe3ds2TransactionViewModel(args, stripeRepository, analyticsRequestExecutor, paymentAnalyticsRequestFactory, stripeThreeDs2Service, messageVersionRegistry, stripe3ds2ChallengeResultProcessor, initChallengeRepository, coroutineContext, savedStateHandle, z);
    }
}

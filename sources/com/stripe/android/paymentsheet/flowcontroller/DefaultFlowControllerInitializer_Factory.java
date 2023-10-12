package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.core.Logger;
import com.stripe.android.googlepaylauncher.GooglePayEnvironment;
import com.stripe.android.googlepaylauncher.GooglePayRepository;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PrefsRepository;
import com.stripe.android.paymentsheet.model.StripeIntentValidator;
import com.stripe.android.paymentsheet.repositories.CustomerRepository;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

public final class DefaultFlowControllerInitializer_Factory implements Factory<DefaultFlowControllerInitializer> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<Function1<GooglePayEnvironment, GooglePayRepository>> googlePayRepositoryFactoryProvider;
    private final Provider<Logger> loggerProvider;
    private final Provider<Function1<PaymentSheet.CustomerConfiguration, PrefsRepository>> prefsRepositoryFactoryProvider;
    private final Provider<StripeIntentRepository> stripeIntentRepositoryProvider;
    private final Provider<StripeIntentValidator> stripeIntentValidatorProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public DefaultFlowControllerInitializer_Factory(Provider<Function1<PaymentSheet.CustomerConfiguration, PrefsRepository>> provider, Provider<Function1<GooglePayEnvironment, GooglePayRepository>> provider2, Provider<StripeIntentRepository> provider3, Provider<StripeIntentValidator> provider4, Provider<CustomerRepository> provider5, Provider<Logger> provider6, Provider<CoroutineContext> provider7) {
        this.prefsRepositoryFactoryProvider = provider;
        this.googlePayRepositoryFactoryProvider = provider2;
        this.stripeIntentRepositoryProvider = provider3;
        this.stripeIntentValidatorProvider = provider4;
        this.customerRepositoryProvider = provider5;
        this.loggerProvider = provider6;
        this.workContextProvider = provider7;
    }

    public DefaultFlowControllerInitializer get() {
        return newInstance(this.prefsRepositoryFactoryProvider.get(), this.googlePayRepositoryFactoryProvider.get(), this.stripeIntentRepositoryProvider.get(), this.stripeIntentValidatorProvider.get(), this.customerRepositoryProvider.get(), this.loggerProvider.get(), this.workContextProvider.get());
    }

    public static DefaultFlowControllerInitializer_Factory create(Provider<Function1<PaymentSheet.CustomerConfiguration, PrefsRepository>> provider, Provider<Function1<GooglePayEnvironment, GooglePayRepository>> provider2, Provider<StripeIntentRepository> provider3, Provider<StripeIntentValidator> provider4, Provider<CustomerRepository> provider5, Provider<Logger> provider6, Provider<CoroutineContext> provider7) {
        return new DefaultFlowControllerInitializer_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static DefaultFlowControllerInitializer newInstance(Function1<PaymentSheet.CustomerConfiguration, PrefsRepository> function1, Function1<GooglePayEnvironment, GooglePayRepository> function12, StripeIntentRepository stripeIntentRepository, StripeIntentValidator stripeIntentValidator, CustomerRepository customerRepository, Logger logger, CoroutineContext coroutineContext) {
        return new DefaultFlowControllerInitializer(function1, function12, stripeIntentRepository, stripeIntentValidator, customerRepository, logger, coroutineContext);
    }
}

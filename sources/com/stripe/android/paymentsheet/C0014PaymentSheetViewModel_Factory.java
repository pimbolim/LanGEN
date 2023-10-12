package com.stripe.android.paymentsheet;

import android.app.Application;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.Logger;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherFactory;
import com.stripe.android.link.injection.LinkPaymentLauncherFactory;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory;
import com.stripe.android.paymentsheet.PaymentSheetContract;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.model.StripeIntentValidator;
import com.stripe.android.paymentsheet.repositories.CustomerRepository;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* renamed from: com.stripe.android.paymentsheet.PaymentSheetViewModel_Factory  reason: case insensitive filesystem */
public final class C0014PaymentSheetViewModel_Factory implements Factory<PaymentSheetViewModel> {
    private final Provider<Application> applicationProvider;
    private final Provider<PaymentSheetContract.Args> argsProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<EventReporter> eventReporterProvider;
    private final Provider<GooglePayPaymentMethodLauncherFactory> googlePayPaymentMethodLauncherFactoryProvider;
    private final Provider<String> injectorKeyProvider;
    private final Provider<LinkPaymentLauncherFactory> linkPaymentLauncherFactoryProvider;
    private final Provider<Logger> loggerProvider;
    private final Provider<PaymentConfiguration> paymentConfigProvider;
    private final Provider<StripePaymentLauncherAssistedFactory> paymentLauncherFactoryProvider;
    private final Provider<PrefsRepository> prefsRepositoryProvider;
    private final Provider<ResourceRepository> resourceRepositoryProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<StripeIntentRepository> stripeIntentRepositoryProvider;
    private final Provider<StripeIntentValidator> stripeIntentValidatorProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public C0014PaymentSheetViewModel_Factory(Provider<Application> provider, Provider<PaymentSheetContract.Args> provider2, Provider<EventReporter> provider3, Provider<PaymentConfiguration> provider4, Provider<StripeIntentRepository> provider5, Provider<StripeIntentValidator> provider6, Provider<CustomerRepository> provider7, Provider<PrefsRepository> provider8, Provider<ResourceRepository> provider9, Provider<StripePaymentLauncherAssistedFactory> provider10, Provider<GooglePayPaymentMethodLauncherFactory> provider11, Provider<Logger> provider12, Provider<CoroutineContext> provider13, Provider<String> provider14, Provider<SavedStateHandle> provider15, Provider<LinkPaymentLauncherFactory> provider16) {
        this.applicationProvider = provider;
        this.argsProvider = provider2;
        this.eventReporterProvider = provider3;
        this.paymentConfigProvider = provider4;
        this.stripeIntentRepositoryProvider = provider5;
        this.stripeIntentValidatorProvider = provider6;
        this.customerRepositoryProvider = provider7;
        this.prefsRepositoryProvider = provider8;
        this.resourceRepositoryProvider = provider9;
        this.paymentLauncherFactoryProvider = provider10;
        this.googlePayPaymentMethodLauncherFactoryProvider = provider11;
        this.loggerProvider = provider12;
        this.workContextProvider = provider13;
        this.injectorKeyProvider = provider14;
        this.savedStateHandleProvider = provider15;
        this.linkPaymentLauncherFactoryProvider = provider16;
    }

    public PaymentSheetViewModel get() {
        return newInstance(this.applicationProvider.get(), this.argsProvider.get(), this.eventReporterProvider.get(), DoubleCheck.lazy(this.paymentConfigProvider), this.stripeIntentRepositoryProvider.get(), this.stripeIntentValidatorProvider.get(), this.customerRepositoryProvider.get(), this.prefsRepositoryProvider.get(), this.resourceRepositoryProvider.get(), this.paymentLauncherFactoryProvider.get(), this.googlePayPaymentMethodLauncherFactoryProvider.get(), this.loggerProvider.get(), this.workContextProvider.get(), this.injectorKeyProvider.get(), this.savedStateHandleProvider.get(), this.linkPaymentLauncherFactoryProvider.get());
    }

    public static C0014PaymentSheetViewModel_Factory create(Provider<Application> provider, Provider<PaymentSheetContract.Args> provider2, Provider<EventReporter> provider3, Provider<PaymentConfiguration> provider4, Provider<StripeIntentRepository> provider5, Provider<StripeIntentValidator> provider6, Provider<CustomerRepository> provider7, Provider<PrefsRepository> provider8, Provider<ResourceRepository> provider9, Provider<StripePaymentLauncherAssistedFactory> provider10, Provider<GooglePayPaymentMethodLauncherFactory> provider11, Provider<Logger> provider12, Provider<CoroutineContext> provider13, Provider<String> provider14, Provider<SavedStateHandle> provider15, Provider<LinkPaymentLauncherFactory> provider16) {
        return new C0014PaymentSheetViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    public static PaymentSheetViewModel newInstance(Application application, PaymentSheetContract.Args args, EventReporter eventReporter, Lazy<PaymentConfiguration> lazy, StripeIntentRepository stripeIntentRepository, StripeIntentValidator stripeIntentValidator, CustomerRepository customerRepository, PrefsRepository prefsRepository, ResourceRepository resourceRepository, StripePaymentLauncherAssistedFactory stripePaymentLauncherAssistedFactory, GooglePayPaymentMethodLauncherFactory googlePayPaymentMethodLauncherFactory, Logger logger, CoroutineContext coroutineContext, String str, SavedStateHandle savedStateHandle, LinkPaymentLauncherFactory linkPaymentLauncherFactory) {
        return new PaymentSheetViewModel(application, args, eventReporter, lazy, stripeIntentRepository, stripeIntentValidator, customerRepository, prefsRepository, resourceRepository, stripePaymentLauncherAssistedFactory, googlePayPaymentMethodLauncherFactory, logger, coroutineContext, str, savedStateHandle, linkPaymentLauncherFactory);
    }
}

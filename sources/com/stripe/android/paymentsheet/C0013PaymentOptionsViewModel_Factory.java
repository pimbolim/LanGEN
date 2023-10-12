package com.stripe.android.paymentsheet;

import android.app.Application;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.core.Logger;
import com.stripe.android.link.injection.LinkPaymentLauncherFactory;
import com.stripe.android.paymentsheet.PaymentOptionContract;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.repositories.CustomerRepository;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* renamed from: com.stripe.android.paymentsheet.PaymentOptionsViewModel_Factory  reason: case insensitive filesystem */
public final class C0013PaymentOptionsViewModel_Factory implements Factory<PaymentOptionsViewModel> {
    private final Provider<Application> applicationProvider;
    private final Provider<PaymentOptionContract.Args> argsProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<EventReporter> eventReporterProvider;
    private final Provider<String> injectorKeyProvider;
    private final Provider<LinkPaymentLauncherFactory> linkPaymentLauncherFactoryProvider;
    private final Provider<Logger> loggerProvider;
    private final Provider<Function1<PaymentSheet.CustomerConfiguration, PrefsRepository>> prefsRepositoryFactoryProvider;
    private final Provider<ResourceRepository> resourceRepositoryProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public C0013PaymentOptionsViewModel_Factory(Provider<PaymentOptionContract.Args> provider, Provider<Function1<PaymentSheet.CustomerConfiguration, PrefsRepository>> provider2, Provider<EventReporter> provider3, Provider<CustomerRepository> provider4, Provider<CoroutineContext> provider5, Provider<Application> provider6, Provider<Logger> provider7, Provider<String> provider8, Provider<ResourceRepository> provider9, Provider<SavedStateHandle> provider10, Provider<LinkPaymentLauncherFactory> provider11) {
        this.argsProvider = provider;
        this.prefsRepositoryFactoryProvider = provider2;
        this.eventReporterProvider = provider3;
        this.customerRepositoryProvider = provider4;
        this.workContextProvider = provider5;
        this.applicationProvider = provider6;
        this.loggerProvider = provider7;
        this.injectorKeyProvider = provider8;
        this.resourceRepositoryProvider = provider9;
        this.savedStateHandleProvider = provider10;
        this.linkPaymentLauncherFactoryProvider = provider11;
    }

    public PaymentOptionsViewModel get() {
        return newInstance(this.argsProvider.get(), this.prefsRepositoryFactoryProvider.get(), this.eventReporterProvider.get(), this.customerRepositoryProvider.get(), this.workContextProvider.get(), this.applicationProvider.get(), this.loggerProvider.get(), this.injectorKeyProvider.get(), this.resourceRepositoryProvider.get(), this.savedStateHandleProvider.get(), this.linkPaymentLauncherFactoryProvider.get());
    }

    public static C0013PaymentOptionsViewModel_Factory create(Provider<PaymentOptionContract.Args> provider, Provider<Function1<PaymentSheet.CustomerConfiguration, PrefsRepository>> provider2, Provider<EventReporter> provider3, Provider<CustomerRepository> provider4, Provider<CoroutineContext> provider5, Provider<Application> provider6, Provider<Logger> provider7, Provider<String> provider8, Provider<ResourceRepository> provider9, Provider<SavedStateHandle> provider10, Provider<LinkPaymentLauncherFactory> provider11) {
        return new C0013PaymentOptionsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static PaymentOptionsViewModel newInstance(PaymentOptionContract.Args args, Function1<PaymentSheet.CustomerConfiguration, PrefsRepository> function1, EventReporter eventReporter, CustomerRepository customerRepository, CoroutineContext coroutineContext, Application application, Logger logger, String str, ResourceRepository resourceRepository, SavedStateHandle savedStateHandle, LinkPaymentLauncherFactory linkPaymentLauncherFactory) {
        return new PaymentOptionsViewModel(args, function1, eventReporter, customerRepository, coroutineContext, application, logger, str, resourceRepository, savedStateHandle, linkPaymentLauncherFactory);
    }
}

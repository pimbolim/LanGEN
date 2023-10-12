package com.stripe.android.paymentsheet.injection;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideUIContextFactory;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideWorkContextFactory;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor_Factory;
import com.stripe.android.link.LinkPaymentLauncher_Factory;
import com.stripe.android.link.injection.LinkPaymentLauncherFactory;
import com.stripe.android.link.injection.LinkPaymentLauncherFactory_Impl;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory_Factory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.networking.StripeApiRepository_Factory;
import com.stripe.android.paymentsheet.PaymentOptionContract;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel_Factory_MembersInjector;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PrefsRepository;
import com.stripe.android.paymentsheet.analytics.DefaultDeviceIdRepository;
import com.stripe.android.paymentsheet.analytics.DefaultDeviceIdRepository_Factory;
import com.stripe.android.paymentsheet.analytics.DefaultEventReporter;
import com.stripe.android.paymentsheet.analytics.DefaultEventReporter_Factory;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.injection.PaymentOptionsViewModelFactoryComponent;
import com.stripe.android.paymentsheet.injection.PaymentOptionsViewModelSubcomponent;
import com.stripe.android.paymentsheet.repositories.CustomerApiRepository;
import com.stripe.android.paymentsheet.repositories.CustomerApiRepository_Factory;
import com.stripe.android.paymentsheet.repositories.CustomerRepository;
import com.stripe.android.ui.core.forms.resources.AsyncResourceRepository;
import com.stripe.android.ui.core.forms.resources.AsyncResourceRepository_Factory;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class DaggerPaymentOptionsViewModelFactoryComponent implements PaymentOptionsViewModelFactoryComponent {
    /* access modifiers changed from: private */
    public Provider<AsyncResourceRepository> asyncResourceRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<Context> contextProvider;
    /* access modifiers changed from: private */
    public Provider<CustomerApiRepository> customerApiRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<DefaultAnalyticsRequestExecutor> defaultAnalyticsRequestExecutorProvider;
    private Provider<DefaultDeviceIdRepository> defaultDeviceIdRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<DefaultEventReporter> defaultEventReporterProvider;
    /* access modifiers changed from: private */
    public Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    /* access modifiers changed from: private */
    public final DaggerPaymentOptionsViewModelFactoryComponent paymentOptionsViewModelFactoryComponent;
    /* access modifiers changed from: private */
    public final PaymentOptionsViewModelModule paymentOptionsViewModelModule;
    private Provider<PaymentOptionsViewModelSubcomponent.Builder> paymentOptionsViewModelSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<Set<String>> productUsageProvider;
    /* access modifiers changed from: private */
    public Provider<Boolean> provideEnabledLoggingProvider;
    private Provider<EventReporter.Mode> provideEventReporterModeProvider;
    private Provider<Locale> provideLocaleProvider;
    /* access modifiers changed from: private */
    public Provider<Logger> provideLoggerProvider;
    private Provider<PaymentConfiguration> providePaymentConfigurationProvider;
    /* access modifiers changed from: private */
    public Provider<Function1<PaymentSheet.CustomerConfiguration, PrefsRepository>> providePrefsRepositoryFactoryProvider;
    /* access modifiers changed from: private */
    public Provider<Function0<String>> providePublishableKeyProvider;
    private Provider<Resources> provideResourcesProvider;
    /* access modifiers changed from: private */
    public Provider<Function0<String>> provideStripeAccountIdProvider;
    /* access modifiers changed from: private */
    public Provider<CoroutineContext> provideUIContextProvider;
    /* access modifiers changed from: private */
    public Provider<CoroutineContext> provideWorkContextProvider;
    /* access modifiers changed from: private */
    public Provider<StripeApiRepository> stripeApiRepositoryProvider;

    private DaggerPaymentOptionsViewModelFactoryComponent(PaymentOptionsViewModelModule paymentOptionsViewModelModule2, CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context, Set<String> set) {
        this.paymentOptionsViewModelFactoryComponent = this;
        this.paymentOptionsViewModelModule = paymentOptionsViewModelModule2;
        initialize(paymentOptionsViewModelModule2, coroutineContextModule, loggingModule, context, set);
    }

    public static PaymentOptionsViewModelFactoryComponent.Builder builder() {
        return new Builder();
    }

    private void initialize(PaymentOptionsViewModelModule paymentOptionsViewModelModule2, CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context, Set<String> set) {
        this.paymentOptionsViewModelSubcomponentBuilderProvider = new Provider<PaymentOptionsViewModelSubcomponent.Builder>() {
            public PaymentOptionsViewModelSubcomponent.Builder get() {
                return new PaymentOptionsViewModelSubcomponentBuilder();
            }
        };
        this.contextProvider = InstanceFactory.create(context);
        Provider<CoroutineContext> provider = DoubleCheck.provider(CoroutineContextModule_ProvideWorkContextFactory.create(coroutineContextModule));
        this.provideWorkContextProvider = provider;
        this.providePrefsRepositoryFactoryProvider = DoubleCheck.provider(PaymentOptionsViewModelModule_ProvidePrefsRepositoryFactoryFactory.create(paymentOptionsViewModelModule2, this.contextProvider, provider));
        this.provideEventReporterModeProvider = DoubleCheck.provider(PaymentOptionsViewModelModule_ProvideEventReporterModeFactory.create(paymentOptionsViewModelModule2));
        this.defaultDeviceIdRepositoryProvider = DoubleCheck.provider(DefaultDeviceIdRepository_Factory.create(this.contextProvider, this.provideWorkContextProvider));
        Provider<Boolean> provider2 = DoubleCheck.provider(PaymentSheetCommonModule_Companion_ProvideEnabledLoggingFactory.create());
        this.provideEnabledLoggingProvider = provider2;
        Provider<Logger> provider3 = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, provider2));
        this.provideLoggerProvider = provider3;
        this.defaultAnalyticsRequestExecutorProvider = DefaultAnalyticsRequestExecutor_Factory.create(provider3, this.provideWorkContextProvider);
        PaymentSheetCommonModule_Companion_ProvidePaymentConfigurationFactory create = PaymentSheetCommonModule_Companion_ProvidePaymentConfigurationFactory.create(this.contextProvider);
        this.providePaymentConfigurationProvider = create;
        this.providePublishableKeyProvider = PaymentSheetCommonModule_Companion_ProvidePublishableKeyFactory.create(create);
        Factory<T> create2 = InstanceFactory.create(set);
        this.productUsageProvider = create2;
        PaymentAnalyticsRequestFactory_Factory create3 = PaymentAnalyticsRequestFactory_Factory.create(this.contextProvider, this.providePublishableKeyProvider, create2);
        this.paymentAnalyticsRequestFactoryProvider = create3;
        this.defaultEventReporterProvider = DoubleCheck.provider(DefaultEventReporter_Factory.create(this.provideEventReporterModeProvider, this.defaultDeviceIdRepositoryProvider, this.defaultAnalyticsRequestExecutorProvider, create3, this.provideWorkContextProvider));
        StripeApiRepository_Factory create4 = StripeApiRepository_Factory.create(this.contextProvider, this.providePublishableKeyProvider, this.provideWorkContextProvider, this.productUsageProvider, this.paymentAnalyticsRequestFactoryProvider, this.defaultAnalyticsRequestExecutorProvider, this.provideLoggerProvider);
        this.stripeApiRepositoryProvider = create4;
        this.customerApiRepositoryProvider = DoubleCheck.provider(CustomerApiRepository_Factory.create(create4, this.providePaymentConfigurationProvider, this.provideLoggerProvider, this.provideWorkContextProvider, this.productUsageProvider));
        this.provideResourcesProvider = DoubleCheck.provider(PaymentSheetCommonModule_Companion_ProvideResourcesFactory.create(this.contextProvider));
        Provider<Locale> provider4 = DoubleCheck.provider(PaymentSheetCommonModule_Companion_ProvideLocaleFactory.create());
        this.provideLocaleProvider = provider4;
        this.asyncResourceRepositoryProvider = DoubleCheck.provider(AsyncResourceRepository_Factory.create(this.provideResourcesProvider, this.provideWorkContextProvider, provider4));
        this.provideStripeAccountIdProvider = PaymentSheetCommonModule_Companion_ProvideStripeAccountIdFactory.create(this.providePaymentConfigurationProvider);
        this.provideUIContextProvider = DoubleCheck.provider(CoroutineContextModule_ProvideUIContextFactory.create(coroutineContextModule));
    }

    public void inject(PaymentOptionsViewModel.Factory factory) {
        injectFactory(factory);
    }

    private PaymentOptionsViewModel.Factory injectFactory(PaymentOptionsViewModel.Factory factory) {
        PaymentOptionsViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.paymentOptionsViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private static final class Builder implements PaymentOptionsViewModelFactoryComponent.Builder {
        private Context context;
        private Set<String> productUsage;

        private Builder() {
        }

        public Builder context(Context context2) {
            this.context = (Context) Preconditions.checkNotNull(context2);
            return this;
        }

        public Builder productUsage(Set<String> set) {
            this.productUsage = (Set) Preconditions.checkNotNull(set);
            return this;
        }

        public PaymentOptionsViewModelFactoryComponent build() {
            Preconditions.checkBuilderRequirement(this.context, Context.class);
            Preconditions.checkBuilderRequirement(this.productUsage, Set.class);
            return new DaggerPaymentOptionsViewModelFactoryComponent(new PaymentOptionsViewModelModule(), new CoroutineContextModule(), new LoggingModule(), this.context, this.productUsage);
        }
    }

    private static final class PaymentOptionsViewModelSubcomponentBuilder implements PaymentOptionsViewModelSubcomponent.Builder {
        private Application application;
        private PaymentOptionContract.Args args;
        private final DaggerPaymentOptionsViewModelFactoryComponent paymentOptionsViewModelFactoryComponent;
        private SavedStateHandle savedStateHandle;

        private PaymentOptionsViewModelSubcomponentBuilder(DaggerPaymentOptionsViewModelFactoryComponent daggerPaymentOptionsViewModelFactoryComponent) {
            this.paymentOptionsViewModelFactoryComponent = daggerPaymentOptionsViewModelFactoryComponent;
        }

        public PaymentOptionsViewModelSubcomponentBuilder application(Application application2) {
            this.application = (Application) Preconditions.checkNotNull(application2);
            return this;
        }

        public PaymentOptionsViewModelSubcomponentBuilder savedStateHandle(SavedStateHandle savedStateHandle2) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(savedStateHandle2);
            return this;
        }

        public PaymentOptionsViewModelSubcomponentBuilder args(PaymentOptionContract.Args args2) {
            this.args = (PaymentOptionContract.Args) Preconditions.checkNotNull(args2);
            return this;
        }

        public PaymentOptionsViewModelSubcomponent build() {
            Preconditions.checkBuilderRequirement(this.application, Application.class);
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            Preconditions.checkBuilderRequirement(this.args, PaymentOptionContract.Args.class);
            return new PaymentOptionsViewModelSubcomponentImpl(this.application, this.savedStateHandle, this.args);
        }
    }

    private static final class PaymentOptionsViewModelSubcomponentImpl implements PaymentOptionsViewModelSubcomponent {
        private final Application application;
        private final PaymentOptionContract.Args args;
        private Provider<LinkPaymentLauncherFactory> linkPaymentLauncherFactoryProvider;
        private LinkPaymentLauncher_Factory linkPaymentLauncherProvider;
        private final DaggerPaymentOptionsViewModelFactoryComponent paymentOptionsViewModelFactoryComponent;
        private final PaymentOptionsViewModelSubcomponentImpl paymentOptionsViewModelSubcomponentImpl;
        private final SavedStateHandle savedStateHandle;

        private PaymentOptionsViewModelSubcomponentImpl(DaggerPaymentOptionsViewModelFactoryComponent daggerPaymentOptionsViewModelFactoryComponent, Application application2, SavedStateHandle savedStateHandle2, PaymentOptionContract.Args args2) {
            this.paymentOptionsViewModelSubcomponentImpl = this;
            this.paymentOptionsViewModelFactoryComponent = daggerPaymentOptionsViewModelFactoryComponent;
            this.args = args2;
            this.application = application2;
            this.savedStateHandle = savedStateHandle2;
            initialize(application2, savedStateHandle2, args2);
        }

        private void initialize(Application application2, SavedStateHandle savedStateHandle2, PaymentOptionContract.Args args2) {
            LinkPaymentLauncher_Factory create = LinkPaymentLauncher_Factory.create(this.paymentOptionsViewModelFactoryComponent.contextProvider, this.paymentOptionsViewModelFactoryComponent.productUsageProvider, this.paymentOptionsViewModelFactoryComponent.providePublishableKeyProvider, this.paymentOptionsViewModelFactoryComponent.provideStripeAccountIdProvider, this.paymentOptionsViewModelFactoryComponent.provideEnabledLoggingProvider, this.paymentOptionsViewModelFactoryComponent.provideWorkContextProvider, this.paymentOptionsViewModelFactoryComponent.provideUIContextProvider, this.paymentOptionsViewModelFactoryComponent.paymentAnalyticsRequestFactoryProvider, this.paymentOptionsViewModelFactoryComponent.defaultAnalyticsRequestExecutorProvider, this.paymentOptionsViewModelFactoryComponent.stripeApiRepositoryProvider);
            this.linkPaymentLauncherProvider = create;
            this.linkPaymentLauncherFactoryProvider = LinkPaymentLauncherFactory_Impl.create(create);
        }

        public PaymentOptionsViewModel getViewModel() {
            return new PaymentOptionsViewModel(this.args, (Function1) this.paymentOptionsViewModelFactoryComponent.providePrefsRepositoryFactoryProvider.get(), (EventReporter) this.paymentOptionsViewModelFactoryComponent.defaultEventReporterProvider.get(), (CustomerRepository) this.paymentOptionsViewModelFactoryComponent.customerApiRepositoryProvider.get(), (CoroutineContext) this.paymentOptionsViewModelFactoryComponent.provideWorkContextProvider.get(), this.application, (Logger) this.paymentOptionsViewModelFactoryComponent.provideLoggerProvider.get(), PaymentOptionsViewModelModule_ProvideDummyInjectorKeyFactory.provideDummyInjectorKey(this.paymentOptionsViewModelFactoryComponent.paymentOptionsViewModelModule), (ResourceRepository) this.paymentOptionsViewModelFactoryComponent.asyncResourceRepositoryProvider.get(), this.savedStateHandle, this.linkPaymentLauncherFactoryProvider.get());
        }
    }
}

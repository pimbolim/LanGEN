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
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor_Factory;
import com.stripe.android.googlepaylauncher.GooglePayEnvironment;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher_Factory;
import com.stripe.android.googlepaylauncher.GooglePayRepository;
import com.stripe.android.googlepaylauncher.injection.GooglePayLauncherModule;
import com.stripe.android.googlepaylauncher.injection.GooglePayLauncherModule_ProvideGooglePayRepositoryFactoryFactory;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherFactory;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherFactory_Impl;
import com.stripe.android.link.LinkPaymentLauncher_Factory;
import com.stripe.android.link.injection.LinkPaymentLauncherFactory;
import com.stripe.android.link.injection.LinkPaymentLauncherFactory_Impl;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory_Factory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.networking.StripeApiRepository_Factory;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory_Impl;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncher_Factory;
import com.stripe.android.paymentsheet.PaymentSheetViewModel;
import com.stripe.android.paymentsheet.PaymentSheetViewModel_Factory_MembersInjector;
import com.stripe.android.paymentsheet.PrefsRepository;
import com.stripe.android.paymentsheet.analytics.DefaultDeviceIdRepository;
import com.stripe.android.paymentsheet.analytics.DefaultDeviceIdRepository_Factory;
import com.stripe.android.paymentsheet.analytics.DefaultEventReporter;
import com.stripe.android.paymentsheet.analytics.DefaultEventReporter_Factory;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.paymentsheet.forms.FormViewModel_Factory_MembersInjector;
import com.stripe.android.paymentsheet.forms.TransformSpecToElement;
import com.stripe.android.paymentsheet.injection.FormViewModelSubcomponent;
import com.stripe.android.paymentsheet.injection.PaymentSheetLauncherComponent;
import com.stripe.android.paymentsheet.injection.PaymentSheetViewModelSubcomponent;
import com.stripe.android.paymentsheet.model.StripeIntentValidator;
import com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArguments;
import com.stripe.android.paymentsheet.repositories.CustomerApiRepository;
import com.stripe.android.paymentsheet.repositories.CustomerApiRepository_Factory;
import com.stripe.android.paymentsheet.repositories.CustomerRepository;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.forms.resources.AsyncResourceRepository;
import com.stripe.android.ui.core.forms.resources.AsyncResourceRepository_Factory;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class DaggerPaymentSheetLauncherComponent implements PaymentSheetLauncherComponent {
    /* access modifiers changed from: private */
    public final Application application;
    /* access modifiers changed from: private */
    public Provider<Application> applicationProvider;
    /* access modifiers changed from: private */
    public Provider<AsyncResourceRepository> asyncResourceRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<CustomerApiRepository> customerApiRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<DefaultAnalyticsRequestExecutor> defaultAnalyticsRequestExecutorProvider;
    private Provider<DefaultDeviceIdRepository> defaultDeviceIdRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<DefaultEventReporter> defaultEventReporterProvider;
    private Provider<FormViewModelSubcomponent.Builder> formViewModelSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public final String injectorKey;
    /* access modifiers changed from: private */
    public Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    /* access modifiers changed from: private */
    public final DaggerPaymentSheetLauncherComponent paymentSheetLauncherComponent;
    private Provider<PaymentSheetViewModelSubcomponent.Builder> paymentSheetViewModelSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public Provider<Boolean> provideEnabledLoggingProvider;
    private Provider<EventReporter.Mode> provideEventReporterModeProvider;
    /* access modifiers changed from: private */
    public Provider<Function1<GooglePayEnvironment, GooglePayRepository>> provideGooglePayRepositoryFactoryProvider;
    private Provider<Locale> provideLocaleProvider;
    /* access modifiers changed from: private */
    public Provider<Logger> provideLoggerProvider;
    /* access modifiers changed from: private */
    public Provider<PaymentConfiguration> providePaymentConfigurationProvider;
    /* access modifiers changed from: private */
    public Provider<Set<String>> provideProductUsageTokensProvider;
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

    private DaggerPaymentSheetLauncherComponent(GooglePayLauncherModule googlePayLauncherModule, CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Application application2, String str) {
        this.paymentSheetLauncherComponent = this;
        this.application = application2;
        this.injectorKey = str;
        initialize(googlePayLauncherModule, coroutineContextModule, loggingModule, application2, str);
    }

    public static PaymentSheetLauncherComponent.Builder builder() {
        return new Builder();
    }

    private Function0<String> namedFunction0OfString() {
        return PaymentSheetCommonModule_Companion_ProvidePublishableKeyFactory.providePublishableKey(DoubleCheck.lazy(this.providePaymentConfigurationProvider));
    }

    private PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory() {
        return new PaymentAnalyticsRequestFactory((Context) this.application, namedFunction0OfString(), this.provideProductUsageTokensProvider.get());
    }

    private DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor() {
        return new DefaultAnalyticsRequestExecutor(this.provideLoggerProvider.get(), this.provideWorkContextProvider.get());
    }

    private StripeApiRepository stripeApiRepository() {
        return new StripeApiRepository((Context) this.application, namedFunction0OfString(), this.provideWorkContextProvider.get(), this.provideProductUsageTokensProvider.get(), paymentAnalyticsRequestFactory(), (AnalyticsRequestExecutor) defaultAnalyticsRequestExecutor(), this.provideLoggerProvider.get());
    }

    /* access modifiers changed from: private */
    public StripeIntentRepository.Api api() {
        return new StripeIntentRepository.Api(stripeApiRepository(), DoubleCheck.lazy(this.providePaymentConfigurationProvider), this.provideWorkContextProvider.get(), this.provideLocaleProvider.get());
    }

    private void initialize(GooglePayLauncherModule googlePayLauncherModule, CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Application application2, String str) {
        this.paymentSheetViewModelSubcomponentBuilderProvider = new Provider<PaymentSheetViewModelSubcomponent.Builder>() {
            public PaymentSheetViewModelSubcomponent.Builder get() {
                return new PaymentSheetViewModelSubcomponentBuilder();
            }
        };
        this.formViewModelSubcomponentBuilderProvider = new Provider<FormViewModelSubcomponent.Builder>() {
            public FormViewModelSubcomponent.Builder get() {
                return new FormViewModelSubcomponentBuilder();
            }
        };
        this.provideEventReporterModeProvider = DoubleCheck.provider(PaymentSheetLauncherModule_Companion_ProvideEventReporterModeFactory.create());
        this.applicationProvider = InstanceFactory.create(application2);
        Provider<CoroutineContext> provider = DoubleCheck.provider(CoroutineContextModule_ProvideWorkContextFactory.create(coroutineContextModule));
        this.provideWorkContextProvider = provider;
        this.defaultDeviceIdRepositoryProvider = DoubleCheck.provider(DefaultDeviceIdRepository_Factory.create(this.applicationProvider, provider));
        Provider<Boolean> provider2 = DoubleCheck.provider(PaymentSheetCommonModule_Companion_ProvideEnabledLoggingFactory.create());
        this.provideEnabledLoggingProvider = provider2;
        Provider<Logger> provider3 = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, provider2));
        this.provideLoggerProvider = provider3;
        this.defaultAnalyticsRequestExecutorProvider = DefaultAnalyticsRequestExecutor_Factory.create(provider3, this.provideWorkContextProvider);
        PaymentSheetCommonModule_Companion_ProvidePaymentConfigurationFactory create = PaymentSheetCommonModule_Companion_ProvidePaymentConfigurationFactory.create(this.applicationProvider);
        this.providePaymentConfigurationProvider = create;
        this.providePublishableKeyProvider = PaymentSheetCommonModule_Companion_ProvidePublishableKeyFactory.create(create);
        Provider<Set<String>> provider4 = DoubleCheck.provider(PaymentSheetLauncherModule_Companion_ProvideProductUsageTokensFactory.create());
        this.provideProductUsageTokensProvider = provider4;
        PaymentAnalyticsRequestFactory_Factory create2 = PaymentAnalyticsRequestFactory_Factory.create(this.applicationProvider, this.providePublishableKeyProvider, provider4);
        this.paymentAnalyticsRequestFactoryProvider = create2;
        this.defaultEventReporterProvider = DoubleCheck.provider(DefaultEventReporter_Factory.create(this.provideEventReporterModeProvider, this.defaultDeviceIdRepositoryProvider, this.defaultAnalyticsRequestExecutorProvider, create2, this.provideWorkContextProvider));
        this.provideLocaleProvider = DoubleCheck.provider(PaymentSheetCommonModule_Companion_ProvideLocaleFactory.create());
        StripeApiRepository_Factory create3 = StripeApiRepository_Factory.create(this.applicationProvider, this.providePublishableKeyProvider, this.provideWorkContextProvider, this.provideProductUsageTokensProvider, this.paymentAnalyticsRequestFactoryProvider, this.defaultAnalyticsRequestExecutorProvider, this.provideLoggerProvider);
        this.stripeApiRepositoryProvider = create3;
        this.customerApiRepositoryProvider = DoubleCheck.provider(CustomerApiRepository_Factory.create(create3, this.providePaymentConfigurationProvider, this.provideLoggerProvider, this.provideWorkContextProvider, this.provideProductUsageTokensProvider));
        Provider<Resources> provider5 = DoubleCheck.provider(PaymentSheetCommonModule_Companion_ProvideResourcesFactory.create(this.applicationProvider));
        this.provideResourcesProvider = provider5;
        this.asyncResourceRepositoryProvider = DoubleCheck.provider(AsyncResourceRepository_Factory.create(provider5, this.provideWorkContextProvider, this.provideLocaleProvider));
        this.provideUIContextProvider = DoubleCheck.provider(CoroutineContextModule_ProvideUIContextFactory.create(coroutineContextModule));
        this.provideGooglePayRepositoryFactoryProvider = DoubleCheck.provider(GooglePayLauncherModule_ProvideGooglePayRepositoryFactoryFactory.create(googlePayLauncherModule, this.applicationProvider, this.provideLoggerProvider));
        this.provideStripeAccountIdProvider = PaymentSheetCommonModule_Companion_ProvideStripeAccountIdFactory.create(this.providePaymentConfigurationProvider);
    }

    public void inject(PaymentSheetViewModel.Factory factory) {
        injectFactory(factory);
    }

    public void inject(FormViewModel.Factory factory) {
        injectFactory2(factory);
    }

    private PaymentSheetViewModel.Factory injectFactory(PaymentSheetViewModel.Factory factory) {
        PaymentSheetViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.paymentSheetViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private FormViewModel.Factory injectFactory2(FormViewModel.Factory factory) {
        FormViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.formViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private static final class Builder implements PaymentSheetLauncherComponent.Builder {
        private Application application;
        private String injectorKey;

        private Builder() {
        }

        public Builder application(Application application2) {
            this.application = (Application) Preconditions.checkNotNull(application2);
            return this;
        }

        public Builder injectorKey(String str) {
            this.injectorKey = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public PaymentSheetLauncherComponent build() {
            Preconditions.checkBuilderRequirement(this.application, Application.class);
            Preconditions.checkBuilderRequirement(this.injectorKey, String.class);
            return new DaggerPaymentSheetLauncherComponent(new GooglePayLauncherModule(), new CoroutineContextModule(), new LoggingModule(), this.application, this.injectorKey);
        }
    }

    private static final class PaymentSheetViewModelSubcomponentBuilder implements PaymentSheetViewModelSubcomponent.Builder {
        private final DaggerPaymentSheetLauncherComponent paymentSheetLauncherComponent;
        private PaymentSheetViewModelModule paymentSheetViewModelModule;
        private SavedStateHandle savedStateHandle;

        private PaymentSheetViewModelSubcomponentBuilder(DaggerPaymentSheetLauncherComponent daggerPaymentSheetLauncherComponent) {
            this.paymentSheetLauncherComponent = daggerPaymentSheetLauncherComponent;
        }

        public PaymentSheetViewModelSubcomponentBuilder paymentSheetViewModelModule(PaymentSheetViewModelModule paymentSheetViewModelModule2) {
            this.paymentSheetViewModelModule = (PaymentSheetViewModelModule) Preconditions.checkNotNull(paymentSheetViewModelModule2);
            return this;
        }

        public PaymentSheetViewModelSubcomponentBuilder savedStateHandle(SavedStateHandle savedStateHandle2) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(savedStateHandle2);
            return this;
        }

        public PaymentSheetViewModelSubcomponent build() {
            Preconditions.checkBuilderRequirement(this.paymentSheetViewModelModule, PaymentSheetViewModelModule.class);
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            return new PaymentSheetViewModelSubcomponentImpl(this.paymentSheetViewModelModule, this.savedStateHandle);
        }
    }

    private static final class FormViewModelSubcomponentBuilder implements FormViewModelSubcomponent.Builder {
        private FormFragmentArguments formFragmentArguments;
        private LayoutSpec layout;
        private final DaggerPaymentSheetLauncherComponent paymentSheetLauncherComponent;

        private FormViewModelSubcomponentBuilder(DaggerPaymentSheetLauncherComponent daggerPaymentSheetLauncherComponent) {
            this.paymentSheetLauncherComponent = daggerPaymentSheetLauncherComponent;
        }

        public FormViewModelSubcomponentBuilder layout(LayoutSpec layoutSpec) {
            this.layout = (LayoutSpec) Preconditions.checkNotNull(layoutSpec);
            return this;
        }

        public FormViewModelSubcomponentBuilder formFragmentArguments(FormFragmentArguments formFragmentArguments2) {
            this.formFragmentArguments = (FormFragmentArguments) Preconditions.checkNotNull(formFragmentArguments2);
            return this;
        }

        public FormViewModelSubcomponent build() {
            Preconditions.checkBuilderRequirement(this.layout, LayoutSpec.class);
            Preconditions.checkBuilderRequirement(this.formFragmentArguments, FormFragmentArguments.class);
            return new FormViewModelSubcomponentImpl(this.layout, this.formFragmentArguments);
        }
    }

    private static final class PaymentSheetViewModelSubcomponentImpl implements PaymentSheetViewModelSubcomponent {
        private Provider<GooglePayPaymentMethodLauncherFactory> googlePayPaymentMethodLauncherFactoryProvider;
        private GooglePayPaymentMethodLauncher_Factory googlePayPaymentMethodLauncherProvider;
        private Provider<LinkPaymentLauncherFactory> linkPaymentLauncherFactoryProvider;
        private LinkPaymentLauncher_Factory linkPaymentLauncherProvider;
        private final DaggerPaymentSheetLauncherComponent paymentSheetLauncherComponent;
        private final PaymentSheetViewModelModule paymentSheetViewModelModule;
        private final PaymentSheetViewModelSubcomponentImpl paymentSheetViewModelSubcomponentImpl;
        private final SavedStateHandle savedStateHandle;
        private Provider<StripePaymentLauncherAssistedFactory> stripePaymentLauncherAssistedFactoryProvider;
        private StripePaymentLauncher_Factory stripePaymentLauncherProvider;

        private PaymentSheetViewModelSubcomponentImpl(DaggerPaymentSheetLauncherComponent daggerPaymentSheetLauncherComponent, PaymentSheetViewModelModule paymentSheetViewModelModule2, SavedStateHandle savedStateHandle2) {
            this.paymentSheetViewModelSubcomponentImpl = this;
            this.paymentSheetLauncherComponent = daggerPaymentSheetLauncherComponent;
            this.paymentSheetViewModelModule = paymentSheetViewModelModule2;
            this.savedStateHandle = savedStateHandle2;
            initialize(paymentSheetViewModelModule2, savedStateHandle2);
        }

        private PrefsRepository prefsRepository() {
            return PaymentSheetViewModelModule_ProvidePrefsRepositoryFactory.providePrefsRepository(this.paymentSheetViewModelModule, this.paymentSheetLauncherComponent.application, (CoroutineContext) this.paymentSheetLauncherComponent.provideWorkContextProvider.get());
        }

        private void initialize(PaymentSheetViewModelModule paymentSheetViewModelModule2, SavedStateHandle savedStateHandle2) {
            StripePaymentLauncher_Factory create = StripePaymentLauncher_Factory.create(this.paymentSheetLauncherComponent.applicationProvider, this.paymentSheetLauncherComponent.provideEnabledLoggingProvider, this.paymentSheetLauncherComponent.provideWorkContextProvider, this.paymentSheetLauncherComponent.provideUIContextProvider, this.paymentSheetLauncherComponent.stripeApiRepositoryProvider, this.paymentSheetLauncherComponent.paymentAnalyticsRequestFactoryProvider, this.paymentSheetLauncherComponent.provideProductUsageTokensProvider);
            this.stripePaymentLauncherProvider = create;
            this.stripePaymentLauncherAssistedFactoryProvider = StripePaymentLauncherAssistedFactory_Impl.create(create);
            GooglePayPaymentMethodLauncher_Factory create2 = GooglePayPaymentMethodLauncher_Factory.create(this.paymentSheetLauncherComponent.applicationProvider, this.paymentSheetLauncherComponent.provideGooglePayRepositoryFactoryProvider, this.paymentSheetLauncherComponent.provideProductUsageTokensProvider, this.paymentSheetLauncherComponent.providePublishableKeyProvider, this.paymentSheetLauncherComponent.provideStripeAccountIdProvider, this.paymentSheetLauncherComponent.provideEnabledLoggingProvider, this.paymentSheetLauncherComponent.provideWorkContextProvider, this.paymentSheetLauncherComponent.paymentAnalyticsRequestFactoryProvider, this.paymentSheetLauncherComponent.defaultAnalyticsRequestExecutorProvider, this.paymentSheetLauncherComponent.stripeApiRepositoryProvider);
            this.googlePayPaymentMethodLauncherProvider = create2;
            this.googlePayPaymentMethodLauncherFactoryProvider = GooglePayPaymentMethodLauncherFactory_Impl.create(create2);
            LinkPaymentLauncher_Factory create3 = LinkPaymentLauncher_Factory.create(this.paymentSheetLauncherComponent.applicationProvider, this.paymentSheetLauncherComponent.provideProductUsageTokensProvider, this.paymentSheetLauncherComponent.providePublishableKeyProvider, this.paymentSheetLauncherComponent.provideStripeAccountIdProvider, this.paymentSheetLauncherComponent.provideEnabledLoggingProvider, this.paymentSheetLauncherComponent.provideWorkContextProvider, this.paymentSheetLauncherComponent.provideUIContextProvider, this.paymentSheetLauncherComponent.paymentAnalyticsRequestFactoryProvider, this.paymentSheetLauncherComponent.defaultAnalyticsRequestExecutorProvider, this.paymentSheetLauncherComponent.stripeApiRepositoryProvider);
            this.linkPaymentLauncherProvider = create3;
            this.linkPaymentLauncherFactoryProvider = LinkPaymentLauncherFactory_Impl.create(create3);
        }

        public PaymentSheetViewModel getViewModel() {
            Lazy lazy = DoubleCheck.lazy(this.paymentSheetLauncherComponent.providePaymentConfigurationProvider);
            StripeIntentRepository.Api access$2100 = this.paymentSheetLauncherComponent.api();
            StripeIntentValidator stripeIntentValidator = r8;
            StripeIntentValidator stripeIntentValidator2 = new StripeIntentValidator();
            return new PaymentSheetViewModel(this.paymentSheetLauncherComponent.application, PaymentSheetViewModelModule_ProvideArgsFactory.provideArgs(this.paymentSheetViewModelModule), (EventReporter) this.paymentSheetLauncherComponent.defaultEventReporterProvider.get(), lazy, access$2100, stripeIntentValidator, (CustomerRepository) this.paymentSheetLauncherComponent.customerApiRepositoryProvider.get(), prefsRepository(), (ResourceRepository) this.paymentSheetLauncherComponent.asyncResourceRepositoryProvider.get(), this.stripePaymentLauncherAssistedFactoryProvider.get(), this.googlePayPaymentMethodLauncherFactoryProvider.get(), (Logger) this.paymentSheetLauncherComponent.provideLoggerProvider.get(), (CoroutineContext) this.paymentSheetLauncherComponent.provideWorkContextProvider.get(), this.paymentSheetLauncherComponent.injectorKey, this.savedStateHandle, this.linkPaymentLauncherFactoryProvider.get());
        }
    }

    private static final class FormViewModelSubcomponentImpl implements FormViewModelSubcomponent {
        private final FormFragmentArguments formFragmentArguments;
        private final FormViewModelSubcomponentImpl formViewModelSubcomponentImpl;
        private final LayoutSpec layout;
        private final DaggerPaymentSheetLauncherComponent paymentSheetLauncherComponent;

        private FormViewModelSubcomponentImpl(DaggerPaymentSheetLauncherComponent daggerPaymentSheetLauncherComponent, LayoutSpec layoutSpec, FormFragmentArguments formFragmentArguments2) {
            this.formViewModelSubcomponentImpl = this;
            this.paymentSheetLauncherComponent = daggerPaymentSheetLauncherComponent;
            this.layout = layoutSpec;
            this.formFragmentArguments = formFragmentArguments2;
        }

        private TransformSpecToElement transformSpecToElement() {
            return new TransformSpecToElement((ResourceRepository) this.paymentSheetLauncherComponent.asyncResourceRepositoryProvider.get(), this.formFragmentArguments, this.paymentSheetLauncherComponent.application);
        }

        public FormViewModel getViewModel() {
            return new FormViewModel(this.layout, this.formFragmentArguments, (ResourceRepository) this.paymentSheetLauncherComponent.asyncResourceRepositoryProvider.get(), transformSpecToElement());
        }
    }
}

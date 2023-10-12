package com.stripe.android.paymentsheet.injection;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import androidx.activity.result.ActivityResultCaller;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelStoreOwner;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideUIContextFactory;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideWorkContextFactory;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
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
import com.stripe.android.paymentsheet.PaymentOptionCallback;
import com.stripe.android.paymentsheet.PaymentOptionContract;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel_Factory_MembersInjector;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResultCallback;
import com.stripe.android.paymentsheet.PrefsRepository;
import com.stripe.android.paymentsheet.analytics.DefaultDeviceIdRepository;
import com.stripe.android.paymentsheet.analytics.DefaultDeviceIdRepository_Factory;
import com.stripe.android.paymentsheet.analytics.DefaultEventReporter;
import com.stripe.android.paymentsheet.analytics.DefaultEventReporter_Factory;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController;
import com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer;
import com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer_Factory;
import com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController_Factory;
import com.stripe.android.paymentsheet.flowcontroller.FlowControllerViewModel;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.paymentsheet.forms.FormViewModel_Factory_MembersInjector;
import com.stripe.android.paymentsheet.forms.TransformSpecToElement;
import com.stripe.android.paymentsheet.injection.FlowControllerComponent;
import com.stripe.android.paymentsheet.injection.FormViewModelSubcomponent;
import com.stripe.android.paymentsheet.injection.PaymentOptionsViewModelSubcomponent;
import com.stripe.android.paymentsheet.model.PaymentOptionFactory;
import com.stripe.android.paymentsheet.model.StripeIntentValidator_Factory;
import com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArguments;
import com.stripe.android.paymentsheet.repositories.CustomerApiRepository;
import com.stripe.android.paymentsheet.repositories.CustomerApiRepository_Factory;
import com.stripe.android.paymentsheet.repositories.CustomerRepository;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository_Api_Factory;
import com.stripe.android.ui.core.elements.LayoutSpec;
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
import kotlinx.coroutines.CoroutineScope;

public final class DaggerFlowControllerComponent implements FlowControllerComponent {
    private Provider<ActivityResultCaller> activityResultCallerProvider;
    private Provider<StripeIntentRepository.Api> apiProvider;
    /* access modifiers changed from: private */
    public final Context appContext;
    /* access modifiers changed from: private */
    public Provider<Context> appContextProvider;
    /* access modifiers changed from: private */
    public Provider<AsyncResourceRepository> asyncResourceRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<CustomerApiRepository> customerApiRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<DefaultAnalyticsRequestExecutor> defaultAnalyticsRequestExecutorProvider;
    private Provider<DefaultDeviceIdRepository> defaultDeviceIdRepositoryProvider;
    /* access modifiers changed from: private */
    public Provider<DefaultEventReporter> defaultEventReporterProvider;
    private Provider<DefaultFlowControllerInitializer> defaultFlowControllerInitializerProvider;
    private Provider<DefaultFlowController> defaultFlowControllerProvider;
    /* access modifiers changed from: private */
    public final DaggerFlowControllerComponent flowControllerComponent;
    private Provider<FormViewModelSubcomponent.Builder> formViewModelSubcomponentBuilderProvider;
    private Provider<GooglePayPaymentMethodLauncherFactory> googlePayPaymentMethodLauncherFactoryProvider;
    private GooglePayPaymentMethodLauncher_Factory googlePayPaymentMethodLauncherProvider;
    /* access modifiers changed from: private */
    public final String injectorKey;
    private Provider<String> injectorKeyProvider;
    private Provider<LifecycleOwner> lifeCycleOwnerProvider;
    private Provider<CoroutineScope> lifecycleScopeProvider;
    /* access modifiers changed from: private */
    public Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    private Provider<PaymentOptionCallback> paymentOptionCallbackProvider;
    private Provider<PaymentOptionFactory> paymentOptionFactoryProvider;
    private Provider<PaymentOptionsViewModelSubcomponent.Builder> paymentOptionsViewModelSubcomponentBuilderProvider;
    private Provider<PaymentSheetResultCallback> paymentResultCallbackProvider;
    /* access modifiers changed from: private */
    public Provider<Boolean> provideEnabledLoggingProvider;
    private Provider<EventReporter.Mode> provideEventReporterModeProvider;
    private Provider<Function1<GooglePayEnvironment, GooglePayRepository>> provideGooglePayRepositoryFactoryProvider;
    private Provider<Locale> provideLocaleProvider;
    /* access modifiers changed from: private */
    public Provider<Logger> provideLoggerProvider;
    private Provider<PaymentConfiguration> providePaymentConfigurationProvider;
    /* access modifiers changed from: private */
    public Provider<Function1<PaymentSheet.CustomerConfiguration, PrefsRepository>> providePrefsRepositoryFactoryProvider;
    /* access modifiers changed from: private */
    public Provider<Set<String>> provideProductUsageTokensProvider;
    /* access modifiers changed from: private */
    public Provider<Function0<String>> providePublishableKeyProvider;
    private Provider<Resources> provideResourcesProvider;
    /* access modifiers changed from: private */
    public Provider<Function0<String>> provideStripeAccountIdProvider;
    /* access modifiers changed from: private */
    public Provider<CoroutineContext> provideUIContextProvider;
    private Provider<FlowControllerViewModel> provideViewModelProvider;
    /* access modifiers changed from: private */
    public Provider<CoroutineContext> provideWorkContextProvider;
    private Provider<Function0<Integer>> statusBarColorProvider;
    /* access modifiers changed from: private */
    public Provider<StripeApiRepository> stripeApiRepositoryProvider;
    private Provider<StripePaymentLauncherAssistedFactory> stripePaymentLauncherAssistedFactoryProvider;
    private StripePaymentLauncher_Factory stripePaymentLauncherProvider;
    private Provider<ViewModelStoreOwner> viewModelStoreOwnerProvider;

    private DaggerFlowControllerComponent(GooglePayLauncherModule googlePayLauncherModule, CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context, ViewModelStoreOwner viewModelStoreOwner, CoroutineScope coroutineScope, LifecycleOwner lifecycleOwner, ActivityResultCaller activityResultCaller, Function0<Integer> function0, PaymentOptionFactory paymentOptionFactory, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback, String str) {
        this.flowControllerComponent = this;
        this.injectorKey = str;
        this.appContext = context;
        initialize(googlePayLauncherModule, coroutineContextModule, loggingModule, context, viewModelStoreOwner, coroutineScope, lifecycleOwner, activityResultCaller, function0, paymentOptionFactory, paymentOptionCallback, paymentSheetResultCallback, str);
    }

    public static FlowControllerComponent.Builder builder() {
        return new Builder();
    }

    private void initialize(GooglePayLauncherModule googlePayLauncherModule, CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context, ViewModelStoreOwner viewModelStoreOwner, CoroutineScope coroutineScope, LifecycleOwner lifecycleOwner, ActivityResultCaller activityResultCaller, Function0<Integer> function0, PaymentOptionFactory paymentOptionFactory, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback, String str) {
        this.lifecycleScopeProvider = InstanceFactory.create(coroutineScope);
        this.lifeCycleOwnerProvider = InstanceFactory.create(lifecycleOwner);
        this.statusBarColorProvider = InstanceFactory.create(function0);
        this.paymentOptionFactoryProvider = InstanceFactory.create(paymentOptionFactory);
        this.paymentOptionCallbackProvider = InstanceFactory.create(paymentOptionCallback);
        this.paymentResultCallbackProvider = InstanceFactory.create(paymentSheetResultCallback);
        this.activityResultCallerProvider = InstanceFactory.create(activityResultCaller);
        this.injectorKeyProvider = InstanceFactory.create(str);
        this.appContextProvider = InstanceFactory.create(context);
        Provider<CoroutineContext> provider = DoubleCheck.provider(CoroutineContextModule_ProvideWorkContextFactory.create(coroutineContextModule));
        this.provideWorkContextProvider = provider;
        this.providePrefsRepositoryFactoryProvider = DoubleCheck.provider(FlowControllerModule_Companion_ProvidePrefsRepositoryFactoryFactory.create(this.appContextProvider, provider));
        Provider<Boolean> provider2 = DoubleCheck.provider(PaymentSheetCommonModule_Companion_ProvideEnabledLoggingFactory.create());
        this.provideEnabledLoggingProvider = provider2;
        Provider<Logger> provider3 = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, provider2));
        this.provideLoggerProvider = provider3;
        this.provideGooglePayRepositoryFactoryProvider = DoubleCheck.provider(GooglePayLauncherModule_ProvideGooglePayRepositoryFactoryFactory.create(googlePayLauncherModule, this.appContextProvider, provider3));
        PaymentSheetCommonModule_Companion_ProvidePaymentConfigurationFactory create = PaymentSheetCommonModule_Companion_ProvidePaymentConfigurationFactory.create(this.appContextProvider);
        this.providePaymentConfigurationProvider = create;
        this.providePublishableKeyProvider = PaymentSheetCommonModule_Companion_ProvidePublishableKeyFactory.create(create);
        Provider<Set<String>> provider4 = DoubleCheck.provider(FlowControllerModule_Companion_ProvideProductUsageTokensFactory.create());
        this.provideProductUsageTokensProvider = provider4;
        this.paymentAnalyticsRequestFactoryProvider = PaymentAnalyticsRequestFactory_Factory.create(this.appContextProvider, this.providePublishableKeyProvider, provider4);
        DefaultAnalyticsRequestExecutor_Factory create2 = DefaultAnalyticsRequestExecutor_Factory.create(this.provideLoggerProvider, this.provideWorkContextProvider);
        this.defaultAnalyticsRequestExecutorProvider = create2;
        this.stripeApiRepositoryProvider = StripeApiRepository_Factory.create(this.appContextProvider, this.providePublishableKeyProvider, this.provideWorkContextProvider, this.provideProductUsageTokensProvider, this.paymentAnalyticsRequestFactoryProvider, create2, this.provideLoggerProvider);
        Provider<Locale> provider5 = DoubleCheck.provider(PaymentSheetCommonModule_Companion_ProvideLocaleFactory.create());
        this.provideLocaleProvider = provider5;
        this.apiProvider = StripeIntentRepository_Api_Factory.create(this.stripeApiRepositoryProvider, this.providePaymentConfigurationProvider, this.provideWorkContextProvider, provider5);
        this.customerApiRepositoryProvider = DoubleCheck.provider(CustomerApiRepository_Factory.create(this.stripeApiRepositoryProvider, this.providePaymentConfigurationProvider, this.provideLoggerProvider, this.provideWorkContextProvider, this.provideProductUsageTokensProvider));
        this.defaultFlowControllerInitializerProvider = DoubleCheck.provider(DefaultFlowControllerInitializer_Factory.create(this.providePrefsRepositoryFactoryProvider, this.provideGooglePayRepositoryFactoryProvider, this.apiProvider, StripeIntentValidator_Factory.create(), this.customerApiRepositoryProvider, this.provideLoggerProvider, this.provideWorkContextProvider));
        this.provideEventReporterModeProvider = DoubleCheck.provider(FlowControllerModule_Companion_ProvideEventReporterModeFactory.create());
        Provider<DefaultDeviceIdRepository> provider6 = DoubleCheck.provider(DefaultDeviceIdRepository_Factory.create(this.appContextProvider, this.provideWorkContextProvider));
        this.defaultDeviceIdRepositoryProvider = provider6;
        this.defaultEventReporterProvider = DoubleCheck.provider(DefaultEventReporter_Factory.create(this.provideEventReporterModeProvider, provider6, this.defaultAnalyticsRequestExecutorProvider, this.paymentAnalyticsRequestFactoryProvider, this.provideWorkContextProvider));
        Factory create3 = InstanceFactory.create(viewModelStoreOwner);
        this.viewModelStoreOwnerProvider = create3;
        this.provideViewModelProvider = DoubleCheck.provider(FlowControllerModule_Companion_ProvideViewModelFactory.create(create3));
        Provider<CoroutineContext> provider7 = DoubleCheck.provider(CoroutineContextModule_ProvideUIContextFactory.create(coroutineContextModule));
        this.provideUIContextProvider = provider7;
        StripePaymentLauncher_Factory create4 = StripePaymentLauncher_Factory.create(this.appContextProvider, this.provideEnabledLoggingProvider, this.provideWorkContextProvider, provider7, this.stripeApiRepositoryProvider, this.paymentAnalyticsRequestFactoryProvider, this.provideProductUsageTokensProvider);
        this.stripePaymentLauncherProvider = create4;
        this.stripePaymentLauncherAssistedFactoryProvider = StripePaymentLauncherAssistedFactory_Impl.create(create4);
        Provider<Resources> provider8 = DoubleCheck.provider(PaymentSheetCommonModule_Companion_ProvideResourcesFactory.create(this.appContextProvider));
        this.provideResourcesProvider = provider8;
        this.asyncResourceRepositoryProvider = DoubleCheck.provider(AsyncResourceRepository_Factory.create(provider8, this.provideWorkContextProvider, this.provideLocaleProvider));
        PaymentSheetCommonModule_Companion_ProvideStripeAccountIdFactory create5 = PaymentSheetCommonModule_Companion_ProvideStripeAccountIdFactory.create(this.providePaymentConfigurationProvider);
        this.provideStripeAccountIdProvider = create5;
        GooglePayPaymentMethodLauncher_Factory create6 = GooglePayPaymentMethodLauncher_Factory.create(this.appContextProvider, this.provideGooglePayRepositoryFactoryProvider, this.provideProductUsageTokensProvider, this.providePublishableKeyProvider, create5, this.provideEnabledLoggingProvider, this.provideWorkContextProvider, this.paymentAnalyticsRequestFactoryProvider, this.defaultAnalyticsRequestExecutorProvider, this.stripeApiRepositoryProvider);
        this.googlePayPaymentMethodLauncherProvider = create6;
        Provider<GooglePayPaymentMethodLauncherFactory> create7 = GooglePayPaymentMethodLauncherFactory_Impl.create(create6);
        this.googlePayPaymentMethodLauncherFactoryProvider = create7;
        this.defaultFlowControllerProvider = DoubleCheck.provider(DefaultFlowController_Factory.create(this.lifecycleScopeProvider, this.lifeCycleOwnerProvider, this.statusBarColorProvider, this.paymentOptionFactoryProvider, this.paymentOptionCallbackProvider, this.paymentResultCallbackProvider, this.activityResultCallerProvider, this.injectorKeyProvider, this.defaultFlowControllerInitializerProvider, this.defaultEventReporterProvider, this.provideViewModelProvider, this.stripePaymentLauncherAssistedFactoryProvider, this.asyncResourceRepositoryProvider, this.providePaymentConfigurationProvider, this.provideUIContextProvider, this.provideEnabledLoggingProvider, this.provideProductUsageTokensProvider, create7));
        this.paymentOptionsViewModelSubcomponentBuilderProvider = new Provider<PaymentOptionsViewModelSubcomponent.Builder>() {
            public PaymentOptionsViewModelSubcomponent.Builder get() {
                return new PaymentOptionsViewModelSubcomponentBuilder();
            }
        };
        this.formViewModelSubcomponentBuilderProvider = new Provider<FormViewModelSubcomponent.Builder>() {
            public FormViewModelSubcomponent.Builder get() {
                return new FormViewModelSubcomponentBuilder();
            }
        };
    }

    public DefaultFlowController getFlowController() {
        return this.defaultFlowControllerProvider.get();
    }

    public void inject(PaymentOptionsViewModel.Factory factory) {
        injectFactory(factory);
    }

    public void inject(FormViewModel.Factory factory) {
        injectFactory2(factory);
    }

    private PaymentOptionsViewModel.Factory injectFactory(PaymentOptionsViewModel.Factory factory) {
        PaymentOptionsViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.paymentOptionsViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private FormViewModel.Factory injectFactory2(FormViewModel.Factory factory) {
        FormViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.formViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private static final class Builder implements FlowControllerComponent.Builder {
        private ActivityResultCaller activityResultCaller;
        private Context appContext;
        private String injectorKey;
        private LifecycleOwner lifeCycleOwner;
        private CoroutineScope lifecycleScope;
        private PaymentOptionCallback paymentOptionCallback;
        private PaymentOptionFactory paymentOptionFactory;
        private PaymentSheetResultCallback paymentResultCallback;
        private Function0<Integer> statusBarColor;
        private ViewModelStoreOwner viewModelStoreOwner;

        private Builder() {
        }

        public Builder appContext(Context context) {
            this.appContext = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        public Builder viewModelStoreOwner(ViewModelStoreOwner viewModelStoreOwner2) {
            this.viewModelStoreOwner = (ViewModelStoreOwner) Preconditions.checkNotNull(viewModelStoreOwner2);
            return this;
        }

        public Builder lifecycleScope(CoroutineScope coroutineScope) {
            this.lifecycleScope = (CoroutineScope) Preconditions.checkNotNull(coroutineScope);
            return this;
        }

        public Builder lifeCycleOwner(LifecycleOwner lifecycleOwner) {
            this.lifeCycleOwner = (LifecycleOwner) Preconditions.checkNotNull(lifecycleOwner);
            return this;
        }

        public Builder activityResultCaller(ActivityResultCaller activityResultCaller2) {
            this.activityResultCaller = (ActivityResultCaller) Preconditions.checkNotNull(activityResultCaller2);
            return this;
        }

        public Builder statusBarColor(Function0<Integer> function0) {
            this.statusBarColor = (Function0) Preconditions.checkNotNull(function0);
            return this;
        }

        public Builder paymentOptionFactory(PaymentOptionFactory paymentOptionFactory2) {
            this.paymentOptionFactory = (PaymentOptionFactory) Preconditions.checkNotNull(paymentOptionFactory2);
            return this;
        }

        public Builder paymentOptionCallback(PaymentOptionCallback paymentOptionCallback2) {
            this.paymentOptionCallback = (PaymentOptionCallback) Preconditions.checkNotNull(paymentOptionCallback2);
            return this;
        }

        public Builder paymentResultCallback(PaymentSheetResultCallback paymentSheetResultCallback) {
            this.paymentResultCallback = (PaymentSheetResultCallback) Preconditions.checkNotNull(paymentSheetResultCallback);
            return this;
        }

        public Builder injectorKey(String str) {
            this.injectorKey = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public FlowControllerComponent build() {
            Preconditions.checkBuilderRequirement(this.appContext, Context.class);
            Preconditions.checkBuilderRequirement(this.viewModelStoreOwner, ViewModelStoreOwner.class);
            Preconditions.checkBuilderRequirement(this.lifecycleScope, CoroutineScope.class);
            Preconditions.checkBuilderRequirement(this.lifeCycleOwner, LifecycleOwner.class);
            Preconditions.checkBuilderRequirement(this.activityResultCaller, ActivityResultCaller.class);
            Preconditions.checkBuilderRequirement(this.statusBarColor, Function0.class);
            Preconditions.checkBuilderRequirement(this.paymentOptionFactory, PaymentOptionFactory.class);
            Preconditions.checkBuilderRequirement(this.paymentOptionCallback, PaymentOptionCallback.class);
            Preconditions.checkBuilderRequirement(this.paymentResultCallback, PaymentSheetResultCallback.class);
            Preconditions.checkBuilderRequirement(this.injectorKey, String.class);
            return new DaggerFlowControllerComponent(new GooglePayLauncherModule(), new CoroutineContextModule(), new LoggingModule(), this.appContext, this.viewModelStoreOwner, this.lifecycleScope, this.lifeCycleOwner, this.activityResultCaller, this.statusBarColor, this.paymentOptionFactory, this.paymentOptionCallback, this.paymentResultCallback, this.injectorKey);
        }
    }

    private static final class PaymentOptionsViewModelSubcomponentBuilder implements PaymentOptionsViewModelSubcomponent.Builder {
        private Application application;
        private PaymentOptionContract.Args args;
        private final DaggerFlowControllerComponent flowControllerComponent;
        private SavedStateHandle savedStateHandle;

        private PaymentOptionsViewModelSubcomponentBuilder(DaggerFlowControllerComponent daggerFlowControllerComponent) {
            this.flowControllerComponent = daggerFlowControllerComponent;
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

    private static final class FormViewModelSubcomponentBuilder implements FormViewModelSubcomponent.Builder {
        private final DaggerFlowControllerComponent flowControllerComponent;
        private FormFragmentArguments formFragmentArguments;
        private LayoutSpec layout;

        private FormViewModelSubcomponentBuilder(DaggerFlowControllerComponent daggerFlowControllerComponent) {
            this.flowControllerComponent = daggerFlowControllerComponent;
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

    private static final class PaymentOptionsViewModelSubcomponentImpl implements PaymentOptionsViewModelSubcomponent {
        private final Application application;
        private final PaymentOptionContract.Args args;
        private final DaggerFlowControllerComponent flowControllerComponent;
        private Provider<LinkPaymentLauncherFactory> linkPaymentLauncherFactoryProvider;
        private LinkPaymentLauncher_Factory linkPaymentLauncherProvider;
        private final PaymentOptionsViewModelSubcomponentImpl paymentOptionsViewModelSubcomponentImpl;
        private final SavedStateHandle savedStateHandle;

        private PaymentOptionsViewModelSubcomponentImpl(DaggerFlowControllerComponent daggerFlowControllerComponent, Application application2, SavedStateHandle savedStateHandle2, PaymentOptionContract.Args args2) {
            this.paymentOptionsViewModelSubcomponentImpl = this;
            this.flowControllerComponent = daggerFlowControllerComponent;
            this.args = args2;
            this.application = application2;
            this.savedStateHandle = savedStateHandle2;
            initialize(application2, savedStateHandle2, args2);
        }

        private void initialize(Application application2, SavedStateHandle savedStateHandle2, PaymentOptionContract.Args args2) {
            LinkPaymentLauncher_Factory create = LinkPaymentLauncher_Factory.create(this.flowControllerComponent.appContextProvider, this.flowControllerComponent.provideProductUsageTokensProvider, this.flowControllerComponent.providePublishableKeyProvider, this.flowControllerComponent.provideStripeAccountIdProvider, this.flowControllerComponent.provideEnabledLoggingProvider, this.flowControllerComponent.provideWorkContextProvider, this.flowControllerComponent.provideUIContextProvider, this.flowControllerComponent.paymentAnalyticsRequestFactoryProvider, this.flowControllerComponent.defaultAnalyticsRequestExecutorProvider, this.flowControllerComponent.stripeApiRepositoryProvider);
            this.linkPaymentLauncherProvider = create;
            this.linkPaymentLauncherFactoryProvider = LinkPaymentLauncherFactory_Impl.create(create);
        }

        public PaymentOptionsViewModel getViewModel() {
            return new PaymentOptionsViewModel(this.args, (Function1) this.flowControllerComponent.providePrefsRepositoryFactoryProvider.get(), (EventReporter) this.flowControllerComponent.defaultEventReporterProvider.get(), (CustomerRepository) this.flowControllerComponent.customerApiRepositoryProvider.get(), (CoroutineContext) this.flowControllerComponent.provideWorkContextProvider.get(), this.application, (Logger) this.flowControllerComponent.provideLoggerProvider.get(), this.flowControllerComponent.injectorKey, (ResourceRepository) this.flowControllerComponent.asyncResourceRepositoryProvider.get(), this.savedStateHandle, this.linkPaymentLauncherFactoryProvider.get());
        }
    }

    private static final class FormViewModelSubcomponentImpl implements FormViewModelSubcomponent {
        private final DaggerFlowControllerComponent flowControllerComponent;
        private final FormFragmentArguments formFragmentArguments;
        private final FormViewModelSubcomponentImpl formViewModelSubcomponentImpl;
        private final LayoutSpec layout;

        private FormViewModelSubcomponentImpl(DaggerFlowControllerComponent daggerFlowControllerComponent, LayoutSpec layoutSpec, FormFragmentArguments formFragmentArguments2) {
            this.formViewModelSubcomponentImpl = this;
            this.flowControllerComponent = daggerFlowControllerComponent;
            this.layout = layoutSpec;
            this.formFragmentArguments = formFragmentArguments2;
        }

        private TransformSpecToElement transformSpecToElement() {
            return new TransformSpecToElement((ResourceRepository) this.flowControllerComponent.asyncResourceRepositoryProvider.get(), this.formFragmentArguments, this.flowControllerComponent.appContext);
        }

        public FormViewModel getViewModel() {
            return new FormViewModel(this.layout, this.formFragmentArguments, (ResourceRepository) this.flowControllerComponent.asyncResourceRepositoryProvider.get(), transformSpecToElement());
        }
    }
}

package com.stripe.android.payments.core.injection;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.ApiRequest_Options_Factory;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor_Factory;
import com.stripe.android.core.networking.RetryDelaySupplier;
import com.stripe.android.core.networking.RetryDelaySupplier_Factory;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.PaymentIntentFlowResultProcessor;
import com.stripe.android.payments.PaymentIntentFlowResultProcessor_Factory;
import com.stripe.android.payments.SetupIntentFlowResultProcessor;
import com.stripe.android.payments.SetupIntentFlowResultProcessor_Factory;
import com.stripe.android.payments.core.authentication.PaymentAuthenticatorRegistry;
import com.stripe.android.payments.core.injection.PaymentLauncherComponent;
import com.stripe.android.payments.core.injection.PaymentLauncherViewModelSubcomponent;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel_Factory_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public final class DaggerPaymentLauncherComponent implements PaymentLauncherComponent {
    /* access modifiers changed from: private */
    public final PaymentAnalyticsRequestFactory analyticsRequestFactory;
    private Provider<PaymentAnalyticsRequestFactory> analyticsRequestFactoryProvider;
    private final Context context;
    private Provider<Context> contextProvider;
    private Provider<DefaultAnalyticsRequestExecutor> defaultAnalyticsRequestExecutorProvider;
    private Provider<Boolean> enableLoggingProvider;
    private final CoroutineContext ioContext;
    private Provider<CoroutineContext> ioContextProvider;
    /* access modifiers changed from: private */
    public Provider<PaymentIntentFlowResultProcessor> paymentIntentFlowResultProcessorProvider;
    /* access modifiers changed from: private */
    public final DaggerPaymentLauncherComponent paymentLauncherComponent;
    private final PaymentLauncherModule paymentLauncherModule;
    private Provider<PaymentLauncherViewModelSubcomponent.Builder> paymentLauncherViewModelSubcomponentBuilderProvider;
    private Provider<Set<String>> productUsageProvider;
    /* access modifiers changed from: private */
    public Provider<DefaultReturnUrl> provideDefaultReturnUrlProvider;
    private Provider<Boolean> provideIsInstantAppProvider;
    private Provider<Logger> provideLoggerProvider;
    /* access modifiers changed from: private */
    public Provider<PaymentAuthenticatorRegistry> providePaymentAuthenticatorRegistryProvider;
    /* access modifiers changed from: private */
    public Provider<Map<String, String>> provideThreeDs1IntentReturnUrlMapProvider;
    /* access modifiers changed from: private */
    public Provider<Function0<String>> publishableKeyProvider;
    private Provider<RetryDelaySupplier> retryDelaySupplierProvider;
    /* access modifiers changed from: private */
    public Provider<SetupIntentFlowResultProcessor> setupIntentFlowResultProcessorProvider;
    /* access modifiers changed from: private */
    public Provider<Function0<String>> stripeAccountIdProvider;
    /* access modifiers changed from: private */
    public final StripeRepository stripeRepository;
    private Provider<StripeRepository> stripeRepositoryProvider;
    /* access modifiers changed from: private */
    public final CoroutineContext uiContext;
    private Provider<CoroutineContext> uiContextProvider;

    private DaggerPaymentLauncherComponent(PaymentLauncherModule paymentLauncherModule2, LoggingModule loggingModule, Context context2, Boolean bool, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, StripeRepository stripeRepository2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, Function0<String> function0, Function0<String> function02, Set<String> set) {
        this.paymentLauncherComponent = this;
        this.stripeRepository = stripeRepository2;
        this.ioContext = coroutineContext;
        this.analyticsRequestFactory = paymentAnalyticsRequestFactory;
        this.uiContext = coroutineContext2;
        this.context = context2;
        this.paymentLauncherModule = paymentLauncherModule2;
        initialize(paymentLauncherModule2, loggingModule, context2, bool, coroutineContext, coroutineContext2, stripeRepository2, paymentAnalyticsRequestFactory, function0, function02, set);
    }

    public static PaymentLauncherComponent.Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    public DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor() {
        return new DefaultAnalyticsRequestExecutor(this.provideLoggerProvider.get(), this.ioContext);
    }

    /* access modifiers changed from: private */
    public boolean namedBoolean() {
        return this.paymentLauncherModule.provideIsInstantApp(this.context);
    }

    private void initialize(PaymentLauncherModule paymentLauncherModule2, LoggingModule loggingModule, Context context2, Boolean bool, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, StripeRepository stripeRepository2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, Function0<String> function0, Function0<String> function02, Set<String> set) {
        PaymentLauncherModule paymentLauncherModule3 = paymentLauncherModule2;
        this.paymentLauncherViewModelSubcomponentBuilderProvider = new Provider<PaymentLauncherViewModelSubcomponent.Builder>() {
            public PaymentLauncherViewModelSubcomponent.Builder get() {
                return new PaymentLauncherViewModelSubcomponentBuilder();
            }
        };
        this.contextProvider = InstanceFactory.create(context2);
        this.stripeRepositoryProvider = InstanceFactory.create(stripeRepository2);
        this.enableLoggingProvider = InstanceFactory.create(bool);
        this.ioContextProvider = InstanceFactory.create(coroutineContext);
        this.uiContextProvider = InstanceFactory.create(coroutineContext2);
        this.provideThreeDs1IntentReturnUrlMapProvider = DoubleCheck.provider(PaymentLauncherModule_ProvideThreeDs1IntentReturnUrlMapFactory.create(paymentLauncherModule2));
        Provider<Logger> provider = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, this.enableLoggingProvider));
        this.provideLoggerProvider = provider;
        this.defaultAnalyticsRequestExecutorProvider = DefaultAnalyticsRequestExecutor_Factory.create(provider, this.ioContextProvider);
        this.analyticsRequestFactoryProvider = InstanceFactory.create(paymentAnalyticsRequestFactory);
        this.publishableKeyProvider = InstanceFactory.create(function0);
        this.productUsageProvider = InstanceFactory.create(set);
        PaymentLauncherModule_ProvideIsInstantAppFactory create = PaymentLauncherModule_ProvideIsInstantAppFactory.create(paymentLauncherModule2, this.contextProvider);
        this.provideIsInstantAppProvider = create;
        this.providePaymentAuthenticatorRegistryProvider = DoubleCheck.provider(PaymentLauncherModule_ProvidePaymentAuthenticatorRegistryFactory.create(paymentLauncherModule2, this.contextProvider, this.stripeRepositoryProvider, this.enableLoggingProvider, this.ioContextProvider, this.uiContextProvider, this.provideThreeDs1IntentReturnUrlMapProvider, this.defaultAnalyticsRequestExecutorProvider, this.analyticsRequestFactoryProvider, this.publishableKeyProvider, this.productUsageProvider, create));
        this.provideDefaultReturnUrlProvider = DoubleCheck.provider(PaymentLauncherModule_ProvideDefaultReturnUrlFactory.create(paymentLauncherModule2, this.contextProvider));
        this.stripeAccountIdProvider = InstanceFactory.create(function02);
        Provider<RetryDelaySupplier> provider2 = DoubleCheck.provider(RetryDelaySupplier_Factory.create());
        this.retryDelaySupplierProvider = provider2;
        this.paymentIntentFlowResultProcessorProvider = DoubleCheck.provider(PaymentIntentFlowResultProcessor_Factory.create(this.contextProvider, this.publishableKeyProvider, this.stripeRepositoryProvider, this.provideLoggerProvider, this.ioContextProvider, provider2));
        this.setupIntentFlowResultProcessorProvider = DoubleCheck.provider(SetupIntentFlowResultProcessor_Factory.create(this.contextProvider, this.publishableKeyProvider, this.stripeRepositoryProvider, this.provideLoggerProvider, this.ioContextProvider));
    }

    public void inject(PaymentLauncherViewModel.Factory factory) {
        injectFactory(factory);
    }

    private PaymentLauncherViewModel.Factory injectFactory(PaymentLauncherViewModel.Factory factory) {
        PaymentLauncherViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.paymentLauncherViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private static final class Builder implements PaymentLauncherComponent.Builder {
        private PaymentAnalyticsRequestFactory analyticsRequestFactory;
        private Context context;
        private Boolean enableLogging;
        private CoroutineContext ioContext;
        private Set<String> productUsage;
        private Function0<String> publishableKeyProvider;
        private Function0<String> stripeAccountIdProvider;
        private StripeRepository stripeRepository;
        private CoroutineContext uiContext;

        private Builder() {
        }

        public Builder context(Context context2) {
            this.context = (Context) Preconditions.checkNotNull(context2);
            return this;
        }

        public Builder enableLogging(boolean z) {
            this.enableLogging = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        public Builder ioContext(CoroutineContext coroutineContext) {
            this.ioContext = (CoroutineContext) Preconditions.checkNotNull(coroutineContext);
            return this;
        }

        public Builder uiContext(CoroutineContext coroutineContext) {
            this.uiContext = (CoroutineContext) Preconditions.checkNotNull(coroutineContext);
            return this;
        }

        public Builder stripeRepository(StripeRepository stripeRepository2) {
            this.stripeRepository = (StripeRepository) Preconditions.checkNotNull(stripeRepository2);
            return this;
        }

        public Builder analyticsRequestFactory(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory) {
            this.analyticsRequestFactory = (PaymentAnalyticsRequestFactory) Preconditions.checkNotNull(paymentAnalyticsRequestFactory);
            return this;
        }

        public Builder publishableKeyProvider(Function0<String> function0) {
            this.publishableKeyProvider = (Function0) Preconditions.checkNotNull(function0);
            return this;
        }

        public Builder stripeAccountIdProvider(Function0<String> function0) {
            this.stripeAccountIdProvider = (Function0) Preconditions.checkNotNull(function0);
            return this;
        }

        public Builder productUsage(Set<String> set) {
            this.productUsage = (Set) Preconditions.checkNotNull(set);
            return this;
        }

        public PaymentLauncherComponent build() {
            Preconditions.checkBuilderRequirement(this.context, Context.class);
            Preconditions.checkBuilderRequirement(this.enableLogging, Boolean.class);
            Preconditions.checkBuilderRequirement(this.ioContext, CoroutineContext.class);
            Preconditions.checkBuilderRequirement(this.uiContext, CoroutineContext.class);
            Preconditions.checkBuilderRequirement(this.stripeRepository, StripeRepository.class);
            Preconditions.checkBuilderRequirement(this.analyticsRequestFactory, PaymentAnalyticsRequestFactory.class);
            Preconditions.checkBuilderRequirement(this.publishableKeyProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.stripeAccountIdProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.productUsage, Set.class);
            return new DaggerPaymentLauncherComponent(new PaymentLauncherModule(), new LoggingModule(), this.context, this.enableLogging, this.ioContext, this.uiContext, this.stripeRepository, this.analyticsRequestFactory, this.publishableKeyProvider, this.stripeAccountIdProvider, this.productUsage);
        }
    }

    private static final class PaymentLauncherViewModelSubcomponentBuilder implements PaymentLauncherViewModelSubcomponent.Builder {
        private Boolean isPaymentIntent;
        private final DaggerPaymentLauncherComponent paymentLauncherComponent;
        private SavedStateHandle savedStateHandle;

        private PaymentLauncherViewModelSubcomponentBuilder(DaggerPaymentLauncherComponent daggerPaymentLauncherComponent) {
            this.paymentLauncherComponent = daggerPaymentLauncherComponent;
        }

        public PaymentLauncherViewModelSubcomponentBuilder isPaymentIntent(boolean z) {
            this.isPaymentIntent = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        public PaymentLauncherViewModelSubcomponentBuilder savedStateHandle(SavedStateHandle savedStateHandle2) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(savedStateHandle2);
            return this;
        }

        public PaymentLauncherViewModelSubcomponent build() {
            Preconditions.checkBuilderRequirement(this.isPaymentIntent, Boolean.class);
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            return new PaymentLauncherViewModelSubcomponentImpl(this.isPaymentIntent, this.savedStateHandle);
        }
    }

    private static final class PaymentLauncherViewModelSubcomponentImpl implements PaymentLauncherViewModelSubcomponent {
        private final Boolean isPaymentIntent;
        private Provider<ApiRequest.Options> optionsProvider;
        private final DaggerPaymentLauncherComponent paymentLauncherComponent;
        private final PaymentLauncherViewModelSubcomponentImpl paymentLauncherViewModelSubcomponentImpl;
        private final SavedStateHandle savedStateHandle;

        private PaymentLauncherViewModelSubcomponentImpl(DaggerPaymentLauncherComponent daggerPaymentLauncherComponent, Boolean bool, SavedStateHandle savedStateHandle2) {
            this.paymentLauncherViewModelSubcomponentImpl = this;
            this.paymentLauncherComponent = daggerPaymentLauncherComponent;
            this.isPaymentIntent = bool;
            this.savedStateHandle = savedStateHandle2;
            initialize(bool, savedStateHandle2);
        }

        private void initialize(Boolean bool, SavedStateHandle savedStateHandle2) {
            this.optionsProvider = ApiRequest_Options_Factory.create(this.paymentLauncherComponent.publishableKeyProvider, this.paymentLauncherComponent.stripeAccountIdProvider);
        }

        public PaymentLauncherViewModel getViewModel() {
            return new PaymentLauncherViewModel(this.isPaymentIntent.booleanValue(), this.paymentLauncherComponent.stripeRepository, (PaymentAuthenticatorRegistry) this.paymentLauncherComponent.providePaymentAuthenticatorRegistryProvider.get(), (DefaultReturnUrl) this.paymentLauncherComponent.provideDefaultReturnUrlProvider.get(), this.optionsProvider, (Map) this.paymentLauncherComponent.provideThreeDs1IntentReturnUrlMapProvider.get(), DoubleCheck.lazy(this.paymentLauncherComponent.paymentIntentFlowResultProcessorProvider), DoubleCheck.lazy(this.paymentLauncherComponent.setupIntentFlowResultProcessorProvider), this.paymentLauncherComponent.defaultAnalyticsRequestExecutor(), this.paymentLauncherComponent.analyticsRequestFactory, this.paymentLauncherComponent.uiContext, this.savedStateHandle, this.paymentLauncherComponent.namedBoolean());
        }
    }
}

package com.stripe.android.payments.core.injection;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideUIContextFactory;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideWorkContextFactory;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.ApiRequest_Options_Factory;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor_Factory;
import com.stripe.android.core.networking.RetryDelaySupplier;
import com.stripe.android.core.networking.RetryDelaySupplier_Factory;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory_Factory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.networking.StripeApiRepository_Factory;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.PaymentIntentFlowResultProcessor;
import com.stripe.android.payments.PaymentIntentFlowResultProcessor_Factory;
import com.stripe.android.payments.SetupIntentFlowResultProcessor;
import com.stripe.android.payments.SetupIntentFlowResultProcessor_Factory;
import com.stripe.android.payments.core.authentication.PaymentAuthenticatorRegistry;
import com.stripe.android.payments.core.injection.PaymentLauncherViewModelFactoryComponent;
import com.stripe.android.payments.core.injection.PaymentLauncherViewModelSubcomponent;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel_Factory_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public final class DaggerPaymentLauncherViewModelFactoryComponent implements PaymentLauncherViewModelFactoryComponent {
    private final Context context;
    private Provider<Context> contextProvider;
    private Provider<DefaultAnalyticsRequestExecutor> defaultAnalyticsRequestExecutorProvider;
    private Provider<Boolean> enableLoggingProvider;
    private Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    /* access modifiers changed from: private */
    public Provider<PaymentIntentFlowResultProcessor> paymentIntentFlowResultProcessorProvider;
    private final PaymentLauncherModule paymentLauncherModule;
    /* access modifiers changed from: private */
    public final DaggerPaymentLauncherViewModelFactoryComponent paymentLauncherViewModelFactoryComponent;
    private Provider<PaymentLauncherViewModelSubcomponent.Builder> paymentLauncherViewModelSubcomponentBuilderProvider;
    private final Set<String> productUsage;
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
    public Provider<CoroutineContext> provideUIContextProvider;
    private Provider<CoroutineContext> provideWorkContextProvider;
    private final Function0<String> publishableKeyProvider;
    /* access modifiers changed from: private */
    public Provider<Function0<String>> publishableKeyProvider2;
    private Provider<RetryDelaySupplier> retryDelaySupplierProvider;
    /* access modifiers changed from: private */
    public Provider<SetupIntentFlowResultProcessor> setupIntentFlowResultProcessorProvider;
    /* access modifiers changed from: private */
    public Provider<Function0<String>> stripeAccountIdProvider;
    private Provider<StripeApiRepository> stripeApiRepositoryProvider;

    private DaggerPaymentLauncherViewModelFactoryComponent(PaymentLauncherModule paymentLauncherModule2, CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context2, Boolean bool, Function0<String> function0, Function0<String> function02, Set<String> set) {
        this.paymentLauncherViewModelFactoryComponent = this;
        this.context = context2;
        this.publishableKeyProvider = function0;
        this.productUsage = set;
        this.paymentLauncherModule = paymentLauncherModule2;
        initialize(paymentLauncherModule2, coroutineContextModule, loggingModule, context2, bool, function0, function02, set);
    }

    public static PaymentLauncherViewModelFactoryComponent.Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    public PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory() {
        return new PaymentAnalyticsRequestFactory(this.context, this.publishableKeyProvider, this.productUsage);
    }

    /* access modifiers changed from: private */
    public DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor() {
        return new DefaultAnalyticsRequestExecutor(this.provideLoggerProvider.get(), this.provideWorkContextProvider.get());
    }

    /* access modifiers changed from: private */
    public StripeApiRepository stripeApiRepository() {
        return new StripeApiRepository(this.context, this.publishableKeyProvider, this.provideWorkContextProvider.get(), this.productUsage, paymentAnalyticsRequestFactory(), (AnalyticsRequestExecutor) defaultAnalyticsRequestExecutor(), this.provideLoggerProvider.get());
    }

    /* access modifiers changed from: private */
    public boolean namedBoolean() {
        return this.paymentLauncherModule.provideIsInstantApp(this.context);
    }

    private void initialize(PaymentLauncherModule paymentLauncherModule2, CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context2, Boolean bool, Function0<String> function0, Function0<String> function02, Set<String> set) {
        PaymentLauncherModule paymentLauncherModule3 = paymentLauncherModule2;
        this.paymentLauncherViewModelSubcomponentBuilderProvider = new Provider<PaymentLauncherViewModelSubcomponent.Builder>() {
            public PaymentLauncherViewModelSubcomponent.Builder get() {
                return new PaymentLauncherViewModelSubcomponentBuilder();
            }
        };
        this.provideWorkContextProvider = DoubleCheck.provider(CoroutineContextModule_ProvideWorkContextFactory.create(coroutineContextModule));
        Factory create = InstanceFactory.create(bool);
        this.enableLoggingProvider = create;
        this.provideLoggerProvider = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, create));
        this.contextProvider = InstanceFactory.create(context2);
        this.publishableKeyProvider2 = InstanceFactory.create(function0);
        Factory<T> create2 = InstanceFactory.create(set);
        this.productUsageProvider = create2;
        this.paymentAnalyticsRequestFactoryProvider = PaymentAnalyticsRequestFactory_Factory.create(this.contextProvider, this.publishableKeyProvider2, create2);
        DefaultAnalyticsRequestExecutor_Factory create3 = DefaultAnalyticsRequestExecutor_Factory.create(this.provideLoggerProvider, this.provideWorkContextProvider);
        this.defaultAnalyticsRequestExecutorProvider = create3;
        this.stripeApiRepositoryProvider = StripeApiRepository_Factory.create(this.contextProvider, this.publishableKeyProvider2, this.provideWorkContextProvider, this.productUsageProvider, this.paymentAnalyticsRequestFactoryProvider, create3, this.provideLoggerProvider);
        this.provideUIContextProvider = DoubleCheck.provider(CoroutineContextModule_ProvideUIContextFactory.create(coroutineContextModule));
        this.provideThreeDs1IntentReturnUrlMapProvider = DoubleCheck.provider(PaymentLauncherModule_ProvideThreeDs1IntentReturnUrlMapFactory.create(paymentLauncherModule2));
        PaymentLauncherModule_ProvideIsInstantAppFactory create4 = PaymentLauncherModule_ProvideIsInstantAppFactory.create(paymentLauncherModule2, this.contextProvider);
        this.provideIsInstantAppProvider = create4;
        this.providePaymentAuthenticatorRegistryProvider = DoubleCheck.provider(PaymentLauncherModule_ProvidePaymentAuthenticatorRegistryFactory.create(paymentLauncherModule2, this.contextProvider, this.stripeApiRepositoryProvider, this.enableLoggingProvider, this.provideWorkContextProvider, this.provideUIContextProvider, this.provideThreeDs1IntentReturnUrlMapProvider, this.defaultAnalyticsRequestExecutorProvider, this.paymentAnalyticsRequestFactoryProvider, this.publishableKeyProvider2, this.productUsageProvider, create4));
        this.provideDefaultReturnUrlProvider = DoubleCheck.provider(PaymentLauncherModule_ProvideDefaultReturnUrlFactory.create(paymentLauncherModule2, this.contextProvider));
        this.stripeAccountIdProvider = InstanceFactory.create(function02);
        Provider<RetryDelaySupplier> provider = DoubleCheck.provider(RetryDelaySupplier_Factory.create());
        this.retryDelaySupplierProvider = provider;
        this.paymentIntentFlowResultProcessorProvider = DoubleCheck.provider(PaymentIntentFlowResultProcessor_Factory.create(this.contextProvider, this.publishableKeyProvider2, this.stripeApiRepositoryProvider, this.provideLoggerProvider, this.provideWorkContextProvider, provider));
        this.setupIntentFlowResultProcessorProvider = DoubleCheck.provider(SetupIntentFlowResultProcessor_Factory.create(this.contextProvider, this.publishableKeyProvider2, this.stripeApiRepositoryProvider, this.provideLoggerProvider, this.provideWorkContextProvider));
    }

    public void inject(PaymentLauncherViewModel.Factory factory) {
        injectFactory(factory);
    }

    private PaymentLauncherViewModel.Factory injectFactory(PaymentLauncherViewModel.Factory factory) {
        PaymentLauncherViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.paymentLauncherViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private static final class Builder implements PaymentLauncherViewModelFactoryComponent.Builder {
        private Context context;
        private Boolean enableLogging;
        private Set<String> productUsage;
        private Function0<String> publishableKeyProvider;
        private Function0<String> stripeAccountIdProvider;

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

        public PaymentLauncherViewModelFactoryComponent build() {
            Preconditions.checkBuilderRequirement(this.context, Context.class);
            Preconditions.checkBuilderRequirement(this.enableLogging, Boolean.class);
            Preconditions.checkBuilderRequirement(this.publishableKeyProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.stripeAccountIdProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.productUsage, Set.class);
            return new DaggerPaymentLauncherViewModelFactoryComponent(new PaymentLauncherModule(), new CoroutineContextModule(), new LoggingModule(), this.context, this.enableLogging, this.publishableKeyProvider, this.stripeAccountIdProvider, this.productUsage);
        }
    }

    private static final class PaymentLauncherViewModelSubcomponentBuilder implements PaymentLauncherViewModelSubcomponent.Builder {
        private Boolean isPaymentIntent;
        private final DaggerPaymentLauncherViewModelFactoryComponent paymentLauncherViewModelFactoryComponent;
        private SavedStateHandle savedStateHandle;

        private PaymentLauncherViewModelSubcomponentBuilder(DaggerPaymentLauncherViewModelFactoryComponent daggerPaymentLauncherViewModelFactoryComponent) {
            this.paymentLauncherViewModelFactoryComponent = daggerPaymentLauncherViewModelFactoryComponent;
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
        private final DaggerPaymentLauncherViewModelFactoryComponent paymentLauncherViewModelFactoryComponent;
        private final PaymentLauncherViewModelSubcomponentImpl paymentLauncherViewModelSubcomponentImpl;
        private final SavedStateHandle savedStateHandle;

        private PaymentLauncherViewModelSubcomponentImpl(DaggerPaymentLauncherViewModelFactoryComponent daggerPaymentLauncherViewModelFactoryComponent, Boolean bool, SavedStateHandle savedStateHandle2) {
            this.paymentLauncherViewModelSubcomponentImpl = this;
            this.paymentLauncherViewModelFactoryComponent = daggerPaymentLauncherViewModelFactoryComponent;
            this.isPaymentIntent = bool;
            this.savedStateHandle = savedStateHandle2;
            initialize(bool, savedStateHandle2);
        }

        private void initialize(Boolean bool, SavedStateHandle savedStateHandle2) {
            this.optionsProvider = ApiRequest_Options_Factory.create(this.paymentLauncherViewModelFactoryComponent.publishableKeyProvider2, this.paymentLauncherViewModelFactoryComponent.stripeAccountIdProvider);
        }

        public PaymentLauncherViewModel getViewModel() {
            return new PaymentLauncherViewModel(this.isPaymentIntent.booleanValue(), this.paymentLauncherViewModelFactoryComponent.stripeApiRepository(), (PaymentAuthenticatorRegistry) this.paymentLauncherViewModelFactoryComponent.providePaymentAuthenticatorRegistryProvider.get(), (DefaultReturnUrl) this.paymentLauncherViewModelFactoryComponent.provideDefaultReturnUrlProvider.get(), this.optionsProvider, (Map) this.paymentLauncherViewModelFactoryComponent.provideThreeDs1IntentReturnUrlMapProvider.get(), DoubleCheck.lazy(this.paymentLauncherViewModelFactoryComponent.paymentIntentFlowResultProcessorProvider), DoubleCheck.lazy(this.paymentLauncherViewModelFactoryComponent.setupIntentFlowResultProcessorProvider), this.paymentLauncherViewModelFactoryComponent.defaultAnalyticsRequestExecutor(), this.paymentLauncherViewModelFactoryComponent.paymentAnalyticsRequestFactory(), (CoroutineContext) this.paymentLauncherViewModelFactoryComponent.provideUIContextProvider.get(), this.savedStateHandle, this.paymentLauncherViewModelFactoryComponent.namedBoolean());
        }
    }
}

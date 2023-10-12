package com.stripe.android.payments.core.injection;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.PaymentAuthConfig;
import com.stripe.android.PaymentBrowserAuthStarter;
import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.RetryDelaySupplier;
import com.stripe.android.core.networking.RetryDelaySupplier_Factory;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.core.authentication.DefaultPaymentAuthenticatorRegistry;
import com.stripe.android.payments.core.authentication.DefaultPaymentAuthenticatorRegistry_Factory;
import com.stripe.android.payments.core.authentication.NoOpIntentAuthenticator;
import com.stripe.android.payments.core.authentication.NoOpIntentAuthenticator_Factory;
import com.stripe.android.payments.core.authentication.OxxoAuthenticator;
import com.stripe.android.payments.core.authentication.OxxoAuthenticator_Factory;
import com.stripe.android.payments.core.authentication.PaymentAuthenticator;
import com.stripe.android.payments.core.authentication.SourceAuthenticator;
import com.stripe.android.payments.core.authentication.SourceAuthenticator_Factory;
import com.stripe.android.payments.core.authentication.UnsupportedAuthenticator;
import com.stripe.android.payments.core.authentication.UnsupportedAuthenticator_Factory;
import com.stripe.android.payments.core.authentication.WebIntentAuthenticator;
import com.stripe.android.payments.core.authentication.WebIntentAuthenticator_Factory;
import com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor;
import com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor_Factory;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3DS2Authenticator;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3DS2Authenticator_Factory;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2ChallengeResultProcessor;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModelFactory;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModelFactory_MembersInjector;
import com.stripe.android.payments.core.injection.AuthenticationComponent;
import com.stripe.android.payments.core.injection.Stripe3ds2TransactionViewModelSubcomponent;
import com.stripe.android.stripe3ds2.service.StripeThreeDs2Service;
import com.stripe.android.stripe3ds2.transaction.InitChallengeRepository;
import com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry;
import com.stripe.android.view.AuthActivityStarterHost;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class DaggerAuthenticationComponent implements AuthenticationComponent {
    /* access modifiers changed from: private */
    public final AnalyticsRequestExecutor analyticsRequestExecutor;
    private Provider<AnalyticsRequestExecutor> analyticsRequestExecutorProvider;
    /* access modifiers changed from: private */
    public final PaymentAnalyticsRequestFactory analyticsRequestFactory;
    private Provider<PaymentAnalyticsRequestFactory> analyticsRequestFactoryProvider;
    private final DaggerAuthenticationComponent authenticationComponent;
    private Provider<Context> contextProvider;
    private Provider<DefaultPaymentAuthenticatorRegistry> defaultPaymentAuthenticatorRegistryProvider;
    /* access modifiers changed from: private */
    public Provider<DefaultStripe3ds2ChallengeResultProcessor> defaultStripe3ds2ChallengeResultProcessorProvider;
    private Provider<Boolean> enableLoggingProvider;
    private Provider<String> injectorKeyProvider;
    private Provider<Map<Class<? extends StripeIntent.NextActionData>, PaymentAuthenticator<StripeIntent>>> intentAuthenticatorMapMapOfClassOfAndPaymentAuthenticatorOfStripeIntentProvider;
    /* access modifiers changed from: private */
    public final Boolean isInstantApp;
    private Provider<Boolean> isInstantAppProvider;
    private Provider<NoOpIntentAuthenticator> noOpIntentAuthenticatorProvider;
    private Provider<OxxoAuthenticator> oxxoAuthenticatorProvider;
    private Provider<Set<String>> productUsageProvider;
    private Provider<DefaultReturnUrl> provideDefaultReturnUrlProvider;
    private Provider<Logger> provideLoggerProvider;
    /* access modifiers changed from: private */
    public Provider<MessageVersionRegistry> provideMessageVersionRegistryProvider;
    private Provider<PaymentAuthConfig> providePaymentAuthConfigProvider;
    private Provider<Function1<AuthActivityStarterHost, PaymentBrowserAuthStarter>> providePaymentBrowserAuthStarterFactoryProvider;
    private Provider<Function1<AuthActivityStarterHost, PaymentRelayStarter>> providePaymentRelayStarterFactoryProvider;
    /* access modifiers changed from: private */
    public Provider<StripeThreeDs2Service> provideStripeThreeDs2ServiceProvider;
    private Provider<PaymentAuthenticator<StripeIntent>> provideWeChatAuthenticator$payments_core_releaseProvider;
    private Provider<Function0<String>> publishableKeyProvider;
    private Provider<RetryDelaySupplier> retryDelaySupplierProvider;
    private Provider<SourceAuthenticator> sourceAuthenticatorProvider;
    private Provider<Stripe3DS2Authenticator> stripe3DS2AuthenticatorProvider;
    /* access modifiers changed from: private */
    public final StripeRepository stripeRepository;
    private Provider<StripeRepository> stripeRepositoryProvider;
    private Provider<Map<String, String>> threeDs1IntentReturnUrlMapProvider;
    private Provider<CoroutineContext> uiContextProvider;
    private Provider<UnsupportedAuthenticator> unsupportedAuthenticatorProvider;
    private Provider<WebIntentAuthenticator> webIntentAuthenticatorProvider;
    /* access modifiers changed from: private */
    public final CoroutineContext workContext;
    private Provider<CoroutineContext> workContextProvider;

    private DaggerAuthenticationComponent(WeChatPayAuthenticatorModule weChatPayAuthenticatorModule, LoggingModule loggingModule, Context context, StripeRepository stripeRepository2, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, Boolean bool, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, Map<String, String> map, String str, Function0<String> function0, Set<String> set, Boolean bool2) {
        this.authenticationComponent = this;
        this.stripeRepository = stripeRepository2;
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.analyticsRequestFactory = paymentAnalyticsRequestFactory;
        this.workContext = coroutineContext;
        this.isInstantApp = bool2;
        initialize(weChatPayAuthenticatorModule, loggingModule, context, stripeRepository2, analyticsRequestExecutor2, paymentAnalyticsRequestFactory, bool, coroutineContext, coroutineContext2, map, str, function0, set, bool2);
    }

    public static AuthenticationComponent.Builder builder() {
        return new Builder();
    }

    private void initialize(WeChatPayAuthenticatorModule weChatPayAuthenticatorModule, LoggingModule loggingModule, Context context, StripeRepository stripeRepository2, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, Boolean bool, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, Map<String, String> map, String str, Function0<String> function0, Set<String> set, Boolean bool2) {
        DelegateFactory delegateFactory = new DelegateFactory();
        this.defaultPaymentAuthenticatorRegistryProvider = delegateFactory;
        Provider<Function1<AuthActivityStarterHost, PaymentRelayStarter>> provider = DoubleCheck.provider(AuthenticationModule_Companion_ProvidePaymentRelayStarterFactoryFactory.create(delegateFactory));
        this.providePaymentRelayStarterFactoryProvider = provider;
        this.noOpIntentAuthenticatorProvider = DoubleCheck.provider(NoOpIntentAuthenticator_Factory.create(provider));
        Factory create = InstanceFactory.create(context);
        this.contextProvider = create;
        Provider<DefaultReturnUrl> provider2 = DoubleCheck.provider(AuthenticationModule_Companion_ProvideDefaultReturnUrlFactory.create(create));
        this.provideDefaultReturnUrlProvider = provider2;
        this.providePaymentBrowserAuthStarterFactoryProvider = DoubleCheck.provider(AuthenticationModule_Companion_ProvidePaymentBrowserAuthStarterFactoryFactory.create(this.defaultPaymentAuthenticatorRegistryProvider, provider2));
        this.analyticsRequestExecutorProvider = InstanceFactory.create(analyticsRequestExecutor2);
        this.analyticsRequestFactoryProvider = InstanceFactory.create(paymentAnalyticsRequestFactory);
        this.enableLoggingProvider = InstanceFactory.create(bool);
        this.uiContextProvider = InstanceFactory.create(coroutineContext2);
        this.publishableKeyProvider = InstanceFactory.create(function0);
        Factory create2 = InstanceFactory.create(bool2);
        this.isInstantAppProvider = create2;
        this.sourceAuthenticatorProvider = DoubleCheck.provider(SourceAuthenticator_Factory.create(this.providePaymentBrowserAuthStarterFactoryProvider, this.providePaymentRelayStarterFactoryProvider, this.analyticsRequestExecutorProvider, this.analyticsRequestFactoryProvider, this.enableLoggingProvider, this.uiContextProvider, this.publishableKeyProvider, create2));
        Provider<UnsupportedAuthenticator> provider3 = DoubleCheck.provider(UnsupportedAuthenticator_Factory.create(this.providePaymentRelayStarterFactoryProvider));
        this.unsupportedAuthenticatorProvider = provider3;
        WeChatPayAuthenticatorModule weChatPayAuthenticatorModule2 = weChatPayAuthenticatorModule;
        this.provideWeChatAuthenticator$payments_core_releaseProvider = WeChatPayAuthenticatorModule_ProvideWeChatAuthenticator$payments_core_releaseFactory.create(weChatPayAuthenticatorModule, provider3);
        Factory<T> create3 = InstanceFactory.create(map);
        this.threeDs1IntentReturnUrlMapProvider = create3;
        Provider<WebIntentAuthenticator> provider4 = DoubleCheck.provider(WebIntentAuthenticator_Factory.create(this.providePaymentBrowserAuthStarterFactoryProvider, this.analyticsRequestExecutorProvider, this.analyticsRequestFactoryProvider, this.enableLoggingProvider, this.uiContextProvider, create3, this.publishableKeyProvider, this.isInstantAppProvider));
        this.webIntentAuthenticatorProvider = provider4;
        this.oxxoAuthenticatorProvider = DoubleCheck.provider(OxxoAuthenticator_Factory.create(provider4, this.noOpIntentAuthenticatorProvider));
        this.providePaymentAuthConfigProvider = DoubleCheck.provider(Stripe3DSAuthenticatorModule_Companion_ProvidePaymentAuthConfigFactory.create());
        this.injectorKeyProvider = InstanceFactory.create(str);
        Factory<T> create4 = InstanceFactory.create(set);
        this.productUsageProvider = create4;
        this.stripe3DS2AuthenticatorProvider = DoubleCheck.provider(Stripe3DS2Authenticator_Factory.create(this.providePaymentAuthConfigProvider, this.enableLoggingProvider, this.injectorKeyProvider, this.publishableKeyProvider, create4));
        MapFactory build = MapFactory.builder(6).put((Object) StripeIntent.NextActionData.WeChatPayRedirect.class, (Provider) this.provideWeChatAuthenticator$payments_core_releaseProvider).put((Object) StripeIntent.NextActionData.SdkData.Use3DS1.class, (Provider) this.webIntentAuthenticatorProvider).put((Object) StripeIntent.NextActionData.RedirectToUrl.class, (Provider) this.webIntentAuthenticatorProvider).put((Object) StripeIntent.NextActionData.AlipayRedirect.class, (Provider) this.webIntentAuthenticatorProvider).put((Object) StripeIntent.NextActionData.DisplayOxxoDetails.class, (Provider) this.oxxoAuthenticatorProvider).put((Object) StripeIntent.NextActionData.SdkData.Use3DS2.class, (Provider) this.stripe3DS2AuthenticatorProvider).build();
        this.intentAuthenticatorMapMapOfClassOfAndPaymentAuthenticatorOfStripeIntentProvider = build;
        DelegateFactory.setDelegate(this.defaultPaymentAuthenticatorRegistryProvider, DoubleCheck.provider(DefaultPaymentAuthenticatorRegistry_Factory.create(this.noOpIntentAuthenticatorProvider, this.sourceAuthenticatorProvider, build)));
        Factory create5 = InstanceFactory.create(coroutineContext);
        this.workContextProvider = create5;
        this.provideStripeThreeDs2ServiceProvider = DoubleCheck.provider(Stripe3ds2TransactionModule_Companion_ProvideStripeThreeDs2ServiceFactory.create(this.contextProvider, this.enableLoggingProvider, create5));
        this.provideMessageVersionRegistryProvider = DoubleCheck.provider(Stripe3ds2TransactionModule_Companion_ProvideMessageVersionRegistryFactory.create());
        this.stripeRepositoryProvider = InstanceFactory.create(stripeRepository2);
        this.retryDelaySupplierProvider = DoubleCheck.provider(RetryDelaySupplier_Factory.create());
        LoggingModule loggingModule2 = loggingModule;
        Provider<Logger> provider5 = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, this.enableLoggingProvider));
        this.provideLoggerProvider = provider5;
        this.defaultStripe3ds2ChallengeResultProcessorProvider = DoubleCheck.provider(DefaultStripe3ds2ChallengeResultProcessor_Factory.create(this.stripeRepositoryProvider, this.analyticsRequestExecutorProvider, this.analyticsRequestFactoryProvider, this.retryDelaySupplierProvider, provider5, this.workContextProvider));
    }

    public DefaultPaymentAuthenticatorRegistry getRegistry() {
        return this.defaultPaymentAuthenticatorRegistryProvider.get();
    }

    public void inject(Stripe3ds2TransactionViewModelFactory stripe3ds2TransactionViewModelFactory) {
        injectStripe3ds2TransactionViewModelFactory(stripe3ds2TransactionViewModelFactory);
    }

    private Stripe3ds2TransactionViewModelFactory injectStripe3ds2TransactionViewModelFactory(Stripe3ds2TransactionViewModelFactory stripe3ds2TransactionViewModelFactory) {
        Stripe3ds2TransactionViewModelFactory_MembersInjector.injectSubComponentBuilder(stripe3ds2TransactionViewModelFactory, new Stripe3ds2TransactionViewModelSubcomponentBuilder());
        return stripe3ds2TransactionViewModelFactory;
    }

    private static final class Builder implements AuthenticationComponent.Builder {
        private AnalyticsRequestExecutor analyticsRequestExecutor;
        private PaymentAnalyticsRequestFactory analyticsRequestFactory;
        private Context context;
        private Boolean enableLogging;
        private String injectorKey;
        private Boolean isInstantApp;
        private Set<String> productUsage;
        private Function0<String> publishableKeyProvider;
        private StripeRepository stripeRepository;
        private Map<String, String> threeDs1IntentReturnUrlMap;
        private CoroutineContext uiContext;
        private CoroutineContext workContext;

        private Builder() {
        }

        public Builder context(Context context2) {
            this.context = (Context) Preconditions.checkNotNull(context2);
            return this;
        }

        public Builder stripeRepository(StripeRepository stripeRepository2) {
            this.stripeRepository = (StripeRepository) Preconditions.checkNotNull(stripeRepository2);
            return this;
        }

        public Builder analyticsRequestExecutor(AnalyticsRequestExecutor analyticsRequestExecutor2) {
            this.analyticsRequestExecutor = (AnalyticsRequestExecutor) Preconditions.checkNotNull(analyticsRequestExecutor2);
            return this;
        }

        public Builder analyticsRequestFactory(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory) {
            this.analyticsRequestFactory = (PaymentAnalyticsRequestFactory) Preconditions.checkNotNull(paymentAnalyticsRequestFactory);
            return this;
        }

        public Builder enableLogging(boolean z) {
            this.enableLogging = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        public Builder workContext(CoroutineContext coroutineContext) {
            this.workContext = (CoroutineContext) Preconditions.checkNotNull(coroutineContext);
            return this;
        }

        public Builder uiContext(CoroutineContext coroutineContext) {
            this.uiContext = (CoroutineContext) Preconditions.checkNotNull(coroutineContext);
            return this;
        }

        public Builder threeDs1IntentReturnUrlMap(Map<String, String> map) {
            this.threeDs1IntentReturnUrlMap = (Map) Preconditions.checkNotNull(map);
            return this;
        }

        public Builder injectorKey(String str) {
            this.injectorKey = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public Builder publishableKeyProvider(Function0<String> function0) {
            this.publishableKeyProvider = (Function0) Preconditions.checkNotNull(function0);
            return this;
        }

        public Builder productUsage(Set<String> set) {
            this.productUsage = (Set) Preconditions.checkNotNull(set);
            return this;
        }

        public Builder isInstantApp(boolean z) {
            this.isInstantApp = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        public AuthenticationComponent build() {
            Preconditions.checkBuilderRequirement(this.context, Context.class);
            Preconditions.checkBuilderRequirement(this.stripeRepository, StripeRepository.class);
            Preconditions.checkBuilderRequirement(this.analyticsRequestExecutor, AnalyticsRequestExecutor.class);
            Preconditions.checkBuilderRequirement(this.analyticsRequestFactory, PaymentAnalyticsRequestFactory.class);
            Preconditions.checkBuilderRequirement(this.enableLogging, Boolean.class);
            Preconditions.checkBuilderRequirement(this.workContext, CoroutineContext.class);
            Preconditions.checkBuilderRequirement(this.uiContext, CoroutineContext.class);
            Preconditions.checkBuilderRequirement(this.threeDs1IntentReturnUrlMap, Map.class);
            Preconditions.checkBuilderRequirement(this.injectorKey, String.class);
            Preconditions.checkBuilderRequirement(this.publishableKeyProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.productUsage, Set.class);
            Preconditions.checkBuilderRequirement(this.isInstantApp, Boolean.class);
            return new DaggerAuthenticationComponent(new WeChatPayAuthenticatorModule(), new LoggingModule(), this.context, this.stripeRepository, this.analyticsRequestExecutor, this.analyticsRequestFactory, this.enableLogging, this.workContext, this.uiContext, this.threeDs1IntentReturnUrlMap, this.injectorKey, this.publishableKeyProvider, this.productUsage, this.isInstantApp);
        }
    }

    private static final class Stripe3ds2TransactionViewModelSubcomponentBuilder implements Stripe3ds2TransactionViewModelSubcomponent.Builder {
        private Application application;
        private Stripe3ds2TransactionContract.Args args;
        private final DaggerAuthenticationComponent authenticationComponent;
        private SavedStateHandle savedStateHandle;

        private Stripe3ds2TransactionViewModelSubcomponentBuilder(DaggerAuthenticationComponent daggerAuthenticationComponent) {
            this.authenticationComponent = daggerAuthenticationComponent;
        }

        public Stripe3ds2TransactionViewModelSubcomponentBuilder args(Stripe3ds2TransactionContract.Args args2) {
            this.args = (Stripe3ds2TransactionContract.Args) Preconditions.checkNotNull(args2);
            return this;
        }

        public Stripe3ds2TransactionViewModelSubcomponentBuilder savedStateHandle(SavedStateHandle savedStateHandle2) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(savedStateHandle2);
            return this;
        }

        public Stripe3ds2TransactionViewModelSubcomponentBuilder application(Application application2) {
            this.application = (Application) Preconditions.checkNotNull(application2);
            return this;
        }

        public Stripe3ds2TransactionViewModelSubcomponent build() {
            Preconditions.checkBuilderRequirement(this.args, Stripe3ds2TransactionContract.Args.class);
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            Preconditions.checkBuilderRequirement(this.application, Application.class);
            return new Stripe3ds2TransactionViewModelSubcomponentImpl(new Stripe3dsTransactionViewModelModule(), this.args, this.savedStateHandle, this.application);
        }
    }

    private static final class Stripe3ds2TransactionViewModelSubcomponentImpl implements Stripe3ds2TransactionViewModelSubcomponent {
        private final Application application;
        private final Stripe3ds2TransactionContract.Args args;
        private final DaggerAuthenticationComponent authenticationComponent;
        private final SavedStateHandle savedStateHandle;
        private final Stripe3ds2TransactionViewModelSubcomponentImpl stripe3ds2TransactionViewModelSubcomponentImpl;
        private final Stripe3dsTransactionViewModelModule stripe3dsTransactionViewModelModule;

        private Stripe3ds2TransactionViewModelSubcomponentImpl(DaggerAuthenticationComponent daggerAuthenticationComponent, Stripe3dsTransactionViewModelModule stripe3dsTransactionViewModelModule2, Stripe3ds2TransactionContract.Args args2, SavedStateHandle savedStateHandle2, Application application2) {
            this.stripe3ds2TransactionViewModelSubcomponentImpl = this;
            this.authenticationComponent = daggerAuthenticationComponent;
            this.args = args2;
            this.stripe3dsTransactionViewModelModule = stripe3dsTransactionViewModelModule2;
            this.application = application2;
            this.savedStateHandle = savedStateHandle2;
        }

        private InitChallengeRepository initChallengeRepository() {
            return Stripe3dsTransactionViewModelModule_ProvidesInitChallengeRepositoryFactory.providesInitChallengeRepository(this.stripe3dsTransactionViewModelModule, this.application, this.args, this.authenticationComponent.workContext);
        }

        public Stripe3ds2TransactionViewModel getViewModel() {
            return new Stripe3ds2TransactionViewModel(this.args, this.authenticationComponent.stripeRepository, this.authenticationComponent.analyticsRequestExecutor, this.authenticationComponent.analyticsRequestFactory, (StripeThreeDs2Service) this.authenticationComponent.provideStripeThreeDs2ServiceProvider.get(), (MessageVersionRegistry) this.authenticationComponent.provideMessageVersionRegistryProvider.get(), (Stripe3ds2ChallengeResultProcessor) this.authenticationComponent.defaultStripe3ds2ChallengeResultProcessorProvider.get(), initChallengeRepository(), this.authenticationComponent.workContext, this.savedStateHandle, this.authenticationComponent.isInstantApp.booleanValue());
        }
    }
}

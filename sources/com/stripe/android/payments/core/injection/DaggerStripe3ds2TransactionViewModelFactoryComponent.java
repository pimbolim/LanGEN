package com.stripe.android.payments.core.injection;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideWorkContextFactory;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor_Factory;
import com.stripe.android.core.networking.RetryDelaySupplier;
import com.stripe.android.core.networking.RetryDelaySupplier_Factory;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory_Factory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.networking.StripeApiRepository_Factory;
import com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor;
import com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor_Factory;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2ChallengeResultProcessor;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModelFactory;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModelFactory_MembersInjector;
import com.stripe.android.payments.core.injection.Stripe3ds2TransactionViewModelFactoryComponent;
import com.stripe.android.payments.core.injection.Stripe3ds2TransactionViewModelSubcomponent;
import com.stripe.android.stripe3ds2.service.StripeThreeDs2Service;
import com.stripe.android.stripe3ds2.transaction.InitChallengeRepository;
import com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public final class DaggerStripe3ds2TransactionViewModelFactoryComponent implements Stripe3ds2TransactionViewModelFactoryComponent {
    private final Context context;
    private Provider<Context> contextProvider;
    private Provider<DefaultAnalyticsRequestExecutor> defaultAnalyticsRequestExecutorProvider;
    /* access modifiers changed from: private */
    public Provider<DefaultStripe3ds2ChallengeResultProcessor> defaultStripe3ds2ChallengeResultProcessorProvider;
    private Provider<Boolean> enableLoggingProvider;
    /* access modifiers changed from: private */
    public final Boolean isInstantApp;
    private Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    private final Set<String> productUsage;
    private Provider<Set<String>> productUsageProvider;
    private Provider<Logger> provideLoggerProvider;
    /* access modifiers changed from: private */
    public Provider<MessageVersionRegistry> provideMessageVersionRegistryProvider;
    /* access modifiers changed from: private */
    public Provider<StripeThreeDs2Service> provideStripeThreeDs2ServiceProvider;
    /* access modifiers changed from: private */
    public Provider<CoroutineContext> provideWorkContextProvider;
    private final Function0<String> publishableKeyProvider;
    private Provider<Function0<String>> publishableKeyProvider2;
    private Provider<RetryDelaySupplier> retryDelaySupplierProvider;
    private final DaggerStripe3ds2TransactionViewModelFactoryComponent stripe3ds2TransactionViewModelFactoryComponent;
    private Provider<StripeApiRepository> stripeApiRepositoryProvider;

    private DaggerStripe3ds2TransactionViewModelFactoryComponent(CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context2, Boolean bool, Function0<String> function0, Set<String> set, Boolean bool2) {
        this.stripe3ds2TransactionViewModelFactoryComponent = this;
        this.context = context2;
        this.publishableKeyProvider = function0;
        this.productUsage = set;
        this.isInstantApp = bool2;
        initialize(coroutineContextModule, loggingModule, context2, bool, function0, set, bool2);
    }

    public static Stripe3ds2TransactionViewModelFactoryComponent.Builder builder() {
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

    private void initialize(CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context2, Boolean bool, Function0<String> function0, Set<String> set, Boolean bool2) {
        this.provideWorkContextProvider = DoubleCheck.provider(CoroutineContextModule_ProvideWorkContextFactory.create(coroutineContextModule));
        Factory create = InstanceFactory.create(bool);
        this.enableLoggingProvider = create;
        this.provideLoggerProvider = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, create));
        Factory create2 = InstanceFactory.create(context2);
        this.contextProvider = create2;
        this.provideStripeThreeDs2ServiceProvider = DoubleCheck.provider(Stripe3ds2TransactionModule_Companion_ProvideStripeThreeDs2ServiceFactory.create(create2, this.enableLoggingProvider, this.provideWorkContextProvider));
        this.provideMessageVersionRegistryProvider = DoubleCheck.provider(Stripe3ds2TransactionModule_Companion_ProvideMessageVersionRegistryFactory.create());
        this.publishableKeyProvider2 = InstanceFactory.create(function0);
        Factory<T> create3 = InstanceFactory.create(set);
        this.productUsageProvider = create3;
        this.paymentAnalyticsRequestFactoryProvider = PaymentAnalyticsRequestFactory_Factory.create(this.contextProvider, this.publishableKeyProvider2, create3);
        DefaultAnalyticsRequestExecutor_Factory create4 = DefaultAnalyticsRequestExecutor_Factory.create(this.provideLoggerProvider, this.provideWorkContextProvider);
        this.defaultAnalyticsRequestExecutorProvider = create4;
        this.stripeApiRepositoryProvider = StripeApiRepository_Factory.create(this.contextProvider, this.publishableKeyProvider2, this.provideWorkContextProvider, this.productUsageProvider, this.paymentAnalyticsRequestFactoryProvider, create4, this.provideLoggerProvider);
        Provider<RetryDelaySupplier> provider = DoubleCheck.provider(RetryDelaySupplier_Factory.create());
        this.retryDelaySupplierProvider = provider;
        this.defaultStripe3ds2ChallengeResultProcessorProvider = DoubleCheck.provider(DefaultStripe3ds2ChallengeResultProcessor_Factory.create(this.stripeApiRepositoryProvider, this.defaultAnalyticsRequestExecutorProvider, this.paymentAnalyticsRequestFactoryProvider, provider, this.provideLoggerProvider, this.provideWorkContextProvider));
    }

    public void inject(Stripe3ds2TransactionViewModelFactory stripe3ds2TransactionViewModelFactory) {
        injectStripe3ds2TransactionViewModelFactory(stripe3ds2TransactionViewModelFactory);
    }

    private Stripe3ds2TransactionViewModelFactory injectStripe3ds2TransactionViewModelFactory(Stripe3ds2TransactionViewModelFactory stripe3ds2TransactionViewModelFactory) {
        Stripe3ds2TransactionViewModelFactory_MembersInjector.injectSubComponentBuilder(stripe3ds2TransactionViewModelFactory, new Stripe3ds2TransactionViewModelSubcomponentBuilder());
        return stripe3ds2TransactionViewModelFactory;
    }

    private static final class Builder implements Stripe3ds2TransactionViewModelFactoryComponent.Builder {
        private Context context;
        private Boolean enableLogging;
        private Boolean isInstantApp;
        private Set<String> productUsage;
        private Function0<String> publishableKeyProvider;

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

        public Builder productUsage(Set<String> set) {
            this.productUsage = (Set) Preconditions.checkNotNull(set);
            return this;
        }

        public Builder isInstantApp(boolean z) {
            this.isInstantApp = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        public Stripe3ds2TransactionViewModelFactoryComponent build() {
            Preconditions.checkBuilderRequirement(this.context, Context.class);
            Preconditions.checkBuilderRequirement(this.enableLogging, Boolean.class);
            Preconditions.checkBuilderRequirement(this.publishableKeyProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.productUsage, Set.class);
            Preconditions.checkBuilderRequirement(this.isInstantApp, Boolean.class);
            return new DaggerStripe3ds2TransactionViewModelFactoryComponent(new CoroutineContextModule(), new LoggingModule(), this.context, this.enableLogging, this.publishableKeyProvider, this.productUsage, this.isInstantApp);
        }
    }

    private static final class Stripe3ds2TransactionViewModelSubcomponentBuilder implements Stripe3ds2TransactionViewModelSubcomponent.Builder {
        private Application application;
        private Stripe3ds2TransactionContract.Args args;
        private SavedStateHandle savedStateHandle;
        private final DaggerStripe3ds2TransactionViewModelFactoryComponent stripe3ds2TransactionViewModelFactoryComponent;

        private Stripe3ds2TransactionViewModelSubcomponentBuilder(DaggerStripe3ds2TransactionViewModelFactoryComponent daggerStripe3ds2TransactionViewModelFactoryComponent) {
            this.stripe3ds2TransactionViewModelFactoryComponent = daggerStripe3ds2TransactionViewModelFactoryComponent;
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
        private final SavedStateHandle savedStateHandle;
        private final DaggerStripe3ds2TransactionViewModelFactoryComponent stripe3ds2TransactionViewModelFactoryComponent;
        private final Stripe3ds2TransactionViewModelSubcomponentImpl stripe3ds2TransactionViewModelSubcomponentImpl;
        private final Stripe3dsTransactionViewModelModule stripe3dsTransactionViewModelModule;

        private Stripe3ds2TransactionViewModelSubcomponentImpl(DaggerStripe3ds2TransactionViewModelFactoryComponent daggerStripe3ds2TransactionViewModelFactoryComponent, Stripe3dsTransactionViewModelModule stripe3dsTransactionViewModelModule2, Stripe3ds2TransactionContract.Args args2, SavedStateHandle savedStateHandle2, Application application2) {
            this.stripe3ds2TransactionViewModelSubcomponentImpl = this;
            this.stripe3ds2TransactionViewModelFactoryComponent = daggerStripe3ds2TransactionViewModelFactoryComponent;
            this.args = args2;
            this.stripe3dsTransactionViewModelModule = stripe3dsTransactionViewModelModule2;
            this.application = application2;
            this.savedStateHandle = savedStateHandle2;
        }

        private InitChallengeRepository initChallengeRepository() {
            return Stripe3dsTransactionViewModelModule_ProvidesInitChallengeRepositoryFactory.providesInitChallengeRepository(this.stripe3dsTransactionViewModelModule, this.application, this.args, (CoroutineContext) this.stripe3ds2TransactionViewModelFactoryComponent.provideWorkContextProvider.get());
        }

        public Stripe3ds2TransactionViewModel getViewModel() {
            return new Stripe3ds2TransactionViewModel(this.args, this.stripe3ds2TransactionViewModelFactoryComponent.stripeApiRepository(), this.stripe3ds2TransactionViewModelFactoryComponent.defaultAnalyticsRequestExecutor(), this.stripe3ds2TransactionViewModelFactoryComponent.paymentAnalyticsRequestFactory(), (StripeThreeDs2Service) this.stripe3ds2TransactionViewModelFactoryComponent.provideStripeThreeDs2ServiceProvider.get(), (MessageVersionRegistry) this.stripe3ds2TransactionViewModelFactoryComponent.provideMessageVersionRegistryProvider.get(), (Stripe3ds2ChallengeResultProcessor) this.stripe3ds2TransactionViewModelFactoryComponent.defaultStripe3ds2ChallengeResultProcessorProvider.get(), initChallengeRepository(), (CoroutineContext) this.stripe3ds2TransactionViewModelFactoryComponent.provideWorkContextProvider.get(), this.savedStateHandle, this.stripe3ds2TransactionViewModelFactoryComponent.isInstantApp.booleanValue());
        }
    }
}

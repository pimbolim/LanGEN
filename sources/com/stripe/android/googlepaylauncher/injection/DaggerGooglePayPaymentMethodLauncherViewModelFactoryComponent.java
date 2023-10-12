package com.stripe.android.googlepaylauncher.injection;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.google.android.gms.wallet.PaymentsClient;
import com.stripe.android.GooglePayJsonFactory;
import com.stripe.android.GooglePayJsonFactory_Factory;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideWorkContextFactory;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.googlepaylauncher.DefaultGooglePayRepository;
import com.stripe.android.googlepaylauncher.DefaultGooglePayRepository_Factory;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel_Factory_MembersInjector;
import com.stripe.android.googlepaylauncher.GooglePayRepository;
import com.stripe.android.googlepaylauncher.PaymentsClientFactory;
import com.stripe.android.googlepaylauncher.PaymentsClientFactory_Factory;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherViewModelFactoryComponent;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherViewModelSubcomponent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeApiRepository;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public final class DaggerGooglePayPaymentMethodLauncherViewModelFactoryComponent implements GooglePayPaymentMethodLauncherViewModelFactoryComponent {
    private final Context context;
    private Provider<Context> contextProvider;
    /* access modifiers changed from: private */
    public Provider<DefaultGooglePayRepository> defaultGooglePayRepositoryProvider;
    private Provider<Boolean> enableLoggingProvider;
    private Provider<GooglePayPaymentMethodLauncher.Config> googlePayConfigProvider;
    /* access modifiers changed from: private */
    public Provider<GooglePayJsonFactory> googlePayJsonFactoryProvider;
    private final DaggerGooglePayPaymentMethodLauncherViewModelFactoryComponent googlePayPaymentMethodLauncherViewModelFactoryComponent;
    private Provider<PaymentsClientFactory> paymentsClientFactoryProvider;
    private final Set<String> productUsage;
    private Provider<Logger> provideLoggerProvider;
    /* access modifiers changed from: private */
    public Provider<PaymentsClient> providePaymentsClientProvider;
    private Provider<CoroutineContext> provideWorkContextProvider;
    /* access modifiers changed from: private */
    public final Function0<String> publishableKeyProvider;
    private Provider<Function0<String>> publishableKeyProvider2;
    /* access modifiers changed from: private */
    public final Function0<String> stripeAccountIdProvider;
    private Provider<Function0<String>> stripeAccountIdProvider2;

    private DaggerGooglePayPaymentMethodLauncherViewModelFactoryComponent(CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context2, Boolean bool, Function0<String> function0, Function0<String> function02, Set<String> set, GooglePayPaymentMethodLauncher.Config config) {
        this.googlePayPaymentMethodLauncherViewModelFactoryComponent = this;
        this.publishableKeyProvider = function0;
        this.stripeAccountIdProvider = function02;
        this.context = context2;
        this.productUsage = set;
        initialize(coroutineContextModule, loggingModule, context2, bool, function0, function02, set, config);
    }

    public static GooglePayPaymentMethodLauncherViewModelFactoryComponent.Builder builder() {
        return new Builder();
    }

    private PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory() {
        return new PaymentAnalyticsRequestFactory(this.context, this.publishableKeyProvider, this.productUsage);
    }

    private DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor() {
        return new DefaultAnalyticsRequestExecutor(this.provideLoggerProvider.get(), this.provideWorkContextProvider.get());
    }

    /* access modifiers changed from: private */
    public StripeApiRepository stripeApiRepository() {
        return new StripeApiRepository(this.context, this.publishableKeyProvider, this.provideWorkContextProvider.get(), this.productUsage, paymentAnalyticsRequestFactory(), (AnalyticsRequestExecutor) defaultAnalyticsRequestExecutor(), this.provideLoggerProvider.get());
    }

    private void initialize(CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context2, Boolean bool, Function0<String> function0, Function0<String> function02, Set<String> set, GooglePayPaymentMethodLauncher.Config config) {
        this.contextProvider = InstanceFactory.create(context2);
        this.googlePayConfigProvider = InstanceFactory.create(config);
        PaymentsClientFactory_Factory create = PaymentsClientFactory_Factory.create(this.contextProvider);
        this.paymentsClientFactoryProvider = create;
        this.providePaymentsClientProvider = DoubleCheck.provider(GooglePayPaymentMethodLauncherModule_Companion_ProvidePaymentsClientFactory.create(this.contextProvider, this.googlePayConfigProvider, create));
        this.provideWorkContextProvider = DoubleCheck.provider(CoroutineContextModule_ProvideWorkContextFactory.create(coroutineContextModule));
        Factory create2 = InstanceFactory.create(bool);
        this.enableLoggingProvider = create2;
        this.provideLoggerProvider = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, create2));
        this.publishableKeyProvider2 = InstanceFactory.create(function0);
        Factory<T> create3 = InstanceFactory.create(function02);
        this.stripeAccountIdProvider2 = create3;
        this.googlePayJsonFactoryProvider = DoubleCheck.provider(GooglePayJsonFactory_Factory.create(this.publishableKeyProvider2, create3, this.googlePayConfigProvider));
        this.defaultGooglePayRepositoryProvider = DoubleCheck.provider(DefaultGooglePayRepository_Factory.create(this.contextProvider, this.googlePayConfigProvider, this.provideLoggerProvider));
    }

    public void inject(GooglePayPaymentMethodLauncherViewModel.Factory factory) {
        injectFactory(factory);
    }

    private GooglePayPaymentMethodLauncherViewModel.Factory injectFactory(GooglePayPaymentMethodLauncherViewModel.Factory factory) {
        GooglePayPaymentMethodLauncherViewModel_Factory_MembersInjector.injectSubComponentBuilder(factory, new GooglePayPaymentMethodLauncherViewModelSubcomponentBuilder());
        return factory;
    }

    private static final class Builder implements GooglePayPaymentMethodLauncherViewModelFactoryComponent.Builder {
        private Context context;
        private Boolean enableLogging;
        private GooglePayPaymentMethodLauncher.Config googlePayConfig;
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

        public Builder googlePayConfig(GooglePayPaymentMethodLauncher.Config config) {
            this.googlePayConfig = (GooglePayPaymentMethodLauncher.Config) Preconditions.checkNotNull(config);
            return this;
        }

        public GooglePayPaymentMethodLauncherViewModelFactoryComponent build() {
            Preconditions.checkBuilderRequirement(this.context, Context.class);
            Preconditions.checkBuilderRequirement(this.enableLogging, Boolean.class);
            Preconditions.checkBuilderRequirement(this.publishableKeyProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.stripeAccountIdProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.productUsage, Set.class);
            Preconditions.checkBuilderRequirement(this.googlePayConfig, GooglePayPaymentMethodLauncher.Config.class);
            return new DaggerGooglePayPaymentMethodLauncherViewModelFactoryComponent(new CoroutineContextModule(), new LoggingModule(), this.context, this.enableLogging, this.publishableKeyProvider, this.stripeAccountIdProvider, this.productUsage, this.googlePayConfig);
        }
    }

    private static final class GooglePayPaymentMethodLauncherViewModelSubcomponentBuilder implements GooglePayPaymentMethodLauncherViewModelSubcomponent.Builder {
        private GooglePayPaymentMethodLauncherContract.Args args;
        private final DaggerGooglePayPaymentMethodLauncherViewModelFactoryComponent googlePayPaymentMethodLauncherViewModelFactoryComponent;
        private SavedStateHandle savedStateHandle;

        private GooglePayPaymentMethodLauncherViewModelSubcomponentBuilder(DaggerGooglePayPaymentMethodLauncherViewModelFactoryComponent daggerGooglePayPaymentMethodLauncherViewModelFactoryComponent) {
            this.googlePayPaymentMethodLauncherViewModelFactoryComponent = daggerGooglePayPaymentMethodLauncherViewModelFactoryComponent;
        }

        public GooglePayPaymentMethodLauncherViewModelSubcomponentBuilder args(GooglePayPaymentMethodLauncherContract.Args args2) {
            this.args = (GooglePayPaymentMethodLauncherContract.Args) Preconditions.checkNotNull(args2);
            return this;
        }

        public GooglePayPaymentMethodLauncherViewModelSubcomponentBuilder savedStateHandle(SavedStateHandle savedStateHandle2) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(savedStateHandle2);
            return this;
        }

        public GooglePayPaymentMethodLauncherViewModelSubcomponent build() {
            Preconditions.checkBuilderRequirement(this.args, GooglePayPaymentMethodLauncherContract.Args.class);
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            return new GooglePayPaymentMethodLauncherViewModelSubcomponentImpl(this.args, this.savedStateHandle);
        }
    }

    private static final class GooglePayPaymentMethodLauncherViewModelSubcomponentImpl implements GooglePayPaymentMethodLauncherViewModelSubcomponent {
        private final GooglePayPaymentMethodLauncherContract.Args args;
        private final DaggerGooglePayPaymentMethodLauncherViewModelFactoryComponent googlePayPaymentMethodLauncherViewModelFactoryComponent;
        private final GooglePayPaymentMethodLauncherViewModelSubcomponentImpl googlePayPaymentMethodLauncherViewModelSubcomponentImpl;
        private final SavedStateHandle savedStateHandle;

        private GooglePayPaymentMethodLauncherViewModelSubcomponentImpl(DaggerGooglePayPaymentMethodLauncherViewModelFactoryComponent daggerGooglePayPaymentMethodLauncherViewModelFactoryComponent, GooglePayPaymentMethodLauncherContract.Args args2, SavedStateHandle savedStateHandle2) {
            this.googlePayPaymentMethodLauncherViewModelSubcomponentImpl = this;
            this.googlePayPaymentMethodLauncherViewModelFactoryComponent = daggerGooglePayPaymentMethodLauncherViewModelFactoryComponent;
            this.args = args2;
            this.savedStateHandle = savedStateHandle2;
        }

        private ApiRequest.Options options() {
            return new ApiRequest.Options(this.googlePayPaymentMethodLauncherViewModelFactoryComponent.publishableKeyProvider, this.googlePayPaymentMethodLauncherViewModelFactoryComponent.stripeAccountIdProvider);
        }

        public GooglePayPaymentMethodLauncherViewModel getViewModel() {
            return new GooglePayPaymentMethodLauncherViewModel((PaymentsClient) this.googlePayPaymentMethodLauncherViewModelFactoryComponent.providePaymentsClientProvider.get(), options(), this.args, this.googlePayPaymentMethodLauncherViewModelFactoryComponent.stripeApiRepository(), (GooglePayJsonFactory) this.googlePayPaymentMethodLauncherViewModelFactoryComponent.googlePayJsonFactoryProvider.get(), (GooglePayRepository) this.googlePayPaymentMethodLauncherViewModelFactoryComponent.defaultGooglePayRepositoryProvider.get(), this.savedStateHandle);
        }
    }
}

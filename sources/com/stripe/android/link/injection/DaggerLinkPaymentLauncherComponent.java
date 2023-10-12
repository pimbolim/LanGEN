package com.stripe.android.link.injection;

import android.content.Context;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.LinkActivityViewModel;
import com.stripe.android.link.LinkActivityViewModel_Factory_MembersInjector;
import com.stripe.android.link.account.CookieStore;
import com.stripe.android.link.account.CookieStore_Factory;
import com.stripe.android.link.account.EncryptedStore;
import com.stripe.android.link.account.EncryptedStore_Factory;
import com.stripe.android.link.account.LinkAccountManager;
import com.stripe.android.link.account.LinkAccountManager_Factory;
import com.stripe.android.link.confirmation.ConfirmationManager;
import com.stripe.android.link.confirmation.ConfirmationManager_Factory;
import com.stripe.android.link.injection.LinkPaymentLauncherComponent;
import com.stripe.android.link.injection.SignUpViewModelSubcomponent;
import com.stripe.android.link.injection.SignedInViewModelSubcomponent;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.model.Navigator;
import com.stripe.android.link.model.Navigator_Factory;
import com.stripe.android.link.repositories.LinkApiRepository;
import com.stripe.android.link.repositories.LinkApiRepository_Factory;
import com.stripe.android.link.repositories.LinkRepository;
import com.stripe.android.link.ui.signup.SignUpViewModel;
import com.stripe.android.link.ui.signup.SignUpViewModel_Factory_MembersInjector;
import com.stripe.android.link.ui.verification.VerificationViewModel;
import com.stripe.android.link.ui.verification.VerificationViewModel_Factory_MembersInjector;
import com.stripe.android.link.ui.wallet.WalletViewModel;
import com.stripe.android.link.ui.wallet.WalletViewModel_Factory_MembersInjector;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory_Impl;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncher_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public final class DaggerLinkPaymentLauncherComponent extends LinkPaymentLauncherComponent {
    private Provider<PaymentAnalyticsRequestFactory> analyticsRequestFactoryProvider;
    /* access modifiers changed from: private */
    public Provider<ConfirmationManager> confirmationManagerProvider;
    private Provider<Context> contextProvider;
    private Provider<CookieStore> cookieStoreProvider;
    private Provider<Boolean> enableLoggingProvider;
    private Provider<EncryptedStore> encryptedStoreProvider;
    private Provider<CoroutineContext> ioContextProvider;
    /* access modifiers changed from: private */
    public Provider<LinkAccountManager> linkAccountManagerProvider;
    /* access modifiers changed from: private */
    public Provider<LinkApiRepository> linkApiRepositoryProvider;
    /* access modifiers changed from: private */
    public final DaggerLinkPaymentLauncherComponent linkPaymentLauncherComponent;
    /* access modifiers changed from: private */
    public Provider<Navigator> navigatorProvider;
    private Provider<Set<String>> productUsageProvider;
    private Provider<Locale> provideLocaleProvider;
    /* access modifiers changed from: private */
    public Provider<Logger> provideLoggerProvider;
    private Provider<Function0<String>> publishableKeyProvider;
    private Provider<SignUpViewModelSubcomponent.Builder> signUpViewModelSubcomponentBuilderProvider;
    private Provider<SignedInViewModelSubcomponent.Builder> signedInViewModelSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public final LinkActivityContract.Args starterArgs;
    private Provider<Function0<String>> stripeAccountIdProvider;
    private Provider<StripePaymentLauncherAssistedFactory> stripePaymentLauncherAssistedFactoryProvider;
    private StripePaymentLauncher_Factory stripePaymentLauncherProvider;
    private Provider<StripeRepository> stripeRepositoryProvider;
    private Provider<CoroutineContext> uiContextProvider;

    private DaggerLinkPaymentLauncherComponent(LoggingModule loggingModule, Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, AnalyticsRequestExecutor analyticsRequestExecutor, StripeRepository stripeRepository, Boolean bool, Function0<String> function0, Function0<String> function02, Set<String> set, LinkActivityContract.Args args) {
        this.linkPaymentLauncherComponent = this;
        this.starterArgs = args;
        initialize(loggingModule, context, coroutineContext, coroutineContext2, paymentAnalyticsRequestFactory, analyticsRequestExecutor, stripeRepository, bool, function0, function02, set, args);
    }

    public static LinkPaymentLauncherComponent.Builder builder() {
        return new Builder();
    }

    private LinkActivityViewModel linkActivityViewModel() {
        return new LinkActivityViewModel(this.starterArgs, this.linkAccountManagerProvider.get(), this.cookieStoreProvider.get(), this.navigatorProvider.get(), this.confirmationManagerProvider.get());
    }

    private void initialize(LoggingModule loggingModule, Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, AnalyticsRequestExecutor analyticsRequestExecutor, StripeRepository stripeRepository, Boolean bool, Function0<String> function0, Function0<String> function02, Set<String> set, LinkActivityContract.Args args) {
        this.publishableKeyProvider = InstanceFactory.create(function0);
        this.stripeAccountIdProvider = InstanceFactory.create(function02);
        this.stripeRepositoryProvider = InstanceFactory.create(stripeRepository);
        Factory create = InstanceFactory.create(bool);
        this.enableLoggingProvider = create;
        LoggingModule loggingModule2 = loggingModule;
        this.provideLoggerProvider = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, create));
        this.ioContextProvider = InstanceFactory.create(coroutineContext);
        Provider<Locale> provider = DoubleCheck.provider(LinkPaymentLauncherModule_Companion_ProvideLocaleFactory.create());
        this.provideLocaleProvider = provider;
        this.linkApiRepositoryProvider = DoubleCheck.provider(LinkApiRepository_Factory.create(this.publishableKeyProvider, this.stripeAccountIdProvider, this.stripeRepositoryProvider, this.provideLoggerProvider, this.ioContextProvider, provider));
        Factory create2 = InstanceFactory.create(context);
        this.contextProvider = create2;
        Provider<EncryptedStore> provider2 = DoubleCheck.provider(EncryptedStore_Factory.create(create2));
        this.encryptedStoreProvider = provider2;
        Provider<CookieStore> provider3 = DoubleCheck.provider(CookieStore_Factory.create(provider2));
        this.cookieStoreProvider = provider3;
        this.linkAccountManagerProvider = DoubleCheck.provider(LinkAccountManager_Factory.create(this.linkApiRepositoryProvider, provider3));
        this.navigatorProvider = DoubleCheck.provider(Navigator_Factory.create());
        this.uiContextProvider = InstanceFactory.create(coroutineContext2);
        this.analyticsRequestFactoryProvider = InstanceFactory.create(paymentAnalyticsRequestFactory);
        Factory<T> create3 = InstanceFactory.create(set);
        this.productUsageProvider = create3;
        StripePaymentLauncher_Factory create4 = StripePaymentLauncher_Factory.create(this.contextProvider, this.enableLoggingProvider, this.ioContextProvider, this.uiContextProvider, this.stripeRepositoryProvider, this.analyticsRequestFactoryProvider, create3);
        this.stripePaymentLauncherProvider = create4;
        Provider<StripePaymentLauncherAssistedFactory> create5 = StripePaymentLauncherAssistedFactory_Impl.create(create4);
        this.stripePaymentLauncherAssistedFactoryProvider = create5;
        this.confirmationManagerProvider = DoubleCheck.provider(ConfirmationManager_Factory.create(create5, this.publishableKeyProvider, this.stripeAccountIdProvider));
        this.signUpViewModelSubcomponentBuilderProvider = new Provider<SignUpViewModelSubcomponent.Builder>() {
            public SignUpViewModelSubcomponent.Builder get() {
                return new SignUpViewModelSubcomponentBuilder();
            }
        };
        this.signedInViewModelSubcomponentBuilderProvider = new Provider<SignedInViewModelSubcomponent.Builder>() {
            public SignedInViewModelSubcomponent.Builder get() {
                return new SignedInViewModelSubcomponentBuilder();
            }
        };
    }

    public void inject(LinkActivityViewModel.Factory factory) {
        injectFactory(factory);
    }

    public void inject(SignUpViewModel.Factory factory) {
        injectFactory2(factory);
    }

    public void inject(VerificationViewModel.Factory factory) {
        injectFactory3(factory);
    }

    public void inject(WalletViewModel.Factory factory) {
        injectFactory4(factory);
    }

    private LinkActivityViewModel.Factory injectFactory(LinkActivityViewModel.Factory factory) {
        LinkActivityViewModel_Factory_MembersInjector.injectViewModel(factory, linkActivityViewModel());
        return factory;
    }

    private SignUpViewModel.Factory injectFactory2(SignUpViewModel.Factory factory) {
        SignUpViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.signUpViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private VerificationViewModel.Factory injectFactory3(VerificationViewModel.Factory factory) {
        VerificationViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.signedInViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private WalletViewModel.Factory injectFactory4(WalletViewModel.Factory factory) {
        WalletViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.signedInViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private static final class Builder implements LinkPaymentLauncherComponent.Builder {
        private AnalyticsRequestExecutor analyticsRequestExecutor;
        private PaymentAnalyticsRequestFactory analyticsRequestFactory;
        private Context context;
        private Boolean enableLogging;
        private CoroutineContext ioContext;
        private Set<String> productUsage;
        private Function0<String> publishableKeyProvider;
        private LinkActivityContract.Args starterArgs;
        private Function0<String> stripeAccountIdProvider;
        private StripeRepository stripeRepository;
        private CoroutineContext uiContext;

        private Builder() {
        }

        public Builder context(Context context2) {
            this.context = (Context) Preconditions.checkNotNull(context2);
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

        public Builder analyticsRequestFactory(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory) {
            this.analyticsRequestFactory = (PaymentAnalyticsRequestFactory) Preconditions.checkNotNull(paymentAnalyticsRequestFactory);
            return this;
        }

        public Builder analyticsRequestExecutor(AnalyticsRequestExecutor analyticsRequestExecutor2) {
            this.analyticsRequestExecutor = (AnalyticsRequestExecutor) Preconditions.checkNotNull(analyticsRequestExecutor2);
            return this;
        }

        public Builder stripeRepository(StripeRepository stripeRepository2) {
            this.stripeRepository = (StripeRepository) Preconditions.checkNotNull(stripeRepository2);
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

        public Builder starterArgs(LinkActivityContract.Args args) {
            this.starterArgs = (LinkActivityContract.Args) Preconditions.checkNotNull(args);
            return this;
        }

        public LinkPaymentLauncherComponent build() {
            Preconditions.checkBuilderRequirement(this.context, Context.class);
            Preconditions.checkBuilderRequirement(this.ioContext, CoroutineContext.class);
            Preconditions.checkBuilderRequirement(this.uiContext, CoroutineContext.class);
            Preconditions.checkBuilderRequirement(this.analyticsRequestFactory, PaymentAnalyticsRequestFactory.class);
            Preconditions.checkBuilderRequirement(this.analyticsRequestExecutor, AnalyticsRequestExecutor.class);
            Preconditions.checkBuilderRequirement(this.stripeRepository, StripeRepository.class);
            Preconditions.checkBuilderRequirement(this.enableLogging, Boolean.class);
            Preconditions.checkBuilderRequirement(this.publishableKeyProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.stripeAccountIdProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.productUsage, Set.class);
            Preconditions.checkBuilderRequirement(this.starterArgs, LinkActivityContract.Args.class);
            return new DaggerLinkPaymentLauncherComponent(new LoggingModule(), this.context, this.ioContext, this.uiContext, this.analyticsRequestFactory, this.analyticsRequestExecutor, this.stripeRepository, this.enableLogging, this.publishableKeyProvider, this.stripeAccountIdProvider, this.productUsage, this.starterArgs);
        }
    }

    private static final class SignUpViewModelSubcomponentBuilder implements SignUpViewModelSubcomponent.Builder {
        private final DaggerLinkPaymentLauncherComponent linkPaymentLauncherComponent;
        private String prefilledEmail;

        private SignUpViewModelSubcomponentBuilder(DaggerLinkPaymentLauncherComponent daggerLinkPaymentLauncherComponent) {
            this.linkPaymentLauncherComponent = daggerLinkPaymentLauncherComponent;
        }

        public SignUpViewModelSubcomponentBuilder prefilledEmail(String str) {
            this.prefilledEmail = str;
            return this;
        }

        public SignUpViewModelSubcomponent build() {
            return new SignUpViewModelSubcomponentImpl(this.prefilledEmail);
        }
    }

    private static final class SignedInViewModelSubcomponentBuilder implements SignedInViewModelSubcomponent.Builder {
        private LinkAccount linkAccount;
        private final DaggerLinkPaymentLauncherComponent linkPaymentLauncherComponent;

        private SignedInViewModelSubcomponentBuilder(DaggerLinkPaymentLauncherComponent daggerLinkPaymentLauncherComponent) {
            this.linkPaymentLauncherComponent = daggerLinkPaymentLauncherComponent;
        }

        public SignedInViewModelSubcomponentBuilder linkAccount(LinkAccount linkAccount2) {
            this.linkAccount = (LinkAccount) Preconditions.checkNotNull(linkAccount2);
            return this;
        }

        public SignedInViewModelSubcomponent build() {
            Preconditions.checkBuilderRequirement(this.linkAccount, LinkAccount.class);
            return new SignedInViewModelSubcomponentImpl(this.linkAccount);
        }
    }

    private static final class SignUpViewModelSubcomponentImpl implements SignUpViewModelSubcomponent {
        private final DaggerLinkPaymentLauncherComponent linkPaymentLauncherComponent;
        private final String prefilledEmail;
        private final SignUpViewModelSubcomponentImpl signUpViewModelSubcomponentImpl;

        private SignUpViewModelSubcomponentImpl(DaggerLinkPaymentLauncherComponent daggerLinkPaymentLauncherComponent, String str) {
            this.signUpViewModelSubcomponentImpl = this;
            this.linkPaymentLauncherComponent = daggerLinkPaymentLauncherComponent;
            this.prefilledEmail = str;
        }

        public SignUpViewModel getSignUpViewModel() {
            return new SignUpViewModel(this.linkPaymentLauncherComponent.starterArgs, this.prefilledEmail, (LinkAccountManager) this.linkPaymentLauncherComponent.linkAccountManagerProvider.get(), (Navigator) this.linkPaymentLauncherComponent.navigatorProvider.get(), (Logger) this.linkPaymentLauncherComponent.provideLoggerProvider.get());
        }
    }

    private static final class SignedInViewModelSubcomponentImpl implements SignedInViewModelSubcomponent {
        private final LinkAccount linkAccount;
        private final DaggerLinkPaymentLauncherComponent linkPaymentLauncherComponent;
        private final SignedInViewModelSubcomponentImpl signedInViewModelSubcomponentImpl;

        private SignedInViewModelSubcomponentImpl(DaggerLinkPaymentLauncherComponent daggerLinkPaymentLauncherComponent, LinkAccount linkAccount2) {
            this.signedInViewModelSubcomponentImpl = this;
            this.linkPaymentLauncherComponent = daggerLinkPaymentLauncherComponent;
            this.linkAccount = linkAccount2;
        }

        public VerificationViewModel getVerificationViewModel() {
            return new VerificationViewModel((LinkAccountManager) this.linkPaymentLauncherComponent.linkAccountManagerProvider.get(), (Navigator) this.linkPaymentLauncherComponent.navigatorProvider.get(), (Logger) this.linkPaymentLauncherComponent.provideLoggerProvider.get(), this.linkAccount);
        }

        public WalletViewModel getWalletViewModel() {
            return new WalletViewModel(this.linkPaymentLauncherComponent.starterArgs, this.linkAccount, (LinkRepository) this.linkPaymentLauncherComponent.linkApiRepositoryProvider.get(), (LinkAccountManager) this.linkPaymentLauncherComponent.linkAccountManagerProvider.get(), (Navigator) this.linkPaymentLauncherComponent.navigatorProvider.get(), (ConfirmationManager) this.linkPaymentLauncherComponent.confirmationManagerProvider.get(), (Logger) this.linkPaymentLauncherComponent.provideLoggerProvider.get());
        }
    }
}

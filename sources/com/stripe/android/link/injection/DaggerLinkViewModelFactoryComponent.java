package com.stripe.android.link.injection;

import android.content.Context;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideUIContextFactory;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideWorkContextFactory;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor_Factory;
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
import com.stripe.android.link.injection.LinkViewModelFactoryComponent;
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
import com.stripe.android.networking.PaymentAnalyticsRequestFactory_Factory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.networking.StripeApiRepository_Factory;
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

public final class DaggerLinkViewModelFactoryComponent implements LinkViewModelFactoryComponent {
    /* access modifiers changed from: private */
    public Provider<ConfirmationManager> confirmationManagerProvider;
    private Provider<Context> contextProvider;
    private Provider<CookieStore> cookieStoreProvider;
    private Provider<DefaultAnalyticsRequestExecutor> defaultAnalyticsRequestExecutorProvider;
    private Provider<Boolean> enableLoggingProvider;
    private Provider<EncryptedStore> encryptedStoreProvider;
    /* access modifiers changed from: private */
    public Provider<LinkAccountManager> linkAccountManagerProvider;
    /* access modifiers changed from: private */
    public Provider<LinkApiRepository> linkApiRepositoryProvider;
    /* access modifiers changed from: private */
    public final DaggerLinkViewModelFactoryComponent linkViewModelFactoryComponent;
    /* access modifiers changed from: private */
    public Provider<Navigator> navigatorProvider;
    private Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    private Provider<Set<String>> productUsageProvider;
    private Provider<Locale> provideLocaleProvider;
    /* access modifiers changed from: private */
    public Provider<Logger> provideLoggerProvider;
    private Provider<CoroutineContext> provideUIContextProvider;
    private Provider<CoroutineContext> provideWorkContextProvider;
    private Provider<Function0<String>> publishableKeyProvider;
    private Provider<SignUpViewModelSubcomponent.Builder> signUpViewModelSubcomponentBuilderProvider;
    private Provider<SignedInViewModelSubcomponent.Builder> signedInViewModelSubcomponentBuilderProvider;
    /* access modifiers changed from: private */
    public final LinkActivityContract.Args starterArgs;
    private Provider<Function0<String>> stripeAccountIdProvider;
    private Provider<StripeApiRepository> stripeApiRepositoryProvider;
    private Provider<StripePaymentLauncherAssistedFactory> stripePaymentLauncherAssistedFactoryProvider;
    private StripePaymentLauncher_Factory stripePaymentLauncherProvider;

    private DaggerLinkViewModelFactoryComponent(CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context, Boolean bool, Function0<String> function0, Function0<String> function02, Set<String> set, LinkActivityContract.Args args) {
        this.linkViewModelFactoryComponent = this;
        this.starterArgs = args;
        initialize(coroutineContextModule, loggingModule, context, bool, function0, function02, set, args);
    }

    public static LinkViewModelFactoryComponent.Builder builder() {
        return new Builder();
    }

    private LinkActivityViewModel linkActivityViewModel() {
        return new LinkActivityViewModel(this.starterArgs, this.linkAccountManagerProvider.get(), this.cookieStoreProvider.get(), this.navigatorProvider.get(), this.confirmationManagerProvider.get());
    }

    private void initialize(CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Context context, Boolean bool, Function0<String> function0, Function0<String> function02, Set<String> set, LinkActivityContract.Args args) {
        this.publishableKeyProvider = InstanceFactory.create(function0);
        this.stripeAccountIdProvider = InstanceFactory.create(function02);
        this.contextProvider = InstanceFactory.create(context);
        this.provideWorkContextProvider = DoubleCheck.provider(CoroutineContextModule_ProvideWorkContextFactory.create(coroutineContextModule));
        Factory<T> create = InstanceFactory.create(set);
        this.productUsageProvider = create;
        this.paymentAnalyticsRequestFactoryProvider = PaymentAnalyticsRequestFactory_Factory.create(this.contextProvider, this.publishableKeyProvider, create);
        Factory create2 = InstanceFactory.create(bool);
        this.enableLoggingProvider = create2;
        Provider<Logger> provider = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, create2));
        this.provideLoggerProvider = provider;
        DefaultAnalyticsRequestExecutor_Factory create3 = DefaultAnalyticsRequestExecutor_Factory.create(provider, this.provideWorkContextProvider);
        this.defaultAnalyticsRequestExecutorProvider = create3;
        this.stripeApiRepositoryProvider = StripeApiRepository_Factory.create(this.contextProvider, this.publishableKeyProvider, this.provideWorkContextProvider, this.productUsageProvider, this.paymentAnalyticsRequestFactoryProvider, create3, this.provideLoggerProvider);
        Provider<Locale> provider2 = DoubleCheck.provider(LinkPaymentLauncherModule_Companion_ProvideLocaleFactory.create());
        this.provideLocaleProvider = provider2;
        this.linkApiRepositoryProvider = DoubleCheck.provider(LinkApiRepository_Factory.create(this.publishableKeyProvider, this.stripeAccountIdProvider, this.stripeApiRepositoryProvider, this.provideLoggerProvider, this.provideWorkContextProvider, provider2));
        Provider<EncryptedStore> provider3 = DoubleCheck.provider(EncryptedStore_Factory.create(this.contextProvider));
        this.encryptedStoreProvider = provider3;
        Provider<CookieStore> provider4 = DoubleCheck.provider(CookieStore_Factory.create(provider3));
        this.cookieStoreProvider = provider4;
        this.linkAccountManagerProvider = DoubleCheck.provider(LinkAccountManager_Factory.create(this.linkApiRepositoryProvider, provider4));
        this.navigatorProvider = DoubleCheck.provider(Navigator_Factory.create());
        Provider<CoroutineContext> provider5 = DoubleCheck.provider(CoroutineContextModule_ProvideUIContextFactory.create(coroutineContextModule));
        this.provideUIContextProvider = provider5;
        StripePaymentLauncher_Factory create4 = StripePaymentLauncher_Factory.create(this.contextProvider, this.enableLoggingProvider, this.provideWorkContextProvider, provider5, this.stripeApiRepositoryProvider, this.paymentAnalyticsRequestFactoryProvider, this.productUsageProvider);
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

    private static final class Builder implements LinkViewModelFactoryComponent.Builder {
        private Context context;
        private Boolean enableLogging;
        private Set<String> productUsage;
        private Function0<String> publishableKeyProvider;
        private LinkActivityContract.Args starterArgs;
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

        public Builder starterArgs(LinkActivityContract.Args args) {
            this.starterArgs = (LinkActivityContract.Args) Preconditions.checkNotNull(args);
            return this;
        }

        public LinkViewModelFactoryComponent build() {
            Preconditions.checkBuilderRequirement(this.context, Context.class);
            Preconditions.checkBuilderRequirement(this.enableLogging, Boolean.class);
            Preconditions.checkBuilderRequirement(this.publishableKeyProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.stripeAccountIdProvider, Function0.class);
            Preconditions.checkBuilderRequirement(this.productUsage, Set.class);
            Preconditions.checkBuilderRequirement(this.starterArgs, LinkActivityContract.Args.class);
            return new DaggerLinkViewModelFactoryComponent(new CoroutineContextModule(), new LoggingModule(), this.context, this.enableLogging, this.publishableKeyProvider, this.stripeAccountIdProvider, this.productUsage, this.starterArgs);
        }
    }

    private static final class SignUpViewModelSubcomponentBuilder implements SignUpViewModelSubcomponent.Builder {
        private final DaggerLinkViewModelFactoryComponent linkViewModelFactoryComponent;
        private String prefilledEmail;

        private SignUpViewModelSubcomponentBuilder(DaggerLinkViewModelFactoryComponent daggerLinkViewModelFactoryComponent) {
            this.linkViewModelFactoryComponent = daggerLinkViewModelFactoryComponent;
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
        private final DaggerLinkViewModelFactoryComponent linkViewModelFactoryComponent;

        private SignedInViewModelSubcomponentBuilder(DaggerLinkViewModelFactoryComponent daggerLinkViewModelFactoryComponent) {
            this.linkViewModelFactoryComponent = daggerLinkViewModelFactoryComponent;
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
        private final DaggerLinkViewModelFactoryComponent linkViewModelFactoryComponent;
        private final String prefilledEmail;
        private final SignUpViewModelSubcomponentImpl signUpViewModelSubcomponentImpl;

        private SignUpViewModelSubcomponentImpl(DaggerLinkViewModelFactoryComponent daggerLinkViewModelFactoryComponent, String str) {
            this.signUpViewModelSubcomponentImpl = this;
            this.linkViewModelFactoryComponent = daggerLinkViewModelFactoryComponent;
            this.prefilledEmail = str;
        }

        public SignUpViewModel getSignUpViewModel() {
            return new SignUpViewModel(this.linkViewModelFactoryComponent.starterArgs, this.prefilledEmail, (LinkAccountManager) this.linkViewModelFactoryComponent.linkAccountManagerProvider.get(), (Navigator) this.linkViewModelFactoryComponent.navigatorProvider.get(), (Logger) this.linkViewModelFactoryComponent.provideLoggerProvider.get());
        }
    }

    private static final class SignedInViewModelSubcomponentImpl implements SignedInViewModelSubcomponent {
        private final LinkAccount linkAccount;
        private final DaggerLinkViewModelFactoryComponent linkViewModelFactoryComponent;
        private final SignedInViewModelSubcomponentImpl signedInViewModelSubcomponentImpl;

        private SignedInViewModelSubcomponentImpl(DaggerLinkViewModelFactoryComponent daggerLinkViewModelFactoryComponent, LinkAccount linkAccount2) {
            this.signedInViewModelSubcomponentImpl = this;
            this.linkViewModelFactoryComponent = daggerLinkViewModelFactoryComponent;
            this.linkAccount = linkAccount2;
        }

        public VerificationViewModel getVerificationViewModel() {
            return new VerificationViewModel((LinkAccountManager) this.linkViewModelFactoryComponent.linkAccountManagerProvider.get(), (Navigator) this.linkViewModelFactoryComponent.navigatorProvider.get(), (Logger) this.linkViewModelFactoryComponent.provideLoggerProvider.get(), this.linkAccount);
        }

        public WalletViewModel getWalletViewModel() {
            return new WalletViewModel(this.linkViewModelFactoryComponent.starterArgs, this.linkAccount, (LinkRepository) this.linkViewModelFactoryComponent.linkApiRepositoryProvider.get(), (LinkAccountManager) this.linkViewModelFactoryComponent.linkAccountManagerProvider.get(), (Navigator) this.linkViewModelFactoryComponent.navigatorProvider.get(), (ConfirmationManager) this.linkViewModelFactoryComponent.confirmationManagerProvider.get(), (Logger) this.linkViewModelFactoryComponent.provideLoggerProvider.get());
        }
    }
}

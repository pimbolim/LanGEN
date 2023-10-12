package com.stripe.android.payments.core.injection;

import android.content.Context;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.core.authentication.PaymentAuthenticatorRegistry;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public final class PaymentLauncherModule_ProvidePaymentAuthenticatorRegistryFactory implements Factory<PaymentAuthenticatorRegistry> {
    private final Provider<Context> contextProvider;
    private final Provider<DefaultAnalyticsRequestExecutor> defaultAnalyticsRequestExecutorProvider;
    private final Provider<Boolean> enableLoggingProvider;
    private final Provider<Boolean> isInstantAppProvider;
    private final PaymentLauncherModule module;
    private final Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    private final Provider<Set<String>> productUsageProvider;
    private final Provider<Function0<String>> publishableKeyProvider;
    private final Provider<StripeRepository> stripeRepositoryProvider;
    private final Provider<Map<String, String>> threeDs1IntentReturnUrlMapProvider;
    private final Provider<CoroutineContext> uiContextProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public PaymentLauncherModule_ProvidePaymentAuthenticatorRegistryFactory(PaymentLauncherModule paymentLauncherModule, Provider<Context> provider, Provider<StripeRepository> provider2, Provider<Boolean> provider3, Provider<CoroutineContext> provider4, Provider<CoroutineContext> provider5, Provider<Map<String, String>> provider6, Provider<DefaultAnalyticsRequestExecutor> provider7, Provider<PaymentAnalyticsRequestFactory> provider8, Provider<Function0<String>> provider9, Provider<Set<String>> provider10, Provider<Boolean> provider11) {
        this.module = paymentLauncherModule;
        this.contextProvider = provider;
        this.stripeRepositoryProvider = provider2;
        this.enableLoggingProvider = provider3;
        this.workContextProvider = provider4;
        this.uiContextProvider = provider5;
        this.threeDs1IntentReturnUrlMapProvider = provider6;
        this.defaultAnalyticsRequestExecutorProvider = provider7;
        this.paymentAnalyticsRequestFactoryProvider = provider8;
        this.publishableKeyProvider = provider9;
        this.productUsageProvider = provider10;
        this.isInstantAppProvider = provider11;
    }

    public PaymentAuthenticatorRegistry get() {
        return providePaymentAuthenticatorRegistry(this.module, this.contextProvider.get(), this.stripeRepositoryProvider.get(), this.enableLoggingProvider.get().booleanValue(), this.workContextProvider.get(), this.uiContextProvider.get(), this.threeDs1IntentReturnUrlMapProvider.get(), this.defaultAnalyticsRequestExecutorProvider.get(), this.paymentAnalyticsRequestFactoryProvider.get(), this.publishableKeyProvider.get(), this.productUsageProvider.get(), this.isInstantAppProvider.get().booleanValue());
    }

    public static PaymentLauncherModule_ProvidePaymentAuthenticatorRegistryFactory create(PaymentLauncherModule paymentLauncherModule, Provider<Context> provider, Provider<StripeRepository> provider2, Provider<Boolean> provider3, Provider<CoroutineContext> provider4, Provider<CoroutineContext> provider5, Provider<Map<String, String>> provider6, Provider<DefaultAnalyticsRequestExecutor> provider7, Provider<PaymentAnalyticsRequestFactory> provider8, Provider<Function0<String>> provider9, Provider<Set<String>> provider10, Provider<Boolean> provider11) {
        return new PaymentLauncherModule_ProvidePaymentAuthenticatorRegistryFactory(paymentLauncherModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static PaymentAuthenticatorRegistry providePaymentAuthenticatorRegistry(PaymentLauncherModule paymentLauncherModule, Context context, StripeRepository stripeRepository, boolean z, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, Map<String, String> map, DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, Function0<String> function0, Set<String> set, boolean z2) {
        return (PaymentAuthenticatorRegistry) Preconditions.checkNotNullFromProvides(paymentLauncherModule.providePaymentAuthenticatorRegistry(context, stripeRepository, z, coroutineContext, coroutineContext2, map, defaultAnalyticsRequestExecutor, paymentAnalyticsRequestFactory, function0, set, z2));
    }
}

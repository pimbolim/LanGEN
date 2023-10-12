package com.stripe.android.payments.paymentlauncher;

import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.PaymentIntentFlowResultProcessor;
import com.stripe.android.payments.SetupIntentFlowResultProcessor;
import com.stripe.android.payments.core.authentication.PaymentAuthenticatorRegistry;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* renamed from: com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel_Factory  reason: case insensitive filesystem */
public final class C0012PaymentLauncherViewModel_Factory implements Factory<PaymentLauncherViewModel> {
    private final Provider<DefaultAnalyticsRequestExecutor> analyticsRequestExecutorProvider;
    private final Provider<ApiRequest.Options> apiRequestOptionsProvider;
    private final Provider<PaymentAuthenticatorRegistry> authenticatorRegistryProvider;
    private final Provider<DefaultReturnUrl> defaultReturnUrlProvider;
    private final Provider<Boolean> isInstantAppProvider;
    private final Provider<Boolean> isPaymentIntentProvider;
    private final Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    private final Provider<PaymentIntentFlowResultProcessor> paymentIntentFlowResultProcessorProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<SetupIntentFlowResultProcessor> setupIntentFlowResultProcessorProvider;
    private final Provider<StripeRepository> stripeApiRepositoryProvider;
    private final Provider<Map<String, String>> threeDs1IntentReturnUrlMapProvider;
    private final Provider<CoroutineContext> uiContextProvider;

    public C0012PaymentLauncherViewModel_Factory(Provider<Boolean> provider, Provider<StripeRepository> provider2, Provider<PaymentAuthenticatorRegistry> provider3, Provider<DefaultReturnUrl> provider4, Provider<ApiRequest.Options> provider5, Provider<Map<String, String>> provider6, Provider<PaymentIntentFlowResultProcessor> provider7, Provider<SetupIntentFlowResultProcessor> provider8, Provider<DefaultAnalyticsRequestExecutor> provider9, Provider<PaymentAnalyticsRequestFactory> provider10, Provider<CoroutineContext> provider11, Provider<SavedStateHandle> provider12, Provider<Boolean> provider13) {
        this.isPaymentIntentProvider = provider;
        this.stripeApiRepositoryProvider = provider2;
        this.authenticatorRegistryProvider = provider3;
        this.defaultReturnUrlProvider = provider4;
        this.apiRequestOptionsProvider = provider5;
        this.threeDs1IntentReturnUrlMapProvider = provider6;
        this.paymentIntentFlowResultProcessorProvider = provider7;
        this.setupIntentFlowResultProcessorProvider = provider8;
        this.analyticsRequestExecutorProvider = provider9;
        this.paymentAnalyticsRequestFactoryProvider = provider10;
        this.uiContextProvider = provider11;
        this.savedStateHandleProvider = provider12;
        this.isInstantAppProvider = provider13;
    }

    public PaymentLauncherViewModel get() {
        return newInstance(this.isPaymentIntentProvider.get().booleanValue(), this.stripeApiRepositoryProvider.get(), this.authenticatorRegistryProvider.get(), this.defaultReturnUrlProvider.get(), this.apiRequestOptionsProvider, this.threeDs1IntentReturnUrlMapProvider.get(), DoubleCheck.lazy(this.paymentIntentFlowResultProcessorProvider), DoubleCheck.lazy(this.setupIntentFlowResultProcessorProvider), this.analyticsRequestExecutorProvider.get(), this.paymentAnalyticsRequestFactoryProvider.get(), this.uiContextProvider.get(), this.savedStateHandleProvider.get(), this.isInstantAppProvider.get().booleanValue());
    }

    public static C0012PaymentLauncherViewModel_Factory create(Provider<Boolean> provider, Provider<StripeRepository> provider2, Provider<PaymentAuthenticatorRegistry> provider3, Provider<DefaultReturnUrl> provider4, Provider<ApiRequest.Options> provider5, Provider<Map<String, String>> provider6, Provider<PaymentIntentFlowResultProcessor> provider7, Provider<SetupIntentFlowResultProcessor> provider8, Provider<DefaultAnalyticsRequestExecutor> provider9, Provider<PaymentAnalyticsRequestFactory> provider10, Provider<CoroutineContext> provider11, Provider<SavedStateHandle> provider12, Provider<Boolean> provider13) {
        return new C0012PaymentLauncherViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static PaymentLauncherViewModel newInstance(boolean z, StripeRepository stripeRepository, PaymentAuthenticatorRegistry paymentAuthenticatorRegistry, DefaultReturnUrl defaultReturnUrl, Provider<ApiRequest.Options> provider, Map<String, String> map, Lazy<PaymentIntentFlowResultProcessor> lazy, Lazy<SetupIntentFlowResultProcessor> lazy2, DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, CoroutineContext coroutineContext, SavedStateHandle savedStateHandle, boolean z2) {
        return new PaymentLauncherViewModel(z, stripeRepository, paymentAuthenticatorRegistry, defaultReturnUrl, provider, map, lazy, lazy2, defaultAnalyticsRequestExecutor, paymentAnalyticsRequestFactory, coroutineContext, savedStateHandle, z2);
    }
}

package com.stripe.android.googlepaylauncher;

import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

public final class GooglePayPaymentMethodLauncher_Factory {
    private final Provider<AnalyticsRequestExecutor> analyticsRequestExecutorProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Boolean> enableLoggingProvider;
    private final Provider<Function1<GooglePayEnvironment, GooglePayRepository>> googlePayRepositoryFactoryProvider;
    private final Provider<CoroutineContext> ioContextProvider;
    private final Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    private final Provider<Set<String>> productUsageProvider;
    private final Provider<Function0<String>> publishableKeyProvider;
    private final Provider<Function0<String>> stripeAccountIdProvider;
    private final Provider<StripeRepository> stripeRepositoryProvider;

    public GooglePayPaymentMethodLauncher_Factory(Provider<Context> provider, Provider<Function1<GooglePayEnvironment, GooglePayRepository>> provider2, Provider<Set<String>> provider3, Provider<Function0<String>> provider4, Provider<Function0<String>> provider5, Provider<Boolean> provider6, Provider<CoroutineContext> provider7, Provider<PaymentAnalyticsRequestFactory> provider8, Provider<AnalyticsRequestExecutor> provider9, Provider<StripeRepository> provider10) {
        this.contextProvider = provider;
        this.googlePayRepositoryFactoryProvider = provider2;
        this.productUsageProvider = provider3;
        this.publishableKeyProvider = provider4;
        this.stripeAccountIdProvider = provider5;
        this.enableLoggingProvider = provider6;
        this.ioContextProvider = provider7;
        this.paymentAnalyticsRequestFactoryProvider = provider8;
        this.analyticsRequestExecutorProvider = provider9;
        this.stripeRepositoryProvider = provider10;
    }

    public GooglePayPaymentMethodLauncher get(CoroutineScope coroutineScope, GooglePayPaymentMethodLauncher.Config config, GooglePayPaymentMethodLauncher.ReadyCallback readyCallback, ActivityResultLauncher<GooglePayPaymentMethodLauncherContract.Args> activityResultLauncher, boolean z) {
        return newInstance(coroutineScope, config, readyCallback, activityResultLauncher, z, this.contextProvider.get(), this.googlePayRepositoryFactoryProvider.get(), this.productUsageProvider.get(), this.publishableKeyProvider.get(), this.stripeAccountIdProvider.get(), this.enableLoggingProvider.get().booleanValue(), this.ioContextProvider.get(), this.paymentAnalyticsRequestFactoryProvider.get(), this.analyticsRequestExecutorProvider.get(), this.stripeRepositoryProvider.get());
    }

    public static GooglePayPaymentMethodLauncher_Factory create(Provider<Context> provider, Provider<Function1<GooglePayEnvironment, GooglePayRepository>> provider2, Provider<Set<String>> provider3, Provider<Function0<String>> provider4, Provider<Function0<String>> provider5, Provider<Boolean> provider6, Provider<CoroutineContext> provider7, Provider<PaymentAnalyticsRequestFactory> provider8, Provider<AnalyticsRequestExecutor> provider9, Provider<StripeRepository> provider10) {
        return new GooglePayPaymentMethodLauncher_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static GooglePayPaymentMethodLauncher newInstance(CoroutineScope coroutineScope, GooglePayPaymentMethodLauncher.Config config, GooglePayPaymentMethodLauncher.ReadyCallback readyCallback, ActivityResultLauncher<GooglePayPaymentMethodLauncherContract.Args> activityResultLauncher, boolean z, Context context, Function1<GooglePayEnvironment, GooglePayRepository> function1, Set<String> set, Function0<String> function0, Function0<String> function02, boolean z2, CoroutineContext coroutineContext, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, AnalyticsRequestExecutor analyticsRequestExecutor, StripeRepository stripeRepository) {
        return new GooglePayPaymentMethodLauncher(coroutineScope, config, readyCallback, activityResultLauncher, z, context, function1, set, function0, function02, z2, coroutineContext, paymentAnalyticsRequestFactory, analyticsRequestExecutor, stripeRepository);
    }
}

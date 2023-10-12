package com.stripe.android.payments.paymentlauncher;

import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public final class StripePaymentLauncher_Factory {
    private final Provider<Context> contextProvider;
    private final Provider<Boolean> enableLoggingProvider;
    private final Provider<CoroutineContext> ioContextProvider;
    private final Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    private final Provider<Set<String>> productUsageProvider;
    private final Provider<StripeRepository> stripeRepositoryProvider;
    private final Provider<CoroutineContext> uiContextProvider;

    public StripePaymentLauncher_Factory(Provider<Context> provider, Provider<Boolean> provider2, Provider<CoroutineContext> provider3, Provider<CoroutineContext> provider4, Provider<StripeRepository> provider5, Provider<PaymentAnalyticsRequestFactory> provider6, Provider<Set<String>> provider7) {
        this.contextProvider = provider;
        this.enableLoggingProvider = provider2;
        this.ioContextProvider = provider3;
        this.uiContextProvider = provider4;
        this.stripeRepositoryProvider = provider5;
        this.paymentAnalyticsRequestFactoryProvider = provider6;
        this.productUsageProvider = provider7;
    }

    public StripePaymentLauncher get(Function0<String> function0, Function0<String> function02, ActivityResultLauncher<PaymentLauncherContract.Args> activityResultLauncher) {
        return newInstance(function0, function02, activityResultLauncher, this.contextProvider.get(), this.enableLoggingProvider.get().booleanValue(), this.ioContextProvider.get(), this.uiContextProvider.get(), this.stripeRepositoryProvider.get(), this.paymentAnalyticsRequestFactoryProvider.get(), this.productUsageProvider.get());
    }

    public static StripePaymentLauncher_Factory create(Provider<Context> provider, Provider<Boolean> provider2, Provider<CoroutineContext> provider3, Provider<CoroutineContext> provider4, Provider<StripeRepository> provider5, Provider<PaymentAnalyticsRequestFactory> provider6, Provider<Set<String>> provider7) {
        return new StripePaymentLauncher_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static StripePaymentLauncher newInstance(Function0<String> function0, Function0<String> function02, ActivityResultLauncher<PaymentLauncherContract.Args> activityResultLauncher, Context context, boolean z, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, StripeRepository stripeRepository, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, Set<String> set) {
        return new StripePaymentLauncher(function0, function02, activityResultLauncher, context, z, coroutineContext, coroutineContext2, stripeRepository, paymentAnalyticsRequestFactory, set);
    }
}

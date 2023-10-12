package com.stripe.android.link;

import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public final class LinkPaymentLauncher_Factory {
    private final Provider<AnalyticsRequestExecutor> analyticsRequestExecutorProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Boolean> enableLoggingProvider;
    private final Provider<CoroutineContext> ioContextProvider;
    private final Provider<PaymentAnalyticsRequestFactory> paymentAnalyticsRequestFactoryProvider;
    private final Provider<Set<String>> productUsageProvider;
    private final Provider<Function0<String>> publishableKeyProvider;
    private final Provider<Function0<String>> stripeAccountIdProvider;
    private final Provider<StripeRepository> stripeRepositoryProvider;
    private final Provider<CoroutineContext> uiContextProvider;

    public LinkPaymentLauncher_Factory(Provider<Context> provider, Provider<Set<String>> provider2, Provider<Function0<String>> provider3, Provider<Function0<String>> provider4, Provider<Boolean> provider5, Provider<CoroutineContext> provider6, Provider<CoroutineContext> provider7, Provider<PaymentAnalyticsRequestFactory> provider8, Provider<AnalyticsRequestExecutor> provider9, Provider<StripeRepository> provider10) {
        this.contextProvider = provider;
        this.productUsageProvider = provider2;
        this.publishableKeyProvider = provider3;
        this.stripeAccountIdProvider = provider4;
        this.enableLoggingProvider = provider5;
        this.ioContextProvider = provider6;
        this.uiContextProvider = provider7;
        this.paymentAnalyticsRequestFactoryProvider = provider8;
        this.analyticsRequestExecutorProvider = provider9;
        this.stripeRepositoryProvider = provider10;
    }

    public LinkPaymentLauncher get(ActivityResultLauncher<LinkActivityContract.Args> activityResultLauncher) {
        return newInstance(activityResultLauncher, this.contextProvider.get(), this.productUsageProvider.get(), this.publishableKeyProvider.get(), this.stripeAccountIdProvider.get(), this.enableLoggingProvider.get().booleanValue(), this.ioContextProvider.get(), this.uiContextProvider.get(), this.paymentAnalyticsRequestFactoryProvider.get(), this.analyticsRequestExecutorProvider.get(), this.stripeRepositoryProvider.get());
    }

    public static LinkPaymentLauncher_Factory create(Provider<Context> provider, Provider<Set<String>> provider2, Provider<Function0<String>> provider3, Provider<Function0<String>> provider4, Provider<Boolean> provider5, Provider<CoroutineContext> provider6, Provider<CoroutineContext> provider7, Provider<PaymentAnalyticsRequestFactory> provider8, Provider<AnalyticsRequestExecutor> provider9, Provider<StripeRepository> provider10) {
        return new LinkPaymentLauncher_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static LinkPaymentLauncher newInstance(ActivityResultLauncher<LinkActivityContract.Args> activityResultLauncher, Context context, Set<String> set, Function0<String> function0, Function0<String> function02, boolean z, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, AnalyticsRequestExecutor analyticsRequestExecutor, StripeRepository stripeRepository) {
        return new LinkPaymentLauncher(activityResultLauncher, context, set, function0, function02, z, coroutineContext, coroutineContext2, paymentAnalyticsRequestFactory, analyticsRequestExecutor, stripeRepository);
    }
}

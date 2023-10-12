package com.stripe.android.networking;

import android.content.Context;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;

public final class PaymentAnalyticsRequestFactory_Factory implements Factory<PaymentAnalyticsRequestFactory> {
    private final Provider<Context> contextProvider;
    private final Provider<Set<String>> defaultProductUsageTokensProvider;
    private final Provider<Function0<String>> publishableKeyProvider;

    public PaymentAnalyticsRequestFactory_Factory(Provider<Context> provider, Provider<Function0<String>> provider2, Provider<Set<String>> provider3) {
        this.contextProvider = provider;
        this.publishableKeyProvider = provider2;
        this.defaultProductUsageTokensProvider = provider3;
    }

    public PaymentAnalyticsRequestFactory get() {
        return newInstance(this.contextProvider.get(), this.publishableKeyProvider.get(), this.defaultProductUsageTokensProvider.get());
    }

    public static PaymentAnalyticsRequestFactory_Factory create(Provider<Context> provider, Provider<Function0<String>> provider2, Provider<Set<String>> provider3) {
        return new PaymentAnalyticsRequestFactory_Factory(provider, provider2, provider3);
    }

    public static PaymentAnalyticsRequestFactory newInstance(Context context, Function0<String> function0, Set<String> set) {
        return new PaymentAnalyticsRequestFactory(context, function0, set);
    }
}

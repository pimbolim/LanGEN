package com.stripe.android.payments.core.injection;

import android.content.Context;
import com.google.android.instantapps.InstantApps;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.injection.UIContext;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.core.authentication.DefaultPaymentAuthenticatorRegistry;
import com.stripe.android.payments.core.authentication.PaymentAuthenticatorRegistry;
import dagger.Module;
import dagger.Provides;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0001\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00192\u000e\b\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\bH\u0007J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/payments/core/injection/PaymentLauncherModule;", "", "()V", "provideDefaultReturnUrl", "Lcom/stripe/android/payments/DefaultReturnUrl;", "context", "Landroid/content/Context;", "provideIsInstantApp", "", "providePaymentAuthenticatorRegistry", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticatorRegistry;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "enableLogging", "workContext", "Lkotlin/coroutines/CoroutineContext;", "uiContext", "threeDs1IntentReturnUrlMap", "", "", "defaultAnalyticsRequestExecutor", "Lcom/stripe/android/core/networking/DefaultAnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "publishableKeyProvider", "Lkotlin/Function0;", "productUsage", "", "isInstantApp", "provideThreeDs1IntentReturnUrlMap", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(subcomponents = {PaymentLauncherViewModelSubcomponent.class})
/* compiled from: PaymentLauncherModule.kt */
public final class PaymentLauncherModule {
    @Singleton
    @Provides
    public final Map<String, String> provideThreeDs1IntentReturnUrlMap() {
        return new LinkedHashMap<>();
    }

    @Singleton
    @Provides
    public final DefaultReturnUrl provideDefaultReturnUrl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DefaultReturnUrl.Companion.create(context);
    }

    @Singleton
    @Provides
    public final PaymentAuthenticatorRegistry providePaymentAuthenticatorRegistry(Context context, StripeRepository stripeRepository, @Named("enableLogging") boolean z, @IOContext CoroutineContext coroutineContext, @UIContext CoroutineContext coroutineContext2, Map<String, String> map, DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, @Named("publishableKey") Function0<String> function0, @Named("productUsage") Set<String> set, @Named("isInstantApp") boolean z2) {
        DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor2 = defaultAnalyticsRequestExecutor;
        Intrinsics.checkNotNullParameter(context, "context");
        StripeRepository stripeRepository2 = stripeRepository;
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        CoroutineContext coroutineContext3 = coroutineContext;
        Intrinsics.checkNotNullParameter(coroutineContext3, "workContext");
        CoroutineContext coroutineContext4 = coroutineContext2;
        Intrinsics.checkNotNullParameter(coroutineContext4, "uiContext");
        Map<String, String> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "threeDs1IntentReturnUrlMap");
        Intrinsics.checkNotNullParameter(defaultAnalyticsRequestExecutor2, "defaultAnalyticsRequestExecutor");
        PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2 = paymentAnalyticsRequestFactory;
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Function0<String> function02 = function0;
        Intrinsics.checkNotNullParameter(function02, "publishableKeyProvider");
        Set<String> set2 = set;
        Intrinsics.checkNotNullParameter(set2, NamedConstantsKt.PRODUCT_USAGE);
        return DefaultPaymentAuthenticatorRegistry.Companion.createInstance(context, stripeRepository2, defaultAnalyticsRequestExecutor2, paymentAnalyticsRequestFactory2, z, coroutineContext3, coroutineContext4, map2, function02, set2, z2);
    }

    @Provides
    @Named("isInstantApp")
    public final boolean provideIsInstantApp(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return InstantApps.isInstantApp(context);
    }
}

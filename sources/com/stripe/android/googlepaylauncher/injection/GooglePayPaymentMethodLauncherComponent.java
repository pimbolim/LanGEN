package com.stripe.android.googlepaylauncher.injection;

import android.content.Context;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

@Component(modules = {GooglePayPaymentMethodLauncherModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherComponent;", "", "()V", "inject", "", "factory", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherViewModel$Factory;", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayPaymentMethodLauncherComponent.kt */
public abstract class GooglePayPaymentMethodLauncherComponent {

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH'J\u0012\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH'J\u0012\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u0010H'J\u0018\u0010\u0011\u001a\u00020\u00002\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H'J\u001a\u0010\u0014\u001a\u00020\u00002\u0010\b\u0001\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H'J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H'¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherComponent$Builder;", "", "analyticsRequestFactory", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "build", "Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherComponent;", "context", "Landroid/content/Context;", "enableLogging", "", "googlePayConfig", "config", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "ioContext", "workContext", "Lkotlin/coroutines/CoroutineContext;", "publishableKeyProvider", "Lkotlin/Function0;", "", "stripeAccountIdProvider", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: GooglePayPaymentMethodLauncherComponent.kt */
    public interface Builder {
        @BindsInstance
        Builder analyticsRequestFactory(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory);

        GooglePayPaymentMethodLauncherComponent build();

        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder enableLogging(@Named("enableLogging") boolean z);

        @BindsInstance
        Builder googlePayConfig(GooglePayPaymentMethodLauncher.Config config);

        @BindsInstance
        Builder ioContext(@IOContext CoroutineContext coroutineContext);

        @BindsInstance
        Builder publishableKeyProvider(@Named("publishableKey") Function0<String> function0);

        @BindsInstance
        Builder stripeAccountIdProvider(@Named("stripeAccountId") Function0<String> function0);

        @BindsInstance
        Builder stripeRepository(StripeRepository stripeRepository);
    }

    public abstract void inject(GooglePayPaymentMethodLauncherViewModel.Factory factory);
}

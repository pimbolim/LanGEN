package com.stripe.android.payments.core.injection;

import android.content.Context;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.UIContext;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.core.authentication.DefaultPaymentAuthenticatorRegistry;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModelFactory;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Map;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

@Component(modules = {AuthenticationModule.class, Stripe3DSAuthenticatorModule.class, WeChatPayAuthenticatorModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/payments/core/injection/AuthenticationComponent;", "", "registry", "Lcom/stripe/android/payments/core/authentication/DefaultPaymentAuthenticatorRegistry;", "getRegistry", "()Lcom/stripe/android/payments/core/authentication/DefaultPaymentAuthenticatorRegistry;", "inject", "", "stripe3ds2TransactionViewModelFactory", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionViewModelFactory;", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthenticationComponent.kt */
public interface AuthenticationComponent {

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H'J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH'J\u0012\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\fH'J\u0012\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'J\u0012\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\u0010\u001a\u00020\fH'J\u0018\u0010\u0011\u001a\u00020\u00002\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H'J\u0018\u0010\u0013\u001a\u00020\u00002\u000e\b\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H'J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H'J\u001c\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0018H'J\u0012\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\u001aH'J\u0012\u0010\u001b\u001a\u00020\u00002\b\b\u0001\u0010\u001b\u001a\u00020\u001aH'¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/payments/core/injection/AuthenticationComponent$Builder;", "", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "analyticsRequestFactory", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "build", "Lcom/stripe/android/payments/core/injection/AuthenticationComponent;", "context", "Landroid/content/Context;", "enableLogging", "", "injectorKey", "id", "", "isInstantApp", "productUsage", "", "publishableKeyProvider", "Lkotlin/Function0;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "threeDs1IntentReturnUrlMap", "", "uiContext", "Lkotlin/coroutines/CoroutineContext;", "workContext", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: AuthenticationComponent.kt */
    public interface Builder {
        @BindsInstance
        Builder analyticsRequestExecutor(AnalyticsRequestExecutor analyticsRequestExecutor);

        @BindsInstance
        Builder analyticsRequestFactory(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory);

        AuthenticationComponent build();

        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder enableLogging(@Named("enableLogging") boolean z);

        @BindsInstance
        Builder injectorKey(@InjectorKey String str);

        @BindsInstance
        Builder isInstantApp(@Named("isInstantApp") boolean z);

        @BindsInstance
        Builder productUsage(@Named("productUsage") Set<String> set);

        @BindsInstance
        Builder publishableKeyProvider(@Named("publishableKey") Function0<String> function0);

        @BindsInstance
        Builder stripeRepository(StripeRepository stripeRepository);

        @BindsInstance
        Builder threeDs1IntentReturnUrlMap(Map<String, String> map);

        @BindsInstance
        Builder uiContext(@UIContext CoroutineContext coroutineContext);

        @BindsInstance
        Builder workContext(@IOContext CoroutineContext coroutineContext);
    }

    DefaultPaymentAuthenticatorRegistry getRegistry();

    void inject(Stripe3ds2TransactionViewModelFactory stripe3ds2TransactionViewModelFactory);
}

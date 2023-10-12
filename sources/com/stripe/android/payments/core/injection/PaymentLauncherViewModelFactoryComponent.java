package com.stripe.android.payments.core.injection;

import android.content.Context;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Component(modules = {PaymentLauncherModule.class, StripeRepositoryModule.class, CoroutineContextModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/payments/core/injection/PaymentLauncherViewModelFactoryComponent;", "", "inject", "", "factory", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherViewModel$Factory;", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentLauncherViewModelFactoryComponent.kt */
public interface PaymentLauncherViewModelFactoryComponent {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\u00020\u00002\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J\u0018\u0010\u000b\u001a\u00020\u00002\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH'J\u001a\u0010\r\u001a\u00020\u00002\u0010\b\u0001\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\fH'¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/payments/core/injection/PaymentLauncherViewModelFactoryComponent$Builder;", "", "build", "Lcom/stripe/android/payments/core/injection/PaymentLauncherViewModelFactoryComponent;", "context", "Landroid/content/Context;", "enableLogging", "", "productUsage", "", "", "publishableKeyProvider", "Lkotlin/Function0;", "stripeAccountIdProvider", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: PaymentLauncherViewModelFactoryComponent.kt */
    public interface Builder {
        PaymentLauncherViewModelFactoryComponent build();

        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder enableLogging(@Named("enableLogging") boolean z);

        @BindsInstance
        Builder productUsage(@Named("productUsage") Set<String> set);

        @BindsInstance
        Builder publishableKeyProvider(@Named("publishableKey") Function0<String> function0);

        @BindsInstance
        Builder stripeAccountIdProvider(@Named("stripeAccountId") Function0<String> function0);
    }

    void inject(PaymentLauncherViewModel.Factory factory);
}

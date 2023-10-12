package com.stripe.android.payments.core.injection;

import android.content.Context;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModelFactory;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Component(modules = {StripeRepositoryModule.class, Stripe3ds2TransactionModule.class, CoroutineContextModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionViewModelFactoryComponent;", "", "inject", "", "stripe3ds2TransactionViewModelFactory", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionViewModelFactory;", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2TransactionViewModelFactoryComponent.kt */
public interface Stripe3ds2TransactionViewModelFactoryComponent {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u0012\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u0007H'J\u0018\u0010\t\u001a\u00020\u00002\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH'J\u0018\u0010\f\u001a\u00020\u00002\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH'¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionViewModelFactoryComponent$Builder;", "", "build", "Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionViewModelFactoryComponent;", "context", "Landroid/content/Context;", "enableLogging", "", "isInstantApp", "productUsage", "", "", "publishableKeyProvider", "Lkotlin/Function0;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: Stripe3ds2TransactionViewModelFactoryComponent.kt */
    public interface Builder {
        Stripe3ds2TransactionViewModelFactoryComponent build();

        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder enableLogging(@Named("enableLogging") boolean z);

        @BindsInstance
        Builder isInstantApp(@Named("isInstantApp") boolean z);

        @BindsInstance
        Builder productUsage(@Named("productUsage") Set<String> set);

        @BindsInstance
        Builder publishableKeyProvider(@Named("publishableKey") Function0<String> function0);
    }

    void inject(Stripe3ds2TransactionViewModelFactory stripe3ds2TransactionViewModelFactory);
}

package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.payments.core.injection.StripeRepositoryModule;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;

@Component(modules = {StripeRepositoryModule.class, PaymentSheetCommonModule.class, PaymentOptionsViewModelModule.class, CoroutineContextModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentOptionsViewModelFactoryComponent;", "", "inject", "", "factory", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$Factory;", "Builder", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsViewModelFactoryComponent.kt */
public interface PaymentOptionsViewModelFactoryComponent {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0006\u001a\u00020\u00002\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentOptionsViewModelFactoryComponent$Builder;", "", "build", "Lcom/stripe/android/paymentsheet/injection/PaymentOptionsViewModelFactoryComponent;", "context", "Landroid/content/Context;", "productUsage", "", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: PaymentOptionsViewModelFactoryComponent.kt */
    public interface Builder {
        PaymentOptionsViewModelFactoryComponent build();

        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder productUsage(@Named("productUsage") Set<String> set);
    }

    void inject(PaymentOptionsViewModel.Factory factory);
}

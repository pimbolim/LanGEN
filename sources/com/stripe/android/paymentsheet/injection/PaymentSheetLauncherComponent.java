package com.stripe.android.paymentsheet.injection;

import android.app.Application;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.googlepaylauncher.injection.GooglePayLauncherModule;
import com.stripe.android.payments.core.injection.StripeRepositoryModule;
import com.stripe.android.paymentsheet.PaymentSheetViewModel;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

@Component(modules = {StripeRepositoryModule.class, PaymentSheetCommonModule.class, PaymentSheetLauncherModule.class, GooglePayLauncherModule.class, CoroutineContextModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentSheetLauncherComponent;", "", "inject", "", "factory", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$Factory;", "Lcom/stripe/android/paymentsheet/forms/FormViewModel$Factory;", "Builder", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetLauncherComponent.kt */
public interface PaymentSheetLauncherComponent {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentSheetLauncherComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lcom/stripe/android/paymentsheet/injection/PaymentSheetLauncherComponent;", "injectorKey", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: PaymentSheetLauncherComponent.kt */
    public interface Builder {
        @BindsInstance
        Builder application(Application application);

        PaymentSheetLauncherComponent build();

        @BindsInstance
        Builder injectorKey(@InjectorKey String str);
    }

    void inject(PaymentSheetViewModel.Factory factory);

    void inject(FormViewModel.Factory factory);
}

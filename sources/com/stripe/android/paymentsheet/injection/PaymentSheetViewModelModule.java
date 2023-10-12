package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.paymentsheet.DefaultPrefsRepository;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetContract;
import com.stripe.android.paymentsheet.PrefsRepository;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentSheetViewModelModule;", "", "starterArgs", "Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "(Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;)V", "provideArgs", "providePrefsRepository", "Lcom/stripe/android/paymentsheet/PrefsRepository;", "appContext", "Landroid/content/Context;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: PaymentSheetViewModelModule.kt */
public final class PaymentSheetViewModelModule {
    private final PaymentSheetContract.Args starterArgs;

    public PaymentSheetViewModelModule(PaymentSheetContract.Args args) {
        Intrinsics.checkNotNullParameter(args, "starterArgs");
        this.starterArgs = args;
    }

    @Provides
    public final PaymentSheetContract.Args provideArgs() {
        return this.starterArgs;
    }

    @Provides
    public final PrefsRepository providePrefsRepository(Context context, @IOContext CoroutineContext coroutineContext) {
        PaymentSheet.CustomerConfiguration customer;
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        PaymentSheet.Configuration config$paymentsheet_release = this.starterArgs.getConfig$paymentsheet_release();
        DefaultPrefsRepository defaultPrefsRepository = null;
        if (!(config$paymentsheet_release == null || (customer = config$paymentsheet_release.getCustomer()) == null)) {
            defaultPrefsRepository = new DefaultPrefsRepository(context, customer.component1(), coroutineContext);
        }
        return defaultPrefsRepository == null ? new PrefsRepository.Noop() : defaultPrefsRepository;
    }
}

package com.stripe.android.paymentsheet.injection;

import android.app.Application;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.paymentsheet.PaymentOptionContract;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentOptionsViewModelSubcomponent;", "", "viewModel", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel;", "getViewModel", "()Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel;", "Builder", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Subcomponent
/* compiled from: PaymentOptionsViewModelSubcomponent.kt */
public interface PaymentOptionsViewModelSubcomponent {

    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentOptionsViewModelSubcomponent$Builder;", "", "application", "Landroid/app/Application;", "args", "Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "build", "Lcom/stripe/android/paymentsheet/injection/PaymentOptionsViewModelSubcomponent;", "savedStateHandle", "handle", "Landroidx/lifecycle/SavedStateHandle;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsViewModelSubcomponent.kt */
    public interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder args(PaymentOptionContract.Args args);

        PaymentOptionsViewModelSubcomponent build();

        @BindsInstance
        Builder savedStateHandle(SavedStateHandle savedStateHandle);
    }

    PaymentOptionsViewModel getViewModel();
}

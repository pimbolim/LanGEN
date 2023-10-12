package com.stripe.android.payments.core.injection;

import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel;
import dagger.BindsInstance;
import dagger.Subcomponent;
import javax.inject.Named;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/payments/core/injection/PaymentLauncherViewModelSubcomponent;", "", "viewModel", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherViewModel;", "getViewModel", "()Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherViewModel;", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Subcomponent
/* compiled from: PaymentLauncherViewModelSubcomponent.kt */
public interface PaymentLauncherViewModelSubcomponent {

    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/stripe/android/payments/core/injection/PaymentLauncherViewModelSubcomponent$Builder;", "", "build", "Lcom/stripe/android/payments/core/injection/PaymentLauncherViewModelSubcomponent;", "isPaymentIntent", "", "savedStateHandle", "handle", "Landroidx/lifecycle/SavedStateHandle;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentLauncherViewModelSubcomponent.kt */
    public interface Builder {
        PaymentLauncherViewModelSubcomponent build();

        @BindsInstance
        Builder isPaymentIntent(@Named("isPaymentIntent") boolean z);

        @BindsInstance
        Builder savedStateHandle(SavedStateHandle savedStateHandle);
    }

    PaymentLauncherViewModel getViewModel();
}

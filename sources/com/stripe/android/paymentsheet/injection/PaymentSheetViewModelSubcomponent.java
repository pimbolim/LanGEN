package com.stripe.android.paymentsheet.injection;

import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.paymentsheet.PaymentSheetViewModel;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentSheetViewModelSubcomponent;", "", "viewModel", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel;", "getViewModel", "()Lcom/stripe/android/paymentsheet/PaymentSheetViewModel;", "Builder", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Subcomponent(modules = {PaymentSheetViewModelModule.class})
/* compiled from: PaymentSheetViewModelSubcomponent.kt */
public interface PaymentSheetViewModelSubcomponent {

    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentSheetViewModelSubcomponent$Builder;", "", "build", "Lcom/stripe/android/paymentsheet/injection/PaymentSheetViewModelSubcomponent;", "paymentSheetViewModelModule", "Lcom/stripe/android/paymentsheet/injection/PaymentSheetViewModelModule;", "savedStateHandle", "handle", "Landroidx/lifecycle/SavedStateHandle;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetViewModelSubcomponent.kt */
    public interface Builder {
        PaymentSheetViewModelSubcomponent build();

        Builder paymentSheetViewModelModule(PaymentSheetViewModelModule paymentSheetViewModelModule);

        @BindsInstance
        Builder savedStateHandle(SavedStateHandle savedStateHandle);
    }

    PaymentSheetViewModel getViewModel();
}

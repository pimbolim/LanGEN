package com.stripe.android.paymentsheet;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048VX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAddPaymentMethodFragment;", "Lcom/stripe/android/paymentsheet/BaseAddPaymentMethodFragment;", "()V", "sheetViewModel", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel;", "getSheetViewModel", "()Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel;", "sheetViewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAddPaymentMethodFragment.kt */
public final class PaymentOptionsAddPaymentMethodFragment extends BaseAddPaymentMethodFragment {
    private final Lazy sheetViewModel$delegate;
    private final ViewModelProvider.Factory viewModelFactory;

    public PaymentOptionsAddPaymentMethodFragment() {
        Function0 paymentOptionsAddPaymentMethodFragment$viewModelFactory$1 = new PaymentOptionsAddPaymentMethodFragment$viewModelFactory$1(this);
        Function0 paymentOptionsAddPaymentMethodFragment$viewModelFactory$2 = new PaymentOptionsAddPaymentMethodFragment$viewModelFactory$2(this);
        FragmentActivity activity = getActivity();
        SavedStateRegistryOwner savedStateRegistryOwner = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        this.viewModelFactory = new PaymentOptionsViewModel.Factory(paymentOptionsAddPaymentMethodFragment$viewModelFactory$1, paymentOptionsAddPaymentMethodFragment$viewModelFactory$2, savedStateRegistryOwner == null ? this : savedStateRegistryOwner, (Bundle) null, 8, (DefaultConstructorMarker) null);
        Fragment fragment = this;
        this.sheetViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(PaymentOptionsViewModel.class), new PaymentOptionsAddPaymentMethodFragment$special$$inlined$activityViewModels$1(fragment), new PaymentOptionsAddPaymentMethodFragment$sheetViewModel$2(this));
    }

    public ViewModelProvider.Factory getViewModelFactory() {
        return this.viewModelFactory;
    }

    public PaymentOptionsViewModel getSheetViewModel() {
        return (PaymentOptionsViewModel) this.sheetViewModel$delegate.getValue();
    }
}

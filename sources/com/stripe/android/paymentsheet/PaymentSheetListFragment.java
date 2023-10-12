package com.stripe.android.paymentsheet;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.stripe.android.paymentsheet.PaymentSheetViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048VX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetListFragment;", "Lcom/stripe/android/paymentsheet/BasePaymentMethodsListFragment;", "()V", "activityViewModel", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel;", "getActivityViewModel", "()Lcom/stripe/android/paymentsheet/PaymentSheetViewModel;", "activityViewModel$delegate", "Lkotlin/Lazy;", "sheetViewModel", "getSheetViewModel", "sheetViewModel$delegate", "transitionToAddPaymentMethod", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetListFragment.kt */
public final class PaymentSheetListFragment extends BasePaymentMethodsListFragment {
    private final Lazy activityViewModel$delegate;
    private final Lazy sheetViewModel$delegate = LazyKt.lazy(new PaymentSheetListFragment$sheetViewModel$2(this));

    public PaymentSheetListFragment() {
        super(false);
        Fragment fragment = this;
        this.activityViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(PaymentSheetViewModel.class), new PaymentSheetListFragment$special$$inlined$activityViewModels$1(fragment), new PaymentSheetListFragment$activityViewModel$2(this));
    }

    /* access modifiers changed from: private */
    public final PaymentSheetViewModel getActivityViewModel() {
        return (PaymentSheetViewModel) this.activityViewModel$delegate.getValue();
    }

    public PaymentSheetViewModel getSheetViewModel() {
        return (PaymentSheetViewModel) this.sheetViewModel$delegate.getValue();
    }

    public void transitionToAddPaymentMethod() {
        getActivityViewModel().transitionTo(new PaymentSheetViewModel.TransitionTarget.AddPaymentMethodFull(getConfig()));
    }
}

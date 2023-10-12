package com.stripe.android.paymentsheet;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048VX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsListFragment;", "Lcom/stripe/android/paymentsheet/BasePaymentMethodsListFragment;", "()V", "activityViewModel", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel;", "getActivityViewModel", "()Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel;", "activityViewModel$delegate", "Lkotlin/Lazy;", "sheetViewModel", "getSheetViewModel", "sheetViewModel$delegate", "onPaymentOptionSelected", "", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "isClick", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "transitionToAddPaymentMethod", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsListFragment.kt */
public final class PaymentOptionsListFragment extends BasePaymentMethodsListFragment {
    private final Lazy activityViewModel$delegate;
    private final Lazy sheetViewModel$delegate = LazyKt.lazy(new PaymentOptionsListFragment$sheetViewModel$2(this));

    public PaymentOptionsListFragment() {
        super(true);
        Fragment fragment = this;
        this.activityViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(PaymentOptionsViewModel.class), new PaymentOptionsListFragment$special$$inlined$activityViewModels$1(fragment), new PaymentOptionsListFragment$activityViewModel$2(this));
    }

    /* access modifiers changed from: private */
    public final PaymentOptionsViewModel getActivityViewModel() {
        return (PaymentOptionsViewModel) this.activityViewModel$delegate.getValue();
    }

    public PaymentOptionsViewModel getSheetViewModel() {
        return (PaymentOptionsViewModel) this.sheetViewModel$delegate.getValue();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getSheetViewModel().resolveTransitionTarget(getConfig());
    }

    public void transitionToAddPaymentMethod() {
        getActivityViewModel().transitionTo(new PaymentOptionsViewModel.TransitionTarget.AddPaymentMethodFull(getConfig()));
    }

    public void onPaymentOptionSelected(PaymentSelection paymentSelection, boolean z) {
        Intrinsics.checkNotNullParameter(paymentSelection, "paymentSelection");
        super.onPaymentOptionSelected(paymentSelection, z);
        if (z) {
            getSheetViewModel().onUserSelection();
        }
    }
}

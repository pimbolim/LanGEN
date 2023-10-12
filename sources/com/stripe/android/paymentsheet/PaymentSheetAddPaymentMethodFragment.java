package com.stripe.android.paymentsheet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import com.facebook.react.uimanager.ViewProps;
import com.stripe.android.paymentsheet.PaymentSheetViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048VX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetAddPaymentMethodFragment;", "Lcom/stripe/android/paymentsheet/BaseAddPaymentMethodFragment;", "()V", "sheetViewModel", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel;", "getSheetViewModel", "()Lcom/stripe/android/paymentsheet/PaymentSheetViewModel;", "sheetViewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetAddPaymentMethodFragment.kt */
public final class PaymentSheetAddPaymentMethodFragment extends BaseAddPaymentMethodFragment {
    private final Lazy sheetViewModel$delegate;
    private final ViewModelProvider.Factory viewModelFactory;

    public PaymentSheetAddPaymentMethodFragment() {
        Intent intent;
        Function0 paymentSheetAddPaymentMethodFragment$viewModelFactory$1 = new PaymentSheetAddPaymentMethodFragment$viewModelFactory$1(this);
        Function0 paymentSheetAddPaymentMethodFragment$viewModelFactory$2 = new PaymentSheetAddPaymentMethodFragment$viewModelFactory$2(this);
        FragmentActivity activity = getActivity();
        Bundle bundle = null;
        SavedStateRegistryOwner savedStateRegistryOwner = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        SavedStateRegistryOwner savedStateRegistryOwner2 = savedStateRegistryOwner == null ? this : savedStateRegistryOwner;
        FragmentActivity activity2 = getActivity();
        AppCompatActivity appCompatActivity = activity2 instanceof AppCompatActivity ? (AppCompatActivity) activity2 : null;
        if (!(appCompatActivity == null || (intent = appCompatActivity.getIntent()) == null)) {
            bundle = intent.getExtras();
        }
        this.viewModelFactory = new PaymentSheetViewModel.Factory(paymentSheetAddPaymentMethodFragment$viewModelFactory$1, paymentSheetAddPaymentMethodFragment$viewModelFactory$2, savedStateRegistryOwner2, bundle);
        Fragment fragment = this;
        this.sheetViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(PaymentSheetViewModel.class), new PaymentSheetAddPaymentMethodFragment$special$$inlined$activityViewModels$1(fragment), new PaymentSheetAddPaymentMethodFragment$sheetViewModel$2(this));
    }

    public ViewModelProvider.Factory getViewModelFactory() {
        return this.viewModelFactory;
    }

    public PaymentSheetViewModel getSheetViewModel() {
        return (PaymentSheetViewModel) this.sheetViewModel$delegate.getValue();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getSheetViewModel().getShowTopContainer$paymentsheet_release().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PaymentSheetAddPaymentMethodFragment.m4426onViewCreated$lambda0(PaymentSheetAddPaymentMethodFragment.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m4426onViewCreated$lambda0(PaymentSheetAddPaymentMethodFragment paymentSheetAddPaymentMethodFragment, Boolean bool) {
        String str;
        Intrinsics.checkNotNullParameter(paymentSheetAddPaymentMethodFragment, "this$0");
        MutableLiveData<String> headerText$paymentsheet_release = paymentSheetAddPaymentMethodFragment.getSheetViewModel().getHeaderText$paymentsheet_release();
        Intrinsics.checkNotNullExpressionValue(bool, ViewProps.VISIBLE);
        if (bool.booleanValue()) {
            str = null;
        } else {
            str = paymentSheetAddPaymentMethodFragment.getString(R.string.stripe_paymentsheet_add_payment_method_title);
        }
        headerText$paymentsheet_release.setValue(str);
    }
}

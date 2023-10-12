package com.stripe.android.paymentsheet;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.stripe.android.paymentsheet.ui.PrimaryButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/stripe/android/paymentsheet/PaymentOptionsActivity$onCreate$5", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "onFragmentStarted", "", "fm", "Landroidx/fragment/app/FragmentManager;", "fragment", "Landroidx/fragment/app/Fragment;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsActivity.kt */
public final class PaymentOptionsActivity$onCreate$5 extends FragmentManager.FragmentLifecycleCallbacks {
    final /* synthetic */ PaymentOptionsActivity this$0;

    PaymentOptionsActivity$onCreate$5(PaymentOptionsActivity paymentOptionsActivity) {
        this.this$0 = paymentOptionsActivity;
    }

    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        PrimaryButton primaryButton = this.this$0.getViewBinding$paymentsheet_release().continueButton;
        Intrinsics.checkNotNullExpressionValue(primaryButton, "viewBinding.continueButton");
        primaryButton.setVisibility(fragment instanceof PaymentOptionsAddPaymentMethodFragment ? 0 : 8);
    }
}

package com.stripe.android.view;

import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.stripe.android.view.FpxViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/view/FpxViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodFpxView.kt */
final class AddPaymentMethodFpxView$viewModel$2 extends Lambda implements Function0<FpxViewModel> {
    final /* synthetic */ FragmentActivity $activity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddPaymentMethodFpxView$viewModel$2(FragmentActivity fragmentActivity) {
        super(0);
        this.$activity = fragmentActivity;
    }

    public final FpxViewModel invoke() {
        FragmentActivity fragmentActivity = this.$activity;
        Application application = fragmentActivity.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "activity.application");
        return (FpxViewModel) new ViewModelProvider((ViewModelStoreOwner) fragmentActivity, (ViewModelProvider.Factory) new FpxViewModel.Factory(application)).get(FpxViewModel.class);
    }
}

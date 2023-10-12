package com.stripe.android.view;

import android.app.Application;
import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.view.PaymentMethodsViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsActivity.kt */
final class PaymentMethodsActivity$viewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ PaymentMethodsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsActivity$viewModel$2(PaymentMethodsActivity paymentMethodsActivity) {
        super(0);
        this.this$0 = paymentMethodsActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        Application application = this.this$0.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        return new PaymentMethodsViewModel.Factory(application, this.this$0.m4673getCustomerSessiond1pmJ48(), this.this$0.getArgs().getInitialPaymentMethodId$payments_core_release(), this.this$0.getStartedFromPaymentSession());
    }
}

package com.stripe.android.view;

import android.app.Application;
import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.core.Logger;
import com.stripe.android.view.PaymentAuthWebViewActivityViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthWebViewActivity.kt */
final class PaymentAuthWebViewActivity$viewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ PaymentAuthWebViewActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentAuthWebViewActivity$viewModel$2(PaymentAuthWebViewActivity paymentAuthWebViewActivity) {
        super(0);
        this.this$0 = paymentAuthWebViewActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        Application application = this.this$0.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        Logger access$getLogger = this.this$0.getLogger();
        PaymentBrowserAuthContract.Args access$get_args = this.this$0.get_args();
        if (access$get_args != null) {
            return new PaymentAuthWebViewActivityViewModel.Factory(application, access$getLogger, access$get_args);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

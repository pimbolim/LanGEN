package com.stripe.android.googlepaylauncher;

import android.app.Application;
import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.googlepaylauncher.StripeGooglePayContract;
import com.stripe.android.googlepaylauncher.StripeGooglePayViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeGooglePayActivity.kt */
final class StripeGooglePayActivity$viewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ StripeGooglePayActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeGooglePayActivity$viewModel$2(StripeGooglePayActivity stripeGooglePayActivity) {
        super(0);
        this.this$0 = stripeGooglePayActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        Application application = this.this$0.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        String access$getPublishableKey = this.this$0.getPublishableKey();
        String access$getStripeAccountId = this.this$0.getStripeAccountId();
        StripeGooglePayContract.Args access$getArgs$p = this.this$0.args;
        if (access$getArgs$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("args");
            access$getArgs$p = null;
        }
        return new StripeGooglePayViewModel.Factory(application, access$getPublishableKey, access$getStripeAccountId, access$getArgs$p);
    }
}

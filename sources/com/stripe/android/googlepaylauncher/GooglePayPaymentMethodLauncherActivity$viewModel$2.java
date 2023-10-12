package com.stripe.android.googlepaylauncher;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayPaymentMethodLauncherActivity.kt */
final class GooglePayPaymentMethodLauncherActivity$viewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ GooglePayPaymentMethodLauncherActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayPaymentMethodLauncherActivity$viewModel$2(GooglePayPaymentMethodLauncherActivity googlePayPaymentMethodLauncherActivity) {
        super(0);
        this.this$0 = googlePayPaymentMethodLauncherActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        Application application = this.this$0.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        GooglePayPaymentMethodLauncherContract.Args access$getArgs$p = this.this$0.args;
        if (access$getArgs$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("args");
            access$getArgs$p = null;
        }
        return new GooglePayPaymentMethodLauncherViewModel.Factory(application, access$getArgs$p, this.this$0, (Bundle) null, 8, (DefaultConstructorMarker) null);
    }
}

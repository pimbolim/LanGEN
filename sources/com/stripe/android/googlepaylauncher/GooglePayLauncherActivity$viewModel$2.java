package com.stripe.android.googlepaylauncher;

import android.app.Application;
import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.googlepaylauncher.GooglePayLauncherContract;
import com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayLauncherActivity.kt */
final class GooglePayLauncherActivity$viewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ GooglePayLauncherActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayLauncherActivity$viewModel$2(GooglePayLauncherActivity googlePayLauncherActivity) {
        super(0);
        this.this$0 = googlePayLauncherActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        Application application = this.this$0.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        GooglePayLauncherContract.Args access$getArgs$p = this.this$0.args;
        if (access$getArgs$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("args");
            access$getArgs$p = null;
        }
        return new GooglePayLauncherViewModel.Factory(application, access$getArgs$p, false, (CoroutineContext) null, 12, (DefaultConstructorMarker) null);
    }
}

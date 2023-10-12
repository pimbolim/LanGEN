package com.stripe.android;

import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.StripeBrowserLauncherActivity;
import com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization;
import com.stripe.android.view.AuthActivityStarter;
import com.stripe.android.view.AuthActivityStarterHost;
import com.stripe.android.view.PaymentAuthWebViewActivity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/PaymentBrowserAuthStarter;", "Lcom/stripe/android/view/AuthActivityStarter;", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "Legacy", "Modern", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentBrowserAuthStarter.kt */
public interface PaymentBrowserAuthStarter extends AuthActivityStarter<PaymentBrowserAuthContract.Args> {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/PaymentBrowserAuthStarter$Legacy;", "Lcom/stripe/android/PaymentBrowserAuthStarter;", "host", "Lcom/stripe/android/view/AuthActivityStarterHost;", "defaultReturnUrl", "Lcom/stripe/android/payments/DefaultReturnUrl;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/payments/DefaultReturnUrl;)V", "start", "", "args", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentBrowserAuthStarter.kt */
    public static final class Legacy implements PaymentBrowserAuthStarter {
        public static final int $stable = 0;
        private final DefaultReturnUrl defaultReturnUrl;
        private final AuthActivityStarterHost host;

        public Legacy(AuthActivityStarterHost authActivityStarterHost, DefaultReturnUrl defaultReturnUrl2) {
            Intrinsics.checkNotNullParameter(authActivityStarterHost, "host");
            Intrinsics.checkNotNullParameter(defaultReturnUrl2, "defaultReturnUrl");
            this.host = authActivityStarterHost;
            this.defaultReturnUrl = defaultReturnUrl2;
        }

        public void start(PaymentBrowserAuthContract.Args args) {
            Class cls;
            Intrinsics.checkNotNullParameter(args, "args");
            Bundle bundle = PaymentBrowserAuthContract.Args.copy$default(args, (String) null, 0, (String) null, (String) null, (String) null, false, (StripeToolbarCustomization) null, (String) null, false, false, this.host.getStatusBarColor$payments_core_release(), (String) null, false, 7167, (Object) null).toBundle();
            AuthActivityStarterHost authActivityStarterHost = this.host;
            boolean z = args.hasDefaultReturnUrl$payments_core_release(this.defaultReturnUrl) || args.isInstantApp();
            if (z) {
                cls = StripeBrowserLauncherActivity.class;
            } else if (!z) {
                cls = PaymentAuthWebViewActivity.class;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            authActivityStarterHost.startActivityForResult(cls, bundle, args.getRequestCode());
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/PaymentBrowserAuthStarter$Modern;", "Lcom/stripe/android/PaymentBrowserAuthStarter;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "(Landroidx/activity/result/ActivityResultLauncher;)V", "start", "", "args", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentBrowserAuthStarter.kt */
    public static final class Modern implements PaymentBrowserAuthStarter {
        public static final int $stable = 8;
        private final ActivityResultLauncher<PaymentBrowserAuthContract.Args> launcher;

        public Modern(ActivityResultLauncher<PaymentBrowserAuthContract.Args> activityResultLauncher) {
            Intrinsics.checkNotNullParameter(activityResultLauncher, "launcher");
            this.launcher = activityResultLauncher;
        }

        public void start(PaymentBrowserAuthContract.Args args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.launcher.launch(args);
        }
    }
}

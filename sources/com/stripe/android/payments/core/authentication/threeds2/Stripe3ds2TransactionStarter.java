package com.stripe.android.payments.core.authentication.threeds2;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.StripePaymentController;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract;
import com.stripe.android.view.AuthActivityStarter;
import com.stripe.android.view.AuthActivityStarterHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionStarter;", "Lcom/stripe/android/view/AuthActivityStarter;", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "Legacy", "Modern", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2TransactionStarter.kt */
public interface Stripe3ds2TransactionStarter extends AuthActivityStarter<Stripe3ds2TransactionContract.Args> {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionStarter$Legacy;", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionStarter;", "host", "Lcom/stripe/android/view/AuthActivityStarterHost;", "(Lcom/stripe/android/view/AuthActivityStarterHost;)V", "start", "", "args", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2TransactionStarter.kt */
    public static final class Legacy implements Stripe3ds2TransactionStarter {
        public static final int $stable = 0;
        private final AuthActivityStarterHost host;

        public Legacy(AuthActivityStarterHost authActivityStarterHost) {
            Intrinsics.checkNotNullParameter(authActivityStarterHost, "host");
            this.host = authActivityStarterHost;
        }

        public void start(Stripe3ds2TransactionContract.Args args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.host.startActivityForResult(Stripe3ds2TransactionActivity.class, args.toBundle(), StripePaymentController.Companion.getRequestCode$payments_core_release(args.getStripeIntent()));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionStarter$Modern;", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionStarter;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "(Landroidx/activity/result/ActivityResultLauncher;)V", "start", "", "args", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2TransactionStarter.kt */
    public static final class Modern implements Stripe3ds2TransactionStarter {
        public static final int $stable = 8;
        private final ActivityResultLauncher<Stripe3ds2TransactionContract.Args> launcher;

        public Modern(ActivityResultLauncher<Stripe3ds2TransactionContract.Args> activityResultLauncher) {
            Intrinsics.checkNotNullParameter(activityResultLauncher, "launcher");
            this.launcher = activityResultLauncher;
        }

        public void start(Stripe3ds2TransactionContract.Args args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.launcher.launch(args);
        }
    }
}

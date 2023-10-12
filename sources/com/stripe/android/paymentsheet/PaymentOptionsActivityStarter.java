package com.stripe.android.paymentsheet;

import android.app.Activity;
import com.stripe.android.paymentsheet.PaymentOptionContract;
import com.stripe.android.view.ActivityStarter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsActivityStarter;", "Lcom/stripe/android/view/ActivityStarter;", "Lcom/stripe/android/paymentsheet/PaymentOptionsActivity;", "Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsActivityStarter.kt */
public final class PaymentOptionsActivityStarter extends ActivityStarter<PaymentOptionsActivity, PaymentOptionContract.Args> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_CODE = 6004;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentOptionsActivityStarter(Activity activity) {
        super(activity, PaymentOptionsActivity.class, (int) REQUEST_CODE, (Integer) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsActivityStarter$Companion;", "", "()V", "REQUEST_CODE", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsActivityStarter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package com.stripe.android.view;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/AlertDisplayer;", "", "show", "", "message", "", "DefaultAlertDisplayer", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlertDisplayer.kt */
public interface AlertDisplayer {
    void show(String str);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/AlertDisplayer$DefaultAlertDisplayer;", "Lcom/stripe/android/view/AlertDisplayer;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "show", "", "message", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AlertDisplayer.kt */
    public static final class DefaultAlertDisplayer implements AlertDisplayer {
        public static final int $stable = 8;
        private final Activity activity;

        public DefaultAlertDisplayer(Activity activity2) {
            Intrinsics.checkNotNullParameter(activity2, "activity");
            this.activity = activity2;
        }

        public void show(String str) {
            Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.MESSAGE);
            if (!this.activity.isFinishing()) {
                new AlertDialog.Builder(this.activity, R.style.AlertDialogStyle).setMessage((CharSequence) str).setCancelable(true).setPositiveButton(17039370, (DialogInterface.OnClickListener) $$Lambda$AlertDisplayer$DefaultAlertDisplayer$B1VZH65ec94vxX1qW2UtpoloVEo.INSTANCE).create().show();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: show$lambda-0  reason: not valid java name */
        public static final void m4640show$lambda0(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }
}

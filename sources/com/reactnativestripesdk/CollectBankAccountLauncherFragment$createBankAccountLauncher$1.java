package com.reactnativestripesdk;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: CollectBankAccountLauncherFragment.kt */
final class CollectBankAccountLauncherFragment$createBankAccountLauncher$1 extends Lambda implements Function1<CollectBankAccountResult, Unit> {
    final /* synthetic */ CollectBankAccountLauncherFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectBankAccountLauncherFragment$createBankAccountLauncher$1(CollectBankAccountLauncherFragment collectBankAccountLauncherFragment) {
        super(1);
        this.this$0 = collectBankAccountLauncherFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CollectBankAccountResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CollectBankAccountResult collectBankAccountResult) {
        FragmentTransaction remove;
        FragmentManager supportFragmentManager;
        WritableMap writableMap;
        Intrinsics.checkNotNullParameter(collectBankAccountResult, "result");
        if (collectBankAccountResult instanceof CollectBankAccountResult.Completed) {
            StripeIntent intent = ((CollectBankAccountResult.Completed) collectBankAccountResult).getResponse().getIntent();
            if (intent.getStatus() == StripeIntent.Status.RequiresPaymentMethod) {
                this.this$0.promise.resolve(ErrorsKt.createError(ErrorType.Canceled.toString(), "Bank account collection was canceled."));
            } else if (intent.getStatus() == StripeIntent.Status.RequiresConfirmation) {
                Promise access$getPromise$p = this.this$0.promise;
                if (this.this$0.isPaymentIntent) {
                    writableMap = MappersKt.createResult("paymentIntent", MappersKt.mapFromPaymentIntentResult((PaymentIntent) intent));
                } else {
                    writableMap = MappersKt.createResult("setupIntent", MappersKt.mapFromSetupIntentResult((SetupIntent) intent));
                }
                access$getPromise$p.resolve(writableMap);
            }
        } else if (collectBankAccountResult instanceof CollectBankAccountResult.Cancelled) {
            this.this$0.promise.resolve(ErrorsKt.createError(ErrorType.Canceled.toString(), "Bank account collection was canceled."));
        } else if (collectBankAccountResult instanceof CollectBankAccountResult.Failed) {
            this.this$0.promise.resolve(ErrorsKt.createError(ErrorType.Failed.toString(), ((CollectBankAccountResult.Failed) collectBankAccountResult).getError()));
        }
        Activity currentActivity = this.this$0.context.getCurrentActivity();
        FragmentTransaction fragmentTransaction = null;
        AppCompatActivity appCompatActivity = currentActivity instanceof AppCompatActivity ? (AppCompatActivity) currentActivity : null;
        if (!(appCompatActivity == null || (supportFragmentManager = appCompatActivity.getSupportFragmentManager()) == null)) {
            fragmentTransaction = supportFragmentManager.beginTransaction();
        }
        if (fragmentTransaction != null && (remove = fragmentTransaction.remove(this.this$0)) != null) {
            remove.commit();
        }
    }
}

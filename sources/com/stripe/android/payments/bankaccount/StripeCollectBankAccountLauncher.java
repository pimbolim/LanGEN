package com.stripe.android.payments.bankaccount;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/payments/bankaccount/StripeCollectBankAccountLauncher;", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountLauncher;", "hostActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "(Landroidx/activity/result/ActivityResultLauncher;)V", "presentWithPaymentIntent", "", "publishableKey", "", "clientSecret", "configuration", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;", "presentWithSetupIntent", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountLauncher.kt */
public final class StripeCollectBankAccountLauncher implements CollectBankAccountLauncher {
    private final ActivityResultLauncher<CollectBankAccountContract.Args> hostActivityLauncher;

    public StripeCollectBankAccountLauncher(ActivityResultLauncher<CollectBankAccountContract.Args> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "hostActivityLauncher");
        this.hostActivityLauncher = activityResultLauncher;
    }

    public void presentWithPaymentIntent(String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration) {
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        Intrinsics.checkNotNullParameter(str2, "clientSecret");
        Intrinsics.checkNotNullParameter(collectBankAccountConfiguration, "configuration");
        this.hostActivityLauncher.launch(new CollectBankAccountContract.Args.ForPaymentIntent(str, str2, collectBankAccountConfiguration));
    }

    public void presentWithSetupIntent(String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration) {
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        Intrinsics.checkNotNullParameter(str2, "clientSecret");
        Intrinsics.checkNotNullParameter(collectBankAccountConfiguration, "configuration");
        this.hostActivityLauncher.launch(new CollectBankAccountContract.Args.ForSetupIntent(str, str2, collectBankAccountConfiguration));
    }
}

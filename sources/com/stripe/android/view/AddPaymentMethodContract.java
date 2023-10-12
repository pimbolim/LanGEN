package com.stripe.android.view;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.view.AddPaymentMethodActivityStarter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodContract.kt */
public final class AddPaymentMethodContract extends ActivityResultContract<AddPaymentMethodActivityStarter.Args, AddPaymentMethodActivityStarter.Result> {
    public Intent createIntent(Context context, AddPaymentMethodActivityStarter.Args args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, GraphQLConstants.Keys.INPUT);
        Intent putExtra = new Intent(context, AddPaymentMethodActivity.class).putExtra("extra_activity_args", args);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, AddPayme…tarter.Args.EXTRA, input)");
        return putExtra;
    }

    public AddPaymentMethodActivityStarter.Result parseResult(int i, Intent intent) {
        return AddPaymentMethodActivityStarter.Result.Companion.fromIntent(intent);
    }
}

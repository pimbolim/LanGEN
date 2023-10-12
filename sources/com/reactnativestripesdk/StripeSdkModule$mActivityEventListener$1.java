package com.reactnativestripesdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.result.ActivityResultRegistry;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.stripe.android.view.AddPaymentMethodActivityStarter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/reactnativestripesdk/StripeSdkModule$mActivityEventListener$1", "Lcom/facebook/react/bridge/BaseActivityEventListener;", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StripeSdkModule.kt */
public final class StripeSdkModule$mActivityEventListener$1 extends BaseActivityEventListener {
    final /* synthetic */ StripeSdkModule this$0;

    StripeSdkModule$mActivityEventListener$1(StripeSdkModule stripeSdkModule) {
        this.this$0 = stripeSdkModule;
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        ActivityResultRegistry activityResultRegistry;
        ActivityResultRegistry activityResultRegistry2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.this$0.stripe != null) {
            PaymentSheetFragment access$getPaymentSheetFragment$p = this.this$0.paymentSheetFragment;
            Parcelable parcelable = null;
            FragmentActivity activity2 = access$getPaymentSheetFragment$p == null ? null : access$getPaymentSheetFragment$p.getActivity();
            if (!(activity2 == null || (activityResultRegistry2 = activity2.getActivityResultRegistry()) == null)) {
                activityResultRegistry2.dispatchResult(i, i2, intent);
            }
            GooglePayFragment access$getGooglePayFragment$p = this.this$0.googlePayFragment;
            FragmentActivity activity3 = access$getGooglePayFragment$p == null ? null : access$getGooglePayFragment$p.getActivity();
            if (!(activity3 == null || (activityResultRegistry = activity3.getActivityResultRegistry()) == null)) {
                activityResultRegistry.dispatchResult(i, i2, intent);
            }
            try {
                AddPaymentMethodActivityStarter.Result fromIntent = AddPaymentMethodActivityStarter.Result.Companion.fromIntent(intent);
                if (intent != null) {
                    parcelable = intent.getParcelableExtra("extra_activity_result");
                }
                if (parcelable != null) {
                    this.this$0.onFpxPaymentMethodResult(fromIntent);
                }
            } catch (Exception e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = e.toString();
                }
                Log.d("Error", localizedMessage);
            }
        }
    }
}

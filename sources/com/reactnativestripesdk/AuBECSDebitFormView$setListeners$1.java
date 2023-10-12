package com.reactnativestripesdk;

import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.view.BecsDebitWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/reactnativestripesdk/AuBECSDebitFormView$setListeners$1", "Lcom/stripe/android/view/BecsDebitWidget$ValidParamsCallback;", "onInputChanged", "", "isValid", "", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AuBECSDebitFormView.kt */
public final class AuBECSDebitFormView$setListeners$1 implements BecsDebitWidget.ValidParamsCallback {
    final /* synthetic */ AuBECSDebitFormView this$0;

    AuBECSDebitFormView$setListeners$1(AuBECSDebitFormView auBECSDebitFormView) {
        this.this$0 = auBECSDebitFormView;
    }

    public void onInputChanged(boolean z) {
        BecsDebitWidget access$getBecsDebitWidget$p = this.this$0.becsDebitWidget;
        if (access$getBecsDebitWidget$p != null) {
            PaymentMethodCreateParams params = access$getBecsDebitWidget$p.getParams();
            if (params != null) {
                this.this$0.onFormChanged(params);
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("becsDebitWidget");
        throw null;
    }
}

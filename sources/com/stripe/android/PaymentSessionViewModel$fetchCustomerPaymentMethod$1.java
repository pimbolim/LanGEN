package com.stripe.android;

import com.stripe.android.CustomerSession;
import com.stripe.android.core.StripeError;
import com.stripe.android.model.PaymentMethod;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"com/stripe/android/PaymentSessionViewModel$fetchCustomerPaymentMethod$1", "Lcom/stripe/android/CustomerSession$PaymentMethodsRetrievalListener;", "onError", "", "errorCode", "", "errorMessage", "", "stripeError", "Lcom/stripe/android/core/StripeError;", "onPaymentMethodsRetrieved", "paymentMethods", "", "Lcom/stripe/android/model/PaymentMethod;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSessionViewModel.kt */
public final class PaymentSessionViewModel$fetchCustomerPaymentMethod$1 implements CustomerSession.PaymentMethodsRetrievalListener {
    final /* synthetic */ Function1<PaymentMethod, Unit> $onComplete;
    final /* synthetic */ String $paymentMethodId;

    PaymentSessionViewModel$fetchCustomerPaymentMethod$1(Function1<? super PaymentMethod, Unit> function1, String str) {
        this.$onComplete = function1;
        this.$paymentMethodId = str;
    }

    public void onPaymentMethodsRetrieved(List<PaymentMethod> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "paymentMethods");
        Function1<PaymentMethod, Unit> function1 = this.$onComplete;
        String str = this.$paymentMethodId;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((PaymentMethod) obj).id, (Object) str)) {
                break;
            }
        }
        function1.invoke(obj);
    }

    public void onError(int i, String str, StripeError stripeError) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        this.$onComplete.invoke(null);
    }
}

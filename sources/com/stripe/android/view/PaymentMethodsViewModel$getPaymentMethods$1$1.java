package com.stripe.android.view;

import androidx.lifecycle.MutableLiveData;
import com.stripe.android.CustomerSession;
import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.model.PaymentMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"com/stripe/android/view/PaymentMethodsViewModel$getPaymentMethods$1$1", "Lcom/stripe/android/CustomerSession$PaymentMethodsRetrievalListener;", "onError", "", "errorCode", "", "errorMessage", "", "stripeError", "Lcom/stripe/android/core/StripeError;", "onPaymentMethodsRetrieved", "paymentMethods", "", "Lcom/stripe/android/model/PaymentMethod;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsViewModel.kt */
public final class PaymentMethodsViewModel$getPaymentMethods$1$1 implements CustomerSession.PaymentMethodsRetrievalListener {
    final /* synthetic */ MutableLiveData<Result<List<PaymentMethod>>> $resultData;
    final /* synthetic */ PaymentMethodsViewModel this$0;

    PaymentMethodsViewModel$getPaymentMethods$1$1(MutableLiveData<Result<List<PaymentMethod>>> mutableLiveData, PaymentMethodsViewModel paymentMethodsViewModel) {
        this.$resultData = mutableLiveData;
        this.this$0 = paymentMethodsViewModel;
    }

    public void onPaymentMethodsRetrieved(List<PaymentMethod> list) {
        Intrinsics.checkNotNullParameter(list, "paymentMethods");
        MutableLiveData<Result<List<PaymentMethod>>> mutableLiveData = this.$resultData;
        Result.Companion companion = Result.Companion;
        mutableLiveData.setValue(Result.m4708boximpl(Result.m4709constructorimpl(list)));
        this.this$0.getProgressData$payments_core_release().setValue(false);
    }

    public void onError(int i, String str, StripeError stripeError) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        MutableLiveData<Result<List<PaymentMethod>>> mutableLiveData = this.$resultData;
        Result.Companion companion = Result.Companion;
        mutableLiveData.setValue(Result.m4708boximpl(Result.m4709constructorimpl(ResultKt.createFailure(new APIException(stripeError, (String) null, i, str, (Throwable) null, 18, (DefaultConstructorMarker) null)))));
        this.this$0.getProgressData$payments_core_release().setValue(false);
    }
}

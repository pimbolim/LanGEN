package com.stripe.android.view;

import androidx.lifecycle.MutableLiveData;
import com.stripe.android.CustomerSession;
import com.stripe.android.core.StripeError;
import com.stripe.android.model.PaymentMethod;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/stripe/android/view/AddPaymentMethodViewModel$attachPaymentMethod$1", "Lcom/stripe/android/CustomerSession$PaymentMethodRetrievalListener;", "onError", "", "errorCode", "", "errorMessage", "", "stripeError", "Lcom/stripe/android/core/StripeError;", "onPaymentMethodRetrieved", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodViewModel.kt */
public final class AddPaymentMethodViewModel$attachPaymentMethod$1 implements CustomerSession.PaymentMethodRetrievalListener {
    final /* synthetic */ MutableLiveData<Result<PaymentMethod>> $resultData;
    final /* synthetic */ AddPaymentMethodViewModel this$0;

    AddPaymentMethodViewModel$attachPaymentMethod$1(MutableLiveData<Result<PaymentMethod>> mutableLiveData, AddPaymentMethodViewModel addPaymentMethodViewModel) {
        this.$resultData = mutableLiveData;
        this.this$0 = addPaymentMethodViewModel;
    }

    public void onPaymentMethodRetrieved(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        MutableLiveData<Result<PaymentMethod>> mutableLiveData = this.$resultData;
        Result.Companion companion = Result.Companion;
        mutableLiveData.setValue(Result.m4708boximpl(Result.m4709constructorimpl(paymentMethod)));
    }

    public void onError(int i, String str, StripeError stripeError) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        MutableLiveData<Result<PaymentMethod>> mutableLiveData = this.$resultData;
        Result.Companion companion = Result.Companion;
        mutableLiveData.setValue(Result.m4708boximpl(Result.m4709constructorimpl(ResultKt.createFailure(new RuntimeException(this.this$0.errorMessageTranslator.translate(i, str, stripeError))))));
    }
}

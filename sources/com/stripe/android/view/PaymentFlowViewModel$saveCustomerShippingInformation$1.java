package com.stripe.android.view;

import androidx.lifecycle.MutableLiveData;
import com.stripe.android.CustomerSession;
import com.stripe.android.core.StripeError;
import com.stripe.android.model.Customer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/stripe/android/view/PaymentFlowViewModel$saveCustomerShippingInformation$1", "Lcom/stripe/android/CustomerSession$CustomerRetrievalListener;", "onCustomerRetrieved", "", "customer", "Lcom/stripe/android/model/Customer;", "onError", "errorCode", "", "errorMessage", "", "stripeError", "Lcom/stripe/android/core/StripeError;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowViewModel.kt */
public final class PaymentFlowViewModel$saveCustomerShippingInformation$1 implements CustomerSession.CustomerRetrievalListener {
    final /* synthetic */ MutableLiveData<Result<Customer>> $resultData;
    final /* synthetic */ PaymentFlowViewModel this$0;

    PaymentFlowViewModel$saveCustomerShippingInformation$1(PaymentFlowViewModel paymentFlowViewModel, MutableLiveData<Result<Customer>> mutableLiveData) {
        this.this$0 = paymentFlowViewModel;
        this.$resultData = mutableLiveData;
    }

    public void onCustomerRetrieved(Customer customer) {
        Intrinsics.checkNotNullParameter(customer, "customer");
        this.this$0.setShippingInfoSubmitted$payments_core_release(true);
        MutableLiveData<Result<Customer>> mutableLiveData = this.$resultData;
        Result.Companion companion = Result.Companion;
        mutableLiveData.setValue(Result.m4708boximpl(Result.m4709constructorimpl(customer)));
    }

    public void onError(int i, String str, StripeError stripeError) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        this.this$0.setShippingInfoSubmitted$payments_core_release(false);
        MutableLiveData<Result<Customer>> mutableLiveData = this.$resultData;
        Result.Companion companion = Result.Companion;
        mutableLiveData.setValue(Result.m4708boximpl(Result.m4709constructorimpl(ResultKt.createFailure(new RuntimeException(str)))));
    }
}

package com.stripe.android.view;

import androidx.lifecycle.MutableLiveData;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.stripe.android.ApiResultCallback;
import com.stripe.android.model.PaymentMethod;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/stripe/android/view/AddPaymentMethodViewModel$createPaymentMethod$1", "Lcom/stripe/android/ApiResultCallback;", "Lcom/stripe/android/model/PaymentMethod;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodViewModel.kt */
public final class AddPaymentMethodViewModel$createPaymentMethod$1 implements ApiResultCallback<PaymentMethod> {
    final /* synthetic */ MutableLiveData<Result<PaymentMethod>> $resultData;

    AddPaymentMethodViewModel$createPaymentMethod$1(MutableLiveData<Result<PaymentMethod>> mutableLiveData) {
        this.$resultData = mutableLiveData;
    }

    public void onSuccess(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "result");
        MutableLiveData<Result<PaymentMethod>> mutableLiveData = this.$resultData;
        Result.Companion companion = Result.Companion;
        mutableLiveData.setValue(Result.m4708boximpl(Result.m4709constructorimpl(paymentMethod)));
    }

    public void onError(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, JWKParameterNames.RSA_EXPONENT);
        MutableLiveData<Result<PaymentMethod>> mutableLiveData = this.$resultData;
        Result.Companion companion = Result.Companion;
        mutableLiveData.setValue(Result.m4708boximpl(Result.m4709constructorimpl(ResultKt.createFailure(exc))));
    }
}

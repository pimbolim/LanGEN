package com.reactnativestripesdk;

import com.facebook.react.bridge.Promise;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.stripe.android.ApiResultCallback;
import com.stripe.android.model.PaymentIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/reactnativestripesdk/StripeSdkModule$verifyMicrodeposits$paymentCallback$1", "Lcom/stripe/android/ApiResultCallback;", "Lcom/stripe/android/model/PaymentIntent;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StripeSdkModule.kt */
public final class StripeSdkModule$verifyMicrodeposits$paymentCallback$1 implements ApiResultCallback<PaymentIntent> {
    final /* synthetic */ Promise $promise;

    StripeSdkModule$verifyMicrodeposits$paymentCallback$1(Promise promise) {
        this.$promise = promise;
    }

    public void onError(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, JWKParameterNames.RSA_EXPONENT);
        this.$promise.resolve(ErrorsKt.createError(ErrorType.Failed.toString(), exc));
    }

    public void onSuccess(PaymentIntent paymentIntent) {
        Intrinsics.checkNotNullParameter(paymentIntent, "result");
        this.$promise.resolve(MappersKt.createResult("paymentIntent", MappersKt.mapFromPaymentIntentResult(paymentIntent)));
    }
}

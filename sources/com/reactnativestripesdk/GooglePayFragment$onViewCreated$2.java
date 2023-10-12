package com.reactnativestripesdk;

import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: GooglePayFragment.kt */
/* synthetic */ class GooglePayFragment$onViewCreated$2 implements GooglePayPaymentMethodLauncher.ResultCallback, FunctionAdapter {
    final /* synthetic */ GooglePayFragment $tmp0;

    GooglePayFragment$onViewCreated$2(GooglePayFragment googlePayFragment) {
        this.$tmp0 = googlePayFragment;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GooglePayPaymentMethodLauncher.ResultCallback) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.$tmp0, GooglePayFragment.class, "onGooglePayResult", "onGooglePayResult(Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final void onResult(GooglePayPaymentMethodLauncher.Result result) {
        Intrinsics.checkNotNullParameter(result, "p0");
        this.$tmp0.onGooglePayResult(result);
    }
}

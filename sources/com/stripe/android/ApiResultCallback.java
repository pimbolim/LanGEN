package com.stripe.android;

import com.stripe.android.core.model.StripeModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&J\u0015\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stripe/android/ApiResultCallback;", "ResultType", "Lcom/stripe/android/core/model/StripeModel;", "", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "(Lcom/stripe/android/core/model/StripeModel;)V", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ApiResultCallback.kt */
public interface ApiResultCallback<ResultType extends StripeModel> {
    void onError(Exception exc);

    void onSuccess(ResultType resulttype);
}

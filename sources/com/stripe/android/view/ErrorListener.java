package com.stripe.android.view;

import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.view.StripeEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/ErrorListener;", "Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", "textInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "(Lcom/google/android/material/textfield/TextInputLayout;)V", "displayErrorMessage", "", "message", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ErrorListener.kt */
public final class ErrorListener implements StripeEditText.ErrorMessageListener {
    private final TextInputLayout textInputLayout;

    public ErrorListener(TextInputLayout textInputLayout2) {
        Intrinsics.checkNotNullParameter(textInputLayout2, "textInputLayout");
        this.textInputLayout = textInputLayout2;
    }

    public void displayErrorMessage(String str) {
        if (str == null) {
            this.textInputLayout.setError((CharSequence) null);
            this.textInputLayout.setErrorEnabled(false);
            return;
        }
        this.textInputLayout.setError(str);
    }
}

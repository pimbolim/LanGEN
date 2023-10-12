package com.stripe.android.view;

import android.text.Editable;
import com.stripe.android.view.StripeEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/BackUpFieldDeleteListener;", "Lcom/stripe/android/view/StripeEditText$DeleteEmptyListener;", "backUpTarget", "Lcom/stripe/android/view/StripeEditText;", "(Lcom/stripe/android/view/StripeEditText;)V", "onDeleteEmpty", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackUpFieldDeleteListener.kt */
public final class BackUpFieldDeleteListener implements StripeEditText.DeleteEmptyListener {
    private final StripeEditText backUpTarget;

    public BackUpFieldDeleteListener(StripeEditText stripeEditText) {
        Intrinsics.checkNotNullParameter(stripeEditText, "backUpTarget");
        this.backUpTarget = stripeEditText;
    }

    public void onDeleteEmpty() {
        String obj;
        Editable text = this.backUpTarget.getText();
        String str = "";
        if (!(text == null || (obj = text.toString()) == null)) {
            str = obj;
        }
        if (str.length() > 1) {
            StripeEditText stripeEditText = this.backUpTarget;
            String substring = str.substring(0, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            stripeEditText.setText(substring);
        }
        this.backUpTarget.requestFocus();
        StripeEditText stripeEditText2 = this.backUpTarget;
        stripeEditText2.setSelection(stripeEditText2.length());
    }
}

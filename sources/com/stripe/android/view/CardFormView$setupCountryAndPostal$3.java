package com.stripe.android.view;

import com.stripe.android.view.CardValidCallback;
import com.stripe.android.view.StripeEditText;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "errorMessage", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardFormView.kt */
final class CardFormView$setupCountryAndPostal$3 implements StripeEditText.ErrorMessageListener {
    final /* synthetic */ CardFormView this$0;

    CardFormView$setupCountryAndPostal$3(CardFormView cardFormView) {
        this.this$0 = cardFormView;
    }

    public final void displayErrorMessage(String str) {
        this.this$0.onFieldError(CardValidCallback.Fields.Postal, str);
    }
}

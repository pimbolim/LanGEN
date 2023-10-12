package com.stripe.android.view;

import android.text.Editable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/stripe/android/view/CardMultilineWidget$cardValidTextWatcher$1", "Lcom/stripe/android/view/StripeTextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardMultilineWidget.kt */
public final class CardMultilineWidget$cardValidTextWatcher$1 extends StripeTextWatcher {
    final /* synthetic */ CardMultilineWidget this$0;

    CardMultilineWidget$cardValidTextWatcher$1(CardMultilineWidget cardMultilineWidget) {
        this.this$0 = cardMultilineWidget;
    }

    public void afterTextChanged(Editable editable) {
        super.afterTextChanged(editable);
        CardValidCallback access$getCardValidCallback$p = this.this$0.cardValidCallback;
        if (access$getCardValidCallback$p != null) {
            access$getCardValidCallback$p.onInputChanged(this.this$0.getInvalidFields$payments_core_release().isEmpty(), this.this$0.getInvalidFields$payments_core_release());
        }
    }
}

package com.stripe.android.ui.core.elements;

import com.stripe.android.cards.CardAccountRangeService;
import com.stripe.android.model.AccountRange;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/stripe/android/ui/core/elements/CardNumberController$accountRangeService$1", "Lcom/stripe/android/cards/CardAccountRangeService$AccountRangeResultListener;", "onAccountRangeResult", "", "newAccountRange", "Lcom/stripe/android/model/AccountRange;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardNumberController.kt */
public final class CardNumberController$accountRangeService$1 implements CardAccountRangeService.AccountRangeResultListener {
    final /* synthetic */ CardNumberController this$0;

    CardNumberController$accountRangeService$1(CardNumberController cardNumberController) {
        this.this$0 = cardNumberController;
    }

    public void onAccountRangeResult(AccountRange accountRange) {
        if (accountRange != null) {
            ((CardNumberVisualTransformation) this.this$0.getVisualTransformation()).setBinBasedMaxPan$payments_ui_core_release(Integer.valueOf(accountRange.getPanLength()));
        }
    }
}

package com.stripe.android.view;

import com.stripe.android.cards.CardAccountRangeService;
import com.stripe.android.model.AccountRange;
import com.stripe.android.model.CardBrand;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/stripe/android/view/CardNumberEditText$accountRangeService$1", "Lcom/stripe/android/cards/CardAccountRangeService$AccountRangeResultListener;", "onAccountRangeResult", "", "newAccountRange", "Lcom/stripe/android/model/AccountRange;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardNumberEditText.kt */
public final class CardNumberEditText$accountRangeService$1 implements CardAccountRangeService.AccountRangeResultListener {
    final /* synthetic */ CardNumberEditText this$0;

    CardNumberEditText$accountRangeService$1(CardNumberEditText cardNumberEditText) {
        this.this$0 = cardNumberEditText;
    }

    public void onAccountRangeResult(AccountRange accountRange) {
        CardBrand cardBrand = null;
        CardNumberEditText.updateLengthFilter$payments_core_release$default(this.this$0, 0, 1, (Object) null);
        CardNumberEditText cardNumberEditText = this.this$0;
        if (accountRange != null) {
            cardBrand = accountRange.getBrand();
        }
        if (cardBrand == null) {
            cardBrand = CardBrand.Unknown;
        }
        cardNumberEditText.setCardBrand$payments_core_release(cardBrand);
    }
}

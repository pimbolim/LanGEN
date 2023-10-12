package com.stripe.android.view;

import com.stripe.android.view.StripeEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "text", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardInputWidget.kt */
final class CardInputWidget$initView$9 implements StripeEditText.AfterTextChangedListener {
    final /* synthetic */ CardInputWidget this$0;

    CardInputWidget$initView$9(CardInputWidget cardInputWidget) {
        this.this$0 = cardInputWidget;
    }

    public final void onTextChanged(String str) {
        CardInputListener access$getCardInputListener$p;
        Intrinsics.checkNotNullParameter(str, "text");
        if (this.this$0.getBrand().isMaxCvc(str) && (access$getCardInputListener$p = this.this$0.cardInputListener) != null) {
            access$getCardInputListener$p.onCvcComplete();
        }
    }
}

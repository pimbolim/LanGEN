package com.stripe.android.view;

import com.stripe.android.model.CardBrand;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "brand", "Lcom/stripe/android/model/CardBrand;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardInputWidget.kt */
final class CardInputWidget$initView$12 extends Lambda implements Function1<CardBrand, Unit> {
    final /* synthetic */ CardInputWidget this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardInputWidget$initView$12(CardInputWidget cardInputWidget) {
        super(1);
        this.this$0 = cardInputWidget;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CardBrand) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CardBrand cardBrand) {
        Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
        this.this$0.getCardBrandView$payments_core_release().setBrand(cardBrand);
        CardInputWidget cardInputWidget = this.this$0;
        cardInputWidget.hiddenCardText = cardInputWidget.createHiddenCardText$payments_core_release(cardInputWidget.getCardNumberEditText$payments_core_release().getPanLength$payments_core_release());
        this.this$0.updateCvc();
    }
}

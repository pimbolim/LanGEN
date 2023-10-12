package com.stripe.android.view;

import com.stripe.android.model.CardBrand;
import com.stripe.android.view.CardMultilineWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/stripe/android/view/CardMultilineWidget$CardBrandIcon;", "cardBrand", "Lcom/stripe/android/model/CardBrand;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardMultilineWidget.kt */
final class CardMultilineWidget$Companion$DEFAULT_CARD_BRAND_ICON_SUPPLIER$1 implements CardMultilineWidget.CardBrandIconSupplier {
    public static final CardMultilineWidget$Companion$DEFAULT_CARD_BRAND_ICON_SUPPLIER$1 INSTANCE = new CardMultilineWidget$Companion$DEFAULT_CARD_BRAND_ICON_SUPPLIER$1();

    CardMultilineWidget$Companion$DEFAULT_CARD_BRAND_ICON_SUPPLIER$1() {
    }

    public final CardMultilineWidget.CardBrandIcon get(CardBrand cardBrand) {
        Intrinsics.checkNotNullParameter(cardBrand, "cardBrand");
        return new CardMultilineWidget.CardBrandIcon(cardBrand.getIcon());
    }
}

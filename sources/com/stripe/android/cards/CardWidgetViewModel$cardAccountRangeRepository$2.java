package com.stripe.android.cards;

import com.stripe.android.cards.CardAccountRangeRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/cards/CardAccountRangeRepository;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardWidgetViewModel.kt */
final class CardWidgetViewModel$cardAccountRangeRepository$2 extends Lambda implements Function0<CardAccountRangeRepository> {
    final /* synthetic */ CardAccountRangeRepository.Factory $cardAccountRangeRepositoryFactory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardWidgetViewModel$cardAccountRangeRepository$2(CardAccountRangeRepository.Factory factory) {
        super(0);
        this.$cardAccountRangeRepositoryFactory = factory;
    }

    public final CardAccountRangeRepository invoke() {
        return this.$cardAccountRangeRepositoryFactory.create();
    }
}

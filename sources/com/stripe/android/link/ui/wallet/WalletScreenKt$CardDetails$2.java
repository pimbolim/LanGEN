package com.stripe.android.link.ui.wallet;

import androidx.compose.runtime.Composer;
import com.stripe.android.model.ConsumerPaymentDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$CardDetails$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ ConsumerPaymentDetails.Card $card;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$CardDetails$2(ConsumerPaymentDetails.Card card, int i) {
        super(2);
        this.$card = card;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        WalletScreenKt.CardDetails(this.$card, composer, this.$$changed | 1);
    }
}

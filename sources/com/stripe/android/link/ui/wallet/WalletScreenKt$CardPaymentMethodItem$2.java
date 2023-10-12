package com.stripe.android.link.ui.wallet;

import androidx.compose.runtime.Composer;
import com.stripe.android.model.ConsumerPaymentDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$CardPaymentMethodItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ ConsumerPaymentDetails.Card $cardDetails;
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$CardPaymentMethodItem$2(ConsumerPaymentDetails.Card card, boolean z, Function0<Unit> function0, int i) {
        super(2);
        this.$cardDetails = card;
        this.$isSelected = z;
        this.$onClick = function0;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        WalletScreenKt.CardPaymentMethodItem(this.$cardDetails, this.$isSelected, this.$onClick, composer, this.$$changed | 1);
    }
}

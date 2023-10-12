package com.stripe.android.link.ui.wallet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$ExpandedPaymentDetails$1$2$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ Function1<Integer, Unit> $onIndexSelected;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$ExpandedPaymentDetails$1$2$1$1$1(Function1<? super Integer, Unit> function1, int i) {
        super(0);
        this.$onIndexSelected = function1;
        this.$index = i;
    }

    public final void invoke() {
        this.$onIndexSelected.invoke(Integer.valueOf(this.$index));
    }
}

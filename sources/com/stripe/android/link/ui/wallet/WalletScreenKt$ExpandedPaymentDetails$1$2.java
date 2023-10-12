package com.stripe.android.link.ui.wallet;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.stripe.android.model.ConsumerPaymentDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$ExpandedPaymentDetails$1$2 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function1<Integer, Unit> $onIndexSelected;
    final /* synthetic */ List<ConsumerPaymentDetails.PaymentDetails> $paymentDetails;
    final /* synthetic */ int $selectedIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$ExpandedPaymentDetails$1$2(List<? extends ConsumerPaymentDetails.PaymentDetails> list, int i, Function1<? super Integer, Unit> function1, int i2) {
        super(1);
        this.$paymentDetails = list;
        this.$selectedIndex = i;
        this.$onIndexSelected = function1;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        List<ConsumerPaymentDetails.PaymentDetails> list = this.$paymentDetails;
        lazyListScope.items(list.size(), (Function1<? super Integer, ? extends Object>) null, ComposableLambdaKt.composableLambdaInstance(-985537359, true, new WalletScreenKt$ExpandedPaymentDetails$1$2$invoke$$inlined$itemsIndexed$default$2(list, this.$selectedIndex, this.$onIndexSelected, this.$$dirty)));
    }
}

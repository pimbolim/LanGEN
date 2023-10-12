package com.stripe.android.link.ui.wallet;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import com.stripe.android.model.ConsumerPaymentDetails;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$WalletBody$5$selectedIndex$2 extends Lambda implements Function0<MutableState<Integer>> {
    final /* synthetic */ List<ConsumerPaymentDetails.PaymentDetails> $paymentDetails;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$WalletBody$5$selectedIndex$2(List<? extends ConsumerPaymentDetails.PaymentDetails> list) {
        super(0);
        this.$paymentDetails = list;
    }

    public final MutableState<Integer> invoke() {
        Iterator<ConsumerPaymentDetails.PaymentDetails> it = this.$paymentDetails.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next().isDefault()) {
                break;
            } else {
                i2++;
            }
        }
        Integer valueOf = Integer.valueOf(i2);
        if (valueOf.intValue() == -1) {
            valueOf = null;
        }
        if (valueOf != null) {
            i = valueOf.intValue();
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i), (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}

package com.stripe.android.link.ui.wallet;

import androidx.compose.runtime.Composer;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.ConsumerPaymentDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.stripe.android.link.ui.wallet.ComposableSingletons$WalletScreenKt$lambda-1$1  reason: invalid class name */
/* compiled from: WalletScreen.kt */
final class ComposableSingletons$WalletScreenKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$WalletScreenKt$lambda1$1 INSTANCE = new ComposableSingletons$WalletScreenKt$lambda1$1();

    ComposableSingletons$WalletScreenKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Composer composer2 = composer;
            WalletScreenKt.WalletBody(false, CollectionsKt.listOf(new ConsumerPaymentDetails.Card("id1", true, 2022, 12, CardBrand.Visa, "4242"), new ConsumerPaymentDetails.Card("id2", false, 2023, 11, CardBrand.MasterCard, "4444")), "Pay $10.99", AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE, composer2, (ConsumerPaymentDetails.Card.$stable << 3) | 224646);
            return;
        }
        composer.skipToGroupEnd();
    }
}

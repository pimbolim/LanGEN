package com.stripe.android.link.ui.wallet;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import com.stripe.android.model.ConsumerPaymentDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$2"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyDsl.kt */
public final class WalletScreenKt$ExpandedPaymentDetails$1$2$invoke$$inlined$itemsIndexed$default$2 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty$inlined;
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $onIndexSelected$inlined;
    final /* synthetic */ int $selectedIndex$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletScreenKt$ExpandedPaymentDetails$1$2$invoke$$inlined$itemsIndexed$default$2(List list, int i, Function1 function1, int i2) {
        super(4);
        this.$items = list;
        this.$selectedIndex$inlined = i;
        this.$onIndexSelected$inlined = function1;
        this.$$dirty$inlined = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
        ComposerKt.sourceInformation(composer, "C120@5624L26:LazyDsl.kt#428nma");
        if ((i2 & 14) == 0) {
            i3 = (composer.changed((Object) lazyItemScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        int i5 = 32;
        if ((i2 & 112) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if (((i3 & 731) ^ 146) != 0 || !composer.getSkipping()) {
            int i6 = (i3 & 112) | (i3 & 14);
            ConsumerPaymentDetails.PaymentDetails paymentDetails = (ConsumerPaymentDetails.PaymentDetails) this.$items.get(i);
            if ((i6 & 112) == 0) {
                if (!composer.changed(i)) {
                    i5 = 16;
                }
                i4 = i5 | i6;
            } else {
                i4 = i6;
            }
            if ((i6 & 896) == 0) {
                i4 |= composer.changed((Object) paymentDetails) ? 256 : 128;
            }
            if (((i4 & 5841) ^ JSONParser.MODE_STRICTEST) == 0 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else if (paymentDetails instanceof ConsumerPaymentDetails.Card) {
                ConsumerPaymentDetails.Card card = (ConsumerPaymentDetails.Card) paymentDetails;
                boolean z = this.$selectedIndex$inlined == i;
                Integer valueOf = Integer.valueOf(i);
                composer.startReplaceableGroup(-3686552);
                ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean changed = composer.changed((Object) valueOf) | composer.changed((Object) this.$onIndexSelected$inlined);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new WalletScreenKt$ExpandedPaymentDetails$1$2$1$1$1(this.$onIndexSelected$inlined, i);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                WalletScreenKt.CardPaymentMethodItem(card, z, (Function0) rememberedValue, composer, ConsumerPaymentDetails.Card.$stable);
            }
        } else {
            composer.skipToGroupEnd();
        }
    }
}

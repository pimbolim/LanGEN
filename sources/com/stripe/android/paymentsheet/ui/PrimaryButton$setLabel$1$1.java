package com.stripe.android.paymentsheet.ui;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimaryButton.kt */
final class PrimaryButton$setLabel$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrimaryButton$setLabel$1$1(String str) {
        super(2);
        this.$text = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            PrimaryButtonKt.LabelUI(this.$text, composer, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}

package com.stripe.android.paymentsheet.ui;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimaryButton.kt */
final class PrimaryButtonKt$LabelUI$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ String $label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrimaryButtonKt$LabelUI$2(String str, int i) {
        super(2);
        this.$label = str;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        PrimaryButtonKt.LabelUI(this.$label, composer, this.$$changed | 1);
    }
}

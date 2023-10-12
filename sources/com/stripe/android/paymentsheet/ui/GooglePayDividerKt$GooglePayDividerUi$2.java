package com.stripe.android.paymentsheet.ui;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayDivider.kt */
final class GooglePayDividerKt$GooglePayDividerUi$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ String $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayDividerKt$GooglePayDividerUi$2(String str, int i, int i2) {
        super(2);
        this.$text = str;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        GooglePayDividerKt.GooglePayDividerUi(this.$text, composer, this.$$changed | 1, this.$$default);
    }
}

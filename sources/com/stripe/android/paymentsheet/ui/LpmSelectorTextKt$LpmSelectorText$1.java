package com.stripe.android.paymentsheet.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LpmSelectorText.kt */
final class LpmSelectorTextKt$LpmSelectorText$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ String $text;
    final /* synthetic */ long $textColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LpmSelectorTextKt$LpmSelectorText$1(String str, long j, Modifier modifier, boolean z, int i) {
        super(2);
        this.$text = str;
        this.$textColor = j;
        this.$modifier = modifier;
        this.$isEnabled = z;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LpmSelectorTextKt.m4444LpmSelectorText3IgeMak(this.$text, this.$textColor, this.$modifier, this.$isEnabled, composer, this.$$changed | 1);
    }
}

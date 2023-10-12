package com.stripe.android.link.ui;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimaryButton.kt */
final class PrimaryButtonKt$PrimaryButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Integer $icon;
    final /* synthetic */ String $label;
    final /* synthetic */ Function0<Unit> $onButtonClick;
    final /* synthetic */ PrimaryButtonState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrimaryButtonKt$PrimaryButton$2(String str, PrimaryButtonState primaryButtonState, Integer num, Function0<Unit> function0, int i, int i2) {
        super(2);
        this.$label = str;
        this.$state = primaryButtonState;
        this.$icon = num;
        this.$onButtonClick = function0;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        PrimaryButtonKt.PrimaryButton(this.$label, this.$state, this.$icon, this.$onButtonClick, composer, this.$$changed | 1, this.$$default);
    }
}

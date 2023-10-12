package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DropdownFieldUI.kt */
final class DropdownFieldUIKt$DropdownMenuItem$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $currentTextColor;
    final /* synthetic */ String $displayValue;
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DropdownFieldUIKt$DropdownMenuItem$4(String str, boolean z, long j, Function0<Unit> function0, int i, int i2) {
        super(2);
        this.$displayValue = str;
        this.$isSelected = z;
        this.$currentTextColor = j;
        this.$onClick = function0;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DropdownFieldUIKt.m4576DropdownMenuItemcf5BqRc(this.$displayValue, this.$isSelected, this.$currentTextColor, this.$onClick, composer, this.$$changed | 1, this.$$default);
    }
}
